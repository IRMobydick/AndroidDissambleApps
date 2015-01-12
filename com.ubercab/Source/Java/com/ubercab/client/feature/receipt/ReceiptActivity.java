package com.ubercab.client.feature.receipt;

import android.os.Bundle;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.app.RiderPingActivity;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.event.PingEvent;
import com.ubercab.client.core.util.PingUtils;
import javax.inject.Inject;

public class ReceiptActivity extends RiderPingActivity
{

  @Inject
  PingProvider mPingProvider;

  private void putReceiptFragment()
  {
    if (findFragment(ReceiptFragment.class) == null)
      putFragment(2131427676, ReceiptFragment.newInstance(), true);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903161);
    if (!PingUtils.hasTripPendingRating(this.mPingProvider.get()))
    {
      setResult(-1);
      finish();
      return;
    }
    putReceiptFragment();
  }

  @Subscribe
  public void onPingEvent(PingEvent paramPingEvent)
  {
    if (!PingUtils.hasTripPendingRating(paramPingEvent.getPing()))
    {
      setResult(-1);
      finish();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.receipt.ReceiptActivity
 * JD-Core Version:    0.6.2
 */