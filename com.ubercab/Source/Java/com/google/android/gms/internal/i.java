package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public abstract class i extends h
{
  private static Method kA;
  private static Method kB;
  private static Method kC;
  private static Method kD;
  private static Method kE;
  private static Method kF;
  private static Method kG;
  private static Method kH;
  private static Method kI;
  private static String kJ;
  private static String kK;
  private static String kL;
  private static o kM;
  static boolean kN = false;
  private static long startTime = 0L;

  protected i(Context paramContext, m paramm, n paramn)
  {
    super(paramContext, paramm, paramn);
  }

  static String a(Context paramContext, m paramm)
    throws i.a
  {
    if (kK != null)
      return kK;
    if (kD == null)
      throw new a();
    try
    {
      localByteBuffer = (ByteBuffer)kD.invoke(null, new Object[] { paramContext });
      if (localByteBuffer == null)
        throw new a();
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      ByteBuffer localByteBuffer;
      throw new a(localIllegalAccessException);
      kK = paramm.a(localByteBuffer.array(), true);
      String str = kK;
      return str;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new a(localInvocationTargetException);
    }
  }

  static ArrayList<Long> a(MotionEvent paramMotionEvent, DisplayMetrics paramDisplayMetrics)
    throws i.a
  {
    if ((kE == null) || (paramMotionEvent == null))
      throw new a();
    try
    {
      ArrayList localArrayList = (ArrayList)kE.invoke(null, new Object[] { paramMotionEvent, paramDisplayMetrics });
      return localArrayList;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new a(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new a(localInvocationTargetException);
    }
  }

  // ERROR //
  protected static void a(String paramString, Context paramContext, m paramm)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 30	com/google/android/gms/internal/i:kN	Z
    //   6: istore 4
    //   8: iload 4
    //   10: ifne +36 -> 46
    //   13: new 80	com/google/android/gms/internal/o
    //   16: dup
    //   17: aload_2
    //   18: aconst_null
    //   19: invokespecial 83	com/google/android/gms/internal/o:<init>	(Lcom/google/android/gms/internal/m;Ljava/security/SecureRandom;)V
    //   22: putstatic 85	com/google/android/gms/internal/i:kM	Lcom/google/android/gms/internal/o;
    //   25: aload_0
    //   26: putstatic 87	com/google/android/gms/internal/i:kJ	Ljava/lang/String;
    //   29: aload_1
    //   30: invokestatic 91	com/google/android/gms/internal/i:g	(Landroid/content/Context;)V
    //   33: invokestatic 95	com/google/android/gms/internal/i:w	()Ljava/lang/Long;
    //   36: invokevirtual 101	java/lang/Long:longValue	()J
    //   39: putstatic 28	com/google/android/gms/internal/i:startTime	J
    //   42: iconst_1
    //   43: putstatic 30	com/google/android/gms/internal/i:kN	Z
    //   46: ldc 2
    //   48: monitorexit
    //   49: return
    //   50: astore_3
    //   51: ldc 2
    //   53: monitorexit
    //   54: aload_3
    //   55: athrow
    //   56: astore 6
    //   58: goto -12 -> 46
    //   61: astore 5
    //   63: goto -17 -> 46
    //
    // Exception table:
    //   from	to	target	type
    //   3	8	50	finally
    //   13	46	50	finally
    //   13	46	56	java/lang/UnsupportedOperationException
    //   13	46	61	com/google/android/gms/internal/i$a
  }

  static String b(Context paramContext, m paramm)
    throws i.a
  {
    if (kL != null)
      return kL;
    if (kG == null)
      throw new a();
    try
    {
      localByteBuffer = (ByteBuffer)kG.invoke(null, new Object[] { paramContext });
      if (localByteBuffer == null)
        throw new a();
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      ByteBuffer localByteBuffer;
      throw new a(localIllegalAccessException);
      kL = paramm.a(localByteBuffer.array(), true);
      String str = kL;
      return str;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new a(localInvocationTargetException);
    }
  }

  private static String b(byte[] paramArrayOfByte, String paramString)
    throws i.a
  {
    try
    {
      String str = new String(kM.c(paramArrayOfByte, paramString), "UTF-8");
      return str;
    }
    catch (o.a locala)
    {
      throw new a(locala);
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new a(localUnsupportedEncodingException);
    }
  }

  static String d(Context paramContext)
    throws i.a
  {
    if (kF == null)
      throw new a();
    String str;
    try
    {
      str = (String)kF.invoke(null, new Object[] { paramContext });
      if (str == null)
        throw new a();
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new a(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new a(localInvocationTargetException);
    }
    return str;
  }

  static ArrayList<Long> e(Context paramContext)
    throws i.a
  {
    if (kH == null)
      throw new a();
    ArrayList localArrayList;
    try
    {
      localArrayList = (ArrayList)kH.invoke(null, new Object[] { paramContext });
      if ((localArrayList == null) || (localArrayList.size() != 2))
        throw new a();
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new a(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new a(localInvocationTargetException);
    }
    return localArrayList;
  }

  static int[] f(Context paramContext)
    throws i.a
  {
    if (kI == null)
      throw new a();
    try
    {
      int[] arrayOfInt = (int[])kI.invoke(null, new Object[] { paramContext });
      return arrayOfInt;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new a(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new a(localInvocationTargetException);
    }
  }

  private static void g(Context paramContext)
    throws i.a
  {
    try
    {
      arrayOfByte1 = kM.b(q.getKey());
      arrayOfByte2 = kM.c(arrayOfByte1, q.B());
      localFile1 = paramContext.getCacheDir();
      if (localFile1 == null)
      {
        localFile1 = paramContext.getDir("dex", 0);
        if (localFile1 == null)
          throw new a();
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      byte[] arrayOfByte1;
      byte[] arrayOfByte2;
      File localFile1;
      throw new a(localFileNotFoundException);
      File localFile2 = localFile1;
      File localFile3 = File.createTempFile("ads", ".jar", localFile2);
      FileOutputStream localFileOutputStream = new FileOutputStream(localFile3);
      localFileOutputStream.write(arrayOfByte2, 0, arrayOfByte2.length);
      localFileOutputStream.close();
      try
      {
        DexClassLoader localDexClassLoader = new DexClassLoader(localFile3.getAbsolutePath(), localFile2.getAbsolutePath(), null, paramContext.getClassLoader());
        Class localClass1 = localDexClassLoader.loadClass(b(arrayOfByte1, q.E()));
        Class localClass2 = localDexClassLoader.loadClass(b(arrayOfByte1, q.Q()));
        Class localClass3 = localDexClassLoader.loadClass(b(arrayOfByte1, q.K()));
        Class localClass4 = localDexClassLoader.loadClass(b(arrayOfByte1, q.I()));
        Class localClass5 = localDexClassLoader.loadClass(b(arrayOfByte1, q.S()));
        Class localClass6 = localDexClassLoader.loadClass(b(arrayOfByte1, q.G()));
        Class localClass7 = localDexClassLoader.loadClass(b(arrayOfByte1, q.O()));
        Class localClass8 = localDexClassLoader.loadClass(b(arrayOfByte1, q.M()));
        Class localClass9 = localDexClassLoader.loadClass(b(arrayOfByte1, q.C()));
        kA = localClass1.getMethod(b(arrayOfByte1, q.F()), new Class[0]);
        kB = localClass2.getMethod(b(arrayOfByte1, q.R()), new Class[0]);
        kC = localClass3.getMethod(b(arrayOfByte1, q.L()), new Class[0]);
        kD = localClass4.getMethod(b(arrayOfByte1, q.J()), new Class[] { Context.class });
        kE = localClass5.getMethod(b(arrayOfByte1, q.T()), new Class[] { MotionEvent.class, DisplayMetrics.class });
        kF = localClass6.getMethod(b(arrayOfByte1, q.H()), new Class[] { Context.class });
        kG = localClass7.getMethod(b(arrayOfByte1, q.P()), new Class[] { Context.class });
        kH = localClass8.getMethod(b(arrayOfByte1, q.N()), new Class[] { Context.class });
        kI = localClass9.getMethod(b(arrayOfByte1, q.D()), new Class[] { Context.class });
        String str2;
        return;
      }
      finally
      {
        String str1 = localFile3.getName();
        localFile3.delete();
        new File(localFile2, str1.replace(".jar", ".dex")).delete();
      }
    }
    catch (IOException localIOException)
    {
      throw new a(localIOException);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new a(localClassNotFoundException);
    }
    catch (o.a locala)
    {
      throw new a(locala);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new a(localNoSuchMethodException);
    }
    catch (NullPointerException localNullPointerException)
    {
      throw new a(localNullPointerException);
    }
  }

  static String v()
    throws i.a
  {
    if (kJ == null)
      throw new a();
    return kJ;
  }

  static Long w()
    throws i.a
  {
    if (kA == null)
      throw new a();
    try
    {
      Long localLong = (Long)kA.invoke(null, new Object[0]);
      return localLong;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new a(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new a(localInvocationTargetException);
    }
  }

  static String x()
    throws i.a
  {
    if (kC == null)
      throw new a();
    try
    {
      String str = (String)kC.invoke(null, new Object[0]);
      return str;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new a(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new a(localInvocationTargetException);
    }
  }

  static Long y()
    throws i.a
  {
    if (kB == null)
      throw new a();
    try
    {
      Long localLong = (Long)kB.invoke(null, new Object[0]);
      return localLong;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new a(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new a(localInvocationTargetException);
    }
  }

  // ERROR //
  protected void b(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: invokestatic 304	com/google/android/gms/internal/i:x	()Ljava/lang/String;
    //   5: invokevirtual 307	com/google/android/gms/internal/i:a	(ILjava/lang/String;)V
    //   8: aload_0
    //   9: iconst_2
    //   10: invokestatic 309	com/google/android/gms/internal/i:v	()Ljava/lang/String;
    //   13: invokevirtual 307	com/google/android/gms/internal/i:a	(ILjava/lang/String;)V
    //   16: invokestatic 95	com/google/android/gms/internal/i:w	()Ljava/lang/Long;
    //   19: invokevirtual 101	java/lang/Long:longValue	()J
    //   22: lstore 13
    //   24: aload_0
    //   25: bipush 25
    //   27: lload 13
    //   29: invokevirtual 312	com/google/android/gms/internal/i:a	(IJ)V
    //   32: getstatic 28	com/google/android/gms/internal/i:startTime	J
    //   35: lconst_0
    //   36: lcmp
    //   37: ifeq +24 -> 61
    //   40: aload_0
    //   41: bipush 17
    //   43: lload 13
    //   45: getstatic 28	com/google/android/gms/internal/i:startTime	J
    //   48: lsub
    //   49: invokevirtual 312	com/google/android/gms/internal/i:a	(IJ)V
    //   52: aload_0
    //   53: bipush 23
    //   55: getstatic 28	com/google/android/gms/internal/i:startTime	J
    //   58: invokevirtual 312	com/google/android/gms/internal/i:a	(IJ)V
    //   61: aload_1
    //   62: invokestatic 314	com/google/android/gms/internal/i:e	(Landroid/content/Context;)Ljava/util/ArrayList;
    //   65: astore 12
    //   67: aload_0
    //   68: bipush 31
    //   70: aload 12
    //   72: iconst_0
    //   73: invokevirtual 318	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   76: checkcast 97	java/lang/Long
    //   79: invokevirtual 101	java/lang/Long:longValue	()J
    //   82: invokevirtual 312	com/google/android/gms/internal/i:a	(IJ)V
    //   85: aload_0
    //   86: bipush 32
    //   88: aload 12
    //   90: iconst_1
    //   91: invokevirtual 318	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   94: checkcast 97	java/lang/Long
    //   97: invokevirtual 101	java/lang/Long:longValue	()J
    //   100: invokevirtual 312	com/google/android/gms/internal/i:a	(IJ)V
    //   103: aload_0
    //   104: bipush 33
    //   106: invokestatic 320	com/google/android/gms/internal/i:y	()Ljava/lang/Long;
    //   109: invokevirtual 101	java/lang/Long:longValue	()J
    //   112: invokevirtual 312	com/google/android/gms/internal/i:a	(IJ)V
    //   115: aload_0
    //   116: bipush 27
    //   118: aload_1
    //   119: aload_0
    //   120: getfield 324	com/google/android/gms/internal/i:ky	Lcom/google/android/gms/internal/m;
    //   123: invokestatic 326	com/google/android/gms/internal/i:a	(Landroid/content/Context;Lcom/google/android/gms/internal/m;)Ljava/lang/String;
    //   126: invokevirtual 307	com/google/android/gms/internal/i:a	(ILjava/lang/String;)V
    //   129: aload_0
    //   130: bipush 29
    //   132: aload_1
    //   133: aload_0
    //   134: getfield 324	com/google/android/gms/internal/i:ky	Lcom/google/android/gms/internal/m;
    //   137: invokestatic 328	com/google/android/gms/internal/i:b	(Landroid/content/Context;Lcom/google/android/gms/internal/m;)Ljava/lang/String;
    //   140: invokevirtual 307	com/google/android/gms/internal/i:a	(ILjava/lang/String;)V
    //   143: aload_1
    //   144: invokestatic 330	com/google/android/gms/internal/i:f	(Landroid/content/Context;)[I
    //   147: astore 11
    //   149: aload_0
    //   150: iconst_5
    //   151: aload 11
    //   153: iconst_0
    //   154: iaload
    //   155: i2l
    //   156: invokevirtual 312	com/google/android/gms/internal/i:a	(IJ)V
    //   159: aload_0
    //   160: bipush 6
    //   162: aload 11
    //   164: iconst_1
    //   165: iaload
    //   166: i2l
    //   167: invokevirtual 312	com/google/android/gms/internal/i:a	(IJ)V
    //   170: return
    //   171: astore 10
    //   173: return
    //   174: astore 9
    //   176: return
    //   177: astore 8
    //   179: goto -36 -> 143
    //   182: astore 7
    //   184: goto -55 -> 129
    //   187: astore 6
    //   189: goto -74 -> 115
    //   192: astore 5
    //   194: goto -91 -> 103
    //   197: astore 4
    //   199: goto -138 -> 61
    //   202: astore_3
    //   203: goto -187 -> 16
    //   206: astore_2
    //   207: goto -199 -> 8
    //
    // Exception table:
    //   from	to	target	type
    //   0	8	171	java/io/IOException
    //   8	16	171	java/io/IOException
    //   16	61	171	java/io/IOException
    //   61	103	171	java/io/IOException
    //   103	115	171	java/io/IOException
    //   115	129	171	java/io/IOException
    //   129	143	171	java/io/IOException
    //   143	170	171	java/io/IOException
    //   143	170	174	com/google/android/gms/internal/i$a
    //   129	143	177	com/google/android/gms/internal/i$a
    //   115	129	182	com/google/android/gms/internal/i$a
    //   103	115	187	com/google/android/gms/internal/i$a
    //   61	103	192	com/google/android/gms/internal/i$a
    //   16	61	197	com/google/android/gms/internal/i$a
    //   8	16	202	com/google/android/gms/internal/i$a
    //   0	8	206	com/google/android/gms/internal/i$a
  }

  // ERROR //
  protected void c(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_2
    //   2: invokestatic 309	com/google/android/gms/internal/i:v	()Ljava/lang/String;
    //   5: invokevirtual 307	com/google/android/gms/internal/i:a	(ILjava/lang/String;)V
    //   8: aload_0
    //   9: iconst_1
    //   10: invokestatic 304	com/google/android/gms/internal/i:x	()Ljava/lang/String;
    //   13: invokevirtual 307	com/google/android/gms/internal/i:a	(ILjava/lang/String;)V
    //   16: aload_0
    //   17: bipush 25
    //   19: invokestatic 95	com/google/android/gms/internal/i:w	()Ljava/lang/Long;
    //   22: invokevirtual 101	java/lang/Long:longValue	()J
    //   25: invokevirtual 312	com/google/android/gms/internal/i:a	(IJ)V
    //   28: aload_0
    //   29: getfield 334	com/google/android/gms/internal/i:kw	Landroid/view/MotionEvent;
    //   32: aload_0
    //   33: getfield 338	com/google/android/gms/internal/i:kx	Landroid/util/DisplayMetrics;
    //   36: invokestatic 340	com/google/android/gms/internal/i:a	(Landroid/view/MotionEvent;Landroid/util/DisplayMetrics;)Ljava/util/ArrayList;
    //   39: astore 7
    //   41: aload_0
    //   42: bipush 14
    //   44: aload 7
    //   46: iconst_0
    //   47: invokevirtual 318	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   50: checkcast 97	java/lang/Long
    //   53: invokevirtual 101	java/lang/Long:longValue	()J
    //   56: invokevirtual 312	com/google/android/gms/internal/i:a	(IJ)V
    //   59: aload_0
    //   60: bipush 15
    //   62: aload 7
    //   64: iconst_1
    //   65: invokevirtual 318	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   68: checkcast 97	java/lang/Long
    //   71: invokevirtual 101	java/lang/Long:longValue	()J
    //   74: invokevirtual 312	com/google/android/gms/internal/i:a	(IJ)V
    //   77: aload 7
    //   79: invokevirtual 134	java/util/ArrayList:size	()I
    //   82: iconst_3
    //   83: if_icmplt +21 -> 104
    //   86: aload_0
    //   87: bipush 16
    //   89: aload 7
    //   91: iconst_2
    //   92: invokevirtual 318	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   95: checkcast 97	java/lang/Long
    //   98: invokevirtual 101	java/lang/Long:longValue	()J
    //   101: invokevirtual 312	com/google/android/gms/internal/i:a	(IJ)V
    //   104: return
    //   105: astore 6
    //   107: return
    //   108: astore 5
    //   110: return
    //   111: astore 4
    //   113: goto -85 -> 28
    //   116: astore_3
    //   117: goto -101 -> 16
    //   120: astore_2
    //   121: goto -113 -> 8
    //
    // Exception table:
    //   from	to	target	type
    //   0	8	105	java/io/IOException
    //   8	16	105	java/io/IOException
    //   16	28	105	java/io/IOException
    //   28	104	105	java/io/IOException
    //   28	104	108	com/google/android/gms/internal/i$a
    //   16	28	111	com/google/android/gms/internal/i$a
    //   8	16	116	com/google/android/gms/internal/i$a
    //   0	8	120	com/google/android/gms/internal/i$a
  }

  static class a extends Exception
  {
    public a()
    {
    }

    public a(Throwable paramThrowable)
    {
      super();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.i
 * JD-Core Version:    0.6.2
 */