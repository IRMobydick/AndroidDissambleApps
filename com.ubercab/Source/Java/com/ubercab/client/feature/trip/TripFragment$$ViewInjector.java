package com.ubercab.client.feature.trip;

import android.view.View;
import android.view.View.OnClickListener;
import butterknife.ButterKnife.Finder;
import com.ubercab.client.feature.music.overlay.AddMusicOverlayView;
import com.ubercab.client.feature.trip.map.PinView;
import com.ubercab.client.feature.trip.overlay.DestinationTutorialOverlayView;
import com.ubercab.client.feature.trip.overlay.DispatchDestinationOverlayView;
import com.ubercab.client.feature.trip.overlay.LegacyMobileMessageOverlayView;
import com.ubercab.client.feature.trip.overlay.NoLocationOverlayView;

public class TripFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, TripFragment paramTripFragment, Object paramObject)
  {
    paramTripFragment.mViewPin = ((PinView)paramFinder.findRequiredView(paramObject, 2131427776, "field 'mViewPin'"));
    paramTripFragment.mViewAddMusicOverlay = ((AddMusicOverlayView)paramFinder.findRequiredView(paramObject, 2131427784, "field 'mViewAddMusicOverlay'"));
    paramTripFragment.mViewHeader = ((HeaderView)paramFinder.findRequiredView(paramObject, 2131427777, "field 'mViewHeader'"));
    paramTripFragment.mViewFooter = ((FooterView)paramFinder.findRequiredView(paramObject, 2131427779, "field 'mViewFooter'"));
    paramTripFragment.mViewNoLocationOverlay = ((NoLocationOverlayView)paramFinder.findRequiredView(paramObject, 2131427775, "field 'mViewNoLocationOverlay'"));
    paramTripFragment.mViewLegacyMobileMessageOverlay = ((LegacyMobileMessageOverlayView)paramFinder.findRequiredView(paramObject, 2131427787, "field 'mViewLegacyMobileMessageOverlay'"));
    paramTripFragment.mViewDestinationTutorialOverlay = ((DestinationTutorialOverlayView)paramFinder.findRequiredView(paramObject, 2131427786, "field 'mViewDestinationTutorialOverlay'"));
    paramTripFragment.mViewDispatchDestinationOverlay = ((DispatchDestinationOverlayView)paramFinder.findRequiredView(paramObject, 2131427772, "field 'mViewDispatchDestinationOverlay'"));
    paramFinder.findRequiredView(paramObject, 2131427895, "method 'onClickPin'").setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickPin();
      }
    });
  }

  public static void reset(TripFragment paramTripFragment)
  {
    paramTripFragment.mViewPin = null;
    paramTripFragment.mViewAddMusicOverlay = null;
    paramTripFragment.mViewHeader = null;
    paramTripFragment.mViewFooter = null;
    paramTripFragment.mViewNoLocationOverlay = null;
    paramTripFragment.mViewLegacyMobileMessageOverlay = null;
    paramTripFragment.mViewDestinationTutorialOverlay = null;
    paramTripFragment.mViewDispatchDestinationOverlay = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.TripFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */