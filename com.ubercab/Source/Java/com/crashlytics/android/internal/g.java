package com.crashlytics.android.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class g
{
  private final Object a;
  private final Method b;
  private final int c;
  private boolean d = true;

  g(Object paramObject, Method paramMethod)
  {
    if (paramObject == null)
      throw new NullPointerException("EventHandler target cannot be null.");
    if (paramMethod == null)
      throw new NullPointerException("EventHandler method cannot be null.");
    this.a = paramObject;
    this.b = paramMethod;
    paramMethod.setAccessible(true);
    this.c = (31 * (31 + paramMethod.hashCode()) + paramObject.hashCode());
  }

  public final void a(Object paramObject)
    throws InvocationTargetException
  {
    if (!this.d)
      throw new IllegalStateException(toString() + " has been invalidated and can no longer handle events.");
    try
    {
      this.b.invoke(this.a, new Object[] { paramObject });
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new AssertionError(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      if ((localInvocationTargetException.getCause() instanceof Error))
        throw ((Error)localInvocationTargetException.getCause());
      throw localInvocationTargetException;
    }
  }

  public final boolean a()
  {
    return this.d;
  }

  public final void b()
  {
    this.d = false;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    g localg;
    do
    {
      return true;
      if (paramObject == null)
        return false;
      if (getClass() != paramObject.getClass())
        return false;
      localg = (g)paramObject;
    }
    while ((this.b.equals(localg.b)) && (this.a == localg.a));
    return false;
  }

  public final int hashCode()
  {
    return this.c;
  }

  public final String toString()
  {
    return "[EventHandler " + this.b + "]";
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.internal.g
 * JD-Core Version:    0.6.2
 */