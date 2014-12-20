package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class gc
{
  private String a;
  private String b;
  private String c;
  private List d;
  private String e;
  private String f;
  private List g;
  private long h = -1L;
  private boolean i = false;
  private final long j = -1L;
  private List k;
  private long l = -1L;
  private int m = -1;

  private static String a(Map paramMap, String paramString)
  {
    List localList = (List)paramMap.get(paramString);
    if ((localList != null) && (!localList.isEmpty()));
    for (String str = (String)localList.get(0); ; str = null)
      return str;
  }

  private static long b(Map paramMap, String paramString)
  {
    List localList = (List)paramMap.get(paramString);
    String str;
    if ((localList != null) && (!localList.isEmpty()))
      str = (String)localList.get(0);
    while (true)
    {
      try
      {
        float f1 = Float.parseFloat(str);
        l1 = ()(f1 * 1000.0F);
        return l1;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        hi.e("Could not parse float from " + paramString + " header: " + str);
      }
      long l1 = -1L;
    }
  }

  private void b(Map paramMap)
  {
    this.a = a(paramMap, "X-Afma-Ad-Size");
  }

  private static List c(Map paramMap, String paramString)
  {
    List localList1 = (List)paramMap.get(paramString);
    String str;
    if ((localList1 != null) && (!localList1.isEmpty()))
    {
      str = (String)localList1.get(0);
      if (str == null);
    }
    for (List localList2 = Arrays.asList(str.trim().split("\\s+")); ; localList2 = null)
      return localList2;
  }

  private void c(Map paramMap)
  {
    List localList = c(paramMap, "X-Afma-Click-Tracking-Urls");
    if (localList != null)
      this.d = localList;
  }

  private void d(Map paramMap)
  {
    List localList = (List)paramMap.get("X-Afma-Debug-Dialog");
    if ((localList != null) && (!localList.isEmpty()))
      this.e = ((String)localList.get(0));
  }

  private void e(Map paramMap)
  {
    List localList = c(paramMap, "X-Afma-Tracking-Urls");
    if (localList != null)
      this.g = localList;
  }

  private void f(Map paramMap)
  {
    long l1 = b(paramMap, "X-Afma-Interstitial-Timeout");
    if (l1 != -1L)
      this.h = l1;
  }

  private void g(Map paramMap)
  {
    this.f = a(paramMap, "X-Afma-ActiveView");
  }

  private void h(Map paramMap)
  {
    List localList = (List)paramMap.get("X-Afma-Mediation");
    if ((localList != null) && (!localList.isEmpty()))
      this.i = Boolean.valueOf((String)localList.get(0)).booleanValue();
  }

  private void i(Map paramMap)
  {
    List localList = c(paramMap, "X-Afma-Manual-Tracking-Urls");
    if (localList != null)
      this.k = localList;
  }

  private void j(Map paramMap)
  {
    long l1 = b(paramMap, "X-Afma-Refresh-Rate");
    if (l1 != -1L)
      this.l = l1;
  }

  private void k(Map paramMap)
  {
    List localList = (List)paramMap.get("X-Afma-Orientation");
    String str;
    if ((localList != null) && (!localList.isEmpty()))
    {
      str = (String)localList.get(0);
      if (!"portrait".equalsIgnoreCase(str))
        break label53;
      this.m = gw.c();
    }
    while (true)
    {
      return;
      label53: if ("landscape".equalsIgnoreCase(str))
      {
        this.m = gw.b();
        continue;
      }
    }
  }

  public du a(long paramLong)
  {
    return new du(this.b, this.c, this.d, this.g, this.h, this.i, -1L, this.k, this.l, this.m, this.a, paramLong, this.e, this.f);
  }

  public void a(String paramString1, Map paramMap, String paramString2)
  {
    this.b = paramString1;
    this.c = paramString2;
    a(paramMap);
  }

  public void a(Map paramMap)
  {
    b(paramMap);
    c(paramMap);
    d(paramMap);
    e(paramMap);
    f(paramMap);
    h(paramMap);
    i(paramMap);
    j(paramMap);
    k(paramMap);
    g(paramMap);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gc
 * JD-Core Version:    0.6.0
 */