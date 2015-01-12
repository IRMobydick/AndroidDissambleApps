package com.ubercab.client.feature.trip.map;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.app.RiderPreferences;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.RiderLocationProvider;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.client.core.content.event.PinLocationEvent;
import com.ubercab.client.core.content.event.PingEvent;
import com.ubercab.client.core.location.RiderLocation;
import com.ubercab.client.core.model.CnLocation;
import com.ubercab.client.core.model.NearbyVehicle;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.Trip;
import com.ubercab.client.core.model.TripDriver;
import com.ubercab.client.core.model.TripDriverLocation;
import com.ubercab.client.core.model.VehiclePathPoint;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.feature.trip.TripUIStateManager;
import com.ubercab.client.feature.trip.event.DestinationChangedEvent;
import com.ubercab.client.feature.trip.event.TripUIStateChangedEvent;
import com.ubercab.common.base.Objects;
import com.ubercab.common.base.Optional;
import com.ubercab.common.collect.Iterables;
import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.location.model.UberLatLngBounds;
import com.ubercab.library.location.model.UberLatLngBounds.Builder;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

public final class MapCameraStateManager
{
  private static final double BOUNDS_PADDING_FACTOR = 1.75D;
  static final float DEFAULT_ZOOM_CONFIRMING = 17.0F;
  static final float DEFAULT_ZOOM_LOOKING = 15.0F;
  private static final String STATE_CAMERA_TRACKING = "com.ubercab.CAMERA_TRACKING";

  @Inject
  Bus mBus;
  private DriverMarkerPositionProvider mDriverMarkerPositionProvider;
  private boolean mIsCameraTracking = true;

  @Inject
  RiderLocationProvider mLocationProvider;
  private final RiderMap mMap;
  private int mPaddingBounds;

  @Inject
  PingProvider mPingProvider;

  @Inject
  RiderPreferences mRiderPreferences;
  private String mSelectedVehicleViewId;

  @Inject
  SessionPreferences mSessionPreferences;
  private MapCameraState mState;

  @Inject
  TripUIStateManager mTripUIStateManager;

  MapCameraStateManager(Context paramContext, RiderMap paramRiderMap)
  {
    this.mMap = paramRiderMap;
    this.mPaddingBounds = paramContext.getResources().getDimensionPixelSize(2131361894);
  }

  private UberLatLngBounds boundsForNearbyVehicles(Ping paramPing, UberLatLng paramUberLatLng)
  {
    double d1 = 0.0D;
    double d2 = 0.0D;
    String str = this.mSessionPreferences.getSelectedVehicleViewId();
    NearbyVehicle localNearbyVehicle = (NearbyVehicle)paramPing.getNearbyVehicles().get(str);
    if (localNearbyVehicle.getVehiclePaths() != null)
    {
      Iterator localIterator = localNearbyVehicle.getVehiclePaths().values().iterator();
      while (localIterator.hasNext())
      {
        VehiclePathPoint localVehiclePathPoint = (VehiclePathPoint)Iterables.getLast((List)localIterator.next());
        d1 = Math.max(d1, Math.abs(paramUberLatLng.getLatitude() - localVehiclePathPoint.getLatitude()));
        d2 = Math.max(d2, Math.abs(paramUberLatLng.getLongitude() - localVehiclePathPoint.getLongitude()));
      }
    }
    return UberLatLngBounds.builder().include(paramUberLatLng).include(new UberLatLng(paramUberLatLng.getLatitude() - d1, paramUberLatLng.getLongitude() - d2)).include(new UberLatLng(d1 + paramUberLatLng.getLatitude(), d2 + paramUberLatLng.getLongitude())).build();
  }

  private UberLatLngBounds boundsForRouteLine(UberLatLng paramUberLatLng1, UberLatLng paramUberLatLng2)
  {
    UberLatLngBounds.Builder localBuilder = UberLatLngBounds.builder().include(paramUberLatLng1);
    if (paramUberLatLng2 == null)
      return localBuilder.build();
    localBuilder.include(paramUberLatLng2);
    List localList1 = this.mMap.getRoutePoints();
    if (localList1 != null)
    {
      Iterator localIterator2 = localList1.iterator();
      while (localIterator2.hasNext())
        localBuilder.include((UberLatLng)localIterator2.next());
    }
    List localList2 = this.mMap.getAdditionalRouteBounds();
    if (localList2 != null)
    {
      Iterator localIterator1 = localList2.iterator();
      while (localIterator1.hasNext())
        localBuilder.include((UberLatLng)localIterator1.next());
    }
    return localBuilder.build();
  }

