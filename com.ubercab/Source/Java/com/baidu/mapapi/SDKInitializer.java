package com.baidu.mapapi;

import android.app.Application;
import android.content.Context;
import com.baidu.mapapi.utils.b;
import java.io.File;

public class SDKInitializer
{
  public static final String SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR = "network error";
  public static final String SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_ERROR = "permission check error";
  public static final String SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE = "error_code";
  private static boolean a;

  public static void initialize(Context paramContext)
  {
    initialize(null, paramContext);
  }

  public static void initialize(String paramString, Context paramContext)
  {
    if (!a)
    {
      if (paramContext == null)
        throw new IllegalArgumentException("context can not be null");
      if (!(paramContext instanceof Application))
        break label112;
      a.a().a(paramContext);
      if ((paramString == null) || (paramString.equals("")));
    }
    try
    {
      File localFile = new File(paramString + "/test.0");
      if (localFile.exists())
        localFile.delete();
      localFile.createNewFile();
      if (localFile.exists())
        localFile.delete();
      b.a(paramString);
      a = true;
      return;
      label112: throw new RuntimeException("context must be an Application Context");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    throw new IllegalArgumentException("provided sdcard path can not used.");
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.SDKInitializer
 * JD-Core Version:    0.6.2
 */