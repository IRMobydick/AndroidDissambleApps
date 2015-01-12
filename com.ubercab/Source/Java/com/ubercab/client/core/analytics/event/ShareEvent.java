package com.ubercab.client.core.analytics.event;

@Deprecated
public final class ShareEvent extends AnalyticsEvent
{
  private static final String EVENT_SHARE = "Share";
  private static final String EVENT_SHARE_ETA_OPEN = "ShareETAOpen";
  private static final String EVENT_SHARE_MY_ETA_ERROR = "ShareMyETAError";
  private static final String EVENT_SHARE_MY_ETA_REQUEST = "ShareMyETARequest";
  private static final String EVENT_SHARE_MY_ETA_SUCCESSFUL = "ShareMyETASuccessful";
  private static final String REASON_NATIVE = "native";
  private static final String REASON_SHARE_YOUR_RIDE = "share-your-ride";

  public ShareEvent(AnalyticsEvent.Listener paramListener)
  {
    super(paramListener);
  }

  private void share(String paramString1, String paramString2)
  {
    sendEvent(new EventBuilder().setEventName("Share").putParameter("method", paramString1.toLowerCase()).putParameter("reason", paramString2).build());
  }

  public void shareEta()
  {
    sendEvent(new EventBuilder().setEventName("Share").putParameter("reason", "share-your-ride").build());
  }

  public void shareEtaOpen()
  {
    sendEvent(new EventBuilder().setEventName("ShareETAOpen").build());
  }

  public void shareMyEtaError(int paramInt)
  {
    sendEvent(new EventBuilder().setEventName("ShareMyETAError").putParameter("statusCode", Integer.valueOf(paramInt)).build());
  }

  public void shareMyEtaRequest()
  {
    sendEvent(new EventBuilder().setEventName("ShareMyETARequest").build());
  }

  public void shareMyEtaSuccessful()
  {
    sendEvent(new EventBuilder().setEventName("ShareMyETASuccessful").build());
  }

  public void shareNative(String paramString)
  {
    share(paramString, "native");
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.analytics.event.ShareEvent
 * JD-Core Version:    0.6.2
 */