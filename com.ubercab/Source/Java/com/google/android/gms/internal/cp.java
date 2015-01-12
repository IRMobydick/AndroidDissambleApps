package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.dynamic.e;

@ez
public final class cp
  implements cq.a
{
  private final ct lq;
  private final Context mContext;
  private final av ml;
  private final Object mw = new Object();
  private final String qo;
  private final long qp;
  private final cl qq;
  private final ay qr;
  private final gt qs;
  private cu qt;
  private int qu = -2;

  public cp(Context paramContext, String paramString, ct paramct, cm paramcm, cl paramcl, av paramav, ay paramay, gt paramgt)
  {
    this.mContext = paramContext;
    this.lq = paramct;
    this.qq = paramcl;
    if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(paramString))
    {
      this.qo = bE();
      if (paramcm.qe == -1L)
        break label106;
    }
    label106: for (long l = paramcm.qe; ; l = 10000L)
    {
      this.qp = l;
      this.ml = paramav;
      this.qr = paramay;
      this.qs = paramgt;
      return;
      this.qo = paramString;
      break;
    }
  }

  private void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    while (true)
    {
      if (this.qu != -2)
        return;
      b(paramLong1, paramLong2, paramLong3, paramLong4);
    }
  }

  private void a(co paramco)
  {
    try
    {
      if (this.qs.wF < 4100000)
      {
        if (this.qr.og)
        {
          this.qt.a(e.k(this.mContext), this.ml, this.qq.qc, paramco);
          return;
        }
        this.qt.a(e.k(this.mContext), this.qr, this.ml, this.qq.qc, paramco);
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      gs.d("Could not request ad from mediation adapter.", localRemoteException);
      j(5);
      return;
    }
    if (this.qr.og)
    {
      this.qt.a(e.k(this.mContext), this.ml, this.qq.qc, this.qq.pW, paramco);
      return;
    }
    this.qt.a(e.k(this.mContext), this.qr, this.ml, this.qq.qc, this.qq.pW, paramco);
  }

  private void b(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    long l1 = SystemClock.elapsedRealtime();
    long l2 = paramLong2 - (l1 - paramLong1);
    long l3 = paramLong4 - (l1 - paramLong3);
    if ((l2 <= 0L) || (l3 <= 0L))
    {
      gs.U("Timed out waiting for adapter.");
      this.qu = 3;
      return;
    }
    try
    {
      this.mw.wait(Math.min(l2, l3));
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      this.qu = -1;
    }
  }

  private String bE()
  {
    try
    {
      if (!TextUtils.isEmpty(this.qq.qa))
      {
        if (this.lq.y(this.qq.qa))
          return "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter";
        return "com.google.ads.mediation.customevent.CustomEventAdapter";
      }
    }
    catch (RemoteException localRemoteException)
    {
      gs.W("Fail to determine the custom event's version, assuming the old one.");
    }
    return "com.google.ads.mediation.customevent.CustomEventAdapter";
  }

  private cu bF()
  {
    gs.U("Instantiating mediation adapter: " + this.qo);
    try
    {
      cu localcu = this.lq.x(this.qo);
      return localcu;
    }
    catch (RemoteException localRemoteException)
    {
      gs.a("Could not instantiate mediation adapter: " + this.qo, localRemoteException);
    }
    return null;
  }

  public cq b(long paramLong1, long paramLong2)
  {
    synchronized (this.mw)
    {
      long l = SystemClock.elapsedRealtime();
      final co localco = new co();
      gr.wC.post(new Runnable()
      {
        public void run()
        {
          synchronized (cp.a(cp.this))
          {
            if (cp.b(cp.this) != -2)
              return;
            cp.a(cp.this, cp.c(cp.this));
            if (cp.d(cp.this) == null)
            {
              cp.this.j(4);
              return;
            }
          }
          localco.a(cp.this);
          cp.a(cp.this, localco);
        }
      });
      a(l, this.qp, paramLong1, paramLong2);
      cq localcq = new cq(this.qq, this.qt, this.qo, localco, this.qu);
      return localcq;
    }
  }

  public void cancel()
  {
    synchronized (this.mw)
    {
      try
      {
        if (this.qt != null)
          this.qt.destroy();
        this.qu = -1;
        this.mw.notify();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        while (true)
          gs.d("Could not destroy mediation adapter.", localRemoteException);
      }
    }
  }

  public void j(int paramInt)
  {
    synchronized (this.mw)
    {
      this.qu = paramInt;
      this.mw.notify();
      return;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.cp
 * JD-Core Version:    0.6.2
 */