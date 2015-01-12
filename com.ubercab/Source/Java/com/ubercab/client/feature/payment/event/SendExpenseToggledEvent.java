package com.ubercab.client.feature.payment.event;

public final class SendExpenseToggledEvent
{
  private final boolean mIsSendExpense;

  public SendExpenseToggledEvent(boolean paramBoolean)
  {
    this.mIsSendExpense = paramBoolean;
  }

  public boolean isSendExpense()
  {
    return this.mIsSendExpense;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.event.SendExpenseToggledEvent
 * JD-Core Version:    0.6.2
 */