package com.ubercab.client.feature.trip.overlay;

import android.view.View;
import android.view.View.OnClickListener;
import butterknife.ButterKnife.Finder;
import com.ubercab.client.feature.trip.address.AddressView;

public class DispatchDestinationOverlayView$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, DispatchDestinationOverlayView paramDispatchDestinationOverlayView, Object paramObject)
  {
    View localView = paramFinder.findRequiredView(paramObject, 2131427773, "field 'mAddressView' and method 'onAddressClick'");
    paramDispatchDestinationOverlayView.mAddressView = ((AddressView)localView);
    localView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onAddressClick();
      }
    });
  }

  public static void reset(DispatchDestinationOverlayView paramDispatchDestinationOverlayView)
  {
    paramDispatchDestinationOverlayView.mAddressView = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.overlay.DispatchDestinationOverlayView..ViewInjector
 * JD-Core Version:    0.6.2
 */