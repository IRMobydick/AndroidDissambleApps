package com.ubercab.client.feature.trip.event;

public final class VehicleViewSelectedEvent
{
  private String mVehicleViewId;

  public VehicleViewSelectedEvent(String paramString)
  {
    this.mVehicleViewId = paramString;
  }

  public String getVehicleViewId()
  {
    return this.mVehicleViewId;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.event.VehicleViewSelectedEvent
 * JD-Core Version:    0.6.2
 */