package com.inauth.mme.header;

import com.inauth.mme.beans.Bean;
import java.util.ArrayList;
import java.util.List;

public class LogHeader
{
  private String account_guid;
  private String device_guid;
  private String dynamic_id;
  private List<Bean> logs = new ArrayList();
  private String sdk_version;
  private String transaction_id;
  private String type;

  public void addLogs(Bean paramBean)
  {
    this.logs.add(paramBean);
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

  public String getSDKVersion()
  {
    return this.sdk_version;
  }

  public String getTransaction_id()
  {
    return this.transaction_id;
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

  public void setSDKVersion(String paramString)
  {
    this.sdk_version = paramString;
  }

  public void setTransaction_id(String paramString)
  {
    this.transaction_id = paramString;
  }

  public void setType(String paramString)
  {
    this.type = paramString;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.mme.header.LogHeader
 * JD-Core Version:    0.6.2
 */