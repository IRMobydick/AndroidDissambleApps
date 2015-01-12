package com.ubercab.client.core.analytics.event;

import com.ubercab.library.util.TimeUtils;

@Deprecated
final class AnalyticsUtils
{
  static float calculateLatencyInSeconds(long paramLong)
  {
    return (float)(TimeUtils.getEpochTimeMs() - paramLong) / 1000.0F;
  }

  static String convertTripUIStateToParameter(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "";
    case 0:
      return "looking";
    case 1:
      return "confirming";
    case 2:
      return "dispatching";
    case 3:
      return "accepted";
    case 4:
      return "arrivingNow";
    case 5:
    }
    return "onTrip";
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.analytics.event.AnalyticsUtils
 * JD-Core Version:    0.6.2
 */