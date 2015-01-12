package com.inauth.mme.header;

import com.inauth.mme.beans.RegistrationBean;

public class RegistrationHeader
{
  private String account_guid;
  private RegistrationBean device;
  private String dynamic_id;
  private String sdk_version;

  public String getAccount_guid()
  {
    return this.account_guid;
  }

  public RegistrationBean getDevice()
  {
    return this.device;
  }

  public String getDynamic_id()
  {
    return this.dynamic_id;
  }

  public String getSdk_version()
  {
    return this.sdk_version;
  }

  public void setAccount_guid(String paramString)
  {
    this.account_guid = paramString;
  }

  public void setDevice(RegistrationBean paramRegistrationBean)
  {
    this.device = paramRegistrationBean;
  }

  public void setDynamic_id(String paramString)
  {
    this.dynamic_id = paramString;
  }

  public void setSdk_version(String paramString)
  {
    this.sdk_version = paramString;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.mme.header.RegistrationHeader
 * JD-Core Version:    0.6.2
 */