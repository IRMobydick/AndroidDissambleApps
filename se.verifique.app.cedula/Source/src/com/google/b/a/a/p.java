package com.google.b.a.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class p extends bh
{
  private static p a;
  private static String b;
  private final ao c;
  private boolean d;
  private boolean e;
  private int f;
  private long g;
  private long h;
  private Context i;
  private final Map j;
  private av k;
  private bd l;
  private l m;
  private Timer n;
  private TimerTask o;
  private boolean p;
  private boolean q;

  private p(Context paramContext)
  {
    this(paramContext, new aw(paramContext), ao.a(paramContext), w.a(), null);
  }

  private p(Context paramContext, av paramav, ao paramao, bd parambd, bi parambi)
  {
  }

  private at a(String paramString)
  {
    try
    {
      at localat2 = at.valueOf(paramString.toUpperCase());
      localat1 = localat2;
      return localat1;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (true)
        at localat1 = null;
    }
  }

  public static p a(Context paramContext)
  {
    if (a == null)
      a = new p(paramContext);
    return a;
  }

  private void a(Context paramContext, av paramav, bd parambd)
  {
    if (paramContext == null)
      ar.a("Context cannot be null");
    this.i = paramContext.getApplicationContext();
    this.l = parambd;
    this.k = paramav;
    b();
  }

  private void b()
  {
    ar.c("Starting EasyTracker.");
    String str1 = this.k.a("ga_trackingId");
    if (TextUtils.isEmpty(str1))
      str1 = this.k.a("ga_api_key");
    a("&tid", str1);
    ar.c("[EasyTracker] trackingId loaded: " + str1);
    String str2 = this.k.a("ga_appName");
    if (!TextUtils.isEmpty(str2))
    {
      ar.c("[EasyTracker] app name loaded: " + str2);
      a("&an", str2);
    }
    String str3 = this.k.a("ga_appVersion");
    if (str3 != null)
    {
      ar.c("[EasyTracker] app version loaded: " + str3);
      a("&av", str3);
    }
    String str4 = this.k.a("ga_logLevel");
    if (str4 != null)
    {
      at localat = a(str4);
      if (localat != null)
      {
        ar.c("[EasyTracker] log level loaded: " + localat);
        this.c.d().a(localat);
      }
    }
    Double localDouble = this.k.b("ga_sampleFrequency");
    if (localDouble == null)
      localDouble = new Double(this.k.a("ga_sampleRate", 100));
    if (localDouble.doubleValue() != 100.0D)
      a("&sf", Double.toString(localDouble.doubleValue()));
    ar.c("[EasyTracker] sample rate loaded: " + localDouble);
    int i1 = this.k.a("ga_dispatchPeriod", 1800);
    ar.c("[EasyTracker] dispatch period loaded: " + i1);
    this.l.a(i1);
    this.g = (1000 * this.k.a("ga_sessionTimeout", 30));
    ar.c("[EasyTracker] session timeout loaded: " + this.g);
    if ((this.k.c("ga_autoActivityTracking")) || (this.k.c("ga_auto_activity_tracking")));
    for (boolean bool1 = true; ; bool1 = false)
    {
      this.e = bool1;
      ar.c("[EasyTracker] auto activity tracking loaded: " + this.e);
      boolean bool2 = this.k.c("ga_anonymizeIp");
      if (bool2)
      {
        a("&aip", "1");
        ar.c("[EasyTracker] anonymize ip loaded: " + bool2);
      }
      this.d = this.k.c("ga_reportUncaughtExceptions");
      if (this.d)
      {
        Thread.setDefaultUncaughtExceptionHandler(new t(this, this.l, Thread.getDefaultUncaughtExceptionHandler(), this.i));
        ar.c("[EasyTracker] report uncaught exceptions loaded: " + this.d);
      }
      boolean bool3 = this.k.c("ga_dryRun");
      this.c.a(bool3);
      return;
    }
  }

  private String c(Activity paramActivity)
  {
    String str1 = paramActivity.getClass().getCanonicalName();
    String str2;
    if (this.j.containsKey(str1))
      str2 = (String)this.j.get(str1);
    while (true)
    {
      return str2;
      str2 = this.k.a(str1);
      if (str2 == null)
        str2 = str1;
      this.j.put(str1, str2);
    }
  }

  private void c()
  {
    monitorenter;
    try
    {
      if (this.n != null)
      {
        this.n.cancel();
        this.n = null;
      }
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void a(Activity paramActivity)
  {
    am.a().a(an.ai);
    c();
    if ((!this.p) && (this.f == 0) && (a()))
      this.q = true;
    this.p = true;
    this.f = (1 + this.f);
    if (this.e)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("&t", "appview");
      am.a().a(true);
      a("&cd", c(paramActivity));
      a(localHashMap);
      am.a().a(false);
    }
  }

  public void a(Map paramMap)
  {
    if (this.q)
    {
      paramMap.put("&sc", "start");
      this.q = false;
    }
    super.a(paramMap);
  }

  boolean a()
  {
    if ((this.g == 0L) || ((this.g > 0L) && (this.m.a() > this.h + this.g)));
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public void b(Activity paramActivity)
  {
    am.a().a(an.aj);
    this.f = (-1 + this.f);
    this.f = Math.max(0, this.f);
    this.h = this.m.a();
    if (this.f == 0)
    {
      c();
      this.o = new r(this, null);
      this.n = new Timer("waitForActivityStart");
      this.n.schedule(this.o, 1000L);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.b.a.a.p
 * JD-Core Version:    0.6.0
 */