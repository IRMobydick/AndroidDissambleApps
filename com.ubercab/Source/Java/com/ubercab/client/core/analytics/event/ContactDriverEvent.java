package com.ubercab.client.core.analytics.event;

@Deprecated
public final class ContactDriverEvent extends AnalyticsEvent
{
  private static final String EVENT_CONTACT_DRIVER = "ContactDriver";
  private static final String EVENT_CONTACT_DRIVER_OPEN = "ContactDriverOpen";
  private static final String METHOD_SMS = "sms";
  private static final String METHOD_VOICE = "voice";

  public ContactDriverEvent(AnalyticsEvent.Listener paramListener)
  {
    super(paramListener);
  }

  public void open()
  {
    sendEvent(new EventBuilder().setEventName("ContactDriverOpen").build());
  }

  public void sms()
  {
    sendEvent(new EventBuilder().setEventName("ContactDriver").putParameter("method", "sms").build());
  }

  public void voice()
  {
    sendEvent(new EventBuilder().setEventName("ContactDriver").putParameter("method", "voice").build());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.analytics.event.ContactDriverEvent
 * JD-Core Version:    0.6.2
 */