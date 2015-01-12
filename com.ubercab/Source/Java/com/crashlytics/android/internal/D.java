package com.crashlytics.android.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import java.io.File;

public class D extends u
{
  private String a;
  private String b;
  private String c;
  private ao d;
  private aJ e;
  private long f;
  private av g;
  private O h;

  public static D a()
  {
    return (D)v.a().a(D.class);
  }

  private String b()
  {
    return ab.a(getContext(), "com.crashlytics.ApiEndpoint");
  }

  public final void a(af paramaf)
  {
    if (this.h != null)
      this.h.a(paramaf.a());
  }

  public final void a(ag paramag)
  {
    if (this.h != null)
      this.h.b(paramag.a());
  }

  protected final void c()
  {
    try
    {
      this.g = new av(v.a().b());
      this.e = new aJ(v.a().a(D.class));
      Context localContext = getContext();
      PackageManager localPackageManager = localContext.getPackageManager();
      this.d = new ao(localContext);
      this.a = localContext.getPackageName();
      PackageInfo localPackageInfo = localPackageManager.getPackageInfo(this.a, 0);
      this.b = Integer.toString(localPackageInfo.versionCode);
      String str;
      if (localPackageInfo.versionName == null)
      {
        str = "0.0";
        this.c = str;
        if (Build.VERSION.SDK_INT < 9)
          break label157;
      }
      label157: for (this.f = localPackageInfo.firstInstallTime; ; this.f = new File(localContext.getPackageManager().getApplicationInfo(localContext.getPackageName(), 0).sourceDir).lastModified())
      {
        new Thread(new E(this), "Crashlytics Initializer").start();
        return;
        str = localPackageInfo.versionName;
        break;
      }
    }
    catch (Exception localException)
    {
      while (true)
        v.a().b().a("Crashlytics", "Error setting up app properties", localException);
    }
  }

  public String getVersion()
  {
    return v.a().getVersion();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.internal.D
 * JD-Core Version:    0.6.2
 */