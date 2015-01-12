package com.ubercab.client.feature.trip.overlay;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import butterknife.ButterKnife.Finder;
import com.ubercab.client.feature.trip.address.AddressView;
import com.ubercab.ui.UberTextView;

public class DestinationTutorialOverlayView$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, DestinationTutorialOverlayView paramDestinationTutorialOverlayView, Object paramObject)
  {
    View localView = paramFinder.findRequiredView(paramObject, 2131427870, "field 'mAddressView' and method 'onAddressClick'");
    paramDestinationTutorialOverlayView.mAddressView = ((AddressView)localView);
    localView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onAddressClick();
      }
    });
    paramDestinationTutorialOverlayView.mViewGroupIcon = ((ViewGroup)paramFinder.findRequiredView(paramObject, 2131427872, "field 'mViewGroupIcon'"));
    paramDestinationTutorialOverlayView.mViewGroupText = ((ViewGroup)paramFinder.findRequiredView(paramObject, 2131427873, "field 'mViewGroupText'"));
    paramDestinationTutorialOverlayView.mTextViewTitle = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427874, "field 'mTextViewTitle'"));
    paramDestinationTutorialOverlayView.mTextViewMessage = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427875, "field 'mTextViewMessage'"));
    paramDestinationTutorialOverlayView.mCoachMarkPathView = ((CoachMarkPathView)paramFinder.findRequiredView(paramObject, 2131427871, "field 'mCoachMarkPathView'"));
  }

  public static void reset(DestinationTutorialOverlayView paramDestinationTutorialOverlayView)
  {
    paramDestinationTutorialOverlayView.mAddressView = null;
    paramDestinationTutorialOverlayView.mViewGroupIcon = null;
    paramDestinationTutorialOverlayView.mViewGroupText = null;
    paramDestinationTutorialOverlayView.mTextViewTitle = null;
    paramDestinationTutorialOverlayView.mTextViewMessage = null;
    paramDestinationTutorialOverlayView.mCoachMarkPathView = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.overlay.DestinationTutorialOverlayView..ViewInjector
 * JD-Core Version:    0.6.2
 */