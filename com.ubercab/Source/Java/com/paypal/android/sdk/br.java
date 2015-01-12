package com.paypal.android.sdk;

import java.util.Locale;

public final class br
  implements h
{
  private static volatile br a;

  public static br d()
  {
    if (a == null);
    try
    {
      if (a == null)
        a = new br();
      return a;
    }
    finally
    {
    }
  }

  public final j a()
  {
    return b();
  }

  public final String a(String paramString)
  {
    return paramString;
  }

  public final j b()
  {
    return new j(Locale.getDefault().getCountry());
  }

  public final Locale c()
  {
    return Locale.getDefault();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.br
 * JD-Core Version:    0.6.2
 */