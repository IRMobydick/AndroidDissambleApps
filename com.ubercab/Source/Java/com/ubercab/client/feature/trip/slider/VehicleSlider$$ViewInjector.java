package com.ubercab.client.feature.trip.slider;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import butterknife.ButterKnife.Finder;

public class VehicleSlider$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, VehicleSlider paramVehicleSlider, Object paramObject)
  {
    paramVehicleSlider.mViewShadow = paramFinder.findRequiredView(paramObject, 2131427900, "field 'mViewShadow'");
    paramVehicleSlider.mSeekBar = ((VehicleSeekBar)paramFinder.findRequiredView(paramObject, 2131427906, "field 'mSeekBar'"));
    paramVehicleSlider.mLabelBar = ((VehicleLabelBar)paramFinder.findRequiredView(paramObject, 2131427905, "field 'mLabelBar'"));
    paramVehicleSlider.mViewGroupBottom = ((ViewGroup)paramFinder.findRequiredView(paramObject, 2131427904, "field 'mViewGroupBottom'"));
    paramVehicleSlider.mOptionsBar = ((VehicleOptionsBar)paramFinder.findRequiredView(paramObject, 2131427902, "field 'mOptionsBar'"));
    View localView = paramFinder.findRequiredView(paramObject, 2131427901, "field 'mBannerBar' and method 'onClickBannerBar'");
    paramVehicleSlider.mBannerBar = ((VehicleBannerBar)localView);
    localView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickBannerBar();
      }
    });
  }

  public static void reset(VehicleSlider paramVehicleSlider)
  {
    paramVehicleSlider.mViewShadow = null;
    paramVehicleSlider.mSeekBar = null;
    paramVehicleSlider.mLabelBar = null;
    paramVehicleSlider.mViewGroupBottom = null;
    paramVehicleSlider.mOptionsBar = null;
    paramVehicleSlider.mBannerBar = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.slider.VehicleSlider..ViewInjector
 * JD-Core Version:    0.6.2
 */