package com.ubercab.client.feature.payment;

import com.ubercab.client.core.content.PingProvider;
import com.ubercab.geo.GeoManager;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class AddPaymentActivity$$InjectAdapter extends Binding<AddPaymentActivity>
  implements Provider<AddPaymentActivity>, MembersInjector<AddPaymentActivity>
{
  private Binding<GeoManager> mGeoManager;
  private Binding<PingProvider> mPingProvider;
  private Binding<PaymentBaseActivity> supertype;

  public AddPaymentActivity$$InjectAdapter()
  {
    super("com.ubercab.client.feature.payment.AddPaymentActivity", "members/com.ubercab.client.feature.payment.AddPaymentActivity", false, AddPaymentActivity.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mGeoManager = paramLinker.requestBinding("com.ubercab.geo.GeoManager", AddPaymentActivity.class, getClass().getClassLoader());
    this.mPingProvider = paramLinker.requestBinding("com.ubercab.client.core.content.PingProvider", AddPaymentActivity.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.feature.payment.PaymentBaseActivity", AddPaymentActivity.class, getClass().getClassLoader(), false, true);
  }

  public AddPaymentActivity get()
  {
    AddPaymentActivity localAddPaymentActivity = new AddPaymentActivity();
    injectMembers(localAddPaymentActivity);
    return localAddPaymentActivity;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mGeoManager);
    paramSet2.add(this.mPingProvider);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(AddPaymentActivity paramAddPaymentActivity)
  {
    paramAddPaymentActivity.mGeoManager = ((GeoManager)this.mGeoManager.get());
    paramAddPaymentActivity.mPingProvider = ((PingProvider)this.mPingProvider.get());
    this.supertype.injectMembers(paramAddPaymentActivity);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.AddPaymentActivity..InjectAdapter
 * JD-Core Version:    0.6.2
 */