package com.ubercab.client.feature.promo;

import com.squareup.otto.Bus;
import com.ubercab.client.core.app.RiderDialogFragment;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class PromoFragment$$InjectAdapter extends Binding<PromoFragment>
  implements Provider<PromoFragment>, MembersInjector<PromoFragment>
{
  private Binding<AnalyticsClient> mAnalyticsClient;
  private Binding<Bus> mBus;
  private Binding<RiderClient> mRiderClient;
  private Binding<RiderDialogFragment> supertype;

  public PromoFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.promo.PromoFragment", "members/com.ubercab.client.feature.promo.PromoFragment", false, PromoFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mRiderClient = paramLinker.requestBinding("com.ubercab.client.core.network.RiderClient", PromoFragment.class, getClass().getClassLoader());
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", PromoFragment.class, getClass().getClassLoader());
    this.mAnalyticsClient = paramLinker.requestBinding("com.ubercab.library.metrics.analytics.AnalyticsClient", PromoFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderDialogFragment", PromoFragment.class, getClass().getClassLoader(), false, true);
  }

  public PromoFragment get()
  {
    PromoFragment localPromoFragment = new PromoFragment();
    injectMembers(localPromoFragment);
    return localPromoFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mRiderClient);
    paramSet2.add(this.mBus);
    paramSet2.add(this.mAnalyticsClient);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(PromoFragment paramPromoFragment)
  {
    paramPromoFragment.mRiderClient = ((RiderClient)this.mRiderClient.get());
    paramPromoFragment.mBus = ((Bus)this.mBus.get());
    paramPromoFragment.mAnalyticsClient = ((AnalyticsClient)this.mAnalyticsClient.get());
    this.supertype.injectMembers(paramPromoFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.promo.PromoFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */