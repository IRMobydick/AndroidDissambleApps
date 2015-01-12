package com.ubercab.client.feature.employee;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.app.RiderPublicActivity;
import com.ubercab.client.core.app.event.SignoutEvent;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.RiderLocationProvider;
import com.ubercab.client.core.model.UnpaidBill;
import com.ubercab.client.feature.employee.event.PreferenceChangedEvent;
import com.ubercab.client.feature.employee.event.ShowFakeArrearsEvent;
import com.ubercab.client.feature.employee.event.ShowFakeLocationSearchEvent;
import com.ubercab.client.feature.employee.event.ShowFakeSmsVerificationEvent;
import com.ubercab.client.feature.employee.event.ShowFakeTokenVerificationEvent;
import com.ubercab.client.feature.employee.event.ShowFakeTripPendingRatingEvent;
import com.ubercab.client.feature.launch.LauncherActivity;
import com.ubercab.client.feature.payment.PaymentFragment;
import com.ubercab.client.feature.receipt.ReceiptFragment;
import com.ubercab.client.feature.search.LocationSearchFragment;
import com.ubercab.client.feature.search.event.LocationSelectedEvent;
import com.ubercab.client.feature.verification.MobileVerificationSmsFragment;
import com.ubercab.client.feature.verification.MobileVerificationTokenFragment;
import java.util.ArrayList;
import javax.inject.Inject;

public class EmployeeSettingsActivity extends RiderPublicActivity
{
  private static final String BUNDLE_PREFERENCES_CHANGED = "preferences_changed";
  private boolean mHasPreferencesChanged;

  @Inject
  RiderLocationProvider mLocationProvider;

  @Inject
  PingProvider mPingProvider;

  private void pushLocationSearchFragment()
  {
    if (findFragment(LocationSearchFragment.class) == null)
      pushFragment(2131427429, LocationSearchFragment.newInstance("com.ubercab.ACTION_PICKUP_LOCATION", null, null, null, null, false), true);
  }

  private void putEmployeeFragment()
  {
    if (findFragment(EmployeeSettingsFragment.class) == null)
      putFragment(2131427429, EmployeeSettingsFragment.newInstance(), true);
  }

  public void onBackPressed()
  {
    if (this.mHasPreferencesChanged)
    {
      this.mPingProvider.clear();
      this.mLocationProvider.clear();
      Intent localIntent = new Intent(this, LauncherActivity.class);
      localIntent.addFlags(268468224);
      startActivity(localIntent);
      finish();
      return;
    }
    super.onBackPressed();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903075);
    putEmployeeFragment();
  }

  @Subscribe
  public void onLocationSelectedEvent(LocationSelectedEvent paramLocationSelectedEvent)
  {
    ((EmployeeSettingsFragment)findFragment(EmployeeSettingsFragment.class)).onPreferenceChangedFakeLocation(paramLocationSelectedEvent.getLocation());
    getFragmentManager().popBackStack();
  }

  @Subscribe
  public void onPreferenceChangedEvent(PreferenceChangedEvent paramPreferenceChangedEvent)
  {
    this.mHasPreferencesChanged = true;
  }

  public void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    this.mHasPreferencesChanged = paramBundle.getBoolean("preferences_changed");
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("preferences_changed", this.mHasPreferencesChanged);
  }

  @Subscribe
  public void onShowFakeArrearsEvent(ShowFakeArrearsEvent paramShowFakeArrearsEvent)
  {
    if (findFragment(PaymentFragment.class) == null)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new UnpaidBill());
      pushFragment(2131427429, PaymentFragment.newArrearsInstance(null, localArrayList), true);
    }
  }

  @Subscribe
  public void onShowFakeLocationSearchEvent(ShowFakeLocationSearchEvent paramShowFakeLocationSearchEvent)
  {
    pushLocationSearchFragment();
  }

  @Subscribe
  public void onShowFakeSmsVerificationEvent(ShowFakeSmsVerificationEvent paramShowFakeSmsVerificationEvent)
  {
    if (findFragment(MobileVerificationSmsFragment.class) == null)
      pushFragment(2131427429, MobileVerificationSmsFragment.newInstance(), true);
  }

  @Subscribe
  public void onShowFakeTokenVerificationEvent(ShowFakeTokenVerificationEvent paramShowFakeTokenVerificationEvent)
  {
    if (findFragment(MobileVerificationTokenFragment.class) == null)
      pushFragment(2131427429, MobileVerificationTokenFragment.newInstance(), true);
  }

  @Subscribe
  public void onShowFakeTripPendingRatingEvent(ShowFakeTripPendingRatingEvent paramShowFakeTripPendingRatingEvent)
  {
    if (findFragment(ReceiptFragment.class) == null)
      putFragment(2131427429, ReceiptFragment.newInstance(paramShowFakeTripPendingRatingEvent.getTripPendingRating()), true);
  }

  @Subscribe
  public void onSignoutEvent(SignoutEvent paramSignoutEvent)
  {
    startLauncherActivityAndClearTask();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.employee.EmployeeSettingsActivity
 * JD-Core Version:    0.6.2
 */