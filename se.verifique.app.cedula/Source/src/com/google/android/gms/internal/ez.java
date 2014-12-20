package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

public class ez
  implements Runnable
{
  protected final hk a;
  protected boolean b;
  protected boolean c;
  private final Handler d;
  private final long e;
  private long f;
  private ho g;
  private final int h;
  private final int i;

  public ez(ho paramho, hk paramhk, int paramInt1, int paramInt2)
  {
    this(paramho, paramhk, paramInt1, paramInt2, 200L, 50L);
  }

  public ez(ho paramho, hk paramhk, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    this.e = paramLong1;
    this.f = paramLong2;
    this.d = new Handler(Looper.getMainLooper());
    this.a = paramhk;
    this.g = paramho;
    this.b = false;
    this.c = false;
    this.h = paramInt2;
    this.i = paramInt1;
  }

  public void a()
  {
    this.d.postDelayed(this, this.e);
  }

  public void a(du paramdu)
  {
    a(paramdu, new iu(this, this.a, paramdu.r));
  }

  public void a(du paramdu, iu paramiu)
  {
    this.a.setWebViewClient(paramiu);
    hk localhk = this.a;
    if (TextUtils.isEmpty(paramdu.c));
    for (String str = null; ; str = gw.a(paramdu.c))
    {
      localhk.loadDataWithBaseURL(str, paramdu.d, "text/html", "UTF-8", null);
      return;
    }
  }

  public void b()
  {
    monitorenter;
    try
    {
      this.b = true;
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

  public boolean c()
  {
    monitorenter;
    try
    {
      boolean bool = this.b;
      monitorexit;
      return bool;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public boolean d()
  {
    return this.c;
  }

  public void run()
  {
    if ((this.a == null) || (c()))
      this.g.a(this.a);
    while (true)
    {
      return;
      new fa(this, this.a).execute(new Void[0]);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ez
 * JD-Core Version:    0.6.0
 */