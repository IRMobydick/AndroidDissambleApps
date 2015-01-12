package com.google.android.gms.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.a;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import java.util.concurrent.TimeUnit;

class ku<T extends Result>
  implements PendingResult<T>
{
  private final T Tx;

  ku(T paramT)
  {
    this.Tx = paramT;
  }

  public void a(PendingResult.a parama)
  {
    parama.n(this.Tx.getStatus());
  }

  public T await()
  {
    return this.Tx;
  }

  public T await(long paramLong, TimeUnit paramTimeUnit)
  {
    return this.Tx;
  }

  public void cancel()
  {
  }

  public boolean isCanceled()
  {
    return false;
  }

  public void setResultCallback(ResultCallback<T> paramResultCallback)
  {
    paramResultCallback.onResult(this.Tx);
  }

  public void setResultCallback(ResultCallback<T> paramResultCallback, long paramLong, TimeUnit paramTimeUnit)
  {
    paramResultCallback.onResult(this.Tx);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ku
 * JD-Core Version:    0.6.2
 */