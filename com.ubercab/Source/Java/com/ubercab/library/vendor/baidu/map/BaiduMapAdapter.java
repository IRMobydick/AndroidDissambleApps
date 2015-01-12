package com.ubercab.library.vendor.baidu.map;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener;
import com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener;
import com.baidu.mapapi.map.BaiduMap.OnMyLocationClickListener;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.Polygon;
import com.baidu.mapapi.map.Polyline;
import com.ubercab.library.map.UberCameraPosition;
import com.ubercab.library.map.UberCameraPosition.Builder;
import com.ubercab.library.map.UberMap.CancelableCallback;
import com.ubercab.library.map.UberMap.OnCameraChangeListener;
import com.ubercab.library.map.UberMap.OnMarkerClickListener;
import com.ubercab.library.map.UberMap.OnMyLocationButtonClickListener;
import com.ubercab.library.map.UberMarker;
import com.ubercab.library.map.internal.IUberMap;
import com.ubercab.library.map.internal.model.IUberCameraPosition;
import com.ubercab.library.map.internal.model.IUberCameraUpdate;
import com.ubercab.library.map.internal.model.IUberMapUiSettings;
import com.ubercab.library.map.internal.model.IUberMarker;
import com.ubercab.library.map.internal.model.IUberMarkerOptions;
import com.ubercab.library.map.internal.model.IUberPolygon;
import com.ubercab.library.map.internal.model.IUberPolygonOptions;
import com.ubercab.library.map.internal.model.IUberPolyline;
import com.ubercab.library.map.internal.model.IUberPolylineOptions;
import com.ubercab.library.map.internal.model.IUberProjection;
import com.ubercab.library.vendor.baidu.map.model.BaiduCameraPositionAdapter;
import com.ubercab.library.vendor.baidu.map.model.BaiduCameraUpdateAdapter;
import com.ubercab.library.vendor.baidu.map.model.BaiduMapUiSettingsAdapter;
import com.ubercab.library.vendor.baidu.map.model.BaiduMarkerAdapter;
import com.ubercab.library.vendor.baidu.map.model.BaiduMarkerOptionsAdapter;
import com.ubercab.library.vendor.baidu.map.model.BaiduPolygonAdapter;
import com.ubercab.library.vendor.baidu.map.model.BaiduPolygonOptionsAdapter;
import com.ubercab.library.vendor.baidu.map.model.BaiduPolylineAdapter;
import com.ubercab.library.vendor.baidu.map.model.BaiduPolylineOptionsAdapter;
import com.ubercab.library.vendor.baidu.map.model.BaiduProjectionAdapter;

public class BaiduMapAdapter extends IUberMap
{
  private final BaiduMap mBaiduMap;
  private final BaiduMapListener mBaiduMapListener;

  public BaiduMapAdapter(BaiduMap paramBaiduMap)
  {
    this.mBaiduMap = paramBaiduMap;
    this.mBaiduMapListener = new BaiduMapListener(null);
  }

  public IUberMarker addMarker(IUberMarkerOptions paramIUberMarkerOptions)
  {
    return new BaiduMarkerAdapter((Marker)this.mBaiduMap.addOverlay(((BaiduMarkerOptionsAdapter)paramIUberMarkerOptions).getMarkerOptions()));
  }

  public IUberPolygon addPolygon(IUberPolygonOptions paramIUberPolygonOptions)
  {
    return new BaiduPolygonAdapter((Polygon)this.mBaiduMap.addOverlay(((BaiduPolygonOptionsAdapter)paramIUberPolygonOptions).getPolygonOptions()));
  }

  public IUberPolyline addPolyline(IUberPolylineOptions paramIUberPolylineOptions)
  {
    return new BaiduPolylineAdapter((Polyline)this.mBaiduMap.addOverlay(((BaiduPolylineOptionsAdapter)paramIUberPolylineOptions).getPolylineOptions()));
  }

  public void animateCamera(IUberCameraUpdate paramIUberCameraUpdate)
  {
    this.mBaiduMap.animateMapStatus(((BaiduCameraUpdateAdapter)paramIUberCameraUpdate).getMapStatusUpdate());
  }

  public void animateCamera(IUberCameraUpdate paramIUberCameraUpdate, int paramInt, UberMap.CancelableCallback paramCancelableCallback)
  {
    super.animateCamera(paramIUberCameraUpdate, paramInt, paramCancelableCallback);
    this.mBaiduMap.animateMapStatus(((BaiduCameraUpdateAdapter)paramIUberCameraUpdate).getMapStatusUpdate(), paramInt);
  }

