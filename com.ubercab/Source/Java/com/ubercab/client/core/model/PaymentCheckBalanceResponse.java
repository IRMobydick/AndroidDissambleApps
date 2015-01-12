package com.ubercab.client.core.model;

public final class PaymentCheckBalanceResponse
{
  Double amount;
  String currencyCode;
  String displayAmount;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    PaymentCheckBalanceResponse localPaymentCheckBalanceResponse;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localPaymentCheckBalanceResponse = (PaymentCheckBalanceResponse)paramObject;
      if (this.amount != null)
      {
        if (this.amount.equals(localPaymentCheckBalanceResponse.amount));
      }
      else
        while (localPaymentCheckBalanceResponse.amount != null)
          return false;
      if (this.currencyCode != null)
      {
        if (this.currencyCode.equals(localPaymentCheckBalanceResponse.currencyCode));
      }
      else
        while (localPaymentCheckBalanceResponse.currencyCode != null)
          return false;
      if (this.displayAmount == null)
        break;
    }
    while (this.displayAmount.equals(localPaymentCheckBalanceResponse.displayAmount));
    while (true)
    {
      return false;
      if (localPaymentCheckBalanceResponse.displayAmount == null)
        break;
    }
  }

  public Double getAmount()
  {
    return this.amount;
  }

  public String getCurrencyCode()
  {
    return this.currencyCode;
  }

  public String getDisplayAmount()
  {
    return this.displayAmount;
  }

  public int hashCode()
  {
    int i;
    int j;
    if (this.amount != null)
    {
      i = this.amount.hashCode();
      j = i * 31;
      if (this.displayAmount == null)
        break label77;
    }
    label77: for (int k = this.displayAmount.hashCode(); ; k = 0)
    {
      int m = 31 * (j + k);
      String str = this.currencyCode;
      int n = 0;
      if (str != null)
        n = this.currencyCode.hashCode();
      return m + n;
      i = 0;
      break;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.PaymentCheckBalanceResponse
 * JD-Core Version:    0.6.2
 */