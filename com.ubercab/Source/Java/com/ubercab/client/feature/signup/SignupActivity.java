package com.ubercab.client.feature.signup;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalService;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.app.RiderApplication;
import com.ubercab.client.core.app.RiderPublicActivity;
import com.ubercab.client.core.model.AppConfig;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.network.AppConfigClient;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.client.core.network.events.VerifyProfileEvent;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.feature.payment.PaymentModule;
import com.ubercab.client.feature.signin.event.SignInSuccessfulEvent;
import com.ubercab.client.feature.signup.event.SignupChooseInternationalCreditCardEvent;
import com.ubercab.client.feature.signup.event.SignupCompletedEvent;
import com.ubercab.client.feature.signup.event.SignupMissingInfoEvent;
import com.ubercab.client.feature.signup.event.SignupPendingConfirmedEvent;
import com.ubercab.client.feature.signup.event.SignupPendingEvent;
import com.ubercab.client.feature.signup.event.SignupValidatedEvent;
import com.ubercab.common.collect.ObjectArrays;
import com.ubercab.geo.GeoManager;
import com.ubercab.library.ui.ConfirmDialogFragment;
import javax.inject.Inject;

public class SignupActivity extends RiderPublicActivity
{
  static final int REQUEST_CODE_CANCEL = 1;
  public static final String THIRD_PARTY_PROFILE = "com.ubercab.THIRD_PARTY_PROFILE";

  @Inject
  AppConfigClient mAppConfigClient;

  @Inject
  GeoManager mGeoManager;

  @Inject
  PayPalConfiguration mPayPalConfiguration;

  @Inject
  RiderClient mRiderClient;

  private void cancelSignup()
  {
    if (((getFragmentManager().getBackStackEntryCount() > 0) || (findFragment(SignupFragment.class) == null)) && (findFragment(SignupPendingFragment.class) == null))
    {
      String str1 = getString(2131558937);
      String str2 = getString(2131559349);
      ConfirmDialogFragment.show(this, 1, null, getString(2131558469), str2, str1);
      return;
    }
    sendSignUpCancelEvent();
    setResult(0);
    finish();
  }

  private void sendSignUpCancelEvent()
  {
    SignupEvents localSignupEvents = (SignupEvents)getFragmentManager().findFragmentById(2131427721);
    if (localSignupEvents != null)
      localSignupEvents.onCancel();
  }

  protected Object[] getModules()
  {
    return ObjectArrays.concat(super.getModules(), new PaymentModule());
  }

  public void onBackPressed()
  {
    cancelSignup();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Intent localIntent = new Intent(this, PayPalService.class);
    localIntent.putExtra("com.paypal.android.sdk.paypalConfiguration", this.mPayPalConfiguration);
    startService(localIntent);
    setContentView(2130903178);
    if ((getIntent().hasExtra("com.ubercab.THIRD_PARTY_PROFILE")) && (findFragment(VerifyFacebookProfileFragment.class) == null))
      pushFragment(2131427721, VerifyFacebookProfileFragment.newInstance((SignupData)getIntent().getParcelableExtra("com.ubercab.THIRD_PARTY_PROFILE")), true);
    while (getFragmentManager().findFragmentById(2131427721) != null)
      return;
    putFragment(2131427721, SignupFragment.newInstance(), true);
  }

  protected void onDestroy()
  {
    stopService(new Intent(this, PayPalService.class));
    super.onDestroy();
  }

  public void onDialogResult(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    SignupPaymentFragment localSignupPaymentFragment = (SignupPaymentFragment)findFragment(SignupPaymentFragment.class);
    if ((localSignupPaymentFragment != null) && (localSignupPaymentFragment.onDialogResult(paramInt1, paramInt2, paramBundle)));
    SignupChoosePaymentFragment localSignupChoosePaymentFragment;
    do
    {
      return;
      localSignupChoosePaymentFragment = (SignupChoosePaymentFragment)findFragment(SignupChoosePaymentFragment.class);
    }
    while (((localSignupChoosePaymentFragment != null) && (localSignupChoosePaymentFragment.onDialogResult(paramInt1, paramInt2, paramBundle))) || (paramInt1 != 1) || (paramInt2 != -1));
    sendSignUpCancelEvent();
    setResult(0);
    finish();
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
    {
      cancelSignup();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }

  @Subscribe
  public void onSignInSuccessfulEvent(SignInSuccessfulEvent paramSignInSuccessfulEvent)
  {
    Ping localPing = paramSignInSuccessfulEvent.getPing();
    if (!PingUtils.hasClient(localPing))
      return;
    String str1 = localPing.getClient().getUuid();
    String str2 = localPing.getClient().getToken();
    String str3 = localPing.getClient().getEmail();
    RiderApplication.get(this).setCurrentUser(str1, str2, str3);
    this.mRiderClient.pingClient();
    setResult(-1);
    finish();
  }

  @Subscribe
  public void onSignupChooseInternationalCreditCard(SignupChooseInternationalCreditCardEvent paramSignupChooseInternationalCreditCardEvent)
  {
    if (findFragment(SignupPaymentFragment.class) == null)
      pushFragment(2131427721, SignupPaymentFragment.newInstance(paramSignupChooseInternationalCreditCardEvent.getData()), true);
  }

  @Subscribe
  public void onSignupCompletedEvent(SignupCompletedEvent paramSignupCompletedEvent)
  {
    setResult(-1);
    finish();
  }

  @Subscribe
  public void onSignupMissingInfoEvent(SignupMissingInfoEvent paramSignupMissingInfoEvent)
  {
    if (findFragment(SignupMissingInfoFragment.class) == null)
      putFragment(2131427721, SignupMissingInfoFragment.newInstance(paramSignupMissingInfoEvent.getData()), true);
  }

  @Subscribe
  public void onSignupPendingConfirmedEvent(SignupPendingConfirmedEvent paramSignupPendingConfirmedEvent)
  {
    cancelSignup();
  }

  @Subscribe
  public void onSignupPendingEvent(SignupPendingEvent paramSignupPendingEvent)
  {
    if (findFragment(SignupPendingFragment.class) == null)
      putFragment(2131427721, SignupPendingFragment.newInstance(paramSignupPendingEvent.getEmail()), true);
  }

  @Subscribe
  public void onSignupValidatedEvent(SignupValidatedEvent paramSignupValidatedEvent)
  {
    if ((SignupChoosePaymentFragment.isEligible(this.mGeoManager)) && (this.mAppConfigClient.getLastAnonymousAppConfig().isPayTmSignupEnabled().booleanValue()))
      if (findFragment(SignupChoosePaymentFragment.class) == null)
        pushFragment(2131427721, SignupChoosePaymentFragment.newInstance(paramSignupValidatedEvent.getData()), true);
    while (findFragment(SignupPaymentFragment.class) != null)
      return;
    pushFragment(2131427721, SignupPaymentFragment.newInstance(paramSignupValidatedEvent.getData()), true);
  }

  @Subscribe
  public void onVerifyProfileEvent(VerifyProfileEvent paramVerifyProfileEvent)
  {
    if (findFragment(VerifyFacebookProfileFragment.class) == null)
      pushFragment(2131427721, VerifyFacebookProfileFragment.newInstance(paramVerifyProfileEvent.getSignupData()), true);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.signup.SignupActivity
 * JD-Core Version:    0.6.2
 */