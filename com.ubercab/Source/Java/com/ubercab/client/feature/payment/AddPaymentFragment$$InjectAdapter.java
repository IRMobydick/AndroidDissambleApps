package com.ubercab.client.feature.payment;

import android.app.ActionBar;
import android.content.Context;
import com.squareup.otto.Bus;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.geo.GeoManager;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class AddPaymentFragment$$InjectAdapter extends Binding<AddPaymentFragment>
  implements Provider<AddPaymentFragment>, MembersInjector<AddPaymentFragment>
{
  private Binding<ActionBar> mActionBar;
  private Binding<AnalyticsClient> mAnalyticsClient;
  private Binding<UberBraintree> mBraintree;
  private Binding<Bus> mBus;
  private Binding<Context> mContext;
  private Binding<GeoManager> mGeoManager;
  private Binding<RiderClient> mRiderClient;
  private Binding<RiderFragment> supertype;

  public AddPaymentFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.payment.AddPaymentFragment", "members/com.ubercab.client.feature.payment.AddPaymentFragment", false, AddPaymentFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", AddPaymentFragment.class, getClass().getClassLoader());
    this.mRiderClient = paramLinker.requestBinding("com.ubercab.client.core.network.RiderClient", AddPaymentFragment.class, getClass().getClassLoader());
    this.mActionBar = paramLinker.requestBinding("android.app.ActionBar", AddPaymentFragment.class, getClass().getClassLoader());
    this.mBraintree = paramLinker.requestBinding("com.ubercab.client.feature.payment.UberBraintree", AddPaymentFragment.class, getClass().getClassLoader());
    this.mGeoManager = paramLinker.requestBinding("com.ubercab.geo.GeoManager", AddPaymentFragment.class, getClass().getClassLoader());
    this.mContext = paramLinker.requestBinding("@com.ubercab.library.app.annotation.ForActivity()/android.content.Context", AddPaymentFragment.class, getClass().getClassLoader());
    this.mAnalyticsClient = paramLinker.requestBinding("com.ubercab.library.metrics.analytics.AnalyticsClient", AddPaymentFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderFragment", AddPaymentFragment.class, getClass().getClassLoader(), false, true);
  }

  public AddPaymentFragment get()
  {
    AddPaymentFragment localAddPaymentFragment = new AddPaymentFragment();
    injectMembers(localAddPaymentFragment);
    return localAddPaymentFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mBus);
    paramSet2.add(this.mRiderClient);
    paramSet2.add(this.mActionBar);
    paramSet2.add(this.mBraintree);
    paramSet2.add(this.mGeoManager);
    paramSet2.add(this.mContext);
    paramSet2.add(this.mAnalyticsClient);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(AddPaymentFragment paramAddPaymentFragment)
  {
    paramAddPaymentFragment.mBus = ((Bus)this.mBus.get());
    paramAddPaymentFragment.mRiderClient = ((RiderClient)this.mRiderClient.get());
    paramAddPaymentFragment.mActionBar = ((ActionBar)this.mActionBar.get());
    paramAddPaymentFragment.mBraintree = ((UberBraintree)this.mBraintree.get());
    paramAddPaymentFragment.mGeoManager = ((GeoManager)this.mGeoManager.get());
    paramAddPaymentFragment.mContext = ((Context)this.mContext.get());
    paramAddPaymentFragment.mAnalyticsClient = ((AnalyticsClient)this.mAnalyticsClient.get());
    this.supertype.injectMembers(paramAddPaymentFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.AddPaymentFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */