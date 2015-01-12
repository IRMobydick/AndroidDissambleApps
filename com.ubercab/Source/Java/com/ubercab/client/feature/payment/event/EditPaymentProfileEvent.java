package com.ubercab.client.feature.payment.event;

public final class EditPaymentProfileEvent
{
  private String mPaymentProfileId;

  public EditPaymentProfileEvent(String paramString)
  {
    this.mPaymentProfileId = paramString;
  }

  public String getPaymentProfileId()
  {
    return this.mPaymentProfileId;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.event.EditPaymentProfileEvent
 * JD-Core Version:    0.6.2
 */