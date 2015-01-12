package com.google.android.gms.analytics;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.internal.hb;
import com.google.android.gms.internal.ju;
import com.google.android.gms.internal.jw;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.impl.client.DefaultHttpClient;

class ab
  implements d
{
  private static final String AY = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", new Object[] { "hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id" });
  private final a AZ;
  private volatile m Ba;
  private final String Bb;
  private aa Bc;
  private long Bd;
  private final int Be;
  private final Context mContext;
  private ju yD;
  private final e yl;

  ab(e parame, Context paramContext)
  {
    this(parame, paramContext, "google_analytics_v4.db", 2000);
  }

  ab(e parame, Context paramContext, String paramString, int paramInt)
  {
    this.mContext = paramContext.getApplicationContext();
    this.Bb = paramString;
    this.yl = parame;
    this.yD = jw.hA();
    this.AZ = new a(this.mContext, this.Bb);
    this.Ba = new ag(new DefaultHttpClient(), this.mContext);
    this.Bd = 0L;
    this.Be = paramInt;
  }

  static String A(Map<String, String> paramMap)
  {
    ArrayList localArrayList = new ArrayList(paramMap.size());
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localArrayList.add(x.encode((String)localEntry.getKey()) + "=" + x.encode((String)localEntry.getValue()));
    }
    return TextUtils.join("&", localArrayList);
  }

  private void a(Map<String, String> paramMap, long paramLong, String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = al("Error opening database for putHit");
    if (localSQLiteDatabase == null)
      return;
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("hit_string", A(paramMap));
    localContentValues.put("hit_time", Long.valueOf(paramLong));
    if (paramMap.containsKey("AppUID"));
    while (true)
    {
      try
      {
        long l2 = Long.parseLong((String)paramMap.get("AppUID"));
        l1 = l2;
        localContentValues.put("hit_app_id", Long.valueOf(l1));
        if (paramString == null)
          paramString = "http://www.google-analytics.com/collect";
        if (paramString.length() == 0)
        {
          z.W("Empty path: not sending hit");
          return;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        l1 = 0L;
        continue;
        localContentValues.put("hit_url", paramString);
        try
        {
          localSQLiteDatabase.insert("hits2", null, localContentValues);
          this.yl.z(false);
          return;
        }
        catch (SQLiteException localSQLiteException)
        {
          z.W("Error storing hit");
          return;
        }
      }
      long l1 = 0L;
    }
  }

  private void a(Map<String, String> paramMap, Collection<hb> paramCollection)
  {
    String str = "&_v".substring(1);
    if (paramCollection != null)
    {
      Iterator localIterator = paramCollection.iterator();
      while (localIterator.hasNext())
      {
        hb localhb = (hb)localIterator.next();
        if ("appendVersion".equals(localhb.getId()))
          paramMap.put(str, localhb.getValue());
      }
    }
  }

  private SQLiteDatabase al(String paramString)
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.AZ.getWritableDatabase();
      return localSQLiteDatabase;
    }
    catch (SQLiteException localSQLiteException)
    {
      z.W(paramString);
    }
    return null;
  }

  private void eM()
  {
    int i = 1 + (eO() - this.Be);
    if (i > 0)
    {
      List localList = F(i);
      z.V("Store full, deleting " + localList.size() + " hits to make room.");
      b((String[])localList.toArray(new String[0]));
    }
  }

  // ERROR //
  List<String> F(int paramInt)
  {
    // Byte code:
    //   0: new 103	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 307	java/util/ArrayList:<init>	()V
    //   7: astore_2
    //   8: iload_1
    //   9: ifgt +11 -> 20
    //   12: ldc_w 309
    //   15: invokestatic 230	com/google/android/gms/analytics/z:W	(Ljava/lang/String;)V
    //   18: aload_2
    //   19: areturn
    //   20: aload_0
    //   21: ldc_w 311
    //   24: invokespecial 186	com/google/android/gms/analytics/ab:al	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
    //   27: astore_3
    //   28: aload_3
    //   29: ifnonnull +5 -> 34
    //   32: aload_2
    //   33: areturn
    //   34: aload_3
    //   35: ldc 31
    //   37: iconst_1
    //   38: anewarray 43	java/lang/String
    //   41: dup
    //   42: iconst_0
    //   43: ldc 33
    //   45: aastore
    //   46: aconst_null
    //   47: aconst_null
    //   48: aconst_null
    //   49: aconst_null
    //   50: ldc_w 313
    //   53: iconst_1
    //   54: anewarray 4	java/lang/Object
    //   57: dup
    //   58: iconst_0
    //   59: ldc 33
    //   61: aastore
    //   62: invokestatic 47	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   65: iload_1
    //   66: invokestatic 317	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   69: invokevirtual 321	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   72: astore 7
    //   74: aload 7
    //   76: astore 5
    //   78: aload 5
    //   80: invokeinterface 326 1 0
    //   85: ifeq +35 -> 120
    //   88: aload_2
    //   89: aload 5
    //   91: iconst_0
    //   92: invokeinterface 330 2 0
    //   97: invokestatic 333	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   100: invokeinterface 165 2 0
    //   105: pop
    //   106: aload 5
    //   108: invokeinterface 336 1 0
    //   113: istore 9
    //   115: iload 9
    //   117: ifne -29 -> 88
    //   120: aload 5
    //   122: ifnull +10 -> 132
    //   125: aload 5
    //   127: invokeinterface 339 1 0
    //   132: aload_2
    //   133: areturn
    //   134: astore 6
    //   136: aconst_null
    //   137: astore 5
    //   139: new 136	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   146: ldc_w 341
    //   149: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload 6
    //   154: invokevirtual 344	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   157: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 230	com/google/android/gms/analytics/z:W	(Ljava/lang/String;)V
    //   166: aload 5
    //   168: ifnull -36 -> 132
    //   171: aload 5
    //   173: invokeinterface 339 1 0
    //   178: goto -46 -> 132
    //   181: astore 4
    //   183: aconst_null
    //   184: astore 5
    //   186: aload 5
    //   188: ifnull +10 -> 198
    //   191: aload 5
    //   193: invokeinterface 339 1 0
    //   198: aload 4
    //   200: athrow
    //   201: astore 4
    //   203: goto -17 -> 186
    //   206: astore 6
    //   208: goto -69 -> 139
    //
    // Exception table:
    //   from	to	target	type
    //   34	74	134	android/database/sqlite/SQLiteException
    //   34	74	181	finally
    //   78	88	201	finally
    //   88	115	201	finally
    //   139	166	201	finally
    //   78	88	206	android/database/sqlite/SQLiteException
    //   88	115	206	android/database/sqlite/SQLiteException
  }

  // ERROR //
  public List<w> G(int paramInt)
  {
    // Byte code:
    //   0: new 103	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 307	java/util/ArrayList:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: ldc_w 347
    //   12: invokespecial 186	com/google/android/gms/analytics/ab:al	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
    //   15: astore_3
    //   16: aload_3
    //   17: ifnonnull +9 -> 26
    //   20: aload_2
    //   21: astore 9
    //   23: aload 9
    //   25: areturn
    //   26: aconst_null
    //   27: astore 4
    //   29: aload_3
    //   30: ldc 31
    //   32: iconst_2
    //   33: anewarray 43	java/lang/String
    //   36: dup
    //   37: iconst_0
    //   38: ldc 33
    //   40: aastore
    //   41: dup
    //   42: iconst_1
    //   43: ldc 35
    //   45: aastore
    //   46: aconst_null
    //   47: aconst_null
    //   48: aconst_null
    //   49: aconst_null
    //   50: ldc_w 313
    //   53: iconst_1
    //   54: anewarray 4	java/lang/Object
    //   57: dup
    //   58: iconst_0
    //   59: ldc 33
    //   61: aastore
    //   62: invokestatic 47	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   65: iload_1
    //   66: invokestatic 317	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   69: invokevirtual 321	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   72: astore 10
    //   74: aload 10
    //   76: astore 11
    //   78: new 103	java/util/ArrayList
    //   81: dup
    //   82: invokespecial 307	java/util/ArrayList:<init>	()V
    //   85: astore 12
    //   87: aload 11
    //   89: invokeinterface 326 1 0
    //   94: ifeq +49 -> 143
    //   97: aload 12
    //   99: new 349	com/google/android/gms/analytics/w
    //   102: dup
    //   103: aconst_null
    //   104: aload 11
    //   106: iconst_0
    //   107: invokeinterface 330 2 0
    //   112: aload 11
    //   114: iconst_1
    //   115: invokeinterface 330 2 0
    //   120: invokespecial 352	com/google/android/gms/analytics/w:<init>	(Ljava/lang/String;JJ)V
    //   123: invokeinterface 165 2 0
    //   128: pop
    //   129: aload 11
    //   131: invokeinterface 336 1 0
    //   136: istore 15
    //   138: iload 15
    //   140: ifne -43 -> 97
    //   143: aload 11
    //   145: ifnull +10 -> 155
    //   148: aload 11
    //   150: invokeinterface 339 1 0
    //   155: aload_3
    //   156: ldc 31
    //   158: iconst_3
    //   159: anewarray 43	java/lang/String
    //   162: dup
    //   163: iconst_0
    //   164: ldc 33
    //   166: aastore
    //   167: dup
    //   168: iconst_1
    //   169: ldc 39
    //   171: aastore
    //   172: dup
    //   173: iconst_2
    //   174: ldc 37
    //   176: aastore
    //   177: aconst_null
    //   178: aconst_null
    //   179: aconst_null
    //   180: aconst_null
    //   181: ldc_w 313
    //   184: iconst_1
    //   185: anewarray 4	java/lang/Object
    //   188: dup
    //   189: iconst_0
    //   190: ldc 33
    //   192: aastore
    //   193: invokestatic 47	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   196: iload_1
    //   197: invokestatic 317	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   200: invokevirtual 321	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   203: astore 24
    //   205: aload 24
    //   207: invokeinterface 326 1 0
    //   212: ifeq +86 -> 298
    //   215: iconst_0
    //   216: istore 25
    //   218: aload 24
    //   220: checkcast 354	android/database/sqlite/SQLiteCursor
    //   223: invokevirtual 358	android/database/sqlite/SQLiteCursor:getWindow	()Landroid/database/CursorWindow;
    //   226: invokevirtual 363	android/database/CursorWindow:getNumRows	()I
    //   229: ifle +155 -> 384
    //   232: aload 12
    //   234: iload 25
    //   236: invokeinterface 366 2 0
    //   241: checkcast 349	com/google/android/gms/analytics/w
    //   244: aload 24
    //   246: iconst_1
    //   247: invokeinterface 369 2 0
    //   252: invokevirtual 372	com/google/android/gms/analytics/w:aj	(Ljava/lang/String;)V
    //   255: aload 12
    //   257: iload 25
    //   259: invokeinterface 366 2 0
    //   264: checkcast 349	com/google/android/gms/analytics/w
    //   267: aload 24
    //   269: iconst_2
    //   270: invokeinterface 369 2 0
    //   275: invokevirtual 375	com/google/android/gms/analytics/w:ak	(Ljava/lang/String;)V
    //   278: iload 25
    //   280: iconst_1
    //   281: iadd
    //   282: istore 27
    //   284: aload 24
    //   286: invokeinterface 336 1 0
    //   291: istore 28
    //   293: iload 28
    //   295: ifne +340 -> 635
    //   298: aload 24
    //   300: ifnull +10 -> 310
    //   303: aload 24
    //   305: invokeinterface 339 1 0
    //   310: aload 12
    //   312: areturn
    //   313: astore 6
    //   315: aload 6
    //   317: astore 7
    //   319: aconst_null
    //   320: astore 8
    //   322: aload_2
    //   323: astore 9
    //   325: new 136	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   332: ldc_w 341
    //   335: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: aload 7
    //   340: invokevirtual 344	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   343: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: invokestatic 230	com/google/android/gms/analytics/z:W	(Ljava/lang/String;)V
    //   352: aload 8
    //   354: ifnull -331 -> 23
    //   357: aload 8
    //   359: invokeinterface 339 1 0
    //   364: aload 9
    //   366: areturn
    //   367: astore 5
    //   369: aload 4
    //   371: ifnull +10 -> 381
    //   374: aload 4
    //   376: invokeinterface 339 1 0
    //   381: aload 5
    //   383: athrow
    //   384: iconst_1
    //   385: anewarray 4	java/lang/Object
    //   388: astore 26
    //   390: aload 26
    //   392: iconst_0
    //   393: aload 12
    //   395: iload 25
    //   397: invokeinterface 366 2 0
    //   402: checkcast 349	com/google/android/gms/analytics/w
    //   405: invokevirtual 379	com/google/android/gms/analytics/w:eG	()J
    //   408: invokestatic 201	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   411: aastore
    //   412: ldc_w 381
    //   415: aload 26
    //   417: invokestatic 47	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   420: invokestatic 230	com/google/android/gms/analytics/z:W	(Ljava/lang/String;)V
    //   423: goto -145 -> 278
    //   426: astore 16
    //   428: aload 24
    //   430: astore 11
    //   432: new 136	java/lang/StringBuilder
    //   435: dup
    //   436: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   439: ldc_w 383
    //   442: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: aload 16
    //   447: invokevirtual 344	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   450: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   456: invokestatic 230	com/google/android/gms/analytics/z:W	(Ljava/lang/String;)V
    //   459: new 103	java/util/ArrayList
    //   462: dup
    //   463: invokespecial 307	java/util/ArrayList:<init>	()V
    //   466: astore 18
    //   468: iconst_0
    //   469: istore 19
    //   471: aload 12
    //   473: invokeinterface 384 1 0
    //   478: astore 20
    //   480: aload 20
    //   482: invokeinterface 128 1 0
    //   487: ifeq +35 -> 522
    //   490: aload 20
    //   492: invokeinterface 132 1 0
    //   497: checkcast 349	com/google/android/gms/analytics/w
    //   500: astore 21
    //   502: aload 21
    //   504: invokevirtual 387	com/google/android/gms/analytics/w:eF	()Ljava/lang/String;
    //   507: invokestatic 391	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   510: istore 22
    //   512: iload 22
    //   514: ifeq +26 -> 540
    //   517: iload 19
    //   519: ifeq +18 -> 537
    //   522: aload 11
    //   524: ifnull +10 -> 534
    //   527: aload 11
    //   529: invokeinterface 339 1 0
    //   534: aload 18
    //   536: areturn
    //   537: iconst_1
    //   538: istore 19
    //   540: aload 18
    //   542: aload 21
    //   544: invokeinterface 165 2 0
    //   549: pop
    //   550: goto -70 -> 480
    //   553: astore 17
    //   555: aload 11
    //   557: ifnull +10 -> 567
    //   560: aload 11
    //   562: invokeinterface 339 1 0
    //   567: aload 17
    //   569: athrow
    //   570: astore 17
    //   572: aload 24
    //   574: astore 11
    //   576: goto -21 -> 555
    //   579: astore 16
    //   581: goto -149 -> 432
    //   584: astore 5
    //   586: aload 11
    //   588: astore 4
    //   590: goto -221 -> 369
    //   593: astore 5
    //   595: aload 8
    //   597: astore 4
    //   599: goto -230 -> 369
    //   602: astore 29
    //   604: aload 29
    //   606: astore 7
    //   608: aload 11
    //   610: astore 8
    //   612: aload_2
    //   613: astore 9
    //   615: goto -290 -> 325
    //   618: astore 13
    //   620: aload 13
    //   622: astore 7
    //   624: aload 11
    //   626: astore 8
    //   628: aload 12
    //   630: astore 9
    //   632: goto -307 -> 325
    //   635: iload 27
    //   637: istore 25
    //   639: goto -421 -> 218
    //
    // Exception table:
    //   from	to	target	type
    //   29	74	313	android/database/sqlite/SQLiteException
    //   29	74	367	finally
    //   205	215	426	android/database/sqlite/SQLiteException
    //   218	278	426	android/database/sqlite/SQLiteException
    //   284	293	426	android/database/sqlite/SQLiteException
    //   384	423	426	android/database/sqlite/SQLiteException
    //   155	205	553	finally
    //   432	468	553	finally
    //   471	480	553	finally
    //   480	512	553	finally
    //   540	550	553	finally
    //   205	215	570	finally
    //   218	278	570	finally
    //   284	293	570	finally
    //   384	423	570	finally
    //   155	205	579	android/database/sqlite/SQLiteException
    //   78	87	584	finally
    //   87	97	584	finally
    //   97	138	584	finally
    //   325	352	593	finally
    //   78	87	602	android/database/sqlite/SQLiteException
    //   87	97	618	android/database/sqlite/SQLiteException
    //   97	138	618	android/database/sqlite/SQLiteException
  }

  public void a(Map<String, String> paramMap, long paramLong, String paramString, Collection<hb> paramCollection)
  {
    eN();
    eM();
    a(paramMap, paramCollection);
    a(paramMap, paramLong, paramString);
  }

  @Deprecated
  void b(Collection<w> paramCollection)
  {
    if ((paramCollection == null) || (paramCollection.isEmpty()))
    {
      z.W("Empty/Null collection passed to deleteHits.");
      return;
    }
    String[] arrayOfString = new String[paramCollection.size()];
    Iterator localIterator = paramCollection.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      w localw = (w)localIterator.next();
      j = i + 1;
      arrayOfString[i] = String.valueOf(localw.eG());
    }
    b(arrayOfString);
  }

  void b(String[] paramArrayOfString)
  {
    boolean bool = true;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
      z.W("Empty hitIds passed to deleteHits.");
    SQLiteDatabase localSQLiteDatabase;
    do
    {
      return;
      localSQLiteDatabase = al("Error opening database for deleteHits.");
    }
    while (localSQLiteDatabase == null);
    Object[] arrayOfObject = new Object[bool];
    arrayOfObject[0] = TextUtils.join(",", Collections.nCopies(paramArrayOfString.length, "?"));
    String str = String.format("HIT_ID in (%s)", arrayOfObject);
    while (true)
    {
      try
      {
        localSQLiteDatabase.delete("hits2", str, paramArrayOfString);
        e locale = this.yl;
        if (eO() == 0)
        {
          locale.z(bool);
          return;
        }
      }
      catch (SQLiteException localSQLiteException)
      {
        z.W("Error deleting hits " + TextUtils.join(",", paramArrayOfString));
        return;
      }
      bool = false;
    }
  }

  public m dM()
  {
    return this.Ba;
  }

  public void dispatch()
  {
    boolean bool = true;
    z.V("Dispatch running...");
    if (!this.Ba.dX())
      return;
    List localList = G(40);
    if (localList.isEmpty())
    {
      z.V("...nothing to dispatch");
      this.yl.z(bool);
      return;
    }
    if (this.Bc == null)
      this.Bc = new aa("_t=dispatch&_v=ma4.0.3", bool);
    if (eO() <= localList.size());
    while (true)
    {
      int i = this.Ba.a(localList, this.Bc, bool);
      z.V("sent " + i + " of " + localList.size() + " hits");
      b(localList.subList(0, Math.min(i, localList.size())));
      if ((i != localList.size()) || (eO() <= 0))
        break;
      GoogleAnalytics.getInstance(this.mContext).dispatchLocalHits();
      return;
      bool = false;
    }
    this.Bc = null;
  }

  int eN()
  {
    boolean bool = true;
    long l1 = this.yD.currentTimeMillis();
    if (l1 <= 86400000L + this.Bd);
    SQLiteDatabase localSQLiteDatabase;
    do
    {
      return 0;
      this.Bd = l1;
      localSQLiteDatabase = al("Error opening database for deleteStaleHits.");
    }
    while (localSQLiteDatabase == null);
    long l2 = this.yD.currentTimeMillis() - 2592000000L;
    String[] arrayOfString = new String[bool];
    arrayOfString[0] = Long.toString(l2);
    int i = localSQLiteDatabase.delete("hits2", "HIT_TIME < ?", arrayOfString);
    e locale = this.yl;
    if (eO() == 0);
    while (true)
    {
      locale.z(bool);
      return i;
      bool = false;
    }
  }

  int eO()
  {
    Cursor localCursor = null;
    SQLiteDatabase localSQLiteDatabase = al("Error opening database for getNumStoredHits.");
    int i = 0;
    if (localSQLiteDatabase == null);
    while (true)
    {
      return i;
      try
      {
        localCursor = localSQLiteDatabase.rawQuery("SELECT COUNT(*) from hits2", null);
        boolean bool = localCursor.moveToFirst();
        i = 0;
        if (bool)
        {
          long l = localCursor.getLong(0);
          i = (int)l;
        }
        return i;
      }
      catch (SQLiteException localSQLiteException)
      {
        z.W("Error getting numStoredHits");
        i = 0;
        return 0;
      }
      finally
      {
        if (localCursor != null)
          localCursor.close();
      }
    }
  }

  public void l(long paramLong)
  {
    boolean bool = true;
    SQLiteDatabase localSQLiteDatabase = al("Error opening database for clearHits");
    e locale;
    if (localSQLiteDatabase != null)
    {
      if (paramLong != 0L)
        break label54;
      localSQLiteDatabase.delete("hits2", null, null);
      locale = this.yl;
      if (eO() != 0)
        break label87;
    }
    while (true)
    {
      locale.z(bool);
      return;
      label54: String[] arrayOfString = new String[bool];
      arrayOfString[0] = Long.valueOf(paramLong).toString();
      localSQLiteDatabase.delete("hits2", "hit_app_id = ?", arrayOfString);
      break;
      label87: bool = false;
    }
  }

  class a extends SQLiteOpenHelper
  {
    private boolean Bf;
    private long Bg = 0L;

    a(Context paramString, String arg3)
    {
      super(str, null, 1);
    }

    private void a(SQLiteDatabase paramSQLiteDatabase)
    {
      Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM hits2 WHERE 0", null);
      HashSet localHashSet = new HashSet();
      try
      {
        String[] arrayOfString = localCursor.getColumnNames();
        for (int i = 0; i < arrayOfString.length; i++)
          localHashSet.add(arrayOfString[i]);
        localCursor.close();
        if ((!localHashSet.remove("hit_id")) || (!localHashSet.remove("hit_url")) || (!localHashSet.remove("hit_string")) || (!localHashSet.remove("hit_time")))
          throw new SQLiteException("Database column missing");
      }
      finally
      {
        localCursor.close();
      }
      boolean bool = localHashSet.remove("hit_app_id");
      int j = 0;
      if (!bool)
        j = 1;
      if (!localHashSet.isEmpty())
        throw new SQLiteException("Database has extra columns");
      if (j != 0)
        paramSQLiteDatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id");
    }

    // ERROR //
    private boolean a(String paramString, SQLiteDatabase paramSQLiteDatabase)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_3
      //   2: aload_2
      //   3: ldc 83
      //   5: iconst_1
      //   6: anewarray 85	java/lang/String
      //   9: dup
      //   10: iconst_0
      //   11: ldc 87
      //   13: aastore
      //   14: ldc 89
      //   16: iconst_1
      //   17: anewarray 85	java/lang/String
      //   20: dup
      //   21: iconst_0
      //   22: aload_1
      //   23: aastore
      //   24: aconst_null
      //   25: aconst_null
      //   26: aconst_null
      //   27: invokevirtual 93	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   30: astore 8
      //   32: aload 8
      //   34: invokeinterface 96 1 0
      //   39: istore 10
      //   41: aload 8
      //   43: ifnull +10 -> 53
      //   46: aload 8
      //   48: invokeinterface 49 1 0
      //   53: iload 10
      //   55: ireturn
      //   56: astore 5
      //   58: aconst_null
      //   59: astore 6
      //   61: new 98	java/lang/StringBuilder
      //   64: dup
      //   65: invokespecial 99	java/lang/StringBuilder:<init>	()V
      //   68: ldc 101
      //   70: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   73: aload_1
      //   74: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   77: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   80: invokestatic 114	com/google/android/gms/analytics/z:W	(Ljava/lang/String;)V
      //   83: aload 6
      //   85: ifnull +10 -> 95
      //   88: aload 6
      //   90: invokeinterface 49 1 0
      //   95: iconst_0
      //   96: ireturn
      //   97: astore 4
      //   99: aload_3
      //   100: ifnull +9 -> 109
      //   103: aload_3
      //   104: invokeinterface 49 1 0
      //   109: aload 4
      //   111: athrow
      //   112: astore 4
      //   114: aload 8
      //   116: astore_3
      //   117: goto -18 -> 99
      //   120: astore 7
      //   122: aload 6
      //   124: astore_3
      //   125: aload 7
      //   127: astore 4
      //   129: goto -30 -> 99
      //   132: astore 9
      //   134: aload 8
      //   136: astore 6
      //   138: goto -77 -> 61
      //
      // Exception table:
      //   from	to	target	type
      //   2	32	56	android/database/sqlite/SQLiteException
      //   2	32	97	finally
      //   32	41	112	finally
      //   61	83	120	finally
      //   32	41	132	android/database/sqlite/SQLiteException
    }

    public SQLiteDatabase getWritableDatabase()
    {
      if ((this.Bf) && (3600000L + this.Bg > ab.a(ab.this).currentTimeMillis()))
        throw new SQLiteException("Database creation failed");
      this.Bf = true;
      this.Bg = ab.a(ab.this).currentTimeMillis();
      try
      {
        SQLiteDatabase localSQLiteDatabase2 = super.getWritableDatabase();
        localSQLiteDatabase1 = localSQLiteDatabase2;
        if (localSQLiteDatabase1 == null)
          localSQLiteDatabase1 = super.getWritableDatabase();
        this.Bf = false;
        return localSQLiteDatabase1;
      }
      catch (SQLiteException localSQLiteException)
      {
        while (true)
        {
          ab.c(ab.this).getDatabasePath(ab.b(ab.this)).delete();
          SQLiteDatabase localSQLiteDatabase1 = null;
        }
      }
    }

    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      o.ag(paramSQLiteDatabase.getPath());
    }

    public void onOpen(SQLiteDatabase paramSQLiteDatabase)
    {
      Cursor localCursor;
      if (Build.VERSION.SDK_INT < 15)
        localCursor = paramSQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
      try
      {
        localCursor.moveToFirst();
        localCursor.close();
        if (!a("hits2", paramSQLiteDatabase))
        {
          paramSQLiteDatabase.execSQL(ab.eP());
          return;
        }
      }
      finally
      {
        localCursor.close();
      }
      a(paramSQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.ab
 * JD-Core Version:    0.6.2
 */