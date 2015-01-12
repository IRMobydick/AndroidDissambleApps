package com.ubercab.client.core.content;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.ubercab.library.content.SharedPreferencesWrapperUtil;

public class SessionPreferences
{
  private static final long CURRENT_VERSION = 1L;
  private static final String KEY_ADD_MUSIC_DISMISSED = "add_music_dismissed";
  private static final String KEY_DESTINATION_TUTORIAL_DISMISSED = "destination_coach_mark_dismissed";
  private static final String KEY_LAST_RATED_TRIP_ID = "last_rated_trip_id";
  private static final String KEY_PREFERENCES_VERSION = "preferences_version";
  private static final String KEY_SELECTED_VEHICLE_VIEW_ID = "selected_vehicle_view_id";
  private static final String KEY_SESSION_HASH = "session_hash";
  private static final String KEY_TOKEN = "token";
  private static final String KEY_USER_NAMES = "user_names";
  private static final String KEY_USER_UUID = "user_uuid";
  public static final String PREFERENCES_FILE_NAME = ".session";
  private static final long UNDEFINED_VERSION;
  private final SharedPreferences mSharedPreferences;

  public SessionPreferences(SharedPreferences paramSharedPreferences)
  {
    this.mSharedPreferences = paramSharedPreferences;
    runMigrations();
  }

  private long getPreferencesVersion()
  {
    return this.mSharedPreferences.getLong("preferences_version", 0L);
  }

  private void migrate(long paramLong1, long paramLong2)
  {
    if ((paramLong1 == 0L) && (paramLong2 == 1L))
      SharedPreferencesWrapperUtil.upgradeStringToBool(this.mSharedPreferences, "destination_coach_mark_dismissed");
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

  public void clear()
  {
    this.mSharedPreferences.edit().clear().apply();
  }

  public String getLastRatedTripId()
  {
    return this.mSharedPreferences.getString("last_rated_trip_id", "");
  }

  public String getSelectedVehicleViewId()
  {
    return this.mSharedPreferences.getString("selected_vehicle_view_id", "");
  }

  public String getSessionHash()
  {
    return this.mSharedPreferences.getString("session_hash", "");
  }

  public String getToken()
  {
    return this.mSharedPreferences.getString("token", "");
  }

  public String getUserUuid()
  {
    return this.mSharedPreferences.getString("user_uuid", "");
  }

  public boolean hasSessionHash()
  {
    return !TextUtils.isEmpty(getSessionHash());
  }

  public boolean hasToken()
  {
    return !TextUtils.isEmpty(getToken());
  }

  public boolean hasUserUuid()
  {
    return !TextUtils.isEmpty(getUserUuid());
  }

  public boolean isAddMusicDismissed()
  {
    return this.mSharedPreferences.getBoolean("add_music_dismissed", false);
  }

  public boolean isDestinationTutorialDismissed()
  {
    return this.mSharedPreferences.getBoolean("destination_coach_mark_dismissed", false);
  }

  public void setAddMusicDismissed(boolean paramBoolean)
  {
    this.mSharedPreferences.edit().putBoolean("add_music_dismissed", paramBoolean).apply();
  }

  public void setDestinationTutorialDismissed(boolean paramBoolean)
  {
    this.mSharedPreferences.edit().putBoolean("destination_coach_mark_dismissed", paramBoolean).apply();
  }

  public void setLastRatedTripId(String paramString)
  {
    this.mSharedPreferences.edit().putString("last_rated_trip_id", paramString).apply();
  }

  public void setSelectedVehicleViewId(String paramString)
  {
    this.mSharedPreferences.edit().putString("selected_vehicle_view_id", paramString).apply();
  }

  public void setSessionHash(String paramString)
  {
    this.mSharedPreferences.edit().putString("session_hash", paramString).apply();
  }

  public void setToken(String paramString)
  {
    this.mSharedPreferences.edit().putString("token", paramString).apply();
  }

  public void setUserUuid(String paramString)
  {
    this.mSharedPreferences.edit().putString("user_uuid", paramString).apply();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.content.SessionPreferences
 * JD-Core Version:    0.6.2
 */