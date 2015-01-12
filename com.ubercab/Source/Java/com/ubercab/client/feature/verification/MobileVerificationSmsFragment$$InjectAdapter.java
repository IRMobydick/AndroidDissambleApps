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

public final class MobileVerificationSmsFragment$$InjectAdapter extends Binding<MobileVerificationSmsFragment>
  implements Provider<MobileVerificationSmsFragment>, MembersInjector<MobileVerificationSmsFragment>
{
  private Binding<ActionBar> mActionBar;
  private Binding<Bus> mBus;
  private Binding<RiderClient> mRiderClient;
  private Binding<RiderFragment> supertype;

  public MobileVerificationSmsFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.verification.MobileVerificationSmsFragment", "members/com.ubercab.client.feature.verification.MobileVerificationSmsFragment", false, MobileVerificationSmsFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", MobileVerificationSmsFragment.class, getClass().getClassLoader());
    this.mRiderClient = paramLinker.requestBinding("com.ubercab.client.core.network.RiderClient", MobileVerificationSmsFragment.class, getClass().getClassLoader());
    this.mActionBar = paramLinker.requestBinding("android.app.ActionBar", MobileVerificationSmsFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderFragment", MobileVerificationSmsFragment.class, getClass().getClassLoader(), false, true);
  }

  public MobileVerificationSmsFragment get()
  {
    MobileVerificationSmsFragment localMobileVerificationSmsFragment = new MobileVerificationSmsFragment();
    injectMembers(localMobileVerificationSmsFragment);
    return localMobileVerificationSmsFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mBus);
    paramSet2.add(this.mRiderClient);
    paramSet2.add(this.mActionBar);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(MobileVerificationSmsFragment paramMobileVerificationSmsFragment)
  {
    paramMobileVerificationSmsFragment.mBus = ((Bus)this.mBus.get());
    paramMobileVerificationSmsFragment.mRiderClient = ((RiderClient)this.mRiderClient.get());
    paramMobileVerificationSmsFragment.mActionBar = ((ActionBar)this.mActionBar.get());
    this.supertype.injectMembers(paramMobileVerificationSmsFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.verification.MobileVerificationSmsFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */