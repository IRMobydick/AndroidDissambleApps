package com.google.android.gms.internal;

import java.util.Map;

final class ay
  implements bb
{
  public void a(hk paramhk, Map paramMap)
  {
    String str = (String)paramMap.get("u");
    if (str == null)
      hi.e("URL missing from httpTrack GMSG.");
    while (true)
    {
      return;
      new hg(paramhk.getContext(), paramhk.h().c, str).e();
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ay
 * JD-Core Version:    0.6.0
 */