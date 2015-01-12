package retrofit;

import java.util.concurrent.Executor;

abstract class CallbackRunnable<T>
  implements Runnable
{
  private final Callback<T> callback;
  private final Executor callbackExecutor;
  private final ErrorHandler errorHandler;

  CallbackRunnable(Callback<T> paramCallback, Executor paramExecutor, ErrorHandler paramErrorHandler)
  {
    this.callback = paramCallback;
    this.callbackExecutor = paramExecutor;
    this.errorHandler = paramErrorHandler;
  }

  public abstract ResponseWrapper obtainResponse();

  public final void run()
  {
    Throwable localThrowable;
    try
    {
      final ResponseWrapper localResponseWrapper = obtainResponse();
      this.callbackExecutor.execute(new Runnable()
      {
        public void run()
        {
          CallbackRunnable.this.callback.success(localResponseWrapper.responseBody, localResponseWrapper.response);
        }
      });
      return;
    }
    catch (RetrofitError localRetrofitError1)
    {
      localThrowable = this.errorHandler.handleError(localRetrofitError1);
      if (localThrowable != localRetrofitError1);
    }
    for (final RetrofitError localRetrofitError2 = localRetrofitError1; ; localRetrofitError2 = RetrofitError.unexpectedError(localRetrofitError1.getUrl(), localThrowable))
    {
      this.callbackExecutor.execute(new Runnable()
      {
        public void run()
        {
          CallbackRunnable.this.callback.failure(localRetrofitError2);
        }
      });
      return;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     retrofit.CallbackRunnable
 * JD-Core Version:    0.6.2
 */