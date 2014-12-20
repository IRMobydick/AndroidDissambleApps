package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import com.google.android.gms.a.a;
import com.google.android.gms.a.d;
import com.google.android.gms.common.g;
import java.util.ArrayList;
import java.util.HashSet;

public class of extends z
  implements aq, bc, be, bn, cv, da, er, go, oe
{
  private final bv a;
  private final oj b;
  private final om c;
  private final b d;
  private boolean e;
  private final ComponentCallbacks f = new og(this);

  public of(Context paramContext, al paramal, String paramString, bv parambv, ev paramev)
  {
    this.b = new oj(paramContext, paramal, paramString, paramev);
    this.a = parambv;
    this.c = new om(this);
    this.d = new b();
    gw.b(paramContext);
    s();
  }

  private void A()
  {
    if (this.b.i != null)
    {
      this.b.i.b.destroy();
      this.b.i = null;
    }
  }

  private void a(int paramInt)
  {
    hi.e("Failed to load ad: " + paramInt);
    if (this.b.f != null);
    try
    {
      this.b.f.a(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        hi.c("Could not call AdListener.onAdFailedToLoad().", localRemoteException);
    }
  }

  private void a(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-2, -2);
    this.b.a.addView(paramView, localLayoutParams);
  }

  private void b(boolean paramBoolean)
  {
    if (this.b.i == null)
      hi.e("Ad state was null when trying to ping impression URLs.");
    while (true)
    {
      return;
      hi.a("Pinging Impression URLs.");
      this.b.j.a();
      if (this.b.i.e != null)
        gw.a(this.b.c, this.b.e.c, this.b.i.e);
      if ((this.b.i.o != null) && (this.b.i.o.d != null))
        bt.a(this.b.c, this.b.e.c, this.b.i, this.b.b, paramBoolean, this.b.i.o.d);
      if ((this.b.i.l == null) || (this.b.i.l.f == null))
        continue;
      bt.a(this.b.c, this.b.e.c, this.b.i, this.b.b, paramBoolean, this.b.i.l.f);
    }
  }

  // ERROR //
  private boolean b(gi paramgi)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 201	com/google/android/gms/internal/gi:k	Z
    //   4: ifeq +199 -> 203
    //   7: aload_1
    //   8: getfield 205	com/google/android/gms/internal/gi:m	Lcom/google/android/gms/internal/by;
    //   11: invokeinterface 210 1 0
    //   16: invokestatic 215	com/google/android/gms/a/d:a	(Lcom/google/android/gms/a/a;)Ljava/lang/Object;
    //   19: checkcast 217	android/view/View
    //   22: astore 6
    //   24: aload_0
    //   25: getfield 53	com/google/android/gms/internal/of:b	Lcom/google/android/gms/internal/oj;
    //   28: getfield 134	com/google/android/gms/internal/oj:a	Lcom/google/android/gms/internal/oh;
    //   31: invokevirtual 221	com/google/android/gms/internal/oh:getNextView	()Landroid/view/View;
    //   34: astore 7
    //   36: aload 7
    //   38: ifnull +15 -> 53
    //   41: aload_0
    //   42: getfield 53	com/google/android/gms/internal/of:b	Lcom/google/android/gms/internal/oj;
    //   45: getfield 134	com/google/android/gms/internal/oj:a	Lcom/google/android/gms/internal/oh;
    //   48: aload 7
    //   50: invokevirtual 224	com/google/android/gms/internal/oh:removeView	(Landroid/view/View;)V
    //   53: aload_0
    //   54: aload 6
    //   56: invokespecial 226	com/google/android/gms/internal/of:a	(Landroid/view/View;)V
    //   59: aload_0
    //   60: getfield 53	com/google/android/gms/internal/of:b	Lcom/google/android/gms/internal/oj;
    //   63: getfield 134	com/google/android/gms/internal/oj:a	Lcom/google/android/gms/internal/oh;
    //   66: invokevirtual 230	com/google/android/gms/internal/oh:getChildCount	()I
    //   69: iconst_1
    //   70: if_icmple +13 -> 83
    //   73: aload_0
    //   74: getfield 53	com/google/android/gms/internal/of:b	Lcom/google/android/gms/internal/oj;
    //   77: getfield 134	com/google/android/gms/internal/oj:a	Lcom/google/android/gms/internal/oh;
    //   80: invokevirtual 233	com/google/android/gms/internal/oh:showNext	()V
    //   83: aload_0
    //   84: getfield 53	com/google/android/gms/internal/of:b	Lcom/google/android/gms/internal/oj;
    //   87: getfield 78	com/google/android/gms/internal/oj:i	Lcom/google/android/gms/internal/gi;
    //   90: ifnull +70 -> 160
    //   93: aload_0
    //   94: getfield 53	com/google/android/gms/internal/of:b	Lcom/google/android/gms/internal/oj;
    //   97: getfield 134	com/google/android/gms/internal/oj:a	Lcom/google/android/gms/internal/oh;
    //   100: invokevirtual 221	com/google/android/gms/internal/oh:getNextView	()Landroid/view/View;
    //   103: astore_3
    //   104: aload_3
    //   105: instanceof 85
    //   108: ifeq +168 -> 276
    //   111: aload_3
    //   112: checkcast 85	com/google/android/gms/internal/hk
    //   115: aload_0
    //   116: getfield 53	com/google/android/gms/internal/of:b	Lcom/google/android/gms/internal/oj;
    //   119: getfield 161	com/google/android/gms/internal/oj:c	Landroid/content/Context;
    //   122: aload_0
    //   123: getfield 53	com/google/android/gms/internal/of:b	Lcom/google/android/gms/internal/oj;
    //   126: getfield 237	com/google/android/gms/internal/oj:h	Lcom/google/android/gms/internal/al;
    //   129: invokevirtual 240	com/google/android/gms/internal/hk:a	(Landroid/content/Context;Lcom/google/android/gms/internal/al;)V
    //   132: aload_0
    //   133: getfield 53	com/google/android/gms/internal/of:b	Lcom/google/android/gms/internal/oj;
    //   136: getfield 78	com/google/android/gms/internal/oj:i	Lcom/google/android/gms/internal/gi;
    //   139: getfield 205	com/google/android/gms/internal/gi:m	Lcom/google/android/gms/internal/by;
    //   142: ifnull +18 -> 160
    //   145: aload_0
    //   146: getfield 53	com/google/android/gms/internal/of:b	Lcom/google/android/gms/internal/oj;
    //   149: getfield 78	com/google/android/gms/internal/oj:i	Lcom/google/android/gms/internal/gi;
    //   152: getfield 205	com/google/android/gms/internal/gi:m	Lcom/google/android/gms/internal/by;
    //   155: invokeinterface 242 1 0
    //   160: aload_0
    //   161: getfield 53	com/google/android/gms/internal/of:b	Lcom/google/android/gms/internal/oj;
    //   164: getfield 134	com/google/android/gms/internal/oj:a	Lcom/google/android/gms/internal/oh;
    //   167: iconst_0
    //   168: invokevirtual 245	com/google/android/gms/internal/oh:setVisibility	(I)V
    //   171: iconst_1
    //   172: istore_2
    //   173: iload_2
    //   174: ireturn
    //   175: astore 5
    //   177: ldc 247
    //   179: aload 5
    //   181: invokestatic 125	com/google/android/gms/internal/hi:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   184: iconst_0
    //   185: istore_2
    //   186: goto -13 -> 173
    //   189: astore 8
    //   191: ldc 249
    //   193: aload 8
    //   195: invokestatic 125	com/google/android/gms/internal/hi:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   198: iconst_0
    //   199: istore_2
    //   200: goto -27 -> 173
    //   203: aload_1
    //   204: getfield 252	com/google/android/gms/internal/gi:r	Lcom/google/android/gms/internal/al;
    //   207: ifnull -148 -> 59
    //   210: aload_1
    //   211: getfield 83	com/google/android/gms/internal/gi:b	Lcom/google/android/gms/internal/hk;
    //   214: aload_1
    //   215: getfield 252	com/google/android/gms/internal/gi:r	Lcom/google/android/gms/internal/al;
    //   218: invokevirtual 255	com/google/android/gms/internal/hk:a	(Lcom/google/android/gms/internal/al;)V
    //   221: aload_0
    //   222: getfield 53	com/google/android/gms/internal/of:b	Lcom/google/android/gms/internal/oj;
    //   225: getfield 134	com/google/android/gms/internal/oj:a	Lcom/google/android/gms/internal/oh;
    //   228: invokevirtual 258	com/google/android/gms/internal/oh:removeAllViews	()V
    //   231: aload_0
    //   232: getfield 53	com/google/android/gms/internal/of:b	Lcom/google/android/gms/internal/oj;
    //   235: getfield 134	com/google/android/gms/internal/oj:a	Lcom/google/android/gms/internal/oh;
    //   238: aload_1
    //   239: getfield 252	com/google/android/gms/internal/gi:r	Lcom/google/android/gms/internal/al;
    //   242: getfield 263	com/google/android/gms/internal/al:h	I
    //   245: invokevirtual 266	com/google/android/gms/internal/oh:setMinimumWidth	(I)V
    //   248: aload_0
    //   249: getfield 53	com/google/android/gms/internal/of:b	Lcom/google/android/gms/internal/oj;
    //   252: getfield 134	com/google/android/gms/internal/oj:a	Lcom/google/android/gms/internal/oh;
    //   255: aload_1
    //   256: getfield 252	com/google/android/gms/internal/gi:r	Lcom/google/android/gms/internal/al;
    //   259: getfield 268	com/google/android/gms/internal/al:e	I
    //   262: invokevirtual 271	com/google/android/gms/internal/oh:setMinimumHeight	(I)V
    //   265: aload_0
    //   266: aload_1
    //   267: getfield 83	com/google/android/gms/internal/gi:b	Lcom/google/android/gms/internal/hk;
    //   270: invokespecial 226	com/google/android/gms/internal/of:a	(Landroid/view/View;)V
    //   273: goto -214 -> 59
    //   276: aload_3
    //   277: ifnull -145 -> 132
    //   280: aload_0
    //   281: getfield 53	com/google/android/gms/internal/of:b	Lcom/google/android/gms/internal/oj;
    //   284: getfield 134	com/google/android/gms/internal/oj:a	Lcom/google/android/gms/internal/oh;
    //   287: aload_3
    //   288: invokevirtual 224	com/google/android/gms/internal/oh:removeView	(Landroid/view/View;)V
    //   291: goto -159 -> 132
    //   294: astore 4
    //   296: ldc_w 273
    //   299: invokestatic 113	com/google/android/gms/internal/hi:e	(Ljava/lang/String;)V
    //   302: goto -142 -> 160
    //
    // Exception table:
    //   from	to	target	type
    //   7	24	175	android/os/RemoteException
    //   53	59	189	java/lang/Throwable
    //   145	160	294	android/os/RemoteException
  }

  private fl c(ai paramai)
  {
    ApplicationInfo localApplicationInfo = this.b.c.getApplicationInfo();
    try
    {
      PackageInfo localPackageInfo2 = this.b.c.getPackageManager().getPackageInfo(localApplicationInfo.packageName, 0);
      localPackageInfo1 = localPackageInfo2;
      if ((!this.b.h.f) && (this.b.a.getParent() != null))
      {
        int[] arrayOfInt = new int[2];
        this.b.a.getLocationOnScreen(arrayOfInt);
        int i = arrayOfInt[0];
        int j = arrayOfInt[1];
        DisplayMetrics localDisplayMetrics = this.b.c.getResources().getDisplayMetrics();
        int k = this.b.a.getWidth();
        int m = this.b.a.getHeight();
        if ((this.b.a.isShown()) && (i + k > 0) && (j + m > 0) && (i <= localDisplayMetrics.widthPixels) && (j <= localDisplayMetrics.heightPixels))
        {
          n = 1;
          localBundle1 = new Bundle(5);
          localBundle1.putInt("x", i);
          localBundle1.putInt("y", j);
          localBundle1.putInt("width", k);
          localBundle1.putInt("height", m);
          localBundle1.putInt("visible", n);
          String str = gm.b();
          this.b.j = new gk(str, this.b.b);
          this.b.j.a(paramai);
          Bundle localBundle2 = gm.a(this.b.c, this, str);
          return new fl(localBundle1, paramai, this.b.h, this.b.b, localApplicationInfo, localPackageInfo1, str, gm.a, this.b.e, localBundle2);
        }
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      while (true)
      {
        PackageInfo localPackageInfo1 = null;
        continue;
        int n = 0;
        continue;
        Bundle localBundle1 = null;
      }
    }
  }

  private void s()
  {
    if ((Build.VERSION.SDK_INT >= 14) && (this.b != null) && (this.b.c != null))
      this.b.c.registerComponentCallbacks(this.f);
  }

  private void t()
  {
    if ((Build.VERSION.SDK_INT >= 14) && (this.b != null) && (this.b.c != null))
      this.b.c.unregisterComponentCallbacks(this.f);
  }

  private void u()
  {
    hi.c("Ad closing.");
    if (this.b.f != null);
    try
    {
      this.b.f.a();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        hi.c("Could not call AdListener.onAdClosed().", localRemoteException);
    }
  }

  private void v()
  {
    hi.c("Ad leaving application.");
    if (this.b.f != null);
    try
    {
      this.b.f.b();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        hi.c("Could not call AdListener.onAdLeftApplication().", localRemoteException);
    }
  }

  private void w()
  {
    hi.c("Ad opening.");
    if (this.b.f != null);
    try
    {
      this.b.f.d();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        hi.c("Could not call AdListener.onAdOpened().", localRemoteException);
    }
  }

  private void x()
  {
    hi.c("Ad finished loading.");
    if (this.b.f != null);
    try
    {
      this.b.f.c();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        hi.c("Could not call AdListener.onAdLoaded().", localRemoteException);
    }
  }

  private boolean y()
  {
    int i = 1;
    if (!gw.a(this.b.c.getPackageManager(), this.b.c.getPackageName(), "android.permission.INTERNET"))
    {
      if (!this.b.h.f)
        hh.a(this.b.a, this.b.h, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
      i = 0;
    }
    if (!gw.a(this.b.c))
    {
      if (!this.b.h.f)
        hh.a(this.b.a, this.b.h, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
      i = 0;
    }
    if ((i == 0) && (!this.b.h.f))
      this.b.a.setVisibility(0);
    return i;
  }

  private void z()
  {
    if (this.b.i == null)
      hi.e("Ad state was null when trying to ping click URLs.");
    while (true)
    {
      return;
      hi.a("Pinging click URLs.");
      this.b.j.b();
      if (this.b.i.c != null)
        gw.a(this.b.c, this.b.e.c, this.b.i.c);
      if ((this.b.i.o == null) || (this.b.i.o.c == null))
        continue;
      bt.a(this.b.c, this.b.e.c, this.b.i, this.b.b, false, this.b.i.o.c);
    }
  }

  public a a()
  {
    kx.b("getAdFrame must be called on the main UI thread.");
    return d.a(this.b.a);
  }

  public void a(ae paramae)
  {
    kx.b("setAppEventListener must be called on the main UI thread.");
    this.b.k = paramae;
  }

  public void a(al paramal)
  {
    kx.b("setAdSize must be called on the main UI thread.");
    this.b.h = paramal;
    if (this.b.i != null)
      this.b.i.b.a(paramal);
    if (this.b.a.getChildCount() > 1)
      this.b.a.removeView(this.b.a.getNextView());
    this.b.a.setMinimumWidth(paramal.h);
    this.b.a.setMinimumHeight(paramal.e);
    this.b.a.requestLayout();
  }

  public void a(eb parameb)
  {
    kx.b("setInAppPurchaseListener must be called on the main UI thread.");
    this.b.m = parameb;
  }

  public void a(ej paramej, String paramString)
  {
    kx.b("setPlayStorePurchaseParams must be called on the main UI thread.");
    this.b.n = new dw(paramString);
    this.b.l = paramej;
    if ((!gm.f()) && (paramej != null))
      new dl(this.b.c, this.b.l, this.b.n).e();
  }

  public void a(gi paramgi)
  {
    int i = 0;
    this.b.g = null;
    if ((paramgi.d != -2) && (paramgi.d != 3))
      gm.a(this.b.a());
    if (paramgi.d == -1);
    while (true)
    {
      return;
      boolean bool;
      if (paramgi.a.d != null)
      {
        bool = paramgi.a.d.getBoolean("_noRefresh", false);
        label72: if (!this.b.h.f)
          break label184;
        gw.a(paramgi.b);
      }
      while (true)
      {
        if ((paramgi.d == 3) && (paramgi.o != null) && (paramgi.o.e != null))
        {
          hi.a("Pinging no fill URLs.");
          bt.a(this.b.c, this.b.e.c, paramgi, this.b.b, false, paramgi.o.e);
        }
        if (paramgi.d == -2)
          break label284;
        a(paramgi.d);
        break;
        bool = false;
        break label72;
        label184: if (bool)
          continue;
        if (paramgi.h > 0L)
        {
          this.c.a(paramgi.a, paramgi.h);
          continue;
        }
        if ((paramgi.o != null) && (paramgi.o.g > 0L))
        {
          this.c.a(paramgi.a, paramgi.o.g);
          continue;
        }
        if ((paramgi.k) || (paramgi.d != 2))
          continue;
        this.c.a(paramgi.a);
      }
      label284: if (this.b.h.f)
        break;
      if (!b(paramgi))
      {
        a(0);
        continue;
      }
      if (this.b.a == null)
        break;
      oh.a(this.b.a).a(paramgi.v);
    }
    if ((this.b.i != null) && (this.b.i.p != null))
      this.b.i.p.a(null);
    if (paramgi.p != null)
      paramgi.p.a(this);
    this.d.b(this.b.i);
    this.b.i = paramgi;
    if (paramgi.r != null)
      this.b.h = paramgi.r;
    this.b.j.a(paramgi.t);
    this.b.j.b(paramgi.u);
    this.b.j.a(this.b.h.f);
    this.b.j.b(paramgi.k);
    if (!this.b.h.f)
      b(false);
    if (this.b.o == null)
      this.b.o = new gp(this.b.b);
    int j;
    if (paramgi.o != null)
    {
      j = paramgi.o.h;
      i = paramgi.o.i;
    }
    while (true)
    {
      this.b.o.a(j, i);
      if ((!this.b.h.f) && (paramgi.b != null) && ((paramgi.b.f().a()) || (paramgi.j != null)))
      {
        c localc = this.d.a(this.b.h, this.b.i);
        if ((paramgi.b.f().a()) && (localc != null))
          localc.a(new ol(paramgi.b));
      }
      this.b.i.b.a();
      x();
      break;
      j = 0;
    }
  }

  public void a(u paramu)
  {
    kx.b("setAdListener must be called on the main UI thread.");
    this.b.f = paramu;
  }

  public void a(String paramString1, String paramString2)
  {
    if (this.b.k != null);
    try
    {
      this.b.k.a(paramString1, paramString2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        hi.c("Could not call the AppEventListener.", localRemoteException);
    }
  }

  public void a(String paramString, ArrayList paramArrayList)
  {
    dn localdn = new dn(paramString, paramArrayList, this.b.c, this.b.e.c);
    if (this.b.m == null)
    {
      hi.e("InAppPurchaseListener is not set. Try to launch default purchase flow.");
      if (g.a(this.b.c) != 0)
        hi.e("Google Play Service unavailable, cannot launch default purchase flow.");
    }
    while (true)
    {
      return;
      if (this.b.l == null)
      {
        hi.e("PlayStorePurchaseListener is not set.");
        continue;
      }
      if (this.b.n == null)
      {
        hi.e("PlayStorePurchaseVerifier is not initialized.");
        continue;
      }
      try
      {
        boolean bool = this.b.l.a(paramString);
        if (!bool)
          continue;
        do.a(this.b.c, this.b.e.f, new cq(localdn, this.b.l, this.b.n, this.b.c));
      }
      catch (RemoteException localRemoteException2)
      {
        while (true)
          hi.e("Could not start In-App purchase.");
      }
      try
      {
        this.b.m.a(localdn);
      }
      catch (RemoteException localRemoteException1)
      {
        hi.e("Could not start In-App purchase.");
      }
    }
  }

  public void a(HashSet paramHashSet)
  {
    this.b.a(paramHashSet);
  }

  public void a(boolean paramBoolean)
  {
    this.b.p = paramBoolean;
  }

  public boolean a(ai paramai)
  {
    int i = 0;
    kx.b("loadAd must be called on the main UI thread.");
    if (this.b.g != null)
      hi.e("An ad request is already in progress. Aborting.");
    Object localObject;
    while (true)
    {
      return i;
      if ((this.b.h.f) && (this.b.i != null))
      {
        hi.e("An interstitial is already loading. Aborting.");
        continue;
      }
      if (!y())
        continue;
      hi.c("Starting ad request.");
      if (!paramai.g)
        hi.c("Use AdRequest.Builder.addTestDevice(\"" + hh.a(this.b.c) + "\") to get test ads on this device.");
      this.c.a();
      this.b.p = false;
      fl localfl = c(paramai);
      if (!this.b.h.f)
        break;
      hk localhk2 = hk.a(this.b.c, this.b.h, false, false, this.b.d, this.b.e);
      localhk2.f().a(this, null, this, this, true, this, this);
      localObject = localhk2;
      this.b.g = eq.a(this.b.c, localfl, this.b.d, (hk)localObject, this.a, this);
      i = 1;
    }
    View localView = this.b.a.getNextView();
    hk localhk1;
    if ((localView instanceof hk))
    {
      localhk1 = (hk)localView;
      localhk1.a(this.b.c, this.b.h);
    }
    while (true)
    {
      localhk1.f().a(this, this, this, this, false, this);
      localObject = localhk1;
      break;
      if (localView != null)
        this.b.a.removeView(localView);
      localhk1 = hk.a(this.b.c, this.b.h, false, false, this.b.d, this.b.e);
      if (this.b.h.i != null)
        continue;
      a(localhk1);
    }
  }

  public void b()
  {
    kx.b("destroy must be called on the main UI thread.");
    t();
    this.b.f = null;
    this.b.k = null;
    this.c.a();
    this.d.a();
    g();
    if (this.b.a != null)
      this.b.a.removeAllViews();
    if ((this.b.i != null) && (this.b.i.b != null))
      this.b.i.b.destroy();
    if ((this.b.i != null) && (this.b.i.m != null));
    try
    {
      this.b.i.m.c();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        hi.e("Could not destroy mediation adapter.");
    }
  }

  public void b(ai paramai)
  {
    ViewParent localViewParent = this.b.a.getParent();
    if (((localViewParent instanceof View)) && (((View)localViewParent).isShown()) && (gw.a()) && (!this.e))
      a(paramai);
    while (true)
    {
      return;
      hi.c("Ad is not visible. Not refreshing ad.");
      this.c.a(paramai);
    }
  }

  public boolean c()
  {
    kx.b("isLoaded must be called on the main UI thread.");
    if ((this.b.g == null) && (this.b.i != null));
    for (int i = 1; ; i = 0)
      return i;
  }

  public void d()
  {
    kx.b("pause must be called on the main UI thread.");
    if (this.b.i != null)
      gw.a(this.b.i.b);
    if ((this.b.i != null) && (this.b.i.m != null));
    try
    {
      this.b.i.m.d();
      this.d.b();
      this.c.b();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        hi.e("Could not pause mediation adapter.");
    }
  }

  public void e()
  {
    kx.b("resume must be called on the main UI thread.");
    if (this.b.i != null)
      gw.b(this.b.i.b);
    if ((this.b.i != null) && (this.b.i.m != null));
    try
    {
      this.b.i.m.e();
      this.c.c();
      this.d.c();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        hi.e("Could not resume mediation adapter.");
    }
  }

  public void f()
  {
    kx.b("showInterstitial must be called on the main UI thread.");
    if (!this.b.h.f)
      hi.e("Cannot call showInterstitial on a banner ad.");
    while (true)
    {
      return;
      if (this.b.i == null)
      {
        hi.e("The interstitial has not loaded.");
        continue;
      }
      if (this.b.i.b.i())
      {
        hi.e("The interstitial is already showing.");
        continue;
      }
      this.b.i.b.a(true);
      if ((this.b.i.b.f().a()) || (this.b.i.j != null))
      {
        c localc = this.d.a(this.b.h, this.b.i);
        if ((this.b.i.b.f().a()) && (localc != null))
          localc.a(new ol(this.b.i.b));
      }
      if (!this.b.i.k)
        break;
      try
      {
        this.b.i.m.b();
      }
      catch (RemoteException localRemoteException)
      {
        hi.c("Could not show interstitial.", localRemoteException);
        A();
      }
    }
    v localv = new v(this.b.p, false);
    boolean bool1;
    if ((this.b.c instanceof Activity))
    {
      Window localWindow = ((Activity)this.b.c).getWindow();
      Rect localRect1 = new Rect();
      Rect localRect2 = new Rect();
      localWindow.getDecorView().getGlobalVisibleRect(localRect1);
      localWindow.getDecorView().getWindowVisibleDisplayFrame(localRect2);
      if ((localRect1.bottom != 0) && (localRect2.bottom != 0))
      {
        bool1 = this.b.p;
        if (localRect1.top != localRect2.top)
          break label429;
      }
    }
    label429: for (boolean bool2 = true; ; bool2 = false)
    {
      localv = new v(bool1, bool2);
      ch localch = new ch(this, this, this, this.b.i.b, this.b.i.g, this.b.e, this.b.i.v, localv);
      co.a(this.b.c, localch);
      break;
    }
  }

  public void g()
  {
    kx.b("stopLoading must be called on the main UI thread.");
    if (this.b.i != null)
    {
      this.b.i.b.stopLoading();
      this.b.i = null;
    }
    if (this.b.g != null)
      this.b.g.f();
  }

  public void h()
  {
    kx.b("recordManualImpression must be called on the main UI thread.");
    if (this.b.i == null)
      hi.e("Ad state was null when trying to ping manual tracking URLs.");
    while (true)
    {
      return;
      hi.a("Pinging manual tracking URLs.");
      if (this.b.i.f == null)
        continue;
      gw.a(this.b.c, this.b.e.c, this.b.i.f);
    }
  }

  public al i()
  {
    kx.b("getAdSize must be called on the main UI thread.");
    return this.b.h;
  }

  public void j()
  {
    r();
  }

  public void k()
  {
    o();
  }

  public void l()
  {
    q();
  }

  public void m()
  {
    p();
  }

  public void n()
  {
    if (this.b.i != null)
      hi.e("Mediation adapter " + this.b.i.n + " refreshed, but mediation adapters should never refresh.");
    b(true);
    x();
  }

  public void o()
  {
    this.d.b(this.b.i);
    if (this.b.h.f)
      A();
    this.e = false;
    u();
    this.b.j.c();
  }

  public void p()
  {
    if (this.b.h.f)
      b(false);
    this.e = true;
    w();
  }

  public void q()
  {
    v();
  }

  public void r()
  {
    z();
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.of
 * JD-Core Version:    0.6.0
 */