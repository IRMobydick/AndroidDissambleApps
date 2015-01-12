package com.ubercab.client.core.model.event;

import com.ubercab.client.core.model.CnLocation;
import java.util.List;

public final class RecentEvent
{
  private final List<CnLocation> mRecent;

  public RecentEvent(List<CnLocation> paramList)
  {
    this.mRecent = paramList;
  }

  public List<CnLocation> getRecent()
  {
    return this.mRecent;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.event.RecentEvent
 * JD-Core Version:    0.6.2
 */