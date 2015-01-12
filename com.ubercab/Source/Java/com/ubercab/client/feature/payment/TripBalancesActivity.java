package com.ubercab.client.feature.payment;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.MenuItem;
import com.ubercab.client.core.app.RiderPublicActivity;

public class TripBalancesActivity extends RiderPublicActivity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903150);
    getActionBar().setDisplayHomeAsUpEnabled(true);
    putFragment(2131427653, TripBalancesFragment.newInstance(), true);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
    {
      finish();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.TripBalancesActivity
 * JD-Core Version:    0.6.2
 */