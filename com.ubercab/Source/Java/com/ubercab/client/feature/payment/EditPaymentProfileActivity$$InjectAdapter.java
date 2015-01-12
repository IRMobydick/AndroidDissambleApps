package com.ubercab.client.feature.payment;

import com.ubercab.client.core.content.PingProvider;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class EditPaymentProfileActivity$$InjectAdapter extends Binding<EditPaymentProfileActivity>
  implements Provider<EditPaymentProfileActivity>, MembersInjector<EditPaymentProfileActivity>
{
  private Binding<AnalyticsClient> mAnalyticsClient;
  private Binding<PingProvider> mPingProvider;
  private Binding<PaymentBaseActivity> supertype;

  public EditPaymentProfileActivity$$InjectAdapter()
  {
    super("com.ubercab.client.feature.payment.EditPaymentProfileActivity", "members/com.ubercab.client.feature.payment.EditPaymentProfileActivity", false, EditPaymentProfileActivity.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mAnalyticsClient = paramLinker.requestBinding("com.ubercab.library.metrics.analytics.AnalyticsClient", EditPaymentProfileActivity.class, getClass().getClassLoader());
    this.mPingProvider = paramLinker.requestBinding("com.ubercab.client.core.content.PingProvider", EditPaymentProfileActivity.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.feature.payment.PaymentBaseActivity", EditPaymentProfileActivity.class, getClass().getClassLoader(), false, true);
  }

  public EditPaymentProfileActivity get()
  {
    EditPaymentProfileActivity localEditPaymentProfileActivity = new EditPaymentProfileActivity();
    injectMembers(localEditPaymentProfileActivity);
    return localEditPaymentProfileActivity;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mAnalyticsClient);
    paramSet2.add(this.mPingProvider);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(EditPaymentProfileActivity paramEditPaymentProfileActivity)
  {
    paramEditPaymentProfileActivity.mAnalyticsClient = ((AnalyticsClient)this.mAnalyticsClient.get());
    paramEditPaymentProfileActivity.mPingProvider = ((PingProvider)this.mPingProvider.get());
    this.supertype.injectMembers(paramEditPaymentProfileActivity);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.EditPaymentProfileActivity..InjectAdapter
 * JD-Core Version:    0.6.2
 */