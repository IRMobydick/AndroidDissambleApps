package retrofit;

import java.io.IOException;
import java.lang.reflect.Type;
import retrofit.client.Response;
import retrofit.converter.ConversionException;
import retrofit.converter.Converter;
import retrofit.mime.TypedInput;

public class RetrofitError extends RuntimeException
{
  private final Converter converter;
  private final boolean networkError;
  private final Response response;
  private final Type successType;
  private final String url;

  RetrofitError(String paramString1, String paramString2, Response paramResponse, Converter paramConverter, Type paramType, boolean paramBoolean, Throwable paramThrowable)
  {
    super(paramString1, paramThrowable);
    this.url = paramString2;
    this.response = paramResponse;
    this.converter = paramConverter;
    this.successType = paramType;
    this.networkError = paramBoolean;
  }

  public static RetrofitError conversionError(String paramString, Response paramResponse, Converter paramConverter, Type paramType, ConversionException paramConversionException)
  {
    return new RetrofitError(paramConversionException.getMessage(), paramString, paramResponse, paramConverter, paramType, false, paramConversionException);
  }

  public static RetrofitError httpError(String paramString, Response paramResponse, Converter paramConverter, Type paramType)
  {
    return new RetrofitError(paramResponse.getStatus() + " " + paramResponse.getReason(), paramString, paramResponse, paramConverter, paramType, false, null);
  }

  public static RetrofitError networkError(String paramString, IOException paramIOException)
  {
    return new RetrofitError(paramIOException.getMessage(), paramString, null, null, null, true, paramIOException);
  }

  public static RetrofitError unexpectedError(String paramString, Throwable paramThrowable)
  {
    return new RetrofitError(paramThrowable.getMessage(), paramString, null, null, null, false, paramThrowable);
  }

  public Object getBody()
  {
    return getBodyAs(this.successType);
  }

  public Object getBodyAs(Type paramType)
  {
    if (this.response == null);
    TypedInput localTypedInput;
    do
    {
      return null;
      localTypedInput = this.response.getBody();
    }
    while (localTypedInput == null);
    try
    {
      Object localObject = this.converter.fromBody(localTypedInput, paramType);
      return localObject;
    }
    catch (ConversionException localConversionException)
    {
      throw new RuntimeException(localConversionException);
    }
  }

  public Response getResponse()
  {
    return this.response;
  }

  public Type getSuccessType()
  {
    return this.successType;
  }

  public String getUrl()
  {
    return this.url;
  }

  public boolean isNetworkError()
  {
    return this.networkError;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     retrofit.RetrofitError
 * JD-Core Version:    0.6.2
 */