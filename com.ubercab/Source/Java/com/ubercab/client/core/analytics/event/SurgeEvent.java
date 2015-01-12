package com.ubercab.client.core.analytics.event;

@Deprecated
public final class SurgeEvent extends AnalyticsEvent
{
  private static final String EVENT_SURGE_ACCEPT = "SurgeAccept";
  private static final String EVENT_SURGE_CANCEL = "SurgeCancel";
  private static final String EVENT_SURGE_DISPLAY = "SurgeDisplay";
  private static final String EVENT_SURGE_NOTIFY_CONFIRM = "SurgeNotifyConfirm";
  private static final String EVENT_SURGE_NOTIFY_FAILURE = "SurgeNotifyFailure";
  private static final String EVENT_SURGE_NOTIFY_SUCCESS = "SurgeNotifySuccess";
  private static final String EVENT_SURGE_TIMEOUT = "SurgeTimeout";

  public SurgeEvent(AnalyticsEvent.Listener paramListener)
  {
    super(paramListener);
  }

  private void surgeEvent(String paramString1, long paramLong, String paramString2, float paramFloat)
  {
    sendEvent(new EventBuilder().setEventName(paramString1).putParameter("fareId", Long.valueOf(paramLong)).putParameter("vehicleViewId", paramString2).putParameter("multiplier", Float.valueOf(paramFloat)).build());
  }

  public void surgeAccept(long paramLong, String paramString, float paramFloat)
  {
    surgeEvent("SurgeAccept", paramLong, paramString, paramFloat);
  }

  public void surgeCancel(long paramLong, String paramString, float paramFloat)
  {
    surgeEvent("SurgeCancel", paramLong, paramString, paramFloat);
  }

  public void surgeDisplay(long paramLong, String paramString, float paramFloat)
  {
    surgeEvent("SurgeDisplay", paramLong, paramString, paramFloat);
  }

  public void surgeNotifyConfirm()
  {
    sendEvent(new EventBuilder().setEventName("SurgeNotifyConfirm").build());
  }

  public void surgeNotifyFailure()
  {
    sendEvent(new EventBuilder().setEventName("SurgeNotifyFailure").build());
  }

  public void surgeNotifySuccess()
  {
    sendEvent(new EventBuilder().setEventName("SurgeNotifySuccess").build());
  }

  public void surgeTimeout(long paramLong, String paramString, float paramFloat)
  {
    surgeEvent("SurgeTimeout", paramLong, paramString, paramFloat);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.analytics.event.SurgeEvent
 * JD-Core Version:    0.6.2
 */