package com.ubercab.client.feature.trip.slider;

import java.util.Map;

public final class VehicleTextBitmapsEvent
{
  final Map<String, VehicleTextBitmap> mVehicleTextBitmapMap;

  public VehicleTextBitmapsEvent(Map<String, VehicleTextBitmap> paramMap)
  {
    this.mVehicleTextBitmapMap = paramMap;
  }

  public Map<String, VehicleTextBitmap> getVehicleTextBitmapMap()
  {
    return this.mVehicleTextBitmapMap;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.slider.VehicleTextBitmapsEvent
 * JD-Core Version:    0.6.2
 */