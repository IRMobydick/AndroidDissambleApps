package com.ubercab.client.feature.trip.event;

import com.ubercab.client.core.model.TripExpenseInfo;

public final class ChangeTripPaymentEvent
{
  private String mCurrentPaymentProfileId;
  private TripExpenseInfo mExpenseInfo;

  public ChangeTripPaymentEvent(String paramString, TripExpenseInfo paramTripExpenseInfo)
  {
    this.mCurrentPaymentProfileId = paramString;
    this.mExpenseInfo = paramTripExpenseInfo;
  }

  public String getCurrentPaymentProfileId()
  {
    return this.mCurrentPaymentProfileId;
  }

  public TripExpenseInfo getExpenseInfo()
  {
    return this.mExpenseInfo;
  }

  public boolean isSendExpense()
  {
    return this.mExpenseInfo.isExpenseTrip();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.event.ChangeTripPaymentEvent
 * JD-Core Version:    0.6.2
 */