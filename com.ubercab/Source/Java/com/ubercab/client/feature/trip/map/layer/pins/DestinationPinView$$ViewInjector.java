package com.ubercab.client.feature.trip.map.layer.pins;

import android.view.ViewGroup;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberTextView;

public class DestinationPinView$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, DestinationPinView paramDestinationPinView, Object paramObject)
  {
    paramDestinationPinView.mViewGroupPopup = ((ViewGroup)paramFinder.findRequiredView(paramObject, 2131427499, "field 'mViewGroupPopup'"));
    paramDestinationPinView.mTextViewEstimate = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427501, "field 'mTextViewEstimate'"));
    paramDestinationPinView.mTextViewTagline = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427500, "field 'mTextViewTagline'"));
  }

  public static void reset(DestinationPinView paramDestinationPinView)
  {
    paramDestinationPinView.mViewGroupPopup = null;
    paramDestinationPinView.mTextViewEstimate = null;
    paramDestinationPinView.mTextViewTagline = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.map.layer.pins.DestinationPinView..ViewInjector
 * JD-Core Version:    0.6.2
 */