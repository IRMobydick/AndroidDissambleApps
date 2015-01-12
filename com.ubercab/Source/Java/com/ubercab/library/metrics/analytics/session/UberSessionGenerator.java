package com.ubercab.library.metrics.analytics.session;

import android.content.Intent;
import com.ubercab.library.app.LifecycleTracker;
import com.ubercab.library.app.LifecycleTracker.Listener;
import com.ubercab.library.app.UberPreferences;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import java.util.UUID;

public class UberSessionGenerator
  implements SessionGenerator, LifecycleTracker.Listener
{
  private static final int SESSION_EXPIRATION_TIME_MS = 1800000;
  private AnalyticsClient mAnalyticsClient;
  private long mPreviousBackgroundTime;
  private long mSessionStartTime;
  private String mSessionUUID;
  private UberPreferences mUberPreferences;

  public UberSessionGenerator(AnalyticsClient paramAnalyticsClient, LifecycleTracker paramLifecycleTracker, UberPreferences paramUberPreferences)
  {
    this.mAnalyticsClient = paramAnalyticsClient;
    this.mUberPreferences = paramUberPreferences;
    this.mSessionStartTime = this.mUberPreferences.getAnalyticsSessionStartTime();
    this.mSessionUUID = this.mUberPreferences.getKeyAnalyticsV2SessionId();
    if (hasSessionExpired(System.currentTimeMillis(), this.mSessionStartTime))
      resetSession(System.currentTimeMillis());
    paramLifecycleTracker.registerListener(this);
  }

  private boolean hasSessionExpired(long paramLong1, long paramLong2)
  {
    return paramLong1 - paramLong2 >= 1800000L;
  }

  private void resetSession(long paramLong)
  {
    this.mSessionUUID = UUID.randomUUID().toString();
    this.mSessionStartTime = paramLong;
    this.mUberPreferences.setKeyAnalyticsV2SessionId(this.mSessionUUID);
    this.mUberPreferences.setAnalyticsSessionStartTime(this.mSessionStartTime);
  }

  public String getId()
  {
    return this.mSessionUUID;
  }

  public long getStartTime()
  {
    return this.mSessionStartTime;
  }

  public void init(String paramString)
  {
    this.mAnalyticsClient.setApplicationKey(paramString);
    this.mAnalyticsClient.setSession(this);
  }

  public void onAppEnteredBackground()
  {
    this.mPreviousBackgroundTime = System.currentTimeMillis();
  }

  public void onAppEnteredForeground(Intent paramIntent)
  {
    onAppEnteredForeground(paramIntent, System.currentTimeMillis());
  }

  void onAppEnteredForeground(Intent paramIntent, long paramLong)
  {
    if ((this.mPreviousBackgroundTime != 0L) && (hasSessionExpired(paramLong, this.mPreviousBackgroundTime)))
      resetSession(paramLong);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.metrics.analytics.session.UberSessionGenerator
 * JD-Core Version:    0.6.2
 */