package com.mobileapptracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Location;

public class Parameters
{
  private static Parameters b = null;
  private String A = null;
  private String B = null;
  private String C = null;
  private String D = null;
  private String E = null;
  private String F = null;
  private String G = null;
  private String H = null;
  private String I = null;
  private String J = null;
  private String K = null;
  private String L = null;
  private String M = null;
  private String N = null;
  private String O = null;
  private String P = null;
  private String Q = null;
  private String R = null;
  private String S = null;
  private Location T = null;
  private String U = null;
  private String V = null;
  private String W = null;
  private String X = null;
  private String Y = null;
  private String Z = null;
  private Context a;
  private String aA = null;
  private String aB = null;
  private String aC = null;
  private String aD = null;
  private String aE = null;
  private String aF = null;
  private String aG = null;
  private String aH = null;
  private String aa = null;
  private String ab = null;
  private String ac = null;
  private String ad = null;
  private String ae = null;
  private String af = null;
  private String ag = null;
  private String ah = null;
  private String ai = null;
  private String aj = null;
  private String ak = null;
  private String al = null;
  private String am = null;
  private String an = null;
  private String ao = null;
  private String ap = null;
  private String aq = null;
  private String ar = null;
  private String as = null;
  private String at = null;
  private String au = null;
  private String av = null;
  private String aw = null;
  private String ax = null;
  private String ay = null;
  private String az = null;
  private String c = null;
  private String d = null;
  private String e = null;
  private String f = null;
  private String g = null;
  private String h = null;
  private String i = null;
  private String j = null;
  private String k = null;
  private String l = null;
  private String m = null;
  private String n = null;
  private String o = null;
  private String p = null;
  private String q = null;
  private String r = null;
  private String s = null;
  private String t = null;
  private String u = null;
  private String v = null;
  private String w = null;
  private String x = null;
  private String y = null;
  private String z = null;

