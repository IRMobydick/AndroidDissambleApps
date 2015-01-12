package com.baidu.mapapi.map;

import android.graphics.Point;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.a;
import com.baidu.platform.comapi.a.b;
import com.baidu.platform.comapi.map.e;

public final class MapStatusUpdate
{
  private static final String l = MapStatusUpdate.class.getSimpleName();
  int a;
  MapStatus b;
  LatLng c;
  LatLngBounds d;
  int e;
  int f;
  float g;
  int h;
  int i;
  float j;
  Point k;

  MapStatusUpdate()
  {
  }

  MapStatusUpdate(int paramInt)
  {
    this.a = paramInt;
  }

  MapStatus a(e parame, MapStatus paramMapStatus)
  {
    switch (this.a)
    {
    default:
      return null;
    case 1:
      return this.b;
    case 2:
      return new MapStatus(paramMapStatus.rotate, this.c, paramMapStatus.overlook, paramMapStatus.zoom, paramMapStatus.targetScreen);
    case 3:
      b localb3 = a.a(this.d.southwest);
      b localb4 = a.a(this.d.northeast);
      float f2 = parame.a(localb3.b(), localb4.a(), localb4.b(), localb3.a());
      LatLng localLatLng4 = this.d.getCenter();
      return new MapStatus(paramMapStatus.rotate, localLatLng4, paramMapStatus.overlook, f2, paramMapStatus.targetScreen);
    case 4:
      return new MapStatus(paramMapStatus.rotate, this.c, paramMapStatus.overlook, this.g, paramMapStatus.targetScreen);
    case 5:
      parame.getWidth();
      LatLng localLatLng3 = a.a(parame.a(parame.getWidth() / 2 + this.h, parame.getHeight() / 2 + this.i));
      return new MapStatus(paramMapStatus.rotate, localLatLng3, paramMapStatus.overlook, paramMapStatus.zoom, paramMapStatus.targetScreen);
    case 6:
      return new MapStatus(paramMapStatus.rotate, paramMapStatus.target, paramMapStatus.overlook, paramMapStatus.zoom + this.j, paramMapStatus.targetScreen);
    case 7:
      LatLng localLatLng2 = a.a(parame.a(this.k.x, this.k.y));
      return new MapStatus(paramMapStatus.rotate, localLatLng2, paramMapStatus.overlook, paramMapStatus.zoom + this.j, this.k);
    case 8:
      return new MapStatus(paramMapStatus.rotate, paramMapStatus.target, paramMapStatus.overlook, this.g, paramMapStatus.targetScreen);
    case 9:
    }
    b localb1 = a.a(this.d.southwest);
    b localb2 = a.a(this.d.northeast);
    float f1 = parame.a(localb1.b(), localb2.a(), localb2.b(), localb1.a(), this.e, this.f);
    LatLng localLatLng1 = this.d.getCenter();
    return new MapStatus(paramMapStatus.rotate, localLatLng1, paramMapStatus.overlook, f1, paramMapStatus.targetScreen);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.map.MapStatusUpdate
 * JD-Core Version:    0.6.2
 */