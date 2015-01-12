package retrofit;

import retrofit.client.Response;

final class ResponseWrapper
{
  final Response response;
  final Object responseBody;

  ResponseWrapper(Response paramResponse, Object paramObject)
  {
    this.response = paramResponse;
    this.responseBody = paramObject;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     retrofit.ResponseWrapper
 * JD-Core Version:    0.6.2
 */