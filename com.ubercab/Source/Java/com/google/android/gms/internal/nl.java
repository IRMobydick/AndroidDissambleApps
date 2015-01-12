package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;

public class nl
  implements GooglePlayServicesClient.ConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener
{
  private no akF;
  private final ng.a akP;
  private boolean akQ;

  public nl(ng.a parama)
  {
    this.akP = parama;
    this.akF = null;
    this.akQ = true;
  }

  public void R(boolean paramBoolean)
  {
    this.akQ = paramBoolean;
  }

  public void a(no paramno)
  {
    this.akF = paramno;
  }

  public void onConnected(Bundle paramBundle)
  {
    this.akF.S(false);
    if ((this.akQ) && (this.akP != null))
      this.akP.mU();
    this.akQ = false;
  }

  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    this.akF.S(true);
    if ((this.akQ) && (this.akP != null))
    {
      if (!paramConnectionResult.hasResolution())
        break label48;
      this.akP.b(paramConnectionResult.getResolution());
    }
    while (true)
    {
      this.akQ = false;
      return;
      label48: this.akP.mV();
    }
  }

  public void onDisconnected()
  {
    this.akF.S(true);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.nl
 * JD-Core Version:    0.6.2
 */