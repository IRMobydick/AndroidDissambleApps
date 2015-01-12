package com.inauth.mme.logs;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.google.gson.Gson;
import com.inauth.mme.InAuthManager;
import com.inauth.mme.beans.BatteryInfoBean;
import com.inauth.mme.header.LogHeader;
import com.inauth.mme.response.LogResponse;
import com.inauth.utilities.InAuthUtilities;

public class BatteryInfoLog
{
  private String parseHealth(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "BATTERY_HEALTH_UNKNOWN";
    case 1:
      return "BATTERY_HEALTH_UNKNOWN";
    case 2:
      return "BATTERY_HEALTH_GOOD";
    case 3:
      return "BATTERY_HEALTH_OVERHEAT";
    case 4:
      return "BATTERY_HEALTH_DEAD";
    case 5:
      return "BATTERY_HEALTH_OVER_VOLTAGE";
    case 6:
    }
    return "BATTERY_HEALTH_UNSPECIFIED_FAILURE";
  }

  private String parsePlugged(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "BATTERY_NOT_PLUGGED";
    case 1:
      return "BATTERY_PLUGGED_AC";
    case 2:
    }
    return "BATTERY_PLUGGED_USB";
  }

  private String parseStatus(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "BATTERY_STATUS_UNKNOWN";
    case 1:
      return "BATTERY_STATUS_UNKNOWN";
    case 2:
      return "BATTERY_STATUS_CHARGING";
    case 3:
      return "BATTERY_STATUS_DISCHARGING";
    case 4:
      return "BATTERY_STATUS_NOT_CHARGING";
    case 5:
    }
    return "BATTERY_STATUS_FULL";
  }

  public LogResponse deserialize(String paramString)
  {
    return (LogResponse)new Gson().fromJson(paramString, LogResponse.class);
  }

  public String serialize(Application paramApplication, String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = paramApplication.getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    int i = localIntent.getIntExtra("health", 0);
    int j = localIntent.getIntExtra("level", 0);
    int k = localIntent.getIntExtra("plugged", 0);
    boolean bool = localIntent.getExtras().getBoolean("present");
    int m = localIntent.getIntExtra("scale", 0);
    int n = localIntent.getIntExtra("status", 0);
    String str = localIntent.getExtras().getString("technology");
    int i1 = localIntent.getIntExtra("temperature", 0);
    int i2 = localIntent.getIntExtra("voltage", 0);
    LogHeader localLogHeader = new LogHeader();
    localLogHeader.setAccountGUID(paramString2);
    localLogHeader.setDeviceGUID(paramString1);
    localLogHeader.setDynamicID(InAuthManager.getInstance().getInAuthDynamicID());
    localLogHeader.setTransaction_id(paramString3);
    localLogHeader.setSDKVersion(InAuthManager.getInstance().getSDKVersion());
    localLogHeader.setType("battery_info_logs");
    BatteryInfoBean localBatteryInfoBean = new BatteryInfoBean();
    localBatteryInfoBean.setHealth(parseHealth(i));
    localBatteryInfoBean.setLevel(Integer.toString(j));
    localBatteryInfoBean.setPlugged(parsePlugged(k));
    localBatteryInfoBean.setPresent(Boolean.toString(bool));
    localBatteryInfoBean.setScale(Integer.toString(m));
    localBatteryInfoBean.setStatus(parseStatus(n));
    localBatteryInfoBean.setTechnology(str);
    localBatteryInfoBean.setTechnology(Integer.toString(i1));
    localBatteryInfoBean.setVoltage(Integer.toString(i2));
    localBatteryInfoBean.setChecked_at(InAuthUtilities.GetIsoDateTime());
    localLogHeader.addLogs(localBatteryInfoBean);
    return new Gson().toJson(localLogHeader);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.mme.logs.BatteryInfoLog
 * JD-Core Version:    0.6.2
 */