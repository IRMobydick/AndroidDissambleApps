package com.inauth.mme.beans;

public class PhoneCallBean extends Bean
{
  private String call_duration;
  private String called_at;
  private String checked_at;
  private String from_number;
  private String phone_call_type;
  private String to_number;

  public String getCall_duration()
  {
    return this.call_duration;
  }

  public String getCalled_at()
  {
    return this.called_at;
  }

  public String getChecked_at()
  {
    return this.checked_at;
  }

  public String getFrom_number()
  {
    return this.from_number;
  }

  public String getPhone_call_type()
  {
    return this.phone_call_type;
  }

  public String getTo_number()
  {
    return this.to_number;
  }

  public void setCall_duration(String paramString)
  {
    this.call_duration = paramString;
  }

  public void setCalled_at(String paramString)
  {
    this.called_at = paramString;
  }

  public void setChecked_at(String paramString)
  {
    this.checked_at = paramString;
  }

  public void setFrom_number(String paramString)
  {
    this.from_number = paramString;
  }

  public void setPhone_call_type(String paramString)
  {
    this.phone_call_type = paramString;
  }

  public void setTo_number(String paramString)
  {
    this.to_number = paramString;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.mme.beans.PhoneCallBean
 * JD-Core Version:    0.6.2
 */