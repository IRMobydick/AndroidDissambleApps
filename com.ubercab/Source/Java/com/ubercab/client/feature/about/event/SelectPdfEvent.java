package com.ubercab.client.feature.about.event;

public final class SelectPdfEvent
{
  private final String mUrl;

  public SelectPdfEvent(String paramString)
  {
    this.mUrl = paramString;
  }

  public String getUrl()
  {
    return this.mUrl;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.about.event.SelectPdfEvent
 * JD-Core Version:    0.6.2
 */