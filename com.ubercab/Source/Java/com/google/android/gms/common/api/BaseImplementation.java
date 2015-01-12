package com.google.android.gms.common.api;

import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.j;
import com.google.android.gms.common.internal.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class BaseImplementation
{
  static void a(Result paramResult)
  {
    if ((paramResult instanceof Releasable));
    try
    {
      ((Releasable)paramResult).release();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      Log.w("GoogleApi", "Unable to release " + paramResult, localRuntimeException);
    }
  }

  public static abstract class AbstractPendingResult<R extends Result>
    implements BaseImplementation.b<R>, PendingResult<R>
  {
    private final Object Ir = new Object();
    private final ArrayList<PendingResult.a> Is = new ArrayList();
    private ResultCallback<R> It;
    private volatile R Iu;
    private volatile boolean Iv;
    private boolean Iw;
    private boolean Ix;
    private j Iy;
    protected BaseImplementation.CallbackHandler<R> mHandler;
    private final CountDownLatch mg = new CountDownLatch(1);

    AbstractPendingResult()
    {
    }

    public AbstractPendingResult(Looper paramLooper)
    {
      this.mHandler = new BaseImplementation.CallbackHandler(paramLooper);
    }

    public AbstractPendingResult(BaseImplementation.CallbackHandler<R> paramCallbackHandler)
    {
      this.mHandler = paramCallbackHandler;
    }

    private void c(R paramR)
    {
      this.Iu = paramR;
      this.Iy = null;
      this.mg.countDown();
      Status localStatus = this.Iu.getStatus();
      if (this.It != null)
      {
        this.mHandler.removeTimeoutMessages();
        if (!this.Iw)
          this.mHandler.sendResultCallback(this.It, gf());
      }
      Iterator localIterator = this.Is.iterator();
      while (localIterator.hasNext())
        ((PendingResult.a)localIterator.next()).n(localStatus);
      this.Is.clear();
    }

    private R gf()
    {
      while (true)
      {
        synchronized (this.Ir)
        {
          if (!this.Iv)
          {
            bool = true;
            o.a(bool, "Result has already been consumed.");
            o.a(isReady(), "Result is not ready.");
            Result localResult = this.Iu;
            gg();
            return localResult;
          }
        }
        boolean bool = false;
      }
    }

    private void gh()
    {
      synchronized (this.Ir)
      {
        if (!isReady())
        {
          b(c(Status.Jw));
          this.Ix = true;
        }
        return;
      }
    }

    private void gi()
    {
      synchronized (this.Ir)
      {
        if (!isReady())
        {
          b(c(Status.Jy));
          this.Ix = true;
        }
        return;
      }
    }

    protected void a(BaseImplementation.CallbackHandler<R> paramCallbackHandler)
    {
      this.mHandler = paramCallbackHandler;
    }

    public final void a(PendingResult.a parama)
    {
      if (!this.Iv);
      for (boolean bool = true; ; bool = false)
      {
        o.a(bool, "Result has already been consumed.");
        synchronized (this.Ir)
        {
          if (isReady())
          {
            parama.n(this.Iu.getStatus());
            return;
          }
          this.Is.add(parama);
        }
      }
    }

    protected final void a(j paramj)
    {
      synchronized (this.Ir)
      {
        this.Iy = paramj;
        return;
      }
    }

    public final R await()
    {
      boolean bool1 = true;
      boolean bool2;
      if (Looper.myLooper() != Looper.getMainLooper())
        bool2 = bool1;
      while (true)
      {
        o.a(bool2, "await must not be called on the UI thread");
        if (!this.Iv)
          o.a(bool1, "Result has already been consumed");
        try
        {
          this.mg.await();
          o.a(isReady(), "Result is not ready.");
          return gf();
          bool2 = false;
          continue;
          bool1 = false;
        }
        catch (InterruptedException localInterruptedException)
        {
          while (true)
            gh();
        }
      }
    }

    public final R await(long paramLong, TimeUnit paramTimeUnit)
    {
      boolean bool1 = true;
      boolean bool2;
      if ((paramLong <= 0L) || (Looper.myLooper() != Looper.getMainLooper()))
        bool2 = bool1;
      while (true)
      {
        o.a(bool2, "await must not be called on the UI thread when time is greater than zero.");
        if (!this.Iv)
          o.a(bool1, "Result has already been consumed.");
        try
        {
          if (!this.mg.await(paramLong, paramTimeUnit))
            gi();
          o.a(isReady(), "Result is not ready.");
          return gf();
          bool2 = false;
          continue;
          bool1 = false;
        }
        catch (InterruptedException localInterruptedException)
        {
          while (true)
            gh();
        }
      }
    }

    public final void b(R paramR)
    {
      boolean bool1 = true;
      while (true)
      {
        synchronized (this.Ir)
        {
          if ((this.Ix) || (this.Iw))
          {
            BaseImplementation.a(paramR);
            return;
          }
          if (!isReady())
          {
            bool2 = bool1;
            o.a(bool2, "Results have already been set");
            if (this.Iv)
              break label81;
            o.a(bool1, "Result has already been consumed");
            c(paramR);
            return;
          }
        }
        boolean bool2 = false;
        continue;
        label81: bool1 = false;
      }
    }

    protected abstract R c(Status paramStatus);

    public void cancel()
    {
      synchronized (this.Ir)
      {
        if ((this.Iw) || (this.Iv))
          return;
        j localj = this.Iy;
        if (localj == null);
      }
      try
      {
        this.Iy.cancel();
        label42: BaseImplementation.a(this.Iu);
        this.It = null;
        this.Iw = true;
        c(c(Status.Jz));
        return;
        localObject2 = finally;
        throw localObject2;
      }
      catch (RemoteException localRemoteException)
      {
        break label42;
      }
    }

    protected void gg()
    {
      this.Iv = true;
      this.Iu = null;
      this.It = null;
    }

    public boolean isCanceled()
    {
      synchronized (this.Ir)
      {
        boolean bool = this.Iw;
        return bool;
      }
    }

    public final boolean isReady()
    {
      return this.mg.getCount() == 0L;
    }

    public final void setResultCallback(ResultCallback<R> paramResultCallback)
    {
      if (!this.Iv);
      for (boolean bool = true; ; bool = false)
      {
        o.a(bool, "Result has already been consumed.");
        while (true)
        {
          synchronized (this.Ir)
          {
            if (isCanceled())
              return;
            if (isReady())
            {
              this.mHandler.sendResultCallback(paramResultCallback, gf());
              return;
            }
          }
          this.It = paramResultCallback;
        }
      }
    }

    public final void setResultCallback(ResultCallback<R> paramResultCallback, long paramLong, TimeUnit paramTimeUnit)
    {
      boolean bool1 = true;
      boolean bool2;
      if (!this.Iv)
      {
        bool2 = bool1;
        o.a(bool2, "Result has already been consumed.");
        if (this.mHandler == null)
          break label114;
      }
      while (true)
      {
        o.a(bool1, "CallbackHandler has not been set before calling setResultCallback.");
        while (true)
        {
          synchronized (this.Ir)
          {
            if (isCanceled())
              return;
            if (isReady())
            {
              this.mHandler.sendResultCallback(paramResultCallback, gf());
              return;
            }
          }
          this.It = paramResultCallback;
          this.mHandler.sendTimeoutResultCallback(this, paramTimeUnit.toMillis(paramLong));
        }
        bool2 = false;
        break;
        label114: bool1 = false;
      }
    }
  }

  public static class CallbackHandler<R extends Result> extends Handler
  {
    public static final int CALLBACK_ON_COMPLETE = 1;
    public static final int CALLBACK_ON_TIMEOUT = 2;

    public CallbackHandler()
    {
      this(Looper.getMainLooper());
    }

    public CallbackHandler(Looper paramLooper)
    {
      super();
    }

    protected void deliverResultCallback(ResultCallback<R> paramResultCallback, R paramR)
    {
      try
      {
        paramResultCallback.onResult(paramR);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        BaseImplementation.a(paramR);
        throw localRuntimeException;
      }
    }

    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default:
        Log.wtf("GoogleApi", "Don't know how to handle this message.");
        return;
      case 1:
        Pair localPair = (Pair)paramMessage.obj;
        deliverResultCallback((ResultCallback)localPair.first, (Result)localPair.second);
        return;
      case 2:
      }
      BaseImplementation.AbstractPendingResult.a((BaseImplementation.AbstractPendingResult)paramMessage.obj);
    }

    public void removeTimeoutMessages()
    {
      removeMessages(2);
    }

    public void sendResultCallback(ResultCallback<R> paramResultCallback, R paramR)
    {
      sendMessage(obtainMessage(1, new Pair(paramResultCallback, paramR)));
    }

    public void sendTimeoutResultCallback(BaseImplementation.AbstractPendingResult<R> paramAbstractPendingResult, long paramLong)
    {
      sendMessageDelayed(obtainMessage(2, paramAbstractPendingResult), paramLong);
    }
  }

  public static abstract class a<R extends Result, A extends Api.a> extends BaseImplementation.AbstractPendingResult<R>
    implements b.c<A>
  {
    private final Api.c<A> Ip;
    private b.a Iz;

    protected a(Api.c<A> paramc)
    {
      this.Ip = ((Api.c)o.i(paramc));
    }

    private void a(RemoteException paramRemoteException)
    {
      m(new Status(8, paramRemoteException.getLocalizedMessage(), null));
    }

    protected abstract void a(A paramA)
      throws RemoteException;

    public void a(b.a parama)
    {
      this.Iz = parama;
    }

    public final void b(A paramA)
      throws DeadObjectException
    {
      if (this.mHandler == null)
        a(new BaseImplementation.CallbackHandler(paramA.getLooper()));
      try
      {
        a(paramA);
        return;
      }
      catch (DeadObjectException localDeadObjectException)
      {
        a(localDeadObjectException);
        throw localDeadObjectException;
      }
      catch (RemoteException localRemoteException)
      {
        a(localRemoteException);
      }
    }

    public final Api.c<A> ge()
    {
      return this.Ip;
    }

    protected void gg()
    {
      super.gg();
      if (this.Iz != null)
      {
        this.Iz.b(this);
        this.Iz = null;
      }
    }

    public int gj()
    {
      return 0;
    }

    public final void m(Status paramStatus)
    {
      if (!paramStatus.isSuccess());
      for (boolean bool = true; ; bool = false)
      {
        o.b(bool, "Failed result must not be success");
        b(c(paramStatus));
        return;
      }
    }
  }

  public static abstract interface b<R>
  {
    public abstract void b(R paramR);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.BaseImplementation
 * JD-Core Version:    0.6.2
 */