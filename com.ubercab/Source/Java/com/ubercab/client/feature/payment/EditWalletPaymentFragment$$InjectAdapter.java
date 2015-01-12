package com.ubercab.client.feature.payment;

import android.app.ActionBar;
import android.content.Context;
import com.squareup.otto.Bus;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.network.PaymentClient;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class EditWalletPaymentFragment$$InjectAdapter extends Binding<EditWalletPaymentFragment>
  implements Provider<EditWalletPaymentFragment>, MembersInjector<EditWalletPaymentFragment>
{
  private Binding<ActionBar> mActionBar;
  private Binding<AnalyticsClient> mAnalyticsClient;
  private Binding<Bus> mBus;
  private Binding<Context> mContext;
  private Binding<DeletePaymentDialogPresenter> mDeletePaymentDialogPresenter;
  private Binding<PaymentClient> mPaymentClient;
  private Binding<RiderClient> mRiderClient;
  private Binding<RiderFragment> supertype;

  public EditWalletPaymentFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.payment.EditWalletPaymentFragment", "members/com.ubercab.client.feature.payment.EditWalletPaymentFragment", false, EditWalletPaymentFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mActionBar = paramLinker.requestBinding("android.app.ActionBar", EditWalletPaymentFragment.class, getClass().getClassLoader());
    this.mAnalyticsClient = paramLinker.requestBinding("com.ubercab.library.metrics.analytics.AnalyticsClient", EditWalletPaymentFragment.class, getClass().getClassLoader());
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", EditWalletPaymentFragment.class, getClass().getClassLoader());
    this.mContext = paramLinker.requestBinding("android.content.Context", EditWalletPaymentFragment.class, getClass().getClassLoader());
    this.mDeletePaymentDialogPresenter = paramLinker.requestBinding("com.ubercab.client.feature.payment.DeletePaymentDialogPresenter", EditWalletPaymentFragment.class, getClass().getClassLoader());
    this.mPaymentClient = paramLinker.requestBinding("com.ubercab.client.core.network.PaymentClient", EditWalletPaymentFragment.class, getClass().getClassLoader());
    this.mRiderClient = paramLinker.requestBinding("com.ubercab.client.core.network.RiderClient", EditWalletPaymentFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderFragment", EditWalletPaymentFragment.class, getClass().getClassLoader(), false, true);
  }

  public EditWalletPaymentFragment get()
  {
    EditWalletPaymentFragment localEditWalletPaymentFragment = new EditWalletPaymentFragment();
    injectMembers(localEditWalletPaymentFragment);
    return localEditWalletPaymentFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mActionBar);
    paramSet2.add(this.mAnalyticsClient);
    paramSet2.add(this.mBus);
    paramSet2.add(this.mContext);
    paramSet2.add(this.mDeletePaymentDialogPresenter);
    paramSet2.add(this.mPaymentClient);
    paramSet2.add(this.mRiderClient);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(EditWalletPaymentFragment paramEditWalletPaymentFragment)
  {
    paramEditWalletPaymentFragment.mActionBar = ((ActionBar)this.mActionBar.get());
    paramEditWalletPaymentFragment.mAnalyticsClient = ((AnalyticsClient)this.mAnalyticsClient.get());
    paramEditWalletPaymentFragment.mBus = ((Bus)this.mBus.get());
    paramEditWalletPaymentFragment.mContext = ((Context)this.mContext.get());
    paramEditWalletPaymentFragment.mDeletePaymentDialogPresenter = ((DeletePaymentDialogPresenter)this.mDeletePaymentDialogPresenter.get());
    paramEditWalletPaymentFragment.mPaymentClient = ((PaymentClient)this.mPaymentClient.get());
    paramEditWalletPaymentFragment.mRiderClient = ((RiderClient)this.mRiderClient.get());
    this.supertype.injectMembers(paramEditWalletPaymentFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.EditWalletPaymentFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */