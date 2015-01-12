package com.ubercab.library.metrics.analytics;

import com.google.gson.JsonParser;
import com.ubercab.common.collect.EvictingQueue;
import com.ubercab.common.collect.ImmutableList;
import com.ubercab.library.app.BuildConfigProxy;
import com.ubercab.library.app.UberPreferences;
import com.ubercab.library.location.LocationProvider;
import com.ubercab.library.metrics.MetricsApi;
import com.ubercab.library.metrics.MetricsLocation;
import com.ubercab.library.metrics.analytics.event.CustomEventName;
import com.ubercab.library.metrics.analytics.event.EventName;
import com.ubercab.library.metrics.analytics.event.ImpressionEventName;
import com.ubercab.library.metrics.analytics.event.TapEventName;
import com.ubercab.library.metrics.analytics.session.SessionGenerator;
import com.ubercab.library.network.CallbackAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import retrofit.RetrofitError;
import retrofit.client.Response;
import timber.log.Timber;

public class AnalyticsClient
{
  private static final ImmutableList<String> LAST_USER_ACTION_EVENTS = ImmutableList.of("lifecycle", "tap");
  public static boolean LOGGING_ENABLED = false;
  static final int MAX_LOG_COUNT = 200;
  private static AnalyticsClient sInstance;
  private final AnalyticsProperties mAnalyticsProperties;
  private String mApplicationKey;
  private final BuildConfigProxy mBuildConfig;
  private final List<Map<String, Object>> mEventQueue;
  private Long mForegroundStartTime;
  private String mLastUserAction;
  private final List<Listener> mListeners;
  private final LocationProvider mLocationProvider;
  private final EvictingQueue<Map<String, Object>> mLoggedEvents;
  private final MetricsApi mMetricsApi;
  private SessionGenerator mSession;
  private final UberPreferences mUberPreferences;

  public AnalyticsClient(BuildConfigProxy paramBuildConfigProxy, UberPreferences paramUberPreferences, AnalyticsProperties paramAnalyticsProperties, MetricsApi paramMetricsApi, LocationProvider paramLocationProvider)
  {
    this.mBuildConfig = paramBuildConfigProxy;
    this.mUberPreferences = paramUberPreferences;
    this.mAnalyticsProperties = paramAnalyticsProperties;
    this.mMetricsApi = paramMetricsApi;
    this.mLocationProvider = paramLocationProvider;
    this.mEventQueue = new LinkedList();
    this.mListeners = new CopyOnWriteArrayList();
    this.mLoggedEvents = EvictingQueue.create(200);
    LOGGING_ENABLED = this.mUberPreferences.getAnalyticsV2Logging();
  }

  private void sendEvent(String paramString, EventName paramEventName)
  {
    addEvent(new AnalyticsEvent.Builder(paramString).setName(paramEventName).build());
  }

  public void addEvent(AnalyticsEvent paramAnalyticsEvent)
  {
    if (!this.mUberPreferences.isAnalyticsV2Disabled())
    {
      Map localMap = buildEvent(paramAnalyticsEvent);
      if (LOGGING_ENABLED)
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = paramAnalyticsEvent;
        arrayOfObject[1] = this.mLastUserAction;
        Timber.d("addEvent: %s from [%s]", arrayOfObject);
        this.mLoggedEvents.add(localMap);
        Iterator localIterator = this.mListeners.iterator();
        while (localIterator.hasNext())
          ((Listener)localIterator.next()).onEventAdded(paramAnalyticsEvent.getName(), paramAnalyticsEvent.getType());
      }
      this.mEventQueue.add(localMap);
      if (LAST_USER_ACTION_EVENTS.contains(paramAnalyticsEvent.getType()))
        this.mLastUserAction = paramAnalyticsEvent.getName().toString();
    }
  }

  public void addListener(Listener paramListener)
  {
    this.mListeners.add(paramListener);
  }

  Map<String, Object> buildEvent(AnalyticsEvent paramAnalyticsEvent)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("epoch_ms", Long.valueOf(System.currentTimeMillis()));
    if (this.mSession != null)
    {
      localHashMap.put("session_id", this.mSession.getId());
      localHashMap.put("session_start_time_ms", Long.valueOf(this.mSession.getStartTime()));
    }
    localHashMap.put("foreground_start_time_ms", this.mForegroundStartTime);
    localHashMap.put("location", MetricsLocation.createLocation(this.mLocationProvider.getLocation()));
    if (paramAnalyticsEvent != null)
    {
      localHashMap.put("name", paramAnalyticsEvent.getName().name().toLowerCase());
      localHashMap.put("type", paramAnalyticsEvent.getType());
      localHashMap.put("last_user_action", this.mLastUserAction);
      localHashMap.put("referrer", paramAnalyticsEvent.getReferrer());
      localHashMap.put("value", paramAnalyticsEvent.getValue());
      localHashMap.put("value_position", paramAnalyticsEvent.getValuePosition());
      localHashMap.put("blob", paramAnalyticsEvent.getBlob());
    }
    localHashMap.put(this.mApplicationKey, new JsonParser().parse(this.mAnalyticsProperties.generateJsonPayload()));
    localHashMap.put("app_name", this.mApplicationKey);
    return localHashMap;
  }

  String getApplicationKey()
  {
    return this.mApplicationKey;
  }

  public EvictingQueue<Map<String, Object>> getLoggedEvents()
  {
    return this.mLoggedEvents;
  }

  public void removeListener(Listener paramListener)
  {
    this.mListeners.remove(paramListener);
  }

  public void sendCustomEvent(CustomEventName paramCustomEventName)
  {
    sendEvent("custom", paramCustomEventName);
  }

  public void sendEvents()
  {
    if (this.mEventQueue.isEmpty())
      return;
    HashMap localHashMap = new HashMap();
    localHashMap.put("events", new ArrayList(this.mEventQueue));
    this.mMetricsApi.sendAnalytics(localHashMap, new CallbackAdapter()
    {
      public void failure(RetrofitError paramAnonymousRetrofitError)
      {
        if ((AnalyticsClient.this.mBuildConfig.isDebug()) && (paramAnonymousRetrofitError.getResponse() != null) && (paramAnonymousRetrofitError.getResponse().getStatus() == 400))
          throw new RuntimeException("Server rejected analytics events.", paramAnonymousRetrofitError);
      }
    });
    if (LOGGING_ENABLED)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(this.mEventQueue.size());
      Timber.d("Sent %d queued events", arrayOfObject);
    }
    this.mEventQueue.clear();
  }

  public void sendImpressionEvent(ImpressionEventName paramImpressionEventName)
  {
    sendEvent("impression", paramImpressionEventName);
  }

  public void sendTapEvent(TapEventName paramTapEventName)
  {
    sendEvent("tap", paramTapEventName);
  }

  public void setApplicationKey(String paramString)
  {
    this.mApplicationKey = paramString;
  }

  public void setForegroundStartTime(long paramLong)
  {
    this.mForegroundStartTime = Long.valueOf(paramLong);
  }

  public void setSession(SessionGenerator paramSessionGenerator)
  {
    this.mSession = paramSessionGenerator;
  }

  public static abstract interface Listener
  {
    public abstract void onEventAdded(EventName paramEventName, String paramString);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.metrics.analytics.AnalyticsClient
 * JD-Core Version:    0.6.2
 */