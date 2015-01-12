package com.baidu.platform.comjni.engine;

import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import java.util.Iterator;
import java.util.List;

public class a
{
  private static final String a = a.class.getSimpleName();
  private static SparseArray<List<Handler>> b = new SparseArray();

  public static void a()
  {
    while (true)
    {
      int j;
      synchronized (b)
      {
        int i = b.size();
        j = 0;
        if (j < i)
        {
          List localList = (List)b.get(b.keyAt(j));
          if (localList != null)
            localList.clear();
        }
        else
        {
          b.clear();
          return;
        }
      }
      j++;
    }
  }

  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    synchronized (b)
    {
      List localList = (List)b.get(paramInt1);
      if ((localList != null) && (!localList.isEmpty()))
      {
        Iterator localIterator = localList.iterator();
        if (localIterator.hasNext())
          Message.obtain((Handler)localIterator.next(), paramInt1, paramInt2, paramInt3, Integer.valueOf(paramInt4)).sendToTarget();
      }
    }
  }

  // ERROR //
  public static void a(int paramInt, Handler paramHandler)
  {
    // Byte code:
    //   0: getstatic 26	com/baidu/platform/comjni/engine/a:b	Landroid/util/SparseArray;
    //   3: astore_2
    //   4: aload_2
    //   5: monitorenter
    //   6: aload_1
    //   7: ifnonnull +6 -> 13
    //   10: aload_2
    //   11: monitorexit
    //   12: return
    //   13: getstatic 26	com/baidu/platform/comjni/engine/a:b	Landroid/util/SparseArray;
    //   16: iload_0
    //   17: invokevirtual 39	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   20: checkcast 41	java/util/List
    //   23: astore 4
    //   25: aload 4
    //   27: ifnull +31 -> 58
    //   30: aload 4
    //   32: aload_1
    //   33: invokeinterface 85 2 0
    //   38: ifne +12 -> 50
    //   41: aload 4
    //   43: aload_1
    //   44: invokeinterface 88 2 0
    //   49: pop
    //   50: aload_2
    //   51: monitorexit
    //   52: return
    //   53: astore_3
    //   54: aload_2
    //   55: monitorexit
    //   56: aload_3
    //   57: athrow
    //   58: new 90	java/util/ArrayList
    //   61: dup
    //   62: invokespecial 91	java/util/ArrayList:<init>	()V
    //   65: astore 6
    //   67: aload 6
    //   69: aload_1
    //   70: invokeinterface 88 2 0
    //   75: pop
    //   76: getstatic 26	com/baidu/platform/comjni/engine/a:b	Landroid/util/SparseArray;
    //   79: iload_0
    //   80: aload 6
    //   82: invokevirtual 95	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   85: goto -35 -> 50
    //
    // Exception table:
    //   from	to	target	type
    //   10	12	53	finally
    //   13	25	53	finally
    //   30	50	53	finally
    //   50	52	53	finally
    //   54	56	53	finally
    //   58	85	53	finally
  }

  public static void b(int paramInt, Handler paramHandler)
  {
    SparseArray localSparseArray = b;
    if (paramHandler != null);
    try
    {
      paramHandler.removeCallbacksAndMessages(null);
      List localList = (List)b.get(paramInt);
      if (localList != null)
        localList.remove(paramHandler);
      return;
    }
    finally
    {
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.platform.comjni.engine.a
 * JD-Core Version:    0.6.2
 */