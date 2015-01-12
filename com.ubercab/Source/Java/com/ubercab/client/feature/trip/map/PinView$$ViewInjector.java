package com.ubercab.client.feature.trip.map;

import android.view.ViewGroup;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberTextView;

public class PinView$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, PinView paramPinView, Object paramObject)
  {
    paramPinView.mViewPinButton = paramFinder.findRequiredView(paramObject, 2131427895, "field 'mViewPinButton'");
    paramPinView.mViewGroupEta = ((ViewGroup)paramFinder.findRequiredView(paramObject, 2131427896, "field 'mViewGroupEta'"));
    paramPinView.mViewGroupPin = ((ViewGroup)paramFinder.findRequiredView(paramObject, 2131427894, "field 'mViewGroupPin'"));
    paramPinView.mTextViewPickup = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427899, "field 'mTextViewPickup'"));
    paramPinView.mTextViewEtaLabel = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427898, "field 'mTextViewEtaLabel'"));
    paramPinView.mTextViewEtaNumber = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427897, "field 'mTextViewEtaNumber'"));
  }

  public static void reset(PinView paramPinView)
  {
    paramPinView.mViewPinButton = null;
    paramPinView.mViewGroupEta = null;
    paramPinView.mViewGroupPin = null;
    paramPinView.mTextViewPickup = null;
    paramPinView.mTextViewEtaLabel = null;
    paramPinView.mTextViewEtaNumber = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.map.PinView..ViewInjector
 * JD-Core Version:    0.6.2
 */