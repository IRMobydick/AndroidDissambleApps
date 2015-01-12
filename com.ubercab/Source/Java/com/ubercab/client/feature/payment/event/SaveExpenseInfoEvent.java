package com.ubercab.client.feature.payment.event;

public final class SaveExpenseInfoEvent
{
  private String mCode;
  private String mMemo;

  public SaveExpenseInfoEvent(String paramString1, String paramString2)
  {
    this.mCode = paramString1;
    this.mMemo = paramString2;
  }

  public String getCode()
  {
    return this.mCode;
  }

  public String getMemo()
  {
    return this.mMemo;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.event.SaveExpenseInfoEvent
 * JD-Core Version:    0.6.2
 */