package com.ubercab.client.feature.notification;

import android.content.Context;
import com.ubercab.client.core.module.RiderApplicationModule;
import com.ubercab.client.feature.notification.handler.FareSplitAcceptedNotificationHandler;
import com.ubercab.client.feature.notification.handler.FareSplitInviteNotificationHandler;
import com.ubercab.client.feature.notification.handler.MessageNotificationHandler;
import com.ubercab.client.feature.notification.handler.ReceiptNotificationHandler;
import com.ubercab.client.feature.notification.handler.SurgeNotificationHandler;
import com.ubercab.client.feature.notification.handler.TripNotificationHandler;
import dagger.Module;
import dagger.Provides;

@Module(addsTo=RiderApplicationModule.class, injects={FareSplitAcceptedNotificationHandler.class, FareSplitInviteNotificationHandler.class, MessageNotificationHandler.class, ReceiptNotificationHandler.class, SurgeNotificationHandler.class, TripNotificationHandler.class})
public class NotificationsModule
{
  private final Context mContext;

  public NotificationsModule(Context paramContext)
  {
    this.mContext = paramContext;
  }

  @Provides
  NotificationPainter provideNotificationPainter()
  {
    return new NotificationPainter(this.mContext);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.notification.NotificationsModule
 * JD-Core Version:    0.6.2
 */