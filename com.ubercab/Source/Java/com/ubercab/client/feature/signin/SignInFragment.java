package com.ubercab.client.feature.signin;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListAdapter;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.AccountPicker;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.analytics.event.SignInEvent;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.content.CachePreferences;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Impression;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.client.core.network.events.LoginGoogleResponseEvent;
import com.ubercab.client.core.network.events.LoginResponseEvent;
import com.ubercab.client.core.network.events.ThirdPartyAuthResponseEvent;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.core.vendor.facebook.FacebookAuthorizationActivity;
import com.ubercab.client.core.vendor.google.GooglePlusUtils;
import com.ubercab.client.feature.signin.event.SignInSuccessfulEvent;
import com.ubercab.client.feature.signup.SignupActivity;
import com.ubercab.client.feature.signup.SignupData;
import com.ubercab.client.feature.signup.ThirdPartyToken;
import com.ubercab.geo.GeoManager;
import com.ubercab.library.metrics.analytics.event.ImpressionEventName;
import com.ubercab.library.ui.MessageDialogFragment;
import com.ubercab.library.util.KeyboardUtils;
import com.ubercab.library.util.PhoneNumberUtils;
import com.ubercab.library.util.StringUtils;
import com.ubercab.ui.TextWatcherAdapter;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberEditText;
import com.ubercab.ui.UberTextView;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import timber.log.Timber;

public class SignInFragment extends RiderFragment
{
  private static final String FORGOT_PASSWORD_URL = "https://www.uber.com/forgot-password";
  private static final int REQUEST_CODE_FACEBOOK_SIGN_IN = 1;
  private static final int REQUEST_CODE_FACEBOOK_SIGN_UP = 10;
  private static final int REQUEST_CODE_GOOGLE_ACCOUNT_PICKER = 5020;

  @Inject
  AnalyticsManager mAnalyticsManager;

  @Inject
  Bus mBus;

  @InjectView(2131427716)
  UberButton mButtonFacebook;

  @InjectView(2131427720)
  UberButton mButtonForgotPass;

  @InjectView(2131427715)
  UberButton mButtonGoogle;

  @InjectView(2131427719)
  UberButton mButtonSignIn;

  @Inject
  CachePreferences mCachePreferences;

  @InjectView(2131427718)
  UberEditText mEditTextPassword;
  private Executor mExecutor;

  @Inject
  GeoManager mGeoManager;
  private String mPendingGoogleToken;
  private ThirdPartyToken mPendingThirdPartyToken;

  @Inject
  RiderClient mRiderClient;

  @InjectView(2131427717)
  AutoCompleteTextView mTextViewEmail;

  @InjectView(2131427928)
  UberTextView mTextViewOr;

  @InjectView(2131427714)
  ViewGroup mViewGroupThirdPartySignIn;

  private void sendFacebookSignInRequest()
  {
    showLoadingDialogSticky(getString(2131559071), null);
    this.mRiderClient.authenticateWithThirdParty(this.mPendingThirdPartyToken.getType(), this.mPendingThirdPartyToken.getToken());
    this.mAnalyticsManager.signInEvent().signInRequest();
  }

  private void sendGoogleSignInRequest(String paramString1, String paramString2)
  {
    showLoadingDialogSticky(getString(2131559071), null);
    this.mPendingGoogleToken = paramString2;
    this.mRiderClient.loginGoogle(paramString1, paramString2);
    this.mAnalyticsManager.signInEvent().signInRequest();
  }

  private void sendUberSignInRequest()
  {
    showLoadingDialogSticky(getString(2131559071), null);
    String str1 = this.mTextViewEmail.getText().toString();
    String str2 = this.mEditTextPassword.getText().toString();
    this.mRiderClient.login(str1, str2);
    this.mAnalyticsManager.signInEvent().signInRequest();
  }

  private void startFacebookAuthorization()
  {
    startActivityForResult(new Intent(getActivity(), FacebookAuthorizationActivity.class), 1);
  }

  private void startGoogleSignIn()
  {
    Account[] arrayOfAccount = AccountManager.get(getActivity()).getAccountsByType("com.google");
    if (arrayOfAccount.length == 1)
    {
      startGoogleSignIn(arrayOfAccount[0].name);
      return;
    }
    startActivityForResult(AccountPicker.newChooseAccountIntent(null, null, new String[] { "com.google" }, false, null, null, null, null), 5020);
  }

