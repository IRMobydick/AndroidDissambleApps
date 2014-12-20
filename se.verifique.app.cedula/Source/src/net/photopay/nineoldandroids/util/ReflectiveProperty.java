package net.photopay.nineoldandroids.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ReflectiveProperty extends Property
{
  private static final String PREFIX_GET = "get";
  private static final String PREFIX_IS = "is";
  private static final String PREFIX_SET = "set";
  private Field mField;
  private Method mGetter;
  private Method mSetter;

  public ReflectiveProperty(Class paramClass1, Class paramClass2, String paramString)
  {
    super(paramClass2, paramString);
    char c = Character.toUpperCase(paramString.charAt(0));
    String str1 = paramString.substring(1);
    String str2 = c + str1;
    String str3 = "get" + str2;
    Class localClass2;
    String str5;
    try
    {
      this.mGetter = paramClass1.getMethod(str3, null);
      localClass2 = this.mGetter.getReturnType();
      if (!typesMatch(paramClass2, localClass2))
        throw new NoSuchPropertyException("Underlying type (" + localClass2 + ") does not match Property type (" + paramClass2 + ")");
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      try
      {
        this.mGetter = paramClass1.getDeclaredMethod(str3, null);
        this.mGetter.setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        while (true)
        {
          String str4 = "is" + str2;
          try
          {
            this.mGetter = paramClass1.getMethod(str4, null);
          }
          catch (NoSuchMethodException localNoSuchMethodException3)
          {
            try
            {
              this.mGetter = paramClass1.getDeclaredMethod(str4, null);
              this.mGetter.setAccessible(true);
            }
            catch (NoSuchMethodException localNoSuchMethodException4)
            {
              try
              {
                this.mField = paramClass1.getField(paramString);
                Class localClass1 = this.mField.getType();
                if (typesMatch(paramClass2, localClass1))
                  break label362;
                throw new NoSuchPropertyException("Underlying type (" + localClass1 + ") does not match Property type (" + paramClass2 + ")");
              }
              catch (NoSuchFieldException localNoSuchFieldException)
              {
                throw new NoSuchPropertyException("No accessor method or field found for property with name " + paramString);
              }
            }
          }
        }
      }
      str5 = "set" + str2;
    }
    try
    {
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = localClass2;
      this.mSetter = paramClass1.getDeclaredMethod(str5, arrayOfClass);
      this.mSetter.setAccessible(true);
      label362: return;
    }
    catch (NoSuchMethodException localNoSuchMethodException5)
    {
      break label362;
    }
  }

  private boolean typesMatch(Class paramClass1, Class paramClass2)
  {
    int i = 0;
    if (paramClass2 != paramClass1)
      if ((!paramClass2.isPrimitive()) || (((paramClass2 != Float.TYPE) || (paramClass1 != Float.class)) && ((paramClass2 != Integer.TYPE) || (paramClass1 != Integer.class)) && ((paramClass2 != Boolean.TYPE) || (paramClass1 != Boolean.class)) && ((paramClass2 != Long.TYPE) || (paramClass1 != Long.class)) && ((paramClass2 != Double.TYPE) || (paramClass1 != Double.class)) && ((paramClass2 != Short.TYPE) || (paramClass1 != Short.class)) && ((paramClass2 != Byte.TYPE) || (paramClass1 != Byte.class)) && ((paramClass2 != Character.TYPE) || (paramClass1 != Character.class))));
    for (i = 1; ; i = 1)
      return i;
  }

  public Object get(Object paramObject)
  {
    if (this.mGetter != null);
    while (true)
    {
      Object localObject2;
      try
      {
        Object localObject3 = this.mGetter.invoke(paramObject, null);
        localObject2 = localObject3;
        return localObject2;
      }
      catch (IllegalAccessException localIllegalAccessException2)
      {
        throw new AssertionError();
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        throw new RuntimeException(localInvocationTargetException.getCause());
      }
      if (this.mField == null)
        break;
      try
      {
        Object localObject1 = this.mField.get(paramObject);
        localObject2 = localObject1;
      }
      catch (IllegalAccessException localIllegalAccessException1)
      {
        throw new AssertionError();
      }
    }
    throw new AssertionError();
  }

  public boolean isReadOnly()
  {
    if ((this.mSetter == null) && (this.mField == null));
    for (int i = 1; ; i = 0)
      return i;
  }

  public void set(Object paramObject1, Object paramObject2)
  {
    if (this.mSetter != null);
    while (true)
    {
      try
      {
        Method localMethod = this.mSetter;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = paramObject2;
        localMethod.invoke(paramObject1, arrayOfObject);
        return;
      }
      catch (IllegalAccessException localIllegalAccessException2)
      {
        throw new AssertionError();
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        throw new RuntimeException(localInvocationTargetException.getCause());
      }
      if (this.mField == null)
        break;
      try
      {
        this.mField.set(paramObject1, paramObject2);
      }
      catch (IllegalAccessException localIllegalAccessException1)
      {
        throw new AssertionError();
      }
    }
    throw new UnsupportedOperationException("Property " + getName() + " is read-only");
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.nineoldandroids.util.ReflectiveProperty
 * JD-Core Version:    0.6.0
 */