package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ViewSwitcher;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.o;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@ez
public class u extends bd.a
  implements aa, bw, bz, cb, cn, dn, dq, fa.a, fd.a, gd, t
{
  private av lp;
  private final ct lq;
  private final b lr;
  private final ab ls;
  private final ae lt;
  private boolean lu;
  private final ComponentCallbacks lv = new ComponentCallbacks()
  {
    public void onConfigurationChanged(Configuration paramAnonymousConfiguration)
    {
      if ((u.a(u.this) != null) && (u.a(u.this).lI != null) && (u.a(u.this).lI.rN != null))
        u.a(u.this).lI.rN.bS();
    }

    public void onLowMemory()
    {
    }
  };

  public u(Context paramContext, ay paramay, String paramString, ct paramct, gt paramgt)
  {
    this(new b(paramContext, paramay, paramString, paramgt), paramct, null);
  }

  u(b paramb, ct paramct, ab paramab)
  {
    this.lr = paramb;
    this.lq = paramct;
    if (paramab != null);
    while (true)
    {
      this.ls = paramab;
      this.lt = new ae();
      gj.q(this.lr.lB);
      gb.a(this.lr.lB, this.lr.lD);
      Z();
      return;
      paramab = new ab(this);
    }
  }

  private void Z()
  {
    if ((Build.VERSION.SDK_INT >= 14) && (this.lr != null) && (this.lr.lB != null))
      this.lr.lB.registerComponentCallbacks(this.lv);
  }

  private fi.a a(av paramav, Bundle paramBundle)
  {
    ApplicationInfo localApplicationInfo = this.lr.lB.getApplicationInfo();
    try
    {
      PackageInfo localPackageInfo2 = this.lr.lB.getPackageManager().getPackageInfo(localApplicationInfo.packageName, 0);
      localPackageInfo1 = localPackageInfo2;
      boolean bool1 = this.lr.lH.og;
      Bundle localBundle1 = null;
      if (!bool1)
      {
        ViewParent localViewParent = this.lr.lz.getParent();
        localBundle1 = null;
        if (localViewParent != null)
        {
          int[] arrayOfInt = new int[2];
          this.lr.lz.getLocationOnScreen(arrayOfInt);
          int i = arrayOfInt[0];
          int j = arrayOfInt[1];
          DisplayMetrics localDisplayMetrics = this.lr.lB.getResources().getDisplayMetrics();
          int k = this.lr.lz.getWidth();
          int m = this.lr.lz.getHeight();
          boolean bool2 = this.lr.lz.isShown();
          int n = 0;
          if (bool2)
          {
            int i1 = i + k;
            n = 0;
            if (i1 > 0)
            {
              int i2 = j + m;
              n = 0;
              if (i2 > 0)
              {
                int i3 = localDisplayMetrics.widthPixels;
                n = 0;
                if (i <= i3)
                {
                  int i4 = localDisplayMetrics.heightPixels;
                  n = 0;
                  if (j <= i4)
                    n = 1;
                }
              }
            }
          }
          localBundle1 = new Bundle(5);
          localBundle1.putInt("x", i);
          localBundle1.putInt("y", j);
          localBundle1.putInt("width", k);
          localBundle1.putInt("height", m);
          localBundle1.putInt("visible", n);
        }
      }
      String str = gb.cW();
      this.lr.lK = new ga(str, this.lr.lA);
      this.lr.lK.e(paramav);
      Bundle localBundle2 = gb.a(this.lr.lB, this, str);
      return new fi.a(localBundle1, paramav, this.lr.lH, this.lr.lA, localApplicationInfo, localPackageInfo1, str, gb.vK, this.lr.lD, localBundle2, this.lr.lS, paramBundle, gb.dc());
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      while (true)
        PackageInfo localPackageInfo1 = null;
    }
  }

  private gv a(v paramv)
  {
    if (this.lr.lH.og)
    {
      gv localgv2 = gv.a(this.lr.lB, this.lr.lH, false, false, this.lr.lC, this.lr.lD);
      localgv2.du().a(this, null, this, this, true, this, this, paramv);
      return localgv2;
    }
    View localView = this.lr.lz.getNextView();
    gv localgv1;
    if ((localView instanceof gv))
    {
      localgv1 = (gv)localView;
      localgv1.a(this.lr.lB, this.lr.lH);
    }
    while (true)
    {
      localgv1.du().a(this, this, this, this, false, this, paramv);
      return localgv1;
      if (localView != null)
        this.lr.lz.removeView(localView);
      localgv1 = gv.a(this.lr.lB, this.lr.lH, false, false, this.lr.lC, this.lr.lD);
      if (this.lr.lH.oh == null)
        c(localgv1);
    }
  }

  private void a(int paramInt)
  {
    gs.W("Failed to load ad: " + paramInt);
    if (this.lr.lE != null);
    try
    {
      this.lr.lE.onAdFailedToLoad(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gs.d("Could not call AdListener.onAdFailedToLoad().", localRemoteException);
    }
  }

  private void aa()
  {
    if ((Build.VERSION.SDK_INT >= 14) && (this.lr != null) && (this.lr.lB != null))
      this.lr.lB.unregisterComponentCallbacks(this.lv);
  }

  private void ak()
  {
    gs.U("Ad closing.");
    if (this.lr.lE != null);
    try
    {
      this.lr.lE.onAdClosed();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gs.d("Could not call AdListener.onAdClosed().", localRemoteException);
    }
  }

  private void al()
  {
    gs.U("Ad leaving application.");
    if (this.lr.lE != null);
    try
    {
      this.lr.lE.onAdLeftApplication();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gs.d("Could not call AdListener.onAdLeftApplication().", localRemoteException);
    }
  }

  private void am()
  {
    gs.U("Ad opening.");
    if (this.lr.lE != null);
    try
    {
      this.lr.lE.onAdOpened();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gs.d("Could not call AdListener.onAdOpened().", localRemoteException);
    }
  }

  private void an()
  {
    gs.U("Ad finished loading.");
    if (this.lr.lE != null);
    try
    {
      this.lr.lE.onAdLoaded();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gs.d("Could not call AdListener.onAdLoaded().", localRemoteException);
    }
  }

  private void ao()
  {
    try
    {
      if (((this.lr.lI.vu instanceof bo)) && (this.lr.lQ != null))
        this.lr.lQ.a((bo)this.lr.lI.vu);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gs.d("Could not call OnAppInstallAdLoadedListener.onAppInstallAdLoaded().", localRemoteException);
    }
  }

  private void ap()
  {
    try
    {
      if (((this.lr.lI.vu instanceof bp)) && (this.lr.lR != null))
        this.lr.lR.a((bp)this.lr.lI.vu);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gs.d("Could not call OnContentAdLoadedListener.onContentAdLoaded().", localRemoteException);
    }
  }

  private void at()
  {
    if (this.lr.lI != null)
    {
      if (this.lr.lW == 0)
        this.lr.lI.rN.destroy();
      this.lr.lI = null;
      this.lr.lX = false;
    }
  }

  // ERROR //
  private boolean b(fz paramfz)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 418	com/google/android/gms/internal/fz:tI	Z
    //   4: ifeq +193 -> 197
    //   7: aload_1
    //   8: getfield 422	com/google/android/gms/internal/fz:qz	Lcom/google/android/gms/internal/cu;
    //   11: invokeinterface 428 1 0
    //   16: invokestatic 434	com/google/android/gms/dynamic/e:f	(Lcom/google/android/gms/dynamic/d;)Ljava/lang/Object;
    //   19: checkcast 436	android/view/View
    //   22: astore 5
    //   24: aload_0
    //   25: getfield 63	com/google/android/gms/internal/u:lr	Lcom/google/android/gms/internal/u$b;
    //   28: getfield 145	com/google/android/gms/internal/u$b:lz	Lcom/google/android/gms/internal/u$a;
    //   31: invokevirtual 264	com/google/android/gms/internal/u$a:getNextView	()Landroid/view/View;
    //   34: astore 6
    //   36: aload 6
    //   38: ifnull +15 -> 53
    //   41: aload_0
    //   42: getfield 63	com/google/android/gms/internal/u:lr	Lcom/google/android/gms/internal/u$b;
    //   45: getfield 145	com/google/android/gms/internal/u$b:lz	Lcom/google/android/gms/internal/u$a;
    //   48: aload 6
    //   50: invokevirtual 274	com/google/android/gms/internal/u$a:removeView	(Landroid/view/View;)V
    //   53: aload_0
    //   54: aload 5
    //   56: invokespecial 281	com/google/android/gms/internal/u:c	(Landroid/view/View;)V
    //   59: aload_0
    //   60: getfield 63	com/google/android/gms/internal/u:lr	Lcom/google/android/gms/internal/u$b;
    //   63: getfield 145	com/google/android/gms/internal/u$b:lz	Lcom/google/android/gms/internal/u$a;
    //   66: invokevirtual 439	com/google/android/gms/internal/u$a:getChildCount	()I
    //   69: iconst_1
    //   70: if_icmple +13 -> 83
    //   73: aload_0
    //   74: getfield 63	com/google/android/gms/internal/u:lr	Lcom/google/android/gms/internal/u$b;
    //   77: getfield 145	com/google/android/gms/internal/u$b:lz	Lcom/google/android/gms/internal/u$a;
    //   80: invokevirtual 442	com/google/android/gms/internal/u$a:showNext	()V
    //   83: aload_0
    //   84: getfield 63	com/google/android/gms/internal/u:lr	Lcom/google/android/gms/internal/u$b;
    //   87: getfield 364	com/google/android/gms/internal/u$b:lI	Lcom/google/android/gms/internal/fz;
    //   90: ifnull +70 -> 160
    //   93: aload_0
    //   94: getfield 63	com/google/android/gms/internal/u:lr	Lcom/google/android/gms/internal/u$b;
    //   97: getfield 145	com/google/android/gms/internal/u$b:lz	Lcom/google/android/gms/internal/u$a;
    //   100: invokevirtual 264	com/google/android/gms/internal/u$a:getNextView	()Landroid/view/View;
    //   103: astore_2
    //   104: aload_2
    //   105: instanceof 248
    //   108: ifeq +162 -> 270
    //   111: aload_2
    //   112: checkcast 248	com/google/android/gms/internal/gv
    //   115: aload_0
    //   116: getfield 63	com/google/android/gms/internal/u:lr	Lcom/google/android/gms/internal/u$b;
    //   119: getfield 76	com/google/android/gms/internal/u$b:lB	Landroid/content/Context;
    //   122: aload_0
    //   123: getfield 63	com/google/android/gms/internal/u:lr	Lcom/google/android/gms/internal/u$b;
    //   126: getfield 136	com/google/android/gms/internal/u$b:lH	Lcom/google/android/gms/internal/ay;
    //   129: invokevirtual 267	com/google/android/gms/internal/gv:a	(Landroid/content/Context;Lcom/google/android/gms/internal/ay;)V
    //   132: aload_0
    //   133: getfield 63	com/google/android/gms/internal/u:lr	Lcom/google/android/gms/internal/u$b;
    //   136: getfield 364	com/google/android/gms/internal/u$b:lI	Lcom/google/android/gms/internal/fz;
    //   139: getfield 422	com/google/android/gms/internal/fz:qz	Lcom/google/android/gms/internal/cu;
    //   142: ifnull +18 -> 160
    //   145: aload_0
    //   146: getfield 63	com/google/android/gms/internal/u:lr	Lcom/google/android/gms/internal/u$b;
    //   149: getfield 364	com/google/android/gms/internal/u$b:lI	Lcom/google/android/gms/internal/fz;
    //   152: getfield 422	com/google/android/gms/internal/fz:qz	Lcom/google/android/gms/internal/cu;
    //   155: invokeinterface 443 1 0
    //   160: aload_0
    //   161: getfield 63	com/google/android/gms/internal/u:lr	Lcom/google/android/gms/internal/u$b;
    //   164: getfield 145	com/google/android/gms/internal/u$b:lz	Lcom/google/android/gms/internal/u$a;
    //   167: iconst_0
    //   168: invokevirtual 446	com/google/android/gms/internal/u$a:setVisibility	(I)V
    //   171: iconst_1
    //   172: ireturn
    //   173: astore 4
    //   175: ldc_w 448
    //   178: aload 4
    //   180: invokestatic 320	com/google/android/gms/internal/gs:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   183: iconst_0
    //   184: ireturn
    //   185: astore 7
    //   187: ldc_w 450
    //   190: aload 7
    //   192: invokestatic 320	com/google/android/gms/internal/gs:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   195: iconst_0
    //   196: ireturn
    //   197: aload_1
    //   198: getfield 453	com/google/android/gms/internal/fz:vr	Lcom/google/android/gms/internal/ay;
    //   201: ifnull -142 -> 59
    //   204: aload_1
    //   205: getfield 405	com/google/android/gms/internal/fz:rN	Lcom/google/android/gms/internal/gv;
    //   208: aload_1
    //   209: getfield 453	com/google/android/gms/internal/fz:vr	Lcom/google/android/gms/internal/ay;
    //   212: invokevirtual 456	com/google/android/gms/internal/gv:a	(Lcom/google/android/gms/internal/ay;)V
    //   215: aload_0
    //   216: getfield 63	com/google/android/gms/internal/u:lr	Lcom/google/android/gms/internal/u$b;
    //   219: getfield 145	com/google/android/gms/internal/u$b:lz	Lcom/google/android/gms/internal/u$a;
    //   222: invokevirtual 459	com/google/android/gms/internal/u$a:removeAllViews	()V
    //   225: aload_0
    //   226: getfield 63	com/google/android/gms/internal/u:lr	Lcom/google/android/gms/internal/u$b;
    //   229: getfield 145	com/google/android/gms/internal/u$b:lz	Lcom/google/android/gms/internal/u$a;
    //   232: aload_1
    //   233: getfield 453	com/google/android/gms/internal/fz:vr	Lcom/google/android/gms/internal/ay;
    //   236: getfield 460	com/google/android/gms/internal/ay:widthPixels	I
    //   239: invokevirtual 463	com/google/android/gms/internal/u$a:setMinimumWidth	(I)V
    //   242: aload_0
    //   243: getfield 63	com/google/android/gms/internal/u:lr	Lcom/google/android/gms/internal/u$b;
    //   246: getfield 145	com/google/android/gms/internal/u$b:lz	Lcom/google/android/gms/internal/u$a;
    //   249: aload_1
    //   250: getfield 453	com/google/android/gms/internal/fz:vr	Lcom/google/android/gms/internal/ay;
    //   253: getfield 464	com/google/android/gms/internal/ay:heightPixels	I
    //   256: invokevirtual 467	com/google/android/gms/internal/u$a:setMinimumHeight	(I)V
    //   259: aload_0
    //   260: aload_1
    //   261: getfield 405	com/google/android/gms/internal/fz:rN	Lcom/google/android/gms/internal/gv;
    //   264: invokespecial 281	com/google/android/gms/internal/u:c	(Landroid/view/View;)V
    //   267: goto -208 -> 59
    //   270: aload_2
    //   271: ifnull -139 -> 132
    //   274: aload_0
    //   275: getfield 63	com/google/android/gms/internal/u:lr	Lcom/google/android/gms/internal/u$b;
    //   278: getfield 145	com/google/android/gms/internal/u$b:lz	Lcom/google/android/gms/internal/u$a;
    //   281: aload_2
    //   282: invokevirtual 274	com/google/android/gms/internal/u$a:removeView	(Landroid/view/View;)V
    //   285: goto -153 -> 132
    //   288: astore_3
    //   289: ldc_w 469
    //   292: invokestatic 305	com/google/android/gms/internal/gs:W	(Ljava/lang/String;)V
    //   295: goto -135 -> 160
    //
    // Exception table:
    //   from	to	target	type
    //   7	24	173	android/os/RemoteException
    //   53	59	185	java/lang/Throwable
    //   145	160	288	android/os/RemoteException
  }

  private void c(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-2, -2);
    this.lr.lz.addView(paramView, localLayoutParams);
  }

  private void c(boolean paramBoolean)
  {
    if (this.lr.lI == null)
      gs.W("Ad state was null when trying to ping impression URLs.");
    do
    {
      return;
      gs.S("Pinging Impression URLs.");
      this.lr.lK.cO();
      if (this.lr.lI.qg != null)
        gj.a(this.lr.lB, this.lr.lD.wD, this.lr.lI.qg);
      if ((this.lr.lI.vq != null) && (this.lr.lI.vq.qg != null))
        cr.a(this.lr.lB, this.lr.lD.wD, this.lr.lI, this.lr.lA, paramBoolean, this.lr.lI.vq.qg);
    }
    while ((this.lr.lI.qy == null) || (this.lr.lI.qy.qb == null));
    cr.a(this.lr.lB, this.lr.lD.wD, this.lr.lI, this.lr.lA, paramBoolean, this.lr.lI.qy.qb);
  }

  public d X()
  {
    o.aT("getAdFrame must be called on the main UI thread.");
    return e.k(this.lr.lz);
  }

  public ay Y()
  {
    o.aT("getAdSize must be called on the main UI thread.");
    return this.lr.lH;
  }

  Bundle a(an paraman)
  {
    if (paraman == null);
    while (true)
    {
      return null;
      if (paraman.aZ())
        paraman.wakeup();
      ak localak = paraman.aX();
      String str;
      if (localak != null)
      {
        str = localak.aO();
        gs.S("In AdManger: loadAd, " + localak.toString());
      }
      while (str != null)
      {
        Bundle localBundle = new Bundle(1);
        localBundle.putString("fingerprint", str);
        return localBundle;
        str = null;
      }
    }
  }

  public void a(ay paramay)
  {
    o.aT("setAdSize must be called on the main UI thread.");
    this.lr.lH = paramay;
    if ((this.lr.lI != null) && (this.lr.lW == 0))
      this.lr.lI.rN.a(paramay);
    if (this.lr.lz.getChildCount() > 1)
      this.lr.lz.removeView(this.lr.lz.getNextView());
    this.lr.lz.setMinimumWidth(paramay.widthPixels);
    this.lr.lz.setMinimumHeight(paramay.heightPixels);
    this.lr.lz.requestLayout();
  }

  public void a(bc parambc)
  {
    o.aT("setAdListener must be called on the main UI thread.");
    this.lr.lE = parambc;
  }

  public void a(bf parambf)
  {
    o.aT("setAppEventListener must be called on the main UI thread.");
    this.lr.lL = parambf;
  }

  public void a(eh parameh)
  {
    o.aT("setInAppPurchaseListener must be called on the main UI thread.");
    this.lr.lN = parameh;
  }

  public void a(el paramel, String paramString)
  {
    o.aT("setPlayStorePurchaseParams must be called on the main UI thread.");
    this.lr.lT = new ee(paramString);
    this.lr.lM = paramel;
    if ((!gb.da()) && (paramel != null))
      new dx(this.lr.lB, this.lr.lM, this.lr.lT).start();
  }

  public void a(et paramet)
  {
    o.aT("setRawHtmlPublisherAdViewListener must be called on the main UI thread.");
    this.lr.lO = paramet;
  }

  public void a(eu parameu)
  {
    o.aT("setRawHtmlPublisherInterstitialAdListener must be called on the main UI thread.");
    this.lr.lP = parameu;
  }

  public void a(fz.a parama)
  {
    this.lr.lF = null;
    this.lr.lJ = parama;
    a(null);
    gv localgv;
    if (!parama.vw.tS)
    {
      final v localv = new v();
      localgv = a(localv);
      localv.a(new v.b(parama, localgv));
      localgv.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          localv.ar();
          return false;
        }
      });
      localgv.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          localv.ar();
        }
      });
    }
    while (true)
    {
      if (parama.lH != null)
        this.lr.lH = parama.lH;
      if (parama.errorCode != -2)
      {
        a(new fz(parama, localgv, null, null, null, null, null));
        return;
      }
      if ((!parama.vw.tI) && (parama.vw.tR))
      {
        String str1 = parama.vw.rP;
        String str2 = null;
        if (str1 != null)
          str2 = Uri.parse(parama.vw.rP).buildUpon().query(null).build().toString();
        er localer = new er(this, str2, parama.vw.tG);
        try
        {
          if ((this.lr.lO != null) && (!this.lr.lH.og) && (this.lr.lO.e(str2, parama.vw.tG)))
          {
            this.lr.lW = 1;
            this.lr.lO.a(localer);
            return;
          }
        }
        catch (RemoteException localRemoteException1)
        {
          gs.d("Could not call the rawHtmlPublisherAdViewListener.", localRemoteException1);
          try
          {
            if ((this.lr.lP != null) && (this.lr.lH.og) && (this.lr.lP.e(str2, parama.vw.tG)))
            {
              this.lr.lW = 1;
              this.lr.lP.a(localer);
              return;
            }
          }
          catch (RemoteException localRemoteException2)
          {
            gs.d("Could not call the RawHtmlPublisherInterstitialAdListener.", localRemoteException2);
          }
        }
      }
      this.lr.lW = 0;
      b localb = this.lr;
      Context localContext = this.lr.lB;
      ct localct = this.lq;
      localb.lG = fd.a(localContext, this, parama, localgv, localct, this);
      return;
      localgv = null;
    }
  }

  public void a(fz paramfz)
  {
    this.lr.lG = null;
    if (paramfz.vu != null);
    for (boolean bool = true; ; bool = false)
    {
      if ((paramfz.errorCode != -2) && (paramfz.errorCode != 3))
        gb.b(this.lr.au());
      if (paramfz.errorCode != -1)
        break;
      return;
    }
    if (a(paramfz, bool))
      gs.S("Ad refresh scheduled.");
    if ((paramfz.errorCode == 3) && (paramfz.vq != null) && (paramfz.vq.qh != null))
    {
      gs.S("Pinging no fill URLs.");
      cr.a(this.lr.lB, this.lr.lD.wD, paramfz, this.lr.lA, false, paramfz.vq.qh);
    }
    if (paramfz.errorCode != -2)
    {
      a(paramfz.errorCode);
      return;
    }
    if ((!this.lr.lH.og) && (!bool) && (this.lr.lW == 0))
    {
      if (!b(paramfz))
      {
        a(0);
        return;
      }
      if (this.lr.lz != null)
        a.a(this.lr.lz).Q(paramfz.tN);
    }
    if ((this.lr.lI != null) && (this.lr.lI.qB != null))
      this.lr.lI.qB.a(null);
    if (paramfz.qB != null)
      paramfz.qB.a(this);
    this.lt.d(this.lr.lI);
    this.lr.lI = paramfz;
    this.lr.lK.j(paramfz.vs);
    this.lr.lK.k(paramfz.vt);
    this.lr.lK.t(this.lr.lH.og);
    this.lr.lK.u(paramfz.tI);
    if ((!this.lr.lH.og) && (!bool) && (this.lr.lW == 0))
      c(false);
    if (this.lr.lU == null)
      this.lr.lU = new ge(this.lr.lA);
    int j;
    int i;
    if (paramfz.vq != null)
    {
      j = paramfz.vq.qk;
      i = paramfz.vq.ql;
    }
    while (true)
    {
      this.lr.lU.d(j, i);
      if (this.lr.lW == 0)
      {
        if ((!this.lr.lH.og) && (paramfz.rN != null) && ((paramfz.rN.du().dE()) || (paramfz.vp != null)))
        {
          af localaf = this.lt.a(this.lr.lH, this.lr.lI);
          if ((paramfz.rN.du().dE()) && (localaf != null))
            localaf.a(new z(paramfz.rN));
        }
        if (this.lr.lI.rN != null)
        {
          this.lr.lI.rN.bS();
          this.lr.lI.rN.du().dF();
        }
        bq.a locala;
        if (bool)
        {
          locala = paramfz.vu;
          if ((!(locala instanceof bp)) || (this.lr.lR == null))
            break label648;
          ap();
        }
        while (true)
        {
          an();
          return;
          label648: if ((!(locala instanceof bo)) || (this.lr.lQ == null))
            break;
          ao();
        }
        gs.W("No matching listener for retrieved native ad template.");
        a(0);
        return;
      }
      if ((this.lr.lV == null) || (paramfz.vp == null))
        break;
      this.lt.a(this.lr.lB, this.lr.lH, this.lr.lI, this.lr.lV, this.lr.lD);
      return;
      i = 0;
      j = 0;
    }
  }

  public void a(String paramString, ArrayList<String> paramArrayList)
  {
    dy localdy = new dy(paramString, paramArrayList, this.lr.lB, this.lr.lD.wD);
    if (this.lr.lN == null)
    {
      gs.W("InAppPurchaseListener is not set. Try to launch default purchase flow.");
      if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.lr.lB) != 0)
        gs.W("Google Play Service unavailable, cannot launch default purchase flow.");
      while (true)
      {
        return;
        if (this.lr.lM == null)
        {
          gs.W("PlayStorePurchaseListener is not set.");
          return;
        }
        if (this.lr.lT == null)
        {
          gs.W("PlayStorePurchaseVerifier is not initialized.");
          return;
        }
        try
        {
          boolean bool = this.lr.lM.isValidPurchase(paramString);
          if (bool)
          {
            dz.a(this.lr.lB, this.lr.lD.wG, new dv(localdy, this.lr.lM, this.lr.lT, this.lr.lB));
            return;
          }
        }
        catch (RemoteException localRemoteException2)
        {
          while (true)
            gs.W("Could not start In-App purchase.");
        }
      }
    }
    try
    {
      this.lr.lN.a(localdy);
      return;
    }
    catch (RemoteException localRemoteException1)
    {
      gs.W("Could not start In-App purchase.");
    }
  }

  public void a(HashSet<ga> paramHashSet)
  {
    this.lr.a(paramHashSet);
  }

  public void a(List<String> paramList)
  {
    o.aT("setNativeTemplates must be called on the main UI thread.");
    this.lr.lS = paramList;
  }

  public boolean a(av paramav)
  {
    o.aT("loadAd must be called on the main UI thread.");
    if ((this.lr.lF != null) || (this.lr.lG != null))
    {
      if (this.lp != null)
        gs.W("Aborting last ad request since another ad request is already in progress. The current request object will still be cached for future refreshes.");
      this.lp = paramav;
    }
    do
    {
      return false;
      if ((this.lr.lH.og) && (this.lr.lI != null))
      {
        gs.W("An interstitial is already loading. Aborting.");
        return false;
      }
    }
    while (!aq());
    gs.U("Starting ad request.");
    if (!paramav.nW)
      gs.U("Use AdRequest.Builder.addTestDevice(\"" + gr.v(this.lr.lB) + "\") to get test ads on this device.");
    Bundle localBundle = a(gb.cU().l(this.lr.lB));
    this.ls.cancel();
    this.lr.lW = 0;
    fi.a locala = a(paramav, localBundle);
    this.lr.lF = fa.a(this.lr.lB, locala, this.lr.lC, this);
    return true;
  }

  boolean a(fz paramfz, boolean paramBoolean)
  {
    boolean bool1 = false;
    av localav;
    boolean bool2;
    if (this.lp != null)
    {
      localav = this.lp;
      this.lp = null;
      bool2 = bool1 | paramBoolean;
      if (!this.lr.lH.og)
        break label99;
      if (this.lr.lW == 0)
        gj.a(paramfz.rN);
    }
    while (true)
    {
      return this.ls.ay();
      localav = paramfz.tx;
      Bundle localBundle = localav.extras;
      bool1 = false;
      if (localBundle == null)
        break;
      bool1 = localav.extras.getBoolean("_noRefresh", false);
      break;
      label99: if ((!bool2) && (this.lr.lW == 0))
        if (paramfz.qj > 0L)
          this.ls.a(localav, paramfz.qj);
        else if ((paramfz.vq != null) && (paramfz.vq.qj > 0L))
          this.ls.a(localav, paramfz.vq.qj);
        else if ((!paramfz.tI) && (paramfz.errorCode == 2))
          this.ls.c(localav);
    }
  }

  public void ab()
  {
    al();
  }

  public void ac()
  {
    this.lt.d(this.lr.lI);
    if (this.lr.lH.og)
      at();
    this.lu = false;
    ak();
    this.lr.lK.cQ();
  }

  public void ad()
  {
    if (this.lr.lH.og)
      c(false);
    this.lu = true;
    am();
  }

  public void ae()
  {
    onAdClicked();
  }

  public void af()
  {
    ac();
  }

  public void ag()
  {
    ab();
  }

  public void ah()
  {
    ad();
  }

  public void ai()
  {
    if (this.lr.lI != null)
      gs.W("Mediation adapter " + this.lr.lI.qA + " refreshed, but mediation adapters should never refresh.");
    c(true);
    an();
  }

  public void aj()
  {
    o.aT("recordManualImpression must be called on the main UI thread.");
    if (this.lr.lI == null)
      gs.W("Ad state was null when trying to ping manual tracking URLs.");
    do
    {
      return;
      gs.S("Pinging manual tracking URLs.");
    }
    while (this.lr.lI.tK == null);
    gj.a(this.lr.lB, this.lr.lD.wD, this.lr.lI.tK);
  }

  public boolean aq()
  {
    boolean bool = true;
    if (!gj.a(this.lr.lB.getPackageManager(), this.lr.lB.getPackageName(), "android.permission.INTERNET"))
    {
      if (!this.lr.lH.og)
        gr.a(this.lr.lz, this.lr.lH, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
      bool = false;
    }
    if (!gj.p(this.lr.lB))
    {
      if (!this.lr.lH.og)
        gr.a(this.lr.lz, this.lr.lH, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
      bool = false;
    }
    if ((!bool) && (!this.lr.lH.og))
      this.lr.lz.setVisibility(0);
    return bool;
  }

  public void ar()
  {
    if (this.lr.lI == null)
      gs.W("Ad state was null when trying to ping click URLs.");
    do
    {
      return;
      gs.S("Pinging click URLs.");
      this.lr.lK.cP();
      if (this.lr.lI.qf != null)
        gj.a(this.lr.lB, this.lr.lD.wD, this.lr.lI.qf);
    }
    while ((this.lr.lI.vq == null) || (this.lr.lI.vq.qf == null));
    cr.a(this.lr.lB, this.lr.lD.wD, this.lr.lI, this.lr.lA, false, this.lr.lI.vq.qf);
  }

  public void as()
  {
    c(false);
  }

  public void b(View paramView)
  {
    this.lr.lV = paramView;
    a(new fz(this.lr.lJ, null, null, null, null, null, null));
  }

  public void b(av paramav)
  {
    ViewParent localViewParent = this.lr.lz.getParent();
    if (((localViewParent instanceof View)) && (((View)localViewParent).isShown()) && (gj.dk()) && (!this.lu))
    {
      a(paramav);
      return;
    }
    gs.U("Ad is not visible. Not refreshing ad.");
    this.ls.c(paramav);
  }

  public void b(boolean paramBoolean)
  {
    this.lr.lX = paramBoolean;
  }

  public void destroy()
  {
    o.aT("destroy must be called on the main UI thread.");
    aa();
    this.lr.lE = null;
    this.lr.lL = null;
    this.lr.lM = null;
    this.lr.lN = null;
    this.lr.lO = null;
    this.lr.lP = null;
    this.ls.cancel();
    this.lt.stop();
    stopLoading();
    if (this.lr.lz != null)
      this.lr.lz.removeAllViews();
    if ((this.lr.lI != null) && (this.lr.lI.rN != null))
      this.lr.lI.rN.destroy();
    if ((this.lr.lI != null) && (this.lr.lI.qz != null));
    try
    {
      this.lr.lI.qz.destroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gs.W("Could not destroy mediation adapter.");
    }
  }

  public String getMediationAdapterClassName()
  {
    if (this.lr.lI != null)
      return this.lr.lI.qA;
    return null;
  }

  public boolean isReady()
  {
    o.aT("isLoaded must be called on the main UI thread.");
    return (this.lr.lF == null) && (this.lr.lG == null) && (this.lr.lI != null);
  }

  public void onAdClicked()
  {
    ar();
  }

  public void onAppEvent(String paramString1, String paramString2)
  {
    if (this.lr.lL != null);
    try
    {
      this.lr.lL.onAppEvent(paramString1, paramString2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gs.d("Could not call the AppEventListener.", localRemoteException);
    }
  }

  public void pause()
  {
    o.aT("pause must be called on the main UI thread.");
    if ((this.lr.lI != null) && (this.lr.lW == 0))
      gj.a(this.lr.lI.rN);
    if ((this.lr.lI != null) && (this.lr.lI.qz != null));
    try
    {
      this.lr.lI.qz.pause();
      this.lt.pause();
      this.ls.pause();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        gs.W("Could not pause mediation adapter.");
    }
  }

  public void resume()
  {
    o.aT("resume must be called on the main UI thread.");
    if ((this.lr.lI != null) && (this.lr.lW == 0))
      gj.b(this.lr.lI.rN);
    if ((this.lr.lI != null) && (this.lr.lI.qz != null));
    try
    {
      this.lr.lI.qz.resume();
      this.ls.resume();
      this.lt.resume();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        gs.W("Could not resume mediation adapter.");
    }
  }

  public void showInterstitial()
  {
    o.aT("showInterstitial must be called on the main UI thread.");
    if (!this.lr.lH.og)
      gs.W("Cannot call showInterstitial on a banner ad.");
    do
    {
      return;
      if (this.lr.lI == null)
      {
        gs.W("The interstitial has not loaded.");
        return;
      }
    }
    while (this.lr.lW == 1);
    if (this.lr.lI.rN.dy())
    {
      gs.W("The interstitial is already showing.");
      return;
    }
    this.lr.lI.rN.x(true);
    if ((this.lr.lI.rN.du().dE()) || (this.lr.lI.vp != null))
    {
      af localaf = this.lt.a(this.lr.lH, this.lr.lI);
      if ((this.lr.lI.rN.du().dE()) && (localaf != null))
        localaf.a(new z(this.lr.lI.rN));
    }
    if (this.lr.lI.tI)
      try
      {
        this.lr.lI.qz.showInterstitial();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        gs.d("Could not show interstitial.", localRemoteException);
        at();
        return;
      }
    x localx = new x(this.lr.lX, false);
    boolean bool1;
    if ((this.lr.lB instanceof Activity))
    {
      Window localWindow = ((Activity)this.lr.lB).getWindow();
      Rect localRect1 = new Rect();
      Rect localRect2 = new Rect();
      localWindow.getDecorView().getGlobalVisibleRect(localRect1);
      localWindow.getDecorView().getWindowVisibleDisplayFrame(localRect2);
      if ((localRect1.bottom != 0) && (localRect2.bottom != 0))
      {
        bool1 = this.lr.lX;
        if (localRect1.top != localRect2.top)
          break label430;
      }
    }
    label430: for (boolean bool2 = true; ; bool2 = false)
    {
      localx = new x(bool1, bool2);
      dm localdm = new dm(this, this, this, this.lr.lI.rN, this.lr.lI.orientation, this.lr.lD, this.lr.lI.tN, localx);
      dk.a(this.lr.lB, localdm);
      return;
    }
  }

  public void stopLoading()
  {
    o.aT("stopLoading must be called on the main UI thread.");
    if ((this.lr.lI != null) && (this.lr.lW == 0))
    {
      this.lr.lI.rN.stopLoading();
      this.lr.lI = null;
    }
    if (this.lr.lF != null)
      this.lr.lF.cancel();
    if (this.lr.lG != null)
      this.lr.lG.cancel();
  }

  @ez
  private static final class a extends ViewSwitcher
  {
    private final gm ly;

    public a(Context paramContext)
    {
      super();
      this.ly = new gm(paramContext);
    }

    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      this.ly.c(paramMotionEvent);
      return false;
    }
  }

  @ez
  static class b
  {
    public final String lA;
    public final Context lB;
    public final k lC;
    public final gt lD;
    public bc lE;
    public gg lF;
    public gg lG;
    public ay lH;
    public fz lI;
    public fz.a lJ;
    public ga lK;
    public bf lL;
    public el lM;
    public eh lN;
    public et lO;
    public eu lP;
    public bt lQ;
    public bu lR;
    public List<String> lS;
    public ee lT;
    public ge lU = null;
    public View lV = null;
    public int lW = 0;
    public boolean lX = false;
    private HashSet<ga> lY = null;
    public final u.a lz;

    public b(Context paramContext, ay paramay, String paramString, gt paramgt)
    {
      if (paramay.og)
        this.lz = null;
      while (true)
      {
        this.lH = paramay;
        this.lA = paramString;
        this.lB = paramContext;
        this.lD = paramgt;
        this.lC = new k(new w(this));
        return;
        this.lz = new u.a(paramContext);
        this.lz.setMinimumWidth(paramay.widthPixels);
        this.lz.setMinimumHeight(paramay.heightPixels);
        this.lz.setVisibility(4);
      }
    }

    public void a(HashSet<ga> paramHashSet)
    {
      this.lY = paramHashSet;
    }

    public HashSet<ga> au()
    {
      return this.lY;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.u
 * JD-Core Version:    0.6.2
 */