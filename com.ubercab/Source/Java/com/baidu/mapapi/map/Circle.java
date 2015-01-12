package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.a;
import com.baidu.platform.comapi.a.b;
import com.baidu.platform.comapi.map.d;

public final class Circle extends Overlay
{
  LatLng a;
  int b;
  int c;
  Stroke d;

  Circle()
  {
    this.k = d.h;
  }

  Bundle a(Bundle paramBundle)
  {
    super.a(paramBundle);
    b localb = a.a(this.a);
    paramBundle.putInt("location_x", localb.b());
    paramBundle.putInt("location_y", localb.a());
    paramBundle.putInt("radius", a.a(this.a, this.c));
    Overlay.a(this.b, paramBundle);
    if (this.d == null)
    {
      paramBundle.putInt("has_stroke", 0);
      return paramBundle;
    }
    paramBundle.putInt("has_stroke", 1);
    Bundle localBundle = new Bundle();
    paramBundle.putBundle("stroke", this.d.a(localBundle));
    return paramBundle;
  }

  public LatLng getCenter()
  {
    return this.a;
  }

  public int getFillColor()
  {
    return this.b;
  }

  public int getRadius()
  {
    return this.c;
  }

  public Stroke getStroke()
  {
    return this.d;
  }

  public void setCenter(LatLng paramLatLng)
  {
    if (paramLatLng == null)
      throw new IllegalArgumentException("circle center can not be null");
    this.a = paramLatLng;
    this.listener.b(this);
  }

  public void setFillColor(int paramInt)
  {
    this.b = paramInt;
    this.listener.b(this);
  }

  public void setRadius(int paramInt)
  {
    this.c = paramInt;
    this.listener.b(this);
  }

  public void setStroke(Stroke paramStroke)
  {
    this.d = paramStroke;
    this.listener.b(this);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.map.Circle
 * JD-Core Version:    0.6.2
 */