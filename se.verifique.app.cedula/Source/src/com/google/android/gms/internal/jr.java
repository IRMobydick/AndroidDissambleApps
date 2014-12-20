package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.g;
import java.util.ArrayList;

public abstract class jr
  implements kf
{
  public static final String[] d;
  private final Context a;
  final Handler b;
  boolean c = false;
  private final Looper e;
  private IInterface f;
  private final ArrayList g = new ArrayList();
  private jz h;
  private volatile int i = 1;
  private final String[] j;
  private final kd k;

  static
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "service_esmobile";
    arrayOfString[1] = "service_googleme";
    d = arrayOfString;
  }

  protected jr(Context paramContext, Looper paramLooper, com.google.android.gms.common.api.c paramc, com.google.android.gms.common.api.d paramd, String[] paramArrayOfString)
  {
    this.a = ((Context)kx.a(paramContext));
    this.e = ((Looper)kx.a(paramLooper, "Looper must not be null"));
    this.k = new kd(paramContext, paramLooper, this);
    this.b = new jt(this, paramLooper);
    a(paramArrayOfString);
    this.j = paramArrayOfString;
    a((com.google.android.gms.common.api.c)kx.a(paramc));
    a((com.google.android.gms.common.api.d)kx.a(paramd));
  }

  @Deprecated
  protected jr(Context paramContext, com.google.android.gms.common.c paramc, com.google.android.gms.common.d paramd, String[] paramArrayOfString)
  {
    this(paramContext, paramContext.getMainLooper(), new jx(paramc), new kb(paramd), paramArrayOfString);
  }

  private void a(int paramInt)
  {
    int m = this.i;
    this.i = paramInt;
    if (m != paramInt)
    {
      if (paramInt != 3)
        break label25;
      d();
    }
    while (true)
    {
      return;
      label25: if ((m == 3) && (paramInt == 1))
      {
        e();
        continue;
      }
    }
  }

  protected abstract String a();

  protected void a(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    this.b.sendMessage(this.b.obtainMessage(1, new kc(this, paramInt, paramIBinder, paramBundle)));
  }

  public void a(com.google.android.gms.common.api.c paramc)
  {
    this.k.a(paramc);
  }

  public void a(com.google.android.gms.common.api.d paramd)
  {
    this.k.a(paramd);
  }

  protected abstract void a(ko paramko, jy paramjy);

  protected void a(String[] paramArrayOfString)
  {
  }

  protected abstract IInterface b(IBinder paramIBinder);

  protected abstract String b();

  protected final void c(IBinder paramIBinder)
  {
    try
    {
      a(kq.a(paramIBinder), new jy(this));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        Log.w("GmsClient", "service died");
    }
  }

  protected void d()
  {
  }

  protected void e()
  {
  }

  public void f()
  {
    this.c = true;
    a(2);
    int m = g.a(this.a);
    if (m != 0)
    {
      a(1);
      this.b.sendMessage(this.b.obtainMessage(3, Integer.valueOf(m)));
    }
    while (true)
    {
      return;
      if (this.h != null)
      {
        Log.e("GmsClient", "Calling connect() while still connected, missing disconnect().");
        this.f = null;
        kg.a(this.a).b(a(), this.h);
      }
      this.h = new jz(this);
      if (kg.a(this.a).a(a(), this.h))
        continue;
      Log.e("GmsClient", "unable to connect to service: " + a());
      this.b.sendMessage(this.b.obtainMessage(3, Integer.valueOf(9)));
    }
  }

  public boolean g()
  {
    if (this.i == 3);
    for (int m = 1; ; m = 0)
      return m;
  }

  public boolean h()
  {
    if (this.i == 2);
    for (int m = 1; ; m = 0)
      return m;
  }

  public void i()
  {
    this.c = false;
    synchronized (this.g)
    {
      int m = this.g.size();
      for (int n = 0; n < m; n++)
        ((jv)this.g.get(n)).d();
      this.g.clear();
      a(1);
      this.f = null;
      if (this.h != null)
      {
        kg.a(this.a).b(a(), this.h);
        this.h = null;
      }
      return;
    }
  }

  public final Context j()
  {
    return this.a;
  }

  protected final void k()
  {
    if (!g())
      throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
  }

  public Bundle l()
  {
    return null;
  }

  public final IInterface m()
  {
    k();
    return this.f;
  }

  public boolean n()
  {
    return this.c;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jr
 * JD-Core Version:    0.6.0
 */