package com.ubercab.library.vendor.google.map.model;

import android.os.Bundle;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CameraPosition.Builder;
import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.map.internal.model.IUberCameraPosition;
import com.ubercab.library.map.internal.model.IUberCameraPosition.Builder;
import com.ubercab.library.vendor.google.GoogleUtils;

public class GoogleCameraPositionAdapter
  implements IUberCameraPosition
{
  private final CameraPosition mCameraPosition;

  public GoogleCameraPositionAdapter(CameraPosition paramCameraPosition)
  {
    this.mCameraPosition = paramCameraPosition;
  }

  public GoogleCameraPositionAdapter(String paramString, Bundle paramBundle)
  {
    this.mCameraPosition = ((CameraPosition)paramBundle.getParcelable(paramString));
  }

  public float getBearing()
  {
    return this.mCameraPosition.bearing;
  }

  public CameraPosition getCameraPosition()
  {
    return this.mCameraPosition;
  }

  public UberLatLng getTarget()
  {
    return GoogleUtils.convertLatLng(this.mCameraPosition.target);
  }

  public float getTilt()
  {
    return this.mCameraPosition.tilt;
  }

  public float getZoom()
  {
    return this.mCameraPosition.zoom;
  }

  public void writeToBundle(String paramString, Bundle paramBundle)
  {
    paramBundle.putParcelable(paramString, this.mCameraPosition);
  }

  public static class Builder
    implements IUberCameraPosition.Builder
  {
    private CameraPosition.Builder mBuilder = new CameraPosition.Builder();

    public IUberCameraPosition.Builder bearing(float paramFloat)
    {
      this.mBuilder = this.mBuilder.bearing(paramFloat);
      return this;
    }

    public IUberCameraPosition build()
    {
      return new GoogleCameraPositionAdapter(this.mBuilder.build());
    }

    public IUberCameraPosition.Builder target(UberLatLng paramUberLatLng)
    {
      this.mBuilder = this.mBuilder.target(GoogleUtils.convertLatLng(paramUberLatLng));
      return this;
    }

    public IUberCameraPosition.Builder tilt(float paramFloat)
    {
      this.mBuilder = this.mBuilder.tilt(paramFloat);
      return this;
    }

    public IUberCameraPosition.Builder zoom(float paramFloat)
    {
      this.mBuilder = this.mBuilder.zoom(paramFloat);
      return this;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.vendor.google.map.model.GoogleCameraPositionAdapter
 * JD-Core Version:    0.6.2
 */