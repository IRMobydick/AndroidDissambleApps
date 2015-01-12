package com.ubercab.client.feature.notification.handler;

import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.client.feature.notification.NotificationPainter;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

public final class ReceiptNotificationHandler$$InjectAdapter extends Binding<ReceiptNotificationHandler>
  implements MembersInjector<ReceiptNotificationHandler>
{
  private Binding<NotificationPainter> mPainter;
  private Binding<SessionPreferences> mSessionPreferences;
  private Binding<NotificationHandler> supertype;

  public ReceiptNotificationHandler$$InjectAdapter()
  {
    super(null, "members/com.ubercab.client.feature.notification.handler.ReceiptNotificationHandler", false, ReceiptNotificationHandler.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mPainter = paramLinker.requestBinding("com.ubercab.client.feature.notification.NotificationPainter", ReceiptNotificationHandler.class, getClass().getClassLoader());
    this.mSessionPreferences = paramLinker.requestBinding("com.ubercab.client.core.content.SessionPreferences", ReceiptNotificationHandler.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.feature.notification.handler.NotificationHandler", ReceiptNotificationHandler.class, getClass().getClassLoader(), false, true);
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mPainter);
    paramSet2.add(this.mSessionPreferences);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(ReceiptNotificationHandler paramReceiptNotificationHandler)
  {
    paramReceiptNotificationHandler.mPainter = ((NotificationPainter)this.mPainter.get());
    paramReceiptNotificationHandler.mSessionPreferences = ((SessionPreferences)this.mSessionPreferences.get());
    this.supertype.injectMembers(paramReceiptNotificationHandler);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.notification.handler.ReceiptNotificationHandler..InjectAdapter
 * JD-Core Version:    0.6.2
 */