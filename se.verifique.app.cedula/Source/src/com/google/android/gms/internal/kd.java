package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.d;
import java.util.ArrayList;
import java.util.Iterator;

public final class kd
{
  final ArrayList a = new ArrayList();
  private final kf b;
  private final ArrayList c = new ArrayList();
  private boolean d = false;
  private final ArrayList e = new ArrayList();
  private final Handler f;

  public kd(Context paramContext, Looper paramLooper, kf paramkf)
  {
    this.b = paramkf;
    this.f = new ke(this, paramLooper);
  }

  protected void a()
  {
    synchronized (this.c)
    {
      a(this.b.l());
      return;
    }
  }

  public void a(int paramInt)
  {
    this.f.removeMessages(1);
    synchronized (this.c)
    {
      this.d = true;
      Iterator localIterator = new ArrayList(this.c).iterator();
      c localc;
      do
      {
        if (localIterator.hasNext())
        {
          localc = (c)localIterator.next();
          if (this.b.n())
            continue;
        }
        this.d = false;
        return;
      }
      while (!this.c.contains(localc));
      localc.a(paramInt);
    }
  }

  public void a(Bundle paramBundle)
  {
    boolean bool1 = true;
    while (true)
    {
      boolean bool2;
      synchronized (this.c)
      {
        if (this.d)
          continue;
        bool2 = bool1;
        kx.a(bool2);
        this.f.removeMessages(1);
        this.d = true;
        if (this.a.size() != 0)
          break label164;
        kx.a(bool1);
        Iterator localIterator = new ArrayList(this.c).iterator();
        if (!localIterator.hasNext())
          continue;
        c localc = (c)localIterator.next();
        if ((this.b.n()) && (this.b.g()))
          continue;
        this.a.clear();
        this.d = false;
        return;
        if (this.a.contains(localc))
          continue;
        localc.a(paramBundle);
      }
      continue;
      label164: bool1 = false;
    }
  }

  // ERROR //
  public void a(com.google.android.gms.common.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 39	com/google/android/gms/internal/kd:f	Landroid/os/Handler;
    //   4: iconst_1
    //   5: invokevirtual 56	android/os/Handler:removeMessages	(I)V
    //   8: aload_0
    //   9: getfield 30	com/google/android/gms/internal/kd:e	Ljava/util/ArrayList;
    //   12: astore_2
    //   13: aload_2
    //   14: monitorenter
    //   15: new 21	java/util/ArrayList
    //   18: dup
    //   19: aload_0
    //   20: getfield 30	com/google/android/gms/internal/kd:e	Ljava/util/ArrayList;
    //   23: invokespecial 59	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   26: invokevirtual 63	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   29: astore 4
    //   31: aload 4
    //   33: invokeinterface 69 1 0
    //   38: ifeq +60 -> 98
    //   41: aload 4
    //   43: invokeinterface 73 1 0
    //   48: checkcast 103	com/google/android/gms/common/d
    //   51: astore 5
    //   53: aload_0
    //   54: getfield 32	com/google/android/gms/internal/kd:b	Lcom/google/android/gms/internal/kf;
    //   57: invokeinterface 78 1 0
    //   62: ifne +8 -> 70
    //   65: aload_2
    //   66: monitorexit
    //   67: goto +33 -> 100
    //   70: aload_0
    //   71: getfield 30	com/google/android/gms/internal/kd:e	Ljava/util/ArrayList;
    //   74: aload 5
    //   76: invokevirtual 82	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   79: ifeq -48 -> 31
    //   82: aload 5
    //   84: aload_1
    //   85: invokeinterface 105 2 0
    //   90: goto -59 -> 31
    //   93: astore_3
    //   94: aload_2
    //   95: monitorexit
    //   96: aload_3
    //   97: athrow
    //   98: aload_2
    //   99: monitorexit
    //   100: return
    //
    // Exception table:
    //   from	to	target	type
    //   15	96	93	finally
    //   98	100	93	finally
  }

  public void a(c paramc)
  {
    kx.a(paramc);
    synchronized (this.c)
    {
      if (this.c.contains(paramc))
      {
        Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + paramc + " is already registered");
        if (this.b.g())
          this.f.sendMessage(this.f.obtainMessage(1, paramc));
        return;
      }
      this.c.add(paramc);
    }
  }

  public void a(d paramd)
  {
    kx.a(paramd);
    synchronized (this.e)
    {
      if (this.e.contains(paramd))
      {
        Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + paramd + " is already registered");
        return;
      }
      this.e.add(paramd);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.kd
 * JD-Core Version:    0.6.0
 */