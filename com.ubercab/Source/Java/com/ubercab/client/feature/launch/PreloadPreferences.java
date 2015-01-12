package com.ubercab.client.feature.launch;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.ubercab.library.content.SharedPreferencesWrapperUtil;

public class PreloadPreferences
{
  private static final long CURRENT_VERSION = 1L;
  private static final String KEY_HAS_BEEN_OPENED = "has_been_opened";
  private static final String KEY_PREFERENCES_VERSION = "preferences_version";
  private static final String KEY_PRELOAD_UUID = "preload_uuid";
  static final String PREFERENCES_FILE_NAME = ".preload";
  private static final long UNDEFINED_VERSION;
  private SharedPreferences mSharedPreferences;

  public PreloadPreferences(Context paramContext)
  {
    this.mSharedPreferences = paramContext.getSharedPreferences(".preload", 0);
    runMigrations();
  }

  private long getPreferencesVersion()
  {
    return this.mSharedPreferences.getLong("preferences_version", 0L);
  }

  private void migrate(long paramLong1, long paramLong2)
  {
    if ((paramLong1 == 0L) && (paramLong2 == 1L))
      SharedPreferencesWrapperUtil.upgradeStringToBool(this.mSharedPreferences, "has_been_opened");
  }

  private void runMigrations()
  {
    long l = getPreferencesVersion();
    while (l < 1L)
    {
      migrate(l, l + 1L);
      l += 1L;
      this.mSharedPreferences.edit().putLong("preferences_version", l).apply();
    }
  }

  public String getPreloadUuid()
  {
    return this.mSharedPreferences.getString("preload_uuid", "");
  }

  public boolean hasBeenOpened()
  {
    return this.mSharedPreferences.getBoolean("has_been_opened", false);
  }

  public void setHasBeenOpened(boolean paramBoolean)
  {
    this.mSharedPreferences.edit().putBoolean("has_been_opened", paramBoolean).apply();
  }

  public void setPreloadUuid(String paramString)
  {
    this.mSharedPreferences.edit().putString("preload_uuid", paramString).apply();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.launch.PreloadPreferences
 * JD-Core Version:    0.6.2
 */