package com.ubercab.client.feature.payment.event;

import com.ubercab.client.core.model.PaymentProfile;

public class SelectExpenseInfoEvent
{
  private boolean mIsShowSkipButton;
  private PaymentProfile mProfile;

  public SelectExpenseInfoEvent(PaymentProfile paramPaymentProfile, boolean paramBoolean)
  {
    this.mIsShowSkipButton = paramBoolean;
    this.mProfile = paramPaymentProfile;
  }

  public PaymentProfile getPaymentProfile()
  {
    return this.mProfile;
  }

  public boolean isShowSkipButton()
  {
    return this.mIsShowSkipButton;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.event.SelectExpenseInfoEvent
 * JD-Core Version:    0.6.2
 */