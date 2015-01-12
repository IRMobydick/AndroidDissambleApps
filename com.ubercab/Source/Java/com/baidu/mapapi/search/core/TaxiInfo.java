package com.baidu.mapapi.search.core;

public class TaxiInfo
{
  private int a;
  private String b;
  private int c;
  private int d;
  private int e;

  public String getDesc()
  {
    return this.b;
  }

  public int getDistance()
  {
    return this.c;
  }

  public int getDuration()
  {
    return this.d;
  }

  public int getPerKMPrice()
  {
    return this.e;
  }

  public int getTotalPrice()
  {
    return this.a;
  }

  public void setDesc(String paramString)
  {
    this.b = paramString;
  }

  public void setDistance(int paramInt)
  {
    this.c = paramInt;
  }

  public void setDuration(int paramInt)
  {
    this.d = paramInt;
  }

  public void setPerKMPrice(int paramInt)
  {
    this.e = paramInt;
  }

  public void setTotalPrice(int paramInt)
  {
    this.a = paramInt;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.search.core.TaxiInfo
 * JD-Core Version:    0.6.2
 */