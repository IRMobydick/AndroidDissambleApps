package com.inauth.mme.header;

public class LogConfigHeader
{
  private String account_guid;
  private String device_guid;
  private String dynamic_id;
  private String sdk_version;

  public String getAccountGUID()
  {
    return this.account_guid;
  }

  public String getDeviceGUID()
  {
    return this.device_guid;
  }

  public String getDynamicID()
  {
    return this.dynamic_id;
  }

  public String getSDKVersion()
  {
    return this.sdk_version;
  }

  public void setAccountGUID(String paramString)
  {
    this.account_guid = paramString;
  }

  public void setDeviceGUID(String paramString)
  {
    this.device_guid = paramString;
  }

  public void setDynamicID(String paramString)
  {
    this.dynamic_id = paramString;
  }

  public void setSDKVersion(String paramString)
  {
    this.sdk_version = paramString;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.mme.header.LogConfigHeader
 * JD-Core Version:    0.6.2
 */