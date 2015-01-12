package com.ubercab.library.metrics.analytics;

import com.ubercab.library.metrics.analytics.event.EventName;

public final class AnalyticsEvent
{
  private final String mBlob;
  private final EventName mName;
  private final String mReferrer;
  private final String mType;
  private final String mUrl;
  private final String mValue;
  private final Long mValuePosition;

  private AnalyticsEvent(String paramString1, EventName paramEventName, String paramString2, String paramString3, String paramString4, String paramString5, Long paramLong)
  {
    this.mBlob = paramString1;
    this.mName = paramEventName;
    this.mReferrer = paramString2;
    this.mType = paramString3;
    this.mUrl = paramString4;
    this.mValue = paramString5;
    this.mValuePosition = paramLong;
  }

  public String getBlob()
  {
    return this.mBlob;
  }

  public EventName getName()
  {
    return this.mName;
  }

  public String getReferrer()
  {
    return this.mReferrer;
  }

  public String getType()
  {
    return this.mType;
  }

  public String getUrl()
  {
    return this.mUrl;
  }

  public String getValue()
  {
    return this.mValue;
  }

  public Long getValuePosition()
  {
    return this.mValuePosition;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("[AnalyticsEvent: (");
    localStringBuilder.append(this.mType).append(" - ").append(this.mName).append(")");
    if (this.mValue != null)
      localStringBuilder.append(" val: ").append(this.mValue);
    if (this.mValuePosition != null)
      localStringBuilder.append(" valPos: ").append(this.mValuePosition);
    if (this.mReferrer != null)
      localStringBuilder.append(" ref: ").append(this.mReferrer);
    if (this.mBlob != null)
      localStringBuilder.append(" blob: ").append(this.mBlob);
    return "]";
  }

  public static class Builder
  {
    private String mBlob;
    private EventName mName;
    private String mReferrer;
    private String mType;
    private String mUrl;
    private String mValue;
    private Long mValuePosition;

    public Builder(String paramString)
    {
      this.mType = paramString;
    }

    public AnalyticsEvent build()
    {
      return new AnalyticsEvent(this.mBlob, this.mName, this.mReferrer, this.mType, this.mUrl, this.mValue, this.mValuePosition, null);
    }

    public Builder setBlob(String paramString)
    {
      this.mBlob = paramString;
      return this;
    }

    public Builder setName(EventName paramEventName)
    {
      this.mName = paramEventName;
      return this;
    }

    public Builder setReferrer(String paramString)
    {
      this.mReferrer = paramString;
      return this;
    }

    public Builder setUrl(String paramString)
    {
      this.mUrl = paramString;
      return this;
    }

    public Builder setValue(String paramString)
    {
      this.mValue = paramString;
      return this;
    }

    public Builder setValuePosition(Long paramLong)
    {
      this.mValuePosition = paramLong;
      return this;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.metrics.analytics.AnalyticsEvent
 * JD-Core Version:    0.6.2
 */