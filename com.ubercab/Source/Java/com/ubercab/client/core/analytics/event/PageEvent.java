package com.ubercab.client.core.analytics.event;

@Deprecated
public final class PageEvent extends AnalyticsEvent
{
  private static final String CONTEXT_DROPOFF = "dropoff";
  private static final String CONTEXT_PICKUP = "pickup";
  private static final String EVENT_CONFIRM_PAGE_VIEW = "ConfirmPageView";
  private static final String EVENT_MAP_PAGE_VIEW = "MapPageView";
  private static final String EVENT_SCAVENGER_RESULTS_IMPRESSION = "ScavengerResultsImpression";

  public PageEvent(AnalyticsEvent.Listener paramListener)
  {
    super(paramListener);
  }

  private void searchResultImpressions(int paramInt, String paramString)
  {
    sendEvent(new EventBuilder().setEventName("ScavengerResultsImpression").putParameter("page", Integer.valueOf(paramInt)).putParameter("reason", paramString).build());
  }

  public void confirmPageView()
  {
    sendEvent(new EventBuilder().setEventName("ConfirmPageView").build());
  }

  public void dropoffSearchResultImpressions(int paramInt)
  {
    searchResultImpressions(paramInt, "dropoff");
  }

  public void mapPageView()
  {
    sendEvent(new EventBuilder().setEventName("MapPageView").build());
  }

  public void pickupSearchResultImpressions(int paramInt)
  {
    searchResultImpressions(paramInt, "pickup");
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.analytics.event.PageEvent
 * JD-Core Version:    0.6.2
 */