  public IUberCameraPosition getCameraPosition()
  {
    return new BaiduCameraPositionAdapter(this.mBaiduMap.getMapStatus());
  }

  public IUberProjection getProjection()
  {
    return new BaiduProjectionAdapter(this.mBaiduMap.getProjection());
  }

  public IUberMapUiSettings getUiSettings()
  {
    return new BaiduMapUiSettingsAdapter(this.mBaiduMap.getUiSettings());
  }

  public void moveCamera(IUberCameraUpdate paramIUberCameraUpdate)
  {
    this.mBaiduMap.setMapStatus(((BaiduCameraUpdateAdapter)paramIUberCameraUpdate).getMapStatusUpdate());
  }

  public void setBuildingsEnabled(boolean paramBoolean)
  {
    this.mBaiduMap.setBuildingsEnabled(paramBoolean);
  }

  public boolean setIndoorEnabled(boolean paramBoolean)
  {
    return false;
  }

  public void setMapType(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return;
    case 0:
    }
    this.mBaiduMap.setMapType(1);
  }

  public void setMyLocationEnabled(boolean paramBoolean)
  {
    this.mBaiduMap.setMyLocationEnabled(paramBoolean);
  }

  public void setOnCameraChangeListener(UberMap.OnCameraChangeListener paramOnCameraChangeListener)
  {
    super.setOnCameraChangeListener(paramOnCameraChangeListener);
    this.mBaiduMap.setOnMapStatusChangeListener(this.mBaiduMapListener);
  }

  public void setOnMarkerClickListener(UberMap.OnMarkerClickListener paramOnMarkerClickListener)
  {
    super.setOnMarkerClickListener(paramOnMarkerClickListener);
    this.mBaiduMap.setOnMarkerClickListener(this.mBaiduMapListener);
  }

  public void setOnMyLocationButtonClickListener(UberMap.OnMyLocationButtonClickListener paramOnMyLocationButtonClickListener)
  {
    super.setOnMyLocationButtonClickListener(paramOnMyLocationButtonClickListener);
    this.mBaiduMap.setOnMyLocationClickListener(this.mBaiduMapListener);
  }

  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
  }

  public void setTrafficEnabled(boolean paramBoolean)
  {
    this.mBaiduMap.setTrafficEnabled(paramBoolean);
  }

  public boolean supportsPadding()
  {
    return false;
  }

  private class BaiduMapListener
    implements BaiduMap.OnMapStatusChangeListener, BaiduMap.OnMarkerClickListener, BaiduMap.OnMyLocationClickListener
  {
    private BaiduMapListener()
    {
    }

    public void onMapStatusChange(MapStatus paramMapStatus)
    {
    }

    public void onMapStatusChangeFinish(MapStatus paramMapStatus)
    {
      if (BaiduMapAdapter.this.mOnCameraChangeListener != null)
      {
        BaiduCameraPositionAdapter localBaiduCameraPositionAdapter = new BaiduCameraPositionAdapter(paramMapStatus);
        UberCameraPosition localUberCameraPosition = new UberCameraPosition.Builder().bearing(localBaiduCameraPositionAdapter.getBearing()).target(localBaiduCameraPositionAdapter.getTarget()).tilt(localBaiduCameraPositionAdapter.getTilt()).zoom(localBaiduCameraPositionAdapter.getZoom()).build();
        BaiduMapAdapter.this.mOnCameraChangeListener.onCameraChange(localUberCameraPosition);
      }
    }

    public void onMapStatusChangeStart(MapStatus paramMapStatus)
    {
    }

    public boolean onMarkerClick(Marker paramMarker)
    {
      if ((paramMarker != null) && (BaiduMapAdapter.this.mOnMarkerClickListener != null))
        return BaiduMapAdapter.this.mOnMarkerClickListener.onMarkerClick(new UberMarker(new BaiduMarkerAdapter(paramMarker)));
      return false;
    }

    public boolean onMyLocationClick()
    {
      if (BaiduMapAdapter.this.mOnMyLocationButtonClickListener != null)
        return BaiduMapAdapter.this.mOnMyLocationButtonClickListener.onMyLocationButtonClick();
      return false;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.vendor.baidu.map.BaiduMapAdapter
 * JD-Core Version:    0.6.2
 */