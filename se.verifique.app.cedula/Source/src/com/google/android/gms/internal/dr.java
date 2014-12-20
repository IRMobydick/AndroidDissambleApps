package com.google.android.gms.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

public class dr
{
  private static final String a;
  private static final Object c;
  private static dr d;
  private final dt b;

  static
  {
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = "InAppPurchase";
    arrayOfObject[1] = "purchase_id";
    arrayOfObject[2] = "product_id";
    arrayOfObject[3] = "developer_payload";
    arrayOfObject[4] = "record_time";
    a = String.format("CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER)", arrayOfObject);
    c = new Object();
  }

  private dr(Context paramContext)
  {
    this.b = new dt(this, paramContext, "google_inapp_purchase.db");
  }

  public static dr a(Context paramContext)
  {
    synchronized (c)
    {
      if (d == null)
        d = new dr(paramContext);
      dr localdr = d;
      return localdr;
    }
  }

  public SQLiteDatabase a()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase2 = this.b.getWritableDatabase();
      localSQLiteDatabase1 = localSQLiteDatabase2;
      return localSQLiteDatabase1;
    }
    catch (SQLiteException localSQLiteException)
    {
      while (true)
      {
        hi.e("Error opening writable conversion tracking database");
        SQLiteDatabase localSQLiteDatabase1 = null;
      }
    }
  }

  public dp a(Cursor paramCursor)
  {
    if (paramCursor == null);
    for (dp localdp = null; ; localdp = new dp(paramCursor.getLong(0), paramCursor.getString(1), paramCursor.getString(2)))
      return localdp;
  }

  // ERROR //
  public java.util.List a(long paramLong)
  {
    // Byte code:
    //   0: getstatic 39	com/google/android/gms/internal/dr:c	Ljava/lang/Object;
    //   3: astore_3
    //   4: aload_3
    //   5: monitorenter
    //   6: new 88	java/util/LinkedList
    //   9: dup
    //   10: invokespecial 89	java/util/LinkedList:<init>	()V
    //   13: astore 4
    //   15: lload_1
    //   16: lconst_0
    //   17: lcmp
    //   18: ifgt +12 -> 30
    //   21: aload_3
    //   22: monitorexit
    //   23: aload 4
    //   25: astore 10
    //   27: goto +189 -> 216
    //   30: aload_0
    //   31: invokevirtual 91	com/google/android/gms/internal/dr:a	()Landroid/database/sqlite/SQLiteDatabase;
    //   34: astore 6
    //   36: aload 6
    //   38: ifnonnull +12 -> 50
    //   41: aload_3
    //   42: monitorexit
    //   43: aload 4
    //   45: astore 10
    //   47: goto +169 -> 216
    //   50: aload 6
    //   52: ldc 16
    //   54: aconst_null
    //   55: aconst_null
    //   56: aconst_null
    //   57: aconst_null
    //   58: aconst_null
    //   59: ldc 93
    //   61: lload_1
    //   62: invokestatic 97	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   65: invokevirtual 103	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   68: astore 11
    //   70: aload 11
    //   72: astore 8
    //   74: aload 8
    //   76: invokeinterface 107 1 0
    //   81: ifeq +31 -> 112
    //   84: aload 4
    //   86: aload_0
    //   87: aload 8
    //   89: invokevirtual 109	com/google/android/gms/internal/dr:a	(Landroid/database/Cursor;)Lcom/google/android/gms/internal/dp;
    //   92: invokeinterface 115 2 0
    //   97: pop
    //   98: aload 8
    //   100: invokeinterface 118 1 0
    //   105: istore 13
    //   107: iload 13
    //   109: ifne -25 -> 84
    //   112: aload 8
    //   114: ifnull +10 -> 124
    //   117: aload 8
    //   119: invokeinterface 121 1 0
    //   124: aload_3
    //   125: monitorexit
    //   126: aload 4
    //   128: astore 10
    //   130: goto +86 -> 216
    //   133: astore 9
    //   135: aconst_null
    //   136: astore 8
    //   138: new 123	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   145: ldc 126
    //   147: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload 9
    //   152: invokevirtual 133	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   155: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 69	com/google/android/gms/internal/hi:e	(Ljava/lang/String;)V
    //   164: aload 8
    //   166: ifnull -42 -> 124
    //   169: aload 8
    //   171: invokeinterface 121 1 0
    //   176: goto -52 -> 124
    //   179: astore 5
    //   181: aload_3
    //   182: monitorexit
    //   183: aload 5
    //   185: athrow
    //   186: astore 7
    //   188: aconst_null
    //   189: astore 8
    //   191: aload 8
    //   193: ifnull +10 -> 203
    //   196: aload 8
    //   198: invokeinterface 121 1 0
    //   203: aload 7
    //   205: athrow
    //   206: astore 7
    //   208: goto -17 -> 191
    //   211: astore 9
    //   213: goto -75 -> 138
    //   216: aload 10
    //   218: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   50	70	133	android/database/sqlite/SQLiteException
    //   6	43	179	finally
    //   117	126	179	finally
    //   169	183	179	finally
    //   196	206	179	finally
    //   50	70	186	finally
    //   74	107	206	finally
    //   138	164	206	finally
    //   74	107	211	android/database/sqlite/SQLiteException
  }

  // ERROR //
  public void a(dp paramdp)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: getstatic 39	com/google/android/gms/internal/dr:c	Ljava/lang/Object;
    //   8: astore_2
    //   9: aload_2
    //   10: monitorenter
    //   11: aload_0
    //   12: invokevirtual 91	com/google/android/gms/internal/dr:a	()Landroid/database/sqlite/SQLiteDatabase;
    //   15: astore 4
    //   17: aload 4
    //   19: ifnonnull +13 -> 32
    //   22: aload_2
    //   23: monitorexit
    //   24: goto -20 -> 4
    //   27: astore_3
    //   28: aload_2
    //   29: monitorexit
    //   30: aload_3
    //   31: athrow
    //   32: iconst_2
    //   33: anewarray 4	java/lang/Object
    //   36: astore 5
    //   38: aload 5
    //   40: iconst_0
    //   41: ldc 18
    //   43: aastore
    //   44: aload 5
    //   46: iconst_1
    //   47: aload_1
    //   48: getfield 140	com/google/android/gms/internal/dp:a	J
    //   51: invokestatic 145	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   54: aastore
    //   55: aload 4
    //   57: ldc 16
    //   59: ldc 147
    //   61: aload 5
    //   63: invokestatic 32	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   66: aconst_null
    //   67: invokevirtual 151	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   70: pop
    //   71: aload_2
    //   72: monitorexit
    //   73: goto -69 -> 4
    //
    // Exception table:
    //   from	to	target	type
    //   11	30	27	finally
    //   32	73	27	finally
  }

  public int b()
  {
    Cursor localCursor = null;
    int i = 0;
    while (true)
    {
      SQLiteDatabase localSQLiteDatabase;
      synchronized (c)
      {
        localSQLiteDatabase = a();
        if (localSQLiteDatabase == null)
          return i;
      }
      try
      {
        localCursor = localSQLiteDatabase.rawQuery("select count(*) from InAppPurchase", null);
        if (localCursor.moveToFirst())
        {
          int j = localCursor.getInt(0);
          i = j;
          if (localCursor != null)
            localCursor.close();
          monitorexit;
          continue;
          localObject2 = finally;
          monitorexit;
          throw localObject2;
        }
        if (localCursor != null)
          localCursor.close();
        monitorexit;
        continue;
      }
      catch (SQLiteException localSQLiteException)
      {
        while (true)
        {
          hi.e("Error getting record count" + localSQLiteException.getMessage());
          if (localCursor == null)
            continue;
          localCursor.close();
        }
      }
      finally
      {
        if (localCursor != null)
          localCursor.close();
      }
    }
    throw localObject3;
  }

  // ERROR //
  public void b(dp paramdp)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: getstatic 39	com/google/android/gms/internal/dr:c	Ljava/lang/Object;
    //   8: astore_2
    //   9: aload_2
    //   10: monitorenter
    //   11: aload_0
    //   12: invokevirtual 91	com/google/android/gms/internal/dr:a	()Landroid/database/sqlite/SQLiteDatabase;
    //   15: astore 4
    //   17: aload 4
    //   19: ifnonnull +13 -> 32
    //   22: aload_2
    //   23: monitorexit
    //   24: goto -20 -> 4
    //   27: astore_3
    //   28: aload_2
    //   29: monitorexit
    //   30: aload_3
    //   31: athrow
    //   32: new 166	android/content/ContentValues
    //   35: dup
    //   36: invokespecial 167	android/content/ContentValues:<init>	()V
    //   39: astore 5
    //   41: aload 5
    //   43: ldc 20
    //   45: aload_1
    //   46: getfield 169	com/google/android/gms/internal/dp:c	Ljava/lang/String;
    //   49: invokevirtual 173	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: aload 5
    //   54: ldc 22
    //   56: aload_1
    //   57: getfield 175	com/google/android/gms/internal/dp:b	Ljava/lang/String;
    //   60: invokevirtual 173	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: aload 5
    //   65: ldc 24
    //   67: invokestatic 181	android/os/SystemClock:elapsedRealtime	()J
    //   70: invokestatic 145	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   73: invokevirtual 184	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   76: aload_1
    //   77: aload 4
    //   79: ldc 16
    //   81: aconst_null
    //   82: aload 5
    //   84: invokevirtual 188	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   87: putfield 140	com/google/android/gms/internal/dp:a	J
    //   90: aload_0
    //   91: invokevirtual 190	com/google/android/gms/internal/dr:b	()I
    //   94: i2l
    //   95: ldc2_w 191
    //   98: lcmp
    //   99: ifle +7 -> 106
    //   102: aload_0
    //   103: invokevirtual 194	com/google/android/gms/internal/dr:c	()V
    //   106: aload_2
    //   107: monitorexit
    //   108: goto -104 -> 4
    //
    // Exception table:
    //   from	to	target	type
    //   11	30	27	finally
    //   32	108	27	finally
  }

  // ERROR //
  public void c()
  {
    // Byte code:
    //   0: getstatic 39	com/google/android/gms/internal/dr:c	Ljava/lang/Object;
    //   3: astore_1
    //   4: aload_1
    //   5: monitorenter
    //   6: aload_0
    //   7: invokevirtual 91	com/google/android/gms/internal/dr:a	()Landroid/database/sqlite/SQLiteDatabase;
    //   10: astore_3
    //   11: aload_3
    //   12: ifnonnull +6 -> 18
    //   15: aload_1
    //   16: monitorexit
    //   17: return
    //   18: aload_3
    //   19: ldc 16
    //   21: aconst_null
    //   22: aconst_null
    //   23: aconst_null
    //   24: aconst_null
    //   25: aconst_null
    //   26: ldc 93
    //   28: ldc 196
    //   30: invokevirtual 103	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   33: astore 7
    //   35: aload 7
    //   37: astore 5
    //   39: aload 5
    //   41: ifnull +23 -> 64
    //   44: aload 5
    //   46: invokeinterface 107 1 0
    //   51: ifeq +13 -> 64
    //   54: aload_0
    //   55: aload_0
    //   56: aload 5
    //   58: invokevirtual 109	com/google/android/gms/internal/dr:a	(Landroid/database/Cursor;)Lcom/google/android/gms/internal/dp;
    //   61: invokevirtual 198	com/google/android/gms/internal/dr:a	(Lcom/google/android/gms/internal/dp;)V
    //   64: aload 5
    //   66: ifnull +10 -> 76
    //   69: aload 5
    //   71: invokeinterface 121 1 0
    //   76: aload_1
    //   77: monitorexit
    //   78: goto -61 -> 17
    //   81: astore_2
    //   82: aload_1
    //   83: monitorexit
    //   84: aload_2
    //   85: athrow
    //   86: astore 6
    //   88: aconst_null
    //   89: astore 5
    //   91: new 123	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   98: ldc 200
    //   100: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload 6
    //   105: invokevirtual 133	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   108: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 69	com/google/android/gms/internal/hi:e	(Ljava/lang/String;)V
    //   117: aload 5
    //   119: ifnull -43 -> 76
    //   122: aload 5
    //   124: invokeinterface 121 1 0
    //   129: goto -53 -> 76
    //   132: aload 5
    //   134: ifnull +10 -> 144
    //   137: aload 5
    //   139: invokeinterface 121 1 0
    //   144: aload 4
    //   146: athrow
    //   147: astore 4
    //   149: goto -17 -> 132
    //   152: astore 6
    //   154: goto -63 -> 91
    //   157: astore 4
    //   159: aconst_null
    //   160: astore 5
    //   162: goto -30 -> 132
    //
    // Exception table:
    //   from	to	target	type
    //   6	17	81	finally
    //   69	84	81	finally
    //   122	147	81	finally
    //   18	35	86	android/database/sqlite/SQLiteException
    //   44	64	147	finally
    //   91	117	147	finally
    //   44	64	152	android/database/sqlite/SQLiteException
    //   18	35	157	finally
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.dr
 * JD-Core Version:    0.6.0
 */