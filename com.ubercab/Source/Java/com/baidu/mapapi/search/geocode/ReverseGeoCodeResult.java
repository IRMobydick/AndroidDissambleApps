package com.baidu.mapapi.search.geocode;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import java.util.List;

public class ReverseGeoCodeResult extends SearchResult
{
  private String a;
  private String b;
  private AddressComponent c;
  private LatLng d;
  private List<PoiInfo> e;

  ReverseGeoCodeResult()
  {
  }

  ReverseGeoCodeResult(SearchResult.ERRORNO paramERRORNO)
  {
    super(paramERRORNO);
  }

  void a(LatLng paramLatLng)
  {
    this.d = paramLatLng;
  }

  void a(AddressComponent paramAddressComponent)
  {
    this.c = paramAddressComponent;
  }

  void a(String paramString)
  {
    this.a = paramString;
  }

  void a(List<PoiInfo> paramList)
  {
    this.e = paramList;
  }

  void b(String paramString)
  {
    this.b = paramString;
  }

  public String getAddress()
  {
    return this.b;
  }

  public AddressComponent getAddressDetail()
  {
    return this.c;
  }

  public String getBusinessCircle()
  {
    return this.a;
  }

  public LatLng getLocation()
  {
    return this.d;
  }

  public List<PoiInfo> getPoiList()
  {
    return this.e;
  }

  public static class AddressComponent
  {
    public String city;
    public String district;
    public String province;
    public String street;
    public String streetNumber;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.search.geocode.ReverseGeoCodeResult
 * JD-Core Version:    0.6.2
 */