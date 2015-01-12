package com.inauth.mme.beans;

public class SMSBean extends Bean
{
  private String checked_at;
  private String from_number;
  private String service_number;
  private String sms_at;
  private String sms_type;
  private String to_number;

  public String getChecked_at()
  {
    return this.checked_at;
  }

  public String getFrom_number()
  {
    return this.from_number;
  }

  public String getService_number()
  {
    return this.service_number;
  }

  public String getSms_at()
  {
    return this.sms_at;
  }

  public String getSms_type()
  {
    return this.sms_type;
  }

  public String getTo_number()
  {
    return this.to_number;
  }

  public void setChecked_at(String paramString)
  {
    this.checked_at = paramString;
  }

  public void setFrom_number(String paramString)
  {
    this.from_number = paramString;
  }

  public void setService_number(String paramString)
  {
    this.service_number = paramString;
  }

  public void setSms_at(String paramString)
  {
    this.sms_at = paramString;
  }

  public void setSms_type(String paramString)
  {
    this.sms_type = paramString;
  }

  public void setTo_number(String paramString)
  {
    this.to_number = paramString;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.mme.beans.SMSBean
 * JD-Core Version:    0.6.2
 */