package retrofit;

import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.subscriptions.Subscriptions;

final class RxSupport
{
  private final ErrorHandler errorHandler;
  private final Executor executor;
  private final RequestInterceptor requestInterceptor;

  RxSupport(Executor paramExecutor, ErrorHandler paramErrorHandler, RequestInterceptor paramRequestInterceptor)
  {
    this.executor = paramExecutor;
    this.errorHandler = paramErrorHandler;
    this.requestInterceptor = paramRequestInterceptor;
  }

  private Runnable getRunnable(final Subscriber<? super Object> paramSubscriber, final Invoker paramInvoker, final RequestInterceptorTape paramRequestInterceptorTape)
  {
    return new Runnable()
    {
      public void run()
      {
        try
        {
          if (paramSubscriber.isUnsubscribed())
            return;
          ResponseWrapper localResponseWrapper = paramInvoker.invoke(paramRequestInterceptorTape);
          paramSubscriber.onNext(localResponseWrapper.responseBody);
          paramSubscriber.onCompleted();
          return;
        }
        catch (RetrofitError localRetrofitError)
        {
          paramSubscriber.onError(RxSupport.this.errorHandler.handleError(localRetrofitError));
        }
      }
    };
  }

  Observable createRequestObservable(final Invoker paramInvoker)
  {
    return Observable.create(new Observable.OnSubscribe()
    {
      public void call(Subscriber<? super Object> paramAnonymousSubscriber)
      {
        RequestInterceptorTape localRequestInterceptorTape = new RequestInterceptorTape();
        RxSupport.this.requestInterceptor.intercept(localRequestInterceptorTape);
        FutureTask localFutureTask = new FutureTask(RxSupport.this.getRunnable(paramAnonymousSubscriber, paramInvoker, localRequestInterceptorTape), null);
        paramAnonymousSubscriber.add(Subscriptions.from(localFutureTask));
        RxSupport.this.executor.execute(localFutureTask);
      }
    });
  }

  static abstract interface Invoker
  {
    public abstract ResponseWrapper invoke(RequestInterceptor paramRequestInterceptor);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     retrofit.RxSupport
 * JD-Core Version:    0.6.2
 */