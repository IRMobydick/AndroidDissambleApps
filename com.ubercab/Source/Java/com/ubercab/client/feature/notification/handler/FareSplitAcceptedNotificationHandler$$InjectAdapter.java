package com.ubercab.client.feature.notification.handler;

import com.ubercab.client.feature.notification.NotificationPainter;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

public final class FareSplitAcceptedNotificationHandler$$InjectAdapter extends Binding<FareSplitAcceptedNotificationHandler>
  implements MembersInjector<FareSplitAcceptedNotificationHandler>
{
  private Binding<NotificationPainter> mPainter;
  private Binding<NotificationHandler> supertype;

  public FareSplitAcceptedNotificationHandler$$InjectAdapter()
  {
    super(null, "members/com.ubercab.client.feature.notification.handler.FareSplitAcceptedNotificationHandler", false, FareSplitAcceptedNotificationHandler.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mPainter = paramLinker.requestBinding("com.ubercab.client.feature.notification.NotificationPainter", FareSplitAcceptedNotificationHandler.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.feature.notification.handler.NotificationHandler", FareSplitAcceptedNotificationHandler.class, getClass().getClassLoader(), false, true);
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mPainter);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(FareSplitAcceptedNotificationHandler paramFareSplitAcceptedNotificationHandler)
  {
    paramFareSplitAcceptedNotificationHandler.mPainter = ((NotificationPainter)this.mPainter.get());
    this.supertype.injectMembers(paramFareSplitAcceptedNotificationHandler);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.notification.handler.FareSplitAcceptedNotificationHandler..InjectAdapter
 * JD-Core Version:    0.6.2
 */