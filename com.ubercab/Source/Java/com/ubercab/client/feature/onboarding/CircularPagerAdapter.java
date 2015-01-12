package com.ubercab.client.feature.onboarding;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

abstract class CircularPagerAdapter extends PagerAdapter
{
  private static final int MAX_PAGES = 2147483647;

  static int midpoint(int paramInt)
  {
    return 2147483647 / paramInt - 2147483647 % paramInt;
  }

  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }

  public int getCount()
  {
    return 2147483647;
  }

  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.onboarding.CircularPagerAdapter
 * JD-Core Version:    0.6.2
 */