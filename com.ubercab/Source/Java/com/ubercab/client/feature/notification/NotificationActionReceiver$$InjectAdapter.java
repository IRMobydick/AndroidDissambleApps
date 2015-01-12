package com.ubercab.client.feature.notification;

import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.network.RiderClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class NotificationActionReceiver$$InjectAdapter extends Binding<NotificationActionReceiver>
  implements Provider<NotificationActionReceiver>, MembersInjector<NotificationActionReceiver>
{
  private Binding<AnalyticsManager> mAnalyticsManager;
  private Binding<PingProvider> mPingProvider;
  private Binding<RiderClient> mRiderClient;
  private Binding<RiderNotificationManager> mRiderNotificationManager;

  public NotificationActionReceiver$$InjectAdapter()
  {
    super("com.ubercab.client.feature.notification.NotificationActionReceiver", "members/com.ubercab.client.feature.notification.NotificationActionReceiver", false, NotificationActionReceiver.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mRiderClient = paramLinker.requestBinding("com.ubercab.client.core.network.RiderClient", NotificationActionReceiver.class, getClass().getClassLoader());
    this.mAnalyticsManager = paramLinker.requestBinding("com.ubercab.client.core.analytics.AnalyticsManager", NotificationActionReceiver.class, getClass().getClassLoader());
    this.mRiderNotificationManager = paramLinker.requestBinding("com.ubercab.client.feature.notification.RiderNotificationManager", NotificationActionReceiver.class, getClass().getClassLoader());
    this.mPingProvider = paramLinker.requestBinding("com.ubercab.client.core.content.PingProvider", NotificationActionReceiver.class, getClass().getClassLoader());
  }

  public NotificationActionReceiver get()
  {
    NotificationActionReceiver localNotificationActionReceiver = new NotificationActionReceiver();
    injectMembers(localNotificationActionReceiver);
    return localNotificationActionReceiver;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mRiderClient);
    paramSet2.add(this.mAnalyticsManager);
    paramSet2.add(this.mRiderNotificationManager);
    paramSet2.add(this.mPingProvider);
  }

  public void injectMembers(NotificationActionReceiver paramNotificationActionReceiver)
  {
    paramNotificationActionReceiver.mRiderClient = ((RiderClient)this.mRiderClient.get());
    paramNotificationActionReceiver.mAnalyticsManager = ((AnalyticsManager)this.mAnalyticsManager.get());
    paramNotificationActionReceiver.mRiderNotificationManager = ((RiderNotificationManager)this.mRiderNotificationManager.get());
    paramNotificationActionReceiver.mPingProvider = ((PingProvider)this.mPingProvider.get());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.notification.NotificationActionReceiver..InjectAdapter
 * JD-Core Version:    0.6.2
 */