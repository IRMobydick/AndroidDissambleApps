package com.ubercab.client.feature.surge;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.analytics.event.SurgeEvent;
import com.ubercab.client.core.app.RiderPingActivity;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.RiderLocationProvider;
import com.ubercab.client.core.location.RiderLocation;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Tap;
import com.ubercab.client.core.model.City;
import com.ubercab.client.core.model.CnLocation;
import com.ubercab.client.core.model.DropNotification;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.Surge;
import com.ubercab.client.core.model.VehicleView;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.client.core.network.events.ScheduleSurgeDropNotificationResponseEvent;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.core.vendor.google.GmmProductSurge;
import com.ubercab.client.feature.surge.event.SurgeAcceptedEvent;
import com.ubercab.client.feature.surge.event.SurgeCancelledEvent;
import com.ubercab.client.feature.surge.event.SurgeConfirmNotificationEvent;
import com.ubercab.client.feature.surge.event.SurgeExpiredEvent;
import com.ubercab.client.feature.surge.event.SurgeSobrietyFailEvent;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import com.ubercab.library.ui.MessageDialogFragment;
import javax.inject.Inject;
import timber.log.Timber;

public class SurgeActivity extends RiderPingActivity
{
  private static final String BUNDLE_VEHICLE_VIEW_ID = "com.ubercab.BUNDLE_VEHICLE_VIEW_ID";
  public static final String EXTRA_FARE_ID = "com.ubercab.FARE_ID";
  private static final String EXTRA_GMM_PRODUCT_SURGE_DISPLAYED = "com.ubercab.GMM_PRODUCT_SURGE_DISPLAYED";
  private static final String EXTRA_SELECTED_VEHICLE_VIEW_ID = "com.ubercab.SELECTED_VEHICLE_VIEW";
  private static final String EXTRA_SHOW_SOBRIETY = "com.ubercab.SHOW_SOBRIETY";
  private static final int REQUEST_CODE_SURGE_SOBRIETY_TEST_FAIL = 1010;

  @Inject
  AnalyticsClient mAnalyticsClient;

  @Inject
  AnalyticsManager mAnalyticsManager;
  private String mCurrentVehicleViewId;

  @Inject
  RiderLocationProvider mLocationProvider;

  @Inject
  PingProvider mPingProvider;

  @Inject
  RiderClient mRiderClient;
  private boolean mSobrietyScreenShown;

