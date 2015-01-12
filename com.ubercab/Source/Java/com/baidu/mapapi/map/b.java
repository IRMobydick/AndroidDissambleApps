package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.graphics.Point;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.a;
import com.baidu.platform.comapi.map.e;
import com.baidu.platform.comapi.map.g;
import com.baidu.platform.comapi.map.w;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class b
  implements g
{
  b(BaiduMap paramBaiduMap)
  {
  }

  public void a()
  {
  }

  public void a(Bitmap paramBitmap)
  {
    if (BaiduMap.h(this.a) != null)
      BaiduMap.h(this.a).onSnapshotReady(paramBitmap);
  }

  public void a(com.baidu.platform.comapi.a.b paramb)
  {
    if (BaiduMap.d(this.a) != null)
    {
      LatLng localLatLng = a.a(paramb);
      BaiduMap.d(this.a).onMapClick(localLatLng);
    }
  }

  public void a(w paramw)
  {
    if (BaiduMap.c(this.a) != null)
    {
      MapStatus localMapStatus = MapStatus.a(paramw);
      BaiduMap.c(this.a).onMapStatusChangeStart(localMapStatus);
    }
  }

  public void a(String paramString)
  {
    JSONObject localJSONObject;
    int i;
    try
    {
      localJSONObject = new JSONObject(paramString).optJSONArray("dataset").optJSONObject(0);
      i = localJSONObject.optInt("ty");
      if (i == 17)
      {
        if (BaiduMap.d(this.a) == null)
          return;
        MapPoi localMapPoi = new MapPoi();
        localMapPoi.a(localJSONObject);
        BaiduMap.d(this.a).onMapPoiClick(localMapPoi);
        return;
      }
      if (i == 18)
      {
        if (BaiduMap.i(this.a) == null)
          return;
        BaiduMap.i(this.a).onMyLocationClick();
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      return;
    }
    if (i == 19)
    {
      w localw = BaiduMap.b(this.a).m();
      localw.c = 0;
      localw.b = 0;
      BaiduMap.b(this.a).a(localw, 300);
      return;
    }
    if (i == 90909)
    {
      String str = localJSONObject.optString("marker_id");
      if ((BaiduMap.j(this.a) != null) && (str.equals(BaiduMap.k(this.a).j)))
      {
        InfoWindow.OnInfoWindowClickListener localOnInfoWindowClickListener = BaiduMap.j(this.a).d;
        if (localOnInfoWindowClickListener != null)
          localOnInfoWindowClickListener.onInfoWindowClick();
      }
      else
      {
        Iterator localIterator = BaiduMap.a(this.a).iterator();
        while (localIterator.hasNext())
        {
          Overlay localOverlay = (Overlay)localIterator.next();
          if (((localOverlay instanceof Marker)) && (localOverlay.j.equals(str)) && (BaiduMap.l(this.a) != null))
            BaiduMap.l(this.a).onMarkerClick((Marker)localOverlay);
        }
      }
    }
  }

  public void b()
  {
    BaiduMap.a(this.a, new Projection(BaiduMap.b(this.a)));
    BaiduMap.a(this.a, true);
    if (BaiduMap.g(this.a) != null)
      BaiduMap.g(this.a).onMapLoaded();
  }

  public void b(com.baidu.platform.comapi.a.b paramb)
  {
    if (BaiduMap.e(this.a) != null)
    {
      LatLng localLatLng = a.a(paramb);
      BaiduMap.e(this.a).onMapDoubleClick(localLatLng);
    }
  }

  public void b(w paramw)
  {
    if (BaiduMap.c(this.a) != null)
    {
      MapStatus localMapStatus = MapStatus.a(paramw);
      BaiduMap.c(this.a).onMapStatusChange(localMapStatus);
    }
  }

  public boolean b(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString).optJSONArray("dataset").optJSONObject(0);
      if (localJSONObject.optInt("ty") == 90909)
      {
        String str = localJSONObject.optString("marker_id");
        if ((BaiduMap.k(this.a) == null) || (!str.equals(BaiduMap.k(this.a).j)))
        {
          Iterator localIterator = BaiduMap.a(this.a).iterator();
          while (localIterator.hasNext())
          {
            Overlay localOverlay = (Overlay)localIterator.next();
            if (((localOverlay instanceof Marker)) && (localOverlay.j.equals(str)))
            {
              Marker localMarker = (Marker)localOverlay;
              if (localMarker.f)
              {
                BaiduMap.a(this.a, localMarker);
                Point localPoint1 = BaiduMap.n(this.a).toScreenLocation(BaiduMap.m(this.a).a);
                Point localPoint2 = new Point(localPoint1.x, -60 + localPoint1.y);
                LatLng localLatLng = BaiduMap.n(this.a).fromScreenLocation(localPoint2);
                BaiduMap.m(this.a).setPosition(localLatLng);
                if (BaiduMap.o(this.a) != null)
                  BaiduMap.o(this.a).onMarkerDragStart(BaiduMap.m(this.a));
                return true;
              }
            }
          }
        }
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return false;
  }

  public void c()
  {
    BaiduMap.p(this.a).lock();
    try
    {
      if (BaiduMap.q(this.a) != null)
        BaiduMap.q(this.a).a.clear();
      return;
    }
    finally
    {
      BaiduMap.p(this.a).unlock();
    }
  }

  public void c(com.baidu.platform.comapi.a.b paramb)
  {
    if (BaiduMap.f(this.a) != null)
    {
      LatLng localLatLng = a.a(paramb);
      BaiduMap.f(this.a).onMapLongClick(localLatLng);
    }
  }

  public void c(w paramw)
  {
    if (BaiduMap.c(this.a) != null)
    {
      MapStatus localMapStatus = MapStatus.a(paramw);
      BaiduMap.c(this.a).onMapStatusChangeFinish(localMapStatus);
    }
  }

  public void d(com.baidu.platform.comapi.a.b paramb)
  {
    if ((BaiduMap.m(this.a) != null) && (BaiduMap.m(this.a).f))
    {
      LatLng localLatLng1 = a.a(paramb);
      Point localPoint1 = BaiduMap.n(this.a).toScreenLocation(localLatLng1);
      Point localPoint2 = new Point(localPoint1.x, -60 + localPoint1.y);
      LatLng localLatLng2 = BaiduMap.n(this.a).fromScreenLocation(localPoint2);
      BaiduMap.m(this.a).setPosition(localLatLng2);
      if ((BaiduMap.o(this.a) != null) && (BaiduMap.m(this.a).f))
        BaiduMap.o(this.a).onMarkerDrag(BaiduMap.m(this.a));
    }
  }

  public void e(com.baidu.platform.comapi.a.b paramb)
  {
    if ((BaiduMap.m(this.a) != null) && (BaiduMap.m(this.a).f))
    {
      LatLng localLatLng1 = a.a(paramb);
      Point localPoint1 = BaiduMap.n(this.a).toScreenLocation(localLatLng1);
      Point localPoint2 = new Point(localPoint1.x, -60 + localPoint1.y);
      LatLng localLatLng2 = BaiduMap.n(this.a).fromScreenLocation(localPoint2);
      BaiduMap.m(this.a).setPosition(localLatLng2);
      if ((BaiduMap.o(this.a) != null) && (BaiduMap.m(this.a).f))
        BaiduMap.o(this.a).onMarkerDragEnd(BaiduMap.m(this.a));
      BaiduMap.a(this.a, null);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.map.b
 * JD-Core Version:    0.6.2
 */