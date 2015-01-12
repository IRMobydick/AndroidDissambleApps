package com.ubercab.client.feature.eta;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.text.TextUtils;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.analytics.event.ShareEvent;
import com.ubercab.client.core.analytics.event.TripEvent;
import com.ubercab.client.core.app.RiderPingActivity;
import com.ubercab.client.core.app.event.RiderServiceReadyEvent;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.location.RiderLocation;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Tap;
import com.ubercab.client.core.model.CnLocation;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.Trip;
import com.ubercab.client.core.model.TripVehicle;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.client.core.network.events.SetDestinationResponseEvent;
import com.ubercab.client.core.network.events.ShareYoRideResponseEvent;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.feature.search.LocationSearchActivity;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import com.ubercab.library.util.StringUtils;
import javax.inject.Inject;

public class ShareEtaActivity extends RiderPingActivity
  implements DialogInterface.OnCancelListener
{
  private static final int REQUEST_CODE_DESTINATION = 3005;

  @Inject
  AnalyticsClient mAnalyticsClient;

  @Inject
  AnalyticsManager mAnalyticsManager;
  private boolean mDestinationSkipped;
  private RiderLocation mPendingDestination;

  @Inject
  PingProvider mPingProvider;

  @Inject
  RiderClient mRiderClient;

  private void shareEta(Ping paramPing)
  {
    if (!PingUtils.hasTrip(paramPing))
    {
      setResult(0);
      finish();
      return;
    }
    if (this.mPendingDestination != null)
    {
      showLoadingDialogSticky(getString(2131559065), null);
      String str = paramPing.getTrip().getVehicle().getVehicleViewId();
      CnLocation localCnLocation = new CnLocation();
      localCnLocation.setLatitude(paramPing.getTrip().getPickupLocation().getLatitude());
      localCnLocation.setLongitude(paramPing.getTrip().getPickupLocation().getLongitude());
      if (str != null)
        this.mRiderClient.setDestination(Integer.valueOf(str).intValue(), 0L, localCnLocation, this.mPendingDestination.getCnLocation());
      this.mPendingDestination = null;
      return;
    }
    if ((!PingUtils.hasTripDestination(paramPing)) && (!this.mDestinationSkipped))
    {
      this.mAnalyticsManager.tripEvent().setAppContext("shareETA");
      startActivityForResult(LocationSearchActivity.newIntent(this, "com.ubercab.ACTION_DESTINATION_ETA", RiderLocation.create(paramPing.getTrip().getPickupLocation()), null), 3005);
      return;
    }
    if (TextUtils.isEmpty(paramPing.getTrip().getShareUrl()))
    {
      showLoadingDialog(getString(2131559065), this);
      this.mAnalyticsManager.shareEvent().shareMyEtaRequest();
      this.mRiderClient.shareYoRide();
      return;
    }
    startShareIntent(paramPing.getTrip().getShareUrl());
  }

  private void startShareIntent(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      setResult(0);
      finish();
      return;
    }
    String str1 = getString(2131559067);
    String str2 = StringUtils.trimPeriod(getString(2131559066, new Object[] { paramString }));
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.putExtra("sms", str2);
    localIntent.putExtra("android.intent.extra.TEXT", str2);
    localIntent.putExtra("android.intent.extra.SUBJECT", str1);
    localIntent.setType("text/plain");
    startActivity(Intent.createChooser(localIntent, getString(2131559068)));
    setResult(-1);
    finish();
    this.mAnalyticsManager.shareEvent().shareEta();
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.SHARE_ETA_SEND);
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 3005);
    switch (paramInt2)
    {
    case 0:
    default:
      this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.SHARE_ETA_CANCEL);
      setResult(0);
      finish();
      return;
    case -1:
      this.mPendingDestination = ((RiderLocation)paramIntent.getParcelableExtra("com.ubercab.LOCATION"));
      return;
    case 1:
    }
    this.mDestinationSkipped = true;
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.SHARE_ETA_SKIP_DESTINATION);
  }

  public void onCancel(DialogInterface paramDialogInterface)
  {
    setResult(0);
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.SHARE_ETA_CANCEL);
    finish();
  }

  @Subscribe
  public void onRiderServiceReadyEvent(RiderServiceReadyEvent paramRiderServiceReadyEvent)
  {
    if (!isFinishing())
      shareEta(this.mPingProvider.get());
  }

  @Subscribe
  public void onSetDestinationResponseEvent(SetDestinationResponseEvent paramSetDestinationResponseEvent)
  {
    if (!paramSetDestinationResponseEvent.isSuccess())
    {
      hideLoadingDialog();
      showToast(paramSetDestinationResponseEvent.getErrorMessage(this));
      setResult(0);
      finish();
      return;
    }
    this.mPendingDestination = null;
    shareEta((Ping)paramSetDestinationResponseEvent.getModel());
  }

  @Subscribe
  public void onShareYoRideResponseEvent(ShareYoRideResponseEvent paramShareYoRideResponseEvent)
  {
    if (!paramShareYoRideResponseEvent.isSuccess())
    {
      hideLoadingDialog();
      showToast(paramShareYoRideResponseEvent.getErrorMessage(this));
      this.mAnalyticsManager.shareEvent().shareMyEtaError(paramShareYoRideResponseEvent.getStatusCode());
      setResult(0);
      finish();
      return;
    }
    this.mAnalyticsManager.shareEvent().shareMyEtaSuccessful();
    shareEta((Ping)paramShareYoRideResponseEvent.getModel());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.eta.ShareEtaActivity
 * JD-Core Version:    0.6.2
 */