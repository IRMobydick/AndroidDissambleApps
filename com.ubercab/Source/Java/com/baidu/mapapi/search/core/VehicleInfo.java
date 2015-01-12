package com.baidu.mapapi.search.core;

public class VehicleInfo
{
  private String a;
  private int b;
  private String c;
  private int d;
  private int e;

  public int getPassStationNum()
  {
    return this.b;
  }

  public String getTitle()
  {
    return this.c;
  }

  public int getTotalPrice()
  {
    return this.e;
  }

  public String getUid()
  {
    return this.a;
  }

  public int getZonePrice()
  {
    return this.d;
  }

  public void setPassStationNum(int paramInt)
  {
    this.b = paramInt;
  }

  public void setTitle(String paramString)
  {
    this.c = paramString;
  }

  public void setTotalPrice(int paramInt)
  {
    this.e = paramInt;
  }

  public void setUid(String paramString)
  {
    this.a = paramString;
  }

  public void setZonePrice(int paramInt)
  {
    this.d = paramInt;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.search.core.VehicleInfo
 * JD-Core Version:    0.6.2
 */