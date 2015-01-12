package com.ubercab.client.feature.onboarding;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

class SpeedFactorScroller extends Scroller
{
  private int mScrollFactor;

  public SpeedFactorScroller(Context paramContext)
  {
    super(paramContext);
  }

  public SpeedFactorScroller(Context paramContext, Interpolator paramInterpolator)
  {
    super(paramContext, paramInterpolator);
  }

  public SpeedFactorScroller(Context paramContext, Interpolator paramInterpolator, boolean paramBoolean)
  {
    super(paramContext, paramInterpolator, paramBoolean);
  }

  void setScrollFactor(int paramInt)
  {
    this.mScrollFactor = paramInt;
  }

  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5 * this.mScrollFactor);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.onboarding.SpeedFactorScroller
 * JD-Core Version:    0.6.2
 */