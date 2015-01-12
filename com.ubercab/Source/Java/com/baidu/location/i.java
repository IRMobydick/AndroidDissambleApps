package com.baidu.location;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import java.util.Calendar;

class i
{
  public static void a(Context paramContext, PendingIntent paramPendingIntent)
  {
    ((AlarmManager)paramContext.getSystemService("alarm")).cancel(paramPendingIntent);
  }

  public static void a(Context paramContext, PendingIntent paramPendingIntent, int paramInt)
  {
    AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
    localAlarmManager.cancel(paramPendingIntent);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(System.currentTimeMillis());
    localCalendar.add(14, paramInt);
    localAlarmManager.set(0, localCalendar.getTimeInMillis(), paramPendingIntent);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.location.i
 * JD-Core Version:    0.6.2
 */