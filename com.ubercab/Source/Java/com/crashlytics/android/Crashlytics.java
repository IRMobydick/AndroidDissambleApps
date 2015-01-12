package com.crashlytics.android;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.crashlytics.android.internal.A;
import com.crashlytics.android.internal.D;
import com.crashlytics.android.internal.aM;
import com.crashlytics.android.internal.aP;
import com.crashlytics.android.internal.aR;
import com.crashlytics.android.internal.aS;
import com.crashlytics.android.internal.aX;
import com.crashlytics.android.internal.ab;
import com.crashlytics.android.internal.af;
import com.crashlytics.android.internal.ag;
import com.crashlytics.android.internal.ai;
import com.crashlytics.android.internal.ao;
import com.crashlytics.android.internal.av;
import com.crashlytics.android.internal.ax;
import com.crashlytics.android.internal.ay;
import com.crashlytics.android.internal.q;
import com.crashlytics.android.internal.r;
import com.crashlytics.android.internal.u;
import java.net.URL;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.HttpsURLConnection;

public final class Crashlytics extends u
{
  public static final String TAG = "Crashlytics";
  private static ContextWrapper j;
  private static String k;
  private static String l;
  private static String m;
  private static String n;
  private static String o;
  private static String p;
  private static String q;
  private static boolean r = false;
  private static PinningInfoProvider s = null;
  private static av t;
  private static float u;
  private static Crashlytics v;
  private final long a = System.currentTimeMillis();
  private final ConcurrentHashMap<String, String> b = new ConcurrentHashMap();
  private CrashlyticsListener c;
  private v d;
  private ao e = null;
  private String f = null;
  private String g = null;
  private String h = null;
  private String i;

