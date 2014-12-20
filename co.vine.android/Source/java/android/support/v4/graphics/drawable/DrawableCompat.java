package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

public class DrawableCompat
{
  static final DrawableImpl IMPL;

  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 19)
      IMPL = new DrawableCompat.KitKatDrawableImpl();
    while (true)
    {
      return;
      if (i >= 11)
      {
        IMPL = new DrawableCompat.HoneycombDrawableImpl();
        continue;
      }
      IMPL = new DrawableCompat.BaseDrawableImpl();
    }
  }

  public static boolean isAutoMirrored(Drawable paramDrawable)
  {
    return IMPL.isAutoMirrored(paramDrawable);
  }

  public static void jumpToCurrentState(Drawable paramDrawable)
  {
    IMPL.jumpToCurrentState(paramDrawable);
  }

  public static void setAutoMirrored(Drawable paramDrawable, boolean paramBoolean)
  {
    IMPL.setAutoMirrored(paramDrawable, paramBoolean);
  }

  static abstract interface DrawableImpl
  {
    public abstract boolean isAutoMirrored(Drawable paramDrawable);

    public abstract void jumpToCurrentState(Drawable paramDrawable);

    public abstract void setAutoMirrored(Drawable paramDrawable, boolean paramBoolean);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.graphics.drawable.DrawableCompat
 * JD-Core Version:    0.6.0
 */