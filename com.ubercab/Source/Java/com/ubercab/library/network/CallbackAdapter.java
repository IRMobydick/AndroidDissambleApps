package com.ubercab.library.network;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public abstract class CallbackAdapter<T>
  implements Callback<T>
{
  public void failure(RetrofitError paramRetrofitError)
  {
  }

  public void success(T paramT, Response paramResponse)
  {
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.network.CallbackAdapter
 * JD-Core Version:    0.6.2
 */