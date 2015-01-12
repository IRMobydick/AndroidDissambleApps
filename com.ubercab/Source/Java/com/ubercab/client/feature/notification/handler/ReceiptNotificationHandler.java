package com.ubercab.client.feature.notification.handler;

import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.NotificationCompat.BigPictureStyle;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.client.feature.notification.NotificationPainter;
import com.ubercab.client.feature.notification.data.ReceiptNotificationData;
import com.ubercab.client.feature.receipt.event.ReceiptRateEvent;
import com.ubercab.client.feature.receipt.event.ShowReceiptEvent;
import com.ubercab.common.base.Objects;
import javax.inject.Inject;

public final class ReceiptNotificationHandler extends NotificationHandler<ReceiptNotificationData>
{
  public static final String ACTION_RATE_DRIVER = "com.ubercab.client.ACTION_RECEIPT_RATE_DRIVER";

  @Inject
  NotificationPainter mPainter;

  @Inject
  SessionPreferences mSessionPreferences;

  public ReceiptNotificationHandler(Context paramContext)
  {
    super(paramContext);
  }

  private void createReceiptNotification(ReceiptNotificationData paramReceiptNotificationData)
  {
    if (Objects.equal(this.mSessionPreferences.getLastRatedTripId(), paramReceiptNotificationData.getTripId()))
      return;
    Context localContext = getContext();
    String str1 = localContext.getString(2131558968, new Object[] { paramReceiptNotificationData.getAmountCharged() });
    int i = paramReceiptNotificationData.getMessageIdentifier();
    String str2 = paramReceiptNotificationData.getCreditsUsed();
    String str3 = getFormattedTimestamp(paramReceiptNotificationData.getTimestamp());
    String str4 = localContext.getString(2131558792, new Object[] { str2 });
    String str5;
    if ((!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(str2)))
      str5 = String.format("%s • %s", new Object[] { str3, str4 });
    while (true)
    {
      PendingIntent localPendingIntent1 = createPendingIntent(i, "com.ubercab.client.ACTION_TRIP_SHOW_MAP");
      PendingIntent localPendingIntent2 = createDeletePendingIntent(2, paramReceiptNotificationData.getTag());
      PendingIntent localPendingIntent3 = createPendingIntent(i, "com.ubercab.client.ACTION_RECEIPT_RATE_DRIVER");
      Bitmap localBitmap1 = ((BitmapDrawable)getContext().getResources().getDrawable(2130837771)).getBitmap();
      NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(getContext()).setSmallIcon(2130837771).setLargeIcon(localBitmap1).setContentTitle(str1).setContentText(str5).setContentIntent(localPendingIntent1).setDeleteIntent(localPendingIntent2).setAutoCancel(true).setTicker(str1).setWhen(0L);
      Bitmap localBitmap2 = this.mPainter.loadBitmapLargeImage(paramReceiptNotificationData.getMapImageUrl(), true);
      if (localBitmap2 != null)
      {
        NotificationCompat.BigPictureStyle localBigPictureStyle = new NotificationCompat.BigPictureStyle(localBuilder);
        localBuilder.setStyle(localBigPictureStyle.bigPicture(localBitmap2));
      }
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramReceiptNotificationData.getDriverName();
      localBuilder.addAction(2130837754, localContext.getString(2131558967, arrayOfObject), localPendingIntent3);
      notify(2, paramReceiptNotificationData.getTag(), localBuilder.build());
      return;
      if (!TextUtils.isEmpty(str3))
        str5 = str3;
      else
        str5 = str4;
    }
  }

  public void handleNotification(ReceiptNotificationData paramReceiptNotificationData)
  {
    createReceiptNotification(paramReceiptNotificationData);
  }

  public void handleNotificationDeleted(int paramInt, String paramString)
  {
  }

  @Subscribe
  public void onReceiptRateEvent(ReceiptRateEvent paramReceiptRateEvent)
  {
    cancel(2, paramReceiptRateEvent.getTripId());
  }

  @Subscribe
  public void onShowReceiptEvent(ShowReceiptEvent paramShowReceiptEvent)
  {
    cancel(2, paramShowReceiptEvent.getTripId());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.notification.handler.ReceiptNotificationHandler
 * JD-Core Version:    0.6.2
 */