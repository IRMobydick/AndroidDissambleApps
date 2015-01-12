package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.a;
import com.baidu.platform.comapi.a.b;
import com.baidu.platform.comapi.map.d;

public final class Dot extends Overlay
{
  LatLng a;
  int b;
  int c;

  Dot()
  {
    this.k = d.g;
  }

  Bundle a(Bundle paramBundle)
  {
    super.a(paramBundle);
    b localb = a.a(this.a);
    paramBundle.putInt("location_x", localb.b());
    paramBundle.putInt("location_y", localb.a());
    paramBundle.putInt("radius", this.c);
    Overlay.a(this.b, paramBundle);
    return paramBundle;
  }

  public LatLng getCenter()
  {
    return this.a;
  }

  public int getColor()
  {
    return this.b;
  }

  public int getRadius()
  {
    return this.c;
  }

  public void setCenter(LatLng paramLatLng)
  {
    if (paramLatLng == null)
      throw new IllegalArgumentException("dot center can not be null");
    this.a = paramLatLng;
    this.listener.b(this);
  }

  public void setColor(int paramInt)
  {
    this.b = paramInt;
    this.listener.b(this);
  }

  public void setRadius(int paramInt)
  {
    if (paramInt > 0)
    {
      this.c = paramInt;
      this.listener.b(this);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.map.Dot
 * JD-Core Version:    0.6.2
 */