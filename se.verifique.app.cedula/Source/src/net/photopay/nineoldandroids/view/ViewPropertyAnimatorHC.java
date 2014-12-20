package net.photopay.nineoldandroids.view;

import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import net.photopay.nineoldandroids.animation.Animator;
import net.photopay.nineoldandroids.animation.Animator.AnimatorListener;
import net.photopay.nineoldandroids.animation.ValueAnimator;

class ViewPropertyAnimatorHC extends ViewPropertyAnimator
{
  private static final int ALPHA = 512;
  private static final int NONE = 0;
  private static final int ROTATION = 16;
  private static final int ROTATION_X = 32;
  private static final int ROTATION_Y = 64;
  private static final int SCALE_X = 4;
  private static final int SCALE_Y = 8;
  private static final int TRANSFORM_MASK = 511;
  private static final int TRANSLATION_X = 1;
  private static final int TRANSLATION_Y = 2;
  private static final int X = 128;
  private static final int Y = 256;
  private Runnable mAnimationStarter = new ViewPropertyAnimatorHC.1(this);
  private ViewPropertyAnimatorHC.AnimatorEventListener mAnimatorEventListener = new ViewPropertyAnimatorHC.AnimatorEventListener(this, null);
  private HashMap mAnimatorMap = new HashMap();
  private long mDuration;
  private boolean mDurationSet = false;
  private Interpolator mInterpolator;
  private boolean mInterpolatorSet = false;
  private Animator.AnimatorListener mListener = null;
  ArrayList mPendingAnimations = new ArrayList();
  private long mStartDelay = 0L;
  private boolean mStartDelaySet = false;
  private final WeakReference mView;

  ViewPropertyAnimatorHC(View paramView)
  {
    this.mView = new WeakReference(paramView);
  }

  private void animateProperty(int paramInt, float paramFloat)
  {
    float f = getValue(paramInt);
    animatePropertyBy(paramInt, f, paramFloat - f);
  }

  private void animatePropertyBy(int paramInt, float paramFloat)
  {
    animatePropertyBy(paramInt, getValue(paramInt), paramFloat);
  }

  private void animatePropertyBy(int paramInt, float paramFloat1, float paramFloat2)
  {
    Animator localAnimator;
    if (this.mAnimatorMap.size() > 0)
    {
      Iterator localIterator = this.mAnimatorMap.keySet().iterator();
      ViewPropertyAnimatorHC.PropertyBundle localPropertyBundle;
      do
      {
        if (!localIterator.hasNext())
          break;
        localAnimator = (Animator)localIterator.next();
        localPropertyBundle = (ViewPropertyAnimatorHC.PropertyBundle)this.mAnimatorMap.get(localAnimator);
      }
      while ((!localPropertyBundle.cancel(paramInt)) || (localPropertyBundle.mPropertyMask != 0));
    }
    while (true)
    {
      if (localAnimator != null)
        localAnimator.cancel();
      ViewPropertyAnimatorHC.NameValuesHolder localNameValuesHolder = new ViewPropertyAnimatorHC.NameValuesHolder(paramInt, paramFloat1, paramFloat2);
      this.mPendingAnimations.add(localNameValuesHolder);
      View localView = (View)this.mView.get();
      if (localView != null)
      {
        localView.removeCallbacks(this.mAnimationStarter);
        localView.post(this.mAnimationStarter);
      }
      return;
      localAnimator = null;
    }
  }

  private float getValue(int paramInt)
  {
    View localView = (View)this.mView.get();
    if (localView != null);
    float f;
    switch (paramInt)
    {
    default:
      f = 0.0F;
    case 1:
    case 2:
    case 16:
    case 32:
    case 64:
    case 4:
    case 8:
    case 128:
    case 256:
    case 512:
    }
    while (true)
    {
      return f;
      f = localView.getTranslationX();
      continue;
      f = localView.getTranslationY();
      continue;
      f = localView.getRotation();
      continue;
      f = localView.getRotationX();
      continue;
      f = localView.getRotationY();
      continue;
      f = localView.getScaleX();
      continue;
      f = localView.getScaleY();
      continue;
      f = localView.getX();
      continue;
      f = localView.getY();
      continue;
      f = localView.getAlpha();
    }
  }

  private void setValue(int paramInt, float paramFloat)
  {
    View localView = (View)this.mView.get();
    if (localView != null)
      switch (paramInt)
      {
      default:
      case 1:
      case 2:
      case 16:
      case 32:
      case 64:
      case 4:
      case 8:
      case 128:
      case 256:
      case 512:
      }
    while (true)
    {
      return;
      localView.setTranslationX(paramFloat);
      continue;
      localView.setTranslationY(paramFloat);
      continue;
      localView.setRotation(paramFloat);
      continue;
      localView.setRotationX(paramFloat);
      continue;
      localView.setRotationY(paramFloat);
      continue;
      localView.setScaleX(paramFloat);
      continue;
      localView.setScaleY(paramFloat);
      continue;
      localView.setX(paramFloat);
      continue;
      localView.setY(paramFloat);
      continue;
      localView.setAlpha(paramFloat);
    }
  }

