package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.a;
import com.baidu.platform.comapi.a.b;
import com.baidu.platform.comapi.map.d;

public final class Marker extends Overlay
{
  LatLng a;
  BitmapDescriptor b;
  float c;
  float d;
  boolean e;
  boolean f;
  float g;
  String h;

  Marker()
  {
    this.k = d.c;
  }

  Bundle a(Bundle paramBundle)
  {
    super.a(paramBundle);
    paramBundle.putBundle("image_info", this.b.b());
    b localb = a.a(this.a);
    paramBundle.putInt("location_x", localb.b());
    paramBundle.putInt("location_y", localb.a());
    if (this.e);
    for (int i = 1; ; i = 0)
    {
      paramBundle.putInt("perspective", i);
      paramBundle.putFloat("anchor_x", this.c);
      paramBundle.putFloat("anchor_y", this.d);
      paramBundle.putFloat("rotate", this.g);
      return paramBundle;
    }
  }

  public float getAnchorX()
  {
    return this.c;
  }

  public float getAnchorY()
  {
    return this.d;
  }

  public BitmapDescriptor getIcon()
  {
    return this.b;
  }

  public LatLng getPosition()
  {
    return this.a;
  }

  public float getRotate()
  {
    return this.g;
  }

  public String getTitle()
  {
    return this.h;
  }

  public boolean isDraggable()
  {
    return this.f;
  }

  public boolean isPerspective()
  {
    return this.e;
  }

  public void setAnchor(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 < 0.0F) || (paramFloat1 > 1.0F));
    while ((paramFloat2 < 0.0F) || (paramFloat2 > 1.0F))
      return;
    this.c = paramFloat1;
    this.d = paramFloat2;
    this.listener.b(this);
  }

  public void setDraggable(boolean paramBoolean)
  {
    this.f = paramBoolean;
    this.listener.b(this);
  }

  public void setIcon(BitmapDescriptor paramBitmapDescriptor)
  {
    if (paramBitmapDescriptor == null)
      throw new IllegalArgumentException("marker's icon can not be null");
    this.b = paramBitmapDescriptor;
    this.listener.b(this);
  }

  public void setPerspective(boolean paramBoolean)
  {
    this.e = paramBoolean;
    this.listener.b(this);
  }

  public void setPosition(LatLng paramLatLng)
  {
    if (paramLatLng == null)
      throw new IllegalArgumentException("marker's position can not be null");
    this.a = paramLatLng;
    this.listener.b(this);
  }

  public void setRotate(float paramFloat)
  {
    while (paramFloat < 0.0F)
      paramFloat += 360.0F;
    this.g = (paramFloat % 360.0F);
    this.listener.b(this);
  }

  public void setTitle(String paramString)
  {
    this.h = paramString;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.map.Marker
 * JD-Core Version:    0.6.2
 */