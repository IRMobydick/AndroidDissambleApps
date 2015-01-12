package com.baidu.platform.comapi.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.android.bbalbs.common.util.CommonParam;
import com.baidu.mapapi.VersionInfo;
import java.io.File;
import java.util.Random;

public class c
{
  static String A = "-1";
  static String B = "-1";
  public static Context C;
  public static final int D = Integer.parseInt(Build.VERSION.SDK);
  public static float E = 1.0F;
  public static String F;
  private static final String G = c.class.getSimpleName();
  private static boolean H = true;
  private static int I = 0;
  private static int J = 0;
  static com.baidu.platform.comjni.map.commonmemcache.a a = new com.baidu.platform.comjni.map.commonmemcache.a();
  static com.baidu.platform.comjni.base.networkdetect.a b = new com.baidu.platform.comjni.base.networkdetect.a();
  static String c = "02";
  static String d;
  static String e;
  static String f;
  static String g;
  static int h;
  static int i;
  static int j;
  static int k;
  static int l;
  static int m;
  static String n;
  static String o;
  static String p;
  static String q;
  static String r;
  static String s;
  static String t = "baidu";
  static String u = "baidu";
  static String v = "";
  static String w = "";
  static String x = "";
  static String y;
  static String z;

  public static String a()
  {
    Random localRandom = new Random();
    StringBuffer localStringBuffer = new StringBuffer(10);
    for (int i1 = 0; i1 < 10; i1++)
      localStringBuffer.append(localRandom.nextInt(10));
    return localStringBuffer.toString();
  }

  // ERROR //
  public static String a(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 108	com/baidu/platform/comapi/c/c:H	Z
    //   3: ifne +55 -> 58
    //   6: invokestatic 137	com/baidu/platform/comapi/c/c:a	()Ljava/lang/String;
    //   9: astore 10
    //   11: aload 10
    //   13: astore_2
    //   14: aload_0
    //   15: ldc 139
    //   17: ldc 140
    //   19: invokevirtual 146	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   22: astore 11
    //   24: aload 11
    //   26: new 148	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   33: ldc 151
    //   35: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_2
    //   39: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokevirtual 161	java/lang/String:getBytes	()[B
    //   48: invokevirtual 167	java/io/FileOutputStream:write	([B)V
    //   51: aload 11
    //   53: invokevirtual 170	java/io/FileOutputStream:close	()V
    //   56: aload_2
    //   57: areturn
    //   58: aload_0
    //   59: ldc 139
    //   61: invokevirtual 174	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   64: astore 4
    //   66: aload 4
    //   68: invokevirtual 180	java/io/FileInputStream:available	()I
    //   71: newarray byte
    //   73: astore 5
    //   75: aload 4
    //   77: aload 5
    //   79: invokevirtual 184	java/io/FileInputStream:read	([B)I
    //   82: pop
    //   83: aload 4
    //   85: invokevirtual 185	java/io/FileInputStream:close	()V
    //   88: new 157	java/lang/String
    //   91: dup
    //   92: aload 5
    //   94: invokespecial 187	java/lang/String:<init>	([B)V
    //   97: astore 7
    //   99: aload 7
    //   101: iconst_1
    //   102: aload 7
    //   104: bipush 124
    //   106: invokevirtual 190	java/lang/String:indexOf	(I)I
    //   109: iadd
    //   110: invokevirtual 194	java/lang/String:substring	(I)Ljava/lang/String;
    //   113: astore 9
    //   115: aload 9
    //   117: areturn
    //   118: astore_1
    //   119: aconst_null
    //   120: astore_2
    //   121: aload_1
    //   122: astore_3
    //   123: aload_3
    //   124: invokevirtual 197	java/lang/Exception:printStackTrace	()V
    //   127: aload_2
    //   128: areturn
    //   129: astore_3
    //   130: goto -7 -> 123
    //   133: astore 8
    //   135: aload 8
    //   137: astore_3
    //   138: aload 7
    //   140: astore_2
    //   141: goto -18 -> 123
    //
    // Exception table:
    //   from	to	target	type
    //   0	11	118	java/lang/Exception
    //   58	99	118	java/lang/Exception
    //   14	56	129	java/lang/Exception
    //   99	115	133	java/lang/Exception
  }

