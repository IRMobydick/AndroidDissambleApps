package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.google.ads.mediation.admob.AdMobAdapter;
import java.util.List;

@ez
public class fe extends gg
  implements gw.a
{
  private final ct lq;
  private final Context mContext;
  private final gv md;
  private final Object mw = new Object();
  private cm pR;
  private final Object sV = new Object();
  private fk sZ;
  private final fd.a tm;
  private final fz.a tn;
  private boolean to = false;
  private ck tp;
  private cq tq;

  public fe(Context paramContext, fz.a parama, gv paramgv, ct paramct, fd.a parama1)
  {
    this.mContext = paramContext;
    this.tn = parama;
    this.sZ = parama.vw;
    this.md = paramgv;
    this.lq = paramct;
    this.tm = parama1;
    this.pR = parama.vq;
  }

  private void a(fi paramfi, long paramLong)
    throws fe.a
  {
    synchronized (this.sV)
    {
      this.tp = new ck(this.mContext, paramfi, this.lq, this.pR);
      this.tq = this.tp.a(paramLong, 60000L);
      switch (this.tq.qx)
      {
      default:
        throw new a("Unexpected mediation result: " + this.tq.qx, 0);
      case 1:
      case 0:
      }
    }
    throw new a("No fill from any mediation ad networks.", 3);
  }

  private boolean c(long paramLong)
    throws fe.a
  {
    long l = 60000L - (SystemClock.elapsedRealtime() - paramLong);
    if (l <= 0L)
      return false;
    try
    {
      this.mw.wait(l);
      return true;
    }
    catch (InterruptedException localInterruptedException)
    {
    }
    throw new a("Ad request cancelled.", -1);
  }

  private void f(long paramLong)
    throws fe.a
  {
    gr.wC.post(new Runnable()
    {
      public void run()
      {
        while (true)
        {
          synchronized (fe.a(fe.this))
          {
            if (fe.c(fe.this).errorCode != -2)
              return;
            fe.d(fe.this).du().a(fe.this);
            if (fe.c(fe.this).errorCode == -3)
            {
              gs.V("Loading URL in WebView: " + fe.c(fe.this).rP);
              fe.d(fe.this).loadUrl(fe.c(fe.this).rP);
              return;
            }
          }
          gs.V("Loading HTML in WebView.");
          fe.d(fe.this).loadDataWithBaseURL(gj.L(fe.c(fe.this).rP), fe.c(fe.this).tG, "text/html", "UTF-8", null);
        }
      }
    });
    h(paramLong);
  }

  private void h(long paramLong)
    throws fe.a
  {
    do
      if (!c(paramLong))
        throw new a("Timed out waiting for WebView to finish loading.", 2);
    while (!this.to);
  }

  public void a(gv paramgv)
  {
    synchronized (this.mw)
    {
      gs.S("WebView finished loading.");
      this.to = true;
      this.mw.notify();
      return;
    }
  }

  public void co()
  {
    while (true)
    {
      int i;
      long l2;
      synchronized (this.mw)
      {
        gs.S("AdRendererBackgroundTask started.");
        fi localfi = this.tn.vv;
        i = this.tn.errorCode;
        try
        {
          l2 = SystemClock.elapsedRealtime();
          if (this.sZ.tI)
          {
            a(localfi, l2);
            av localav = localfi.tx;
            gv localgv = this.md;
            List localList1 = this.sZ.qf;
            List localList2 = this.sZ.qg;
            List localList3 = this.sZ.tK;
            int j = this.sZ.orientation;
            long l1 = this.sZ.qj;
            String str1 = localfi.tA;
            boolean bool = this.sZ.tI;
            if (this.tq == null)
              break label457;
            localcl = this.tq.qy;
            if (this.tq == null)
              break label463;
            localcu = this.tq.qz;
            if (this.tq == null)
              break label436;
            localObject3 = this.tq.qA;
            cm localcm = this.pR;
            if (this.tq == null)
              break label451;
            localco = this.tq.qB;
            final fz localfz = new fz(localav, localgv, localList1, i, localList2, localList3, j, l1, str1, bool, localcl, localcu, (String)localObject3, localcm, localco, this.sZ.tJ, this.tn.lH, this.sZ.tH, this.tn.vs, this.sZ.tM, this.sZ.tN, this.tn.vp, null);
            gr.wC.post(new Runnable()
            {
              public void run()
              {
                synchronized (fe.a(fe.this))
                {
                  fe.b(fe.this).a(localfz);
                  return;
                }
              }
            });
            return;
          }
          if (!this.sZ.tO)
            break label393;
          g(l2);
          continue;
        }
        catch (a locala)
        {
          i = locala.getErrorCode();
          if (i == 3)
            continue;
        }
        if (i != -1)
          break label402;
        gs.U(locala.getMessage());
        if (this.sZ != null)
          break label413;
        this.sZ = new fk(i);
        gr.wC.post(new Runnable()
        {
          public void run()
          {
            fe.this.onStop();
          }
        });
      }
      label393: f(l2);
      continue;
      label402: gs.W(locala.getMessage());
      continue;
      label413: this.sZ = new fk(i, this.sZ.qj);
      continue;
      label436: String str2 = AdMobAdapter.class.getName();
      Object localObject3 = str2;
      continue;
      label451: co localco = null;
      continue;
      label457: cl localcl = null;
      continue;
      label463: cu localcu = null;
    }
  }

  protected void g(long paramLong)
    throws fe.a
  {
    ay localay = this.md.Y();
    int i;
    if (localay.og)
      i = this.mContext.getResources().getDisplayMetrics().widthPixels;
    final fc localfc;
    for (int j = this.mContext.getResources().getDisplayMetrics().heightPixels; ; j = localay.heightPixels)
    {
      localfc = new fc(this, this.md, i, j);
      gr.wC.post(new Runnable()
      {
        public void run()
        {
          synchronized (fe.a(fe.this))
          {
            if (fe.c(fe.this).errorCode != -2)
              return;
            fe.d(fe.this).du().a(fe.this);
            localfc.b(fe.c(fe.this));
            return;
          }
        }
      });
      h(paramLong);
      if (!localfc.cA())
        break;
      gs.S("Ad-Network indicated no fill with passback URL.");
      throw new a("AdNetwork sent passback url", 3);
      i = localay.widthPixels;
    }
    if (!localfc.cB())
      throw new a("AdNetwork timed out", 2);
  }

  public void onStop()
  {
    synchronized (this.sV)
    {
      this.md.stopLoading();
      gj.a(this.md);
      if (this.tp != null)
        this.tp.cancel();
      return;
    }
  }

  private static final class a extends Exception
  {
    private final int tc;

    public a(String paramString, int paramInt)
    {
      super();
      this.tc = paramInt;
    }

    public int getErrorCode()
    {
      return this.tc;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fe
 * JD-Core Version:    0.6.2
 */