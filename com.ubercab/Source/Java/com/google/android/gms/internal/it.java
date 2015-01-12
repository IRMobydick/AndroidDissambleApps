package com.google.android.gms.internal;

import android.os.SystemClock;
import org.json.JSONObject;

public final class it
{
  private static final ip Gr = new ip("RequestTracker");
  public static final Object Hz = new Object();
  private long Hv;
  private long Hw;
  private long Hx;
  private is Hy;

  public it(long paramLong)
  {
    this.Hv = paramLong;
    this.Hw = -1L;
    this.Hx = 0L;
  }

  private void fU()
  {
    this.Hw = -1L;
    this.Hy = null;
    this.Hx = 0L;
  }

  public void a(long paramLong, is paramis)
  {
    synchronized (Hz)
    {
      is localis = this.Hy;
      long l = this.Hw;
      this.Hw = paramLong;
      this.Hy = paramis;
      this.Hx = SystemClock.elapsedRealtime();
      if (localis != null)
        localis.n(l);
      return;
    }
  }

  public boolean b(long paramLong, int paramInt, JSONObject paramJSONObject)
  {
    for (boolean bool = true; ; bool = false)
    {
      synchronized (Hz)
      {
        if ((this.Hw != -1L) && (this.Hw == paramLong))
        {
          ip localip = Gr;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = Long.valueOf(this.Hw);
          localip.b("request %d completed", arrayOfObject);
          localis = this.Hy;
          fU();
          if (localis != null)
            localis.a(paramLong, paramInt, paramJSONObject);
          return bool;
        }
      }
      is localis = null;
    }
  }

  public void clear()
  {
    synchronized (Hz)
    {
      if (this.Hw != -1L)
        fU();
      return;
    }
  }

  public boolean d(long paramLong, int paramInt)
  {
    return b(paramLong, paramInt, null);
  }

  public boolean e(long paramLong, int paramInt)
  {
    boolean bool = true;
    long l = 0L;
    while (true)
    {
      synchronized (Hz)
      {
        if ((this.Hw != -1L) && (paramLong - this.Hx >= this.Hv))
        {
          ip localip = Gr;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = Long.valueOf(this.Hw);
          localip.b("request %d timed out", arrayOfObject);
          l = this.Hw;
          localis = this.Hy;
          fU();
          if (localis != null)
            localis.a(l, paramInt, null);
          return bool;
        }
      }
      is localis = null;
      bool = false;
    }
  }

  public boolean fV()
  {
    while (true)
    {
      synchronized (Hz)
      {
        if (this.Hw != -1L)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }

  public boolean p(long paramLong)
  {
    while (true)
    {
      synchronized (Hz)
      {
        if ((this.Hw != -1L) && (this.Hw == paramLong))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.it
 * JD-Core Version:    0.6.2
 */