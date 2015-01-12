package com.baidu.mapapi.cloud;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DetailSearchResult extends BaseSearchResult
{
  public CloudPoiInfo poiInfo;

  void a(JSONObject paramJSONObject)
    throws JSONException
  {
    super.a(paramJSONObject);
    JSONArray localJSONArray = paramJSONObject.optJSONArray("contents");
    if (localJSONArray == null);
    JSONObject localJSONObject;
    do
    {
      return;
      localJSONObject = localJSONArray.optJSONObject(0);
    }
    while (localJSONObject == null);
    this.poiInfo = new CloudPoiInfo();
    this.poiInfo.a(localJSONObject);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.cloud.DetailSearchResult
 * JD-Core Version:    0.6.2
 */