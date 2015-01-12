package com.google.android.gms.internal;

import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.Plus.a;
import com.google.android.gms.plus.internal.e;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;

public final class ns
  implements Moments
{
  public PendingResult<Moments.LoadMomentsResult> load(GoogleApiClient paramGoogleApiClient)
  {
    // Byte code:
    //   0: aload_1
    //   1: new 14	com/google/android/gms/internal/ns$1
    //   4: dup
    //   5: aload_0
    //   6: invokespecial 17	com/google/android/gms/internal/ns$1:<init>	(Lcom/google/android/gms/internal/ns;)V
    //   9: invokeinterface 23 2 0
    //   14: areturn
  }

  public PendingResult<Moments.LoadMomentsResult> load(GoogleApiClient paramGoogleApiClient, final int paramInt, final String paramString1, final Uri paramUri, final String paramString2, final String paramString3)
  {
    return paramGoogleApiClient.a(new a(paramInt)
    {
      protected void a(e paramAnonymouse)
      {
        paramAnonymouse.a(this, paramInt, paramString1, paramUri, paramString2, paramString3);
      }
    });
  }

  public PendingResult<Status> remove(GoogleApiClient paramGoogleApiClient, final String paramString)
  {
    return paramGoogleApiClient.b(new b(paramString)
    {
      protected void a(e paramAnonymouse)
      {
        paramAnonymouse.removeMoment(paramString);
        b(Status.Jv);
      }
    });
  }

  public PendingResult<Status> write(GoogleApiClient paramGoogleApiClient, final Moment paramMoment)
  {
    return paramGoogleApiClient.b(new c(paramMoment)
    {
      protected void a(e paramAnonymouse)
      {
        paramAnonymouse.a(this, paramMoment);
      }
    });
  }

  private static abstract class a extends Plus.a<Moments.LoadMomentsResult>
  {
    public Moments.LoadMomentsResult aC(final Status paramStatus)
    {
      return new Moments.LoadMomentsResult()
      {
        public MomentBuffer getMomentBuffer()
        {
          return null;
        }

        public String getNextPageToken()
        {
          return null;
        }

        public Status getStatus()
        {
          return paramStatus;
        }

        public String getUpdated()
        {
          return null;
        }

        public void release()
        {
        }
      };
    }
  }

  private static abstract class b extends Plus.a<Status>
  {
    public Status d(Status paramStatus)
    {
      return paramStatus;
    }
  }

  private static abstract class c extends Plus.a<Status>
  {
    public Status d(Status paramStatus)
    {
      return paramStatus;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ns
 * JD-Core Version:    0.6.2
 */