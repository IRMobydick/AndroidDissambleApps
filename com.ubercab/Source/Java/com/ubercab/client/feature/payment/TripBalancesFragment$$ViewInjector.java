package com.ubercab.client.feature.payment;

import android.widget.ListView;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberTextView;

public class TripBalancesFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, TripBalancesFragment paramTripBalancesFragment, Object paramObject)
  {
    paramTripBalancesFragment.mTextViewFooter = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427655, "field 'mTextViewFooter'"));
    paramTripBalancesFragment.mListViewBalances = ((ListView)paramFinder.findRequiredView(paramObject, 2131427654, "field 'mListViewBalances'"));
  }

  public static void reset(TripBalancesFragment paramTripBalancesFragment)
  {
    paramTripBalancesFragment.mTextViewFooter = null;
    paramTripBalancesFragment.mListViewBalances = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.TripBalancesFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */