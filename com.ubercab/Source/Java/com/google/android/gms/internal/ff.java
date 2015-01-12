package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesUtil;

@ez
public final class ff
{
  public static gg a(Context paramContext, fi paramfi, a parama)
  {
    if (paramfi.lD.wG)
      return b(paramContext, paramfi, parama);
    return c(paramContext, paramfi, parama);
  }

  private static gg b(Context paramContext, fi paramfi, a parama)
  {
    gs.S("Fetching ad response from local ad request service.");
    fg.a locala = new fg.a(paramContext, paramfi, parama);
    locala.start();
    return locala;
  }

  private static gg c(Context paramContext, fi paramfi, a parama)
  {
    gs.S("Fetching ad response from remote ad request service.");
    if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramContext) != 0)
    {
      gs.W("Failed to connect to remote ad request service.");
      return null;
    }
    return new fg.b(paramContext, paramfi, parama);
  }

  public static abstract interface a
  {
    public abstract void a(fk paramfk);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ff
 * JD-Core Version:    0.6.2
 */