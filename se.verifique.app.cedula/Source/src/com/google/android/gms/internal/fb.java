package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.g;

public final class fb
{
  public static gr a(Context paramContext, ds paramds, fc paramfc)
  {
    if (paramds.l.f);
    for (gr localgr = b(paramContext, paramds, paramfc); ; localgr = c(paramContext, paramds, paramfc))
      return localgr;
  }

  private static gr b(Context paramContext, ds paramds, fc paramfc)
  {
    hi.a("Fetching ad response from local ad request service.");
    ff localff = new ff(paramContext, paramds, paramfc);
    localff.e();
    return localff;
  }

  private static gr c(Context paramContext, ds paramds, fc paramfc)
  {
    hi.a("Fetching ad response from remote ad request service.");
    if (g.a(paramContext) != 0)
      hi.e("Failed to connect to remote ad request service.");
    for (fh localfh = null; ; localfh = new fh(paramContext, paramds, paramfc))
      return localfh;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fb
 * JD-Core Version:    0.6.0
 */