package com.ubercab.library.vendor.baidu.map;

import android.content.Context;
import android.os.Bundle;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.MapView;
import com.ubercab.library.map.internal.IUberMap;
import com.ubercab.library.map.internal.IUberMapView;

public class BaiduMapViewAdapter
  implements IUberMapView
{
  private final MapView mMapView;

  public BaiduMapViewAdapter(Context paramContext, BaiduMapOptionsAdapter paramBaiduMapOptionsAdapter)
  {
    SDKInitializer.initialize(paramContext.getApplicationContext());
    this.mMapView = new MapView(paramContext, paramBaiduMapOptionsAdapter.getBaiduMapOptions());
  }

  public IUberMap getMap()
  {
    if (this.mMapView.getMap() == null)
      return null;
    return new BaiduMapAdapter(this.mMapView.getMap());
  }

  public MapView getMapView()
  {
    return this.mMapView;
  }

  public void onCreate(Bundle paramBundle)
  {
  }

  public void onDestroy()
  {
    this.mMapView.onDestroy();
  }

  public void onLowMemory()
  {
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
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.vendor.baidu.map.BaiduMapViewAdapter
 * JD-Core Version:    0.6.2
 */