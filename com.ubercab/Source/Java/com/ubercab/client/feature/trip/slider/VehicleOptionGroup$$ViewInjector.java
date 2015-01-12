package com.ubercab.client.feature.trip.slider;

import android.widget.RadioGroup;
import butterknife.ButterKnife.Finder;

public class VehicleOptionGroup$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, VehicleOptionGroup paramVehicleOptionGroup, Object paramObject)
  {
    paramVehicleOptionGroup.mRadioGroup = ((RadioGroup)paramFinder.findRequiredView(paramObject, 2131427907, "field 'mRadioGroup'"));
  }

  public static void reset(VehicleOptionGroup paramVehicleOptionGroup)
  {
    paramVehicleOptionGroup.mRadioGroup = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.slider.VehicleOptionGroup..ViewInjector
 * JD-Core Version:    0.6.2
 */