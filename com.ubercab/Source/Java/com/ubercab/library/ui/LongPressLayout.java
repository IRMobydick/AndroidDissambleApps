package com.ubercab.library.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.ubercab.library.R.styleable;

public class LongPressLayout extends FrameLayout
{
  private static final int DEFAULT_POINTER_COUNT = 2;
  private static final int DEFAULT_TRIGGER_DURATION_MS = 2000;
  private static final long VIBRATION_DURATION_MS = 50L;
  private final Handler mHandler = new Handler();
  private int mPointerCount;
  private boolean mPressing;
  private final Runnable mRunnable = new Runnable()
  {
    public void run()
    {
      LongPressLayout.this.trigger();
    }
  };
  private TriggerCallback mTriggerCallback;
  private int mTriggerDuration;
  private boolean mVibrate;
  private final Vibrator mVibrator;

  public LongPressLayout(Context paramContext)
  {
    this(paramContext, null);
  }

  public LongPressLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public LongPressLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.LongPressLayout, paramInt, 0);
    this.mPointerCount = localTypedArray.getInt(R.styleable.LongPressLayout_pointerCount, 2);
    this.mTriggerDuration = localTypedArray.getInt(R.styleable.LongPressLayout_triggerDurationMs, 2000);
    this.mVibrate = localTypedArray.getBoolean(R.styleable.LongPressLayout_vibrate, true);
    localTypedArray.recycle();
    if (isInEditMode())
    {
      this.mVibrator = null;
      return;
    }
    this.mVibrator = ((Vibrator)paramContext.getSystemService("vibrator"));
  }

  private void cancel()
  {
    stop();
    this.mHandler.removeCallbacks(this.mRunnable);
  }

  private Boolean handleTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getActionMasked())
    {
    case 4:
    default:
    case 1:
    case 3:
    case 6:
    case 0:
    case 5:
    case 2:
    }
    do
    {
      return null;
      if (this.mPressing)
        cancel();
      return Boolean.valueOf(false);
      if ((!this.mPressing) && (paramMotionEvent.getPointerCount() == this.mPointerCount))
        start();
      return Boolean.valueOf(true);
      if (paramMotionEvent.getPointerCount() == this.mPointerCount)
      {
        if (!this.mPressing)
          start();
        return Boolean.valueOf(true);
      }
      cancel();
      return null;
    }
    while (!this.mPressing);
    invalidate();
    return Boolean.valueOf(true);
  }

  private void start()
  {
    this.mPressing = true;
    this.mHandler.postDelayed(this.mRunnable, this.mTriggerDuration);
  }

  private void stop()
  {
    this.mPressing = false;
  }

  private void trigger()
  {
    stop();
    if (this.mVibrate)
      this.mVibrator.vibrate(50L);
    if (this.mTriggerCallback != null)
      this.mTriggerCallback.onTrigger();
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isEnabled())
      return false;
    if ((paramMotionEvent.getActionMasked() == 5) && (paramMotionEvent.getPointerCount() == this.mPointerCount))
    {
      start();
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isEnabled())
      return false;
    Boolean localBoolean = handleTouchEvent(paramMotionEvent);
    if (localBoolean == null)
      return super.onTouchEvent(paramMotionEvent);
    return localBoolean.booleanValue();
  }

  public void setPointerCount(int paramInt)
  {
    this.mPointerCount = paramInt;
  }

  public void setTriggerCallback(TriggerCallback paramTriggerCallback)
  {
    this.mTriggerCallback = paramTriggerCallback;
  }

  public void setVibrate(boolean paramBoolean)
  {
    this.mVibrate = paramBoolean;
  }

  public static abstract interface TriggerCallback
  {
    public abstract void onTrigger();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.ui.LongPressLayout
 * JD-Core Version:    0.6.2
 */