package com.ubercab.client.feature.trip;

import com.squareup.otto.Bus;
import com.squareup.otto.Produce;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.event.PinLocationEvent;
import com.ubercab.client.core.location.RiderLocation;
import com.ubercab.client.core.model.City;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.CnLocation;
import com.ubercab.client.core.model.FareEstimateRange;
import com.ubercab.client.core.model.Itinerary;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.Surge;
import com.ubercab.client.core.model.VehicleView;
import com.ubercab.client.core.model.event.ClientEvent;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.feature.trip.event.DestinationChangedEvent;
import com.ubercab.client.feature.trip.event.FareEstimateEvent;
import com.ubercab.client.feature.trip.event.GetFareEstimateEvent;
import com.ubercab.client.feature.trip.event.TripUIStateChangedEvent;
import com.ubercab.client.feature.trip.event.VehicleViewSelectedEvent;
import com.ubercab.common.base.Objects;
import com.ubercab.library.location.model.UberLatLng;

public final class LegacyFareEstimateManager
{
  private final Bus mBus;
  private Itinerary mCurrentFareEstimate;
  private String mFareId = "";
  private RiderLocation mLocationDestination;
  private RiderLocation mLocationPin;
  private final PingProvider mPingProvider;
  private final TripUIStateManager mTripUIStateManager;
  private String mVehicleViewId;

  LegacyFareEstimateManager(Bus paramBus, PingProvider paramPingProvider, TripUIStateManager paramTripUIStateManager)
  {
    this.mBus = paramBus;
    this.mPingProvider = paramPingProvider;
    this.mTripUIStateManager = paramTripUIStateManager;
  }

  public static String getFareEstimatePointsRange(FareEstimateRange paramFareEstimateRange, Float paramFloat)
  {
    Float localFloat1 = paramFareEstimateRange.getMinFare();
    Float localFloat2 = paramFareEstimateRange.getMaxFare();
    String str = null;
    float f1;
    if (localFloat1 != null)
    {
      str = null;
      if (localFloat2 != null)
      {
        f1 = localFloat1.floatValue() * paramFloat.floatValue();
        if (!localFloat1.equals(localFloat2))
          break label70;
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Float.valueOf(f1);
        str = String.format("%.0f", arrayOfObject2);
      }
    }
    return str;
    label70: float f2 = localFloat2.floatValue() * paramFloat.floatValue();
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = Float.valueOf(f1);
    arrayOfObject1[1] = Float.valueOf(f2);
    return String.format("%.0f - %.0f", arrayOfObject1);
  }

  private boolean hasRequiredData()
  {
    return (this.mVehicleViewId != null) && (this.mLocationPin != null) && (this.mLocationDestination != null) && (this.mFareId != null);
  }

  private boolean isCurrentFareEstimate()
  {
    boolean bool1 = true;
    if ((this.mCurrentFareEstimate == null) || (!hasRequiredData()))
      bool1 = false;
    label154: label158: 
    while (true)
    {
      return bool1;
      UberLatLng localUberLatLng1 = this.mCurrentFareEstimate.getPickupLocation().getUberLatLng();
      UberLatLng localUberLatLng2 = this.mCurrentFareEstimate.getDestination().getUberLatLng();
      String str1 = this.mCurrentFareEstimate.getVehicleViewId();
      String str2 = this.mCurrentFareEstimate.getFareId();
      boolean bool2 = localUberLatLng1.equals(this.mLocationPin.getUberLatLng());
      boolean bool3 = localUberLatLng2.equals(this.mLocationDestination.getUberLatLng());
      boolean bool4;
      if ((str1 != null) && (str1.equals(this.mVehicleViewId)))
      {
        bool4 = bool1;
        if ((str2 == null) || (!str2.equals(this.mFareId)))
          break label154;
      }
      for (boolean bool5 = bool1; ; bool5 = false)
      {
        if ((bool5) && (bool4) && (bool2) && (bool3))
          break label158;
        return false;
        bool4 = false;
        break;
      }
    }
  }

  String getFareId()
  {
    return this.mFareId;
  }

