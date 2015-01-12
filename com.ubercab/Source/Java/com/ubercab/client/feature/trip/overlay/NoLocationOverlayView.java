package com.ubercab.client.feature.trip.overlay;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.ubercab.client.core.app.RiderApplication;
import com.ubercab.ui.UberTextView;

public class NoLocationOverlayView extends LinearLayout
{
  private static final int ANIMATION_DURATION_MS = 2000;

  @InjectView(2131427536)
  ImageView mImageViewNoLocationArrow;
  private RotateAnimation mRotateAnimationNoLocationArrow;

  @InjectView(2131427538)
  UberTextView mTextViewNoLocationDesc;

  @InjectView(2131427537)
  UberTextView mTextViewNoLocationHeading;

  public NoLocationOverlayView(Context paramContext)
  {
    this(paramContext, null);
  }

  public NoLocationOverlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public NoLocationOverlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (!isInEditMode())
      RiderApplication.get(paramContext).inject(this);
  }

  public void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode())
      return;
    ButterKnife.inject(this);
    this.mTextViewNoLocationHeading.setText(getContext().getString(2131558940));
    this.mTextViewNoLocationDesc.setText(getContext().getString(2131558939));
    this.mRotateAnimationNoLocationArrow = new RotateAnimation(0.0F, 30.0F, 1, 0.5F, 1, 0.5F);
    this.mRotateAnimationNoLocationArrow.setRepeatMode(2);
    this.mRotateAnimationNoLocationArrow.setInterpolator(new AccelerateDecelerateInterpolator());
    this.mRotateAnimationNoLocationArrow.setRepeatCount(-1);
    this.mRotateAnimationNoLocationArrow.setDuration(2000L);
  }

  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 0)
    {
      this.mImageViewNoLocationArrow.startAnimation(this.mRotateAnimationNoLocationArrow);
      return;
    }
    this.mImageViewNoLocationArrow.clearAnimation();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.overlay.NoLocationOverlayView
 * JD-Core Version:    0.6.2
 */