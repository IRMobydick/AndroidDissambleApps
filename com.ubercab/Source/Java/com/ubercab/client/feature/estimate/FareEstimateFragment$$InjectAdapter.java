package com.ubercab.client.feature.estimate;

import android.app.ActionBar;
import com.squareup.otto.Bus;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.client.core.network.RiderClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class FareEstimateFragment$$InjectAdapter extends Binding<FareEstimateFragment>
  implements Provider<FareEstimateFragment>, MembersInjector<FareEstimateFragment>
{
  private Binding<ActionBar> mActionBar;
  private Binding<Bus> mBus;
  private Binding<RiderClient> mRiderClient;
  private Binding<SessionPreferences> mSessionPreferences;
  private Binding<RiderFragment> supertype;

  public FareEstimateFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.estimate.FareEstimateFragment", "members/com.ubercab.client.feature.estimate.FareEstimateFragment", false, FareEstimateFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", FareEstimateFragment.class, getClass().getClassLoader());
    this.mRiderClient = paramLinker.requestBinding("com.ubercab.client.core.network.RiderClient", FareEstimateFragment.class, getClass().getClassLoader());
    this.mSessionPreferences = paramLinker.requestBinding("com.ubercab.client.core.content.SessionPreferences", FareEstimateFragment.class, getClass().getClassLoader());
    this.mActionBar = paramLinker.requestBinding("android.app.ActionBar", FareEstimateFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderFragment", FareEstimateFragment.class, getClass().getClassLoader(), false, true);
  }

  public FareEstimateFragment get()
  {
    FareEstimateFragment localFareEstimateFragment = new FareEstimateFragment();
    injectMembers(localFareEstimateFragment);
    return localFareEstimateFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mBus);
    paramSet2.add(this.mRiderClient);
    paramSet2.add(this.mSessionPreferences);
    paramSet2.add(this.mActionBar);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(FareEstimateFragment paramFareEstimateFragment)
  {
    paramFareEstimateFragment.mBus = ((Bus)this.mBus.get());
    paramFareEstimateFragment.mRiderClient = ((RiderClient)this.mRiderClient.get());
    paramFareEstimateFragment.mSessionPreferences = ((SessionPreferences)this.mSessionPreferences.get());
    paramFareEstimateFragment.mActionBar = ((ActionBar)this.mActionBar.get());
    this.supertype.injectMembers(paramFareEstimateFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.estimate.FareEstimateFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */