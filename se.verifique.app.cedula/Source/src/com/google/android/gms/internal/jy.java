package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;

public final class jy extends kl
{
  private jr a;

  public jy(jr paramjr)
  {
    this.a = paramjr;
  }

  public void a(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    kx.a("onPostInitComplete can be called only once per call to getServiceFromBroker", this.a);
    this.a.a(paramInt, paramIBinder, paramBundle);
    this.a = null;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jy
 * JD-Core Version:    0.6.0
 */