package com.ubercab.client.core.analytics.event;

@Deprecated
public final class AppEvent extends AnalyticsEvent
{
  private static final String EVENT_APP_OPEN = "AppOpen";
  private static final String EVENT_NO_LOCATION_FOUND = "NoLocationFound";
  private static final String PARAM_VPL_APP_ID = "vplAppId";
  private static final String PARAM_VPL_DEVICE_ID = "vplDeviceId";

  public AppEvent(AnalyticsEvent.Listener paramListener)
  {
    super(paramListener);
  }

  private void send(String paramString)
  {
    sendEvent(new EventBuilder().setEventName(paramString).build());
  }

  public void noLocationFound()
  {
    send("NoLocationFound");
  }

  public void open(String paramString1, String paramString2)
  {
    sendEvent(new EventBuilder().setEventName("AppOpen").putParameter("vplAppId", paramString1).putParameter("vplDeviceId", paramString2).build());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.analytics.event.AppEvent
 * JD-Core Version:    0.6.2
 */