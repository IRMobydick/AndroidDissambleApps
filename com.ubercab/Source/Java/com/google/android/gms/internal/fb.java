package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import org.json.JSONException;

@ez
public class fb extends gg
  implements ff.a
{
  private final Context mContext;
  private final Object mw = new Object();
  private cm pR;
  private final fa.a sU;
  private final Object sV = new Object();
  private final fi.a sW;
  private final k sX;
  private gg sY;
  private fk sZ;

  public fb(Context paramContext, fi.a parama, k paramk, fa.a parama1)
  {
    this.sU = parama1;
    this.mContext = paramContext;
    this.sW = parama;
    this.sX = paramk;
  }

  private ay a(fi paramfi)
    throws fb.a
  {
    if (this.sZ.tL == null)
      throw new a("The ad response must specify one of the supported ad sizes.", 0);
    String[] arrayOfString = this.sZ.tL.split("x");
    if (arrayOfString.length != 2)
      throw new a("Could not parse the ad size from the ad response: " + this.sZ.tL, 0);
    while (true)
    {
      int m;
      ay localay;
      try
      {
        int i = Integer.parseInt(arrayOfString[0]);
        int j = Integer.parseInt(arrayOfString[1]);
        ay[] arrayOfay = paramfi.lH.oh;
        int k = arrayOfay.length;
        m = 0;
        if (m >= k)
          break;
        localay = arrayOfay[m];
        float f = this.mContext.getResources().getDisplayMetrics().density;
        if (localay.width == -1)
        {
          n = (int)(localay.widthPixels / f);
          if (localay.height != -2)
            break label255;
          i1 = (int)(localay.heightPixels / f);
          if ((i != n) || (j != i1))
            break label265;
          return new ay(localay, paramfi.lH.oh);
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new a("Could not parse the ad size from the ad response: " + this.sZ.tL, 0);
      }
      int n = localay.width;
      continue;
      label255: int i1 = localay.height;
      continue;
      label265: m++;
    }
    throw new a("The ad size from the ad response was not one of the requested sizes: " + this.sZ.tL, 0);
  }

  private boolean c(long paramLong)
    throws fb.a
  {
    long l = 60000L - (SystemClock.elapsedRealtime() - paramLong);
    if (l <= 0L)
      return false;
    try
    {
      this.mw.wait(l);
      return true;
    }
    catch (InterruptedException localInterruptedException)
    {
    }
    throw new a("Ad request cancelled.", -1);
  }

  private void cx()
    throws fb.a
  {
    if (this.sZ.errorCode == -3);
    do
    {
      return;
      if (TextUtils.isEmpty(this.sZ.tG))
        throw new a("No fill from ad server.", 3);
      gb.a(this.mContext, this.sZ.tF);
    }
    while (!this.sZ.tI);
    try
    {
      this.pR = new cm(this.sZ.tG);
      return;
    }
    catch (JSONException localJSONException)
    {
    }
    throw new a("Could not parse mediation config: " + this.sZ.tG, 0);
  }

  private void e(long paramLong)
    throws fb.a
  {
    do
      if (!c(paramLong))
        throw new a("Timed out waiting for ad response.", 2);
    while (this.sZ == null);
    synchronized (this.sV)
    {
      this.sY = null;
      if ((this.sZ.errorCode != -2) && (this.sZ.errorCode != -3))
        throw new a("There was a problem getting an ad response. ErrorCode: " + this.sZ.errorCode, this.sZ.errorCode);
    }
  }

  private void r(boolean paramBoolean)
  {
    gb.cU().v(paramBoolean);
    an localan = gb.cU().l(this.mContext);
    if ((localan != null) && (!localan.isAlive()))
    {
      gs.S("start fetching content...");
      localan.aV();
    }
  }

  public void a(fk paramfk)
  {
    synchronized (this.mw)
    {
      gs.S("Received ad response.");
      this.sZ = paramfk;
      this.mw.notify();
      return;
    }
  }

  // ERROR //
  public void co()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 36	com/google/android/gms/internal/fb:mw	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: ldc 249
    //   9: invokestatic 235	com/google/android/gms/internal/gs:S	(Ljava/lang/String;)V
    //   12: aload_0
    //   13: getfield 44	com/google/android/gms/internal/fb:sX	Lcom/google/android/gms/internal/k;
    //   16: invokevirtual 255	com/google/android/gms/internal/k:z	()Lcom/google/android/gms/internal/g;
    //   19: aload_0
    //   20: getfield 40	com/google/android/gms/internal/fb:mContext	Landroid/content/Context;
    //   23: invokeinterface 260 2 0
    //   28: astore_3
    //   29: new 92	com/google/android/gms/internal/fi
    //   32: dup
    //   33: aload_0
    //   34: getfield 42	com/google/android/gms/internal/fb:sW	Lcom/google/android/gms/internal/fi$a;
    //   37: aload_3
    //   38: invokespecial 263	com/google/android/gms/internal/fi:<init>	(Lcom/google/android/gms/internal/fi$a;Ljava/lang/String;)V
    //   41: astore 4
    //   43: bipush 254
    //   45: istore 5
    //   47: ldc2_w 264
    //   50: lstore 6
    //   52: invokestatic 153	android/os/SystemClock:elapsedRealtime	()J
    //   55: lstore 18
    //   57: aload_0
    //   58: getfield 40	com/google/android/gms/internal/fb:mContext	Landroid/content/Context;
    //   61: aload 4
    //   63: aload_0
    //   64: invokestatic 270	com/google/android/gms/internal/ff:a	(Landroid/content/Context;Lcom/google/android/gms/internal/fi;Lcom/google/android/gms/internal/ff$a;)Lcom/google/android/gms/internal/gg;
    //   67: astore 20
    //   69: aload_0
    //   70: getfield 34	com/google/android/gms/internal/fb:sV	Ljava/lang/Object;
    //   73: astore 21
    //   75: aload 21
    //   77: monitorenter
    //   78: aload_0
    //   79: aload 20
    //   81: putfield 204	com/google/android/gms/internal/fb:sY	Lcom/google/android/gms/internal/gg;
    //   84: aload_0
    //   85: getfield 204	com/google/android/gms/internal/fb:sY	Lcom/google/android/gms/internal/gg;
    //   88: ifnonnull +181 -> 269
    //   91: new 48	com/google/android/gms/internal/fb$a
    //   94: dup
    //   95: ldc_w 272
    //   98: iconst_0
    //   99: invokespecial 63	com/google/android/gms/internal/fb$a:<init>	(Ljava/lang/String;I)V
    //   102: athrow
    //   103: astore 22
    //   105: aload 21
    //   107: monitorexit
    //   108: aload 22
    //   110: athrow
    //   111: astore 8
    //   113: aconst_null
    //   114: astore 9
    //   116: aload 8
    //   118: invokevirtual 276	com/google/android/gms/internal/fb$a:getErrorCode	()I
    //   121: istore 5
    //   123: iload 5
    //   125: iconst_3
    //   126: if_icmpeq +9 -> 135
    //   129: iload 5
    //   131: iconst_m1
    //   132: if_icmpne +196 -> 328
    //   135: aload 8
    //   137: invokevirtual 279	com/google/android/gms/internal/fb$a:getMessage	()Ljava/lang/String;
    //   140: invokestatic 282	com/google/android/gms/internal/gs:U	(Ljava/lang/String;)V
    //   143: aload_0
    //   144: getfield 52	com/google/android/gms/internal/fb:sZ	Lcom/google/android/gms/internal/fk;
    //   147: ifnonnull +197 -> 344
    //   150: aload_0
    //   151: new 54	com/google/android/gms/internal/fk
    //   154: dup
    //   155: iload 5
    //   157: invokespecial 285	com/google/android/gms/internal/fk:<init>	(I)V
    //   160: putfield 52	com/google/android/gms/internal/fb:sZ	Lcom/google/android/gms/internal/fk;
    //   163: getstatic 291	com/google/android/gms/internal/gr:wC	Landroid/os/Handler;
    //   166: new 293	com/google/android/gms/internal/fb$1
    //   169: dup
    //   170: aload_0
    //   171: invokespecial 296	com/google/android/gms/internal/fb$1:<init>	(Lcom/google/android/gms/internal/fb;)V
    //   174: invokevirtual 302	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   177: pop
    //   178: lload 6
    //   180: lstore 11
    //   182: aload_0
    //   183: getfield 52	com/google/android/gms/internal/fb:sZ	Lcom/google/android/gms/internal/fk;
    //   186: getfield 305	com/google/android/gms/internal/fk:tQ	Ljava/lang/String;
    //   189: invokestatic 174	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   192: istore 13
    //   194: iload 13
    //   196: ifne +181 -> 377
    //   199: new 307	org/json/JSONObject
    //   202: dup
    //   203: aload_0
    //   204: getfield 52	com/google/android/gms/internal/fb:sZ	Lcom/google/android/gms/internal/fk;
    //   207: getfield 305	com/google/android/gms/internal/fk:tQ	Ljava/lang/String;
    //   210: invokespecial 308	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   213: astore 14
    //   215: new 310	com/google/android/gms/internal/fz$a
    //   218: dup
    //   219: aload 4
    //   221: aload_0
    //   222: getfield 52	com/google/android/gms/internal/fb:sZ	Lcom/google/android/gms/internal/fk;
    //   225: aload_0
    //   226: getfield 195	com/google/android/gms/internal/fb:pR	Lcom/google/android/gms/internal/cm;
    //   229: aload 9
    //   231: iload 5
    //   233: lload 11
    //   235: aload_0
    //   236: getfield 52	com/google/android/gms/internal/fb:sZ	Lcom/google/android/gms/internal/fk;
    //   239: getfield 314	com/google/android/gms/internal/fk:tM	J
    //   242: aload 14
    //   244: invokespecial 317	com/google/android/gms/internal/fz$a:<init>	(Lcom/google/android/gms/internal/fi;Lcom/google/android/gms/internal/fk;Lcom/google/android/gms/internal/cm;Lcom/google/android/gms/internal/ay;IJJLorg/json/JSONObject;)V
    //   247: astore 15
    //   249: getstatic 291	com/google/android/gms/internal/gr:wC	Landroid/os/Handler;
    //   252: new 319	com/google/android/gms/internal/fb$2
    //   255: dup
    //   256: aload_0
    //   257: aload 15
    //   259: invokespecial 322	com/google/android/gms/internal/fb$2:<init>	(Lcom/google/android/gms/internal/fb;Lcom/google/android/gms/internal/fz$a;)V
    //   262: invokevirtual 302	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   265: pop
    //   266: aload_1
    //   267: monitorexit
    //   268: return
    //   269: aload 21
    //   271: monitorexit
    //   272: aload_0
    //   273: lload 18
    //   275: invokespecial 324	com/google/android/gms/internal/fb:e	(J)V
    //   278: invokestatic 153	android/os/SystemClock:elapsedRealtime	()J
    //   281: lstore 6
    //   283: aload_0
    //   284: invokespecial 326	com/google/android/gms/internal/fb:cx	()V
    //   287: aload 4
    //   289: getfield 96	com/google/android/gms/internal/fi:lH	Lcom/google/android/gms/internal/ay;
    //   292: getfield 102	com/google/android/gms/internal/ay:oh	[Lcom/google/android/gms/internal/ay;
    //   295: ifnull +93 -> 388
    //   298: aload_0
    //   299: aload 4
    //   301: invokespecial 328	com/google/android/gms/internal/fb:a	(Lcom/google/android/gms/internal/fi;)Lcom/google/android/gms/internal/ay;
    //   304: astore 23
    //   306: aload 23
    //   308: astore 9
    //   310: aload_0
    //   311: aload_0
    //   312: getfield 52	com/google/android/gms/internal/fb:sZ	Lcom/google/android/gms/internal/fk;
    //   315: getfield 331	com/google/android/gms/internal/fk:tT	Z
    //   318: invokespecial 333	com/google/android/gms/internal/fb:r	(Z)V
    //   321: lload 6
    //   323: lstore 11
    //   325: goto -143 -> 182
    //   328: aload 8
    //   330: invokevirtual 279	com/google/android/gms/internal/fb$a:getMessage	()Ljava/lang/String;
    //   333: invokestatic 336	com/google/android/gms/internal/gs:W	(Ljava/lang/String;)V
    //   336: goto -193 -> 143
    //   339: astore_2
    //   340: aload_1
    //   341: monitorexit
    //   342: aload_2
    //   343: athrow
    //   344: aload_0
    //   345: new 54	com/google/android/gms/internal/fk
    //   348: dup
    //   349: iload 5
    //   351: aload_0
    //   352: getfield 52	com/google/android/gms/internal/fb:sZ	Lcom/google/android/gms/internal/fk;
    //   355: getfield 339	com/google/android/gms/internal/fk:qj	J
    //   358: invokespecial 342	com/google/android/gms/internal/fk:<init>	(IJ)V
    //   361: putfield 52	com/google/android/gms/internal/fb:sZ	Lcom/google/android/gms/internal/fk;
    //   364: goto -201 -> 163
    //   367: astore 17
    //   369: ldc_w 344
    //   372: aload 17
    //   374: invokestatic 347	com/google/android/gms/internal/gs:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   377: aconst_null
    //   378: astore 14
    //   380: goto -165 -> 215
    //   383: astore 8
    //   385: goto -269 -> 116
    //   388: aconst_null
    //   389: astore 9
    //   391: goto -81 -> 310
    //
    // Exception table:
    //   from	to	target	type
    //   78	103	103	finally
    //   105	108	103	finally
    //   269	272	103	finally
    //   52	78	111	com/google/android/gms/internal/fb$a
    //   108	111	111	com/google/android/gms/internal/fb$a
    //   272	306	111	com/google/android/gms/internal/fb$a
    //   7	43	339	finally
    //   52	78	339	finally
    //   108	111	339	finally
    //   116	123	339	finally
    //   135	143	339	finally
    //   143	163	339	finally
    //   163	178	339	finally
    //   182	194	339	finally
    //   199	215	339	finally
    //   215	268	339	finally
    //   272	306	339	finally
    //   310	321	339	finally
    //   328	336	339	finally
    //   340	342	339	finally
    //   344	364	339	finally
    //   369	377	339	finally
    //   199	215	367	java/lang/Exception
    //   310	321	383	com/google/android/gms/internal/fb$a
  }

  public void onStop()
  {
    synchronized (this.sV)
    {
      if (this.sY != null)
        this.sY.cancel();
      return;
    }
  }

  @ez
  private static final class a extends Exception
  {
    private final int tc;

    public a(String paramString, int paramInt)
    {
      super();
      this.tc = paramInt;
    }

    public int getErrorCode()
    {
      return this.tc;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fb
 * JD-Core Version:    0.6.2
 */