package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.a;
import com.baidu.platform.comapi.a.b;
import com.baidu.platform.comapi.map.d;
import java.util.List;

public final class Polyline extends Overlay
{
  int a;
  List<LatLng> b;
  int c;

  Polyline()
  {
    this.k = d.i;
  }

  Bundle a(Bundle paramBundle)
  {
    super.a(paramBundle);
    b localb = a.a((LatLng)this.b.get(0));
    paramBundle.putInt("location_x", localb.b());
    paramBundle.putInt("location_y", localb.a());
    paramBundle.putInt("width", this.c);
    Overlay.a(this.b, paramBundle);
    Overlay.a(this.a, paramBundle);
    return paramBundle;
  }

  public int getColor()
  {
    return this.a;
  }

  public List<LatLng> getPoints()
  {
    return this.b;
  }

  public int getWidth()
  {
    return this.c;
  }

  public void setColor(int paramInt)
  {
    this.a = paramInt;
    this.listener.b(this);
  }

  public void setPoints(List<LatLng> paramList)
  {
    if (paramList == null)
      throw new IllegalArgumentException("points list can not be null");
    if ((paramList.size() < 2) || (paramList.size() > 10000))
      throw new IllegalArgumentException("points count can not less than 2 or more than 10000");
    if (paramList.contains(null))
      throw new IllegalArgumentException("points list can not contains null");
    this.b = paramList;
    this.listener.b(this);
  }

  public void setWidth(int paramInt)
  {
    if (paramInt > 0)
    {
      this.c = paramInt;
      this.listener.b(this);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.map.Polyline
 * JD-Core Version:    0.6.2
 */