package com.ubercab.client.feature.search;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.app.RiderPingActivity;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.location.RiderLocation;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Tap;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.feature.search.event.AddFavoriteLocationEvent;
import com.ubercab.client.feature.search.event.EditFavoriteLocationEvent;
import com.ubercab.client.feature.search.event.LocationSelectedEvent;
import com.ubercab.client.feature.search.event.LocationSkippedEvent;
import com.ubercab.client.feature.search.event.RemoveFavoriteLocationEvent;
import com.ubercab.client.feature.search.event.SelectFavoriteLocationEvent;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import com.ubercab.library.metrics.analytics.event.TapEventName;
import com.ubercab.library.ui.ConfirmDialogFragment;
import javax.inject.Inject;
import timber.log.Timber;

public class LocationSearchActivity extends RiderPingActivity
{
  public static final String EXTRA_ACTION_BAR_TITLE = "com.ubercab.ACTION_BAR_TITLE";
  public static final String EXTRA_LOCATION = "com.ubercab.LOCATION";
  public static final String EXTRA_LOCATION_DESTINATION = "com.ubercab.LOCATION_DESTINATION";
  public static final String EXTRA_LOCATION_PICKUP = "com.ubercab.LOCATION_PICKUP";
  public static final String EXTRA_LOCATION_TAG = "com.ubercab.LOCATION_TAG";
  public static final String EXTRA_SHOW_RATES = "com.ubercab.SHOW_RATES";
  public static final String EXTRA_VEHICLE_VIEW_ID = "com.ubercab.VEHICLE_VIEW_ID";
  private static final int REQUEST_CODE_CONFIRM_CHANGE_DESTINATION = 6001;
  public static final int RESULT_SKIPPED = 1;

  @Inject
  AnalyticsClient mAnalyticsClient;

  @Inject
  PingProvider mPingProvider;

  private Fragment getSearchFragment(String paramString)
  {
    Intent localIntent = getIntent();
    return LocationSearchFragment.newInstance(paramString, (RiderLocation)localIntent.getParcelableExtra("com.ubercab.LOCATION_PICKUP"), (RiderLocation)localIntent.getParcelableExtra("com.ubercab.LOCATION_DESTINATION"), localIntent.getStringExtra("com.ubercab.VEHICLE_VIEW_ID"), localIntent.getStringExtra("com.ubercab.ACTION_BAR_TITLE"), localIntent.getBooleanExtra("com.ubercab.SHOW_RATES", false));
  }

  public static Intent newIntent(Context paramContext, String paramString, RiderLocation paramRiderLocation1, RiderLocation paramRiderLocation2)
  {
    return newIntent(paramContext, paramString, paramRiderLocation1, paramRiderLocation2, null, null, false);
  }

