package com.google.android.gms.internal;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener
{
  private static final long m = TimeUnit.MILLISECONDS.toNanos(100L);
  private final Object a = new Object();
  private final WeakReference b;
  private WeakReference c;
  private final WeakReference d;
  private final a e;
  private final Context f;
  private final j g;
  private boolean h;
  private final WindowManager i;
  private final PowerManager j;
  private final KeyguardManager k;
  private i l;
  private boolean n = false;
  private boolean o = false;
  private long p = -9223372036854775808L;
  private boolean q;
  private BroadcastReceiver r;
  private HashSet s = new HashSet();

  public c(al paramal, gi paramgi)
  {
    this(paramal, paramgi, paramgi.b.h(), paramgi.b, new l(paramgi.b.getContext(), paramgi.b.h()));
  }

  public c(al paramal, gi paramgi, ev paramev, View paramView, j paramj)
  {
    this.b = new WeakReference(paramgi);
    this.d = new WeakReference(paramView);
    this.c = new WeakReference(null);
    this.q = true;
    this.e = new a(Integer.toString(paramgi.hashCode()), paramev, paramal.c, paramgi.j);
    this.g = paramj;
    this.i = ((WindowManager)paramView.getContext().getSystemService("window"));
    this.j = ((PowerManager)paramView.getContext().getApplicationContext().getSystemService("power"));
    this.k = ((KeyguardManager)paramView.getContext().getSystemService("keyguard"));
    this.f = paramView.getContext().getApplicationContext();
    a(paramj);
    this.g.a(new d(this));
    b(this.g);
    hi.c("Tracking ad unit: " + this.e.d());
  }

  protected int a(int paramInt, DisplayMetrics paramDisplayMetrics)
  {
    float f1 = paramDisplayMetrics.density;
    return (int)(paramInt / f1);
  }

  protected JSONObject a(View paramView)
  {
    int[] arrayOfInt1 = new int[2];
    int[] arrayOfInt2 = new int[2];
    paramView.getLocationOnScreen(arrayOfInt1);
    paramView.getLocationInWindow(arrayOfInt2);
    JSONObject localJSONObject = h();
    DisplayMetrics localDisplayMetrics = paramView.getContext().getResources().getDisplayMetrics();
    Rect localRect1 = new Rect();
    localRect1.left = arrayOfInt1[0];
    localRect1.top = arrayOfInt1[1];
    localRect1.right = (localRect1.left + paramView.getWidth());
    localRect1.bottom = (localRect1.top + paramView.getHeight());
    Rect localRect2 = new Rect();
    localRect2.right = this.i.getDefaultDisplay().getWidth();
    localRect2.bottom = this.i.getDefaultDisplay().getHeight();
    Rect localRect3 = new Rect();
    boolean bool = paramView.getGlobalVisibleRect(localRect3, null);
    Rect localRect4 = new Rect();
    paramView.getLocalVisibleRect(localRect4);
    localJSONObject.put("viewBox", new JSONObject().put("top", a(localRect2.top, localDisplayMetrics)).put("bottom", a(localRect2.bottom, localDisplayMetrics)).put("left", a(localRect2.left, localDisplayMetrics)).put("right", a(localRect2.right, localDisplayMetrics))).put("adBox", new JSONObject().put("top", a(localRect1.top, localDisplayMetrics)).put("bottom", a(localRect1.bottom, localDisplayMetrics)).put("left", a(localRect1.left, localDisplayMetrics)).put("right", a(localRect1.right, localDisplayMetrics))).put("globalVisibleBox", new JSONObject().put("top", a(localRect3.top, localDisplayMetrics)).put("bottom", a(localRect3.bottom, localDisplayMetrics)).put("left", a(localRect3.left, localDisplayMetrics)).put("right", a(localRect3.right, localDisplayMetrics))).put("localVisibleBox", new JSONObject().put("top", a(localRect4.top, localDisplayMetrics)).put("bottom", a(localRect4.bottom, localDisplayMetrics)).put("left", a(localRect4.left, localDisplayMetrics)).put("right", a(localRect4.right, localDisplayMetrics))).put("screenDensity", localDisplayMetrics.density).put("isVisible", a(paramView, bool)).put("isStopped", this.o).put("isPaused", this.n);
    return localJSONObject;
  }

  protected void a()
  {
    synchronized (this.a)
    {
      if (this.r == null)
      {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.intent.action.SCREEN_ON");
        localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
        this.r = new e(this);
        this.f.registerReceiver(this.r, localIntentFilter);
      }
    }
  }

  protected void a(hk paramhk, Map paramMap)
  {
    b(false);
  }

  public void a(i parami)
  {
    synchronized (this.a)
    {
      this.l = parami;
      return;
    }
  }

  protected void a(j paramj)
  {
    paramj.a("http://googleads.g.doubleclick.net/mads/static/sdk/native/sdk-core-v40.html");
  }

  public void a(op paramop)
  {
    this.s.add(paramop);
  }

  protected void a(JSONObject paramJSONObject)
  {
    JSONArray localJSONArray = new JSONArray();
    JSONObject localJSONObject = new JSONObject();
    localJSONArray.put(paramJSONObject);
    localJSONObject.put("units", localJSONArray);
    this.g.a("AFMA_updateActiveView", localJSONObject);
  }

  protected void a(boolean paramBoolean)
  {
    Iterator localIterator = this.s.iterator();
    while (localIterator.hasNext())
      ((op)localIterator.next()).a(this, paramBoolean);
  }

  protected boolean a(View paramView, boolean paramBoolean)
  {
    if ((paramView.getVisibility() == 0) && (paramBoolean) && (paramView.isShown()) && (this.j.isScreenOn()) && (!this.k.inKeyguardRestrictedInputMode()));
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  protected void b()
  {
    synchronized (this.a)
    {
      if (this.r != null)
      {
        this.f.unregisterReceiver(this.r);
        this.r = null;
      }
      return;
    }
  }

  protected void b(j paramj)
  {
    paramj.a("/updateActiveView", new f(this));
    paramj.a("/activeViewPingSent", new g(this));
    paramj.a("/visibilityChanged", new h(this));
    paramj.a("/viewabilityChanged", ar.a);
  }

  protected void b(boolean paramBoolean)
  {
    while (true)
    {
      long l1;
      gi localgi;
      View localView;
      synchronized (this.a)
      {
        if ((this.h) && (!this.q))
          continue;
        l1 = System.nanoTime();
        if ((!paramBoolean) || (this.p + m <= l1))
          continue;
      }
      int i1 = 1;
    }
  }

  public void c()
  {
    synchronized (this.a)
    {
      if (this.q)
      {
        g();
        b();
      }
      try
      {
        a(i());
        this.q = false;
        d();
        hi.c("Untracked ad unit: " + this.e.d());
        return;
      }
      catch (JSONException localJSONException)
      {
        while (true)
          hi.b("JSON Failure while processing active view data.", localJSONException);
      }
    }
  }

  protected void c(j paramj)
  {
    paramj.b("/viewabilityChanged");
    paramj.b("/visibilityChanged");
    paramj.b("/activeViewPingSent");
    paramj.b("/updateActiveView");
  }

  protected void d()
  {
    if (this.l != null)
      this.l.a(this);
  }

  public boolean e()
  {
    synchronized (this.a)
    {
      boolean bool = this.q;
      return bool;
    }
  }

  protected void f()
  {
    View localView = (View)this.d.get();
    if (localView == null);
    while (true)
    {
      return;
      ViewTreeObserver localViewTreeObserver1 = (ViewTreeObserver)this.c.get();
      ViewTreeObserver localViewTreeObserver2 = localView.getViewTreeObserver();
      if (localViewTreeObserver2 == localViewTreeObserver1)
        continue;
      this.c = new WeakReference(localViewTreeObserver2);
      localViewTreeObserver2.addOnScrollChangedListener(this);
      localViewTreeObserver2.addOnGlobalLayoutListener(this);
    }
  }

  protected void g()
  {
    ViewTreeObserver localViewTreeObserver = (ViewTreeObserver)this.c.get();
    if ((localViewTreeObserver == null) || (!localViewTreeObserver.isAlive()));
    while (true)
    {
      return;
      localViewTreeObserver.removeOnScrollChangedListener(this);
      localViewTreeObserver.removeGlobalOnLayoutListener(this);
    }
  }

  protected JSONObject h()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("afmaVersion", this.e.b()).put("activeViewJSON", this.e.c()).put("timestamp", TimeUnit.NANOSECONDS.toMillis(System.nanoTime())).put("adFormat", this.e.a()).put("hashCode", this.e.d());
    return localJSONObject;
  }

  protected JSONObject i()
  {
    JSONObject localJSONObject = h();
    localJSONObject.put("doneReasonCode", "u");
    return localJSONObject;
  }

  public void j()
  {
    synchronized (this.a)
    {
      this.o = true;
      b(false);
      this.g.a();
      return;
    }
  }

  public void k()
  {
    synchronized (this.a)
    {
      this.n = true;
      b(false);
      this.g.a();
      return;
    }
  }

  public void l()
  {
    synchronized (this.a)
    {
      this.g.b();
      this.n = false;
      b(false);
      return;
    }
  }

  public void onGlobalLayout()
  {
    b(false);
  }

  public void onScrollChanged()
  {
    b(true);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.c
 * JD-Core Version:    0.6.0
 */