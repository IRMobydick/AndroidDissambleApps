package com.google.b.a.a;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

public class ao extends bi
{
  private static ao g;
  private boolean a;
  private h b;
  private Context c;
  private volatile Boolean d = Boolean.valueOf(false);
  private final Map e = new HashMap();
  private as f;

  protected ao(Context paramContext)
  {
    this(paramContext, ai.a(paramContext));
  }

  private ao(Context paramContext, h paramh)
  {
    if (paramContext == null)
      throw new IllegalArgumentException("context cannot be null");
    this.c = paramContext.getApplicationContext();
    this.b = paramh;
    i.a(this.c);
    bb.a(this.c);
    j.a(this.c);
    this.f = new m();
  }

  static ao a()
  {
    monitorenter;
    try
    {
      ao localao = g;
      monitorexit;
      return localao;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public static ao a(Context paramContext)
  {
    monitorenter;
    try
    {
      if (g == null)
        g = new ao(paramContext);
      ao localao = g;
      monitorexit;
      return localao;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  // ERROR //
  void a(Map paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +20 -> 23
    //   6: new 46	java/lang/IllegalArgumentException
    //   9: dup
    //   10: ldc 85
    //   12: invokespecial 51	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   15: athrow
    //   16: astore 4
    //   18: aload_0
    //   19: monitorexit
    //   20: aload 4
    //   22: athrow
    //   23: aload_1
    //   24: ldc 87
    //   26: invokestatic 93	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   29: invokestatic 98	com/google/b/a/a/bj:a	(Ljava/util/Locale;)Ljava/lang/String;
    //   32: invokestatic 101	com/google/b/a/a/bj:a	(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V
    //   35: aload_1
    //   36: ldc 103
    //   38: invokestatic 106	com/google/b/a/a/bb:a	()Lcom/google/b/a/a/bb;
    //   41: ldc 103
    //   43: invokevirtual 109	com/google/b/a/a/bb:a	(Ljava/lang/String;)Ljava/lang/String;
    //   46: invokestatic 101	com/google/b/a/a/bj:a	(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V
    //   49: aload_1
    //   50: ldc 111
    //   52: invokestatic 116	com/google/b/a/a/am:a	()Lcom/google/b/a/a/am;
    //   55: invokevirtual 119	com/google/b/a/a/am:c	()Ljava/lang/String;
    //   58: invokeinterface 125 3 0
    //   63: pop
    //   64: invokestatic 116	com/google/b/a/a/am:a	()Lcom/google/b/a/a/am;
    //   67: invokevirtual 127	com/google/b/a/a/am:b	()Ljava/lang/String;
    //   70: pop
    //   71: aload_0
    //   72: getfield 61	com/google/b/a/a/ao:b	Lcom/google/b/a/a/h;
    //   75: aload_1
    //   76: invokeinterface 131 2 0
    //   81: aload_0
    //   82: monitorexit
    //   83: return
    //
    // Exception table:
    //   from	to	target	type
    //   6	20	16	finally
    //   23	83	16	finally
  }

  public void a(boolean paramBoolean)
  {
    am.a().a(an.ac);
    this.a = paramBoolean;
  }

  public boolean b()
  {
    am.a().a(an.ad);
    return this.a;
  }

  public boolean c()
  {
    am.a().a(an.R);
    return this.d.booleanValue();
  }

  public as d()
  {
    return this.f;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.b.a.a.ao
 * JD-Core Version:    0.6.0
 */