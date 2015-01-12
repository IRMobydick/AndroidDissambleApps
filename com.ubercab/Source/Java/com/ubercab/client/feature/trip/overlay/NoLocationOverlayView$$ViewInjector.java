package com.ubercab.client.feature.trip.overlay;

import android.widget.ImageView;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberTextView;

public class NoLocationOverlayView$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, NoLocationOverlayView paramNoLocationOverlayView, Object paramObject)
  {
    paramNoLocationOverlayView.mImageViewNoLocationArrow = ((ImageView)paramFinder.findRequiredView(paramObject, 2131427536, "field 'mImageViewNoLocationArrow'"));
    paramNoLocationOverlayView.mTextViewNoLocationHeading = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427537, "field 'mTextViewNoLocationHeading'"));
    paramNoLocationOverlayView.mTextViewNoLocationDesc = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427538, "field 'mTextViewNoLocationDesc'"));
  }

  public static void reset(NoLocationOverlayView paramNoLocationOverlayView)
  {
    paramNoLocationOverlayView.mImageViewNoLocationArrow = null;
    paramNoLocationOverlayView.mTextViewNoLocationHeading = null;
    paramNoLocationOverlayView.mTextViewNoLocationDesc = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.overlay.NoLocationOverlayView..ViewInjector
 * JD-Core Version:    0.6.2
 */