  private void startGoogleSignIn(final String paramString)
  {
    AsyncTask local2 = new AsyncTask()
    {
      public Exception mException;

      protected String doInBackground(Void[] paramAnonymousArrayOfVoid)
      {
        try
        {
          String str = SignInFragment.this.getGoogleToken(paramString, this.val$scope);
          return str;
        }
        catch (Exception localException)
        {
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = paramString;
          Timber.e(localException, "Could not create Google Auth token for %s", arrayOfObject);
          this.mException = localException;
        }
        return null;
      }

      protected void onPostExecute(String paramAnonymousString)
      {
        if (!SignInFragment.this.isAdded())
          return;
        if (this.mException != null)
        {
          SignInFragment.this.hideLoadingDialog();
          SignInFragment.this.showToast(this.mException.getMessage());
          return;
        }
        SignInFragment.this.sendGoogleSignInRequest(paramString, paramAnonymousString);
      }
    };
    if (this.mExecutor != null);
    for (Executor localExecutor = this.mExecutor; ; localExecutor = AsyncTask.THREAD_POOL_EXECUTOR)
    {
      local2.executeOnExecutor(localExecutor, new Void[0]);
      return;
    }
  }

  private void startUberSignIn()
  {
    String str1 = this.mTextViewEmail.getText().toString();
    String str2 = this.mEditTextPassword.getText().toString();
    if (!StringUtils.isEmailAddress(str1))
    {
      this.mTextViewEmail.setError(getString(2131558918));
      this.mTextViewEmail.requestFocus();
      return;
    }
    if (str2.length() < 5)
    {
      this.mEditTextPassword.setError(getString(2131558984));
      this.mEditTextPassword.requestFocus();
      return;
    }
    KeyboardUtils.hideKeyboard(getActivity(), this.mEditTextPassword);
    sendUberSignInRequest();
  }

  String getGoogleToken(String paramString1, String paramString2)
    throws Exception
  {
    return GoogleAuthUtil.getToken(getActivity(), paramString1, paramString2);
  }

