package com.ubercab.client.feature.trip.map;

import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.ubercab.client.core.util.MathUtils;

final class GestureDetector
{
  private static final float DRAG_MIN_DISTANCE = 10.0F;
  public static final int GESTURE_CANCELED = 1;
  public static final int GESTURE_DEFAULT = 0;
  public static final int GESTURE_DOUBLE_TAP = 2;
  public static final int GESTURE_PINCH_ZOOM_ACTIVE = 5;
  public static final int GESTURE_PINCH_ZOOM_END = 6;
  public static final int GESTURE_PINCH_ZOOM_START = 4;
  public static final int GESTURE_TWO_FINGER_TAP = 3;
  private SparseArray<Long> mActionTimestamps = new SparseArray();
  private float mPinchEndDistance;
  private float mPinchStartDistance;
  private Long mPreviousActionUpTimestamp;

  private void cleanUpTimestampsAndStates()
  {
    this.mPreviousActionUpTimestamp = ((Long)this.mActionTimestamps.get(1));
    this.mActionTimestamps.clear();
    this.mPinchStartDistance = 0.0F;
    this.mPinchEndDistance = 0.0F;
  }

  int evaluate(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    int j = paramMotionEvent.getPointerCount();
    this.mActionTimestamps.put(i, Long.valueOf(System.currentTimeMillis()));
    switch (i)
    {
    case 4:
    default:
    case 5:
    case 2:
      do
      {
        return 0;
        this.mPinchStartDistance = MathUtils.distance(paramMotionEvent.getX(0), paramMotionEvent.getY(0), paramMotionEvent.getX(1), paramMotionEvent.getY(1));
        return 4;
      }
      while (j <= 1);
      return 5;
    case 6:
      this.mPinchEndDistance = MathUtils.distance(paramMotionEvent.getX(0), paramMotionEvent.getY(0), paramMotionEvent.getX(1), paramMotionEvent.getY(1));
      return 0;
    case 1:
      long l1;
      long l2;
      int k;
      if (this.mPreviousActionUpTimestamp != null)
      {
        l1 = this.mPreviousActionUpTimestamp.longValue();
        l2 = ViewConfiguration.getDoubleTapTimeout();
        if ((this.mActionTimestamps.get(5) == null) || (this.mActionTimestamps.get(6) == null))
          break label217;
        if (Math.abs(this.mPinchEndDistance - this.mPinchStartDistance) >= 10.0F)
          break label210;
        k = 3;
      }
      while (true)
      {
        cleanUpTimestampsAndStates();
        return k;
        l1 = 0L;
        break;
        label210: k = 6;
        continue;
        label217: boolean bool = ((Long)this.mActionTimestamps.get(0)).longValue() - l1 < l2;
        k = 0;
        if (!bool)
          k = 2;
      }
    case 3:
    }
    cleanUpTimestampsAndStates();
    return 0;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.map.GestureDetector
 * JD-Core Version:    0.6.2
 */