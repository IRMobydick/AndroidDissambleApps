package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

@ez
public class ga
{
  private final Object mw = new Object();
  private boolean uC = false;
  private final String vA;
  private long vB = -1L;
  private long vC = -1L;
  private long vD = -1L;
  private long vE = 0L;
  private long vF = -1L;
  private long vG = -1L;
  private final gb vx;
  private final LinkedList<a> vy;
  private final String vz;

  public ga(gb paramgb, String paramString1, String paramString2)
  {
    this.vx = paramgb;
    this.vz = paramString1;
    this.vA = paramString2;
    this.vy = new LinkedList();
  }

  public ga(String paramString1, String paramString2)
  {
    this(gb.cU(), paramString1, paramString2);
  }

  public void cO()
  {
    synchronized (this.mw)
    {
      if ((this.vG != -1L) && (this.vC == -1L))
      {
        this.vC = SystemClock.elapsedRealtime();
        this.vx.a(this);
      }
      gb.cY().cO();
      return;
    }
  }

  public void cP()
  {
    synchronized (this.mw)
    {
      if (this.vG != -1L)
      {
        a locala = new a();
        locala.cT();
        this.vy.add(locala);
        this.vE = (1L + this.vE);
        gb.cY().cP();
        this.vx.a(this);
      }
      return;
    }
  }

  public void cQ()
  {
    synchronized (this.mw)
    {
      if ((this.vG != -1L) && (!this.vy.isEmpty()))
      {
        a locala = (a)this.vy.getLast();
        if (locala.cR() == -1L)
        {
          locala.cS();
          this.vx.a(this);
        }
      }
      return;
    }
  }

  public void e(av paramav)
  {
    synchronized (this.mw)
    {
      this.vF = SystemClock.elapsedRealtime();
      gb.cY().b(paramav, this.vF);
      return;
    }
  }

  public void j(long paramLong)
  {
    synchronized (this.mw)
    {
      this.vG = paramLong;
      if (this.vG != -1L)
        this.vx.a(this);
      return;
    }
  }

  public void k(long paramLong)
  {
    synchronized (this.mw)
    {
      if (this.vG != -1L)
      {
        this.vB = paramLong;
        this.vx.a(this);
      }
      return;
    }
  }

  public void t(boolean paramBoolean)
  {
    synchronized (this.mw)
    {
      if (this.vG != -1L)
      {
        this.vD = SystemClock.elapsedRealtime();
        if (!paramBoolean)
        {
          this.vC = this.vD;
          this.vx.a(this);
        }
      }
      return;
    }
  }

  public Bundle toBundle()
  {
    Bundle localBundle;
    ArrayList localArrayList;
    synchronized (this.mw)
    {
      localBundle = new Bundle();
      localBundle.putString("seq_num", this.vz);
      localBundle.putString("slotid", this.vA);
      localBundle.putBoolean("ismediation", this.uC);
      localBundle.putLong("treq", this.vF);
      localBundle.putLong("tresponse", this.vG);
      localBundle.putLong("timp", this.vC);
      localBundle.putLong("tload", this.vD);
      localBundle.putLong("pcc", this.vE);
      localBundle.putLong("tfetch", this.vB);
      localArrayList = new ArrayList();
      Iterator localIterator = this.vy.iterator();
      if (localIterator.hasNext())
        localArrayList.add(((a)localIterator.next()).toBundle());
    }
    localBundle.putParcelableArrayList("tclick", localArrayList);
    return localBundle;
  }

  public void u(boolean paramBoolean)
  {
    synchronized (this.mw)
    {
      if (this.vG != -1L)
      {
        this.uC = paramBoolean;
        this.vx.a(this);
      }
      return;
    }
  }

  @ez
  private static final class a
  {
    private long vH = -1L;
    private long vI = -1L;

    public long cR()
    {
      return this.vI;
    }

    public void cS()
    {
      this.vI = SystemClock.elapsedRealtime();
    }

    public void cT()
    {
      this.vH = SystemClock.elapsedRealtime();
    }

    public Bundle toBundle()
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("topen", this.vH);
      localBundle.putLong("tclose", this.vI);
      return localBundle;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ga
 * JD-Core Version:    0.6.2
 */