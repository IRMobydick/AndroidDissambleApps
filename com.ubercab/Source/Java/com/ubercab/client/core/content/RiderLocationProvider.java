package com.ubercab.client.core.content;

import com.squareup.otto.Bus;
import com.squareup.otto.Produce;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.content.event.DeviceLocationEvent;
import com.ubercab.client.core.content.event.PinLocationEvent;
import com.ubercab.client.core.location.RiderLocation;
import com.ubercab.library.location.LocationProvider;
import com.ubercab.library.location.event.LocationEvent;
import com.ubercab.library.location.model.UberLocation;

public class RiderLocationProvider
{
  private Bus mBus;
  private RiderLocation mDeviceLocation;
  private LocationProvider mLocationProvider;
  private RiderLocation mPinLocation;

  public RiderLocationProvider(LocationProvider paramLocationProvider, Bus paramBus)
  {
    this.mLocationProvider = paramLocationProvider;
    this.mBus = paramBus;
  }

  public void clear()
  {
    this.mLocationProvider.clear();
    this.mPinLocation = null;
    this.mDeviceLocation = null;
  }

  public void clearDeviceLocation()
  {
    this.mDeviceLocation = null;
    this.mLocationProvider.clear();
  }

  public void clearPinLocation()
  {
    this.mPinLocation = null;
  }

  public RiderLocation getDeviceLocation()
  {
    return this.mDeviceLocation;
  }

  public RiderLocation getPinLocation()
  {
    return this.mPinLocation;
  }

  @Subscribe
  public void onLocationEvent(LocationEvent paramLocationEvent)
  {
    UberLocation localUberLocation = paramLocationEvent.getLocation();
    if (localUberLocation == null)
      return;
    this.mDeviceLocation = RiderLocation.create(localUberLocation);
    this.mBus.post(produceDeviceLocationEvent());
  }

  @Produce
  public DeviceLocationEvent produceDeviceLocationEvent()
  {
    RiderLocation localRiderLocation = this.mDeviceLocation;
    if (localRiderLocation != null)
      return new DeviceLocationEvent(localRiderLocation);
    return null;
  }

  @Produce
  public PinLocationEvent producePinLocationEvent()
  {
    RiderLocation localRiderLocation = this.mPinLocation;
    if (localRiderLocation != null)
      return new PinLocationEvent(localRiderLocation);
    return null;
  }

  public void register()
  {
    this.mBus.register(this);
  }

  public void unregister()
  {
    this.mBus.unregister(this);
  }

  public void updateDeviceLocation(RiderLocation paramRiderLocation)
  {
    this.mLocationProvider.update(paramRiderLocation);
  }

  public void updatePinLocation(RiderLocation paramRiderLocation)
  {
    if (paramRiderLocation == null)
      return;
    this.mPinLocation = paramRiderLocation;
    this.mBus.post(producePinLocationEvent());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.content.RiderLocationProvider
 * JD-Core Version:    0.6.2
 */