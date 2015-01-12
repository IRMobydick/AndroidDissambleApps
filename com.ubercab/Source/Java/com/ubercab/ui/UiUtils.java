package com.ubercab.ui;

import android.content.res.Resources;
import android.util.DisplayMetrics;

final class UiUtils
{
  static int convertPixelToSp(float paramFloat)
  {
    return (int)(paramFloat / Resources.getSystem().getDisplayMetrics().scaledDensity);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.ui.UiUtils
 * JD-Core Version:    0.6.2
 */