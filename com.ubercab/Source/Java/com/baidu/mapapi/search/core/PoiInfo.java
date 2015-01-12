package com.baidu.mapapi.search.core;

import com.baidu.mapapi.model.LatLng;

public class PoiInfo
{
  public String address;
  public String city;
  public boolean hasCaterDetails;
  public boolean isPano;
  public LatLng location;
  public String name;
  public String phoneNum;
  public String postCode;
  public POITYPE type;
  public String uid;

  public static enum POITYPE
  {
    private int a;

    static
    {
      BUS_STATION = new POITYPE("BUS_STATION", 1, 1);
      BUS_LINE = new POITYPE("BUS_LINE", 2, 2);
      SUBWAY_STATION = new POITYPE("SUBWAY_STATION", 3, 3);
      SUBWAY_LINE = new POITYPE("SUBWAY_LINE", 4, 4);
      POITYPE[] arrayOfPOITYPE = new POITYPE[5];
      arrayOfPOITYPE[0] = POINT;
      arrayOfPOITYPE[1] = BUS_STATION;
      arrayOfPOITYPE[2] = BUS_LINE;
      arrayOfPOITYPE[3] = SUBWAY_STATION;
      arrayOfPOITYPE[4] = SUBWAY_LINE;
    }

    private POITYPE(int paramInt)
    {
    }

    public static POITYPE fromInt(int paramInt)
    {
      switch (paramInt)
      {
      default:
        return null;
      case 0:
        return POINT;
      case 1:
        return BUS_STATION;
      case 2:
        return BUS_LINE;
      case 3:
        return SUBWAY_STATION;
      case 4:
      }
      return SUBWAY_LINE;
    }

    public int getInt()
    {
      return this.a;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.search.core.PoiInfo
 * JD-Core Version:    0.6.2
 */