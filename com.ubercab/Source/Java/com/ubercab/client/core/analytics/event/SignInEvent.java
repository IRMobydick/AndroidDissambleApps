package com.ubercab.client.core.analytics.event;

import com.ubercab.library.util.TimeUtils;
import java.util.UUID;

@Deprecated
public final class SignInEvent extends AnalyticsEvent
{
  private static final String EVENT_SIGN_IN_PAGE_VIEW = "SignInPageView";
  private static final String EVENT_SIGN_IN_REQUEST = "SignInRequest";
  private static final String EVENT_SIGN_IN_RESPONSE = "SignInResponse";
  private long mEpoch;
  private String mUuid;

  public SignInEvent(AnalyticsEvent.Listener paramListener)
  {
    super(paramListener);
  }

  public void signInPageView()
  {
    sendEvent(new EventBuilder().setEventName("SignInPageView").build());
  }

  public void signInRequest()
  {
    this.mEpoch = TimeUtils.getEpochTimeMs();
    this.mUuid = UUID.randomUUID().toString();
    sendEvent(new EventBuilder().setEventName("SignInRequest").putParameter("requestGuid", this.mUuid).build());
  }

  public void signInResponse(int paramInt)
  {
    float f = AnalyticsUtils.calculateLatencyInSeconds(this.mEpoch);
    sendEvent(new EventBuilder().setEventName("SignInResponse").putParameter("latency", Float.valueOf(f)).putParameter("statusCode", Integer.valueOf(paramInt)).putParameter("requestGuid", this.mUuid).build());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.analytics.event.SignInEvent
 * JD-Core Version:    0.6.2
 */