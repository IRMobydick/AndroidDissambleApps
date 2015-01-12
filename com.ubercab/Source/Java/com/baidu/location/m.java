package com.baidu.location;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class m extends SQLiteOpenHelper
{
  private static m a;
  private static final String jdField_do = "bd_geofence.db";
  private static final int jdField_if = 2;

  public m(Context paramContext)
  {
    super(paramContext, "bd_geofence.db", null, 2);
  }

  public static m a(Context paramContext)
  {
    try
    {
      if (a == null)
        a = new m(paramContext);
      m localm = a;
      return localm;
    }
    finally
    {
    }
  }

  private String a(String paramString1, String paramString2, String paramString3)
  {
    return "ALTER TABLE " + paramString1 + " ADD " + paramString2 + " " + paramString3;
  }

  private void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE  IF NOT EXISTS geofence (_id INTEGER PRIMARY KEY AUTOINCREMENT,geofence_id NTEXT,longitude NTEXT,latitude NTEXT,radius_type INTEGER,radius NTEXT,valid_date INTEGER,duration_millis INTEGER,coord_type NTEXT,next_active_time INTEGER,is_lac INTEGER,is_cell INTEGER,is_wifi INTEGER,next_exit_active_time INTEGER);");
    paramSQLiteDatabase.execSQL("CREATE TABLE  IF NOT EXISTS geofence_detail (_id INTEGER PRIMARY KEY AUTOINCREMENT,geofence_id NTEXT,ap NTEXT,ap_backup NTEXT);");
    paramSQLiteDatabase.execSQL("CREATE INDEX  IF NOT EXISTS ap_index ON geofence_detail (ap);");
  }

  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    a(paramSQLiteDatabase);
  }

  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 < 2)
      a("geofence", "next_exit_active_time", "INTEGER");
    a(paramSQLiteDatabase);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.location.m
 * JD-Core Version:    0.6.2
 */