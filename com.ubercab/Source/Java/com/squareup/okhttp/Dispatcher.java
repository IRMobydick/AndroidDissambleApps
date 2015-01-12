package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.HttpEngine;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class Dispatcher
{
  private ExecutorService executorService;
  private int maxRequests = 64;
  private int maxRequestsPerHost = 5;
  private final Deque<Call.AsyncCall> readyCalls = new ArrayDeque();
  private final Deque<Call.AsyncCall> runningCalls = new ArrayDeque();

  public Dispatcher()
  {
  }

  public Dispatcher(ExecutorService paramExecutorService)
  {
    this.executorService = paramExecutorService;
  }

  private void promoteCalls()
  {
    if (this.runningCalls.size() >= this.maxRequests);
    do
    {
      Iterator localIterator;
      do
      {
        return;
        while (this.readyCalls.isEmpty());
        localIterator = this.readyCalls.iterator();
      }
      while (!localIterator.hasNext());
      Call.AsyncCall localAsyncCall = (Call.AsyncCall)localIterator.next();
      if (runningCallsForHost(localAsyncCall) < this.maxRequestsPerHost)
      {
        localIterator.remove();
        this.runningCalls.add(localAsyncCall);
        getExecutorService().execute(localAsyncCall);
      }
    }
    while (this.runningCalls.size() < this.maxRequests);
  }

  private int runningCallsForHost(Call.AsyncCall paramAsyncCall)
  {
    int i = 0;
    Iterator localIterator = this.runningCalls.iterator();
    while (localIterator.hasNext())
      if (((Call.AsyncCall)localIterator.next()).host().equals(paramAsyncCall.host()))
        i++;
    return i;
  }

  public void cancel(Object paramObject)
  {
    try
    {
      Iterator localIterator1 = this.readyCalls.iterator();
      while (localIterator1.hasNext())
        if (Util.equal(paramObject, ((Call.AsyncCall)localIterator1.next()).tag()))
          localIterator1.remove();
    }
    finally
    {
    }
    Iterator localIterator2 = this.runningCalls.iterator();
    while (localIterator2.hasNext())
    {
      Call.AsyncCall localAsyncCall = (Call.AsyncCall)localIterator2.next();
      if (Util.equal(paramObject, localAsyncCall.tag()))
      {
        localAsyncCall.get().canceled = true;
        HttpEngine localHttpEngine = localAsyncCall.get().engine;
        if (localHttpEngine != null)
          localHttpEngine.disconnect();
      }
    }
  }

  void enqueue(Call.AsyncCall paramAsyncCall)
  {
    try
    {
      if ((this.runningCalls.size() < this.maxRequests) && (runningCallsForHost(paramAsyncCall) < this.maxRequestsPerHost))
      {
        this.runningCalls.add(paramAsyncCall);
        getExecutorService().execute(paramAsyncCall);
      }
      while (true)
      {
        return;
        this.readyCalls.add(paramAsyncCall);
      }
    }
    finally
    {
    }
  }

  void finished(Call.AsyncCall paramAsyncCall)
  {
    try
    {
      if (!this.runningCalls.remove(paramAsyncCall))
        throw new AssertionError("AsyncCall wasn't running!");
    }
    finally
    {
    }
    promoteCalls();
  }

  public ExecutorService getExecutorService()
  {
    try
    {
      if (this.executorService == null)
        this.executorService = new ThreadPoolExecutor(0, 2147483647, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp Dispatcher", false));
      ExecutorService localExecutorService = this.executorService;
      return localExecutorService;
    }
    finally
    {
    }
  }

  public int getMaxRequests()
  {
    try
    {
      int i = this.maxRequests;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public int getMaxRequestsPerHost()
  {
    try
    {
      int i = this.maxRequestsPerHost;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setMaxRequests(int paramInt)
  {
    if (paramInt < 1)
      try
      {
        throw new IllegalArgumentException("max < 1: " + paramInt);
      }
      finally
      {
      }
    this.maxRequests = paramInt;
    promoteCalls();
  }

  public void setMaxRequestsPerHost(int paramInt)
  {
    if (paramInt < 1)
      try
      {
        throw new IllegalArgumentException("max < 1: " + paramInt);
      }
      finally
      {
      }
    this.maxRequestsPerHost = paramInt;
    promoteCalls();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.squareup.okhttp.Dispatcher
 * JD-Core Version:    0.6.2
 */