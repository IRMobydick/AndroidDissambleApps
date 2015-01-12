package com.ubercab.client.feature.launch;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.analytics.event.NearestCabEvent;
import com.ubercab.client.core.app.RiderPublicActivity;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.RiderLocationProvider;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.client.core.location.RiderLocation;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Impression;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Tap;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.PaymentProfile;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.RewardInfo;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.core.util.RiderUtil;
import com.ubercab.client.feature.employee.EmployeeSettingsActivity;
import com.ubercab.client.feature.payment.RewardInfoActivity;
import com.ubercab.client.feature.signin.SignInActivity;
import com.ubercab.client.feature.signup.SignupActivity;
import com.ubercab.client.feature.signup.SignupPaymentOtpActivity;
import com.ubercab.client.feature.trip.TripActivity;
import com.ubercab.client.feature.verification.MobileVerificationActivity;
import com.ubercab.library.app.UberPreferences;
import com.ubercab.library.location.event.NoLocationEvent;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import com.ubercab.library.metrics.analytics.event.ImpressionEventName;
import com.ubercab.library.ui.LongPressLayout;
import com.ubercab.library.ui.LongPressLayout.TriggerCallback;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberEditText;
import com.ubercab.ui.UberTextView;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;

public class MagicActivity extends RiderPublicActivity
  implements LongPressLayout.TriggerCallback
{
  private static final int REQUEST_CODE_REGISTER = 2005;
  private static final int REQUEST_CODE_SIGN_IN = 2000;
  private static final Pattern SERVER_REGEX = Pattern.compile("[a-zA-Z0-9]+");

  @Inject
  AnalyticsClient mAnalyticsClient;

  @Inject
  AnalyticsManager mAnalyticsManager;

  @InjectView(2131427482)
  UberButton mButtonRegister;

  @InjectView(2131427481)
  UberButton mButtonSignIn;

  @InjectView(2131427479)
  LongPressLayout mLayoutRoot;

  @Inject
  RiderLocationProvider mLocationProvider;

  @Inject
  PingProvider mPingProvider;

  @Inject
  SessionPreferences mSessionPreferences;

  @InjectView(2131427480)
  UberTextView mTextViewDevServer;

  @InjectView(2131427485)
  UberTextView mTextViewSlogan;

  @Inject
  UberPreferences mUberPreferences;

  @InjectView(2131427483)
  ViewGroup mViewGroupEmployee;

  private void initEmployeeUI()
  {
  }

  private static boolean isEligibleForRewardsEnrollment(PaymentProfile paramPaymentProfile)
  {
    if (paramPaymentProfile == null);
    RewardInfo localRewardInfo;
    do
    {
      return false;
      localRewardInfo = paramPaymentProfile.getRewardInfo();
    }
    while ((localRewardInfo == null) || (!localRewardInfo.isEligible()) || (localRewardInfo.isEnrolled()) || (localRewardInfo.hasTakenEnrollAction()));
    return true;
  }

  private void setSloganText()
  {
    RiderLocation localRiderLocation = this.mLocationProvider.getDeviceLocation();
    this.mTextViewSlogan.setText(RiderUtil.getUberSlogan(this, localRiderLocation));
  }

  private void showServerDialog()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    localBuilder.setTitle("Change Server");
    localBuilder.setMessage("Leave blank for production or enter the EC2 name.");
    final UberEditText localUberEditText = new UberEditText(this);
    localBuilder.setView(localUberEditText);
    localBuilder.setPositiveButton(17039370, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        String str1 = localUberEditText.getText().toString();
        if (TextUtils.isEmpty(str1))
        {
          MagicActivity.this.mUberPreferences.removeCnEndpoint();
          MagicActivity.this.updateCustomServerUI();
        }
        while (!MagicActivity.SERVER_REGEX.matcher(str1).matches())
          return;
        if (MagicActivity.this.mUberPreferences.isCnSslVerificationDisabled());
        for (String str2 = "http://"; ; str2 = "https://")
        {
          String str3 = "";
          if ("amex".equals(str1))
            str3 = ":8000";
          MagicActivity.this.mUberPreferences.setCnEndpoint(String.format("%scn.%s.dev.uber.com%s", new Object[] { str2, str1, str3 }));
          break;
        }
      }
    });
    localBuilder.setNegativeButton(2131559124, null);
    localBuilder.show();
  }

  private void startRegisterActivityForResult()
  {
    startActivityForResult(new Intent(this, SignupActivity.class), 2005);
  }

  private void startRewardsEnrollActivity(List<PaymentProfile> paramList)
  {
    if (!paramList.isEmpty())
    {
      PaymentProfile localPaymentProfile = (PaymentProfile)paramList.get(0);
      if (isEligibleForRewardsEnrollment(localPaymentProfile))
        startActivity(RewardInfoActivity.newIntent(this, localPaymentProfile));
    }
  }

  private void startSignInActivityForResult()
  {
    startActivityForResult(new Intent(this, SignInActivity.class), 2000);
  }

  private void updateCustomServerUI()
  {
    String str = this.mUberPreferences.getCnEndpoint();
    if (!TextUtils.isEmpty(str))
    {
      this.mTextViewDevServer.setText("Server: " + str);
      this.mTextViewDevServer.setVisibility(0);
      return;
    }
    this.mTextViewDevServer.setVisibility(8);
  }

  protected ImpressionEventName getImpressionAnalyticsName()
  {
    return RiderEvents.Impression.MAGIC;
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 2000) && (paramInt2 == -1))
    {
      startActivity(new Intent(this, TripActivity.class));
      this.mAnalyticsManager.nearestCabEvent().openAppRequest();
      localPing2 = this.mPingProvider.get();
      if (PingUtils.hasClient(localPing2))
      {
        localClient2 = localPing2.getClient();
        if (PingUtils.hasExperimentSerial(this.mPingProvider.get(), "amex_rewards", 1))
        {
          localPaymentProfile = RewardInfoActivity.findPaymentProfileToEnroll(localClient2.getPaymentProfiles());
          if (localPaymentProfile != null)
            startActivity(RewardInfoActivity.newIntent(this, localPaymentProfile));
        }
      }
      finish();
    }
    while ((paramInt1 != 2005) || (paramInt2 != -1))
    {
      Ping localPing2;
      Client localClient2;
      PaymentProfile localPaymentProfile;
      return;
    }
    startActivity(new Intent(this, TripActivity.class));
    this.mAnalyticsManager.nearestCabEvent().openAppRequest();
    Ping localPing1 = this.mPingProvider.get();
    Client localClient1;
    if (PingUtils.hasClient(localPing1))
    {
      localClient1 = localPing1.getClient();
      if (!localClient1.hasConfirmedMobile())
        if (!localClient1.hasToOptInSmsNotifications())
          break label282;
    }
    label282: for (String str = "com.ubercab.ACTION_MOBILE_VERIFICATION_SMS"; ; str = "com.ubercab.ACTION_MOBILE_VERIFICATION_TOKEN")
    {
      Intent localIntent = new Intent(this, MobileVerificationActivity.class);
      localIntent.setAction(str);
      startActivity(localIntent);
      if (PingUtils.hasExperimentSerial(this.mPingProvider.get(), "amex_rewards", 1))
        startRewardsEnrollActivity(localClient1.getPaymentProfiles());
      if (SignupPaymentOtpActivity.isEligible(localClient1.getInactivePaymentProfiles()))
        startActivity(SignupPaymentOtpActivity.newIntent(this, ((PaymentProfile)localClient1.getInactivePaymentProfiles().get(0)).getUuid()));
      finish();
      return;
    }
  }

  @OnClick({2131427484})
  public void onClickButtonEmployee()
  {
    startActivity(new Intent(this, EmployeeSettingsActivity.class));
  }

  @OnClick({2131427480})
  public void onClickTextViewDevServer()
  {
    showServerDialog();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903091);
    ButterKnife.inject(this);
    setHasImpressionAnalytics(true);
    initEmployeeUI();
    updateCustomServerUI();
    this.mLayoutRoot.setTriggerCallback(this);
  }

  @Subscribe
  public void onNoLocationEvent(NoLocationEvent paramNoLocationEvent)
  {
    alertIfLocationServicesDisabled();
  }

  @OnClick({2131427482})
  public void onRegisterButtonClicked()
  {
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.REGISTER);
    this.mSessionPreferences.setSessionHash(UUID.randomUUID().toString());
    startRegisterActivityForResult();
  }

  public void onResume()
  {
    super.onResume();
    setSloganText();
  }

  @OnClick({2131427481})
  public void onSignInButtonClicked()
  {
    startSignInActivityForResult();
  }

  protected void onStart()
  {
    super.onStart();
    this.mButtonSignIn.setText(getString(2131559070));
    this.mButtonRegister.setText(getString(2131559023));
  }

  public void onTrigger()
  {
    showServerDialog();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.launch.MagicActivity
 * JD-Core Version:    0.6.2
 */