  String getVehicleViewId()
  {
    return this.mVehicleViewId;
  }

  @Subscribe
  public void onClientEvent(ClientEvent paramClientEvent)
  {
    this.mCurrentFareEstimate = paramClientEvent.getClient().getLastEstimatedTrip();
    this.mBus.post(produceFareEstimateEvent());
  }

  @Subscribe
  public void onDestinationChangedEvent(DestinationChangedEvent paramDestinationChangedEvent)
  {
    UberLatLng localUberLatLng1;
    if (this.mLocationDestination != null)
    {
      localUberLatLng1 = this.mLocationDestination.getUberLatLng();
      if (paramDestinationChangedEvent.getLocation() == null)
        break label44;
    }
    label44: for (UberLatLng localUberLatLng2 = paramDestinationChangedEvent.getLocation().getUberLatLng(); ; localUberLatLng2 = null)
    {
      if (!Objects.equal(localUberLatLng1, localUberLatLng2))
        break label49;
      return;
      localUberLatLng1 = null;
      break;
    }
    label49: this.mLocationDestination = paramDestinationChangedEvent.getLocation();
    requestEstimate();
  }

  @Subscribe
  public void onPinLocationEvent(PinLocationEvent paramPinLocationEvent)
  {
    if ((this.mLocationPin != null) && (this.mLocationPin.getUberLatLng().equals(paramPinLocationEvent.getLocation().getUberLatLng())))
      return;
    this.mLocationPin = paramPinLocationEvent.getLocation();
    requestEstimate();
  }

  @Subscribe
  public void onTripUIStateChanged(TripUIStateChangedEvent paramTripUIStateChangedEvent)
  {
    if (paramTripUIStateChangedEvent.getState() == 1)
      requestEstimate();
  }

  @Subscribe
  public void onVehicleViewSelectedEvent(VehicleViewSelectedEvent paramVehicleViewSelectedEvent)
  {
    Ping localPing = this.mPingProvider.get();
    String str1 = paramVehicleViewSelectedEvent.getVehicleViewId();
    if (!PingUtils.hasVehicleView(localPing, str1))
      return;
    long l = localPing.getCity().findVehicleView(str1).getSurge().getFareId();
    if (l > 0L);
    for (String str2 = String.valueOf(l); ; str2 = "")
    {
      boolean bool1 = Objects.equal(this.mVehicleViewId, str1);
      boolean bool2 = Objects.equal(this.mFareId, str2);
      if ((bool1) && (bool2))
        break;
      this.mVehicleViewId = str1;
      this.mFareId = str2;
      requestEstimate();
      return;
    }
  }

  @Produce
  public FareEstimateEvent produceFareEstimateEvent()
  {
    if (!isCurrentFareEstimate())
      return new FareEstimateEvent(null, null);
    return new FareEstimateEvent(this.mCurrentFareEstimate.getFareEstimateString(), this.mCurrentFareEstimate.getFareEstimateRange(), this.mCurrentFareEstimate.getFareEstimateTagline());
  }

  void requestEstimate()
  {
    if (!this.mTripUIStateManager.showNewConfirmation());
    do
    {
      do
        return;
      while (this.mTripUIStateManager.getDestination() == null);
      this.mBus.post(produceFareEstimateEvent());
    }
    while (!hasRequiredData());
    this.mBus.post(new GetFareEstimateEvent());
  }

  void setCurrentFareEstimate(Itinerary paramItinerary)
  {
    this.mCurrentFareEstimate = paramItinerary;
  }

  void setFareId(String paramString)
  {
    this.mFareId = paramString;
  }

  void setLocationDestination(RiderLocation paramRiderLocation)
  {
    this.mLocationDestination = paramRiderLocation;
  }

  void setLocationPin(RiderLocation paramRiderLocation)
  {
    this.mLocationPin = paramRiderLocation;
  }

  void setVehicleViewId(String paramString)
  {
    this.mVehicleViewId = paramString;
  }

  void start()
  {
    this.mBus.register(this);
  }

  void stop()
  {
    this.mBus.unregister(this);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.LegacyFareEstimateManager
 * JD-Core Version:    0.6.2
 */