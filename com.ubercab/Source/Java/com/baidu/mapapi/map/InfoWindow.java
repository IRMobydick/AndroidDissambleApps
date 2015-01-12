package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapapi.model.LatLng;

public class InfoWindow
{
  BitmapDescriptor a;
  View b;
  LatLng c;
  OnInfoWindowClickListener d;

  public InfoWindow(View paramView, LatLng paramLatLng, OnInfoWindowClickListener paramOnInfoWindowClickListener)
  {
    if ((paramView == null) || (paramLatLng == null))
      throw new IllegalArgumentException("view and position can not be null");
    this.b = paramView;
    this.c = paramLatLng;
    this.d = paramOnInfoWindowClickListener;
  }

  public InfoWindow(BitmapDescriptor paramBitmapDescriptor, LatLng paramLatLng, OnInfoWindowClickListener paramOnInfoWindowClickListener)
  {
    if ((paramBitmapDescriptor == null) || (paramLatLng == null))
      throw new IllegalArgumentException("bitmapDescriptor and position can not be null");
    this.a = paramBitmapDescriptor;
    this.c = paramLatLng;
    this.d = paramOnInfoWindowClickListener;
  }

  public static abstract interface OnInfoWindowClickListener
  {
    public abstract void onInfoWindowClick();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.map.InfoWindow
 * JD-Core Version:    0.6.2
 */