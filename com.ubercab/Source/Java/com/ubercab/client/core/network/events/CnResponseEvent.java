package com.ubercab.client.core.network.events;

import android.content.Context;
import android.text.TextUtils;
import com.ubercab.library.network.dispatch.model.DispatchResponse;
import retrofit.RetrofitError;
import retrofit.client.Response;

public abstract class CnResponseEvent<T extends DispatchResponse>
{
  private RetrofitError mNetworkError;
  private Response mResponse;
  private T model;

  public CnResponseEvent(T paramT, Response paramResponse)
  {
    this.model = paramT;
    this.mResponse = paramResponse;
  }

  public CnResponseEvent(RetrofitError paramRetrofitError)
  {
    this.mNetworkError = paramRetrofitError;
  }

  public String getErrorMessage()
  {
    if (this.mNetworkError != null)
      return this.mNetworkError.getMessage();
    if ((this.model != null) && (this.model.getMessageType().equals("Error")))
      return this.model.getDescription();
    return null;
  }

  public String getErrorMessage(Context paramContext)
  {
    String str = getErrorMessage();
    if (!TextUtils.isEmpty(str))
      return str;
    return paramContext.getString(2131559319);
  }

  public T getModel()
  {
    return this.model;
  }

  public Exception getNetworkError()
  {
    return this.mNetworkError;
  }

  public Response getResponse()
  {
    return this.mResponse;
  }

  public int getStatusCode()
  {
    if ((this.mNetworkError != null) && (this.mNetworkError.getResponse() != null))
      return this.mNetworkError.getResponse().getStatus();
    if (this.mResponse != null)
      return this.mResponse.getStatus();
    return 0;
  }

  public boolean hasNetworkError()
  {
    return this.mNetworkError != null;
  }

  public boolean isSuccess()
  {
    return (this.mNetworkError == null) && (this.model.getMessageType().equals("OK"));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.network.events.CnResponseEvent
 * JD-Core Version:    0.6.2
 */