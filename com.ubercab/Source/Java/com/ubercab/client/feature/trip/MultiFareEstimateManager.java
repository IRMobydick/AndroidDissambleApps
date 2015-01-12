package com.ubercab.client.feature.trip;

import com.google.gson.Gson;
import com.squareup.otto.Bus;
import com.squareup.otto.Produce;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.event.PinLocationEvent;
import com.ubercab.client.core.content.event.PingEvent;
import com.ubercab.client.core.location.RiderLocation;
import com.ubercab.client.core.model.City;
import com.ubercab.client.core.model.FareEstimateLocation;
import com.ubercab.client.core.model.FareEstimateResponse;
import com.ubercab.client.core.model.FareEstimateVehicleViewData;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.Surge;
import com.ubercab.client.core.model.VehicleView;
import com.ubercab.client.core.network.FareEstimateClient;
import com.ubercab.client.core.network.events.FareEstimateResponseEvent;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.feature.trip.event.DestinationChangedEvent;
import com.ubercab.client.feature.trip.event.MultiFareEstimateEvent;
import com.ubercab.client.feature.trip.event.VehicleViewSelectedEvent;
import com.ubercab.common.base.Function;
import com.ubercab.common.base.Objects;
import com.ubercab.common.collect.Iterables;
import com.ubercab.common.collect.Lists;
import com.ubercab.library.location.model.UberLatLng;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class MultiFareEstimateManager
{
  private final Bus mBus;
  private Map<String, String> mEstimates = new HashMap();
  private final FareEstimateClient mFareEstimateClient;
  private FareEstimateResponse mFareEstimateResponse;
  private int mFareEstimateResponseState;
  private RiderLocation mLocationDestination;
  private RiderLocation mLocationPin;
  private final PingProvider mPingProvider;
  private float mSurgeMultiplier;
  private final TripUIStateManager mTripUIStateManager;
  private String mVehicleViewId;

  MultiFareEstimateManager(Bus paramBus, FareEstimateClient paramFareEstimateClient, PingProvider paramPingProvider, TripUIStateManager paramTripUIStateManager)
  {
    this.mBus = paramBus;
    this.mFareEstimateClient = paramFareEstimateClient;
    this.mPingProvider = paramPingProvider;
    this.mTripUIStateManager = paramTripUIStateManager;
  }

  private static String getSurgeVehicleViewString(List<VehicleViewSurge> paramList)
  {
    return new Gson().toJson(paramList);
  }

  private boolean hasRequiredData()
  {
    return (this.mLocationPin != null) && (this.mLocationDestination != null);
  }

  private void invalidateResponseData()
  {
    this.mFareEstimateResponse = null;
    this.mEstimates.clear();
  }

  private boolean isCurrentFareEstimate()
  {
    boolean bool1 = true;
    if ((this.mFareEstimateResponse == null) || (this.mFareEstimateResponse.getVehicleViews() == null))
      bool1 = false;
    while (true)
    {
      return bool1;
      FareEstimateLocation localFareEstimateLocation1 = this.mFareEstimateResponse.getPickupLocation();
      FareEstimateLocation localFareEstimateLocation2 = this.mFareEstimateResponse.getDestinationLocation();
      FareEstimateVehicleViewData localFareEstimateVehicleViewData = (FareEstimateVehicleViewData)this.mFareEstimateResponse.getVehicleViews().get(this.mVehicleViewId);
      boolean bool2 = FareEstimateLocation.isLocationEqual(localFareEstimateLocation1, this.mLocationPin);
      boolean bool3 = FareEstimateLocation.isLocationEqual(localFareEstimateLocation2, this.mLocationDestination);
      if ((localFareEstimateVehicleViewData != null) && (localFareEstimateVehicleViewData.getSurgeMultiplier() == this.mSurgeMultiplier));
      for (boolean bool4 = bool1; (!bool2) || (!bool3) || (!bool4); bool4 = false)
        return false;
    }
  }

  private void sendRequestForEstimates(Set<String> paramSet, String paramString)
  {
    UberLatLng localUberLatLng1 = this.mLocationPin.getUberLatLng();
    UberLatLng localUberLatLng2 = this.mLocationDestination.getUberLatLng();
    this.mFareEstimateClient.fareEstimates(localUberLatLng1, localUberLatLng2, new ArrayList(paramSet), paramString);
  }

  FareEstimateResponse getFareEstimateResponse()
  {
    return this.mFareEstimateResponse;
  }

  int getFareEstimateResponseState()
  {
    return this.mFareEstimateResponseState;
  }

  List<VehicleViewSurge> getSurgeVehicleViews(Ping paramPing)
  {
    if (!PingUtils.hasVehicleViews(paramPing))
      return new ArrayList();
    return Lists.newArrayList(Iterables.transform(paramPing.getCity().getVehicleViews().values(), new Function()
    {
      public MultiFareEstimateManager.VehicleViewSurge apply(VehicleView paramAnonymousVehicleView)
      {
        return new MultiFareEstimateManager.VehicleViewSurge(paramAnonymousVehicleView.getId(), Float.valueOf(paramAnonymousVehicleView.getSurge().getMultiplier()));
      }
    }));
  }

  boolean hasEstimateForCurrentVehicleView()
  {
    if ((this.mFareEstimateResponse == null) || (this.mFareEstimateResponse.getVehicleViews() == null));
    Map localMap;
    do
    {
      return false;
      localMap = this.mFareEstimateResponse.getVehicleViews();
    }
    while ((localMap == null) || (!localMap.containsKey(this.mVehicleViewId)) || (((FareEstimateVehicleViewData)localMap.get(this.mVehicleViewId)).getSurgeMultiplier() != this.mSurgeMultiplier));
    return true;
  }

  @Subscribe
  public void onDestinationChangedEvent(DestinationChangedEvent paramDestinationChangedEvent)
  {
    RiderLocation localRiderLocation = paramDestinationChangedEvent.getLocation();
    if (this.mLocationDestination != null);
    for (UberLatLng localUberLatLng1 = this.mLocationDestination.getUberLatLng(); ; localUberLatLng1 = null)
    {
      UberLatLng localUberLatLng2 = null;
      if (localRiderLocation != null)
        localUberLatLng2 = localRiderLocation.getUberLatLng();
      if (!Objects.equal(localUberLatLng1, localUberLatLng2))
        break;
      return;
    }
    this.mLocationDestination = localRiderLocation;
    requestEstimate();
  }

  @Subscribe
  public void onFareEstimateResponse(FareEstimateResponseEvent paramFareEstimateResponseEvent)
  {
    this.mFareEstimateResponseState = 2;
    if (paramFareEstimateResponseEvent.isSuccess())
    {
      this.mEstimates.clear();
      this.mFareEstimateResponse = ((FareEstimateResponse)paramFareEstimateResponseEvent.getModel());
      Map localMap = this.mFareEstimateResponse.getVehicleViews();
      if ((localMap != null) && (!localMap.isEmpty()))
      {
        this.mFareEstimateResponseState = 1;
        Iterator localIterator = localMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          this.mEstimates.put(str, ((FareEstimateVehicleViewData)localMap.get(str)).getFareString());
        }
      }
    }
    this.mBus.post(produceFareEstimateEvent());
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
  public void onPingEvent(PingEvent paramPingEvent)
  {
    Ping localPing = paramPingEvent.getPing();
    if (this.mVehicleViewId == null);
    do
    {
      do
        return;
      while (!PingUtils.hasVehicleView(localPing, this.mVehicleViewId));
      this.mSurgeMultiplier = localPing.getCity().findVehicleView(this.mVehicleViewId).getSurge().getMultiplier();
    }
    while (hasEstimateForCurrentVehicleView());
    requestEstimate();
  }

  @Subscribe
  public void onVehicleViewSelectedEvent(VehicleViewSelectedEvent paramVehicleViewSelectedEvent)
  {
    Ping localPing = this.mPingProvider.get();
    String str = paramVehicleViewSelectedEvent.getVehicleViewId();
    if (!PingUtils.hasVehicleView(localPing, str));
    do
    {
      return;
      this.mVehicleViewId = str;
      this.mSurgeMultiplier = localPing.getCity().findVehicleView(this.mVehicleViewId).getSurge().getMultiplier();
    }
    while (hasEstimateForCurrentVehicleView());
    requestEstimate();
  }

  @Produce
  public MultiFareEstimateEvent produceFareEstimateEvent()
  {
    if (!isCurrentFareEstimate())
    {
      invalidateResponseData();
      return new MultiFareEstimateEvent(null, this.mFareEstimateResponseState);
    }
    return new MultiFareEstimateEvent(this.mEstimates, this.mFareEstimateResponseState);
  }

  void requestEstimate()
  {
    int i = this.mTripUIStateManager.getState();
    if ((i != 0) && (i != 1));
    Ping localPing;
    do
    {
      return;
      this.mBus.post(produceFareEstimateEvent());
      localPing = this.mPingProvider.get();
    }
    while ((!hasRequiredData()) || (!PingUtils.hasVehicleViews(localPing)));
    String str = getSurgeVehicleViewString(getSurgeVehicleViews(localPing));
    sendRequestForEstimates(localPing.getCity().getVehicleViews().keySet(), str);
  }

  void setDestinationLocation(RiderLocation paramRiderLocation)
  {
    this.mLocationDestination = paramRiderLocation;
  }

  void setFareEstimateResponse(FareEstimateResponse paramFareEstimateResponse)
  {
    this.mFareEstimateResponse = paramFareEstimateResponse;
  }

  void setPickupLocation(RiderLocation paramRiderLocation)
  {
    this.mLocationPin = paramRiderLocation;
  }

  void setVehicleViewId(String paramString)
  {
    this.mVehicleViewId = paramString;
  }

  void setVehicleViewMultiplier(float paramFloat)
  {
    this.mSurgeMultiplier = paramFloat;
  }

  void start()
  {
    this.mBus.register(this);
  }

  void stop()
  {
    this.mBus.unregister(this);
  }

  static class VehicleViewSurge
  {
    Float multiplier;
    String vehicle_view_id;

    VehicleViewSurge(String paramString, Float paramFloat)
    {
      this.vehicle_view_id = paramString;
      this.multiplier = paramFloat;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.MultiFareEstimateManager
 * JD-Core Version:    0.6.2
 */