package com.ubercab.client.feature.mobilemessage;

import com.ubercab.client.core.app.RiderPopupWindow;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

public final class MobileMessagePopupWindow$$InjectAdapter extends Binding<MobileMessagePopupWindow>
  implements MembersInjector<MobileMessagePopupWindow>
{
  private Binding<AnalyticsClient> mAnalyticsClient;
  private Binding<MobileMessageManager> mMobileMessageManager;
  private Binding<PingProvider> mPingProvider;
  private Binding<RiderPopupWindow> supertype;

  public MobileMessagePopupWindow$$InjectAdapter()
  {
    super(null, "members/com.ubercab.client.feature.mobilemessage.MobileMessagePopupWindow", false, MobileMessagePopupWindow.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mAnalyticsClient = paramLinker.requestBinding("com.ubercab.library.metrics.analytics.AnalyticsClient", MobileMessagePopupWindow.class, getClass().getClassLoader());
    this.mMobileMessageManager = paramLinker.requestBinding("com.ubercab.client.feature.mobilemessage.MobileMessageManager", MobileMessagePopupWindow.class, getClass().getClassLoader());
    this.mPingProvider = paramLinker.requestBinding("com.ubercab.client.core.content.PingProvider", MobileMessagePopupWindow.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderPopupWindow", MobileMessagePopupWindow.class, getClass().getClassLoader(), false, true);
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mAnalyticsClient);
    paramSet2.add(this.mMobileMessageManager);
    paramSet2.add(this.mPingProvider);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(MobileMessagePopupWindow paramMobileMessagePopupWindow)
  {
    paramMobileMessagePopupWindow.mAnalyticsClient = ((AnalyticsClient)this.mAnalyticsClient.get());
    paramMobileMessagePopupWindow.mMobileMessageManager = ((MobileMessageManager)this.mMobileMessageManager.get());
    paramMobileMessagePopupWindow.mPingProvider = ((PingProvider)this.mPingProvider.get());
    this.supertype.injectMembers(paramMobileMessagePopupWindow);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.mobilemessage.MobileMessagePopupWindow..InjectAdapter
 * JD-Core Version:    0.6.2
 */