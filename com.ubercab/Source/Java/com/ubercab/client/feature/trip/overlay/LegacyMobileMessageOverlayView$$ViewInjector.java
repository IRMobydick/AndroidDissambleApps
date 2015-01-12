package com.ubercab.client.feature.trip.overlay;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.WebView;
import butterknife.ButterKnife.Finder;

public class LegacyMobileMessageOverlayView$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, LegacyMobileMessageOverlayView paramLegacyMobileMessageOverlayView, Object paramObject)
  {
    paramLegacyMobileMessageOverlayView.mWebView = ((WebView)paramFinder.findRequiredView(paramObject, 2131427487, "field 'mWebView'"));
    paramFinder.findRequiredView(paramObject, 2131427486, "method 'onTouchDismissOverlay'").setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return this.val$target.onTouchDismissOverlay();
      }
    });
  }

  public static void reset(LegacyMobileMessageOverlayView paramLegacyMobileMessageOverlayView)
  {
    paramLegacyMobileMessageOverlayView.mWebView = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.overlay.LegacyMobileMessageOverlayView..ViewInjector
 * JD-Core Version:    0.6.2
 */