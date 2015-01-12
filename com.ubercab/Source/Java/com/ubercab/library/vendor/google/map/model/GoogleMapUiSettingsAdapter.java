package com.ubercab.library.vendor.google.map.model;

import com.google.android.gms.maps.UiSettings;
import com.ubercab.library.map.internal.model.IUberMapUiSettings;

public class GoogleMapUiSettingsAdapter
  implements IUberMapUiSettings
{
  private final UiSettings mUiSettings;

  public GoogleMapUiSettingsAdapter(UiSettings paramUiSettings)
  {
    this.mUiSettings = paramUiSettings;
  }

  public boolean isCompassEnabled()
  {
    return this.mUiSettings.isCompassEnabled();
  }

  public boolean isRotateGesturesEnabled()
  {
    return this.mUiSettings.isRotateGesturesEnabled();
  }

  public boolean isScrollGesturesEnabled()
  {
    return this.mUiSettings.isScrollGesturesEnabled();
  }

  public boolean isTiltGesturesEnabled()
  {
    return this.mUiSettings.isTiltGesturesEnabled();
  }

  public boolean isZoomGesturesEnabled()
  {
    return this.mUiSettings.isZoomGesturesEnabled();
  }

  public void setAllGesturesEnabled(boolean paramBoolean)
  {
    this.mUiSettings.setAllGesturesEnabled(paramBoolean);
  }

  public void setCompassEnabled(boolean paramBoolean)
  {
    this.mUiSettings.setCompassEnabled(paramBoolean);
  }

  public void setMyLocationButtonEnabled(boolean paramBoolean)
  {
    this.mUiSettings.setMyLocationButtonEnabled(paramBoolean);
  }

  public void setRotateGesturesEnabled(boolean paramBoolean)
  {
    this.mUiSettings.setRotateGesturesEnabled(paramBoolean);
  }

  public void setScrollGesturesEnabled(boolean paramBoolean)
  {
    this.mUiSettings.setScrollGesturesEnabled(paramBoolean);
  }

  public void setTiltGesturesEnabled(boolean paramBoolean)
  {
    this.mUiSettings.setTiltGesturesEnabled(paramBoolean);
  }

  public void setZoomControlsEnabled(boolean paramBoolean)
  {
    this.mUiSettings.setZoomControlsEnabled(paramBoolean);
  }

  public void setZoomGesturesEnabled(boolean paramBoolean)
  {
    this.mUiSettings.setZoomGesturesEnabled(paramBoolean);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.vendor.google.map.model.GoogleMapUiSettingsAdapter
 * JD-Core Version:    0.6.2
 */