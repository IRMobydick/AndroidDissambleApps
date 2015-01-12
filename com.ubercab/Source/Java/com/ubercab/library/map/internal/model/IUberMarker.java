package com.ubercab.library.map.internal.model;

import com.ubercab.library.location.model.UberLatLng;

public abstract interface IUberMarker
{
  public abstract float getAlpha();

  public abstract String getId();

  public abstract UberLatLng getPosition();

  public abstract float getRotation();

  public abstract void remove();

  public abstract void setAlpha(float paramFloat);

  public abstract void setIcon(IUberBitmapDescriptor paramIUberBitmapDescriptor);

  public abstract void setPosition(UberLatLng paramUberLatLng);

  public abstract void setRotation(float paramFloat);

  public abstract void setVisible(boolean paramBoolean);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.map.internal.model.IUberMarker
 * JD-Core Version:    0.6.2
 */