  private void finishSuccess(long paramLong)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("com.ubercab.FARE_ID", paramLong);
    setResult(-1, localIntent);
    finish();
  }

  private VehicleView getVehicleView()
  {
    Ping localPing = this.mPingProvider.get();
    if (!PingUtils.hasVehicleView(localPing, this.mCurrentVehicleViewId))
    {
      logVehicleViewLookupError();
      return null;
    }
    return localPing.getCity().findVehicleView(this.mCurrentVehicleViewId);
  }

  private void logVehicleViewLookupError()
  {
    Timber.d("Vehicle view does not exist in Ping: " + this.mCurrentVehicleViewId, new Object[0]);
  }

  public static Intent newIntent(Context paramContext, String paramString, boolean paramBoolean, GmmProductSurge paramGmmProductSurge)
  {
    Intent localIntent = new Intent(paramContext, SurgeActivity.class);
    localIntent.putExtra("com.ubercab.SELECTED_VEHICLE_VIEW", paramString);
    localIntent.putExtra("com.ubercab.SHOW_SOBRIETY", paramBoolean);
    localIntent.putExtra("com.ubercab.GMM_PRODUCT_SURGE_DISPLAYED", paramGmmProductSurge);
    return localIntent;
  }

  private void pushSurgeSobrietyFragment()
  {
    pushFragment(2131427768, SurgeFragment.getInstance(true, (GmmProductSurge)getIntent().getParcelableExtra("com.ubercab.GMM_PRODUCT_SURGE_DISPLAYED")), true);
    this.mSobrietyScreenShown = true;
  }

  private void putSurgeFragment()
  {
    if (findFragment(SurgeFragment.class) == null)
    {
      sendSurgeDisplayEvent();
      putFragment(2131427768, SurgeFragment.getInstance(false, (GmmProductSurge)getIntent().getParcelableExtra("com.ubercab.GMM_PRODUCT_SURGE_DISPLAYED")), true);
    }
  }

  private void sendSurgeAcceptEvent()
  {
    VehicleView localVehicleView = getVehicleView();
    if (localVehicleView == null)
      return;
    this.mAnalyticsManager.surgeEvent().surgeAccept(localVehicleView.getSurge().getFareId(), localVehicleView.getId(), localVehicleView.getSurge().getMultiplier());
  }

  private void sendSurgeCancelEvent()
  {
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.SURGE_PRICING_CLOSE);
    VehicleView localVehicleView = getVehicleView();
    if (localVehicleView == null)
      return;
    this.mAnalyticsManager.surgeEvent().surgeCancel(localVehicleView.getSurge().getFareId(), localVehicleView.getId(), localVehicleView.getSurge().getMultiplier());
  }

  private void sendSurgeDisplayEvent()
  {
    VehicleView localVehicleView = getVehicleView();
    if (localVehicleView == null)
      return;
    this.mAnalyticsManager.surgeEvent().surgeDisplay(localVehicleView.getSurge().getFareId(), localVehicleView.getId(), localVehicleView.getSurge().getMultiplier());
  }

  private void sendSurgeTimeoutEvent()
  {
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.SURGE_TIMEOUT);
    VehicleView localVehicleView = getVehicleView();
    if (localVehicleView == null)
      return;
    this.mAnalyticsManager.surgeEvent().surgeTimeout(localVehicleView.getSurge().getFareId(), localVehicleView.getId(), localVehicleView.getSurge().getMultiplier());
  }

  private boolean showSurgeSobriety()
  {
    return getIntent().getBooleanExtra("com.ubercab.SHOW_SOBRIETY", false);
  }

  public void onBackPressed()
  {
    if ((SurgeFragment)findFragment(SurgeFragment.class) != null)
    {
      this.mSobrietyScreenShown = false;
      sendSurgeCancelEvent();
    }
    super.onBackPressed();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903190);
    this.mCurrentVehicleViewId = getIntent().getStringExtra("com.ubercab.SELECTED_VEHICLE_VIEW");
    putSurgeFragment();
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if ((paramMenuItem.getItemId() == 16908332) && ((SurgeFragment)findFragment(SurgeFragment.class) != null))
    {
      if (getFragmentManager().getBackStackEntryCount() > 0)
      {
        getFragmentManager().popBackStack();
        this.mSobrietyScreenShown = false;
        return true;
      }
      sendSurgeCancelEvent();
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }

  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    this.mCurrentVehicleViewId = paramBundle.getString("com.ubercab.BUNDLE_VEHICLE_VIEW_ID", null);
  }

  public void onResume()
  {
    super.onResume();
    getActionBar().setTitle(getString(2131559096));
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putString("com.ubercab.BUNDLE_VEHICLE_VIEW_ID", this.mCurrentVehicleViewId);
  }

  @Subscribe
  public void onScheduleSurgeDropNotificationResponseEvent(ScheduleSurgeDropNotificationResponseEvent paramScheduleSurgeDropNotificationResponseEvent)
  {
    hideLoadingDialog();
    VehicleView localVehicleView = getVehicleView();
    if (localVehicleView == null)
      return;
    if (paramScheduleSurgeDropNotificationResponseEvent.isSuccess())
    {
      DropNotification localDropNotification = localVehicleView.getSurge().getDropNotification();
      int i = 0;
      if (localDropNotification != null)
        i = (int)localDropNotification.getDefaultExpirationTimeInMinutes();
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(i);
      showToast(getString(2131559093, arrayOfObject));
      this.mAnalyticsManager.surgeEvent().surgeNotifySuccess();
    }
    while (true)
    {
      setResult(0);
      finish();
      return;
      showToast(paramScheduleSurgeDropNotificationResponseEvent.getErrorMessage(this));
      this.mAnalyticsManager.surgeEvent().surgeNotifyFailure();
    }
  }

  @Subscribe
  public void onSurgeAcceptedEvent(SurgeAcceptedEvent paramSurgeAcceptedEvent)
  {
    if ((showSurgeSobriety()) && (!this.mSobrietyScreenShown))
    {
      pushSurgeSobrietyFragment();
      return;
    }
    sendSurgeAcceptEvent();
    finishSuccess(paramSurgeAcceptedEvent.getFareId());
  }

  @Subscribe
  public void onSurgeCancelledEvent(SurgeCancelledEvent paramSurgeCancelledEvent)
  {
    sendSurgeCancelEvent();
    setResult(0);
    finish();
  }

  @Subscribe
  public void onSurgeConfirmNotificationEvent(SurgeConfirmNotificationEvent paramSurgeConfirmNotificationEvent)
  {
    VehicleView localVehicleView = getVehicleView();
    if (localVehicleView == null)
      return;
    int i = Integer.valueOf(localVehicleView.getId()).intValue();
    CnLocation localCnLocation = this.mLocationProvider.getPinLocation().getCnLocation();
    this.mRiderClient.scheduleSurgeDropNotification(paramSurgeConfirmNotificationEvent.getFareId(), i, localCnLocation);
    showLoadingDialogSticky(getString(2131559095), null);
    this.mAnalyticsManager.surgeEvent().surgeNotifyConfirm();
  }

  @Subscribe
  public void onSurgeExpiredEvent(SurgeExpiredEvent paramSurgeExpiredEvent)
  {
    sendSurgeTimeoutEvent();
    setResult(0);
    finish();
  }

  @Subscribe
  public void onSurgeSobrietyFailedEvent(SurgeSobrietyFailEvent paramSurgeSobrietyFailEvent)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Float.valueOf(paramSurgeSobrietyFailEvent.getMultiplier());
    MessageDialogFragment.show(this, 1010, null, getString(2131559105, arrayOfObject));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.surge.SurgeActivity
 * JD-Core Version:    0.6.2
 */