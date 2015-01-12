package com.ubercab.client.feature.payment;

import android.widget.TextView;
import butterknife.ButterKnife.Finder;

public class TripBalancesAdapter$TripBalancesViewHolder$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, TripBalancesAdapter.TripBalancesViewHolder paramTripBalancesViewHolder, Object paramObject)
  {
    paramTripBalancesViewHolder.mLabel = ((TextView)paramFinder.findRequiredView(paramObject, 2131427656, "field 'mLabel'"));
    paramTripBalancesViewHolder.mDetails = ((TextView)paramFinder.findRequiredView(paramObject, 2131427657, "field 'mDetails'"));
  }

  public static void reset(TripBalancesAdapter.TripBalancesViewHolder paramTripBalancesViewHolder)
  {
    paramTripBalancesViewHolder.mLabel = null;
    paramTripBalancesViewHolder.mDetails = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.TripBalancesAdapter.TripBalancesViewHolder..ViewInjector
 * JD-Core Version:    0.6.2
 */