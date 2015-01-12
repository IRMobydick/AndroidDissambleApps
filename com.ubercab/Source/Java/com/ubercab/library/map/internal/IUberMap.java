package com.ubercab.library.map.internal;

import com.ubercab.library.map.UberMap.CancelableCallback;
import com.ubercab.library.map.UberMap.OnCameraChangeListener;
import com.ubercab.library.map.UberMap.OnMarkerClickListener;
import com.ubercab.library.map.UberMap.OnMyLocationButtonClickListener;
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

public abstract class IUberMap
{
  protected UberMap.CancelableCallback mCancelableCallback;
  protected UberMap.OnCameraChangeListener mOnCameraChangeListener;
  protected UberMap.OnMarkerClickListener mOnMarkerClickListener;
  protected UberMap.OnMyLocationButtonClickListener mOnMyLocationButtonClickListener;

  public abstract IUberMarker addMarker(IUberMarkerOptions paramIUberMarkerOptions);

  public abstract IUberPolygon addPolygon(IUberPolygonOptions paramIUberPolygonOptions);

  public abstract IUberPolyline addPolyline(IUberPolylineOptions paramIUberPolylineOptions);

  public abstract void animateCamera(IUberCameraUpdate paramIUberCameraUpdate);

  public void animateCamera(IUberCameraUpdate paramIUberCameraUpdate, int paramInt, UberMap.CancelableCallback paramCancelableCallback)
  {
    this.mCancelableCallback = paramCancelableCallback;
  }

  public abstract IUberCameraPosition getCameraPosition();

  public abstract IUberProjection getProjection();

  public abstract IUberMapUiSettings getUiSettings();

  public abstract void moveCamera(IUberCameraUpdate paramIUberCameraUpdate);

  public abstract void setBuildingsEnabled(boolean paramBoolean);

  public abstract boolean setIndoorEnabled(boolean paramBoolean);

  public abstract void setMapType(int paramInt);

  public abstract void setMyLocationEnabled(boolean paramBoolean);

  public void setOnCameraChangeListener(UberMap.OnCameraChangeListener paramOnCameraChangeListener)
  {
    this.mOnCameraChangeListener = paramOnCameraChangeListener;
  }

  public void setOnMarkerClickListener(UberMap.OnMarkerClickListener paramOnMarkerClickListener)
  {
    this.mOnMarkerClickListener = paramOnMarkerClickListener;
  }

  public void setOnMyLocationButtonClickListener(UberMap.OnMyLocationButtonClickListener paramOnMyLocationButtonClickListener)
  {
    this.mOnMyLocationButtonClickListener = paramOnMyLocationButtonClickListener;
  }

  public abstract void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4);

  public abstract void setTrafficEnabled(boolean paramBoolean);

  public abstract boolean supportsPadding();
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.map.internal.IUberMap
 * JD-Core Version:    0.6.2
 */