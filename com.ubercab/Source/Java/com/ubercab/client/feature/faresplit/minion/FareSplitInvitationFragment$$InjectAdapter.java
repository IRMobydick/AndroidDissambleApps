package com.ubercab.client.feature.faresplit.minion;

import com.squareup.picasso.Picasso;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.app.RiderDialogFragment;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class FareSplitInvitationFragment$$InjectAdapter extends Binding<FareSplitInvitationFragment>
  implements Provider<FareSplitInvitationFragment>, MembersInjector<FareSplitInvitationFragment>
{
  private Binding<AnalyticsClient> mAnalyticsClient;
  private Binding<AnalyticsManager> mAnalyticsManager;
  private Binding<Picasso> mPicasso;
  private Binding<RiderClient> mRiderClient;
  private Binding<RiderDialogFragment> supertype;

  public FareSplitInvitationFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.faresplit.minion.FareSplitInvitationFragment", "members/com.ubercab.client.feature.faresplit.minion.FareSplitInvitationFragment", false, FareSplitInvitationFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mAnalyticsClient = paramLinker.requestBinding("com.ubercab.library.metrics.analytics.AnalyticsClient", FareSplitInvitationFragment.class, getClass().getClassLoader());
    this.mRiderClient = paramLinker.requestBinding("com.ubercab.client.core.network.RiderClient", FareSplitInvitationFragment.class, getClass().getClassLoader());
    this.mPicasso = paramLinker.requestBinding("com.squareup.picasso.Picasso", FareSplitInvitationFragment.class, getClass().getClassLoader());
    this.mAnalyticsManager = paramLinker.requestBinding("com.ubercab.client.core.analytics.AnalyticsManager", FareSplitInvitationFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderDialogFragment", FareSplitInvitationFragment.class, getClass().getClassLoader(), false, true);
  }

  public FareSplitInvitationFragment get()
  {
    FareSplitInvitationFragment localFareSplitInvitationFragment = new FareSplitInvitationFragment();
    injectMembers(localFareSplitInvitationFragment);
    return localFareSplitInvitationFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mAnalyticsClient);
    paramSet2.add(this.mRiderClient);
    paramSet2.add(this.mPicasso);
    paramSet2.add(this.mAnalyticsManager);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(FareSplitInvitationFragment paramFareSplitInvitationFragment)
  {
    paramFareSplitInvitationFragment.mAnalyticsClient = ((AnalyticsClient)this.mAnalyticsClient.get());
    paramFareSplitInvitationFragment.mRiderClient = ((RiderClient)this.mRiderClient.get());
    paramFareSplitInvitationFragment.mPicasso = ((Picasso)this.mPicasso.get());
    paramFareSplitInvitationFragment.mAnalyticsManager = ((AnalyticsManager)this.mAnalyticsManager.get());
    this.supertype.injectMembers(paramFareSplitInvitationFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.faresplit.minion.FareSplitInvitationFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */