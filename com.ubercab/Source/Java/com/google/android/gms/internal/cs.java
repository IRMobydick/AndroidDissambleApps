package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.mediation.MediationServerParameters;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import java.util.Map;

@ez
public final class cs extends ct.a
{
  private Map<Class<? extends com.google.android.gms.ads.mediation.NetworkExtras>, com.google.android.gms.ads.mediation.NetworkExtras> qC;

  private <NETWORK_EXTRAS extends com.google.ads.mediation.NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> cu z(String paramString)
    throws RemoteException
  {
    try
    {
      Class localClass = Class.forName(paramString, false, cs.class.getClassLoader());
      if (com.google.ads.mediation.MediationAdapter.class.isAssignableFrom(localClass))
      {
        com.google.ads.mediation.MediationAdapter localMediationAdapter = (com.google.ads.mediation.MediationAdapter)localClass.newInstance();
        return new cz(localMediationAdapter, (com.google.ads.mediation.NetworkExtras)this.qC.get(localMediationAdapter.getAdditionalParametersType()));
      }
      if (com.google.android.gms.ads.mediation.MediationAdapter.class.isAssignableFrom(localClass))
        return new cx((com.google.android.gms.ads.mediation.MediationAdapter)localClass.newInstance());
      gs.W("Could not instantiate mediation adapter: " + paramString + " (not a valid adapter).");
      throw new RemoteException();
    }
    catch (Throwable localThrowable)
    {
      gs.W("Could not instantiate mediation adapter: " + paramString + ". " + localThrowable.getMessage());
    }
    throw new RemoteException();
  }

  public void d(Map<Class<? extends com.google.android.gms.ads.mediation.NetworkExtras>, com.google.android.gms.ads.mediation.NetworkExtras> paramMap)
  {
    this.qC = paramMap;
  }

  public cu x(String paramString)
    throws RemoteException
  {
    return z(paramString);
  }

  public boolean y(String paramString)
    throws RemoteException
  {
    try
    {
      boolean bool = CustomEvent.class.isAssignableFrom(Class.forName(paramString, false, cs.class.getClassLoader()));
      return bool;
    }
    catch (Throwable localThrowable)
    {
      gs.W("Could not load custom event implementation class: " + paramString + ", assuming old implementation.");
    }
    return false;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.cs
 * JD-Core Version:    0.6.2
 */