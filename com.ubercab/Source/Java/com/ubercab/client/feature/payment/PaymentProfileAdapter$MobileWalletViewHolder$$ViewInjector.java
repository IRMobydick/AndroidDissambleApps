package com.ubercab.client.feature.payment;

import android.widget.ProgressBar;
import android.widget.RadioButton;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberTextView;

public class PaymentProfileAdapter$MobileWalletViewHolder$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, PaymentProfileAdapter.MobileWalletViewHolder paramMobileWalletViewHolder, Object paramObject)
  {
    paramMobileWalletViewHolder.mRadioButtonItem = ((RadioButton)paramFinder.findRequiredView(paramObject, 2131427623, "field 'mRadioButtonItem'"));
    paramMobileWalletViewHolder.mProgressBarCurrentBalanceRequest = ((ProgressBar)paramFinder.findRequiredView(paramObject, 2131427584, "field 'mProgressBarCurrentBalanceRequest'"));
    paramMobileWalletViewHolder.mTextViewCurrentBalanceValue = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427583, "field 'mTextViewCurrentBalanceValue'"));
    paramMobileWalletViewHolder.mTextViewProfile = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427622, "field 'mTextViewProfile'"));
  }

  public static void reset(PaymentProfileAdapter.MobileWalletViewHolder paramMobileWalletViewHolder)
  {
    paramMobileWalletViewHolder.mRadioButtonItem = null;
    paramMobileWalletViewHolder.mProgressBarCurrentBalanceRequest = null;
    paramMobileWalletViewHolder.mTextViewCurrentBalanceValue = null;
    paramMobileWalletViewHolder.mTextViewProfile = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.PaymentProfileAdapter.MobileWalletViewHolder..ViewInjector
 * JD-Core Version:    0.6.2
 */