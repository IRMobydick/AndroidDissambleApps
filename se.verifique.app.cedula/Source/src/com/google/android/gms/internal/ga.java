package com.google.android.gms.internal;

import java.util.Map;

class ga
  implements bb
{
  ga(fy paramfy)
  {
  }

  public void a(hk paramhk, Map paramMap)
  {
    synchronized (fy.a(this.a))
    {
      gd localgd = new gd(paramMap);
      String str1 = localgd.c();
      if (str1 == null)
      {
        hi.e("URL missing in loadAdUrl GMSG.");
      }
      else
      {
        if (str1.contains("%40mediation_adapters%40"))
        {
          String str2 = str1.replaceAll("%40mediation_adapters%40", gq.a(paramhk.getContext(), (String)paramMap.get("check_adapters"), fy.b(this.a)));
          hi.d("Ad request URL modified to " + str2);
        }
        fy.a(this.a, localgd);
        fy.a(this.a).notify();
      }
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ga
 * JD-Core Version:    0.6.0
 */