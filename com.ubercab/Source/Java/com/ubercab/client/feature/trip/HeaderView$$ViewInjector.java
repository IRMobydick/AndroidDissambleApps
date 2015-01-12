package com.ubercab.client.feature.trip;

import butterknife.ButterKnife.Finder;
import com.ubercab.client.feature.trip.address.MultiAddressView;

public class HeaderView$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, HeaderView paramHeaderView, Object paramObject)
  {
    paramHeaderView.mMultiAddressView = ((MultiAddressView)paramFinder.findRequiredView(paramObject, 2131427778, "field 'mMultiAddressView'"));
  }

  public static void reset(HeaderView paramHeaderView)
  {
    paramHeaderView.mMultiAddressView = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.HeaderView..ViewInjector
 * JD-Core Version:    0.6.2
 */