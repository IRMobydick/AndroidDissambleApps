package com.ubercab.client.feature.trip.map;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import butterknife.ButterKnife.Finder;

public class MapFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, MapFragment paramMapFragment, Object paramObject)
  {
    View localView = paramFinder.findRequiredView(paramObject, 2131427790, "field 'mButtonMyLocation' and method 'onClickMyLocationButton'");
    paramMapFragment.mButtonMyLocation = ((ImageButton)localView);
    localView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickMyLocationButton();
      }
    });
    paramMapFragment.mViewMapExtension = ((MapViewExtension)paramFinder.findRequiredView(paramObject, 2131427788, "field 'mViewMapExtension'"));
  }

  public static void reset(MapFragment paramMapFragment)
  {
    paramMapFragment.mButtonMyLocation = null;
    paramMapFragment.mViewMapExtension = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.map.MapFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */