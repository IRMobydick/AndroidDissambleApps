package com.ubercab.client.feature.estimate;

import android.view.View;
import android.view.View.OnClickListener;
import butterknife.ButterKnife.Finder;
import com.ubercab.client.feature.trip.address.AddressView;

public class FareEstimateMultiAddressView$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, FareEstimateMultiAddressView paramFareEstimateMultiAddressView, Object paramObject)
  {
    View localView1 = paramFinder.findRequiredView(paramObject, 2131427449, "field 'mAddressViewPickup' and method 'onClickAddressViewPickup'");
    paramFareEstimateMultiAddressView.mAddressViewPickup = ((AddressView)localView1);
    localView1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickAddressViewPickup();
      }
    });
    View localView2 = paramFinder.findRequiredView(paramObject, 2131427450, "field 'mAddressViewDestination' and method 'onClickAddressViewDestination'");
    paramFareEstimateMultiAddressView.mAddressViewDestination = ((AddressView)localView2);
    localView2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickAddressViewDestination();
      }
    });
  }

  public static void reset(FareEstimateMultiAddressView paramFareEstimateMultiAddressView)
  {
    paramFareEstimateMultiAddressView.mAddressViewPickup = null;
    paramFareEstimateMultiAddressView.mAddressViewDestination = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.estimate.FareEstimateMultiAddressView..ViewInjector
 * JD-Core Version:    0.6.2
 */