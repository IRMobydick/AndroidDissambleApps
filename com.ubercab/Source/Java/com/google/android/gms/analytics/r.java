package com.google.android.gms.analytics;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.hb;
import com.google.android.gms.internal.ju;
import com.google.android.gms.internal.jw;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

class r
  implements af, c.b, c.c
{
  private final Context mContext;
  private boolean yA;
  private boolean yB;
  private boolean yC;
  private ju yD;
  private long yE = 300000L;
  private d yd;
  private final f ye;
  private boolean yg;
  private volatile long yq;
  private volatile a yr;
  private volatile b ys;
  private d yt;
  private final GoogleAnalytics yu;
  private final Queue<d> yv = new ConcurrentLinkedQueue();
  private volatile int yw;
  private volatile Timer yx;
  private volatile Timer yy;
  private volatile Timer yz;

  r(Context paramContext, f paramf)
  {
    this(paramContext, paramf, null, GoogleAnalytics.getInstance(paramContext));
  }

  r(Context paramContext, f paramf, d paramd, GoogleAnalytics paramGoogleAnalytics)
  {
    this.yt = paramd;
    this.mContext = paramContext;
    this.ye = paramf;
    this.yu = paramGoogleAnalytics;
    this.yD = jw.hA();
    this.yw = 0;
    this.yr = a.yN;
  }

  private Timer a(Timer paramTimer)
  {
    if (paramTimer != null)
      paramTimer.cancel();
    return null;
  }

  private void cC()
  {
    try
    {
      if ((this.ys != null) && (this.yr == a.yI))
      {
        this.yr = a.yM;
        this.ys.disconnect();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void ef()
  {
    this.yx = a(this.yx);
    this.yy = a(this.yy);
    this.yz = a(this.yz);
  }

  private void eh()
  {
    while (true)
    {
      try
      {
        if (!Thread.currentThread().equals(this.ye.getThread()))
        {
          this.ye.dO().add(new Runnable()
          {
            public void run()
            {
              r.a(r.this);
            }
          });
          return;
        }
        if (this.yA)
          dH();
        switch (2.yG[this.yr.ordinal()])
        {
        case 1:
          if (this.yv.isEmpty())
            break label211;
          d locald2 = (d)this.yv.poll();
          z.V("Sending hit to store  " + locald2);
          this.yd.a(locald2.em(), locald2.en(), locald2.getPath(), locald2.eo());
          continue;
        case 7:
        case 2:
        case 6:
        case 3:
        case 4:
        case 5:
        }
      }
      finally
      {
      }
      z.V("Blocked. Dropping hits.");
      this.yv.clear();
      continue;
      label211: if (this.yg)
      {
        ei();
        continue;
        if (!this.yv.isEmpty())
        {
          d locald1 = (d)this.yv.peek();
          z.V("Sending hit to service   " + locald1);
          if (!this.yu.isDryRunEnabled())
            this.ys.a(locald1.em(), locald1.en(), locald1.getPath(), locald1.eo());
          while (true)
          {
            this.yv.poll();
            break;
            z.V("Dry run enabled. Hit not actually sent to service.");
          }
        }
        this.yq = this.yD.elapsedRealtime();
        continue;
        z.V("Need to reconnect");
        if (!this.yv.isEmpty())
          ek();
      }
    }
  }

  private void ei()
  {
    this.yd.dispatch();
    this.yg = false;
  }

  private void ej()
  {
    try
    {
      a locala1 = this.yr;
      a locala2 = a.yJ;
      if (locala1 == locala2);
      while (true)
      {
        return;
        if ((this.mContext == null) || (!"com.google.android.gms".equals(this.mContext.getPackageName())))
          break;
        this.yr = a.yK;
        this.ys.disconnect();
        z.W("Attempted to fall back to local store from service.");
      }
    }
    finally
    {
    }
    ef();
    z.V("falling back to local store");
    if (this.yt != null);
    q localq;
    for (this.yd = this.yt; ; this.yd = localq.ec())
    {
      this.yr = a.yJ;
      eh();
      break;
      localq = q.dZ();
      localq.a(this.mContext, this.ye);
    }
  }

  private void ek()
  {
    while (true)
    {
      try
      {
        if ((!this.yC) && (this.ys != null))
        {
          a locala1 = this.yr;
          a locala2 = a.yJ;
          if (locala1 != locala2)
            try
            {
              this.yw = (1 + this.yw);
              a(this.yy);
              this.yr = a.yH;
              this.yy = new Timer("Failed Connect");
              this.yy.schedule(new c(null), 3000L);
              z.V("connecting to Analytics service");
              this.ys.connect();
              return;
            }
            catch (SecurityException localSecurityException)
            {
              z.W("security exception on connectToService");
              ej();
              continue;
            }
        }
      }
      finally
      {
      }
      z.W("client not initialized.");
      ej();
    }
  }

  private void el()
  {
    this.yx = a(this.yx);
    this.yx = new Timer("Service Reconnect");
    this.yx.schedule(new e(null), 5000L);
  }

  public void a(int paramInt, Intent paramIntent)
  {
    try
    {
      this.yr = a.yL;
      if (this.yw < 2)
      {
        z.W("Service unavailable (code=" + paramInt + "), will retry.");
        el();
      }
      while (true)
      {
        return;
        z.W("Service unavailable (code=" + paramInt + "), using local store.");
        ej();
      }
    }
    finally
    {
    }
  }

  public void b(Map<String, String> paramMap, long paramLong, String paramString, List<hb> paramList)
  {
    z.V("putHit called");
    this.yv.add(new d(paramMap, paramLong, paramString, paramList));
    eh();
  }

  public void dH()
  {
    z.V("clearHits called");
    this.yv.clear();
    switch (2.yG[this.yr.ordinal()])
    {
    default:
      this.yA = true;
      return;
    case 1:
      this.yd.l(0L);
      this.yA = false;
      return;
    case 2:
    }
    this.ys.dH();
    this.yA = false;
  }

  public void dN()
  {
    while (true)
    {
      try
      {
        boolean bool = this.yC;
        if (bool)
          return;
        z.V("setForceLocalDispatch called.");
        this.yC = true;
        switch (2.yG[this.yr.ordinal()])
        {
        case 1:
        case 4:
        case 5:
        case 6:
        case 2:
          cC();
          continue;
        case 3:
        }
      }
      finally
      {
      }
      this.yB = true;
    }
  }

  public void dispatch()
  {
    switch (2.yG[this.yr.ordinal()])
    {
    default:
      this.yg = true;
    case 2:
      return;
    case 1:
    }
    ei();
  }

  public void eg()
  {
    if (this.ys != null)
      return;
    this.ys = new c(this.mContext, this, this);
    ek();
  }

  public void onConnected()
  {
    try
    {
      this.yy = a(this.yy);
      this.yw = 0;
      z.V("Connected to service");
      this.yr = a.yI;
      if (this.yB)
      {
        cC();
        this.yB = false;
      }
      while (true)
      {
        return;
        eh();
        this.yz = a(this.yz);
        this.yz = new Timer("disconnect check");
        this.yz.schedule(new b(null), this.yE);
      }
    }
    finally
    {
    }
  }

  public void onDisconnected()
  {
    while (true)
    {
      try
      {
        if (this.yr == a.yK)
        {
          z.V("Service blocked.");
          ef();
          return;
        }
        if (this.yr == a.yM)
        {
          z.V("Disconnected from service");
          ef();
          this.yr = a.yN;
          continue;
        }
      }
      finally
      {
      }
      z.V("Unexpected disconnect.");
      this.yr = a.yL;
      if (this.yw < 2)
        el();
      else
        ej();
    }
  }

  private static enum a
  {
    static
    {
      a[] arrayOfa = new a[7];
      arrayOfa[0] = yH;
      arrayOfa[1] = yI;
      arrayOfa[2] = yJ;
      arrayOfa[3] = yK;
      arrayOfa[4] = yL;
      arrayOfa[5] = yM;
      arrayOfa[6] = yN;
    }
  }

  private class b extends TimerTask
  {
    private b()
    {
    }

    public void run()
    {
      if ((r.b(r.this) == r.a.yI) && (r.e(r.this).isEmpty()) && (r.f(r.this) + r.g(r.this) < r.h(r.this).elapsedRealtime()))
      {
        z.V("Disconnecting due to inactivity");
        r.i(r.this);
        return;
      }
      r.j(r.this).schedule(new b(r.this), r.g(r.this));
    }
  }

  private class c extends TimerTask
  {
    private c()
    {
    }

    public void run()
    {
      if (r.b(r.this) == r.a.yH)
        r.c(r.this);
    }
  }

  private static class d
  {
    private final Map<String, String> yP;
    private final long yQ;
    private final String yR;
    private final List<hb> yS;

    public d(Map<String, String> paramMap, long paramLong, String paramString, List<hb> paramList)
    {
      this.yP = paramMap;
      this.yQ = paramLong;
      this.yR = paramString;
      this.yS = paramList;
    }

    public Map<String, String> em()
    {
      return this.yP;
    }

    public long en()
    {
      return this.yQ;
    }

    public List<hb> eo()
    {
      return this.yS;
    }

    public String getPath()
    {
      return this.yR;
    }

    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PATH: ");
      localStringBuilder.append(this.yR);
      if (this.yP != null)
      {
        localStringBuilder.append("  PARAMS: ");
        Iterator localIterator = this.yP.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          localStringBuilder.append((String)localEntry.getKey());
          localStringBuilder.append("=");
          localStringBuilder.append((String)localEntry.getValue());
          localStringBuilder.append(",  ");
        }
      }
      return localStringBuilder.toString();
    }
  }

  private class e extends TimerTask
  {
    private e()
    {
    }

    public void run()
    {
      r.d(r.this);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.r
 * JD-Core Version:    0.6.2
 */