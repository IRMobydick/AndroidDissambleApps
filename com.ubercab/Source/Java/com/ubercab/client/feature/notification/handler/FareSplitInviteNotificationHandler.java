package com.ubercab.client.feature.notification.handler;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.support.v4.app.NotificationCompat.Builder;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.network.events.FareSplitAcceptResponseEvent;
import com.ubercab.client.core.network.events.FareSplitDeclineResponseEvent;
import com.ubercab.client.feature.notification.NotificationPainter;
import com.ubercab.client.feature.notification.data.FareSplitInviteNotificationData;
import com.ubercab.client.feature.notification.data.NotificationData.Source;
import javax.inject.Inject;

public final class FareSplitInviteNotificationHandler extends NotificationHandler<FareSplitInviteNotificationData>
{
  public static final String ACTION_ACCEPT = "com.ubercab.client.ACTION_FARE_SPLIT_INVITE_ACCEPT";
  public static final String ACTION_DECLINE = "com.ubercab.client.ACTION_FARE_SPLIT_INVITE_DECLINE";

  @Inject
  NotificationPainter mPainter;

  public FareSplitInviteNotificationHandler(Context paramContext)
  {
    super(paramContext);
  }

  public void handleNotification(FareSplitInviteNotificationData paramFareSplitInviteNotificationData)
  {
    Context localContext = getContext();
    String str1 = paramFareSplitInviteNotificationData.getMasterName();
    String str2 = localContext.getString(2131558951);
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramFareSplitInviteNotificationData.getMasterName();
    String str3 = localContext.getString(2131558950, arrayOfObject);
    int i = paramFareSplitInviteNotificationData.getMessageIdentifier();
    PendingIntent localPendingIntent1 = createPendingIntent(i, "com.ubercab.client.ACTION_TRIP_SHOW_MAP");
    PendingIntent localPendingIntent2 = createPendingIntent(i, "com.ubercab.client.ACTION_FARE_SPLIT_INVITE_ACCEPT", false);
    PendingIntent localPendingIntent3 = createPendingIntent(i, "com.ubercab.client.ACTION_FARE_SPLIT_INVITE_DECLINE", false);
    Notification localNotification = new NotificationCompat.Builder(getContext()).setSmallIcon(2130837771).setLargeIcon(this.mPainter.loadBitmap(paramFareSplitInviteNotificationData.getMasterPhotoUrl(), this.mPainter.getIconSizeLarge())).setContentTitle(str1).setContentText(str2).setContentIntent(localPendingIntent1).setDeleteIntent(createDeletePendingIntent(4, null)).setAutoCancel(true).setTicker(str3).addAction(2130837765, localContext.getString(2131558797), localPendingIntent3).addAction(2130837764, localContext.getString(2131558416), localPendingIntent2).build();
    if (paramFareSplitInviteNotificationData.getSource() != NotificationData.Source.PUSH)
    {
      localNotification.defaults = 0;
      localNotification.sound = null;
      localNotification.vibrate = null;
    }
    notify(4, localNotification);
  }

  public void handleNotificationDeleted(int paramInt, String paramString)
  {
  }

  @Subscribe
  public void onFareSplitAcceptResponseEvent(FareSplitAcceptResponseEvent paramFareSplitAcceptResponseEvent)
  {
    cancel(4);
  }

  @Subscribe
  public void onFareSplitDeclineResponseEvent(FareSplitDeclineResponseEvent paramFareSplitDeclineResponseEvent)
  {
    cancel(4);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.notification.handler.FareSplitInviteNotificationHandler
 * JD-Core Version:    0.6.2
 */