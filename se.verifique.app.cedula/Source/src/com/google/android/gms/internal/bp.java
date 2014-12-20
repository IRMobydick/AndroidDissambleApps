package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.a.d;
import com.google.android.gms.ads.c.a.a;

public final class bp
  implements bs
{
  private final String a;
  private final bv b;
  private final long c;
  private final bl d;
  private final ai e;
  private final al f;
  private final Context g;
  private final Object h = new Object();
  private final ev i;
  private by j;
  private int k = -2;

  public bp(Context paramContext, String paramString, bv parambv, bm parambm, bl parambl, ai paramai, al paramal, ev paramev)
  {
    this.g = paramContext;
    long l;
    if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(paramString))
    {
      this.a = a(parambl);
      this.b = parambv;
      if (parambm.b == -1L)
        break label108;
      l = parambm.b;
    }
    while (true)
    {
      this.c = l;
      this.d = parambl;
      this.e = paramai;
      this.f = paramal;
      this.i = paramev;
      return;
      this.a = paramString;
      break;
      label108: l = 10000L;
    }
  }

  private String a(bl parambl)
  {
    try
    {
      if ((!TextUtils.isEmpty(parambl.e)) && (a.class.isAssignableFrom(Class.forName(parambl.e, false, bp.class.getClassLoader()))))
      {
        str = "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter";
        return str;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      while (true)
      {
        hi.e("Could not create custom event adapter.");
        String str = "com.google.ads.mediation.customevent.CustomEventAdapter";
      }
    }
  }

  private void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    while (true)
    {
      if (this.k != -2)
        return;
      b(paramLong1, paramLong2, paramLong3, paramLong4);
    }
  }

  private void a(bo parambo)
  {
    try
    {
      if (this.i.e < 4100000)
      {
        if (this.f.f)
        {
          this.j.a(d.a(this.g), this.e, this.d.g, parambo);
          return;
        }
        this.j.a(d.a(this.g), this.f, this.e, this.d.g, parambo);
      }
    }
    catch (RemoteException localRemoteException)
    {
      hi.c("Could not request ad from mediation adapter.", localRemoteException);
      a(5);
    }
    if (this.f.f)
      this.j.a(d.a(this.g), this.e, this.d.g, this.d.a, parambo);
    else
      this.j.a(d.a(this.g), this.f, this.e, this.d.g, this.d.a, parambo);
  }

  private by b()
  {
    hi.c("Instantiating mediation adapter: " + this.a);
    try
    {
      by localby2 = this.b.a(this.a);
      localby1 = localby2;
      return localby1;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
      {
        hi.a("Could not instantiate mediation adapter: " + this.a, localRemoteException);
        by localby1 = null;
      }
    }
  }

  private void b(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    long l1 = SystemClock.elapsedRealtime();
    long l2 = paramLong2 - (l1 - paramLong1);
    long l3 = paramLong4 - (l1 - paramLong3);
    if ((l2 <= 0L) || (l3 <= 0L))
    {
      hi.c("Timed out waiting for adapter.");
      this.k = 3;
    }
    while (true)
    {
      return;
      try
      {
        this.h.wait(Math.min(l2, l3));
      }
      catch (InterruptedException localInterruptedException)
      {
        this.k = -1;
      }
    }
  }

  public br a(long paramLong1, long paramLong2)
  {
    synchronized (this.h)
    {
      long l = SystemClock.elapsedRealtime();
      bo localbo = new bo();
      hh.a.post(new bq(this, localbo));
      a(l, this.c, paramLong1, paramLong2);
      br localbr = new br(this.d, this.j, this.a, localbo, this.k);
      return localbr;
    }
  }

  public void a()
  {
    synchronized (this.h)
    {
      try
      {
        if (this.j != null)
          this.j.c();
        this.k = -1;
        this.h.notify();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        while (true)
          hi.c("Could not destroy mediation adapter.", localRemoteException);
      }
    }
  }

  public void a(int paramInt)
  {
    synchronized (this.h)
    {
      this.k = paramInt;
      this.h.notify();
      return;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.bp
 * JD-Core Version:    0.6.0
 */