package com.ubercab.client.feature.trip.map.layer.vehicles;

import android.content.Context;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.squareup.picasso.Picasso;
import com.ubercab.client.core.app.RiderPreferences;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.client.core.content.event.PingEvent;
import com.ubercab.client.core.model.City;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.NearbyVehicle;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.Trip;
import com.ubercab.client.core.model.TripDriver;
import com.ubercab.client.core.model.TripDriverLocation;
import com.ubercab.client.core.model.TripVehicle;
import com.ubercab.client.core.model.VehiclePathPoint;
import com.ubercab.client.core.model.VehicleView;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.feature.trip.TripUIStateManager;
import com.ubercab.client.feature.trip.event.VehicleViewSelectedEvent;
import com.ubercab.client.feature.trip.map.MapCameraStateManager;
import com.ubercab.client.feature.trip.map.MapCameraStateManager.DriverMarkerPositionProvider;
import com.ubercab.client.feature.trip.map.layer.BaseMapLayer;
import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.map.UberBitmapDescriptorFactory;
import com.ubercab.library.map.UberMap;
import com.ubercab.library.map.UberMarkerOptions;
import com.ubercab.library.util.TimeUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Inject;
import javax.inject.Provider;

public class VehiclesMapLayer extends BaseMapLayer
  implements MapCameraStateManager.DriverMarkerPositionProvider
{

  @Inject
  Bus mBus;

  @Inject
  Context mContext;
  private boolean mIsShowAllVehicles;

  @Inject
  UberMap mMap;

  @Inject
  MapCameraStateManager mMapCameraStateManager;

  @Inject
  Provider<UberMarkerOptions> mMarkerOptionsProvider;
  private final Map<String, Map<String, Vehicle>> mNearbyVehicles = new ConcurrentHashMap();

  @Inject
  Picasso mPicasso;

  @Inject
  PingProvider mPingProvider;

  @Inject
  RiderPreferences mRiderPreferences;

  @Inject
  SessionPreferences mSessionPreferences;

  @Inject
  TripUIStateManager mTripUIStateManager;

  @Inject
  UberBitmapDescriptorFactory mUberBitmapDescriptorFactory;

  private void addOrUpdateNearbyVehicle(String paramString1, String paramString2, List<VehiclePathPoint> paramList, boolean paramBoolean)
  {
    Ping localPing = this.mPingProvider.get();
    if (!PingUtils.hasVehicleView(localPing, paramString1));
    while (true)
    {
      return;
      if (!this.mNearbyVehicles.containsKey(paramString1))
        this.mNearbyVehicles.put(paramString1, new ConcurrentHashMap());
      Map localMap = (Map)this.mNearbyVehicles.get(paramString1);
      Vehicle localVehicle = (Vehicle)localMap.get(paramString2);
      if (localVehicle == null)
      {
        VehicleView localVehicleView = localPing.getCity().findVehicleView(paramString1);
        localVehicle = new Vehicle(this.mContext, this.mPicasso, localVehicleView, paramString2, paramList, this.mMap, this.mUberBitmapDescriptorFactory, this.mMarkerOptionsProvider);
        localMap.put(paramString2, localVehicle);
      }
      while ((paramBoolean) && (!localVehicle.isAnimating()))
      {
        localVehicle.startAnimation();
        return;
        localVehicle.updatePathPoints(paramList);
      }
    }
  }

  private void purgeInvalidNearbyVehicles(Map<String, NearbyVehicle> paramMap)
  {
    Iterator localIterator1 = this.mNearbyVehicles.keySet().iterator();
    while (localIterator1.hasNext())
    {
      String str1 = (String)localIterator1.next();
      if (!paramMap.containsKey(str1))
      {
        stopVehicleAnimationsFor(str1);
        this.mNearbyVehicles.remove(str1);
      }
      else
      {
        Map localMap1 = (Map)this.mNearbyVehicles.get(str1);
        Map localMap2 = ((NearbyVehicle)paramMap.get(str1)).getVehiclePaths();
        if (localMap2 != null)
        {
          Iterator localIterator2 = localMap1.keySet().iterator();
          while (localIterator2.hasNext())
          {
            String str2 = (String)localIterator2.next();
            if (!localMap2.containsKey(str2))
            {
              ((Vehicle)localMap1.get(str2)).stopAnimation();
              localMap1.remove(str2);
            }
          }
        }
      }
    }
  }

  private void showVehicleForTrip(Ping paramPing)
  {
    if (!PingUtils.hasTrip(paramPing));
    String str1;
    String str2;
    TripDriver localTripDriver;
    do
    {
      return;
      Trip localTrip = paramPing.getTrip();
      TripVehicle localTripVehicle = localTrip.getVehicle();
      str1 = localTripVehicle.getVehicleViewId();
      str2 = localTripVehicle.getUuid();
      Iterator localIterator1 = this.mNearbyVehicles.keySet().iterator();
      while (localIterator1.hasNext())
      {
        String str3 = (String)localIterator1.next();
        if (!str3.equals(str1))
        {
          stopVehicleAnimationsFor(str3);
          this.mNearbyVehicles.remove(str3);
        }
        else
        {
          Map localMap = (Map)this.mNearbyVehicles.get(str3);
          Iterator localIterator2 = localMap.keySet().iterator();
          while (localIterator2.hasNext())
          {
            String str4 = (String)localIterator2.next();
            if (!str4.equals(str2))
            {
              ((Vehicle)localMap.get(str4)).stopAnimation();
              localMap.remove(str4);
            }
          }
        }
      }
      localList = localTripVehicle.getVehiclePath();
      if ((localList != null) && (localList.size() != 0))
        break;
      localTripDriver = localTrip.getDriver();
    }
    while ((localTripDriver == null) || (localTripDriver.getLocation() == null));
    UberLatLng localUberLatLng = localTripDriver.getLocation().getUberLatLng();
    List localList = Arrays.asList(new VehiclePathPoint[] { new VehiclePathPoint(TimeUtils.getEpochTimeMs(), localUberLatLng, 0.0F) });
    addOrUpdateNearbyVehicle(str1, str2, localList, true);
  }

  private void showVehiclesForLooking(String paramString)
  {
    Iterator localIterator = this.mNearbyVehicles.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!paramString.equals(str)) && (!this.mIsShowAllVehicles))
        stopVehicleAnimationsFor(str);
      else
        startVehicleAnimationsFor(str);
    }
  }

  private void startVehicleAnimationsFor(String paramString)
  {
    if (!this.mNearbyVehicles.containsKey(paramString));
    while (true)
    {
      return;
      Iterator localIterator = ((Map)this.mNearbyVehicles.get(paramString)).values().iterator();
      while (localIterator.hasNext())
      {
        Vehicle localVehicle = (Vehicle)localIterator.next();
        if (!localVehicle.isAnimating())
          localVehicle.startAnimation();
      }
    }
  }

  private void stopVehicleAnimations()
  {
    Iterator localIterator1 = this.mNearbyVehicles.values().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((Map)localIterator1.next()).values().iterator();
      while (localIterator2.hasNext())
      {
        Vehicle localVehicle = (Vehicle)localIterator2.next();
        if (localVehicle.isAnimating())
          localVehicle.stopAnimation();
      }
    }
  }

  private void stopVehicleAnimationsFor(String paramString)
  {
    if (!this.mNearbyVehicles.containsKey(paramString));
    while (true)
    {
      return;
      Iterator localIterator = ((Map)this.mNearbyVehicles.get(paramString)).values().iterator();
      while (localIterator.hasNext())
      {
        Vehicle localVehicle = (Vehicle)localIterator.next();
        if (localVehicle.isAnimating())
          localVehicle.stopAnimation();
      }
    }
  }

  private void syncNearbyVehiclesWithPing(Ping paramPing)
  {
    label20: Iterator localIterator1;
    if (!PingUtils.hasNearbyVehicles(paramPing))
    {
      stopVehicleAnimations();
      this.mNearbyVehicles.clear();
      return;
    }
    else
    {
      purgeInvalidNearbyVehicles(paramPing.getNearbyVehicles());
      localIterator1 = paramPing.getNearbyVehicles().keySet().iterator();
    }
    while (true)
    {
      if (!localIterator1.hasNext())
        break label20;
      String str1 = (String)localIterator1.next();
      if (!PingUtils.hasVehicleView(paramPing, str1))
        break;
      Map localMap = ((NearbyVehicle)paramPing.getNearbyVehicles().get(str1)).getVehiclePaths();
      if (localMap == null)
        break;
      Iterator localIterator2 = localMap.keySet().iterator();
      while (localIterator2.hasNext())
      {
        String str2 = (String)localIterator2.next();
        addOrUpdateNearbyVehicle(str1, str2, (List)localMap.get(str2), false);
      }
    }
  }

  public List<UberLatLng> getAdditionalRouteBounds()
  {
    return null;
  }

  public UberLatLng getDriverMarkerPositionForTrip()
  {
    Ping localPing = this.mPingProvider.get();
    if (!PingUtils.hasTrip(localPing));
    Vehicle localVehicle;
    do
    {
      String str2;
      Map localMap;
      do
      {
        String str1;
        do
        {
          return null;
          TripVehicle localTripVehicle = localPing.getTrip().getVehicle();
          str1 = localTripVehicle.getVehicleViewId();
          str2 = localTripVehicle.getUuid();
        }
        while (str1 == null);
        localMap = (Map)this.mNearbyVehicles.get(str1);
      }
      while ((localMap == null) || (str2 == null));
      localVehicle = (Vehicle)localMap.get(str2);
    }
    while (localVehicle == null);
    return localVehicle.getMarkerPosition();
  }

  public List<UberLatLng> getRoutePoints()
  {
    return null;
  }

  @Subscribe
  public void onPingEvent(PingEvent paramPingEvent)
  {
    Vehicle.setFixedDelayInMs(paramPingEvent.getPing().getMapFittingMobileAppDelayWindowMs());
    Ping localPing = paramPingEvent.getPing();
    switch (this.mTripUIStateManager.getState())
    {
    default:
      return;
    case -1:
    case 0:
    case 1:
      syncNearbyVehiclesWithPing(localPing);
      showVehiclesForLooking(this.mSessionPreferences.getSelectedVehicleViewId());
      return;
    case 2:
      stopVehicleAnimations();
      return;
    case 3:
    case 4:
      showVehicleForTrip(localPing);
      return;
    case 5:
    }
    showVehicleForTrip(localPing);
  }

  @Subscribe
  public void onVehicleViewEvent(VehicleViewSelectedEvent paramVehicleViewSelectedEvent)
  {
    Ping localPing = this.mPingProvider.get();
    if (!PingUtils.hasClient(localPing));
    while (!"Looking".equals(localPing.getClient().getStatus()))
      return;
    showVehiclesForLooking(paramVehicleViewSelectedEvent.getVehicleViewId());
  }

  public void start()
  {
    this.mMapCameraStateManager.setDriverMarkerPositionProvider(this);
    this.mIsShowAllVehicles = this.mRiderPreferences.isShowingAllVehicles();
    this.mBus.register(this);
  }

  public void stop()
  {
    stopVehicleAnimations();
    this.mMapCameraStateManager.setDriverMarkerPositionProvider(null);
    this.mBus.unregister(this);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.map.layer.vehicles.VehiclesMapLayer
 * JD-Core Version:    0.6.2
 */