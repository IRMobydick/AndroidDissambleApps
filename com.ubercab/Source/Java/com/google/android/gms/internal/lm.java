package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.e.e;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.identity.intents.UserAddressRequest;

public class lm extends e<lo>
{
  private final String Dd;
  private a adM;
  private final int mTheme;
  private Activity nr;

  public lm(Activity paramActivity, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString, int paramInt)
  {
    super(paramActivity, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, new String[0]);
    this.Dd = paramString;
    this.nr = paramActivity;
    this.mTheme = paramInt;
  }

  protected void a(l paraml, e.e parame)
    throws RemoteException
  {
    paraml.d(parame, 6171000, getContext().getPackageName());
  }

  public void a(UserAddressRequest paramUserAddressRequest, int paramInt)
  {
    lT();
    this.adM = new a(paramInt, this.nr);
    try
    {
      Bundle localBundle1 = new Bundle();
      localBundle1.putString("com.google.android.gms.identity.intents.EXTRA_CALLING_PACKAGE_NAME", getContext().getPackageName());
      if (!TextUtils.isEmpty(this.Dd))
        localBundle1.putParcelable("com.google.android.gms.identity.intents.EXTRA_ACCOUNT", new Account(this.Dd, "com.google"));
      localBundle1.putInt("com.google.android.gms.identity.intents.EXTRA_THEME", this.mTheme);
      lS().a(this.adM, paramUserAddressRequest, localBundle1);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("AddressClientImpl", "Exception requesting user address", localRemoteException);
      Bundle localBundle2 = new Bundle();
      localBundle2.putInt("com.google.android.gms.identity.intents.EXTRA_ERROR_CODE", 555);
      this.adM.g(1, localBundle2);
    }
  }

  protected lo aF(IBinder paramIBinder)
  {
    return lo.a.aH(paramIBinder);
  }

  public void disconnect()
  {
    super.disconnect();
    if (this.adM != null)
    {
      a.a(this.adM, null);
      this.adM = null;
    }
  }

  protected String getServiceDescriptor()
  {
    return "com.google.android.gms.identity.intents.internal.IAddressService";
  }

  protected String getStartServiceAction()
  {
    return "com.google.android.gms.identity.service.BIND";
  }

  protected lo lS()
  {
    return (lo)super.gS();
  }

  protected void lT()
  {
    super.dJ();
  }

  public static final class a extends ln.a
  {
    private final int Lu;
    private Activity nr;

    public a(int paramInt, Activity paramActivity)
    {
      this.Lu = paramInt;
      this.nr = paramActivity;
    }

    private void setActivity(Activity paramActivity)
    {
      this.nr = paramActivity;
    }

    public void g(int paramInt, Bundle paramBundle)
    {
      PendingIntent localPendingIntent1;
      if (paramInt == 1)
      {
        Intent localIntent = new Intent();
        localIntent.putExtras(paramBundle);
        localPendingIntent1 = this.nr.createPendingResult(this.Lu, localIntent, 1073741824);
        if (localPendingIntent1 != null);
      }
      while (true)
      {
        return;
        try
        {
          localPendingIntent1.send(1);
          return;
        }
        catch (PendingIntent.CanceledException localCanceledException1)
        {
          Log.w("AddressClientImpl", "Exception settng pending result", localCanceledException1);
          return;
        }
        PendingIntent localPendingIntent2 = null;
        if (paramBundle != null)
          localPendingIntent2 = (PendingIntent)paramBundle.getParcelable("com.google.android.gms.identity.intents.EXTRA_PENDING_INTENT");
        ConnectionResult localConnectionResult = new ConnectionResult(paramInt, localPendingIntent2);
        if (localConnectionResult.hasResolution())
          try
          {
            localConnectionResult.startResolutionForResult(this.nr, this.Lu);
            return;
          }
          catch (IntentSender.SendIntentException localSendIntentException)
          {
            Log.w("AddressClientImpl", "Exception starting pending intent", localSendIntentException);
            return;
          }
        try
        {
          PendingIntent localPendingIntent3 = this.nr.createPendingResult(this.Lu, new Intent(), 1073741824);
          if (localPendingIntent3 != null)
          {
            localPendingIntent3.send(1);
            return;
          }
        }
        catch (PendingIntent.CanceledException localCanceledException2)
        {
          Log.w("AddressClientImpl", "Exception setting pending result", localCanceledException2);
        }
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.lm
 * JD-Core Version:    0.6.2
 */