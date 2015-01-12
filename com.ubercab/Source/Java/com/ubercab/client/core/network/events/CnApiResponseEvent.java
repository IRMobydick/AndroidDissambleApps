package com.ubercab.client.core.network.events;

import android.text.TextUtils;
import com.ubercab.client.core.model.ApiResponse;
import com.ubercab.client.core.model.Ping;
import retrofit.RetrofitError;
import retrofit.client.Response;

public abstract class CnApiResponseEvent extends CnResponseEvent<Ping>
{
  public CnApiResponseEvent(Ping paramPing, Response paramResponse)
  {
    super(paramPing, paramResponse);
  }

  public CnApiResponseEvent(RetrofitError paramRetrofitError)
  {
    super(paramRetrofitError);
  }

  public String getErrorMessage()
  {
    String str = ((Ping)getModel()).getApiResponse().getErrorMessage();
    if (!TextUtils.isEmpty(str))
      return str;
    return super.getErrorMessage();
  }

  public boolean isApiSuccess()
  {
    return (getModel() != null) && (((Ping)getModel()).getApiResponse() != null) && (((Ping)getModel()).getApiResponse().isSuccess());
  }

  public boolean isCnSuccess()
  {
    return super.isSuccess();
  }

  public boolean isSuccess()
  {
    return (isCnSuccess()) && (isApiSuccess());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.network.events.CnApiResponseEvent
 * JD-Core Version:    0.6.2
 */