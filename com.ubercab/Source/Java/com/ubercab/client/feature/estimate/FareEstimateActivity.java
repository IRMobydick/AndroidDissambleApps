package com.ubercab.client.feature.estimate;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.analytics.event.TripEvent;
import com.ubercab.client.core.app.RiderPingActivity;
import com.ubercab.client.core.content.RiderLocationProvider;
import com.ubercab.client.core.location.RiderLocation;
import com.ubercab.client.feature.estimate.event.DestinationSelectEvent;
import com.ubercab.client.feature.estimate.event.PickupSelectEvent;
import com.ubercab.client.feature.search.LocationSearchActivity;
import javax.inject.Inject;

public class FareEstimateActivity extends RiderPingActivity
{
  public static final String EXTRA_CURRENCY_TO_POINTS_RATIO = "com.ubercab.CURRENCY_TO_POINTS_RATIO";
  public static final String EXTRA_FARE_ID = "com.ubercab.FARE_ID";
  public static final String EXTRA_LOCATION_DESTINATION = "com.ubercab.LOCATION_DESTINATION";
  private static final int REQUEST_CODE_SEARCH_DESTINATION = 2010;
  private static final int REQUEST_CODE_SEARCH_PICKUP = 2009;

  @Inject
  AnalyticsManager mAnalyticsManager;
  private Float mCurrencyToPointsRatio;
  private RiderLocation mDestinationLocation;
  private long mFareId;

  @Inject
  RiderLocationProvider mLocationProvider;

  private void startDestinationLocationSearchActivity()
  {
    this.mAnalyticsManager.tripEvent().setAppContext("fareQuote");
    startActivityForResult(LocationSearchActivity.newIntent(this, "com.ubercab.ACTION_DESTINATION", this.mLocationProvider.getPinLocation(), this.mDestinationLocation), 2010);
  }

  private void startPickupLocationSearchActivity()
  {
    this.mAnalyticsManager.tripEvent().setAppContext("fareQuote");
    startActivityForResult(LocationSearchActivity.newIntent(this, "com.ubercab.ACTION_PICKUP_LOCATION", this.mLocationProvider.getPinLocation(), this.mDestinationLocation), 2009);
  }

  private void updateFragment()
  {
    RiderLocation localRiderLocation = this.mLocationProvider.getPinLocation();
    FareEstimateFragment localFareEstimateFragment = (FareEstimateFragment)findFragment(FareEstimateFragment.class);
    if (localFareEstimateFragment == null)
    {
      putFragment(2131427434, FareEstimateFragment.newInstance(localRiderLocation, this.mDestinationLocation, this.mFareId, this.mCurrencyToPointsRatio), true);
      return;
    }
    localFareEstimateFragment.update(localRiderLocation, this.mDestinationLocation);
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == 0) && (this.mDestinationLocation == null))
      finish();
    do
    {
      return;
      if ((paramInt1 == 2009) && (paramInt2 == -1))
      {
        RiderLocation localRiderLocation = (RiderLocation)paramIntent.getParcelableExtra("com.ubercab.LOCATION");
        this.mLocationProvider.updatePinLocation(localRiderLocation);
        setResult(-1, getIntent());
        return;
      }
    }
    while ((paramInt1 != 2010) || (paramInt2 != -1));
    this.mDestinationLocation = ((RiderLocation)paramIntent.getParcelableExtra("com.ubercab.LOCATION"));
    Intent localIntent = getIntent();
    localIntent.putExtra("com.ubercab.LOCATION_DESTINATION", this.mDestinationLocation);
    setResult(-1, localIntent);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903077);
    getActionBar().setDisplayHomeAsUpEnabled(true);
    if (paramBundle == null)
    {
      this.mCurrencyToPointsRatio = Float.valueOf(getIntent().getFloatExtra("com.ubercab.CURRENCY_TO_POINTS_RATIO", 0.0F));
      this.mFareId = getIntent().getLongExtra("com.ubercab.FARE_ID", 0L);
      this.mDestinationLocation = ((RiderLocation)getIntent().getParcelableExtra("com.ubercab.LOCATION_DESTINATION"));
    }
  }

  @Subscribe
  public void onDestinationChangeEvent(DestinationSelectEvent paramDestinationSelectEvent)
  {
    startDestinationLocationSearchActivity();
  }

  @Subscribe
  public void onPickupChangeEvent(PickupSelectEvent paramPickupSelectEvent)
  {
    startPickupLocationSearchActivity();
  }

  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    this.mCurrencyToPointsRatio = Float.valueOf(paramBundle.getFloat("com.ubercab.CURRENCY_TO_POINTS_RATIO", 0.0F));
    this.mFareId = paramBundle.getLong("com.ubercab.FARE_ID");
    this.mDestinationLocation = ((RiderLocation)paramBundle.getParcelable("com.ubercab.LOCATION_DESTINATION"));
  }

  public void onResume()
  {
    super.onResume();
    if (isFinishing())
      return;
    if (this.mDestinationLocation == null)
    {
      startDestinationLocationSearchActivity();
      return;
    }
    updateFragment();
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putFloat("com.ubercab.CURRENCY_TO_POINTS_RATIO", this.mCurrencyToPointsRatio.floatValue());
    paramBundle.putParcelable("com.ubercab.LOCATION_DESTINATION", this.mDestinationLocation);
    paramBundle.putLong("com.ubercab.FARE_ID", this.mFareId);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.estimate.FareEstimateActivity
 * JD-Core Version:    0.6.2
 */