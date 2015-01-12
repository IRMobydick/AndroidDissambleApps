package com.ubercab.client.core.app;

import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.SessionPreferences;
import javax.inject.Inject;

public abstract class RiderPingActivity extends RiderActivity
{

  @Inject
  PingProvider mPingProvider;

  @Inject
  SessionPreferences mSessionPreferences;

  public void checkForExpiredPing()
  {
    if (!this.mPingProvider.isExpired())
      return;
    this.mPingProvider.clear();
    startLauncherActivityAndClearTask();
  }

  public void checkForExpiredSession()
  {
    if (this.mSessionPreferences.hasToken())
      return;
    this.mSessionPreferences.clear();
    startLauncherActivityAndClearTask();
  }

  public void onResume()
  {
    super.onResume();
    checkForExpiredPing();
    checkForExpiredSession();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.app.RiderPingActivity
 * JD-Core Version:    0.6.2
 */