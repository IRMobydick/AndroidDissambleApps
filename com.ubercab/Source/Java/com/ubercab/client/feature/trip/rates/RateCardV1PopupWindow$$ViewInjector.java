package com.ubercab.client.feature.trip.rates;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import com.ubercab.client.feature.trip.address.AddressView;

public class RateCardV1PopupWindow$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, RateCardV1PopupWindow paramRateCardV1PopupWindow, Object paramObject)
  {
    BaseRateCardPopupWindow..ViewInjector.inject(paramFinder, paramRateCardV1PopupWindow, paramObject);
    View localView1 = paramFinder.findRequiredView(paramObject, 2131427827, "field 'mAddressViewPickup' and method 'onPickupClick'");
    paramRateCardV1PopupWindow.mAddressViewPickup = ((AddressView)localView1);
    localView1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onPickupClick();
      }
    });
    View localView2 = paramFinder.findRequiredView(paramObject, 2131427828, "field 'mAddressViewDestination' and method 'onDestinationClick'");
    paramRateCardV1PopupWindow.mAddressViewDestination = ((AddressView)localView2);
    localView2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onDestinationClick();
      }
    });
    paramRateCardV1PopupWindow.mProgressBarFareLoading = ((ProgressBar)paramFinder.findRequiredView(paramObject, 2131427832, "field 'mProgressBarFareLoading'"));
    paramRateCardV1PopupWindow.mTextViewMinFare = ((TextView)paramFinder.findRequiredView(paramObject, 2131427823, "field 'mTextViewMinFare'"));
    paramRateCardV1PopupWindow.mTextViewFareEstimate = ((TextView)paramFinder.findRequiredView(paramObject, 2131427830, "field 'mTextViewFareEstimate'"));
    paramRateCardV1PopupWindow.mViewGroupAddressContents = ((ViewGroup)paramFinder.findRequiredView(paramObject, 2131427826, "field 'mViewGroupAddressContents'"));
    paramRateCardV1PopupWindow.mTextViewFareEstimateError = ((TextView)paramFinder.findRequiredView(paramObject, 2131427831, "field 'mTextViewFareEstimateError'"));
    paramRateCardV1PopupWindow.mViewGroupFareEstimateDetails = ((ViewGroup)paramFinder.findRequiredView(paramObject, 2131427829, "field 'mViewGroupFareEstimateDetails'"));
  }

  public static void reset(RateCardV1PopupWindow paramRateCardV1PopupWindow)
  {
    BaseRateCardPopupWindow..ViewInjector.reset(paramRateCardV1PopupWindow);
    paramRateCardV1PopupWindow.mAddressViewPickup = null;
    paramRateCardV1PopupWindow.mAddressViewDestination = null;
    paramRateCardV1PopupWindow.mProgressBarFareLoading = null;
    paramRateCardV1PopupWindow.mTextViewMinFare = null;
    paramRateCardV1PopupWindow.mTextViewFareEstimate = null;
    paramRateCardV1PopupWindow.mViewGroupAddressContents = null;
    paramRateCardV1PopupWindow.mTextViewFareEstimateError = null;
    paramRateCardV1PopupWindow.mViewGroupFareEstimateDetails = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.rates.RateCardV1PopupWindow..ViewInjector
 * JD-Core Version:    0.6.2
 */