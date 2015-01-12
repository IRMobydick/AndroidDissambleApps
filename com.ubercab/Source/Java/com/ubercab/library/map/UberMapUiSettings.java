package com.ubercab.library.map;

import com.ubercab.library.map.internal.model.IUberMapUiSettings;

public class UberMapUiSettings
{
  private final IUberMapUiSettings mMapUiSettings;

  public UberMapUiSettings(IUberMapUiSettings paramIUberMapUiSettings)
  {
    this.mMapUiSettings = paramIUberMapUiSettings;
  }

  IUberMapUiSettings getMapUiSettings()
  {
    return this.mMapUiSettings;
  }

  public boolean isCompassEnabled()
  {
    return this.mMapUiSettings.isCompassEnabled();
  }

  public boolean isRotateGesturesEnabled()
  {
    return this.mMapUiSettings.isRotateGesturesEnabled();
  }

  public boolean isScrollGesturesEnabled()
  {
    return this.mMapUiSettings.isScrollGesturesEnabled();
  }

  public boolean isTiltGesturesEnabled()
  {
    return this.mMapUiSettings.isTiltGesturesEnabled();
  }

  public boolean isZoomGesturesEnabled()
  {
    return this.mMapUiSettings.isZoomGesturesEnabled();
  }

  public void setAllGesturesEnabled(boolean paramBoolean)
  {
    this.mMapUiSettings.setAllGesturesEnabled(paramBoolean);
  }

  public void setCompassEnabled(boolean paramBoolean)
  {
    this.mMapUiSettings.setCompassEnabled(paramBoolean);
  }

  public void setMyLocationButtonEnabled(boolean paramBoolean)
  {
    this.mMapUiSettings.setMyLocationButtonEnabled(paramBoolean);
  }

  public void setRotateGesturesEnabled(boolean paramBoolean)
  {
    this.mMapUiSettings.setRotateGesturesEnabled(paramBoolean);
  }

  public void setScrollGesturesEnabled(boolean paramBoolean)
  {
    this.mMapUiSettings.setScrollGesturesEnabled(paramBoolean);
  }

  public void setTiltGesturesEnabled(boolean paramBoolean)
  {
    this.mMapUiSettings.setTiltGesturesEnabled(paramBoolean);
  }

  public void setZoomControlsEnabled(boolean paramBoolean)
  {
    this.mMapUiSettings.setZoomControlsEnabled(paramBoolean);
  }

  public void setZoomGesturesEnabled(boolean paramBoolean)
  {
    this.mMapUiSettings.setZoomGesturesEnabled(paramBoolean);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.map.UberMapUiSettings
 * JD-Core Version:    0.6.2
 */