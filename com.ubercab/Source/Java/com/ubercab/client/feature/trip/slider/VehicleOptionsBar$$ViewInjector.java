package com.ubercab.client.feature.trip.slider;

import android.widget.FrameLayout;
import butterknife.ButterKnife.Finder;

public class VehicleOptionsBar$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, VehicleOptionsBar paramVehicleOptionsBar, Object paramObject)
  {
    paramVehicleOptionsBar.mViewGroupContainer = ((FrameLayout)paramFinder.findRequiredView(paramObject, 2131427903, "field 'mViewGroupContainer'"));
  }

  public static void reset(VehicleOptionsBar paramVehicleOptionsBar)
  {
    paramVehicleOptionsBar.mViewGroupContainer = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.slider.VehicleOptionsBar..ViewInjector
 * JD-Core Version:    0.6.2
 */