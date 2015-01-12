package com.ubercab.client.core.network;

import com.squareup.otto.Bus;
import com.ubercab.client.core.network.events.CnResponseEvent;
import com.ubercab.library.network.dispatch.DispatchCallback;
import com.ubercab.library.network.dispatch.DispatchRequest;
import com.ubercab.library.network.dispatch.model.DispatchResponse;
import java.lang.reflect.Constructor;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class DispatchCallbackBusAdapter
  implements DispatchCallback
{
  private Bus mEventBus;
  private Class<? extends CnResponseEvent> mEventClass;

  public DispatchCallbackBusAdapter(Bus paramBus, Class<? extends CnResponseEvent> paramClass)
  {
    this.mEventBus = paramBus;
    this.mEventClass = paramClass;
  }

  private Object createResponseEvent(DispatchResponse paramDispatchResponse, Response paramResponse)
  {
    try
    {
      Class localClass = this.mEventClass;
      Class[] arrayOfClass = new Class[2];
      arrayOfClass[0] = paramDispatchResponse.getClass();
      arrayOfClass[1] = Response.class;
      Object localObject = localClass.getConstructor(arrayOfClass).newInstance(new Object[] { paramDispatchResponse, paramResponse });
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

  public void onDispatchError(DispatchRequest paramDispatchRequest, DispatchResponse paramDispatchResponse, Response paramResponse)
  {
    this.mEventBus.post(createResponseEvent(paramDispatchResponse, paramResponse));
  }

  public void onDispatchNetworkError(DispatchRequest paramDispatchRequest, RetrofitError paramRetrofitError)
  {
    this.mEventBus.post(createResponseEvent(paramRetrofitError));
  }

  public void onDispatchSuccess(DispatchRequest paramDispatchRequest, DispatchResponse paramDispatchResponse, Response paramResponse)
  {
    this.mEventBus.post(createResponseEvent(paramDispatchResponse, paramResponse));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.network.DispatchCallbackBusAdapter
 * JD-Core Version:    0.6.2
 */