package com.baidu.mapapi.search.geocode;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.platform.comapi.a.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  private static ReverseGeoCodeResult.AddressComponent a(JSONObject paramJSONObject, String paramString)
  {
    if ((paramJSONObject == null) || (paramString == null) || ("".equals(paramString)))
      return null;
    JSONObject localJSONObject = paramJSONObject.optJSONObject(paramString);
    ReverseGeoCodeResult.AddressComponent localAddressComponent = new ReverseGeoCodeResult.AddressComponent();
    localAddressComponent.city = localJSONObject.optString("city");
    localAddressComponent.district = localJSONObject.optString("district");
    localAddressComponent.province = localJSONObject.optString("province");
    localAddressComponent.street = localJSONObject.optString("street");
    localAddressComponent.streetNumber = localJSONObject.optString("street_number");
    return localAddressComponent;
  }

  public static ReverseGeoCodeResult a(String paramString)
  {
    ReverseGeoCodeResult localReverseGeoCodeResult = new ReverseGeoCodeResult();
    if ((paramString == null) || ("".equals(paramString)))
    {
      localReverseGeoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
      return localReverseGeoCodeResult;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      localReverseGeoCodeResult.b(localJSONObject.optString("address"));
      localReverseGeoCodeResult.a(localJSONObject.optString("business"));
      localReverseGeoCodeResult.a(a(localJSONObject, "addr_detail"));
      localReverseGeoCodeResult.a(b(localJSONObject, "point"));
      localReverseGeoCodeResult.a(c(localJSONObject, "surround_poi"));
      return localReverseGeoCodeResult;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      localReverseGeoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
    }
    return localReverseGeoCodeResult;
  }

  private static LatLng b(JSONObject paramJSONObject, String paramString)
  {
    if ((paramJSONObject == null) || (paramString == null) || ("".equals(paramString)));
    JSONObject localJSONObject;
    do
    {
      return null;
      localJSONObject = paramJSONObject.optJSONObject(paramString);
    }
    while (localJSONObject == null);
    int i = localJSONObject.optInt("x");
    return com.baidu.mapapi.model.a.a(new b(localJSONObject.optInt("y"), i));
  }

  public static GeoCodeResult b(String paramString)
  {
    GeoCodeResult localGeoCodeResult = new GeoCodeResult();
    JSONObject localJSONObject;
    try
    {
      localJSONObject = new JSONObject(paramString);
      if (localJSONObject == null)
      {
        localGeoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        return localGeoCodeResult;
      }
      if (localJSONObject.optInt("error") != 0)
      {
        localGeoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        return localGeoCodeResult;
      }
    }
    catch (JSONException localJSONException)
    {
      localGeoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
      localJSONException.printStackTrace();
      return localGeoCodeResult;
    }
    localGeoCodeResult.a(com.baidu.mapapi.model.a.a(new b(localJSONObject.optInt("y"), localJSONObject.optInt("x"))));
    localGeoCodeResult.setAddress(localJSONObject.optString("addr"));
    return localGeoCodeResult;
  }

  private static List<PoiInfo> c(JSONObject paramJSONObject, String paramString)
  {
    if ((paramJSONObject == null) || (paramString == null) || ("".equals(paramString)));
    JSONArray localJSONArray;
    do
    {
      return null;
      localJSONArray = paramJSONObject.optJSONArray(paramString);
    }
    while (localJSONArray == null);
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < localJSONArray.length(); i++)
    {
      JSONObject localJSONObject = localJSONArray.optJSONObject(i);
      PoiInfo localPoiInfo = new PoiInfo();
      localPoiInfo.address = localJSONObject.optString("addr");
      localPoiInfo.phoneNum = localJSONObject.optString("tel");
      localPoiInfo.uid = localJSONObject.optString("uid");
      localPoiInfo.postCode = localJSONObject.optString("zip");
      localPoiInfo.name = localJSONObject.optString("name");
      localPoiInfo.location = b(localJSONObject, "point");
      localArrayList.add(localPoiInfo);
    }
    return localArrayList;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.search.geocode.a
 * JD-Core Version:    0.6.2
 */