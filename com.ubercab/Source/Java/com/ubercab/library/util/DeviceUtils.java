package com.ubercab.library.util;

import android.content.Context;
import android.graphics.Point;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import java.util.Locale;

public final class DeviceUtils
{
  private static final String LOCALE_CHINESE = "zh";
  private static final String LOCALE_TRADITIONAL_CHINESE = "zh_TW";

  public static String getAndroidId(Context paramContext)
  {
    try
    {
      String str = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      return str;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static String getDeviceId(Context paramContext)
  {
    String str1 = getTelephonyDeviceId(paramContext);
    if (!TextUtils.isEmpty(str1))
      return str1;
    String str2 = Build.SERIAL;
    if (!TextUtils.isEmpty(str2))
      return str2;
    String str3 = getAndroidId(paramContext);
    if (!TextUtils.isEmpty(str3))
      return str3;
    String str4 = getWifiMacAddress(paramContext);
    if (!TextUtils.isEmpty(str4))
      return str4;
    return "Error getting deviceId";
  }

  public static String getDeviceLanguage()
  {
    Locale localLocale = Locale.getDefault();
    String str1 = localLocale.getCountry().toUpperCase(Locale.US);
    String str2 = localLocale.getLanguage().toLowerCase(Locale.US);
    if ("".equals(str1))
    {
      if ("zh".equals(str2))
        str2 = "zh_TW";
      return str2;
    }
    return String.format("%s_%s", new Object[] { str2, str1 });
  }

  public static String getDeviceMCC(Context paramContext)
  {
    String str = ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkOperator();
    if ((str != null) && (str.length() >= 3))
      return str.substring(0, 3);
    return "";
  }

  public static String getDeviceMNC(Context paramContext)
  {
    String str = ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkOperator();
    if ((str != null) && (str.length() >= 3))
      return str.substring(3);
    return "";
  }

  public static String getPhoneNumber(Context paramContext)
  {
    return ((TelephonyManager)paramContext.getSystemService("phone")).getLine1Number();
  }

  public static String getPhoneNumberCountryIso2(Context paramContext)
  {
    return ((TelephonyManager)paramContext.getSystemService("phone")).getSimCountryIso();
  }

  public static Point getScreenSize(Context paramContext)
  {
    Display localDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    Point localPoint = new Point();
    localDisplay.getSize(localPoint);
    return localPoint;
  }

  public static String getTelephonyDeviceId(Context paramContext)
  {
    try
    {
      String str = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      return str;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static String getWifiMacAddress(Context paramContext)
  {
    try
    {
      String str = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
      return str;
    }
    catch (Exception localException)
    {
    }
    return null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.util.DeviceUtils
 * JD-Core Version:    0.6.2
 */