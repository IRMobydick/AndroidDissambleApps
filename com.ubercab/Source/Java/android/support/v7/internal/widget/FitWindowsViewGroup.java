package android.support.v7.internal.widget;

import android.graphics.Rect;

public abstract interface FitWindowsViewGroup
{
  public abstract void setOnFitSystemWindowsListener(OnFitSystemWindowsListener paramOnFitSystemWindowsListener);

  public static abstract interface OnFitSystemWindowsListener
  {
    public abstract void onFitSystemWindows(Rect paramRect);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.FitWindowsViewGroup
 * JD-Core Version:    0.6.2
 */