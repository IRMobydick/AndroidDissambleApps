package com.ubercab.client.feature.trip.map;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class MapViewExtension extends GestureDetectionLayout
{
  private static final int ZOOM_END_DISPATCH_DELAY_MS = 100;
  private List<MapTouchEventListener> mTouchEventListeners = new CopyOnWriteArrayList();
  private Handler mZoomHandler = new Handler();
  private List<Listener> mZoomListeners = new CopyOnWriteArrayList();

  public MapViewExtension(Context paramContext)
  {
    this(paramContext, null);
  }

  public MapViewExtension(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public MapViewExtension(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private void dispatchZoomEnd()
  {
    this.mZoomHandler.postDelayed(new Runnable()
    {
      public void run()
      {
        Iterator localIterator = MapViewExtension.this.mZoomListeners.iterator();
        while (localIterator.hasNext())
          ((MapViewExtension.Listener)localIterator.next()).onZoomEnd();
      }
    }
    , 100L);
  }

  public void addTouchEventListener(MapTouchEventListener paramMapTouchEventListener)
  {
    this.mTouchEventListeners.add(paramMapTouchEventListener);
  }

  public void addZoomListener(Listener paramListener)
  {
    this.mZoomListeners.add(paramListener);
  }

  protected boolean gestureDetectionEnabled()
  {
    return true;
  }

  protected boolean onGestureCanceled()
  {
    dispatchZoomEnd();
    return false;
  }

  protected boolean onPinchZoomEnd()
  {
    dispatchZoomEnd();
    return false;
  }

  protected boolean onPinchZoomStart()
  {
    Iterator localIterator = this.mZoomListeners.iterator();
    while (localIterator.hasNext())
      ((Listener)localIterator.next()).onZoomStart();
    return false;
  }

  protected boolean onTwoFingerTap()
  {
    Iterator localIterator = this.mZoomListeners.iterator();
    while (localIterator.hasNext())
      ((Listener)localIterator.next()).onTwoFingerTap();
    dispatchZoomEnd();
    return true;
  }

  public void removeTouchEventListener(MapTouchEventListener paramMapTouchEventListener)
  {
    this.mTouchEventListeners.remove(paramMapTouchEventListener);
  }

  public void removeZoomListener(Listener paramListener)
  {
    this.mZoomListeners.remove(paramListener);
  }

  protected boolean respondToAction(int paramInt)
  {
    switch (paramInt)
    {
    default:
    case 0:
    case 1:
    case 2:
    }
    while (true)
    {
      return false;
      Iterator localIterator3 = this.mTouchEventListeners.iterator();
      while (localIterator3.hasNext())
        ((MapTouchEventListener)localIterator3.next()).onMapTouchEventActionDown();
      Iterator localIterator2 = this.mTouchEventListeners.iterator();
      while (localIterator2.hasNext())
        ((MapTouchEventListener)localIterator2.next()).onMapTouchEventActionUp();
      Iterator localIterator1 = this.mTouchEventListeners.iterator();
      while (localIterator1.hasNext())
        ((MapTouchEventListener)localIterator1.next()).onMapTouchEventActionMove();
    }
  }

  static abstract interface Listener
  {
    public abstract void onTwoFingerTap();

    public abstract void onZoomEnd();

    public abstract void onZoomStart();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.map.MapViewExtension
 * JD-Core Version:    0.6.2
 */