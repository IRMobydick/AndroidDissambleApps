package com.ubercab.library.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

public abstract class AnimatorCancelAdapter extends AnimatorListenerAdapter
{
  private boolean mIsCanceled;

  public boolean isCanceled()
  {
    return this.mIsCanceled;
  }

  public void onAnimationCancel(Animator paramAnimator)
  {
    this.mIsCanceled = true;
  }

  public void onAnimationComplete(Animator paramAnimator)
  {
  }

  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!this.mIsCanceled)
      onAnimationComplete(paramAnimator);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.ui.AnimatorCancelAdapter
 * JD-Core Version:    0.6.2
 */