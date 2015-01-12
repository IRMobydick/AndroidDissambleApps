package com.baidu.mapapi.cloud;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CloudSearchResult extends BaseSearchResult
{
  public List<CloudPoiInfo> poiList;

  void a(JSONObject paramJSONObject)
    throws JSONException
  {
    super.a(paramJSONObject);
    this.poiList = new ArrayList();
    JSONArray localJSONArray = paramJSONObject.optJSONArray("contents");
    if (localJSONArray == null)
      return;
    int i = 0;
    label30: JSONObject localJSONObject;
    if (i < localJSONArray.length())
    {
      localJSONObject = localJSONArray.optJSONObject(i);
      if (localJSONObject != null)
        break label56;
    }
    while (true)
    {
      i++;
      break label30;
      break;
      label56: CloudPoiInfo localCloudPoiInfo = new CloudPoiInfo();
      localCloudPoiInfo.a(localJSONObject);
      this.poiList.add(localCloudPoiInfo);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.cloud.CloudSearchResult
 * JD-Core Version:    0.6.2
 */