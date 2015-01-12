package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.a;
import com.baidu.platform.comapi.a.b;
import com.baidu.platform.comapi.map.d;

public final class GroundOverlay extends Overlay
{
  private static final String o = GroundOverlay.class.getSimpleName();
  int a;
  BitmapDescriptor b;
  LatLng c;
  int d;
  int e;
  float f;
  float g;
  LatLngBounds h;
  float i;

  GroundOverlay()
  {
    this.k = d.d;
  }

  Bundle a(Bundle paramBundle)
  {
    super.a(paramBundle);
    paramBundle.putBundle("image_info", this.b.b());
    if (this.a == 1)
    {
      b localb2 = a.a(this.h.southwest);
      int j = localb2.b();
      int k = localb2.a();
      b localb3 = a.a(this.h.northeast);
      int m = localb3.b();
      int n = localb3.a();
      this.d = (m - j);
      this.e = (n - k);
      this.c = a.a(new b(k + this.e / 2, j + this.d / 2));
      this.f = 0.5F;
      this.g = 0.5F;
    }
    if ((this.d <= 0) || (this.e <= 0))
      throw new IllegalStateException("when you add ground overlay, the width and height must greater than 0");
    paramBundle.putInt("x_distance", this.d);
    if (this.e == 2147483647)
      this.e = ((int)(this.d * this.b.a.getHeight() / this.b.a.getWidth()));
    paramBundle.putInt("y_distance", this.e);
    b localb1 = a.a(this.c);
    paramBundle.putInt("location_x", localb1.b());
    paramBundle.putInt("location_y", localb1.a());
    paramBundle.putFloat("anchor_x", this.f);
    paramBundle.putFloat("anchor_y", this.g);
    paramBundle.putFloat("transparency", this.i);
    return paramBundle;
  }

  public float getAnchorX()
  {
    return this.f;
  }

  public float getAnchorY()
  {
    return this.g;
  }

  public LatLngBounds getBounds()
  {
    return this.h;
  }

  public int getHeight()
  {
    return this.e;
  }

  public BitmapDescriptor getImage()
  {
    return this.b;
  }

  public LatLng getPosition()
  {
    return this.c;
  }

  public float getTransparency()
  {
    return this.i;
  }

  public int getWidth()
  {
    return this.d;
  }

  public void setAnchor(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 < 0.0F) || (paramFloat1 > 1.0F));
    while ((paramFloat2 < 0.0F) || (paramFloat2 > 1.0F))
      return;
    this.f = paramFloat1;
    this.g = paramFloat2;
    this.listener.b(this);
  }

  public void setDimensions(int paramInt)
  {
    this.d = paramInt;
    this.e = 2147483647;
    this.listener.b(this);
  }

  public void setDimensions(int paramInt1, int paramInt2)
  {
    this.d = paramInt1;
    this.e = paramInt2;
    this.listener.b(this);
  }

  public void setImage(BitmapDescriptor paramBitmapDescriptor)
  {
    if (paramBitmapDescriptor == null)
      throw new IllegalArgumentException("image can not be null");
    this.b = paramBitmapDescriptor;
    this.listener.b(this);
  }

  public void setPosition(LatLng paramLatLng)
  {
    if (paramLatLng == null)
      throw new IllegalArgumentException("position can not be null");
    this.a = 2;
    this.c = paramLatLng;
    this.listener.b(this);
  }

  public void setPositionFromBounds(LatLngBounds paramLatLngBounds)
  {
    if (paramLatLngBounds == null)
      throw new IllegalArgumentException("bounds can not be null");
    this.a = 1;
    this.h = paramLatLngBounds;
    this.listener.b(this);
  }

  public void setTransparency(float paramFloat)
  {
    if ((paramFloat > 1.0F) || (paramFloat < 0.0F))
      return;
    this.i = paramFloat;
    this.listener.b(this);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.map.GroundOverlay
 * JD-Core Version:    0.6.2
 */