package com.ubercab.library.network.dispatch;

import com.ubercab.library.network.dispatch.model.DispatchResponse;
import retrofit.RetrofitError;
import retrofit.client.Response;

public abstract class DispatchCallbackAdapter<T extends DispatchResponse>
  implements DispatchCallback<T>
{
  public void onDispatchError(DispatchRequest paramDispatchRequest, T paramT, Response paramResponse)
  {
  }

  public void onDispatchNetworkError(DispatchRequest paramDispatchRequest, RetrofitError paramRetrofitError)
  {
  }

  public void onDispatchSuccess(DispatchRequest paramDispatchRequest, T paramT, Response paramResponse)
  {
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.network.dispatch.DispatchCallbackAdapter
 * JD-Core Version:    0.6.2
 */