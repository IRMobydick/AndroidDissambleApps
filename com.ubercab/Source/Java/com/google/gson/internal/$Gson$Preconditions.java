package com.google.gson.internal;

public final class $Gson$Preconditions
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
 * Qualified Name:     com.google.gson.internal..Gson.Preconditions
 * JD-Core Version:    0.6.2
 */