package com.google.android.gms.common.api;

import android.os.Looper;
import java.util.ArrayList;
import java.util.List;

public final class Batch extends BaseImplementation.AbstractPendingResult<BatchResult>
{
  private int IA;
  private boolean IB;
  private boolean IC;
  private final PendingResult<?>[] IE;
  private final Object mw = new Object();

  private Batch(List<PendingResult<?>> paramList, Looper paramLooper)
  {
    super(new BaseImplementation.CallbackHandler(paramLooper));
    this.IA = paramList.size();
    this.IE = new PendingResult[this.IA];
    for (int i = 0; i < paramList.size(); i++)
    {
      PendingResult localPendingResult = (PendingResult)paramList.get(i);
      this.IE[i] = localPendingResult;
      localPendingResult.a(new PendingResult.a()
      {
        public void n(Status paramAnonymousStatus)
        {
          while (true)
          {
            synchronized (Batch.a(Batch.this))
            {
              if (Batch.this.isCanceled())
                return;
              if (paramAnonymousStatus.isCanceled())
              {
                Batch.a(Batch.this, true);
                Batch.b(Batch.this);
                if (Batch.c(Batch.this) == 0)
                {
                  if (!Batch.d(Batch.this))
                    break;
                  Batch.e(Batch.this);
                }
                return;
              }
            }
            if (!paramAnonymousStatus.isSuccess())
              Batch.b(Batch.this, true);
          }
          if (Batch.f(Batch.this));
          for (Status localStatus = new Status(13); ; localStatus = Status.Jv)
          {
            Batch.this.b(new BatchResult(localStatus, Batch.g(Batch.this)));
            break;
          }
        }
      });
    }
  }

  public void cancel()
  {
    super.cancel();
    PendingResult[] arrayOfPendingResult = this.IE;
    int i = arrayOfPendingResult.length;
    for (int j = 0; j < i; j++)
      arrayOfPendingResult[j].cancel();
  }

  public BatchResult createFailedResult(Status paramStatus)
  {
    return new BatchResult(paramStatus, this.IE);
  }

  public static final class Builder
  {
    private List<PendingResult<?>> IG = new ArrayList();
    private Looper IH;

    public Builder(GoogleApiClient paramGoogleApiClient)
    {
      this.IH = paramGoogleApiClient.getLooper();
    }

    public <R extends Result> BatchResultToken<R> add(PendingResult<R> paramPendingResult)
    {
      BatchResultToken localBatchResultToken = new BatchResultToken(this.IG.size());
      this.IG.add(paramPendingResult);
      return localBatchResultToken;
    }

    public Batch build()
    {
      return new Batch(this.IG, this.IH, null);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.Batch
 * JD-Core Version:    0.6.2
 */