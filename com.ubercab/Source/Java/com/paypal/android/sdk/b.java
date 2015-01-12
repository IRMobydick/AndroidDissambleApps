package com.paypal.android.sdk;

import android.content.Context;

public class b
{
  private static volatile b a;
  private Context b;
  private c c;

  public static b a()
  {
    if (a == null);
    try
    {
      if (a == null)
        a = new b();
      return a;
    }
    finally
    {
    }
  }

  public final void a(Context paramContext, String paramString)
  {
    this.b = paramContext;
    this.c = new c(paramContext, paramString);
  }

  public final Context b()
  {
    return this.b;
  }

  public final c c()
  {
    return this.c;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.b
 * JD-Core Version:    0.6.2
 */