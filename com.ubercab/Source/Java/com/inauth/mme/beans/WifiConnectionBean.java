package com.inauth.mme.beans;

public class WifiConnectionBean extends Bean
{
  private String bssid;
  private String checked_at;
  private String ip;
  private String linkspeed;
  private String macaddr;
  private String networkid;
  private String rssi;
  private String ssid;

  public String getBssid()
  {
    return this.bssid;
  }

  public String getChecked_at()
  {
    return this.checked_at;
  }

  public String getIp()
  {
    return this.ip;
  }

  public String getLinkspeed()
  {
    return this.linkspeed;
  }

  public String getMacaddr()
  {
    return this.macaddr;
  }

  public String getNetworkID()
  {
    return this.networkid;
  }

  public String getRssi()
  {
    return this.rssi;
  }

  public String getSsid()
  {
    return this.ssid;
  }

  public void setBssid(String paramString)
  {
    this.bssid = paramString;
  }

  public void setChecked_at(String paramString)
  {
    this.checked_at = paramString;
  }

  public void setIp(String paramString)
  {
    this.ip = paramString;
  }

  public void setLinkspeed(String paramString)
  {
    this.linkspeed = paramString;
  }

  public void setMacaddr(String paramString)
  {
    this.macaddr = paramString;
  }

  public void setNetworkID(String paramString)
  {
    this.networkid = paramString;
  }

  public void setRssi(String paramString)
  {
    this.rssi = paramString;
  }

  public void setSsid(String paramString)
  {
    this.ssid = paramString;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.mme.beans.WifiConnectionBean
 * JD-Core Version:    0.6.2
 */