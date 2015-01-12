package com.ubercab.client.core.network.events;

import com.ubercab.client.core.model.PaymentSendCodeResponse;
import retrofit.RetrofitError;
import retrofit.client.Response;

public final class PaymentSendCodeResponseEvent extends ResponseEvent<PaymentSendCodeResponse>
{
  public PaymentSendCodeResponseEvent(PaymentSendCodeResponse paramPaymentSendCodeResponse, Response paramResponse)
  {
    super(paramPaymentSendCodeResponse, paramResponse);
  }

  public PaymentSendCodeResponseEvent(RetrofitError paramRetrofitError)
  {
    super(paramRetrofitError);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.network.events.PaymentSendCodeResponseEvent
 * JD-Core Version:    0.6.2
 */