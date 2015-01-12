package com.ubercab.library.util;

import android.graphics.Bitmap;

public final class BitmapUtils
{
  public static Bitmap scaleToMaxSize(Bitmap paramBitmap, int paramInt)
  {
    float f1 = paramBitmap.getWidth();
    float f2 = paramBitmap.getHeight();
    if (f1 > f2)
      return Bitmap.createScaledBitmap(paramBitmap, paramInt, (int)(f2 * paramInt / f1), true);
    return Bitmap.createScaledBitmap(paramBitmap, (int)(f1 * paramInt / f2), paramInt, true);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.util.BitmapUtils
 * JD-Core Version:    0.6.2
 */