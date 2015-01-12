package com.ubercab.client.core.analytics.event;

@Deprecated
public final class RateDriverEvent extends AnalyticsEvent
{
  private static final String EVENT_RATE_DRIVER_SUBMIT = "RateDriverSubmit";
  private static final String EVENT_RATE_DRIVER_VIEW = "RateDriverView";

  public RateDriverEvent(AnalyticsEvent.Listener paramListener)
  {
    super(paramListener);
  }

  public void submit(int paramInt, String paramString)
  {
    sendEvent(new EventBuilder().setEventName("RateDriverSubmit").putParameter("reason", Integer.valueOf(paramInt)).putParameter("messageID", paramString).build());
  }

  public void view(String paramString)
  {
    sendEvent(new EventBuilder().setEventName("RateDriverView").putParameter("messageID", paramString).build());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.analytics.event.RateDriverEvent
 * JD-Core Version:    0.6.2
 */