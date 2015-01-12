package com.ubercab.client.feature.notification.handler;

import android.app.PendingIntent;
import android.content.Context;
import android.support.v4.app.NotificationCompat.Builder;
import com.ubercab.client.feature.notification.NotificationPainter;
import com.ubercab.client.feature.notification.data.FareSplitAcceptedNotificationData;
import javax.inject.Inject;

public final class FareSplitAcceptedNotificationHandler extends NotificationHandler<FareSplitAcceptedNotificationData>
{

  @Inject
  NotificationPainter mPainter;

  public FareSplitAcceptedNotificationHandler(Context paramContext)
  {
    super(paramContext);
  }

  public void handleNotification(FareSplitAcceptedNotificationData paramFareSplitAcceptedNotificationData)
  {
    String str1 = paramFareSplitAcceptedNotificationData.getMinionName();
    String str2 = getContext().getString(2131558948);
    Context localContext = getContext();
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramFareSplitAcceptedNotificationData.getMinionName();
    String str3 = localContext.getString(2131558949, arrayOfObject);
    PendingIntent localPendingIntent = createPendingIntent(paramFareSplitAcceptedNotificationData.getMessageIdentifier(), "com.ubercab.client.ACTION_TRIP_SHOW_MAP");
    NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(getContext()).setSmallIcon(2130837771).setLargeIcon(this.mPainter.loadBitmap(paramFareSplitAcceptedNotificationData.getMinionPhotoUrl(), this.mPainter.getIconSizeLarge())).setContentTitle(str1).setContentText(str2).setContentIntent(localPendingIntent).setDeleteIntent(createDeletePendingIntent(5, null)).setAutoCancel(true).setTicker(str3);
    notify(5, paramFareSplitAcceptedNotificationData.getTag(), localBuilder.build());
  }

  public void handleNotificationDeleted(int paramInt, String paramString)
  {
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.notification.handler.FareSplitAcceptedNotificationHandler
 * JD-Core Version:    0.6.2
 */