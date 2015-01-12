package com.inauth.mme.logs;

import android.app.Application;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.google.gson.Gson;
import com.inauth.mme.InAuthManager;
import com.inauth.mme.beans.WifiConnectionBean;
import com.inauth.mme.header.LogHeader;
import com.inauth.mme.response.LogResponse;
import com.inauth.utilities.InAuthUtilities;

public class WifiConnectionLog
{
  private static String intToIp(int paramInt)
  {
    return (paramInt & 0xFF) + "." + (0xFF & paramInt >> 8) + "." + (0xFF & paramInt >> 16) + "." + (0xFF & paramInt >> 24);
  }

  public LogResponse deserialize(String paramString)
  {
    return (LogResponse)new Gson().fromJson(paramString, LogResponse.class);
  }

  public String serialize(Application paramApplication, String paramString1, String paramString2, String paramString3)
  {
    WifiInfo localWifiInfo = ((WifiManager)paramApplication.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
    LogHeader localLogHeader = new LogHeader();
    localLogHeader.setAccountGUID(paramString2);
    localLogHeader.setDeviceGUID(paramString1);
    localLogHeader.setDynamicID(InAuthManager.getInstance().getInAuthDynamicID());
    localLogHeader.setTransaction_id(paramString3);
    localLogHeader.setSDKVersion(InAuthManager.getInstance().getSDKVersion());
    localLogHeader.setType("wifi_connection_logs");
    WifiConnectionBean localWifiConnectionBean = new WifiConnectionBean();
    localWifiConnectionBean.setBssid(localWifiInfo.getBSSID());
    localWifiConnectionBean.setIp(intToIp(localWifiInfo.getIpAddress()));
    localWifiConnectionBean.setLinkspeed(Integer.toString(localWifiInfo.getLinkSpeed()));
    localWifiConnectionBean.setMacaddr(localWifiInfo.getMacAddress());
    localWifiConnectionBean.setNetworkID(Integer.toString(localWifiInfo.getNetworkId()));
    localWifiConnectionBean.setRssi(Integer.toString(localWifiInfo.getRssi()));
    localWifiConnectionBean.setSsid(localWifiInfo.getSSID());
    localWifiConnectionBean.setChecked_at(InAuthUtilities.GetIsoDateTime());
    localLogHeader.addLogs(localWifiConnectionBean);
    return new Gson().toJson(localLogHeader);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.mme.logs.WifiConnectionLog
 * JD-Core Version:    0.6.2
 */