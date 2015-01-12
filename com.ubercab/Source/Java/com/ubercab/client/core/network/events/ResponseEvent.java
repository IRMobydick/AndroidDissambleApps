package com.ubercab.client.core.network.events;

import retrofit.RetrofitError;
import retrofit.client.Response;

public abstract class ResponseEvent<T>
{
  private T mModel;
  private RetrofitError mNetworkError;
  private Response mResponse;

  public ResponseEvent(T paramT, Response paramResponse)
  {
    this.mModel = paramT;
    this.mResponse = paramResponse;
  }

  public ResponseEvent(RetrofitError paramRetrofitError)
  {
    this.mNetworkError = paramRetrofitError;
  }

  public T getModel()
  {
    return this.mModel;
  }

  public Exception getNetworkError()
  {
    return this.mNetworkError;
  }

  public String getNetworkErrorMessage()
  {
    if (this.mNetworkError != null)
      return this.mNetworkError.getMessage();
    return "";
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
    return this.mNetworkError == null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.network.events.ResponseEvent
 * JD-Core Version:    0.6.2
 */