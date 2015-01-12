package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import java.util.Iterator;
import java.util.List;

@ez
public final class ck
{
  private final ct lq;
  private final Context mContext;
  private final Object mw = new Object();
  private final fi pQ;
  private final cm pR;
  private boolean pS = false;
  private cp pT;

  public ck(Context paramContext, fi paramfi, ct paramct, cm paramcm)
  {
    this.mContext = paramContext;
    this.pQ = paramfi;
    this.lq = paramct;
    this.pR = paramcm;
  }

  public cq a(long paramLong1, long paramLong2)
  {
    gs.S("Starting mediation.");
    Iterator localIterator1 = this.pR.qd.iterator();
    while (localIterator1.hasNext())
    {
      cl localcl = (cl)localIterator1.next();
      gs.U("Trying mediation network: " + localcl.pX);
      Iterator localIterator2 = localcl.pY.iterator();
      while (localIterator2.hasNext())
      {
        String str = (String)localIterator2.next();
        final cq localcq2;
        synchronized (this.mw)
        {
          if (this.pS)
          {
            cq localcq1 = new cq(-1);
            return localcq1;
          }
          this.pT = new cp(this.mContext, str, this.lq, this.pR, localcl, this.pQ.tx, this.pQ.lH, this.pQ.lD);
          localcq2 = this.pT.b(paramLong1, paramLong2);
          if (localcq2.qx == 0)
          {
            gs.S("Adapter succeeded.");
            return localcq2;
          }
        }
        if (localcq2.qz != null)
          gr.wC.post(new Runnable()
          {
            public void run()
            {
              try
              {
                localcq2.qz.destroy();
                return;
              }
              catch (RemoteException localRemoteException)
              {
                gs.d("Could not destroy mediation adapter.", localRemoteException);
              }
            }
          });
      }
    }
    return new cq(1);
  }

  public void cancel()
  {
    synchronized (this.mw)
    {
      this.pS = true;
      if (this.pT != null)
        this.pT.cancel();
      return;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ck
 * JD-Core Version:    0.6.2
 */