  private RiderCameraUpdate cameraUpdateForConfirming(MapCameraState paramMapCameraState, boolean paramBoolean)
  {
    RiderLocation localRiderLocation1 = this.mLocationProvider.getPinLocation();
    if (localRiderLocation1 == null)
      return null;
    RiderCameraUpdate.Builder localBuilder1 = RiderCameraUpdate.builder().latLng(localRiderLocation1.getUberLatLng());
    if (paramMapCameraState != MapCameraState.CONFIRMING);
    for (boolean bool1 = true; ; bool1 = false)
    {
      RiderCameraUpdate.Builder localBuilder2 = localBuilder1.animate(bool1);
      if ((this.mRiderPreferences.isFlagMapAnimationsEnabled()) && ((paramMapCameraState != MapCameraState.CONFIRMING) || (paramBoolean)))
        localBuilder2.zoom(17.0F);
      boolean bool2 = this.mTripUIStateManager.showNewConfirmation();
      RiderLocation localRiderLocation2 = this.mTripUIStateManager.getDestination();
      if ((bool2) && (localRiderLocation2 != null))
        localBuilder2.bounds(boundsForRouteLine(localRiderLocation1.getUberLatLng(), localRiderLocation2.getUberLatLng()), localRiderLocation1.getUberLatLng(), 17.0F, this.mPaddingBounds);
      return localBuilder2.build();
    }
  }

  private RiderCameraUpdate cameraUpdateForDispatching(MapCameraState paramMapCameraState)
  {
    boolean bool = true;
    if (!this.mIsCameraTracking)
      return null;
    if (!PingUtils.hasTrip(this.mPingProvider.get()))
      return null;
    UberLatLng localUberLatLng1 = getPickupLatLng();
    UberLatLng localUberLatLng2 = getDestinationLatLng();
    if ((localUberLatLng1 == null) || (localUberLatLng2 == null))
    {
      UberLatLng localUberLatLng3 = (UberLatLng)Optional.fromNullable(localUberLatLng1).or(Optional.fromNullable(localUberLatLng2)).orNull();
      if (localUberLatLng3 == null)
        return null;
      RiderCameraUpdate.Builder localBuilder1 = RiderCameraUpdate.builder().latLng(localUberLatLng3).zoom(15.0F);
      if (paramMapCameraState != MapCameraState.UNKNOWN);
      while (true)
      {
        return localBuilder1.animate(bool).build();
        bool = false;
      }
    }
    UberLatLngBounds localUberLatLngBounds = UberLatLngBounds.builder().include(localUberLatLng1).include(localUberLatLng2).build();
    RiderCameraUpdate.Builder localBuilder2 = RiderCameraUpdate.builder().bounds(localUberLatLngBounds, localUberLatLng1, 15.0F, this.mPaddingBounds);
    if (paramMapCameraState != MapCameraState.UNKNOWN);
    while (true)
    {
      return localBuilder2.animate(bool).build();
      bool = false;
    }
  }

  private RiderCameraUpdate cameraUpdateForPickup()
  {
    if (!this.mIsCameraTracking)
      return null;
    UberLatLng localUberLatLng1 = getPickupLatLng();
    UberLatLng localUberLatLng2 = getDriverLatLng();
    if ((localUberLatLng2 == null) || (localUberLatLng1 == null))
    {
      UberLatLng localUberLatLng3 = (UberLatLng)Optional.fromNullable(localUberLatLng1).or(Optional.fromNullable(localUberLatLng2)).orNull();
      if (localUberLatLng3 == null)
        return null;
      return RiderCameraUpdate.builder().latLng(localUberLatLng3).zoom(15.0F).build();
    }
    double d1 = 1.75D * Math.abs(localUberLatLng2.getLatitude() - localUberLatLng1.getLatitude());
    double d2 = 1.75D * Math.abs(localUberLatLng2.getLongitude() - localUberLatLng1.getLongitude());
    UberLatLng localUberLatLng4 = new UberLatLng(d1 + localUberLatLng1.getLatitude(), d2 + localUberLatLng1.getLongitude());
    UberLatLng localUberLatLng5 = new UberLatLng(localUberLatLng1.getLatitude() - d1, localUberLatLng1.getLongitude() - d2);
    UberLatLngBounds localUberLatLngBounds = new UberLatLngBounds.Builder().include(localUberLatLng4).include(localUberLatLng5).build();
    return RiderCameraUpdate.builder().bounds(localUberLatLngBounds, localUberLatLng2, 15.0F).animate(true).build();
  }

