package com.baidu.mapapi.map;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.a;
import org.json.JSONObject;

public final class MapPoi
{
  private static final String c = MapPoi.class.getSimpleName();
  String a;
  LatLng b;

  void a(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optString("tx");
    this.b = a.b(paramJSONObject.optString("geo"));
  }

  public String getName()
  {
    return this.a;
  }

  public LatLng getPosition()
  {
    return this.b;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.map.MapPoi
 * JD-Core Version:    0.6.2
 */