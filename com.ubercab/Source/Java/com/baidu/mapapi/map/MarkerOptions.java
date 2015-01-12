package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;

public final class MarkerOptions extends OverlayOptions
{
  int a;
  boolean b = true;
  Bundle c;
  private LatLng d;
  private BitmapDescriptor e;
  private float f = 0.5F;
  private float g = 1.0F;
  private boolean h = true;
  private boolean i = false;
  private float j;
  private String k;

  Overlay a()
  {
    Marker localMarker = new Marker();
    localMarker.m = this.b;
    localMarker.l = this.a;
    localMarker.n = this.c;
    if (this.d == null)
      throw new IllegalStateException("when you add marker, you must set the position");
    localMarker.a = this.d;
    if (this.e == null)
      throw new IllegalStateException("when you add marker, you must set the icon");
    localMarker.b = this.e;
    localMarker.c = this.f;
    localMarker.d = this.g;
    localMarker.e = this.h;
    localMarker.f = this.i;
    localMarker.g = this.j;
    localMarker.h = this.k;
    return localMarker;
  }

  public MarkerOptions anchor(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 < 0.0F) || (paramFloat1 > 1.0F));
    while ((paramFloat2 < 0.0F) || (paramFloat2 > 1.0F))
      return this;
    this.f = paramFloat1;
    this.g = paramFloat2;
    return this;
  }

  public MarkerOptions draggable(boolean paramBoolean)
  {
    this.i = paramBoolean;
    return this;
  }

  public MarkerOptions extraInfo(Bundle paramBundle)
  {
    this.c = paramBundle;
    return this;
  }

  public float getAnchorX()
  {
    return this.f;
  }

  public float getAnchorY()
  {
    return this.g;
  }

  public Bundle getExtraInfo()
  {
    return this.c;
  }

  public BitmapDescriptor getIcon()
  {
    return this.e;
  }

  public LatLng getPosition()
  {
    return this.d;
  }

  public float getRotate()
  {
    return this.j;
  }

  public String getTitle()
  {
    return this.k;
  }

  public int getZIndex()
  {
    return this.a;
  }

  public MarkerOptions icon(BitmapDescriptor paramBitmapDescriptor)
  {
    if (paramBitmapDescriptor == null)
      throw new IllegalArgumentException("marker's icon can not be null");
    this.e = paramBitmapDescriptor;
    return this;
  }

  public boolean isDraggable()
  {
    return this.i;
  }

  public boolean isPerspective()
  {
    return this.h;
  }

  public boolean isVisible()
  {
    return this.b;
  }

  public MarkerOptions perspective(boolean paramBoolean)
  {
    this.h = paramBoolean;
    return this;
  }

  public MarkerOptions position(LatLng paramLatLng)
  {
    if (paramLatLng == null)
      throw new IllegalArgumentException("marker's position can not be null");
    this.d = paramLatLng;
    return this;
  }

  public MarkerOptions rotate(float paramFloat)
  {
    while (paramFloat < 0.0F)
      paramFloat += 360.0F;
    this.j = (paramFloat % 360.0F);
    return this;
  }

  public MarkerOptions title(String paramString)
  {
    this.k = paramString;
    return this;
  }

  public MarkerOptions visible(boolean paramBoolean)
  {
    this.b = paramBoolean;
    return this;
  }

  public MarkerOptions zIndex(int paramInt)
  {
    this.a = paramInt;
    return this;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.map.MarkerOptions
 * JD-Core Version:    0.6.2
 */