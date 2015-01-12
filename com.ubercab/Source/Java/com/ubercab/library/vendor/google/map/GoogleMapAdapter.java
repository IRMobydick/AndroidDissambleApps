package com.ubercab.library.vendor.google.map;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.CancelableCallback;
import com.google.android.gms.maps.GoogleMap.OnCameraChangeListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.GoogleMap.OnMyLocationButtonClickListener;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Marker;
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
import com.ubercab.library.vendor.google.map.model.GoogleCameraPositionAdapter;
import com.ubercab.library.vendor.google.map.model.GoogleCameraUpdateAdapter;
import com.ubercab.library.vendor.google.map.model.GoogleMapUiSettingsAdapter;
import com.ubercab.library.vendor.google.map.model.GoogleMarkerAdapter;
import com.ubercab.library.vendor.google.map.model.GoogleMarkerOptionsAdapter;
import com.ubercab.library.vendor.google.map.model.GooglePolygonAdapter;
import com.ubercab.library.vendor.google.map.model.GooglePolygonOptionsAdapter;
import com.ubercab.library.vendor.google.map.model.GooglePolylineAdapter;
import com.ubercab.library.vendor.google.map.model.GooglePolylineOptionsAdapter;
import com.ubercab.library.vendor.google.map.model.GoogleProjectionAdapter;

public class GoogleMapAdapter extends IUberMap
{
  private final GoogleMap mGoogleMap;
  private final GoogleMapListener mGoogleMapListener;

  public GoogleMapAdapter(GoogleMap paramGoogleMap)
  {
    this.mGoogleMap = paramGoogleMap;
    this.mGoogleMapListener = new GoogleMapListener(null);
  }

  public IUberMarker addMarker(IUberMarkerOptions paramIUberMarkerOptions)
  {
    return new GoogleMarkerAdapter(this.mGoogleMap.addMarker(((GoogleMarkerOptionsAdapter)paramIUberMarkerOptions).getMarkerOptions()));
  }

  public IUberPolygon addPolygon(IUberPolygonOptions paramIUberPolygonOptions)
  {
    return new GooglePolygonAdapter(this.mGoogleMap.addPolygon(((GooglePolygonOptionsAdapter)paramIUberPolygonOptions).getPolygonOptions()));
  }

  public IUberPolyline addPolyline(IUberPolylineOptions paramIUberPolylineOptions)
  {
    return new GooglePolylineAdapter(this.mGoogleMap.addPolyline(((GooglePolylineOptionsAdapter)paramIUberPolylineOptions).getPolylineOptions()));
  }

  public void animateCamera(IUberCameraUpdate paramIUberCameraUpdate)
  {
    this.mGoogleMap.animateCamera(((GoogleCameraUpdateAdapter)paramIUberCameraUpdate).getCameraUpdate());
  }

  public void animateCamera(IUberCameraUpdate paramIUberCameraUpdate, int paramInt, UberMap.CancelableCallback paramCancelableCallback)
  {
    super.animateCamera(paramIUberCameraUpdate, paramInt, paramCancelableCallback);
    this.mGoogleMap.animateCamera(((GoogleCameraUpdateAdapter)paramIUberCameraUpdate).getCameraUpdate(), paramInt, this.mGoogleMapListener);
  }

  public IUberCameraPosition getCameraPosition()
  {
    return new GoogleCameraPositionAdapter(this.mGoogleMap.getCameraPosition());
  }

  public IUberProjection getProjection()
  {
    return new GoogleProjectionAdapter(this.mGoogleMap.getProjection());
  }

  public IUberMapUiSettings getUiSettings()
  {
    return new GoogleMapUiSettingsAdapter(this.mGoogleMap.getUiSettings());
  }

  public void moveCamera(IUberCameraUpdate paramIUberCameraUpdate)
  {
    this.mGoogleMap.moveCamera(((GoogleCameraUpdateAdapter)paramIUberCameraUpdate).getCameraUpdate());
  }

