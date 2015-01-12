package com.ubercab.client.feature.payment.event;

import com.ubercab.client.core.model.PaymentProfile;

public final class ChangePaymentProfileEvent
{
  private PaymentProfile mPaymentProfile;

  public ChangePaymentProfileEvent(PaymentProfile paramPaymentProfile)
  {
    this.mPaymentProfile = paramPaymentProfile;
  }

  public PaymentProfile getPaymentProfile()
  {
    return this.mPaymentProfile;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.event.ChangePaymentProfileEvent
 * JD-Core Version:    0.6.2
 */