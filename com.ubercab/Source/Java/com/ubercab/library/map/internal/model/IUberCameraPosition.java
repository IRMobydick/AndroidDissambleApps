package com.ubercab.library.map.internal.model;

import android.os.Bundle;
import com.ubercab.library.location.model.UberLatLng;

public abstract interface IUberCameraPosition
{
  public abstract float getBearing();

  public abstract UberLatLng getTarget();

  public abstract float getTilt();

  public abstract float getZoom();

  public abstract void writeToBundle(String paramString, Bundle paramBundle);

  public static abstract interface Builder
  {
    public abstract Builder bearing(float paramFloat);

    public abstract IUberCameraPosition build();

    public abstract Builder target(UberLatLng paramUberLatLng);

    public abstract Builder tilt(float paramFloat);

    public abstract Builder zoom(float paramFloat);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.map.internal.model.IUberCameraPosition
 * JD-Core Version:    0.6.2
 */