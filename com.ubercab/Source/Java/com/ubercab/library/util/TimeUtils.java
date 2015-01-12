package com.ubercab.library.util;

public final class TimeUtils
{
  public static long getEpochTime()
  {
    return System.currentTimeMillis() / 1000L;
  }

  public static long getEpochTimeMs()
  {
    return System.currentTimeMillis();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.util.TimeUtils
 * JD-Core Version:    0.6.2
 */