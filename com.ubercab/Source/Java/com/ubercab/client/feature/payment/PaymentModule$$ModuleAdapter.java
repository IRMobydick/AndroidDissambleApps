package com.ubercab.client.feature.payment;

import android.content.res.Resources;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.ubercab.client.core.app.RiderPreferences;
import dagger.internal.Binding;
import dagger.internal.BindingsGroup;
import dagger.internal.Linker;
import dagger.internal.ModuleAdapter;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import javax.inject.Provider;

public final class PaymentModule$$ModuleAdapter extends ModuleAdapter<PaymentModule>
{
  private static final Class<?>[] INCLUDES = new Class[0];
  private static final String[] INJECTS = { "members/com.ubercab.client.feature.payment.AddFundsActivity", "members/com.ubercab.client.feature.payment.AddFundsFragment", "members/com.ubercab.client.feature.payment.AddPaymentActivity", "members/com.ubercab.client.feature.payment.AddPaymentFragment", "members/com.ubercab.client.feature.payment.EditCreditCardFragment", "members/com.ubercab.client.feature.payment.EditDelegatePaymentProfileFragment", "members/com.ubercab.client.feature.payment.EditThirdPartyPaymentProviderFragment", "members/com.ubercab.client.feature.payment.EditWalletPaymentFragment", "members/com.ubercab.client.feature.payment.expense.ExpenseLinkResources", "members/com.ubercab.client.core.vendor.google.GoogleWalletActivity", "members/com.ubercab.client.feature.payment.PaymentActivity", "members/com.ubercab.client.feature.payment.RewardInfoActivity", "members/com.ubercab.client.feature.payment.RewardInfoFragment", "members/com.ubercab.client.feature.signup.SignupActivity", "members/com.ubercab.client.feature.signup.SignupPaymentFragment" };
  private static final Class<?>[] STATIC_INJECTIONS = new Class[0];

  public PaymentModule$$ModuleAdapter()
  {
    super(PaymentModule.class, INJECTS, STATIC_INJECTIONS, false, INCLUDES, true, false);
  }

  public void getBindings(BindingsGroup paramBindingsGroup, PaymentModule paramPaymentModule)
  {
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.client.feature.payment.UberBraintree", new ProvideBraintreeProvidesAdapter(paramPaymentModule));
    paramBindingsGroup.contributeProvidesBinding("com.paypal.android.sdk.payments.PayPalConfiguration", new ProvidePayPalConfigurationProvidesAdapter(paramPaymentModule));
  }

  public PaymentModule newModule()
  {
    return new PaymentModule();
  }

  public static final class ProvideBraintreeProvidesAdapter extends ProvidesBinding<UberBraintree>
    implements Provider<UberBraintree>
  {
    private final PaymentModule module;
    private Binding<RiderPreferences> preferences;
    private Binding<Resources> resources;

    public ProvideBraintreeProvidesAdapter(PaymentModule paramPaymentModule)
    {
      super(false, "com.ubercab.client.feature.payment.PaymentModule", "provideBraintree");
      this.module = paramPaymentModule;
      setLibrary(false);
    }

    public void attach(Linker paramLinker)
    {
      this.preferences = paramLinker.requestBinding("com.ubercab.client.core.app.RiderPreferences", PaymentModule.class, getClass().getClassLoader());
      this.resources = paramLinker.requestBinding("android.content.res.Resources", PaymentModule.class, getClass().getClassLoader());
    }

    public UberBraintree get()
    {
      return this.module.provideBraintree((RiderPreferences)this.preferences.get(), (Resources)this.resources.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.preferences);
      paramSet1.add(this.resources);
    }
  }

  public static final class ProvidePayPalConfigurationProvidesAdapter extends ProvidesBinding<PayPalConfiguration>
    implements Provider<PayPalConfiguration>
  {
    private final PaymentModule module;
    private Binding<RiderPreferences> preferences;
    private Binding<Resources> resources;

    public ProvidePayPalConfigurationProvidesAdapter(PaymentModule paramPaymentModule)
    {
      super(false, "com.ubercab.client.feature.payment.PaymentModule", "providePayPalConfiguration");
      this.module = paramPaymentModule;
      setLibrary(false);
    }

    public void attach(Linker paramLinker)
    {
      this.preferences = paramLinker.requestBinding("com.ubercab.client.core.app.RiderPreferences", PaymentModule.class, getClass().getClassLoader());
      this.resources = paramLinker.requestBinding("android.content.res.Resources", PaymentModule.class, getClass().getClassLoader());
    }

    public PayPalConfiguration get()
    {
      return this.module.providePayPalConfiguration((RiderPreferences)this.preferences.get(), (Resources)this.resources.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.preferences);
      paramSet1.add(this.resources);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.PaymentModule..ModuleAdapter
 * JD-Core Version:    0.6.2
 */