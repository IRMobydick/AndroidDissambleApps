package com.ubercab.library.metrics.monitoring;

import com.ubercab.library.app.BuildConfigProxy;
import com.ubercab.library.app.UberPreferences;
import com.ubercab.library.location.LocationProvider;
import com.ubercab.library.metrics.Device;
import com.ubercab.library.metrics.MetricsApi;
import com.ubercab.library.metrics.MetricsLocation;
import com.ubercab.library.network.CallbackAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MonitoringClient
{
  private final MetricsApi mAnalyticsApi;
  private final BuildConfigProxy mBuildConfig;
  private final Device mDevice;
  private final List<Map<String, Object>> mEventQueue;
  private final LocationProvider mLocationProvider;
  private MonitoringProperties mMonitoringProperties;
  private final UberPreferences mUberPreferences;

  public MonitoringClient(BuildConfigProxy paramBuildConfigProxy, UberPreferences paramUberPreferences, MetricsApi paramMetricsApi, LocationProvider paramLocationProvider, Device paramDevice)
  {
    this.mBuildConfig = paramBuildConfigProxy;
    this.mUberPreferences = paramUberPreferences;
    this.mAnalyticsApi = paramMetricsApi;
    this.mLocationProvider = paramLocationProvider;
    this.mEventQueue = Collections.synchronizedList(new LinkedList());
    this.mDevice = paramDevice;
  }

  public void addEvent(MonitoringEvent paramMonitoringEvent)
  {
    if (this.mUberPreferences.isMonitoringEnabled())
      this.mEventQueue.add(buildEvent(paramMonitoringEvent));
  }

  Map<String, Object> buildEvent(MonitoringEvent paramMonitoringEvent)
  {
    HashMap localHashMap = new HashMap();
    if (this.mMonitoringProperties != null)
    {
      Map localMap = this.mMonitoringProperties.generateProperties();
      if (localMap != null)
      {
        Iterator localIterator = localMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localHashMap.put(str, localMap.get(str));
        }
      }
    }
    localHashMap.put("epoch_ms", Long.valueOf(System.currentTimeMillis()));
    localHashMap.put("location", MetricsLocation.createLocation(this.mLocationProvider.getLocation()));
    localHashMap.put("device", this.mDevice);
    if (paramMonitoringEvent != null)
    {
      localHashMap.put("method", paramMonitoringEvent.getMethod());
      localHashMap.put("hostname", paramMonitoringEvent.getHostname());
      localHashMap.put("path", paramMonitoringEvent.getPath());
      localHashMap.put("message_type", paramMonitoringEvent.getMessageType());
      localHashMap.put("api_command_path", paramMonitoringEvent.getApiCommandPath());
      localHashMap.put("status_code", Integer.valueOf(paramMonitoringEvent.getStatusCode()));
      localHashMap.put("response_type", paramMonitoringEvent.getResponseType());
      localHashMap.put("roundtrip_time_ms", Long.valueOf(paramMonitoringEvent.getRoundtripTimeMs()));
    }
    return localHashMap;
  }

  public void sendEvents()
  {
    if (this.mEventQueue.isEmpty())
      return;
    HashMap localHashMap = new HashMap();
    localHashMap.put("events", new ArrayList(this.mEventQueue));
    this.mAnalyticsApi.sendMonitoring(localHashMap, new CallbackAdapter()
    {
      public void failure(RetrofitError paramAnonymousRetrofitError)
      {
        if ((MonitoringClient.this.mBuildConfig.isDebug()) && (paramAnonymousRetrofitError.getResponse() != null) && (paramAnonymousRetrofitError.getResponse().getStatus() == 400))
          throw new RuntimeException("Server rejected metrics events.", paramAnonymousRetrofitError);
      }
    });
    this.mEventQueue.clear();
  }

  public void setMonitoringProperties(MonitoringProperties paramMonitoringProperties)
  {
    this.mMonitoringProperties = paramMonitoringProperties;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.metrics.monitoring.MonitoringClient
 * JD-Core Version:    0.6.2
 */