package com.ubercab.client.core.model.event;

import com.ubercab.client.core.model.City;

public final class CityEvent
{
  private final City mCity;

  public CityEvent(City paramCity)
  {
    this.mCity = paramCity;
  }

  public City getCity()
  {
    return this.mCity;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.event.CityEvent
 * JD-Core Version:    0.6.2
 */