  private b a(Y paramY)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = this.i;
    String str = ab.a(arrayOfString);
    int i1 = ai.a(l).a();
    return new b(p, k, o, n, str, m, i1, q, "0", paramY);
  }

  private static void a(int paramInt, String paramString1, String paramString2)
  {
    Crashlytics localCrashlytics = getInstance();
    if ((localCrashlytics == null) || (localCrashlytics.d == null))
    {
      com.crashlytics.android.internal.v.a().b().a(paramString1, "Crashlytics must be initialized by calling Crashlytics.start(Context) prior to logging messages.", null);
      return;
    }
    long l1 = System.currentTimeMillis() - localCrashlytics.a;
    localCrashlytics.d.a(l1, ab.b(paramInt) + "/" + paramString1 + " " + paramString2);
  }

  static void a(String paramString)
  {
    D localD = (D)com.crashlytics.android.internal.v.a().a(D.class);
    if (localD != null)
      localD.a(new ag(paramString));
  }

  // ERROR //
  private void a(String paramString, Context paramContext, float paramFloat)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: getstatic 178	com/crashlytics/android/Crashlytics:j	Landroid/content/ContextWrapper;
    //   8: ifnull +21 -> 29
    //   11: invokestatic 125	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   14: invokevirtual 128	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   17: ldc 8
    //   19: ldc 180
    //   21: invokeinterface 183 3 0
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: aload_1
    //   30: putstatic 97	com/crashlytics/android/Crashlytics:p	Ljava/lang/String;
    //   33: new 185	android/content/ContextWrapper
    //   36: dup
    //   37: aload_2
    //   38: invokevirtual 191	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   41: invokespecial 194	android/content/ContextWrapper:<init>	(Landroid/content/Context;)V
    //   44: putstatic 178	com/crashlytics/android/Crashlytics:j	Landroid/content/ContextWrapper;
    //   47: new 196	com/crashlytics/android/internal/av
    //   50: dup
    //   51: invokestatic 125	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   54: invokevirtual 128	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   57: invokespecial 199	com/crashlytics/android/internal/av:<init>	(Lcom/crashlytics/android/internal/q;)V
    //   60: putstatic 201	com/crashlytics/android/Crashlytics:t	Lcom/crashlytics/android/internal/av;
    //   63: invokestatic 125	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   66: invokevirtual 128	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   69: ldc 8
    //   71: new 137	java/lang/StringBuilder
    //   74: dup
    //   75: ldc 203
    //   77: invokespecial 204	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   80: invokestatic 207	com/crashlytics/android/Crashlytics:getCrashlyticsVersion	()Ljava/lang/String;
    //   83: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokeinterface 209 3 0
    //   94: getstatic 178	com/crashlytics/android/Crashlytics:j	Landroid/content/ContextWrapper;
    //   97: invokevirtual 212	android/content/ContextWrapper:getPackageName	()Ljava/lang/String;
    //   100: putstatic 99	com/crashlytics/android/Crashlytics:k	Ljava/lang/String;
    //   103: getstatic 178	com/crashlytics/android/Crashlytics:j	Landroid/content/ContextWrapper;
    //   106: invokevirtual 216	android/content/ContextWrapper:getPackageManager	()Landroid/content/pm/PackageManager;
    //   109: astore 11
    //   111: aload 11
    //   113: getstatic 99	com/crashlytics/android/Crashlytics:k	Ljava/lang/String;
    //   116: invokevirtual 222	android/content/pm/PackageManager:getInstallerPackageName	(Ljava/lang/String;)Ljava/lang/String;
    //   119: putstatic 85	com/crashlytics/android/Crashlytics:l	Ljava/lang/String;
    //   122: invokestatic 125	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   125: invokevirtual 128	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   128: ldc 8
    //   130: new 137	java/lang/StringBuilder
    //   133: dup
    //   134: ldc 224
    //   136: invokespecial 204	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   139: getstatic 85	com/crashlytics/android/Crashlytics:l	Ljava/lang/String;
    //   142: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokeinterface 183 3 0
    //   153: aload 11
    //   155: getstatic 99	com/crashlytics/android/Crashlytics:k	Ljava/lang/String;
    //   158: iconst_0
    //   159: invokevirtual 228	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   162: astore 12
    //   164: aload 12
    //   166: getfield 234	android/content/pm/PackageInfo:versionCode	I
    //   169: invokestatic 238	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   172: putstatic 103	com/crashlytics/android/Crashlytics:n	Ljava/lang/String;
    //   175: aload 12
    //   177: getfield 241	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   180: ifnonnull +312 -> 492
    //   183: ldc 243
    //   185: astore 13
    //   187: aload 13
    //   189: putstatic 101	com/crashlytics/android/Crashlytics:o	Ljava/lang/String;
    //   192: aload_2
    //   193: invokevirtual 244	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   196: aload_2
    //   197: invokevirtual 248	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   200: invokevirtual 252	android/content/pm/PackageManager:getApplicationLabel	(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;
    //   203: invokeinterface 255 1 0
    //   208: putstatic 105	com/crashlytics/android/Crashlytics:m	Ljava/lang/String;
    //   211: aload_2
    //   212: invokevirtual 248	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   215: getfield 260	android/content/pm/ApplicationInfo:targetSdkVersion	I
    //   218: invokestatic 238	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   221: putstatic 107	com/crashlytics/android/Crashlytics:q	Ljava/lang/String;
    //   224: aload_0
    //   225: aload_2
    //   226: invokestatic 263	com/crashlytics/android/internal/ab:i	(Landroid/content/Context;)Ljava/lang/String;
    //   229: putfield 78	com/crashlytics/android/Crashlytics:i	Ljava/lang/String;
    //   232: aload_0
    //   233: new 265	com/crashlytics/android/internal/ao
    //   236: dup
    //   237: getstatic 178	com/crashlytics/android/Crashlytics:j	Landroid/content/ContextWrapper;
    //   240: invokespecial 266	com/crashlytics/android/internal/ao:<init>	(Landroid/content/Context;)V
    //   243: putfield 53	com/crashlytics/android/Crashlytics:e	Lcom/crashlytics/android/internal/ao;
    //   246: aload_0
    //   247: getfield 53	com/crashlytics/android/Crashlytics:e	Lcom/crashlytics/android/internal/ao;
    //   250: invokevirtual 268	com/crashlytics/android/internal/ao:h	()Ljava/lang/String;
    //   253: pop
    //   254: new 270	com/crashlytics/android/c
    //   257: dup
    //   258: aload_0
    //   259: getfield 78	com/crashlytics/android/Crashlytics:i	Ljava/lang/String;
    //   262: getstatic 178	com/crashlytics/android/Crashlytics:j	Landroid/content/ContextWrapper;
    //   265: ldc_w 272
    //   268: iconst_1
    //   269: invokestatic 275	com/crashlytics/android/internal/ab:a	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   272: invokespecial 278	com/crashlytics/android/c:<init>	(Ljava/lang/String;Z)V
    //   275: aload_1
    //   276: getstatic 99	com/crashlytics/android/Crashlytics:k	Ljava/lang/String;
    //   279: invokevirtual 279	com/crashlytics/android/c:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   282: invokestatic 125	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   285: invokevirtual 128	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   288: ldc 8
    //   290: ldc_w 281
    //   293: invokeinterface 183 3 0
    //   298: aload_0
    //   299: new 155	com/crashlytics/android/v
    //   302: dup
    //   303: invokestatic 287	java/lang/Thread:getDefaultUncaughtExceptionHandler	()Ljava/lang/Thread$UncaughtExceptionHandler;
    //   306: aload_0
    //   307: getfield 289	com/crashlytics/android/Crashlytics:c	Lcom/crashlytics/android/CrashlyticsListener;
    //   310: aload_0
    //   311: getfield 78	com/crashlytics/android/Crashlytics:i	Ljava/lang/String;
    //   314: invokespecial 292	com/crashlytics/android/v:<init>	(Ljava/lang/Thread$UncaughtExceptionHandler;Lcom/crashlytics/android/CrashlyticsListener;Ljava/lang/String;)V
    //   317: putfield 115	com/crashlytics/android/Crashlytics:d	Lcom/crashlytics/android/v;
    //   320: aload_0
    //   321: getfield 115	com/crashlytics/android/Crashlytics:d	Lcom/crashlytics/android/v;
    //   324: invokevirtual 295	com/crashlytics/android/v:f	()Z
    //   327: istore 4
    //   329: aload_0
    //   330: getfield 115	com/crashlytics/android/Crashlytics:d	Lcom/crashlytics/android/v;
    //   333: invokevirtual 297	com/crashlytics/android/v:d	()V
    //   336: aload_0
    //   337: getfield 115	com/crashlytics/android/Crashlytics:d	Lcom/crashlytics/android/v;
    //   340: invokevirtual 299	com/crashlytics/android/v:c	()V
    //   343: aload_0
    //   344: getfield 115	com/crashlytics/android/Crashlytics:d	Lcom/crashlytics/android/v;
    //   347: invokevirtual 301	com/crashlytics/android/v:h	()V
    //   350: aload_0
    //   351: getfield 115	com/crashlytics/android/Crashlytics:d	Lcom/crashlytics/android/v;
    //   354: invokestatic 305	java/lang/Thread:setDefaultUncaughtExceptionHandler	(Ljava/lang/Thread$UncaughtExceptionHandler;)V
    //   357: invokestatic 125	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   360: invokevirtual 128	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   363: ldc 8
    //   365: ldc_w 307
    //   368: invokeinterface 183 3 0
    //   373: new 309	java/util/concurrent/CountDownLatch
    //   376: dup
    //   377: iconst_1
    //   378: invokespecial 312	java/util/concurrent/CountDownLatch:<init>	(I)V
    //   381: astore 9
    //   383: new 283	java/lang/Thread
    //   386: dup
    //   387: new 314	com/crashlytics/android/t
    //   390: dup
    //   391: aload_0
    //   392: aload_2
    //   393: fload_3
    //   394: aload 9
    //   396: invokespecial 317	com/crashlytics/android/t:<init>	(Lcom/crashlytics/android/Crashlytics;Landroid/content/Context;FLjava/util/concurrent/CountDownLatch;)V
    //   399: ldc_w 319
    //   402: invokespecial 322	java/lang/Thread:<init>	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   405: invokevirtual 325	java/lang/Thread:start	()V
    //   408: iload 4
    //   410: ifeq -384 -> 26
    //   413: invokestatic 125	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   416: invokevirtual 128	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   419: ldc 8
    //   421: ldc_w 327
    //   424: invokeinterface 183 3 0
    //   429: aload 9
    //   431: ldc2_w 328
    //   434: getstatic 335	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   437: invokevirtual 339	java/util/concurrent/CountDownLatch:await	(JLjava/util/concurrent/TimeUnit;)Z
    //   440: ifne -414 -> 26
    //   443: invokestatic 125	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   446: invokevirtual 128	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   449: ldc 8
    //   451: ldc_w 341
    //   454: invokeinterface 343 3 0
    //   459: goto -433 -> 26
    //   462: astore 10
    //   464: invokestatic 125	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   467: invokevirtual 128	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   470: ldc 8
    //   472: ldc_w 345
    //   475: aload 10
    //   477: invokeinterface 135 4 0
    //   482: goto -456 -> 26
    //   485: astore 5
    //   487: aload_0
    //   488: monitorexit
    //   489: aload 5
    //   491: athrow
    //   492: aload 12
    //   494: getfield 241	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   497: astore 13
    //   499: goto -312 -> 187
    //   502: astore 6
    //   504: invokestatic 125	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   507: invokevirtual 128	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   510: ldc 8
    //   512: ldc_w 347
    //   515: aload 6
    //   517: invokeinterface 135 4 0
    //   522: goto -290 -> 232
    //   525: astore 8
    //   527: invokestatic 125	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   530: invokevirtual 128	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   533: ldc 8
    //   535: ldc_w 349
    //   538: aload 8
    //   540: invokeinterface 135 4 0
    //   545: goto -172 -> 373
    //
    // Exception table:
    //   from	to	target	type
    //   429	459	462	java/lang/InterruptedException
    //   5	26	485	finally
    //   29	94	485	finally
    //   94	183	485	finally
    //   187	232	485	finally
    //   232	282	485	finally
    //   282	373	485	finally
    //   373	408	485	finally
    //   413	429	485	finally
    //   429	459	485	finally
    //   464	482	485	finally
    //   492	499	485	finally
    //   504	522	485	finally
    //   527	545	485	finally
    //   94	183	502	java/lang/Exception
    //   187	232	502	java/lang/Exception
    //   492	499	502	java/lang/Exception
    //   282	373	525	java/lang/Exception
  }

  static void a(boolean paramBoolean)
  {
    ab.a().edit().putBoolean("always_send_reports_opt_in", true).commit();
  }

  private boolean a(Context paramContext, float paramFloat)
  {
    boolean bool1 = true;
    String str = ab.g(getContext());
    try
    {
      aS.a().a(paramContext, t, n, o, i()).c();
      aX localaX2 = aS.a().b();
      localaX1 = localaX2;
      if (localaX1 == null);
    }
    catch (Exception localException4)
    {
      while (true)
      {
        try
        {
          localaM = localaX1.a;
          if ("new".equals(localaM.a))
          {
            b localb2 = a(Y.a(getContext(), str));
            if (new T(i(), localaM.b, t).a(localb2))
            {
              boolean bool5 = aS.a().d();
              bool4 = bool5;
              bool3 = bool4;
            }
          }
        }
        catch (Exception localException4)
        {
          try
          {
            bool2 = localaX1.d.b;
            if ((!bool3) || (!bool2));
          }
          catch (Exception localException4)
          {
            try
            {
              aM localaM;
              bool1 = true & this.d.b();
              V localV = q();
              i1 = 0;
              if (localV != null)
                new aa(localV).a(paramFloat);
              if (i1 != 0)
                com.crashlytics.android.internal.v.a().b().a("Crashlytics", "Crash reporting disabled.");
              return bool1;
              localException1 = localException1;
              com.crashlytics.android.internal.v.a().b().a("Crashlytics", "Error dealing with settings", localException1);
              aX localaX1 = null;
              continue;
              com.crashlytics.android.internal.v.a().b().a("Crashlytics", "Failed to create app with Crashlytics service.", null);
              boolean bool4 = false;
              continue;
              if ("configured".equals(localaM.a))
              {
                bool4 = aS.a().d();
                continue;
              }
              if (localaM.d)
              {
                com.crashlytics.android.internal.v.a().b().a("Crashlytics", "Server says an update is required - forcing a full App update.");
                b localb1 = a(Y.a(getContext(), str));
                new ad(i(), localaM.b, t).a(localb1);
              }
              bool4 = bool1;
              continue;
              localException3 = localException3;
              com.crashlytics.android.internal.v.a().b().a("Crashlytics", "Error performing auto configuration.", localException3);
              bool3 = false;
              continue;
              localException4 = localException4;
              com.crashlytics.android.internal.v.a().b().a("Crashlytics", "Error getting collect reports setting.", localException4);
              bool2 = false;
            }
            catch (Exception localException2)
            {
              com.crashlytics.android.internal.v.a().b().a("Crashlytics", "Error sending crash report", localException2);
              i1 = 0;
              continue;
            }
            int i1 = bool1;
            continue;
          }
        }
        boolean bool2 = false;
        boolean bool3 = false;
      }
    }
  }

  static void b(String paramString)
  {
    D localD = (D)com.crashlytics.android.internal.v.a().a(D.class);
    if (localD != null)
      localD.a(new af(paramString));
  }

  private static String c(String paramString)
  {
    if (paramString != null)
    {
      paramString = paramString.trim();
      if (paramString.length() > 1024)
        paramString = paramString.substring(0, 1024);
    }
    return paramString;
  }

  static String d()
  {
    return k;
  }

  static String e()
  {
    return l;
  }

  static String f()
  {
    return o;
  }

  static String g()
  {
    return n;
  }

  @Deprecated
  public static String getCrashlyticsVersion()
  {
    return getInstance().getVersion();
  }

  public static Crashlytics getInstance()
  {
    try
    {
      Crashlytics localCrashlytics = (Crashlytics)com.crashlytics.android.internal.v.a().a(Crashlytics.class);
      if (localCrashlytics != null);
      while (true)
      {
        return localCrashlytics;
        if (v == null)
          v = new Crashlytics();
        localCrashlytics = v;
      }
    }
    finally
    {
    }
  }

  public static PinningInfoProvider getPinningInfoProvider()
  {
    return s;
  }

  static String h()
  {
    return m;
  }

  static String i()
  {
    return ab.a(j, "com.crashlytics.ApiEndpoint");
  }

  static boolean k()
  {
    return ab.a().getBoolean("always_send_reports_opt_in", false);
  }

  public static void log(int paramInt, String paramString1, String paramString2)
  {
    a(paramInt, paramString1, paramString2);
    com.crashlytics.android.internal.v.a().b().a(paramInt, paramString1, paramString2, true);
  }

  public static void log(String paramString)
  {
    a(3, "Crashlytics", paramString);
  }

  public static void logException(Throwable paramThrowable)
  {
    Crashlytics localCrashlytics = getInstance();
    if ((localCrashlytics == null) || (localCrashlytics.d == null))
    {
      com.crashlytics.android.internal.v.a().b().a("Crashlytics", "Crashlytics must be initialized by calling Crashlytics.start(Context) prior to logging exceptions.", null);
      return;
    }
    if (paramThrowable == null)
    {
      com.crashlytics.android.internal.v.a().b().a(5, "Crashlytics", "Crashlytics is ignoring a request to log a null exception.");
      return;
    }
    localCrashlytics.d.a(Thread.currentThread(), paramThrowable);
  }

  public static void setApplicationInstallationIdentifier(String paramString)
  {
    com.crashlytics.android.internal.v.a().a(c(paramString));
  }

  public static void setBool(String paramString, boolean paramBoolean)
  {
    setString(paramString, Boolean.toString(paramBoolean));
  }

  public static void setDouble(String paramString, double paramDouble)
  {
    setString(paramString, Double.toString(paramDouble));
  }

  public static void setFloat(String paramString, float paramFloat)
  {
    setString(paramString, Float.toString(paramFloat));
  }

  public static void setInt(String paramString, int paramInt)
  {
    setString(paramString, Integer.toString(paramInt));
  }

  public static void setLong(String paramString, long paramLong)
  {
    setString(paramString, Long.toString(paramLong));
  }

  public static void setPinningInfoProvider(PinningInfoProvider paramPinningInfoProvider)
  {
    if (s != paramPinningInfoProvider)
    {
      s = paramPinningInfoProvider;
      if (t != null)
      {
        if (paramPinningInfoProvider != null)
          break label29;
        t.a(null);
      }
    }
    return;
    label29: t.a(new k(paramPinningInfoProvider));
  }

  public static void setString(String paramString1, String paramString2)
  {
    if (paramString1 == null)
    {
      if ((j != null) && (ab.f(j)))
        throw new IllegalArgumentException("Custom attribute key cannot be null.");
      com.crashlytics.android.internal.v.a().b().a("Crashlytics", "Attempting to set custom attribute with null key, ignoring.", null);
      return;
    }
    String str1 = c(paramString1);
    if ((getInstance().b.size() < 64) || (getInstance().b.containsKey(str1)))
    {
      if (paramString2 == null);
      for (String str2 = ""; ; str2 = c(paramString2))
      {
        getInstance().b.put(str1, str2);
        return;
      }
    }
    com.crashlytics.android.internal.v.a().b().a("Crashlytics", "Exceeded maximum number of custom attributes (64)");
  }

  public static void setUserEmail(String paramString)
  {
    getInstance().g = c(paramString);
  }

  public static void setUserIdentifier(String paramString)
  {
    getInstance().f = c(paramString);
  }

  public static void setUserName(String paramString)
  {
    getInstance().h = c(paramString);
  }

  public static void start(Context paramContext)
  {
    start(paramContext, 1.0F);
  }

  public static void start(Context paramContext, float paramFloat)
  {
    u = paramFloat;
    if (!ab.d(paramContext))
      com.crashlytics.android.internal.v.a().a(new A());
    u[] arrayOfu = new u[2];
    arrayOfu[0] = getInstance();
    arrayOfu[1] = new D();
    com.crashlytics.android.internal.v.a(paramContext, arrayOfu);
  }

  final Map<String, String> a()
  {
    return Collections.unmodifiableMap(this.b);
  }

  final ao b()
  {
    return this.e;
  }

  protected final void c()
  {
    Context localContext = super.getContext();
    String str = r.a(localContext, false);
    if (str == null)
      return;
    try
    {
      a(str, localContext, u);
      return;
    }
    catch (CrashlyticsMissingDependencyException localCrashlyticsMissingDependencyException)
    {
      throw localCrashlyticsMissingDependencyException;
    }
    catch (Exception localException)
    {
      com.crashlytics.android.internal.v.a().b().a("Crashlytics", "Crashlytics was not started due to an exception during initialization", localException);
    }
  }

  public final void crash()
  {
    new CrashTest().indexOutOfBounds();
  }

  public final boolean getDebugMode()
  {
    return com.crashlytics.android.internal.v.a().f();
  }

  public final String getVersion()
  {
    return com.crashlytics.android.internal.v.a().getVersion();
  }

  final boolean j()
  {
    return ((Boolean)aS.a().a(new l(this), Boolean.valueOf(false))).booleanValue();
  }

  final v l()
  {
    return this.d;
  }

  final String m()
  {
    if (this.e.a())
      return this.f;
    return null;
  }

  final String n()
  {
    if (this.e.a())
      return this.g;
    return null;
  }

  final String o()
  {
    if (this.e.a())
      return this.h;
    return null;
  }

  final boolean p()
  {
    return ((Boolean)aS.a().a(new m(this), Boolean.valueOf(true))).booleanValue();
  }

  final V q()
  {
    return (V)aS.a().a(new n(this), null);
  }

  final aR r()
  {
    return (aR)aS.a().a(new o(this), null);
  }

  public final void setDebugMode(boolean paramBoolean)
  {
    com.crashlytics.android.internal.v.a().a(paramBoolean);
  }

  public final void setListener(CrashlyticsListener paramCrashlyticsListener)
  {
    this.c = paramCrashlyticsListener;
  }

  public final boolean verifyPinning(URL paramURL)
  {
    try
    {
      if (getPinningInfoProvider() != null)
      {
        ay localay = t.a(ax.a, paramURL.toString());
        ((HttpsURLConnection)localay.a()).setInstanceFollowRedirects(false);
        localay.b();
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      com.crashlytics.android.internal.v.a().b().a("Crashlytics", "Could not verify SSL pinning", localException);
    }
    return false;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.Crashlytics
 * JD-Core Version:    0.6.2
 */