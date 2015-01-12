package com.ubercab.client.feature.payment;

import android.app.ActionBar;
import com.squareup.otto.Bus;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class EditThirdPartyPaymentProviderFragment$$InjectAdapter extends Binding<EditThirdPartyPaymentProviderFragment>
  implements Provider<EditThirdPartyPaymentProviderFragment>, MembersInjector<EditThirdPartyPaymentProviderFragment>
{
  private Binding<ActionBar> mActionBar;
  private Binding<AnalyticsClient> mAnalyticsClient;
  private Binding<Bus> mBus;
  private Binding<DeletePaymentDialogPresenter> mDeletePaymentDialogPresenter;
  private Binding<PingProvider> mPingProvider;
  private Binding<RiderClient> mRiderClient;
  private Binding<RiderFragment> supertype;

  public EditThirdPartyPaymentProviderFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.payment.EditThirdPartyPaymentProviderFragment", "members/com.ubercab.client.feature.payment.EditThirdPartyPaymentProviderFragment", false, EditThirdPartyPaymentProviderFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mAnalyticsClient = paramLinker.requestBinding("com.ubercab.library.metrics.analytics.AnalyticsClient", EditThirdPartyPaymentProviderFragment.class, getClass().getClassLoader());
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", EditThirdPartyPaymentProviderFragment.class, getClass().getClassLoader());
    this.mRiderClient = paramLinker.requestBinding("com.ubercab.client.core.network.RiderClient", EditThirdPartyPaymentProviderFragment.class, getClass().getClassLoader());
    this.mActionBar = paramLinker.requestBinding("android.app.ActionBar", EditThirdPartyPaymentProviderFragment.class, getClass().getClassLoader());
    this.mPingProvider = paramLinker.requestBinding("com.ubercab.client.core.content.PingProvider", EditThirdPartyPaymentProviderFragment.class, getClass().getClassLoader());
    this.mDeletePaymentDialogPresenter = paramLinker.requestBinding("com.ubercab.client.feature.payment.DeletePaymentDialogPresenter", EditThirdPartyPaymentProviderFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderFragment", EditThirdPartyPaymentProviderFragment.class, getClass().getClassLoader(), false, true);
  }

  public EditThirdPartyPaymentProviderFragment get()
  {
    EditThirdPartyPaymentProviderFragment localEditThirdPartyPaymentProviderFragment = new EditThirdPartyPaymentProviderFragment();
    injectMembers(localEditThirdPartyPaymentProviderFragment);
    return localEditThirdPartyPaymentProviderFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mAnalyticsClient);
    paramSet2.add(this.mBus);
    paramSet2.add(this.mRiderClient);
    paramSet2.add(this.mActionBar);
    paramSet2.add(this.mPingProvider);
    paramSet2.add(this.mDeletePaymentDialogPresenter);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(EditThirdPartyPaymentProviderFragment paramEditThirdPartyPaymentProviderFragment)
  {
    paramEditThirdPartyPaymentProviderFragment.mAnalyticsClient = ((AnalyticsClient)this.mAnalyticsClient.get());
    paramEditThirdPartyPaymentProviderFragment.mBus = ((Bus)this.mBus.get());
    paramEditThirdPartyPaymentProviderFragment.mRiderClient = ((RiderClient)this.mRiderClient.get());
    paramEditThirdPartyPaymentProviderFragment.mActionBar = ((ActionBar)this.mActionBar.get());
    paramEditThirdPartyPaymentProviderFragment.mPingProvider = ((PingProvider)this.mPingProvider.get());
    paramEditThirdPartyPaymentProviderFragment.mDeletePaymentDialogPresenter = ((DeletePaymentDialogPresenter)this.mDeletePaymentDialogPresenter.get());
    this.supertype.injectMembers(paramEditThirdPartyPaymentProviderFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.EditThirdPartyPaymentProviderFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */