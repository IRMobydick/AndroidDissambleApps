package fr.castorflex.android.smoothprogressbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;

public class SmoothProgressDrawable extends Drawable
  implements Animatable
{
  private static final long FRAME_DURATION = 16L;
  private static final float OFFSET_PER_FRAME = 0.01F;
  private final Rect fBackgroundRect = new Rect();
  private Drawable mBackgroundDrawable;
  private Rect mBounds;
  private Callbacks mCallbacks;
  private int[] mColors;
  private int mColorsIndex;
  private float mCurrentOffset;
  private int mCurrentSections;
  private boolean mFinishing;
  private float mFinishingOffset;
  private Interpolator mInterpolator;
  private int[] mLinearGradientColors;
  private float[] mLinearGradientPositions;
  private float mMaxOffset;
  private boolean mMirrorMode;
  private boolean mNewTurn;
  private Paint mPaint;
  private boolean mProgressiveStartActivated;
  private float mProgressiveStartSpeed;
  private float mProgressiveStopSpeed;
  private boolean mReversed;
  private boolean mRunning = false;
  private int mSectionsCount;
  private int mSeparatorLength;
  private float mSpeed;
  private int mStartSection;
  private float mStrokeWidth;
  private final Runnable mUpdater = new Runnable()
  {
    public void run()
    {
      if (SmoothProgressDrawable.this.isFinishing())
      {
        SmoothProgressDrawable.access$016(SmoothProgressDrawable.this, 0.01F * SmoothProgressDrawable.this.mProgressiveStopSpeed);
        SmoothProgressDrawable.access$216(SmoothProgressDrawable.this, 0.01F * SmoothProgressDrawable.this.mProgressiveStopSpeed);
        if (SmoothProgressDrawable.this.mFinishingOffset >= 1.0F)
          SmoothProgressDrawable.this.stop();
      }
      while (true)
      {
        if (SmoothProgressDrawable.this.mCurrentOffset >= SmoothProgressDrawable.this.mMaxOffset)
        {
          SmoothProgressDrawable.access$602(SmoothProgressDrawable.this, true);
          SmoothProgressDrawable.access$224(SmoothProgressDrawable.this, SmoothProgressDrawable.this.mMaxOffset);
        }
        if (SmoothProgressDrawable.this.isRunning())
          SmoothProgressDrawable.this.scheduleSelf(SmoothProgressDrawable.this.mUpdater, 16L + SystemClock.uptimeMillis());
        SmoothProgressDrawable.this.invalidateSelf();
        return;
        if (SmoothProgressDrawable.this.isStarting())
          SmoothProgressDrawable.access$216(SmoothProgressDrawable.this, 0.01F * SmoothProgressDrawable.this.mProgressiveStartSpeed);
        else
          SmoothProgressDrawable.access$216(SmoothProgressDrawable.this, 0.01F * SmoothProgressDrawable.this.mSpeed);
      }
    }
  };
  private boolean mUseGradients;

  private SmoothProgressDrawable(Interpolator paramInterpolator, int paramInt1, int paramInt2, int[] paramArrayOfInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean1, boolean paramBoolean2, Callbacks paramCallbacks, boolean paramBoolean3, Drawable paramDrawable, boolean paramBoolean4)
  {
    this.mInterpolator = paramInterpolator;
    this.mSectionsCount = paramInt1;
    this.mStartSection = 0;
    this.mCurrentSections = this.mSectionsCount;
    this.mSeparatorLength = paramInt2;
    this.mSpeed = paramFloat2;
    this.mProgressiveStartSpeed = paramFloat3;
    this.mProgressiveStopSpeed = paramFloat4;
    this.mReversed = paramBoolean1;
    this.mColors = paramArrayOfInt;
    this.mColorsIndex = 0;
    this.mMirrorMode = paramBoolean2;
    this.mFinishing = false;
    this.mBackgroundDrawable = paramDrawable;
    this.mStrokeWidth = paramFloat1;
    this.mMaxOffset = (1.0F / this.mSectionsCount);
    this.mPaint = new Paint();
    this.mPaint.setStrokeWidth(paramFloat1);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setDither(false);
    this.mPaint.setAntiAlias(false);
    this.mProgressiveStartActivated = paramBoolean3;
    this.mCallbacks = paramCallbacks;
    this.mUseGradients = paramBoolean4;
    refreshLinearGradientOptions();
  }

  private void checkColorIndex(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.mColors.length))
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(paramInt);
      throw new IllegalArgumentException(String.format("Index %d not valid", arrayOfObject));
    }
  }

  private int decrementColor(int paramInt)
  {
    int i = paramInt - 1;
    if (i < 0)
      i = -1 + this.mColors.length;
    return i;
  }

  private void drawBackground(Canvas paramCanvas, float paramFloat1, float paramFloat2)
  {
    int i = paramCanvas.save();
    paramCanvas.clipRect(paramFloat1, (int)((paramCanvas.getHeight() - this.mStrokeWidth) / 2.0F), paramFloat2, (int)((paramCanvas.getHeight() + this.mStrokeWidth) / 2.0F));
    this.mBackgroundDrawable.draw(paramCanvas);
    paramCanvas.restoreToCount(i);
  }

  private void drawBackgroundIfNeeded(Canvas paramCanvas, float paramFloat1, float paramFloat2)
  {
    if (this.mBackgroundDrawable == null);
    label190: 
    do
    {
      return;
      this.fBackgroundRect.top = ((int)((paramCanvas.getHeight() - this.mStrokeWidth) / 2.0F));
      this.fBackgroundRect.bottom = ((int)((paramCanvas.getHeight() + this.mStrokeWidth) / 2.0F));
      this.fBackgroundRect.left = 0;
      Rect localRect = this.fBackgroundRect;
      if (this.mMirrorMode);
      for (int i = paramCanvas.getWidth() / 2; ; i = paramCanvas.getWidth())
      {
        localRect.right = i;
        this.mBackgroundDrawable.setBounds(this.fBackgroundRect);
        if (isRunning())
          break label190;
        if (!this.mMirrorMode)
          break;
        paramCanvas.save();
        paramCanvas.translate(paramCanvas.getWidth() / 2, 0.0F);
        drawBackground(paramCanvas, 0.0F, this.fBackgroundRect.width());
        paramCanvas.scale(-1.0F, 1.0F);
        drawBackground(paramCanvas, 0.0F, this.fBackgroundRect.width());
        paramCanvas.restore();
        return;
      }
      drawBackground(paramCanvas, 0.0F, this.fBackgroundRect.width());
      return;
    }
    while ((!isFinishing()) && (!isStarting()));
    if (paramFloat1 > paramFloat2)
    {
      float f = paramFloat1;
      paramFloat1 = paramFloat2;
      paramFloat2 = f;
    }
    if (paramFloat1 > 0.0F)
    {
      if (!this.mMirrorMode)
        break label411;
      paramCanvas.save();
      paramCanvas.translate(paramCanvas.getWidth() / 2, 0.0F);
      if (this.mReversed)
      {
        drawBackground(paramCanvas, 0.0F, paramFloat1);
        paramCanvas.scale(-1.0F, 1.0F);
        drawBackground(paramCanvas, 0.0F, paramFloat1);
        label276: paramCanvas.restore();
      }
    }
    else
    {
      label280: if (paramFloat2 > paramCanvas.getWidth())
        break label419;
      if (!this.mMirrorMode)
        break label461;
      paramCanvas.save();
      paramCanvas.translate(paramCanvas.getWidth() / 2, 0.0F);
      if (!this.mReversed)
        break label421;
      drawBackground(paramCanvas, paramFloat2, paramCanvas.getWidth() / 2);
      paramCanvas.scale(-1.0F, 1.0F);
      drawBackground(paramCanvas, paramFloat2, paramCanvas.getWidth() / 2);
    }
    while (true)
    {
      paramCanvas.restore();
      return;
      drawBackground(paramCanvas, paramCanvas.getWidth() / 2 - paramFloat1, paramCanvas.getWidth() / 2);
      paramCanvas.scale(-1.0F, 1.0F);
      drawBackground(paramCanvas, paramCanvas.getWidth() / 2 - paramFloat1, paramCanvas.getWidth() / 2);
      break label276;
      label411: drawBackground(paramCanvas, 0.0F, paramFloat1);
      break label280;
      label419: break;
      label421: drawBackground(paramCanvas, 0.0F, paramCanvas.getWidth() / 2 - paramFloat2);
      paramCanvas.scale(-1.0F, 1.0F);
      drawBackground(paramCanvas, 0.0F, paramCanvas.getWidth() / 2 - paramFloat2);
    }
    label461: drawBackground(paramCanvas, paramFloat2, paramCanvas.getWidth());
  }

  private void drawGradient(Canvas paramCanvas)
  {
    float f1 = 1.0F / this.mSectionsCount;
    int i = this.mColorsIndex;
    this.mLinearGradientPositions[0] = 0.0F;
    this.mLinearGradientPositions[(-1 + this.mLinearGradientPositions.length)] = 1.0F;
    int j = i - 1;
    if (j < 0)
      j += this.mColors.length;
    this.mLinearGradientColors[0] = this.mColors[j];
    for (int k = 0; k < this.mSectionsCount; k++)
    {
      float f6 = this.mInterpolator.getInterpolation(f1 * k + this.mCurrentOffset);
      this.mLinearGradientPositions[(k + 1)] = f6;
      this.mLinearGradientColors[(k + 1)] = this.mColors[i];
      i = (i + 1) % this.mColors.length;
    }
    this.mLinearGradientColors[(-1 + this.mLinearGradientColors.length)] = this.mColors[i];
    int n;
    float f2;
    label200: int m;
    label223: float f3;
    label228: float f4;
    float f5;
    int[] arrayOfInt;
    float[] arrayOfFloat;
    if (this.mReversed)
      if (this.mMirrorMode)
      {
        n = Math.abs(this.mBounds.left - this.mBounds.right) / 2;
        f2 = n;
        if (!this.mMirrorMode)
          break label370;
        if (!this.mReversed)
          break label345;
        m = this.mBounds.left;
        f3 = m;
        f4 = this.mBounds.centerY() - this.mStrokeWidth / 2.0F;
        f5 = this.mBounds.centerY() + this.mStrokeWidth / 2.0F;
        arrayOfInt = this.mLinearGradientColors;
        arrayOfFloat = this.mLinearGradientPositions;
        if (!this.mMirrorMode)
          break label383;
      }
    label345: label370: label383: for (Shader.TileMode localTileMode = Shader.TileMode.MIRROR; ; localTileMode = Shader.TileMode.CLAMP)
    {
      LinearGradient localLinearGradient = new LinearGradient(f2, f4, f3, f5, arrayOfInt, arrayOfFloat, localTileMode);
      this.mPaint.setShader(localLinearGradient);
      return;
      n = this.mBounds.left;
      break;
      f2 = this.mBounds.left;
      break label200;
      m = Math.abs(this.mBounds.left - this.mBounds.right) / 2;
      break label223;
      f3 = this.mBounds.right;
      break label228;
    }
  }

  private void drawLine(Canvas paramCanvas, int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt2)
  {
    this.mPaint.setColor(this.mColors[paramInt2]);
    if (!this.mMirrorMode)
    {
      paramCanvas.drawLine(paramFloat1, paramFloat2, paramFloat3, paramFloat4, this.mPaint);
      return;
    }
    if (this.mReversed)
    {
      paramCanvas.drawLine(paramFloat1 + paramInt1, paramFloat2, paramFloat3 + paramInt1, paramFloat4, this.mPaint);
      paramCanvas.drawLine(paramInt1 - paramFloat1, paramFloat2, paramInt1 - paramFloat3, paramFloat4, this.mPaint);
      return;
    }
    paramCanvas.drawLine(paramFloat1, paramFloat2, paramFloat3, paramFloat4, this.mPaint);
    paramCanvas.drawLine(paramInt1 * 2 - paramFloat1, paramFloat2, paramInt1 * 2 - paramFloat3, paramFloat4, this.mPaint);
  }

  private void drawStrokes(Canvas paramCanvas)
  {
    if (this.mReversed)
    {
      paramCanvas.translate(this.mBounds.width(), 0.0F);
      paramCanvas.scale(-1.0F, 1.0F);
    }
    float f1 = 0.0F;
    int i = this.mBounds.width();
    if (this.mMirrorMode)
      i /= 2;
    int j = i + this.mSeparatorLength + this.mSectionsCount;
    int k = this.mBounds.centerY();
    float f2 = 1.0F / this.mSectionsCount;
    float f3 = 0.0F;
    int m = this.mColorsIndex;
    int n = this.mStartSection;
    int i1 = this.mCurrentSections;
    float f4 = 0.0F;
    if (n == i1)
    {
      int i3 = this.mCurrentSections;
      int i4 = this.mSectionsCount;
      f4 = 0.0F;
      if (i3 == i4)
        f4 = paramCanvas.getWidth();
    }
    int i2 = 0;
    if (i2 <= this.mCurrentSections)
    {
      float f5 = f2 * i2 + this.mCurrentOffset;
      float f6 = Math.max(0.0F, f5 - f2);
      float f7 = (int)(Math.abs(this.mInterpolator.getInterpolation(f6) - this.mInterpolator.getInterpolation(Math.min(f5, 1.0F))) * j);
      float f8;
      if (f7 + f6 < j)
      {
        f8 = Math.min(f7, this.mSeparatorLength);
        label237: if (f7 <= f8)
          break label393;
      }
      label393: for (float f9 = f7 - f8; ; f9 = 0.0F)
      {
        float f10 = f1 + f9;
        if ((f10 > f1) && (i2 >= this.mStartSection))
        {
          float f11 = Math.max(this.mInterpolator.getInterpolation(Math.min(this.mFinishingOffset, 1.0F)) * j, Math.min(i, f1));
          float f12 = Math.min(i, f10);
          drawLine(paramCanvas, i, f11, k, f12, k, m);
          if (i2 == this.mStartSection)
            f4 = f11 - this.mSeparatorLength;
        }
        if (i2 == this.mCurrentSections)
          f3 = f1 + f7;
        f1 = f10 + f8;
        m = incrementColor(m);
        i2++;
        break;
        f8 = 0.0F;
        break label237;
      }
    }
    drawBackgroundIfNeeded(paramCanvas, f4, f3);
  }

  private int incrementColor(int paramInt)
  {
    int i = paramInt + 1;
    if (i >= this.mColors.length)
      i = 0;
    return i;
  }

  private void resetProgressiveStart(int paramInt)
  {
    checkColorIndex(paramInt);
    this.mCurrentOffset = 0.0F;
    this.mFinishing = false;
    this.mFinishingOffset = 0.0F;
    this.mStartSection = 0;
    this.mCurrentSections = 0;
    this.mColorsIndex = paramInt;
  }

  public void draw(Canvas paramCanvas)
  {
    this.mBounds = getBounds();
    paramCanvas.clipRect(this.mBounds);
    if (this.mNewTurn)
    {
      this.mColorsIndex = decrementColor(this.mColorsIndex);
      this.mNewTurn = false;
      if (isFinishing())
      {
        this.mStartSection = (1 + this.mStartSection);
        if (this.mStartSection > this.mSectionsCount)
        {
          stop();
          return;
        }
      }
      if (this.mCurrentSections < this.mSectionsCount)
        this.mCurrentSections = (1 + this.mCurrentSections);
    }
    if (this.mUseGradients)
      drawGradient(paramCanvas);
    drawStrokes(paramCanvas);
  }

  public Drawable getBackgroundDrawable()
  {
    return this.mBackgroundDrawable;
  }

  public int[] getColors()
  {
    return this.mColors;
  }

  public int getOpacity()
  {
    return -2;
  }

  public float getStrokeWidth()
  {
    return this.mStrokeWidth;
  }

  public boolean isFinishing()
  {
    return this.mFinishing;
  }

  public boolean isRunning()
  {
    return this.mRunning;
  }

  public boolean isStarting()
  {
    return this.mCurrentSections < this.mSectionsCount;
  }

  public void progressiveStart()
  {
    progressiveStart(0);
  }

  public void progressiveStart(int paramInt)
  {
    resetProgressiveStart(paramInt);
    start();
  }

  public void progressiveStop()
  {
    this.mFinishing = true;
    this.mStartSection = 0;
  }

  protected void refreshLinearGradientOptions()
  {
    if (this.mUseGradients)
    {
      this.mLinearGradientColors = new int[2 + this.mSectionsCount];
      this.mLinearGradientPositions = new float[2 + this.mSectionsCount];
      return;
    }
    this.mPaint.setShader(null);
    this.mLinearGradientColors = null;
    this.mLinearGradientPositions = null;
  }

  public void scheduleSelf(Runnable paramRunnable, long paramLong)
  {
    this.mRunning = true;
    super.scheduleSelf(paramRunnable, paramLong);
  }

  public void setAlpha(int paramInt)
  {
    this.mPaint.setAlpha(paramInt);
  }

  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    if (this.mBackgroundDrawable == paramDrawable)
      return;
    this.mBackgroundDrawable = paramDrawable;
    invalidateSelf();
  }

  public void setCallbacks(Callbacks paramCallbacks)
  {
    this.mCallbacks = paramCallbacks;
  }

  public void setColor(int paramInt)
  {
    setColors(new int[] { paramInt });
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mPaint.setColorFilter(paramColorFilter);
  }

  public void setColors(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0))
      throw new IllegalArgumentException("Colors cannot be null or empty");
    this.mColorsIndex = 0;
    this.mColors = paramArrayOfInt;
    refreshLinearGradientOptions();
    invalidateSelf();
  }

  public void setInterpolator(Interpolator paramInterpolator)
  {
    if (paramInterpolator == null)
      throw new IllegalArgumentException("Interpolator cannot be null");
    this.mInterpolator = paramInterpolator;
    invalidateSelf();
  }

  public void setMirrorMode(boolean paramBoolean)
  {
    if (this.mMirrorMode == paramBoolean)
      return;
    this.mMirrorMode = paramBoolean;
    invalidateSelf();
  }

  public void setProgressiveStartActivated(boolean paramBoolean)
  {
    this.mProgressiveStartActivated = paramBoolean;
  }

  public void setProgressiveStartSpeed(float paramFloat)
  {
    if (paramFloat < 0.0F)
      throw new IllegalArgumentException("SpeedProgressiveStart must be >= 0");
    this.mProgressiveStartSpeed = paramFloat;
    invalidateSelf();
  }

  public void setProgressiveStopSpeed(float paramFloat)
  {
    if (paramFloat < 0.0F)
      throw new IllegalArgumentException("SpeedProgressiveStop must be >= 0");
    this.mProgressiveStopSpeed = paramFloat;
    invalidateSelf();
  }

  public void setReversed(boolean paramBoolean)
  {
    if (this.mReversed == paramBoolean)
      return;
    this.mReversed = paramBoolean;
    invalidateSelf();
  }

  public void setSectionsCount(int paramInt)
  {
    if (paramInt <= 0)
      throw new IllegalArgumentException("SectionsCount must be > 0");
    this.mSectionsCount = paramInt;
    this.mMaxOffset = (1.0F / this.mSectionsCount);
    this.mCurrentOffset %= this.mMaxOffset;
    refreshLinearGradientOptions();
    invalidateSelf();
  }

  public void setSeparatorLength(int paramInt)
  {
    if (paramInt < 0)
      throw new IllegalArgumentException("SeparatorLength must be >= 0");
    this.mSeparatorLength = paramInt;
    invalidateSelf();
  }

  public void setSpeed(float paramFloat)
  {
    if (paramFloat < 0.0F)
      throw new IllegalArgumentException("Speed must be >= 0");
    this.mSpeed = paramFloat;
    invalidateSelf();
  }

  public void setStrokeWidth(float paramFloat)
  {
    if (paramFloat < 0.0F)
      throw new IllegalArgumentException("The strokeWidth must be >= 0");
    this.mPaint.setStrokeWidth(paramFloat);
    invalidateSelf();
  }

  public void setUseGradients(boolean paramBoolean)
  {
    if (this.mUseGradients == paramBoolean)
      return;
    this.mUseGradients = paramBoolean;
    refreshLinearGradientOptions();
    invalidateSelf();
  }

  public void start()
  {
    if (this.mProgressiveStartActivated)
      resetProgressiveStart(0);
    if (isRunning())
      return;
    if (this.mCallbacks != null)
      this.mCallbacks.onStart();
    scheduleSelf(this.mUpdater, 16L + SystemClock.uptimeMillis());
    invalidateSelf();
  }

  public void stop()
  {
    if (!isRunning())
      return;
    if (this.mCallbacks != null)
      this.mCallbacks.onStop();
    this.mRunning = false;
    unscheduleSelf(this.mUpdater);
  }

  public static class Builder
  {
    private Drawable mBackgroundDrawableWhenHidden;
    private int[] mColors;
    private boolean mGenerateBackgroundUsingColors;
    private boolean mGradients;
    private Interpolator mInterpolator;
    private boolean mMirrorMode;
    private SmoothProgressDrawable.Callbacks mOnProgressiveStopEndedListener;
    private boolean mProgressiveStartActivated;
    private float mProgressiveStartSpeed;
    private float mProgressiveStopSpeed;
    private boolean mReversed;
    private int mSectionsCount;
    private float mSpeed;
    private int mStrokeSeparatorLength;
    private float mStrokeWidth;

    public Builder(Context paramContext)
    {
      initValues(paramContext);
    }

    private void initValues(Context paramContext)
    {
      Resources localResources = paramContext.getResources();
      this.mInterpolator = new AccelerateInterpolator();
      this.mSectionsCount = localResources.getInteger(R.integer.spb_default_sections_count);
      int[] arrayOfInt = new int[1];
      arrayOfInt[0] = localResources.getColor(R.color.spb_default_color);
      this.mColors = arrayOfInt;
      this.mSpeed = Float.parseFloat(localResources.getString(R.string.spb_default_speed));
      this.mProgressiveStartSpeed = this.mSpeed;
      this.mProgressiveStopSpeed = this.mSpeed;
      this.mReversed = localResources.getBoolean(R.bool.spb_default_reversed);
      this.mStrokeSeparatorLength = localResources.getDimensionPixelSize(R.dimen.spb_default_stroke_separator_length);
      this.mStrokeWidth = localResources.getDimensionPixelOffset(R.dimen.spb_default_stroke_width);
      this.mProgressiveStartActivated = localResources.getBoolean(R.bool.spb_default_progressiveStart_activated);
      this.mGradients = false;
    }

    public Builder backgroundDrawable(Drawable paramDrawable)
    {
      this.mBackgroundDrawableWhenHidden = paramDrawable;
      return this;
    }

    public SmoothProgressDrawable build()
    {
      if (this.mGenerateBackgroundUsingColors)
        this.mBackgroundDrawableWhenHidden = SmoothProgressBarUtils.generateDrawableWithColors(this.mColors, this.mStrokeWidth);
      return new SmoothProgressDrawable(this.mInterpolator, this.mSectionsCount, this.mStrokeSeparatorLength, this.mColors, this.mStrokeWidth, this.mSpeed, this.mProgressiveStartSpeed, this.mProgressiveStopSpeed, this.mReversed, this.mMirrorMode, this.mOnProgressiveStopEndedListener, this.mProgressiveStartActivated, this.mBackgroundDrawableWhenHidden, this.mGradients, null);
    }

    public Builder callbacks(SmoothProgressDrawable.Callbacks paramCallbacks)
    {
      this.mOnProgressiveStopEndedListener = paramCallbacks;
      return this;
    }

    public Builder color(int paramInt)
    {
      this.mColors = new int[] { paramInt };
      return this;
    }

    public Builder colors(int[] paramArrayOfInt)
    {
      if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0))
        throw new IllegalArgumentException("Your color array must not be empty");
      this.mColors = paramArrayOfInt;
      return this;
    }

    public Builder generateBackgroundUsingColors()
    {
      this.mGenerateBackgroundUsingColors = true;
      return this;
    }

    public Builder gradients()
    {
      return gradients(true);
    }

    public Builder gradients(boolean paramBoolean)
    {
      this.mGradients = paramBoolean;
      return this;
    }

    public Builder interpolator(Interpolator paramInterpolator)
    {
      if (paramInterpolator == null)
        throw new IllegalArgumentException("Interpolator can't be null");
      this.mInterpolator = paramInterpolator;
      return this;
    }

    public Builder mirrorMode(boolean paramBoolean)
    {
      this.mMirrorMode = paramBoolean;
      return this;
    }

    public Builder progressiveStart(boolean paramBoolean)
    {
      this.mProgressiveStartActivated = paramBoolean;
      return this;
    }

    public Builder progressiveStartSpeed(float paramFloat)
    {
      if (paramFloat < 0.0F)
        throw new IllegalArgumentException("progressiveStartSpeed must be >= 0");
      this.mProgressiveStartSpeed = paramFloat;
      return this;
    }

    public Builder progressiveStopSpeed(float paramFloat)
    {
      if (paramFloat < 0.0F)
        throw new IllegalArgumentException("progressiveStopSpeed must be >= 0");
      this.mProgressiveStopSpeed = paramFloat;
      return this;
    }

    public Builder reversed(boolean paramBoolean)
    {
      this.mReversed = paramBoolean;
      return this;
    }

    public Builder sectionsCount(int paramInt)
    {
      if (paramInt <= 0)
        throw new IllegalArgumentException("SectionsCount must be > 0");
      this.mSectionsCount = paramInt;
      return this;
    }

    public Builder separatorLength(int paramInt)
    {
      if (paramInt < 0)
        throw new IllegalArgumentException("SeparatorLength must be >= 0");
      this.mStrokeSeparatorLength = paramInt;
      return this;
    }

    public Builder speed(float paramFloat)
    {
      if (paramFloat < 0.0F)
        throw new IllegalArgumentException("Speed must be >= 0");
      this.mSpeed = paramFloat;
      return this;
    }

    public Builder strokeWidth(float paramFloat)
    {
      if (paramFloat < 0.0F)
        throw new IllegalArgumentException("The width must be >= 0");
      this.mStrokeWidth = paramFloat;
      return this;
    }
  }

  public static abstract interface Callbacks
  {
    public abstract void onStart();

    public abstract void onStop();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     fr.castorflex.android.smoothprogressbar.SmoothProgressDrawable
 * JD-Core Version:    0.6.2
 */