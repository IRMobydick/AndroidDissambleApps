package com.baidu.location;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.wifi.ScanResult;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Messenger;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.RemoteException;
import com.baidu.location.b.a.a;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

class a0
  implements n
{
  public static final long i2 = 1800000L;
  private static final String i4 = "1";
  private static final String iR = "GeofenceStrategyService";
  private static final int iT = 30000;
  private static final int iU = 360000;
  private static final int iW = 6;
  private static final String iZ = "GeofenceStrategyService";
  private static final String ja = "com.baidu.locsdk.geofence.geofencestrategyservice";
  private static final int jb = 180000;
  private static final int jd = 60000;
  public static a0 jf;
  private static final String jh = "0";
  public static final String ji = "http://loc.map.baidu.com/fence";
  private static final String jk = "&gf=1";
  private String i0;
  private d i1;
  private boolean i3 = true;
  private Handler i5 = new Handler();
  private Map i6 = new HashMap();
  private String i7;
  private c i8;
  private PowerManager.WakeLock i9;
  private List iS;
  private String iV;
  private boolean iX;
  private boolean iY;
  private int jc;
  private HandlerThread je;
  private Messenger jg;
  private ar.b jj;
  private List jl;
  private ar.b jm;

  private void jdMethod_byte(Context paramContext)
  {
    if (this.i9 == null)
    {
      this.i9 = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(1, "GeofenceStrategyService");
      this.i9.setReferenceCounted(false);
      this.i9.acquire(60000L);
    }
  }

  public static a0 cq()
  {
    if (jf == null)
    {
      jf = new a0();
      jf.cv();
    }
    return jf;
  }

  private Map cr()
  {
    Cursor localCursor = null;
    HashMap localHashMap = new HashMap();
    SQLiteDatabase localSQLiteDatabase = m.a(f.getServiceContext()).getReadableDatabase();
    try
    {
      long l = System.currentTimeMillis();
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = "geofence_detail";
      arrayOfObject[1] = "geofence";
      arrayOfObject[2] = Long.valueOf(l);
      arrayOfObject[3] = Long.valueOf(l);
      localCursor = localSQLiteDatabase.rawQuery(String.format("SELECT a.ap, b.geofence_id FROM %s AS a LEFT JOIN %s AS b WHERE (a.geofence_id = b.geofence_id) AND ((b.valid_date + b.duration_millis) >= %d) AND (b.next_exit_active_time < %d) ", arrayOfObject), null);
      String str1;
      String str2;
      if ((localCursor != null) && (localCursor.getCount() > 0))
      {
        localCursor.moveToFirst();
        int i = localCursor.getColumnIndex("geofence_id");
        int j = localCursor.getColumnIndex("ap");
        str1 = localCursor.getString(i);
        str2 = localCursor.getString(j);
        if (!localHashMap.containsKey(str1))
          break label193;
        ((List)localHashMap.get(str1)).add(str2);
      }
      while (true)
      {
        boolean bool = localCursor.moveToNext();
        if (bool)
          break;
        if (localCursor != null)
          localCursor.close();
        localSQLiteDatabase.close();
        return localHashMap;
        label193: ArrayList localArrayList = new ArrayList();
        localArrayList.add(str2);
        localHashMap.put(str1, localArrayList);
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        localException.printStackTrace();
        if (localCursor != null)
          localCursor.close();
      }
    }
    finally
    {
      if (localCursor != null)
        localCursor.close();
    }
  }

  private boolean cs()
  {
    if (this.jj == null);
    do
    {
      return true;
      if (this.jm == this.jj)
        return false;
    }
    while (!this.jj.a(this.jm));
    return false;
  }

  private void ct()
  {
    if (this.iX)
    {
      jdMethod_if(f.getServiceContext(), 30000);
      return;
    }
    if (this.jc > 0)
    {
      Context localContext = f.getServiceContext();
      if (this.jc >= 6);
      for (int k = 180000; ; k = 30000 * this.jc)
      {
        jdMethod_if(localContext, k);
        return;
      }
    }
    int i;
    if ((this.jl != null) && (this.jl.size() > 0))
    {
      Iterator localIterator1 = this.jl.iterator();
      i = 0;
      if (localIterator1.hasNext())
      {
        aq localaq2 = (aq)localIterator1.next();
        if ((localaq2.jdMethod_if()) || (localaq2.jdMethod_for()))
          break label258;
        jdMethod_for(localaq2);
      }
    }
    label258: for (int j = 1; ; j = i)
    {
      i = j;
      break;
      if ((this.iS != null) && (this.iS.size() > 0))
      {
        Iterator localIterator2 = this.iS.iterator();
        while (localIterator2.hasNext())
        {
          aq localaq1 = (aq)localIterator2.next();
          if ((!localaq1.jdMethod_if()) && (!localaq1.jdMethod_for()))
          {
            jdMethod_for(localaq1);
            i = 1;
          }
        }
      }
      if (i != 0)
      {
        jdMethod_if(f.getServiceContext(), 30000);
        return;
      }
      jdMethod_if(f.getServiceContext(), 180000);
      return;
      jdMethod_if(f.getServiceContext(), 360000);
      return;
    }
  }

  private void cu()
  {
    if ((this.i9 != null) && (this.i9.isHeld()))
    {
      this.i9.release();
      this.i9 = null;
    }
  }

  private void cv()
  {
    this.je = new HandlerThread("GeofenceStrategyService", 10);
    this.je.start();
    this.i5 = new Handler(this.je.getLooper());
    this.i1 = new d(null);
  }

  private List jdMethod_else(boolean paramBoolean)
  {
    t.a locala = t.an().ak();
    this.jm = ar.bW().bS();
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
    {
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = Integer.valueOf(locala.jdField_do);
      arrayOfObject[1] = Integer.valueOf(locala.jdField_if);
      arrayOfObject[2] = Integer.valueOf(locala.jdField_for);
      arrayOfObject[3] = Integer.valueOf(locala.jdField_try);
      this.i0 = String.format("%s|%s|%s|%s", arrayOfObject);
      localArrayList.add(Jni.j(this.i0));
    }
    if (this.jm != null)
    {
      List localList = this.jm.jdField_for;
      if (localList != null)
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          ScanResult localScanResult = (ScanResult)localIterator.next();
          if (localScanResult != null)
            localArrayList.add(Jni.j(localScanResult.BSSID.replace(":", "")));
        }
      }
    }
    return localArrayList;
  }

  private void jdMethod_for(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
      return;
    int i = paramList.size();
    for (int j = 0; j < i; j++)
    {
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = paramList.get(j);
      paramList.set(j, String.format("'%s'", arrayOfObject2));
    }
    List localList1 = jdMethod_if(paramList, true);
    if (localList1 != null)
    {
      Iterator localIterator5 = localList1.iterator();
      while (localIterator5.hasNext())
      {
        aq localaq3 = (aq)localIterator5.next();
        Iterator localIterator6 = this.i6.entrySet().iterator();
        while (localIterator6.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator6.next();
          if (System.currentTimeMillis() - ((Long)localEntry.getValue()).longValue() >= 1800000L)
            localIterator6.remove();
          if (localaq3.getGeofenceId().equals(localEntry.getKey()))
            localIterator5.remove();
        }
      }
    }
    List localList2 = jdMethod_else(false);
    if ((localList2 != null) && (localList2.size() > 0))
    {
      Map localMap = cr();
      if (localMap.size() > 0)
      {
        Iterator localIterator3 = localList2.iterator();
        while (true)
        {
          if (!localIterator3.hasNext())
            break label339;
          String str = (String)localIterator3.next();
          Iterator localIterator4 = localMap.entrySet().iterator();
          if (localIterator4.hasNext())
          {
            if (!((List)((Map.Entry)localIterator4.next()).getValue()).contains(str))
              break;
            localIterator4.remove();
          }
        }
      }
      label339: if (localMap.size() > 0)
      {
        localList2.clear();
        localList2.addAll(localMap.keySet());
        int m = localList2.size();
        for (int n = 0; n < m; n++)
        {
          Object[] arrayOfObject1 = new Object[1];
          arrayOfObject1[0] = localList2.get(n);
          localList2.set(n, String.format("'%s'", arrayOfObject1));
        }
      }
    }
    for (List localList3 = jdMethod_if(localList2, false); ; localList3 = null)
    {
      ArrayList localArrayList = new ArrayList();
      if (localList1 != null)
        localArrayList.addAll(localList1);
      if (localList3 != null)
      {
        Iterator localIterator2 = localList3.iterator();
        while (localIterator2.hasNext())
        {
          aq localaq2 = (aq)localIterator2.next();
          if ((!localArrayList.contains(localaq2)) || (this.i3))
            localArrayList.add(localaq2);
        }
      }
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        Iterator localIterator1 = localArrayList.iterator();
        label558: 
        while (localIterator1.hasNext())
        {
          aq localaq1 = (aq)localIterator1.next();
          if (localaq1 != null)
          {
            this.iX = true;
            jdMethod_for(localaq1);
            this.i7 = this.i0;
            this.jj = this.jm;
            this.jc = 0;
          }
          else
          {
            this.iX = false;
            this.jc = (1 + this.jc);
            if (this.jc != 2147483647)
              break label657;
          }
        }
        label657: for (int k = 1; ; k = this.jc)
        {
          this.jc = k;
          break label558;
          break;
        }
      }
      this.iX = false;
      return;
    }
  }

  // ERROR //
  public List jdMethod_for(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 144	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   3: invokestatic 150	com/baidu/location/m:a	(Landroid/content/Context;)Lcom/baidu/location/m;
    //   6: invokevirtual 154	com/baidu/location/m:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   9: astore_3
    //   10: aconst_null
    //   11: astore 4
    //   13: aload_3
    //   14: ifnull +501 -> 515
    //   17: aconst_null
    //   18: astore 5
    //   20: invokestatic 160	java/lang/System:currentTimeMillis	()J
    //   23: lstore 6
    //   25: iload_2
    //   26: ifeq +492 -> 518
    //   29: iconst_5
    //   30: anewarray 4	java/lang/Object
    //   33: astore 45
    //   35: aload 45
    //   37: iconst_0
    //   38: ldc 162
    //   40: aastore
    //   41: aload 45
    //   43: iconst_1
    //   44: ldc 164
    //   46: aastore
    //   47: aload 45
    //   49: iconst_2
    //   50: aload_1
    //   51: aastore
    //   52: aload 45
    //   54: iconst_3
    //   55: lload 6
    //   57: invokestatic 170	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   60: aastore
    //   61: aload 45
    //   63: iconst_4
    //   64: lload 6
    //   66: invokestatic 170	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   69: aastore
    //   70: ldc_w 470
    //   73: aload 45
    //   75: invokestatic 178	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   78: astore 13
    //   80: aload_3
    //   81: aload 13
    //   83: aconst_null
    //   84: invokevirtual 184	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   87: astore 14
    //   89: aload 14
    //   91: astore 9
    //   93: aconst_null
    //   94: astore 4
    //   96: aload 9
    //   98: ifnull +401 -> 499
    //   101: aload 9
    //   103: invokeinterface 190 1 0
    //   108: istore 16
    //   110: aconst_null
    //   111: astore 4
    //   113: iload 16
    //   115: ifle +384 -> 499
    //   118: new 230	java/util/ArrayList
    //   121: dup
    //   122: invokespecial 231	java/util/ArrayList:<init>	()V
    //   125: astore 17
    //   127: aload 9
    //   129: invokeinterface 194 1 0
    //   134: pop
    //   135: aload 9
    //   137: ldc 196
    //   139: invokeinterface 200 2 0
    //   144: istore 20
    //   146: aload 9
    //   148: ldc_w 472
    //   151: invokeinterface 200 2 0
    //   156: istore 21
    //   158: aload 9
    //   160: ldc_w 474
    //   163: invokeinterface 200 2 0
    //   168: istore 22
    //   170: aload 9
    //   172: ldc_w 476
    //   175: invokeinterface 200 2 0
    //   180: istore 23
    //   182: aload 9
    //   184: ldc_w 478
    //   187: invokeinterface 200 2 0
    //   192: istore 24
    //   194: aload 9
    //   196: ldc_w 480
    //   199: invokeinterface 200 2 0
    //   204: istore 25
    //   206: aload 9
    //   208: ldc_w 482
    //   211: invokeinterface 200 2 0
    //   216: istore 26
    //   218: aload 9
    //   220: ldc_w 484
    //   223: invokeinterface 200 2 0
    //   228: istore 27
    //   230: aload 9
    //   232: ldc_w 486
    //   235: invokeinterface 200 2 0
    //   240: istore 28
    //   242: aload 9
    //   244: ldc_w 488
    //   247: invokeinterface 200 2 0
    //   252: istore 29
    //   254: aload 9
    //   256: iload 20
    //   258: invokeinterface 206 2 0
    //   263: astore 30
    //   265: aload 9
    //   267: iload 21
    //   269: invokeinterface 206 2 0
    //   274: invokestatic 493	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   277: invokevirtual 497	java/lang/Float:floatValue	()F
    //   280: fstore 31
    //   282: aload 9
    //   284: iload 22
    //   286: invokeinterface 206 2 0
    //   291: invokestatic 493	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   294: invokevirtual 497	java/lang/Float:floatValue	()F
    //   297: fstore 32
    //   299: aload 9
    //   301: iload 23
    //   303: invokeinterface 206 2 0
    //   308: invokestatic 493	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   311: invokevirtual 497	java/lang/Float:floatValue	()F
    //   314: fstore 33
    //   316: aload 9
    //   318: iload 24
    //   320: invokeinterface 206 2 0
    //   325: astore 34
    //   327: aload 9
    //   329: iload 25
    //   331: invokeinterface 501 2 0
    //   336: lstore 35
    //   338: aload 9
    //   340: iload 26
    //   342: invokeinterface 505 2 0
    //   347: ifeq +229 -> 576
    //   350: iconst_1
    //   351: istore 37
    //   353: aload 9
    //   355: iload 27
    //   357: invokeinterface 505 2 0
    //   362: ifeq +220 -> 582
    //   365: iconst_1
    //   366: istore 38
    //   368: aload 9
    //   370: iload 28
    //   372: invokeinterface 505 2 0
    //   377: ifeq +211 -> 588
    //   380: iconst_1
    //   381: istore 39
    //   383: aload 9
    //   385: iload 29
    //   387: invokeinterface 505 2 0
    //   392: istore 40
    //   394: new 277	com/baidu/location/aq
    //   397: dup
    //   398: aload 30
    //   400: fload 31
    //   402: f2d
    //   403: fload 32
    //   405: f2d
    //   406: iload 40
    //   408: lload 35
    //   410: aload 34
    //   412: invokespecial 508	com/baidu/location/aq:<init>	(Ljava/lang/String;DDIJLjava/lang/String;)V
    //   415: astore 41
    //   417: aload 41
    //   419: ifnull +52 -> 471
    //   422: aload 41
    //   424: fload 33
    //   426: invokevirtual 511	com/baidu/location/aq:a	(F)V
    //   429: aload 41
    //   431: iload 37
    //   433: invokevirtual 513	com/baidu/location/aq:do	(Z)V
    //   436: aload 41
    //   438: iload 38
    //   440: invokevirtual 515	com/baidu/location/aq:a	(Z)V
    //   443: aload 41
    //   445: iload 39
    //   447: invokevirtual 517	com/baidu/location/aq:if	(Z)V
    //   450: aload_0
    //   451: getfield 87	com/baidu/location/a0:i3	Z
    //   454: ifne +17 -> 471
    //   457: iload_2
    //   458: ifeq +136 -> 594
    //   461: iconst_1
    //   462: istore 42
    //   464: aload 41
    //   466: iload 42
    //   468: invokevirtual 520	com/baidu/location/aq:a	(I)V
    //   471: aload 17
    //   473: aload 41
    //   475: invokeinterface 221 2 0
    //   480: pop
    //   481: aload 9
    //   483: invokeinterface 224 1 0
    //   488: istore 44
    //   490: iload 44
    //   492: ifne -238 -> 254
    //   495: aload 17
    //   497: astore 4
    //   499: aload 9
    //   501: ifnull +10 -> 511
    //   504: aload 9
    //   506: invokeinterface 227 1 0
    //   511: aload_3
    //   512: invokevirtual 228	android/database/sqlite/SQLiteDatabase:close	()V
    //   515: aload 4
    //   517: areturn
    //   518: iconst_5
    //   519: anewarray 4	java/lang/Object
    //   522: astore 11
    //   524: aload 11
    //   526: iconst_0
    //   527: ldc 162
    //   529: aastore
    //   530: aload 11
    //   532: iconst_1
    //   533: ldc 164
    //   535: aastore
    //   536: aload 11
    //   538: iconst_2
    //   539: aload_1
    //   540: aastore
    //   541: aload 11
    //   543: iconst_3
    //   544: lload 6
    //   546: invokestatic 170	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   549: aastore
    //   550: aload 11
    //   552: iconst_4
    //   553: lload 6
    //   555: invokestatic 170	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   558: aastore
    //   559: ldc_w 522
    //   562: aload 11
    //   564: invokestatic 178	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   567: astore 12
    //   569: aload 12
    //   571: astore 13
    //   573: goto -493 -> 80
    //   576: iconst_0
    //   577: istore 37
    //   579: goto -226 -> 353
    //   582: iconst_0
    //   583: istore 38
    //   585: goto -217 -> 368
    //   588: iconst_0
    //   589: istore 39
    //   591: goto -208 -> 383
    //   594: iconst_0
    //   595: istore 42
    //   597: goto -133 -> 464
    //   600: astore 10
    //   602: aload 5
    //   604: ifnull -93 -> 511
    //   607: aload 5
    //   609: invokeinterface 227 1 0
    //   614: goto -103 -> 511
    //   617: astore 8
    //   619: aconst_null
    //   620: astore 9
    //   622: aload 9
    //   624: ifnull +10 -> 634
    //   627: aload 9
    //   629: invokeinterface 227 1 0
    //   634: aload 8
    //   636: athrow
    //   637: astore 8
    //   639: goto -17 -> 622
    //   642: astore 15
    //   644: aload 9
    //   646: astore 5
    //   648: aconst_null
    //   649: astore 4
    //   651: goto -49 -> 602
    //   654: astore 18
    //   656: aload 9
    //   658: astore 5
    //   660: aload 17
    //   662: astore 4
    //   664: goto -62 -> 602
    //
    // Exception table:
    //   from	to	target	type
    //   29	80	600	java/lang/Exception
    //   80	89	600	java/lang/Exception
    //   518	569	600	java/lang/Exception
    //   29	80	617	finally
    //   80	89	617	finally
    //   518	569	617	finally
    //   101	110	637	finally
    //   118	127	637	finally
    //   127	254	637	finally
    //   254	350	637	finally
    //   353	365	637	finally
    //   368	380	637	finally
    //   383	417	637	finally
    //   422	457	637	finally
    //   464	471	637	finally
    //   471	490	637	finally
    //   101	110	642	java/lang/Exception
    //   118	127	642	java/lang/Exception
    //   127	254	654	java/lang/Exception
    //   254	350	654	java/lang/Exception
    //   353	365	654	java/lang/Exception
    //   368	380	654	java/lang/Exception
    //   383	417	654	java/lang/Exception
    //   422	457	654	java/lang/Exception
    //   464	471	654	java/lang/Exception
    //   471	490	654	java/lang/Exception
  }

  public void jdMethod_for(aq paramaq)
  {
    new a(paramaq, Jni.i(new b(null).e("&gf=1").replace("gcj02", paramaq.jdMethod_int()))).ai();
  }

  // ERROR //
  public List jdMethod_if(List paramList, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 545
    //   3: aload_1
    //   4: invokestatic 551	android/text/TextUtils:join	(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
    //   7: astore_3
    //   8: invokestatic 144	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   11: invokestatic 150	com/baidu/location/m:a	(Landroid/content/Context;)Lcom/baidu/location/m;
    //   14: invokevirtual 154	com/baidu/location/m:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   17: astore 4
    //   19: aconst_null
    //   20: astore 5
    //   22: aload 4
    //   24: ifnull +510 -> 534
    //   27: aconst_null
    //   28: astore 6
    //   30: invokestatic 160	java/lang/System:currentTimeMillis	()J
    //   33: lstore 10
    //   35: iload_2
    //   36: ifeq +501 -> 537
    //   39: iconst_5
    //   40: anewarray 4	java/lang/Object
    //   43: astore 12
    //   45: aload 12
    //   47: iconst_0
    //   48: ldc 162
    //   50: aastore
    //   51: aload 12
    //   53: iconst_1
    //   54: ldc 164
    //   56: aastore
    //   57: aload 12
    //   59: iconst_2
    //   60: aload_3
    //   61: aastore
    //   62: aload 12
    //   64: iconst_3
    //   65: lload 10
    //   67: invokestatic 170	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   70: aastore
    //   71: aload 12
    //   73: iconst_4
    //   74: lload 10
    //   76: invokestatic 170	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   79: aastore
    //   80: ldc_w 553
    //   83: aload 12
    //   85: invokestatic 178	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   88: astore 13
    //   90: aload 4
    //   92: aload 13
    //   94: aconst_null
    //   95: invokevirtual 184	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   98: astore 14
    //   100: aload 14
    //   102: astore 8
    //   104: aconst_null
    //   105: astore 5
    //   107: aload 8
    //   109: ifnull +408 -> 517
    //   112: aload 8
    //   114: invokeinterface 190 1 0
    //   119: istore 16
    //   121: aconst_null
    //   122: astore 5
    //   124: iload 16
    //   126: ifle +391 -> 517
    //   129: new 230	java/util/ArrayList
    //   132: dup
    //   133: invokespecial 231	java/util/ArrayList:<init>	()V
    //   136: astore 17
    //   138: aload 17
    //   140: invokeinterface 447 1 0
    //   145: aload 8
    //   147: invokeinterface 194 1 0
    //   152: pop
    //   153: aload 8
    //   155: ldc 196
    //   157: invokeinterface 200 2 0
    //   162: istore 20
    //   164: aload 8
    //   166: ldc_w 472
    //   169: invokeinterface 200 2 0
    //   174: istore 21
    //   176: aload 8
    //   178: ldc_w 474
    //   181: invokeinterface 200 2 0
    //   186: istore 22
    //   188: aload 8
    //   190: ldc_w 476
    //   193: invokeinterface 200 2 0
    //   198: istore 23
    //   200: aload 8
    //   202: ldc_w 478
    //   205: invokeinterface 200 2 0
    //   210: istore 24
    //   212: aload 8
    //   214: ldc_w 480
    //   217: invokeinterface 200 2 0
    //   222: istore 25
    //   224: aload 8
    //   226: ldc_w 482
    //   229: invokeinterface 200 2 0
    //   234: istore 26
    //   236: aload 8
    //   238: ldc_w 484
    //   241: invokeinterface 200 2 0
    //   246: istore 27
    //   248: aload 8
    //   250: ldc_w 486
    //   253: invokeinterface 200 2 0
    //   258: istore 28
    //   260: aload 8
    //   262: ldc_w 488
    //   265: invokeinterface 200 2 0
    //   270: istore 29
    //   272: aload 8
    //   274: iload 20
    //   276: invokeinterface 206 2 0
    //   281: astore 30
    //   283: aload 8
    //   285: iload 21
    //   287: invokeinterface 206 2 0
    //   292: invokestatic 493	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   295: invokevirtual 497	java/lang/Float:floatValue	()F
    //   298: fstore 31
    //   300: aload 8
    //   302: iload 22
    //   304: invokeinterface 206 2 0
    //   309: invokestatic 493	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   312: invokevirtual 497	java/lang/Float:floatValue	()F
    //   315: fstore 32
    //   317: aload 8
    //   319: iload 23
    //   321: invokeinterface 206 2 0
    //   326: invokestatic 493	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   329: invokevirtual 497	java/lang/Float:floatValue	()F
    //   332: fstore 33
    //   334: aload 8
    //   336: iload 24
    //   338: invokeinterface 206 2 0
    //   343: astore 34
    //   345: aload 8
    //   347: iload 25
    //   349: invokeinterface 501 2 0
    //   354: lstore 35
    //   356: aload 8
    //   358: iload 26
    //   360: invokeinterface 505 2 0
    //   365: ifeq +230 -> 595
    //   368: iconst_1
    //   369: istore 37
    //   371: aload 8
    //   373: iload 27
    //   375: invokeinterface 505 2 0
    //   380: ifeq +221 -> 601
    //   383: iconst_1
    //   384: istore 38
    //   386: aload 8
    //   388: iload 28
    //   390: invokeinterface 505 2 0
    //   395: ifeq +212 -> 607
    //   398: iconst_1
    //   399: istore 39
    //   401: aload 8
    //   403: iload 29
    //   405: invokeinterface 505 2 0
    //   410: istore 40
    //   412: new 277	com/baidu/location/aq
    //   415: dup
    //   416: aload 30
    //   418: fload 31
    //   420: f2d
    //   421: fload 32
    //   423: f2d
    //   424: iload 40
    //   426: lload 35
    //   428: aload 34
    //   430: invokespecial 508	com/baidu/location/aq:<init>	(Ljava/lang/String;DDIJLjava/lang/String;)V
    //   433: astore 41
    //   435: aload 41
    //   437: ifnull +52 -> 489
    //   440: aload 41
    //   442: fload 33
    //   444: invokevirtual 511	com/baidu/location/aq:a	(F)V
    //   447: aload 41
    //   449: iload 37
    //   451: invokevirtual 513	com/baidu/location/aq:do	(Z)V
    //   454: aload 41
    //   456: iload 38
    //   458: invokevirtual 515	com/baidu/location/aq:a	(Z)V
    //   461: aload 41
    //   463: iload 39
    //   465: invokevirtual 517	com/baidu/location/aq:if	(Z)V
    //   468: aload_0
    //   469: getfield 87	com/baidu/location/a0:i3	Z
    //   472: ifne +17 -> 489
    //   475: iload_2
    //   476: ifeq +137 -> 613
    //   479: iconst_1
    //   480: istore 42
    //   482: aload 41
    //   484: iload 42
    //   486: invokevirtual 520	com/baidu/location/aq:a	(I)V
    //   489: aload 17
    //   491: aload 41
    //   493: invokeinterface 221 2 0
    //   498: pop
    //   499: aload 8
    //   501: invokeinterface 224 1 0
    //   506: istore 44
    //   508: iload 44
    //   510: ifne -238 -> 272
    //   513: aload 17
    //   515: astore 5
    //   517: aload 8
    //   519: ifnull +10 -> 529
    //   522: aload 8
    //   524: invokeinterface 227 1 0
    //   529: aload 4
    //   531: invokevirtual 228	android/database/sqlite/SQLiteDatabase:close	()V
    //   534: aload 5
    //   536: areturn
    //   537: iconst_5
    //   538: anewarray 4	java/lang/Object
    //   541: astore 45
    //   543: aload 45
    //   545: iconst_0
    //   546: ldc 162
    //   548: aastore
    //   549: aload 45
    //   551: iconst_1
    //   552: ldc 164
    //   554: aastore
    //   555: aload 45
    //   557: iconst_2
    //   558: aload_3
    //   559: aastore
    //   560: aload 45
    //   562: iconst_3
    //   563: lload 10
    //   565: invokestatic 170	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   568: aastore
    //   569: aload 45
    //   571: iconst_4
    //   572: lload 10
    //   574: invokestatic 170	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   577: aastore
    //   578: ldc_w 555
    //   581: aload 45
    //   583: invokestatic 178	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   586: astore 46
    //   588: aload 46
    //   590: astore 13
    //   592: goto -502 -> 90
    //   595: iconst_0
    //   596: istore 37
    //   598: goto -227 -> 371
    //   601: iconst_0
    //   602: istore 38
    //   604: goto -218 -> 386
    //   607: iconst_0
    //   608: istore 39
    //   610: goto -209 -> 401
    //   613: iconst_0
    //   614: istore 42
    //   616: goto -134 -> 482
    //   619: astore 9
    //   621: aload 6
    //   623: ifnull -94 -> 529
    //   626: aload 6
    //   628: invokeinterface 227 1 0
    //   633: goto -104 -> 529
    //   636: astore 7
    //   638: aconst_null
    //   639: astore 8
    //   641: aload 8
    //   643: ifnull +10 -> 653
    //   646: aload 8
    //   648: invokeinterface 227 1 0
    //   653: aload 7
    //   655: athrow
    //   656: astore 7
    //   658: goto -17 -> 641
    //   661: astore 15
    //   663: aload 8
    //   665: astore 6
    //   667: aconst_null
    //   668: astore 5
    //   670: goto -49 -> 621
    //   673: astore 18
    //   675: aload 8
    //   677: astore 6
    //   679: aload 17
    //   681: astore 5
    //   683: goto -62 -> 621
    //
    // Exception table:
    //   from	to	target	type
    //   30	35	619	java/lang/Exception
    //   39	90	619	java/lang/Exception
    //   90	100	619	java/lang/Exception
    //   537	588	619	java/lang/Exception
    //   30	35	636	finally
    //   39	90	636	finally
    //   90	100	636	finally
    //   537	588	636	finally
    //   112	121	656	finally
    //   129	138	656	finally
    //   138	272	656	finally
    //   272	368	656	finally
    //   371	383	656	finally
    //   386	398	656	finally
    //   401	435	656	finally
    //   440	475	656	finally
    //   482	489	656	finally
    //   489	508	656	finally
    //   112	121	661	java/lang/Exception
    //   129	138	661	java/lang/Exception
    //   138	272	673	java/lang/Exception
    //   272	368	673	java/lang/Exception
    //   371	383	673	java/lang/Exception
    //   386	398	673	java/lang/Exception
    //   401	435	673	java/lang/Exception
    //   440	475	673	java/lang/Exception
    //   482	489	673	java/lang/Exception
    //   489	508	673	java/lang/Exception
  }

  public void jdMethod_if(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent("com.baidu.locsdk.geofence.geofencestrategyservice");
    PendingIntent localPendingIntent = PendingIntent.getBroadcast(paramContext, 0, localIntent, 134217728);
    if (paramInt <= 0)
    {
      i.a(paramContext, localPendingIntent);
      paramContext.sendBroadcast(localIntent);
      return;
    }
    i.a(paramContext, localPendingIntent, paramInt);
  }

  public void jdMethod_if(Context paramContext, Message paramMessage)
  {
    if (this.iY)
      return;
    this.jg = paramMessage.replyTo;
    this.iY = true;
    this.i8 = new c();
    paramContext.registerReceiver(this.i8, new IntentFilter("com.baidu.locsdk.geofence.geofencestrategyservice"));
    jdMethod_if(paramContext, 0);
  }

  public void jdMethod_new(Context paramContext)
  {
    jdMethod_if(paramContext, null);
  }

  public void jdMethod_try(Context paramContext)
  {
    this.iY = false;
    i.a(paramContext, PendingIntent.getBroadcast(paramContext, 0, new Intent("com.baidu.locsdk.geofence.geofencestrategyservice"), 134217728));
    cu();
    if (this.i8 != null);
    try
    {
      paramContext.unregisterReceiver(this.i8);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private class a extends s
  {
    private static final String dQ = "fence";
    private static final String dS = "bloc";
    private static final String dT = "ext";
    private static final String dU = "error";
    private static final String dW = "in";
    private aq dR;
    private final String dV;

    public a(aq paramString, String arg3)
    {
      this.dR = paramString;
      Object localObject;
      this.dV = localObject;
      this.cT = new ArrayList();
    }

    private void ah()
      throws RemoteException
    {
      a0.jdMethod_if(a0.this, false);
      au.jdMethod_for(f.getServiceContext()).jdMethod_if(this.dR);
      if (a0.jdMethod_char(a0.this) != null)
      {
        Message localMessage = Message.obtain(null, 209);
        Bundle localBundle = new Bundle();
        localBundle.putString("geofence_id", this.dR.getGeofenceId());
        localMessage.setData(localBundle);
        a0.jdMethod_char(a0.this).send(localMessage);
      }
    }

    private void aj()
      throws RemoteException
    {
      a0.jdMethod_if(a0.this, false);
      a0.jdMethod_goto(a0.this).put(this.dR.getGeofenceId(), Long.valueOf(System.currentTimeMillis()));
      au.jdMethod_for(f.getServiceContext()).jdMethod_do(this.dR);
      if (a0.jdMethod_char(a0.this) != null)
      {
        Message localMessage = Message.obtain(null, 208);
        Bundle localBundle = new Bundle();
        localBundle.putString("geofence_id", this.dR.getGeofenceId());
        localMessage.setData(localBundle);
        a0.jdMethod_char(a0.this).send(localMessage);
      }
    }

    void T()
    {
      this.cR = "http://loc.map.baidu.com/fence";
      DecimalFormat localDecimalFormat = new DecimalFormat("0.00000");
      Object[] arrayOfObject1 = new Object[8];
      arrayOfObject1[0] = localDecimalFormat.format(this.dR.a());
      arrayOfObject1[1] = localDecimalFormat.format(this.dR.jdMethod_case());
      arrayOfObject1[2] = String.valueOf(this.dR.jdMethod_do());
      arrayOfObject1[3] = String.valueOf(this.dR.jdMethod_int());
      arrayOfObject1[4] = Integer.valueOf(au.jdMethod_do(f.getServiceContext()));
      arrayOfObject1[5] = a.jdMethod_if(f.getServiceContext());
      arrayOfObject1[6] = Integer.valueOf(this.dR.jdMethod_char());
      if (ar.bW().bZ());
      for (String str1 = "1"; ; str1 = "0")
      {
        arrayOfObject1[7] = str1;
        String str2 = Jni.i(String.format("&x=%s&y=%s&r=%s&coord=%s&type=%s&cu=%s&fence_type=%s&wf_on=%s", arrayOfObject1));
        this.cT.add(new BasicNameValuePair("fence", str2));
        this.cT.add(new BasicNameValuePair("bloc", this.dV));
        List localList = this.cT;
        Locale localLocale = Locale.CHINA;
        Object[] arrayOfObject2 = new Object[2];
        arrayOfObject2[0] = v.a(f.getServiceContext());
        arrayOfObject2[1] = v.jdMethod_if(f.getServiceContext());
        localList.add(new BasicNameValuePair("ext", Jni.i(String.format(localLocale, "&ki=%s&sn=%s", arrayOfObject2))));
        return;
      }
    }

    public void ai()
    {
      N();
    }

    void jdMethod_do(boolean paramBoolean)
    {
      a0.jdMethod_do(a0.this, false);
      if ((paramBoolean) && (this.cS != null));
      try
      {
        JSONObject localJSONObject = new JSONObject(EntityUtils.toString(this.cS, "UTF-8"));
        if (localJSONObject != null)
        {
          int i = Integer.valueOf(localJSONObject.getString("error")).intValue();
          boolean bool = localJSONObject.has("in");
          int j = 0;
          if (bool)
            j = Integer.valueOf(localJSONObject.getString("in")).intValue();
          if (i == 0)
          {
            a0.jdMethod_do(a0.this, null);
            a0.jdMethod_if(a0.this, null);
            au.jdMethod_for(f.getServiceContext()).b7();
            if (a0.jdMethod_try(a0.this))
            {
              if (j == 1)
              {
                aj();
                return;
              }
              if (j == 0)
                ah();
            }
            else
            {
              if ((j == 1) && (this.dR.jdMethod_try() == 1))
              {
                aj();
                return;
              }
              if ((j == 0) && (this.dR.jdMethod_try() == 0))
                ah();
            }
          }
        }
        return;
      }
      catch (Exception localException)
      {
      }
    }
  }

  private class b extends ag
  {
    private b()
    {
    }

    void at()
    {
    }

    void jdMethod_byte(Message paramMessage)
    {
    }
  }

  public class c extends BroadcastReceiver
  {
    public c()
    {
    }

    public void onReceive(Context paramContext, Intent paramIntent)
    {
      a0.jdMethod_if(a0.this, paramContext);
      a0.jdMethod_byte(a0.this).post(a0.jdMethod_if(a0.this));
    }
  }

  private class d
    implements Runnable, b
  {
    private d()
    {
    }

    public void run()
    {
      try
      {
        List localList = a0.jdMethod_for(a0.this, true);
        if ((!a0.jdMethod_for(a0.this).equals(a0.jdMethod_case(a0.this))) || (a0.jdMethod_else(a0.this)) || (!a0.jdMethod_new(a0.this)))
        {
          a0.jdMethod_do(a0.this, a0.jdMethod_for(a0.this));
          a0.jdMethod_if(a0.this, a0.jdMethod_int(a0.this));
          t.a locala = t.an().ak();
          Object[] arrayOfObject1 = new Object[3];
          arrayOfObject1[0] = Integer.valueOf(locala.jdField_do);
          arrayOfObject1[1] = Integer.valueOf(locala.jdField_if);
          arrayOfObject1[2] = Integer.valueOf(locala.jdField_for);
          String str = Jni.j(String.format("%s|%s|%s|0", arrayOfObject1));
          a0 locala0 = a0.this;
          Object[] arrayOfObject2 = new Object[3];
          arrayOfObject2[0] = Integer.valueOf(locala.jdField_do);
          arrayOfObject2[1] = Integer.valueOf(locala.jdField_if);
          arrayOfObject2[2] = Integer.valueOf(locala.jdField_for);
          a0.jdMethod_if(locala0, String.format("%s|%s|%s|0", arrayOfObject2));
          a0.jdMethod_if(a0.this, a0.this.jdMethod_for(str, true));
          a0.jdMethod_do(a0.this, a0.this.jdMethod_for(str, false));
          a0.jdMethod_for(a0.this, localList);
          a0.jdMethod_do(a0.this);
        }
        return;
      }
      catch (Exception localException)
      {
        a0.this.jdMethod_if(f.getServiceContext(), 360000);
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.location.a0
 * JD-Core Version:    0.6.2
 */