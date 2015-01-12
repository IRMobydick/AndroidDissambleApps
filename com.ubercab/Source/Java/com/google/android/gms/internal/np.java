package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api.c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.o;
import com.google.android.gms.plus.Account;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.Plus.a;
import com.google.android.gms.plus.internal.e;

public final class np
  implements Account
{
  private static e a(GoogleApiClient paramGoogleApiClient, Api.c<e> paramc)
  {
    boolean bool1 = true;
    boolean bool2;
    e locale;
    if (paramGoogleApiClient != null)
    {
      bool2 = bool1;
      o.b(bool2, "GoogleApiClient parameter is required.");
      o.a(paramGoogleApiClient.isConnected(), "GoogleApiClient must be connected.");
      locale = (e)paramGoogleApiClient.a(paramc);
      if (locale == null)
        break label56;
    }
    while (true)
    {
      o.a(bool1, "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
      return locale;
      bool2 = false;
      break;
      label56: bool1 = false;
    }
  }

  public void clearDefaultAccount(GoogleApiClient paramGoogleApiClient)
  {
    a(paramGoogleApiClient, Plus.CU).clearDefaultAccount();
  }

  public String getAccountName(GoogleApiClient paramGoogleApiClient)
  {
    return a(paramGoogleApiClient, Plus.CU).getAccountName();
  }

  public PendingResult<Status> revokeAccessAndDisconnect(GoogleApiClient paramGoogleApiClient)
  {
    // Byte code:
    //   0: aload_1
    //   1: new 58	com/google/android/gms/internal/np$1
    //   4: dup
    //   5: aload_0
    //   6: invokespecial 61	com/google/android/gms/internal/np$1:<init>	(Lcom/google/android/gms/internal/np;)V
    //   9: invokeinterface 64 2 0
    //   14: areturn
  }

  private static abstract class a extends Plus.a<Status>
  {
    public Status d(Status paramStatus)
    {
      return paramStatus;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.np
 * JD-Core Version:    0.6.2
 */