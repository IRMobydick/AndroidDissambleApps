package com.google.android.gms.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.SystemClock;

@ez
public class ec
{
  private static final Object mw = new Object();
  private static final String sG = String.format("CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER)", new Object[] { "InAppPurchase", "purchase_id", "product_id", "developer_payload", "record_time" });
  private static ec sI;
  private final a sH;

  private ec(Context paramContext)
  {
    this.sH = new a(paramContext, "google_inapp_purchase.db");
  }

  public static ec j(Context paramContext)
  {
    synchronized (mw)
    {
      if (sI == null)
        sI = new ec(paramContext);
      ec localec = sI;
      return localec;
    }
  }

  public ea a(Cursor paramCursor)
  {
    if (paramCursor == null)
      return null;
    return new ea(paramCursor.getLong(0), paramCursor.getString(1), paramCursor.getString(2));
  }

  public void a(ea paramea)
  {
    if (paramea == null)
      return;
    SQLiteDatabase localSQLiteDatabase;
    synchronized (mw)
    {
      localSQLiteDatabase = getWritableDatabase();
      if (localSQLiteDatabase == null)
        return;
    }
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = "purchase_id";
    arrayOfObject[1] = Long.valueOf(paramea.sA);
    localSQLiteDatabase.delete("InAppPurchase", String.format("%s = %d", arrayOfObject), null);
  }

