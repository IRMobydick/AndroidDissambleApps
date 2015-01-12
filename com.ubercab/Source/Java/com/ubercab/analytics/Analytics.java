package com.ubercab.analytics;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

public final class Analytics
{
  private static final String ANDROID_PREFIX = "android.";
  static final Map<Class<?>, Method> INJECTORS = new LinkedHashMap();
  private static final String JAVA_PREFIX = "java.";
  static final Method NO_OP = null;

  private static Method findInjectorForClass(Class<?> paramClass)
    throws NoSuchMethodException
  {
    Method localMethod1 = (Method)INJECTORS.get(paramClass);
    if (localMethod1 != null)
      return localMethod1;
    String str = paramClass.getName();
    if ((str.startsWith("android.")) || (str.startsWith("java.")))
      return NO_OP;
    try
    {
      Method localMethod3 = Class.forName(str + "$$AnalyticsInjector").getMethod("init", new Class[] { paramClass });
      localMethod2 = localMethod3;
      INJECTORS.put(paramClass, localMethod2);
      return localMethod2;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      while (true)
        Method localMethod2 = findInjectorForClass(paramClass.getSuperclass());
    }
  }

  public static void inject(Object paramObject)
  {
    Class localClass = paramObject.getClass();
    try
    {
      Method localMethod = findInjectorForClass(localClass);
      if (localMethod != null)
        localMethod.invoke(null, new Object[] { paramObject });
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (Exception localException)
    {
      Object localObject = localException;
      if ((localObject instanceof InvocationTargetException))
        localObject = ((Throwable)localObject).getCause();
      throw new RuntimeException("Unable to inject analytics for " + paramObject, (Throwable)localObject);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.analytics.Analytics
 * JD-Core Version:    0.6.2
 */