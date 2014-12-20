package com.google.android.gms.internal;

import java.util.Map;

final class ba
  implements bb
{
  public void a(hk paramhk, Map paramMap)
  {
    String str1 = (String)paramMap.get("tx");
    String str2 = (String)paramMap.get("ty");
    String str3 = (String)paramMap.get("td");
    try
    {
      int i = Integer.parseInt(str1);
      int j = Integer.parseInt(str2);
      int k = Integer.parseInt(str3);
      mw localmw = paramhk.g();
      if (localmw != null)
        localmw.a().a(i, j, k);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (true)
        hi.e("Could not parse touch parameters from gmsg.");
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ba
 * JD-Core Version:    0.6.0
 */