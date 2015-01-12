package com.ubercab.client.core.analytics.event;

import java.util.Map;

@Deprecated
public abstract class AnalyticsEvent
{
  private final Listener mListener;

  protected AnalyticsEvent(Listener paramListener)
  {
    this.mListener = paramListener;
  }

  protected void sendEvent(Map<String, Object> paramMap)
  {
    this.mListener.onSendEvent(paramMap);
  }

  public static abstract interface Listener
  {
    public abstract void onSendEvent(Map<String, Object> paramMap);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.analytics.event.AnalyticsEvent
 * JD-Core Version:    0.6.2
 */