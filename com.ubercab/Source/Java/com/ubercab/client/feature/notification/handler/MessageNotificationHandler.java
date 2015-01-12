package com.ubercab.client.feature.notification.handler;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import com.ubercab.client.feature.notification.NotificationPainter;
import com.ubercab.client.feature.notification.data.MessageNotificationData;
import com.ubercab.client.feature.trip.TripActivity;
import javax.inject.Inject;

public final class MessageNotificationHandler extends NotificationHandler<MessageNotificationData>
{
  private final int mIconSizeLarge;

  @Inject
  NotificationPainter mPainter;

  public MessageNotificationHandler(Context paramContext)
  {
    super(paramContext);
    this.mIconSizeLarge = paramContext.getResources().getDimensionPixelSize(2131361909);
  }

  public void handleNotification(MessageNotificationData paramMessageNotificationData)
  {
    if (!TextUtils.isEmpty(paramMessageNotificationData.getUrl()));
    for (Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramMessageNotificationData.getUrl())); ; localIntent = new Intent(getContext(), TripActivity.class))
    {
      PendingIntent localPendingIntent = PendingIntent.getActivity(getContext(), 0, localIntent, 268435456);
      NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(getContext()).setSmallIcon(2130837771).setContentTitle(paramMessageNotificationData.getTitle()).setContentText(paramMessageNotificationData.getText()).setContentIntent(localPendingIntent).setDeleteIntent(createDeletePendingIntent(6, paramMessageNotificationData.getTag())).setAutoCancel(true).setTicker(paramMessageNotificationData.getTicker()).setWhen(0L);
      if (!TextUtils.isEmpty(paramMessageNotificationData.getLargeImageUrl()))
        localBuilder.setLargeIcon(this.mPainter.loadBitmap(paramMessageNotificationData.getLargeImageUrl(), this.mIconSizeLarge));
      localBuilder.setStyle(new NotificationCompat.BigTextStyle(localBuilder).setBigContentTitle(paramMessageNotificationData.getTitle()).bigText(paramMessageNotificationData.getText()));
      notify(6, paramMessageNotificationData.getTag(), localBuilder.build());
      return;
    }
  }

  public void handleNotificationDeleted(int paramInt, String paramString)
  {
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.notification.handler.MessageNotificationHandler
 * JD-Core Version:    0.6.2
 */