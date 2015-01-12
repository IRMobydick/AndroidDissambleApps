package com.ubercab.client.feature.signup;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.ActionBar;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import com.google.android.gms.common.AccountPicker;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.analytics.event.SignUpEvent;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.locale.ChineseName;
import com.ubercab.client.core.locale.SelectCountryActivity;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Custom;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Impression;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Tap;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.client.core.network.SignupClient;
import com.ubercab.client.core.network.events.ThirdPartyAuthResponseEvent;
import com.ubercab.client.core.network.events.ValidateAccountResponseEvent;
import com.ubercab.client.core.network.events.VerifyProfileEvent;
import com.ubercab.client.core.ui.FlagButton;
import com.ubercab.client.core.ui.PhoneNumberCountryTextWatcher;
import com.ubercab.client.core.ui.PhoneNumberCountryTextWatcher.Listener;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.core.util.ValidationUtils;
import com.ubercab.client.core.vendor.facebook.FacebookAuthorizationActivity;
import com.ubercab.client.feature.signin.event.SignInSuccessfulEvent;
import com.ubercab.client.feature.signup.event.SignupCompletedEvent;
import com.ubercab.client.feature.signup.event.SignupMissingInfoEvent;
import com.ubercab.client.feature.signup.event.SignupValidatedEvent;
import com.ubercab.common.collect.ImmutableList.Builder;
import com.ubercab.common.collect.ImmutableMap;
import com.ubercab.geo.GeoManager;
import com.ubercab.library.app.annotation.ForApp;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import com.ubercab.library.metrics.analytics.event.ImpressionEventName;
import com.ubercab.library.ui.MessageDialogFragment;
import com.ubercab.library.util.KeyboardUtils;
import com.ubercab.ui.TextWatcherAdapter;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberEditText;
import com.ubercab.ui.UberTextView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import javax.inject.Inject;

public class SignupFragment extends RiderFragment
  implements LoaderManager.LoaderCallbacks<Profile>, SignupEvents, PhoneNumberCountryTextWatcher.Listener
{
  private static final List<Character.UnicodeBlock> CJK_UNICODE_BLOCKS = new ImmutableList.Builder().add(Character.UnicodeBlock.CJK_RADICALS_SUPPLEMENT).add(Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION).add(Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A).add(Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS).add(Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS).add(Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B).add(Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT).build();
  private static final int LOADER_PROFILE = 1;
  static final int REQUEST_CODE_FACEBOOK = 500;
  static final int REQUEST_CODE_GOOGLE = 600;
  static final int REQUEST_CODE_PICK_ACCOUNT = 700;
  static final int REQUEST_CODE_SELECT_COUNTRY = 800;

  @Inject
  ActionBar mActionBar;

  @Inject
  AnalyticsClient mAnalyticsClient;

  @Inject
  AnalyticsManager mAnalyticsManager;

  @Inject
  Bus mBus;

  @InjectView(2131427757)
  UberButton mButtonFacebook;

  @InjectView(2131427756)
  UberButton mButtonGoogle;

  @InjectView(2131427727)
  UberButton mButtonNext;

  @ForApp
  @Inject
  Context mContext;

  @InjectView(2131427761)
  AutoCompleteTextView mEditTextEmail;

  @InjectView(2131427722)
  UberEditText mEditTextFirstName;

  @InjectView(2131427760)
  UberEditText mEditTextFullName;

  @InjectView(2131427723)
  UberEditText mEditTextLastName;

  @InjectView(2131427762)
  UberEditText mEditTextPassword;

  @InjectView(2131427726)
  UberEditText mEditTextPhone;
  private UpdateFirstAndLastNameTextWatcher mFirstAndLastNameTextWatcher;

  @InjectView(2131427725)
  FlagButton mFlagButtonCountry;
  private UpdateFullNameTextWatcher mFullNameTextWatcher;

  @Inject
  GeoManager mGeoManager;
  private boolean mIsThirdPartySignup;

  @InjectView(2131427759)
  LinearLayout mNameOneFields;

  @InjectView(2131427758)
  LinearLayout mNameTwoFields;

  @Inject
  PingProvider mPingProvider;

  @InjectView(2131427763)
  ProgressBar mProgressBarLoading;
  private final Queue<Object> mQueuePendingEvents = new LinkedList();

  @Inject
  RiderClient mRiderClient;

  @Inject
  SignupClient mSignupClient;
  private SignupData mSignupData;

  @InjectView(2131427928)
  UberTextView mTextViewOr;
  private PhoneNumberCountryTextWatcher mTextWatcherPhone;
  private UpdateUITextWatcher mTextWatcherUpdateUI;

  @InjectView(2131427721)
  ViewGroup mViewGroupContent;

  @InjectView(2131427755)
  ViewGroup mViewGroupThirdPartySignIn;

  private SignupData getSignupData()
  {
    return getSignupData(null);
  }

  private SignupData getSignupData(ValidateAccountResponseEvent paramValidateAccountResponseEvent)
  {
    String str1 = this.mEditTextFirstName.getText().toString();
    String str2 = this.mEditTextLastName.getText().toString();
    if (!TextUtils.isEmpty(this.mEditTextFullName.getText()))
    {
      ChineseName localChineseName = new ChineseName(this.mEditTextFullName.getText().toString());
      str1 = localChineseName.getFirstName();
      str2 = localChineseName.getLastName();
    }
    SignupData.PromoCode localPromoCode = null;
    if (paramValidateAccountResponseEvent != null)
      localPromoCode = SignupData.PromoCode.createFromData(paramValidateAccountResponseEvent.getData());
    return this.mSignupData.setFirstName(str1).setLastName(str2).setEmail(this.mEditTextEmail.getText().toString()).setMobile(this.mEditTextPhone.getText().toString(), this.mFlagButtonCountry.getCountryIso2()).setPassword(this.mEditTextPassword.getText().toString()).setPromoCode(localPromoCode);
  }

  private boolean has(Object paramObject)
  {
    return (paramObject != null) && (!paramObject.toString().isEmpty());
  }

  private boolean isChineseCharacter(char paramChar)
  {
    return CJK_UNICODE_BLOCKS.contains(Character.UnicodeBlock.of(paramChar));
  }

  private boolean isChinesePhone()
  {
    return (this.mGeoManager.getGeo() == 3) && ((Locale.getDefault() == Locale.CHINA) || (Locale.getDefault() == Locale.CHINESE));
  }

  public static SignupFragment newInstance()
  {
    return new SignupFragment();
  }

  private void sendValidateAccountRequest()
  {
    KeyboardUtils.hideKeyboard(getActivity(), this.mEditTextEmail);
    this.mEditTextEmail.setError(null);
    this.mEditTextPhone.setError(null);
    this.mEditTextPassword.setError(null);
    String str1 = this.mEditTextEmail.getText().toString();
    String str2 = this.mEditTextPhone.getText().toString();
    String str3 = this.mFlagButtonCountry.getCountryIso2();
    String str4 = this.mEditTextPassword.getText().toString();
    showLoadingDialogSticky(getString(2131559341), null);
    this.mSignupClient.validateAccount(str1, str2, str3, str4);
  }

  private void setCountry(String paramString)
  {
    if (paramString != null)
      paramString = paramString.toUpperCase(Locale.US);
    this.mFlagButtonCountry.setCountryIso2(paramString);
    this.mTextWatcherPhone.setCountryCode(paramString);
    PhoneNumberUtil localPhoneNumberUtil = PhoneNumberUtil.getInstance();
    Phonenumber.PhoneNumber localPhoneNumber = localPhoneNumberUtil.getExampleNumberForType(paramString, PhoneNumberUtil.PhoneNumberType.MOBILE);
    if (localPhoneNumber != null)
    {
      this.mEditTextPhone.setHint(localPhoneNumberUtil.format(localPhoneNumber, PhoneNumberUtil.PhoneNumberFormat.NATIONAL));
      return;
    }
    this.mEditTextPhone.setHint(getString(2131558933));
  }

  private void startFacebookSignUp()
  {
    this.mIsThirdPartySignup = true;
    startActivityForResult(new Intent(getActivity(), FacebookAuthorizationActivity.class), 500);
  }

  private void startGoogleSignUp()
  {
    Account[] arrayOfAccount = AccountManager.get(getActivity()).getAccountsByType("com.google");
    if (arrayOfAccount.length == 1)
    {
      startGoogleSignUp(arrayOfAccount[0].name);
      return;
    }
    startActivityForResult(AccountPicker.newChooseAccountIntent(null, null, new String[] { "com.google" }, false, null, null, null, null), 700);
  }

  private void startGoogleSignUp(String paramString)
  {
    Intent localIntent = new Intent(getActivity(), SignupGoogleActivity.class);
    localIntent.putExtra("com.ubercab.ACCOUNT_NAME", paramString);
    startActivityForResult(localIntent, 600);
  }

  private void startSelectCountryActivityForResult()
  {
    startActivityForResult(new Intent(getActivity(), SelectCountryActivity.class), 800);
  }

  private void updateUI()
  {
    if (((!TextUtils.isEmpty(this.mEditTextFirstName.getText())) && (!TextUtils.isEmpty(this.mEditTextLastName.getText()))) || ((!TextUtils.isEmpty(this.mEditTextFullName.getText())) && (!TextUtils.isEmpty(this.mEditTextEmail.getText())) && (!TextUtils.isEmpty(this.mEditTextPhone.getText()))))
    {
      bool = true;
      if (!this.mIsThirdPartySignup)
        if ((!bool) || (TextUtils.isEmpty(this.mEditTextPassword.getText())))
          break label107;
    }
    label107: for (boolean bool = true; ; bool = false)
    {
      this.mButtonNext.setEnabled(bool);
      return;
      bool = false;
      break;
    }
  }

  protected ImpressionEventName getImpressionAnalyticsName()
  {
    return RiderEvents.Impression.SIGN_UP_1;
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    SignupData localSignupData;
    if ((paramInt1 == 700) && (paramInt2 == -1))
    {
      startGoogleSignUp(paramIntent.getStringExtra("authAccount"));
      if (paramInt1 == 600)
      {
        if (paramInt2 != -1)
          break label233;
        localSignupData = (SignupData)paramIntent.getParcelableExtra("com.ubercab.SIGNUP_DATA");
        if (!localSignupData.hasRequiredData())
          break label211;
        this.mQueuePendingEvents.add(new SignupValidatedEvent(localSignupData));
      }
    }
    while (true)
    {
      if ((paramInt1 == 800) && (paramInt2 == -1))
      {
        setCountry(paramIntent.getStringExtra("country_iso2"));
        this.mEditTextPhone.setText("");
      }
      return;
      if ((paramInt1 != 500) || (paramInt2 != -1))
        break;
      String str = paramIntent.getStringExtra("token");
      if (TextUtils.isEmpty(str))
        break;
      showLoadingDialogSticky(getString(2131559071), null);
      ThirdPartyToken localThirdPartyToken = new ThirdPartyToken("facebook", str, paramIntent.getLongExtra("tokenExpiry", 0L));
      this.mSignupData = getSignupData();
      this.mSignupData.setThirdPartyToken(localThirdPartyToken);
      this.mRiderClient.authenticateWithThirdParty(localThirdPartyToken.getType(), localThirdPartyToken.getToken());
      break;
      label211: this.mQueuePendingEvents.add(new SignupMissingInfoEvent(localSignupData));
      continue;
      label233: if (paramInt2 == 1)
        this.mQueuePendingEvents.add(new SignupCompletedEvent());
    }
  }

  public void onCancel()
  {
    this.mAnalyticsManager.signUpEvent().signUpCancel(getSignupData());
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mSignupData = new SignupData();
    this.mTextWatcherUpdateUI = new UpdateUITextWatcher(null);
    this.mFullNameTextWatcher = new UpdateFullNameTextWatcher(null);
    this.mFirstAndLastNameTextWatcher = new UpdateFirstAndLastNameTextWatcher(null);
    this.mTextWatcherPhone = new PhoneNumberCountryTextWatcher();
    this.mTextWatcherPhone.setListener(this);
  }

  public Loader<Profile> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    return new ProfileLoader(getActivity());
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903184, paramViewGroup, false);
    ButterKnife.inject(this, localView);
    return localView;
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    ButterKnife.reset(this);
  }

  @OnClick({2131427757})
  public void onFacebookSignupClicked()
  {
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.SIGN_UP_FACEBOOK);
    startFacebookSignUp();
  }

  @OnClick({2131427725})
  public void onFlagClicked()
  {
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.SIGN_UP_COUNTRY);
    startSelectCountryActivityForResult();
  }

  @OnClick({2131427756})
  public void onGoogleSigninClicked()
  {
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.SIGN_UP_GOOGLE_PLUS);
    startGoogleSignUp();
  }

  public void onLoadFinished(Loader<Profile> paramLoader, Profile paramProfile)
  {
    Profile.Name localName = paramProfile.getTopName();
    if (has(paramProfile.getTopEmail()))
      this.mAnalyticsClient.sendCustomEvent(RiderEvents.Custom.SIGN_UP_LOAD_PROFILE_HAS_EMAIL);
    if (has(paramProfile.getTopPhone()))
      this.mAnalyticsClient.sendCustomEvent(RiderEvents.Custom.SIGN_UP_LOAD_PROFILE_HAS_PHONE);
    if ((localName != null) && (has(localName.getFirstName())))
      this.mAnalyticsClient.sendCustomEvent(RiderEvents.Custom.SIGN_UP_LOAD_PROFILE_HAS_FIRST_NAME);
    if ((localName != null) && (has(localName.getLastName())))
      this.mAnalyticsClient.sendCustomEvent(RiderEvents.Custom.SIGN_UP_LOAD_PROFILE_HAS_LAST_NAME);
    if ((TextUtils.isEmpty(this.mEditTextFirstName.getText())) && (TextUtils.isEmpty(this.mEditTextLastName.getText())) && (localName != null))
    {
      if (isChinesePhone())
      {
        String str = "";
        if ((localName.getLastName() != null) && (localName.getLastName().length() > 0) && (isChineseCharacter(localName.getLastName().charAt(0))))
          str = localName.getLastName();
        if ((localName.getFirstName() != null) && (localName.getFirstName().length() > 0))
          str = str + localName.getFirstName();
        this.mEditTextFullName.setText(str);
      }
    }
    else
    {
      if (TextUtils.isEmpty(this.mEditTextEmail.getText()))
        this.mEditTextEmail.setText(paramProfile.getTopEmail());
      if (TextUtils.isEmpty(this.mEditTextPhone.getText()))
      {
        Profile.Phone localPhone = paramProfile.getTopPhone();
        if (localPhone == null)
          break label375;
        this.mEditTextPhone.setText(localPhone.getNumber());
        setCountry(localPhone.getCountryIso2());
      }
    }
    while (true)
    {
      ArrayAdapter localArrayAdapter = new ArrayAdapter(getActivity(), 17367050, new ArrayList(paramProfile.getEmails()));
      this.mEditTextEmail.setAdapter(localArrayAdapter);
      this.mProgressBarLoading.setVisibility(8);
      this.mViewGroupContent.setVisibility(0);
      return;
      this.mEditTextFirstName.setText(localName.getFirstName());
      this.mEditTextLastName.setText(localName.getLastName());
      break;
      label375: setCountry(Locale.getDefault().getCountry());
    }
  }

  public void onLoaderReset(Loader<Profile> paramLoader)
  {
  }

  @OnClick({2131427727})
  public void onNextClicked()
  {
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.SIGN_UP_NEXT);
    sendValidateAccountRequest();
  }

  @OnEditorAction({2131427762})
  public boolean onPasswordEditorAction()
  {
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.SIGN_UP_ENTER_NEXT);
    sendValidateAccountRequest();
    return true;
  }

  public void onPhoneTextWatcherCountryChanged(String paramString)
  {
    setCountry(paramString);
  }

  public void onResume()
  {
    super.onResume();
    this.mActionBar.setTitle(getString(2131559023));
    this.mAnalyticsManager.signUpEvent().signUpPageView();
    updateUI();
    while (!this.mQueuePendingEvents.isEmpty())
      this.mBus.post(this.mQueuePendingEvents.remove());
  }

  @Subscribe
  public void onThirdPartyAuthResponseEvent(ThirdPartyAuthResponseEvent paramThirdPartyAuthResponseEvent)
  {
    Ping localPing = this.mPingProvider.get();
    if ((paramThirdPartyAuthResponseEvent.isSuccess()) && ((PingUtils.hasClient(localPing)) || (localPing.getThirdPartyConnected())))
    {
      this.mBus.post(new SignInSuccessfulEvent(localPing));
      return;
    }
    if (paramThirdPartyAuthResponseEvent.isSuccess())
    {
      Map localMap = localPing.getSignupFieldsRequired();
      this.mSignupData.setFirstName((String)localMap.get("firstName")).setLastName((String)localMap.get("lastName")).setEmail((String)localMap.get("email"));
    }
    this.mBus.post(new VerifyProfileEvent(this.mSignupData));
    hideLoadingDialog();
  }

  @Subscribe
  public void onValidateAccountResponseEvent(ValidateAccountResponseEvent paramValidateAccountResponseEvent)
  {
    hideLoadingDialog();
    if (paramValidateAccountResponseEvent.isSuccess())
      this.mBus.post(new SignupValidatedEvent(getSignupData(paramValidateAccountResponseEvent)));
    Map localMap;
    do
    {
      return;
      localMap = paramValidateAccountResponseEvent.getErrorHash();
      if (localMap == null)
      {
        String str = paramValidateAccountResponseEvent.getNetworkErrorMessage();
        if (TextUtils.isEmpty(str))
          str = getString(2131558919);
        MessageDialogFragment.show(getRiderActivity(), 0, null, str);
        return;
      }
      if ((localMap != null) && (localMap.containsKey("username")) && (!localMap.containsKey("email")))
        localMap.put("email", localMap.get("username"));
      ValidationUtils.showValidationErrors(localMap, ImmutableMap.of("email", this.mEditTextEmail, "mobile", this.mEditTextPhone, "password", this.mEditTextPassword));
    }
    while (!localMap.containsKey("error"));
    MessageDialogFragment.show(getRiderActivity(), 0, null, (String)localMap.get("error"));
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.mButtonFacebook.setText(getString(2131558851));
    this.mButtonGoogle.setText(getString(2131558884));
    this.mTextViewOr.setText(getString(2131558979));
    this.mEditTextFirstName.setHint(getString(2131558875));
    this.mEditTextFirstName.addTextChangedListener(this.mFirstAndLastNameTextWatcher);
    this.mEditTextLastName.setHint(getString(2131558903));
    this.mEditTextLastName.addTextChangedListener(this.mFirstAndLastNameTextWatcher);
    this.mEditTextEmail.setHint(getString(2131558830));
    this.mEditTextEmail.addTextChangedListener(this.mTextWatcherUpdateUI);
    this.mEditTextPhone.setHint(getString(2131558933));
    this.mEditTextPhone.addTextChangedListener(this.mTextWatcherUpdateUI);
    this.mEditTextPhone.addTextChangedListener(this.mTextWatcherPhone);
    this.mEditTextPassword.setHint(getString(2131558983));
    this.mEditTextPassword.addTextChangedListener(this.mTextWatcherUpdateUI);
    this.mButtonNext.setText(getString(2131558936));
    this.mEditTextFullName.setHint(getString(2131558880));
    if (this.mGeoManager.getGeo() == 3)
      this.mViewGroupThirdPartySignIn.setVisibility(8);
    while (true)
    {
      if (isChinesePhone())
      {
        this.mNameOneFields.setVisibility(0);
        this.mNameTwoFields.setVisibility(8);
        this.mEditTextFullName.addTextChangedListener(this.mFullNameTextWatcher);
      }
      getLoaderManager().initLoader(1, null, this);
      return;
      this.mViewGroupThirdPartySignIn.setVisibility(0);
    }
  }

  private class UpdateFirstAndLastNameTextWatcher extends SignupFragment.UpdateUITextWatcher
  {
    private UpdateFirstAndLastNameTextWatcher()
    {
      super(null);
    }

    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
      if ((SignupFragment.this.isChinesePhone()) && (TextUtils.isEmpty(SignupFragment.this.mEditTextFirstName.getText())) && (TextUtils.isEmpty(SignupFragment.this.mEditTextLastName.getText())))
      {
        SignupFragment.this.mNameOneFields.setVisibility(0);
        SignupFragment.this.mNameTwoFields.setVisibility(8);
        SignupFragment.this.mEditTextFullName.requestFocus();
      }
    }
  }

  private class UpdateFullNameTextWatcher extends SignupFragment.UpdateUITextWatcher
  {
    private UpdateFullNameTextWatcher()
    {
      super(null);
    }

    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
      String str = SignupFragment.this.mEditTextFullName.getText().toString();
      if ((str.length() > 0) && (!SignupFragment.this.isChineseCharacter(str.charAt(0))))
      {
        SignupFragment.this.mEditTextFirstName.setText(SignupFragment.this.mEditTextFullName.getText().toString());
        SignupFragment.this.mEditTextFullName.setText("");
        SignupFragment.this.mEditTextFirstName.requestFocus();
        SignupFragment.this.mNameOneFields.setVisibility(8);
        SignupFragment.this.mNameTwoFields.setVisibility(0);
      }
    }
  }

  private class UpdateUITextWatcher extends TextWatcherAdapter
  {
    private UpdateUITextWatcher()
    {
    }

    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      SignupFragment.this.updateUI();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.signup.SignupFragment
 * JD-Core Version:    0.6.2
 */