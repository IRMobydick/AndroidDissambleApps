package com.ubercab.client.feature.verification;

import android.app.ActionBar;
import com.squareup.otto.Bus;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.network.RiderClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class MobileVerificationChangeNumberFragment$$InjectAdapter extends Binding<MobileVerificationChangeNumberFragment>
  implements Provider<MobileVerificationChangeNumberFragment>, MembersInjector<MobileVerificationChangeNumberFragment>
{
  private Binding<ActionBar> mActionBar;
  private Binding<Bus> mBus;
  private Binding<RiderClient> mRiderClient;
  private Binding<RiderFragment> supertype;

  public MobileVerificationChangeNumberFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.verification.MobileVerificationChangeNumberFragment", "members/com.ubercab.client.feature.verification.MobileVerificationChangeNumberFragment", false, MobileVerificationChangeNumberFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mActionBar = paramLinker.requestBinding("android.app.ActionBar", MobileVerificationChangeNumberFragment.class, getClass().getClassLoader());
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", MobileVerificationChangeNumberFragment.class, getClass().getClassLoader());
    this.mRiderClient = paramLinker.requestBinding("com.ubercab.client.core.network.RiderClient", MobileVerificationChangeNumberFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderFragment", MobileVerificationChangeNumberFragment.class, getClass().getClassLoader(), false, true);
  }

  public MobileVerificationChangeNumberFragment get()
  {
    MobileVerificationChangeNumberFragment localMobileVerificationChangeNumberFragment = new MobileVerificationChangeNumberFragment();
    injectMembers(localMobileVerificationChangeNumberFragment);
    return localMobileVerificationChangeNumberFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mActionBar);
    paramSet2.add(this.mBus);
    paramSet2.add(this.mRiderClient);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(MobileVerificationChangeNumberFragment paramMobileVerificationChangeNumberFragment)
  {
    paramMobileVerificationChangeNumberFragment.mActionBar = ((ActionBar)this.mActionBar.get());
    paramMobileVerificationChangeNumberFragment.mBus = ((Bus)this.mBus.get());
    paramMobileVerificationChangeNumberFragment.mRiderClient = ((RiderClient)this.mRiderClient.get());
    this.supertype.injectMembers(paramMobileVerificationChangeNumberFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.verification.MobileVerificationChangeNumberFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */