package com.google.android.gms.internal;

import java.util.Map;

class fz
  implements bb
{
  fz(fy paramfy)
  {
  }

  public void a(hk paramhk, Map paramMap)
  {
    synchronized (fy.a(this.a))
    {
      gd localgd = new gd(paramMap);
      hi.e("Invalid " + localgd.d() + " request error: " + localgd.a());
      fy.a(this.a, 1);
      fy.a(this.a).notify();
      return;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fz
 * JD-Core Version:    0.6.0
 */