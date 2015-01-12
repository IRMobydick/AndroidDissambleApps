package com.google.android.gms.maps.internal;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.o;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class u
{
  private static Context ajx;
  private static c ajy;

  public static c S(Context paramContext)
    throws GooglePlayServicesNotAvailableException
  {
    o.i(paramContext);
    if (ajy != null)
      return ajy;
    T(paramContext);
    ajy = U(paramContext);
    try
    {
      ajy.a(e.k(getRemoteContext(paramContext).getResources()), 6171000);
      return ajy;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  private static void T(Context paramContext)
    throws GooglePlayServicesNotAvailableException
  {
    int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramContext);
    switch (i)
    {
    default:
      throw new GooglePlayServicesNotAvailableException(i);
    case 0:
    }
  }

  private static c U(Context paramContext)
  {
    if (mK())
    {
      Log.i(u.class.getSimpleName(), "Making Creator statically");
      return (c)c(mL());
    }
    Log.i(u.class.getSimpleName(), "Making Creator dynamically");
    return c.a.aP((IBinder)a(getRemoteContext(paramContext).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl"));
  }

  private static <T> T a(ClassLoader paramClassLoader, String paramString)
  {
    try
    {
      Object localObject = c(((ClassLoader)o.i(paramClassLoader)).loadClass(paramString));
      return localObject;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
    }
    throw new IllegalStateException("Unable to find dynamic class " + paramString);
  }

  private static <T> T c(Class<?> paramClass)
  {
    try
    {
      Object localObject = paramClass.newInstance();
      return localObject;
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new IllegalStateException("Unable to instantiate the dynamic class " + paramClass.getName());
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
    }
    throw new IllegalStateException("Unable to call the default constructor of " + paramClass.getName());
  }

  private static Context getRemoteContext(Context paramContext)
  {
    if (ajx == null)
      if (!mK())
        break label23;
    label23: for (ajx = paramContext.getApplicationContext(); ; ajx = GooglePlayServicesUtil.getRemoteContext(paramContext))
      return ajx;
  }

  private static boolean mK()
  {
    return false;
  }

  private static Class<?> mL()
  {
    try
    {
      if (Build.VERSION.SDK_INT < 15)
        return Class.forName("com.google.android.gms.maps.internal.CreatorImplGmm6");
      Class localClass = Class.forName("com.google.android.gms.maps.internal.CreatorImpl");
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new RuntimeException(localClassNotFoundException);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.internal.u
 * JD-Core Version:    0.6.2
 */