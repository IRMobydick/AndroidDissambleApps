package com.ubercab.client.core.network.events;

import com.ubercab.client.core.model.PaymentCheckBalanceResponse;
import retrofit.RetrofitError;
import retrofit.client.Response;

public final class PaymentCheckBalanceResponseEvent extends ResponseEvent<PaymentCheckBalanceResponse>
{
  public PaymentCheckBalanceResponseEvent(PaymentCheckBalanceResponse paramPaymentCheckBalanceResponse, Response paramResponse)
  {
    super(paramPaymentCheckBalanceResponse, paramResponse);
  }

  public PaymentCheckBalanceResponseEvent(RetrofitError paramRetrofitError)
  {
    super(paramRetrofitError);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.network.events.PaymentCheckBalanceResponseEvent
 * JD-Core Version:    0.6.2
 */