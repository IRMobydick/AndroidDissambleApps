package com.ubercab.client.feature.receipt.event;

public final class ReceiptRateEvent
{
  private String mTripId;

  public ReceiptRateEvent(String paramString)
  {
    this.mTripId = paramString;
  }

  public String getTripId()
  {
    return this.mTripId;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.receipt.event.ReceiptRateEvent
 * JD-Core Version:    0.6.2
 */