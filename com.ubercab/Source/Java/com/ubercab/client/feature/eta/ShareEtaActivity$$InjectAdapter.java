package com.ubercab.client.feature.eta;

import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.app.RiderPingActivity;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class ShareEtaActivity$$InjectAdapter extends Binding<ShareEtaActivity>
  implements Provider<ShareEtaActivity>, MembersInjector<ShareEtaActivity>
{
  private Binding<AnalyticsClient> mAnalyticsClient;
  private Binding<AnalyticsManager> mAnalyticsManager;
  private Binding<PingProvider> mPingProvider;
  private Binding<RiderClient> mRiderClient;
  private Binding<RiderPingActivity> supertype;

  public ShareEtaActivity$$InjectAdapter()
  {
    super("com.ubercab.client.feature.eta.ShareEtaActivity", "members/com.ubercab.client.feature.eta.ShareEtaActivity", false, ShareEtaActivity.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mAnalyticsClient = paramLinker.requestBinding("com.ubercab.library.metrics.analytics.AnalyticsClient", ShareEtaActivity.class, getClass().getClassLoader());
    this.mRiderClient = paramLinker.requestBinding("com.ubercab.client.core.network.RiderClient", ShareEtaActivity.class, getClass().getClassLoader());
    this.mPingProvider = paramLinker.requestBinding("com.ubercab.client.core.content.PingProvider", ShareEtaActivity.class, getClass().getClassLoader());
    this.mAnalyticsManager = paramLinker.requestBinding("com.ubercab.client.core.analytics.AnalyticsManager", ShareEtaActivity.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderPingActivity", ShareEtaActivity.class, getClass().getClassLoader(), false, true);
  }

  public ShareEtaActivity get()
  {
    ShareEtaActivity localShareEtaActivity = new ShareEtaActivity();
    injectMembers(localShareEtaActivity);
    return localShareEtaActivity;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mAnalyticsClient);
    paramSet2.add(this.mRiderClient);
    paramSet2.add(this.mPingProvider);
    paramSet2.add(this.mAnalyticsManager);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(ShareEtaActivity paramShareEtaActivity)
  {
    paramShareEtaActivity.mAnalyticsClient = ((AnalyticsClient)this.mAnalyticsClient.get());
    paramShareEtaActivity.mRiderClient = ((RiderClient)this.mRiderClient.get());
    paramShareEtaActivity.mPingProvider = ((PingProvider)this.mPingProvider.get());
    paramShareEtaActivity.mAnalyticsManager = ((AnalyticsManager)this.mAnalyticsManager.get());
    this.supertype.injectMembers(paramShareEtaActivity);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.eta.ShareEtaActivity..InjectAdapter
 * JD-Core Version:    0.6.2
 */