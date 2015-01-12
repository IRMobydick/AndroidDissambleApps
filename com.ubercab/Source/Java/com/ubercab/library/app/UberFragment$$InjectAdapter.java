package com.ubercab.library.app;

import com.squareup.otto.Bus;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

public final class UberFragment$$InjectAdapter extends Binding<UberFragment>
  implements MembersInjector<UberFragment>
{
  private Binding<AnalyticsClient> mAnalyticsClient;
  private Binding<Bus> mBus;

  public UberFragment$$InjectAdapter()
  {
    super(null, "members/com.ubercab.library.app.UberFragment", false, UberFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", UberFragment.class, getClass().getClassLoader());
    this.mAnalyticsClient = paramLinker.requestBinding("com.ubercab.library.metrics.analytics.AnalyticsClient", UberFragment.class, getClass().getClassLoader());
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mBus);
    paramSet2.add(this.mAnalyticsClient);
  }

  public void injectMembers(UberFragment paramUberFragment)
  {
    paramUberFragment.mBus = ((Bus)this.mBus.get());
    paramUberFragment.mAnalyticsClient = ((AnalyticsClient)this.mAnalyticsClient.get());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.app.UberFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */