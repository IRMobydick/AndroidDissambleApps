package com.ubercab.client.feature.signup;

import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.plus.Account;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.Person.Image;
import com.google.android.gms.plus.model.people.Person.Name;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.app.RiderApplication;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.client.core.network.SignupClient;
import com.ubercab.client.core.network.events.LoginGoogleResponseEvent;
import com.ubercab.client.core.network.events.ValidateAccountResponseEvent;
import com.ubercab.client.core.vendor.google.GoogleApiActivity;
import com.ubercab.client.core.vendor.google.GooglePlusUtils;
import com.ubercab.library.network.dispatch.DispatchRequest;
import com.ubercab.library.util.PhoneNumberUtils;
import java.util.Locale;
import javax.inject.Inject;
import retrofit.client.Response;

public class SignupGoogleActivity extends GoogleApiActivity
{
  public static final String EXTRA_SIGNUP_DATA = "com.ubercab.SIGNUP_DATA";
  public static final String FAKE_PASSWORD = "thisisnotarealpassword1234567$";
  public static final int RESULT_LOGGED_IN = 1;
  private String mAccountName;
  private String mGoogleToken;

  @Inject
  RiderClient mRiderClient;

  @Inject
  SignupClient mSignupClient;
  private SignupData mValidatedSignupData;

  private void finishWithResult(SignupData paramSignupData)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("com.ubercab.SIGNUP_DATA", paramSignupData);
    setResult(-1, localIntent);
    finish();
  }

  public void onConnected(Bundle paramBundle)
  {
    final String str = getResources().getString(2131559130);
    new AsyncTask()
    {
      private Exception mException;

      protected String doInBackground(Void[] paramAnonymousArrayOfVoid)
      {
        try
        {
          String str = GoogleAuthUtil.getToken(SignupGoogleActivity.this, this.val$accountName, str);
          return str;
        }
        catch (Exception localException)
        {
          this.mException = localException;
        }
        return null;
      }

      protected void onPostExecute(String paramAnonymousString)
      {
        if (SignupGoogleActivity.this.isFinishing())
          return;
        if (this.mException != null)
        {
          SignupGoogleActivity.this.showToast(this.mException.getMessage());
          SignupGoogleActivity.this.setResult(0);
          SignupGoogleActivity.this.finish();
          return;
        }
        SignupGoogleActivity.access$002(SignupGoogleActivity.this, this.val$accountName);
        SignupGoogleActivity.access$102(SignupGoogleActivity.this, paramAnonymousString);
        SignupGoogleActivity.this.mRiderClient.loginGoogle(SignupGoogleActivity.this.mAccountName, SignupGoogleActivity.this.mGoogleToken);
      }

      protected void onPreExecute()
      {
        SignupGoogleActivity.this.showLoadingDialogSticky(SignupGoogleActivity.this.getString(2131558909), null);
      }
    }
    .executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    showLoadingDialogSticky(getString(2131558909), null);
  }

  public void onDispatchError(DispatchRequest paramDispatchRequest, Ping paramPing, Response paramResponse)
  {
  }

  @Subscribe
  public void onLoginGoogleResponseEvent(LoginGoogleResponseEvent paramLoginGoogleResponseEvent)
  {
    if (paramLoginGoogleResponseEvent.isSuccess())
    {
      Ping localPing = (Ping)paramLoginGoogleResponseEvent.getModel();
      String str1 = localPing.getClient().getUuid();
      String str2 = localPing.getClient().getToken();
      String str3 = localPing.getClient().getEmail();
      RiderApplication.get(this).setCurrentUser(str1, str2, str3);
      setResult(1);
      finish();
      return;
    }
    if (paramLoginGoogleResponseEvent.getNetworkError() != null)
    {
      GooglePlusUtils.clearTokenInBackground(this, this.mGoogleToken);
      showToast(paramLoginGoogleResponseEvent.getErrorMessage(this));
      setResult(0);
      return;
    }
    SignupData localSignupData = new SignupData().setEmail(this.mAccountName).setGoogleToken(this.mGoogleToken);
    TelephonyManager localTelephonyManager = (TelephonyManager)getSystemService("phone");
    if ((!TextUtils.isEmpty(localTelephonyManager.getLine1Number())) && (!TextUtils.isEmpty(localTelephonyManager.getSimCountryIso())))
      localSignupData.setMobile(PhoneNumberUtils.getDisplayPhoneNumber(localTelephonyManager.getLine1Number(), localTelephonyManager.getSimCountryIso()), localTelephonyManager.getSimCountryIso().toUpperCase(Locale.US));
    Person localPerson = Plus.PeopleApi.getCurrentPerson(this.mGoogleApiClient);
    if (localPerson != null)
    {
      if (localPerson.hasName())
      {
        localSignupData.setFirstName(localPerson.getName().getGivenName());
        localSignupData.setLastName(localPerson.getName().getFamilyName());
      }
      if ((localPerson.hasImage()) && (localPerson.getImage().hasUrl()))
        localSignupData.setPictureUrl(localPerson.getImage().getUrl());
    }
    if (localSignupData.hasRequiredData())
    {
      this.mValidatedSignupData = localSignupData;
      showLoadingDialogSticky(getString(2131559341), null);
      this.mSignupClient.validateAccount(localSignupData.getEmail(), localSignupData.getMobile(), localSignupData.getMobileCountryIso2(), "thisisnotarealpassword1234567$");
      return;
    }
    finishWithResult(localSignupData);
  }

  @Subscribe
  public void onValidateAccountResponseEvent(ValidateAccountResponseEvent paramValidateAccountResponseEvent)
  {
    hideLoadingDialog();
    if ((!paramValidateAccountResponseEvent.isSuccess()) || (this.mValidatedSignupData == null))
    {
      showToast(getString(2131558921));
      setResult(0);
      finish();
      return;
    }
    finishWithResult(this.mValidatedSignupData);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.signup.SignupGoogleActivity
 * JD-Core Version:    0.6.2
 */