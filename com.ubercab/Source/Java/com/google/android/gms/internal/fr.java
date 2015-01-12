package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@ez
public final class fr extends fm.a
{
  private static final Object uf = new Object();
  private static fr ug;
  private final Context mContext;
  private final fx uh;
  private final ci ui;
  private final bm uj;

  fr(Context paramContext, bm parambm, ci paramci, fx paramfx)
  {
    this.mContext = paramContext;
    this.uh = paramfx;
    this.ui = paramci;
    this.uj = parambm;
  }

  private static gw.a I(String paramString)
  {
    return new gw.a()
    {
      public void a(gv paramAnonymousgv)
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = "AFMA_buildAdURL";
        arrayOfObject[1] = this.uo;
        String str = String.format("javascript:%s(%s);", arrayOfObject);
        gs.V("About to execute: " + str);
        paramAnonymousgv.loadUrl(str);
      }
    };
  }

  private static fk a(Context paramContext, bm parambm, ci paramci, fx paramfx, final fi paramfi)
  {
    gs.S("Starting ad request from service.");
    paramci.init();
    fw localfw = new fw(paramContext);
    if (localfw.vd == -1)
    {
      gs.S("Device is offline.");
      return new fk(2);
    }
    final ft localft = new ft(paramfi.applicationInfo.packageName);
    if (paramfi.tx.extras != null)
    {
      String str4 = paramfi.tx.extras.getString("_ad");
      if (str4 != null)
        return fs.a(paramContext, paramfi, str4);
    }
    Location localLocation = paramci.a(250L);
    final String str1 = parambm.bp();
    String str2 = fs.a(paramfi, localfw, localLocation, parambm.bq(), parambm.br());
    if (str2 == null)
      return new fk(0);
    final gw.a locala = I(str2);
    gr.wC.post(new Runnable()
    {
      public void run()
      {
        gv localgv = gv.a(this.mV, new ay(), false, false, null, paramfi.lD);
        localgv.setWillNotDraw(true);
        localft.b(localgv);
        gw localgw = localgv.du();
        localgw.a("/invalidRequest", localft.us);
        localgw.a("/loadAdURL", localft.ut);
        localgw.a("/log", bx.pG);
        localgw.a(locala);
        gs.S("Loading the JS library.");
        localgv.loadUrl(str1);
      }
    });
    fv localfv;
    try
    {
      localfv = (fv)localft.cK().get(10L, TimeUnit.SECONDS);
      if (localfv == null)
        return new fk(0);
    }
    catch (Exception localException)
    {
      return new fk(0);
    }
    if (localfv.getErrorCode() != -2)
      return new fk(localfv.getErrorCode());
    boolean bool = localfv.cN();
    String str3 = null;
    if (bool)
      str3 = paramfx.K(paramfi.ty.packageName);
    return a(paramContext, paramfi.lD.wD, localfv.getUrl(), str3, localfv);
  }

  // ERROR //
  public static fk a(Context paramContext, String paramString1, String paramString2, String paramString3, fv paramfv)
  {
    // Byte code:
    //   0: new 210	com/google/android/gms/internal/fu
    //   3: dup
    //   4: invokespecial 211	com/google/android/gms/internal/fu:<init>	()V
    //   7: astore 5
    //   9: new 213	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   16: ldc 216
    //   18: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_2
    //   22: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 54	com/google/android/gms/internal/gs:S	(Ljava/lang/String;)V
    //   31: new 225	java/net/URL
    //   34: dup
    //   35: aload_2
    //   36: invokespecial 226	java/net/URL:<init>	(Ljava/lang/String;)V
    //   39: astore 7
    //   41: invokestatic 232	android/os/SystemClock:elapsedRealtime	()J
    //   44: lstore 8
    //   46: aload 7
    //   48: astore 10
    //   50: iconst_0
    //   51: istore 11
    //   53: aload 10
    //   55: invokevirtual 236	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   58: checkcast 238	java/net/HttpURLConnection
    //   61: astore 12
    //   63: aload_0
    //   64: aload_1
    //   65: iconst_0
    //   66: aload 12
    //   68: invokestatic 243	com/google/android/gms/internal/gj:a	(Landroid/content/Context;Ljava/lang/String;ZLjava/net/HttpURLConnection;)V
    //   71: aload_3
    //   72: invokestatic 249	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   75: ifne +11 -> 86
    //   78: aload 12
    //   80: ldc 251
    //   82: aload_3
    //   83: invokevirtual 255	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: aload 4
    //   88: ifnull +64 -> 152
    //   91: aload 4
    //   93: invokevirtual 258	com/google/android/gms/internal/fv:cM	()Ljava/lang/String;
    //   96: invokestatic 249	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   99: ifne +53 -> 152
    //   102: aload 12
    //   104: iconst_1
    //   105: invokevirtual 262	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   108: aload 4
    //   110: invokevirtual 258	com/google/android/gms/internal/fv:cM	()Ljava/lang/String;
    //   113: invokevirtual 268	java/lang/String:getBytes	()[B
    //   116: astore 23
    //   118: aload 12
    //   120: aload 23
    //   122: arraylength
    //   123: invokevirtual 271	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   126: new 273	java/io/BufferedOutputStream
    //   129: dup
    //   130: aload 12
    //   132: invokevirtual 277	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   135: invokespecial 280	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   138: astore 24
    //   140: aload 24
    //   142: aload 23
    //   144: invokevirtual 284	java/io/BufferedOutputStream:write	([B)V
    //   147: aload 24
    //   149: invokevirtual 287	java/io/BufferedOutputStream:close	()V
    //   152: aload 12
    //   154: invokevirtual 290	java/net/HttpURLConnection:getResponseCode	()I
    //   157: istore 14
    //   159: aload 12
    //   161: invokevirtual 294	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   164: astore 15
    //   166: iload 14
    //   168: sipush 200
    //   171: if_icmplt +74 -> 245
    //   174: iload 14
    //   176: sipush 300
    //   179: if_icmpge +66 -> 245
    //   182: aload 10
    //   184: invokevirtual 295	java/net/URL:toString	()Ljava/lang/String;
    //   187: astore 20
    //   189: new 297	java/io/InputStreamReader
    //   192: dup
    //   193: aload 12
    //   195: invokevirtual 301	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   198: invokespecial 304	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   201: invokestatic 307	com/google/android/gms/internal/gj:a	(Ljava/lang/Readable;)Ljava/lang/String;
    //   204: astore 21
    //   206: aload 20
    //   208: aload 15
    //   210: aload 21
    //   212: iload 14
    //   214: invokestatic 310	com/google/android/gms/internal/fr:a	(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;I)V
    //   217: aload 5
    //   219: aload 20
    //   221: aload 15
    //   223: aload 21
    //   225: invokevirtual 313	com/google/android/gms/internal/fu:a	(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V
    //   228: aload 5
    //   230: lload 8
    //   232: invokevirtual 317	com/google/android/gms/internal/fu:i	(J)Lcom/google/android/gms/internal/fk;
    //   235: astore 22
    //   237: aload 12
    //   239: invokevirtual 320	java/net/HttpURLConnection:disconnect	()V
    //   242: aload 22
    //   244: areturn
    //   245: aload 10
    //   247: invokevirtual 295	java/net/URL:toString	()Ljava/lang/String;
    //   250: aload 15
    //   252: aconst_null
    //   253: iload 14
    //   255: invokestatic 310	com/google/android/gms/internal/fr:a	(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;I)V
    //   258: iload 14
    //   260: sipush 300
    //   263: if_icmplt +97 -> 360
    //   266: iload 14
    //   268: sipush 400
    //   271: if_icmpge +89 -> 360
    //   274: aload 12
    //   276: ldc_w 322
    //   279: invokevirtual 325	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   282: astore 17
    //   284: aload 17
    //   286: invokestatic 249	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   289: ifeq +27 -> 316
    //   292: ldc_w 327
    //   295: invokestatic 330	com/google/android/gms/internal/gs:W	(Ljava/lang/String;)V
    //   298: new 71	com/google/android/gms/internal/fk
    //   301: dup
    //   302: iconst_0
    //   303: invokespecial 74	com/google/android/gms/internal/fk:<init>	(I)V
    //   306: astore 19
    //   308: aload 12
    //   310: invokevirtual 320	java/net/HttpURLConnection:disconnect	()V
    //   313: aload 19
    //   315: areturn
    //   316: new 225	java/net/URL
    //   319: dup
    //   320: aload 17
    //   322: invokespecial 226	java/net/URL:<init>	(Ljava/lang/String;)V
    //   325: astore 10
    //   327: iinc 11 1
    //   330: iload 11
    //   332: iconst_5
    //   333: if_icmple +69 -> 402
    //   336: ldc_w 332
    //   339: invokestatic 330	com/google/android/gms/internal/gs:W	(Ljava/lang/String;)V
    //   342: new 71	com/google/android/gms/internal/fk
    //   345: dup
    //   346: iconst_0
    //   347: invokespecial 74	com/google/android/gms/internal/fk:<init>	(I)V
    //   350: astore 18
    //   352: aload 12
    //   354: invokevirtual 320	java/net/HttpURLConnection:disconnect	()V
    //   357: aload 18
    //   359: areturn
    //   360: new 213	java/lang/StringBuilder
    //   363: dup
    //   364: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   367: ldc_w 334
    //   370: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: iload 14
    //   375: invokevirtual 337	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   378: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   381: invokestatic 330	com/google/android/gms/internal/gs:W	(Ljava/lang/String;)V
    //   384: new 71	com/google/android/gms/internal/fk
    //   387: dup
    //   388: iconst_0
    //   389: invokespecial 74	com/google/android/gms/internal/fk:<init>	(I)V
    //   392: astore 16
    //   394: aload 12
    //   396: invokevirtual 320	java/net/HttpURLConnection:disconnect	()V
    //   399: aload 16
    //   401: areturn
    //   402: aload 5
    //   404: aload 15
    //   406: invokevirtual 341	com/google/android/gms/internal/fu:e	(Ljava/util/Map;)V
    //   409: aload 12
    //   411: invokevirtual 320	java/net/HttpURLConnection:disconnect	()V
    //   414: goto -361 -> 53
    //   417: astore 6
    //   419: new 213	java/lang/StringBuilder
    //   422: dup
    //   423: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   426: ldc_w 343
    //   429: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: aload 6
    //   434: invokevirtual 346	java/io/IOException:getMessage	()Ljava/lang/String;
    //   437: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   443: invokestatic 330	com/google/android/gms/internal/gs:W	(Ljava/lang/String;)V
    //   446: new 71	com/google/android/gms/internal/fk
    //   449: dup
    //   450: iconst_2
    //   451: invokespecial 74	com/google/android/gms/internal/fk:<init>	(I)V
    //   454: areturn
    //   455: astore 13
    //   457: aload 12
    //   459: invokevirtual 320	java/net/HttpURLConnection:disconnect	()V
    //   462: aload 13
    //   464: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	46	417	java/io/IOException
    //   53	63	417	java/io/IOException
    //   237	242	417	java/io/IOException
    //   308	313	417	java/io/IOException
    //   352	357	417	java/io/IOException
    //   394	399	417	java/io/IOException
    //   409	414	417	java/io/IOException
    //   457	465	417	java/io/IOException
    //   63	86	455	finally
    //   91	152	455	finally
    //   152	166	455	finally
    //   182	237	455	finally
    //   245	258	455	finally
    //   274	308	455	finally
    //   316	327	455	finally
    //   336	352	455	finally
    //   360	394	455	finally
    //   402	409	455	finally
  }

  public static fr a(Context paramContext, bm parambm, ci paramci, fx paramfx)
  {
    synchronized (uf)
    {
      if (ug == null)
        ug = new fr(paramContext.getApplicationContext(), parambm, paramci, paramfx);
      fr localfr = ug;
      return localfr;
    }
  }

  private static void a(String paramString1, Map<String, List<String>> paramMap, String paramString2, int paramInt)
  {
    if (gs.u(2))
    {
      gs.V("Http Response: {\n  URL:\n    " + paramString1 + "\n  Headers:");
      if (paramMap != null)
      {
        Iterator localIterator1 = paramMap.keySet().iterator();
        while (localIterator1.hasNext())
        {
          String str1 = (String)localIterator1.next();
          gs.V("    " + str1 + ":");
          Iterator localIterator2 = ((List)paramMap.get(str1)).iterator();
          while (localIterator2.hasNext())
          {
            String str2 = (String)localIterator2.next();
            gs.V("      " + str2);
          }
        }
      }
      gs.V("  Body:");
      if (paramString2 != null)
        for (int i = 0; i < Math.min(paramString2.length(), 100000); i += 1000)
          gs.V(paramString2.substring(i, Math.min(paramString2.length(), i + 1000)));
      gs.V("    null");
      gs.V("  Response Code:\n    " + paramInt + "\n}");
    }
  }

  public fk b(fi paramfi)
  {
    return a(this.mContext, this.uj, this.ui, this.uh, paramfi);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fr
 * JD-Core Version:    0.6.2
 */