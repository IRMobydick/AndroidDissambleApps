package com.ubercab.client.core.network;

import com.squareup.otto.Bus;
import com.ubercab.client.core.network.events.ResponseEvent;
import java.lang.reflect.Constructor;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public final class RetrofitCallbackBusAdapter<R, T extends ResponseEvent>
  implements Callback<R>
{
  private final Bus mBus;
  private final Class<T> mEventClass;

  public RetrofitCallbackBusAdapter(Bus paramBus, Class<T> paramClass)
  {
    this.mBus = paramBus;
    this.mEventClass = paramClass;
  }

  private Object createResponseEvent(R paramR, Response paramResponse)
  {
    try
    {
      Class localClass = paramR.getClass();
      if (!localClass.getSuperclass().equals(Object.class))
        localClass = localClass.getSuperclass();
      Object localObject = this.mEventClass.getConstructor(new Class[] { localClass, Response.class }).newInstance(new Object[] { paramR, paramResponse });
      return localObject;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }

  private Object createResponseEvent(RetrofitError paramRetrofitError)
  {
    try
    {
      Object localObject = this.mEventClass.getConstructor(new Class[] { RetrofitError.class }).newInstance(new Object[] { paramRetrofitError });
      return localObject;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }

  public void failure(RetrofitError paramRetrofitError)
  {
    this.mBus.post(createResponseEvent(paramRetrofitError));
  }

  public void success(R paramR, Response paramResponse)
  {
    this.mBus.post(createResponseEvent(paramR, paramResponse));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.network.RetrofitCallbackBusAdapter
 * JD-Core Version:    0.6.2
 */