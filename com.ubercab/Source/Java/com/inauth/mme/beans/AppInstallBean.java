package com.inauth.mme.beans;

public class AppInstallBean extends Bean
{
  private String checked_at;
  private String installed_at;
  private String name;
  private String package_name;
  private String unknown_sources_enabled;
  private String version_code;
  private String version_name;

  public String getCheckedAt()
  {
    return this.checked_at;
  }

  public String getInstalledAt()
  {
    return this.installed_at;
  }

  public String getName()
  {
    return this.name;
  }

  public String getPackageName()
  {
    return this.package_name;
  }

  public String getUnknown_sources_enabled()
  {
    return this.unknown_sources_enabled;
  }

  public String getVersionCode()
  {
    return this.version_code;
  }

  public String getVersionName()
  {
    return this.version_name;
  }

  public void setCheckedAt(String paramString)
  {
    this.checked_at = paramString;
  }

  public void setInstalledAt(String paramString)
  {
    this.installed_at = paramString;
  }

  public void setName(String paramString)
  {
    this.name = paramString;
  }

  public void setPackageName(String paramString)
  {
    this.package_name = paramString;
  }

  public void setUnknown_sources_enabled(String paramString)
  {
    this.unknown_sources_enabled = paramString;
  }

  public void setVersionCode(String paramString)
  {
    this.version_code = paramString;
  }

  public void setVersionName(String paramString)
  {
    this.version_name = paramString;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.mme.beans.AppInstallBean
 * JD-Core Version:    0.6.2
 */