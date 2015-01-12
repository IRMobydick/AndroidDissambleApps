package com.ubercab.client.feature.notification.handler;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Impression;
import com.ubercab.client.feature.notification.data.SurgeNotificationData;
import com.ubercab.client.feature.trip.TripActivity;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import javax.inject.Inject;

public final class SurgeNotificationHandler extends NotificationHandler<SurgeNotificationData>
{

  @Inject
  AnalyticsClient mAnalyticsClient;

  public SurgeNotificationHandler(Context paramContext)
  {
    super(paramContext);
  }

  public void handleNotification(SurgeNotificationData paramSurgeNotificationData)
  {
    String str1 = paramSurgeNotificationData.getFallbackText();
    if (TextUtils.isEmpty(str1))
    {
      cancel(3, paramSurgeNotificationData.getTag());
      return;
    }
    this.mAnalyticsClient.sendImpressionEvent(RiderEvents.Impression.SURGE_DROP_NOTIFY_RECEIVED);
    Context localContext = getContext();
    PendingIntent localPendingIntent = PendingIntent.getActivity(localContext, 0, new Intent(localContext, TripActivity.class), 268435456);
    Bitmap localBitmap = ((BitmapDrawable)localContext.getResources().getDrawable(2130837772)).getBitmap();
    String str2 = localContext.getString(2131559096);
    NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(localContext).setLargeIcon(localBitmap).setSmallIcon(2130837771).setContentTitle(str2).setContentText(str1).setContentIntent(localPendingIntent).setDeleteIntent(createDeletePendingIntent(6, paramSurgeNotificationData.getTag())).setAutoCancel(true).setTicker(str1).setWhen(0L);
    localBuilder.setStyle(new NotificationCompat.BigTextStyle(localBuilder).setBigContentTitle(str2).bigText(str1));
    notify(3, paramSurgeNotificationData.getTag(), localBuilder.build());
  }

  public void handleNotificationDeleted(int paramInt, String paramString)
  {
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.notification.handler.SurgeNotificationHandler
 * JD-Core Version:    0.6.2
 */