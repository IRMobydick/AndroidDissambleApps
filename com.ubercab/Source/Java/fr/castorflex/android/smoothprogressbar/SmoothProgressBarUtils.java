package fr.castorflex.android.smoothprogressbar;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;

public final class SmoothProgressBarUtils
{
  public static Drawable generateDrawableWithColors(int[] paramArrayOfInt, float paramFloat)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0))
      return null;
    return new ShapeDrawable(new ColorsShape(paramFloat, paramArrayOfInt));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     fr.castorflex.android.smoothprogressbar.SmoothProgressBarUtils
 * JD-Core Version:    0.6.2
 */