package com.baidu.mapapi.search.route;

public abstract interface OnGetRoutePlanResultListener
{
  public abstract void onGetDrivingRouteResult(DrivingRouteResult paramDrivingRouteResult);

  public abstract void onGetTransitRouteResult(TransitRouteResult paramTransitRouteResult);

  public abstract void onGetWalkingRouteResult(WalkingRouteResult paramWalkingRouteResult);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
 * JD-Core Version:    0.6.2
 */