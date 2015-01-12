package com.ubercab.client.feature.trip.map;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageButton;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.analytics.event.PageEvent;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.content.RiderLocationProvider;
import com.ubercab.client.core.content.event.PinLocationEvent;
import com.ubercab.client.core.location.RiderLocation;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Tap;
import com.ubercab.client.feature.trip.TripUIStateManager;
import com.ubercab.client.feature.trip.event.TripUIStateChangedEvent;
import com.ubercab.client.feature.trip.map.layer.MapLayer;
import com.ubercab.client.feature.trip.map.layer.MapLayerModule;
import com.ubercab.client.feature.trip.map.layer.directions.DirectionsMapLayer;
import com.ubercab.client.feature.trip.map.layer.pins.LocationPinsMapLayer;
import com.ubercab.client.feature.trip.map.layer.route.MultiLegRouteMapLayer;
import com.ubercab.client.feature.trip.map.layer.route.SingleLegRouteMapLayer;
import com.ubercab.client.feature.trip.map.layer.vehicles.VehiclesMapLayer;
import com.ubercab.common.collect.ObjectArrays;
import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.map.UberCameraPosition;
import com.ubercab.library.map.UberCameraUpdate;
import com.ubercab.library.map.UberCameraUpdateFactory;
import com.ubercab.library.map.UberMap;
import com.ubercab.library.map.UberMap.CancelableCallback;
import com.ubercab.library.map.UberMap.OnCameraChangeListener;
import com.ubercab.library.map.UberMap.OnMarkerClickListener;
import com.ubercab.library.map.UberMapUiSettings;
import com.ubercab.library.map.UberMapView;
import com.ubercab.library.map.UberMarker;
import com.ubercab.library.map.UberProjection;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import com.ubercab.library.util.LocationUtils;
import dagger.ObjectGraph;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;

