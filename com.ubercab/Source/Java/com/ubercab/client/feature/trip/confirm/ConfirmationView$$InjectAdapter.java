package com.ubercab.client.feature.trip.confirm;

import com.ubercab.library.metrics.analytics.AnalyticsClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

public final class ConfirmationView$$InjectAdapter extends Binding<ConfirmationView>
  implements MembersInjector<ConfirmationView>
{
  private Binding<AnalyticsClient> mAnalyticsClient;

  public ConfirmationView$$InjectAdapter()
  {
    super(null, "members/com.ubercab.client.feature.trip.confirm.ConfirmationView", false, ConfirmationView.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mAnalyticsClient = paramLinker.requestBinding("com.ubercab.library.metrics.analytics.AnalyticsClient", ConfirmationView.class, getClass().getClassLoader());
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mAnalyticsClient);
  }

  public void injectMembers(ConfirmationView paramConfirmationView)
  {
    paramConfirmationView.mAnalyticsClient = ((AnalyticsClient)this.mAnalyticsClient.get());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.confirm.ConfirmationView..InjectAdapter
 * JD-Core Version:    0.6.2
 */