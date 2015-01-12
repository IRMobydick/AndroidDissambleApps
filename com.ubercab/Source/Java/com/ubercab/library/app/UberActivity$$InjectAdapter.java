package com.ubercab.library.app;

import com.squareup.otto.Bus;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

public final class UberActivity$$InjectAdapter extends Binding<UberActivity>
  implements MembersInjector<UberActivity>
{
  private Binding<AnalyticsClient> mAnalyticsClient;
  private Binding<LifecycleTracker> mAppLifecycleTracker;
  private Binding<Bus> mBus;

  public UberActivity$$InjectAdapter()
  {
    super(null, "members/com.ubercab.library.app.UberActivity", false, UberActivity.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", UberActivity.class, getClass().getClassLoader());
    this.mAnalyticsClient = paramLinker.requestBinding("com.ubercab.library.metrics.analytics.AnalyticsClient", UberActivity.class, getClass().getClassLoader());
    this.mAppLifecycleTracker = paramLinker.requestBinding("com.ubercab.library.app.LifecycleTracker", UberActivity.class, getClass().getClassLoader());
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mBus);
    paramSet2.add(this.mAnalyticsClient);
    paramSet2.add(this.mAppLifecycleTracker);
  }

  public void injectMembers(UberActivity paramUberActivity)
  {
    paramUberActivity.mBus = ((Bus)this.mBus.get());
    paramUberActivity.mAnalyticsClient = ((AnalyticsClient)this.mAnalyticsClient.get());
    paramUberActivity.mAppLifecycleTracker = ((LifecycleTracker)this.mAppLifecycleTracker.get());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.app.UberActivity..InjectAdapter
 * JD-Core Version:    0.6.2
 */