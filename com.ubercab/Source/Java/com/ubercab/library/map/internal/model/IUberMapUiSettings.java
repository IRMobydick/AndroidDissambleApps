package com.ubercab.library.map.internal.model;

public abstract interface IUberMapUiSettings
{
  public abstract boolean isCompassEnabled();

  public abstract boolean isRotateGesturesEnabled();

  public abstract boolean isScrollGesturesEnabled();

  public abstract boolean isTiltGesturesEnabled();

  public abstract boolean isZoomGesturesEnabled();

  public abstract void setAllGesturesEnabled(boolean paramBoolean);

  public abstract void setCompassEnabled(boolean paramBoolean);

  public abstract void setMyLocationButtonEnabled(boolean paramBoolean);

  public abstract void setRotateGesturesEnabled(boolean paramBoolean);

  public abstract void setScrollGesturesEnabled(boolean paramBoolean);

  public abstract void setTiltGesturesEnabled(boolean paramBoolean);

  public abstract void setZoomControlsEnabled(boolean paramBoolean);

  public abstract void setZoomGesturesEnabled(boolean paramBoolean);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.map.internal.model.IUberMapUiSettings
 * JD-Core Version:    0.6.2
 */