package com.ubercab.library.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.ubercab.library.content.SharedPreferencesWrapperUtil;
import com.ubercab.library.location.model.UberLocation;

public final class UberPreferences
{
  private static final long CURRENT_VERSION = 1L;
  static final String FILE_NAME = ".uber_preferences";
  static final String KEY_ANALYTICS_V2_DISABLE = "uber.analytics_v2_disable";
  static final String KEY_ANALYTICS_V2_LOGGING = "uber.analytics_v2.logging";
  static final String KEY_ANALYTICS_V2_SESSION_ID = "uber.analytics_v2.session_id";
  static final String KEY_ANALYTICS_V2_SESSION_START_TIME = "uber.analytics_v2.session_start_time";
  static final String KEY_CN_ENDPOINT = "uber.cn_endpoint";
  static final String KEY_CN_SSL_VERIFICATION_DISABLE = "uber.cn_ssl_verification_disabled";
  static final String KEY_FAKE_CN_FAILOVER_STRATEGY = "uber.cn.failover_strategy";
  static final String KEY_FAKE_GEO_ENGINE = "fake_geo_engine";
  static final String KEY_FAKE_GEO_PROJECTION = "fake_geo_projection";
  static final String KEY_FAKE_LOCATION = "fake_location";
  static final String KEY_MONITORING_ENABLED = "uber.monitoring_enabled";
  static final String KEY_PREFERENCES_VERSION = "preferences_version";
  static final String KEY_VERSION_FAKE = "employee.settings.other.version.fake";
  private static final long UNDEFINED_VERSION;
  private Gson mGson;
  private SharedPreferences mSharedPreferences;

  public UberPreferences(Context paramContext, Gson paramGson)
  {
    this.mSharedPreferences = paramContext.getSharedPreferences(".uber_preferences", 0);
    this.mGson = paramGson;
    runMigrations();
  }

  private long getPreferencesVersion()
  {
    return this.mSharedPreferences.getLong("preferences_version", 0L);
  }

