package com.ubercab.client.feature.payment;

import android.app.ActionBar;
import android.view.LayoutInflater;
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

public final class EditCreditCardFragment$$InjectAdapter extends Binding<EditCreditCardFragment>
  implements Provider<EditCreditCardFragment>, MembersInjector<EditCreditCardFragment>
{
  private Binding<ActionBar> mActionBar;
  private Binding<AnalyticsClient> mAnalyticsClient;
  private Binding<UberBraintree> mBraintree;
  private Binding<Bus> mBus;
  private Binding<DeletePaymentDialogPresenter> mDeletePaymentDialogPresenter;
  private Binding<LayoutInflater> mLayoutInflater;
  private Binding<PingProvider> mPingProvider;
  private Binding<RiderClient> mRiderClient;
  private Binding<RiderFragment> supertype;

  public EditCreditCardFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.payment.EditCreditCardFragment", "members/com.ubercab.client.feature.payment.EditCreditCardFragment", false, EditCreditCardFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mAnalyticsClient = paramLinker.requestBinding("com.ubercab.library.metrics.analytics.AnalyticsClient", EditCreditCardFragment.class, getClass().getClassLoader());
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", EditCreditCardFragment.class, getClass().getClassLoader());
    this.mRiderClient = paramLinker.requestBinding("com.ubercab.client.core.network.RiderClient", EditCreditCardFragment.class, getClass().getClassLoader());
    this.mBraintree = paramLinker.requestBinding("com.ubercab.client.feature.payment.UberBraintree", EditCreditCardFragment.class, getClass().getClassLoader());
    this.mActionBar = paramLinker.requestBinding("android.app.ActionBar", EditCreditCardFragment.class, getClass().getClassLoader());
    this.mPingProvider = paramLinker.requestBinding("com.ubercab.client.core.content.PingProvider", EditCreditCardFragment.class, getClass().getClassLoader());
    this.mLayoutInflater = paramLinker.requestBinding("android.view.LayoutInflater", EditCreditCardFragment.class, getClass().getClassLoader());
    this.mDeletePaymentDialogPresenter = paramLinker.requestBinding("com.ubercab.client.feature.payment.DeletePaymentDialogPresenter", EditCreditCardFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderFragment", EditCreditCardFragment.class, getClass().getClassLoader(), false, true);
  }

  public EditCreditCardFragment get()
  {
    EditCreditCardFragment localEditCreditCardFragment = new EditCreditCardFragment();
    injectMembers(localEditCreditCardFragment);
    return localEditCreditCardFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mAnalyticsClient);
    paramSet2.add(this.mBus);
    paramSet2.add(this.mRiderClient);
    paramSet2.add(this.mBraintree);
    paramSet2.add(this.mActionBar);
    paramSet2.add(this.mPingProvider);
    paramSet2.add(this.mLayoutInflater);
    paramSet2.add(this.mDeletePaymentDialogPresenter);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(EditCreditCardFragment paramEditCreditCardFragment)
  {
    paramEditCreditCardFragment.mAnalyticsClient = ((AnalyticsClient)this.mAnalyticsClient.get());
    paramEditCreditCardFragment.mBus = ((Bus)this.mBus.get());
    paramEditCreditCardFragment.mRiderClient = ((RiderClient)this.mRiderClient.get());
    paramEditCreditCardFragment.mBraintree = ((UberBraintree)this.mBraintree.get());
    paramEditCreditCardFragment.mActionBar = ((ActionBar)this.mActionBar.get());
    paramEditCreditCardFragment.mPingProvider = ((PingProvider)this.mPingProvider.get());
    paramEditCreditCardFragment.mLayoutInflater = ((LayoutInflater)this.mLayoutInflater.get());
    paramEditCreditCardFragment.mDeletePaymentDialogPresenter = ((DeletePaymentDialogPresenter)this.mDeletePaymentDialogPresenter.get());
    this.supertype.injectMembers(paramEditCreditCardFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.EditCreditCardFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */