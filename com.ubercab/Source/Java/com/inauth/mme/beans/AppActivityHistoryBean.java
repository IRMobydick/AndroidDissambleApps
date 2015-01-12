package com.inauth.mme.beans;

public class AppActivityHistoryBean extends Bean
{
  private String checked_at;
  private String name;
  private String package_name;
  private String process_number_of_activity;
  private String processed_id;

  public String getCheckedAt()
  {
    return this.checked_at;
  }

  public String getName()
  {
    return this.name;
  }

  public String getPackageName()
  {
    return this.package_name;
  }

  public String getProcess_number_of_activity()
  {
    return this.process_number_of_activity;
  }

  public String getProcessed_id()
  {
    return this.processed_id;
  }

  public void setCheckedAt(String paramString)
  {
    this.checked_at = paramString;
  }

  public void setName(String paramString)
  {
    this.name = paramString;
  }

  public void setPackageName(String paramString)
  {
    this.package_name = paramString;
  }

  public void setProcess_number_of_activity(String paramString)
  {
    this.process_number_of_activity = paramString;
  }

  public void setProcessed_id(String paramString)
  {
    this.processed_id = paramString;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.mme.beans.AppActivityHistoryBean
 * JD-Core Version:    0.6.2
 */