  public void b(ea paramea)
  {
    if (paramea == null)
      return;
    SQLiteDatabase localSQLiteDatabase;
    synchronized (mw)
    {
      localSQLiteDatabase = getWritableDatabase();
      if (localSQLiteDatabase == null)
        return;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("product_id", paramea.sC);
    localContentValues.put("developer_payload", paramea.sB);
    localContentValues.put("record_time", Long.valueOf(SystemClock.elapsedRealtime()));
    paramea.sA = localSQLiteDatabase.insert("InAppPurchase", null, localContentValues);
    if (getRecordCount() > 20000L)
      cr();
  }

  // ERROR //
  public void cr()
  {
    // Byte code:
    //   0: getstatic 40	com/google/android/gms/internal/ec:mw	Ljava/lang/Object;
    //   3: astore_1
    //   4: aload_1
    //   5: monitorenter
    //   6: aload_0
    //   7: invokevirtual 80	com/google/android/gms/internal/ec:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   10: astore_3
    //   11: aload_3
    //   12: ifnonnull +6 -> 18
    //   15: aload_1
    //   16: monitorexit
    //   17: return
    //   18: aload_3
    //   19: ldc 19
    //   21: aconst_null
    //   22: aconst_null
    //   23: aconst_null
    //   24: aconst_null
    //   25: aconst_null
    //   26: ldc 138
    //   28: ldc 140
    //   30: invokevirtual 144	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   33: astore 7
    //   35: aload 7
    //   37: astore 5
    //   39: aload 5
    //   41: ifnull +23 -> 64
    //   44: aload 5
    //   46: invokeinterface 148 1 0
    //   51: ifeq +13 -> 64
    //   54: aload_0
    //   55: aload_0
    //   56: aload 5
    //   58: invokevirtual 150	com/google/android/gms/internal/ec:a	(Landroid/database/Cursor;)Lcom/google/android/gms/internal/ea;
    //   61: invokevirtual 152	com/google/android/gms/internal/ec:a	(Lcom/google/android/gms/internal/ea;)V
    //   64: aload 5
    //   66: ifnull +10 -> 76
    //   69: aload 5
    //   71: invokeinterface 155 1 0
    //   76: aload_1
    //   77: monitorexit
    //   78: return
    //   79: astore_2
    //   80: aload_1
    //   81: monitorexit
    //   82: aload_2
    //   83: athrow
    //   84: astore 6
    //   86: aconst_null
    //   87: astore 5
    //   89: new 157	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   96: ldc 160
    //   98: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload 6
    //   103: invokevirtual 167	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   106: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 176	com/google/android/gms/internal/gs:W	(Ljava/lang/String;)V
    //   115: aload 5
    //   117: ifnull -41 -> 76
    //   120: aload 5
    //   122: invokeinterface 155 1 0
    //   127: goto -51 -> 76
    //   130: aload 5
    //   132: ifnull +10 -> 142
    //   135: aload 5
    //   137: invokeinterface 155 1 0
    //   142: aload 4
    //   144: athrow
    //   145: astore 4
    //   147: goto -17 -> 130
    //   150: astore 6
    //   152: goto -63 -> 89
    //   155: astore 4
    //   157: aconst_null
    //   158: astore 5
    //   160: goto -30 -> 130
    //
    // Exception table:
    //   from	to	target	type
    //   6	11	79	finally
    //   15	17	79	finally
    //   69	76	79	finally
    //   76	78	79	finally
    //   80	82	79	finally
    //   120	127	79	finally
    //   135	142	79	finally
    //   142	145	79	finally
    //   18	35	84	android/database/sqlite/SQLiteException
    //   44	64	145	finally
    //   89	115	145	finally
    //   44	64	150	android/database/sqlite/SQLiteException
    //   18	35	155	finally
  }

  // ERROR //
  public java.util.List<ea> d(long paramLong)
  {
    // Byte code:
    //   0: getstatic 40	com/google/android/gms/internal/ec:mw	Ljava/lang/Object;
    //   3: astore_3
    //   4: aload_3
    //   5: monitorenter
    //   6: new 180	java/util/LinkedList
    //   9: dup
    //   10: invokespecial 181	java/util/LinkedList:<init>	()V
    //   13: astore 4
    //   15: lload_1
    //   16: lconst_0
    //   17: lcmp
    //   18: ifgt +8 -> 26
    //   21: aload_3
    //   22: monitorexit
    //   23: aload 4
    //   25: areturn
    //   26: aload_0
    //   27: invokevirtual 80	com/google/android/gms/internal/ec:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   30: astore 6
    //   32: aload 6
    //   34: ifnonnull +8 -> 42
    //   37: aload_3
    //   38: monitorexit
    //   39: aload 4
    //   41: areturn
    //   42: aload 6
    //   44: ldc 19
    //   46: aconst_null
    //   47: aconst_null
    //   48: aconst_null
    //   49: aconst_null
    //   50: aconst_null
    //   51: ldc 138
    //   53: lload_1
    //   54: invokestatic 184	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   57: invokevirtual 144	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   60: astore 10
    //   62: aload 10
    //   64: astore 8
    //   66: aload 8
    //   68: invokeinterface 148 1 0
    //   73: ifeq +31 -> 104
    //   76: aload 4
    //   78: aload_0
    //   79: aload 8
    //   81: invokevirtual 150	com/google/android/gms/internal/ec:a	(Landroid/database/Cursor;)Lcom/google/android/gms/internal/ea;
    //   84: invokeinterface 190 2 0
    //   89: pop
    //   90: aload 8
    //   92: invokeinterface 193 1 0
    //   97: istore 12
    //   99: iload 12
    //   101: ifne -25 -> 76
    //   104: aload 8
    //   106: ifnull +10 -> 116
    //   109: aload 8
    //   111: invokeinterface 155 1 0
    //   116: aload_3
    //   117: monitorexit
    //   118: aload 4
    //   120: areturn
    //   121: astore 9
    //   123: aconst_null
    //   124: astore 8
    //   126: new 157	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   133: ldc 195
    //   135: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload 9
    //   140: invokevirtual 167	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   143: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 176	com/google/android/gms/internal/gs:W	(Ljava/lang/String;)V
    //   152: aload 8
    //   154: ifnull -38 -> 116
    //   157: aload 8
    //   159: invokeinterface 155 1 0
    //   164: goto -48 -> 116
    //   167: astore 5
    //   169: aload_3
    //   170: monitorexit
    //   171: aload 5
    //   173: athrow
    //   174: astore 7
    //   176: aconst_null
    //   177: astore 8
    //   179: aload 8
    //   181: ifnull +10 -> 191
    //   184: aload 8
    //   186: invokeinterface 155 1 0
    //   191: aload 7
    //   193: athrow
    //   194: astore 7
    //   196: goto -17 -> 179
    //   199: astore 9
    //   201: goto -75 -> 126
    //
    // Exception table:
    //   from	to	target	type
    //   42	62	121	android/database/sqlite/SQLiteException
    //   6	15	167	finally
    //   21	23	167	finally
    //   26	32	167	finally
    //   37	39	167	finally
    //   109	116	167	finally
    //   116	118	167	finally
    //   157	164	167	finally
    //   169	171	167	finally
    //   184	191	167	finally
    //   191	194	167	finally
    //   42	62	174	finally
    //   66	76	194	finally
    //   76	99	194	finally
    //   126	152	194	finally
    //   66	76	199	android/database/sqlite/SQLiteException
    //   76	99	199	android/database/sqlite/SQLiteException
  }

  public int getRecordCount()
  {
    Cursor localCursor = null;
    SQLiteDatabase localSQLiteDatabase;
    synchronized (mw)
    {
      localSQLiteDatabase = getWritableDatabase();
      if (localSQLiteDatabase == null)
        return 0;
    }
    try
    {
      localCursor = localSQLiteDatabase.rawQuery("select count(*) from InAppPurchase", null);
      if (localCursor.moveToFirst())
      {
        int i = localCursor.getInt(0);
        if (localCursor != null)
          localCursor.close();
        return i;
        localObject2 = finally;
        throw localObject2;
      }
      if (localCursor != null)
        localCursor.close();
      return 0;
    }
    catch (SQLiteException localSQLiteException)
    {
      while (true)
      {
        gs.W("Error getting record count" + localSQLiteException.getMessage());
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

  public SQLiteDatabase getWritableDatabase()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.sH.getWritableDatabase();
      return localSQLiteDatabase;
    }
    catch (SQLiteException localSQLiteException)
    {
      gs.W("Error opening writable conversion tracking database");
    }
    return null;
  }

  public class a extends SQLiteOpenHelper
  {
    public a(Context paramString, String arg3)
    {
      super(str, null, 4);
    }

    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase.execSQL(ec.cs());
    }

    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      gs.U("Database updated from version " + paramInt1 + " to version " + paramInt2);
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS InAppPurchase");
      onCreate(paramSQLiteDatabase);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ec
 * JD-Core Version:    0.6.2
 */