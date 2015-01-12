package com.ubercab.library.location;

import com.squareup.otto.Bus;
import com.squareup.otto.Produce;
import com.ubercab.library.location.event.LocationEvent;
import com.ubercab.library.location.model.UberLocation;

public class LocationProvider
{
  private Bus mBus;
  private UberLocation mLocation;

  public LocationProvider()
  {
  }

  public LocationProvider(Bus paramBus)
  {
    this.mBus = paramBus;
  }

  public void clear()
  {
    this.mLocation = null;
  }

  public UberLocation getLocation()
  {
    try
    {
      UberLocation localUberLocation = this.mLocation;
      return localUberLocation;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  @Produce
  public LocationEvent produceLocationEvent()
  {
    UberLocation localUberLocation = this.mLocation;
    if (localUberLocation == null)
      return null;
    return new LocationEvent(localUberLocation);
  }

  public void register()
  {
    if (this.mBus != null)
      this.mBus.register(this);
  }

  public void unregister()
  {
    if (this.mBus != null)
      this.mBus.unregister(this);
  }

  public void update(UberLocation paramUberLocation)
  {
    if (paramUberLocation == null);
    do
    {
      return;
      this.mLocation = paramUberLocation;
    }
    while (this.mBus == null);
    this.mBus.post(produceLocationEvent());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.location.LocationProvider
 * JD-Core Version:    0.6.2
 */