package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;

public class gm
{
  public static final String a;
  private static final gm c = new gm();
  public final String b = gw.d();
  private final Object d = new Object();
  private final gn e = new gn(this.b);
  private BigInteger f = BigInteger.ONE;
  private final HashSet g = new HashSet();
  private final HashMap h = new HashMap();
  private boolean i = false;

  static
  {
    a = c.b;
  }

  public static Bundle a(Context paramContext, go paramgo, String paramString)
  {
    return c.b(paramContext, paramgo, paramString);
  }

  public static gm a()
  {
    return c;
  }

  public static void a(HashSet paramHashSet)
  {
    c.b(paramHashSet);
  }

  public static String b()
  {
    return c.c();
  }

  public static gn d()
  {
    return c.e();
  }

  public static boolean f()
  {
    return c.g();
  }

  public void a(gk paramgk)
  {
    synchronized (this.d)
    {
      this.g.add(paramgk);
      return;
    }
  }

  public void a(String paramString, gp paramgp)
  {
    synchronized (this.d)
    {
      this.h.put(paramString, paramgp);
      return;
    }
  }

  // ERROR //
  public Bundle b(Context paramContext, go paramgo, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 35	com/google/android/gms/internal/gm:d	Ljava/lang/Object;
    //   4: astore 4
    //   6: aload 4
    //   8: monitorenter
    //   9: new 93	android/os/Bundle
    //   12: dup
    //   13: invokespecial 94	android/os/Bundle:<init>	()V
    //   16: astore 5
    //   18: aload 5
    //   20: ldc 96
    //   22: aload_0
    //   23: getfield 66	com/google/android/gms/internal/gm:e	Lcom/google/android/gms/internal/gn;
    //   26: aload_1
    //   27: aload_3
    //   28: invokevirtual 99	com/google/android/gms/internal/gn:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/os/Bundle;
    //   31: invokevirtual 103	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   34: new 93	android/os/Bundle
    //   37: dup
    //   38: invokespecial 94	android/os/Bundle:<init>	()V
    //   41: astore 7
    //   43: aload_0
    //   44: getfield 52	com/google/android/gms/internal/gm:h	Ljava/util/HashMap;
    //   47: invokevirtual 107	java/util/HashMap:keySet	()Ljava/util/Set;
    //   50: invokeinterface 113 1 0
    //   55: astore 8
    //   57: aload 8
    //   59: invokeinterface 118 1 0
    //   64: ifeq +48 -> 112
    //   67: aload 8
    //   69: invokeinterface 122 1 0
    //   74: checkcast 124	java/lang/String
    //   77: astore 12
    //   79: aload 7
    //   81: aload 12
    //   83: aload_0
    //   84: getfield 52	com/google/android/gms/internal/gm:h	Ljava/util/HashMap;
    //   87: aload 12
    //   89: invokevirtual 128	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   92: checkcast 130	com/google/android/gms/internal/gp
    //   95: invokevirtual 133	com/google/android/gms/internal/gp:a	()Landroid/os/Bundle;
    //   98: invokevirtual 103	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   101: goto -44 -> 57
    //   104: astore 6
    //   106: aload 4
    //   108: monitorexit
    //   109: aload 6
    //   111: athrow
    //   112: aload 5
    //   114: ldc 135
    //   116: aload 7
    //   118: invokevirtual 103	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   121: new 137	java/util/ArrayList
    //   124: dup
    //   125: invokespecial 138	java/util/ArrayList:<init>	()V
    //   128: astore 9
    //   130: aload_0
    //   131: getfield 47	com/google/android/gms/internal/gm:g	Ljava/util/HashSet;
    //   134: invokevirtual 139	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   137: astore 10
    //   139: aload 10
    //   141: invokeinterface 118 1 0
    //   146: ifeq +25 -> 171
    //   149: aload 9
    //   151: aload 10
    //   153: invokeinterface 122 1 0
    //   158: checkcast 141	com/google/android/gms/internal/gk
    //   161: invokevirtual 143	com/google/android/gms/internal/gk:d	()Landroid/os/Bundle;
    //   164: invokevirtual 144	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   167: pop
    //   168: goto -29 -> 139
    //   171: aload 5
    //   173: ldc 146
    //   175: aload 9
    //   177: invokevirtual 150	android/os/Bundle:putParcelableArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   180: aload_2
    //   181: aload_0
    //   182: getfield 47	com/google/android/gms/internal/gm:g	Ljava/util/HashSet;
    //   185: invokeinterface 154 2 0
    //   190: aload_0
    //   191: getfield 47	com/google/android/gms/internal/gm:g	Ljava/util/HashSet;
    //   194: invokevirtual 157	java/util/HashSet:clear	()V
    //   197: aload 4
    //   199: monitorexit
    //   200: aload 5
    //   202: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   9	109	104	finally
    //   112	200	104	finally
  }

  public void b(HashSet paramHashSet)
  {
    synchronized (this.d)
    {
      this.g.addAll(paramHashSet);
      return;
    }
  }

  public String c()
  {
    synchronized (this.d)
    {
      String str = this.f.toString();
      this.f = this.f.add(BigInteger.ONE);
      return str;
    }
  }

  public gn e()
  {
    synchronized (this.d)
    {
      gn localgn = this.e;
      return localgn;
    }
  }

  public boolean g()
  {
    synchronized (this.d)
    {
      boolean bool = this.i;
      this.i = true;
      return bool;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gm
 * JD-Core Version:    0.6.0
 */