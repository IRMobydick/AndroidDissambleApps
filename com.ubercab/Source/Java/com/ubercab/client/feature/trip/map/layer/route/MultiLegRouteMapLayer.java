package com.ubercab.client.feature.trip.map.layer.route;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.content.event.PingEvent;
import com.ubercab.client.core.model.AppConfig;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.CnLocation;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.Trip;
import com.ubercab.client.core.model.TripEntity;
import com.ubercab.client.core.model.TripLeg;
import com.ubercab.client.core.model.TripLegAction;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.feature.trip.map.MapCameraStateManager;
import com.ubercab.client.feature.trip.map.MapPolylineStyle;
import com.ubercab.client.feature.trip.map.MapUtils;
import com.ubercab.client.feature.trip.map.layer.BaseMapLayer;
import com.ubercab.common.base.Objects;
import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.map.UberBitmapDescriptorFactory;
import com.ubercab.library.map.UberMap;
import com.ubercab.library.map.UberMarker;
import com.ubercab.library.map.UberMarkerOptions;
import com.ubercab.library.map.UberPolyline;
import com.ubercab.library.map.UberPolylineOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

public class MultiLegRouteMapLayer extends BaseMapLayer
{
  private final Bitmap mBitmapPinEnd;
  private final Bitmap mBitmapPinStart;

  @Inject
  Bus mBus;
  private List<TripLeg> mLastMultiLegs;

  @Inject
  UberMap mMap;

  @Inject
  MapCameraStateManager mMapCameraStateManager;
  private List<UberMarker> mMultiLegMarkers;
  private List<UberPolyline> mMultiLegPolylines;

  @Inject
  MapPolylineStyle mPolylineStyle;

  public MultiLegRouteMapLayer(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    this.mBitmapPinStart = ((BitmapDrawable)localResources.getDrawable(2130837848)).getBitmap();
    this.mBitmapPinEnd = ((BitmapDrawable)localResources.getDrawable(2130837844)).getBitmap();
  }

  private void addMultiLegMarkers(Ping paramPing, List<TripLeg> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Trip localTrip = paramPing.getTrip();
    Client localClient = paramPing.getClient();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      TripLeg localTripLeg = (TripLeg)localIterator.next();
      if ((localTripLeg.getActions() != null) && (!localTripLeg.getActions().isEmpty()) && (!localTrip.isLegForUser(localTripLeg, localClient.getUuid())))
      {
        TripLegAction localTripLegAction = (TripLegAction)localTripLeg.getActions().get(0);
        TripEntity localTripEntity = localTrip.getEntity(localTripLegAction.getEntityRef());
        CnLocation localCnLocation = localTrip.getLocation(localTripLeg.getLocationEndRef());
        if ((localTripEntity != null) && (localCnLocation != null) && (localCnLocation.getLatitude() != 0.0D) && (localCnLocation.getLongitude() != 0.0D))
        {
          if (localTripLegAction.getType().equals("Pickup"));
          for (Bitmap localBitmap = this.mBitmapPinStart; ; localBitmap = this.mBitmapPinEnd)
          {
            localArrayList.add(this.mMap.addMarker(new UberMarkerOptions().position(localCnLocation.getUberLatLng()).icon(new UberBitmapDescriptorFactory().fromBitmap(localBitmap)).anchor(0.5F, 0.5F)));
            break;
          }
        }
      }
    }
    this.mMultiLegMarkers = localArrayList;
  }

  private void addMultiLegRouteLines(Ping paramPing, List<TripLeg> paramList)
  {
    Trip localTrip = paramPing.getTrip();
    Client localClient = paramPing.getClient();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      TripLeg localTripLeg = (TripLeg)localIterator.next();
      String str = localTripLeg.getEncodedPolyline();
      if (!TextUtils.isEmpty(str))
      {
        List localList = MapUtils.decodePolyline(str);
        if ((localList != null) && (!localList.isEmpty()))
        {
          if (localTrip.isUserInVehicleForLeg(localTripLeg, localClient.getUuid()));
          for (int i = this.mPolylineStyle.getPolylineColor(); ; i = this.mPolylineStyle.getPolylineSecondaryColor())
          {
            localArrayList.add(this.mMap.addPolyline(new UberPolylineOptions().points(localList).width(this.mPolylineStyle.getPolylineWidth()).color(i)));
            break;
          }
        }
      }
    }
    this.mMultiLegPolylines = localArrayList;
  }

  private List<TripLeg> getLegsForDisplay(Ping paramPing)
  {
    Client localClient = paramPing.getClient();
    String str = localClient.getStatus();
    int i = -1;
    switch (str.hashCode())
    {
    default:
    case -1978426120:
    case -1929061692:
    }
    while (true)
      switch (i)
      {
      default:
        return null;
        if (str.equals("WaitingForPickup"))
        {
          i = 0;
          continue;
          if (str.equals("OnTrip"))
            i = 1;
        }
        break;
      case 0:
      case 1:
      }
    return paramPing.getTrip().getLegsBetweenCurrentLegAndPickup(localClient);
    return paramPing.getTrip().getRemainingLegs();
  }

  private void removeMultiLegMarkers()
  {
    if (this.mMultiLegMarkers == null)
      return;
    Iterator localIterator = this.mMultiLegMarkers.iterator();
    while (localIterator.hasNext())
      ((UberMarker)localIterator.next()).remove();
    this.mMultiLegMarkers = null;
  }

  private void removeMultiLegRouteLines()
  {
    if (this.mMultiLegPolylines == null)
      return;
    Iterator localIterator = this.mMultiLegPolylines.iterator();
    while (localIterator.hasNext())
      ((UberPolyline)localIterator.next()).remove();
    this.mMultiLegPolylines = null;
  }

  public List<UberLatLng> getRoutePoints()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.mMultiLegPolylines != null) && (!this.mMultiLegPolylines.isEmpty()))
    {
      Iterator localIterator2 = this.mMultiLegPolylines.iterator();
      while (localIterator2.hasNext())
        localArrayList.addAll(((UberPolyline)localIterator2.next()).getPoints());
    }
    if ((this.mMultiLegMarkers != null) && (!this.mMultiLegMarkers.isEmpty()))
    {
      Iterator localIterator1 = this.mMultiLegMarkers.iterator();
      while (localIterator1.hasNext())
        localArrayList.add(((UberMarker)localIterator1.next()).getPosition());
    }
    if (localArrayList.isEmpty())
      localArrayList = null;
    return localArrayList;
  }

  @Subscribe
  public void onPingEvent(PingEvent paramPingEvent)
  {
    Ping localPing = paramPingEvent.getPing();
    if ((!PingUtils.hasMultiLegTrip(localPing)) || (!localPing.getAppConfig().getUseTripLegs()))
    {
      removeMultiLegRouteLines();
      removeMultiLegMarkers();
      this.mLastMultiLegs = null;
    }
    List localList;
    do
    {
      return;
      localList = getLegsForDisplay(localPing);
    }
    while (Objects.equal(this.mLastMultiLegs, localList));
    this.mLastMultiLegs = localList;
    removeMultiLegRouteLines();
    removeMultiLegMarkers();
    if (localList != null)
    {
      addMultiLegRouteLines(localPing, localList);
      addMultiLegMarkers(localPing, localList);
    }
    this.mMapCameraStateManager.syncCamera();
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
 * Qualified Name:     com.ubercab.client.feature.trip.map.layer.route.MultiLegRouteMapLayer
 * JD-Core Version:    0.6.2
 */