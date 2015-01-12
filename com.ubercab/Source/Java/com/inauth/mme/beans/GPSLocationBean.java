package com.inauth.mme.beans;

public class GPSLocationBean extends Bean
{
  private String accuracy;
  private String altitude;
  private String checked_at;
  private String latitude;
  private String longitude;
  private String provider;
  private String speed;

  public String getAccuracy()
  {
    return this.accuracy;
  }

  public String getAltitude()
  {
    return this.altitude;
  }

  public String getChecked_at()
  {
    return this.checked_at;
  }

  public String getLatitude()
  {
    return this.latitude;
  }

  public String getLongitude()
  {
    return this.longitude;
  }

  public String getProvider()
  {
    return this.provider;
  }

  public String getSpeed()
  {
    return this.speed;
  }

  public void setAccuracy(String paramString)
  {
    this.accuracy = paramString;
  }

  public void setAltitude(String paramString)
  {
    this.altitude = paramString;
  }

  public void setChecked_at(String paramString)
  {
    this.checked_at = paramString;
  }

  public void setLatitude(String paramString)
  {
    this.latitude = paramString;
  }

  public void setLongitude(String paramString)
  {
    this.longitude = paramString;
  }

  public void setProvider(String paramString)
  {
    this.provider = paramString;
  }

  public void setSpeed(String paramString)
  {
    this.speed = paramString;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.mme.beans.GPSLocationBean
 * JD-Core Version:    0.6.2
 */