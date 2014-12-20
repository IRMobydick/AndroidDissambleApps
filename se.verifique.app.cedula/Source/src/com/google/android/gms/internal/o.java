package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.a.a;
import com.google.android.gms.a.d;
import com.google.android.gms.a.e;
import com.google.android.gms.a.f;
import com.google.android.gms.common.g;

public final class o extends e
{
  private static final o a = new o();

  private o()
  {
    super("com.google.android.gms.ads.AdManagerCreatorImpl");
  }

  public static y a(Context paramContext, al paramal, String paramString, bu parambu)
  {
    Object localObject;
    if (g.a(paramContext) == 0)
    {
      localObject = a.b(paramContext, paramal, paramString, parambu);
      if (localObject != null);
    }
    else
    {
      hi.a("Using AdManager from the client jar.");
      localObject = new of(paramContext, paramal, paramString, parambu, new ev(5089000, 5089000, true));
    }
    return (y)localObject;
  }

  private y b(Context paramContext, al paramal, String paramString, bu parambu)
  {
    try
    {
      a locala = d.a(paramContext);
      y localy2 = z.a(((ab)a(paramContext)).a(locala, paramal, paramString, parambu, 5089000));
      localy1 = localy2;
      return localy1;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
      {
        hi.c("Could not create remote AdManager.", localRemoteException);
        localy1 = null;
      }
    }
    catch (f localf)
    {
      while (true)
      {
        hi.c("Could not create remote AdManager.", localf);
        y localy1 = null;
      }
    }
  }

  protected ab b(IBinder paramIBinder)
  {
    return ac.a(paramIBinder);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.o
 * JD-Core Version:    0.6.0
 */