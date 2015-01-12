package com.ubercab.library.app;

import com.squareup.otto.Bus;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

public final class UberDialogFragment$$InjectAdapter extends Binding<UberDialogFragment>
  implements MembersInjector<UberDialogFragment>
{
  private Binding<AnalyticsClient> mAnalyticsClient;
  private Binding<Bus> mBus;

  public UberDialogFragment$$InjectAdapter()
  {
    super(null, "members/com.ubercab.library.app.UberDialogFragment", false, UberDialogFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", UberDialogFragment.class, getClass().getClassLoader());
    this.mAnalyticsClient = paramLinker.requestBinding("com.ubercab.library.metrics.analytics.AnalyticsClient", UberDialogFragment.class, getClass().getClassLoader());
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mBus);
    paramSet2.add(this.mAnalyticsClient);
  }

  public void injectMembers(UberDialogFragment paramUberDialogFragment)
  {
    paramUberDialogFragment.mBus = ((Bus)this.mBus.get());
    paramUberDialogFragment.mAnalyticsClient = ((AnalyticsClient)this.mAnalyticsClient.get());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.app.UberDialogFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */