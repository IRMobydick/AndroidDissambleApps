package com.inauth.mme.beans;

public class AppDataUsageBean extends Bean
{
  private String cache_size;
  private String checked_at;
  private String code_size;
  private String data_size;
  private String name;
  private String package_name;

  public String getCacheSize()
  {
    return this.cache_size;
  }

  public String getCheckedAt()
  {
    return this.checked_at;
  }

  public String getCodeSize()
  {
    return this.code_size;
  }

  public String getDatasize()
  {
    return this.data_size;
  }

  public String getName()
  {
    return this.name;
  }

  public String getPackageName()
  {
    return this.package_name;
  }

  public void setCacheSize(String paramString)
  {
    this.cache_size = paramString;
  }

  public void setCheckedAt(String paramString)
  {
    this.checked_at = paramString;
  }

  public void setCodeSize(String paramString)
  {
    this.code_size = paramString;
  }

  public void setDataSize(String paramString)
  {
    this.data_size = paramString;
  }

  public void setName(String paramString)
  {
    this.name = paramString;
  }

  public void setPackageName(String paramString)
  {
    this.package_name = paramString;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.mme.beans.AppDataUsageBean
 * JD-Core Version:    0.6.2
 */