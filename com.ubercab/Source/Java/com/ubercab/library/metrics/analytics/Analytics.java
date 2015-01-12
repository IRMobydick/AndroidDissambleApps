package com.ubercab.library.metrics.analytics;

import com.ubercab.library.app.BuildConfigProxy;
import com.ubercab.library.app.UberPreferences;
import com.ubercab.library.location.LocationProvider;
import com.ubercab.library.metrics.MetricsApi;

public final class Analytics
{
  private AnalyticsClient mAnalyticsClient;

  public static Analytics getInstance()
  {
    return AnalyticsHolder.INSTANCE;
  }

  public static void init(BuildConfigProxy paramBuildConfigProxy, UberPreferences paramUberPreferences, AnalyticsProperties paramAnalyticsProperties, MetricsApi paramMetricsApi, LocationProvider paramLocationProvider)
  {
    getInstance().mAnalyticsClient = new AnalyticsClient(paramBuildConfigProxy, paramUberPreferences, paramAnalyticsProperties, paramMetricsApi, paramLocationProvider);
  }

  public AnalyticsClient getAnalyticsClient()
  {
    if (this.mAnalyticsClient == null)
      throw new RuntimeException("Analytics singleton not initialized.");
    return this.mAnalyticsClient;
  }

  private static class AnalyticsHolder
  {
    private static final Analytics INSTANCE = new Analytics(null);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.metrics.analytics.Analytics
 * JD-Core Version:    0.6.2
 */