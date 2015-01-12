package com.ubercab.client.core.network;

import android.text.TextUtils;
import com.squareup.otto.Bus;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.client.core.model.PaymentCheckBalanceResponse;
import com.ubercab.client.core.model.PaymentDepositRequestResponse;
import com.ubercab.client.core.model.PaymentSendCodeResponse;
import com.ubercab.client.core.model.PaymentValidateCodeResponse;
import com.ubercab.client.core.network.events.PaymentCheckBalanceResponseEvent;
import com.ubercab.client.core.network.events.PaymentDepositRequestResponseEvent;
import com.ubercab.client.core.network.events.PaymentSendCodeResponseEvent;
import com.ubercab.client.core.network.events.PaymentValidateCodeResponseEvent;
import com.ubercab.common.collect.ImmutableMap;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class PaymentClient
{
  private static final String PARAM_CODE = "code";
  private final PaymentApi mApi;
  private final Bus mBus;
  private final SessionPreferences mSessionPreferences;

  public PaymentClient(Bus paramBus, SessionPreferences paramSessionPreferences, PaymentApi paramPaymentApi)
  {
    this.mBus = paramBus;
    this.mApi = paramPaymentApi;
    this.mSessionPreferences = paramSessionPreferences;
  }

  public void checkBalance(String paramString)
  {
    Callback local1 = new Callback()
    {
      public void failure(RetrofitError paramAnonymousRetrofitError)
      {
        PaymentClient.this.mBus.post(new PaymentCheckBalanceResponseEvent(paramAnonymousRetrofitError));
      }

      public void success(PaymentCheckBalanceResponse paramAnonymousPaymentCheckBalanceResponse, Response paramAnonymousResponse)
      {
        PaymentClient.this.mBus.post(new PaymentCheckBalanceResponseEvent(paramAnonymousPaymentCheckBalanceResponse, paramAnonymousResponse));
      }
    };
    this.mApi.checkBalance(paramString, local1);
  }

  public void depositRequest(String paramString1, int paramInt, String paramString2)
  {
    Callback local2 = new Callback()
    {
      public void failure(RetrofitError paramAnonymousRetrofitError)
      {
        PaymentClient.this.mBus.post(new PaymentDepositRequestResponseEvent(paramAnonymousRetrofitError));
      }

      public void success(PaymentDepositRequestResponse paramAnonymousPaymentDepositRequestResponse, Response paramAnonymousResponse)
      {
        PaymentClient.this.mBus.post(new PaymentDepositRequestResponseEvent(paramAnonymousPaymentDepositRequestResponse, paramAnonymousResponse));
      }
    };
    this.mApi.depositRequest(paramString1, Integer.toString(paramInt), paramString2, local2);
  }

  protected String ensureToken()
  {
    String str = this.mSessionPreferences.getToken();
    if (TextUtils.isEmpty(str))
      throw new IllegalStateException("Token is required");
    return str;
  }

  public void sendCode(String paramString)
  {
    Callback local3 = new Callback()
    {
      public void failure(RetrofitError paramAnonymousRetrofitError)
      {
        PaymentClient.this.mBus.post(new PaymentSendCodeResponseEvent(paramAnonymousRetrofitError));
      }

      public void success(PaymentSendCodeResponse paramAnonymousPaymentSendCodeResponse, Response paramAnonymousResponse)
      {
        PaymentClient.this.mBus.post(new PaymentSendCodeResponseEvent(paramAnonymousPaymentSendCodeResponse, paramAnonymousResponse));
      }
    };
    this.mApi.sendCode(paramString, local3);
  }

  public void validateCode(String paramString1, String paramString2)
  {
    Callback local4 = new Callback()
    {
      public void failure(RetrofitError paramAnonymousRetrofitError)
      {
        PaymentClient.this.mBus.post(new PaymentValidateCodeResponseEvent(paramAnonymousRetrofitError));
      }

      public void success(PaymentValidateCodeResponse paramAnonymousPaymentValidateCodeResponse, Response paramAnonymousResponse)
      {
        PaymentClient.this.mBus.post(new PaymentValidateCodeResponseEvent(paramAnonymousPaymentValidateCodeResponse, paramAnonymousResponse));
      }
    };
    ImmutableMap localImmutableMap = ImmutableMap.of("code", paramString2);
    this.mApi.validateCode(paramString1, localImmutableMap, local4);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.network.PaymentClient
 * JD-Core Version:    0.6.2
 */