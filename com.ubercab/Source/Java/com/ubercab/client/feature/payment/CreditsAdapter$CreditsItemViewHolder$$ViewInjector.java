package com.ubercab.client.feature.payment;

import android.widget.Switch;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberTextView;

public class CreditsAdapter$CreditsItemViewHolder$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, CreditsAdapter.CreditsItemViewHolder paramCreditsItemViewHolder, Object paramObject)
  {
    paramCreditsItemViewHolder.mTextViewCredit = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427619, "field 'mTextViewCredit'"));
    paramCreditsItemViewHolder.mSwitchUseCredits = ((Switch)paramFinder.findRequiredView(paramObject, 2131427620, "field 'mSwitchUseCredits'"));
  }

  public static void reset(CreditsAdapter.CreditsItemViewHolder paramCreditsItemViewHolder)
  {
    paramCreditsItemViewHolder.mTextViewCredit = null;
    paramCreditsItemViewHolder.mSwitchUseCredits = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.CreditsAdapter.CreditsItemViewHolder..ViewInjector
 * JD-Core Version:    0.6.2
 */