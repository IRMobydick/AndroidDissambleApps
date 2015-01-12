package com.ubercab.client.feature.notification.handler;

import com.ubercab.client.feature.notification.NotificationPainter;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

public final class FareSplitInviteNotificationHandler$$InjectAdapter extends Binding<FareSplitInviteNotificationHandler>
  implements MembersInjector<FareSplitInviteNotificationHandler>
{
  private Binding<NotificationPainter> mPainter;
  private Binding<NotificationHandler> supertype;

  public FareSplitInviteNotificationHandler$$InjectAdapter()
  {
    super(null, "members/com.ubercab.client.feature.notification.handler.FareSplitInviteNotificationHandler", false, FareSplitInviteNotificationHandler.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mPainter = paramLinker.requestBinding("com.ubercab.client.feature.notification.NotificationPainter", FareSplitInviteNotificationHandler.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.feature.notification.handler.NotificationHandler", FareSplitInviteNotificationHandler.class, getClass().getClassLoader(), false, true);
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mPainter);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(FareSplitInviteNotificationHandler paramFareSplitInviteNotificationHandler)
  {
    paramFareSplitInviteNotificationHandler.mPainter = ((NotificationPainter)this.mPainter.get());
    this.supertype.injectMembers(paramFareSplitInviteNotificationHandler);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.notification.handler.FareSplitInviteNotificationHandler..InjectAdapter
 * JD-Core Version:    0.6.2
 */