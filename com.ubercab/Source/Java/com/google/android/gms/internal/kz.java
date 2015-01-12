package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.HistoryApi;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.e.a;
import com.google.android.gms.fitness.result.DataReadResult;

public class kz
  implements HistoryApi
{
  public PendingResult<Status> deleteData(GoogleApiClient paramGoogleApiClient, final DataDeleteRequest paramDataDeleteRequest)
  {
    return paramGoogleApiClient.a(new kk.c()
    {
      protected void a(kk paramAnonymouskk)
        throws RemoteException
      {
        kk.b localb = new kk.b(this);
        String str = paramAnonymouskk.getContext().getPackageName();
        paramAnonymouskk.jb().a(paramDataDeleteRequest, localb, str);
      }
    });
  }

  public PendingResult<Status> insertData(GoogleApiClient paramGoogleApiClient, final DataSet paramDataSet)
  {
    return paramGoogleApiClient.a(new kk.c()
    {
      protected void a(kk paramAnonymouskk)
        throws RemoteException
      {
        kk.b localb = new kk.b(this);
        String str = paramAnonymouskk.getContext().getPackageName();
        paramAnonymouskk.jb().a(new e.a().b(paramDataSet).jj(), localb, str);
      }
    });
  }

  public PendingResult<DataReadResult> readData(GoogleApiClient paramGoogleApiClient, final DataReadRequest paramDataReadRequest)
  {
    return paramGoogleApiClient.a(new kk.a()
    {
      protected void a(kk paramAnonymouskk)
        throws RemoteException
      {
        kz.a locala = new kz.a(this, null);
        String str = paramAnonymouskk.getContext().getPackageName();
        paramAnonymouskk.jb().a(paramDataReadRequest, locala, str);
      }

      protected DataReadResult y(Status paramAnonymousStatus)
      {
        return DataReadResult.a(paramAnonymousStatus, paramDataReadRequest);
      }
    });
  }

  private static class a extends km.a
  {
    private final BaseImplementation.b<DataReadResult> De;
    private int TL = 0;
    private DataReadResult TM = null;

    private a(BaseImplementation.b<DataReadResult> paramb)
    {
      this.De = paramb;
    }

    public void a(DataReadResult paramDataReadResult)
    {
      try
      {
        Log.v("Fitness", "Received batch result");
        if (this.TM == null)
          this.TM = paramDataReadResult;
        while (true)
        {
          this.TL = (1 + this.TL);
          if (this.TL == this.TM.jH())
            this.De.b(this.TM);
          return;
          this.TM.b(paramDataReadResult);
        }
      }
      finally
      {
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.kz
 * JD-Core Version:    0.6.2
 */