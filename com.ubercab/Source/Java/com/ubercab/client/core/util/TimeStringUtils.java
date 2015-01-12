package com.ubercab.client.core.util;

import android.content.Context;
import com.ubercab.common.base.Joiner;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public final class TimeStringUtils
{
  private static final long MS_IN_DAY = 86400000L;
  private static final long MS_IN_HOUR = 3600000L;
  private static final long MS_IN_MINUTE = 60000L;

  public static String convertMSToFormattedString(Context paramContext, long paramLong, String paramString)
  {
    long[] arrayOfLong = { 86400000L, 3600000L, 60000L };
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < arrayOfLong.length)
    {
      long l;
      if (paramLong > arrayOfLong[i])
      {
        l = paramLong / arrayOfLong[i];
        if (l <= 1L)
          break label127;
      }
      label127: for (String str = getPluralLocalizedTimeUnit(paramContext, i); ; str = getSingularLocalizedTimeUnit(paramContext, i))
      {
        localArrayList.add(l + " " + str);
        paramLong -= l * arrayOfLong[i];
        i++;
        break;
      }
    }
    return Joiner.on(paramString + " ").join(localArrayList);
  }

  public static String getDayOfWeekFromEpochMS(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    return localCalendar.getDisplayName(7, 1, Locale.getDefault());
  }

  private static String getPluralLocalizedTimeUnit(Context paramContext, int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "";
    case 0:
      return paramContext.getString(2131558796);
    case 1:
      return paramContext.getString(2131558893);
    case 2:
    }
    return paramContext.getString(2131558931);
  }

  private static String getSingularLocalizedTimeUnit(Context paramContext, int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "";
    case 0:
      return paramContext.getString(2131558795);
    case 1:
      return paramContext.getString(2131558892);
    case 2:
    }
    return paramContext.getString(2131558927);
  }

  public static String getTimeOfDayFromEpochMS(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    int i = localCalendar.get(10);
    int j = localCalendar.get(12);
    String str = localCalendar.getDisplayName(9, 1, Locale.getDefault());
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(i);
    arrayOfObject[1] = Integer.valueOf(j);
    arrayOfObject[2] = str;
    return String.format("%d:%d%s", arrayOfObject);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.util.TimeStringUtils
 * JD-Core Version:    0.6.2
 */