  private String a(String paramString1, String paramString2)
  {
    try
    {
      String str = this.a.getSharedPreferences(paramString1, 0).getString(paramString2, "");
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      this.a.getSharedPreferences(paramString1, 0).edit().putString(paramString2, paramString3).commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  // ERROR //
  private boolean a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_2
    //   4: invokevirtual 314	java/lang/String:trim	()Ljava/lang/String;
    //   7: invokevirtual 318	com/mobileapptracker/Parameters:setAdvertiserId	(Ljava/lang/String;)V
    //   10: aload_0
    //   11: ldc_w 320
    //   14: invokevirtual 323	com/mobileapptracker/Parameters:setCurrencyCode	(Ljava/lang/String;)V
    //   17: new 325	android/os/Handler
    //   20: dup
    //   21: invokestatic 331	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   24: invokespecial 334	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   27: new 336	com/mobileapptracker/br
    //   30: dup
    //   31: aload_0
    //   32: aload_0
    //   33: getfield 272	com/mobileapptracker/Parameters:a	Landroid/content/Context;
    //   36: invokespecial 339	com/mobileapptracker/br:<init>	(Lcom/mobileapptracker/Parameters;Landroid/content/Context;)V
    //   39: invokevirtual 343	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   42: pop
    //   43: aload_0
    //   44: getfield 272	com/mobileapptracker/Parameters:a	Landroid/content/Context;
    //   47: invokevirtual 346	android/content/Context:getPackageName	()Ljava/lang/String;
    //   50: astore 8
    //   52: aload_0
    //   53: aload 8
    //   55: invokevirtual 349	com/mobileapptracker/Parameters:setPackageName	(Ljava/lang/String;)V
    //   58: aload_0
    //   59: getfield 272	com/mobileapptracker/Parameters:a	Landroid/content/Context;
    //   62: invokevirtual 353	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   65: astore 9
    //   67: aload_0
    //   68: aload 9
    //   70: aload 9
    //   72: aload 8
    //   74: iconst_0
    //   75: invokevirtual 359	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   78: invokevirtual 363	android/content/pm/PackageManager:getApplicationLabel	(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;
    //   81: invokeinterface 368 1 0
    //   86: invokevirtual 371	com/mobileapptracker/Parameters:setAppName	(Ljava/lang/String;)V
    //   89: aload_0
    //   90: new 373	java/util/Date
    //   93: dup
    //   94: new 375	java/io/File
    //   97: dup
    //   98: aload 9
    //   100: aload 8
    //   102: iconst_0
    //   103: invokevirtual 359	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   106: getfield 380	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   109: invokespecial 382	java/io/File:<init>	(Ljava/lang/String;)V
    //   112: invokevirtual 386	java/io/File:lastModified	()J
    //   115: invokespecial 389	java/util/Date:<init>	(J)V
    //   118: invokevirtual 392	java/util/Date:getTime	()J
    //   121: ldc2_w 393
    //   124: ldiv
    //   125: invokestatic 399	java/lang/Long:toString	(J)Ljava/lang/String;
    //   128: invokevirtual 402	com/mobileapptracker/Parameters:setInstallDate	(Ljava/lang/String;)V
    //   131: aload_0
    //   132: aload 9
    //   134: aload 8
    //   136: iconst_0
    //   137: invokevirtual 406	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   140: getfield 411	android/content/pm/PackageInfo:versionCode	I
    //   143: invokestatic 416	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   146: invokevirtual 419	com/mobileapptracker/Parameters:setAppVersion	(Ljava/lang/String;)V
    //   149: aload_0
    //   150: aload 9
    //   152: aload 8
    //   154: invokevirtual 423	android/content/pm/PackageManager:getInstallerPackageName	(Ljava/lang/String;)Ljava/lang/String;
    //   157: invokevirtual 426	com/mobileapptracker/Parameters:setInstaller	(Ljava/lang/String;)V
    //   160: aload_0
    //   161: getstatic 431	android/os/Build:MODEL	Ljava/lang/String;
    //   164: invokevirtual 434	com/mobileapptracker/Parameters:setDeviceModel	(Ljava/lang/String;)V
    //   167: aload_0
    //   168: getstatic 437	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   171: invokevirtual 440	com/mobileapptracker/Parameters:setDeviceBrand	(Ljava/lang/String;)V
    //   174: aload_0
    //   175: ldc_w 442
    //   178: invokestatic 447	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   181: invokevirtual 450	com/mobileapptracker/Parameters:setDeviceCpuType	(Ljava/lang/String;)V
    //   184: aload_0
    //   185: getstatic 455	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   188: invokevirtual 458	com/mobileapptracker/Parameters:setOsVersion	(Ljava/lang/String;)V
    //   191: aload_0
    //   192: aload_1
    //   193: invokevirtual 462	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   196: invokevirtual 468	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   199: getfield 473	android/util/DisplayMetrics:density	F
    //   202: invokestatic 478	java/lang/Float:toString	(F)Ljava/lang/String;
    //   205: invokevirtual 481	com/mobileapptracker/Parameters:setScreenDensity	(Ljava/lang/String;)V
    //   208: aload_1
    //   209: ldc_w 483
    //   212: invokevirtual 487	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   215: checkcast 489	android/view/WindowManager
    //   218: astore 12
    //   220: getstatic 492	android/os/Build$VERSION:SDK_INT	I
    //   223: bipush 13
    //   225: if_icmplt +258 -> 483
    //   228: new 494	android/graphics/Point
    //   231: dup
    //   232: invokespecial 495	android/graphics/Point:<init>	()V
    //   235: astore 13
    //   237: aload 12
    //   239: invokeinterface 499 1 0
    //   244: aload 13
    //   246: invokevirtual 505	android/view/Display:getSize	(Landroid/graphics/Point;)V
    //   249: aload 13
    //   251: getfield 507	android/graphics/Point:x	I
    //   254: istore 14
    //   256: aload 13
    //   258: getfield 509	android/graphics/Point:y	I
    //   261: istore 15
    //   263: aload_0
    //   264: iload 14
    //   266: invokestatic 416	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   269: invokevirtual 512	com/mobileapptracker/Parameters:setScreenWidth	(Ljava/lang/String;)V
    //   272: aload_0
    //   273: iload 15
    //   275: invokestatic 416	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   278: invokevirtual 515	com/mobileapptracker/Parameters:setScreenHeight	(Ljava/lang/String;)V
    //   281: aload_0
    //   282: getfield 272	com/mobileapptracker/Parameters:a	Landroid/content/Context;
    //   285: ldc_w 517
    //   288: invokevirtual 487	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   291: checkcast 519	android/net/ConnectivityManager
    //   294: iconst_1
    //   295: invokevirtual 523	android/net/ConnectivityManager:getNetworkInfo	(I)Landroid/net/NetworkInfo;
    //   298: invokevirtual 528	android/net/NetworkInfo:isConnected	()Z
    //   301: ifeq +209 -> 510
    //   304: aload_0
    //   305: ldc_w 530
    //   308: invokevirtual 533	com/mobileapptracker/Parameters:setConnectionType	(Ljava/lang/String;)V
    //   311: aload_0
    //   312: invokestatic 539	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   315: getstatic 543	java/util/Locale:US	Ljava/util/Locale;
    //   318: invokevirtual 547	java/util/Locale:getDisplayLanguage	(Ljava/util/Locale;)Ljava/lang/String;
    //   321: invokevirtual 550	com/mobileapptracker/Parameters:setLanguage	(Ljava/lang/String;)V
    //   324: aload_0
    //   325: getfield 272	com/mobileapptracker/Parameters:a	Landroid/content/Context;
    //   328: ldc_w 552
    //   331: invokevirtual 487	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   334: checkcast 554	android/telephony/TelephonyManager
    //   337: astore 16
    //   339: aload 16
    //   341: ifnull +184 -> 525
    //   344: aload 16
    //   346: invokevirtual 557	android/telephony/TelephonyManager:getNetworkCountryIso	()Ljava/lang/String;
    //   349: ifnull +12 -> 361
    //   352: aload_0
    //   353: aload 16
    //   355: invokevirtual 557	android/telephony/TelephonyManager:getNetworkCountryIso	()Ljava/lang/String;
    //   358: invokevirtual 560	com/mobileapptracker/Parameters:setCountryCode	(Ljava/lang/String;)V
    //   361: aload_0
    //   362: aload 16
    //   364: invokevirtual 563	android/telephony/TelephonyManager:getNetworkOperatorName	()Ljava/lang/String;
    //   367: invokevirtual 566	com/mobileapptracker/Parameters:setDeviceCarrier	(Ljava/lang/String;)V
    //   370: aload 16
    //   372: invokevirtual 569	android/telephony/TelephonyManager:getNetworkOperator	()Ljava/lang/String;
    //   375: astore 17
    //   377: aload 17
    //   379: ifnull +32 -> 411
    //   382: aload 17
    //   384: iconst_0
    //   385: iconst_3
    //   386: invokevirtual 573	java/lang/String:substring	(II)Ljava/lang/String;
    //   389: astore 20
    //   391: aload 17
    //   393: iconst_3
    //   394: invokevirtual 575	java/lang/String:substring	(I)Ljava/lang/String;
    //   397: astore 21
    //   399: aload_0
    //   400: aload 20
    //   402: invokevirtual 578	com/mobileapptracker/Parameters:setMCC	(Ljava/lang/String;)V
    //   405: aload_0
    //   406: aload 21
    //   408: invokevirtual 581	com/mobileapptracker/Parameters:setMNC	(Ljava/lang/String;)V
    //   411: aload_0
    //   412: invokevirtual 584	com/mobileapptracker/Parameters:getMatId	()Ljava/lang/String;
    //   415: astore 18
    //   417: aload 18
    //   419: ifnull +11 -> 430
    //   422: aload 18
    //   424: invokevirtual 588	java/lang/String:length	()I
    //   427: ifne +13 -> 440
    //   430: aload_0
    //   431: invokestatic 594	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   434: invokevirtual 595	java/util/UUID:toString	()Ljava/lang/String;
    //   437: invokevirtual 598	com/mobileapptracker/Parameters:setMatId	(Ljava/lang/String;)V
    //   440: iconst_1
    //   441: istore 6
    //   443: aload_0
    //   444: monitorexit
    //   445: iload 6
    //   447: ireturn
    //   448: astore 11
    //   450: aload_0
    //   451: ldc_w 600
    //   454: invokevirtual 419	com/mobileapptracker/Parameters:setAppVersion	(Ljava/lang/String;)V
    //   457: goto -308 -> 149
    //   460: astore 4
    //   462: ldc_w 602
    //   465: ldc_w 604
    //   468: invokestatic 609	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   471: pop
    //   472: aload 4
    //   474: invokevirtual 612	java/lang/Exception:printStackTrace	()V
    //   477: iconst_0
    //   478: istore 6
    //   480: goto -37 -> 443
    //   483: aload 12
    //   485: invokeinterface 499 1 0
    //   490: invokevirtual 615	android/view/Display:getWidth	()I
    //   493: istore 14
    //   495: aload 12
    //   497: invokeinterface 499 1 0
    //   502: invokevirtual 618	android/view/Display:getHeight	()I
    //   505: istore 15
    //   507: goto -244 -> 263
    //   510: aload_0
    //   511: ldc_w 620
    //   514: invokevirtual 533	com/mobileapptracker/Parameters:setConnectionType	(Ljava/lang/String;)V
    //   517: goto -206 -> 311
    //   520: astore_3
    //   521: aload_0
    //   522: monitorexit
    //   523: aload_3
    //   524: athrow
    //   525: aload_0
    //   526: invokestatic 539	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   529: invokevirtual 623	java/util/Locale:getCountry	()Ljava/lang/String;
    //   532: invokevirtual 560	com/mobileapptracker/Parameters:setCountryCode	(Ljava/lang/String;)V
    //   535: goto -124 -> 411
    //   538: astore 19
    //   540: goto -129 -> 411
    //   543: astore 10
    //   545: goto -414 -> 131
    //
    // Exception table:
    //   from	to	target	type
    //   131	149	448	android/content/pm/PackageManager$NameNotFoundException
    //   2	67	460	java/lang/Exception
    //   67	131	460	java/lang/Exception
    //   131	149	460	java/lang/Exception
    //   149	263	460	java/lang/Exception
    //   263	311	460	java/lang/Exception
    //   311	339	460	java/lang/Exception
    //   344	361	460	java/lang/Exception
    //   361	377	460	java/lang/Exception
    //   382	411	460	java/lang/Exception
    //   411	417	460	java/lang/Exception
    //   422	430	460	java/lang/Exception
    //   430	440	460	java/lang/Exception
    //   450	457	460	java/lang/Exception
    //   483	507	460	java/lang/Exception
    //   510	517	460	java/lang/Exception
    //   525	535	460	java/lang/Exception
    //   2	67	520	finally
    //   67	131	520	finally
    //   131	149	520	finally
    //   149	263	520	finally
    //   263	311	520	finally
    //   311	339	520	finally
    //   344	361	520	finally
    //   361	377	520	finally
    //   382	411	520	finally
    //   411	417	520	finally
    //   422	430	520	finally
    //   430	440	520	finally
    //   450	457	520	finally
    //   462	477	520	finally
    //   483	507	520	finally
    //   510	517	520	finally
    //   525	535	520	finally
    //   382	411	538	java/lang/IndexOutOfBoundsException
    //   67	131	543	android/content/pm/PackageManager$NameNotFoundException
  }

  public static Parameters getInstance()
  {
    return b;
  }

  public static void init(Context paramContext, String paramString1, String paramString2)
  {
    if (b == null)
    {
      Parameters localParameters = new Parameters();
      b = localParameters;
      localParameters.a = paramContext;
      b.a(paramContext, paramString1);
    }
  }

  public void clear()
  {
    b = null;
  }

  public String getAction()
  {
    try
    {
      String str = this.c;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getAdvertiserId()
  {
    try
    {
      String str = this.d;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getAdvertiserSubAd()
  {
    try
    {
      String str = this.av;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getAdvertiserSubAdgroup()
  {
    try
    {
      String str = this.au;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getAdvertiserSubCampaign()
  {
    try
    {
      String str = this.at;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getAdvertiserSubKeyword()
  {
    try
    {
      String str = this.aw;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getAdvertiserSubPublisher()
  {
    try
    {
      String str = this.ar;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getAdvertiserSubSite()
  {
    try
    {
      String str = this.as;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getAge()
  {
    try
    {
      String str = this.e;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getAllowDuplicates()
  {
    try
    {
      String str = this.f;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getAltitude()
  {
    try
    {
      String str = this.g;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getAndroidId()
  {
    try
    {
      String str = this.h;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getAppAdTrackingEnabled()
  {
    try
    {
      String str = this.i;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getAppName()
  {
    try
    {
      String str = this.j;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getAppVersion()
  {
    try
    {
      String str = this.k;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getConnectionType()
  {
    try
    {
      String str = this.l;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getCountryCode()
  {
    try
    {
      String str = this.m;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getCurrencyCode()
  {
    try
    {
      String str = this.n;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getDeviceBrand()
  {
    try
    {
      String str = this.o;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getDeviceCarrier()
  {
    try
    {
      String str = this.p;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getDeviceCpuSubtype()
  {
    try
    {
      String str = this.r;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getDeviceCpuType()
  {
    try
    {
      String str = this.q;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getDeviceId()
  {
    try
    {
      String str = this.s;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getDeviceModel()
  {
    try
    {
      String str = this.t;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getEventAttribute1()
  {
    try
    {
      String str = this.u;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getEventAttribute2()
  {
    try
    {
      String str = this.v;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getEventAttribute3()
  {
    try
    {
      String str = this.w;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getEventAttribute4()
  {
    try
    {
      String str = this.x;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getEventAttribute5()
  {
    try
    {
      String str = this.y;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getEventContentId()
  {
    try
    {
      String str = this.z;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getEventContentType()
  {
    try
    {
      String str = this.A;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getEventDate1()
  {
    try
    {
      String str = this.B;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getEventDate2()
  {
    try
    {
      String str = this.C;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getEventId()
  {
    try
    {
      String str = this.D;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getEventLevel()
  {
    try
    {
      String str = this.E;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getEventName()
  {
    try
    {
      String str = this.F;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getEventQuantity()
  {
    try
    {
      String str = this.G;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getEventRating()
  {
    try
    {
      String str = this.H;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getEventSearchString()
  {
    try
    {
      String str = this.I;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getExistingUser()
  {
    try
    {
      String str = this.J;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getFacebookUserId()
  {
    try
    {
      String str = this.K;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getGender()
  {
    try
    {
      String str = this.L;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getGoogleAdTrackingLimited()
  {
    try
    {
      String str = this.N;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getGoogleAdvertisingId()
  {
    try
    {
      String str = this.M;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getGoogleUserId()
  {
    try
    {
      String str = this.O;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getInstallDate()
  {
    try
    {
      String str = this.P;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getInstallLogId()
  {
    try
    {
      String str = a("mat_log_id_install", "logId");
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getInstallReferrer()
  {
    try
    {
      String str = a("mat_referrer", "referrer");
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getInstaller()
  {
    try
    {
      String str = this.Q;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getIsPayingUser()
  {
    try
    {
      String str = a("mat_is_paying_user", "mat_is_paying_user");
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getLanguage()
  {
    try
    {
      String str = this.R;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getLastOpenLogId()
  {
    try
    {
      String str = a("mat_log_id_last_open", "logId");
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getLatitude()
  {
    try
    {
      String str = this.S;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public Location getLocation()
  {
    try
    {
      Location localLocation = this.T;
      return localLocation;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getLongitude()
  {
    try
    {
      String str = this.U;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getMCC()
  {
    try
    {
      String str = this.W;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getMNC()
  {
    try
    {
      String str = this.X;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getMacAddress()
  {
    try
    {
      String str = this.V;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getMatId()
  {
    try
    {
      String str = a("mat_id", "mat_id");
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getOfferId()
  {
    try
    {
      String str = this.ao;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getOpenLogId()
  {
    try
    {
      String str = a("mat_log_id_open", "logId");
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getOsVersion()
  {
    try
    {
      String str = this.Y;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getPackageName()
  {
    try
    {
      String str = this.Z;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getPluginName()
  {
    try
    {
      String str = this.aa;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getPublisherId()
  {
    try
    {
      String str = this.ap;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getPublisherReferenceId()
  {
    try
    {
      String str = this.aq;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getPublisherSub1()
  {
    try
    {
      String str = this.aD;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getPublisherSub2()
  {
    try
    {
      String str = this.aE;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getPublisherSub3()
  {
    try
    {
      String str = this.aF;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getPublisherSub4()
  {
    try
    {
      String str = this.aG;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getPublisherSub5()
  {
    try
    {
      String str = this.aH;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getPublisherSubAd()
  {
    try
    {
      String str = this.aB;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getPublisherSubAdgroup()
  {
    try
    {
      String str = this.aA;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getPublisherSubCampaign()
  {
    try
    {
      String str = this.az;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getPublisherSubKeyword()
  {
    try
    {
      String str = this.aC;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getPublisherSubPublisher()
  {
    try
    {
      String str = this.ax;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getPublisherSubSite()
  {
    try
    {
      String str = this.ay;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getPurchaseStatus()
  {
    try
    {
      String str = this.ab;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getRefId()
  {
    try
    {
      String str = this.ae;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getReferralSource()
  {
    try
    {
      String str = this.ac;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getReferralUrl()
  {
    try
    {
      String str = this.ad;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getRevenue()
  {
    try
    {
      String str = this.af;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getScreenDensity()
  {
    try
    {
      String str = this.ag;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getScreenHeight()
  {
    try
    {
      String str = this.ah;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getScreenWidth()
  {
    try
    {
      String str = this.ai;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getSdkVersion()
  {
    return "3.3";
  }

  public String getSiteId()
  {
    try
    {
      String str = this.aj;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getTRUSTeId()
  {
    try
    {
      String str = this.al;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getTrackingId()
  {
    try
    {
      String str = this.ak;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getTwitterUserId()
  {
    try
    {
      String str = this.am;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getUpdateLogId()
  {
    try
    {
      String str = a("mat_log_id_update", "logId");
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getUserAgent()
  {
    try
    {
      String str = this.an;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getUserEmail()
  {
    try
    {
      String str = a("mat_user_ids", "user_email");
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getUserId()
  {
    try
    {
      String str = a("mat_user_ids", "user_id");
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getUserName()
  {
    try
    {
      String str = a("mat_user_ids", "user_name");
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void resetAfterRequest()
  {
    try
    {
      setEventId(null);
      setEventName(null);
      setRevenue(null);
      setCurrencyCode("USD");
      setRefId(null);
      setEventContentType(null);
      setEventContentId(null);
      setEventLevel(null);
      setEventQuantity(null);
      setEventSearchString(null);
      setEventRating(null);
      setEventDate1(null);
      setEventDate2(null);
      setEventAttribute1(null);
      setEventAttribute2(null);
      setEventAttribute3(null);
      setEventAttribute4(null);
      setEventAttribute5(null);
      setPublisherId(null);
      setOfferId(null);
      setPublisherReferenceId(null);
      setPublisherSub1(null);
      setPublisherSub2(null);
      setPublisherSub3(null);
      setPublisherSub4(null);
      setPublisherSub5(null);
      setPublisherSubAd(null);
      setPublisherSubAdgroup(null);
      setPublisherSubCampaign(null);
      setPublisherSubKeyword(null);
      setPublisherSubPublisher(null);
      setPublisherSubSite(null);
      setAdvertiserSubAd(null);
      setAdvertiserSubAdgroup(null);
      setAdvertiserSubCampaign(null);
      setAdvertiserSubKeyword(null);
      setAdvertiserSubPublisher(null);
      setAdvertiserSubSite(null);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setAction(String paramString)
  {
    try
    {
      this.c = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setAdvertiserId(String paramString)
  {
    try
    {
      this.d = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setAdvertiserSubAd(String paramString)
  {
    try
    {
      this.av = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setAdvertiserSubAdgroup(String paramString)
  {
    try
    {
      this.au = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setAdvertiserSubCampaign(String paramString)
  {
    try
    {
      this.at = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setAdvertiserSubKeyword(String paramString)
  {
    try
    {
      this.aw = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setAdvertiserSubPublisher(String paramString)
  {
    try
    {
      this.ar = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setAdvertiserSubSite(String paramString)
  {
    try
    {
      this.as = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setAge(String paramString)
  {
    try
    {
      this.e = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setAllowDuplicates(String paramString)
  {
    try
    {
      this.f = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setAltitude(String paramString)
  {
    try
    {
      this.g = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setAndroidId(String paramString)
  {
    try
    {
      this.h = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setAppAdTrackingEnabled(String paramString)
  {
    try
    {
      this.i = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setAppName(String paramString)
  {
    try
    {
      this.j = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setAppVersion(String paramString)
  {
    try
    {
      this.k = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setConnectionType(String paramString)
  {
    try
    {
      this.l = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setCountryCode(String paramString)
  {
    try
    {
      this.m = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setCurrencyCode(String paramString)
  {
    try
    {
      this.n = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setDeviceBrand(String paramString)
  {
    try
    {
      this.o = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setDeviceCarrier(String paramString)
  {
    try
    {
      this.p = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setDeviceCpuSubtype(String paramString)
  {
    try
    {
      this.r = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setDeviceCpuType(String paramString)
  {
    try
    {
      this.q = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setDeviceId(String paramString)
  {
    try
    {
      this.s = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setDeviceModel(String paramString)
  {
    try
    {
      this.t = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setEventAttribute1(String paramString)
  {
    try
    {
      this.u = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setEventAttribute2(String paramString)
  {
    try
    {
      this.v = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setEventAttribute3(String paramString)
  {
    try
    {
      this.w = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setEventAttribute4(String paramString)
  {
    try
    {
      this.x = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setEventAttribute5(String paramString)
  {
    try
    {
      this.y = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setEventContentId(String paramString)
  {
    try
    {
      this.z = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setEventContentType(String paramString)
  {
    try
    {
      this.A = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setEventDate1(String paramString)
  {
    try
    {
      this.B = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setEventDate2(String paramString)
  {
    try
    {
      this.C = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setEventId(String paramString)
  {
    try
    {
      this.D = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setEventLevel(String paramString)
  {
    try
    {
      this.E = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setEventName(String paramString)
  {
    try
    {
      this.F = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setEventQuantity(String paramString)
  {
    try
    {
      this.G = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setEventRating(String paramString)
  {
    try
    {
      this.H = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setEventSearchString(String paramString)
  {
    try
    {
      this.I = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setExistingUser(String paramString)
  {
    try
    {
      this.J = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setFacebookUserId(String paramString)
  {
    try
    {
      this.K = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setGender(String paramString)
  {
    try
    {
      this.L = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setGoogleAdTrackingLimited(String paramString)
  {
    try
    {
      this.N = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setGoogleAdvertisingId(String paramString)
  {
    try
    {
      this.M = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setGoogleUserId(String paramString)
  {
    try
    {
      this.O = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setInstallDate(String paramString)
  {
    try
    {
      this.P = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setInstallReferrer(String paramString)
  {
    try
    {
      a("mat_referrer", "referrer", paramString);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setInstaller(String paramString)
  {
    try
    {
      this.Q = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setIsPayingUser(String paramString)
  {
    try
    {
      a("mat_is_paying_user", "mat_is_paying_user", paramString);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setLanguage(String paramString)
  {
    try
    {
      this.R = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setLastOpenLogId(String paramString)
  {
    try
    {
      a("mat_log_id_last_open", "logId", paramString);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setLatitude(String paramString)
  {
    try
    {
      this.S = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setLocation(Location paramLocation)
  {
    try
    {
      this.T = paramLocation;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setLongitude(String paramString)
  {
    try
    {
      this.U = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setMCC(String paramString)
  {
    try
    {
      this.W = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setMNC(String paramString)
  {
    try
    {
      this.X = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setMacAddress(String paramString)
  {
    try
    {
      this.V = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setMatId(String paramString)
  {
    try
    {
      a("mat_id", "mat_id", paramString);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setOfferId(String paramString)
  {
    try
    {
      this.ao = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setOpenLogId(String paramString)
  {
    try
    {
      a("mat_log_id_open", "logId", paramString);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setOsVersion(String paramString)
  {
    try
    {
      this.Y = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setPackageName(String paramString)
  {
    try
    {
      this.Z = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setPluginName(String paramString)
  {
    try
    {
      this.aa = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setPublisherId(String paramString)
  {
    try
    {
      this.ap = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setPublisherReferenceId(String paramString)
  {
    try
    {
      this.aq = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setPublisherSub1(String paramString)
  {
    try
    {
      this.aD = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setPublisherSub2(String paramString)
  {
    try
    {
      this.aE = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setPublisherSub3(String paramString)
  {
    try
    {
      this.aF = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setPublisherSub4(String paramString)
  {
    try
    {
      this.aG = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setPublisherSub5(String paramString)
  {
    try
    {
      this.aH = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setPublisherSubAd(String paramString)
  {
    try
    {
      this.aB = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setPublisherSubAdgroup(String paramString)
  {
    try
    {
      this.aA = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setPublisherSubCampaign(String paramString)
  {
    try
    {
      this.az = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setPublisherSubKeyword(String paramString)
  {
    try
    {
      this.aC = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setPublisherSubPublisher(String paramString)
  {
    try
    {
      this.ax = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setPublisherSubSite(String paramString)
  {
    try
    {
      this.ay = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setPurchaseStatus(String paramString)
  {
    try
    {
      this.ab = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setRefId(String paramString)
  {
    try
    {
      this.ae = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setReferralSource(String paramString)
  {
    try
    {
      this.ac = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setReferralUrl(String paramString)
  {
    try
    {
      this.ad = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setRevenue(String paramString)
  {
    try
    {
      this.af = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setScreenDensity(String paramString)
  {
    try
    {
      this.ag = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setScreenHeight(String paramString)
  {
    try
    {
      this.ah = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setScreenWidth(String paramString)
  {
    try
    {
      this.ai = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setSiteId(String paramString)
  {
    try
    {
      this.aj = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setTRUSTeId(String paramString)
  {
    try
    {
      this.al = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setTrackingId(String paramString)
  {
    try
    {
      this.ak = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setTwitterUserId(String paramString)
  {
    try
    {
      this.am = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setUserEmail(String paramString)
  {
    try
    {
      a("mat_user_ids", "user_email", paramString);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setUserId(String paramString)
  {
    try
    {
      a("mat_user_ids", "user_id", paramString);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setUserName(String paramString)
  {
    try
    {
      a("mat_user_ids", "user_name", paramString);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.mobileapptracker.Parameters
 * JD-Core Version:    0.6.2
 */