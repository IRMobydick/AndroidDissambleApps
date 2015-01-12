package com.ubercab.client.core.module;

import android.app.ActionBar;
import android.content.Context;
import android.view.LayoutInflater;
import dagger.internal.BindingsGroup;
import dagger.internal.ModuleAdapter;
import dagger.internal.ProvidesBinding;
import javax.inject.Provider;

public final class RiderActivityModule$$ModuleAdapter extends ModuleAdapter<RiderActivityModule>
{
  private static final Class<?>[] INCLUDES = new Class[0];
  private static final String[] INJECTS = { "members/com.ubercab.client.feature.about.AboutFragment", "members/com.ubercab.client.feature.about.AboutLegalFragment", "members/com.ubercab.client.feature.payment.AddAlipayActivity", "members/com.ubercab.client.feature.payment.AddFundsWebViewFragment", "members/com.ubercab.client.feature.payment.ArrearsView", "members/com.ubercab.client.feature.trip.rates.BaseRateCardPopupWindow", "members/com.ubercab.client.feature.music.BrowseFragment", "members/com.ubercab.client.feature.payment.ChoosePaymentFragment", "members/com.ubercab.client.feature.payment.CreditsAdapter", "members/com.ubercab.client.feature.music.DisconnectMusicProviderActivity", "members/com.ubercab.client.feature.music.DisconnectMusicProviderFragment", "members/com.ubercab.client.feature.payment.EditPaymentProfileActivity", "members/com.ubercab.client.feature.payment.EditWalletPaymentFragment", "members/com.ubercab.client.feature.employeeupgrade.EmployeeUpgradeFragment", "members/com.ubercab.client.feature.payment.expense.ExpenseInfoActivity", "members/com.ubercab.client.feature.payment.expense.ExpenseInfoFragment", "members/com.ubercab.client.feature.estimate.FareEstimateActivity", "members/com.ubercab.client.feature.estimate.FareEstimateFragment", "members/com.ubercab.client.feature.faresplit.master.FareSplitInviteFragment", "members/com.ubercab.client.feature.faresplit.minion.FareSplitInvitationFragment", "members/com.ubercab.client.feature.faresplit.master.FareSplitSummaryFragment", "members/com.ubercab.client.feature.forceupgrade.ForceUpgradeActivity", "members/com.ubercab.client.feature.signup.LegalActivity", "members/com.ubercab.client.feature.legal.LegalFragment", "members/com.ubercab.client.feature.music.LinkMusicProviderActivity", "members/com.ubercab.client.feature.music.LinkMusicProviderFragment", "members/com.ubercab.client.feature.search.LocationSearchActivity", "members/com.ubercab.client.feature.search.LocationSearchFragment", "members/com.ubercab.client.feature.verification.MobileVerificationChangeNumberFragment", "members/com.ubercab.client.feature.verification.MobileVerificationSmsFragment", "members/com.ubercab.client.feature.verification.MobileVerificationTokenFragment", "members/com.ubercab.client.feature.music.MusicActivity", "members/com.ubercab.client.feature.music.MusicProviderOfferActivity", "members/com.ubercab.client.feature.about.OtherFragment", "members/com.ubercab.client.feature.payment.PaymentFragment", "members/com.ubercab.client.feature.payment.PaymentOtpFragment", "members/com.ubercab.client.feature.payment.PaymentProfileAdapter", "members/com.ubercab.client.feature.music.PlaylistFragment", "members/com.ubercab.client.feature.promo.PromoFragment", "members/com.ubercab.client.feature.profile.ProfileFragment", "members/com.ubercab.client.feature.trip.rates.RateCardPopupWindow", "members/com.ubercab.client.feature.trip.rates.RateCardV1PopupWindow", "members/com.ubercab.client.feature.trip.rates.RateCardV2PopupWindow", "members/com.ubercab.client.feature.receipt.ReceiptActivity", "members/com.ubercab.client.feature.receipt.ReceiptFragment", "members/com.ubercab.client.feature.estimate.RewardPointsFareEstimateFragment", "members/com.ubercab.client.core.locale.SelectCountryActivity", "members/com.ubercab.client.core.locale.SelectCountryFragment", "members/com.ubercab.client.feature.signup.SignupChoosePaymentFragment", "members/com.ubercab.client.feature.signup.SignupGoogleActivity", "members/com.ubercab.client.feature.signup.SignupLegalFragment", "members/com.ubercab.client.feature.signup.SignupMissingInfoFragment", "members/com.ubercab.client.feature.signup.SignupFragment", "members/com.ubercab.client.feature.signup.SignupPaymentLastStepActivity", "members/com.ubercab.client.feature.signup.SignupPaymentLastStepFragment", "members/com.ubercab.client.feature.signup.SignupPaymentOtpActivity", "members/com.ubercab.client.feature.signup.SignupPaymentOtpFragment", "members/com.ubercab.client.feature.signup.SignupPendingFragment", "members/com.ubercab.client.feature.signup.SignupPromoFragment", "members/com.ubercab.client.feature.share.ShareFragment", "members/com.ubercab.client.feature.music.SpotifyInterstitialActivity", "members/com.ubercab.client.feature.music.SpotifyInterstitialFragment", "members/com.ubercab.client.feature.surge.SurgeActivity", "members/com.ubercab.client.feature.surge.SurgeFragment", "members/com.ubercab.client.feature.payment.TripBalancesActivity", "members/com.ubercab.client.feature.payment.TripBalancesFragment", "members/com.ubercab.client.feature.payment.VerifyAlipayActivity", "members/com.ubercab.client.feature.signup.VerifyFacebookProfileFragment", "members/com.ubercab.client.feature.about.WebViewFragment" };
  private static final Class<?>[] STATIC_INJECTIONS = new Class[0];

