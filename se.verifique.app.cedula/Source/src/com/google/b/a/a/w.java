package com.google.b.a.a;

import android.content.Context;
import android.os.Handler;

public class w extends bd
{
  private static final Object a = new Object();
  private static w o;
  private Context b;
  private f c;
  private volatile h d;
  private int e = 1800;
  private boolean f = true;
  private boolean g;
  private String h;
  private boolean i = true;
  private boolean j = true;
  private g k = new x(this);
  private Handler l;
  private v m;
  private boolean n = false;

  public static w a()
  {
    if (o == null)
      o = new w();
    return o;
  }

  private void g()
  {
    this.m = new v(this);
    this.m.a(this.b);
  }

  private void h()
  {
    this.l = new Handler(this.b.getMainLooper(), new y(this));
    if (this.e > 0)
      this.l.sendMessageDelayed(this.l.obtainMessage(1, a), 1000 * this.e);
  }

  @Deprecated
  public void a(int paramInt)
  {
    monitorenter;
    try
    {
      if (this.l == null)
      {
        ar.c("Dispatch period set with null handler. Dispatch will run once initialization is complete.");
        this.e = paramInt;
      }
      while (true)
      {
        return;
        am.a().a(an.T);
        if ((!this.n) && (this.i) && (this.e > 0))
          this.l.removeMessages(1, a);
        this.e = paramInt;
        if ((paramInt <= 0) || (this.n) || (!this.i))
          continue;
        this.l.sendMessageDelayed(this.l.obtainMessage(1, a), paramInt * 1000);
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  void a(Context paramContext, h paramh)
  {
    monitorenter;
    try
    {
      Context localContext = this.b;
      if (localContext != null);
      while (true)
      {
        return;
        this.b = paramContext.getApplicationContext();
        if (this.d != null)
          continue;
        this.d = paramh;
        if (this.f)
        {
          c();
          this.f = false;
        }
        if (!this.g)
          continue;
        d();
        this.g = false;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  void a(boolean paramBoolean)
  {
    monitorenter;
    try
    {
      a(this.n, paramBoolean);
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

  void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    monitorenter;
    while (true)
    {
      try
      {
        if (this.n != paramBoolean1)
          continue;
        boolean bool = this.i;
        if (bool == paramBoolean2)
          return;
        if (((!paramBoolean1) && (paramBoolean2)) || (this.e <= 0))
          continue;
        this.l.removeMessages(1, a);
        if ((paramBoolean1) || (!paramBoolean2) || (this.e <= 0))
          continue;
        this.l.sendMessageDelayed(this.l.obtainMessage(1, a), 1000 * this.e);
        StringBuilder localStringBuilder = new StringBuilder().append("PowerSaveMode ");
        if (paramBoolean1)
          break label157;
        if (!paramBoolean2)
        {
          break label157;
          ar.c(str);
          this.n = paramBoolean1;
          this.i = paramBoolean2;
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      String str = "terminated.";
      continue;
      label157: str = "initiated.";
    }
  }

  f b()
  {
    monitorenter;
    try
    {
      if (this.c != null)
        break label80;
      if (this.b == null)
        throw new IllegalStateException("Cant get a store unless we have a context");
    }
    finally
    {
      monitorexit;
    }
    this.c = new ax(this.k, this.b);
    if (this.h != null)
    {
      this.c.b().a(this.h);
      this.h = null;
    }
    label80: if (this.l == null)
      h();
    if ((this.m == null) && (this.j))
      g();
    f localf = this.c;
    monitorexit;
    return localf;
  }

  @Deprecated
  public void c()
  {
    monitorenter;
    try
    {
      if (this.d == null)
      {
        ar.c("Dispatch call queued. Dispatch will run once initialization is complete.");
        this.f = true;
      }
      while (true)
      {
        return;
        am.a().a(an.S);
        this.d.a();
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  @Deprecated
  public void d()
  {
    if (this.d == null)
    {
      ar.c("setForceLocalDispatch() queued. It will be called once initialization is complete.");
      this.g = true;
    }
    while (true)
    {
      return;
      am.a().a(an.af);
      this.d.b();
    }
  }

  void e()
  {
    monitorenter;
    try
    {
      if ((!this.n) && (this.i) && (this.e > 0))
      {
        this.l.removeMessages(1, a);
        this.l.sendMessage(this.l.obtainMessage(1, a));
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
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.b.a.a.w
 * JD-Core Version:    0.6.0
 */