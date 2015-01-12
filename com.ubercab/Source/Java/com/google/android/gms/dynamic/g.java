package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.o;

public abstract class g<T>
{
  private final String Sl;
  private T Sm;

  protected g(String paramString)
  {
    this.Sl = paramString;
  }

  protected final T L(Context paramContext)
    throws g.a
  {
    ClassLoader localClassLoader;
    if (this.Sm == null)
    {
      o.i(paramContext);
      Context localContext = GooglePlayServicesUtil.getRemoteContext(paramContext);
      if (localContext == null)
        throw new a("Could not get remote context.");
      localClassLoader = localContext.getClassLoader();
    }
    try
    {
      this.Sm = d((IBinder)localClassLoader.loadClass(this.Sl).newInstance());
      return this.Sm;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new a("Could not load creator class.", localClassNotFoundException);
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new a("Could not instantiate creator.", localInstantiationException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new a("Could not access creator.", localIllegalAccessException);
    }
  }

  protected abstract T d(IBinder paramIBinder);

  public static class a extends Exception
  {
    public a(String paramString)
    {
      super();
    }

    public a(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.dynamic.g
 * JD-Core Version:    0.6.2
 */