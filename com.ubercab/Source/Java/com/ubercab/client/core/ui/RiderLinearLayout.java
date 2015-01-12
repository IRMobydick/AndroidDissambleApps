package com.ubercab.client.core.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class RiderLinearLayout extends LinearLayout
{
  private List<OnLayoutSizeChangedListener> mListeners = new CopyOnWriteArrayList();

  public RiderLinearLayout(Context paramContext)
  {
    this(paramContext, null);
  }

  public RiderLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public RiderLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public void addOnLayoutSizeChangedListener(OnLayoutSizeChangedListener paramOnLayoutSizeChangedListener)
  {
    this.mListeners.add(paramOnLayoutSizeChangedListener);
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext())
      ((OnLayoutSizeChangedListener)localIterator.next()).onLayoutSizeChanged(this, paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public void removeOnLayoutSizeChangedListener(OnLayoutSizeChangedListener paramOnLayoutSizeChangedListener)
  {
    this.mListeners.remove(paramOnLayoutSizeChangedListener);
  }

  public static abstract interface OnLayoutSizeChangedListener
  {
    public abstract void onLayoutSizeChanged(RiderLinearLayout paramRiderLinearLayout, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.ui.RiderLinearLayout
 * JD-Core Version:    0.6.2
 */