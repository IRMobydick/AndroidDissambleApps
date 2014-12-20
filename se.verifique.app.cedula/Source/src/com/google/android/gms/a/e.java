package com.google.android.gms.a;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.g;
import com.google.android.gms.internal.kx;

public abstract class e
{
  private final String a;
  private Object b;

  protected e(String paramString)
  {
    this.a = paramString;
  }

  protected final Object a(Context paramContext)
  {
    ClassLoader localClassLoader;
    if (this.b == null)
    {
      kx.a(paramContext);
      Context localContext = g.c(paramContext);
      if (localContext == null)
        throw new f("Could not get remote context.");
      localClassLoader = localContext.getClassLoader();
    }
    try
    {
      this.b = a((IBinder)localClassLoader.loadClass(this.a).newInstance());
      return this.b;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new f("Could not load creator class.");
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new f("Could not instantiate creator.");
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
    }
    throw new f("Could not access creator.");
  }

  protected abstract Object a(IBinder paramIBinder);
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.a.e
 * JD-Core Version:    0.6.0
 */