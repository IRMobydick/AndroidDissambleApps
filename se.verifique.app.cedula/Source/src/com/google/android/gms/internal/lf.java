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

public abstract class lf extends jp
{
  static boolean d;
  private static Method e;
  private static Method f;
  private static Method g;
  private static Method h;
  private static Method i;
  private static Method j;
  private static Method k;
  private static Method l;
  private static String m;
  private static long n = 0L;
  private static nx o;

  static
  {
    d = false;
  }

  protected lf(Context paramContext, nq paramnq, nw paramnw)
  {
    super(paramContext, paramnq, paramnw);
  }

  static String a()
  {
    if (m == null)
      throw new lh();
    return m;
  }

  static String a(Context paramContext, nq paramnq)
  {
    if (h == null)
      throw new lh();
    try
    {
      Method localMethod = h;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramContext;
      localByteBuffer = (ByteBuffer)localMethod.invoke(null, arrayOfObject);
      if (localByteBuffer == null)
        throw new lh();
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      ByteBuffer localByteBuffer;
      throw new lh(localIllegalAccessException);
      String str = paramnq.a(localByteBuffer.array(), true);
      return str;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
    }
    throw new lh(localInvocationTargetException);
  }

  static ArrayList a(MotionEvent paramMotionEvent, DisplayMetrics paramDisplayMetrics)
  {
    if ((i == null) || (paramMotionEvent == null))
      throw new lh();
    try
    {
      Method localMethod = i;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramMotionEvent;
      arrayOfObject[1] = paramDisplayMetrics;
      ArrayList localArrayList = (ArrayList)localMethod.invoke(null, arrayOfObject);
      return localArrayList;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new lh(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
    }
    throw new lh(localInvocationTargetException);
  }

  // ERROR //
  protected static void a(String paramString, Context paramContext, nq paramnq)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 27	com/google/android/gms/internal/lf:d	Z
    //   6: istore 4
    //   8: iload 4
    //   10: ifne +36 -> 46
    //   13: new 78	com/google/android/gms/internal/nx
    //   16: dup
    //   17: aload_2
    //   18: aconst_null
    //   19: invokespecial 81	com/google/android/gms/internal/nx:<init>	(Lcom/google/android/gms/internal/nq;Ljava/security/SecureRandom;)V
    //   22: putstatic 83	com/google/android/gms/internal/lf:o	Lcom/google/android/gms/internal/nx;
    //   25: aload_0
    //   26: putstatic 35	com/google/android/gms/internal/lf:m	Ljava/lang/String;
    //   29: aload_1
    //   30: invokestatic 86	com/google/android/gms/internal/lf:h	(Landroid/content/Context;)V
    //   33: invokestatic 90	com/google/android/gms/internal/lf:b	()Ljava/lang/Long;
    //   36: invokevirtual 96	java/lang/Long:longValue	()J
    //   39: putstatic 25	com/google/android/gms/internal/lf:n	J
    //   42: iconst_1
    //   43: putstatic 27	com/google/android/gms/internal/lf:d	Z
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
    //   13	46	61	com/google/android/gms/internal/lh
  }

