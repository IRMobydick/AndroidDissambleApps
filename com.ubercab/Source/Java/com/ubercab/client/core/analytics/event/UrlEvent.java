package com.ubercab.client.core.analytics.event;

import android.net.Uri;

@Deprecated
public final class UrlEvent extends AnalyticsEvent
{
  private static final String CLIENT_ID_PARAMETER = "client_id";
  private static final String EVENT_HANDLE_URL = "HandleURL";

  public UrlEvent(AnalyticsEvent.Listener paramListener)
  {
    super(paramListener);
  }

  public void handleUrl(Uri paramUri)
  {
    sendEvent(new EventBuilder().setEventName("HandleURL").putParameter("url", paramUri.toString()).putParameter("sourceApplication", paramUri.getQueryParameter("client_id")).build());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.analytics.event.UrlEvent
 * JD-Core Version:    0.6.2
 */