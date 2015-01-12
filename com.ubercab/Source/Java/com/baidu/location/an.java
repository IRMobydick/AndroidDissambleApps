package com.baidu.location;

public final class an
{
  public static Object a(Object paramObject)
  {
    if (paramObject == null)
      throw new NullPointerException("null reference");
    return paramObject;
  }

  public static Object a(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null)
      throw new NullPointerException(String.valueOf(paramObject2));
    return paramObject1;
  }

  public static void a(boolean paramBoolean)
  {
    if (!paramBoolean)
      throw new IllegalStateException();
  }

  public static void a(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean)
      throw new IllegalStateException(String.valueOf(paramObject));
  }

  public static void a(boolean paramBoolean, String paramString, Object[] paramArrayOfObject)
  {
    if (!paramBoolean)
      throw new IllegalArgumentException(String.format(paramString, paramArrayOfObject));
  }

  public static void jdMethod_if(boolean paramBoolean)
  {
    if (!paramBoolean)
      throw new IllegalArgumentException();
  }

  public static void jdMethod_if(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean)
      throw new IllegalArgumentException(String.valueOf(paramObject));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.location.an
 * JD-Core Version:    0.6.2
 */