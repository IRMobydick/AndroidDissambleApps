package com.ubercab.client.feature.trip.rates;

import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.app.RiderPopupWindow;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

public final class BaseRateCardPopupWindow$$InjectAdapter extends Binding<BaseRateCardPopupWindow>
  implements MembersInjector<BaseRateCardPopupWindow>
{
  private Binding<AnalyticsClient> mAnalyticsClient;
  private Binding<AnalyticsManager> mAnalyticsManager;
  private Binding<PingProvider> mPingProvider;
  private Binding<RiderPopupWindow> supertype;

  public BaseRateCardPopupWindow$$InjectAdapter()
  {
    super(null, "members/com.ubercab.client.feature.trip.rates.BaseRateCardPopupWindow", false, BaseRateCardPopupWindow.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mAnalyticsManager = paramLinker.requestBinding("com.ubercab.client.core.analytics.AnalyticsManager", BaseRateCardPopupWindow.class, getClass().getClassLoader());
    this.mAnalyticsClient = paramLinker.requestBinding("com.ubercab.library.metrics.analytics.AnalyticsClient", BaseRateCardPopupWindow.class, getClass().getClassLoader());
    this.mPingProvider = paramLinker.requestBinding("com.ubercab.client.core.content.PingProvider", BaseRateCardPopupWindow.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderPopupWindow", BaseRateCardPopupWindow.class, getClass().getClassLoader(), false, true);
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mAnalyticsManager);
    paramSet2.add(this.mAnalyticsClient);
    paramSet2.add(this.mPingProvider);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(BaseRateCardPopupWindow paramBaseRateCardPopupWindow)
  {
    paramBaseRateCardPopupWindow.mAnalyticsManager = ((AnalyticsManager)this.mAnalyticsManager.get());
    paramBaseRateCardPopupWindow.mAnalyticsClient = ((AnalyticsClient)this.mAnalyticsClient.get());
    paramBaseRateCardPopupWindow.mPingProvider = ((PingProvider)this.mPingProvider.get());
    this.supertype.injectMembers(paramBaseRateCardPopupWindow);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.rates.BaseRateCardPopupWindow..InjectAdapter
 * JD-Core Version:    0.6.2
 */