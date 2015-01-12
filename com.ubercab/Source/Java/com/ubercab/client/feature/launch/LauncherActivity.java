package com.ubercab.client.feature.launch;

import android.content.Intent;
import android.os.Bundle;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.adjust.sdk.Adjust;
import com.adjust.sdk.OnFinishedListener;
import com.adjust.sdk.ResponseData;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.analytics.event.NearestCabEvent;
import com.ubercab.client.core.analytics.event.SignOutEvent;
import com.ubercab.client.core.analytics.event.UrlEvent;
import com.ubercab.client.core.app.RiderPreferences;
import com.ubercab.client.core.app.RiderPublicActivity;
import com.ubercab.client.core.content.RiderLocationProvider;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.client.core.content.event.DeviceLocationEvent;
import com.ubercab.client.core.location.RiderLocation;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Impression;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.PaymentProfile;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.network.events.PingClientResponseEvent;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.core.util.RiderUtil;
import com.ubercab.client.feature.onboarding.OnboardingActivity;
import com.ubercab.client.feature.payment.RewardInfoActivity;
import com.ubercab.client.feature.trip.TripActivity;
import com.ubercab.geo.GeoManager;
import com.ubercab.library.location.event.NoLocationEvent;
import com.ubercab.library.metrics.analytics.event.ImpressionEventName;
import com.ubercab.library.vendor.google.GoogleUtils;
import com.ubercab.ui.UberTextView;
import com.ubercab.webclient.app.WebClientActivity;
import javax.inject.Inject;

public class LauncherActivity extends RiderPublicActivity
{
  public static final String EXTRA_TRIP_NOTIFICATION_ACTION = "trip_notification_action";

  @Inject
  AnalyticsManager mAnalyticsManager;

  @Inject
  GeoManager mGeoManager;

  @Inject
  RiderLocationProvider mLocationProvider;

  @Inject
  RiderPreferences mRiderPreferences;

  @Inject
  SessionPreferences mSessionPreferences;

  @InjectView(2131427485)
  UberTextView mTextViewSlogan;

  private void setSloganText()
  {
    RiderLocation localRiderLocation = this.mLocationProvider.getDeviceLocation();
    this.mTextViewSlogan.setText(RiderUtil.getUberSlogan(this, localRiderLocation));
  }

  private boolean showPreload()
  {
    if (!RiderUtil.isPreload());
    Preload localPreload;
    do
    {
      return false;
      localPreload = new Preload(this, this.mAnalyticsManager);
    }
    while (!localPreload.isFirstLaunch());
    localPreload.dropBreadcrumbs();
    localPreload.sendAppOpenEvent();
    localPreload.setHasRunOnce();
    return true;
  }

  private void startMagicActivityAndFinish()
  {
    if ((this.mGeoManager.getGeo() != 3) && (!GoogleUtils.isGooglePlayServicesInstalled(this)));
    for (Intent localIntent = new Intent(this, WebClientActivity.class); ; localIntent = new Intent(this, MagicActivity.class))
    {
      startActivity(localIntent);
      finish();
      return;
    }
  }

  private void startOnboardingActivityAndFinish()
  {
    startActivity(new Intent(this, OnboardingActivity.class));
    finish();
  }

  private void startTripActivityAndFinish()
  {
    Intent localIntent;
    if ((this.mGeoManager.getGeo() != 3) && (!isGooglePlayServicesInstalled()))
      localIntent = new Intent(this, WebClientActivity.class);
    while (true)
    {
      startActivity(localIntent);
      finish();
      return;
      localIntent = new Intent(this, TripActivity.class);
      if (getIntent().hasExtra("trip_notification_action"))
        localIntent.setAction(getIntent().getStringExtra("trip_notification_action"));
      localIntent.setData(getIntent().getData());
    }
  }

  private void trackAdjustInstallOnce()
  {
    if (!this.mRiderPreferences.hasTrackedInstall())
    {
      Adjust.onResume(this);
      Adjust.setOnFinishedListener(new OnFinishedListener()
      {
        public void onFinishedTracking(ResponseData paramAnonymousResponseData)
        {
          if (paramAnonymousResponseData.wasSuccess())
          {
            Adjust.setEnabled(Boolean.valueOf(false));
            LauncherActivity.this.mRiderPreferences.setTrackedInstall(true);
          }
        }
      });
    }
  }

  private void trackUberUrlIntent()
  {
    Intent localIntent = getIntent();
    if ((localIntent != null) && (localIntent.getData() != null) && ("uber".equals(localIntent.getScheme())))
      this.mAnalyticsManager.urlEvent().handleUrl(localIntent.getData());
  }

  protected ImpressionEventName getImpressionAnalyticsName()
  {
    return RiderEvents.Impression.SPLASH;
  }

  boolean isGooglePlayServicesInstalled()
  {
    return GoogleUtils.isGooglePlayServicesInstalled(this);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903092);
    ButterKnife.inject(this);
    trackUberUrlIntent();
    setHasImpressionAnalytics(true);
  }

  @Subscribe
  public void onDeviceLocationEvent(DeviceLocationEvent paramDeviceLocationEvent)
  {
    if (showPreload())
    {
      startOnboardingActivityAndFinish();
      return;
    }
    if (!this.mSessionPreferences.hasToken())
    {
      startMagicActivityAndFinish();
      return;
    }
    setSloganText();
  }

  @Subscribe
  public void onNoLocationEvent(NoLocationEvent paramNoLocationEvent)
  {
    if (showPreload())
      startOnboardingActivityAndFinish();
    do
    {
      return;
      setSloganText();
    }
    while (this.mSessionPreferences.hasToken());
    startMagicActivityAndFinish();
  }

  @Subscribe
  public void onPingClientResponseEvent(PingClientResponseEvent paramPingClientResponseEvent)
  {
    if (!paramPingClientResponseEvent.isSuccess())
    {
      if (paramPingClientResponseEvent.getNetworkError() == null)
      {
        this.mAnalyticsManager.signOutEvent().initialPingError();
        return;
      }
      this.mAnalyticsManager.signOutEvent().initialPingFailed();
      return;
    }
    startTripActivityAndFinish();
    Ping localPing = (Ping)paramPingClientResponseEvent.getModel();
    if (PingUtils.hasClient(localPing))
    {
      Client localClient = localPing.getClient();
      String str = localClient.getUuid();
      if (!str.equals(this.mSessionPreferences.getUserUuid()))
        this.mSessionPreferences.setUserUuid(str);
      if (PingUtils.hasExperimentSerial(localPing, "amex_rewards", 1))
      {
        PaymentProfile localPaymentProfile = RewardInfoActivity.findPaymentProfileToEnroll(localClient.getPaymentProfiles());
        if (localPaymentProfile != null)
          startActivity(RewardInfoActivity.newIntent(this, localPaymentProfile));
      }
    }
    this.mAnalyticsManager.nearestCabEvent().openAppRequest();
  }

  public void onResume()
  {
    super.onResume();
    setSloganText();
    trackAdjustInstallOnce();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.launch.LauncherActivity
 * JD-Core Version:    0.6.2
 */