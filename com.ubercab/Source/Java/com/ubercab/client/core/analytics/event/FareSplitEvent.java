package com.ubercab.client.core.analytics.event;

@Deprecated
public final class FareSplitEvent extends AnalyticsEvent
{
  private static final String EVENT_FARE_SPLIT_ACCEPT = "FareSplitAccept";
  private static final String EVENT_FARE_SPLIT_DECLINE = "FareSplitDecline";
  private static final String EVENT_FARE_SPLIT_OPEN = "FareSplitOpen";
  private static final String EVENT_FARE_SPLIT_SEND = "FareSplitSend";
  private static final String EVENT_FARE_SPLIT_UNINVITE = "FareSplitUninvite";
  private static final String REASON_MASTER = "master";
  private static final String REASON_MINION = "minion";

  public FareSplitEvent(AnalyticsEvent.Listener paramListener)
  {
    super(paramListener);
  }

  public void accept()
  {
    sendEvent(new EventBuilder().setEventName("FareSplitAccept").build());
  }

  public void decline()
  {
    sendEvent(new EventBuilder().setEventName("FareSplitDecline").build());
  }

  public void open(boolean paramBoolean)
  {
    EventBuilder localEventBuilder = new EventBuilder().setEventName("FareSplitOpen");
    if (paramBoolean);
    for (String str = "master"; ; str = "minion")
    {
      sendEvent(localEventBuilder.putParameter("reason", str).build());
      return;
    }
  }

  public void send(int paramInt)
  {
    sendEvent(new EventBuilder().setEventName("FareSplitSend").putParameter("numberOfInvitees", Integer.valueOf(paramInt)).build());
  }

  public void uninvite()
  {
    sendEvent(new EventBuilder().setEventName("FareSplitUninvite").build());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.analytics.event.FareSplitEvent
 * JD-Core Version:    0.6.2
 */