package com.ubercab.client.feature.trip.rates;

import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;

public class RateCardPopupWindow$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, RateCardPopupWindow paramRateCardPopupWindow, Object paramObject)
  {
    BaseRateCardPopupWindow..ViewInjector.inject(paramFinder, paramRateCardPopupWindow, paramObject);
    paramRateCardPopupWindow.mTextViewAndOr = ((TextView)paramFinder.findRequiredView(paramObject, 2131427809, "field 'mTextViewAndOr'"));
    paramRateCardPopupWindow.mTextViewBaseFare = ((TextView)paramFinder.findRequiredView(paramObject, 2131427806, "field 'mTextViewBaseFare'"));
    paramRateCardPopupWindow.mTextViewBaseFareSeparator = ((TextView)paramFinder.findRequiredView(paramObject, 2131427807, "field 'mTextViewBaseFareSeparator'"));
    paramRateCardPopupWindow.mTextViewMinFareSubtitle = ((TextView)paramFinder.findRequiredView(paramObject, 2131427805, "field 'mTextViewMinFareSubtitle'"));
    paramRateCardPopupWindow.mTextViewPerDistance = ((TextView)paramFinder.findRequiredView(paramObject, 2131427810, "field 'mTextViewPerDistance'"));
    paramRateCardPopupWindow.mTextViewPerMinute = ((TextView)paramFinder.findRequiredView(paramObject, 2131427808, "field 'mTextViewPerMinute'"));
    paramRateCardPopupWindow.mTextViewSafeRide = ((TextView)paramFinder.findRequiredView(paramObject, 2131427812, "field 'mTextViewSafeRide'"));
    paramRateCardPopupWindow.mTextViewSurgeSubtext = ((TextView)paramFinder.findRequiredView(paramObject, 2131427816, "field 'mTextViewSurgeSubtext'"));
    paramRateCardPopupWindow.mViewGroupSafeRide = ((ViewGroup)paramFinder.findRequiredView(paramObject, 2131427811, "field 'mViewGroupSafeRide'"));
    paramRateCardPopupWindow.mViewGroupVehicleDetails = ((ViewGroup)paramFinder.findRequiredView(paramObject, 2131427813, "field 'mViewGroupVehicleDetails'"));
  }

  public static void reset(RateCardPopupWindow paramRateCardPopupWindow)
  {
    BaseRateCardPopupWindow..ViewInjector.reset(paramRateCardPopupWindow);
    paramRateCardPopupWindow.mTextViewAndOr = null;
    paramRateCardPopupWindow.mTextViewBaseFare = null;
    paramRateCardPopupWindow.mTextViewBaseFareSeparator = null;
    paramRateCardPopupWindow.mTextViewMinFareSubtitle = null;
    paramRateCardPopupWindow.mTextViewPerDistance = null;
    paramRateCardPopupWindow.mTextViewPerMinute = null;
    paramRateCardPopupWindow.mTextViewSafeRide = null;
    paramRateCardPopupWindow.mTextViewSurgeSubtext = null;
    paramRateCardPopupWindow.mViewGroupSafeRide = null;
    paramRateCardPopupWindow.mViewGroupVehicleDetails = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.rates.RateCardPopupWindow..ViewInjector
 * JD-Core Version:    0.6.2
 */