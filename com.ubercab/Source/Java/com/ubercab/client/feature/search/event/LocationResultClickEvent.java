package com.ubercab.client.feature.search.event;

import com.ubercab.client.core.model.LocationSearchResult;

public final class LocationResultClickEvent
{
  private final LocationSearchResult mLocationResult;
  private final String mTag;

  public LocationResultClickEvent(LocationSearchResult paramLocationSearchResult, String paramString)
  {
    this.mLocationResult = paramLocationSearchResult;
    this.mTag = paramString;
  }

  public LocationSearchResult getLocationResult()
  {
    return this.mLocationResult;
  }

  public String getTag()
  {
    return this.mTag;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.search.event.LocationResultClickEvent
 * JD-Core Version:    0.6.2
 */