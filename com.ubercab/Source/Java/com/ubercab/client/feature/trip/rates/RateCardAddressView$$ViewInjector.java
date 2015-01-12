package com.ubercab.client.feature.trip.rates;

import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberTextView;

public class RateCardAddressView$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, RateCardAddressView paramRateCardAddressView, Object paramObject)
  {
    paramRateCardAddressView.mTextViewAddress = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427820, "field 'mTextViewAddress'"));
  }

  public static void reset(RateCardAddressView paramRateCardAddressView)
  {
    paramRateCardAddressView.mTextViewAddress = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.rates.RateCardAddressView..ViewInjector
 * JD-Core Version:    0.6.2
 */