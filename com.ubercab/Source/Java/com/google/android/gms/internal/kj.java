package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class kj
{
  private static final List<TimeUnit> Sv = Arrays.asList(arrayOfTimeUnit);

  static
  {
    TimeUnit[] arrayOfTimeUnit = new TimeUnit[7];
    arrayOfTimeUnit[0] = TimeUnit.NANOSECONDS;
    arrayOfTimeUnit[1] = TimeUnit.MICROSECONDS;
    arrayOfTimeUnit[2] = TimeUnit.MILLISECONDS;
    arrayOfTimeUnit[3] = TimeUnit.SECONDS;
    arrayOfTimeUnit[4] = TimeUnit.MINUTES;
    arrayOfTimeUnit[5] = TimeUnit.HOURS;
    arrayOfTimeUnit[6] = TimeUnit.DAYS;
  }

  public static long a(long paramLong, TimeUnit paramTimeUnit1, TimeUnit paramTimeUnit2)
  {
    return paramTimeUnit1.convert(paramTimeUnit2.convert(paramLong, paramTimeUnit1), paramTimeUnit2);
  }

  public static boolean a(TimeUnit paramTimeUnit)
  {
    return a(paramTimeUnit, TimeUnit.MILLISECONDS);
  }

  private static boolean a(TimeUnit paramTimeUnit1, TimeUnit paramTimeUnit2)
  {
    return Sv.indexOf(paramTimeUnit1) < Sv.indexOf(paramTimeUnit2);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.kj
 * JD-Core Version:    0.6.2
 */