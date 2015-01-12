package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.map.e;
import com.baidu.platform.comapi.map.w;
import com.baidu.platform.comjni.tools.ParcelItem;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BaiduMap
{
  public static final int MAP_TYPE_NORMAL = 1;
  public static final int MAP_TYPE_SATELLITE = 2;
  private static final String a = BaiduMap.class.getSimpleName();
  private Projection b;
  private UiSettings c;
  private e d;
  private List<Overlay> e;
  private Overlay.a f;
  private OnMapStatusChangeListener g;
  private OnMapClickListener h;
  private OnMapLoadedCallback i;
  private OnMapDoubleClickListener j;
  private OnMapLongClickListener k;
  private OnMarkerClickListener l;
  private OnMarkerDragListener m;
  private OnMyLocationClickListener n;
  private SnapshotReadyCallback o;
  private HeatMap p;
  private Lock q = new ReentrantLock();
  private InfoWindow r;
  private Marker s;
  private Marker t;
  private MyLocationData u;
  private MyLocationConfiguration v;
  private boolean w;

  BaiduMap(e parame)
  {
    this.d = parame;
    this.c = new UiSettings(this.d);
    this.e = new LinkedList();
    this.f = new a(this);
    b localb = new b(this);
    this.d.a(localb);
    c localc = new c(this);
    this.d.a(localc);
  }

  private w a(MapStatusUpdate paramMapStatusUpdate)
  {
    w localw = this.d.m();
    return paramMapStatusUpdate.a(this.d, getMapStatus()).b(localw);
  }

  private final void a(MyLocationData paramMyLocationData, MyLocationConfiguration paramMyLocationConfiguration)
  {
    int i1 = 0;
    if ((paramMyLocationData == null) || (paramMyLocationConfiguration == null) || (!isMyLocationEnabled()))
      return;
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    JSONObject localJSONObject2 = new JSONObject();
    JSONObject localJSONObject3 = new JSONObject();
    LatLng localLatLng = new LatLng(paramMyLocationData.latitude, paramMyLocationData.longitude);
    com.baidu.platform.comapi.a.b localb = com.baidu.mapapi.model.a.a(localLatLng);
    try
    {
      localJSONObject1.put("type", 0);
      localJSONObject2.put("ptx", localb.b());
      localJSONObject2.put("pty", localb.a());
      localJSONObject2.put("radius", com.baidu.mapapi.model.a.a(localLatLng, (int)paramMyLocationData.accuracy));
      float f1;
      if (paramMyLocationConfiguration.enableDirection)
      {
        f1 = paramMyLocationData.direction % 360.0F;
        if (f1 > 180.0F)
          f1 -= 360.0F;
      }
      while (true)
      {
        localJSONObject2.put("direction", f1);
        localJSONObject2.put("iconarrownor", "NormalLocArrow");
        localJSONObject2.put("iconarrownorid", 28);
        localJSONObject2.put("iconarrowfoc", "FocusLocArrow");
        localJSONObject2.put("iconarrowfocid", 29);
        localJSONArray.put(localJSONObject2);
        localJSONObject1.put("data", localJSONArray);
        if (paramMyLocationConfiguration.locationMode == MyLocationConfiguration.LocationMode.COMPASS)
        {
          localJSONObject3.put("ptx", localb.b());
          localJSONObject3.put("pty", localb.a());
          localJSONObject3.put("radius", 0);
          localJSONObject3.put("direction", 0);
          localJSONObject3.put("iconarrownor", "direction_wheel");
          localJSONObject3.put("iconarrownorid", 54);
          localJSONObject3.put("iconarrowfoc", "direction_wheel");
          localJSONObject3.put("iconarrowfocid", 54);
          localJSONArray.put(localJSONObject3);
        }
        if (paramMyLocationConfiguration.customMarker != null)
          break;
        localObject = null;
        this.d.a(localJSONObject1.toString(), (Bundle)localObject);
        switch (1.a[paramMyLocationConfiguration.locationMode.ordinal()])
        {
        case 3:
        default:
          return;
        case 1:
          animateMapStatus(MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder().rotate(paramMyLocationData.direction).overlook(-45.0F).target(new LatLng(paramMyLocationData.latitude, paramMyLocationData.longitude)).targetScreen(getMapStatus().targetScreen).zoom(getMapStatus().zoom).build()));
          return;
          if (f1 < -180.0F)
          {
            f1 += 360.0F;
            continue;
            f1 = -1.0F;
          }
          break;
        case 2:
        }
      }
    }
    catch (JSONException localJSONException)
    {
      while (true)
      {
        localJSONException.printStackTrace();
        continue;
        ArrayList localArrayList1 = new ArrayList();
        localArrayList1.add(paramMyLocationConfiguration.customMarker);
        Bundle localBundle1 = new Bundle();
        ArrayList localArrayList2 = new ArrayList();
        Iterator localIterator = localArrayList1.iterator();
        while (localIterator.hasNext())
        {
          BitmapDescriptor localBitmapDescriptor = (BitmapDescriptor)localIterator.next();
          ParcelItem localParcelItem = new ParcelItem();
          Bundle localBundle2 = new Bundle();
          Bitmap localBitmap = localBitmapDescriptor.a;
          ByteBuffer localByteBuffer = ByteBuffer.allocate(4 * (localBitmap.getWidth() * localBitmap.getHeight()));
          localBitmap.copyPixelsToBuffer(localByteBuffer);
          localBundle2.putByteArray("imgdata", localByteBuffer.array());
          localBundle2.putInt("imgindex", localBitmapDescriptor.hashCode());
          localBundle2.putInt("imgH", localBitmap.getHeight());
          localBundle2.putInt("imgW", localBitmap.getWidth());
          localParcelItem.setBundle(localBundle2);
          localArrayList2.add(localParcelItem);
        }
        if (localArrayList2.size() > 0)
        {
          ParcelItem[] arrayOfParcelItem = new ParcelItem[localArrayList2.size()];
          while (i1 < localArrayList2.size())
          {
            arrayOfParcelItem[i1] = ((ParcelItem)localArrayList2.get(i1));
            i1++;
          }
          localBundle1.putParcelableArray("icondata", arrayOfParcelItem);
        }
        Object localObject = localBundle1;
      }
      animateMapStatus(MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder().target(new LatLng(paramMyLocationData.latitude, paramMyLocationData.longitude)).zoom(getMapStatus().zoom).rotate(getMapStatus().rotate).overlook(getMapStatus().overlook).targetScreen(getMapStatus().targetScreen).build()));
    }
  }

  void a()
  {
    this.d.g();
  }

  void a(HeatMap paramHeatMap)
  {
    this.q.lock();
    try
    {
      if ((this.p != null) && (paramHeatMap == this.p))
      {
        this.p.a();
        this.p.b();
        this.p.b = null;
        this.d.o();
        this.p = null;
        this.d.f(false);
      }
      return;
    }
    finally
    {
      this.q.unlock();
    }
  }

  public void addHeatMap(HeatMap paramHeatMap)
  {
    if (paramHeatMap == null)
      return;
    this.q.lock();
    try
    {
      HeatMap localHeatMap = this.p;
      if (paramHeatMap == localHeatMap)
        return;
      if (this.p != null)
      {
        this.p.a();
        this.p.b();
        this.p.b = null;
        this.d.o();
      }
      this.p = paramHeatMap;
      this.p.b = this;
      this.d.f(true);
      return;
    }
    finally
    {
      this.q.unlock();
    }
  }

  public final Overlay addOverlay(OverlayOptions paramOverlayOptions)
  {
    Overlay localOverlay = paramOverlayOptions.a();
    localOverlay.listener = this.f;
    Bundle localBundle = new Bundle();
    localOverlay.a(localBundle);
    this.d.a(localBundle);
    this.e.add(localOverlay);
    return localOverlay;
  }

  public final void animateMapStatus(MapStatusUpdate paramMapStatusUpdate)
  {
    animateMapStatus(paramMapStatusUpdate, 300);
  }

  public final void animateMapStatus(MapStatusUpdate paramMapStatusUpdate, int paramInt)
  {
    if ((paramMapStatusUpdate == null) || (paramInt <= 0))
      return;
    w localw = a(paramMapStatusUpdate);
    if (!this.w)
    {
      this.d.a(localw);
      return;
    }
    this.d.a(localw, paramInt);
  }

  public final void clear()
  {
    this.e.clear();
    this.d.n();
  }

  public final MyLocationConfiguration getLocationConfigeration()
  {
    return this.v;
  }

  public final MyLocationData getLocationData()
  {
    return this.u;
  }

  public final MapStatus getMapStatus()
  {
    return MapStatus.a(this.d.m());
  }

  public final int getMapType()
  {
    if (this.d.c())
      return 2;
    return 1;
  }

  public final float getMaxZoomLevel()
  {
    return this.d.a;
  }

  public final float getMinZoomLevel()
  {
    return this.d.b;
  }

  public final Projection getProjection()
  {
    return this.b;
  }

  public final UiSettings getUiSettings()
  {
    return this.c;
  }

  public void hideInfoWindow()
  {
    if (this.r != null)
    {
      this.r = null;
      this.s.remove();
      this.s = null;
    }
  }

  public final boolean isBuildingsEnabled()
  {
    return this.d.d();
  }

  public final boolean isMyLocationEnabled()
  {
    return this.d.f();
  }

  public final boolean isTrafficEnabled()
  {
    return this.d.b();
  }

  public final void setBuildingsEnabled(boolean paramBoolean)
  {
    this.d.c(paramBoolean);
  }

  public final void setMapStatus(MapStatusUpdate paramMapStatusUpdate)
  {
    if (paramMapStatusUpdate == null);
    do
    {
      return;
      w localw = a(paramMapStatusUpdate);
      this.d.a(localw);
    }
    while (this.g == null);
    this.g.onMapStatusChange(getMapStatus());
  }

  public final void setMapType(int paramInt)
  {
    if (paramInt == 1)
      this.d.b(false);
    while (paramInt != 2)
      return;
    this.d.b(true);
  }

  public final void setMaxAndMinZoomLevel(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 > 19.0F);
    while ((paramFloat2 < 3.0F) || (paramFloat1 < paramFloat2))
      return;
    this.d.a = paramFloat1;
    this.d.b = paramFloat2;
  }

  public final void setMyLocationConfigeration(MyLocationConfiguration paramMyLocationConfiguration)
  {
    this.v = paramMyLocationConfiguration;
    a(this.u, this.v);
  }

  public final void setMyLocationData(MyLocationData paramMyLocationData)
  {
    this.u = paramMyLocationData;
    if (this.v == null)
      this.v = new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, false, null);
    a(paramMyLocationData, this.v);
  }

  public final void setMyLocationEnabled(boolean paramBoolean)
  {
    this.d.e(paramBoolean);
  }

  public final void setOnMapClickListener(OnMapClickListener paramOnMapClickListener)
  {
    this.h = paramOnMapClickListener;
  }

  public final void setOnMapDoubleClickListener(OnMapDoubleClickListener paramOnMapDoubleClickListener)
  {
    this.j = paramOnMapDoubleClickListener;
  }

  public void setOnMapLoadedCallback(OnMapLoadedCallback paramOnMapLoadedCallback)
  {
    this.i = paramOnMapLoadedCallback;
  }

  public final void setOnMapLongClickListener(OnMapLongClickListener paramOnMapLongClickListener)
  {
    this.k = paramOnMapLongClickListener;
  }

  public final void setOnMapStatusChangeListener(OnMapStatusChangeListener paramOnMapStatusChangeListener)
  {
    this.g = paramOnMapStatusChangeListener;
  }

  public final void setOnMarkerClickListener(OnMarkerClickListener paramOnMarkerClickListener)
  {
    this.l = paramOnMarkerClickListener;
  }

  public final void setOnMarkerDragListener(OnMarkerDragListener paramOnMarkerDragListener)
  {
    this.m = paramOnMarkerDragListener;
  }

  public final void setOnMyLocationClickListener(OnMyLocationClickListener paramOnMyLocationClickListener)
  {
    this.n = paramOnMyLocationClickListener;
  }

  public final void setTrafficEnabled(boolean paramBoolean)
  {
    this.d.a(paramBoolean);
  }

  public void showInfoWindow(InfoWindow paramInfoWindow)
  {
    if (paramInfoWindow != null)
    {
      hideInfoWindow();
      this.r = paramInfoWindow;
      if (paramInfoWindow.b == null)
        break label68;
    }
    label68: for (BitmapDescriptor localBitmapDescriptor = BitmapDescriptorFactory.fromView(paramInfoWindow.b); ; localBitmapDescriptor = paramInfoWindow.a)
    {
      this.s = ((Marker)addOverlay(new MarkerOptions().perspective(false).icon(localBitmapDescriptor).position(paramInfoWindow.c).zIndex(2147483647)));
      return;
    }
  }

  public final void snapshot(SnapshotReadyCallback paramSnapshotReadyCallback)
  {
    this.o = paramSnapshotReadyCallback;
    this.d.a("anything");
  }

  public static abstract interface OnMapClickListener
  {
    public abstract void onMapClick(LatLng paramLatLng);

    public abstract boolean onMapPoiClick(MapPoi paramMapPoi);
  }

  public static abstract interface OnMapDoubleClickListener
  {
    public abstract void onMapDoubleClick(LatLng paramLatLng);
  }

  public static abstract interface OnMapLoadedCallback
  {
    public abstract void onMapLoaded();
  }

  public static abstract interface OnMapLongClickListener
  {
    public abstract void onMapLongClick(LatLng paramLatLng);
  }

  public static abstract interface OnMapStatusChangeListener
  {
    public abstract void onMapStatusChange(MapStatus paramMapStatus);

    public abstract void onMapStatusChangeFinish(MapStatus paramMapStatus);

    public abstract void onMapStatusChangeStart(MapStatus paramMapStatus);
  }

  public static abstract interface OnMarkerClickListener
  {
    public abstract boolean onMarkerClick(Marker paramMarker);
  }

  public static abstract interface OnMarkerDragListener
  {
    public abstract void onMarkerDrag(Marker paramMarker);

    public abstract void onMarkerDragEnd(Marker paramMarker);

    public abstract void onMarkerDragStart(Marker paramMarker);
  }

  public static abstract interface OnMyLocationClickListener
  {
    public abstract boolean onMyLocationClick();
  }

  public static abstract interface SnapshotReadyCallback
  {
    public abstract void onSnapshotReady(Bitmap paramBitmap);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.map.BaiduMap
 * JD-Core Version:    0.6.2
 */