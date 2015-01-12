package com.ubercab.client.feature.trip.map;

import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.location.model.UberLatLngBounds;
import com.ubercab.library.map.UberCameraUpdate;
import com.ubercab.library.map.UberCameraUpdateFactory;

final class RiderCameraUpdate
{
  private boolean mAnimate;
  private UberLatLng mLatLng;
  private UberLatLngBounds mLatLngBounds;
  private int mPaddingBounds;
  private Float mZoom;

  static Builder builder()
  {
    return new Builder(null);
  }

  UberLatLng getLatLng()
  {
    return this.mLatLng;
  }

  UberLatLngBounds getLatLngBounds()
  {
    return this.mLatLngBounds;
  }

  Float getZoom()
  {
    return this.mZoom;
  }

  boolean shouldAnimate()
  {
    return this.mAnimate;
  }

  UberCameraUpdate toUberCameraUpdate(int paramInt1, int paramInt2)
  {
    UberCameraUpdateFactory localUberCameraUpdateFactory = new UberCameraUpdateFactory();
    if ((this.mLatLngBounds != null) && (paramInt1 > 0) && (paramInt2 > 0))
      return localUberCameraUpdateFactory.newLatLngBounds(this.mLatLngBounds, this.mPaddingBounds);
    if (this.mLatLng != null)
    {
      if (this.mZoom != null)
        return localUberCameraUpdateFactory.newLatLngZoom(this.mLatLng, this.mZoom.floatValue());
      return localUberCameraUpdateFactory.newLatLng(this.mLatLng);
    }
    return null;
  }

  static final class Builder
  {
    private boolean mAnimate;
    private UberLatLng mLatLng;
    private UberLatLngBounds mLatLngBounds;
    private int mPaddingBounds;
    private Float mZoom;

    Builder animate(boolean paramBoolean)
    {
      this.mAnimate = paramBoolean;
      return this;
    }

    Builder bounds(UberLatLngBounds paramUberLatLngBounds, UberLatLng paramUberLatLng, float paramFloat)
    {
      return bounds(paramUberLatLngBounds, paramUberLatLng, paramFloat, 0);
    }

    Builder bounds(UberLatLngBounds paramUberLatLngBounds, UberLatLng paramUberLatLng, float paramFloat, int paramInt)
    {
      this.mLatLngBounds = paramUberLatLngBounds;
      this.mPaddingBounds = paramInt;
      this.mLatLng = paramUberLatLng;
      this.mZoom = Float.valueOf(paramFloat);
      return this;
    }

    RiderCameraUpdate build()
    {
      RiderCameraUpdate localRiderCameraUpdate = new RiderCameraUpdate(null);
      RiderCameraUpdate.access$202(localRiderCameraUpdate, this.mLatLng);
      RiderCameraUpdate.access$302(localRiderCameraUpdate, this.mLatLngBounds);
      RiderCameraUpdate.access$402(localRiderCameraUpdate, this.mPaddingBounds);
      RiderCameraUpdate.access$502(localRiderCameraUpdate, this.mZoom);
      RiderCameraUpdate.access$602(localRiderCameraUpdate, this.mAnimate);
      return localRiderCameraUpdate;
    }

    Builder latLng(UberLatLng paramUberLatLng)
    {
      this.mLatLng = paramUberLatLng;
      this.mLatLngBounds = null;
      this.mPaddingBounds = 0;
      return this;
    }

    Builder zoom(float paramFloat)
    {
      this.mZoom = Float.valueOf(paramFloat);
      this.mLatLngBounds = null;
      this.mPaddingBounds = 0;
      return this;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.map.RiderCameraUpdate
 * JD-Core Version:    0.6.2
 */