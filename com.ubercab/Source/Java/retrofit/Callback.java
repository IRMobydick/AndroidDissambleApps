package retrofit;

import retrofit.client.Response;

public abstract interface Callback<T>
{
  public abstract void failure(RetrofitError paramRetrofitError);

  public abstract void success(T paramT, Response paramResponse);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     retrofit.Callback
 * JD-Core Version:    0.6.2
 */