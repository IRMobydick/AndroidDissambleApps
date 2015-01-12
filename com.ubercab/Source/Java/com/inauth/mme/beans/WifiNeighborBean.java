package com.inauth.mme.beans;

public class WifiNeighborBean extends Bean
{
  private String bssid;
  private String capabilities;
  private String checked_at;
  private String frequency;
  private String level;
  private String ssid;

  public String getBssid()
  {
    return this.bssid;
  }

  public String getCapabilities()
  {
    return this.capabilities;
  }

  public String getChecked_at()
  {
    return this.checked_at;
  }

  public String getFrequency()
  {
    return this.frequency;
  }

  public String getLevel()
  {
    return this.level;
  }

  public String getSsid()
  {
    return this.ssid;
  }

  public void setBssid(String paramString)
  {
    this.bssid = paramString;
  }

  public void setCapabilities(String paramString)
  {
    this.capabilities = paramString;
  }

  public void setChecked_at(String paramString)
  {
    this.checked_at = paramString;
  }

  public void setFrequency(String paramString)
  {
    this.frequency = paramString;
  }

  public void setLevel(String paramString)
  {
    this.level = paramString;
  }

  public void setSsid(String paramString)
  {
    this.ssid = paramString;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.mme.beans.WifiNeighborBean
 * JD-Core Version:    0.6.2
 */