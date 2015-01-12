package com.ubercab.library.vendor.google.map;

import com.google.android.gms.maps.GoogleMapOptions;
import com.ubercab.library.map.internal.IUberMapOptions;
import com.ubercab.library.map.internal.model.IUberCameraPosition;
import com.ubercab.library.vendor.google.map.model.GoogleCameraPositionAdapter;

public class GoogleMapOptionsAdapter
  implements IUberMapOptions
{
  private final GoogleMapOptions mGoogleMapOptions = new GoogleMapOptions();

  public IUberMapOptions camera(IUberCameraPosition paramIUberCameraPosition)
  {
    this.mGoogleMapOptions.camera(((GoogleCameraPositionAdapter)paramIUberCameraPosition).getCameraPosition());
    return this;
  }

  public IUberMapOptions compassEnabled(boolean paramBoolean)
  {
    this.mGoogleMapOptions.compassEnabled(paramBoolean);
    return this;
  }

  GoogleMapOptions getGoogleMapOptions()
  {
    return this.mGoogleMapOptions;
  }

  public IUberMapOptions rotateGesturesEnabled(boolean paramBoolean)
  {
    this.mGoogleMapOptions.rotateGesturesEnabled(paramBoolean);
    return this;
  }

  public IUberMapOptions scrollGesturesEnabled(boolean paramBoolean)
  {
    this.mGoogleMapOptions.scrollGesturesEnabled(paramBoolean);
    return this;
  }

  public IUberMapOptions tiltGesturesEnabled(boolean paramBoolean)
  {
    this.mGoogleMapOptions.tiltGesturesEnabled(paramBoolean);
    return this;
  }

  public IUberMapOptions zoomControlsEnabled(boolean paramBoolean)
  {
    this.mGoogleMapOptions.zoomControlsEnabled(paramBoolean);
    return this;
  }

  public IUberMapOptions zoomGesturesEnabled(boolean paramBoolean)
  {
    this.mGoogleMapOptions.zoomControlsEnabled(paramBoolean);
    return this;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.vendor.google.map.GoogleMapOptionsAdapter
 * JD-Core Version:    0.6.2
 */