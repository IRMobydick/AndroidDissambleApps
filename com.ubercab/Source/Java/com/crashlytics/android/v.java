package com.crashlytics.android;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Environment;
import com.crashlytics.android.internal.ab;
import com.crashlytics.android.internal.ah;
import com.crashlytics.android.internal.ap;
import com.crashlytics.android.internal.aq;
import com.crashlytics.android.internal.q;
import com.crashlytics.android.internal.r;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

final class v
  implements Thread.UncaughtExceptionHandler
{
  static final FilenameFilter a = new w();
  private static Comparator<File> b = new H();
  private static Comparator<File> c = new J();
  private static final Pattern d = Pattern.compile("([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");
  private static final Map<String, String> e = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", "1");
  private static final d f = d.a("0");
  private final AtomicInteger g = new AtomicInteger(0);
  private final AtomicBoolean h = new AtomicBoolean(false);
  private final int i;
  private final Thread.UncaughtExceptionHandler j;
  private final File k;
  private final File l;
  private final AtomicBoolean m;
  private final String n;
  private final BroadcastReceiver o;
  private final BroadcastReceiver p;
  private final d q;
  private final d r;
  private final ExecutorService s;
  private ActivityManager.RunningAppProcessInfo t;
  private aq u;
  private boolean v;
  private Thread[] w;
  private List<StackTraceElement[]> x;
  private StackTraceElement[] y;

  static
  {
    new K();
  }

  public v(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler, CrashlyticsListener paramCrashlyticsListener, String paramString)
  {
    this(paramUncaughtExceptionHandler, paramCrashlyticsListener, ah.a("Crashlytics Exception Handler"), paramString);
  }

  private v(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler, CrashlyticsListener paramCrashlyticsListener, ExecutorService paramExecutorService, String paramString)
  {
    this.j = paramUncaughtExceptionHandler;
    this.s = paramExecutorService;
    this.m = new AtomicBoolean(false);
    this.k = com.crashlytics.android.internal.v.a().h();
    this.l = new File(this.k, "initialization_marker");
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Crashlytics.getInstance().getVersion();
    this.n = String.format(localLocale, "Crashlytics Android SDK/%s", arrayOfObject);
    this.i = 8;
    com.crashlytics.android.internal.v.a().b().a("Crashlytics", "Checking for previous crash marker.");
    File localFile = new File(com.crashlytics.android.internal.v.a().h(), "crash_marker");
    if (localFile.exists())
    {
      localFile.delete();
      if (paramCrashlyticsListener == null);
    }
    try
    {
      paramCrashlyticsListener.crashlyticsDidDetectCrashDuringPreviousExecution();
      this.q = d.a(Crashlytics.d());
      if (paramString == null)
      {
        locald = null;
        this.r = locald;
        this.p = new L(this);
        IntentFilter localIntentFilter1 = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");
        this.o = new M(this);
        IntentFilter localIntentFilter2 = new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED");
        Crashlytics.getInstance().getContext().registerReceiver(this.p, localIntentFilter1);
        Crashlytics.getInstance().getContext().registerReceiver(this.o, localIntentFilter2);
        this.h.set(true);
        return;
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        com.crashlytics.android.internal.v.a().b().a("Crashlytics", "Exception thrown by CrashlyticsListener while notifying of previous crash.", localException);
        continue;
        d locald = d.a(paramString.replace("-", ""));
      }
    }
  }

  private static int a(float paramFloat, int paramInt1, boolean paramBoolean, int paramInt2, long paramLong1, long paramLong2)
  {
    return 0 + h.b(1, paramFloat) + h.f(2, paramInt1) + h.b(3, paramBoolean) + h.d(4, paramInt2) + h.b(5, paramLong1) + h.b(6, paramLong2);
  }

  private int a(int paramInt1, d paramd1, d paramd2, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, Map<ap, String> paramMap, int paramInt3, d paramd3, d paramd4)
  {
    int i1 = 0 + h.b(1, paramd1) + h.e(3, paramInt1);
    if (paramd2 == null);
    int i3;
    for (int i2 = 0; ; i2 = h.b(4, paramd2))
    {
      i3 = i2 + i1 + h.d(5, paramInt2) + h.b(6, paramLong1) + h.b(7, paramLong2) + h.b(10, paramBoolean);
      if (paramMap == null)
        break;
      Iterator localIterator = paramMap.entrySet().iterator();
      i4 = i3;
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        int i9 = a((ap)localEntry.getKey(), (String)localEntry.getValue());
        i4 += i9 + (h.a(11) + h.c(i9));
      }
    }
    int i4 = i3;
    int i5 = i4 + h.d(12, paramInt3);
    int i6;
    int i7;
    if (paramd3 == null)
    {
      i6 = 0;
      i7 = i5 + i6;
      if (paramd4 != null)
        break label219;
    }
    label219: for (int i8 = 0; ; i8 = h.b(14, paramd4))
    {
      return i8 + i7;
      i6 = h.b(13, paramd3);
      break;
    }
  }

  private static int a(ap paramap, String paramString)
  {
    return h.e(1, paramap.f) + h.b(2, d.a(paramString));
  }

  private static int a(StackTraceElement paramStackTraceElement, boolean paramBoolean)
  {
    int i1;
    int i2;
    if (paramStackTraceElement.isNativeMethod())
    {
      i1 = 0 + h.b(1, Math.max(paramStackTraceElement.getLineNumber(), 0));
      i2 = i1 + h.b(2, d.a(paramStackTraceElement.getClassName() + "." + paramStackTraceElement.getMethodName()));
      if (paramStackTraceElement.getFileName() != null)
        i2 += h.b(3, d.a(paramStackTraceElement.getFileName()));
      if ((paramStackTraceElement.isNativeMethod()) || (paramStackTraceElement.getLineNumber() <= 0))
        break label145;
    }
    label145: for (int i3 = i2 + h.b(4, paramStackTraceElement.getLineNumber()); ; i3 = i2)
    {
      if (paramBoolean);
      for (int i4 = 2; ; i4 = 0)
      {
        return i3 + h.d(5, i4);
        i1 = 0 + h.b(1, 0L);
        break;
      }
    }
  }

  private static int a(String paramString1, String paramString2)
  {
    int i1 = h.b(1, d.a(paramString1));
    if (paramString2 == null)
      paramString2 = "";
    return i1 + h.b(2, d.a(paramString2));
  }

  private int a(Thread paramThread, Throwable paramThrowable, Map<String, String> paramMap)
  {
    int i1 = b(paramThread, paramThrowable);
    int i2 = 0 + (i1 + (h.a(1) + h.c(i1)));
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      i3 = i2;
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        int i4 = a((String)localEntry.getKey(), (String)localEntry.getValue());
        i3 += i4 + (h.a(2) + h.c(i4));
      }
    }
    int i3 = i2;
    if (this.t != null)
      if (this.t.importance == 100)
        break label174;
    label174: for (boolean bool = true; ; bool = false)
    {
      i3 += h.b(3, bool);
      return i3 + h.d(4, Crashlytics.getInstance().getContext().getResources().getConfiguration().orientation);
    }
  }

  private int a(Thread paramThread, StackTraceElement[] paramArrayOfStackTraceElement, int paramInt, boolean paramBoolean)
  {
    int i1 = h.b(1, d.a(paramThread.getName())) + h.d(2, paramInt);
    int i2 = paramArrayOfStackTraceElement.length;
    for (int i3 = 0; i3 < i2; i3++)
    {
      int i4 = a(paramArrayOfStackTraceElement[i3], paramBoolean);
      i1 += i4 + (h.a(3) + h.c(i4));
    }
    return i1;
  }

  private int a(Throwable paramThrowable, int paramInt)
  {
    int i1 = 0 + h.b(1, d.a(paramThrowable.getClass().getName()));
    String str = paramThrowable.getLocalizedMessage();
    if (str != null)
      i1 += h.b(3, d.a(str));
    StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
    int i2 = arrayOfStackTraceElement.length;
    int i3 = 0;
    while (i3 < i2)
    {
      int i6 = a(arrayOfStackTraceElement[i3], true);
      int i7 = i1 + (i6 + (h.a(4) + h.c(i6)));
      i3++;
      i1 = i7;
    }
    Throwable localThrowable = paramThrowable.getCause();
    int i4;
    if (localThrowable != null)
    {
      i4 = 0;
      if (paramInt < 8)
      {
        int i5 = a(localThrowable, paramInt + 1);
        i1 += i5 + (h.a(6) + h.c(i5));
      }
    }
    else
    {
      return i1;
    }
    while (localThrowable != null)
    {
      localThrowable = localThrowable.getCause();
      i4++;
    }
    return i1 + h.d(7, i4);
  }

  private d a(aq paramaq)
  {
    if (paramaq == null)
      return null;
    int[] arrayOfInt = { 0 };
    byte[] arrayOfByte = new byte[paramaq.a()];
    try
    {
      paramaq.a(new y(this, arrayOfByte, arrayOfInt));
      return d.a(arrayOfByte, 0, arrayOfInt[0]);
    }
    catch (IOException localIOException)
    {
      while (true)
        com.crashlytics.android.internal.v.a().b().a("Crashlytics", "A problem occurred while reading the Crashlytics log file.", localIOException);
    }
  }

  private <T> T a(Callable<T> paramCallable)
  {
    try
    {
      Object localObject = this.s.submit(paramCallable).get();
      return localObject;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      com.crashlytics.android.internal.v.a().b().a("Crashlytics", "Executor is shut down because we're handling a fatal crash.");
      return null;
    }
    catch (Exception localException)
    {
      com.crashlytics.android.internal.v.a().b().a("Crashlytics", "Failed to execute task.", localException);
    }
    return null;
  }

  private static String a(File paramFile)
  {
    return paramFile.getName().substring(0, 35);
  }

  private Future<?> a(Runnable paramRunnable)
  {
    try
    {
      Future localFuture = this.s.submit(new G(this, paramRunnable));
      return localFuture;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      com.crashlytics.android.internal.v.a().b().a("Crashlytics", "Executor is shut down because we're handling a fatal crash.");
    }
    return null;
  }

  private static void a(f paramf)
  {
    if (paramf != null);
    try
    {
      paramf.a();
      return;
    }
    catch (IOException localIOException)
    {
      com.crashlytics.android.internal.v.a().b().a("Crashlytics", "Error closing session file stream in the presence of an exception", localIOException);
    }
  }

  private void a(h paramh, int paramInt, StackTraceElement paramStackTraceElement, boolean paramBoolean)
    throws Exception
  {
    int i1 = 4;
    paramh.g(paramInt, 2);
    paramh.b(a(paramStackTraceElement, paramBoolean));
    if (paramStackTraceElement.isNativeMethod())
    {
      paramh.a(1, Math.max(paramStackTraceElement.getLineNumber(), 0));
      paramh.a(2, d.a(paramStackTraceElement.getClassName() + "." + paramStackTraceElement.getMethodName()));
      if (paramStackTraceElement.getFileName() != null)
        paramh.a(3, d.a(paramStackTraceElement.getFileName()));
      if ((!paramStackTraceElement.isNativeMethod()) && (paramStackTraceElement.getLineNumber() > 0))
        paramh.a(i1, paramStackTraceElement.getLineNumber());
      if (!paramBoolean)
        break label144;
    }
    while (true)
    {
      paramh.a(5, i1);
      return;
      paramh.a(1, 0L);
      break;
      label144: i1 = 0;
    }
  }

  // ERROR //
  private static void a(h paramh, File paramFile)
    throws IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 205	java/io/File:exists	()Z
    //   4: ifeq +86 -> 90
    //   7: aload_1
    //   8: invokevirtual 505	java/io/File:length	()J
    //   11: l2i
    //   12: newarray byte
    //   14: astore_2
    //   15: new 507	java/io/FileInputStream
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 510	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   23: astore_3
    //   24: iconst_0
    //   25: istore 4
    //   27: iload 4
    //   29: aload_2
    //   30: arraylength
    //   31: if_icmpge +32 -> 63
    //   34: aload_3
    //   35: aload_2
    //   36: iload 4
    //   38: aload_2
    //   39: arraylength
    //   40: iload 4
    //   42: isub
    //   43: invokevirtual 514	java/io/FileInputStream:read	([BII)I
    //   46: istore 6
    //   48: iload 6
    //   50: iflt +13 -> 63
    //   53: iload 4
    //   55: iload 6
    //   57: iadd
    //   58: istore 4
    //   60: goto -33 -> 27
    //   63: aload_3
    //   64: ldc_w 516
    //   67: invokestatic 521	com/crashlytics/android/internal/ab:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   70: aload_0
    //   71: aload_2
    //   72: invokevirtual 524	com/crashlytics/android/h:a	([B)V
    //   75: return
    //   76: astore 5
    //   78: aconst_null
    //   79: astore_3
    //   80: aload_3
    //   81: ldc_w 516
    //   84: invokestatic 521	com/crashlytics/android/internal/ab:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   87: aload 5
    //   89: athrow
    //   90: invokestatic 145	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   93: invokevirtual 190	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   96: ldc 192
    //   98: new 347	java/lang/StringBuilder
    //   101: dup
    //   102: ldc_w 526
    //   105: invokespecial 527	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   108: aload_1
    //   109: invokevirtual 466	java/io/File:getName	()Ljava/lang/String;
    //   112: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 363	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: aconst_null
    //   119: invokeinterface 258 4 0
    //   124: return
    //   125: astore 5
    //   127: goto -47 -> 80
    //
    // Exception table:
    //   from	to	target	type
    //   15	24	76	finally
    //   27	48	125	finally
  }

  private void a(h paramh, String paramString)
    throws IOException
  {
    String[] arrayOfString = { "SessionUser", "SessionApp", "SessionOS", "SessionDevice" };
    int i1 = arrayOfString.length;
    int i2 = 0;
    if (i2 < i1)
    {
      String str = arrayOfString[i2];
      File[] arrayOfFile = a(new R(paramString + str));
      if (arrayOfFile.length == 0)
        com.crashlytics.android.internal.v.a().b().a("Crashlytics", "Can't find " + str + " data for session ID " + paramString, null);
      while (true)
      {
        i2++;
        break;
        com.crashlytics.android.internal.v.a().b().a("Crashlytics", "Collecting " + str + " data for session ID " + paramString);
        a(paramh, arrayOfFile[0]);
      }
    }
  }

  private void a(h paramh, Thread paramThread, Throwable paramThrowable)
    throws Exception
  {
    paramh.g(1, 2);
    paramh.b(b(paramThread, paramThrowable));
    a(paramh, paramThread, this.y, 4, true);
    int i1 = this.w.length;
    for (int i2 = 0; i2 < i1; i2++)
      a(paramh, this.w[i2], (StackTraceElement[])this.x.get(i2), 0, false);
    a(paramh, paramThrowable, 1, 2);
    paramh.g(3, 2);
    paramh.b(s());
    paramh.a(1, f);
    paramh.a(2, f);
    paramh.a(3, 0L);
    paramh.g(4, 2);
    paramh.b(r());
    paramh.a(1, 0L);
    paramh.a(2, 0L);
    paramh.a(3, this.q);
    if (this.r != null)
      paramh.a(4, this.r);
  }

  private void a(h paramh, Thread paramThread, StackTraceElement[] paramArrayOfStackTraceElement, int paramInt, boolean paramBoolean)
    throws Exception
  {
    paramh.g(1, 2);
    paramh.b(a(paramThread, paramArrayOfStackTraceElement, paramInt, paramBoolean));
    paramh.a(1, d.a(paramThread.getName()));
    paramh.a(2, paramInt);
    int i1 = paramArrayOfStackTraceElement.length;
    for (int i2 = 0; i2 < i1; i2++)
      a(paramh, 3, paramArrayOfStackTraceElement[i2], paramBoolean);
  }

  private void a(h paramh, Throwable paramThrowable, int paramInt1, int paramInt2)
    throws Exception
  {
    paramh.g(paramInt2, 2);
    paramh.b(a(paramThrowable, 1));
    paramh.a(1, d.a(paramThrowable.getClass().getName()));
    String str = paramThrowable.getLocalizedMessage();
    if (str != null)
      paramh.a(3, d.a(str));
    StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
    int i1 = arrayOfStackTraceElement.length;
    for (int i2 = 0; i2 < i1; i2++)
      a(paramh, 4, arrayOfStackTraceElement[i2], true);
    Throwable localThrowable = paramThrowable.getCause();
    int i3;
    if (localThrowable != null)
    {
      i3 = 0;
      if (paramInt1 < 8)
        a(paramh, localThrowable, paramInt1 + 1, 6);
    }
    else
    {
      return;
    }
    while (localThrowable != null)
    {
      localThrowable = localThrowable.getCause();
      i3++;
    }
    paramh.a(7, i3);
  }

  private void a(h paramh, Map<String, String> paramMap)
    throws Exception
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramh.g(2, 2);
      paramh.b(a((String)localEntry.getKey(), (String)localEntry.getValue()));
      paramh.a(1, d.a((String)localEntry.getKey()));
      String str = (String)localEntry.getValue();
      if (str == null)
        str = "";
      paramh.a(2, d.a(str));
    }
  }

  private void a(h paramh, File[] paramArrayOfFile, String paramString)
  {
    Arrays.sort(paramArrayOfFile, ab.a);
    int i1 = paramArrayOfFile.length;
    int i2 = 0;
    while (true)
      if (i2 < i1)
      {
        File localFile = paramArrayOfFile[i2];
        try
        {
          q localq = com.crashlytics.android.internal.v.a().b();
          Locale localLocale = Locale.US;
          Object[] arrayOfObject = new Object[2];
          arrayOfObject[0] = paramString;
          arrayOfObject[1] = localFile.getName();
          localq.a("Crashlytics", String.format(localLocale, "Found Non Fatal for session ID %s in %s ", arrayOfObject));
          a(paramh, localFile);
          i2++;
        }
        catch (Exception localException)
        {
          while (true)
            com.crashlytics.android.internal.v.a().b().a("Crashlytics", "Error writting non-fatal to session.", localException);
        }
      }
  }

  static void a(aq paramaq, int paramInt, long paramLong, String paramString)
  {
    if (paramaq == null)
      return;
    if (paramString == null);
    for (String str1 = "null"; ; str1 = paramString)
      try
      {
        if (str1.length() > 16384)
          str1 = "..." + str1.substring(-16384 + str1.length());
        String str2 = str1.replaceAll("\r", " ").replaceAll("\n", " ");
        Locale localLocale = Locale.US;
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = Long.valueOf(paramLong);
        arrayOfObject[1] = str2;
        paramaq.a(String.format(localLocale, "%d %s%n", arrayOfObject).getBytes("UTF-8"));
        while ((!paramaq.b()) && (paramaq.a() > 65536))
          paramaq.c();
      }
      catch (IOException localIOException)
      {
        com.crashlytics.android.internal.v.a().b().a("Crashlytics", "There was a problem writing to the Crashlytics log.", localIOException);
        return;
      }
  }

  private void a(String paramString)
  {
    File[] arrayOfFile = a(new S(paramString));
    int i1 = arrayOfFile.length;
    for (int i2 = 0; i2 < i1; i2++)
      arrayOfFile[i2].delete();
  }

  private void a(String paramString, int paramInt)
  {
    b.a(this.k, new R(paramString + "SessionEvent"), paramInt, c);
  }

  // ERROR //
  private void a(Throwable paramThrowable, java.io.OutputStream paramOutputStream)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +24 -> 25
    //   4: new 687	java/io/PrintWriter
    //   7: dup
    //   8: aload_2
    //   9: invokespecial 690	java/io/PrintWriter:<init>	(Ljava/io/OutputStream;)V
    //   12: astore_3
    //   13: aload_1
    //   14: aload_3
    //   15: invokestatic 693	com/crashlytics/android/v:a	(Ljava/lang/Throwable;Ljava/io/Writer;)V
    //   18: aload_3
    //   19: ldc_w 695
    //   22: invokestatic 521	com/crashlytics/android/internal/ab:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   25: return
    //   26: astore 4
    //   28: aconst_null
    //   29: astore_3
    //   30: invokestatic 145	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   33: invokevirtual 190	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   36: ldc 192
    //   38: ldc_w 697
    //   41: aload 4
    //   43: invokeinterface 258 4 0
    //   48: aload_3
    //   49: ldc_w 695
    //   52: invokestatic 521	com/crashlytics/android/internal/ab:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   55: return
    //   56: astore 5
    //   58: aconst_null
    //   59: astore_3
    //   60: aload_3
    //   61: ldc_w 695
    //   64: invokestatic 521	com/crashlytics/android/internal/ab:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   67: aload 5
    //   69: athrow
    //   70: astore 5
    //   72: goto -12 -> 60
    //   75: astore 4
    //   77: goto -47 -> 30
    //
    // Exception table:
    //   from	to	target	type
    //   4	13	26	java/lang/Exception
    //   4	13	56	finally
    //   13	18	70	finally
    //   30	48	70	finally
    //   13	18	75	java/lang/Exception
  }

  private static void a(Throwable paramThrowable, Writer paramWriter)
  {
    int i1 = 1;
    if (paramThrowable != null);
    while (true)
    {
      String str2;
      try
      {
        String str1 = paramThrowable.getLocalizedMessage();
        if (str1 == null)
        {
          str2 = null;
          break label183;
          paramWriter.write(str4 + paramThrowable.getClass().getName() + ": " + str3 + "\n");
          StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
          int i2 = arrayOfStackTraceElement.length;
          int i3 = 0;
          if (i3 < i2)
          {
            StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i3];
            paramWriter.write("\tat " + localStackTraceElement.toString() + "\n");
            i3++;
            continue;
          }
        }
        else
        {
          str2 = str1.replaceAll("(\r\n|\n|\f)", " ");
          break label183;
        }
        Throwable localThrowable = paramThrowable.getCause();
        paramThrowable = localThrowable;
        i1 = 0;
      }
      catch (Exception localException)
      {
        com.crashlytics.android.internal.v.a().b().a("Crashlytics", "Could not write stack trace", localException);
      }
      return;
      label183: if (str2 != null);
      for (String str3 = str2; ; str3 = "")
      {
        if (i1 == 0)
          break label212;
        str4 = "";
        break;
      }
      label212: String str4 = "Caused by: ";
    }
  }

  private void a(Date paramDate, h paramh, Thread paramThread, Throwable paramThrowable, String paramString, boolean paramBoolean)
    throws Exception
  {
    long l1 = paramDate.getTime() / 1000L;
    float f1 = ab.b(Crashlytics.getInstance().getContext());
    int i1 = ab.a(this.v);
    boolean bool1 = ab.c(Crashlytics.getInstance().getContext());
    int i2 = Crashlytics.getInstance().getContext().getResources().getConfiguration().orientation;
    long l2 = ab.c() - ab.a(Crashlytics.getInstance().getContext());
    long l3 = ab.b(Environment.getDataDirectory().getPath());
    this.t = ab.a(Crashlytics.d(), Crashlytics.getInstance().getContext());
    this.x = new LinkedList();
    this.y = paramThrowable.getStackTrace();
    if (paramBoolean)
    {
      Map localMap2 = Thread.getAllStackTraces();
      this.w = new Thread[localMap2.size()];
      Iterator localIterator = localMap2.entrySet().iterator();
      for (int i9 = 0; localIterator.hasNext(); i9++)
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        this.w[i9] = ((Thread)localEntry.getKey());
        this.x.add(localEntry.getValue());
      }
    }
    this.w = new Thread[0];
    d locald = a(this.u);
    if (locald == null)
      com.crashlytics.android.internal.v.a().b().a("Crashlytics", "No log data to include with this event.");
    ab.a(this.u, "There was a problem closing the Crashlytics log file.");
    this.u = null;
    Object localObject;
    if (!ab.a(Crashlytics.getInstance().getContext(), "com.crashlytics.CollectCustomKeys", true))
      localObject = new TreeMap();
    while (true)
    {
      paramh.g(10, 2);
      int i3 = 0 + h.b(1, l1) + h.b(2, d.a(paramString));
      int i4 = a(paramThread, paramThrowable, (Map)localObject);
      int i5 = i3 + (i4 + (h.a(3) + h.c(i4)));
      int i6 = a(f1, i1, bool1, i2, l2, l3);
      int i7 = i5 + (i6 + (h.a(5) + h.c(i6)));
      if (locald != null)
      {
        int i8 = h.b(1, locald);
        i7 += i8 + (h.a(6) + h.c(i8));
      }
      paramh.b(i7);
      paramh.a(1, l1);
      paramh.a(2, d.a(paramString));
      paramh.g(3, 2);
      paramh.b(a(paramThread, paramThrowable, (Map)localObject));
      a(paramh, paramThread, paramThrowable);
      if ((localObject != null) && (!((Map)localObject).isEmpty()))
        a(paramh, (Map)localObject);
      if (this.t != null)
        if (this.t.importance == 100)
          break label682;
      Map localMap1;
      label682: for (boolean bool2 = true; ; bool2 = false)
      {
        paramh.a(3, bool2);
        paramh.a(4, Crashlytics.getInstance().getContext().getResources().getConfiguration().orientation);
        paramh.g(5, 2);
        paramh.b(a(f1, i1, bool1, i2, l2, l3));
        paramh.a(1, f1);
        paramh.c(2, i1);
        paramh.a(3, bool1);
        paramh.a(4, i2);
        paramh.a(5, l2);
        paramh.a(6, l3);
        if (locald != null)
        {
          paramh.g(6, 2);
          paramh.b(h.b(1, locald));
          paramh.a(1, locald);
        }
        return;
        localMap1 = Crashlytics.getInstance().a();
        if ((localMap1 == null) || (localMap1.size() <= 1))
          break label688;
        localObject = new TreeMap(localMap1);
        break;
      }
      label688: localObject = localMap1;
    }
  }

  private File[] a(FilenameFilter paramFilenameFilter)
  {
    File[] arrayOfFile = this.k.listFiles(paramFilenameFilter);
    if (arrayOfFile == null)
      arrayOfFile = new File[0];
    return arrayOfFile;
  }

  private int b(Thread paramThread, Throwable paramThrowable)
  {
    int i1 = a(paramThread, this.y, 4, true);
    int i2 = 0 + (i1 + (h.a(1) + h.c(i1)));
    int i3 = this.w.length;
    int i4 = 0;
    int i5 = i2;
    while (i4 < i3)
    {
      int i11 = a(this.w[i4], (StackTraceElement[])this.x.get(i4), 0, false);
      i5 += i11 + (h.a(1) + h.c(i11));
      i4++;
    }
    int i6 = a(paramThrowable, 1);
    int i7 = i5 + (i6 + (h.a(2) + h.c(i6)));
    int i8 = s();
    int i9 = i7 + (i8 + (h.a(3) + h.c(i8)));
    int i10 = r();
    return i9 + (i10 + (h.a(3) + h.c(i10)));
  }

  private static d b(String paramString)
  {
    if (paramString == null)
      return null;
    return d.a(paramString);
  }

  private <T> Future<T> b(Callable<T> paramCallable)
  {
    try
    {
      Future localFuture = this.s.submit(new I(this, paramCallable));
      return localFuture;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      com.crashlytics.android.internal.v.a().b().a("Crashlytics", "Executor is shut down because we're handling a fatal crash.");
    }
    return null;
  }

  // ERROR //
  private void c(String paramString)
    throws Exception
  {
    // Byte code:
    //   0: invokestatic 145	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   3: invokevirtual 148	com/crashlytics/android/internal/v:h	()Ljava/io/File;
    //   6: astore 8
    //   8: new 347	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   15: aload_1
    //   16: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: ldc_w 536
    //   22: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 363	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: astore 9
    //   30: new 482	com/crashlytics/android/f
    //   33: dup
    //   34: aload 8
    //   36: aload 9
    //   38: invokespecial 644	com/crashlytics/android/f:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   41: astore 7
    //   43: aload 7
    //   45: invokestatic 647	com/crashlytics/android/h:a	(Ljava/io/OutputStream;)Lcom/crashlytics/android/h;
    //   48: astore 10
    //   50: aload 10
    //   52: astore 6
    //   54: new 844	android/os/StatFs
    //   57: dup
    //   58: invokestatic 741	android/os/Environment:getDataDirectory	()Ljava/io/File;
    //   61: invokevirtual 744	java/io/File:getPath	()Ljava/lang/String;
    //   64: invokespecial 845	android/os/StatFs:<init>	(Ljava/lang/String;)V
    //   67: astore 11
    //   69: invokestatic 847	com/crashlytics/android/internal/ab:b	()I
    //   72: istore 12
    //   74: getstatic 852	android/os/Build:MODEL	Ljava/lang/String;
    //   77: invokestatic 854	com/crashlytics/android/v:b	(Ljava/lang/String;)Lcom/crashlytics/android/d;
    //   80: astore 13
    //   82: getstatic 857	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   85: invokestatic 854	com/crashlytics/android/v:b	(Ljava/lang/String;)Lcom/crashlytics/android/d;
    //   88: astore 14
    //   90: getstatic 860	android/os/Build:PRODUCT	Ljava/lang/String;
    //   93: invokestatic 854	com/crashlytics/android/v:b	(Ljava/lang/String;)Lcom/crashlytics/android/d;
    //   96: astore 15
    //   98: invokestatic 866	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   101: invokevirtual 869	java/lang/Runtime:availableProcessors	()I
    //   104: istore 16
    //   106: invokestatic 733	com/crashlytics/android/internal/ab:c	()J
    //   109: lstore 17
    //   111: aload 11
    //   113: invokevirtual 872	android/os/StatFs:getBlockCount	()I
    //   116: i2l
    //   117: aload 11
    //   119: invokevirtual 875	android/os/StatFs:getBlockSize	()I
    //   122: i2l
    //   123: lmul
    //   124: lstore 19
    //   126: invokestatic 877	com/crashlytics/android/internal/ab:d	()Z
    //   129: istore 21
    //   131: invokestatic 171	com/crashlytics/android/Crashlytics:getInstance	()Lcom/crashlytics/android/Crashlytics;
    //   134: invokevirtual 880	com/crashlytics/android/Crashlytics:b	()Lcom/crashlytics/android/internal/ao;
    //   137: astore 22
    //   139: aload 22
    //   141: invokevirtual 884	com/crashlytics/android/internal/ao:e	()Ljava/lang/String;
    //   144: invokestatic 104	com/crashlytics/android/d:a	(Ljava/lang/String;)Lcom/crashlytics/android/d;
    //   147: astore 23
    //   149: aload 22
    //   151: invokevirtual 886	com/crashlytics/android/internal/ao:f	()Ljava/util/Map;
    //   154: astore 24
    //   156: invokestatic 888	com/crashlytics/android/internal/ab:f	()I
    //   159: istore 25
    //   161: aload 6
    //   163: bipush 9
    //   165: iconst_2
    //   166: invokevirtual 490	com/crashlytics/android/h:g	(II)V
    //   169: aload_0
    //   170: iload 12
    //   172: aload 23
    //   174: aload 13
    //   176: iload 16
    //   178: lload 17
    //   180: lload 19
    //   182: iload 21
    //   184: aload 24
    //   186: iload 25
    //   188: aload 14
    //   190: aload 15
    //   192: invokespecial 890	com/crashlytics/android/v:a	(ILcom/crashlytics/android/d;Lcom/crashlytics/android/d;IJJZLjava/util/Map;ILcom/crashlytics/android/d;Lcom/crashlytics/android/d;)I
    //   195: istore 26
    //   197: aload 6
    //   199: iload 26
    //   201: invokevirtual 492	com/crashlytics/android/h:b	(I)V
    //   204: aload 6
    //   206: iconst_1
    //   207: aload 23
    //   209: invokevirtual 498	com/crashlytics/android/h:a	(ILcom/crashlytics/android/d;)V
    //   212: aload 6
    //   214: iconst_3
    //   215: iload 12
    //   217: invokevirtual 892	com/crashlytics/android/h:b	(II)V
    //   220: aload 6
    //   222: iconst_4
    //   223: aload 13
    //   225: invokevirtual 498	com/crashlytics/android/h:a	(ILcom/crashlytics/android/d;)V
    //   228: aload 6
    //   230: iconst_5
    //   231: iload 16
    //   233: invokevirtual 500	com/crashlytics/android/h:a	(II)V
    //   236: aload 6
    //   238: bipush 6
    //   240: lload 17
    //   242: invokevirtual 495	com/crashlytics/android/h:a	(IJ)V
    //   245: aload 6
    //   247: bipush 7
    //   249: lload 19
    //   251: invokevirtual 495	com/crashlytics/android/h:a	(IJ)V
    //   254: aload 6
    //   256: bipush 10
    //   258: iload 21
    //   260: invokevirtual 794	com/crashlytics/android/h:a	(IZ)V
    //   263: aload 24
    //   265: invokeinterface 295 1 0
    //   270: invokeinterface 301 1 0
    //   275: astore 27
    //   277: aload 27
    //   279: invokeinterface 306 1 0
    //   284: ifeq +149 -> 433
    //   287: aload 27
    //   289: invokeinterface 310 1 0
    //   294: checkcast 312	java/util/Map$Entry
    //   297: astore 28
    //   299: aload 6
    //   301: bipush 11
    //   303: iconst_2
    //   304: invokevirtual 490	com/crashlytics/android/h:g	(II)V
    //   307: aload 28
    //   309: invokeinterface 315 1 0
    //   314: checkcast 317	com/crashlytics/android/internal/ap
    //   317: aload 28
    //   319: invokeinterface 320 1 0
    //   324: checkcast 179	java/lang/String
    //   327: invokestatic 323	com/crashlytics/android/v:a	(Lcom/crashlytics/android/internal/ap;Ljava/lang/String;)I
    //   330: istore 29
    //   332: aload 6
    //   334: iload 29
    //   336: invokevirtual 492	com/crashlytics/android/h:b	(I)V
    //   339: aload 28
    //   341: invokeinterface 315 1 0
    //   346: checkcast 317	com/crashlytics/android/internal/ap
    //   349: getfield 330	com/crashlytics/android/internal/ap:f	I
    //   352: istore 30
    //   354: aload 6
    //   356: iconst_1
    //   357: iload 30
    //   359: invokevirtual 892	com/crashlytics/android/h:b	(II)V
    //   362: aload 28
    //   364: invokeinterface 320 1 0
    //   369: checkcast 179	java/lang/String
    //   372: invokestatic 104	com/crashlytics/android/d:a	(Ljava/lang/String;)Lcom/crashlytics/android/d;
    //   375: astore 31
    //   377: aload 6
    //   379: iconst_2
    //   380: aload 31
    //   382: invokevirtual 498	com/crashlytics/android/h:a	(ILcom/crashlytics/android/d;)V
    //   385: goto -108 -> 277
    //   388: astore_2
    //   389: aload 6
    //   391: astore_3
    //   392: aload 7
    //   394: astore 4
    //   396: aload_0
    //   397: aload_2
    //   398: aload 4
    //   400: invokespecial 679	com/crashlytics/android/v:a	(Ljava/lang/Throwable;Ljava/io/OutputStream;)V
    //   403: aload_2
    //   404: athrow
    //   405: astore 5
    //   407: aload_3
    //   408: astore 6
    //   410: aload 4
    //   412: astore 7
    //   414: aload 6
    //   416: ldc_w 894
    //   419: invokestatic 657	com/crashlytics/android/internal/ab:a	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   422: aload 7
    //   424: ldc_w 896
    //   427: invokestatic 521	com/crashlytics/android/internal/ab:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   430: aload 5
    //   432: athrow
    //   433: aload 6
    //   435: bipush 12
    //   437: iload 25
    //   439: invokevirtual 500	com/crashlytics/android/h:a	(II)V
    //   442: aload 14
    //   444: ifnull +12 -> 456
    //   447: aload 6
    //   449: bipush 13
    //   451: aload 14
    //   453: invokevirtual 498	com/crashlytics/android/h:a	(ILcom/crashlytics/android/d;)V
    //   456: aload 15
    //   458: ifnull +12 -> 470
    //   461: aload 6
    //   463: bipush 14
    //   465: aload 15
    //   467: invokevirtual 498	com/crashlytics/android/h:a	(ILcom/crashlytics/android/d;)V
    //   470: aload 6
    //   472: ldc_w 894
    //   475: invokestatic 657	com/crashlytics/android/internal/ab:a	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   478: aload 7
    //   480: ldc_w 896
    //   483: invokestatic 521	com/crashlytics/android/internal/ab:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   486: return
    //   487: astore 5
    //   489: aconst_null
    //   490: astore 6
    //   492: aconst_null
    //   493: astore 7
    //   495: goto -81 -> 414
    //   498: astore 5
    //   500: aconst_null
    //   501: astore 6
    //   503: goto -89 -> 414
    //   506: astore 5
    //   508: goto -94 -> 414
    //   511: astore_2
    //   512: aconst_null
    //   513: astore_3
    //   514: aconst_null
    //   515: astore 4
    //   517: goto -121 -> 396
    //   520: astore_2
    //   521: aload 7
    //   523: astore 4
    //   525: aconst_null
    //   526: astore_3
    //   527: goto -131 -> 396
    //
    // Exception table:
    //   from	to	target	type
    //   54	277	388	java/lang/Exception
    //   277	385	388	java/lang/Exception
    //   433	442	388	java/lang/Exception
    //   447	456	388	java/lang/Exception
    //   461	470	388	java/lang/Exception
    //   396	405	405	finally
    //   0	43	487	finally
    //   43	50	498	finally
    //   54	277	506	finally
    //   277	385	506	finally
    //   433	442	506	finally
    //   447	456	506	finally
    //   461	470	506	finally
    //   0	43	511	java/lang/Exception
    //   43	50	520	java/lang/Exception
  }

  // ERROR //
  private boolean k()
  {
    // Byte code:
    //   0: invokestatic 171	com/crashlytics/android/Crashlytics:getInstance	()Lcom/crashlytics/android/Crashlytics;
    //   3: invokevirtual 244	com/crashlytics/android/Crashlytics:getContext	()Landroid/content/Context;
    //   6: ldc_w 904
    //   9: iconst_1
    //   10: invokestatic 777	com/crashlytics/android/internal/ab:a	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   13: ifne +21 -> 34
    //   16: invokestatic 145	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   19: invokevirtual 190	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   22: ldc 192
    //   24: ldc_w 906
    //   27: invokeinterface 199 3 0
    //   32: iconst_0
    //   33: ireturn
    //   34: aload_0
    //   35: getfield 766	com/crashlytics/android/v:u	Lcom/crashlytics/android/internal/aq;
    //   38: new 347	java/lang/StringBuilder
    //   41: dup
    //   42: ldc_w 908
    //   45: invokespecial 527	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   48: aload_0
    //   49: getfield 766	com/crashlytics/android/v:u	Lcom/crashlytics/android/internal/aq;
    //   52: invokevirtual 821	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 363	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 521	com/crashlytics/android/internal/ab:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   61: new 347	java/lang/StringBuilder
    //   64: dup
    //   65: ldc_w 910
    //   68: invokespecial 527	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   71: invokestatic 916	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   74: invokevirtual 917	java/util/UUID:toString	()Ljava/lang/String;
    //   77: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: ldc_w 919
    //   83: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 363	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: astore_3
    //   90: new 152	java/io/File
    //   93: dup
    //   94: invokestatic 145	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   97: invokevirtual 148	com/crashlytics/android/internal/v:h	()Ljava/io/File;
    //   100: aload_3
    //   101: invokespecial 157	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   104: astore_2
    //   105: aload_0
    //   106: new 431	com/crashlytics/android/internal/aq
    //   109: dup
    //   110: aload_2
    //   111: invokespecial 920	com/crashlytics/android/internal/aq:<init>	(Ljava/io/File;)V
    //   114: putfield 766	com/crashlytics/android/v:u	Lcom/crashlytics/android/internal/aq;
    //   117: aload_2
    //   118: invokevirtual 208	java/io/File:delete	()Z
    //   121: pop
    //   122: iconst_1
    //   123: ireturn
    //   124: astore_1
    //   125: aconst_null
    //   126: astore_2
    //   127: invokestatic 145	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   130: invokevirtual 190	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   133: ldc 192
    //   135: new 347	java/lang/StringBuilder
    //   138: dup
    //   139: ldc_w 922
    //   142: invokespecial 527	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   145: aload_2
    //   146: invokevirtual 821	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 363	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: aload_1
    //   153: invokeinterface 258 4 0
    //   158: iconst_0
    //   159: ireturn
    //   160: astore_1
    //   161: goto -34 -> 127
    //
    // Exception table:
    //   from	to	target	type
    //   61	105	124	java/lang/Exception
    //   105	122	160	java/lang/Exception
  }

  // ERROR //
  private void l()
    throws Exception
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 715	java/util/Date
    //   5: dup
    //   6: invokespecial 923	java/util/Date:<init>	()V
    //   9: astore_2
    //   10: new 925	com/crashlytics/android/e
    //   13: dup
    //   14: invokestatic 171	com/crashlytics/android/Crashlytics:getInstance	()Lcom/crashlytics/android/Crashlytics;
    //   17: invokevirtual 880	com/crashlytics/android/Crashlytics:b	()Lcom/crashlytics/android/internal/ao;
    //   20: invokespecial 928	com/crashlytics/android/e:<init>	(Lcom/crashlytics/android/internal/ao;)V
    //   23: invokevirtual 929	com/crashlytics/android/e:toString	()Ljava/lang/String;
    //   26: astore_3
    //   27: invokestatic 145	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   30: invokevirtual 190	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   33: ldc 192
    //   35: new 347	java/lang/StringBuilder
    //   38: dup
    //   39: ldc_w 931
    //   42: invokespecial 527	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   45: aload_3
    //   46: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 363	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokeinterface 199 3 0
    //   57: new 482	com/crashlytics/android/f
    //   60: dup
    //   61: invokestatic 145	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   64: invokevirtual 148	com/crashlytics/android/internal/v:h	()Ljava/io/File;
    //   67: new 347	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   74: aload_3
    //   75: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: ldc_w 933
    //   81: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 363	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokespecial 644	com/crashlytics/android/f:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   90: astore 4
    //   92: aload 4
    //   94: invokestatic 647	com/crashlytics/android/h:a	(Ljava/io/OutputStream;)Lcom/crashlytics/android/h;
    //   97: astore 9
    //   99: aload 9
    //   101: astore 6
    //   103: aload 6
    //   105: iconst_1
    //   106: aload_0
    //   107: getfield 185	com/crashlytics/android/v:n	Ljava/lang/String;
    //   110: invokestatic 104	com/crashlytics/android/d:a	(Ljava/lang/String;)Lcom/crashlytics/android/d;
    //   113: invokevirtual 498	com/crashlytics/android/h:a	(ILcom/crashlytics/android/d;)V
    //   116: aload 6
    //   118: iconst_2
    //   119: aload_3
    //   120: invokestatic 104	com/crashlytics/android/d:a	(Ljava/lang/String;)Lcom/crashlytics/android/d;
    //   123: invokevirtual 498	com/crashlytics/android/h:a	(ILcom/crashlytics/android/d;)V
    //   126: aload 6
    //   128: iconst_3
    //   129: aload_2
    //   130: invokevirtual 718	java/util/Date:getTime	()J
    //   133: ldc2_w 719
    //   136: ldiv
    //   137: invokevirtual 495	com/crashlytics/android/h:a	(IJ)V
    //   140: aload 6
    //   142: ldc_w 654
    //   145: invokestatic 657	com/crashlytics/android/internal/ab:a	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   148: aload 4
    //   150: ldc_w 935
    //   153: invokestatic 521	com/crashlytics/android/internal/ab:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   156: new 482	com/crashlytics/android/f
    //   159: dup
    //   160: invokestatic 145	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   163: invokevirtual 148	com/crashlytics/android/internal/v:h	()Ljava/io/File;
    //   166: new 347	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   173: aload_3
    //   174: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: ldc_w 532
    //   180: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 363	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokespecial 644	com/crashlytics/android/f:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   189: astore 10
    //   191: aload 10
    //   193: invokestatic 647	com/crashlytics/android/h:a	(Ljava/io/OutputStream;)Lcom/crashlytics/android/h;
    //   196: astore 15
    //   198: aload 15
    //   200: astore 14
    //   202: invokestatic 215	com/crashlytics/android/Crashlytics:d	()Ljava/lang/String;
    //   205: invokestatic 104	com/crashlytics/android/d:a	(Ljava/lang/String;)Lcom/crashlytics/android/d;
    //   208: astore 16
    //   210: invokestatic 937	com/crashlytics/android/Crashlytics:g	()Ljava/lang/String;
    //   213: invokestatic 104	com/crashlytics/android/d:a	(Ljava/lang/String;)Lcom/crashlytics/android/d;
    //   216: astore 17
    //   218: invokestatic 939	com/crashlytics/android/Crashlytics:f	()Ljava/lang/String;
    //   221: invokestatic 104	com/crashlytics/android/d:a	(Ljava/lang/String;)Lcom/crashlytics/android/d;
    //   224: astore 18
    //   226: invokestatic 941	com/crashlytics/android/Crashlytics:h	()Ljava/lang/String;
    //   229: invokestatic 104	com/crashlytics/android/d:a	(Ljava/lang/String;)Lcom/crashlytics/android/d;
    //   232: pop
    //   233: invokestatic 171	com/crashlytics/android/Crashlytics:getInstance	()Lcom/crashlytics/android/Crashlytics;
    //   236: invokevirtual 244	com/crashlytics/android/Crashlytics:getContext	()Landroid/content/Context;
    //   239: invokevirtual 944	android/content/Context:getPackageCodePath	()Ljava/lang/String;
    //   242: invokestatic 104	com/crashlytics/android/d:a	(Ljava/lang/String;)Lcom/crashlytics/android/d;
    //   245: pop
    //   246: invokestatic 171	com/crashlytics/android/Crashlytics:getInstance	()Lcom/crashlytics/android/Crashlytics;
    //   249: invokevirtual 880	com/crashlytics/android/Crashlytics:b	()Lcom/crashlytics/android/internal/ao;
    //   252: invokevirtual 946	com/crashlytics/android/internal/ao:b	()Ljava/lang/String;
    //   255: invokestatic 104	com/crashlytics/android/d:a	(Ljava/lang/String;)Lcom/crashlytics/android/d;
    //   258: astore 21
    //   260: invokestatic 947	com/crashlytics/android/Crashlytics:e	()Ljava/lang/String;
    //   263: invokestatic 952	com/crashlytics/android/internal/ai:a	(Ljava/lang/String;)Lcom/crashlytics/android/internal/ai;
    //   266: invokevirtual 953	com/crashlytics/android/internal/ai:a	()I
    //   269: istore 22
    //   271: aload 14
    //   273: bipush 7
    //   275: iconst_2
    //   276: invokevirtual 490	com/crashlytics/android/h:g	(II)V
    //   279: iconst_0
    //   280: iconst_1
    //   281: aload 16
    //   283: invokestatic 287	com/crashlytics/android/h:b	(ILcom/crashlytics/android/d;)I
    //   286: iadd
    //   287: iconst_2
    //   288: aload 17
    //   290: invokestatic 287	com/crashlytics/android/h:b	(ILcom/crashlytics/android/d;)I
    //   293: iadd
    //   294: iconst_3
    //   295: aload 18
    //   297: invokestatic 287	com/crashlytics/android/h:b	(ILcom/crashlytics/android/d;)I
    //   300: iadd
    //   301: istore 23
    //   303: invokestatic 955	com/crashlytics/android/v:q	()I
    //   306: istore 24
    //   308: aload 14
    //   310: iload 23
    //   312: iload 24
    //   314: iconst_5
    //   315: invokestatic 326	com/crashlytics/android/h:a	(I)I
    //   318: iload 24
    //   320: invokestatic 328	com/crashlytics/android/h:c	(I)I
    //   323: iadd
    //   324: iadd
    //   325: iadd
    //   326: bipush 6
    //   328: aload 21
    //   330: invokestatic 287	com/crashlytics/android/h:b	(ILcom/crashlytics/android/d;)I
    //   333: iadd
    //   334: bipush 10
    //   336: iload 22
    //   338: invokestatic 289	com/crashlytics/android/h:e	(II)I
    //   341: iadd
    //   342: invokevirtual 492	com/crashlytics/android/h:b	(I)V
    //   345: aload 14
    //   347: iconst_1
    //   348: aload 16
    //   350: invokevirtual 498	com/crashlytics/android/h:a	(ILcom/crashlytics/android/d;)V
    //   353: aload 14
    //   355: iconst_2
    //   356: aload 17
    //   358: invokevirtual 498	com/crashlytics/android/h:a	(ILcom/crashlytics/android/d;)V
    //   361: aload 14
    //   363: iconst_3
    //   364: aload 18
    //   366: invokevirtual 498	com/crashlytics/android/h:a	(ILcom/crashlytics/android/d;)V
    //   369: aload 14
    //   371: iconst_5
    //   372: iconst_2
    //   373: invokevirtual 490	com/crashlytics/android/h:g	(II)V
    //   376: aload 14
    //   378: invokestatic 955	com/crashlytics/android/v:q	()I
    //   381: invokevirtual 492	com/crashlytics/android/h:b	(I)V
    //   384: aload 14
    //   386: iconst_1
    //   387: invokestatic 171	com/crashlytics/android/Crashlytics:getInstance	()Lcom/crashlytics/android/Crashlytics;
    //   390: invokevirtual 244	com/crashlytics/android/Crashlytics:getContext	()Landroid/content/Context;
    //   393: iconst_0
    //   394: invokestatic 960	com/crashlytics/android/internal/r:a	(Landroid/content/Context;Z)Ljava/lang/String;
    //   397: invokevirtual 963	com/crashlytics/android/h:a	(ILjava/lang/String;)V
    //   400: aload 14
    //   402: bipush 6
    //   404: aload 21
    //   406: invokevirtual 498	com/crashlytics/android/h:a	(ILcom/crashlytics/android/d;)V
    //   409: aload 14
    //   411: bipush 10
    //   413: iload 22
    //   415: invokevirtual 892	com/crashlytics/android/h:b	(II)V
    //   418: aload 14
    //   420: ldc_w 965
    //   423: invokestatic 657	com/crashlytics/android/internal/ab:a	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   426: aload 10
    //   428: ldc_w 967
    //   431: invokestatic 521	com/crashlytics/android/internal/ab:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   434: new 482	com/crashlytics/android/f
    //   437: dup
    //   438: invokestatic 145	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   441: invokevirtual 148	com/crashlytics/android/internal/v:h	()Ljava/io/File;
    //   444: new 347	java/lang/StringBuilder
    //   447: dup
    //   448: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   451: aload_3
    //   452: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: ldc_w 534
    //   458: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: invokevirtual 363	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   464: invokespecial 644	com/crashlytics/android/f:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   467: astore 25
    //   469: aload 25
    //   471: invokestatic 647	com/crashlytics/android/h:a	(Ljava/io/OutputStream;)Lcom/crashlytics/android/h;
    //   474: astore_1
    //   475: getstatic 972	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   478: invokestatic 104	com/crashlytics/android/d:a	(Ljava/lang/String;)Lcom/crashlytics/android/d;
    //   481: astore 28
    //   483: getstatic 975	android/os/Build$VERSION:CODENAME	Ljava/lang/String;
    //   486: invokestatic 104	com/crashlytics/android/d:a	(Ljava/lang/String;)Lcom/crashlytics/android/d;
    //   489: astore 29
    //   491: invokestatic 977	com/crashlytics/android/internal/ab:e	()Z
    //   494: istore 30
    //   496: aload_1
    //   497: bipush 8
    //   499: iconst_2
    //   500: invokevirtual 490	com/crashlytics/android/h:g	(II)V
    //   503: aload_1
    //   504: iconst_0
    //   505: iconst_1
    //   506: iconst_3
    //   507: invokestatic 289	com/crashlytics/android/h:e	(II)I
    //   510: iadd
    //   511: iconst_2
    //   512: aload 28
    //   514: invokestatic 287	com/crashlytics/android/h:b	(ILcom/crashlytics/android/d;)I
    //   517: iadd
    //   518: iconst_3
    //   519: aload 29
    //   521: invokestatic 287	com/crashlytics/android/h:b	(ILcom/crashlytics/android/d;)I
    //   524: iadd
    //   525: iconst_4
    //   526: iload 30
    //   528: invokestatic 278	com/crashlytics/android/h:b	(IZ)I
    //   531: iadd
    //   532: invokevirtual 492	com/crashlytics/android/h:b	(I)V
    //   535: aload_1
    //   536: iconst_1
    //   537: iconst_3
    //   538: invokevirtual 892	com/crashlytics/android/h:b	(II)V
    //   541: aload_1
    //   542: iconst_2
    //   543: aload 28
    //   545: invokevirtual 498	com/crashlytics/android/h:a	(ILcom/crashlytics/android/d;)V
    //   548: aload_1
    //   549: iconst_3
    //   550: aload 29
    //   552: invokevirtual 498	com/crashlytics/android/h:a	(ILcom/crashlytics/android/d;)V
    //   555: aload_1
    //   556: iconst_4
    //   557: iload 30
    //   559: invokevirtual 794	com/crashlytics/android/h:a	(IZ)V
    //   562: aload_1
    //   563: ldc_w 979
    //   566: invokestatic 657	com/crashlytics/android/internal/ab:a	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   569: aload 25
    //   571: ldc_w 981
    //   574: invokestatic 521	com/crashlytics/android/internal/ab:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   577: aload_0
    //   578: aload_3
    //   579: invokespecial 983	com/crashlytics/android/v:c	(Ljava/lang/String;)V
    //   582: return
    //   583: astore 5
    //   585: aconst_null
    //   586: astore 6
    //   588: aload_0
    //   589: aload 5
    //   591: aload_1
    //   592: invokespecial 679	com/crashlytics/android/v:a	(Ljava/lang/Throwable;Ljava/io/OutputStream;)V
    //   595: aload 5
    //   597: athrow
    //   598: astore 7
    //   600: aload_1
    //   601: astore 4
    //   603: aload 6
    //   605: astore 8
    //   607: aload 8
    //   609: ldc_w 654
    //   612: invokestatic 657	com/crashlytics/android/internal/ab:a	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   615: aload 4
    //   617: ldc_w 935
    //   620: invokestatic 521	com/crashlytics/android/internal/ab:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   623: aload 7
    //   625: athrow
    //   626: astore 11
    //   628: aconst_null
    //   629: astore 12
    //   631: aload_0
    //   632: aload 11
    //   634: aload 12
    //   636: invokespecial 679	com/crashlytics/android/v:a	(Ljava/lang/Throwable;Ljava/io/OutputStream;)V
    //   639: aload 11
    //   641: athrow
    //   642: astore 13
    //   644: aload 12
    //   646: astore 10
    //   648: aload_1
    //   649: astore 14
    //   651: aload 14
    //   653: ldc_w 965
    //   656: invokestatic 657	com/crashlytics/android/internal/ab:a	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   659: aload 10
    //   661: ldc_w 967
    //   664: invokestatic 521	com/crashlytics/android/internal/ab:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   667: aload 13
    //   669: athrow
    //   670: astore 26
    //   672: aconst_null
    //   673: astore 25
    //   675: aload_0
    //   676: aload 26
    //   678: aload 25
    //   680: invokespecial 679	com/crashlytics/android/v:a	(Ljava/lang/Throwable;Ljava/io/OutputStream;)V
    //   683: aload 26
    //   685: athrow
    //   686: astore 27
    //   688: aload_1
    //   689: ldc_w 979
    //   692: invokestatic 657	com/crashlytics/android/internal/ab:a	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   695: aload 25
    //   697: ldc_w 981
    //   700: invokestatic 521	com/crashlytics/android/internal/ab:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   703: aload 27
    //   705: athrow
    //   706: astore 27
    //   708: aconst_null
    //   709: astore 25
    //   711: aconst_null
    //   712: astore_1
    //   713: goto -25 -> 688
    //   716: astore 26
    //   718: goto -43 -> 675
    //   721: astore 13
    //   723: aconst_null
    //   724: astore 14
    //   726: aconst_null
    //   727: astore 10
    //   729: goto -78 -> 651
    //   732: astore 13
    //   734: aconst_null
    //   735: astore 14
    //   737: goto -86 -> 651
    //   740: astore 13
    //   742: goto -91 -> 651
    //   745: astore 11
    //   747: aload 10
    //   749: astore 12
    //   751: aconst_null
    //   752: astore_1
    //   753: goto -122 -> 631
    //   756: astore 11
    //   758: aload 14
    //   760: astore_1
    //   761: aload 10
    //   763: astore 12
    //   765: goto -134 -> 631
    //   768: astore 7
    //   770: aconst_null
    //   771: astore 8
    //   773: aconst_null
    //   774: astore 4
    //   776: goto -169 -> 607
    //   779: astore 7
    //   781: aconst_null
    //   782: astore 8
    //   784: goto -177 -> 607
    //   787: astore 7
    //   789: aload 6
    //   791: astore 8
    //   793: goto -186 -> 607
    //   796: astore 5
    //   798: aload 4
    //   800: astore_1
    //   801: aconst_null
    //   802: astore 6
    //   804: goto -216 -> 588
    //   807: astore 5
    //   809: aload 4
    //   811: astore_1
    //   812: goto -224 -> 588
    //
    // Exception table:
    //   from	to	target	type
    //   57	92	583	java/lang/Exception
    //   588	598	598	finally
    //   156	191	626	java/lang/Exception
    //   631	642	642	finally
    //   434	469	670	java/lang/Exception
    //   469	562	686	finally
    //   675	686	686	finally
    //   434	469	706	finally
    //   469	562	716	java/lang/Exception
    //   156	191	721	finally
    //   191	198	732	finally
    //   202	418	740	finally
    //   191	198	745	java/lang/Exception
    //   202	418	756	java/lang/Exception
    //   57	92	768	finally
    //   92	99	779	finally
    //   103	140	787	finally
    //   92	99	796	java/lang/Exception
    //   103	140	807	java/lang/Exception
  }

  // ERROR //
  private void m()
    throws Exception
  {
    // Byte code:
    //   0: new 985	java/util/HashSet
    //   3: dup
    //   4: invokespecial 986	java/util/HashSet:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: invokespecial 989	com/crashlytics/android/v:o	()[Ljava/io/File;
    //   12: astore_2
    //   13: aload_2
    //   14: getstatic 67	com/crashlytics/android/v:b	Ljava/util/Comparator;
    //   17: invokestatic 587	java/util/Arrays:sort	([Ljava/lang/Object;Ljava/util/Comparator;)V
    //   20: bipush 8
    //   22: aload_2
    //   23: arraylength
    //   24: invokestatic 992	java/lang/Math:min	(II)I
    //   27: istore_3
    //   28: iconst_0
    //   29: istore 4
    //   31: iload 4
    //   33: iload_3
    //   34: if_icmpge +23 -> 57
    //   37: aload_1
    //   38: aload_2
    //   39: iload 4
    //   41: aaload
    //   42: invokestatic 994	com/crashlytics/android/v:a	(Ljava/io/File;)Ljava/lang/String;
    //   45: invokeinterface 995 2 0
    //   50: pop
    //   51: iinc 4 1
    //   54: goto -23 -> 31
    //   57: aload_0
    //   58: new 997	com/crashlytics/android/Q
    //   61: dup
    //   62: iconst_0
    //   63: invokespecial 1000	com/crashlytics/android/Q:<init>	(B)V
    //   66: invokespecial 542	com/crashlytics/android/v:a	(Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   69: astore 5
    //   71: aload 5
    //   73: arraylength
    //   74: istore 6
    //   76: iconst_0
    //   77: istore 7
    //   79: iload 7
    //   81: iload 6
    //   83: if_icmpge +91 -> 174
    //   86: aload 5
    //   88: iload 7
    //   90: aaload
    //   91: astore 49
    //   93: aload 49
    //   95: invokevirtual 466	java/io/File:getName	()Ljava/lang/String;
    //   98: astore 50
    //   100: getstatic 85	com/crashlytics/android/v:d	Ljava/util/regex/Pattern;
    //   103: aload 50
    //   105: invokevirtual 1004	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   108: astore 51
    //   110: aload 51
    //   112: invokevirtual 1009	java/util/regex/Matcher:matches	()Z
    //   115: pop
    //   116: aload_1
    //   117: aload 51
    //   119: iconst_1
    //   120: invokevirtual 1012	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   123: invokeinterface 1015 2 0
    //   128: ifne +40 -> 168
    //   131: invokestatic 145	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   134: invokevirtual 190	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   137: ldc 192
    //   139: new 347	java/lang/StringBuilder
    //   142: dup
    //   143: ldc_w 1017
    //   146: invokespecial 527	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   149: aload 50
    //   151: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 363	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokeinterface 199 3 0
    //   162: aload 49
    //   164: invokevirtual 208	java/io/File:delete	()Z
    //   167: pop
    //   168: iinc 7 1
    //   171: goto -92 -> 79
    //   174: aload_0
    //   175: invokespecial 639	com/crashlytics/android/v:n	()Ljava/lang/String;
    //   178: astore 8
    //   180: aload 8
    //   182: ifnull +1113 -> 1295
    //   185: aconst_null
    //   186: astore 9
    //   188: new 482	com/crashlytics/android/f
    //   191: dup
    //   192: aload_0
    //   193: getfield 150	com/crashlytics/android/v:k	Ljava/io/File;
    //   196: new 347	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   203: aload 8
    //   205: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: ldc_w 530
    //   211: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 363	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokespecial 644	com/crashlytics/android/f:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   220: astore 10
    //   222: aload 10
    //   224: invokestatic 647	com/crashlytics/android/h:a	(Ljava/io/OutputStream;)Lcom/crashlytics/android/h;
    //   227: astore 9
    //   229: invokestatic 171	com/crashlytics/android/Crashlytics:getInstance	()Lcom/crashlytics/android/Crashlytics;
    //   232: invokevirtual 1019	com/crashlytics/android/Crashlytics:m	()Ljava/lang/String;
    //   235: astore 13
    //   237: invokestatic 171	com/crashlytics/android/Crashlytics:getInstance	()Lcom/crashlytics/android/Crashlytics;
    //   240: invokevirtual 1021	com/crashlytics/android/Crashlytics:o	()Ljava/lang/String;
    //   243: astore 14
    //   245: invokestatic 171	com/crashlytics/android/Crashlytics:getInstance	()Lcom/crashlytics/android/Crashlytics;
    //   248: invokevirtual 1022	com/crashlytics/android/Crashlytics:n	()Ljava/lang/String;
    //   251: astore 15
    //   253: aload 13
    //   255: ifnonnull +689 -> 944
    //   258: aload 14
    //   260: ifnonnull +684 -> 944
    //   263: aload 15
    //   265: ifnonnull +679 -> 944
    //   268: aload 9
    //   270: ldc_w 1024
    //   273: invokestatic 657	com/crashlytics/android/internal/ab:a	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   276: aload 10
    //   278: ldc_w 1026
    //   281: invokestatic 521	com/crashlytics/android/internal/ab:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   284: invokestatic 171	com/crashlytics/android/Crashlytics:getInstance	()Lcom/crashlytics/android/Crashlytics;
    //   287: invokevirtual 1029	com/crashlytics/android/Crashlytics:r	()Lcom/crashlytics/android/internal/aR;
    //   290: astore 20
    //   292: aload 20
    //   294: ifnull +984 -> 1278
    //   297: aload 20
    //   299: getfield 1033	com/crashlytics/android/internal/aR:a	I
    //   302: istore 21
    //   304: invokestatic 145	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   307: invokevirtual 190	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   310: ldc 192
    //   312: ldc_w 1035
    //   315: invokeinterface 199 3 0
    //   320: aload_0
    //   321: invokespecial 989	com/crashlytics/android/v:o	()[Ljava/io/File;
    //   324: astore 22
    //   326: aload 22
    //   328: ifnull +966 -> 1294
    //   331: aload 22
    //   333: arraylength
    //   334: ifle +960 -> 1294
    //   337: aload 22
    //   339: arraylength
    //   340: istore 23
    //   342: iconst_0
    //   343: istore 24
    //   345: iload 24
    //   347: iload 23
    //   349: if_icmpge +945 -> 1294
    //   352: aload 22
    //   354: iload 24
    //   356: aaload
    //   357: astore 25
    //   359: aload 25
    //   361: invokestatic 994	com/crashlytics/android/v:a	(Ljava/io/File;)Ljava/lang/String;
    //   364: astore 26
    //   366: invokestatic 145	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   369: invokevirtual 190	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   372: ldc 192
    //   374: new 347	java/lang/StringBuilder
    //   377: dup
    //   378: ldc_w 1037
    //   381: invokespecial 527	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   384: aload 26
    //   386: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: invokevirtual 363	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: invokeinterface 199 3 0
    //   397: invokestatic 145	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   400: invokevirtual 190	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   403: ldc 192
    //   405: new 347	java/lang/StringBuilder
    //   408: dup
    //   409: ldc_w 1039
    //   412: invokespecial 527	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   415: aload 26
    //   417: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: invokevirtual 363	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   423: invokeinterface 199 3 0
    //   428: aload_0
    //   429: new 538	com/crashlytics/android/R
    //   432: dup
    //   433: new 347	java/lang/StringBuilder
    //   436: dup
    //   437: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   440: aload 26
    //   442: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: ldc_w 643
    //   448: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: invokevirtual 363	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   454: invokespecial 539	com/crashlytics/android/R:<init>	(Ljava/lang/String;)V
    //   457: invokespecial 542	com/crashlytics/android/v:a	(Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   460: astore 27
    //   462: aload 27
    //   464: ifnull +679 -> 1143
    //   467: aload 27
    //   469: arraylength
    //   470: ifle +673 -> 1143
    //   473: iconst_1
    //   474: istore 28
    //   476: invokestatic 145	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   479: invokevirtual 190	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   482: astore 29
    //   484: getstatic 165	java/util/Locale:US	Ljava/util/Locale;
    //   487: astore 30
    //   489: iconst_2
    //   490: anewarray 4	java/lang/Object
    //   493: astore 31
    //   495: aload 31
    //   497: iconst_0
    //   498: aload 26
    //   500: aastore
    //   501: aload 31
    //   503: iconst_1
    //   504: iload 28
    //   506: invokestatic 1044	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   509: aastore
    //   510: aload 29
    //   512: ldc 192
    //   514: aload 30
    //   516: ldc_w 1046
    //   519: aload 31
    //   521: invokestatic 183	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   524: invokeinterface 199 3 0
    //   529: aload_0
    //   530: new 538	com/crashlytics/android/R
    //   533: dup
    //   534: new 347	java/lang/StringBuilder
    //   537: dup
    //   538: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   541: aload 26
    //   543: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: ldc_w 685
    //   549: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: invokevirtual 363	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   555: invokespecial 539	com/crashlytics/android/R:<init>	(Ljava/lang/String;)V
    //   558: invokespecial 542	com/crashlytics/android/v:a	(Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   561: astore 32
    //   563: aload 32
    //   565: ifnull +584 -> 1149
    //   568: aload 32
    //   570: arraylength
    //   571: ifle +578 -> 1149
    //   574: iconst_1
    //   575: istore 33
    //   577: invokestatic 145	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   580: invokevirtual 190	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   583: astore 34
    //   585: getstatic 165	java/util/Locale:US	Ljava/util/Locale;
    //   588: astore 35
    //   590: iconst_2
    //   591: anewarray 4	java/lang/Object
    //   594: astore 36
    //   596: aload 36
    //   598: iconst_0
    //   599: aload 26
    //   601: aastore
    //   602: aload 36
    //   604: iconst_1
    //   605: iload 33
    //   607: invokestatic 1044	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   610: aastore
    //   611: aload 34
    //   613: ldc 192
    //   615: aload 35
    //   617: ldc_w 1048
    //   620: aload 36
    //   622: invokestatic 183	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   625: invokeinterface 199 3 0
    //   630: iload 28
    //   632: ifne +8 -> 640
    //   635: iload 33
    //   637: ifeq +607 -> 1244
    //   640: aconst_null
    //   641: astore 37
    //   643: new 482	com/crashlytics/android/f
    //   646: dup
    //   647: aload_0
    //   648: getfield 150	com/crashlytics/android/v:k	Ljava/io/File;
    //   651: aload 26
    //   653: invokespecial 644	com/crashlytics/android/f:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   656: astore 38
    //   658: aload 38
    //   660: invokestatic 647	com/crashlytics/android/h:a	(Ljava/io/OutputStream;)Lcom/crashlytics/android/h;
    //   663: astore 43
    //   665: aload 43
    //   667: astore 37
    //   669: invokestatic 145	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   672: invokevirtual 190	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   675: ldc 192
    //   677: new 347	java/lang/StringBuilder
    //   680: dup
    //   681: ldc_w 1050
    //   684: invokespecial 527	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   687: aload 26
    //   689: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: invokevirtual 363	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   695: invokeinterface 199 3 0
    //   700: aload 37
    //   702: aload 25
    //   704: invokestatic 550	com/crashlytics/android/v:a	(Lcom/crashlytics/android/h;Ljava/io/File;)V
    //   707: aload 37
    //   709: iconst_4
    //   710: new 715	java/util/Date
    //   713: dup
    //   714: invokespecial 923	java/util/Date:<init>	()V
    //   717: invokevirtual 718	java/util/Date:getTime	()J
    //   720: ldc2_w 719
    //   723: ldiv
    //   724: invokevirtual 495	com/crashlytics/android/h:a	(IJ)V
    //   727: aload 37
    //   729: iconst_5
    //   730: iload 28
    //   732: invokevirtual 794	com/crashlytics/android/h:a	(IZ)V
    //   735: aload_0
    //   736: aload 37
    //   738: aload 26
    //   740: invokespecial 1052	com/crashlytics/android/v:a	(Lcom/crashlytics/android/h;Ljava/lang/String;)V
    //   743: iload 33
    //   745: ifeq +110 -> 855
    //   748: aload 32
    //   750: arraylength
    //   751: iload 21
    //   753: if_icmple +618 -> 1371
    //   756: invokestatic 145	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   759: invokevirtual 190	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   762: astore 45
    //   764: getstatic 165	java/util/Locale:US	Ljava/util/Locale;
    //   767: astore 46
    //   769: iconst_1
    //   770: anewarray 4	java/lang/Object
    //   773: astore 47
    //   775: aload 47
    //   777: iconst_0
    //   778: iload 21
    //   780: invokestatic 1057	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   783: aastore
    //   784: aload 45
    //   786: ldc 192
    //   788: aload 46
    //   790: ldc_w 1059
    //   793: aload 47
    //   795: invokestatic 183	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   798: invokeinterface 199 3 0
    //   803: aload_0
    //   804: aload 26
    //   806: iload 21
    //   808: invokespecial 836	com/crashlytics/android/v:a	(Ljava/lang/String;I)V
    //   811: aload_0
    //   812: new 538	com/crashlytics/android/R
    //   815: dup
    //   816: new 347	java/lang/StringBuilder
    //   819: dup
    //   820: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   823: aload 26
    //   825: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   828: ldc_w 685
    //   831: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   834: invokevirtual 363	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   837: invokespecial 539	com/crashlytics/android/R:<init>	(Ljava/lang/String;)V
    //   840: invokespecial 542	com/crashlytics/android/v:a	(Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   843: astore 44
    //   845: aload_0
    //   846: aload 37
    //   848: aload 44
    //   850: aload 26
    //   852: invokespecial 1061	com/crashlytics/android/v:a	(Lcom/crashlytics/android/h;[Ljava/io/File;Ljava/lang/String;)V
    //   855: iload 28
    //   857: ifeq +12 -> 869
    //   860: aload 37
    //   862: aload 27
    //   864: iconst_0
    //   865: aaload
    //   866: invokestatic 550	com/crashlytics/android/v:a	(Lcom/crashlytics/android/h;Ljava/io/File;)V
    //   869: aload 37
    //   871: bipush 11
    //   873: iconst_1
    //   874: invokevirtual 500	com/crashlytics/android/h:a	(II)V
    //   877: aload 37
    //   879: bipush 12
    //   881: iconst_3
    //   882: invokevirtual 892	com/crashlytics/android/h:b	(II)V
    //   885: aload 37
    //   887: ldc_w 1063
    //   890: invokestatic 657	com/crashlytics/android/internal/ab:a	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   893: aload 38
    //   895: ldc_w 1065
    //   898: invokestatic 521	com/crashlytics/android/internal/ab:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   901: invokestatic 145	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   904: invokevirtual 190	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   907: ldc 192
    //   909: new 347	java/lang/StringBuilder
    //   912: dup
    //   913: ldc_w 1067
    //   916: invokespecial 527	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   919: aload 26
    //   921: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   924: invokevirtual 363	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   927: invokeinterface 199 3 0
    //   932: aload_0
    //   933: aload 26
    //   935: invokespecial 1068	com/crashlytics/android/v:a	(Ljava/lang/String;)V
    //   938: iinc 24 1
    //   941: goto -596 -> 345
    //   944: aload 13
    //   946: ifnonnull +8 -> 954
    //   949: ldc_w 262
    //   952: astore 13
    //   954: aload 13
    //   956: invokestatic 104	com/crashlytics/android/d:a	(Ljava/lang/String;)Lcom/crashlytics/android/d;
    //   959: astore 16
    //   961: aload 14
    //   963: ifnonnull +119 -> 1082
    //   966: aconst_null
    //   967: astore 17
    //   969: goto +409 -> 1378
    //   972: iconst_0
    //   973: iconst_1
    //   974: aload 16
    //   976: invokestatic 287	com/crashlytics/android/h:b	(ILcom/crashlytics/android/d;)I
    //   979: iadd
    //   980: istore 19
    //   982: aload 17
    //   984: ifnull +14 -> 998
    //   987: iload 19
    //   989: iconst_2
    //   990: aload 17
    //   992: invokestatic 287	com/crashlytics/android/h:b	(ILcom/crashlytics/android/d;)I
    //   995: iadd
    //   996: istore 19
    //   998: aload 18
    //   1000: ifnull +14 -> 1014
    //   1003: iload 19
    //   1005: iconst_3
    //   1006: aload 18
    //   1008: invokestatic 287	com/crashlytics/android/h:b	(ILcom/crashlytics/android/d;)I
    //   1011: iadd
    //   1012: istore 19
    //   1014: aload 9
    //   1016: bipush 6
    //   1018: iconst_2
    //   1019: invokevirtual 490	com/crashlytics/android/h:g	(II)V
    //   1022: aload 9
    //   1024: iload 19
    //   1026: invokevirtual 492	com/crashlytics/android/h:b	(I)V
    //   1029: aload 9
    //   1031: iconst_1
    //   1032: aload 16
    //   1034: invokevirtual 498	com/crashlytics/android/h:a	(ILcom/crashlytics/android/d;)V
    //   1037: aload 17
    //   1039: ifnull +11 -> 1050
    //   1042: aload 9
    //   1044: iconst_2
    //   1045: aload 17
    //   1047: invokevirtual 498	com/crashlytics/android/h:a	(ILcom/crashlytics/android/d;)V
    //   1050: aload 18
    //   1052: ifnull +11 -> 1063
    //   1055: aload 9
    //   1057: iconst_3
    //   1058: aload 18
    //   1060: invokevirtual 498	com/crashlytics/android/h:a	(ILcom/crashlytics/android/d;)V
    //   1063: aload 9
    //   1065: ldc_w 1024
    //   1068: invokestatic 657	com/crashlytics/android/internal/ab:a	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   1071: aload 10
    //   1073: ldc_w 1026
    //   1076: invokestatic 521	com/crashlytics/android/internal/ab:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   1079: goto -795 -> 284
    //   1082: aload 14
    //   1084: invokestatic 104	com/crashlytics/android/d:a	(Ljava/lang/String;)Lcom/crashlytics/android/d;
    //   1087: astore 17
    //   1089: goto +289 -> 1378
    //   1092: aload 15
    //   1094: invokestatic 104	com/crashlytics/android/d:a	(Ljava/lang/String;)Lcom/crashlytics/android/d;
    //   1097: astore 48
    //   1099: aload 48
    //   1101: astore 18
    //   1103: goto -131 -> 972
    //   1106: astore 11
    //   1108: aconst_null
    //   1109: astore 10
    //   1111: aload_0
    //   1112: aload 11
    //   1114: aload 10
    //   1116: invokespecial 679	com/crashlytics/android/v:a	(Ljava/lang/Throwable;Ljava/io/OutputStream;)V
    //   1119: aload 11
    //   1121: athrow
    //   1122: astore 12
    //   1124: aload 9
    //   1126: ldc_w 1024
    //   1129: invokestatic 657	com/crashlytics/android/internal/ab:a	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   1132: aload 10
    //   1134: ldc_w 1026
    //   1137: invokestatic 521	com/crashlytics/android/internal/ab:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   1140: aload 12
    //   1142: athrow
    //   1143: iconst_0
    //   1144: istore 28
    //   1146: goto -670 -> 476
    //   1149: iconst_0
    //   1150: istore 33
    //   1152: goto -575 -> 577
    //   1155: astore 39
    //   1157: aconst_null
    //   1158: astore 41
    //   1160: aconst_null
    //   1161: astore 40
    //   1163: invokestatic 145	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   1166: invokevirtual 190	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   1169: ldc 192
    //   1171: new 347	java/lang/StringBuilder
    //   1174: dup
    //   1175: ldc_w 1070
    //   1178: invokespecial 527	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1181: aload 26
    //   1183: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1186: invokevirtual 363	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1189: aload 39
    //   1191: invokeinterface 258 4 0
    //   1196: aload_0
    //   1197: aload 39
    //   1199: aload 40
    //   1201: invokespecial 679	com/crashlytics/android/v:a	(Ljava/lang/Throwable;Ljava/io/OutputStream;)V
    //   1204: aload 41
    //   1206: ldc_w 1063
    //   1209: invokestatic 657	com/crashlytics/android/internal/ab:a	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   1212: aload 40
    //   1214: invokestatic 1072	com/crashlytics/android/v:a	(Lcom/crashlytics/android/f;)V
    //   1217: goto -316 -> 901
    //   1220: astore 42
    //   1222: aconst_null
    //   1223: astore 38
    //   1225: aload 37
    //   1227: ldc_w 1063
    //   1230: invokestatic 657	com/crashlytics/android/internal/ab:a	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   1233: aload 38
    //   1235: ldc_w 1065
    //   1238: invokestatic 521	com/crashlytics/android/internal/ab:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   1241: aload 42
    //   1243: athrow
    //   1244: invokestatic 145	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   1247: invokevirtual 190	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   1250: ldc 192
    //   1252: new 347	java/lang/StringBuilder
    //   1255: dup
    //   1256: ldc_w 1074
    //   1259: invokespecial 527	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1262: aload 26
    //   1264: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1267: invokevirtual 363	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1270: invokeinterface 199 3 0
    //   1275: goto -374 -> 901
    //   1278: invokestatic 145	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   1281: invokevirtual 190	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   1284: ldc 192
    //   1286: ldc_w 1076
    //   1289: invokeinterface 199 3 0
    //   1294: return
    //   1295: invokestatic 145	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   1298: invokevirtual 190	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   1301: ldc 192
    //   1303: ldc_w 1078
    //   1306: invokeinterface 199 3 0
    //   1311: return
    //   1312: astore 42
    //   1314: goto -89 -> 1225
    //   1317: astore 42
    //   1319: aload 40
    //   1321: astore 38
    //   1323: aload 41
    //   1325: astore 37
    //   1327: goto -102 -> 1225
    //   1330: astore 39
    //   1332: aload 38
    //   1334: astore 40
    //   1336: aconst_null
    //   1337: astore 41
    //   1339: goto -176 -> 1163
    //   1342: astore 39
    //   1344: aload 37
    //   1346: astore 41
    //   1348: aload 38
    //   1350: astore 40
    //   1352: goto -189 -> 1163
    //   1355: astore 12
    //   1357: aconst_null
    //   1358: astore 9
    //   1360: aconst_null
    //   1361: astore 10
    //   1363: goto -239 -> 1124
    //   1366: astore 11
    //   1368: goto -257 -> 1111
    //   1371: aload 32
    //   1373: astore 44
    //   1375: goto -530 -> 845
    //   1378: aload 15
    //   1380: ifnonnull -288 -> 1092
    //   1383: aconst_null
    //   1384: astore 18
    //   1386: goto -414 -> 972
    //
    // Exception table:
    //   from	to	target	type
    //   188	222	1106	java/lang/Exception
    //   222	253	1122	finally
    //   954	961	1122	finally
    //   972	982	1122	finally
    //   987	998	1122	finally
    //   1003	1014	1122	finally
    //   1014	1037	1122	finally
    //   1042	1050	1122	finally
    //   1055	1063	1122	finally
    //   1082	1089	1122	finally
    //   1092	1099	1122	finally
    //   1111	1122	1122	finally
    //   643	658	1155	java/lang/Exception
    //   643	658	1220	finally
    //   658	665	1312	finally
    //   669	743	1312	finally
    //   748	845	1312	finally
    //   845	855	1312	finally
    //   860	869	1312	finally
    //   869	885	1312	finally
    //   1163	1204	1317	finally
    //   658	665	1330	java/lang/Exception
    //   669	743	1342	java/lang/Exception
    //   748	845	1342	java/lang/Exception
    //   845	855	1342	java/lang/Exception
    //   860	869	1342	java/lang/Exception
    //   869	885	1342	java/lang/Exception
    //   188	222	1355	finally
    //   222	253	1366	java/lang/Exception
    //   954	961	1366	java/lang/Exception
    //   972	982	1366	java/lang/Exception
    //   987	998	1366	java/lang/Exception
    //   1003	1014	1366	java/lang/Exception
    //   1014	1037	1366	java/lang/Exception
    //   1042	1050	1366	java/lang/Exception
    //   1055	1063	1366	java/lang/Exception
    //   1082	1089	1366	java/lang/Exception
    //   1092	1099	1366	java/lang/Exception
  }

  private String n()
  {
    File[] arrayOfFile = a(new R("BeginSession"));
    Arrays.sort(arrayOfFile, b);
    if (arrayOfFile.length > 0)
      return a(arrayOfFile[0]);
    return null;
  }

  private File[] o()
  {
    return a(new R("BeginSession"));
  }

  private void p()
  {
    for (File localFile : a(a))
    {
      com.crashlytics.android.internal.v.a().b().a("Crashlytics", "Attempting to send crash report at time of crash...");
      new Thread(new D(this, localFile), "Crashlytics Report Uploader").start();
    }
  }

  private static int q()
  {
    return 0 + h.b(1, d.a(r.a(Crashlytics.getInstance().getContext(), com.crashlytics.android.internal.v.a().f())));
  }

  private int r()
  {
    int i1 = 0 + h.b(1, 0L) + h.b(2, 0L) + h.b(3, this.q);
    if (this.r != null)
      i1 += h.b(4, this.r);
    return i1;
  }

  private static int s()
  {
    return 0 + h.b(1, f) + h.b(2, f) + h.b(3, 0L);
  }

  final void a(long paramLong, String paramString)
  {
    b(new x(this, paramLong, paramString));
  }

  final void a(Thread paramThread, Throwable paramThrowable)
  {
    a(new P(this, new Date(), paramThread, paramThrowable));
  }

  final void a(File[] paramArrayOfFile)
  {
    File localFile1 = new File(com.crashlytics.android.internal.v.a().h(), "invalidClsFiles");
    if (localFile1.exists())
    {
      if (localFile1.isDirectory())
      {
        File[] arrayOfFile2 = localFile1.listFiles();
        int i5 = arrayOfFile2.length;
        for (int i6 = 0; i6 < i5; i6++)
          arrayOfFile2[i6].delete();
      }
      localFile1.delete();
    }
    int i1 = paramArrayOfFile.length;
    for (int i2 = 0; i2 < i1; i2++)
    {
      File localFile2 = paramArrayOfFile[i2];
      com.crashlytics.android.internal.v.a().b().a("Crashlytics", "Found invalid session part file: " + localFile2);
      String str = a(localFile2);
      F localF = new F(this, str);
      com.crashlytics.android.internal.v.a().b().a("Crashlytics", "Deleting all part files for invalid session: " + str);
      for (File localFile3 : a(localF))
      {
        com.crashlytics.android.internal.v.a().b().a("Crashlytics", "Deleting session file: " + localFile3);
        localFile3.delete();
      }
    }
  }

  final boolean a()
  {
    return this.m.get();
  }

  final boolean b()
  {
    return ((Boolean)a(new O(this))).booleanValue();
  }

  final void c()
  {
    b(new z(this));
  }

  final void d()
  {
    b(new A(this));
  }

  final void e()
  {
    b(new B(this));
  }

  final boolean f()
  {
    return ((Boolean)a(new C(this))).booleanValue();
  }

  final boolean g()
  {
    return o().length > 0;
  }

  final void h()
  {
    a(new E(this));
  }

  // ERROR //
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 140	com/crashlytics/android/v:m	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   6: iconst_1
    //   7: invokevirtual 253	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   10: invokestatic 145	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   13: invokevirtual 190	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   16: ldc 192
    //   18: new 347	java/lang/StringBuilder
    //   21: dup
    //   22: ldc_w 1157
    //   25: invokespecial 527	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   28: aload_2
    //   29: invokevirtual 821	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   32: ldc_w 823
    //   35: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_1
    //   39: invokevirtual 401	java/lang/Thread:getName	()Ljava/lang/String;
    //   42: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 363	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokeinterface 199 3 0
    //   53: aload_0
    //   54: getfield 134	com/crashlytics/android/v:h	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   57: iconst_1
    //   58: invokevirtual 1161	java/util/concurrent/atomic/AtomicBoolean:getAndSet	(Z)Z
    //   61: ifne +45 -> 106
    //   64: invokestatic 145	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   67: invokevirtual 190	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   70: ldc 192
    //   72: ldc_w 1163
    //   75: invokeinterface 199 3 0
    //   80: invokestatic 171	com/crashlytics/android/Crashlytics:getInstance	()Lcom/crashlytics/android/Crashlytics;
    //   83: invokevirtual 244	com/crashlytics/android/Crashlytics:getContext	()Landroid/content/Context;
    //   86: aload_0
    //   87: getfield 226	com/crashlytics/android/v:p	Landroid/content/BroadcastReceiver;
    //   90: invokevirtual 1167	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   93: invokestatic 171	com/crashlytics/android/Crashlytics:getInstance	()Lcom/crashlytics/android/Crashlytics;
    //   96: invokevirtual 244	com/crashlytics/android/Crashlytics:getContext	()Landroid/content/Context;
    //   99: aload_0
    //   100: getfield 238	com/crashlytics/android/v:o	Landroid/content/BroadcastReceiver;
    //   103: invokevirtual 1167	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   106: aload_0
    //   107: new 1169	com/crashlytics/android/N
    //   110: dup
    //   111: aload_0
    //   112: new 715	java/util/Date
    //   115: dup
    //   116: invokespecial 923	java/util/Date:<init>	()V
    //   119: aload_1
    //   120: aload_2
    //   121: invokespecial 1170	com/crashlytics/android/N:<init>	(Lcom/crashlytics/android/v;Ljava/util/Date;Ljava/lang/Thread;Ljava/lang/Throwable;)V
    //   124: invokespecial 1136	com/crashlytics/android/v:a	(Ljava/util/concurrent/Callable;)Ljava/lang/Object;
    //   127: pop
    //   128: invokestatic 145	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   131: invokevirtual 190	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   134: ldc 192
    //   136: ldc_w 1172
    //   139: invokeinterface 199 3 0
    //   144: aload_0
    //   145: getfield 136	com/crashlytics/android/v:j	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   148: aload_1
    //   149: aload_2
    //   150: invokeinterface 1174 3 0
    //   155: aload_0
    //   156: getfield 140	com/crashlytics/android/v:m	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   159: iconst_0
    //   160: invokevirtual 253	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   163: aload_0
    //   164: monitorexit
    //   165: return
    //   166: astore 5
    //   168: invokestatic 145	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   171: invokevirtual 190	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   174: ldc 192
    //   176: ldc_w 1176
    //   179: aload 5
    //   181: invokeinterface 258 4 0
    //   186: invokestatic 145	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   189: invokevirtual 190	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   192: ldc 192
    //   194: ldc_w 1172
    //   197: invokeinterface 199 3 0
    //   202: aload_0
    //   203: getfield 136	com/crashlytics/android/v:j	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   206: aload_1
    //   207: aload_2
    //   208: invokeinterface 1174 3 0
    //   213: aload_0
    //   214: getfield 140	com/crashlytics/android/v:m	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   217: iconst_0
    //   218: invokevirtual 253	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   221: goto -58 -> 163
    //   224: astore_3
    //   225: aload_0
    //   226: monitorexit
    //   227: aload_3
    //   228: athrow
    //   229: astore 4
    //   231: invokestatic 145	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   234: invokevirtual 190	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   237: ldc 192
    //   239: ldc_w 1172
    //   242: invokeinterface 199 3 0
    //   247: aload_0
    //   248: getfield 136	com/crashlytics/android/v:j	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   251: aload_1
    //   252: aload_2
    //   253: invokeinterface 1174 3 0
    //   258: aload_0
    //   259: getfield 140	com/crashlytics/android/v:m	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   262: iconst_0
    //   263: invokevirtual 253	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   266: aload 4
    //   268: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   10	106	166	java/lang/Exception
    //   106	128	166	java/lang/Exception
    //   2	10	224	finally
    //   128	163	224	finally
    //   186	221	224	finally
    //   231	269	224	finally
    //   10	106	229	finally
    //   106	128	229	finally
    //   168	186	229	finally
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.v
 * JD-Core Version:    0.6.2
 */