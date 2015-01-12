package fr.castorflex.android.smoothprogressbar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;

public class SmoothProgressBar extends ProgressBar
{
  private static final int INTERPOLATOR_ACCELERATE = 0;
  private static final int INTERPOLATOR_ACCELERATEDECELERATE = 2;
  private static final int INTERPOLATOR_DECELERATE = 3;
  private static final int INTERPOLATOR_LINEAR = 1;

  public SmoothProgressBar(Context paramContext)
  {
    this(paramContext, null);
  }

  public SmoothProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.spbStyle);
  }

  public SmoothProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (isInEditMode())
    {
      SmoothProgressDrawable.Builder localBuilder1 = new SmoothProgressDrawable.Builder(paramContext);
      setIndeterminateDrawable(localBuilder1.build());
      return;
    }
    Resources localResources = paramContext.getResources();
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SmoothProgressBar, paramInt, 0);
    int i = localTypedArray.getColor(1, localResources.getColor(R.color.spb_default_color));
    int j = localTypedArray.getInteger(4, localResources.getInteger(R.integer.spb_default_sections_count));
    int k = localTypedArray.getDimensionPixelSize(3, localResources.getDimensionPixelSize(R.dimen.spb_default_stroke_separator_length));
    float f1 = localTypedArray.getDimension(2, localResources.getDimension(R.dimen.spb_default_stroke_width));
    float f2 = localTypedArray.getFloat(5, Float.parseFloat(localResources.getString(R.string.spb_default_speed)));
    float f3 = localTypedArray.getFloat(6, f2);
    float f4 = localTypedArray.getFloat(7, f2);
    int m = localTypedArray.getInteger(8, -1);
    boolean bool1 = localTypedArray.getBoolean(9, localResources.getBoolean(R.bool.spb_default_reversed));
    boolean bool2 = localTypedArray.getBoolean(10, localResources.getBoolean(R.bool.spb_default_mirror_mode));
    int n = localTypedArray.getResourceId(11, 0);
    boolean bool3 = localTypedArray.getBoolean(12, localResources.getBoolean(R.bool.spb_default_progressiveStart_activated));
    Drawable localDrawable = localTypedArray.getDrawable(13);
    boolean bool4 = localTypedArray.getBoolean(14, false);
    boolean bool5 = localTypedArray.getBoolean(15, false);
    localTypedArray.recycle();
    Object localObject = null;
    if (m == -1)
      localObject = getInterpolator();
    if (localObject == null);
    SmoothProgressDrawable.Builder localBuilder3;
    switch (m)
    {
    default:
      localObject = new AccelerateInterpolator();
      int[] arrayOfInt = null;
      if (n != 0)
        arrayOfInt = localResources.getIntArray(n);
      SmoothProgressDrawable.Builder localBuilder2 = new SmoothProgressDrawable.Builder(paramContext);
      localBuilder3 = localBuilder2.speed(f2).progressiveStartSpeed(f3).progressiveStopSpeed(f4).interpolator((Interpolator)localObject).sectionsCount(j).separatorLength(k).strokeWidth(f1).reversed(bool1).mirrorMode(bool2).progressiveStart(bool3).gradients(bool5);
      if (localDrawable != null)
        localBuilder3.backgroundDrawable(localDrawable);
      if (bool4)
        localBuilder3.generateBackgroundUsingColors();
      if ((arrayOfInt != null) && (arrayOfInt.length > 0))
        localBuilder3.colors(arrayOfInt);
      break;
    case 2:
    case 3:
    case 1:
    }
    while (true)
    {
      setIndeterminateDrawable(localBuilder3.build());
      return;
      localObject = new AccelerateDecelerateInterpolator();
      break;
      localObject = new DecelerateInterpolator();
      break;
      localObject = new LinearInterpolator();
      break;
      localBuilder3.color(i);
    }
  }

  private SmoothProgressDrawable checkIndeterminateDrawable()
  {
    Drawable localDrawable = getIndeterminateDrawable();
    if ((localDrawable == null) || (!(localDrawable instanceof SmoothProgressDrawable)))
      throw new RuntimeException("The drawable is not a SmoothProgressDrawable");
    return (SmoothProgressDrawable)localDrawable;
  }

  public void applyStyle(int paramInt)
  {
    TypedArray localTypedArray = getContext().obtainStyledAttributes(null, R.styleable.SmoothProgressBar, 0, paramInt);
    if (localTypedArray.hasValue(1))
      setSmoothProgressDrawableColor(localTypedArray.getColor(1, 0));
    if (localTypedArray.hasValue(11))
    {
      int i = localTypedArray.getResourceId(11, 0);
      if (i != 0)
      {
        int[] arrayOfInt = getResources().getIntArray(i);
        if ((arrayOfInt != null) && (arrayOfInt.length > 0))
          setSmoothProgressDrawableColors(arrayOfInt);
      }
    }
    if (localTypedArray.hasValue(4))
      setSmoothProgressDrawableSectionsCount(localTypedArray.getInteger(4, 0));
    if (localTypedArray.hasValue(3))
      setSmoothProgressDrawableSeparatorLength(localTypedArray.getDimensionPixelSize(3, 0));
    if (localTypedArray.hasValue(2))
      setSmoothProgressDrawableStrokeWidth(localTypedArray.getDimension(2, 0.0F));
    if (localTypedArray.hasValue(5))
      setSmoothProgressDrawableSpeed(localTypedArray.getFloat(5, 0.0F));
    if (localTypedArray.hasValue(6))
      setSmoothProgressDrawableProgressiveStartSpeed(localTypedArray.getFloat(6, 0.0F));
    if (localTypedArray.hasValue(7))
      setSmoothProgressDrawableProgressiveStopSpeed(localTypedArray.getFloat(7, 0.0F));
    if (localTypedArray.hasValue(9))
      setSmoothProgressDrawableReversed(localTypedArray.getBoolean(9, false));
    if (localTypedArray.hasValue(10))
      setSmoothProgressDrawableMirrorMode(localTypedArray.getBoolean(10, false));
    if (localTypedArray.hasValue(12))
      setProgressiveStartActivated(localTypedArray.getBoolean(12, false));
    if (localTypedArray.hasValue(12))
      setProgressiveStartActivated(localTypedArray.getBoolean(12, false));
    if (localTypedArray.hasValue(15))
      setSmoothProgressDrawableUseGradients(localTypedArray.getBoolean(15, false));
    if ((localTypedArray.hasValue(14)) && (localTypedArray.getBoolean(14, false)))
      setSmoothProgressDrawableBackgroundDrawable(SmoothProgressBarUtils.generateDrawableWithColors(checkIndeterminateDrawable().getColors(), checkIndeterminateDrawable().getStrokeWidth()));
    Object localObject;
    if (localTypedArray.hasValue(8))
      switch (localTypedArray.getInteger(8, -1))
      {
      default:
        localObject = null;
      case 2:
      case 3:
      case 1:
      case 0:
      }
    while (true)
    {
      if (localObject != null)
        setInterpolator((Interpolator)localObject);
      localTypedArray.recycle();
      return;
      localObject = new AccelerateDecelerateInterpolator();
      continue;
      localObject = new DecelerateInterpolator();
      continue;
      localObject = new LinearInterpolator();
      continue;
      localObject = new AccelerateInterpolator();
    }
  }

  protected void onDraw(Canvas paramCanvas)
  {
    try
    {
      super.onDraw(paramCanvas);
      if ((isIndeterminate()) && ((getIndeterminateDrawable() instanceof SmoothProgressDrawable)) && (!((SmoothProgressDrawable)getIndeterminateDrawable()).isRunning()))
        getIndeterminateDrawable().draw(paramCanvas);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void progressiveStart()
  {
    checkIndeterminateDrawable().progressiveStart();
  }

  public void progressiveStop()
  {
    checkIndeterminateDrawable().progressiveStop();
  }

  public void setInterpolator(Interpolator paramInterpolator)
  {
    super.setInterpolator(paramInterpolator);
    Drawable localDrawable = getIndeterminateDrawable();
    if ((localDrawable != null) && ((localDrawable instanceof SmoothProgressDrawable)))
      ((SmoothProgressDrawable)localDrawable).setInterpolator(paramInterpolator);
  }

  public void setProgressiveStartActivated(boolean paramBoolean)
  {
    checkIndeterminateDrawable().setProgressiveStartActivated(paramBoolean);
  }

  public void setSmoothProgressDrawableBackgroundDrawable(Drawable paramDrawable)
  {
    checkIndeterminateDrawable().setBackgroundDrawable(paramDrawable);
  }

  public void setSmoothProgressDrawableCallbacks(SmoothProgressDrawable.Callbacks paramCallbacks)
  {
    checkIndeterminateDrawable().setCallbacks(paramCallbacks);
  }

  public void setSmoothProgressDrawableColor(int paramInt)
  {
    checkIndeterminateDrawable().setColor(paramInt);
  }

  public void setSmoothProgressDrawableColors(int[] paramArrayOfInt)
  {
    checkIndeterminateDrawable().setColors(paramArrayOfInt);
  }

  public void setSmoothProgressDrawableInterpolator(Interpolator paramInterpolator)
  {
    checkIndeterminateDrawable().setInterpolator(paramInterpolator);
  }

  public void setSmoothProgressDrawableMirrorMode(boolean paramBoolean)
  {
    checkIndeterminateDrawable().setMirrorMode(paramBoolean);
  }

  public void setSmoothProgressDrawableProgressiveStartSpeed(float paramFloat)
  {
    checkIndeterminateDrawable().setProgressiveStartSpeed(paramFloat);
  }

  public void setSmoothProgressDrawableProgressiveStopSpeed(float paramFloat)
  {
    checkIndeterminateDrawable().setProgressiveStopSpeed(paramFloat);
  }

  public void setSmoothProgressDrawableReversed(boolean paramBoolean)
  {
    checkIndeterminateDrawable().setReversed(paramBoolean);
  }

  public void setSmoothProgressDrawableSectionsCount(int paramInt)
  {
    checkIndeterminateDrawable().setSectionsCount(paramInt);
  }

  public void setSmoothProgressDrawableSeparatorLength(int paramInt)
  {
    checkIndeterminateDrawable().setSeparatorLength(paramInt);
  }

  public void setSmoothProgressDrawableSpeed(float paramFloat)
  {
    checkIndeterminateDrawable().setSpeed(paramFloat);
  }

  public void setSmoothProgressDrawableStrokeWidth(float paramFloat)
  {
    checkIndeterminateDrawable().setStrokeWidth(paramFloat);
  }

  public void setSmoothProgressDrawableUseGradients(boolean paramBoolean)
  {
    checkIndeterminateDrawable().setUseGradients(paramBoolean);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     fr.castorflex.android.smoothprogressbar.SmoothProgressBar
 * JD-Core Version:    0.6.2
 */