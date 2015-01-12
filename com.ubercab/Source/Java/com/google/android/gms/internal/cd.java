package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@ez
public final class cd
  implements by
{
  private final bz pL;
  private final v pM;

  public cd(bz parambz, v paramv)
  {
    this.pL = parambz;
    this.pM = paramv;
  }

  private static boolean b(Map<String, String> paramMap)
  {
    return "1".equals(paramMap.get("custom_close"));
  }

  private static int c(Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("o");
    if (str != null)
    {
      if ("p".equalsIgnoreCase(str))
        return gj.dm();
      if ("l".equalsIgnoreCase(str))
        return gj.dl();
    }
    return -1;
  }

  public void a(gv paramgv, Map<String, String> paramMap)
  {
    String str1 = (String)paramMap.get("a");
    if (str1 == null)
      gs.W("Action missing from an open GMSG.");
    gw localgw;
    String str2;
    String str3;
    do
    {
      return;
      if ((this.pM != null) && (!this.pM.av()))
      {
        this.pM.d((String)paramMap.get("u"));
        return;
      }
      localgw = paramgv.du();
      if ("expand".equalsIgnoreCase(str1))
      {
        if (paramgv.dy())
        {
          gs.W("Cannot expand WebView that is already expanded.");
          return;
        }
        localgw.a(b(paramMap), c(paramMap));
        return;
      }
      if ("webapp".equalsIgnoreCase(str1))
      {
        String str4 = (String)paramMap.get("u");
        if (str4 != null)
        {
          localgw.a(b(paramMap), c(paramMap), str4);
          return;
        }
        localgw.a(b(paramMap), c(paramMap), (String)paramMap.get("html"), (String)paramMap.get("baseurl"));
        return;
      }
      if (!"in_app_purchase".equalsIgnoreCase(str1))
        break;
      str2 = (String)paramMap.get("product_id");
      str3 = (String)paramMap.get("report_urls");
    }
    while (this.pL == null);
    if ((str3 != null) && (!str3.isEmpty()))
    {
      String[] arrayOfString = str3.split(" ");
      this.pL.a(str2, new ArrayList(Arrays.asList(arrayOfString)));
      return;
    }
    this.pL.a(str2, new ArrayList());
    return;
    localgw.a(new dj((String)paramMap.get("i"), (String)paramMap.get("u"), (String)paramMap.get("m"), (String)paramMap.get("p"), (String)paramMap.get("c"), (String)paramMap.get("f"), (String)paramMap.get("e")));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.cd
 * JD-Core Version:    0.6.2
 */