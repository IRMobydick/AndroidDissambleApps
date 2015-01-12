package com.ubercab.client.core.analytics.event;

import com.ubercab.library.util.TimeUtils;

@Deprecated
public final class SessionEvent extends AnalyticsEvent
{
  private static final String EVENT_SESSION_LENGTH = "SessionLength";
  private static final String EVENT_SESSION_START = "SessionStart";
  private long mEpoch;

  public SessionEvent(AnalyticsEvent.Listener paramListener)
  {
    super(paramListener);
  }

  public void sessionEnd()
  {
    float f = AnalyticsUtils.calculateLatencyInSeconds(this.mEpoch);
    sendEvent(new EventBuilder().setEventName("SessionLength").putParameter("length", Float.valueOf(f)).build());
  }

  public void sessionStart()
  {
    this.mEpoch = TimeUtils.getEpochTimeMs();
    sendEvent(new EventBuilder().setEventName("SessionStart").build());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.analytics.event.SessionEvent
 * JD-Core Version:    0.6.2
 */