  static Long b()
  {
    if (e == null)
      throw new lh();
    try
    {
      Long localLong = (Long)e.invoke(null, new Object[0]);
      return localLong;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new lh(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
    }
    throw new lh(localInvocationTargetException);
  }

  static String b(Context paramContext, nq paramnq)
  {
    if (k == null)
      throw new lh();
    try
    {
      Method localMethod = k;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramContext;
      localByteBuffer = (ByteBuffer)localMethod.invoke(null, arrayOfObject);
      if (localByteBuffer == null)
        throw new lh();
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      ByteBuffer localByteBuffer;
      throw new lh(localIllegalAccessException);
      String str = paramnq.a(localByteBuffer.array(), true);
      return str;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
    }
    throw new lh(localInvocationTargetException);
  }

  private static String b(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      String str = new String(o.a(paramArrayOfByte, paramString), "UTF-8");
      return str;
    }
    catch (ny localny)
    {
      throw new lh(localny);
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    throw new lh(localUnsupportedEncodingException);
  }

  static String c()
  {
    if (g == null)
      throw new lh();
    try
    {
      String str = (String)g.invoke(null, new Object[0]);
      return str;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new lh(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
    }
    throw new lh(localInvocationTargetException);
  }

  static Long d()
  {
    if (f == null)
      throw new lh();
    try
    {
      Long localLong = (Long)f.invoke(null, new Object[0]);
      return localLong;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new lh(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
    }
    throw new lh(localInvocationTargetException);
  }

  static String f(Context paramContext)
  {
    if (j == null)
      throw new lh();
    String str;
    try
    {
      Method localMethod = j;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramContext;
      str = (String)localMethod.invoke(null, arrayOfObject);
      if (str == null)
        throw new lh();
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new lh(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new lh(localInvocationTargetException);
    }
    return str;
  }

  static ArrayList g(Context paramContext)
  {
    if (l == null)
      throw new lh();
    ArrayList localArrayList;
    try
    {
      Method localMethod = l;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramContext;
      localArrayList = (ArrayList)localMethod.invoke(null, arrayOfObject);
      if ((localArrayList == null) || (localArrayList.size() != 2))
        throw new lh();
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new lh(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new lh(localInvocationTargetException);
    }
    return localArrayList;
  }

  private static void h(Context paramContext)
  {
    try
    {
      arrayOfByte1 = o.a(oa.a());
      arrayOfByte2 = o.a(arrayOfByte1, oa.b());
      localFile1 = paramContext.getCacheDir();
      if (localFile1 == null)
      {
        localFile1 = paramContext.getDir("dex", 0);
        if (localFile1 == null)
          throw new lh();
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      byte[] arrayOfByte1;
      byte[] arrayOfByte2;
      File localFile1;
      throw new lh(localFileNotFoundException);
      File localFile2 = localFile1;
      File localFile3 = File.createTempFile("ads", ".jar", localFile2);
      FileOutputStream localFileOutputStream = new FileOutputStream(localFile3);
      localFileOutputStream.write(arrayOfByte2, 0, arrayOfByte2.length);
      localFileOutputStream.close();
      try
      {
        DexClassLoader localDexClassLoader = new DexClassLoader(localFile3.getAbsolutePath(), localFile2.getAbsolutePath(), null, paramContext.getClassLoader());
        Class localClass1 = localDexClassLoader.loadClass(b(arrayOfByte1, oa.c()));
        Class localClass2 = localDexClassLoader.loadClass(b(arrayOfByte1, oa.o()));
        Class localClass3 = localDexClassLoader.loadClass(b(arrayOfByte1, oa.i()));
        Class localClass4 = localDexClassLoader.loadClass(b(arrayOfByte1, oa.g()));
        Class localClass5 = localDexClassLoader.loadClass(b(arrayOfByte1, oa.q()));
        Class localClass6 = localDexClassLoader.loadClass(b(arrayOfByte1, oa.e()));
        Class localClass7 = localDexClassLoader.loadClass(b(arrayOfByte1, oa.m()));
        Class localClass8 = localDexClassLoader.loadClass(b(arrayOfByte1, oa.k()));
        e = localClass1.getMethod(b(arrayOfByte1, oa.d()), new Class[0]);
        f = localClass2.getMethod(b(arrayOfByte1, oa.p()), new Class[0]);
        g = localClass3.getMethod(b(arrayOfByte1, oa.j()), new Class[0]);
        String str2 = b(arrayOfByte1, oa.h());
        Class[] arrayOfClass1 = new Class[1];
        arrayOfClass1[0] = Context.class;
        h = localClass4.getMethod(str2, arrayOfClass1);
        String str3 = b(arrayOfByte1, oa.r());
        Class[] arrayOfClass2 = new Class[2];
        arrayOfClass2[0] = MotionEvent.class;
        arrayOfClass2[1] = DisplayMetrics.class;
        i = localClass5.getMethod(str3, arrayOfClass2);
        String str4 = b(arrayOfByte1, oa.f());
        Class[] arrayOfClass3 = new Class[1];
        arrayOfClass3[0] = Context.class;
        j = localClass6.getMethod(str4, arrayOfClass3);
        String str5 = b(arrayOfByte1, oa.n());
        Class[] arrayOfClass4 = new Class[1];
        arrayOfClass4[0] = Context.class;
        k = localClass7.getMethod(str5, arrayOfClass4);
        String str6 = b(arrayOfByte1, oa.l());
        Class[] arrayOfClass5 = new Class[1];
        arrayOfClass5[0] = Context.class;
        l = localClass8.getMethod(str6, arrayOfClass5);
        String str7;
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
      throw new lh(localIOException);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new lh(localClassNotFoundException);
    }
    catch (ny localny)
    {
      throw new lh(localny);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new lh(localNoSuchMethodException);
    }
    catch (NullPointerException localNullPointerException)
    {
    }
    throw new lh(localNullPointerException);
  }

  // ERROR //
  protected void c(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: invokestatic 263	com/google/android/gms/internal/lf:c	()Ljava/lang/String;
    //   5: invokevirtual 266	com/google/android/gms/internal/lf:a	(ILjava/lang/String;)V
    //   8: aload_0
    //   9: iconst_2
    //   10: invokestatic 267	com/google/android/gms/internal/lf:a	()Ljava/lang/String;
    //   13: invokevirtual 266	com/google/android/gms/internal/lf:a	(ILjava/lang/String;)V
    //   16: aload_0
    //   17: bipush 25
    //   19: invokestatic 90	com/google/android/gms/internal/lf:b	()Ljava/lang/Long;
    //   22: invokevirtual 96	java/lang/Long:longValue	()J
    //   25: invokevirtual 270	com/google/android/gms/internal/lf:a	(IJ)V
    //   28: aload_1
    //   29: invokestatic 272	com/google/android/gms/internal/lf:g	(Landroid/content/Context;)Ljava/util/ArrayList;
    //   32: astore 8
    //   34: aload_0
    //   35: bipush 31
    //   37: aload 8
    //   39: iconst_0
    //   40: invokevirtual 276	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   43: checkcast 92	java/lang/Long
    //   46: invokevirtual 96	java/lang/Long:longValue	()J
    //   49: invokevirtual 270	com/google/android/gms/internal/lf:a	(IJ)V
    //   52: aload_0
    //   53: bipush 32
    //   55: aload 8
    //   57: iconst_1
    //   58: invokevirtual 276	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   61: checkcast 92	java/lang/Long
    //   64: invokevirtual 96	java/lang/Long:longValue	()J
    //   67: invokevirtual 270	com/google/android/gms/internal/lf:a	(IJ)V
    //   70: aload_0
    //   71: bipush 33
    //   73: invokestatic 278	com/google/android/gms/internal/lf:d	()Ljava/lang/Long;
    //   76: invokevirtual 96	java/lang/Long:longValue	()J
    //   79: invokevirtual 270	com/google/android/gms/internal/lf:a	(IJ)V
    //   82: return
    //   83: astore 7
    //   85: goto -3 -> 82
    //   88: astore 6
    //   90: goto -8 -> 82
    //   93: astore 5
    //   95: goto -25 -> 70
    //   98: astore 4
    //   100: goto -72 -> 28
    //   103: astore_3
    //   104: goto -88 -> 16
    //   107: astore_2
    //   108: goto -100 -> 8
    //
    // Exception table:
    //   from	to	target	type
    //   0	8	83	java/io/IOException
    //   8	16	83	java/io/IOException
    //   16	28	83	java/io/IOException
    //   28	70	83	java/io/IOException
    //   70	82	83	java/io/IOException
    //   70	82	88	com/google/android/gms/internal/lh
    //   28	70	93	com/google/android/gms/internal/lh
    //   16	28	98	com/google/android/gms/internal/lh
    //   8	16	103	com/google/android/gms/internal/lh
    //   0	8	107	com/google/android/gms/internal/lh
  }

  // ERROR //
  protected void e(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_2
    //   2: invokestatic 267	com/google/android/gms/internal/lf:a	()Ljava/lang/String;
    //   5: invokevirtual 266	com/google/android/gms/internal/lf:a	(ILjava/lang/String;)V
    //   8: aload_0
    //   9: iconst_1
    //   10: invokestatic 263	com/google/android/gms/internal/lf:c	()Ljava/lang/String;
    //   13: invokevirtual 266	com/google/android/gms/internal/lf:a	(ILjava/lang/String;)V
    //   16: invokestatic 90	com/google/android/gms/internal/lf:b	()Ljava/lang/Long;
    //   19: invokevirtual 96	java/lang/Long:longValue	()J
    //   22: lstore 10
    //   24: aload_0
    //   25: bipush 25
    //   27: lload 10
    //   29: invokevirtual 270	com/google/android/gms/internal/lf:a	(IJ)V
    //   32: getstatic 25	com/google/android/gms/internal/lf:n	J
    //   35: lconst_0
    //   36: lcmp
    //   37: ifeq +24 -> 61
    //   40: aload_0
    //   41: bipush 17
    //   43: lload 10
    //   45: getstatic 25	com/google/android/gms/internal/lf:n	J
    //   48: lsub
    //   49: invokevirtual 270	com/google/android/gms/internal/lf:a	(IJ)V
    //   52: aload_0
    //   53: bipush 23
    //   55: getstatic 25	com/google/android/gms/internal/lf:n	J
    //   58: invokevirtual 270	com/google/android/gms/internal/lf:a	(IJ)V
    //   61: aload_0
    //   62: getfield 281	com/google/android/gms/internal/lf:a	Landroid/view/MotionEvent;
    //   65: aload_0
    //   66: getfield 284	com/google/android/gms/internal/lf:b	Landroid/util/DisplayMetrics;
    //   69: invokestatic 286	com/google/android/gms/internal/lf:a	(Landroid/view/MotionEvent;Landroid/util/DisplayMetrics;)Ljava/util/ArrayList;
    //   72: astore 9
    //   74: aload_0
    //   75: bipush 14
    //   77: aload 9
    //   79: iconst_0
    //   80: invokevirtual 276	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   83: checkcast 92	java/lang/Long
    //   86: invokevirtual 96	java/lang/Long:longValue	()J
    //   89: invokevirtual 270	com/google/android/gms/internal/lf:a	(IJ)V
    //   92: aload_0
    //   93: bipush 15
    //   95: aload 9
    //   97: iconst_1
    //   98: invokevirtual 276	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   101: checkcast 92	java/lang/Long
    //   104: invokevirtual 96	java/lang/Long:longValue	()J
    //   107: invokevirtual 270	com/google/android/gms/internal/lf:a	(IJ)V
    //   110: aload 9
    //   112: invokevirtual 130	java/util/ArrayList:size	()I
    //   115: iconst_3
    //   116: if_icmplt +21 -> 137
    //   119: aload_0
    //   120: bipush 16
    //   122: aload 9
    //   124: iconst_2
    //   125: invokevirtual 276	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   128: checkcast 92	java/lang/Long
    //   131: invokevirtual 96	java/lang/Long:longValue	()J
    //   134: invokevirtual 270	com/google/android/gms/internal/lf:a	(IJ)V
    //   137: aload_0
    //   138: bipush 27
    //   140: aload_1
    //   141: aload_0
    //   142: getfield 289	com/google/android/gms/internal/lf:c	Lcom/google/android/gms/internal/nq;
    //   145: invokestatic 291	com/google/android/gms/internal/lf:a	(Landroid/content/Context;Lcom/google/android/gms/internal/nq;)Ljava/lang/String;
    //   148: invokevirtual 266	com/google/android/gms/internal/lf:a	(ILjava/lang/String;)V
    //   151: aload_0
    //   152: bipush 29
    //   154: aload_1
    //   155: aload_0
    //   156: getfield 289	com/google/android/gms/internal/lf:c	Lcom/google/android/gms/internal/nq;
    //   159: invokestatic 293	com/google/android/gms/internal/lf:b	(Landroid/content/Context;Lcom/google/android/gms/internal/nq;)Ljava/lang/String;
    //   162: invokevirtual 266	com/google/android/gms/internal/lf:a	(ILjava/lang/String;)V
    //   165: return
    //   166: astore 8
    //   168: goto -3 -> 165
    //   171: astore 7
    //   173: goto -8 -> 165
    //   176: astore 6
    //   178: goto -27 -> 151
    //   181: astore 5
    //   183: goto -46 -> 137
    //   186: astore 4
    //   188: goto -127 -> 61
    //   191: astore_3
    //   192: goto -176 -> 16
    //   195: astore_2
    //   196: goto -188 -> 8
    //
    // Exception table:
    //   from	to	target	type
    //   0	8	166	java/io/IOException
    //   8	16	166	java/io/IOException
    //   16	61	166	java/io/IOException
    //   61	137	166	java/io/IOException
    //   137	151	166	java/io/IOException
    //   151	165	166	java/io/IOException
    //   151	165	171	com/google/android/gms/internal/lh
    //   137	151	176	com/google/android/gms/internal/lh
    //   61	137	181	com/google/android/gms/internal/lh
    //   16	61	186	com/google/android/gms/internal/lh
    //   8	16	191	com/google/android/gms/internal/lh
    //   0	8	195	com/google/android/gms/internal/lh
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.lf
 * JD-Core Version:    0.6.0
 */