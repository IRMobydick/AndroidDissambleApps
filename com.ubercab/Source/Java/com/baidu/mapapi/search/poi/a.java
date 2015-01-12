package com.baidu.mapapi.search.poi;

import com.baidu.mapapi.search.core.CityInfo;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.PoiInfo.POITYPE;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class a
{
  public static PoiResult a(String paramString)
  {
    PoiResult localPoiResult = new PoiResult();
    if ((paramString == null) || ("".equals(paramString)))
    {
      localPoiResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
      return localPoiResult;
    }
    ArrayList localArrayList;
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
      JSONArray localJSONArray = localJSONObject1.optJSONArray("citys");
      if ((localJSONArray == null) || (localJSONArray.length() <= 0))
        break label179;
      localArrayList = new ArrayList();
      for (int i = 0; i < localJSONArray.length(); i++)
      {
        JSONObject localJSONObject2 = (JSONObject)localJSONArray.opt(i);
        CityInfo localCityInfo = new CityInfo();
        localCityInfo.num = localJSONObject2.optInt("num");
        localCityInfo.city = localJSONObject2.optString("name");
        localArrayList.add(localCityInfo);
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      localPoiResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
      return localPoiResult;
    }
    if (localArrayList.size() > 0)
      localPoiResult.b(localArrayList);
    localPoiResult.error = SearchResult.ERRORNO.AMBIGUOUS_KEYWORD;
    return localPoiResult;
    label179: localPoiResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
    return localPoiResult;
  }

  public static PoiResult a(String paramString, int paramInt)
  {
    PoiResult localPoiResult = new PoiResult();
    if ((paramString == null) || (paramString.equals("")))
    {
      localPoiResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
      return localPoiResult;
    }
    ArrayList localArrayList;
    while (true)
    {
      try
      {
        JSONObject localJSONObject1 = new JSONObject(paramString);
        int i = localJSONObject1.optInt("total");
        int j = localJSONObject1.optInt("count");
        localPoiResult.b(i);
        localPoiResult.d(i);
        localPoiResult.c(j);
        localPoiResult.a(paramInt);
        int k = i / j;
        if (i % j > 0)
        {
          m = 1;
          localPoiResult.b(m + k);
          JSONObject localJSONObject2 = localJSONObject1.optJSONObject("current_city");
          String str = null;
          if (localJSONObject2 != null)
            str = localJSONObject2.optString("name");
          JSONArray localJSONArray = localJSONObject1.optJSONArray("pois");
          localArrayList = new ArrayList();
          if (localJSONArray == null)
            break;
          int n = 0;
          if (n >= localJSONArray.length())
            break;
          JSONObject localJSONObject3 = localJSONArray.optJSONObject(n);
          PoiInfo localPoiInfo = new PoiInfo();
          localPoiInfo.name = localJSONObject3.optString("name");
          localPoiInfo.address = localJSONObject3.optString("addr");
          localPoiInfo.uid = localJSONObject3.optString("uid");
          localPoiInfo.phoneNum = localJSONObject3.optString("tel");
          localPoiInfo.type = PoiInfo.POITYPE.fromInt(localJSONObject3.optInt("type"));
          if (localJSONObject3.optInt("pano") != 1)
            break label392;
          bool = true;
          localPoiInfo.isPano = bool;
          if ((localPoiInfo.type != PoiInfo.POITYPE.BUS_LINE) && (localPoiInfo.type != PoiInfo.POITYPE.SUBWAY_LINE))
            localPoiInfo.location = com.baidu.mapapi.model.a.a(localJSONObject3.optString("geo"));
          localPoiInfo.city = str;
          JSONObject localJSONObject4 = localJSONObject3.optJSONObject("place");
          if ((localJSONObject4 != null) && ("cater".equals(localJSONObject4.optString("src_name"))) && (localJSONObject3.optBoolean("detail")))
            localPoiInfo.hasCaterDetails = true;
          localArrayList.add(localPoiInfo);
          n++;
          continue;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        localPoiResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        return localPoiResult;
      }
      int m = 0;
      continue;
      label392: boolean bool = false;
    }
    if (localArrayList.size() > 0)
      localPoiResult.a(localArrayList);
    return localPoiResult;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.search.poi.a
 * JD-Core Version:    0.6.2
 */