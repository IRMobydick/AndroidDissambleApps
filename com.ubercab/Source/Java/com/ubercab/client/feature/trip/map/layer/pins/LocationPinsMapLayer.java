package com.ubercab.client.feature.trip.map.layer.pins;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.animation.LinearInterpolator;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.RiderLocationProvider;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.client.core.content.event.DeviceLocationEvent;
import com.ubercab.client.core.content.event.PingEvent;
import com.ubercab.client.core.location.RiderLocation;
import com.ubercab.client.core.model.City;
import com.ubercab.client.core.model.CnLocation;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.Trip;
import com.ubercab.client.core.model.VehicleView;
import com.ubercab.client.core.ui.TripEtaPinPainter;
import com.ubercab.client.core.util.LatLngInterpolator;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.feature.trip.TripUIStateManager;
import com.ubercab.client.feature.trip.event.DestinationChangedEvent;
import com.ubercab.client.feature.trip.event.FareEstimateEvent;
import com.ubercab.client.feature.trip.event.ShowFareQuoteEvent;
import com.ubercab.client.feature.trip.event.TripUIStateChangedEvent;
import com.ubercab.client.feature.trip.map.layer.BaseMapLayer;
import com.ubercab.common.base.Objects;
import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.location.model.UberLocation;
import com.ubercab.library.map.UberBitmapDescriptor;
import com.ubercab.library.map.UberBitmapDescriptorFactory;
import com.ubercab.library.map.UberMap;
import com.ubercab.library.map.UberMarker;
import com.ubercab.library.map.UberMarkerOptions;
import com.ubercab.library.map.UberProjection;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class LocationPinsMapLayer extends BaseMapLayer
{
  private static final String STATE_SHOW_DESTINATION_ETA_TIME = "com.ubercab.STATE_SHOW_DESTINATION_ETA_TIME";

  @Inject
  Bus mBus;
  private RiderLocation mLastDestination;
  private Integer mLastDestinationEta;
  private String mLastPickupEtaString;
  private RiderLocation mLastPickupLocation;
  private boolean mLastShowDestinationEtaTime;
  private int mLastTripUIState = -1;

  @Inject
  RiderLocationProvider mLocationProvider;

  @Inject
  UberMap mMap;
  private int mMapAnimationTime;
  private UberMarker mMarkerDestinationLocation;
  private UberMarker mMarkerMyLocation;
  private UberMarker mMarkerPickupEta;
  private UberMarker mMarkerSetLocation;

  @Inject
  PingProvider mPingProvider;

  @Inject
  SessionPreferences mSessionPreferences;
  private boolean mShowDestinationEtaTime;
  private TripEtaPinPainter mTripEtaPinPainter;

  @Inject
  TripUIStateManager mTripUIStateManager;

  @Inject
  UberBitmapDescriptorFactory mUberBitmapDescriptorFactory;
  private DestinationPinView mViewDestinationPin;

  public LocationPinsMapLayer(Context paramContext, Bundle paramBundle)
  {
    this.mTripEtaPinPainter = new TripEtaPinPainter(paramContext);
    this.mMapAnimationTime = paramContext.getResources().getInteger(2131492872);
    this.mViewDestinationPin = ((DestinationPinView)LayoutInflater.from(paramContext).inflate(2130903097, null, false));
    if (paramBundle != null)
      this.mShowDestinationEtaTime = paramBundle.getBoolean("com.ubercab.STATE_SHOW_DESTINATION_ETA_TIME", false);
  }

  private void addMyLocationMarker()
  {
    if (this.mMarkerMyLocation != null);
    RiderLocation localRiderLocation;
    do
    {
      return;
      localRiderLocation = this.mLocationProvider.getDeviceLocation();
    }
    while (localRiderLocation == null);
    UberBitmapDescriptor localUberBitmapDescriptor = this.mUberBitmapDescriptorFactory.fromResource(2130837814);
    UberMarkerOptions localUberMarkerOptions = new UberMarkerOptions().icon(localUberBitmapDescriptor).anchor(0.5F, 0.5F).position(localRiderLocation.getUberLatLng());
    this.mMarkerMyLocation = this.mMap.addMarker(localUberMarkerOptions);
  }

  private void addPickupEtaPinMarker()
  {
    Ping localPing = this.mPingProvider.get();
    if ((!PingUtils.hasTrip(localPing)) || (localPing.getTrip().getPickupLocation() == null))
      removePickupEtaPinMarker();
    String str;
    do
    {
      return;
      str = localPing.getTrip().getEtaString();
      if (TextUtils.isEmpty(str))
      {
        removePickupEtaPinMarker();
        return;
      }
    }
    while (str.equals(this.mLastPickupEtaString));
    Bitmap localBitmap = this.mTripEtaPinPainter.drawPickup(str);
    if (localBitmap == null)
    {
      removePickupEtaPinMarker();
      return;
    }
    this.mLastPickupEtaString = str;
    UberBitmapDescriptor localUberBitmapDescriptor = this.mUberBitmapDescriptorFactory.fromBitmap(localBitmap);
    UberLatLng localUberLatLng = localPing.getTrip().getPickupLocation().getUberLatLng();
    if (this.mMarkerPickupEta == null)
    {
      UberMarkerOptions localUberMarkerOptions = new UberMarkerOptions().icon(localUberBitmapDescriptor).position(localUberLatLng);
      this.mMarkerPickupEta = this.mMap.addMarker(localUberMarkerOptions);
      return;
    }
    this.mMarkerPickupEta.setPosition(localUberLatLng);
    this.mMarkerPickupEta.setIcon(localUberBitmapDescriptor);
  }

  private void removeDestinationPinMarker()
  {
    if (this.mMarkerDestinationLocation != null)
    {
      this.mMarkerDestinationLocation.remove();
      this.mMarkerDestinationLocation = null;
    }
  }

  private void removeMyLocationMarker()
  {
    if (this.mMarkerMyLocation == null)
      return;
    this.mMarkerMyLocation.remove();
    this.mMarkerMyLocation = null;
  }

  private void removePickupEtaPinMarker()
  {
    if (this.mMarkerPickupEta != null)
    {
      this.mMarkerPickupEta.remove();
      this.mMarkerPickupEta = null;
      this.mLastPickupEtaString = null;
    }
  }

  private void update()
  {
    updateSetPickupPinMarker();
    updateDestinationPinMarker();
    updateMyLocationMarker();
    updatePickupEtaPinMarker();
  }

  private void updateDestinationPinMarker()
  {
    if (this.mTripUIStateManager.getDestination() == null)
    {
      removeDestinationPinMarker();
      return;
    }
    int i = this.mTripUIStateManager.getState();
    this.mViewDestinationPin.updateUI(this.mTripUIStateManager.getState());
    switch (i)
    {
    case 3:
    case 4:
    default:
      removeDestinationPinMarker();
      return;
    case 1:
    case 2:
      updatePreTripDestinationPin();
      return;
    case 5:
    }
    updateTripDestinationPin();
  }

  private void updateMyLocationMarker()
  {
    int i = this.mTripUIStateManager.getState();
    if ((i != 2) && (i != 5))
    {
      addMyLocationMarker();
      return;
    }
    removeMyLocationMarker();
  }

  private void updatePickupEtaPinMarker()
  {
    int i = this.mTripUIStateManager.getState();
    if ((i == 3) || (i == 4))
    {
      addPickupEtaPinMarker();
      return;
    }
    removePickupEtaPinMarker();
  }

  private void updatePreTripDestinationPin()
  {
    RiderLocation localRiderLocation = this.mTripUIStateManager.getDestination();
    UberBitmapDescriptor localUberBitmapDescriptor = this.mUberBitmapDescriptorFactory.fromBitmap(this.mViewDestinationPin.getBitmap());
    if (this.mMarkerDestinationLocation == null)
    {
      UberMarkerOptions localUberMarkerOptions = new UberMarkerOptions().icon(localUberBitmapDescriptor).position(localRiderLocation.getUberLatLng());
      this.mMarkerDestinationLocation = this.mMap.addMarker(localUberMarkerOptions);
      return;
    }
    this.mMarkerDestinationLocation.setIcon(localUberBitmapDescriptor);
    this.mMarkerDestinationLocation.setPosition(localRiderLocation.getUberLatLng());
  }

  private void updateSetPickupPinMarker()
  {
    Ping localPing = this.mPingProvider.get();
    int i;
    int j;
    label34: int k;
    label69: UberLatLng localUberLatLng;
    if (this.mTripUIStateManager.getState() == 2)
    {
      i = 1;
      if (this.mTripUIStateManager.getState() != 1)
        break label127;
      j = 1;
      boolean bool1 = this.mTripUIStateManager.showNewConfirmation();
      boolean bool2 = this.mTripUIStateManager.hasDestination();
      if ((j == 0) || (!bool1) || (!bool2))
        break label132;
      k = 1;
      if (!PingUtils.hasTripPickup(localPing))
        break label138;
      localUberLatLng = localPing.getTrip().getPickupLocation().getUberLatLng();
    }
    while (true)
    {
      if ((localUberLatLng != null) && ((i != 0) || (k != 0)))
        break label170;
      if (this.mMarkerSetLocation != null)
      {
        this.mMarkerSetLocation.remove();
        this.mMarkerSetLocation = null;
      }
      return;
      i = 0;
      break;
      label127: j = 0;
      break label34;
      label132: k = 0;
      break label69;
      label138: RiderLocation localRiderLocation = this.mLocationProvider.getPinLocation();
      localUberLatLng = null;
      if (localRiderLocation != null)
        localUberLatLng = this.mLocationProvider.getPinLocation().getUberLatLng();
    }
    label170: if (this.mMarkerSetLocation != null)
    {
      this.mMarkerSetLocation.setPosition(localUberLatLng);
      return;
    }
    UberBitmapDescriptor localUberBitmapDescriptor = this.mUberBitmapDescriptorFactory.fromResource(2130837847);
    UberMarkerOptions localUberMarkerOptions = new UberMarkerOptions().icon(localUberBitmapDescriptor).position(localUberLatLng);
    this.mMarkerSetLocation = this.mMap.addMarker(localUberMarkerOptions);
  }

  private void updateTripDestinationPin()
  {
    Ping localPing = this.mPingProvider.get();
    RiderLocation localRiderLocation1 = this.mTripUIStateManager.getDestination();
    RiderLocation localRiderLocation2 = this.mLocationProvider.getPinLocation();
    int i = this.mTripUIStateManager.getState();
    Integer localInteger = localPing.getTrip().getEtaToDestination();
    boolean bool1 = Objects.equal(this.mLastPickupLocation, localRiderLocation2);
    boolean bool2 = Objects.equal(this.mLastDestination, localRiderLocation1);
    boolean bool3 = Objects.equal(this.mLastDestinationEta, localInteger);
    int j;
    if (this.mLastTripUIState == i)
    {
      j = 1;
      if (this.mLastShowDestinationEtaTime != this.mShowDestinationEtaTime)
        break label168;
    }
    label168: for (int k = 1; ; k = 0)
    {
      this.mLastPickupLocation = localRiderLocation2;
      this.mLastDestination = localRiderLocation1;
      this.mLastTripUIState = i;
      this.mLastDestinationEta = localInteger;
      this.mLastShowDestinationEtaTime = this.mShowDestinationEtaTime;
      if ((!bool1) || (!bool2) || (!bool3) || (j == 0) || (k == 0) || (this.mMarkerDestinationLocation == null))
        break label174;
      return;
      j = 0;
      break;
    }
    label174: if ((!bool1) || (!bool2) || (j == 0))
      this.mShowDestinationEtaTime = false;
    Bitmap localBitmap;
    if (localInteger != null)
      localBitmap = this.mTripEtaPinPainter.drawDestination(localInteger.intValue(), this.mShowDestinationEtaTime);
    for (UberBitmapDescriptor localUberBitmapDescriptor = this.mUberBitmapDescriptorFactory.fromBitmap(localBitmap); this.mMarkerDestinationLocation == null; localUberBitmapDescriptor = this.mUberBitmapDescriptorFactory.fromResource(2130837843))
    {
      UberMarkerOptions localUberMarkerOptions = new UberMarkerOptions().icon(localUberBitmapDescriptor).position(localRiderLocation1.getUberLatLng());
      this.mMarkerDestinationLocation = this.mMap.addMarker(localUberMarkerOptions);
      return;
    }
    this.mMarkerDestinationLocation.setPosition(localRiderLocation1.getUberLatLng());
    this.mMarkerDestinationLocation.setIcon(localUberBitmapDescriptor);
  }

  public List<UberLatLng> getAdditionalRouteBounds()
  {
    if (this.mTripUIStateManager.getDestination() == null);
    while ((this.mTripUIStateManager.getState() != 1) || (!this.mTripUIStateManager.showNewConfirmation()) || (this.mViewDestinationPin == null) || (!this.mViewDestinationPin.hasFareEstimate()))
      return null;
    UberLatLng localUberLatLng = this.mTripUIStateManager.getDestination().getUberLatLng();
    int i = this.mViewDestinationPin.getWidth();
    int j = this.mViewDestinationPin.getHeight();
    UberProjection localUberProjection = this.mMap.getProjection();
    Point localPoint = localUberProjection.toScreenLocation(localUberLatLng);
    int k = localPoint.x - i / 2;
    int m = localPoint.x + i / 2;
    int n = localPoint.y - j;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localUberProjection.fromScreenLocation(new Point(k, n)));
    localArrayList.add(localUberProjection.fromScreenLocation(new Point(m, n)));
    return localArrayList;
  }

  @Subscribe
  public void onDestinationChangedEvent(DestinationChangedEvent paramDestinationChangedEvent)
  {
    update();
  }

  @Subscribe
  public void onDeviceLocationEvent(DeviceLocationEvent paramDeviceLocationEvent)
  {
    RiderLocation localRiderLocation = paramDeviceLocationEvent.getLocation();
    if (this.mMarkerMyLocation == null)
      return;
    UberLatLng localUberLatLng = localRiderLocation.getUberLatLng();
    TypeEvaluator local1 = new TypeEvaluator()
    {
      public UberLatLng evaluate(float paramAnonymousFloat, UberLatLng paramAnonymousUberLatLng1, UberLatLng paramAnonymousUberLatLng2)
      {
        return LatLngInterpolator.linear(paramAnonymousFloat, paramAnonymousUberLatLng1, paramAnonymousUberLatLng2);
      }
    };
    Property localProperty = Property.of(UberMarker.class, UberLatLng.class, "position");
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofObject(this.mMarkerMyLocation, localProperty, local1, new UberLatLng[] { localUberLatLng });
    localObjectAnimator.setInterpolator(new LinearInterpolator());
    localObjectAnimator.setDuration(this.mMapAnimationTime).start();
  }

  @Subscribe
  public void onFareEstimateEvent(FareEstimateEvent paramFareEstimateEvent)
  {
    if ((this.mTripUIStateManager.getState() != 1) || (!this.mTripUIStateManager.showNewConfirmation()));
    while (Objects.equal(this.mViewDestinationPin.getEstimateText(), paramFareEstimateEvent.getFareEstimateString()))
      return;
    Ping localPing = this.mPingProvider.get();
    boolean bool1 = PingUtils.hasVehicleView(localPing, this.mSessionPreferences.getSelectedVehicleViewId());
    boolean bool2 = false;
    if (bool1)
      bool2 = localPing.getCity().findVehicleView(this.mSessionPreferences.getSelectedVehicleViewId()).isAllowFareEstimate();
    DestinationPinView localDestinationPinView1 = this.mViewDestinationPin;
    String str1;
    DestinationPinView localDestinationPinView2;
    if (bool2)
    {
      str1 = paramFareEstimateEvent.getFareEstimateString();
      localDestinationPinView1.setEstimateText(str1);
      localDestinationPinView2 = this.mViewDestinationPin;
      if (!bool2)
        break label146;
    }
    label146: for (String str2 = paramFareEstimateEvent.getFareEstimateTagline(); ; str2 = "")
    {
      localDestinationPinView2.setTaglineText(str2);
      updateDestinationPinMarker();
      return;
      str1 = "";
      break;
    }
  }

  public void onMarkerClick(UberMarker paramUberMarker)
  {
    if ((this.mMarkerDestinationLocation != null) && (paramUberMarker.getId().equals(this.mMarkerDestinationLocation.getId())))
      if (this.mShowDestinationEtaTime)
        break label74;
    label74: for (boolean bool = true; ; bool = false)
    {
      this.mShowDestinationEtaTime = bool;
      updateDestinationPinMarker();
      if ((this.mViewDestinationPin != null) && (this.mViewDestinationPin.hasFareEstimate()))
        this.mBus.post(new ShowFareQuoteEvent());
      return;
    }
  }

  @Subscribe
  public void onPingEvent(PingEvent paramPingEvent)
  {
    update();
  }

  @Subscribe
  public void onTripUIStateChangedEvent(TripUIStateChangedEvent paramTripUIStateChangedEvent)
  {
    update();
  }

  public void saveInstanceState(Bundle paramBundle)
  {
    paramBundle.putBoolean("com.ubercab.STATE_SHOW_DESTINATION_ETA_TIME", this.mShowDestinationEtaTime);
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
 * Qualified Name:     com.ubercab.client.feature.trip.map.layer.pins.LocationPinsMapLayer
 * JD-Core Version:    0.6.2
 */