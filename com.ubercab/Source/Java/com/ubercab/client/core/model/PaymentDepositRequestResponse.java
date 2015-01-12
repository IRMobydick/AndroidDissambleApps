package com.ubercab.client.core.model;

public final class PaymentDepositRequestResponse
{
  String data;
  String url;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    PaymentDepositRequestResponse localPaymentDepositRequestResponse;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localPaymentDepositRequestResponse = (PaymentDepositRequestResponse)paramObject;
      if (this.data != null)
      {
        if (this.data.equals(localPaymentDepositRequestResponse.data));
      }
      else
        while (localPaymentDepositRequestResponse.data != null)
          return false;
      if (this.url == null)
        break;
    }
    while (this.url.equals(localPaymentDepositRequestResponse.url));
    while (true)
    {
      return false;
      if (localPaymentDepositRequestResponse.url == null)
        break;
    }
  }

  public String getData()
  {
    return this.data;
  }

  public String getUrl()
  {
    return this.url;
  }

  public int hashCode()
  {
    if (this.data != null);
    for (int i = this.data.hashCode(); ; i = 0)
    {
      int j = i * 31;
      String str = this.url;
      int k = 0;
      if (str != null)
        k = this.url.hashCode();
      return j + k;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.PaymentDepositRequestResponse
 * JD-Core Version:    0.6.2
 */