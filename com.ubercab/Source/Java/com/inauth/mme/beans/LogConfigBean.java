package com.inauth.mme.beans;

public class LogConfigBean
{
  private boolean accelerometer_logs;
  private String account_type;
  private boolean android_accounts_logs;
  private boolean app_activity_history_logs;
  private boolean app_data_usage_logs;
  private boolean app_installs_logs;
  private boolean battery_info_logs;
  private boolean device_info_logs;
  private boolean gps_location_logs;
  private boolean malware_info_logs;
  private boolean mms_logs;
  private boolean net_data_usage_logs;
  private boolean phone_calls_logs;
  private boolean root_check_logs;
  private boolean sms_logs;
  private boolean telephony_info_logs;
  private boolean wifi_connection_logs;
  private boolean wifi_neighbor_logs;

  public LogConfigBean()
  {
    setAccountType("full");
    setAccelerometer(false);
    setAccounts(false);
    setAppActivity(false);
    setAppDataUsage(false);
    setAppInstall(false);
    setBattery(false);
    setDevice(false);
    setGPS(false);
    setMalware(false);
    setMMS(false);
    setNetData(false);
    setPhone(false);
    setRoot(false);
    setSMS(false);
    setTelephony(false);
    setWifiConnected(false);
    setWifiNeighbor(false);
  }

  public boolean getAccelerometer_logs()
  {
    return this.accelerometer_logs;
  }

  public String getAccountType()
  {
    return this.account_type;
  }

  public boolean getAndroid_accounts_logs()
  {
    return this.android_accounts_logs;
  }

  public boolean getApp_activity_history_logs()
  {
    return this.app_activity_history_logs;
  }

  public boolean getApp_data_usage_logs()
  {
    return this.app_data_usage_logs;
  }

  public boolean getApp_install_logs()
  {
    return this.app_installs_logs;
  }

  public boolean getBattery_info_logs()
  {
    return this.battery_info_logs;
  }

  public String getConfig()
  {
    return this.account_type + "," + this.accelerometer_logs + "," + this.android_accounts_logs + "," + this.app_activity_history_logs + "," + this.app_data_usage_logs + "," + this.app_installs_logs + "," + this.battery_info_logs + "," + this.device_info_logs + "," + this.gps_location_logs + "," + this.malware_info_logs + "," + this.mms_logs + "," + this.net_data_usage_logs + "," + this.phone_calls_logs + "," + this.root_check_logs + "," + this.sms_logs + "," + this.telephony_info_logs + "," + this.wifi_connection_logs + "," + this.wifi_neighbor_logs;
  }

  public boolean getDevice_info_logs()
  {
    return this.device_info_logs;
  }

  public boolean getGps_location_logs()
  {
    return this.gps_location_logs;
  }

  public boolean getMalware_info_logs()
  {
    return this.malware_info_logs;
  }

  public boolean getMms_logs()
  {
    return this.mms_logs;
  }

  public boolean getNet_data_usage_logs()
  {
    return this.net_data_usage_logs;
  }

  public boolean getPhone_calls_logs()
  {
    return this.phone_calls_logs;
  }

  public boolean getRoot_check_logs()
  {
    return this.root_check_logs;
  }

  public boolean getSms_logs()
  {
    return this.sms_logs;
  }

  public boolean getTelephony_info_logs()
  {
    return this.telephony_info_logs;
  }

  public boolean getWifi_connection_logs()
  {
    return this.wifi_connection_logs;
  }

  public boolean getWifi_neighbor_logs()
  {
    return this.wifi_neighbor_logs;
  }

  public void setAccelerometer(boolean paramBoolean)
  {
    this.accelerometer_logs = paramBoolean;
  }

  public void setAccountType(String paramString)
  {
    this.account_type = paramString;
  }

  public void setAccounts(boolean paramBoolean)
  {
    this.android_accounts_logs = paramBoolean;
  }

  public void setAppActivity(boolean paramBoolean)
  {
    this.app_activity_history_logs = paramBoolean;
  }

  public void setAppDataUsage(boolean paramBoolean)
  {
    this.app_data_usage_logs = paramBoolean;
  }

  public void setAppInstall(boolean paramBoolean)
  {
    this.app_installs_logs = paramBoolean;
  }

  public void setBattery(boolean paramBoolean)
  {
    this.battery_info_logs = paramBoolean;
  }

  public void setDevice(boolean paramBoolean)
  {
    this.device_info_logs = paramBoolean;
  }

  public void setGPS(boolean paramBoolean)
  {
    this.gps_location_logs = paramBoolean;
  }

  public void setMMS(boolean paramBoolean)
  {
    this.mms_logs = paramBoolean;
  }

  public void setMalware(boolean paramBoolean)
  {
    this.malware_info_logs = paramBoolean;
  }

  public void setNetData(boolean paramBoolean)
  {
    this.net_data_usage_logs = paramBoolean;
  }

  public void setPhone(boolean paramBoolean)
  {
    this.phone_calls_logs = paramBoolean;
  }

  public void setRoot(boolean paramBoolean)
  {
    this.root_check_logs = paramBoolean;
  }

  public void setSMS(boolean paramBoolean)
  {
    this.sms_logs = paramBoolean;
  }

  public void setTelephony(boolean paramBoolean)
  {
    this.telephony_info_logs = paramBoolean;
  }

  public void setWifiConnected(boolean paramBoolean)
  {
    this.wifi_connection_logs = paramBoolean;
  }

  public void setWifiNeighbor(boolean paramBoolean)
  {
    this.wifi_neighbor_logs = paramBoolean;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.mme.beans.LogConfigBean
 * JD-Core Version:    0.6.2
 */