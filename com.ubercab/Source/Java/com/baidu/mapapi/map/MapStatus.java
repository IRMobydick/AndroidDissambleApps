package com.baidu.mapapi.map;

import android.graphics.Point;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.a;
import com.baidu.platform.comapi.a.b;
import com.baidu.platform.comapi.map.w;

public final class MapStatus
{
  public final float overlook;
  public final float rotate;
  public final LatLng target;
  public final Point targetScreen;
  public final float zoom;

  MapStatus(float paramFloat1, LatLng paramLatLng, float paramFloat2, float paramFloat3, Point paramPoint)
  {
    this.rotate = paramFloat1;
    this.target = paramLatLng;
    this.overlook = paramFloat2;
    this.zoom = paramFloat3;
    this.targetScreen = paramPoint;
  }

  static MapStatus a(w paramw)
  {
    return new MapStatus(paramw.b, a.a(new b(paramw.e, paramw.d)), paramw.c, paramw.a, new Point(paramw.f, paramw.g));
  }

  w a()
  {
    return b(new w());
  }

  w b(w paramw)
  {
    if (this.rotate != -2.147484E+009F)
      paramw.b = ((int)this.rotate);
    if (this.zoom != -2.147484E+009F)
      paramw.a = this.zoom;
    if (this.overlook != -2.147484E+009F)
      paramw.c = ((int)this.overlook);
    if (this.target != null)
    {
      b localb = a.a(this.target);
      paramw.d = localb.b();
      paramw.e = localb.a();
    }
    if (this.targetScreen != null)
    {
      paramw.f = this.targetScreen.x;
      paramw.g = this.targetScreen.y;
    }
    return paramw;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.target != null)
    {
      localStringBuilder.append("target lat: " + this.target.latitude + "\n");
      localStringBuilder.append("target lng: " + this.target.longitude + "\n");
    }
    if (this.targetScreen != null)
    {
      localStringBuilder.append("target screen x: " + this.targetScreen.x + "\n");
      localStringBuilder.append("target screen y: " + this.targetScreen.y + "\n");
    }
    localStringBuilder.append("zoom: " + this.zoom + "\n");
    localStringBuilder.append("rotate: " + this.rotate + "\n");
    localStringBuilder.append("overlook: " + this.overlook + "\n");
    return localStringBuilder.toString();
  }

  public static final class Builder
  {
    private float a = -2.147484E+009F;
    private LatLng b = null;
    private float c = -2.147484E+009F;
    private float d = -2.147484E+009F;
    private Point e = null;

    public Builder()
    {
    }

    public Builder(MapStatus paramMapStatus)
    {
      this.a = paramMapStatus.rotate;
      this.b = paramMapStatus.target;
      this.c = paramMapStatus.overlook;
      this.d = paramMapStatus.zoom;
      this.e = paramMapStatus.targetScreen;
    }

    public MapStatus build()
    {
      return new MapStatus(this.a, this.b, this.c, this.d, this.e);
    }

    public Builder overlook(float paramFloat)
    {
      this.c = paramFloat;
      return this;
    }

    public Builder rotate(float paramFloat)
    {
      this.a = paramFloat;
      return this;
    }

    public Builder target(LatLng paramLatLng)
    {
      this.b = paramLatLng;
      return this;
    }

    public Builder targetScreen(Point paramPoint)
    {
      this.e = paramPoint;
      return this;
    }

    public Builder zoom(float paramFloat)
    {
      this.d = paramFloat;
      return this;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.map.MapStatus
 * JD-Core Version:    0.6.2
 */