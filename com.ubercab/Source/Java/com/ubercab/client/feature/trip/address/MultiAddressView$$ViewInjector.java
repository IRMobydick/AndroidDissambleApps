package com.ubercab.client.feature.trip.address;

import android.view.View;
import android.view.View.OnClickListener;
import butterknife.ButterKnife.Finder;

public class MultiAddressView$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, MultiAddressView paramMultiAddressView, Object paramObject)
  {
    View localView1 = paramFinder.findRequiredView(paramObject, 2131427892, "field 'mAddressViewPickup' and method 'onClickAddressViewPickup'");
    paramMultiAddressView.mAddressViewPickup = ((AddressView)localView1);
    localView1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickAddressViewPickup();
      }
    });
    View localView2 = paramFinder.findRequiredView(paramObject, 2131427893, "field 'mAddressViewDestination' and method 'onClickAddressViewDestination'");
    paramMultiAddressView.mAddressViewDestination = ((AddressView)localView2);
    localView2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickAddressViewDestination();
      }
    });
  }

  public static void reset(MultiAddressView paramMultiAddressView)
  {
    paramMultiAddressView.mAddressViewPickup = null;
    paramMultiAddressView.mAddressViewDestination = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.address.MultiAddressView..ViewInjector
 * JD-Core Version:    0.6.2
 */