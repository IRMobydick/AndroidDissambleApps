package com.ubercab.client.feature.notification.handler;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.squareup.otto.Bus;
import com.ubercab.client.core.util.TimeStringUtils;
import com.ubercab.client.feature.notification.NotificationActionActivity;
import com.ubercab.client.feature.notification.data.NotificationData;
import javax.inject.Inject;

public abstract class NotificationHandler<T extends NotificationData>
{
  public static final String ACTION_CLICK = "com.ubercab.client.ACTION_CLICK";
  public static final String ACTION_DELETE = "com.ubercab.client.ACTION_DELETE";
  public static final String EXTRA_ACTION = "com.ubercab.client.EXTRA_ACTION";
  public static final String EXTRA_ID = "com.ubercab.client.EXTRA_ID";
  public static final String EXTRA_MESSAGE_IDENTIFIER = "com.ubercab.client.EXTRA_MESSAGE_IDENTIFIER";
  public static final String EXTRA_TAG = "com.ubercab.client.EXTRA_TAG";
  private static final String PROVIDER_NAME = "notifications";
  private static final int REQUEST_CODE_DELETE = 1000;

  @Inject
  Bus mBus;
  private final Context mContext;

  protected NotificationHandler(Context paramContext)
  {
    this.mContext = paramContext;
  }

  private NotificationManager getNotificationManager()
  {
    return (NotificationManager)this.mContext.getSystemService("notification");
  }

  protected void cancel(int paramInt)
  {
    getNotificationManager().cancel(paramInt);
  }

  protected void cancel(int paramInt, String paramString)
  {
    getNotificationManager().cancel(paramString, paramInt);
  }

  protected PendingIntent createDeletePendingIntent(int paramInt, String paramString)
  {
    Intent localIntent = new Intent("com.ubercab.client.ACTION_DELETE");
    localIntent.putExtra("com.ubercab.client.EXTRA_ID", paramInt);
    localIntent.putExtra("com.ubercab.client.EXTRA_TAG", paramString);
    return PendingIntent.getBroadcast(getContext(), paramInt + 1000, localIntent, 134217728);
  }

  protected PendingIntent createPendingIntent(int paramInt, String paramString)
  {
    return createPendingIntent(paramInt, paramString, true);
  }

  protected PendingIntent createPendingIntent(int paramInt, String paramString, boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    if (paramBoolean)
    {
      localIntent.setClass(getContext(), NotificationActionActivity.class);
      localIntent.setAction(paramString);
      localIntent.setFlags(268435456);
    }
    while (true)
    {
      localIntent.putExtra("com.ubercab.client.EXTRA_ACTION", paramString);
      localIntent.putExtra("com.ubercab.client.EXTRA_MESSAGE_IDENTIFIER", paramInt);
      return PendingIntent.getActivity(getContext(), paramString.hashCode(), localIntent, 134217728);
      localIntent.setAction("com.ubercab.client.ACTION_CLICK");
    }
  }

  protected Context getContext()
  {
    return this.mContext;
  }

  protected String getFormattedTimestamp(Long paramLong)
  {
    if (paramLong == null)
      return "";
    String str1 = TimeStringUtils.getDayOfWeekFromEpochMS(paramLong.longValue());
    String str2 = TimeStringUtils.getTimeOfDayFromEpochMS(paramLong.longValue());
    return this.mContext.getString(2131558966, new Object[] { str1, str2 });
  }

  protected SharedPreferences getPreferences()
  {
    return getContext().getSharedPreferences("notifications", 0);
  }

  public abstract void handleNotification(T paramT);

  public abstract void handleNotificationDeleted(int paramInt, String paramString);

  protected void notify(int paramInt, Notification paramNotification)
  {
    notify(paramInt, null, paramNotification);
  }

  protected void notify(int paramInt, String paramString, Notification paramNotification)
  {
    getNotificationManager().notify(paramString, paramInt, paramNotification);
  }

  public void start()
  {
    this.mBus.register(this);
  }

  public void stop()
  {
    this.mBus.unregister(this);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.notification.handler.NotificationHandler
 * JD-Core Version:    0.6.2
 */