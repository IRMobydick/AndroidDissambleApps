package com.google.android.gms.internal;

import java.util.Map;

final class ax
  implements bb
{
  public void a(hk paramhk, Map paramMap)
  {
    co localco = paramhk.d();
    if (localco == null)
      hi.e("A GMSG tried to use a custom close button on something that wasn't an overlay.");
    while (true)
    {
      return;
      localco.b("1".equals(paramMap.get("custom_close")));
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ax
 * JD-Core Version:    0.6.0
 */