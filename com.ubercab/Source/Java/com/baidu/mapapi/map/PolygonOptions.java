package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import java.util.List;

public final class PolygonOptions extends OverlayOptions
{
  int a;
  boolean b = true;
  Bundle c;
  private Stroke d;
  private int e = -16777216;
  private List<LatLng> f;

  Overlay a()
  {
    Polygon localPolygon = new Polygon();
    localPolygon.m = this.b;
    localPolygon.l = this.a;
    localPolygon.n = this.c;
    if ((this.f == null) || (this.f.size() < 2))
      throw new IllegalStateException("when you add polyline, you must at least supply 2 points");
    localPolygon.c = this.f;
    localPolygon.b = this.e;
    localPolygon.a = this.d;
    return localPolygon;
  }

  public PolygonOptions extraInfo(Bundle paramBundle)
  {
    this.c = paramBundle;
    return this;
  }

  public PolygonOptions fillColor(int paramInt)
  {
    this.e = paramInt;
    return this;
  }

  public Bundle getExtraInfo()
  {
    return this.c;
  }

  public int getFillColor()
  {
    return this.e;
  }

  public List<LatLng> getPoints()
  {
    return this.f;
  }

  public Stroke getStroke()
  {
    return this.d;
  }

  public int getZIndex()
  {
    return this.a;
  }

  public boolean isVisible()
  {
    return this.b;
  }

  public PolygonOptions points(List<LatLng> paramList)
  {
    if (paramList == null)
      throw new IllegalArgumentException("points list can not be null");
    if (paramList.size() <= 2)
      throw new IllegalArgumentException("points count can not less than three");
    if (paramList.contains(null))
      throw new IllegalArgumentException("points list can not contains null");
    for (int i = 0; i < paramList.size(); i++)
      for (int j = i + 1; j < paramList.size(); j++)
        if ((LatLng)paramList.get(i) == (LatLng)paramList.get(j))
          throw new IllegalArgumentException("points list can not has same points");
    this.f = paramList;
    return this;
  }

  public PolygonOptions stroke(Stroke paramStroke)
  {
    this.d = paramStroke;
    return this;
  }

  public PolygonOptions visible(boolean paramBoolean)
  {
    this.b = paramBoolean;
    return this;
  }

  public PolygonOptions zIndex(int paramInt)
  {
    this.a = paramInt;
    return this;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.map.PolygonOptions
 * JD-Core Version:    0.6.2
 */