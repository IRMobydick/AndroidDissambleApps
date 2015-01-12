package com.google.android.gms.internal;

import java.util.Map;
import java.util.concurrent.Future;

@ez
public final class ft
{
  private gv md;
  private final Object mw = new Object();
  private String uq;
  private gk<fv> ur = new gk();
  public final by us = new by()
  {
    public void a(gv paramAnonymousgv, Map<String, String> paramAnonymousMap)
    {
      synchronized (ft.a(ft.this))
      {
        if (ft.b(ft.this).isDone())
          return;
        fv localfv = new fv(1, paramAnonymousMap);
        gs.W("Invalid " + localfv.getType() + " request error: " + localfv.cL());
        ft.b(ft.this).a(localfv);
        return;
      }
    }
  };
  public final by ut = new by()
  {
    public void a(gv paramAnonymousgv, Map<String, String> paramAnonymousMap)
    {
      fv localfv;
      String str1;
      synchronized (ft.a(ft.this))
      {
        if (ft.b(ft.this).isDone())
          return;
        localfv = new fv(-2, paramAnonymousMap);
        str1 = localfv.getUrl();
        if (str1 == null)
        {
          gs.W("URL missing in loadAdUrl GMSG.");
          return;
        }
      }
      if (str1.contains("%40mediation_adapters%40"))
      {
        String str2 = str1.replaceAll("%40mediation_adapters%40", gf.a(paramAnonymousgv.getContext(), (String)paramAnonymousMap.get("check_adapters"), ft.c(ft.this)));
        localfv.setUrl(str2);
        gs.V("Ad request URL modified to " + str2);
      }
      ft.b(ft.this).a(localfv);
    }
  };

  public ft(String paramString)
  {
    this.uq = paramString;
  }

  public void b(gv paramgv)
  {
    this.md = paramgv;
  }

  public Future<fv> cK()
  {
    return this.ur;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ft
 * JD-Core Version:    0.6.2
 */