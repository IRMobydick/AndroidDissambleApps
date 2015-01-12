package com.ubercab.client.core.analytics.event;

import com.ubercab.library.util.TimeUtils;
import java.util.UUID;

@Deprecated
public final class AddExpenseInfoEvent extends AnalyticsEvent
{
  private static final String EVENT_ADD_EXPENSE_INFO_REQUEST = "AddExpenseInfoRequest";
  private static final String EVENT_ADD_EXPENSE_INFO_RESPONSE = "AddExpenseInfoResponse";
  private long mEpoch;
  private String mUuid;

  public AddExpenseInfoEvent(AnalyticsEvent.Listener paramListener)
  {
    super(paramListener);
  }

  public void addExpenseInfoRequest(boolean paramBoolean)
  {
    this.mEpoch = TimeUtils.getEpochTimeMs();
    this.mUuid = UUID.randomUUID().toString();
    sendEvent(new EventBuilder().setEventName("AddExpenseInfoRequest").putParameter("expenseTrip", Boolean.valueOf(paramBoolean)).putParameter("requestGuid", this.mUuid).build());
  }

  public void addExpenseInfoResponse(int paramInt)
  {
    float f = AnalyticsUtils.calculateLatencyInSeconds(this.mEpoch);
    sendEvent(new EventBuilder().setEventName("AddExpenseInfoResponse").putParameter("statusCode", Integer.valueOf(paramInt)).putParameter("latency", Float.valueOf(f)).putParameter("requestGuid", this.mUuid).build());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.analytics.event.AddExpenseInfoEvent
 * JD-Core Version:    0.6.2
 */