package com.ubercab.client.feature.trip.rates;

import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;

public class BaseRateCardPopupWindow$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, BaseRateCardPopupWindow paramBaseRateCardPopupWindow, Object paramObject)
  {
    paramBaseRateCardPopupWindow.mTextViewEta = ((TextView)paramFinder.findRequiredView(paramObject, 2131427814, "field 'mTextViewEta'"));
    paramBaseRateCardPopupWindow.mTextViewMessage = ((TextView)paramFinder.findRequiredView(paramObject, 2131427821, "field 'mTextViewMessage'"));
    paramBaseRateCardPopupWindow.mTextViewPassengers = ((TextView)paramFinder.findRequiredView(paramObject, 2131427815, "field 'mTextViewPassengers'"));
    paramBaseRateCardPopupWindow.mTextViewSurgeSubtitle = ((TextView)paramFinder.findRequiredView(paramObject, 2131427825, "field 'mTextViewSurgeSubtitle'"));
    paramBaseRateCardPopupWindow.mTextViewSurgeTitle = ((TextView)paramFinder.findRequiredView(paramObject, 2131427824, "field 'mTextViewSurgeTitle'"));
    paramBaseRateCardPopupWindow.mTextViewUrl = ((TextView)paramFinder.findRequiredView(paramObject, 2131427822, "field 'mTextViewUrl'"));
    paramBaseRateCardPopupWindow.mViewGroupContent = ((ViewGroup)paramFinder.findRequiredView(paramObject, 2131427803, "field 'mViewGroupContent'"));
    paramBaseRateCardPopupWindow.mViewGroupMessage = ((ViewGroup)paramFinder.findRequiredView(paramObject, 2131427817, "field 'mViewGroupMessage'"));
    paramBaseRateCardPopupWindow.mViewGroupSurgeHeader = ((ViewGroup)paramFinder.findRequiredView(paramObject, 2131427804, "field 'mViewGroupSurgeHeader'"));
  }

  public static void reset(BaseRateCardPopupWindow paramBaseRateCardPopupWindow)
  {
    paramBaseRateCardPopupWindow.mTextViewEta = null;
    paramBaseRateCardPopupWindow.mTextViewMessage = null;
    paramBaseRateCardPopupWindow.mTextViewPassengers = null;
    paramBaseRateCardPopupWindow.mTextViewSurgeSubtitle = null;
    paramBaseRateCardPopupWindow.mTextViewSurgeTitle = null;
    paramBaseRateCardPopupWindow.mTextViewUrl = null;
    paramBaseRateCardPopupWindow.mViewGroupContent = null;
    paramBaseRateCardPopupWindow.mViewGroupMessage = null;
    paramBaseRateCardPopupWindow.mViewGroupSurgeHeader = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.rates.BaseRateCardPopupWindow..ViewInjector
 * JD-Core Version:    0.6.2
 */