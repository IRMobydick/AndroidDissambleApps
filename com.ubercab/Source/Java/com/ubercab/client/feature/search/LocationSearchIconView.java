package com.ubercab.client.feature.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import butterknife.ButterKnife;

public class LocationSearchIconView extends ImageView
{
  private int mDefaultImgResource;
  private Animation mLoadingSpinnerAnimation;

  public LocationSearchIconView(Context paramContext)
  {
    this(paramContext, null);
  }

  public LocationSearchIconView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public LocationSearchIconView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mLoadingSpinnerAnimation = AnimationUtils.loadAnimation(paramContext, 2130968585);
    this.mLoadingSpinnerAnimation.setInterpolator(new LinearInterpolator());
  }

  public void displayLoading()
  {
    setImageResource(2130837798);
    setAnimation(this.mLoadingSpinnerAnimation);
  }

  public void hideLoading()
  {
    setAnimation(null);
    setImageResource(this.mDefaultImgResource);
  }

  public void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.inject(this);
  }

  public void setDefaultIconResource(int paramInt)
  {
    this.mDefaultImgResource = paramInt;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.search.LocationSearchIconView
 * JD-Core Version:    0.6.2
 */