  public static void a(String paramString)
  {
    q = paramString;
    h();
  }

  public static void a(String paramString1, String paramString2)
  {
    A = paramString2;
    B = paramString1;
    h();
  }

  public static void b()
  {
    f();
    d();
  }

  public static byte[] b(Context paramContext)
  {
    try
    {
      byte[] arrayOfByte = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 64).signatures[0].toByteArray();
      return arrayOfByte;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
    }
    return null;
  }

  public static Bundle c()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("cpu", v);
    localBundle.putString("resid", c);
    localBundle.putString("channel", t);
    localBundle.putString("glr", w);
    localBundle.putString("glv", x);
    localBundle.putString("mb", i());
    localBundle.putString("sv", k());
    localBundle.putString("os", m());
    localBundle.putInt("dpi_x", n());
    localBundle.putInt("dpi_y", n());
    localBundle.putString("net", q);
    localBundle.putString("im", j(C));
    localBundle.putString("imrand", a(C));
    localBundle.putString("cuid", p());
    localBundle.putByteArray("signature", b(C));
    localBundle.putString("pcn", C.getPackageName());
    localBundle.putInt("screen_x", j());
    localBundle.putInt("screen_y", l());
    return localBundle;
  }

  public static void c(Context paramContext)
  {
    C = paramContext;
    y = paramContext.getFilesDir().getAbsolutePath();
    z = paramContext.getCacheDir().getAbsolutePath();
    e = Build.MODEL;
    f = "Android" + Build.VERSION.SDK;
    d = paramContext.getPackageName();
    e(paramContext);
    f(paramContext);
    g(paramContext);
    h(paramContext);
    i(paramContext);
    l(paramContext);
    try
    {
      LocationManager localLocationManager = (LocationManager)paramContext.getSystemService("location");
      int i1;
      if (localLocationManager.isProviderEnabled("gps"))
      {
        i1 = 1;
        I = i1;
        if (!localLocationManager.isProviderEnabled("network"))
          break label137;
      }
      label137: for (int i2 = 1; ; i2 = 0)
      {
        J = i2;
        return;
        i1 = 0;
        break;
      }
    }
    catch (Exception localException)
    {
    }
  }

  public static void d()
  {
    if (b != null)
      b.a();
  }

  // ERROR //
  public static void d(Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: new 315	java/io/File
    //   5: dup
    //   6: getstatic 320	com/baidu/platform/comapi/c/c:y	Ljava/lang/String;
    //   9: invokespecial 370	java/io/File:<init>	(Ljava/lang/String;)V
    //   12: astore_2
    //   13: aload_2
    //   14: invokevirtual 374	java/io/File:exists	()Z
    //   17: ifne +8 -> 25
    //   20: aload_2
    //   21: invokevirtual 377	java/io/File:mkdirs	()Z
    //   24: pop
    //   25: aload_0
    //   26: invokevirtual 381	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   29: astore 4
    //   31: bipush 12
    //   33: anewarray 157	java/lang/String
    //   36: astore 5
    //   38: aload 5
    //   40: iconst_0
    //   41: ldc_w 383
    //   44: aastore
    //   45: aload 5
    //   47: iload_1
    //   48: ldc_w 385
    //   51: aastore
    //   52: aload 5
    //   54: iconst_2
    //   55: ldc_w 387
    //   58: aastore
    //   59: aload 5
    //   61: iconst_3
    //   62: ldc_w 389
    //   65: aastore
    //   66: aload 5
    //   68: iconst_4
    //   69: ldc_w 391
    //   72: aastore
    //   73: aload 5
    //   75: iconst_5
    //   76: ldc_w 393
    //   79: aastore
    //   80: aload 5
    //   82: bipush 6
    //   84: ldc_w 395
    //   87: aastore
    //   88: aload 5
    //   90: bipush 7
    //   92: ldc_w 397
    //   95: aastore
    //   96: aload 5
    //   98: bipush 8
    //   100: ldc_w 399
    //   103: aastore
    //   104: aload 5
    //   106: bipush 9
    //   108: ldc_w 401
    //   111: aastore
    //   112: aload 5
    //   114: bipush 10
    //   116: ldc_w 403
    //   119: aastore
    //   120: aload 5
    //   122: bipush 11
    //   124: ldc_w 405
    //   127: aastore
    //   128: bipush 12
    //   130: anewarray 157	java/lang/String
    //   133: astore 6
    //   135: aload 6
    //   137: iconst_0
    //   138: ldc_w 383
    //   141: aastore
    //   142: aload 6
    //   144: iload_1
    //   145: ldc_w 385
    //   148: aastore
    //   149: aload 6
    //   151: iconst_2
    //   152: ldc_w 407
    //   155: aastore
    //   156: aload 6
    //   158: iconst_3
    //   159: ldc_w 389
    //   162: aastore
    //   163: aload 6
    //   165: iconst_4
    //   166: ldc_w 391
    //   169: aastore
    //   170: aload 6
    //   172: iconst_5
    //   173: ldc_w 393
    //   176: aastore
    //   177: aload 6
    //   179: bipush 6
    //   181: ldc_w 395
    //   184: aastore
    //   185: aload 6
    //   187: bipush 7
    //   189: ldc_w 397
    //   192: aastore
    //   193: aload 6
    //   195: bipush 8
    //   197: ldc_w 399
    //   200: aastore
    //   201: aload 6
    //   203: bipush 9
    //   205: ldc_w 401
    //   208: aastore
    //   209: aload 6
    //   211: bipush 10
    //   213: ldc_w 403
    //   216: aastore
    //   217: aload 6
    //   219: bipush 11
    //   221: ldc_w 405
    //   224: aastore
    //   225: new 315	java/io/File
    //   228: dup
    //   229: new 148	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   236: getstatic 320	com/baidu/platform/comapi/c/c:y	Ljava/lang/String;
    //   239: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: ldc_w 409
    //   245: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokespecial 370	java/io/File:<init>	(Ljava/lang/String;)V
    //   254: astore 7
    //   256: bipush 6
    //   258: newarray byte
    //   260: dup
    //   261: iconst_0
    //   262: ldc_w 410
    //   265: bastore
    //   266: dup
    //   267: iconst_1
    //   268: ldc_w 411
    //   271: bastore
    //   272: dup
    //   273: iconst_2
    //   274: ldc_w 412
    //   277: bastore
    //   278: dup
    //   279: iconst_3
    //   280: ldc_w 412
    //   283: bastore
    //   284: dup
    //   285: iconst_4
    //   286: ldc_w 412
    //   289: bastore
    //   290: dup
    //   291: iconst_5
    //   292: ldc_w 412
    //   295: bastore
    //   296: astore 8
    //   298: aload 7
    //   300: invokevirtual 374	java/io/File:exists	()Z
    //   303: ifeq +48 -> 351
    //   306: new 176	java/io/FileInputStream
    //   309: dup
    //   310: aload 7
    //   312: invokespecial 415	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   315: astore 19
    //   317: aload 19
    //   319: invokevirtual 180	java/io/FileInputStream:available	()I
    //   322: newarray byte
    //   324: astore 20
    //   326: aload 19
    //   328: aload 20
    //   330: invokevirtual 184	java/io/FileInputStream:read	([B)I
    //   333: pop
    //   334: aload 19
    //   336: invokevirtual 185	java/io/FileInputStream:close	()V
    //   339: aload 20
    //   341: aload 8
    //   343: invokestatic 421	java/util/Arrays:equals	([B[B)Z
    //   346: ifeq +5 -> 351
    //   349: iconst_0
    //   350: istore_1
    //   351: iload_1
    //   352: ifeq +181 -> 533
    //   355: aload 7
    //   357: invokevirtual 374	java/io/File:exists	()Z
    //   360: ifeq +9 -> 369
    //   363: aload 7
    //   365: invokevirtual 424	java/io/File:delete	()Z
    //   368: pop
    //   369: aload 7
    //   371: invokevirtual 427	java/io/File:createNewFile	()Z
    //   374: pop
    //   375: new 163	java/io/FileOutputStream
    //   378: dup
    //   379: aload 7
    //   381: invokespecial 428	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   384: astore 23
    //   386: aload 23
    //   388: aload 8
    //   390: invokevirtual 167	java/io/FileOutputStream:write	([B)V
    //   393: aload 23
    //   395: invokevirtual 170	java/io/FileOutputStream:close	()V
    //   398: new 315	java/io/File
    //   401: dup
    //   402: new 148	java/lang/StringBuilder
    //   405: dup
    //   406: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   409: getstatic 320	com/baidu/platform/comapi/c/c:y	Ljava/lang/String;
    //   412: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: ldc_w 430
    //   418: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   424: invokespecial 370	java/io/File:<init>	(Ljava/lang/String;)V
    //   427: astore 24
    //   429: aload 24
    //   431: invokevirtual 374	java/io/File:exists	()Z
    //   434: ifne +9 -> 443
    //   437: aload 24
    //   439: invokevirtual 377	java/io/File:mkdirs	()Z
    //   442: pop
    //   443: new 315	java/io/File
    //   446: dup
    //   447: new 148	java/lang/StringBuilder
    //   450: dup
    //   451: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   454: getstatic 320	com/baidu/platform/comapi/c/c:y	Ljava/lang/String;
    //   457: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: ldc_w 432
    //   463: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   469: invokespecial 370	java/io/File:<init>	(Ljava/lang/String;)V
    //   472: astore 25
    //   474: aload 25
    //   476: invokevirtual 374	java/io/File:exists	()Z
    //   479: ifne +9 -> 488
    //   482: aload 25
    //   484: invokevirtual 377	java/io/File:mkdirs	()Z
    //   487: pop
    //   488: new 315	java/io/File
    //   491: dup
    //   492: new 148	java/lang/StringBuilder
    //   495: dup
    //   496: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   499: getstatic 320	com/baidu/platform/comapi/c/c:y	Ljava/lang/String;
    //   502: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: ldc_w 434
    //   508: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   514: invokespecial 370	java/io/File:<init>	(Ljava/lang/String;)V
    //   517: astore 26
    //   519: aload 26
    //   521: invokevirtual 374	java/io/File:exists	()Z
    //   524: ifne +9 -> 533
    //   527: aload 26
    //   529: invokevirtual 377	java/io/File:mkdirs	()Z
    //   532: pop
    //   533: iconst_0
    //   534: istore 10
    //   536: iload_1
    //   537: ifeq +138 -> 675
    //   540: iload 10
    //   542: aload 6
    //   544: arraylength
    //   545: if_icmpge +130 -> 675
    //   548: aload 4
    //   550: aload 5
    //   552: iload 10
    //   554: aaload
    //   555: invokevirtual 440	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   558: astore 12
    //   560: aload 12
    //   562: invokevirtual 443	java/io/InputStream:available	()I
    //   565: newarray byte
    //   567: astore 13
    //   569: aload 12
    //   571: aload 13
    //   573: invokevirtual 444	java/io/InputStream:read	([B)I
    //   576: pop
    //   577: aload 12
    //   579: invokevirtual 445	java/io/InputStream:close	()V
    //   582: new 315	java/io/File
    //   585: dup
    //   586: new 148	java/lang/StringBuilder
    //   589: dup
    //   590: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   593: getstatic 320	com/baidu/platform/comapi/c/c:y	Ljava/lang/String;
    //   596: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: ldc_w 447
    //   602: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: aload 6
    //   607: iload 10
    //   609: aaload
    //   610: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   616: invokespecial 370	java/io/File:<init>	(Ljava/lang/String;)V
    //   619: astore 15
    //   621: aload 15
    //   623: invokevirtual 374	java/io/File:exists	()Z
    //   626: ifeq +9 -> 635
    //   629: aload 15
    //   631: invokevirtual 424	java/io/File:delete	()Z
    //   634: pop
    //   635: aload 15
    //   637: invokevirtual 427	java/io/File:createNewFile	()Z
    //   640: pop
    //   641: new 163	java/io/FileOutputStream
    //   644: dup
    //   645: aload 15
    //   647: invokespecial 428	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   650: astore 17
    //   652: aload 17
    //   654: aload 13
    //   656: invokevirtual 167	java/io/FileOutputStream:write	([B)V
    //   659: aload 17
    //   661: invokevirtual 170	java/io/FileOutputStream:close	()V
    //   664: iinc 10 1
    //   667: goto -127 -> 540
    //   670: astore_3
    //   671: aload_3
    //   672: invokevirtual 197	java/lang/Exception:printStackTrace	()V
    //   675: return
    //   676: astore 9
    //   678: aload 9
    //   680: invokevirtual 197	java/lang/Exception:printStackTrace	()V
    //   683: goto -150 -> 533
    //   686: astore 11
    //   688: aload 11
    //   690: invokevirtual 197	java/lang/Exception:printStackTrace	()V
    //   693: goto -29 -> 664
    //
    // Exception table:
    //   from	to	target	type
    //   2	25	670	java/lang/Exception
    //   225	349	676	java/lang/Exception
    //   355	369	676	java/lang/Exception
    //   369	443	676	java/lang/Exception
    //   443	488	676	java/lang/Exception
    //   488	533	676	java/lang/Exception
    //   548	635	686	java/lang/Exception
    //   635	664	686	java/lang/Exception
  }

  public static void e()
  {
    if (a != null)
      a.a();
  }

  private static void e(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      PackageInfo localPackageInfo = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0);
      g = VersionInfo.getApiVersion();
      h = localPackageInfo.versionCode;
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      g = "1.0.0";
      h = 1;
    }
  }

  public static void f()
  {
    if (a != null)
      a.b();
  }

  private static void f(Context paramContext)
  {
    WindowManager localWindowManager = (WindowManager)paramContext.getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    if (localWindowManager != null);
    for (Display localDisplay = localWindowManager.getDefaultDisplay(); ; localDisplay = null)
    {
      if (localDisplay != null)
      {
        i = localDisplay.getWidth();
        j = localDisplay.getHeight();
        localDisplay.getMetrics(localDisplayMetrics);
      }
      E = localDisplayMetrics.density;
      k = (int)localDisplayMetrics.xdpi;
      l = (int)localDisplayMetrics.ydpi;
      if (D > 3);
      for (m = localDisplayMetrics.densityDpi; ; m = 160)
      {
        if (m == 0)
          m = 160;
        return;
      }
    }
  }

  public static String g()
  {
    return q;
  }

  private static void g(Context paramContext)
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    if (localTelephonyManager != null)
    {
      n = j(paramContext);
      o = localTelephonyManager.getSubscriberId();
      p = a(paramContext);
    }
  }

  public static void h()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("cpu", v);
    localBundle.putString("resid", c);
    localBundle.putString("channel", t);
    localBundle.putString("glr", w);
    localBundle.putString("glv", x);
    localBundle.putString("mb", i());
    localBundle.putString("sv", k());
    localBundle.putString("os", m());
    localBundle.putInt("dpi_x", n());
    localBundle.putInt("dpi_y", n());
    localBundle.putString("net", q);
    localBundle.putString("im", j(C));
    localBundle.putString("imrand", a(C));
    localBundle.putString("cuid", p());
    localBundle.putString("pcn", C.getPackageName());
    localBundle.putInt("screen_x", j());
    localBundle.putInt("screen_y", l());
    localBundle.putString("appid", A);
    localBundle.putString("uid", B);
    localBundle.putString("token", F);
    if (a != null)
      a.a(localBundle);
  }

  private static void h(Context paramContext)
  {
    r = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
  }

  public static String i()
  {
    return e;
  }

  private static void i(Context paramContext)
  {
    if ((TelephonyManager)paramContext.getSystemService("phone") != null)
      s = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
  }

  public static int j()
  {
    return i;
  }

  // ERROR //
  private static String j(Context paramContext)
  {
    // Byte code:
    //   0: new 315	java/io/File
    //   3: dup
    //   4: new 148	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   11: aload_0
    //   12: invokevirtual 313	android/content/Context:getFilesDir	()Ljava/io/File;
    //   15: invokevirtual 318	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   18: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: ldc_w 447
    //   24: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: ldc 139
    //   29: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokespecial 370	java/io/File:<init>	(Ljava/lang/String;)V
    //   38: astore_1
    //   39: aload_1
    //   40: invokevirtual 374	java/io/File:exists	()Z
    //   43: ifne +42 -> 85
    //   46: iconst_0
    //   47: putstatic 108	com/baidu/platform/comapi/c/c:H	Z
    //   50: aload_0
    //   51: invokestatic 564	com/baidu/platform/comapi/c/c:k	(Landroid/content/Context;)Ljava/lang/String;
    //   54: astore 11
    //   56: aload 11
    //   58: astore_3
    //   59: aload_0
    //   60: ldc 139
    //   62: ldc 140
    //   64: invokevirtual 146	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   67: astore 12
    //   69: aload 12
    //   71: aload_3
    //   72: invokevirtual 161	java/lang/String:getBytes	()[B
    //   75: invokevirtual 167	java/io/FileOutputStream:write	([B)V
    //   78: aload 12
    //   80: invokevirtual 170	java/io/FileOutputStream:close	()V
    //   83: aload_3
    //   84: areturn
    //   85: iconst_1
    //   86: putstatic 108	com/baidu/platform/comapi/c/c:H	Z
    //   89: aload_0
    //   90: ldc 139
    //   92: invokevirtual 174	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   95: astore 5
    //   97: aload 5
    //   99: invokevirtual 180	java/io/FileInputStream:available	()I
    //   102: newarray byte
    //   104: astore 6
    //   106: aload 5
    //   108: aload 6
    //   110: invokevirtual 184	java/io/FileInputStream:read	([B)I
    //   113: pop
    //   114: aload 5
    //   116: invokevirtual 185	java/io/FileInputStream:close	()V
    //   119: new 157	java/lang/String
    //   122: dup
    //   123: aload 6
    //   125: invokespecial 187	java/lang/String:<init>	([B)V
    //   128: astore 8
    //   130: aload 8
    //   132: iconst_0
    //   133: aload 8
    //   135: bipush 124
    //   137: invokevirtual 190	java/lang/String:indexOf	(I)I
    //   140: invokevirtual 567	java/lang/String:substring	(II)Ljava/lang/String;
    //   143: astore 10
    //   145: aload 10
    //   147: areturn
    //   148: astore_2
    //   149: aconst_null
    //   150: astore_3
    //   151: aload_2
    //   152: astore 4
    //   154: aload 4
    //   156: invokevirtual 197	java/lang/Exception:printStackTrace	()V
    //   159: aload_3
    //   160: areturn
    //   161: astore 4
    //   163: goto -9 -> 154
    //   166: astore 9
    //   168: aload 9
    //   170: astore 4
    //   172: aload 8
    //   174: astore_3
    //   175: goto -21 -> 154
    //
    // Exception table:
    //   from	to	target	type
    //   39	56	148	java/lang/Exception
    //   85	130	148	java/lang/Exception
    //   59	83	161	java/lang/Exception
    //   130	145	166	java/lang/Exception
  }

  public static String k()
  {
    return g;
  }

  private static String k(Context paramContext)
  {
    try
    {
      TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      if (localTelephonyManager != null)
      {
        String str2 = localTelephonyManager.getDeviceId();
        str1 = str2;
        if (TextUtils.isEmpty(str1))
          str1 = "000000000000000";
        return str1;
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        localException.printStackTrace();
        String str1 = null;
      }
    }
  }

  public static int l()
  {
    return j;
  }

  private static void l(Context paramContext)
  {
    q = "0";
  }

  public static String m()
  {
    return f;
  }

  public static int n()
  {
    return m;
  }

  public static String o()
  {
    return y;
  }

  public static String p()
  {
    String str = CommonParam.a(C);
    if (str == null)
      str = "";
    return str;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.platform.comapi.c.c
 * JD-Core Version:    0.6.2
 */