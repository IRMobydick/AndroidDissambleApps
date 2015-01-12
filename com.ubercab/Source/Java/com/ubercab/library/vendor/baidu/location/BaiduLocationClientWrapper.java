package com.ubercab.library.vendor.baidu.location;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;

class BaiduLocationClientWrapper
{
  private final LocationClient mLocationClient;

  BaiduLocationClientWrapper(LocationClient paramLocationClient)
  {
    this.mLocationClient = paramLocationClient;
  }

  BDLocation getLastKnownLocation()
  {
    return this.mLocationClient.getLastKnownLocation();
  }

  String getVersion()
  {
    return this.mLocationClient.getVersion();
  }

  boolean isStarted()
  {
    return this.mLocationClient.isStarted();
  }

  void registerLocationListener(BDLocationListener paramBDLocationListener)
  {
    this.mLocationClient.registerLocationListener(paramBDLocationListener);
  }

  void setLocOption(LocationClientOption paramLocationClientOption)
  {
    this.mLocationClient.setLocOption(paramLocationClientOption);
  }

  void start()
  {
    this.mLocationClient.start();
  }

  void stop()
  {
    this.mLocationClient.stop();
  }

  void unRegisterLocationListener(BDLocationListener paramBDLocationListener)
  {
    this.mLocationClient.unRegisterLocationListener(paramBDLocationListener);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.vendor.baidu.location.BaiduLocationClientWrapper
 * JD-Core Version:    0.6.2
 */