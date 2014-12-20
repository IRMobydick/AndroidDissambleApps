package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public final class bf
  implements bb
{
  private final bc a;

  public bf(bc parambc)
  {
    this.a = parambc;
  }

  private static boolean a(Map paramMap)
  {
    return "1".equals(paramMap.get("custom_close"));
  }

  private static int b(Map paramMap)
  {
    String str = (String)paramMap.get("o");
    int i;
    if (str != null)
      if ("p".equalsIgnoreCase(str))
        i = gw.c();
    while (true)
    {
      return i;
      if ("l".equalsIgnoreCase(str))
      {
        i = gw.b();
        continue;
      }
      i = -1;
    }
  }

  public void a(hk paramhk, Map paramMap)
  {
    String str1 = (String)paramMap.get("a");
    if (str1 == null)
      hi.e("Action missing from an open GMSG.");
    while (true)
    {
      return;
      hm localhm = paramhk.f();
      if ("expand".equalsIgnoreCase(str1))
      {
        if (paramhk.i())
        {
          hi.e("Cannot expand WebView that is already expanded.");
          continue;
        }
        localhm.a(a(paramMap), b(paramMap));
        continue;
      }
      if ("webapp".equalsIgnoreCase(str1))
      {
        String str4 = (String)paramMap.get("u");
        if (str4 != null)
        {
          localhm.a(a(paramMap), b(paramMap), str4);
          continue;
        }
        localhm.a(a(paramMap), b(paramMap), (String)paramMap.get("html"), (String)paramMap.get("baseurl"));
        continue;
      }
      if ("in_app_purchase".equalsIgnoreCase(str1))
      {
        String str2 = (String)paramMap.get("product_id");
        String str3 = (String)paramMap.get("report_urls");
        if (this.a == null)
          continue;
        if ((str3 != null) && (!str3.isEmpty()))
        {
          String[] arrayOfString = str3.split(" ");
          this.a.a(str2, new ArrayList(Arrays.asList(arrayOfString)));
          continue;
        }
        this.a.a(str2, new ArrayList());
        continue;
      }
      localhm.a(new ce((String)paramMap.get("i"), (String)paramMap.get("u"), (String)paramMap.get("m"), (String)paramMap.get("p"), (String)paramMap.get("c"), (String)paramMap.get("f"), (String)paramMap.get("e")));
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.bf
 * JD-Core Version:    0.6.0
 */