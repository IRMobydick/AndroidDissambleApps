package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@ez
public class fn extends gg
{
  private final Object mw = new Object();
  private final fk sZ;
  private final fo tU;
  private Future<fz> tV;
  private final fd.a tm;
  private final fz.a tn;

  public fn(Context paramContext, u paramu, ai paramai, fz.a parama, fd.a parama1)
  {
    this(parama, parama1, new fo(paramContext, paramu, paramai, new go(), parama));
  }

  fn(fz.a parama, fd.a parama1, fo paramfo)
  {
    this.tn = parama;
    this.sZ = parama.vw;
    this.tm = parama1;
    this.tU = paramfo;
  }

  private fz r(int paramInt)
  {
    return new fz(this.tn.vv.tx, null, null, paramInt, null, null, this.sZ.orientation, this.sZ.qj, this.tn.vv.tA, false, null, null, null, null, null, this.sZ.tJ, this.tn.lH, this.sZ.tH, this.tn.vs, this.sZ.tM, this.sZ.tN, this.tn.vp, null);
  }

  public void co()
  {
    try
    {
      synchronized (this.mw)
      {
        this.tV = gi.submit(this.tU);
        localfz = (fz)this.tV.get(60000L, TimeUnit.MILLISECONDS);
        i = -2;
        if (localfz != null)
        {
          gr.wC.post(new Runnable()
          {
            public void run()
            {
              fn.a(fn.this).a(localfz);
            }
          });
          return;
        }
      }
    }
    catch (TimeoutException localTimeoutException)
    {
      while (true)
      {
        gs.W("Timed out waiting for native ad.");
        i = 2;
        localfz = null;
      }
    }
    catch (ExecutionException localExecutionException)
    {
      while (true)
      {
        localfz = null;
        i = 0;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      while (true)
      {
        i = -1;
        localfz = null;
      }
    }
    catch (CancellationException localCancellationException)
    {
      while (true)
      {
        int i = -1;
        final fz localfz = null;
        continue;
        localfz = r(i);
      }
    }
  }

  public void onStop()
  {
    synchronized (this.mw)
    {
      if (this.tV != null)
        this.tV.cancel(true);
      return;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fn
 * JD-Core Version:    0.6.2
 */