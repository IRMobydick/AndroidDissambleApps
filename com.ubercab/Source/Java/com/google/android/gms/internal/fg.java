package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;

@ez
public abstract class fg extends gg
{
  private final fi pQ;
  private final ff.a tu;

  public fg(fi paramfi, ff.a parama)
  {
    this.pQ = paramfi;
    this.tu = parama;
  }

  private static fk a(fm paramfm, fi paramfi)
  {
    try
    {
      fk localfk = paramfm.b(paramfi);
      return localfk;
    }
    catch (RemoteException localRemoteException)
    {
      gs.d("Could not fetch ad response from ad request service.", localRemoteException);
      return null;
    }
    catch (NullPointerException localNullPointerException)
    {
      gs.d("Could not fetch ad response from ad request service due to an Exception.", localNullPointerException);
      return null;
    }
    catch (SecurityException localSecurityException)
    {
      gs.d("Could not fetch ad response from ad request service due to an Exception.", localSecurityException);
      return null;
    }
    catch (Throwable localThrowable)
    {
      gb.e(localThrowable);
    }
    return null;
  }

  public abstract void cC();

  public abstract fm cD();

  public final void co()
  {
    try
    {
      fm localfm = cD();
      fk localfk;
      if (localfm == null)
        localfk = new fk(0);
      while (true)
      {
        cC();
        this.tu.a(localfk);
        return;
        localfk = a(localfm, this.pQ);
        if (localfk == null)
          localfk = new fk(0);
      }
    }
    finally
    {
      cC();
    }
  }

  public final void onStop()
  {
    cC();
  }

  @ez
  public static final class a extends fg
  {
    private final Context mContext;

    public a(Context paramContext, fi paramfi, ff.a parama)
    {
      super(parama);
      this.mContext = paramContext;
    }

    public void cC()
    {
    }

    public fm cD()
    {
      Bundle localBundle = gb.bD();
      bm localbm = new bm(localBundle.getString("gads:sdk_core_location"), localBundle.getString("gads:sdk_core_experiment_id"), localBundle.getString("gads:block_autoclicks_experiment_id"));
      return fr.a(this.mContext, localbm, new cj(), new fy());
    }
  }

  @ez
  public static final class b extends fg
    implements GooglePlayServicesClient.ConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener
  {
    private final Object mw = new Object();
    private final ff.a tu;
    private final fh tv;

    public b(Context paramContext, fi paramfi, ff.a parama)
    {
      super(parama);
      this.tu = parama;
      this.tv = new fh(paramContext, this, this, paramfi.lD.wF);
      this.tv.connect();
    }

    public void cC()
    {
      synchronized (this.mw)
      {
        if ((this.tv.isConnected()) || (this.tv.isConnecting()))
          this.tv.disconnect();
        return;
      }
    }

    public fm cD()
    {
      synchronized (this.mw)
      {
        try
        {
          fm localfm = this.tv.cE();
          return localfm;
        }
        catch (IllegalStateException localIllegalStateException)
        {
          return null;
        }
      }
    }

    public void onConnected(Bundle paramBundle)
    {
      start();
    }

    public void onConnectionFailed(ConnectionResult paramConnectionResult)
    {
      this.tu.a(new fk(0));
    }

    public void onDisconnected()
    {
      gs.S("Disconnected from remote ad request service.");
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fg
 * JD-Core Version:    0.6.2
 */