  protected ImpressionEventName getImpressionAnalyticsName()
  {
    return RiderEvents.Impression.SIGN_IN;
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 5020) && (paramInt2 == -1))
      startGoogleSignIn(paramIntent.getStringExtra("authAccount"));
    do
    {
      return;
      if ((paramInt1 == 1) && (paramInt2 == -1))
      {
        String str1 = paramIntent.getStringExtra("token");
        if (TextUtils.isEmpty(str1))
        {
          hideLoadingDialog();
          String str2 = getString(2131558973);
          String str3 = getString(2131558920);
          MessageDialogFragment.show(getLibraryActivity(), 0, null, str3, str2);
          return;
        }
        this.mPendingThirdPartyToken = new ThirdPartyToken("facebook", str1, paramIntent.getLongExtra("tokenExpiry", 0L));
        sendFacebookSignInRequest();
        return;
      }
      if ((paramInt1 == 10) && (paramInt2 == -1))
      {
        startFacebookAuthorization();
        return;
      }
    }
    while (paramInt2 != 0);
    hideLoadingDialog();
  }

  @OnClick({2131427716})
  public void onClickButtonFacebook()
  {
    startFacebookAuthorization();
  }

  @OnClick({2131427715})
  public void onClickButtonGoogle()
  {
    startGoogleSignIn();
  }

  @OnClick({2131427719})
  public void onClickButtonNext()
  {
    startUberSignIn();
  }

  @OnClick({2131427720})
  public void onClickForgotPass()
  {
    startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.uber.com/forgot-password")));
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setHasOptionsMenu(true);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903176, paramViewGroup, false);
    ButterKnife.inject(this, localView);
    return localView;
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    ButterKnife.reset(this);
  }

  @OnEditorAction({2131427718})
  public boolean onEditorActionPassword(int paramInt)
  {
    if (paramInt == 6)
    {
      startUberSignIn();
      return true;
    }
    return false;
  }

  @Subscribe
  public void onLoginFacebookResponseEvent(ThirdPartyAuthResponseEvent paramThirdPartyAuthResponseEvent)
  {
    if (paramThirdPartyAuthResponseEvent.isSuccess())
    {
      Ping localPing = (Ping)paramThirdPartyAuthResponseEvent.getModel();
      if ((!PingUtils.hasClient(localPing)) && (!localPing.getThirdPartyConnected()))
      {
        Map localMap = localPing.getSignupFieldsRequired();
        SignupData localSignupData = new SignupData().setFirstName((String)localMap.get("firstName")).setLastName((String)localMap.get("lastName")).setEmail((String)localMap.get("email")).setThirdPartyToken(this.mPendingThirdPartyToken);
        TelephonyManager localTelephonyManager = (TelephonyManager)getActivity().getSystemService("phone");
        if ((!TextUtils.isEmpty(localTelephonyManager.getLine1Number())) && (!TextUtils.isEmpty(localTelephonyManager.getSimCountryIso())))
          localSignupData.setMobile(PhoneNumberUtils.getDisplayPhoneNumber(localTelephonyManager.getLine1Number(), localTelephonyManager.getSimCountryIso()), localTelephonyManager.getSimCountryIso().toUpperCase(Locale.US));
        Intent localIntent = new Intent(getActivity(), SignupActivity.class);
        localIntent.putExtra("com.ubercab.THIRD_PARTY_PROFILE", localSignupData);
        startActivityForResult(localIntent, 10);
      }
    }
    while (true)
    {
      this.mAnalyticsManager.signInEvent().signInResponse(paramThirdPartyAuthResponseEvent.getStatusCode());
      hideLoadingDialog();
      return;
      this.mBus.post(new SignInSuccessfulEvent((Ping)paramThirdPartyAuthResponseEvent.getModel()));
      continue;
      String str1 = getString(2131558973);
      String str2 = getString(2131558920);
      MessageDialogFragment.show(getLibraryActivity(), 0, null, str2, str1);
    }
  }

  @Subscribe
  public void onLoginGoogleResponseEvent(LoginGoogleResponseEvent paramLoginGoogleResponseEvent)
  {
    hideLoadingDialog();
    if (paramLoginGoogleResponseEvent.isSuccess())
      this.mBus.post(new SignInSuccessfulEvent((Ping)paramLoginGoogleResponseEvent.getModel()));
    while (true)
    {
      this.mAnalyticsManager.signInEvent().signInResponse(paramLoginGoogleResponseEvent.getStatusCode());
      return;
      GooglePlusUtils.clearTokenInBackground(getActivity(), this.mPendingGoogleToken);
      String str1 = getString(2131558973);
      String str2 = getString(2131558921);
      MessageDialogFragment.show(getLibraryActivity(), 0, null, str2, str1);
    }
  }

  @Subscribe
  public void onLoginResponseEvent(LoginResponseEvent paramLoginResponseEvent)
  {
    hideLoadingDialog();
    if (paramLoginResponseEvent.isSuccess())
      this.mBus.post(new SignInSuccessfulEvent((Ping)paramLoginResponseEvent.getModel()));
    while (true)
    {
      this.mAnalyticsManager.signInEvent().signInResponse(paramLoginResponseEvent.getStatusCode());
      return;
      String str1 = paramLoginResponseEvent.getErrorMessage(getActivity());
      String str2 = getString(2131558973);
      String str3 = getString(2131558922);
      if (TextUtils.isEmpty(str1))
        str1 = getString(2131558919);
      MessageDialogFragment.show(getLibraryActivity(), 0, str3, str1, str2);
    }
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.mTextViewOr.setText(getString(2131558979));
    this.mButtonForgotPass.setText(getString(2131558879));
    this.mButtonForgotPass.setPaintFlags(0x8 | this.mButtonForgotPass.getPaintFlags());
    String str1 = getString(2131558827);
    List localList = this.mCachePreferences.getUserSignInNames();
    ArrayAdapter localArrayAdapter = new ArrayAdapter(getActivity(), 17367050, localList);
    this.mTextViewEmail.setHint(str1);
    this.mTextViewEmail.setThreshold(0);
    this.mTextViewEmail.setAdapter(localArrayAdapter);
    this.mTextViewEmail.addTextChangedListener(new TextWatcherAdapter()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if (SignInFragment.this.mTextViewEmail.getAdapter().getCount() > 0)
        {
          String str = (String)SignInFragment.this.mTextViewEmail.getAdapter().getItem(0);
          if ((str != null) && (paramAnonymousEditable.length() >= str.length()))
            SignInFragment.this.mTextViewEmail.dismissDropDown();
        }
      }
    });
    String str2 = getString(2131559070);
    String str3 = getString(2131558983);
    String str4 = getString(2131558884);
    this.mEditTextPassword.setHint(str3);
    this.mEditTextPassword.setImeActionLabel(str2, 6);
    this.mButtonSignIn.setText(str2);
    this.mButtonFacebook.setText(getString(2131558851));
    this.mButtonGoogle.setText(str4);
    this.mAnalyticsManager.signInEvent().signInPageView();
    ViewGroup localViewGroup = this.mViewGroupThirdPartySignIn;
    int i = this.mGeoManager.getGeo();
    int j = 0;
    if (i == 3)
      j = 8;
    localViewGroup.setVisibility(j);
  }

  void setExecutor(Executor paramExecutor)
  {
    this.mExecutor = paramExecutor;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.signin.SignInFragment
 * JD-Core Version:    0.6.2
 */