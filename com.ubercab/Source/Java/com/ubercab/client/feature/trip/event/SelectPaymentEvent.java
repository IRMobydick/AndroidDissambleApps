package com.ubercab.client.feature.trip.event;

import com.ubercab.client.core.model.PaymentProfile;
import com.ubercab.client.core.model.TripExpenseInfo;

public final class SelectPaymentEvent
{
  private PaymentProfile mCurrentPaymentProfile;
  private TripExpenseInfo mExpenseInfo;
  private boolean mIsUsingCredits;
  private boolean mIsUsingPoints;

  public SelectPaymentEvent(PaymentProfile paramPaymentProfile, boolean paramBoolean1, boolean paramBoolean2, TripExpenseInfo paramTripExpenseInfo)
  {
    this.mCurrentPaymentProfile = paramPaymentProfile;
    this.mIsUsingCredits = paramBoolean1;
    this.mIsUsingPoints = paramBoolean2;
    this.mExpenseInfo = paramTripExpenseInfo;
  }

  public PaymentProfile getCurrentPaymentProfile()
  {
    return this.mCurrentPaymentProfile;
  }

  public TripExpenseInfo getExpenseInfo()
  {
    return this.mExpenseInfo;
  }

  public boolean isSendExpense()
  {
    return this.mExpenseInfo.isExpenseTrip();
  }

  public boolean isUsingCredits()
  {
    return this.mIsUsingCredits;
  }

  public boolean isUsingPoints()
  {
    return this.mIsUsingPoints;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.event.SelectPaymentEvent
 * JD-Core Version:    0.6.2
 */