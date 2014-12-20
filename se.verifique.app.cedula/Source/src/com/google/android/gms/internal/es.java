package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import org.json.JSONException;

public class es extends gr
  implements fc, ho
{
  private final bv a;
  private final er b;
  private final hk c;
  private final Object d = new Object();
  private final Context e;
  private final Object f = new Object();
  private final fl g;
  private final mw h;
  private gr i;
  private du j;
  private boolean k = false;
  private bj l;
  private bm m;
  private br n;

  public es(Context paramContext, fl paramfl, mw parammw, hk paramhk, bv parambv, er paramer)
  {
    this.a = parambv;
    this.b = paramer;
    this.c = paramhk;
    this.e = paramContext;
    this.g = paramfl;
    this.h = parammw;
  }

  private al a(ds paramds)
  {
    if (this.j.n == null)
      throw new ey("The ad response must specify one of the supported ad sizes.", 0);
    String[] arrayOfString = this.j.n.split("x");
    if (arrayOfString.length != 2)
      throw new ey("Could not parse the ad size from the ad response: " + this.j.n, 0);
    while (true)
    {
      int i4;
      al localal;
      try
      {
        int i1 = Integer.parseInt(arrayOfString[0]);
        int i2 = Integer.parseInt(arrayOfString[1]);
        al[] arrayOfal = paramds.e.i;
        int i3 = arrayOfal.length;
        i4 = 0;
        if (i4 >= i3)
          break;
        localal = arrayOfal[i4];
        float f1 = this.e.getResources().getDisplayMetrics().density;
        if (localal.g == -1)
        {
          i5 = (int)(localal.h / f1);
          if (localal.d != -2)
            break label256;
          i6 = (int)(localal.e / f1);
          if ((i1 != i5) || (i2 != i6))
            break label266;
          return new al(localal, paramds.e.i);
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new ey("Could not parse the ad size from the ad response: " + this.j.n, 0);
      }
      int i5 = localal.g;
      continue;
      label256: int i6 = localal.d;
      continue;
      label266: i4++;
    }
    throw new ey("The ad size from the ad response was not one of the requested sizes: " + this.j.n, 0);
  }

  private void a(ds paramds, long paramLong)
  {
    synchronized (this.d)
    {
      this.l = new bj(this.e, paramds, this.a, this.m);
      this.n = this.l.a(paramLong, 60000L);
      switch (this.n.a)
      {
      default:
        throw new ey("Unexpected mediation result: " + this.n.a, 0);
      case 1:
      case 0:
      }
    }
    throw new ey("No fill from any mediation ad networks.", 3);
  }

  private void b(long paramLong)
  {
    hh.a.post(new ew(this));
    d(paramLong);
  }

  private void c()
  {
    if (this.j.f == -3);
    while (true)
    {
      return;
      if (TextUtils.isEmpty(this.j.d))
        throw new ey("No fill from ad server.", 3);
      if (!this.j.i)
        continue;
      try
      {
        this.m = new bm(this.j.d);
      }
      catch (JSONException localJSONException)
      {
      }
    }
    throw new ey("Could not parse mediation config: " + this.j.d, 0);
  }

  private void c(long paramLong)
  {
    do
    {
      if (e(paramLong))
        continue;
      throw new ey("Timed out waiting for ad response.", 2);
    }
    while (this.j == null);
    synchronized (this.d)
    {
      this.i = null;
      if ((this.j.f != -2) && (this.j.f != -3))
        throw new ey("There was a problem getting an ad response. ErrorCode: " + this.j.f, this.j.f);
    }
  }

  private void d(long paramLong)
  {
    do
    {
      if (e(paramLong))
        continue;
      throw new ey("Timed out waiting for WebView to finish loading.", 2);
    }
    while (!this.k);
  }

  private boolean e(long paramLong)
  {
    long l1 = 60000L - (SystemClock.elapsedRealtime() - paramLong);
    int i1;
    if (l1 <= 0L)
      i1 = 0;
    while (true)
    {
      return i1;
      try
      {
        this.f.wait(l1);
        i1 = 1;
      }
      catch (InterruptedException localInterruptedException)
      {
      }
    }
    throw new ey("Ad request cancelled.", -1);
  }

  // ERROR //
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 47	com/google/android/gms/internal/es:f	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: ldc 249
    //   9: invokestatic 253	com/google/android/gms/internal/hi:a	(Ljava/lang/String;)V
    //   12: aload_0
    //   13: getfield 61	com/google/android/gms/internal/es:h	Lcom/google/android/gms/internal/mw;
    //   16: invokevirtual 258	com/google/android/gms/internal/mw:a	()Lcom/google/android/gms/internal/jd;
    //   19: astore_3
    //   20: aload_3
    //   21: aload_0
    //   22: getfield 57	com/google/android/gms/internal/es:e	Landroid/content/Context;
    //   25: invokeinterface 263 2 0
    //   30: astore 4
    //   32: aload_3
    //   33: aload_0
    //   34: getfield 57	com/google/android/gms/internal/es:e	Landroid/content/Context;
    //   37: invokeinterface 265 2 0
    //   42: astore 5
    //   44: new 107	com/google/android/gms/internal/ds
    //   47: dup
    //   48: aload_0
    //   49: getfield 59	com/google/android/gms/internal/es:g	Lcom/google/android/gms/internal/fl;
    //   52: aload 4
    //   54: aload 5
    //   56: invokespecial 268	com/google/android/gms/internal/ds:<init>	(Lcom/google/android/gms/internal/fl;Ljava/lang/String;Ljava/lang/String;)V
    //   59: astore 6
    //   61: aconst_null
    //   62: astore 7
    //   64: bipush 254
    //   66: istore 8
    //   68: ldc2_w 269
    //   71: lstore 9
    //   73: invokestatic 240	android/os/SystemClock:elapsedRealtime	()J
    //   76: lstore 37
    //   78: aload_0
    //   79: getfield 57	com/google/android/gms/internal/es:e	Landroid/content/Context;
    //   82: aload 6
    //   84: aload_0
    //   85: invokestatic 275	com/google/android/gms/internal/fb:a	(Landroid/content/Context;Lcom/google/android/gms/internal/ds;Lcom/google/android/gms/internal/fc;)Lcom/google/android/gms/internal/gr;
    //   88: astore 39
    //   90: aload_0
    //   91: getfield 45	com/google/android/gms/internal/es:d	Ljava/lang/Object;
    //   94: astore 40
    //   96: aload 40
    //   98: monitorenter
    //   99: aload_0
    //   100: aload 39
    //   102: putfield 227	com/google/android/gms/internal/es:i	Lcom/google/android/gms/internal/gr;
    //   105: aload_0
    //   106: getfield 227	com/google/android/gms/internal/es:i	Lcom/google/android/gms/internal/gr;
    //   109: ifnonnull +370 -> 479
    //   112: new 73	com/google/android/gms/internal/ey
    //   115: dup
    //   116: ldc_w 277
    //   119: iconst_0
    //   120: invokespecial 78	com/google/android/gms/internal/ey:<init>	(Ljava/lang/String;I)V
    //   123: athrow
    //   124: astore 41
    //   126: aload 40
    //   128: monitorexit
    //   129: aload 41
    //   131: athrow
    //   132: astore 11
    //   134: aload 11
    //   136: invokevirtual 280	com/google/android/gms/internal/ey:a	()I
    //   139: istore 8
    //   141: iload 8
    //   143: iconst_3
    //   144: if_icmpeq +10 -> 154
    //   147: iload 8
    //   149: bipush 255
    //   151: if_icmpne +419 -> 570
    //   154: aload 11
    //   156: invokevirtual 283	com/google/android/gms/internal/ey:getMessage	()Ljava/lang/String;
    //   159: invokestatic 285	com/google/android/gms/internal/hi:c	(Ljava/lang/String;)V
    //   162: aload_0
    //   163: getfield 66	com/google/android/gms/internal/es:j	Lcom/google/android/gms/internal/du;
    //   166: ifnonnull +415 -> 581
    //   169: aload_0
    //   170: new 68	com/google/android/gms/internal/du
    //   173: dup
    //   174: iload 8
    //   176: invokespecial 288	com/google/android/gms/internal/du:<init>	(I)V
    //   179: putfield 66	com/google/android/gms/internal/es:j	Lcom/google/android/gms/internal/du;
    //   182: getstatic 183	com/google/android/gms/internal/hh:a	Landroid/os/Handler;
    //   185: new 290	com/google/android/gms/internal/et
    //   188: dup
    //   189: aload_0
    //   190: invokespecial 291	com/google/android/gms/internal/et:<init>	(Lcom/google/android/gms/internal/es;)V
    //   193: invokevirtual 194	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   196: pop
    //   197: lload 9
    //   199: lstore 13
    //   201: aload 7
    //   203: astore 15
    //   205: aload_0
    //   206: getfield 66	com/google/android/gms/internal/es:j	Lcom/google/android/gms/internal/du;
    //   209: getfield 294	com/google/android/gms/internal/du:s	Ljava/lang/String;
    //   212: invokestatic 209	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   215: istore 16
    //   217: iload 16
    //   219: ifne +395 -> 614
    //   222: aload_0
    //   223: getfield 66	com/google/android/gms/internal/es:j	Lcom/google/android/gms/internal/du;
    //   226: getfield 294	com/google/android/gms/internal/du:s	Ljava/lang/String;
    //   229: astore 36
    //   231: new 296	org/json/JSONObject
    //   234: dup
    //   235: aload 36
    //   237: invokespecial 297	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   240: astore 17
    //   242: aload 6
    //   244: getfield 300	com/google/android/gms/internal/ds:d	Lcom/google/android/gms/internal/ai;
    //   247: astore 18
    //   249: aload_0
    //   250: getfield 55	com/google/android/gms/internal/es:c	Lcom/google/android/gms/internal/hk;
    //   253: astore 19
    //   255: aload_0
    //   256: getfield 66	com/google/android/gms/internal/es:j	Lcom/google/android/gms/internal/du;
    //   259: getfield 303	com/google/android/gms/internal/du:e	Ljava/util/List;
    //   262: astore 20
    //   264: aload_0
    //   265: getfield 66	com/google/android/gms/internal/es:j	Lcom/google/android/gms/internal/du;
    //   268: getfield 305	com/google/android/gms/internal/du:g	Ljava/util/List;
    //   271: astore 21
    //   273: aload_0
    //   274: getfield 66	com/google/android/gms/internal/es:j	Lcom/google/android/gms/internal/du;
    //   277: getfield 307	com/google/android/gms/internal/du:k	Ljava/util/List;
    //   280: astore 22
    //   282: aload_0
    //   283: getfield 66	com/google/android/gms/internal/es:j	Lcom/google/android/gms/internal/du;
    //   286: getfield 309	com/google/android/gms/internal/du:m	I
    //   289: istore 23
    //   291: aload_0
    //   292: getfield 66	com/google/android/gms/internal/es:j	Lcom/google/android/gms/internal/du;
    //   295: getfield 312	com/google/android/gms/internal/du:l	J
    //   298: lstore 24
    //   300: aload 6
    //   302: getfield 314	com/google/android/gms/internal/ds:j	Ljava/lang/String;
    //   305: astore 26
    //   307: aload_0
    //   308: getfield 66	com/google/android/gms/internal/es:j	Lcom/google/android/gms/internal/du;
    //   311: getfield 213	com/google/android/gms/internal/du:i	Z
    //   314: istore 27
    //   316: aload_0
    //   317: getfield 165	com/google/android/gms/internal/es:n	Lcom/google/android/gms/internal/br;
    //   320: ifnull +300 -> 620
    //   323: aload_0
    //   324: getfield 165	com/google/android/gms/internal/es:n	Lcom/google/android/gms/internal/br;
    //   327: getfield 317	com/google/android/gms/internal/br:b	Lcom/google/android/gms/internal/bl;
    //   330: astore 28
    //   332: aload_0
    //   333: getfield 165	com/google/android/gms/internal/es:n	Lcom/google/android/gms/internal/br;
    //   336: ifnull +290 -> 626
    //   339: aload_0
    //   340: getfield 165	com/google/android/gms/internal/es:n	Lcom/google/android/gms/internal/br;
    //   343: getfield 320	com/google/android/gms/internal/br:c	Lcom/google/android/gms/internal/by;
    //   346: astore 29
    //   348: aload_0
    //   349: getfield 165	com/google/android/gms/internal/es:n	Lcom/google/android/gms/internal/br;
    //   352: ifnull +280 -> 632
    //   355: aload_0
    //   356: getfield 165	com/google/android/gms/internal/es:n	Lcom/google/android/gms/internal/br;
    //   359: getfield 321	com/google/android/gms/internal/br:d	Ljava/lang/String;
    //   362: astore 30
    //   364: aload_0
    //   365: getfield 153	com/google/android/gms/internal/es:m	Lcom/google/android/gms/internal/bm;
    //   368: astore 31
    //   370: aload_0
    //   371: getfield 165	com/google/android/gms/internal/es:n	Lcom/google/android/gms/internal/br;
    //   374: ifnull +264 -> 638
    //   377: aload_0
    //   378: getfield 165	com/google/android/gms/internal/es:n	Lcom/google/android/gms/internal/br;
    //   381: getfield 324	com/google/android/gms/internal/br:e	Lcom/google/android/gms/internal/bo;
    //   384: astore 32
    //   386: new 326	com/google/android/gms/internal/gi
    //   389: dup
    //   390: aload 18
    //   392: aload 19
    //   394: aload 20
    //   396: iload 8
    //   398: aload 21
    //   400: aload 22
    //   402: iload 23
    //   404: lload 24
    //   406: aload 26
    //   408: iload 27
    //   410: aload 28
    //   412: aload 29
    //   414: aload 30
    //   416: aload 31
    //   418: aload 32
    //   420: aload_0
    //   421: getfield 66	com/google/android/gms/internal/es:j	Lcom/google/android/gms/internal/du;
    //   424: getfield 328	com/google/android/gms/internal/du:j	J
    //   427: aload 15
    //   429: aload_0
    //   430: getfield 66	com/google/android/gms/internal/es:j	Lcom/google/android/gms/internal/du;
    //   433: getfield 330	com/google/android/gms/internal/du:h	J
    //   436: lload 13
    //   438: aload_0
    //   439: getfield 66	com/google/android/gms/internal/es:j	Lcom/google/android/gms/internal/du;
    //   442: getfield 333	com/google/android/gms/internal/du:o	J
    //   445: aload_0
    //   446: getfield 66	com/google/android/gms/internal/es:j	Lcom/google/android/gms/internal/du;
    //   449: getfield 336	com/google/android/gms/internal/du:p	Ljava/lang/String;
    //   452: aload 17
    //   454: invokespecial 339	com/google/android/gms/internal/gi:<init>	(Lcom/google/android/gms/internal/ai;Lcom/google/android/gms/internal/hk;Ljava/util/List;ILjava/util/List;Ljava/util/List;IJLjava/lang/String;ZLcom/google/android/gms/internal/bl;Lcom/google/android/gms/internal/by;Ljava/lang/String;Lcom/google/android/gms/internal/bm;Lcom/google/android/gms/internal/bo;JLcom/google/android/gms/internal/al;JJJLjava/lang/String;Lorg/json/JSONObject;)V
    //   457: astore 33
    //   459: getstatic 183	com/google/android/gms/internal/hh:a	Landroid/os/Handler;
    //   462: new 341	com/google/android/gms/internal/eu
    //   465: dup
    //   466: aload_0
    //   467: aload 33
    //   469: invokespecial 344	com/google/android/gms/internal/eu:<init>	(Lcom/google/android/gms/internal/es;Lcom/google/android/gms/internal/gi;)V
    //   472: invokevirtual 194	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   475: pop
    //   476: aload_1
    //   477: monitorexit
    //   478: return
    //   479: aload 40
    //   481: monitorexit
    //   482: aload_0
    //   483: lload 37
    //   485: invokespecial 346	com/google/android/gms/internal/es:c	(J)V
    //   488: invokestatic 240	android/os/SystemClock:elapsedRealtime	()J
    //   491: lstore 9
    //   493: aload_0
    //   494: invokespecial 348	com/google/android/gms/internal/es:c	()V
    //   497: aload 6
    //   499: getfield 110	com/google/android/gms/internal/ds:e	Lcom/google/android/gms/internal/al;
    //   502: getfield 115	com/google/android/gms/internal/al:i	[Lcom/google/android/gms/internal/al;
    //   505: ifnull +11 -> 516
    //   508: aload_0
    //   509: aload 6
    //   511: invokespecial 350	com/google/android/gms/internal/es:a	(Lcom/google/android/gms/internal/ds;)Lcom/google/android/gms/internal/al;
    //   514: astore 7
    //   516: aload_0
    //   517: getfield 66	com/google/android/gms/internal/es:j	Lcom/google/android/gms/internal/du;
    //   520: getfield 213	com/google/android/gms/internal/du:i	Z
    //   523: ifeq +14 -> 537
    //   526: aload_0
    //   527: aload 6
    //   529: lload 37
    //   531: invokespecial 352	com/google/android/gms/internal/es:a	(Lcom/google/android/gms/internal/ds;J)V
    //   534: goto +110 -> 644
    //   537: aload_0
    //   538: getfield 66	com/google/android/gms/internal/es:j	Lcom/google/android/gms/internal/du;
    //   541: getfield 355	com/google/android/gms/internal/du:q	Z
    //   544: ifeq +17 -> 561
    //   547: aload_0
    //   548: lload 37
    //   550: invokevirtual 357	com/google/android/gms/internal/es:a	(J)V
    //   553: goto +91 -> 644
    //   556: astore_2
    //   557: aload_1
    //   558: monitorexit
    //   559: aload_2
    //   560: athrow
    //   561: aload_0
    //   562: lload 37
    //   564: invokespecial 359	com/google/android/gms/internal/es:b	(J)V
    //   567: goto +77 -> 644
    //   570: aload 11
    //   572: invokevirtual 283	com/google/android/gms/internal/ey:getMessage	()Ljava/lang/String;
    //   575: invokestatic 361	com/google/android/gms/internal/hi:e	(Ljava/lang/String;)V
    //   578: goto -416 -> 162
    //   581: aload_0
    //   582: new 68	com/google/android/gms/internal/du
    //   585: dup
    //   586: iload 8
    //   588: aload_0
    //   589: getfield 66	com/google/android/gms/internal/es:j	Lcom/google/android/gms/internal/du;
    //   592: getfield 312	com/google/android/gms/internal/du:l	J
    //   595: invokespecial 364	com/google/android/gms/internal/du:<init>	(IJ)V
    //   598: putfield 66	com/google/android/gms/internal/es:j	Lcom/google/android/gms/internal/du;
    //   601: goto -419 -> 182
    //   604: astore 35
    //   606: ldc_w 366
    //   609: aload 35
    //   611: invokestatic 369	com/google/android/gms/internal/hi:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   614: aconst_null
    //   615: astore 17
    //   617: goto -375 -> 242
    //   620: aconst_null
    //   621: astore 28
    //   623: goto -291 -> 332
    //   626: aconst_null
    //   627: astore 29
    //   629: goto -281 -> 348
    //   632: aconst_null
    //   633: astore 30
    //   635: goto -271 -> 364
    //   638: aconst_null
    //   639: astore 32
    //   641: goto -255 -> 386
    //   644: lload 9
    //   646: lstore 13
    //   648: aload 7
    //   650: astore 15
    //   652: goto -447 -> 205
    //
    // Exception table:
    //   from	to	target	type
    //   99	129	124	finally
    //   479	482	124	finally
    //   73	99	132	com/google/android/gms/internal/ey
    //   129	132	132	com/google/android/gms/internal/ey
    //   482	553	132	com/google/android/gms/internal/ey
    //   561	567	132	com/google/android/gms/internal/ey
    //   7	61	556	finally
    //   73	99	556	finally
    //   129	132	556	finally
    //   134	217	556	finally
    //   222	242	556	finally
    //   242	478	556	finally
    //   482	553	556	finally
    //   557	559	556	finally
    //   561	567	556	finally
    //   570	614	556	finally
    //   222	242	604	java/lang/Exception
  }

  protected void a(long paramLong)
  {
    al localal = this.c.e();
    int i1;
    if (localal.f)
      i1 = this.e.getResources().getDisplayMetrics().widthPixels;
    ez localez;
    for (int i2 = this.e.getResources().getDisplayMetrics().heightPixels; ; i2 = localal.e)
    {
      localez = new ez(this, this.c, i1, i2);
      hh.a.post(new ex(this, localez));
      d(paramLong);
      if (!localez.c())
        break;
      hi.a("Ad-Network indicated no fill with passback URL.");
      throw new ey("AdNetwork sent passback url", 3);
      i1 = localal.h;
    }
    if (!localez.d())
      throw new ey("AdNetwork timed out", 2);
  }

  public void a(du paramdu)
  {
    synchronized (this.f)
    {
      hi.a("Received ad response.");
      this.j = paramdu;
      this.f.notify();
      return;
    }
  }

  public void a(hk paramhk)
  {
    synchronized (this.f)
    {
      hi.a("WebView finished loading.");
      this.k = true;
      this.f.notify();
      return;
    }
  }

  public void b()
  {
    synchronized (this.d)
    {
      if (this.i != null)
        this.i.f();
      this.c.stopLoading();
      gw.a(this.c);
      if (this.l != null)
        this.l.a();
      return;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.es
 * JD-Core Version:    0.6.0
 */