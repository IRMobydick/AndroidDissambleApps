package com.squareup.otto;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class EventHandler
{
  private final int hashCode;
  private final Method method;
  private final Object target;
  private boolean valid = true;

  EventHandler(Object paramObject, Method paramMethod)
  {
    if (paramObject == null)
      throw new NullPointerException("EventHandler target cannot be null.");
    if (paramMethod == null)
      throw new NullPointerException("EventHandler method cannot be null.");
    this.target = paramObject;
    this.method = paramMethod;
    paramMethod.setAccessible(true);
    this.hashCode = (31 * (31 + paramMethod.hashCode()) + paramObject.hashCode());
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    EventHandler localEventHandler;
    do
    {
      return true;
      if (paramObject == null)
        return false;
      if (getClass() != paramObject.getClass())
        return false;
      localEventHandler = (EventHandler)paramObject;
    }
    while ((this.method.equals(localEventHandler.method)) && (this.target == localEventHandler.target));
    return false;
  }

  public void handleEvent(Object paramObject)
    throws InvocationTargetException
  {
    if (!this.valid)
      throw new IllegalStateException(toString() + " has been invalidated and can no longer handle events.");
    try
    {
      this.method.invoke(this.target, new Object[] { paramObject });
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

  public int hashCode()
  {
    return this.hashCode;
  }

  public void invalidate()
  {
    this.valid = false;
  }

  public boolean isValid()
  {
    return this.valid;
  }

  public String toString()
  {
    return "[EventHandler " + this.method + "]";
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.squareup.otto.EventHandler
 * JD-Core Version:    0.6.2
 */