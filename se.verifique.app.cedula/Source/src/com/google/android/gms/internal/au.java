package com.google.android.gms.internal;

import android.net.Uri;
import java.util.Map;

final class au
  implements bb
{
  public void a(hk paramhk, Map paramMap)
  {
    String str1 = (String)paramMap.get("u");
    if (str1 == null)
      hi.e("URL missing from click GMSG.");
    while (true)
    {
      return;
      Uri localUri1 = Uri.parse(str1);
      try
      {
        mw localmw = paramhk.g();
        if ((localmw != null) && (localmw.b(localUri1)))
        {
          Uri localUri3 = localmw.a(localUri1, paramhk.getContext());
          localUri2 = localUri3;
          String str2 = localUri2.toString();
          new hg(paramhk.getContext(), paramhk.h().c, str2).e();
        }
      }
      catch (nh localnh)
      {
        while (true)
        {
          hi.e("Unable to append parameter to URL: " + str1);
          Uri localUri2 = localUri1;
        }
      }
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.au
 * JD-Core Version:    0.6.0
 */