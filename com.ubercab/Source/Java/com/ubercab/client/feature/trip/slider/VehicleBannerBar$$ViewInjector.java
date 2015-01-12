package com.ubercab.client.feature.trip.slider;

import android.widget.TextView;
import butterknife.ButterKnife.Finder;

public class VehicleBannerBar$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, VehicleBannerBar paramVehicleBannerBar, Object paramObject)
  {
    paramVehicleBannerBar.mTextViewTitle = ((TextView)paramFinder.findRequiredView(paramObject, 2131427852, "field 'mTextViewTitle'"));
    paramVehicleBannerBar.mTextViewDetail = ((TextView)paramFinder.findRequiredView(paramObject, 2131427853, "field 'mTextViewDetail'"));
  }

  public static void reset(VehicleBannerBar paramVehicleBannerBar)
  {
    paramVehicleBannerBar.mTextViewTitle = null;
    paramVehicleBannerBar.mTextViewDetail = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.slider.VehicleBannerBar..ViewInjector
 * JD-Core Version:    0.6.2
 */