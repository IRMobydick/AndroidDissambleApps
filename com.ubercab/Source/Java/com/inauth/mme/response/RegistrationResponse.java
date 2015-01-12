package com.inauth.mme.response;

import com.inauth.mme.beans.LogConfigBean;

public class RegistrationResponse
{
  private String device_guid;
  private LogConfigBean log_configs;
  private String status;

  public String getAccountType()
  {
    return this.log_configs.getAccountType();
  }

  public String getConfig()
  {
    return this.log_configs.getConfig();
  }

  public String getDeviceGuid()
  {
    return this.device_guid;
  }

  public String getStatus()
  {
    return this.status;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.mme.response.RegistrationResponse
 * JD-Core Version:    0.6.2
 */