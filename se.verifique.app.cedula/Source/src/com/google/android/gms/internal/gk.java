package com.google.android.gms.internal;

import android.os.SystemClock;
import java.util.LinkedList;

public class gk
{
  private final gm a;
  private final LinkedList b;
  private final Object c = new Object();
  private final String d;
  private final String e;
  private long f = -1L;
  private long g = -1L;
  private boolean h = false;
  private long i = -1L;
  private long j = 0L;
  private long k = -1L;
  private long l = -1L;

  public gk(gm paramgm, String paramString1, String paramString2)
  {
    this.a = paramgm;
    this.d = paramString1;
    this.e = paramString2;
    this.b = new LinkedList();
  }

  public gk(String paramString1, String paramString2)
  {
    this(gm.a(), paramString1, paramString2);
  }

  public void a()
  {
    synchronized (this.c)
    {
      if ((this.l != -1L) && (this.g == -1L))
      {
        this.g = SystemClock.elapsedRealtime();
        this.a.a(this);
      }
      gm.d().c();
      return;
    }
  }

  public void a(long paramLong)
  {
    synchronized (this.c)
    {
      this.l = paramLong;
      if (this.l != -1L)
        this.a.a(this);
      return;
    }
  }

  public void a(ai paramai)
  {
    synchronized (this.c)
    {
      this.k = SystemClock.elapsedRealtime();
      gm.d().a(paramai, this.k);
      return;
    }
  }

  public void a(boolean paramBoolean)
  {
    synchronized (this.c)
    {
      if (this.l != -1L)
      {
        this.i = SystemClock.elapsedRealtime();
        if (!paramBoolean)
        {
          this.g = this.i;
          this.a.a(this);
        }
      }
      return;
    }
  }

  public void b()
  {
    synchronized (this.c)
    {
      if (this.l != -1L)
      {
        gl localgl = new gl();
        localgl.c();
        this.b.add(localgl);
        this.j = (1L + this.j);
        gm.d().b();
        this.a.a(this);
      }
      return;
    }
  }

  public void b(long paramLong)
  {
    synchronized (this.c)
    {
      if (this.l != -1L)
      {
        this.f = paramLong;
        this.a.a(this);
      }
      return;
    }
  }

  public void b(boolean paramBoolean)
  {
    synchronized (this.c)
    {
      if (this.l != -1L)
      {
        this.h = paramBoolean;
        this.a.a(this);
      }
      return;
    }
  }

  public void c()
  {
    synchronized (this.c)
    {
      if ((this.l != -1L) && (!this.b.isEmpty()))
      {
        gl localgl = (gl)this.b.getLast();
        if (localgl.a() == -1L)
        {
          localgl.b();
          this.a.a(this);
        }
      }
      return;
    }
  }

  // ERROR //
  public android.os.Bundle d()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 29	com/google/android/gms/internal/gk:c	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: new 110	android/os/Bundle
    //   10: dup
    //   11: invokespecial 111	android/os/Bundle:<init>	()V
    //   14: astore_2
    //   15: aload_2
    //   16: ldc 113
    //   18: aload_0
    //   19: getfield 49	com/google/android/gms/internal/gk:d	Ljava/lang/String;
    //   22: invokevirtual 116	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: aload_2
    //   26: ldc 118
    //   28: aload_0
    //   29: getfield 51	com/google/android/gms/internal/gk:e	Ljava/lang/String;
    //   32: invokevirtual 116	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: aload_2
    //   36: ldc 120
    //   38: aload_0
    //   39: getfield 37	com/google/android/gms/internal/gk:h	Z
    //   42: invokevirtual 124	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   45: aload_2
    //   46: ldc 126
    //   48: aload_0
    //   49: getfield 43	com/google/android/gms/internal/gk:k	J
    //   52: invokevirtual 130	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   55: aload_2
    //   56: ldc 132
    //   58: aload_0
    //   59: getfield 45	com/google/android/gms/internal/gk:l	J
    //   62: invokevirtual 130	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   65: aload_2
    //   66: ldc 134
    //   68: aload_0
    //   69: getfield 35	com/google/android/gms/internal/gk:g	J
    //   72: invokevirtual 130	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   75: aload_2
    //   76: ldc 136
    //   78: aload_0
    //   79: getfield 39	com/google/android/gms/internal/gk:i	J
    //   82: invokevirtual 130	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   85: aload_2
    //   86: ldc 138
    //   88: aload_0
    //   89: getfield 41	com/google/android/gms/internal/gk:j	J
    //   92: invokevirtual 130	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   95: aload_2
    //   96: ldc 140
    //   98: aload_0
    //   99: getfield 33	com/google/android/gms/internal/gk:f	J
    //   102: invokevirtual 130	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   105: new 142	java/util/ArrayList
    //   108: dup
    //   109: invokespecial 143	java/util/ArrayList:<init>	()V
    //   112: astore 4
    //   114: aload_0
    //   115: getfield 56	com/google/android/gms/internal/gk:b	Ljava/util/LinkedList;
    //   118: invokevirtual 147	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   121: astore 5
    //   123: aload 5
    //   125: invokeinterface 152 1 0
    //   130: ifeq +30 -> 160
    //   133: aload 4
    //   135: aload 5
    //   137: invokeinterface 155 1 0
    //   142: checkcast 88	com/google/android/gms/internal/gl
    //   145: invokevirtual 157	com/google/android/gms/internal/gl:d	()Landroid/os/Bundle;
    //   148: invokevirtual 158	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   151: pop
    //   152: goto -29 -> 123
    //   155: astore_3
    //   156: aload_1
    //   157: monitorexit
    //   158: aload_3
    //   159: athrow
    //   160: aload_2
    //   161: ldc 160
    //   163: aload 4
    //   165: invokevirtual 164	android/os/Bundle:putParcelableArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   168: aload_1
    //   169: monitorexit
    //   170: aload_2
    //   171: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   7	158	155	finally
    //   160	170	155	finally
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gk
 * JD-Core Version:    0.6.0
 */