  private void migrate(long paramLong1, long paramLong2)
  {
    if ((paramLong1 == 0L) && (paramLong2 == 1L))
    {
      SharedPreferencesWrapperUtil.upgradeStringToBool(this.mSharedPreferences, "uber.analytics_v2_disable");
      SharedPreferencesWrapperUtil.upgradeStringToBool(this.mSharedPreferences, "uber.analytics_v2.logging");
      SharedPreferencesWrapperUtil.upgradeStringToBool(this.mSharedPreferences, "uber.cn_ssl_verification_disabled");
      SharedPreferencesWrapperUtil.upgradeStringToBool(this.mSharedPreferences, "uber.monitoring_enabled");
      this.mSharedPreferences.edit().remove("fake_geo_engine").apply();
    }
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

  public void disableCnSslVerfification()
  {
    this.mSharedPreferences.edit().putBoolean("uber.cn_ssl_verification_disabled", true).apply();
  }

  public void enableCnSslVerification()
  {
    this.mSharedPreferences.edit().remove("uber.cn_ssl_verification_disabled").apply();
  }

  public long getAnalyticsSessionStartTime()
  {
    return this.mSharedPreferences.getLong("uber.analytics_v2.session_start_time", 0L);
  }

  public boolean getAnalyticsV2Logging()
  {
    return this.mSharedPreferences.getBoolean("uber.analytics_v2.logging", false);
  }

  public String getCnEndpoint()
  {
    return this.mSharedPreferences.getString("uber.cn_endpoint", "");
  }

  public String getFakeCnFailoverStrategy()
  {
    return this.mSharedPreferences.getString("uber.cn.failover_strategy", "");
  }

  public int getFakeGeoEngine()
  {
    return this.mSharedPreferences.getInt("fake_geo_engine", 0);
  }

  public int getFakeGeoProjection()
  {
    return this.mSharedPreferences.getInt("fake_geo_projection", 0);
  }

  public UberLocation getFakeLocation()
  {
    String str = this.mSharedPreferences.getString("fake_location", "");
    if (TextUtils.isEmpty(str))
      return null;
    return (UberLocation)this.mGson.fromJson(str, UberLocation.class);
  }

  public String getFakeVersion()
  {
    return this.mSharedPreferences.getString("employee.settings.other.version.fake", "");
  }

  public String getKeyAnalyticsV2SessionId()
  {
    return this.mSharedPreferences.getString("uber.analytics_v2.session_id", "");
  }

  public boolean hasCnEndpoint()
  {
    return !TextUtils.isEmpty(getCnEndpoint());
  }

  public boolean hasFakeCnFailoverStrategy()
  {
    return !TextUtils.isEmpty(getFakeCnFailoverStrategy());
  }

  public boolean hasFakeGeoEngine()
  {
    return getFakeGeoEngine() != 0;
  }

  public boolean hasFakeGeoProjection()
  {
    return getFakeGeoProjection() != 0;
  }

  public boolean hasFakeLocation()
  {
    return getFakeLocation() != null;
  }

  public boolean hasFakeVersion()
  {
    return !TextUtils.isEmpty(getFakeVersion());
  }

  public boolean isAnalyticsV2Disabled()
  {
    return this.mSharedPreferences.getBoolean("uber.analytics_v2_disable", false);
  }

  public boolean isCnSslVerificationDisabled()
  {
    return this.mSharedPreferences.getBoolean("uber.cn_ssl_verification_disabled", false);
  }

  public boolean isMonitoringEnabled()
  {
    return this.mSharedPreferences.getBoolean("uber.monitoring_enabled", false);
  }

  public void removeCnEndpoint()
  {
    this.mSharedPreferences.edit().remove("uber.cn_endpoint").apply();
  }

  public void removeFakeCnFailoverStrategy()
  {
    this.mSharedPreferences.edit().remove("uber.cn.failover_strategy").apply();
  }

  public void removeFakeGeoEngine()
  {
    this.mSharedPreferences.edit().remove("fake_geo_engine").apply();
  }

  public void removeFakeGeoProjection()
  {
    this.mSharedPreferences.edit().remove("fake_geo_projection").apply();
  }

  public void removeFakeLocation()
  {
    this.mSharedPreferences.edit().remove("fake_location").apply();
  }

  public void removeFakeVersion()
  {
    this.mSharedPreferences.edit().remove("employee.settings.other.version.fake").apply();
  }

  public void reset()
  {
    this.mSharedPreferences.edit().clear().apply();
  }

  public void setAnalyticsSessionStartTime(long paramLong)
  {
    this.mSharedPreferences.edit().putLong("uber.analytics_v2.session_start_time", paramLong).apply();
  }

  public void setAnalyticsV2Disabled(boolean paramBoolean)
  {
    this.mSharedPreferences.edit().putBoolean("uber.analytics_v2_disable", paramBoolean).apply();
  }

  public void setAnalyticsV2Logging(boolean paramBoolean)
  {
    com.ubercab.library.metrics.analytics.AnalyticsClient.LOGGING_ENABLED = paramBoolean;
    this.mSharedPreferences.edit().putBoolean("uber.analytics_v2.logging", paramBoolean).apply();
  }

  public void setCnEndpoint(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.mSharedPreferences.edit().remove("uber.cn_endpoint").apply();
      return;
    }
    this.mSharedPreferences.edit().putString("uber.cn_endpoint", paramString).apply();
  }

  public void setFakeCnFailoverStrategy(String paramString)
  {
    this.mSharedPreferences.edit().putString("uber.cn.failover_strategy", paramString).apply();
  }

  public void setFakeGeoEngine(int paramInt)
  {
    this.mSharedPreferences.edit().putInt("fake_geo_engine", paramInt).apply();
  }

  public void setFakeGeoProjection(int paramInt)
  {
    this.mSharedPreferences.edit().putInt("fake_geo_projection", paramInt).apply();
  }

  public void setFakeLocation(UberLocation paramUberLocation)
  {
    this.mSharedPreferences.edit().putString("fake_location", this.mGson.toJson(paramUberLocation)).apply();
  }

  public void setFakeVersion(String paramString)
  {
    this.mSharedPreferences.edit().putString("employee.settings.other.version.fake", paramString).apply();
  }

  public void setKeyAnalyticsV2SessionId(String paramString)
  {
    this.mSharedPreferences.edit().putString("uber.analytics_v2.session_id", paramString).apply();
  }

  public void setMonitoringEnabled(boolean paramBoolean)
  {
    this.mSharedPreferences.edit().putBoolean("uber.monitoring_enabled", paramBoolean).apply();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.app.UberPreferences
 * JD-Core Version:    0.6.2
 */