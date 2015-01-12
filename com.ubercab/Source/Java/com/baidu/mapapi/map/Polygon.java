package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.a;
import com.baidu.platform.comapi.a.b;
import com.baidu.platform.comapi.map.d;
import java.util.List;

public final class Polygon extends Overlay
{
  Stroke a;
  int b;
  List<LatLng> c;

  Polygon()
  {
    this.k = d.j;
  }

  Bundle a(Bundle paramBundle)
  {
    super.a(paramBundle);
    b localb = a.a((LatLng)this.c.get(0));
    paramBundle.putInt("location_x", localb.b());
    paramBundle.putInt("location_y", localb.a());
    Overlay.a(this.c, paramBundle);
    Overlay.a(this.b, paramBundle);
    if (this.a == null)
    {
      paramBundle.putInt("has_stroke", 0);
      return paramBundle;
    }
    paramBundle.putInt("has_stroke", 1);
    Bundle localBundle = new Bundle();
    paramBundle.putBundle("stroke", this.a.a(localBundle));
    return paramBundle;
  }

  public int getFillColor()
  {
    return this.b;
  }

  public List<LatLng> getPoints()
  {
    return this.c;
  }

  public Stroke getStroke()
  {
    return this.a;
  }

  public void setFillColor(int paramInt)
  {
    this.b = paramInt;
    this.listener.b(this);
  }

  public void setPoints(List<LatLng> paramList)
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
    this.c = paramList;
    this.listener.b(this);
  }

  public void setStroke(Stroke paramStroke)
  {
    this.a = paramStroke;
    this.listener.b(this);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.map.Polygon
 * JD-Core Version:    0.6.2
 */