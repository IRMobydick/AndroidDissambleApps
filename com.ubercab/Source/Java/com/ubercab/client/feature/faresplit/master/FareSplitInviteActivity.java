package com.ubercab.client.feature.faresplit.master;

import android.app.FragmentManager;
import android.os.Bundle;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.app.RiderPingActivity;
import com.ubercab.client.core.content.event.PingEvent;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.feature.faresplit.master.event.FareSplitInvitesSentEvent;

public class FareSplitInviteActivity extends RiderPingActivity
{
  private void putFareSplitInviteFragment()
  {
    if (findFragment(FareSplitInviteFragment.class) == null)
      putFragment(2131427452, new FareSplitInviteFragment(), true);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903083);
    if (getFragmentManager().findFragmentById(2131427452) == null)
      putFareSplitInviteFragment();
  }

  @Subscribe
  public void onFareSplitInvitesSentEvent(FareSplitInvitesSentEvent paramFareSplitInvitesSentEvent)
  {
    setResult(-1);
    finish();
  }

  @Subscribe
  public void onPingEvent(PingEvent paramPingEvent)
  {
    String str = paramPingEvent.getPing().getClient().getStatus();
    if ((!str.equals("OnTrip")) && (!str.equals("WaitingForPickup")))
    {
      setResult(0);
      finish();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.faresplit.master.FareSplitInviteActivity
 * JD-Core Version:    0.6.2
 */