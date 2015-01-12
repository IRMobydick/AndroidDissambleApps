package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.a;
import com.baidu.platform.comapi.a.b;
import com.baidu.platform.comapi.map.d;
import java.util.ArrayList;
import java.util.List;

public final class Arc extends Overlay
{
  private static final String f = Arc.class.getSimpleName();
  int a;
  int b;
  LatLng c;
  LatLng d;
  LatLng e;

  Arc()
  {
    this.k = d.f;
  }

  Bundle a(Bundle paramBundle)
  {
    super.a(paramBundle);
    ArrayList localArrayList = new ArrayList();
    localArrayList.clear();
    localArrayList.add(this.c);
    localArrayList.add(this.d);
    localArrayList.add(this.e);
    b localb = a.a((LatLng)localArrayList.get(0));
    paramBundle.putInt("location_x", localb.b());
    paramBundle.putInt("location_y", localb.a());
    paramBundle.putInt("width", this.b);
    Overlay.a(localArrayList, paramBundle);
    Overlay.a(this.a, paramBundle);
    return paramBundle;
  }

  public int getColor()
  {
    return this.a;
  }

  public LatLng getEndPoint()
  {
    return this.e;
  }

  public LatLng getMiddlePoint()
  {
    return this.d;
  }

  public LatLng getStartPoint()
  {
    return this.c;
  }

  public int getWidth()
  {
    return this.b;
  }

  public void setColor(int paramInt)
  {
    this.a = paramInt;
    this.listener.b(this);
  }

  public void setPoints(LatLng paramLatLng1, LatLng paramLatLng2, LatLng paramLatLng3)
  {
    if ((paramLatLng1 == null) || (paramLatLng2 == null) || (paramLatLng3 == null))
      throw new IllegalArgumentException("start and middle and end points can not be null");
    if ((paramLatLng1 == paramLatLng2) || (paramLatLng1 == paramLatLng3) || (paramLatLng2 == paramLatLng3))
      throw new IllegalArgumentException("start and middle and end points can not be same");
    this.c = paramLatLng1;
    this.d = paramLatLng2;
    this.e = paramLatLng3;
    this.listener.b(this);
  }

  public void setWidth(int paramInt)
  {
    if (paramInt > 0)
    {
      this.b = paramInt;
      this.listener.b(this);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.map.Arc
 * JD-Core Version:    0.6.2
 */