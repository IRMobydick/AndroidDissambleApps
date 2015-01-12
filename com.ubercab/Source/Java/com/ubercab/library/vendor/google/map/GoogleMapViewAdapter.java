package com.ubercab.library.vendor.google.map;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.ubercab.library.map.internal.IUberMap;
import com.ubercab.library.map.internal.IUberMapView;

public class GoogleMapViewAdapter
  implements IUberMapView
{
  private final Context mContext;
  private final MapView mMapView;

  public GoogleMapViewAdapter(Context paramContext, GoogleMapOptionsAdapter paramGoogleMapOptionsAdapter)
  {
    this.mContext = paramContext;
    this.mMapView = new MapView(paramContext, paramGoogleMapOptionsAdapter.getGoogleMapOptions());
  }

  public IUberMap getMap()
  {
    if (this.mMapView.getMap() == null)
      return null;
    MapsInitializer.initialize(this.mContext);
    return new GoogleMapAdapter(this.mMapView.getMap());
  }

  public MapView getMapView()
  {
    return this.mMapView;
  }

  public void onCreate(Bundle paramBundle)
  {
    this.mMapView.onCreate(paramBundle);
  }

  public void onDestroy()
  {
    this.mMapView.onDestroy();
  }

  public void onLowMemory()
  {
    this.mMapView.onLowMemory();
  }

  public void onPause()
  {
    this.mMapView.onPause();
  }

  public void onResume()
  {
    this.mMapView.onResume();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    this.mMapView.onSaveInstanceState(paramBundle);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.vendor.google.map.GoogleMapViewAdapter
 * JD-Core Version:    0.6.2
 */