package com.inauth.mme.logs;

import android.app.Application;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import com.google.gson.Gson;
import com.inauth.mme.InAuthManager;
import com.inauth.mme.beans.WifiNeighborBean;
import com.inauth.mme.header.LogHeader;
import com.inauth.mme.response.LogResponse;
import com.inauth.utilities.InAuthUtilities;
import com.inauth.utilities.network.WifiScanner;
import java.util.List;

public class WifiNeighborLog
{
  public LogResponse deserialize(String paramString)
  {
    return (LogResponse)new Gson().fromJson(paramString, LogResponse.class);
  }

  public String serialize(Application paramApplication, String paramString1, String paramString2, String paramString3)
  {
    WifiScanner localWifiScanner = new WifiScanner(paramApplication);
    List localList = localWifiScanner.getResults();
    LogHeader localLogHeader = new LogHeader();
    localLogHeader.setAccountGUID(paramString2);
    localLogHeader.setDeviceGUID(paramString1);
    localLogHeader.setDynamicID(InAuthManager.getInstance().getInAuthDynamicID());
    localLogHeader.setTransaction_id(paramString3);
    localLogHeader.setSDKVersion(InAuthManager.getInstance().getSDKVersion());
    localLogHeader.setType("wifi_neighbor_logs");
    if (localList != null)
    {
      for (int i = 0; i < localList.size(); i++)
      {
        WifiNeighborBean localWifiNeighborBean = new WifiNeighborBean();
        localWifiNeighborBean.setBssid(((ScanResult)localList.get(i)).BSSID);
        localWifiNeighborBean.setSsid(((ScanResult)localList.get(i)).SSID);
        localWifiNeighborBean.setCapabilities(((ScanResult)localList.get(i)).capabilities);
        localWifiNeighborBean.setFrequency(Integer.toString(((ScanResult)localList.get(i)).frequency));
        localWifiNeighborBean.setLevel(Integer.toString(((ScanResult)localList.get(i)).level));
        localWifiNeighborBean.setChecked_at(InAuthUtilities.GetIsoDateTime());
        localLogHeader.addLogs(localWifiNeighborBean);
      }
      if (localWifiScanner.wasWifiDisabled())
      {
        localWifiScanner.getWifi().setWifiEnabled(false);
        localWifiScanner.setWasWifiDisabled(false);
      }
    }
    return new Gson().toJson(localLogHeader);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.mme.logs.WifiNeighborLog
 * JD-Core Version:    0.6.2
 */