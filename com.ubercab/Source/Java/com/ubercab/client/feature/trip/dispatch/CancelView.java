package com.ubercab.client.feature.trip.dispatch;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnTouch;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CancelView extends LinearLayout
{

  @InjectView(2131427854)
  ImageButton mButtonCancel;
  private List<Listener> mListeners = new CopyOnWriteArrayList();

  public CancelView(Context paramContext)
  {
    super(paramContext);
  }

  public CancelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public CancelView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public void addListener(Listener paramListener)
  {
    this.mListeners.add(paramListener);
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.inject(this);
  }

  @OnTouch({2131427854})
  public boolean onTouchButtonCancel(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default:
    case 0:
    case 1:
    case 2:
    }
    while (true)
    {
      return false;
      Iterator localIterator3 = this.mListeners.iterator();
      while (localIterator3.hasNext())
        ((Listener)localIterator3.next()).onCancelPressed(true);
      Iterator localIterator2 = this.mListeners.iterator();
      while (localIterator2.hasNext())
        ((Listener)localIterator2.next()).onCancelPressed(false);
      Rect localRect = new Rect();
      this.mButtonCancel.getLocalVisibleRect(localRect);
      if (!localRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
      {
        Iterator localIterator1 = this.mListeners.iterator();
        while (localIterator1.hasNext())
          ((Listener)localIterator1.next()).onCancelPressed(false);
      }
    }
  }

  public void removeListener(Listener paramListener)
  {
    this.mListeners.remove(paramListener);
  }

  public static abstract interface Listener
  {
    public abstract void onCancelPressed(boolean paramBoolean);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.dispatch.CancelView
 * JD-Core Version:    0.6.2
 */