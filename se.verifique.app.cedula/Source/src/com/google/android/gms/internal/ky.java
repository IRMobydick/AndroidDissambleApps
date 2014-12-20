package com.google.android.gms.internal;

import java.util.LinkedHashMap;

public class ky
{
  private final LinkedHashMap a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;

  private int c(Object paramObject1, Object paramObject2)
  {
    int i = a(paramObject1, paramObject2);
    if (i < 0)
      throw new IllegalStateException("Negative size: " + paramObject1 + "=" + paramObject2);
    return i;
  }

  protected int a(Object paramObject1, Object paramObject2)
  {
    return 1;
  }

  public final Object a(Object paramObject)
  {
    if (paramObject == null)
      throw new NullPointerException("key == null");
    monitorenter;
    Object localObject3;
    try
    {
      localObject2 = this.a.get(paramObject);
      if (localObject2 != null)
      {
        this.g = (1 + this.g);
        monitorexit;
        break label170;
      }
      this.h = (1 + this.h);
      monitorexit;
      localObject3 = b(paramObject);
      if (localObject3 == null)
        localObject2 = null;
    }
    finally
    {
      monitorexit;
    }
    monitorenter;
    try
    {
      this.e = (1 + this.e);
      localObject2 = this.a.put(paramObject, localObject3);
      if (localObject2 != null)
        this.a.put(paramObject, localObject2);
      while (true)
      {
        monitorexit;
        if (localObject2 == null)
          break;
        a(false, paramObject, localObject3, localObject2);
        break label170;
        this.b += c(paramObject, localObject3);
      }
    }
    finally
    {
      monitorexit;
    }
    a(this.c);
    Object localObject2 = localObject3;
    label170: return localObject2;
  }

  public final void a()
  {
    a(-1);
  }

  // ERROR //
  public void a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 73	com/google/android/gms/internal/ky:b	I
    //   6: iflt +20 -> 26
    //   9: aload_0
    //   10: getfield 51	com/google/android/gms/internal/ky:a	Ljava/util/LinkedHashMap;
    //   13: invokevirtual 84	java/util/LinkedHashMap:isEmpty	()Z
    //   16: ifeq +48 -> 64
    //   19: aload_0
    //   20: getfield 73	com/google/android/gms/internal/ky:b	I
    //   23: ifeq +41 -> 64
    //   26: new 19	java/lang/IllegalStateException
    //   29: dup
    //   30: new 21	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   37: aload_0
    //   38: invokevirtual 88	java/lang/Object:getClass	()Ljava/lang/Class;
    //   41: invokevirtual 93	java/lang/Class:getName	()Ljava/lang/String;
    //   44: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc 95
    //   49: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokespecial 43	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   58: athrow
    //   59: astore_2
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_2
    //   63: athrow
    //   64: aload_0
    //   65: getfield 73	com/google/android/gms/internal/ky:b	I
    //   68: iload_1
    //   69: if_icmple +13 -> 82
    //   72: aload_0
    //   73: getfield 51	com/google/android/gms/internal/ky:a	Ljava/util/LinkedHashMap;
    //   76: invokevirtual 84	java/util/LinkedHashMap:isEmpty	()Z
    //   79: ifeq +6 -> 85
    //   82: aload_0
    //   83: monitorexit
    //   84: return
    //   85: aload_0
    //   86: getfield 51	com/google/android/gms/internal/ky:a	Ljava/util/LinkedHashMap;
    //   89: invokevirtual 99	java/util/LinkedHashMap:entrySet	()Ljava/util/Set;
    //   92: invokeinterface 105 1 0
    //   97: invokeinterface 111 1 0
    //   102: checkcast 113	java/util/Map$Entry
    //   105: astore_3
    //   106: aload_3
    //   107: invokeinterface 116 1 0
    //   112: astore 4
    //   114: aload_3
    //   115: invokeinterface 119 1 0
    //   120: astore 5
    //   122: aload_0
    //   123: getfield 51	com/google/android/gms/internal/ky:a	Ljava/util/LinkedHashMap;
    //   126: aload 4
    //   128: invokevirtual 122	java/util/LinkedHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   131: pop
    //   132: aload_0
    //   133: aload_0
    //   134: getfield 73	com/google/android/gms/internal/ky:b	I
    //   137: aload_0
    //   138: aload 4
    //   140: aload 5
    //   142: invokespecial 75	com/google/android/gms/internal/ky:c	(Ljava/lang/Object;Ljava/lang/Object;)I
    //   145: isub
    //   146: putfield 73	com/google/android/gms/internal/ky:b	I
    //   149: aload_0
    //   150: iconst_1
    //   151: aload_0
    //   152: getfield 124	com/google/android/gms/internal/ky:f	I
    //   155: iadd
    //   156: putfield 124	com/google/android/gms/internal/ky:f	I
    //   159: aload_0
    //   160: monitorexit
    //   161: aload_0
    //   162: iconst_1
    //   163: aload 4
    //   165: aload 5
    //   167: aconst_null
    //   168: invokevirtual 71	com/google/android/gms/internal/ky:a	(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   171: goto -171 -> 0
    //
    // Exception table:
    //   from	to	target	type
    //   2	62	59	finally
    //   64	161	59	finally
  }

  protected void a(boolean paramBoolean, Object paramObject1, Object paramObject2, Object paramObject3)
  {
  }

  protected Object b(Object paramObject)
  {
    return null;
  }

  public final Object b(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == null) || (paramObject2 == null))
      throw new NullPointerException("key == null || value == null");
    monitorenter;
    try
    {
      this.d = (1 + this.d);
      this.b += c(paramObject1, paramObject2);
      Object localObject2 = this.a.put(paramObject1, paramObject2);
      if (localObject2 != null)
        this.b -= c(paramObject1, localObject2);
      monitorexit;
      if (localObject2 != null)
        a(false, paramObject1, localObject2, paramObject2);
      a(this.c);
      return localObject2;
    }
    finally
    {
      monitorexit;
    }
    throw localObject1;
  }

  public final String toString()
  {
    int i = 0;
    monitorenter;
    try
    {
      int j = this.g + this.h;
      if (j != 0)
        i = 100 * this.g / j;
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = Integer.valueOf(this.c);
      arrayOfObject[1] = Integer.valueOf(this.g);
      arrayOfObject[2] = Integer.valueOf(this.h);
      arrayOfObject[3] = Integer.valueOf(i);
      String str = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", arrayOfObject);
      monitorexit;
      return str;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ky
 * JD-Core Version:    0.6.0
 */