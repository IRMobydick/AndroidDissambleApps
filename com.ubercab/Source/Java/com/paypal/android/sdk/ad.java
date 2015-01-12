package com.paypal.android.sdk;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ad extends y
{
  private static final String a = ad.class.getSimpleName();
  private L b;
  private ThreadPoolExecutor c;
  private int d;

  public ad(L paramL, int paramInt)
  {
    this.b = paramL;
    this.d = paramInt;
    this.c = ((ThreadPoolExecutor)Executors.newCachedThreadPool());
  }

  public final boolean b(al paramal)
  {
    this.c.submit(new ae(this, paramal));
    return true;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.ad
 * JD-Core Version:    0.6.2
 */