public class MapFragment extends RiderFragment
  implements UberMap.OnMarkerClickListener, UberMap.OnCameraChangeListener, MapViewExtension.Listener, RiderMap, MapTouchEventListener
{
  private static final int CHECK_MAP_INITIALIZED_FREQ = 500;
  public static final UberLatLng DEFAULT_LATLNG = new UberLatLng(0.0D, 0.0D);
  private static final String STATE_CAMERA_POSITION = "com.ubercab.CAMERA_POSITION";

  @Inject
  AnalyticsClient mAnalyticsClient;

  @Inject
  AnalyticsManager mAnalyticsManager;

  @InjectView(2131427790)
  ImageButton mButtonMyLocation;
  private RiderCameraUpdate mCameraUpdatePending;
  private final Handler mHandler = new Handler();
  private final Runnable mInitializeMapRunnable = new Runnable()
  {
    public void run()
    {
      MapFragment.this.initializeMap();
      if (!MapFragment.this.isMapInitialized())
        MapFragment.this.mHandler.postDelayed(MapFragment.this.mInitializeMapRunnable, 500L);
    }
  };
  private boolean mIsCameraMoving;
  private int mLastTripUIState = -1;
  private final List<MapLayer> mLayers = new ArrayList();

  @Inject
  RiderLocationProvider mLocationProvider;
  private int mMapAnimationTime;

  @Inject
  MapCameraStateManager mMapCameraStateManager;
  private final List<UberMap.OnCameraChangeListener> mOnCameraChangeListeners = new CopyOnWriteArrayList();
  private Rect mPadding;
  private Rect mPaddingPending;
  private boolean mResumed;
  private Bundle mSavedInstanceState;

  @Inject
  TripUIStateManager mTripUIStateManager;
  private UberCameraUpdateFactory mUberCameraUpdateFactory;
  private UberMap mUberMap;
  private UberMapView mViewMap;

  @InjectView(2131427788)
  MapViewExtension mViewMapExtension;

  private void animateCamera(UberCameraUpdate paramUberCameraUpdate)
  {
    this.mIsCameraMoving = true;
    this.mUberMap.animateCamera(paramUberCameraUpdate, this.mMapAnimationTime, new UberMap.CancelableCallback()
    {
      public void onCancel()
      {
        if (MapFragment.this.mIsCameraMoving)
        {
          MapFragment.access$402(MapFragment.this, false);
          MapFragment.this.mViewMap.post(new Runnable()
          {
            public void run()
            {
              MapFragment.this.applyPendingPadding();
              MapFragment.this.applyPendingCameraUpdate();
            }
          });
        }
      }

      public void onFinish()
      {
        if (MapFragment.this.mIsCameraMoving)
        {
          MapFragment.access$402(MapFragment.this, false);
          MapFragment.this.applyPendingPadding();
          MapFragment.this.applyPendingCameraUpdate();
        }
      }
    });
    this.mViewMap.postDelayed(new Runnable()
    {
      public void run()
      {
        if (!MapFragment.this.isAdded());
        while (!MapFragment.this.mIsCameraMoving)
          return;
        MapFragment.access$402(MapFragment.this, false);
        MapFragment.this.applyPendingPadding();
        MapFragment.this.applyPendingCameraUpdate();
      }
    }
    , 500 + this.mMapAnimationTime);
  }

  private void applyPendingCameraUpdate()
  {
    RiderCameraUpdate localRiderCameraUpdate = this.mCameraUpdatePending;
    if (localRiderCameraUpdate != null)
    {
      this.mCameraUpdatePending = null;
      processCameraUpdate(localRiderCameraUpdate);
    }
  }

  private void applyPendingPadding()
  {
    Rect localRect = this.mPaddingPending;
    if (localRect != null)
    {
      this.mPaddingPending = null;
      setPadding(localRect.left, localRect.top, localRect.right, localRect.bottom);
    }
  }

  private void handleResumeIfMapReady()
  {
    if (!isMapInitialized());
    while (true)
    {
      return;
      this.mMapCameraStateManager.start();
      Iterator localIterator = this.mLayers.iterator();
      while (localIterator.hasNext())
        ((MapLayer)localIterator.next()).start();
    }
  }

  private void initCameraPosition(Bundle paramBundle)
  {
    RiderLocation localRiderLocation = this.mLocationProvider.getPinLocation();
    if (localRiderLocation == null)
      localRiderLocation = this.mLocationProvider.getDeviceLocation();
    if (localRiderLocation == null)
      return;
    UberLatLng localUberLatLng = localRiderLocation.getUberLatLng();
    if (paramBundle != null)
    {
      UberCameraPosition localUberCameraPosition = new UberCameraPosition("com.ubercab.CAMERA_POSITION", paramBundle);
      moveCamera(this.mUberCameraUpdateFactory.newLatLngZoom(localUberCameraPosition.getTarget(), localUberCameraPosition.getZoom()));
    }
    while (true)
    {
      this.mViewMapExtension.setCenterCoordinates(this.mUberMap.getProjection().toScreenLocation(localUberLatLng));
      updateMyLocationButton(false);
      return;
      moveCamera(this.mUberCameraUpdateFactory.newLatLngZoom(localRiderLocation.getUberLatLng(), 15.0F));
    }
  }

  private void initLayers(Bundle paramBundle)
  {
    ObjectGraph localObjectGraph1 = getFragmentGraph();
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = new MapLayerModule(this.mUberMap);
    ObjectGraph localObjectGraph2 = localObjectGraph1.plus(arrayOfObject);
    Activity localActivity = getActivity();
    this.mLayers.add(localObjectGraph2.inject(new DirectionsMapLayer()));
    this.mLayers.add(localObjectGraph2.inject(new SingleLegRouteMapLayer()));
    this.mLayers.add(localObjectGraph2.inject(new MultiLegRouteMapLayer(localActivity)));
    this.mLayers.add(localObjectGraph2.inject(new VehiclesMapLayer()));
    this.mLayers.add(localObjectGraph2.inject(new LocationPinsMapLayer(localActivity, paramBundle)));
  }

  private void initializeMap()
  {
    this.mUberMap = this.mViewMap.getMap();
    if (!isMapInitialized());
    do
    {
      return;
      this.mUberMap.setOnMarkerClickListener(this);
      this.mUberMap.setOnCameraChangeListener(this);
      this.mUberMap.setIndoorEnabled(false);
      this.mUberMap.setBuildingsEnabled(false);
      this.mUberMap.setMapType(0);
      this.mUberMap.getUiSettings().setCompassEnabled(false);
      this.mUberMap.getUiSettings().setZoomGesturesEnabled(true);
      this.mUberMap.getUiSettings().setTiltGesturesEnabled(false);
      this.mUberMap.getUiSettings().setZoomControlsEnabled(false);
      this.mUberMap.getUiSettings().setRotateGesturesEnabled(false);
      this.mUberMap.getUiSettings().setMyLocationButtonEnabled(false);
      this.mViewMapExtension.addZoomListener(this);
      this.mViewMapExtension.addTouchEventListener(this);
      initCameraPosition(this.mSavedInstanceState);
      initLayers(this.mSavedInstanceState);
    }
    while (!this.mResumed);
    handleResumeIfMapReady();
  }

  private boolean isMapInitialized()
  {
    return this.mUberMap != null;
  }

  private void moveCamera(UberCameraUpdate paramUberCameraUpdate)
  {
    this.mIsCameraMoving = true;
    this.mUberMap.moveCamera(paramUberCameraUpdate);
    this.mIsCameraMoving = false;
    applyPendingPadding();
    applyPendingCameraUpdate();
  }

  public static MapFragment newInstance()
  {
    return new MapFragment();
  }

  private void processCameraUpdate(RiderCameraUpdate paramRiderCameraUpdate)
  {
    UberCameraUpdate localUberCameraUpdate = paramRiderCameraUpdate.toUberCameraUpdate(this.mViewMap.getWidth(), this.mViewMap.getHeight());
    if (paramRiderCameraUpdate.shouldAnimate())
    {
      animateCamera(localUberCameraUpdate);
      return;
    }
    moveCamera(localUberCameraUpdate);
  }

  private void updateCameraTracking()
  {
    RiderLocation localRiderLocation = this.mLocationProvider.getDeviceLocation();
    if (localRiderLocation == null)
      return;
    MapCameraStateManager.MapCameraState localMapCameraState = this.mMapCameraStateManager.getState();
    if ((localMapCameraState == MapCameraStateManager.MapCameraState.LOOKING) || (localMapCameraState == MapCameraStateManager.MapCameraState.CONFIRMING))
    {
      boolean bool = LocationUtils.equalWithinDistance(this.mLocationProvider.getPinLocation().getUberLatLng(), localRiderLocation.getUberLatLng());
      this.mMapCameraStateManager.setCameraTracking(bool);
      return;
    }
    updateMyLocationButton(true);
  }

  private void updateMyLocationButton(boolean paramBoolean)
  {
    int i = 5.$SwitchMap$com$ubercab$client$feature$trip$map$MapCameraStateManager$MapCameraState[this.mMapCameraStateManager.getState().ordinal()];
    int j = 0;
    switch (i)
    {
    default:
      if (((j != 0) && (this.mButtonMyLocation.getVisibility() == 0)) || ((j == 0) && (this.mButtonMyLocation.getVisibility() == 8)))
        return;
      break;
    case 1:
    case 2:
    case 3:
    case 4:
      if (!this.mMapCameraStateManager.isCameraTracking());
      for (j = 1; ; j = 0)
        break;
    case 5:
      int k;
      if ((this.mTripUIStateManager.getDestination() != null) && (this.mTripUIStateManager.showNewConfirmation()))
      {
        k = 1;
        label126: if ((this.mMapCameraStateManager.isCameraTracking()) || (k != 0))
          break label152;
      }
      label152: for (j = 1; ; j = 0)
      {
        break;
        k = 0;
        break label126;
      }
    }
    if (paramBoolean)
    {
      if (j != 0)
      {
        this.mButtonMyLocation.setAlpha(0.0F);
        this.mButtonMyLocation.setVisibility(0);
        this.mButtonMyLocation.animate().alpha(1.0F).setListener(null).setDuration(this.mMapAnimationTime).start();
        return;
      }
      this.mButtonMyLocation.animate().alpha(0.0F).setDuration(this.mMapAnimationTime).setListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          if (MapFragment.this.mButtonMyLocation != null)
            MapFragment.this.mButtonMyLocation.setVisibility(8);
        }
      }).start();
      return;
    }
    if (j != 0)
    {
      this.mButtonMyLocation.setAlpha(1.0F);
      this.mButtonMyLocation.setVisibility(0);
      return;
    }
    this.mButtonMyLocation.setAlpha(0.0F);
    this.mButtonMyLocation.setVisibility(8);
  }

  public void addOnCameraChangeListener(UberMap.OnCameraChangeListener paramOnCameraChangeListener)
  {
    this.mOnCameraChangeListeners.add(paramOnCameraChangeListener);
  }

  public void addTouchEventListener(MapTouchEventListener paramMapTouchEventListener)
  {
    this.mViewMapExtension.addTouchEventListener(paramMapTouchEventListener);
  }

  public void applyCameraUpdate(RiderCameraUpdate paramRiderCameraUpdate)
  {
    if (this.mIsCameraMoving)
    {
      this.mCameraUpdatePending = paramRiderCameraUpdate;
      return;
    }
    processCameraUpdate(paramRiderCameraUpdate);
  }

  public List<UberLatLng> getAdditionalRouteBounds()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mLayers.iterator();
    while (localIterator.hasNext())
    {
      List localList = ((MapLayer)localIterator.next()).getAdditionalRouteBounds();
      if (localList != null)
        localArrayList.addAll(localList);
    }
    return localArrayList;
  }

  public UberLatLng getCameraLatLng()
  {
    if (!isMapInitialized())
      return null;
    return this.mUberMap.getCameraPosition().getTarget();
  }

  protected Object[] getModules()
  {
    return ObjectArrays.concat(super.getModules(), new MapModule(this));
  }

  public List<UberLatLng> getRoutePoints()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mLayers.iterator();
    while (localIterator.hasNext())
    {
      List localList = ((MapLayer)localIterator.next()).getRoutePoints();
      if (localList != null)
        localArrayList.addAll(localList);
    }
    return localArrayList;
  }

  public void onCameraChange(UberCameraPosition paramUberCameraPosition)
  {
    if (this.mIsCameraMoving);
    while (true)
    {
      return;
      this.mViewMapExtension.setCenterCoordinates(this.mUberMap.getProjection().toScreenLocation(paramUberCameraPosition.getTarget()));
      Iterator localIterator = this.mOnCameraChangeListeners.iterator();
      while (localIterator.hasNext())
        ((UberMap.OnCameraChangeListener)localIterator.next()).onCameraChange(paramUberCameraPosition);
    }
  }

  @OnClick({2131427790})
  public void onClickMyLocationButton()
  {
    MapCameraStateManager.MapCameraState localMapCameraState = this.mMapCameraStateManager.getState();
    if ((localMapCameraState == MapCameraStateManager.MapCameraState.LOOKING) || (localMapCameraState == MapCameraStateManager.MapCameraState.CONFIRMING))
    {
      this.mLocationProvider.updatePinLocation(this.mLocationProvider.getDeviceLocation());
      this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.MAP_CENTER_BUTTON);
      return;
    }
    this.mMapCameraStateManager.setCameraTracking(true);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mMapAnimationTime = getResources().getInteger(2131492872);
    this.mUberCameraUpdateFactory = new UberCameraUpdateFactory();
    inject(this.mMapCameraStateManager);
    this.mMapCameraStateManager.restoreInstanceState(paramBundle);
    this.mSavedInstanceState = paramBundle;
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903194, paramViewGroup, false);
    ButterKnife.inject(this, localView);
    return localView;
  }

  public void onDestroy()
  {
    super.onDestroy();
    this.mViewMap.onDestroy();
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    this.mViewMapExtension.removeZoomListener(this);
    ButterKnife.reset(this);
  }

  public void onLowMemory()
  {
    super.onLowMemory();
    this.mViewMap.onLowMemory();
  }

  public void onMapCameraTrackingChanged(boolean paramBoolean)
  {
    updateMyLocationButton(true);
  }

  public void onMapTouchEventActionDown()
  {
    this.mCameraUpdatePending = null;
  }

  public void onMapTouchEventActionMove()
  {
    this.mMapCameraStateManager.setCameraTracking(false);
  }

  public void onMapTouchEventActionUp()
  {
  }

  public boolean onMarkerClick(UberMarker paramUberMarker)
  {
    Iterator localIterator = this.mLayers.iterator();
    while (localIterator.hasNext())
      ((MapLayer)localIterator.next()).onMarkerClick(paramUberMarker);
    return true;
  }

  public void onPause()
  {
    super.onPause();
    this.mViewMap.onPause();
    if (isMapInitialized())
    {
      this.mMapCameraStateManager.stop();
      Iterator localIterator = this.mLayers.iterator();
      while (localIterator.hasNext())
        ((MapLayer)localIterator.next()).stop();
    }
    this.mResumed = false;
  }

  @Subscribe
  public void onPinLocationEvent(PinLocationEvent paramPinLocationEvent)
  {
    if (!isMapInitialized())
      return;
    updateCameraTracking();
  }

  public void onResume()
  {
    super.onResume();
    this.mViewMap.onResume();
    this.mAnalyticsManager.pageEvent().mapPageView();
    handleResumeIfMapReady();
    this.mResumed = true;
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (isMapInitialized())
    {
      this.mUberMap.getCameraPosition().writeToBundle("com.ubercab.CAMERA_POSITION", paramBundle);
      this.mMapCameraStateManager.saveInstanceState(paramBundle);
      Iterator localIterator = this.mLayers.iterator();
      while (localIterator.hasNext())
        ((MapLayer)localIterator.next()).saveInstanceState(paramBundle);
    }
  }

  @Subscribe
  public void onTripUIStateChangedEvent(TripUIStateChangedEvent paramTripUIStateChangedEvent)
  {
    if (!isMapInitialized())
      return;
    int i = this.mTripUIStateManager.getState();
    boolean bool1 = TripUIStateManager.isOnTrip(this.mLastTripUIState);
    boolean bool2 = TripUIStateManager.isOnTrip(i);
    this.mLastTripUIState = i;
    if ((!bool1) && (bool2))
    {
      this.mMapCameraStateManager.setCameraTracking(true);
      return;
    }
    updateCameraTracking();
  }

  public void onTwoFingerTap()
  {
    this.mUberMap.animateCamera(this.mUberCameraUpdateFactory.zoomOut());
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.mViewMap = ((UberMapView)paramView.findViewById(2131427789));
    this.mViewMap.onCreate(paramBundle);
    this.mInitializeMapRunnable.run();
  }

  public void onZoomEnd()
  {
    this.mUberMap.getUiSettings().setScrollGesturesEnabled(true);
  }

  public void onZoomStart()
  {
    this.mUberMap.getUiSettings().setScrollGesturesEnabled(false);
  }

  public void removeOnCameraChangeListener(UberMap.OnCameraChangeListener paramOnCameraChangeListener)
  {
    this.mOnCameraChangeListeners.remove(paramOnCameraChangeListener);
  }

  public void removeTouchEventListener(MapTouchEventListener paramMapTouchEventListener)
  {
    this.mViewMapExtension.removeTouchEventListener(paramMapTouchEventListener);
  }

  public void setMyLocationTranslationY(int paramInt)
  {
    this.mButtonMyLocation.animate().translationY(paramInt).setInterpolator(new DecelerateInterpolator()).setDuration(this.mMapAnimationTime).start();
  }

  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Rect localRect = new Rect(paramInt1, paramInt2, paramInt3, paramInt4);
    if (localRect.equals(this.mPadding))
      return;
    if ((!isMapInitialized()) || (this.mIsCameraMoving))
    {
      this.mPaddingPending = localRect;
      return;
    }
    this.mPadding = localRect;
    this.mViewMap.setMapPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mCameraUpdatePending != null)
    {
      applyPendingCameraUpdate();
      return;
    }
    this.mMapCameraStateManager.syncCamera();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.map.MapFragment
 * JD-Core Version:    0.6.2
 */