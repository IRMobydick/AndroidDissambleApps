package com.baidu.mapapi.cloud;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CloudPoiInfo
{
  public String address;
  public String city;
  public int distance;
  public String district;
  public Map<String, Object> extras;
  public int geotableId;
  public double latitude;
  public double longitude;
  public String province;
  public String tags;
  public String title;
  public int uid;
  public int weight;

  void a(JSONObject paramJSONObject)
    throws JSONException
  {
    if (paramJSONObject == null);
    while (true)
    {
      return;
      this.uid = paramJSONObject.optInt("uid");
      paramJSONObject.remove("uid");
      this.geotableId = paramJSONObject.optInt("geotable_id");
      paramJSONObject.remove("geotable_id");
      this.title = paramJSONObject.optString("title");
      paramJSONObject.remove("title");
      this.address = paramJSONObject.optString("address");
      paramJSONObject.remove("address");
      this.province = paramJSONObject.optString("province");
      paramJSONObject.remove("province");
      this.city = paramJSONObject.optString("city");
      paramJSONObject.remove("city");
      this.district = paramJSONObject.optString("district");
      paramJSONObject.remove("district");
      JSONArray localJSONArray = paramJSONObject.optJSONArray("location");
      if (localJSONArray != null)
      {
        this.longitude = localJSONArray.optDouble(0);
        this.latitude = localJSONArray.optDouble(1);
      }
      paramJSONObject.remove("location");
      this.tags = paramJSONObject.optString("tags");
      paramJSONObject.remove("tags");
      this.distance = paramJSONObject.optInt("distance");
      paramJSONObject.remove("distance");
      this.weight = paramJSONObject.optInt("weight");
      paramJSONObject.remove("weight");
      this.extras = new HashMap();
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = paramJSONObject.opt(str);
        this.extras.put(str, localObject);
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.cloud.CloudPoiInfo
 * JD-Core Version:    0.6.2
 */