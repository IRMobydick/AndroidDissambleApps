package com.ubercab.library.util;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

public final class CompatUtils
{
  public static void removeOnGlobalLayoutListener(View paramView, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
  {
    if (Build.VERSION.SDK_INT > 15)
    {
      paramView.getViewTreeObserver().removeOnGlobalLayoutListener(paramOnGlobalLayoutListener);
      return;
    }
    paramView.getViewTreeObserver().removeGlobalOnLayoutListener(paramOnGlobalLayoutListener);
  }

  public static void setBackgroundDrawable(View paramView, Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView.setBackground(paramDrawable);
      return;
    }
    paramView.setBackgroundDrawable(paramDrawable);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.util.CompatUtils
 * JD-Core Version:    0.6.2
 */