package com.crashlytics.android.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.Log;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

public final class v extends p
{
  private b a = new B(m.a);
  private AtomicReference<q> b = new AtomicReference();
  private boolean c;
  private File d;
  private Application e;
  private WeakReference<Activity> f;
  private String g;
  private int h = 4;
  private ConcurrentHashMap<Class<? extends u>, u> i = new ConcurrentHashMap();

  public static v a()
  {
    return y.a();
  }

  private v a(Activity paramActivity)
  {
    this.f = new WeakReference(paramActivity);
    return this;
  }

  public static void a(Context paramContext, u[] paramArrayOfu)
  {
    while (true)
    {
      int k;
      try
      {
        boolean bool = y.a().isInitialized();
        if (bool)
          return;
        v localv1 = y.a();
        localv1.e = r.b(paramContext);
        v localv2 = localv1.a(r.a(paramContext));
        int j = paramArrayOfu.length;
        k = 0;
        if (k < j)
        {
          u localu = paramArrayOfu[k];
          if (!localv2.i.containsKey(paramArrayOfu))
            localv2.i.putIfAbsent(localu.getClass(), localu);
        }
        else
        {
          localv2.a(paramContext);
          continue;
        }
      }
      finally
      {
      }
      k++;
    }
  }

  public final <T extends u> T a(Class<T> paramClass)
  {
    return (u)this.i.get(paramClass);
  }

  public final void a(q paramq)
  {
    this.b.set(paramq);
  }

  public final void a(String paramString)
  {
    this.g = paramString;
  }

  public final void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
    if (paramBoolean);
    for (int j = 3; ; j = 4)
    {
      this.h = j;
      return;
    }
  }

  public final q b()
  {
    Object localObject = (q)this.b.get();
    if (localObject == null)
    {
      localObject = new r();
      if (!this.b.compareAndSet(null, localObject))
        localObject = (q)this.b.get();
    }
    return localObject;
  }

  protected final void c()
  {
    Context localContext = getContext();
    this.d = new File(localContext.getFilesDir(), "com.crashlytics.sdk.android");
    if (!this.d.exists())
      this.d.mkdirs();
    if (Build.VERSION.SDK_INT >= 14)
      w.a(new w(this, (byte)0), this.e);
    if ((this.c) && (Log.isLoggable("CrashlyticsInternal", 3)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator2 = this.i.values().iterator();
      while (localIterator2.hasNext())
      {
        p localp = (p)localIterator2.next();
        long l = System.nanoTime();
        localp.a(localContext);
        localStringBuilder.append("sdkPerfStart.").append(localp.getClass().getName()).append('=').append(System.nanoTime() - l).append('\n');
      }
      Log.d("CrashlyticsInternal", localStringBuilder.toString());
    }
    while (true)
    {
      return;
      Iterator localIterator1 = this.i.values().iterator();
      while (localIterator1.hasNext())
        ((p)localIterator1.next()).a(localContext);
    }
  }

  public final Application d()
  {
    return this.e;
  }

  public final Activity e()
  {
    if (this.f != null)
      return (Activity)this.f.get();
    return null;
  }

  public final boolean f()
  {
    return this.c;
  }

  public final int g()
  {
    return this.h;
  }

  public final String getVersion()
  {
    return "1.1.13.29";
  }

  public final File h()
  {
    return this.d;
  }

  public final String i()
  {
    return this.g;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.internal.v
 * JD-Core Version:    0.6.2
 */