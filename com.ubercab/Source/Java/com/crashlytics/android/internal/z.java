package com.crashlytics.android.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import java.io.File;

final class z extends ContextWrapper
{
  private final String a;

  public z(Context paramContext, String paramString)
  {
    super(paramContext);
    this.a = (".TwitterSdk/" + paramString);
  }

  public final File getCacheDir()
  {
    return new File(super.getCacheDir(), this.a);
  }

  public final File getDatabasePath(String paramString)
  {
    File localFile = new File(super.getDatabasePath(paramString).getParentFile(), this.a);
    localFile.mkdirs();
    return new File(localFile, paramString);
  }

  public final File getExternalCacheDir()
  {
    return new File(super.getExternalCacheDir(), this.a);
  }

  public final File getExternalFilesDir(String paramString)
  {
    return new File(super.getExternalFilesDir(paramString), this.a);
  }

  public final File getFilesDir()
  {
    return new File(super.getFilesDir(), this.a);
  }

  public final SQLiteDatabase openOrCreateDatabase(String paramString, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory)
  {
    return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(paramString), paramCursorFactory);
  }

  @TargetApi(11)
  public final SQLiteDatabase openOrCreateDatabase(String paramString, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(paramString).getPath(), paramCursorFactory, paramDatabaseErrorHandler);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.internal.z
 * JD-Core Version:    0.6.2
 */