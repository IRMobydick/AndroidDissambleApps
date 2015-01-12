package com.ubercab.client.core.analytics.event;

@Deprecated
public final class LocationEvent extends AnalyticsEvent
{
  private static final String EVENT_ENABLE_LOCATION_SERVICES = "NoLocationEnableLocationServices";
  private static final String EVENT_ENTER_PICKUP_ADDRESS = "NoLocationEnterPickupAddress";
  private static final String EVENT_REVERSE_GEOCODE = "ReverseGeocode";
  private static final String EVENT_TAP_TO_REMOVE_OVERLAY = "NoLocationTapRemoveOverlay";
  private static final String REASON_UPDATE = "update";

  public LocationEvent(AnalyticsEvent.Listener paramListener)
  {
    super(paramListener);
  }

  private void send(String paramString)
  {
    sendEvent(new EventBuilder().setEventName(paramString).build());
  }

  public void noLocationTapToRemoveOverlay()
  {
    send("NoLocationTapRemoveOverlay");
  }

  public void pickupSearchWithoutLocationServices()
  {
    send("NoLocationEnterPickupAddress");
  }

  public void promptEnableLocationServices()
  {
    send("NoLocationEnableLocationServices");
  }

  public void updateReverseGeocode()
  {
    sendEvent(new EventBuilder().setEventName("ReverseGeocode").putParameter("reason", "update").build());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.analytics.event.LocationEvent
 * JD-Core Version:    0.6.2
 */