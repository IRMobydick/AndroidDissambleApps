package com.google.android.gms.internal;

import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;

@ez
public class v
{
  private a lZ;
  private boolean ma;
  private boolean mb;

  public v()
  {
    Bundle localBundle = gb.bD();
    boolean bool1 = false;
    if (localBundle != null)
    {
      boolean bool2 = localBundle.getBoolean("gads:block_autoclicks", false);
      bool1 = false;
      if (bool2)
        bool1 = true;
    }
    this.mb = bool1;
  }

  public v(boolean paramBoolean)
  {
    this.mb = paramBoolean;
  }

  public void a(a parama)
  {
    this.lZ = parama;
  }

  public void ar()
  {
    this.ma = true;
  }

  public boolean av()
  {
    return (!this.mb) || (this.ma);
  }

  public void d(String paramString)
  {
    gs.S("Action was blocked because no click was detected.");
    if (this.lZ != null)
      this.lZ.e(paramString);
  }

  public static abstract interface a
  {
    public abstract void e(String paramString);
  }

  @ez
  public static class b
    implements v.a
  {
    private final fz.a mc;
    private final gv md;

    public b(fz.a parama, gv paramgv)
    {
      this.mc = parama;
      this.md = paramgv;
    }

    public void e(String paramString)
    {
      gs.S("An auto-clicking creative is blocked");
      Uri.Builder localBuilder = new Uri.Builder();
      localBuilder.scheme("https");
      localBuilder.path("//pagead2.googlesyndication.com/pagead/gen_204");
      localBuilder.appendQueryParameter("id", "gmob-apps-blocked-navigation");
      if (!TextUtils.isEmpty(paramString))
        localBuilder.appendQueryParameter("navigationURL", paramString);
      if ((this.mc != null) && (this.mc.vw != null) && (!TextUtils.isEmpty(this.mc.vw.tN)))
        localBuilder.appendQueryParameter("debugDialog", this.mc.vw.tN);
      gj.c(this.md.getContext(), this.md.dx().wD, localBuilder.toString());
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.v
 * JD-Core Version:    0.6.2
 */