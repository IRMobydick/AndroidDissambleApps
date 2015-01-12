package com.ubercab.client.feature.notification.handler;

import com.ubercab.library.metrics.analytics.AnalyticsClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

public final class SurgeNotificationHandler$$InjectAdapter extends Binding<SurgeNotificationHandler>
  implements MembersInjector<SurgeNotificationHandler>
{
  private Binding<AnalyticsClient> mAnalyticsClient;
  private Binding<NotificationHandler> supertype;

  public SurgeNotificationHandler$$InjectAdapter()
  {
    super(null, "members/com.ubercab.client.feature.notification.handler.SurgeNotificationHandler", false, SurgeNotificationHandler.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mAnalyticsClient = paramLinker.requestBinding("com.ubercab.library.metrics.analytics.AnalyticsClient", SurgeNotificationHandler.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.feature.notification.handler.NotificationHandler", SurgeNotificationHandler.class, getClass().getClassLoader(), false, true);
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mAnalyticsClient);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(SurgeNotificationHandler paramSurgeNotificationHandler)
  {
    paramSurgeNotificationHandler.mAnalyticsClient = ((AnalyticsClient)this.mAnalyticsClient.get());
    this.supertype.injectMembers(paramSurgeNotificationHandler);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.notification.handler.SurgeNotificationHandler..InjectAdapter
 * JD-Core Version:    0.6.2
 */