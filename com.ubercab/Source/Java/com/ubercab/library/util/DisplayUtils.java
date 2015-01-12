package com.ubercab.library.util;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;

public final class DisplayUtils
{
  public static int convertDpToPixel(int paramInt)
  {
    return (int)(paramInt * Resources.getSystem().getDisplayMetrics().densityDpi / 160.0F);
  }

  public static int convertPixelToDp(float paramFloat)
  {
    return (int)(paramFloat / (Resources.getSystem().getDisplayMetrics().densityDpi / 160.0F));
  }

  public static int convertPixelToSp(float paramFloat)
  {
    return (int)(paramFloat / Resources.getSystem().getDisplayMetrics().scaledDensity);
  }

  public static int convertSpToPixel(int paramInt)
  {
    return (int)(paramInt * Resources.getSystem().getDisplayMetrics().scaledDensity);
  }

  public static int getWindowHeight(Activity paramActivity)
  {
    Rect localRect = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    return localRect.height();
  }

  public static int getWindowWidth(Activity paramActivity)
  {
    Rect localRect = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    return localRect.width();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.util.DisplayUtils
 * JD-Core Version:    0.6.2
 */