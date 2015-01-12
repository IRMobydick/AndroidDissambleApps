package com.baidu.location;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.location.b.a.a;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

class au
  implements ax, n
{
  private static final String h2 = "GeofenceMan";
  private static final int h3 = 3;
  public static final int h4 = 10;
  private static final String h5 = "http://loc.map.baidu.com/fence";
  private static final String h6 = "geofence_id";
  private static final String h7 = ";";
  private static final String h9 = "status_code";
  private static final String i = "GeofenceMan";
  private static au ia;
  private static final int ic = 5;
  private static final int id = 2;
  private static final int ie = 1;
  private static final String ih = "geofence_ids";
  private Context h1;
  private Object h8 = new Object();
  private HandlerThread ib;
  private a ig;

  private void b8()
  {
    this.ib = new HandlerThread("GeofenceMan", 10);
    this.ib.start();
    this.ig = new a(this.ib.getLooper());
  }

  // ERROR //
  private void b9()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 82	com/baidu/location/au:h1	Landroid/content/Context;
    //   6: invokestatic 88	com/baidu/location/m:a	(Landroid/content/Context;)Lcom/baidu/location/m;
    //   9: invokevirtual 92	com/baidu/location/m:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   12: astore_2
    //   13: aload_2
    //   14: ifnull +118 -> 132
    //   17: aload_2
    //   18: invokevirtual 97	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   21: invokestatic 103	java/lang/System:currentTimeMillis	()J
    //   24: lstore 5
    //   26: iconst_5
    //   27: anewarray 4	java/lang/Object
    //   30: astore 7
    //   32: aload 7
    //   34: iconst_0
    //   35: ldc 105
    //   37: aastore
    //   38: aload 7
    //   40: iconst_1
    //   41: ldc 107
    //   43: aastore
    //   44: aload 7
    //   46: iconst_2
    //   47: ldc 109
    //   49: aastore
    //   50: aload 7
    //   52: iconst_3
    //   53: ldc 111
    //   55: aastore
    //   56: aload 7
    //   58: iconst_4
    //   59: lload 5
    //   61: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   64: aastore
    //   65: aload_2
    //   66: ldc 119
    //   68: aload 7
    //   70: invokestatic 125	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   73: invokevirtual 129	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   76: iconst_4
    //   77: anewarray 4	java/lang/Object
    //   80: astore 8
    //   82: aload 8
    //   84: iconst_0
    //   85: ldc 107
    //   87: aastore
    //   88: aload 8
    //   90: iconst_1
    //   91: ldc 109
    //   93: aastore
    //   94: aload 8
    //   96: iconst_2
    //   97: ldc 111
    //   99: aastore
    //   100: aload 8
    //   102: iconst_3
    //   103: lload 5
    //   105: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   108: aastore
    //   109: aload_2
    //   110: ldc 131
    //   112: aload 8
    //   114: invokestatic 125	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   117: invokevirtual 129	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   120: aload_2
    //   121: invokevirtual 134	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   124: aload_2
    //   125: invokevirtual 137	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   128: aload_2
    //   129: invokevirtual 140	android/database/sqlite/SQLiteDatabase:close	()V
    //   132: aload_0
    //   133: monitorexit
    //   134: return
    //   135: astore 4
    //   137: aload_2
    //   138: invokevirtual 137	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   141: aload_2
    //   142: invokevirtual 140	android/database/sqlite/SQLiteDatabase:close	()V
    //   145: goto -13 -> 132
    //   148: astore_1
    //   149: aload_0
    //   150: monitorexit
    //   151: aload_1
    //   152: athrow
    //   153: astore_3
    //   154: aload_2
    //   155: invokevirtual 137	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   158: aload_2
    //   159: invokevirtual 140	android/database/sqlite/SQLiteDatabase:close	()V
    //   162: aload_3
    //   163: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   21	124	135	java/lang/Exception
    //   2	13	148	finally
    //   17	21	148	finally
    //   124	132	148	finally
    //   137	145	148	finally
    //   154	164	148	finally
    //   21	124	153	finally
  }

  private void ca()
  {
    this.ig.sendEmptyMessage(3);
  }

  private final void cb()
  {
    if (!s.jdMethod_if(this.h1))
      throw new IllegalStateException("Not net connection");
  }

  // ERROR //
  private long cc()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: lconst_0
    //   3: lstore_1
    //   4: aload_0
    //   5: getfield 82	com/baidu/location/au:h1	Landroid/content/Context;
    //   8: invokestatic 88	com/baidu/location/m:a	(Landroid/content/Context;)Lcom/baidu/location/m;
    //   11: invokevirtual 162	com/baidu/location/m:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   14: astore 5
    //   16: aload 5
    //   18: ifnull +16 -> 34
    //   21: aload 5
    //   23: ldc 107
    //   25: invokestatic 168	android/database/DatabaseUtils:queryNumEntries	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)J
    //   28: lstore_1
    //   29: aload 5
    //   31: invokevirtual 140	android/database/sqlite/SQLiteDatabase:close	()V
    //   34: aload_0
    //   35: monitorexit
    //   36: lload_1
    //   37: lreturn
    //   38: astore 4
    //   40: aload_0
    //   41: monitorexit
    //   42: aload 4
    //   44: athrow
    //   45: astore_3
    //   46: goto -12 -> 34
    //
    // Exception table:
    //   from	to	target	type
    //   4	16	38	finally
    //   21	34	38	finally
    //   4	16	45	java/lang/Exception
    //   21	34	45	java/lang/Exception
  }

  public static int jdMethod_do(Context paramContext)
  {
    String str = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
    if (str != null)
    {
      if ((str.startsWith("46000")) || (str.startsWith("46002")) || (str.startsWith("46007")))
        return 1;
      if (str.startsWith("46001"))
        return 2;
      if (str.startsWith("46003"))
        return 3;
    }
    return 5;
  }

  private int jdMethod_do(List paramList)
  {
    while (true)
    {
      try
      {
        SQLiteDatabase localSQLiteDatabase = m.a(this.h1).getWritableDatabase();
        if (localSQLiteDatabase != null)
        {
          localSQLiteDatabase.beginTransaction();
          try
          {
            Iterator localIterator = paramList.iterator();
            if (localIterator.hasNext())
            {
              String[] arrayOfString = { (String)localIterator.next() };
              localSQLiteDatabase.delete("geofence", String.format("%s=?", new Object[] { "geofence_id" }), arrayOfString);
              localSQLiteDatabase.delete("geofence_detail", String.format("%s=?", new Object[] { "geofence_id" }), arrayOfString);
              continue;
            }
          }
          catch (Exception localException)
          {
            localSQLiteDatabase.endTransaction();
            j = 1;
            localSQLiteDatabase.close();
            return j;
            localSQLiteDatabase.setTransactionSuccessful();
            localSQLiteDatabase.endTransaction();
            j = 0;
            continue;
          }
          finally
          {
            localSQLiteDatabase.endTransaction();
          }
        }
      }
      finally
      {
      }
      int j = 0;
    }
  }

  public static au jdMethod_for(Context paramContext)
  {
    if (ia == null)
    {
      ia = new au();
      ia.b8();
      ia.h1 = paramContext;
    }
    return ia;
  }

  private int jdMethod_if(aq paramaq, String paramString)
  {
    while (true)
    {
      try
      {
        SQLiteDatabase localSQLiteDatabase = m.a(this.h1).getWritableDatabase();
        int j = 0;
        long l;
        if (localSQLiteDatabase != null)
        {
          localSQLiteDatabase.beginTransaction();
          l = System.currentTimeMillis();
        }
        try
        {
          ContentValues localContentValues1 = new ContentValues();
          String str1 = paramaq.getGeofenceId();
          localContentValues1.put("geofence_id", str1);
          localContentValues1.put("longitude", Double.valueOf(paramaq.a()));
          localContentValues1.put("latitude", Double.valueOf(paramaq.jdMethod_case()));
          localContentValues1.put("radius", Float.valueOf(paramaq.jdMethod_do()));
          localContentValues1.put("radius_type", Integer.valueOf(paramaq.jdMethod_new()));
          localContentValues1.put("valid_date", Long.valueOf(l));
          localContentValues1.put("duration_millis", Long.valueOf(paramaq.jdMethod_goto()));
          localContentValues1.put("coord_type", paramaq.jdMethod_int());
          if (paramaq.jdMethod_byte())
          {
            k = 1;
            localContentValues1.put("is_lac", Integer.valueOf(k));
            if (!paramaq.jdMethod_if())
              break label422;
            m = 1;
            localContentValues1.put("is_cell", Integer.valueOf(m));
            if (!paramaq.jdMethod_for())
              break label428;
            n = 1;
            localContentValues1.put("is_wifi", Integer.valueOf(n));
            localContentValues1.put("next_active_time", Integer.valueOf(0));
            localContentValues1.put("next_exit_active_time", Integer.valueOf(0));
            localSQLiteDatabase.insert("geofence", null, localContentValues1);
            String[] arrayOfString = paramString.split(";");
            int i1 = arrayOfString.length;
            int i2 = 0;
            if (i2 < i1)
            {
              String str2 = arrayOfString[i2];
              ContentValues localContentValues2 = new ContentValues();
              localContentValues2.put("geofence_id", str1);
              localContentValues2.put("ap_backup", str2);
              int i3 = str2.lastIndexOf("|");
              if (i3 != -1)
                str2 = str2.substring(0, i3);
              localContentValues2.put("ap", str2);
              localSQLiteDatabase.insert("geofence_detail", null, localContentValues2);
              i2++;
              continue;
            }
            localSQLiteDatabase.setTransactionSuccessful();
            localSQLiteDatabase.endTransaction();
            localSQLiteDatabase.close();
            return j;
          }
        }
        catch (Exception localException)
        {
          localSQLiteDatabase.endTransaction();
          j = 1;
          continue;
        }
        finally
        {
          localSQLiteDatabase.endTransaction();
        }
      }
      finally
      {
      }
      int k = 0;
      continue;
      label422: int m = 0;
      continue;
      label428: int n = 0;
    }
  }

  private void jdMethod_if(int paramInt, String paramString, GeofenceClient.OnAddBDGeofencesResultListener paramOnAddBDGeofencesResultListener)
  {
    if (paramInt == 1);
    paramOnAddBDGeofencesResultListener.onAddBDGeofencesResult(paramInt, paramString);
  }

  private void jdMethod_if(int paramInt, String[] paramArrayOfString, GeofenceClient.OnRemoveBDGeofencesResultListener paramOnRemoveBDGeofencesResultListener)
  {
    paramOnRemoveBDGeofencesResultListener.onRemoveBDGeofencesByRequestIdsResult(paramInt, paramArrayOfString);
  }

  private void jdMethod_if(GeofenceClient.OnAddBDGeofencesResultListener paramOnAddBDGeofencesResultListener, int paramInt, String paramString)
  {
    Message localMessage = Message.obtain(this.ig);
    localMessage.what = 0;
    localMessage.obj = paramOnAddBDGeofencesResultListener;
    Bundle localBundle = new Bundle();
    localBundle.putInt("status_code", paramInt);
    localBundle.putString("geofence_id", paramString);
    localMessage.setData(localBundle);
    this.ig.sendMessage(localMessage);
  }

  public static void jdMethod_int(Context paramContext)
  {
    a0.cq().jdMethod_try(f.getServiceContext());
  }

  public void b7()
  {
    synchronized (this.h8)
    {
      this.ig.post(new au.3(this));
      return;
    }
  }

  public void jdMethod_do(aq paramaq)
  {
    this.ig.post(new au.1(this, paramaq));
  }

  // ERROR //
  public void jdMethod_do(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc2_w 433
    //   3: lstore_3
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_1
    //   7: invokestatic 440	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: istore 6
    //   12: iload 6
    //   14: ifeq +6 -> 20
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: getfield 82	com/baidu/location/au:h1	Landroid/content/Context;
    //   24: invokestatic 88	com/baidu/location/m:a	(Landroid/content/Context;)Lcom/baidu/location/m;
    //   27: invokevirtual 92	com/baidu/location/m:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   30: astore 7
    //   32: aload 7
    //   34: ifnull -17 -> 17
    //   37: new 235	android/content/ContentValues
    //   40: dup
    //   41: invokespecial 236	android/content/ContentValues:<init>	()V
    //   44: astore 8
    //   46: iload_2
    //   47: ifeq +79 -> 126
    //   50: invokestatic 103	java/lang/System:currentTimeMillis	()J
    //   53: lstore 11
    //   55: invokestatic 445	com/baidu/location/GeofenceClient:d	()J
    //   58: lconst_0
    //   59: lcmp
    //   60: ifeq +15 -> 75
    //   63: invokestatic 445	com/baidu/location/GeofenceClient:d	()J
    //   66: lload_3
    //   67: lcmp
    //   68: ifeq +7 -> 75
    //   71: invokestatic 445	com/baidu/location/GeofenceClient:d	()J
    //   74: lstore_3
    //   75: aload 8
    //   77: ldc_w 316
    //   80: lload_3
    //   81: lload 11
    //   83: ladd
    //   84: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   87: invokevirtual 293	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   90: aload 7
    //   92: ldc 107
    //   94: aload 8
    //   96: ldc_w 447
    //   99: iconst_1
    //   100: anewarray 121	java/lang/String
    //   103: dup
    //   104: iconst_0
    //   105: aload_1
    //   106: aastore
    //   107: invokevirtual 451	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   110: pop
    //   111: aload 7
    //   113: invokevirtual 140	android/database/sqlite/SQLiteDatabase:close	()V
    //   116: goto -99 -> 17
    //   119: astore 5
    //   121: aload_0
    //   122: monitorexit
    //   123: aload 5
    //   125: athrow
    //   126: invokestatic 103	java/lang/System:currentTimeMillis	()J
    //   129: lstore 14
    //   131: invokestatic 445	com/baidu/location/GeofenceClient:d	()J
    //   134: lconst_0
    //   135: lcmp
    //   136: ifeq +15 -> 151
    //   139: invokestatic 445	com/baidu/location/GeofenceClient:d	()J
    //   142: lload_3
    //   143: lcmp
    //   144: ifeq +7 -> 151
    //   147: invokestatic 445	com/baidu/location/GeofenceClient:d	()J
    //   150: lstore_3
    //   151: aload 8
    //   153: ldc_w 318
    //   156: lload_3
    //   157: lload 14
    //   159: ladd
    //   160: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   163: invokevirtual 293	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   166: goto -76 -> 90
    //   169: astore 10
    //   171: aload 7
    //   173: invokevirtual 140	android/database/sqlite/SQLiteDatabase:close	()V
    //   176: goto -159 -> 17
    //   179: astore 9
    //   181: aload 7
    //   183: invokevirtual 140	android/database/sqlite/SQLiteDatabase:close	()V
    //   186: aload 9
    //   188: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   6	12	119	finally
    //   20	32	119	finally
    //   111	116	119	finally
    //   171	176	119	finally
    //   181	189	119	finally
    //   37	46	169	java/lang/Exception
    //   50	75	169	java/lang/Exception
    //   75	90	169	java/lang/Exception
    //   90	111	169	java/lang/Exception
    //   126	151	169	java/lang/Exception
    //   151	166	169	java/lang/Exception
    //   37	46	179	finally
    //   50	75	179	finally
    //   75	90	179	finally
    //   90	111	179	finally
    //   126	151	179	finally
    //   151	166	179	finally
  }

  public void jdMethod_if(aq paramaq)
  {
    this.ig.post(new au.2(this, paramaq));
  }

  public void jdMethod_if(aq paramaq, GeofenceClient.OnAddBDGeofencesResultListener paramOnAddBDGeofencesResultListener)
  {
    cb();
    an.a(paramOnAddBDGeofencesResultListener, "OnAddBDGeofenceRecesResultListener not provided.");
    if (cc() >= 10L)
    {
      paramOnAddBDGeofencesResultListener.onAddBDGeofencesResult(1001, paramaq.getGeofenceId());
      return;
    }
    new b(paramaq, paramOnAddBDGeofencesResultListener).ag();
    ca();
  }

  public void jdMethod_if(List paramList, GeofenceClient.OnRemoveBDGeofencesResultListener paramOnRemoveBDGeofencesResultListener)
  {
    if ((paramList != null) && (paramList.size() > 0));
    for (boolean bool = true; ; bool = false)
    {
      an.jdMethod_if(bool, "geofenceRequestIds can't be null nor empty.");
      an.a(paramOnRemoveBDGeofencesResultListener, "onRemoveBDGeofencesResultListener not provided.");
      this.ig.post(new d(paramList, paramOnRemoveBDGeofencesResultListener));
      return;
    }
  }

  private class a extends Handler
  {
    public static final int jdField_do = 2;
    public static final int jdField_for = 3;
    public static final int jdField_if;

    public a(Looper arg2)
    {
      super();
    }

    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      int i = paramMessage.what;
      Bundle localBundle = paramMessage.getData();
      String str2;
      int m;
      switch (i)
      {
      case 1:
      default:
        return;
      case 0:
        if (localBundle != null)
        {
          int n = localBundle.getInt("status_code", 1);
          str2 = localBundle.getString("geofence_id");
          m = n;
        }
        break;
      case 2:
      case 3:
      }
      for (String str1 = str2; ; str1 = null)
      {
        GeofenceClient.OnAddBDGeofencesResultListener localOnAddBDGeofencesResultListener = (GeofenceClient.OnAddBDGeofencesResultListener)paramMessage.obj;
        au.jdField_if(au.this, m, str1, localOnAddBDGeofencesResultListener);
        return;
        String[] arrayOfString2;
        int j;
        if (localBundle != null)
        {
          int k = localBundle.getInt("status_code", 1);
          arrayOfString2 = localBundle.getStringArray("geofence_ids");
          j = k;
        }
        for (String[] arrayOfString1 = arrayOfString2; ; arrayOfString1 = null)
        {
          GeofenceClient.OnRemoveBDGeofencesResultListener localOnRemoveBDGeofencesResultListener = (GeofenceClient.OnRemoveBDGeofencesResultListener)paramMessage.obj;
          au.jdField_if(au.this, j, arrayOfString1, localOnRemoveBDGeofencesResultListener);
          return;
          au.this.b7();
          return;
          j = 1;
        }
        m = 1;
      }
    }
  }

  class b extends s
  {
    private static final String dE = "error";
    private static final int dF = -3;
    private static final String dG = "ext";
    private static final String dH = "cl";
    private static final String dI = "fence";
    private static final String dJ = "lac";
    private static final String dL = "wf";
    private static final String dN = "radius";
    private GeofenceClient.OnAddBDGeofencesResultListener dD;
    private int dM;
    private final aq dO;

    public b(aq paramOnAddBDGeofencesResultListener, GeofenceClient.OnAddBDGeofencesResultListener arg3)
    {
      this.dO = paramOnAddBDGeofencesResultListener;
      Object localObject;
      this.dD = localObject;
      this.cT = new ArrayList();
    }

    public void T()
    {
      this.cR = "http://loc.map.baidu.com/fence";
      DecimalFormat localDecimalFormat = new DecimalFormat("0.00000");
      Object[] arrayOfObject1 = new Object[7];
      arrayOfObject1[0] = localDecimalFormat.format(this.dO.a());
      arrayOfObject1[1] = localDecimalFormat.format(this.dO.jdMethod_case());
      arrayOfObject1[2] = String.valueOf(this.dO.jdMethod_new());
      arrayOfObject1[3] = String.valueOf(this.dO.jdMethod_int());
      arrayOfObject1[4] = Integer.valueOf(au.jdMethod_do(au.jdMethod_if(au.this)));
      arrayOfObject1[5] = a.jdMethod_if(au.jdMethod_if(au.this));
      arrayOfObject1[6] = Float.valueOf(4.2F);
      String str = Jni.i(String.format("&x=%s&y=%s&r=%s&coord=%s&type=%s&cu=%s&sdk=%s", arrayOfObject1));
      this.cT.add(new BasicNameValuePair("fence", str));
      List localList = this.cT;
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = v.a(au.jdMethod_if(au.this));
      arrayOfObject2[1] = v.jdMethod_if(au.jdMethod_if(au.this));
      localList.add(new BasicNameValuePair("ext", Jni.i(String.format("&ki=%s&sn=%s", arrayOfObject2))));
    }

    public void ag()
    {
      N();
    }

    public void jdMethod_do(boolean paramBoolean)
    {
      if ((paramBoolean) && (this.cS != null))
      {
        String str1;
        try
        {
          JSONObject localJSONObject = new JSONObject(EntityUtils.toString(this.cS, "UTF-8"));
          str1 = null;
          if (localJSONObject != null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            if (localJSONObject.has("lac"))
            {
              String str4 = localJSONObject.getString("lac");
              if (!TextUtils.isEmpty(str4))
              {
                localStringBuilder.append(str4);
                this.dO.jdMethod_do(true);
              }
            }
            if (localJSONObject.has("cl"))
            {
              String str3 = localJSONObject.getString("cl");
              if (!TextUtils.isEmpty(str3))
              {
                localStringBuilder.append(str3);
                this.dO.a(true);
              }
            }
            if (localJSONObject.has("wf"))
            {
              String str2 = localJSONObject.getString("wf");
              if (!TextUtils.isEmpty(str2))
              {
                localStringBuilder.append(str2);
                this.dO.jdMethod_if(true);
              }
            }
            str1 = localStringBuilder.toString();
            if (localJSONObject.has("radius"))
            {
              float f = Float.valueOf(localJSONObject.getString("radius")).floatValue();
              this.dO.a(f);
            }
            if (localJSONObject.has("error"))
              this.dM = Integer.valueOf(localJSONObject.getString("error")).intValue();
          }
          if (!TextUtils.isEmpty(str1))
            break label312;
          if (this.dM == -3)
          {
            au.jdMethod_if(au.this, this.dD, 1002, this.dO.getGeofenceId());
            return;
          }
        }
        catch (Exception localException)
        {
          au.jdMethod_if(au.this, this.dD, 1, this.dO.getGeofenceId());
          return;
        }
        au.jdMethod_if(au.this, this.dD, this.dM, this.dO.getGeofenceId());
        return;
        label312: au.jdMethod_do(au.this).post(new au.c(au.this, this.dO, str1, this.dD));
        return;
      }
      au.jdMethod_if(au.this, this.dD, 1, this.dO.getGeofenceId());
    }
  }

  private class c
    implements Runnable
  {
    private final aq jdField_do;
    private final GeofenceClient.OnAddBDGeofencesResultListener jdField_for;
    private final String jdField_if;

    public c(aq paramString, String paramOnAddBDGeofencesResultListener, GeofenceClient.OnAddBDGeofencesResultListener arg4)
    {
      this.jdField_do = paramString;
      this.jdField_if = paramOnAddBDGeofencesResultListener;
      Object localObject;
      this.jdField_for = localObject;
    }

    public void run()
    {
      int i = au.jdField_if(au.this, this.jdField_do, this.jdField_if);
      au.jdField_if(au.this, this.jdField_for, i, this.jdField_do.getGeofenceId());
      if (f.getServiceContext() != null)
        a0.cq().jdField_for(this.jdField_do);
    }
  }

  private class d
    implements Runnable
  {
    private final GeofenceClient.OnRemoveBDGeofencesResultListener jdField_do;
    private final List jdField_if;

    public d(List paramOnRemoveBDGeofencesResultListener, GeofenceClient.OnRemoveBDGeofencesResultListener arg3)
    {
      this.jdField_if = paramOnRemoveBDGeofencesResultListener;
      Object localObject;
      this.jdField_do = localObject;
    }

    public void run()
    {
      int i = au.jdField_if(au.this, this.jdField_if);
      Message localMessage = Message.obtain(au.jdField_do(au.this));
      localMessage.what = 2;
      localMessage.obj = this.jdField_do;
      Bundle localBundle = new Bundle();
      localBundle.putInt("status_code", i);
      localBundle.putStringArray("geofence_ids", (String[])this.jdField_if.toArray(new String[this.jdField_if.size()]));
      localMessage.setData(localBundle);
      au.jdField_do(au.this).sendMessage(localMessage);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.location.au
 * JD-Core Version:    0.6.2
 */