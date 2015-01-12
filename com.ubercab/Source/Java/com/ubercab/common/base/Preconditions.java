package com.ubercab.common.base;

public final class Preconditions
{
  public static void checkArgument(boolean paramBoolean)
  {
    if (!paramBoolean)
      throw new IllegalArgumentException();
  }

  public static <T> T checkNotNull(T paramT)
  {
    if (paramT == null)
      throw new NullPointerException();
    return paramT;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.common.base.Preconditions
 * JD-Core Version:    0.6.2
 */