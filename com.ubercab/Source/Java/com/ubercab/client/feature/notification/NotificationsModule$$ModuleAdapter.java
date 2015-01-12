package com.ubercab.client.feature.notification;

import dagger.internal.BindingsGroup;
import dagger.internal.ModuleAdapter;
import dagger.internal.ProvidesBinding;
import javax.inject.Provider;

public final class NotificationsModule$$ModuleAdapter extends ModuleAdapter<NotificationsModule>
{
  private static final Class<?>[] INCLUDES = new Class[0];
  private static final String[] INJECTS = { "members/com.ubercab.client.feature.notification.handler.FareSplitAcceptedNotificationHandler", "members/com.ubercab.client.feature.notification.handler.FareSplitInviteNotificationHandler", "members/com.ubercab.client.feature.notification.handler.MessageNotificationHandler", "members/com.ubercab.client.feature.notification.handler.ReceiptNotificationHandler", "members/com.ubercab.client.feature.notification.handler.SurgeNotificationHandler", "members/com.ubercab.client.feature.notification.handler.TripNotificationHandler" };
  private static final Class<?>[] STATIC_INJECTIONS = new Class[0];

  public NotificationsModule$$ModuleAdapter()
  {
    super(NotificationsModule.class, INJECTS, STATIC_INJECTIONS, false, INCLUDES, true, false);
  }

  public void getBindings(BindingsGroup paramBindingsGroup, NotificationsModule paramNotificationsModule)
  {
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.client.feature.notification.NotificationPainter", new ProvideNotificationPainterProvidesAdapter(paramNotificationsModule));
  }

  public static final class ProvideNotificationPainterProvidesAdapter extends ProvidesBinding<NotificationPainter>
    implements Provider<NotificationPainter>
  {
    private final NotificationsModule module;

    public ProvideNotificationPainterProvidesAdapter(NotificationsModule paramNotificationsModule)
    {
      super(false, "com.ubercab.client.feature.notification.NotificationsModule", "provideNotificationPainter");
      this.module = paramNotificationsModule;
      setLibrary(false);
    }

    public NotificationPainter get()
    {
      return this.module.provideNotificationPainter();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.notification.NotificationsModule..ModuleAdapter
 * JD-Core Version:    0.6.2
 */