  private void startAnimation()
  {
    float[] arrayOfFloat = new float[1];
    arrayOfFloat[0] = 1.0F;
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(arrayOfFloat);
    ArrayList localArrayList = (ArrayList)this.mPendingAnimations.clone();
    this.mPendingAnimations.clear();
    int i = localArrayList.size();
    int j = 0;
    int k = 0;
    while (j < i)
    {
      k |= ((ViewPropertyAnimatorHC.NameValuesHolder)localArrayList.get(j)).mNameConstant;
      j++;
    }
    this.mAnimatorMap.put(localValueAnimator, new ViewPropertyAnimatorHC.PropertyBundle(k, localArrayList));
    localValueAnimator.addUpdateListener(this.mAnimatorEventListener);
    localValueAnimator.addListener(this.mAnimatorEventListener);
    if (this.mStartDelaySet)
      localValueAnimator.setStartDelay(this.mStartDelay);
    if (this.mDurationSet)
      localValueAnimator.setDuration(this.mDuration);
    if (this.mInterpolatorSet)
      localValueAnimator.setInterpolator(this.mInterpolator);
    localValueAnimator.start();
  }

  public ViewPropertyAnimator alpha(float paramFloat)
  {
    animateProperty(512, paramFloat);
    return this;
  }

  public ViewPropertyAnimator alphaBy(float paramFloat)
  {
    animatePropertyBy(512, paramFloat);
    return this;
  }

  public void cancel()
  {
    if (this.mAnimatorMap.size() > 0)
    {
      Iterator localIterator = ((HashMap)this.mAnimatorMap.clone()).keySet().iterator();
      while (localIterator.hasNext())
        ((Animator)localIterator.next()).cancel();
    }
    this.mPendingAnimations.clear();
    View localView = (View)this.mView.get();
    if (localView != null)
      localView.removeCallbacks(this.mAnimationStarter);
  }

  public long getDuration()
  {
    long l;
    if (this.mDurationSet)
      l = this.mDuration;
    while (true)
    {
      return l;
      l = new ValueAnimator().getDuration();
    }
  }

  public long getStartDelay()
  {
    long l;
    if (this.mStartDelaySet)
      l = this.mStartDelay;
    while (true)
    {
      return l;
      l = 0L;
    }
  }

  public ViewPropertyAnimator rotation(float paramFloat)
  {
    animateProperty(16, paramFloat);
    return this;
  }

  public ViewPropertyAnimator rotationBy(float paramFloat)
  {
    animatePropertyBy(16, paramFloat);
    return this;
  }

  public ViewPropertyAnimator rotationX(float paramFloat)
  {
    animateProperty(32, paramFloat);
    return this;
  }

  public ViewPropertyAnimator rotationXBy(float paramFloat)
  {
    animatePropertyBy(32, paramFloat);
    return this;
  }

  public ViewPropertyAnimator rotationY(float paramFloat)
  {
    animateProperty(64, paramFloat);
    return this;
  }

  public ViewPropertyAnimator rotationYBy(float paramFloat)
  {
    animatePropertyBy(64, paramFloat);
    return this;
  }

  public ViewPropertyAnimator scaleX(float paramFloat)
  {
    animateProperty(4, paramFloat);
    return this;
  }

  public ViewPropertyAnimator scaleXBy(float paramFloat)
  {
    animatePropertyBy(4, paramFloat);
    return this;
  }

  public ViewPropertyAnimator scaleY(float paramFloat)
  {
    animateProperty(8, paramFloat);
    return this;
  }

  public ViewPropertyAnimator scaleYBy(float paramFloat)
  {
    animatePropertyBy(8, paramFloat);
    return this;
  }

  public ViewPropertyAnimator setDuration(long paramLong)
  {
    if (paramLong < 0L)
      throw new IllegalArgumentException("Animators cannot have negative duration: " + paramLong);
    this.mDurationSet = true;
    this.mDuration = paramLong;
    return this;
  }

  public ViewPropertyAnimator setInterpolator(Interpolator paramInterpolator)
  {
    this.mInterpolatorSet = true;
    this.mInterpolator = paramInterpolator;
    return this;
  }

  public ViewPropertyAnimator setListener(Animator.AnimatorListener paramAnimatorListener)
  {
    this.mListener = paramAnimatorListener;
    return this;
  }

  public ViewPropertyAnimator setStartDelay(long paramLong)
  {
    if (paramLong < 0L)
      throw new IllegalArgumentException("Animators cannot have negative duration: " + paramLong);
    this.mStartDelaySet = true;
    this.mStartDelay = paramLong;
    return this;
  }

  public void start()
  {
    startAnimation();
  }

  public ViewPropertyAnimator translationX(float paramFloat)
  {
    animateProperty(1, paramFloat);
    return this;
  }

  public ViewPropertyAnimator translationXBy(float paramFloat)
  {
    animatePropertyBy(1, paramFloat);
    return this;
  }

  public ViewPropertyAnimator translationY(float paramFloat)
  {
    animateProperty(2, paramFloat);
    return this;
  }

  public ViewPropertyAnimator translationYBy(float paramFloat)
  {
    animatePropertyBy(2, paramFloat);
    return this;
  }

  public ViewPropertyAnimator x(float paramFloat)
  {
    animateProperty(128, paramFloat);
    return this;
  }

  public ViewPropertyAnimator xBy(float paramFloat)
  {
    animatePropertyBy(128, paramFloat);
    return this;
  }

  public ViewPropertyAnimator y(float paramFloat)
  {
    animateProperty(256, paramFloat);
    return this;
  }

  public ViewPropertyAnimator yBy(float paramFloat)
  {
    animatePropertyBy(256, paramFloat);
    return this;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.nineoldandroids.view.ViewPropertyAnimatorHC
 * JD-Core Version:    0.6.0
 */