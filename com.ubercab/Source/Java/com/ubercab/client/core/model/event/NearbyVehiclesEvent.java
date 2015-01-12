package com.ubercab.client.core.model.event;

import com.ubercab.client.core.model.NearbyVehicle;
import java.util.Map;

public final class NearbyVehiclesEvent
{
  private final Map<String, NearbyVehicle> mNearbyVehicles;

  public NearbyVehiclesEvent(Map<String, NearbyVehicle> paramMap)
  {
    this.mNearbyVehicles = paramMap;
  }

  public Map<String, NearbyVehicle> getNearbyVehicles()
  {
    return this.mNearbyVehicles;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.event.NearbyVehiclesEvent
 * JD-Core Version:    0.6.2
 */