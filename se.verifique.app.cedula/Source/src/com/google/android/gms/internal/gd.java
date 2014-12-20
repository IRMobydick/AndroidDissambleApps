package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

class gd
{
  private final List a;
  private final List b;
  private final String c;
  private final String d;
  private final String e;
  private final String f;
  private final String g;
  private final boolean h;
  private final int i;

  public gd(Map paramMap)
  {
    this.g = ((String)paramMap.get("url"));
    this.d = ((String)paramMap.get("base_uri"));
    this.e = ((String)paramMap.get("post_parameters"));
    this.h = a((String)paramMap.get("drt_include"));
    this.c = ((String)paramMap.get("activation_overlay_url"));
    this.b = b((String)paramMap.get("check_packages"));
    this.i = c((String)paramMap.get("request_id"));
    this.f = ((String)paramMap.get("type"));
    this.a = b((String)paramMap.get("errors"));
  }

  private static boolean a(String paramString)
  {
    if ((paramString != null) && ((paramString.equals("1")) || (paramString.equals("true"))));
    for (int j = 1; ; j = 0)
      return j;
  }

  private List b(String paramString)
  {
    if (paramString == null);
    for (List localList = null; ; localList = Arrays.asList(paramString.split(",")))
      return localList;
  }

  private int c(String paramString)
  {
    if (paramString == null);
    for (int j = 0; ; j = Integer.parseInt(paramString))
      return j;
  }

  public List a()
  {
    return this.a;
  }

  public String b()
  {
    return this.e;
  }

  public String c()
  {
    return this.g;
  }

  public String d()
  {
    return this.f;
  }

  public boolean e()
  {
    return this.h;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gd
 * JD-Core Version:    0.6.0
 */