package com.ubercab.client.feature.share;

import android.view.LayoutInflater;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.app.RiderFragment;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class ShareFragment$$InjectAdapter extends Binding<ShareFragment>
  implements Provider<ShareFragment>, MembersInjector<ShareFragment>
{
  private Binding<AnalyticsManager> mAnalyticsManager;
  private Binding<LayoutInflater> mLayoutInflater;
  private Binding<RiderFragment> supertype;

  public ShareFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.share.ShareFragment", "members/com.ubercab.client.feature.share.ShareFragment", false, ShareFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mLayoutInflater = paramLinker.requestBinding("android.view.LayoutInflater", ShareFragment.class, getClass().getClassLoader());
    this.mAnalyticsManager = paramLinker.requestBinding("com.ubercab.client.core.analytics.AnalyticsManager", ShareFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderFragment", ShareFragment.class, getClass().getClassLoader(), false, true);
  }

  public ShareFragment get()
  {
    ShareFragment localShareFragment = new ShareFragment();
    injectMembers(localShareFragment);
    return localShareFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mLayoutInflater);
    paramSet2.add(this.mAnalyticsManager);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(ShareFragment paramShareFragment)
  {
    paramShareFragment.mLayoutInflater = ((LayoutInflater)this.mLayoutInflater.get());
    paramShareFragment.mAnalyticsManager = ((AnalyticsManager)this.mAnalyticsManager.get());
    this.supertype.injectMembers(paramShareFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.share.ShareFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */