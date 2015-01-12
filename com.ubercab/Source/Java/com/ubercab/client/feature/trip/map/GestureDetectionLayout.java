package com.ubercab.client.feature.trip.map;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

abstract class GestureDetectionLayout extends RelativeLayout
{
  private Point mCenterCoordinates;
  private GestureDetector mGestureDetector;

  GestureDetectionLayout(Context paramContext)
  {
    super(paramContext);
    init();
  }

  GestureDetectionLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }

  GestureDetectionLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }

  private void init()
  {
    this.mGestureDetector = new GestureDetector();
  }

  static boolean shouldCenterGesture(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 4) || (paramInt == 5);
  }

  private MotionEvent translateMotionEventToCenter(MotionEvent paramMotionEvent)
  {
    float f1 = 0.0F;
    float f2 = 0.0F;
    int i = 0;
    int j = paramMotionEvent.getPointerCount();
    while (i < j)
    {
      f1 += paramMotionEvent.getX(i);
      f2 += paramMotionEvent.getY(i);
      i++;
    }
    float f3 = f1 / j;
    float f4 = f2 / j;
    if (this.mCenterCoordinates != null)
      paramMotionEvent.offsetLocation(this.mCenterCoordinates.x - f3, this.mCenterCoordinates.y - f4);
    return paramMotionEvent;
  }

  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = respondToAction(paramMotionEvent.getActionMasked());
    if (gestureDetectionEnabled())
    {
      int i = this.mGestureDetector.evaluate(paramMotionEvent);
      if (shouldCenterGesture(i))
        paramMotionEvent = translateMotionEventToCenter(paramMotionEvent);
      if ((!respondToGesture(i)) && (!bool1))
        break label77;
    }
    label77: for (bool1 = true; ; bool1 = false)
    {
      boolean bool2;
      if (!bool1)
      {
        boolean bool3 = super.dispatchTouchEvent(paramMotionEvent);
        bool2 = false;
        if (!bool3);
      }
      else
      {
        bool2 = true;
      }
      return bool2;
    }
  }

  boolean gestureDetectionEnabled()
  {
    return false;
  }

  boolean onDoubleTap()
  {
    return false;
  }

  boolean onGestureCanceled()
  {
    return false;
  }

  boolean onPinchZoomActive()
  {
    return false;
  }

  boolean onPinchZoomEnd()
  {
    return false;
  }

  boolean onPinchZoomStart()
  {
    return false;
  }

  boolean onTwoFingerTap()
  {
    return false;
  }

  boolean respondToAction(int paramInt)
  {
    return false;
  }

  boolean respondToGesture(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return false;
    case 2:
      return onDoubleTap();
    case 4:
      return onPinchZoomStart();
    case 5:
      return onPinchZoomActive();
    case 3:
      return onTwoFingerTap();
    case 6:
      return onPinchZoomEnd();
    case 1:
    }
    return onGestureCanceled();
  }

  void setCenterCoordinates(Point paramPoint)
  {
    this.mCenterCoordinates = paramPoint;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.map.GestureDetectionLayout
 * JD-Core Version:    0.6.2
 */