package com.ubercab.client.feature.trip.rates;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;

public class RateCardV2PopupWindow$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, RateCardV2PopupWindow paramRateCardV2PopupWindow, Object paramObject)
  {
    BaseRateCardPopupWindow..ViewInjector.inject(paramFinder, paramRateCardV2PopupWindow, paramObject);
    View localView1 = paramFinder.findRequiredView(paramObject, 2131427828, "field 'mAddressViewDestination' and method 'onDestinationClick'");
    paramRateCardV2PopupWindow.mAddressViewDestination = ((RateCardAddressView)localView1);
    localView1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onDestinationClick();
      }
    });
    View localView2 = paramFinder.findRequiredView(paramObject, 2131427836, "field 'mAddressViewFareDestination' and method 'onFareEstimateDestinationClick'");
    paramRateCardV2PopupWindow.mAddressViewFareDestination = ((RateCardAddressView)localView2);
    localView2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onFareEstimateDestinationClick();
      }
    });
    paramRateCardV2PopupWindow.mTextViewDividerFor = ((TextView)paramFinder.findRequiredView(paramObject, 2131427835, "field 'mTextViewDividerFor'"));
    paramRateCardV2PopupWindow.mTextViewDividerTo = ((TextView)paramFinder.findRequiredView(paramObject, 2131427837, "field 'mTextViewDividerTo'"));
    paramRateCardV2PopupWindow.mTextViewMinFare = ((TextView)paramFinder.findRequiredView(paramObject, 2131427823, "field 'mTextViewMinFare'"));
    paramRateCardV2PopupWindow.mProgressBarFareLoading = ((ProgressBar)paramFinder.findRequiredView(paramObject, 2131427832, "field 'mProgressBarFareLoading'"));
    paramRateCardV2PopupWindow.mTextViewFareEstimate = ((TextView)paramFinder.findRequiredView(paramObject, 2131427830, "field 'mTextViewFareEstimate'"));
    paramRateCardV2PopupWindow.mTextViewFareEstimateError = ((TextView)paramFinder.findRequiredView(paramObject, 2131427831, "field 'mTextViewFareEstimateError'"));
    paramRateCardV2PopupWindow.mViewGroupDefaultDetails = ((ViewGroup)paramFinder.findRequiredView(paramObject, 2131427833, "field 'mViewGroupDefaultDetails'"));
    paramRateCardV2PopupWindow.mViewGroupAddressContents = ((ViewGroup)paramFinder.findRequiredView(paramObject, 2131427826, "field 'mViewGroupAddressContents'"));
    paramRateCardV2PopupWindow.mViewGroupFareEstimateDetails = ((ViewGroup)paramFinder.findRequiredView(paramObject, 2131427829, "field 'mViewGroupFareEstimateDetails'"));
    paramFinder.findRequiredView(paramObject, 2131427834, "method 'onFareEstimateClick'").setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onFareEstimateClick();
      }
    });
  }

  public static void reset(RateCardV2PopupWindow paramRateCardV2PopupWindow)
  {
    BaseRateCardPopupWindow..ViewInjector.reset(paramRateCardV2PopupWindow);
    paramRateCardV2PopupWindow.mAddressViewDestination = null;
    paramRateCardV2PopupWindow.mAddressViewFareDestination = null;
    paramRateCardV2PopupWindow.mTextViewDividerFor = null;
    paramRateCardV2PopupWindow.mTextViewDividerTo = null;
    paramRateCardV2PopupWindow.mTextViewMinFare = null;
    paramRateCardV2PopupWindow.mProgressBarFareLoading = null;
    paramRateCardV2PopupWindow.mTextViewFareEstimate = null;
    paramRateCardV2PopupWindow.mTextViewFareEstimateError = null;
    paramRateCardV2PopupWindow.mViewGroupDefaultDetails = null;
    paramRateCardV2PopupWindow.mViewGroupAddressContents = null;
    paramRateCardV2PopupWindow.mViewGroupFareEstimateDetails = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.rates.RateCardV2PopupWindow..ViewInjector
 * JD-Core Version:    0.6.2
 */