package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class co extends de
{
  private static final int a = Color.argb(0, 0, 0, 0);
  private final Activity b;
  private ch c;
  private cw d;
  private hk e;
  private ct f;
  private cz g;
  private boolean h;
  private FrameLayout i;
  private WebChromeClient.CustomViewCallback j;
  private boolean k = false;
  private boolean l = false;
  private boolean m = false;
  private RelativeLayout n;

  public co(Activity paramActivity)
  {
    this.b = paramActivity;
  }

  public static void a(Context paramContext, ch paramch)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName(paramContext, "com.google.android.gms.ads.AdActivity");
    localIntent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", paramch.o.f);
    ch.a(localIntent, paramch);
    localIntent.addFlags(524288);
    if (!(paramContext instanceof Activity))
      localIntent.addFlags(268435456);
    paramContext.startActivity(localIntent);
  }

  private static RelativeLayout.LayoutParams c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(paramInt3, paramInt4);
    localLayoutParams.setMargins(paramInt1, paramInt2, 0, 0);
    localLayoutParams.addRule(10);
    localLayoutParams.addRule(9);
    return localLayoutParams;
  }

  private void c(boolean paramBoolean)
  {
    if (!this.h)
      this.b.requestWindowFeature(1);
    Window localWindow = this.b.getWindow();
    if ((!this.m) || (this.c.r.d))
      localWindow.setFlags(1024, 1024);
    a(this.c.l);
    if (Build.VERSION.SDK_INT >= 11)
    {
      hi.a("Enabling hardware acceleration on the AdActivity window.");
      he.a(localWindow);
    }
    this.n = new cs(this.b, this.c.q);
    boolean bool;
    if (!this.m)
    {
      this.n.setBackgroundColor(-16777216);
      this.b.setContentView(this.n);
      j();
      bool = this.c.f.f().a();
      if (!paramBoolean)
        break label414;
      this.e = hk.a(this.b, this.c.f.e(), true, bool, null, this.c.o);
      this.e.f().a(null, null, this.c.g, this.c.k, true, this.c.p);
      this.e.f().a(new cp(this));
      if (this.c.n == null)
        break label364;
      this.e.loadUrl(this.c.n);
    }
    while (true)
    {
      this.e.a(this);
      ViewParent localViewParent = this.e.getParent();
      if ((localViewParent != null) && ((localViewParent instanceof ViewGroup)))
        ((ViewGroup)localViewParent).removeView(this.e);
      if (this.m)
        this.e.setBackgroundColor(a);
      this.n.addView(this.e, -1, -1);
      if (!paramBoolean)
        this.e.c();
      a(bool);
      return;
      this.n.setBackgroundColor(a);
      break;
      label364: if (this.c.j != null)
      {
        this.e.loadDataWithBaseURL(this.c.h, this.c.j, "text/html", "UTF-8", null);
        continue;
      }
      throw new cr("No URL or HTML to display in ad overlay.");
      label414: this.e = this.c.f;
      this.e.setContext(this.b);
    }
  }

  private void l()
  {
    if ((!this.b.isFinishing()) || (this.l));
    while (true)
    {
      return;
      this.l = true;
      if (!this.b.isFinishing())
        continue;
      if (this.e != null)
      {
        this.e.b();
        this.n.removeView(this.e);
        if (this.f != null)
        {
          this.e.a(false);
          this.f.c.addView(this.e, this.f.a, this.f.b);
        }
      }
      if ((this.c == null) || (this.c.e == null))
        continue;
      this.c.e.o();
    }
  }

  public void a()
  {
    this.b.finish();
  }

  public void a(int paramInt)
  {
    this.b.setRequestedOrientation(paramInt);
  }

  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.d != null)
      this.d.setLayoutParams(c(paramInt1, paramInt2, paramInt3, paramInt4));
  }

  public void a(Bundle paramBundle)
  {
    boolean bool = false;
    if (paramBundle != null)
      bool = paramBundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
    this.k = bool;
    try
    {
      this.c = ch.a(this.b.getIntent());
      if (this.c == null)
        throw new cr("Could not get info for ad overlay.");
    }
    catch (cr localcr)
    {
      hi.e(localcr.getMessage());
      this.b.finish();
    }
    while (true)
    {
      return;
      if (this.c.r != null);
      for (this.m = this.c.r.c; ; this.m = false)
      {
        if (paramBundle == null)
        {
          if (this.c.e != null)
            this.c.e.p();
          if ((this.c.m != 1) && (this.c.d != null))
            this.c.d.r();
        }
        switch (this.c.m)
        {
        default:
          throw new cr("Could not determine ad overlay type.");
        case 1:
        case 2:
        case 3:
        case 4:
        }
      }
      c(false);
      continue;
      this.f = new ct(this.c.f);
      c(false);
      continue;
      c(true);
      continue;
      if (this.k)
      {
        this.b.finish();
        continue;
      }
      if (cm.a(this.b, this.c.c, this.c.k))
        continue;
      this.b.finish();
    }
  }

  public void a(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    this.i = new FrameLayout(this.b);
    this.i.setBackgroundColor(-16777216);
    this.i.addView(paramView, -1, -1);
    this.b.setContentView(this.i);
    j();
    this.j = paramCustomViewCallback;
  }

  public void a(boolean paramBoolean)
  {
    int i1;
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramBoolean)
    {
      i1 = 50;
      this.g = new cz(this.b, i1);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(10);
      if (!paramBoolean)
        break label88;
    }
    label88: for (int i2 = 11; ; i2 = 9)
    {
      localLayoutParams.addRule(i2);
      this.g.a(this.c.i);
      this.n.addView(this.g, localLayoutParams);
      return;
      i1 = 32;
      break;
    }
  }

  public cw b()
  {
    return this.d;
  }

  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.d == null)
    {
      this.d = new cw(this.b, this.e);
      this.n.addView(this.d, 0, c(paramInt1, paramInt2, paramInt3, paramInt4));
      this.e.f().a(false);
    }
  }

  public void b(Bundle paramBundle)
  {
    paramBundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.k);
  }

  public void b(boolean paramBoolean)
  {
    if (this.g != null)
      this.g.a(paramBoolean);
  }

  public void c()
  {
    if (this.c != null)
      a(this.c.l);
    if (this.i != null)
    {
      this.b.setContentView(this.n);
      j();
      this.i.removeAllViews();
      this.i = null;
    }
    if (this.j != null)
    {
      this.j.onCustomViewHidden();
      this.j = null;
    }
  }

  public void d()
  {
  }

  public void e()
  {
  }

  public void f()
  {
    if ((this.c != null) && (this.c.m == 4))
    {
      if (!this.k)
        break label47;
      this.b.finish();
    }
    while (true)
    {
      if (this.e != null)
        gw.b(this.e);
      return;
      label47: this.k = true;
    }
  }

  public void g()
  {
    if (this.d != null)
      this.d.c();
    c();
    if ((this.e != null) && ((!this.b.isFinishing()) || (this.f == null)))
      gw.a(this.e);
    l();
  }

  public void h()
  {
    l();
  }

  public void i()
  {
    if (this.d != null)
      this.d.a();
    if (this.e != null)
      this.n.removeView(this.e);
    l();
  }

  public void j()
  {
    this.h = true;
  }

  public void k()
  {
    this.n.removeView(this.g);
    a(true);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.co
 * JD-Core Version:    0.6.0
 */