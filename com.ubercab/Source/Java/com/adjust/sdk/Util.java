package com.adjust.sdk;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util
{
  private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'Z";
  private static SimpleDateFormat dateFormat;

  private static String convertToHex(byte[] paramArrayOfByte)
  {
    BigInteger localBigInteger = new BigInteger(1, paramArrayOfByte);
    return String.format("%0" + (paramArrayOfByte.length << 1) + "x", new Object[] { localBigInteger });
  }

  protected static String createUuid()
  {
    return UUID.randomUUID().toString();
  }

  public static String dateFormat(long paramLong)
  {
    if (dateFormat == null)
      dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'Z", Locale.US);
    return dateFormat.format(Long.valueOf(paramLong));
  }

  protected static String getAndroidId(Context paramContext)
  {
    return Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
  }

  private static String getAppVersion(Context paramContext)
  {
    try
    {
      String str = sanitizeString(paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName);
      return str;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return "unknown";
  }

  protected static String getAttributionId(Context paramContext)
  {
    try
    {
      Cursor localCursor = paramContext.getContentResolver().query(Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider"), new String[] { "aid" }, null, null, null);
      if (localCursor == null)
        return null;
      if (!localCursor.moveToFirst())
      {
        localCursor.close();
        return null;
      }
      String str = localCursor.getString(localCursor.getColumnIndex("aid"));
      localCursor.close();
      return str;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  private static String getCountry(Locale paramLocale)
  {
    return sanitizeStringShort(paramLocale.getCountry());
  }

  private static String getDeviceName()
  {
    return sanitizeString(Build.MODEL);
  }

  private static String getDeviceType(int paramInt)
  {
    switch (paramInt & 0xF)
    {
    default:
      return "unknown";
    case 1:
    case 2:
      return "phone";
    case 3:
    case 4:
    }
    return "tablet";
  }

  private static String getDisplayHeight(DisplayMetrics paramDisplayMetrics)
  {
    return sanitizeString(String.valueOf(paramDisplayMetrics.heightPixels));
  }

  private static String getDisplayWidth(DisplayMetrics paramDisplayMetrics)
  {
    return sanitizeString(String.valueOf(paramDisplayMetrics.widthPixels));
  }

  public static String getGpsAdid(Context paramContext)
  {
    try
    {
      Object localObject = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", new Class[] { Context.class }).invoke(null, new Object[] { paramContext });
      Class localClass = localObject.getClass();
      if (((Boolean)localClass.getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(localObject, new Object[0])).booleanValue())
        return null;
      String str = (String)localClass.getMethod("getId", new Class[0]).invoke(localObject, new Object[0]);
      return str;
    }
    catch (NoClassDefFoundError localNoClassDefFoundError)
    {
      return null;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  private static String getLanguage(Locale paramLocale)
  {
    return sanitizeStringShort(paramLocale.getLanguage());
  }

  protected static String getMacAddress(Context paramContext)
  {
    return sanitizeString(getRawMacAddress(paramContext).toUpperCase(Locale.US));
  }

  private static String getOsName()
  {
    return "android";
  }

  private static String getOsVersion()
  {
    return sanitizeString("" + Build.VERSION.SDK_INT);
  }

  private static String getPackageName(Context paramContext)
  {
    return sanitizeString(paramContext.getPackageName());
  }

  private static String getRawMacAddress(Context paramContext)
  {
    String str1 = loadAddress("wlan0");
    if (str1 != null)
      return str1;
    String str2 = loadAddress("eth0");
    if (str2 != null)
      return str2;
    try
    {
      String str3 = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
      if (str3 != null)
        return str3;
    }
    catch (Exception localException)
    {
    }
    return "";
  }

  private static String getScreenDensity(DisplayMetrics paramDisplayMetrics)
  {
    int i = paramDisplayMetrics.densityDpi;
    if (i == 0)
      return "unknown";
    if (i < 140)
      return "low";
    if (i > 200)
      return "high";
    return "medium";
  }

  private static String getScreenFormat(int paramInt)
  {
    switch (paramInt & 0x30)
    {
    default:
      return "unknown";
    case 32:
      return "long";
    case 16:
    }
    return "normal";
  }

  private static String getScreenSize(int paramInt)
  {
    switch (paramInt & 0xF)
    {
    default:
      return "unknown";
    case 1:
      return "small";
    case 2:
      return "normal";
    case 3:
      return "large";
    case 4:
    }
    return "xlarge";
  }

  protected static String getUserAgent(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    DisplayMetrics localDisplayMetrics = localResources.getDisplayMetrics();
    Configuration localConfiguration = localResources.getConfiguration();
    Locale localLocale = localConfiguration.locale;
    int i = localConfiguration.screenLayout;
    String[] arrayOfString = new String[13];
    arrayOfString[0] = getPackageName(paramContext);
    arrayOfString[1] = getAppVersion(paramContext);
    arrayOfString[2] = getDeviceType(i);
    arrayOfString[3] = getDeviceName();
    arrayOfString[4] = getOsName();
    arrayOfString[5] = getOsVersion();
    arrayOfString[6] = getLanguage(localLocale);
    arrayOfString[7] = getCountry(localLocale);
    arrayOfString[8] = getScreenSize(i);
    arrayOfString[9] = getScreenFormat(i);
    arrayOfString[10] = getScreenDensity(localDisplayMetrics);
    arrayOfString[11] = getDisplayWidth(localDisplayMetrics);
    arrayOfString[12] = getDisplayHeight(localDisplayMetrics);
    return TextUtils.join(" ", arrayOfString);
  }

  private static String hash(String paramString1, String paramString2)
  {
    try
    {
      byte[] arrayOfByte = paramString1.getBytes("UTF-8");
      MessageDigest localMessageDigest = MessageDigest.getInstance(paramString2);
      localMessageDigest.update(arrayOfByte, 0, arrayOfByte.length);
      String str = convertToHex(localMessageDigest.digest());
      return str;
    }
    catch (Exception localException)
    {
    }
    return "";
  }

  protected static String loadAddress(String paramString)
  {
    try
    {
      String str1 = "/sys/class/net/" + paramString + "/address";
      StringBuilder localStringBuilder = new StringBuilder(1000);
      BufferedReader localBufferedReader = new BufferedReader(new FileReader(str1), 1024);
      char[] arrayOfChar = new char[1024];
      while (true)
      {
        int i = localBufferedReader.read(arrayOfChar);
        if (i == -1)
          break;
        localStringBuilder.append(String.valueOf(arrayOfChar, 0, i));
      }
      localBufferedReader.close();
      String str2 = localStringBuilder.toString();
      return str2;
    }
    catch (IOException localIOException)
    {
    }
    return null;
  }

  protected static String md5(String paramString)
  {
    return hash(paramString, "MD5");
  }

  public static String quote(String paramString)
  {
    if (paramString == null)
      paramString = null;
    while (!Pattern.compile("\\s").matcher(paramString).find())
      return paramString;
    return String.format("'%s'", new Object[] { paramString });
  }

  private static String sanitizeString(String paramString)
  {
    return sanitizeString(paramString, "unknown");
  }

  private static String sanitizeString(String paramString1, String paramString2)
  {
    String str1 = paramString1;
    if (TextUtils.isEmpty(str1))
      str1 = paramString2;
    String str2 = str1.replaceAll("\\s", "");
    if (TextUtils.isEmpty(str2))
      str2 = paramString2;
    return str2;
  }

  private static String sanitizeStringShort(String paramString)
  {
    return sanitizeString(paramString, "zz");
  }

  protected static String sha1(String paramString)
  {
    return hash(paramString, "SHA-1");
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.Util
 * JD-Core Version:    0.6.2
 */