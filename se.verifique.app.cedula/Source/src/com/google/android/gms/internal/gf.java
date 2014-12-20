package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.Uri;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import java.util.Locale;

public final class gf
{
  public final int a;
  public final boolean b;
  public final boolean c;
  public final String d;
  public final String e;
  public final boolean f;
  public final boolean g;
  public final boolean h;
  public final String i;
  public final String j;
  public final int k;
  public final int l;
  public final int m;
  public final int n;
  public final int o;
  public final int p;
  public final float q;
  public final int r;
  public final int s;
  public final double t;
  public final boolean u;
  public final boolean v;
  public final int w;

  public gf(Context paramContext)
  {
    AudioManager localAudioManager = (AudioManager)paramContext.getSystemService("audio");
    ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    Locale localLocale = Locale.getDefault();
    PackageManager localPackageManager = paramContext.getPackageManager();
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    Intent localIntent = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    this.a = localAudioManager.getMode();
    boolean bool2;
    boolean bool3;
    if (a(localPackageManager, "geo:0,0?q=donuts") != null)
    {
      bool2 = bool1;
      this.b = bool2;
      if (a(localPackageManager, "http://www.google.com") == null)
        break label376;
      bool3 = bool1;
      label114: this.c = bool3;
      this.d = localTelephonyManager.getNetworkOperator();
      this.e = localLocale.getCountry();
      this.f = hh.a();
      this.g = localAudioManager.isMusicActive();
      this.h = localAudioManager.isSpeakerphoneOn();
      this.i = localLocale.getLanguage();
      this.j = a(localPackageManager);
      this.k = localAudioManager.getStreamVolume(3);
      this.l = a(paramContext, localConnectivityManager, localPackageManager);
      this.m = localTelephonyManager.getNetworkType();
      this.n = localTelephonyManager.getPhoneType();
      this.o = localAudioManager.getRingerMode();
      this.p = localAudioManager.getStreamVolume(2);
      this.q = localDisplayMetrics.density;
      this.r = localDisplayMetrics.widthPixels;
      this.s = localDisplayMetrics.heightPixels;
      if (localIntent == null)
        break label387;
      int i1 = localIntent.getIntExtra("status", -1);
      int i2 = localIntent.getIntExtra("level", -1);
      int i3 = localIntent.getIntExtra("scale", -1);
      this.t = (i2 / i3);
      if ((i1 != 2) && (i1 != 5))
        break label382;
      label324: this.u = bool1;
      label329: if (Build.VERSION.SDK_INT < 16)
        break label411;
      this.v = localConnectivityManager.isActiveNetworkMetered();
      if (localConnectivityManager.getActiveNetworkInfo() == null)
        break label402;
      this.w = localConnectivityManager.getActiveNetworkInfo().getDetailedState().ordinal();
    }
    while (true)
    {
      return;
      bool2 = false;
      break;
      label376: bool3 = false;
      break label114;
      label382: bool1 = false;
      break label324;
      label387: this.t = -1.0D;
      this.u = false;
      break label329;
      label402: this.w = -1;
      continue;
      label411: this.v = false;
      this.w = -1;
    }
  }

  private static int a(Context paramContext, ConnectivityManager paramConnectivityManager, PackageManager paramPackageManager)
  {
    int i1 = -2;
    NetworkInfo localNetworkInfo;
    if (gw.a(paramPackageManager, paramContext.getPackageName(), "android.permission.ACCESS_NETWORK_STATE"))
    {
      localNetworkInfo = paramConnectivityManager.getActiveNetworkInfo();
      if (localNetworkInfo == null)
        break label35;
    }
    label35: for (i1 = localNetworkInfo.getType(); ; i1 = -1)
      return i1;
  }

  private static ResolveInfo a(PackageManager paramPackageManager, String paramString)
  {
    return paramPackageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)), 65536);
  }

  private static String a(PackageManager paramPackageManager)
  {
    Object localObject = null;
    ResolveInfo localResolveInfo = a(paramPackageManager, "market://details?id=com.google.android.gms.ads");
    if (localResolveInfo == null);
    while (true)
    {
      return localObject;
      ActivityInfo localActivityInfo = localResolveInfo.activityInfo;
      if (localActivityInfo == null)
        continue;
      try
      {
        PackageInfo localPackageInfo = paramPackageManager.getPackageInfo(localActivityInfo.packageName, 0);
        if (localPackageInfo == null)
          continue;
        String str = localPackageInfo.versionCode + "." + localActivityInfo.packageName;
        localObject = str;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
      }
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gf
 * JD-Core Version:    0.6.0
 */