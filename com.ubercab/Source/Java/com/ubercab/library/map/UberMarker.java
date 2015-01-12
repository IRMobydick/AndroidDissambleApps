package com.ubercab.library.map;

import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.map.internal.model.IUberMarker;

public class UberMarker
{
  private final IUberMarker mMarker;

  public UberMarker(IUberMarker paramIUberMarker)
  {
    this.mMarker = paramIUberMarker;
  }

  public float getAlpha()
  {
    return this.mMarker.getAlpha();
  }

  public String getId()
  {
    return this.mMarker.getId();
  }

  IUberMarker getMarker()
  {
    return this.mMarker;
  }

  public UberLatLng getPosition()
  {
    return this.mMarker.getPosition();
  }

  public float getRotation()
  {
    return this.mMarker.getRotation();
  }

  public void remove()
  {
    this.mMarker.remove();
  }

  public void setAlpha(float paramFloat)
  {
    this.mMarker.setAlpha(paramFloat);
  }

  public void setIcon(UberBitmapDescriptor paramUberBitmapDescriptor)
  {
    this.mMarker.setIcon(paramUberBitmapDescriptor.getBitmapDescriptor());
  }

  public void setPosition(UberLatLng paramUberLatLng)
  {
    this.mMarker.setPosition(paramUberLatLng);
  }

  public void setRotation(float paramFloat)
  {
    this.mMarker.setRotation(paramFloat);
  }

  public void setVisible(boolean paramBoolean)
  {
    this.mMarker.setVisible(paramBoolean);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.map.UberMarker
 * JD-Core Version:    0.6.2
 */