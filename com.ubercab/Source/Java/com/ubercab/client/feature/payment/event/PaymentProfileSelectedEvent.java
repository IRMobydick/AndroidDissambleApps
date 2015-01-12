package com.ubercab.client.feature.payment.event;

import com.ubercab.client.core.model.PaymentProfile;

public final class PaymentProfileSelectedEvent
{
  private final boolean mIsUsingPoints;
  private final PaymentProfile mPaymentProfile;

  public PaymentProfileSelectedEvent(PaymentProfile paramPaymentProfile)
  {
    this(paramPaymentProfile, false);
  }

  public PaymentProfileSelectedEvent(PaymentProfile paramPaymentProfile, boolean paramBoolean)
  {
    this.mPaymentProfile = paramPaymentProfile;
    this.mIsUsingPoints = paramBoolean;
  }

  public PaymentProfile getPaymentProfile()
  {
    return this.mPaymentProfile;
  }

  public boolean isUsingPoints()
  {
    return this.mIsUsingPoints;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.event.PaymentProfileSelectedEvent
 * JD-Core Version:    0.6.2
 */