package com.ubercab.client.core.analytics.event;

import com.ubercab.library.util.TimeUtils;
import java.util.UUID;

@Deprecated
public final class CancelTripEvent extends AnalyticsEvent
{
  private static final String EVENT_CANCEL_TRIP_REQUEST = "CancelTripRequest";
  private static final String EVENT_CANCEL_TRIP_RESPONSE = "CancelTripResponse";
  private long mEpoch;
  private String mUuid;

  public CancelTripEvent(AnalyticsEvent.Listener paramListener)
  {
    super(paramListener);
  }

  public void cancelTripRequest(String paramString)
  {
    this.mEpoch = TimeUtils.getEpochTimeMs();
    this.mUuid = UUID.randomUUID().toString();
    sendEvent(new EventBuilder().setEventName("CancelTripRequest").putParameter("requestGuid", this.mUuid).putParameter("method", paramString).build());
  }

  public void cancelTripResponse(int paramInt)
  {
    float f = AnalyticsUtils.calculateLatencyInSeconds(this.mEpoch);
    sendEvent(new EventBuilder().setEventName("CancelTripResponse").putParameter("statusCode", Integer.valueOf(paramInt)).putParameter("latency", Float.valueOf(f)).putParameter("requestGuid", this.mUuid).build());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.analytics.event.CancelTripEvent
 * JD-Core Version:    0.6.2
 */