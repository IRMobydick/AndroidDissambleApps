package com.ubercab.client.feature.payment.event;

public final class ShowRewardInfoEvent
{
  private final String mCardNumber;
  private final boolean mIsEarnOnly;
  private final String mPaymentProfileId;

  public ShowRewardInfoEvent(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.mPaymentProfileId = paramString1;
    this.mCardNumber = paramString2;
    this.mIsEarnOnly = paramBoolean;
  }

  public String getCardNumber()
  {
    return this.mCardNumber;
  }

  public String getPaymentProfileId()
  {
    return this.mPaymentProfileId;
  }

  public boolean isEarnOnly()
  {
    return this.mIsEarnOnly;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.event.ShowRewardInfoEvent
 * JD-Core Version:    0.6.2
 */