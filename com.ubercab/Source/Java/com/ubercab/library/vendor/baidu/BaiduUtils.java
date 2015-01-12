package com.ubercab.library.vendor.baidu;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.LatLngBounds.Builder;
import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.location.model.UberLatLngBounds;

public final class BaiduUtils
{
  private static final String BAIDU_SERVICE_NAME = "com.baidu.location.f";

  public static LatLng convertLatLng(UberLatLng paramUberLatLng)
  {
    UberLatLng localUberLatLng = paramUberLatLng.convertToBD09();
    return new LatLng(localUberLatLng.getLatitude(), localUberLatLng.getLongitude());
  }

  public static UberLatLng convertLatLng(LatLng paramLatLng)
  {
    return new UberLatLng(paramLatLng.latitude, paramLatLng.longitude, 2).convertToWGS84();
  }

  public static LatLngBounds convertLatLngBounds(UberLatLngBounds paramUberLatLngBounds)
  {
    LatLng localLatLng1 = convertLatLng(paramUberLatLngBounds.getSouthwest());
    LatLng localLatLng2 = convertLatLng(paramUberLatLngBounds.getNortheast());
    return new LatLngBounds.Builder().include(localLatLng1).include(localLatLng2).build();
  }

  public static void setBaiduServiceEnabled(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = 1; ; i = 2)
    {
      paramContext.getPackageManager().setComponentEnabledSetting(new ComponentName(paramContext.getPackageName(), "com.baidu.location.f"), i, 1);
      return;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.vendor.baidu.BaiduUtils
 * JD-Core Version:    0.6.2
 */