package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.reflect.Field;

public abstract class d
  implements SafeParcelable
{
  private static final Object Lv = new Object();
  private static ClassLoader Lw = null;
  private static Integer Lx = null;
  private boolean Ly = false;

  private static boolean a(Class<?> paramClass)
  {
    try
    {
      boolean bool = "SAFE_PARCELABLE_NULL_STRING".equals(paramClass.getField("NULL").get(null));
      return bool;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      return false;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
    }
    return false;
  }

  protected static boolean aV(String paramString)
  {
    ClassLoader localClassLoader = gO();
    if (localClassLoader == null)
      return true;
    try
    {
      boolean bool = a(localClassLoader.loadClass(paramString));
      return bool;
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  protected static ClassLoader gO()
  {
    synchronized (Lv)
    {
      ClassLoader localClassLoader = Lw;
      return localClassLoader;
    }
  }

  protected static Integer gP()
  {
    synchronized (Lv)
    {
      Integer localInteger = Lx;
      return localInteger;
    }
  }

  protected boolean gQ()
  {
    return this.Ly;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.d
 * JD-Core Version:    0.6.2
 */