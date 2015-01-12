package com.ubercab.client.feature.payment;

import android.content.res.Resources;
import android.net.Uri;
import com.braintreegateway.encryption.Braintree;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.ubercab.client.core.app.RiderPreferences;
import com.ubercab.client.core.module.RiderActivityModule;
import com.ubercab.client.core.vendor.google.GoogleWalletActivity;
import com.ubercab.client.feature.payment.expense.ExpenseLinkResources;
import com.ubercab.client.feature.signup.SignupActivity;
import com.ubercab.client.feature.signup.SignupPaymentFragment;
import dagger.Module;
import dagger.Provides;

@Module(addsTo=RiderActivityModule.class, injects={AddFundsActivity.class, AddFundsFragment.class, AddPaymentActivity.class, AddPaymentFragment.class, EditCreditCardFragment.class, EditDelegatePaymentProfileFragment.class, EditThirdPartyPaymentProviderFragment.class, EditWalletPaymentFragment.class, ExpenseLinkResources.class, GoogleWalletActivity.class, PaymentActivity.class, RewardInfoActivity.class, RewardInfoFragment.class, SignupActivity.class, SignupPaymentFragment.class})
public class PaymentModule
{
  @Provides
  UberBraintree provideBraintree(RiderPreferences paramRiderPreferences, Resources paramResources)
  {
    if (paramRiderPreferences.isUseBraintreeDevKey())
      return new UberBraintree(new Braintree(paramResources.getString(2131559122)));
    return new UberBraintree(new Braintree(paramResources.getString(2131559123)));
  }

  @Provides
  PayPalConfiguration providePayPalConfiguration(RiderPreferences paramRiderPreferences, Resources paramResources)
  {
    Uri localUri1 = Uri.parse(paramResources.getString(2131559301));
    Uri localUri2 = Uri.parse(paramResources.getString(2131559300));
    String str1 = paramResources.getString(2131559299);
    PayPalConfiguration localPayPalConfiguration = new PayPalConfiguration().merchantName(str1).merchantPrivacyPolicyUri(localUri2).merchantUserAgreementUri(localUri1);
    String str2 = paramRiderPreferences.getPayPalEnvironment();
    if (str2.equals("live"))
    {
      String str4 = paramResources.getString(2131559297);
      localPayPalConfiguration.environment("live");
      localPayPalConfiguration.clientId(str4);
      return localPayPalConfiguration;
    }
    if (str2.equals("sandbox"))
    {
      String str3 = paramResources.getString(2131559298);
      localPayPalConfiguration.environment("sandbox");
      localPayPalConfiguration.clientId(str3);
      return localPayPalConfiguration;
    }
    localPayPalConfiguration.environment("mock");
    localPayPalConfiguration.clientId("");
    return localPayPalConfiguration;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.PaymentModule
 * JD-Core Version:    0.6.2
 */