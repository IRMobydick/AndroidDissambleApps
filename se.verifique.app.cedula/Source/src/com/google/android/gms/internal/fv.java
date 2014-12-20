package com.google.android.gms.internal;

import android.content.Context;

final class fv
  implements Runnable
{
  fv(Context paramContext, ds paramds, fy paramfy, ho paramho, String paramString)
  {
  }

  public void run()
  {
    hk localhk = hk.a(this.a, new al(), false, false, null, this.b.l);
    localhk.setWillNotDraw(true);
    this.c.a(localhk);
    hm localhm = localhk.f();
    localhm.a("/invalidRequest", this.c.a);
    localhm.a("/loadAdURL", this.c.b);
    localhm.a("/log", ar.g);
    localhm.a(this.d);
    hi.a("Loading the JS library.");
    localhk.loadUrl(this.e);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fv
 * JD-Core Version:    0.6.0
 */