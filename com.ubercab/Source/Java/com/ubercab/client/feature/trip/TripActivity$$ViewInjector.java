package com.ubercab.client.feature.trip;

import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import butterknife.ButterKnife.Finder;

public class TripActivity$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, TripActivity paramTripActivity, Object paramObject)
  {
    paramTripActivity.mDrawerLayout = ((DrawerLayout)paramFinder.findRequiredView(paramObject, 2131427769, "field 'mDrawerLayout'"));
    View localView = paramFinder.findRequiredView(paramObject, 2131427771, "field 'mListViewDrawer' and method 'onItemClick'");
    paramTripActivity.mListViewDrawer = ((ListView)localView);
    ((AdapterView)localView).setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        this.val$target.onItemClick(paramAnonymousLong);
      }
    });
  }

  public static void reset(TripActivity paramTripActivity)
  {
    paramTripActivity.mDrawerLayout = null;
    paramTripActivity.mListViewDrawer = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.TripActivity..ViewInjector
 * JD-Core Version:    0.6.2
 */