package com.google.b.a.a;

import android.content.Context;
import android.content.Intent;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Timer;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

class z
  implements be, d, e
{
  private volatile long a;
  private volatile ad b;
  private volatile a c;
  private f d;
  private f e;
  private final ao f;
  private final h g;
  private final Context h;
  private final Queue i = new ConcurrentLinkedQueue();
  private volatile int j;
  private volatile Timer k;
  private volatile Timer l;
  private volatile Timer m;
  private boolean n;
  private boolean o;
  private boolean p;
  private boolean q;
  private l r;
  private long s = 300000L;

  z(Context paramContext, h paramh)
  {
    this(paramContext, paramh, null, ao.a(paramContext));
  }

  z(Context paramContext, h paramh, f paramf, ao paramao)
  {
    this.e = paramf;
    this.h = paramContext;
    this.g = paramh;
    this.f = paramao;
    this.r = new aa(this);
    this.j = 0;
    this.b = ad.g;
  }

  private Timer a(Timer paramTimer)
  {
    if (paramTimer != null)
      paramTimer.cancel();
    return null;
  }

  private void g()
  {
    this.k = a(this.k);
    this.l = a(this.l);
    this.m = a(this.m);
  }

  private void h()
  {
    monitorenter;
    while (true)
    {
      try
      {
        if (Thread.currentThread().equals(this.g.d()))
          continue;
        this.g.c().add(new ab(this));
        return;
        if (!this.o)
          continue;
        d();
        switch (ac.a[this.b.ordinal()])
        {
        case 1:
          if (!this.i.isEmpty())
          {
            ag localag2 = (ag)this.i.poll();
            ar.c("Sending hit to store  " + localag2);
            this.d.a(localag2.a(), localag2.b(), localag2.c(), localag2.d());
            continue;
          }
        case 2:
        case 6:
        case 3:
        case 4:
        case 5:
        }
      }
      finally
      {
        monitorexit;
      }
      if (!this.n)
        continue;
      i();
      continue;
      if (!this.i.isEmpty())
      {
        ag localag1 = (ag)this.i.peek();
        ar.c("Sending hit to service   " + localag1);
        if (!this.f.b())
          this.c.a(localag1.a(), localag1.b(), localag1.c(), localag1.d());
        while (true)
        {
          this.i.poll();
          break;
          ar.c("Dry run enabled. Hit not actually sent to service.");
        }
      }
      this.a = this.r.a();
      continue;
      ar.c("Need to reconnect");
      if (this.i.isEmpty())
        continue;
      k();
      continue;
    }
  }

  private void i()
  {
    this.d.a();
    this.n = false;
  }

  private void j()
  {
    monitorenter;
    while (true)
    {
      try
      {
        ad localad1 = this.b;
        ad localad2 = ad.c;
        if (localad1 == localad2)
          return;
        g();
        ar.c("falling back to local store");
        if (this.e != null)
        {
          this.d = this.e;
          this.b = ad.c;
          h();
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      w localw = w.a();
      localw.a(this.h, this.g);
      this.d = localw.b();
    }
  }

  private void k()
  {
    monitorenter;
    while (true)
    {
      try
      {
        if ((!this.q) && (this.c != null))
        {
          ad localad1 = this.b;
          ad localad2 = ad.c;
          if (localad1 != localad2)
            try
            {
              this.j = (1 + this.j);
              a(this.l);
              this.b = ad.a;
              this.l = new Timer("Failed Connect");
              this.l.schedule(new af(this, null), 3000L);
              ar.c("connecting to Analytics service");
              this.c.b();
              monitorexit;
              return;
            }
            catch (SecurityException localSecurityException)
            {
              ar.d("security exception on connectToService");
              j();
              continue;
            }
        }
      }
      finally
      {
        monitorexit;
      }
      ar.d("client not initialized.");
      j();
    }
  }

  private void l()
  {
    monitorenter;
    try
    {
      if ((this.c != null) && (this.b == ad.b))
      {
        this.b = ad.f;
        this.c.c();
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

  private void m()
  {
    this.k = a(this.k);
    this.k = new Timer("Service Reconnect");
    this.k.schedule(new ah(this, null), 5000L);
  }

  public void a()
  {
    monitorenter;
    try
    {
      this.l = a(this.l);
      this.j = 0;
      ar.c("Connected to service");
      this.b = ad.b;
      if (this.p)
      {
        l();
        this.p = false;
      }
      while (true)
      {
        return;
        h();
        this.m = a(this.m);
        this.m = new Timer("disconnect check");
        this.m.schedule(new ae(this, null), this.s);
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void a(int paramInt, Intent paramIntent)
  {
    monitorenter;
    try
    {
      this.b = ad.e;
      if (this.j < 2)
      {
        ar.d("Service unavailable (code=" + paramInt + "), will retry.");
        m();
      }
      while (true)
      {
        return;
        ar.d("Service unavailable (code=" + paramInt + "), using local store.");
        j();
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void a(Map paramMap, long paramLong, String paramString, List paramList)
  {
    ar.c("putHit called");
    this.i.add(new ag(paramMap, paramLong, paramString, paramList));
    h();
  }

  public void b()
  {
    monitorenter;
    while (true)
    {
      try
      {
        if (this.b != ad.f)
          continue;
        ar.c("Disconnected from service");
        g();
        this.b = ad.g;
        return;
        ar.c("Unexpected disconnect.");
        this.b = ad.e;
        if (this.j < 2)
        {
          m();
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      j();
    }
  }

  public void c()
  {
    switch (ac.a[this.b.ordinal()])
    {
    default:
      this.n = true;
    case 2:
    case 1:
    }
    while (true)
    {
      return;
      i();
    }
  }

  public void d()
  {
    ar.c("clearHits called");
    this.i.clear();
    switch (ac.a[this.b.ordinal()])
    {
    default:
      this.o = true;
    case 1:
    case 2:
    }
    while (true)
    {
      return;
      this.d.a(0L);
      this.o = false;
      continue;
      this.c.a();
      this.o = false;
    }
  }

  public void e()
  {
    monitorenter;
    while (true)
    {
      try
      {
        boolean bool = this.q;
        if (bool)
          return;
        ar.c("setForceLocalDispatch called.");
        this.q = true;
        switch (ac.a[this.b.ordinal()])
        {
        case 1:
        case 4:
        case 5:
        case 6:
        case 2:
          l();
          continue;
        case 3:
        }
      }
      finally
      {
        monitorexit;
      }
      this.p = true;
      continue;
    }
  }

  public void f()
  {
    if (this.c != null);
    while (true)
    {
      return;
      this.c = new b(this.h, this, this);
      k();
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.b.a.a.z
 * JD-Core Version:    0.6.0
 */