package com.ubercab.library.vendor.google.map.model;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.map.internal.model.IUberBitmapDescriptor;
import com.ubercab.library.map.internal.model.IUberMarkerOptions;

public class GoogleMarkerOptionsAdapter
  implements IUberMarkerOptions
{
  private MarkerOptions mMarkerOptions = new MarkerOptions();

  public IUberMarkerOptions alpha(float paramFloat)
  {
    this.mMarkerOptions = this.mMarkerOptions.alpha(paramFloat);
    return this;
  }

  public IUberMarkerOptions anchor(float paramFloat1, float paramFloat2)
  {
    this.mMarkerOptions = this.mMarkerOptions.anchor(paramFloat1, paramFloat2);
    return this;
  }

  public MarkerOptions getMarkerOptions()
  {
    return this.mMarkerOptions;
  }

  public IUberMarkerOptions icon(IUberBitmapDescriptor paramIUberBitmapDescriptor)
  {
    this.mMarkerOptions = this.mMarkerOptions.icon(((GoogleBitmapDescriptorAdapter)paramIUberBitmapDescriptor).getBitmapDescriptor());
    return this;
  }

  public IUberMarkerOptions position(UberLatLng paramUberLatLng)
  {
    this.mMarkerOptions = this.mMarkerOptions.position(new LatLng(paramUberLatLng.getLatitude(), paramUberLatLng.getLongitude()));
    return this;
  }

  public IUberMarkerOptions rotation(float paramFloat)
  {
    this.mMarkerOptions = this.mMarkerOptions.rotation(paramFloat);
    return this;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.vendor.google.map.model.GoogleMarkerOptionsAdapter
 * JD-Core Version:    0.6.2
 */