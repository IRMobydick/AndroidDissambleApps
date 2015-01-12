package com.ubercab.client.core.module;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import com.ubercab.client.core.locale.SelectCountryActivity;
import com.ubercab.client.core.locale.SelectCountryFragment;
import com.ubercab.client.feature.about.AboutFragment;
import com.ubercab.client.feature.about.AboutLegalFragment;
import com.ubercab.client.feature.about.OtherFragment;
import com.ubercab.client.feature.about.WebViewFragment;
import com.ubercab.client.feature.employeeupgrade.EmployeeUpgradeFragment;
import com.ubercab.client.feature.estimate.FareEstimateActivity;
import com.ubercab.client.feature.estimate.FareEstimateFragment;
import com.ubercab.client.feature.estimate.RewardPointsFareEstimateFragment;
import com.ubercab.client.feature.faresplit.master.FareSplitInviteFragment;
import com.ubercab.client.feature.faresplit.master.FareSplitSummaryFragment;
import com.ubercab.client.feature.faresplit.minion.FareSplitInvitationFragment;
import com.ubercab.client.feature.forceupgrade.ForceUpgradeActivity;
import com.ubercab.client.feature.legal.LegalFragment;
import com.ubercab.client.feature.music.BrowseFragment;
import com.ubercab.client.feature.music.DisconnectMusicProviderActivity;
import com.ubercab.client.feature.music.DisconnectMusicProviderFragment;
import com.ubercab.client.feature.music.LinkMusicProviderActivity;
import com.ubercab.client.feature.music.LinkMusicProviderFragment;
import com.ubercab.client.feature.music.MusicActivity;
import com.ubercab.client.feature.music.MusicProviderOfferActivity;
import com.ubercab.client.feature.music.PlaylistFragment;
import com.ubercab.client.feature.music.SpotifyInterstitialActivity;
import com.ubercab.client.feature.music.SpotifyInterstitialFragment;
import com.ubercab.client.feature.payment.AddAlipayActivity;
import com.ubercab.client.feature.payment.AddFundsWebViewFragment;
import com.ubercab.client.feature.payment.ArrearsView;
import com.ubercab.client.feature.payment.ChoosePaymentFragment;
import com.ubercab.client.feature.payment.CreditsAdapter;
import com.ubercab.client.feature.payment.EditPaymentProfileActivity;
import com.ubercab.client.feature.payment.EditWalletPaymentFragment;
import com.ubercab.client.feature.payment.PaymentFragment;
import com.ubercab.client.feature.payment.PaymentOtpFragment;
import com.ubercab.client.feature.payment.PaymentProfileAdapter;
import com.ubercab.client.feature.payment.TripBalancesActivity;
import com.ubercab.client.feature.payment.TripBalancesFragment;
import com.ubercab.client.feature.payment.VerifyAlipayActivity;
import com.ubercab.client.feature.payment.expense.ExpenseInfoActivity;
import com.ubercab.client.feature.payment.expense.ExpenseInfoFragment;
import com.ubercab.client.feature.profile.ProfileFragment;
import com.ubercab.client.feature.promo.PromoFragment;
import com.ubercab.client.feature.receipt.ReceiptActivity;
import com.ubercab.client.feature.receipt.ReceiptFragment;
import com.ubercab.client.feature.search.LocationSearchActivity;
import com.ubercab.client.feature.search.LocationSearchFragment;
import com.ubercab.client.feature.share.ShareFragment;
import com.ubercab.client.feature.signup.LegalActivity;
import com.ubercab.client.feature.signup.SignupChoosePaymentFragment;
import com.ubercab.client.feature.signup.SignupFragment;
import com.ubercab.client.feature.signup.SignupGoogleActivity;
import com.ubercab.client.feature.signup.SignupLegalFragment;
import com.ubercab.client.feature.signup.SignupMissingInfoFragment;
import com.ubercab.client.feature.signup.SignupPaymentLastStepActivity;
import com.ubercab.client.feature.signup.SignupPaymentLastStepFragment;
import com.ubercab.client.feature.signup.SignupPaymentOtpActivity;
import com.ubercab.client.feature.signup.SignupPaymentOtpFragment;
import com.ubercab.client.feature.signup.SignupPendingFragment;
import com.ubercab.client.feature.signup.SignupPromoFragment;
import com.ubercab.client.feature.signup.VerifyFacebookProfileFragment;
import com.ubercab.client.feature.surge.SurgeActivity;
import com.ubercab.client.feature.surge.SurgeFragment;
import com.ubercab.client.feature.trip.rates.BaseRateCardPopupWindow;
import com.ubercab.client.feature.trip.rates.RateCardPopupWindow;
import com.ubercab.client.feature.trip.rates.RateCardV1PopupWindow;
import com.ubercab.client.feature.trip.rates.RateCardV2PopupWindow;
import com.ubercab.client.feature.verification.MobileVerificationChangeNumberFragment;
import com.ubercab.client.feature.verification.MobileVerificationSmsFragment;
import com.ubercab.client.feature.verification.MobileVerificationTokenFragment;
import com.ubercab.library.app.annotation.ForActivity;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module(addsTo=RiderApplicationModule.class, injects={AboutFragment.class, AboutLegalFragment.class, AddAlipayActivity.class, AddFundsWebViewFragment.class, ArrearsView.class, BaseRateCardPopupWindow.class, BrowseFragment.class, ChoosePaymentFragment.class, CreditsAdapter.class, DisconnectMusicProviderActivity.class, DisconnectMusicProviderFragment.class, EditPaymentProfileActivity.class, EditWalletPaymentFragment.class, EmployeeUpgradeFragment.class, ExpenseInfoActivity.class, ExpenseInfoFragment.class, FareEstimateActivity.class, FareEstimateFragment.class, FareSplitInviteFragment.class, FareSplitInvitationFragment.class, FareSplitSummaryFragment.class, ForceUpgradeActivity.class, LegalActivity.class, LegalFragment.class, LinkMusicProviderActivity.class, LinkMusicProviderFragment.class, LocationSearchActivity.class, LocationSearchFragment.class, MobileVerificationChangeNumberFragment.class, MobileVerificationSmsFragment.class, MobileVerificationTokenFragment.class, MusicActivity.class, MusicProviderOfferActivity.class, OtherFragment.class, PaymentFragment.class, PaymentOtpFragment.class, PaymentProfileAdapter.class, PlaylistFragment.class, PromoFragment.class, ProfileFragment.class, RateCardPopupWindow.class, RateCardV1PopupWindow.class, RateCardV2PopupWindow.class, ReceiptActivity.class, ReceiptFragment.class, RewardPointsFareEstimateFragment.class, SelectCountryActivity.class, SelectCountryFragment.class, SignupChoosePaymentFragment.class, SignupGoogleActivity.class, SignupLegalFragment.class, SignupMissingInfoFragment.class, SignupFragment.class, SignupPaymentLastStepActivity.class, SignupPaymentLastStepFragment.class, SignupPaymentOtpActivity.class, SignupPaymentOtpFragment.class, SignupPendingFragment.class, SignupPromoFragment.class, ShareFragment.class, SpotifyInterstitialActivity.class, SpotifyInterstitialFragment.class, SurgeActivity.class, SurgeFragment.class, TripBalancesActivity.class, TripBalancesFragment.class, VerifyAlipayActivity.class, VerifyFacebookProfileFragment.class, WebViewFragment.class}, library=true)
public final class RiderActivityModule
{
  private final Activity mActivity;

  public RiderActivityModule(Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }

  @Provides
  @Singleton
  ActionBar provideActionBar()
  {
    return this.mActivity.getActionBar();
  }

  @ForActivity
  @Provides
  @Singleton
  Context provideActivityContext()
  {
    return this.mActivity;
  }

  @Provides
  @Singleton
  LayoutInflater provideLayoutInflater()
  {
    return LayoutInflater.from(this.mActivity);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.module.RiderActivityModule
 * JD-Core Version:    0.6.2
 */