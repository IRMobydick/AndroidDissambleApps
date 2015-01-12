package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.g;
import com.google.android.gms.dynamic.g.a;

@ez
public final class au extends g<be>
{
  private static final au nS = new au();

  private au()
  {
    super("com.google.android.gms.ads.AdManagerCreatorImpl");
  }

  public static bd a(Context paramContext, ay paramay, String paramString, cs paramcs)
  {
    Object localObject;
    if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramContext) == 0)
    {
      localObject = nS.b(paramContext, paramay, paramString, paramcs);
      if (localObject != null);
    }
    else
    {
      gs.S("Using AdManager from the client jar.");
      localObject = new u(paramContext, paramay, paramString, paramcs, new gt(6171000, 6171000, true));
    }
    return localObject;
  }

  private bd b(Context paramContext, ay paramay, String paramString, cs paramcs)
  {
    try
    {
      d locald = e.k(paramContext);
      bd localbd = bd.a.f(((be)L(paramContext)).a(locald, paramay, paramString, paramcs, 6171000));
      return localbd;
    }
    catch (RemoteException localRemoteException)
    {
      gs.d("Could not create remote AdManager.", localRemoteException);
      return null;
    }
    catch (g.a locala)
    {
      gs.d("Could not create remote AdManager.", locala);
    }
    return null;
  }

  protected be c(IBinder paramIBinder)
  {
    return be.a.g(paramIBinder);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.au
 * JD-Core Version:    0.6.2
 */