  public void setBuildingsEnabled(boolean paramBoolean)
  {
    this.mGoogleMap.setBuildingsEnabled(paramBoolean);
  }

  public boolean setIndoorEnabled(boolean paramBoolean)
  {
    return this.mGoogleMap.setIndoorEnabled(paramBoolean);
  }

  public void setMapType(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return;
    case 0:
    }
    this.mGoogleMap.setMapType(1);
  }

  public void setMyLocationEnabled(boolean paramBoolean)
  {
    this.mGoogleMap.setMyLocationEnabled(paramBoolean);
  }

  public void setOnCameraChangeListener(UberMap.OnCameraChangeListener paramOnCameraChangeListener)
  {
    super.setOnCameraChangeListener(paramOnCameraChangeListener);
    this.mGoogleMap.setOnCameraChangeListener(this.mGoogleMapListener);
  }

  public void setOnMarkerClickListener(UberMap.OnMarkerClickListener paramOnMarkerClickListener)
  {
    super.setOnMarkerClickListener(paramOnMarkerClickListener);
    this.mGoogleMap.setOnMarkerClickListener(this.mGoogleMapListener);
  }

  public void setOnMyLocationButtonClickListener(UberMap.OnMyLocationButtonClickListener paramOnMyLocationButtonClickListener)
  {
    super.setOnMyLocationButtonClickListener(paramOnMyLocationButtonClickListener);
    this.mGoogleMap.setOnMyLocationButtonClickListener(this.mGoogleMapListener);
  }

  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mGoogleMap.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public void setTrafficEnabled(boolean paramBoolean)
  {
    this.mGoogleMap.setTrafficEnabled(paramBoolean);
  }

  public boolean supportsPadding()
  {
    return true;
  }

  private class GoogleMapListener
    implements GoogleMap.CancelableCallback, GoogleMap.OnCameraChangeListener, GoogleMap.OnMarkerClickListener, GoogleMap.OnMyLocationButtonClickListener
  {
    private GoogleMapListener()
    {
    }

    public void onCameraChange(CameraPosition paramCameraPosition)
    {
      if (GoogleMapAdapter.this.mOnCameraChangeListener != null)
      {
        GoogleCameraPositionAdapter localGoogleCameraPositionAdapter = new GoogleCameraPositionAdapter(paramCameraPosition);
        UberCameraPosition localUberCameraPosition = new UberCameraPosition.Builder().bearing(localGoogleCameraPositionAdapter.getBearing()).target(localGoogleCameraPositionAdapter.getTarget()).tilt(localGoogleCameraPositionAdapter.getTilt()).zoom(localGoogleCameraPositionAdapter.getZoom()).build();
        GoogleMapAdapter.this.mOnCameraChangeListener.onCameraChange(localUberCameraPosition);
      }
    }

    public void onCancel()
    {
      if (GoogleMapAdapter.this.mCancelableCallback != null)
        GoogleMapAdapter.this.mCancelableCallback.onCancel();
    }

    public void onFinish()
    {
      if (GoogleMapAdapter.this.mCancelableCallback != null)
        GoogleMapAdapter.this.mCancelableCallback.onFinish();
    }

    public boolean onMarkerClick(Marker paramMarker)
    {
      if (GoogleMapAdapter.this.mOnMarkerClickListener != null)
        return GoogleMapAdapter.this.mOnMarkerClickListener.onMarkerClick(new UberMarker(new GoogleMarkerAdapter(paramMarker)));
      return false;
    }

    public boolean onMyLocationButtonClick()
    {
      if (GoogleMapAdapter.this.mOnMyLocationButtonClickListener != null)
        return GoogleMapAdapter.this.mOnMyLocationButtonClickListener.onMyLocationButtonClick();
      return false;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.vendor.google.map.GoogleMapAdapter
 * JD-Core Version:    0.6.2
 */