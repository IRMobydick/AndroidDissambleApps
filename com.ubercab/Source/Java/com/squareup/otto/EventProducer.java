package com.squareup.otto;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class EventProducer
{
  private final int hashCode;
  private final Method method;
  final Object target;
  private boolean valid = true;

  EventProducer(Object paramObject, Method paramMethod)
  {
    if (paramObject == null)
      throw new NullPointerException("EventProducer target cannot be null.");
    if (paramMethod == null)
      throw new NullPointerException("EventProducer method cannot be null.");
    this.target = paramObject;
    this.method = paramMethod;
    paramMethod.setAccessible(true);
    this.hashCode = (31 * (31 + paramMethod.hashCode()) + paramObject.hashCode());
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    EventProducer localEventProducer;
    do
    {
      return true;
      if (paramObject == null)
        return false;
      if (getClass() != paramObject.getClass())
        return false;
      localEventProducer = (EventProducer)paramObject;
    }
    while ((this.method.equals(localEventProducer.method)) && (this.target == localEventProducer.target));
    return false;
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

  public Object produceEvent()
    throws InvocationTargetException
  {
    if (!this.valid)
      throw new IllegalStateException(toString() + " has been invalidated and can no longer produce events.");
    try
    {
      Object localObject = this.method.invoke(this.target, new Object[0]);
      return localObject;
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

  public String toString()
  {
    return "[EventProducer " + this.method + "]";
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.squareup.otto.EventProducer
 * JD-Core Version:    0.6.2
 */