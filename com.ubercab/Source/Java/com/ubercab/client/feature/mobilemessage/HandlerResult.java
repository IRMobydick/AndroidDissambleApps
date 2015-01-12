package com.ubercab.client.feature.mobilemessage;

import com.ubercab.library.metrics.analytics.AnalyticsEvent;
import com.ubercab.library.metrics.analytics.AnalyticsEvent.Builder;
import com.ubercab.library.metrics.analytics.event.TapEventName;

public final class HandlerResult
{
  public static final HandlerResult ERROR = new Builder().setSuccess(false).build();
  public static final HandlerResult OK = new Builder().setSuccess(true).build();
  private TapEventName mAnalyticsEventName;
  private String mAnalyticsEventType;
  private String mAnalyticsEventValue;
  private String mAnalyticsReferrer;
  private boolean mDismissMessage;
  private boolean mSuccess;

  public AnalyticsEvent getAnalyticsEvent()
  {
    return new AnalyticsEvent.Builder(this.mAnalyticsEventType).setName(this.mAnalyticsEventName).setValue(this.mAnalyticsEventValue).setReferrer(this.mAnalyticsReferrer).build();
  }

  public boolean isDismissMessage()
  {
    return this.mDismissMessage;
  }

  public boolean isSuccess()
  {
    return this.mSuccess;
  }

  public boolean shouldSendAnalytics()
  {
    return (this.mAnalyticsEventType != null) && (this.mAnalyticsEventName != null);
  }

  public static class Builder
  {
    private TapEventName mAnalyticsEventName;
    private String mAnalyticsEventType = "tap";
    private String mAnalyticsEventValue;
    private String mAnalyticsReferrer;
    private boolean mDismissMessage = false;
    private boolean mSuccess = true;

    public HandlerResult build()
    {
      HandlerResult localHandlerResult = new HandlerResult(null);
      HandlerResult.access$102(localHandlerResult, this.mSuccess);
      HandlerResult.access$202(localHandlerResult, this.mDismissMessage);
      HandlerResult.access$302(localHandlerResult, this.mAnalyticsEventType);
      HandlerResult.access$402(localHandlerResult, this.mAnalyticsEventName);
      HandlerResult.access$502(localHandlerResult, this.mAnalyticsEventValue);
      HandlerResult.access$602(localHandlerResult, this.mAnalyticsReferrer);
      return localHandlerResult;
    }

    public Builder setAnalyticsEventName(TapEventName paramTapEventName)
    {
      this.mAnalyticsEventName = paramTapEventName;
      return this;
    }

    public Builder setAnalyticsEventType(String paramString)
    {
      this.mAnalyticsEventType = paramString;
      return this;
    }

    public Builder setAnalyticsEventValue(String paramString)
    {
      this.mAnalyticsEventValue = paramString;
      return this;
    }

    public Builder setAnalyticsReferrer(String paramString)
    {
      this.mAnalyticsReferrer = paramString;
      return this;
    }

    public Builder setDismissMessage(boolean paramBoolean)
    {
      this.mDismissMessage = paramBoolean;
      return this;
    }

    public Builder setSuccess(boolean paramBoolean)
    {
      this.mSuccess = paramBoolean;
      return this;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.mobilemessage.HandlerResult
 * JD-Core Version:    0.6.2
 */