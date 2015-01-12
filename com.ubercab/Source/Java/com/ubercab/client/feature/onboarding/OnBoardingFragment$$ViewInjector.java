package com.ubercab.client.feature.onboarding;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import butterknife.ButterKnife.Finder;

public class OnBoardingFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, OnBoardingFragment paramOnBoardingFragment, Object paramObject)
  {
    paramOnBoardingFragment.mPageIndicator = ((PageIndicator)paramFinder.findRequiredView(paramObject, 2131427542, "field 'mPageIndicator'"));
    View localView1 = paramFinder.findRequiredView(paramObject, 2131427540, "field 'mPage' and method 'onPageTouched'");
    paramOnBoardingFragment.mPage = ((MovableBackgroundLayout)localView1);
    localView1.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return this.val$target.onPageTouched();
      }
    });
    paramOnBoardingFragment.mHeadlinePager = ((ScrollingViewPager)paramFinder.findRequiredView(paramObject, 2131427541, "field 'mHeadlinePager'"));
    paramOnBoardingFragment.mScreenshotPager = ((ScrollingViewPager)paramFinder.findRequiredView(paramObject, 2131427543, "field 'mScreenshotPager'"));
    View localView2 = paramFinder.findRequiredView(paramObject, 2131427544, "field 'mCallToAction' and method 'onCallToActionClicked'");
    paramOnBoardingFragment.mCallToAction = ((Button)localView2);
    localView2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onCallToActionClicked();
      }
    });
  }

  public static void reset(OnBoardingFragment paramOnBoardingFragment)
  {
    paramOnBoardingFragment.mPageIndicator = null;
    paramOnBoardingFragment.mPage = null;
    paramOnBoardingFragment.mHeadlinePager = null;
    paramOnBoardingFragment.mScreenshotPager = null;
    paramOnBoardingFragment.mCallToAction = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.onboarding.OnBoardingFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */