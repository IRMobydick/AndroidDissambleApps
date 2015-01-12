package com.ubercab.client.core.network.events;

import com.ubercab.client.core.model.PaymentValidateCodeResponse;
import retrofit.RetrofitError;
import retrofit.client.Response;

public final class PaymentValidateCodeResponseEvent extends ResponseEvent<PaymentValidateCodeResponse>
{
  public PaymentValidateCodeResponseEvent(PaymentValidateCodeResponse paramPaymentValidateCodeResponse, Response paramResponse)
  {
    super(paramPaymentValidateCodeResponse, paramResponse);
  }

  public PaymentValidateCodeResponseEvent(RetrofitError paramRetrofitError)
  {
    super(paramRetrofitError);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.network.events.PaymentValidateCodeResponseEvent
 * JD-Core Version:    0.6.2
 */