  public RiderActivityModule$$ModuleAdapter()
  {
    super(RiderActivityModule.class, INJECTS, STATIC_INJECTIONS, false, INCLUDES, true, true);
  }

  public void getBindings(BindingsGroup paramBindingsGroup, RiderActivityModule paramRiderActivityModule)
  {
    paramBindingsGroup.contributeProvidesBinding("android.app.ActionBar", new ProvideActionBarProvidesAdapter(paramRiderActivityModule));
    paramBindingsGroup.contributeProvidesBinding("android.view.LayoutInflater", new ProvideLayoutInflaterProvidesAdapter(paramRiderActivityModule));
    paramBindingsGroup.contributeProvidesBinding("@com.ubercab.library.app.annotation.ForActivity()/android.content.Context", new ProvideActivityContextProvidesAdapter(paramRiderActivityModule));
  }

  public static final class ProvideActionBarProvidesAdapter extends ProvidesBinding<ActionBar>
    implements Provider<ActionBar>
  {
    private final RiderActivityModule module;

    public ProvideActionBarProvidesAdapter(RiderActivityModule paramRiderActivityModule)
    {
      super(true, "com.ubercab.client.core.module.RiderActivityModule", "provideActionBar");
      this.module = paramRiderActivityModule;
      setLibrary(true);
    }

    public ActionBar get()
    {
      return this.module.provideActionBar();
    }
  }

  public static final class ProvideActivityContextProvidesAdapter extends ProvidesBinding<Context>
    implements Provider<Context>
  {
    private final RiderActivityModule module;

    public ProvideActivityContextProvidesAdapter(RiderActivityModule paramRiderActivityModule)
    {
      super(true, "com.ubercab.client.core.module.RiderActivityModule", "provideActivityContext");
      this.module = paramRiderActivityModule;
      setLibrary(true);
    }

    public Context get()
    {
      return this.module.provideActivityContext();
    }
  }

  public static final class ProvideLayoutInflaterProvidesAdapter extends ProvidesBinding<LayoutInflater>
    implements Provider<LayoutInflater>
  {
    private final RiderActivityModule module;

    public ProvideLayoutInflaterProvidesAdapter(RiderActivityModule paramRiderActivityModule)
    {
      super(true, "com.ubercab.client.core.module.RiderActivityModule", "provideLayoutInflater");
      this.module = paramRiderActivityModule;
      setLibrary(true);
    }

    public LayoutInflater get()
    {
      return this.module.provideLayoutInflater();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.module.RiderActivityModule..ModuleAdapter
 * JD-Core Version:    0.6.2
 */