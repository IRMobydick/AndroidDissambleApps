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

public final class MobileVerificationTokenFragment$$InjectAdapter extends Binding<MobileVerificationTokenFragment>
  implements Provider<MobileVerificationTokenFragment>, MembersInjector<MobileVerificationTokenFragment>
{
  private Binding<ActionBar> mActionBar;
  private Binding<Bus> mBus;
  private Binding<RiderClient> mRiderClient;
  private Binding<RiderFragment> supertype;

  public MobileVerificationTokenFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.verification.MobileVerificationTokenFragment", "members/com.ubercab.client.feature.verification.MobileVerificationTokenFragment", false, MobileVerificationTokenFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mActionBar = paramLinker.requestBinding("android.app.ActionBar", MobileVerificationTokenFragment.class, getClass().getClassLoader());
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", MobileVerificationTokenFragment.class, getClass().getClassLoader());
    this.mRiderClient = paramLinker.requestBinding("com.ubercab.client.core.network.RiderClient", MobileVerificationTokenFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderFragment", MobileVerificationTokenFragment.class, getClass().getClassLoader(), false, true);
  }

  public MobileVerificationTokenFragment get()
  {
    MobileVerificationTokenFragment localMobileVerificationTokenFragment = new MobileVerificationTokenFragment();
    injectMembers(localMobileVerificationTokenFragment);
    return localMobileVerificationTokenFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mActionBar);
    paramSet2.add(this.mBus);
    paramSet2.add(this.mRiderClient);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(MobileVerificationTokenFragment paramMobileVerificationTokenFragment)
  {
    paramMobileVerificationTokenFragment.mActionBar = ((ActionBar)this.mActionBar.get());
    paramMobileVerificationTokenFragment.mBus = ((Bus)this.mBus.get());
    paramMobileVerificationTokenFragment.mRiderClient = ((RiderClient)this.mRiderClient.get());
    this.supertype.injectMembers(paramMobileVerificationTokenFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.verification.MobileVerificationTokenFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */