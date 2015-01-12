package com.ubercab.client.feature.notification.handler;

import com.squareup.otto.Bus;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

public final class NotificationHandler$$InjectAdapter extends Binding<NotificationHandler>
  implements MembersInjector<NotificationHandler>
{
  private Binding<Bus> mBus;

  public NotificationHandler$$InjectAdapter()
  {
    super(null, "members/com.ubercab.client.feature.notification.handler.NotificationHandler", false, NotificationHandler.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", NotificationHandler.class, getClass().getClassLoader());
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mBus);
  }

  public void injectMembers(NotificationHandler paramNotificationHandler)
  {
    paramNotificationHandler.mBus = ((Bus)this.mBus.get());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.notification.handler.NotificationHandler..InjectAdapter
 * JD-Core Version:    0.6.2
 */