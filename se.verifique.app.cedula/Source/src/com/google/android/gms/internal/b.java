package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.WeakHashMap;

public final class b
  implements i
{
  private final Object a = new Object();
  private WeakHashMap b = new WeakHashMap();
  private ArrayList c = new ArrayList();

  public c a(al paramal, gi paramgi)
  {
    c localc;
    synchronized (this.a)
    {
      if (a(paramgi))
      {
        localc = (c)this.b.get(paramgi);
      }
      else
      {
        localc = new c(paramal, paramgi);
        localc.a(this);
        this.b.put(paramgi, localc);
        this.c.add(localc);
      }
    }
    return localc;
  }

  // ERROR //
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 18	com/google/android/gms/internal/b:a	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 28	com/google/android/gms/internal/b:c	Ljava/util/ArrayList;
    //   11: invokevirtual 56	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   14: astore_3
    //   15: aload_3
    //   16: invokeinterface 62 1 0
    //   21: ifeq +23 -> 44
    //   24: aload_3
    //   25: invokeinterface 66 1 0
    //   30: checkcast 38	com/google/android/gms/internal/c
    //   33: invokevirtual 69	com/google/android/gms/internal/c:j	()V
    //   36: goto -21 -> 15
    //   39: astore_2
    //   40: aload_1
    //   41: monitorexit
    //   42: aload_2
    //   43: athrow
    //   44: aload_1
    //   45: monitorexit
    //   46: return
    //
    // Exception table:
    //   from	to	target	type
    //   7	42	39	finally
    //   44	46	39	finally
  }

  public void a(c paramc)
  {
    synchronized (this.a)
    {
      if (!paramc.e())
        this.c.remove(paramc);
      return;
    }
  }

  public boolean a(gi paramgi)
  {
    while (true)
    {
      synchronized (this.a)
      {
        c localc = (c)this.b.get(paramgi);
        if ((localc != null) && (localc.e()))
        {
          i = 1;
          return i;
        }
      }
      int i = 0;
    }
  }

  // ERROR //
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 18	com/google/android/gms/internal/b:a	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 28	com/google/android/gms/internal/b:c	Ljava/util/ArrayList;
    //   11: invokevirtual 56	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   14: astore_3
    //   15: aload_3
    //   16: invokeinterface 62 1 0
    //   21: ifeq +23 -> 44
    //   24: aload_3
    //   25: invokeinterface 66 1 0
    //   30: checkcast 38	com/google/android/gms/internal/c
    //   33: invokevirtual 79	com/google/android/gms/internal/c:k	()V
    //   36: goto -21 -> 15
    //   39: astore_2
    //   40: aload_1
    //   41: monitorexit
    //   42: aload_2
    //   43: athrow
    //   44: aload_1
    //   45: monitorexit
    //   46: return
    //
    // Exception table:
    //   from	to	target	type
    //   7	42	39	finally
    //   44	46	39	finally
  }

  public void b(gi paramgi)
  {
    synchronized (this.a)
    {
      c localc = (c)this.b.get(paramgi);
      if (localc != null)
        localc.c();
      return;
    }
  }

  // ERROR //
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 18	com/google/android/gms/internal/b:a	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 28	com/google/android/gms/internal/b:c	Ljava/util/ArrayList;
    //   11: invokevirtual 56	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   14: astore_3
    //   15: aload_3
    //   16: invokeinterface 62 1 0
    //   21: ifeq +23 -> 44
    //   24: aload_3
    //   25: invokeinterface 66 1 0
    //   30: checkcast 38	com/google/android/gms/internal/c
    //   33: invokevirtual 85	com/google/android/gms/internal/c:l	()V
    //   36: goto -21 -> 15
    //   39: astore_2
    //   40: aload_1
    //   41: monitorexit
    //   42: aload_2
    //   43: athrow
    //   44: aload_1
    //   45: monitorexit
    //   46: return
    //
    // Exception table:
    //   from	to	target	type
    //   7	42	39	finally
    //   44	46	39	finally
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.b
 * JD-Core Version:    0.6.0
 */