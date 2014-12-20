package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Handler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class hm extends WebViewClient
{
  protected final hk a;
  private final HashMap b = new HashMap();
  private final Object c = new Object();
  private oe d;
  private cv e;
  private ho f;
  private aq g;
  private boolean h = false;
  private bc i;
  private be j;
  private boolean k;
  private da l;

  public hm(hk paramhk, boolean paramBoolean)
  {
    this.a = paramhk;
    this.k = paramBoolean;
  }

  private static boolean a(Uri paramUri)
  {
    String str = paramUri.getScheme();
    if (("http".equalsIgnoreCase(str)) || ("https".equalsIgnoreCase(str)));
    for (int m = 1; ; m = 0)
      return m;
  }

  private void b(Uri paramUri)
  {
    String str1 = paramUri.getPath();
    bb localbb = (bb)this.b.get(str1);
    if (localbb != null)
    {
      Map localMap = gw.a(paramUri);
      if (hi.a(2))
      {
        hi.d("Received GMSG: " + str1);
        Iterator localIterator = localMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str2 = (String)localIterator.next();
          hi.d("  " + str2 + ": " + (String)localMap.get(str2));
        }
      }
      localbb.a(this.a, localMap);
    }
    while (true)
    {
      return;
      hi.d("No GMSG handler found for GMSG: " + paramUri);
    }
  }

  public final void a(ce paramce)
  {
    cv localcv = null;
    boolean bool = this.a.i();
    oe localoe;
    if ((bool) && (!this.a.e().f))
    {
      localoe = null;
      if (!bool)
        break label70;
    }
    while (true)
    {
      a(new ch(paramce, localoe, localcv, this.l, this.a.h()));
      return;
      localoe = this.d;
      break;
      label70: localcv = this.e;
    }
  }

  protected void a(ch paramch)
  {
    co.a(this.a.getContext(), paramch);
  }

  public final void a(ho paramho)
  {
    this.f = paramho;
  }

  public void a(oe paramoe, cv paramcv, aq paramaq, da paramda, boolean paramBoolean, bc parambc)
  {
    a("/appEvent", new ap(paramaq));
    a("/canOpenURLs", ar.b);
    a("/click", ar.c);
    a("/close", ar.d);
    a("/customClose", ar.e);
    a("/httpTrack", ar.f);
    a("/log", ar.g);
    a("/open", new bf(parambc));
    a("/touch", ar.h);
    a("/video", ar.i);
    this.d = paramoe;
    this.e = paramcv;
    this.g = paramaq;
    this.i = parambc;
    this.l = paramda;
    a(paramBoolean);
  }

  public void a(oe paramoe, cv paramcv, aq paramaq, da paramda, boolean paramBoolean, bc parambc, be parambe)
  {
    a(paramoe, paramcv, paramaq, paramda, paramBoolean, parambc);
    a("/setInterstitialProperties", new bd(parambe));
    this.j = parambe;
  }

  public final void a(String paramString, bb parambb)
  {
    this.b.put(paramString, parambb);
  }

  public final void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }

  public final void a(boolean paramBoolean, int paramInt)
  {
    if ((this.a.i()) && (!this.a.e().f));
    for (oe localoe = null; ; localoe = this.d)
    {
      a(new ch(localoe, this.e, this.l, this.a, paramBoolean, paramInt, this.a.h()));
      return;
    }
  }

  public final void a(boolean paramBoolean, int paramInt, String paramString)
  {
    cv localcv = null;
    boolean bool = this.a.i();
    oe localoe;
    if ((bool) && (!this.a.e().f))
    {
      localoe = null;
      if (!bool)
        break label89;
    }
    while (true)
    {
      a(new ch(localoe, localcv, this.g, this.l, this.a, paramBoolean, paramInt, paramString, this.a.h(), this.i));
      return;
      localoe = this.d;
      break;
      label89: localcv = this.e;
    }
  }

  public final void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    boolean bool = this.a.i();
    oe localoe;
    if ((bool) && (!this.a.e().f))
    {
      localoe = null;
      if (!bool)
        break label91;
    }
    label91: for (cv localcv = null; ; localcv = this.e)
    {
      a(new ch(localoe, localcv, this.g, this.l, this.a, paramBoolean, paramInt, paramString1, paramString2, this.a.h(), this.i));
      return;
      localoe = this.d;
      break;
    }
  }

  public boolean a()
  {
    synchronized (this.c)
    {
      boolean bool = this.k;
      return bool;
    }
  }

  public final void b()
  {
    synchronized (this.c)
    {
      this.b.clear();
      this.d = null;
      this.e = null;
      this.f = null;
      this.g = null;
      this.h = false;
      this.k = false;
      this.i = null;
      this.l = null;
      return;
    }
  }

  public final void c()
  {
    synchronized (this.c)
    {
      this.h = false;
      this.k = true;
      co localco = this.a.d();
      if (localco != null)
      {
        if (!hh.b())
          hh.a.post(new hn(this, localco));
      }
      else
        return;
      localco.k();
    }
  }

  public final void onLoadResource(WebView paramWebView, String paramString)
  {
    hi.d("Loading resource: " + paramString);
    Uri localUri = Uri.parse(paramString);
    if (("gmsg".equalsIgnoreCase(localUri.getScheme())) && ("mobileads.google.com".equalsIgnoreCase(localUri.getHost())))
      b(localUri);
  }

  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    if (this.f != null)
    {
      this.f.a(this.a);
      this.f = null;
    }
  }

  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    hi.d("AdWebView shouldOverrideUrlLoading: " + paramString);
    Object localObject1 = Uri.parse(paramString);
    if (("gmsg".equalsIgnoreCase(((Uri)localObject1).getScheme())) && ("mobileads.google.com".equalsIgnoreCase(((Uri)localObject1).getHost())))
      b((Uri)localObject1);
    while (true)
    {
      for (boolean bool = true; ; bool = super.shouldOverrideUrlLoading(paramWebView, paramString))
      {
        return bool;
        if ((!this.h) || (paramWebView != this.a) || (!a((Uri)localObject1)))
          break;
      }
      if (!this.a.willNotDraw())
        try
        {
          mw localmw = this.a.g();
          if ((localmw != null) && (localmw.b((Uri)localObject1)))
          {
            Uri localUri = localmw.a((Uri)localObject1, this.a.getContext());
            localObject1 = localUri;
          }
          localObject2 = localObject1;
          a(new ce("android.intent.action.VIEW", localObject2.toString(), null, null, null, null, null));
        }
        catch (nh localnh)
        {
          while (true)
          {
            hi.e("Unable to append parameter to URL: " + paramString);
            Object localObject2 = localObject1;
          }
        }
      hi.e("AdWebView unable to handle URL: " + paramString);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hm
 * JD-Core Version:    0.6.0
 */