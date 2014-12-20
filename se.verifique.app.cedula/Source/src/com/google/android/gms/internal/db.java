package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.a.a;
import com.google.android.gms.a.d;
import com.google.android.gms.a.e;
import com.google.android.gms.a.f;

public final class db extends e
{
  private static final db a = new db();

  private db()
  {
    super("com.google.android.gms.ads.AdOverlayCreatorImpl");
  }

  public static dd a(Activity paramActivity)
  {
    Object localObject;
    try
    {
      if (b(paramActivity))
      {
        hi.a("Using AdOverlay from the client jar.");
        localObject = new co(paramActivity);
      }
      else
      {
        dd localdd = a.c(paramActivity);
        localObject = localdd;
      }
    }
    catch (dc localdc)
    {
      hi.e(localdc.getMessage());
      localObject = null;
    }
    return (dd)localObject;
  }

  private static boolean b(Activity paramActivity)
  {
    Intent localIntent = paramActivity.getIntent();
    if (!localIntent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar"))
      throw new dc("Ad overlay requires the useClientJar flag in intent extras.");
    return localIntent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
  }

  private dd c(Activity paramActivity)
  {
    try
    {
      a locala = d.a(paramActivity);
      dd localdd2 = de.a(((dg)a(paramActivity)).a(locala));
      localdd1 = localdd2;
      return localdd1;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
      {
        hi.c("Could not create remote AdOverlay.", localRemoteException);
        localdd1 = null;
      }
    }
    catch (f localf)
    {
      while (true)
      {
        hi.c("Could not create remote AdOverlay.", localf);
        dd localdd1 = null;
      }
    }
  }

  protected dg b(IBinder paramIBinder)
  {
    return dh.a(paramIBinder);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.db
 * JD-Core Version:    0.6.0
 */