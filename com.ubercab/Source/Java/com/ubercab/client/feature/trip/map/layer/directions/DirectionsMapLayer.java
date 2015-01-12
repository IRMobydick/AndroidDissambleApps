package com.ubercab.client.feature.trip.map.layer.directions;

import android.text.TextUtils;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.content.RiderLocationProvider;
import com.ubercab.client.core.content.event.PinLocationEvent;
import com.ubercab.client.core.location.RiderLocation;
import com.ubercab.client.core.vendor.google.model.DirectionsResponse;
import com.ubercab.client.core.vendor.google.model.OverviewPolyline;
import com.ubercab.client.core.vendor.google.model.Route;
import com.ubercab.client.core.vendor.google.network.DirectionsClient;
import com.ubercab.client.core.vendor.google.network.event.DirectionsResponseEvent;
import com.ubercab.client.feature.trip.TripUIStateManager;
import com.ubercab.client.feature.trip.event.DestinationChangedEvent;
import com.ubercab.client.feature.trip.event.TripUIStateChangedEvent;
import com.ubercab.client.feature.trip.map.MapCameraStateManager;
import com.ubercab.client.feature.trip.map.MapPolylineStyle;
import com.ubercab.client.feature.trip.map.MapUtils;
import com.ubercab.client.feature.trip.map.layer.BaseMapLayer;
import com.ubercab.common.base.Function;
import com.ubercab.common.collect.Iterables;
import com.ubercab.common.collect.Lists;
import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.map.UberMap;
import com.ubercab.library.map.UberPolyline;
import com.ubercab.library.map.UberPolylineOptions;
import java.util.List;
import javax.inject.Inject;

public class DirectionsMapLayer extends BaseMapLayer
{

  @Inject
  Bus mBus;

  @Inject
  DirectionsClient mDirectionsClient;
  private String mLastEncodedPolyline;

  @Inject
  RiderLocationProvider mLocationProvider;

  @Inject
  UberMap mMap;

  @Inject
  MapCameraStateManager mMapCameraStateManager;
  private UberPolyline mPolylineRoute;

  @Inject
  MapPolylineStyle mPolylineStyle;

  @Inject
  TripUIStateManager mTripUIStateManager;

  private void removeRouteLine()
  {
    if (this.mPolylineRoute == null)
      return;
    this.mPolylineRoute.remove();
    this.mPolylineRoute = null;
    this.mLastEncodedPolyline = null;
  }

  private void update()
  {
    boolean bool1 = this.mTripUIStateManager.showNewConfirmation();
    boolean bool2 = this.mTripUIStateManager.hasDestination();
    if ((bool1) && (bool2))
    {
      RiderLocation localRiderLocation = this.mLocationProvider.getPinLocation();
      this.mDirectionsClient.directions(localRiderLocation, this.mTripUIStateManager.getDestination());
      return;
    }
    removeRouteLine();
  }

  private void updateRouteLine(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      removeRouteLine();
    List localList;
    do
    {
      do
        return;
      while ((this.mLastEncodedPolyline != null) && (this.mLastEncodedPolyline.equals(paramString)));
      removeRouteLine();
      localList = MapUtils.decodePolyline(paramString);
    }
    while ((localList == null) || (localList.isEmpty()));
    this.mLastEncodedPolyline = paramString;
    this.mPolylineRoute = this.mMap.addPolyline(new UberPolylineOptions().points(localList).width(this.mPolylineStyle.getPolylineWidth()).color(this.mPolylineStyle.getPolylineColor()));
    this.mMapCameraStateManager.syncCamera();
  }

  public List<UberLatLng> getRoutePoints()
  {
    if ((this.mPolylineRoute == null) || (this.mPolylineRoute.getPoints() == null) || (this.mPolylineRoute.getPoints().isEmpty()))
      return null;
    return Lists.newArrayList(Iterables.transform(this.mPolylineRoute.getPoints(), new Function()
    {
      public UberLatLng apply(UberLatLng paramAnonymousUberLatLng)
      {
        return new UberLatLng(paramAnonymousUberLatLng.getLatitude(), paramAnonymousUberLatLng.getLongitude());
      }
    }));
  }

  @Subscribe
  public void onDestinationChangedEvent(DestinationChangedEvent paramDestinationChangedEvent)
  {
    update();
  }

  @Subscribe
  public void onDirectionResponseEvent(DirectionsResponseEvent paramDirectionsResponseEvent)
  {
    if ((!paramDirectionsResponseEvent.isSuccess()) || (this.mTripUIStateManager.getState() != 1))
    {
      removeRouteLine();
      return;
    }
    List localList = ((DirectionsResponse)paramDirectionsResponseEvent.getModel()).getRoutes();
    if ((localList != null) && (!localList.isEmpty()))
    {
      OverviewPolyline localOverviewPolyline = ((Route)localList.get(0)).getOverviewPolyline();
      if ((localOverviewPolyline != null) && (!TextUtils.isEmpty(localOverviewPolyline.getPoints())))
      {
        updateRouteLine(localOverviewPolyline.getPoints());
        return;
      }
    }
    removeRouteLine();
  }

  @Subscribe
  public void onPinLocationEvent(PinLocationEvent paramPinLocationEvent)
  {
    update();
  }

  @Subscribe
  public void onTripUIStateChangedEvent(TripUIStateChangedEvent paramTripUIStateChangedEvent)
  {
    update();
  }

  public void start()
  {
    this.mBus.register(this);
  }

  public void stop()
  {
    this.mBus.unregister(this);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.map.layer.directions.DirectionsMapLayer
 * JD-Core Version:    0.6.2
 */