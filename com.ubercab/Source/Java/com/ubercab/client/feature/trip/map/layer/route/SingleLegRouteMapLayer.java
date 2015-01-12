package com.ubercab.client.feature.trip.map.layer.route;

import android.text.TextUtils;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.content.event.PingEvent;
import com.ubercab.client.core.model.AppConfig;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.Trip;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.feature.trip.TripUIStateManager;
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

public class SingleLegRouteMapLayer extends BaseMapLayer
{

  @Inject
  Bus mBus;
  private String mLastEncodedPolyline;

  @Inject
  UberMap mMap;

  @Inject
  MapCameraStateManager mMapCameraStateManager;

  @Inject
  MapPolylineStyle mMapPolylineStyle;
  private UberPolyline mPolylineRoute;

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
    this.mPolylineRoute = this.mMap.addPolyline(new UberPolylineOptions().points(localList).width(this.mMapPolylineStyle.getPolylineWidth()).color(this.mMapPolylineStyle.getPolylineColor()));
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
  public void onPingEvent(PingEvent paramPingEvent)
  {
    int i = 1;
    Ping localPing = paramPingEvent.getPing();
    if ((PingUtils.hasMultiLegTrip(localPing)) && (localPing.getAppConfig().getUseTripLegs()))
      removeRouteLine();
    label108: label111: 
    while (true)
    {
      return;
      int j = this.mTripUIStateManager.getState();
      boolean bool1 = this.mTripUIStateManager.showNewConfirmation();
      boolean bool2 = this.mTripUIStateManager.hasDestination();
      int k;
      if (j == i)
      {
        k = i;
        if (j != 2)
          break label108;
      }
      while (true)
      {
        if ((bool1) && (bool2) && ((k != 0) || (i != 0)))
          break label111;
        if (PingUtils.hasTrip(localPing))
          break label113;
        removeRouteLine();
        return;
        k = 0;
        break;
        i = 0;
      }
    }
    label113: updateRouteLine(localPing.getTrip().getRouteToDestination());
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
 * Qualified Name:     com.ubercab.client.feature.trip.map.layer.route.SingleLegRouteMapLayer
 * JD-Core Version:    0.6.2
 */