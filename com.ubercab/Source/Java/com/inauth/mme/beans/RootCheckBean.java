package com.inauth.mme.beans;

public class RootCheckBean extends Bean
{
  private String checked_at;
  private String root_status_code;
  private String root_status_reason_code;
  private String root_version;
  private String sig_file_version;

  public String getChecked_at()
  {
    return this.checked_at;
  }

  public String getRoot_status_code()
  {
    return this.root_status_code;
  }

  public String getRoot_status_reason_code()
  {
    return this.root_status_reason_code;
  }

  public String getRoot_version()
  {
    return this.root_version;
  }

  public String getSig_file_version()
  {
    return this.sig_file_version;
  }

  public void setChecked_at(String paramString)
  {
    this.checked_at = paramString;
  }

  public void setRoot_status_code(String paramString)
  {
    this.root_status_code = paramString;
  }

  public void setRoot_status_reason_code(String paramString)
  {
    this.root_status_reason_code = paramString;
  }

  public void setRoot_version(String paramString)
  {
    this.root_version = paramString;
  }

  public void setSig_file_version(String paramString)
  {
    this.sig_file_version = paramString;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.mme.beans.RootCheckBean
 * JD-Core Version:    0.6.2
 */