  private UberLatLng getDestinationLatLng()
  {
    RiderLocation localRiderLocation = this.mTripUIStateManager.getDestination();
    UberLatLng localUberLatLng;
    if (localRiderLocation == null)
      localUberLatLng = null;
    do
    {
      return localUberLatLng;
      localUberLatLng = localRiderLocation.getUberLatLng();
    }
    while (!localUberLatLng.equals(MapFragment.DEFAULT_LATLNG));
    return null;
  }

  private UberLatLng getDriverLatLng()
  {
    Trip localTrip = this.mPingProvider.get().getTrip();
    if (this.mDriverMarkerPositionProvider != null);
    TripDriverLocation localTripDriverLocation;
    for (UberLatLng localUberLatLng = this.mDriverMarkerPositionProvider.getDriverMarkerPositionForTrip(); ; localUberLatLng = null)
    {
      localTripDriverLocation = localTrip.getDriver().getLocation();
      if ((localUberLatLng == null) || (localUberLatLng.equals(MapFragment.DEFAULT_LATLNG)))
        break;
      return localUberLatLng;
    }
    if ((localUberLatLng != null) || (localTripDriverLocation == null) || (localTripDriverLocation.getUberLatLng().equals(MapFragment.DEFAULT_LATLNG)))
      return null;
    return localTripDriverLocation.getUberLatLng();
  }

  private UberLatLng getPickupLatLng()
  {
    CnLocation localCnLocation = this.mPingProvider.get().getTrip().getPickupLocation();
    if ((localCnLocation == null) || (localCnLocation.getUberLatLng().equals(MapFragment.DEFAULT_LATLNG)))
      return null;
    return localCnLocation.getUberLatLng();
  }

  RiderCameraUpdate cameraUpdateForLooking(MapCameraState paramMapCameraState, boolean paramBoolean)
  {
    RiderLocation localRiderLocation = this.mLocationProvider.getPinLocation();
    if ((paramMapCameraState == this.mState) && (!paramBoolean) && (!this.mIsCameraTracking) && (!localRiderLocation.isLocationSearchResult()))
      return null;
    Ping localPing = this.mPingProvider.get();
    UberLatLng localUberLatLng = localRiderLocation.getUberLatLng();
    if ((!this.mRiderPreferences.isFlagMapAnimationsEnabled()) || (!PingUtils.hasNearbyVehicles(localPing)))
    {
      RiderCameraUpdate.Builder localBuilder = RiderCameraUpdate.builder().latLng(localUberLatLng).animate(true);
      if ((localRiderLocation.isLocationSearchResult()) || (localRiderLocation.isDeviceLocation()) || (paramMapCameraState != MapCameraState.LOOKING))
        localBuilder.zoom(15.0F);
      return localBuilder.build();
    }
    return RiderCameraUpdate.builder().bounds(boundsForNearbyVehicles(localPing, localUberLatLng), localUberLatLng, 15.0F).animate(true).build();
  }

  RiderCameraUpdate cameraUpdateForNoLocation()
  {
    return RiderCameraUpdate.builder().latLng(MapFragment.DEFAULT_LATLNG).zoom(0.0F).build();
  }

  RiderCameraUpdate cameraUpdateForOnTrip()
  {
    if (!this.mIsCameraTracking);
    UberLatLng localUberLatLng1;
    UberLatLng localUberLatLng2;
    UberLatLng localUberLatLng3;
    do
    {
      return null;
      localUberLatLng1 = getDriverLatLng();
      localUberLatLng2 = getDestinationLatLng();
      if ((localUberLatLng1 != null) && (localUberLatLng2 != null))
        break;
      localUberLatLng3 = (UberLatLng)Optional.fromNullable(localUberLatLng2).or(Optional.fromNullable(localUberLatLng1)).orNull();
    }
    while (localUberLatLng3 == null);
    return RiderCameraUpdate.builder().latLng(localUberLatLng3).zoom(15.0F).build();
    UberLatLngBounds localUberLatLngBounds = boundsForRouteLine(localUberLatLng1, localUberLatLng2);
    return RiderCameraUpdate.builder().bounds(localUberLatLngBounds, localUberLatLng1, 15.0F, this.mPaddingBounds).animate(true).build();
  }

  MapCameraState getState()
  {
    switch (this.mTripUIStateManager.getState())
    {
    default:
      return MapCameraState.UNKNOWN;
    case 0:
      if (this.mLocationProvider.getPinLocation() == null)
        return MapCameraState.LOOKING_NO_LOCATION;
      return MapCameraState.LOOKING;
    case 1:
      return MapCameraState.CONFIRMING;
    case 2:
      return MapCameraState.DISPATCHING;
    case 3:
    case 4:
      return MapCameraState.WAITING_FOR_PICKUP;
    case 5:
    }
    return MapCameraState.ON_TRIP;
  }

