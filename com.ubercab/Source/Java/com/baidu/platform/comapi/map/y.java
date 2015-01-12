package com.baidu.platform.comapi.map;

import android.graphics.Point;
import com.baidu.platform.comapi.a.b;
import com.baidu.platform.comjni.map.basemap.a;
import org.json.JSONException;
import org.json.JSONObject;

public class y
{
  private a a;

  public y(a parama)
  {
    this.a = parama;
  }

  public Point a(b paramb)
  {
    Point localPoint;
    if (paramb == null)
      localPoint = null;
    String str;
    do
    {
      return localPoint;
      localPoint = new Point(0, 0);
      str = this.a.b(paramb.b(), paramb.a());
    }
    while (str == null);
    try
    {
      JSONObject localJSONObject = new JSONObject(str);
      localPoint.x = localJSONObject.getInt("scrx");
      localPoint.y = localJSONObject.getInt("scry");
      return localPoint;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localPoint;
  }

  public b a(int paramInt1, int paramInt2)
  {
    String str = this.a.a(paramInt1, paramInt2);
    b localb = new b(0, 0);
    if (str != null)
      try
      {
        JSONObject localJSONObject = new JSONObject(str);
        localb.b(localJSONObject.getInt("geox"));
        localb.a(localJSONObject.getInt("geoy"));
        return localb;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    return null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.platform.comapi.map.y
 * JD-Core Version:    0.6.2
 */