package com.google.android.gms.analytics;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

class q extends ae
{
  private static final Object yc = new Object();
  private static q yo;
  private Context mContext;
  private Handler mHandler;
  private d yd;
  private volatile f ye;
  private int yf = 1800;
  private boolean yg = true;
  private boolean yh;
  private String yi;
  private boolean yj = true;
  private boolean yk = true;
  private e yl = new e()
  {
    public void z(boolean paramAnonymousBoolean)
    {
      q.this.a(paramAnonymousBoolean, q.a(q.this));
    }
  };
  private p ym;
  private boolean yn = false;

  public static q dZ()
  {
    if (yo == null)
      yo = new q();
    return yo;
  }

  private void ea()
  {
    this.ym = new p(this);
    this.ym.z(this.mContext);
  }

  private void eb()
  {
    this.mHandler = new Handler(this.mContext.getMainLooper(), new Handler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        if ((1 == paramAnonymousMessage.what) && (q.ee().equals(paramAnonymousMessage.obj)))
        {
          t.ep().B(true);
          q.this.dispatchLocalHits();
          t.ep().B(false);
          if ((q.b(q.this) > 0) && (!q.c(q.this)))
            q.d(q.this).sendMessageDelayed(q.d(q.this).obtainMessage(1, q.ee()), 1000 * q.b(q.this));
        }
        return true;
      }
    });
    if (this.yf > 0)
      this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, yc), 1000 * this.yf);
  }

  void A(boolean paramBoolean)
  {
    try
    {
      a(this.yn, paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void a(Context paramContext, f paramf)
  {
    try
    {
      Context localContext = this.mContext;
      if (localContext != null);
      while (true)
      {
        return;
        this.mContext = paramContext.getApplicationContext();
        if (this.ye == null)
        {
          this.ye = paramf;
          if (this.yg)
          {
            dispatchLocalHits();
            this.yg = false;
          }
          if (this.yh)
          {
            dN();
            this.yh = false;
          }
        }
      }
    }
    finally
    {
    }
  }

  void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    while (true)
    {
      try
      {
        if (this.yn == paramBoolean1)
        {
          boolean bool = this.yj;
          if (bool == paramBoolean2)
            return;
        }
        if (((paramBoolean1) || (!paramBoolean2)) && (this.yf > 0))
          this.mHandler.removeMessages(1, yc);
        if ((!paramBoolean1) && (paramBoolean2) && (this.yf > 0))
          this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, yc), 1000 * this.yf);
        StringBuilder localStringBuilder = new StringBuilder().append("PowerSaveMode ");
        if (paramBoolean1)
          break label157;
        if (!paramBoolean2)
        {
          break label157;
          z.V(str);
          this.yn = paramBoolean1;
          this.yj = paramBoolean2;
          continue;
        }
      }
      finally
      {
      }
      String str = "terminated.";
      continue;
      label157: str = "initiated.";
    }
  }

  void dN()
  {
    if (this.ye == null)
    {
      z.V("setForceLocalDispatch() queued. It will be called once initialization is complete.");
      this.yh = true;
      return;
    }
    t.ep().a(t.a.Ak);
    this.ye.dN();
  }

  void dispatchLocalHits()
  {
    try
    {
      if (this.ye == null)
      {
        z.V("Dispatch call queued. Dispatch will run once initialization is complete.");
        this.yg = true;
      }
      while (true)
      {
        return;
        t.ep().a(t.a.zX);
        this.ye.dispatch();
      }
    }
    finally
    {
    }
  }

  d ec()
  {
    try
    {
      if (this.yd != null)
        break label80;
      if (this.mContext == null)
        throw new IllegalStateException("Cant get a store unless we have a context");
    }
    finally
    {
    }
    this.yd = new ab(this.yl, this.mContext);
    if (this.yi != null)
    {
      this.yd.dM().af(this.yi);
      this.yi = null;
    }
    label80: if (this.mHandler == null)
      eb();
    if ((this.ym == null) && (this.yk))
      ea();
    d locald = this.yd;
    return locald;
  }

  void ed()
  {
    try
    {
      if ((!this.yn) && (this.yj) && (this.yf > 0))
      {
        this.mHandler.removeMessages(1, yc);
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, yc));
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void setLocalDispatchPeriod(int paramInt)
  {
    try
    {
      if (this.mHandler == null)
      {
        z.V("Dispatch period set with null handler. Dispatch will run once initialization is complete.");
        this.yf = paramInt;
      }
      while (true)
      {
        return;
        t.ep().a(t.a.zY);
        if ((!this.yn) && (this.yj) && (this.yf > 0))
          this.mHandler.removeMessages(1, yc);
        this.yf = paramInt;
        if ((paramInt > 0) && (!this.yn) && (this.yj))
          this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, yc), paramInt * 1000);
      }
    }
    finally
    {
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.q
 * JD-Core Version:    0.6.2
 */