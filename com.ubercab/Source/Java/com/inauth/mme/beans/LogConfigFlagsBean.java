package com.inauth.mme.beans;

import java.util.Arrays;
import java.util.List;

public class LogConfigFlagsBean
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

  public LogConfigFlagsBean(String paramString)
  {
    if (paramString == null)
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
      return;
    }
    List localList = Arrays.asList(paramString.split(","));
    try
    {
      setAccountType((String)localList.get(0));
    }
    catch (NullPointerException localNullPointerException16)
    {
      try
      {
        setAccelerometer(Boolean.parseBoolean((String)localList.get(1)));
      }
      catch (NullPointerException localNullPointerException16)
      {
        try
        {
          setAccounts(Boolean.parseBoolean((String)localList.get(2)));
        }
        catch (NullPointerException localNullPointerException16)
        {
          try
          {
            setAppActivity(Boolean.parseBoolean((String)localList.get(3)));
          }
          catch (NullPointerException localNullPointerException16)
          {
            try
            {
              setAppDataUsage(Boolean.parseBoolean((String)localList.get(4)));
            }
            catch (NullPointerException localNullPointerException16)
            {
              try
              {
                setAppInstall(Boolean.parseBoolean((String)localList.get(5)));
              }
              catch (NullPointerException localNullPointerException16)
              {
                try
                {
                  setBattery(Boolean.parseBoolean((String)localList.get(6)));
                }
                catch (NullPointerException localNullPointerException16)
                {
                  try
                  {
                    setDevice(Boolean.parseBoolean((String)localList.get(7)));
                  }
                  catch (NullPointerException localNullPointerException16)
                  {
                    try
                    {
                      setGPS(Boolean.parseBoolean((String)localList.get(8)));
                    }
                    catch (NullPointerException localNullPointerException16)
                    {
                      try
                      {
                        setMalware(Boolean.parseBoolean((String)localList.get(9)));
                      }
                      catch (NullPointerException localNullPointerException16)
                      {
                        try
                        {
                          setMMS(Boolean.parseBoolean((String)localList.get(10)));
                        }
                        catch (NullPointerException localNullPointerException16)
                        {
                          try
                          {
                            setNetData(Boolean.parseBoolean((String)localList.get(11)));
                          }
                          catch (NullPointerException localNullPointerException16)
                          {
                            try
                            {
                              setPhone(Boolean.parseBoolean((String)localList.get(12)));
                            }
                            catch (NullPointerException localNullPointerException16)
                            {
                              try
                              {
                                setRoot(Boolean.parseBoolean((String)localList.get(13)));
                              }
                              catch (NullPointerException localNullPointerException16)
                              {
                                try
                                {
                                  setSMS(Boolean.parseBoolean((String)localList.get(14)));
                                }
                                catch (NullPointerException localNullPointerException16)
                                {
                                  try
                                  {
                                    setTelephony(Boolean.parseBoolean((String)localList.get(15)));
                                  }
                                  catch (NullPointerException localNullPointerException16)
                                  {
                                    try
                                    {
                                      while (true)
                                      {
                                        setWifiConnected(Boolean.parseBoolean((String)localList.get(16)));
                                        try
                                        {
                                          setWifiNeighbor(Boolean.parseBoolean((String)localList.get(17)));
                                          return;
                                        }
                                        catch (NullPointerException localNullPointerException18)
                                        {
                                          setWifiNeighbor(false);
                                          return;
                                        }
                                        localNullPointerException1 = localNullPointerException1;
                                        setAccountType("full");
                                        continue;
                                        localNullPointerException2 = localNullPointerException2;
                                        setAccelerometer(false);
                                        continue;
                                        localNullPointerException3 = localNullPointerException3;
                                        setAccounts(false);
                                        continue;
                                        localNullPointerException4 = localNullPointerException4;
                                        setAppActivity(false);
                                        continue;
                                        localNullPointerException5 = localNullPointerException5;
                                        setAppDataUsage(false);
                                        continue;
                                        localNullPointerException6 = localNullPointerException6;
                                        setAppInstall(false);
                                        continue;
                                        localNullPointerException7 = localNullPointerException7;
                                        setBattery(false);
                                        continue;
                                        localNullPointerException8 = localNullPointerException8;
                                        setDevice(false);
                                        continue;
                                        localNullPointerException9 = localNullPointerException9;
                                        setGPS(false);
                                        continue;
                                        localNullPointerException10 = localNullPointerException10;
                                        setMalware(false);
                                        continue;
                                        localNullPointerException11 = localNullPointerException11;
                                        setMMS(false);
                                        continue;
                                        localNullPointerException12 = localNullPointerException12;
                                        setNetData(false);
                                        continue;
                                        localNullPointerException13 = localNullPointerException13;
                                        setPhone(false);
                                        continue;
                                        localNullPointerException14 = localNullPointerException14;
                                        setRoot(false);
                                        continue;
                                        localNullPointerException15 = localNullPointerException15;
                                        setSMS(false);
                                        continue;
                                        localNullPointerException16 = localNullPointerException16;
                                        setTelephony(false);
                                      }
                                    }
                                    catch (NullPointerException localNullPointerException17)
                                    {
                                      while (true)
                                        setWifiConnected(false);
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  public String getAccountType()
  {
    return this.account_type;
  }

  public String getConfig()
  {
    return this.account_type + "," + this.accelerometer_logs + "," + this.android_accounts_logs + "," + this.app_activity_history_logs + "," + this.app_data_usage_logs + "," + this.app_installs_logs + "," + this.battery_info_logs + "," + this.device_info_logs + "," + this.gps_location_logs + "," + this.malware_info_logs + "," + this.mms_logs + "," + this.net_data_usage_logs + "," + this.phone_calls_logs + "," + this.root_check_logs + "," + this.sms_logs + "," + this.telephony_info_logs + "," + this.wifi_connection_logs + "," + this.wifi_neighbor_logs;
  }

  public boolean isAccelerometerLogEnabled()
  {
    return this.accelerometer_logs;
  }

  public boolean isAccountsLogEnabled()
  {
    return this.android_accounts_logs;
  }

  public boolean isAppActivityLogEnabled()
  {
    return this.app_activity_history_logs;
  }

  public boolean isAppDataLogEnabled()
  {
    return this.app_data_usage_logs;
  }

  public boolean isAppInstallLogEnabled()
  {
    return this.app_installs_logs;
  }

  public boolean isBatteryInfoLogEnabled()
  {
    return this.battery_info_logs;
  }

  public boolean isDeviceInfoLogEnabled()
  {
    return this.device_info_logs;
  }

  public boolean isGPSLogEnabled()
  {
    return this.gps_location_logs;
  }

  public boolean isMMSLogEnabled()
  {
    return this.mms_logs;
  }

  public boolean isMalwareInfoLogEnabled()
  {
    return this.malware_info_logs;
  }

  public boolean isNetDataUsageLogEnabled()
  {
    return this.net_data_usage_logs;
  }

  public boolean isPhoneCallLogEnabled()
  {
    return this.phone_calls_logs;
  }

  public boolean isRootInfoLogEnabled()
  {
    return this.root_check_logs;
  }

  public boolean isSMSLogEnabled()
  {
    return this.sms_logs;
  }

  public boolean isTelephonyInfoLogEnabled()
  {
    return this.telephony_info_logs;
  }

  public boolean isWifiConnectedLogEnabled()
  {
    return this.wifi_connection_logs;
  }

  public boolean isWifiNeighborLogEnabled()
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
 * Qualified Name:     com.inauth.mme.beans.LogConfigFlagsBean
 * JD-Core Version:    0.6.2
 */