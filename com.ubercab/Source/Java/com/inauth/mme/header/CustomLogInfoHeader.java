package com.inauth.mme.header;

import com.inauth.mme.beans.CustomLogInfoBean;

public class CustomLogInfoHeader
{
  String account_guid;
  String device_guid;
  String dynamic_id;
  CustomLogInfoBean event = new CustomLogInfoBean();
  String sdk_version;
  String type;

  public void addLogsPayload(CustomLogInfoBean paramCustomLogInfoBean)
  {
    this.event = paramCustomLogInfoBean;
  }

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

  public CustomLogInfoBean getEvent()
  {
    return this.event;
  }

  public CustomLogInfoBean getLogsPayload()
  {
    return this.event;
  }

  public String getSDKVersion()
  {
    return this.sdk_version;
  }

  public String getType()
  {
    return this.type;
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

  public void setEvent(CustomLogInfoBean paramCustomLogInfoBean)
  {
    this.event = paramCustomLogInfoBean;
  }

  public void setLogsPayload(CustomLogInfoBean paramCustomLogInfoBean)
  {
    this.event = paramCustomLogInfoBean;
  }

  public void setSDKVersion(String paramString)
  {
    this.sdk_version = paramString;
  }

  public void setType(String paramString)
  {
    this.type = paramString;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.mme.header.CustomLogInfoHeader
 * JD-Core Version:    0.6.2
 */