  boolean isCameraTracking()
  {
    return this.mIsCameraTracking;
  }

  @Subscribe
  public void onDestinationChangedEvent(DestinationChangedEvent paramDestinationChangedEvent)
  {
    syncCamera();
  }

  @Subscribe
  public void onPinLocationEvent(PinLocationEvent paramPinLocationEvent)
  {
    syncCamera();
  }

  @Subscribe
  public void onPingEvent(PingEvent paramPingEvent)
  {
    if (PingUtils.hasTrip(paramPingEvent.getPing()))
      syncCamera();
  }

  @Subscribe
  public void onTripUIStateChangedEvent(TripUIStateChangedEvent paramTripUIStateChangedEvent)
  {
    syncCamera();
  }

  void restoreInstanceState(Bundle paramBundle)
  {
    if (paramBundle == null)
      return;
    this.mIsCameraTracking = paramBundle.getBoolean("com.ubercab.CAMERA_TRACKING", true);
  }

  void saveInstanceState(Bundle paramBundle)
  {
    paramBundle.putBoolean("com.ubercab.CAMERA_TRACKING", this.mIsCameraTracking);
  }

  void setCameraTracking(boolean paramBoolean)
  {
    this.mIsCameraTracking = paramBoolean;
    this.mMap.onMapCameraTrackingChanged(this.mIsCameraTracking);
    MapCameraState localMapCameraState = getState();
    if ((localMapCameraState != MapCameraState.LOOKING) && (localMapCameraState != MapCameraState.CONFIRMING))
      syncCamera();
  }

  public void setDriverMarkerPositionProvider(DriverMarkerPositionProvider paramDriverMarkerPositionProvider)
  {
    this.mDriverMarkerPositionProvider = paramDriverMarkerPositionProvider;
  }

  void start()
  {
    this.mState = getState();
    this.mBus.register(this);
  }

  void stop()
  {
    this.mBus.unregister(this);
  }

  public void syncCamera()
  {
    MapCameraState localMapCameraState = this.mState;
    String str = this.mSelectedVehicleViewId;
    this.mState = getState();
    this.mSelectedVehicleViewId = this.mSessionPreferences.getSelectedVehicleViewId();
    boolean bool;
    RiderCameraUpdate localRiderCameraUpdate;
    if (!Objects.equal(str, this.mSelectedVehicleViewId))
    {
      bool = true;
      int i = 1.$SwitchMap$com$ubercab$client$feature$trip$map$MapCameraStateManager$MapCameraState[this.mState.ordinal()];
      localRiderCameraUpdate = null;
      switch (i)
      {
      default:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      }
    }
    while (true)
    {
      if (localRiderCameraUpdate != null)
        this.mMap.applyCameraUpdate(localRiderCameraUpdate);
      return;
      bool = false;
      break;
      localRiderCameraUpdate = cameraUpdateForLooking(localMapCameraState, bool);
      continue;
      localRiderCameraUpdate = cameraUpdateForNoLocation();
      continue;
      localRiderCameraUpdate = cameraUpdateForConfirming(localMapCameraState, bool);
      continue;
      localRiderCameraUpdate = cameraUpdateForDispatching(localMapCameraState);
      continue;
      localRiderCameraUpdate = cameraUpdateForPickup();
      continue;
      localRiderCameraUpdate = cameraUpdateForOnTrip();
    }
  }

  public static abstract interface DriverMarkerPositionProvider
  {
    public abstract UberLatLng getDriverMarkerPositionForTrip();
  }

  static enum MapCameraState
  {
    static
    {
      LOOKING_NO_LOCATION = new MapCameraState("LOOKING_NO_LOCATION", 1);
      LOOKING = new MapCameraState("LOOKING", 2);
      CONFIRMING = new MapCameraState("CONFIRMING", 3);
      DISPATCHING = new MapCameraState("DISPATCHING", 4);
      WAITING_FOR_PICKUP = new MapCameraState("WAITING_FOR_PICKUP", 5);
      ON_TRIP = new MapCameraState("ON_TRIP", 6);
      MapCameraState[] arrayOfMapCameraState = new MapCameraState[7];
      arrayOfMapCameraState[0] = UNKNOWN;
      arrayOfMapCameraState[1] = LOOKING_NO_LOCATION;
      arrayOfMapCameraState[2] = LOOKING;
      arrayOfMapCameraState[3] = CONFIRMING;
      arrayOfMapCameraState[4] = DISPATCHING;
      arrayOfMapCameraState[5] = WAITING_FOR_PICKUP;
      arrayOfMapCameraState[6] = ON_TRIP;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.map.MapCameraStateManager
 * JD-Core Version:    0.6.2
 */