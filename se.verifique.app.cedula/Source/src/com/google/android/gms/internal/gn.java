package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;

public class gn
{
  private final Object a = new Object();
  private final String b;
  private int c = 0;
  private long d = -1L;
  private long e = -1L;
  private int f = 0;
  private int g = -1;

  public gn(String paramString)
  {
    this.b = paramString;
  }

  public static boolean a(Context paramContext)
  {
    int i = 0;
    int j = paramContext.getResources().getIdentifier("Theme.Translucent", "style", "android");
    if (j == 0)
      hi.c("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
    while (true)
    {
      return i;
      ComponentName localComponentName = new ComponentName(paramContext.getPackageName(), "com.google.android.gms.ads.AdActivity");
      try
      {
        if (j == paramContext.getPackageManager().getActivityInfo(localComponentName, 0).theme)
        {
          i = 1;
          continue;
        }
        hi.c("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        hi.e("Fail to fetch AdActivity theme");
        hi.c("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
      }
    }
  }

  public long a()
  {
    return this.e;
  }

  public Bundle a(Context paramContext, String paramString)
  {
    synchronized (this.a)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("session_id", this.b);
      localBundle.putLong("basets", this.e);
      localBundle.putLong("currts", this.d);
      localBundle.putString("seq_num", paramString);
      localBundle.putInt("preqs", this.g);
      localBundle.putInt("pclick", this.c);
      localBundle.putInt("pimp", this.f);
      localBundle.putBoolean("support_transparent_background", a(paramContext));
      return localBundle;
    }
  }

  // ERROR //
  public void a(ai paramai, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 22	com/google/android/gms/internal/gn:a	Ljava/lang/Object;
    //   4: astore 4
    //   6: aload 4
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 30	com/google/android/gms/internal/gn:e	J
    //   13: ldc2_w 25
    //   16: lcmp
    //   17: ifne +43 -> 60
    //   20: aload_0
    //   21: lload_2
    //   22: putfield 30	com/google/android/gms/internal/gn:e	J
    //   25: aload_0
    //   26: aload_0
    //   27: getfield 30	com/google/android/gms/internal/gn:e	J
    //   30: putfield 28	com/google/android/gms/internal/gn:d	J
    //   33: aload_1
    //   34: getfield 137	com/google/android/gms/internal/ai:d	Landroid/os/Bundle;
    //   37: ifnull +39 -> 76
    //   40: aload_1
    //   41: getfield 137	com/google/android/gms/internal/ai:d	Landroid/os/Bundle;
    //   44: ldc 139
    //   46: iconst_2
    //   47: invokevirtual 143	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   50: iconst_1
    //   51: if_icmpne +25 -> 76
    //   54: aload 4
    //   56: monitorexit
    //   57: goto +32 -> 89
    //   60: aload_0
    //   61: lload_2
    //   62: putfield 28	com/google/android/gms/internal/gn:d	J
    //   65: goto -32 -> 33
    //   68: astore 5
    //   70: aload 4
    //   72: monitorexit
    //   73: aload 5
    //   75: athrow
    //   76: aload_0
    //   77: iconst_1
    //   78: aload_0
    //   79: getfield 34	com/google/android/gms/internal/gn:g	I
    //   82: iadd
    //   83: putfield 34	com/google/android/gms/internal/gn:g	I
    //   86: aload 4
    //   88: monitorexit
    //   89: return
    //
    // Exception table:
    //   from	to	target	type
    //   9	73	68	finally
    //   76	89	68	finally
  }

  public void b()
  {
    synchronized (this.a)
    {
      this.c = (1 + this.c);
      return;
    }
  }

  public void c()
  {
    synchronized (this.a)
    {
      this.f = (1 + this.f);
      return;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gn
 * JD-Core Version:    0.6.0
 */