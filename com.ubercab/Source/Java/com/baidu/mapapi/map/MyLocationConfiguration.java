package com.baidu.mapapi.map;

public class MyLocationConfiguration
{
  public final BitmapDescriptor customMarker;
  public final boolean enableDirection;
  public final LocationMode locationMode;

  public MyLocationConfiguration(LocationMode paramLocationMode, boolean paramBoolean, BitmapDescriptor paramBitmapDescriptor)
  {
    if (paramLocationMode == null)
      paramLocationMode = LocationMode.NORMAL;
    this.locationMode = paramLocationMode;
    this.enableDirection = paramBoolean;
    this.customMarker = paramBitmapDescriptor;
  }

  public static enum LocationMode
  {
    static
    {
      FOLLOWING = new LocationMode("FOLLOWING", 1);
      COMPASS = new LocationMode("COMPASS", 2);
      LocationMode[] arrayOfLocationMode = new LocationMode[3];
      arrayOfLocationMode[0] = NORMAL;
      arrayOfLocationMode[1] = FOLLOWING;
      arrayOfLocationMode[2] = COMPASS;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.map.MyLocationConfiguration
 * JD-Core Version:    0.6.2
 */