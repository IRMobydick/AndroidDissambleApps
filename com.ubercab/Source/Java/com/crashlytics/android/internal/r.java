package com.crashlytics.android.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;

public class r
  implements q
{
  public static int a(int paramInt)
  {
    if ((paramInt >= 200) && (paramInt <= 299));
    do
    {
      return 0;
      if ((paramInt >= 300) && (paramInt <= 399))
        return 1;
    }
    while ((paramInt >= 400) && (paramInt <= 499));
    if (paramInt >= 500)
      return 1;
    return 1;
  }

  public static String a(Context paramContext, boolean paramBoolean)
  {
    String str1;
    try
    {
      Context localContext = paramContext.getApplicationContext();
      String str2 = localContext.getPackageName();
      Bundle localBundle = localContext.getPackageManager().getApplicationInfo(str2, 128).metaData;
      if (localBundle != null)
      {
        String str3 = localBundle.getString("com.crashlytics.ApiKey");
        str1 = str3;
        if (ab.e(str1))
        {
          int i = ab.a(paramContext, "com.crashlytics.ApiKey", "string");
          if (i != 0)
            str1 = paramContext.getResources().getString(i);
        }
        if (!ab.e(str1))
          break label159;
        if ((!paramBoolean) && (!ab.f(paramContext)))
          break label143;
        throw new IllegalArgumentException("Crashlytics could not be initialized, API key missing from AndroidManifest.xml. Add the following tag to your Application element \n\t<meta-data android:name=\"com.crashlytics.ApiKey\" android:value=\"YOUR_API_KEY\"/>");
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        y.a().b().a("Crashlytics", "Caught non-fatal exception while retrieving apiKey: " + localException);
        str1 = null;
      }
      label143: y.a().b().a("Crashlytics", "Crashlytics could not be initialized, API key missing from AndroidManifest.xml. Add the following tag to your Application element \n\t<meta-data android:name=\"com.crashlytics.ApiKey\" android:value=\"YOUR_API_KEY\"/>", null);
    }
    label159: return str1;
  }

  private static boolean b(int paramInt)
  {
    return y.a().g() <= paramInt;
  }

  public final void a(int paramInt, String paramString1, String paramString2)
  {
    a(paramInt, paramString1, paramString2, false);
  }

  public final void a(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramBoolean) || (b(paramInt)))
      Log.println(paramInt, paramString1, paramString2);
  }

  public final void a(String paramString1, String paramString2)
  {
    if (b(3))
      Log.d(paramString1, paramString2, null);
  }

  public final void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (b(6))
      Log.e(paramString1, paramString2, paramThrowable);
  }

  public final void b(String paramString1, String paramString2)
  {
    if (b(4))
      Log.i(paramString1, paramString2, null);
  }

  public final void c(String paramString1, String paramString2)
  {
    if (b(5))
      Log.w(paramString1, paramString2, null);
  }

  public final void d(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, null);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.internal.r
 * JD-Core Version:    0.6.2
 */