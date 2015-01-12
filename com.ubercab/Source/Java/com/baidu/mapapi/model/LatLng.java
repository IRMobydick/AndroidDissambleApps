package com.baidu.mapapi.model;

public final class LatLng
{
  private static final String a = LatLng.class.getSimpleName();
  public final double latitude;
  public final double longitude;

  public LatLng(double paramDouble1, double paramDouble2)
  {
    int i = (int)(paramDouble1 * 1000000.0D);
    int j = (int)(paramDouble2 * 1000000.0D);
    this.latitude = (i / 1000000.0D);
    this.longitude = (j / 1000000.0D);
  }

  public String toString()
  {
    String str1 = new String("latitude: ");
    String str2 = str1 + this.latitude;
    String str3 = str2 + ", longitude: ";
    return str3 + this.longitude;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.model.LatLng
 * JD-Core Version:    0.6.2
 */