package com.ubercab.client.feature.estimate;

import android.widget.LinearLayout;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberTextView;

public class FareEstimateFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, FareEstimateFragment paramFareEstimateFragment, Object paramObject)
  {
    paramFareEstimateFragment.mTextViewFare = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427439, "field 'mTextViewFare'"));
    paramFareEstimateFragment.mTextViewFarePoints = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427440, "field 'mTextViewFarePoints'"));
    paramFareEstimateFragment.mTextViewFarePointsExplanation = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427441, "field 'mTextViewFarePointsExplanation'"));
    paramFareEstimateFragment.mViewGroupSurge = ((LinearLayout)paramFinder.findRequiredView(paramObject, 2131427438, "field 'mViewGroupSurge'"));
    paramFareEstimateFragment.mTextViewVehicle = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427437, "field 'mTextViewVehicle'"));
    paramFareEstimateFragment.mTextViewMessage = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427442, "field 'mTextViewMessage'"));
    paramFareEstimateFragment.mViewGroupResults = ((LinearLayout)paramFinder.findRequiredView(paramObject, 2131427436, "field 'mViewGroupResults'"));
    paramFareEstimateFragment.mTextViewSectionHeaderSurge = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427928, "field 'mTextViewSectionHeaderSurge'"));
    paramFareEstimateFragment.mMultiAddressView = ((FareEstimateMultiAddressView)paramFinder.findRequiredView(paramObject, 2131427435, "field 'mMultiAddressView'"));
  }

  public static void reset(FareEstimateFragment paramFareEstimateFragment)
  {
    paramFareEstimateFragment.mTextViewFare = null;
    paramFareEstimateFragment.mTextViewFarePoints = null;
    paramFareEstimateFragment.mTextViewFarePointsExplanation = null;
    paramFareEstimateFragment.mViewGroupSurge = null;
    paramFareEstimateFragment.mTextViewVehicle = null;
    paramFareEstimateFragment.mTextViewMessage = null;
    paramFareEstimateFragment.mViewGroupResults = null;
    paramFareEstimateFragment.mTextViewSectionHeaderSurge = null;
    paramFareEstimateFragment.mMultiAddressView = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.estimate.FareEstimateFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */