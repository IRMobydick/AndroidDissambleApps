package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.reflect.Field;

public abstract class ha
  implements SafeParcelable
{
  private static final Object a = new Object();
  private static ClassLoader b = null;
  private static Integer c = null;
  private boolean d = false;

  protected static ClassLoader B()
  {
    synchronized (a)
    {
      ClassLoader localClassLoader = b;
      return localClassLoader;
    }
  }

  protected static Integer C()
  {
    synchronized (a)
    {
      Integer localInteger = c;
      return localInteger;
    }
  }

  private static boolean a(Class paramClass)
  {
    int i = 0;
    try
    {
      boolean bool = "SAFE_PARCELABLE_NULL_STRING".equals(paramClass.getField("NULL").get(null));
      i = bool;
      label22: return i;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label22;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      break label22;
    }
  }

  protected static boolean b(String paramString)
  {
    ClassLoader localClassLoader = B();
    int i;
    if (localClassLoader == null)
      i = 1;
    while (true)
    {
      return i;
      try
      {
        boolean bool = a(localClassLoader.loadClass(paramString));
        i = bool;
      }
      catch (Exception localException)
      {
        i = 0;
      }
    }
  }

  protected boolean D()
  {
    return this.d;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ha
 * JD-Core Version:    0.6.0
 */