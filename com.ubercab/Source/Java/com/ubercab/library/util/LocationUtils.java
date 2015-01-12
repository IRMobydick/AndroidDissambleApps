package com.ubercab.library.util;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.location.model.UberLatLngBounds;
import com.ubercab.library.location.model.UberLocation;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class LocationUtils
{
  private static final UberLatLngBounds BEIJING_BOUNDS = new UberLatLngBounds(new UberLatLng(35.229999999999997D, 112.92D), new UberLatLng(42.359999999999999D, 122.98999999999999D));
  private static final UberLatLngBounds CHENGDU_BOUNDS;
  private static final UberLatLngBounds GUANGZHOU_BOUNDS = new UberLatLngBounds(new UberLatLng(22.488099999999999D, 112.39149999999999D), new UberLatLng(24.427199999999999D, 113.7745D));
  private static final UberLatLngBounds HANGZHOU_BOUNDS = new UberLatLngBounds(new UberLatLng(29.5501D, 119.00409999999999D), new UberLatLng(30.927900000000001D, 121.3651D));
  private static final double LATLNG_PRECISION = Math.pow(10.0D, 6.0D);
  private static final UberLatLngBounds SHANGHAI_BOUNDS = new UberLatLngBounds(new UberLatLng(27.120000000000001D, 114.90000000000001D), new UberLatLng(34.25D, 122.81999999999999D));
  private static final UberLatLngBounds SHENZEN_BOUNDS = new UberLatLngBounds(new UberLatLng(22.501473000000001D, 113.381601D), new UberLatLng(23.187719000000001D, 114.764664D));

  static
  {
    CHENGDU_BOUNDS = new UberLatLngBounds(new UberLatLng(28.140000000000001D, 100.88D), new UberLatLng(33.619999999999997D, 109.33D));
  }

  public static LatLng convertToGoogleLatLng(UberLatLng paramUberLatLng)
  {
    return new LatLng(paramUberLatLng.getLatitude(), paramUberLatLng.getLongitude());
  }

  public static LatLngBounds convertToGoogleLatLngBounds(UberLatLngBounds paramUberLatLngBounds)
  {
    return new LatLngBounds(convertToGoogleLatLng(paramUberLatLngBounds.getSouthwest()), convertToGoogleLatLng(paramUberLatLngBounds.getNortheast()));
  }

  public static UberLatLng convertToUberLatLng(LatLng paramLatLng)
  {
    return new UberLatLng(paramLatLng.latitude, paramLatLng.longitude);
  }

  public static List<UberLatLng> decode(String paramString)
  {
    int i = paramString.length();
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    int k = 0;
    int m = 0;
    int n;
    int i1;
    if (j < i)
    {
      n = 1;
      i1 = 0;
    }
    while (true)
    {
      int i2 = j + 1;
      int i3 = -1 + ('￁' + paramString.charAt(j));
      n += (i3 << i1);
      i1 += 5;
      if (i3 < 31)
      {
        int i4;
        label84: int i5;
        int i6;
        if ((n & 0x1) != 0)
        {
          i4 = 0xFFFFFFFF ^ n >> 1;
          k += i4;
          i5 = 1;
          i6 = 0;
        }
        int i8;
        for (int i7 = i2; ; i7 = i8)
        {
          i8 = i7 + 1;
          int i9 = -1 + ('￁' + paramString.charAt(i7));
          i5 += (i9 << i6);
          i6 += 5;
          if (i9 < 31)
          {
            if ((i5 & 0x1) != 0);
            for (int i10 = 0xFFFFFFFF ^ i5 >> 1; ; i10 = i5 >> 1)
            {
              m += i10;
              localArrayList.add(new UberLatLng(1.E-005D * k, 1.E-005D * m));
              j = i8;
              break;
              i4 = n >> 1;
              break label84;
            }
            return localArrayList;
          }
        }
      }
      j = i2;
    }
  }

  public static boolean equalWithinDistance(UberLatLng paramUberLatLng1, UberLatLng paramUberLatLng2)
  {
    boolean bool = true;
    if ((paramUberLatLng1 == null) || (paramUberLatLng2 == null))
      bool = false;
    while ((paramUberLatLng1.equals(paramUberLatLng2)) || (UberLatLng.distanceInMeters(paramUberLatLng1, paramUberLatLng2) < 1.0D))
      return bool;
    return false;
  }

  public static boolean equalWithinPrecision(UberLatLng paramUberLatLng1, UberLatLng paramUberLatLng2)
  {
    boolean bool = true;
    if ((paramUberLatLng1 == null) || (paramUberLatLng2 == null))
      bool = false;
    double d1;
    double d2;
    double d3;
    double d4;
    do
    {
      do
        return bool;
      while (paramUberLatLng1.equals(paramUberLatLng2));
      d1 = Math.round(paramUberLatLng1.getLatitude() * LATLNG_PRECISION) / LATLNG_PRECISION;
      d2 = Math.round(paramUberLatLng2.getLatitude() * LATLNG_PRECISION) / LATLNG_PRECISION;
      d3 = Math.round(paramUberLatLng1.getLongitude() * LATLNG_PRECISION) / LATLNG_PRECISION;
      d4 = Math.round(paramUberLatLng2.getLongitude() * LATLNG_PRECISION) / LATLNG_PRECISION;
    }
    while ((d1 == d2) && (d3 == d4));
    return false;
  }

  public static boolean isInCalifornia(UberLocation paramUberLocation)
  {
    if (paramUberLocation == null)
      return false;
    return new UberLatLngBounds(new UberLatLng(32.5D, -124.59999999999999D), new UberLatLng(42.100000000000001D, -114.09999999999999D)).contains(paramUberLocation.getUberLatLng());
  }

  public static boolean isInChina(UberLatLng paramUberLatLng)
  {
    return (CHENGDU_BOUNDS.contains(paramUberLatLng)) || (BEIJING_BOUNDS.contains(paramUberLatLng)) || (GUANGZHOU_BOUNDS.contains(paramUberLatLng)) || (HANGZHOU_BOUNDS.contains(paramUberLatLng)) || (SHANGHAI_BOUNDS.contains(paramUberLatLng)) || (SHENZEN_BOUNDS.contains(paramUberLatLng));
  }

  public static boolean isInGermany(UberLocation paramUberLocation)
  {
    boolean bool = Locale.getDefault().getLanguage().startsWith("de");
    if (paramUberLocation != null)
      return (new UberLatLngBounds(new UberLatLng(47.299999999999997D, 5.32D), new UberLatLng(55.119999999999997D, 14.800000000000001D)).contains(paramUberLocation.getUberLatLng())) || (bool);
    return bool;
  }

  public static boolean isInJapan(UberLocation paramUberLocation)
  {
    boolean bool1 = Locale.getDefault().getLanguage().startsWith("ja");
    if (paramUberLocation == null)
      return bool1;
    boolean bool2 = new UberLatLngBounds(new UberLatLng(23.649999999999999D, 122.5D), new UberLatLng(45.950000000000003D, 146.5D)).contains(paramUberLocation.getUberLatLng());
    if ((bool1) && (bool2));
    for (boolean bool3 = true; ; bool3 = false)
      return bool3;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.util.LocationUtils
 * JD-Core Version:    0.6.2
 */