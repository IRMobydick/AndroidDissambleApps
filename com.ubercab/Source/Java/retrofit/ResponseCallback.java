package retrofit;

import retrofit.client.Response;

public abstract class ResponseCallback
  implements Callback<Response>
{
  public abstract void success(Response paramResponse);

  public void success(Response paramResponse1, Response paramResponse2)
  {
    success(paramResponse1);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     retrofit.ResponseCallback
 * JD-Core Version:    0.6.2
 */