package com.ubercab.common.collect;

import java.lang.reflect.Array;
import java.util.Arrays;

public final class ObjectArrays
{
  public static <T> T[] concat(T paramT, T[] paramArrayOfT)
  {
    Object[] arrayOfObject = newArray(paramArrayOfT, 1 + paramArrayOfT.length);
    arrayOfObject[0] = paramT;
    System.arraycopy(paramArrayOfT, 0, arrayOfObject, 1, paramArrayOfT.length);
    return arrayOfObject;
  }

  public static <T> T[] concat(T[] paramArrayOfT, T paramT)
  {
    Object[] arrayOfObject = Arrays.copyOf(paramArrayOfT, 1 + paramArrayOfT.length);
    arrayOfObject[paramArrayOfT.length] = paramT;
    return arrayOfObject;
  }

  public static <T> T[] concat(T[] paramArrayOfT1, T[] paramArrayOfT2, Class<T> paramClass)
  {
    Object[] arrayOfObject = newArray(paramClass, paramArrayOfT1.length + paramArrayOfT2.length);
    System.arraycopy(paramArrayOfT1, 0, arrayOfObject, 0, paramArrayOfT1.length);
    System.arraycopy(paramArrayOfT2, 0, arrayOfObject, paramArrayOfT1.length, paramArrayOfT2.length);
    return arrayOfObject;
  }

  public static <T> T[] newArray(Class<T> paramClass, int paramInt)
  {
    return (Object[])Array.newInstance(paramClass, paramInt);
  }

  public static <T> T[] newArray(T[] paramArrayOfT, int paramInt)
  {
    return (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), paramInt);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.common.collect.ObjectArrays
 * JD-Core Version:    0.6.2
 */