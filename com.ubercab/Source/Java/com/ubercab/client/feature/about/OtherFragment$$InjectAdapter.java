package com.ubercab.client.feature.about;

import android.app.ActionBar;
import com.squareup.otto.Bus;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.RiderLocationProvider;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class OtherFragment$$InjectAdapter extends Binding<OtherFragment>
  implements Provider<OtherFragment>, MembersInjector<OtherFragment>
{
  private Binding<ActionBar> mActionBar;
  private Binding<Bus> mBus;
  private Binding<RiderLocationProvider> mLocationProvider;
  private Binding<PingProvider> mPingProvider;
  private Binding<RiderFragment> supertype;

  public OtherFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.about.OtherFragment", "members/com.ubercab.client.feature.about.OtherFragment", false, OtherFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", OtherFragment.class, getClass().getClassLoader());
    this.mActionBar = paramLinker.requestBinding("android.app.ActionBar", OtherFragment.class, getClass().getClassLoader());
    this.mLocationProvider = paramLinker.requestBinding("com.ubercab.client.core.content.RiderLocationProvider", OtherFragment.class, getClass().getClassLoader());
    this.mPingProvider = paramLinker.requestBinding("com.ubercab.client.core.content.PingProvider", OtherFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderFragment", OtherFragment.class, getClass().getClassLoader(), false, true);
  }

  public OtherFragment get()
  {
    OtherFragment localOtherFragment = new OtherFragment();
    injectMembers(localOtherFragment);
    return localOtherFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mBus);
    paramSet2.add(this.mActionBar);
    paramSet2.add(this.mLocationProvider);
    paramSet2.add(this.mPingProvider);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(OtherFragment paramOtherFragment)
  {
    paramOtherFragment.mBus = ((Bus)this.mBus.get());
    paramOtherFragment.mActionBar = ((ActionBar)this.mActionBar.get());
    paramOtherFragment.mLocationProvider = ((RiderLocationProvider)this.mLocationProvider.get());
    paramOtherFragment.mPingProvider = ((PingProvider)this.mPingProvider.get());
    this.supertype.injectMembers(paramOtherFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.about.OtherFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */