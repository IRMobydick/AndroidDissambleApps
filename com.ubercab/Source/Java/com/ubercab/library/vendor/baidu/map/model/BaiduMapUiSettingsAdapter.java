package com.ubercab.library.vendor.baidu.map.model;

import com.baidu.mapapi.map.UiSettings;
import com.ubercab.library.map.internal.model.IUberMapUiSettings;

public class BaiduMapUiSettingsAdapter
  implements IUberMapUiSettings
{
  private final UiSettings mUiSettings;

  public BaiduMapUiSettingsAdapter(UiSettings paramUiSettings)
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
    return this.mUiSettings.isOverlookingGesturesEnabled();
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
    this.mUiSettings.setOverlookingGesturesEnabled(paramBoolean);
  }

  public void setZoomControlsEnabled(boolean paramBoolean)
  {
  }

  public void setZoomGesturesEnabled(boolean paramBoolean)
  {
    this.mUiSettings.setZoomGesturesEnabled(paramBoolean);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.vendor.baidu.map.model.BaiduMapUiSettingsAdapter
 * JD-Core Version:    0.6.2
 */