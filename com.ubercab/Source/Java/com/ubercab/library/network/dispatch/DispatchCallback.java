package com.ubercab.library.network.dispatch;

import com.ubercab.library.network.dispatch.model.DispatchResponse;
import retrofit.RetrofitError;
import retrofit.client.Response;

public abstract interface DispatchCallback<T extends DispatchResponse>
{
  public abstract void onDispatchError(DispatchRequest paramDispatchRequest, T paramT, Response paramResponse);

  public abstract void onDispatchNetworkError(DispatchRequest paramDispatchRequest, RetrofitError paramRetrofitError);

  public abstract void onDispatchSuccess(DispatchRequest paramDispatchRequest, T paramT, Response paramResponse);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.network.dispatch.DispatchCallback
 * JD-Core Version:    0.6.2
 */