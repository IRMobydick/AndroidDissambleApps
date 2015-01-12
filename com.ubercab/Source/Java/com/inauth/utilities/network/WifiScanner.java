package com.inauth.utilities.network;

import android.app.Application;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import java.util.List;

public class WifiScanner
{
  private WifiManager wifi;
  boolean wifiDisabled;

  public WifiScanner(Application paramApplication)
  {
    setWasWifiDisabled(false);
    setWifiManager((WifiManager)paramApplication.getApplicationContext().getSystemService("wifi"));
    if (!getWifi().isWifiEnabled())
    {
      getWifi().setWifiEnabled(true);
      setWasWifiDisabled(true);
    }
    getWifi().startScan();
  }

  public List<ScanResult> getResults()
  {
    List localList = getWifi().getScanResults();
    if (localList != null)
      return localList;
    return null;
  }

  public WifiManager getWifi()
  {
    return this.wifi;
  }

  public void setWasWifiDisabled(boolean paramBoolean)
  {
    this.wifiDisabled = paramBoolean;
  }

  public void setWifiManager(WifiManager paramWifiManager)
  {
    this.wifi = paramWifiManager;
  }

  public boolean wasWifiDisabled()
  {
    return this.wifiDisabled;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.utilities.network.WifiScanner
 * JD-Core Version:    0.6.2
 */