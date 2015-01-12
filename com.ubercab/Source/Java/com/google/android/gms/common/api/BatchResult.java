package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.o;
import java.util.concurrent.TimeUnit;

public final class BatchResult
  implements Result
{
  private final Status CM;
  private final PendingResult<?>[] IE;

  BatchResult(Status paramStatus, PendingResult<?>[] paramArrayOfPendingResult)
  {
    this.CM = paramStatus;
    this.IE = paramArrayOfPendingResult;
  }

  public Status getStatus()
  {
    return this.CM;
  }

  public <R extends Result> R take(BatchResultToken<R> paramBatchResultToken)
  {
    if (paramBatchResultToken.mId < this.IE.length);
    for (boolean bool = true; ; bool = false)
    {
      o.b(bool, "The result token does not belong to this batch");
      return this.IE[paramBatchResultToken.mId].await(0L, TimeUnit.MILLISECONDS);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.BatchResult
 * JD-Core Version:    0.6.2
 */