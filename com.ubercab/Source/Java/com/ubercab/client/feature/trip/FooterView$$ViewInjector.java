package com.ubercab.client.feature.trip;

import butterknife.ButterKnife.Finder;
import com.ubercab.client.feature.music.MusicTrayView;
import com.ubercab.client.feature.trip.confirm.ConfirmationView;
import com.ubercab.client.feature.trip.dispatch.CancelView;
import com.ubercab.client.feature.trip.driver.DriverView;
import com.ubercab.client.feature.trip.slider.VehicleSlider;

public class FooterView$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, FooterView paramFooterView, Object paramObject)
  {
    paramFooterView.mViewCancel = ((CancelView)paramFinder.findRequiredView(paramObject, 2131427780, "field 'mViewCancel'"));
    paramFooterView.mViewConfirmation = ((ConfirmationView)paramFinder.findRequiredView(paramObject, 2131427781, "field 'mViewConfirmation'"));
    paramFooterView.mViewDriver = ((DriverView)paramFinder.findRequiredView(paramObject, 2131427783, "field 'mViewDriver'"));
    paramFooterView.mViewMusicTray = ((MusicTrayView)paramFinder.findRequiredView(paramObject, 2131427782, "field 'mViewMusicTray'"));
    paramFooterView.mViewVehicleSlider = ((VehicleSlider)paramFinder.findRequiredView(paramObject, 2131427785, "field 'mViewVehicleSlider'"));
  }

  public static void reset(FooterView paramFooterView)
  {
    paramFooterView.mViewCancel = null;
    paramFooterView.mViewConfirmation = null;
    paramFooterView.mViewDriver = null;
    paramFooterView.mViewMusicTray = null;
    paramFooterView.mViewVehicleSlider = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.FooterView..ViewInjector
 * JD-Core Version:    0.6.2
 */