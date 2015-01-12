package com.ubercab.client.core.metrics.monitoring;

import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.Trip;
import com.ubercab.client.core.model.TripDriver;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.library.metrics.monitoring.MonitoringProperties;
import java.util.HashMap;
import java.util.Map;

public class RiderMonitoringProperties
  implements MonitoringProperties
{
  private static final String APP_NAME_VALUE = "rider_app";
  private static final String KEY_APP_NAME = "app_name";
  private static final String KEY_DRIVER_ID = "driver_id";
  private static final String KEY_RIDER_ID = "rider_id";
  private static final String KEY_TRIP_ID = "trip_id";
  private PingProvider mPingProvider;

  public RiderMonitoringProperties(PingProvider paramPingProvider)
  {
    this.mPingProvider = paramPingProvider;
  }

  public Map<String, Object> generateProperties()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("app_name", "rider_app");
    Ping localPing = this.mPingProvider.get();
    if (PingUtils.hasClient(localPing))
      localHashMap.put("rider_id", localPing.getClient().getUuid());
    if (PingUtils.hasTrip(localPing))
    {
      Trip localTrip = localPing.getTrip();
      localHashMap.put("trip_id", localTrip.getId());
      localHashMap.put("driver_id", localTrip.getDriver().getUuid());
    }
    return localHashMap;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.metrics.monitoring.RiderMonitoringProperties
 * JD-Core Version:    0.6.2
 */