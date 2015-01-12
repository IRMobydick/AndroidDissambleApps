package com.ubercab.library.vendor.google;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.location.LocationManager;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.location.model.UberLatLngBounds;
import com.ubercab.library.location.model.UberLocation;

public final class GoogleUtils
{
  public static final String GOOGLE_PLAY_SERVICES_DEVELOPER_ERROR = "developer_error";
  public static final String GOOGLE_PLAY_SERVICES_INTERNAL_ERROR = "internal_error";
  public static final String GOOGLE_PLAY_SERVICES_INVALID_ACCOUNT = "invalid_account";
  public static final String GOOGLE_PLAY_SERVICES_LICENSE_CHECK_FAILED = "license_check_failed";
  public static final String GOOGLE_PLAY_SERVICES_NETWORK_ERROR = "network_error";
  public static final String GOOGLE_PLAY_SERVICES_RESOLUTION_REQUIRED = "resolution_required";
  public static final String GOOGLE_PLAY_SERVICES_SERVICE_DISABLED = "service_disabled";
  public static final String GOOGLE_PLAY_SERVICES_SERVICE_INVALID = "service_invalid";
  public static final String GOOGLE_PLAY_SERVICES_SERVICE_MISSING = "service_missing";
  public static final String GOOGLE_PLAY_SERVICES_SERVICE_VERSION_UPDATE_REQUIRED = "service_version_update_required";
  public static final String GOOGLE_PLAY_SERVICES_SIGN_IN_REQUIRED = "sign_in_required";
  public static final String GOOGLE_PLAY_SERVICES_SUCCESS = "success";
  public static final String GOOGLE_PLAY_SERVICES_UNKNOWN = "unkown";

  public static LatLng convertLatLng(UberLatLng paramUberLatLng)
  {
    return new LatLng(paramUberLatLng.getLatitude(), paramUberLatLng.getLongitude());
  }

  public static UberLatLng convertLatLng(LatLng paramLatLng)
  {
    return new UberLatLng(paramLatLng.latitude, paramLatLng.longitude);
  }

  public static LatLngBounds convertLatLngBounds(UberLatLngBounds paramUberLatLngBounds)
  {
    return new LatLngBounds(convertLatLng(paramUberLatLngBounds.getSouthwest()), convertLatLng(paramUberLatLngBounds.getNortheast()));
  }

  public static String formatLocation(double paramDouble1, double paramDouble2)
  {
    if ((Double.isNaN(paramDouble1)) || (Double.isNaN(paramDouble2)))
      return "";
    return paramDouble1 + "," + paramDouble2;
  }

  public static String formatLocation(UberLatLng paramUberLatLng)
  {
    if (paramUberLatLng == null)
      return "";
    return formatLocation(paramUberLatLng.getLatitude(), paramUberLatLng.getLongitude());
  }

  public static String formatLocation(UberLocation paramUberLocation)
  {
    if (paramUberLocation == null)
      return "";
    return formatLocation(paramUberLocation.getUberLatLng());
  }

  public static String getGooglePlayServicesStatus(Context paramContext)
  {
    switch (GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramContext))
    {
    default:
      return "unkown";
    case 10:
      return "developer_error";
    case 8:
      return "internal_error";
    case 5:
      return "invalid_account";
    case 11:
      return "license_check_failed";
    case 7:
      return "network_error";
    case 6:
      return "resolution_required";
    case 3:
      return "service_disabled";
    case 9:
      return "service_invalid";
    case 1:
      return "service_missing";
    case 2:
      return "service_version_update_required";
    case 4:
      return "sign_in_required";
    case 0:
    }
    return "success";
  }

  public static String getGooglePlayServicesVersionName(Context paramContext)
  {
    try
    {
      String str = paramContext.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionName;
      return str;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return "name_not_found";
  }

  public static boolean isGooglePlayServicesInstalled(Context paramContext)
  {
    int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramContext);
    return (i != 1) && (i != 9);
  }

  public static boolean isLocationProviderAvailable(Context paramContext)
  {
    LocationManager localLocationManager = (LocationManager)paramContext.getSystemService("location");
    boolean bool1 = localLocationManager.isProviderEnabled("network");
    boolean bool2 = localLocationManager.isProviderEnabled("gps");
    return (bool1) || (bool2);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.vendor.google.GoogleUtils
 * JD-Core Version:    0.6.2
 */