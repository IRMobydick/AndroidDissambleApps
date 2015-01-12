package com.baidu.platform.comjni.map.search;

import android.os.Bundle;

public class JNISearch
{
  public native boolean AreaSearch(int paramInt, Bundle paramBundle);

  public native boolean BusLineDetailSearch(int paramInt, String paramString1, String paramString2);

  public native int Create();

  public native boolean ForceSearchByCityName(int paramInt, Bundle paramBundle);

  public native String GetSearchResult(int paramInt1, int paramInt2);

  public native boolean MapBoundSearch(int paramInt, Bundle paramBundle);

  public native boolean POIDetailSearchPlace(int paramInt, String paramString);

  public native boolean PoiDetailShareUrlSearch(int paramInt, String paramString);

  public native boolean PoiRGCShareUrlSearch(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2);

  public native int Release(int paramInt);

  public native boolean ReverseGeocodeSearch(int paramInt1, int paramInt2, int paramInt3);

  public native boolean RoutePlanByBus(int paramInt, Bundle paramBundle);

  public native boolean RoutePlanByCar(int paramInt, Bundle paramBundle);

  public native boolean RoutePlanByFoot(int paramInt, Bundle paramBundle);

  public native boolean SuggestionSearch(int paramInt, Bundle paramBundle);

  public native boolean geocode(int paramInt, String paramString1, String paramString2);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.platform.comjni.map.search.JNISearch
 * JD-Core Version:    0.6.2
 */