  public static Intent newIntent(Context paramContext, String paramString1, RiderLocation paramRiderLocation1, RiderLocation paramRiderLocation2, String paramString2, String paramString3, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramContext, LocationSearchActivity.class);
    localIntent.putExtra("com.ubercab.ACTION_BAR_TITLE", paramString3);
    localIntent.putExtra("com.ubercab.LOCATION_PICKUP", paramRiderLocation1);
    localIntent.putExtra("com.ubercab.LOCATION_DESTINATION", paramRiderLocation2);
    localIntent.putExtra("com.ubercab.SHOW_RATES", paramBoolean);
    localIntent.putExtra("com.ubercab.VEHICLE_VIEW_ID", paramString2);
    localIntent.setAction(paramString1);
    return localIntent;
  }

  private void putSearchFragment()
  {
    if (findFragment(LocationSearchFragment.class) == null)
      putFragment(2131427489, getSearchFragment(getIntent().getAction()), true);
  }

  private void putSearchFragmentForFavoriteLocation(String paramString, boolean paramBoolean)
  {
    if (paramBoolean);
    for (String str = "com.ubercab.ACTION_ADD_FAVORITE_LOCATION"; ; str = "com.ubercab.ACTION_EDIT_FAVORITE_LOCATION")
    {
      pushFragment(2131427489, LocationSearchFragment.newInstance(str, paramString, (RiderLocation)getIntent().getParcelableExtra("com.ubercab.LOCATION_PICKUP")), true);
      return;
    }
  }

  private void sendLocationSearchDismissedAnalytics()
  {
    if (getIntent() == null);
    for (String str = null; str == null; str = getIntent().getAction())
    {
      Timber.w("Null action", new Object[0]);
      return;
    }
    int i = -1;
    Object localObject;
    switch (str.hashCode())
    {
    default:
      switch (i)
      {
      default:
        Timber.w("Not tracking action: %s", new Object[] { str });
        localObject = null;
      case 0:
      case 1:
      case 2:
      }
      break;
    case -669628160:
    case 1712228054:
    case 458188937:
    }
    while (true)
    {
      this.mAnalyticsClient.sendTapEvent((TapEventName)localObject);
      return;
      if (!str.equals("com.ubercab.ACTION_PICKUP_LOCATION"))
        break;
      i = 0;
      break;
      if (!str.equals("com.ubercab.ACTION_DESTINATION"))
        break;
      i = 1;
      break;
      if (!str.equals("com.ubercab.ACTION_DESTINATION_ETA"))
        break;
      i = 2;
      break;
      localObject = RiderEvents.Tap.SEARCH_PICKUP_CANCEL;
      continue;
      localObject = RiderEvents.Tap.SEARCH_DROPOFF_CANCEL;
    }
  }

  private void showLocationChangeDialog(RiderLocation paramRiderLocation)
  {
    String str1 = getString(2131558475);
    String str2 = getString(2131558474);
    String str3 = getString(2131558973);
    String str4 = getString(2131558467);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("com.ubercab.LOCATION", paramRiderLocation);
    ConfirmDialogFragment.show(this, 6001, str1, str2, str3, str4, localBundle);
  }

  private void showNoAddressDialog()
  {
    ConfirmDialogFragment.show(this, 0, null, getString(2131558910), getString(2131558973), null, null);
  }

  @Subscribe
  public void onAddFavoriteLocationEvent(AddFavoriteLocationEvent paramAddFavoriteLocationEvent)
  {
    putSearchFragmentForFavoriteLocation(paramAddFavoriteLocationEvent.getTag(), true);
  }

  public void onBackPressed()
  {
    sendLocationSearchDismissedAnalytics();
    super.onBackPressed();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903095);
    putSearchFragment();
  }

  public void onDialogResult(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    super.onDialogResult(paramInt1, paramInt2, paramBundle);
    if ((paramInt1 == 6001) && (paramInt2 == -1))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("com.ubercab.LOCATION", paramBundle.getParcelable("com.ubercab.LOCATION"));
      setResult(-1, localIntent);
      finish();
    }
  }

  @Subscribe
  public void onEditFavoriteLocationEvent(EditFavoriteLocationEvent paramEditFavoriteLocationEvent)
  {
    putSearchFragmentForFavoriteLocation(paramEditFavoriteLocationEvent.getTag(), false);
  }

  @Subscribe
  public void onLocationSelectedEvent(LocationSelectedEvent paramLocationSelectedEvent)
  {
    Ping localPing = this.mPingProvider.get();
    String str = localPing.getClient().getStatus();
    if (("WaitingForPickup".equals(str)) || ("OnTrip".equals(str)));
    for (int i = 1; (i != 0) && (PingUtils.hasTripDestination(localPing)); i = 0)
    {
      showLocationChangeDialog(paramLocationSelectedEvent.getLocation());
      return;
    }
    if (paramLocationSelectedEvent.getLocation().getUberLatLng() == null)
    {
      showNoAddressDialog();
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("com.ubercab.LOCATION", paramLocationSelectedEvent.getLocation());
    setResult(-1, localIntent);
    finish();
  }

  @Subscribe
  public void onLocationSkippedEvent(LocationSkippedEvent paramLocationSkippedEvent)
  {
    setResult(1);
    finish();
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
    {
      setResult(0);
      finish();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }

  @Subscribe
  public void onRemoveFavoriteLocationEvent(RemoveFavoriteLocationEvent paramRemoveFavoriteLocationEvent)
  {
    popFragment();
  }

  @Subscribe
  public void onSelectFavoriteLocationEvent(SelectFavoriteLocationEvent paramSelectFavoriteLocationEvent)
  {
    popFragment();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.search.LocationSearchActivity
 * JD-Core Version:    0.6.2
 */