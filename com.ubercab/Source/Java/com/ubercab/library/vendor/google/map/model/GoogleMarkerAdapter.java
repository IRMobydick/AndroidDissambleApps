package com.ubercab.library.vendor.google.map.model;

import com.google.android.gms.maps.model.Marker;
import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.map.internal.model.IUberBitmapDescriptor;
import com.ubercab.library.map.internal.model.IUberMarker;
import com.ubercab.library.vendor.google.GoogleUtils;

public class GoogleMarkerAdapter
  implements IUberMarker
{
  private final Marker mMarker;

  public GoogleMarkerAdapter(Marker paramMarker)
  {
    this.mMarker = paramMarker;
  }

  public float getAlpha()
  {
    return this.mMarker.getAlpha();
  }

  public String getId()
  {
    return this.mMarker.getId();
  }

  public Marker getMarker()
  {
    return this.mMarker;
  }

  public UberLatLng getPosition()
  {
    return GoogleUtils.convertLatLng(this.mMarker.getPosition());
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

  public void setIcon(IUberBitmapDescriptor paramIUberBitmapDescriptor)
  {
    this.mMarker.setIcon(((GoogleBitmapDescriptorAdapter)paramIUberBitmapDescriptor).getBitmapDescriptor());
  }

  public void setPosition(UberLatLng paramUberLatLng)
  {
    this.mMarker.setPosition(GoogleUtils.convertLatLng(paramUberLatLng));
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
 * Qualified Name:     com.ubercab.library.vendor.google.map.model.GoogleMarkerAdapter
 * JD-Core Version:    0.6.2
 */