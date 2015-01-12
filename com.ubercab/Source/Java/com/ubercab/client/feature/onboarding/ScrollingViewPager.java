package com.ubercab.client.feature.onboarding;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.animation.Interpolator;
import java.lang.reflect.Field;
import timber.log.Timber;

public class ScrollingViewPager extends ViewPager
{
  private SpeedFactorScroller mScroller;

  public ScrollingViewPager(Context paramContext)
  {
    this(paramContext, null);
  }

  public ScrollingViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    attachScroller();
  }

  private void attachScroller()
  {
    try
    {
      Field localField1 = ViewPager.class.getDeclaredField("mScroller");
      localField1.setAccessible(true);
      Field localField2 = ViewPager.class.getDeclaredField("sInterpolator");
      localField2.setAccessible(true);
      this.mScroller = new SpeedFactorScroller(getContext(), (Interpolator)localField2.get(null));
      localField1.set(this, this.mScroller);
      return;
    }
    catch (Exception localException)
    {
      Timber.e(localException, "Could not initialize scroller.", new Object[0]);
    }
  }

  void resetScrollFactor()
  {
    this.mScroller.setScrollFactor(1);
  }

  void setScrollFactor(int paramInt)
  {
    this.mScroller.setScrollFactor(paramInt);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.onboarding.ScrollingViewPager
 * JD-Core Version:    0.6.2
 */