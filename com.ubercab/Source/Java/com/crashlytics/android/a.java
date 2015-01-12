package com.crashlytics.android;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import com.crashlytics.android.internal.Z;
import com.crashlytics.android.internal.ab;
import com.crashlytics.android.internal.av;
import com.crashlytics.android.internal.ax;
import com.crashlytics.android.internal.ay;
import com.crashlytics.android.internal.q;
import com.crashlytics.android.internal.r;
import com.crashlytics.android.internal.v;
import java.io.InputStream;

abstract class a extends Z
{
  public a(String paramString1, String paramString2, av paramav, ax paramax)
  {
    super(paramString1, paramString2, paramav, paramax);
  }

  private static ay a(ay paramay, b paramb)
  {
    ay localay = paramay.b("app[identifier]", paramb.b).b("app[name]", paramb.f).b("app[display_version]", paramb.c).b("app[build_version]", paramb.d).a("app[source]", Integer.valueOf(paramb.g)).b("app[minimum_sdk_version]", paramb.h).b("app[built_sdk_version]", paramb.i);
    if (!ab.e(paramb.e))
      localay.b("app[instance_identifier]", paramb.e);
    InputStream localInputStream;
    if (paramb.j != null)
      localInputStream = null;
    try
    {
      localInputStream = v.a().getContext().getResources().openRawResource(paramb.j.b);
      localay.b("app[icon][hash]", paramb.j.a).a("app[icon][data]", "icon.png", "application/octet-stream", localInputStream).a("app[icon][width]", Integer.valueOf(paramb.j.c)).a("app[icon][height]", Integer.valueOf(paramb.j.d));
      return localay;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      v.a().b().a("Crashlytics", "Failed to find app icon with resource ID: " + paramb.j.b, localNotFoundException);
      return localay;
    }
    finally
    {
      ab.a(localInputStream, "Failed to close app icon InputStream.");
    }
  }

  public final boolean a(b paramb)
  {
    ay localay = a(b().a("X-CRASHLYTICS-API-KEY", paramb.a).a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", v.a().getVersion()), paramb);
    v.a().b().a("Crashlytics", "Sending app info to " + a());
    if (paramb.j != null)
    {
      v.a().b().a("Crashlytics", "App icon hash is " + paramb.j.a);
      v.a().b().a("Crashlytics", "App icon size is " + paramb.j.c + "x" + paramb.j.d);
    }
    int i = localay.b();
    if ("POST".equals(localay.d()));
    for (String str = "Create"; ; str = "Update")
    {
      v.a().b().a("Crashlytics", str + " app request ID: " + localay.a("X-REQUEST-ID"));
      v.a().b().a("Crashlytics", "Result was " + i);
      if (r.a(i) != 0)
        break;
      return true;
    }
    return false;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.a
 * JD-Core Version:    0.6.2
 */