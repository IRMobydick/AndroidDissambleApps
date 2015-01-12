package com.ubercab.client.feature.about.event;

import com.ubercab.library.metrics.analytics.event.ImpressionEventName;

public final class SelectWebViewEvent
{
  private final ImpressionEventName mImpressionEventName;
  private final String mTitle;
  private final String mUrl;

  public SelectWebViewEvent(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, null);
  }

  public SelectWebViewEvent(String paramString1, String paramString2, ImpressionEventName paramImpressionEventName)
  {
    this.mTitle = paramString1;
    this.mUrl = paramString2;
    this.mImpressionEventName = paramImpressionEventName;
  }

  public ImpressionEventName getImpressionEventName()
  {
    return this.mImpressionEventName;
  }

  public String getTitle()
  {
    return this.mTitle;
  }

  public String getUrl()
  {
    return this.mUrl;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.about.event.SelectWebViewEvent
 * JD-Core Version:    0.6.2
 */