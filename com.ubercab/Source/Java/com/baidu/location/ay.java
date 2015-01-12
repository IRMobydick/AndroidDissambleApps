package com.baidu.location;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

class ay
  implements ax, n
{
  private static ay im = null;
  private volatile boolean iA = false;
  private final String iB = I + "/ls.db";
  private int iC = 0;
  private final String iD = "wof";
  private boolean iE = false;
  private final int iF = 10000;
  private String iG = null;
  private boolean in = false;
  private String io = null;
  private long ip = 0L;
  private final int iq = 6;
  private double ir = 0.0D;
  private double is = 0.0D;
  private final String it = "bdcltb09";
  private double iu = 0.0D;
  private double iv = 0.0D;
  private boolean iw = false;
  private boolean ix = true;
  private boolean iy = false;
  private double iz = 0.0D;

  private ay()
  {
    try
    {
      cg();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private String jdMethod_byte(boolean paramBoolean)
  {
    double d1 = 0.0D;
    double d2 = 0.0D;
    boolean bool;
    int i;
    double d3;
    if (this.iE)
    {
      d1 = this.is;
      d2 = this.ir;
      bool = true;
      i = 1;
      d3 = 246.40000000000001D;
    }
    while (true)
    {
      j.cZ().jdMethod_if(this.iy, this.iE, d1, d2);
      if (i != 0)
      {
        if (paramBoolean)
        {
          String str2 = "{\"result\":{\"time\":\"" + c.jdMethod_new() + "\",\"error\":\"66\"},\"content\":{\"point\":{\"x\":" + "\"%f\",\"y\":\"%f\"},\"radius\":\"%f\",\"isCellChanged\":\"%b\"}}";
          Locale localLocale2 = Locale.CHINA;
          Object[] arrayOfObject2 = new Object[4];
          arrayOfObject2[0] = Double.valueOf(d1);
          arrayOfObject2[1] = Double.valueOf(d2);
          arrayOfObject2[2] = Double.valueOf(d3);
          arrayOfObject2[3] = Boolean.valueOf(true);
          return String.format(localLocale2, str2, arrayOfObject2);
          if (this.iy)
          {
            d1 = this.iv;
            d2 = this.iu;
            double d4 = this.iz;
            bool = ah.ay().aA();
            i = 1;
            d3 = d4;
          }
        }
        else
        {
          String str1 = "{\"result\":{\"time\":\"" + c.jdMethod_new() + "\",\"error\":\"68\"},\"content\":{\"point\":{\"x\":" + "\"%f\",\"y\":\"%f\"},\"radius\":\"%f\",\"isCellChanged\":\"%b\"}}";
          Locale localLocale1 = Locale.CHINA;
          Object[] arrayOfObject1 = new Object[4];
          arrayOfObject1[0] = Double.valueOf(d1);
          arrayOfObject1[1] = Double.valueOf(d2);
          arrayOfObject1[2] = Double.valueOf(d3);
          arrayOfObject1[3] = Boolean.valueOf(bool);
          return String.format(localLocale1, str1, arrayOfObject1);
        }
      }
      else
      {
        if (paramBoolean)
          return "{\"result\":{\"time\":\"" + c.jdMethod_new() + "\",\"error\":\"67\"}}";
        return "{\"result\":{\"time\":\"" + c.jdMethod_new() + "\",\"error\":\"63\"}}";
        d3 = 0.0D;
        bool = false;
        i = 0;
      }
    }
  }

  public static ay cd()
  {
    if (im == null)
      im = new ay();
    return im;
  }

  private void ce()
  {
    SQLiteDatabase localSQLiteDatabase1;
    long l2;
    try
    {
      SQLiteDatabase localSQLiteDatabase2 = SQLiteDatabase.openOrCreateDatabase(this.iB, null);
      localSQLiteDatabase1 = localSQLiteDatabase2;
      if (localSQLiteDatabase1 == null)
        return;
    }
    catch (Exception localException)
    {
      while (true)
        localSQLiteDatabase1 = null;
      long l1 = DatabaseUtils.queryNumEntries(localSQLiteDatabase1, "wof");
      l2 = DatabaseUtils.queryNumEntries(localSQLiteDatabase1, "bdcltb09");
      if (l1 <= 10000L)
        break label120;
    }
    boolean bool1 = true;
    if (l2 > 10000L);
    for (boolean bool2 = true; ; bool2 = false)
    {
      if ((bool1) || (bool2))
      {
        a locala = new a(null);
        Boolean[] arrayOfBoolean = new Boolean[2];
        arrayOfBoolean[0] = Boolean.valueOf(bool1);
        arrayOfBoolean[1] = Boolean.valueOf(bool2);
        locala.execute(arrayOfBoolean);
      }
      localSQLiteDatabase1.close();
      return;
      label120: bool1 = false;
      break;
    }
  }

  private void cf()
  {
    t.a locala = t.an().ak();
    if (locala != null)
      r(locala.a());
    jdMethod_for(ar.bW().bS());
  }

  private void cg()
  {
    try
    {
      File localFile1 = new File(I);
      File localFile2 = new File(this.iB);
      if (!localFile1.exists())
        localFile1.mkdirs();
      if (!localFile2.exists())
        localFile2.createNewFile();
      if (localFile2.exists())
      {
        SQLiteDatabase localSQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(localFile2, null);
        localSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS bdcltb09(id CHAR(40) PRIMARY KEY,time DOUBLE,tag DOUBLE, type DOUBLE , ac INT);");
        localSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS wof(id CHAR(15) PRIMARY KEY,mktime DOUBLE,time DOUBLE, ac INT, bc INT, cc INT);");
        localSQLiteDatabase.setVersion(1);
        localSQLiteDatabase.close();
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  // ERROR //
  private void jdMethod_for(ar.b paramb)
  {
    // Byte code:
    //   0: invokestatic 271	java/lang/System:currentTimeMillis	()J
    //   3: pop2
    //   4: aload_0
    //   5: iconst_0
    //   6: putfield 50	com/baidu/location/ay:iE	Z
    //   9: aload_1
    //   10: getfield 276	com/baidu/location/ar$b:for	Ljava/util/List;
    //   13: ifnonnull +4 -> 17
    //   16: return
    //   17: aload_0
    //   18: getfield 101	com/baidu/location/ay:iB	Ljava/lang/String;
    //   21: aconst_null
    //   22: invokestatic 180	android/database/sqlite/SQLiteDatabase:openOrCreateDatabase	(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;)Landroid/database/sqlite/SQLiteDatabase;
    //   25: astore 63
    //   27: aload 63
    //   29: astore 5
    //   31: aload 5
    //   33: ifnull -17 -> 16
    //   36: aload_1
    //   37: ifnull -21 -> 16
    //   40: aload_1
    //   41: getfield 276	com/baidu/location/ar$b:for	Ljava/util/List;
    //   44: invokeinterface 282 1 0
    //   49: astore 6
    //   51: iconst_0
    //   52: istore 7
    //   54: aconst_null
    //   55: astore 8
    //   57: iconst_0
    //   58: istore 9
    //   60: iconst_0
    //   61: istore 10
    //   63: dconst_0
    //   64: dstore 11
    //   66: dconst_0
    //   67: dstore 13
    //   69: iconst_0
    //   70: istore 15
    //   72: aload 6
    //   74: invokeinterface 287 1 0
    //   79: ifeq +28 -> 107
    //   82: aload 6
    //   84: invokeinterface 291 1 0
    //   89: checkcast 293	android/net/wifi/ScanResult
    //   92: astore 16
    //   94: iload 15
    //   96: iconst_1
    //   97: iadd
    //   98: istore 17
    //   100: iload 17
    //   102: bipush 10
    //   104: if_icmple +47 -> 151
    //   107: iload 10
    //   109: ifle +28 -> 137
    //   112: aload_0
    //   113: iconst_1
    //   114: putfield 50	com/baidu/location/ay:iE	Z
    //   117: aload_0
    //   118: dload 13
    //   120: iload 10
    //   122: i2d
    //   123: ddiv
    //   124: putfield 64	com/baidu/location/ay:is	D
    //   127: aload_0
    //   128: dload 11
    //   130: iload 10
    //   132: i2d
    //   133: ddiv
    //   134: putfield 66	com/baidu/location/ay:ir	D
    //   137: aload 5
    //   139: invokevirtual 200	android/database/sqlite/SQLiteDatabase:close	()V
    //   142: return
    //   143: astore 4
    //   145: aconst_null
    //   146: astore 5
    //   148: goto -117 -> 31
    //   151: aload 16
    //   153: getfield 296	android/net/wifi/ScanResult:BSSID	Ljava/lang/String;
    //   156: ldc_w 298
    //   159: ldc_w 300
    //   162: invokevirtual 304	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   165: invokestatic 310	com/baidu/location/Jni:j	(Ljava/lang/String;)Ljava/lang/String;
    //   168: astore 18
    //   170: new 86	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   177: ldc_w 312
    //   180: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload 18
    //   185: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: ldc_w 314
    //   191: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: astore 28
    //   199: aload 5
    //   201: aload 28
    //   203: aconst_null
    //   204: invokevirtual 318	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   207: astore 29
    //   209: aload 29
    //   211: invokeinterface 323 1 0
    //   216: ifeq +481 -> 697
    //   219: aload 29
    //   221: iconst_1
    //   222: invokeinterface 327 2 0
    //   227: ldc2_w 328
    //   230: dsub
    //   231: dstore 30
    //   233: aload 29
    //   235: iconst_2
    //   236: invokeinterface 327 2 0
    //   241: ldc2_w 330
    //   244: dsub
    //   245: dstore 32
    //   247: aload 29
    //   249: iconst_3
    //   250: invokeinterface 335 2 0
    //   255: pop
    //   256: aload 29
    //   258: iconst_4
    //   259: invokeinterface 335 2 0
    //   264: istore 35
    //   266: aload 29
    //   268: iconst_5
    //   269: invokeinterface 335 2 0
    //   274: istore 36
    //   276: aload 29
    //   278: invokeinterface 336 1 0
    //   283: iload 36
    //   285: bipush 8
    //   287: if_icmple +17 -> 304
    //   290: iload 36
    //   292: iload 35
    //   294: if_icmple +10 -> 304
    //   297: iload 17
    //   299: istore 15
    //   301: goto -229 -> 72
    //   304: aload_0
    //   305: getfield 48	com/baidu/location/ay:iy	Z
    //   308: ifeq +49 -> 357
    //   311: iconst_1
    //   312: newarray float
    //   314: astore 57
    //   316: dload 32
    //   318: dload 30
    //   320: aload_0
    //   321: getfield 60	com/baidu/location/ay:iu	D
    //   324: aload_0
    //   325: getfield 58	com/baidu/location/ay:iv	D
    //   328: aload 57
    //   330: invokestatic 342	android/location/Location:distanceBetween	(DDDD[F)V
    //   333: aload 57
    //   335: iconst_0
    //   336: faload
    //   337: f2d
    //   338: ldc2_w 343
    //   341: aload_0
    //   342: getfield 62	com/baidu/location/ay:iz	D
    //   345: dadd
    //   346: dcmpl
    //   347: ifle +441 -> 788
    //   350: iload 17
    //   352: istore 15
    //   354: goto -282 -> 72
    //   357: iload 9
    //   359: ifeq +47 -> 406
    //   362: iconst_1
    //   363: newarray float
    //   365: astore 37
    //   367: dload 32
    //   369: dload 30
    //   371: dload 11
    //   373: iload 10
    //   375: i2d
    //   376: ddiv
    //   377: dload 13
    //   379: iload 10
    //   381: i2d
    //   382: ddiv
    //   383: aload 37
    //   385: invokestatic 342	android/location/Location:distanceBetween	(DDDD[F)V
    //   388: aload 37
    //   390: iconst_0
    //   391: faload
    //   392: ldc_w 345
    //   395: fcmpl
    //   396: ifle +456 -> 852
    //   399: iload 17
    //   401: istore 15
    //   403: goto -331 -> 72
    //   406: aload 8
    //   408: ifnonnull +471 -> 879
    //   411: bipush 8
    //   413: newarray double
    //   415: astore 8
    //   417: iload 7
    //   419: iconst_1
    //   420: iadd
    //   421: istore 38
    //   423: aload 8
    //   425: iload 7
    //   427: dload 30
    //   429: dastore
    //   430: iload 38
    //   432: iconst_1
    //   433: iadd
    //   434: istore 7
    //   436: aload 8
    //   438: iload 38
    //   440: dload 32
    //   442: dastore
    //   443: iload 7
    //   445: istore 20
    //   447: aload 8
    //   449: astore 21
    //   451: iload 9
    //   453: istore 22
    //   455: iload 10
    //   457: istore 23
    //   459: dload 11
    //   461: dstore 24
    //   463: dload 13
    //   465: dstore 26
    //   467: goto +364 -> 831
    //   470: iload 40
    //   472: iload 7
    //   474: if_icmpge +105 -> 579
    //   477: iconst_1
    //   478: newarray float
    //   480: astore 41
    //   482: dload 32
    //   484: dload 30
    //   486: aload 8
    //   488: iload 40
    //   490: iconst_1
    //   491: iadd
    //   492: daload
    //   493: aload 8
    //   495: iload 40
    //   497: daload
    //   498: aload 41
    //   500: invokestatic 342	android/location/Location:distanceBetween	(DDDD[F)V
    //   503: aload 41
    //   505: iconst_0
    //   506: faload
    //   507: fstore 42
    //   509: fload 42
    //   511: ldc_w 345
    //   514: fcmpg
    //   515: ifge +254 -> 769
    //   518: iconst_1
    //   519: istore 43
    //   521: dload 13
    //   523: aload 8
    //   525: iload 40
    //   527: daload
    //   528: dadd
    //   529: dstore 13
    //   531: aload 8
    //   533: iload 40
    //   535: iconst_1
    //   536: iadd
    //   537: daload
    //   538: dstore 50
    //   540: dload 50
    //   542: dload 11
    //   544: dadd
    //   545: dstore 45
    //   547: iload 10
    //   549: iconst_1
    //   550: iadd
    //   551: istore 44
    //   553: dload 13
    //   555: dstore 47
    //   557: iinc 40 2
    //   560: iload 43
    //   562: istore 9
    //   564: iload 44
    //   566: istore 10
    //   568: dload 47
    //   570: dstore 13
    //   572: dload 45
    //   574: dstore 11
    //   576: goto -106 -> 470
    //   579: iload 9
    //   581: ifeq +50 -> 631
    //   584: dload 13
    //   586: dload 30
    //   588: dadd
    //   589: dstore 52
    //   591: dload 11
    //   593: dload 32
    //   595: dadd
    //   596: dstore 54
    //   598: iload 10
    //   600: iconst_1
    //   601: iadd
    //   602: istore 56
    //   604: iload 7
    //   606: istore 20
    //   608: aload 8
    //   610: astore 21
    //   612: iload 9
    //   614: istore 22
    //   616: iload 56
    //   618: istore 23
    //   620: dload 54
    //   622: dstore 24
    //   624: dload 52
    //   626: dstore 26
    //   628: goto +203 -> 831
    //   631: iload 7
    //   633: bipush 8
    //   635: if_icmpge +56 -> 691
    //   638: iload 7
    //   640: iconst_1
    //   641: iadd
    //   642: istore 38
    //   644: aload 8
    //   646: iload 7
    //   648: dload 30
    //   650: dastore
    //   651: iload 38
    //   653: iconst_1
    //   654: iadd
    //   655: istore 7
    //   657: aload 8
    //   659: iload 38
    //   661: dload 32
    //   663: dastore
    //   664: iload 7
    //   666: istore 20
    //   668: aload 8
    //   670: astore 21
    //   672: iload 9
    //   674: istore 22
    //   676: iload 10
    //   678: istore 23
    //   680: dload 11
    //   682: dstore 24
    //   684: dload 13
    //   686: dstore 26
    //   688: goto +143 -> 831
    //   691: aload 5
    //   693: invokevirtual 200	android/database/sqlite/SQLiteDatabase:close	()V
    //   696: return
    //   697: aload 29
    //   699: invokeinterface 336 1 0
    //   704: iload 17
    //   706: istore 15
    //   708: goto -636 -> 72
    //   711: astore 39
    //   713: iload 38
    //   715: istore 20
    //   717: aload 8
    //   719: astore 21
    //   721: iload 9
    //   723: istore 22
    //   725: iload 10
    //   727: istore 23
    //   729: dload 13
    //   731: dstore 26
    //   733: dload 11
    //   735: dstore 24
    //   737: goto +174 -> 911
    //   740: astore 49
    //   742: iload 7
    //   744: istore 20
    //   746: aload 8
    //   748: astore 21
    //   750: iload 43
    //   752: istore 22
    //   754: iload 10
    //   756: istore 23
    //   758: dload 13
    //   760: dstore 26
    //   762: dload 11
    //   764: dstore 24
    //   766: goto +145 -> 911
    //   769: iload 9
    //   771: istore 43
    //   773: iload 10
    //   775: istore 44
    //   777: dload 11
    //   779: dstore 45
    //   781: dload 13
    //   783: dstore 47
    //   785: goto -228 -> 557
    //   788: dload 13
    //   790: dload 30
    //   792: dadd
    //   793: dstore 58
    //   795: dload 11
    //   797: dload 32
    //   799: dadd
    //   800: dstore 60
    //   802: iload 10
    //   804: iconst_1
    //   805: iadd
    //   806: istore 62
    //   808: iload 7
    //   810: istore 20
    //   812: aload 8
    //   814: astore 21
    //   816: iconst_1
    //   817: istore 22
    //   819: iload 62
    //   821: istore 23
    //   823: dload 60
    //   825: dstore 24
    //   827: dload 58
    //   829: dstore 26
    //   831: iload 23
    //   833: iconst_4
    //   834: if_icmple +77 -> 911
    //   837: iload 23
    //   839: istore 10
    //   841: dload 24
    //   843: dstore 11
    //   845: dload 26
    //   847: dstore 13
    //   849: goto -742 -> 107
    //   852: iload 7
    //   854: istore 20
    //   856: aload 8
    //   858: astore 21
    //   860: iload 9
    //   862: istore 22
    //   864: iload 10
    //   866: istore 23
    //   868: dload 11
    //   870: dstore 24
    //   872: dload 13
    //   874: dstore 26
    //   876: goto -45 -> 831
    //   879: iconst_0
    //   880: istore 40
    //   882: goto -412 -> 470
    //   885: astore 19
    //   887: iload 7
    //   889: istore 20
    //   891: aload 8
    //   893: astore 21
    //   895: iload 9
    //   897: istore 22
    //   899: iload 10
    //   901: istore 23
    //   903: dload 11
    //   905: dstore 24
    //   907: dload 13
    //   909: dstore 26
    //   911: iload 20
    //   913: istore 7
    //   915: aload 21
    //   917: astore 8
    //   919: iload 22
    //   921: istore 9
    //   923: iload 23
    //   925: istore 10
    //   927: dload 24
    //   929: dstore 11
    //   931: dload 26
    //   933: dstore 13
    //   935: iload 17
    //   937: istore 15
    //   939: goto -867 -> 72
    //
    // Exception table:
    //   from	to	target	type
    //   17	27	143	java/lang/Exception
    //   423	430	711	java/lang/Exception
    //   644	651	711	java/lang/Exception
    //   521	540	740	java/lang/Exception
    //   170	283	885	java/lang/Exception
    //   304	350	885	java/lang/Exception
    //   362	399	885	java/lang/Exception
    //   411	417	885	java/lang/Exception
    //   436	443	885	java/lang/Exception
    //   477	509	885	java/lang/Exception
    //   657	664	885	java/lang/Exception
    //   691	696	885	java/lang/Exception
    //   697	704	885	java/lang/Exception
  }

  private void jdMethod_if(ar.b paramb, BDLocation paramBDLocation, SQLiteDatabase paramSQLiteDatabase)
  {
    if ((paramBDLocation == null) || (paramBDLocation.getLocType() != 161) || ((!"wf".equals(paramBDLocation.getNetworkLocationType())) && (paramBDLocation.getRadius() >= 300.0F)))
      return;
    while (paramb.jdField_for == null);
    int i = (int)(System.currentTimeMillis() >> 28);
    System.currentTimeMillis();
    Iterator localIterator = paramb.jdField_for.iterator();
    int j = 0;
    while (localIterator.hasNext())
    {
      ScanResult localScanResult = (ScanResult)localIterator.next();
      if (localScanResult.level == 0)
        break;
      int k = j + 1;
      if (k > 6)
        break;
      ContentValues localContentValues = new ContentValues();
      String str = Jni.j(localScanResult.BSSID.replace(":", ""));
      try
      {
        Cursor localCursor = paramSQLiteDatabase.rawQuery("select * from wof where id = \"" + str + "\";", null);
        int n;
        int i1;
        double d1;
        int m;
        double d2;
        if ((localCursor != null) && (localCursor.moveToFirst()))
        {
          double d5 = localCursor.getDouble(1) - 113.2349D;
          double d6 = localCursor.getDouble(2) - 432.12380000000002D;
          localCursor.getInt(3);
          int i4 = localCursor.getInt(4);
          n = localCursor.getInt(5);
          i1 = i4;
          d1 = d5;
          m = 1;
          d2 = d6;
          label265: localCursor.close();
          if (m != 0)
            break label700;
          localContentValues.put("mktime", Double.valueOf(113.2349D + paramBDLocation.getLongitude()));
          localContentValues.put("time", Double.valueOf(432.12380000000002D + paramBDLocation.getLatitude()));
          localContentValues.put("bc", Integer.valueOf(1));
          localContentValues.put("cc", Integer.valueOf(1));
          localContentValues.put("ac", Integer.valueOf(i));
          localContentValues.put("id", str);
          paramSQLiteDatabase.insert("wof", null, localContentValues);
        }
        label693: label700: 
        while (n != 0)
        {
          float[] arrayOfFloat = new float[1];
          Location.distanceBetween(d2, d1, paramBDLocation.getLatitude(), paramBDLocation.getLongitude(), arrayOfFloat);
          int i2;
          if (arrayOfFloat[0] > 1500.0F)
          {
            i2 = n + 1;
            if ((i2 > 10) && (i2 > i1 * 3))
            {
              localContentValues.put("mktime", Double.valueOf(113.2349D + paramBDLocation.getLongitude()));
              localContentValues.put("time", Double.valueOf(432.12380000000002D + paramBDLocation.getLatitude()));
              localContentValues.put("bc", Integer.valueOf(1));
              localContentValues.put("cc", Integer.valueOf(1));
              localContentValues.put("ac", Integer.valueOf(i));
            }
          }
          try
          {
            while (true)
            {
              int i3 = paramSQLiteDatabase.update("wof", localContentValues, "id = \"" + str + "\"", null);
              if (i3 > 0)
                break;
              break;
              localContentValues.put("cc", Integer.valueOf(i2));
              continue;
              double d3 = (d1 * i1 + paramBDLocation.getLongitude()) / (i1 + 1);
              double d4 = (d2 * i1 + paramBDLocation.getLatitude()) / (i1 + 1);
              localContentValues.put("mktime", Double.valueOf(d3 + 113.2349D));
              localContentValues.put("time", Double.valueOf(d4 + 432.12380000000002D));
              localContentValues.put("bc", Integer.valueOf(i1 + 1));
              localContentValues.put("ac", Integer.valueOf(i));
            }
          }
          catch (Exception localException2)
          {
          }
          d1 = 0.0D;
          d2 = 0.0D;
          m = 0;
          n = 0;
          i1 = 0;
          break label265;
          j = k;
          break;
        }
        j = k;
      }
      catch (Exception localException1)
      {
        break label693;
      }
    }
  }

  private void jdMethod_if(String paramString, t.a parama, SQLiteDatabase paramSQLiteDatabase)
  {
    int i = 0;
    double d1 = 0.0D;
    if ((!parama.jdMethod_for()) || (!ah.ay().aA()))
      return;
    System.currentTimeMillis();
    int j = (int)(System.currentTimeMillis() >> 28);
    String str1 = parama.a();
    while (true)
    {
      try
      {
        int k;
        String str2;
        while (true)
        {
          JSONObject localJSONObject1 = new JSONObject(paramString);
          k = Integer.parseInt(localJSONObject1.getJSONObject("result").getString("error"));
          if (k != 161)
            break label370;
          JSONObject localJSONObject2 = localJSONObject1.getJSONObject("content");
          if (!localJSONObject2.has("clf"))
            break label417;
          str2 = localJSONObject2.getString("clf");
          if (str2.equals("0"))
          {
            JSONObject localJSONObject3 = localJSONObject2.getJSONObject("point");
            d1 = Double.parseDouble(localJSONObject3.getString("x"));
            d2 = Double.parseDouble(localJSONObject3.getString("y"));
            float f3 = Float.parseFloat(localJSONObject2.getString("radius"));
            f1 = f3;
            if (i != 0)
              break;
            double d3 = d1 + 1235.4322999999999D;
            double d4 = d2 + 2367.3217D;
            float f2 = 4326.0F + f1;
            ContentValues localContentValues = new ContentValues();
            localContentValues.put("time", Double.valueOf(d3));
            localContentValues.put("tag", Float.valueOf(f2));
            localContentValues.put("type", Double.valueOf(d4));
            localContentValues.put("ac", Integer.valueOf(j));
            try
            {
              if (paramSQLiteDatabase.update("bdcltb09", localContentValues, "id = \"" + str1 + "\"", null) > 0)
                break;
              localContentValues.put("id", str1);
              paramSQLiteDatabase.insert("bdcltb09", null, localContentValues);
              return;
            }
            catch (Exception localException2)
            {
              return;
            }
          }
        }
        String[] arrayOfString = str2.split("\\|");
        d1 = Double.parseDouble(arrayOfString[0]);
        d2 = Double.parseDouble(arrayOfString[1]);
        f1 = Float.parseFloat(arrayOfString[2]);
        i = 0;
        continue;
        label370: if (k == 167)
        {
          paramSQLiteDatabase.delete("bdcltb09", "id = \"" + str1 + "\"", null);
          return;
        }
      }
      catch (Exception localException1)
      {
        return;
      }
      label417: i = 1;
      double d2 = d1;
      float f1 = 0.0F;
    }
  }

  private void k(Message paramMessage)
  {
    k.p().jdMethod_if(jdMethod_case(true), paramMessage);
  }

  private void r(String paramString)
  {
    if ((paramString == null) || (paramString.equals(this.iG)))
      return;
    try
    {
      SQLiteDatabase localSQLiteDatabase2 = SQLiteDatabase.openOrCreateDatabase(this.iB, null);
      localSQLiteDatabase1 = localSQLiteDatabase2;
      if ((localSQLiteDatabase1 == null) || (paramString == null))
      {
        this.iy = false;
        return;
      }
      this.iy = false;
      try
      {
        Cursor localCursor = localSQLiteDatabase1.rawQuery("select * from bdcltb09 where id = \"" + paramString + "\";", null);
        this.iG = paramString;
        this.ip = System.currentTimeMillis();
        if (localCursor != null)
        {
          if (localCursor.moveToFirst())
          {
            this.iv = (localCursor.getDouble(1) - 1235.4322999999999D);
            this.iz = (localCursor.getDouble(2) - 4326.0D);
            this.iu = (localCursor.getDouble(3) - 2367.3217D);
            this.iy = true;
          }
          localCursor.close();
        }
        label168: localSQLiteDatabase1.close();
        return;
      }
      catch (Exception localException2)
      {
        break label168;
      }
    }
    catch (Exception localException1)
    {
      while (true)
        SQLiteDatabase localSQLiteDatabase1 = null;
    }
  }

  public BDLocation jdMethod_case(boolean paramBoolean)
  {
    cf();
    return new BDLocation(jdMethod_byte(paramBoolean));
  }

  public void ch()
  {
  }

  public void ci()
  {
    this.ix = true;
    ab.bj().postDelayed(new ay.1(this), 3000L);
  }

  public void jdMethod_if(String paramString, t.a parama, ar.b paramb, BDLocation paramBDLocation)
  {
    if ((!parama.jdMethod_for()) || (!ah.ay().aA()));
    for (int i = 1; ; i = 0)
    {
      if ((paramBDLocation == null) || (paramBDLocation.getLocType() != 161) || ((!"wf".equals(paramBDLocation.getNetworkLocationType())) && (paramBDLocation.getRadius() >= 300.0F)));
      for (int j = 1; ; j = 0)
      {
        if (paramb.jdField_for == null)
          j = 1;
        if ((i != 0) && (j != 0));
        while (this.iA)
          return;
        this.iA = true;
        new b(null).execute(new Object[] { paramString, parama, paramb, paramBDLocation });
        return;
      }
    }
  }

  public void j(Message paramMessage)
  {
    k(paramMessage);
  }

  private class a extends AsyncTask
  {
    private a()
    {
    }

    protected Boolean a(Boolean[] paramArrayOfBoolean)
    {
      if (paramArrayOfBoolean.length != 4)
        return Boolean.valueOf(false);
      try
      {
        SQLiteDatabase localSQLiteDatabase2 = SQLiteDatabase.openOrCreateDatabase(ay.jdMethod_if(ay.this), null);
        localSQLiteDatabase1 = localSQLiteDatabase2;
        if (localSQLiteDatabase1 == null)
          return Boolean.valueOf(false);
        int i = (int)(System.currentTimeMillis() >> 28);
        try
        {
          localSQLiteDatabase1.beginTransaction();
          String str2;
          if (paramArrayOfBoolean[0].booleanValue())
            str2 = "delete from wof where ac < " + (i - 35);
          try
          {
            localSQLiteDatabase1.execSQL(str2);
            if (paramArrayOfBoolean[1].booleanValue())
              str1 = "delete from bdcltb09 where ac is NULL or ac < " + (i - 130);
          }
          catch (Exception localException4)
          {
            try
            {
              String str1;
              localSQLiteDatabase1.execSQL(str1);
              label130: localSQLiteDatabase1.setTransactionSuccessful();
              localSQLiteDatabase1.endTransaction();
              localSQLiteDatabase1.close();
              label142: return Boolean.valueOf(true);
              localException4 = localException4;
            }
            catch (Exception localException3)
            {
              break label130;
            }
          }
        }
        catch (Exception localException2)
        {
          break label142;
        }
      }
      catch (Exception localException1)
      {
        while (true)
          SQLiteDatabase localSQLiteDatabase1 = null;
      }
    }
  }

  private class b extends AsyncTask
  {
    private b()
    {
    }

    protected Boolean a(Object[] paramArrayOfObject)
    {
      if (paramArrayOfObject.length != 4)
      {
        ay.jdMethod_if(ay.this, false);
        return Boolean.valueOf(false);
      }
      SQLiteDatabase localSQLiteDatabase1;
      try
      {
        SQLiteDatabase localSQLiteDatabase2 = SQLiteDatabase.openOrCreateDatabase(ay.jdMethod_if(ay.this), null);
        localSQLiteDatabase1 = localSQLiteDatabase2;
        if (localSQLiteDatabase1 == null)
        {
          ay.jdMethod_if(ay.this, false);
          return Boolean.valueOf(false);
        }
      }
      catch (Exception localException1)
      {
        while (true)
          localSQLiteDatabase1 = null;
      }
      try
      {
        localSQLiteDatabase1.beginTransaction();
        ay.jdMethod_if(ay.this, (String)paramArrayOfObject[0], (t.a)paramArrayOfObject[1], localSQLiteDatabase1);
        ay.jdMethod_if(ay.this, (ar.b)paramArrayOfObject[2], (BDLocation)paramArrayOfObject[3], localSQLiteDatabase1);
        localSQLiteDatabase1.setTransactionSuccessful();
        localSQLiteDatabase1.endTransaction();
        localSQLiteDatabase1.close();
        label116: ay.jdMethod_if(ay.this, false);
        return Boolean.valueOf(true);
      }
      catch (Exception localException2)
      {
        break label116;
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.location.ay
 * JD-Core Version:    0.6.2
 */