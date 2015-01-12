package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import java.util.List;

public final class PolylineOptions extends OverlayOptions
{
  int a;
  boolean b = true;
  Bundle c;
  private int d = -16777216;
  private List<LatLng> e;
  private int f = 5;

  Overlay a()
  {
    Polyline localPolyline = new Polyline();
    localPolyline.m = this.b;
    localPolyline.l = this.a;
    localPolyline.n = this.c;
    if ((this.e == null) || (this.e.size() < 2))
      throw new IllegalStateException("when you add polyline, you must at least supply 2 points");
    localPolyline.b = this.e;
    localPolyline.a = this.d;
    localPolyline.c = this.f;
    return localPolyline;
  }

  public PolylineOptions color(int paramInt)
  {
    this.d = paramInt;
    return this;
  }

  public PolylineOptions extraInfo(Bundle paramBundle)
  {
    this.c = paramBundle;
    return this;
  }

  public int getColor()
  {
    return this.d;
  }

  public Bundle getExtraInfo()
  {
    return this.c;
  }

  public List<LatLng> getPoints()
  {
    return this.e;
  }

  public int getWidth()
  {
    return this.f;
  }

  public int getZIndex()
  {
    return this.a;
  }

  public boolean isVisible()
  {
    return this.b;
  }

  public PolylineOptions points(List<LatLng> paramList)
  {
    if (paramList == null)
      throw new IllegalArgumentException("points list can not be null");
    if ((paramList.size() < 2) || (paramList.size() > 10000))
      throw new IllegalArgumentException("points count can not less than 2 or more than 10000");
    if (paramList.contains(null))
      throw new IllegalArgumentException("points list can not contains null");
    this.e = paramList;
    return this;
  }

  public PolylineOptions visible(boolean paramBoolean)
  {
    this.b = paramBoolean;
    return this;
  }

  public PolylineOptions width(int paramInt)
  {
    if (paramInt > 0)
      this.f = paramInt;
    return this;
  }

  public PolylineOptions zIndex(int paramInt)
  {
    this.a = paramInt;
    return this;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.map.PolylineOptions
 * JD-Core Version:    0.6.2
 */