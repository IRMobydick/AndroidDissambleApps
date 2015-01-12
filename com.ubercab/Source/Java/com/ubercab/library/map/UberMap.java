package com.ubercab.library.map;

import com.ubercab.library.map.internal.IUberMap;
import com.ubercab.library.map.internal.model.IUberCameraPosition;

public class UberMap
{
  public static final int MAP_TYPE_NORMAL;
  private final IUberMap mUberMap;

  public UberMap(IUberMap paramIUberMap)
  {
    this.mUberMap = paramIUberMap;
  }

  public UberMarker addMarker(UberMarkerOptions paramUberMarkerOptions)
  {
    return new UberMarker(this.mUberMap.addMarker(paramUberMarkerOptions.getMarkerOptions()));
  }

  public UberPolygon addPolygon(UberPolygonOptions paramUberPolygonOptions)
  {
    return new UberPolygon(this.mUberMap.addPolygon(paramUberPolygonOptions.getPolygonOptions()));
  }

  public UberPolyline addPolyline(UberPolylineOptions paramUberPolylineOptions)
  {
    return new UberPolyline(this.mUberMap.addPolyline(paramUberPolylineOptions.getPolylineOptions()));
  }

  public void animateCamera(UberCameraUpdate paramUberCameraUpdate)
  {
    this.mUberMap.animateCamera(paramUberCameraUpdate.getCameraUpdate());
  }

  public void animateCamera(UberCameraUpdate paramUberCameraUpdate, int paramInt, CancelableCallback paramCancelableCallback)
  {
    this.mUberMap.animateCamera(paramUberCameraUpdate.getCameraUpdate(), paramInt, paramCancelableCallback);
  }

  public UberCameraPosition getCameraPosition()
  {
    IUberCameraPosition localIUberCameraPosition = this.mUberMap.getCameraPosition();
    return new UberCameraPosition(localIUberCameraPosition.getBearing(), localIUberCameraPosition.getTarget(), localIUberCameraPosition.getTilt(), localIUberCameraPosition.getZoom());
  }

  public UberProjection getProjection()
  {
    return new UberProjection(this.mUberMap.getProjection());
  }

  public UberMapUiSettings getUiSettings()
  {
    return new UberMapUiSettings(this.mUberMap.getUiSettings());
  }

  public void moveCamera(UberCameraUpdate paramUberCameraUpdate)
  {
    this.mUberMap.moveCamera(paramUberCameraUpdate.getCameraUpdate());
  }

  public void setBuildingsEnabled(boolean paramBoolean)
  {
    this.mUberMap.setBuildingsEnabled(paramBoolean);
  }

  public boolean setIndoorEnabled(boolean paramBoolean)
  {
    return this.mUberMap.setIndoorEnabled(paramBoolean);
  }

  public void setMapType(int paramInt)
  {
    this.mUberMap.setMapType(paramInt);
  }

  public void setMyLocationEnabled(boolean paramBoolean)
  {
    this.mUberMap.setMyLocationEnabled(paramBoolean);
  }

  public void setOnCameraChangeListener(OnCameraChangeListener paramOnCameraChangeListener)
  {
    this.mUberMap.setOnCameraChangeListener(paramOnCameraChangeListener);
  }

  public void setOnMarkerClickListener(OnMarkerClickListener paramOnMarkerClickListener)
  {
    this.mUberMap.setOnMarkerClickListener(paramOnMarkerClickListener);
  }

  public void setOnMyLocationButtonClickListener(OnMyLocationButtonClickListener paramOnMyLocationButtonClickListener)
  {
    this.mUberMap.setOnMyLocationButtonClickListener(paramOnMyLocationButtonClickListener);
  }

  void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mUberMap.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public void setTrafficEnabled(boolean paramBoolean)
  {
    this.mUberMap.setTrafficEnabled(paramBoolean);
  }

  boolean supportsPadding()
  {
    return this.mUberMap.supportsPadding();
  }

  public static abstract interface CancelableCallback
  {
    public abstract void onCancel();

    public abstract void onFinish();
  }

  public static abstract interface OnCameraChangeListener
  {
    public abstract void onCameraChange(UberCameraPosition paramUberCameraPosition);
  }

  public static abstract interface OnMarkerClickListener
  {
    public abstract boolean onMarkerClick(UberMarker paramUberMarker);
  }

  public static abstract interface OnMyLocationButtonClickListener
  {
    public abstract boolean onMyLocationButtonClick();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.map.UberMap
 * JD-Core Version:    0.6.2
 */