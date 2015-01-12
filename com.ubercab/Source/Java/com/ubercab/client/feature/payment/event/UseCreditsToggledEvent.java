package com.ubercab.client.feature.payment.event;

public final class UseCreditsToggledEvent
{
  private boolean mUseCredits;

  public UseCreditsToggledEvent(boolean paramBoolean)
  {
    this.mUseCredits = paramBoolean;
  }

  public boolean isUsingCredits()
  {
    return this.mUseCredits;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.event.UseCreditsToggledEvent
 * JD-Core Version:    0.6.2
 */