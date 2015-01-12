package com.ubercab.client.core.model.event;

import com.ubercab.client.core.model.CnLocation;
import java.util.List;

public final class NearbyEvent
{
  private final List<CnLocation> mNearby;

  public NearbyEvent(List<CnLocation> paramList)
  {
    this.mNearby = paramList;
  }

  public List<CnLocation> getNearby()
  {
    return this.mNearby;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.event.NearbyEvent
 * JD-Core Version:    0.6.2
 */