package com.inauth.mme.response;

import com.inauth.mme.beans.LogConfigBean;

public class LogConfigResponse
{
  private LogConfigBean log_configs;

  public String getAccountType()
  {
    return this.log_configs.getAccountType();
  }

  public String getConfig()
  {
    return this.log_configs.getConfig();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.mme.response.LogConfigResponse
 * JD-Core Version:    0.6.2
 */