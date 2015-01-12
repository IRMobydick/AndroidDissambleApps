package com.baidu.mapapi.map;

import com.baidu.platform.comapi.map.e;

public final class UiSettings
{
  private e a;

  UiSettings(e parame)
  {
    this.a = parame;
  }

  public boolean isCompassEnabled()
  {
    return this.a.e();
  }

  public boolean isOverlookingGesturesEnabled()
  {
    return this.a.k();
  }

  public boolean isRotateGesturesEnabled()
  {
    return this.a.j();
  }

  public boolean isScrollGesturesEnabled()
  {
    return this.a.h();
  }

  public boolean isZoomGesturesEnabled()
  {
    return this.a.i();
  }

  public void setAllGesturesEnabled(boolean paramBoolean)
  {
    setRotateGesturesEnabled(paramBoolean);
    setScrollGesturesEnabled(paramBoolean);
    setOverlookingGesturesEnabled(paramBoolean);
    setZoomGesturesEnabled(paramBoolean);
  }

  public void setCompassEnabled(boolean paramBoolean)
  {
    this.a.d(paramBoolean);
  }

  public void setOverlookingGesturesEnabled(boolean paramBoolean)
  {
    this.a.j(paramBoolean);
  }

  public void setRotateGesturesEnabled(boolean paramBoolean)
  {
    this.a.i(paramBoolean);
  }

  public void setScrollGesturesEnabled(boolean paramBoolean)
  {
    this.a.g(paramBoolean);
  }

  public void setZoomGesturesEnabled(boolean paramBoolean)
  {
    this.a.h(paramBoolean);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.map.UiSettings
 * JD-Core Version:    0.6.2
 */