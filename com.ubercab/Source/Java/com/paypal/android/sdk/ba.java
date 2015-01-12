package com.paypal.android.sdk;

import java.util.UUID;

public final class ba
{
  private static String a = null;
  private static long b = 0L;
  private static long c = 0L;

  public static void a()
  {
    try
    {
      a = UUID.randomUUID().toString();
      b = System.currentTimeMillis();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static void a(long paramLong)
  {
    try
    {
      c = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static String b()
  {
    try
    {
      if (a == null)
        a();
      String str = a;
      return str;
    }
    finally
    {
    }
  }

  public static boolean c()
  {
    try
    {
      long l1 = System.currentTimeMillis() - d();
      long l2 = c;
      if (l1 <= l2)
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
    finally
    {
    }
  }

  private static long d()
  {
    try
    {
      if (b == 0L)
        a();
      long l = b;
      return l;
    }
    finally
    {
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.ba
 * JD-Core Version:    0.6.2
 */