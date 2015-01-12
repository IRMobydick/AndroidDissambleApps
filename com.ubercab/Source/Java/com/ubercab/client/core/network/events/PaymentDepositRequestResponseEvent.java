package com.ubercab.client.core.network.events;

import com.ubercab.client.core.model.PaymentDepositRequestResponse;
import retrofit.RetrofitError;
import retrofit.client.Response;

public final class PaymentDepositRequestResponseEvent extends ResponseEvent<PaymentDepositRequestResponse>
{
  public PaymentDepositRequestResponseEvent(PaymentDepositRequestResponse paramPaymentDepositRequestResponse, Response paramResponse)
  {
    super(paramPaymentDepositRequestResponse, paramResponse);
  }

  public PaymentDepositRequestResponseEvent(RetrofitError paramRetrofitError)
  {
    super(paramRetrofitError);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.network.events.PaymentDepositRequestResponseEvent
 * JD-Core Version:    0.6.2
 */