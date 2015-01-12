package com.ubercab.client.core.analytics.event;

import com.ubercab.library.util.TimeUtils;
import java.util.UUID;

@Deprecated
public final class SetUseCreditsEvent extends AnalyticsEvent
{
  private static final String EVENT_SET_USE_CREDITS_REQUEST = "SetUseCreditsRequest";
  private static final String EVENT_SET_USE_CREDITS_RESPONSE = "SetUseCreditsResponse";
  private long mEpoch;
  private String mUuid;

  public SetUseCreditsEvent(AnalyticsEvent.Listener paramListener)
  {
    super(paramListener);
  }

  public void setUseCreditsRequest(boolean paramBoolean)
  {
    this.mEpoch = TimeUtils.getEpochTimeMs();
    this.mUuid = UUID.randomUUID().toString();
    sendEvent(new EventBuilder().setEventName("SetUseCreditsRequest").putParameter("useCredits", Boolean.valueOf(paramBoolean)).putParameter("requestGuid", this.mUuid).build());
  }

  public void setUseCreditsResponse(int paramInt)
  {
    float f = AnalyticsUtils.calculateLatencyInSeconds(this.mEpoch);
    sendEvent(new EventBuilder().setEventName("SetUseCreditsResponse").putParameter("statusCode", Integer.valueOf(paramInt)).putParameter("latency", Float.valueOf(f)).putParameter("requestGuid", this.mUuid).build());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.analytics.event.SetUseCreditsEvent
 * JD-Core Version:    0.6.2
 */