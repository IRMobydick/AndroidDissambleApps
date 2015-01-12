package com.ubercab.client.feature.trip.event;

import com.ubercab.client.core.model.PaymentProfile;
import com.ubercab.client.core.model.TripExpenseInfo;
import com.ubercab.client.feature.payment.event.SelectExpenseInfoEvent;

public class AddBusinessCardExpenseInfoEvent extends SelectExpenseInfoEvent
{
  private TripExpenseInfo mExpenseInfo;

  public AddBusinessCardExpenseInfoEvent(PaymentProfile paramPaymentProfile, TripExpenseInfo paramTripExpenseInfo)
  {
    super(paramPaymentProfile, true);
    this.mExpenseInfo = paramTripExpenseInfo;
  }

  public TripExpenseInfo getExpenseInfo()
  {
    return this.mExpenseInfo;
  }

  public String getPaymentProfileId()
  {
    if (getPaymentProfile() == null)
      return null;
    return getPaymentProfile().getId();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.event.AddBusinessCardExpenseInfoEvent
 * JD-Core Version:    0.6.2
 */