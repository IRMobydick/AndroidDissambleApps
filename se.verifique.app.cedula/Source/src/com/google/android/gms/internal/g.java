package com.google.android.gms.internal;

import java.util.Map;

class g
  implements bb
{
  g(c paramc)
  {
  }

  public void a(hk paramhk, Map paramMap)
  {
    if ((paramMap.containsKey("pingType")) && ("unloadPing".equals(paramMap.get("pingType"))))
    {
      this.a.c(c.a(this.a));
      hi.c("Unregistered GMSG handlers for: " + c.b(this.a).d());
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.g
 * JD-Core Version:    0.6.0
 */