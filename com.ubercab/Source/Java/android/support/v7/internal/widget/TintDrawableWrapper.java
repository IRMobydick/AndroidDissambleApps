package android.support.v7.internal.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;

class TintDrawableWrapper extends DrawableWrapper
{
  private int mCurrentColor;
  private final PorterDuff.Mode mTintMode;
  private final ColorStateList mTintStateList;

  public TintDrawableWrapper(Drawable paramDrawable, ColorStateList paramColorStateList)
  {
    this(paramDrawable, paramColorStateList, TintManager.DEFAULT_MODE);
  }

  public TintDrawableWrapper(Drawable paramDrawable, ColorStateList paramColorStateList, PorterDuff.Mode paramMode)
  {
    super(paramDrawable);
    this.mTintStateList = paramColorStateList;
    this.mTintMode = paramMode;
  }

  private boolean updateTint(int[] paramArrayOfInt)
  {
    if (this.mTintStateList != null)
    {
      int i = this.mTintStateList.getColorForState(paramArrayOfInt, this.mCurrentColor);
      if (i != this.mCurrentColor)
      {
        if (i != 0)
          setColorFilter(i, this.mTintMode);
        while (true)
        {
          this.mCurrentColor = i;
          return true;
          clearColorFilter();
        }
      }
    }
    return false;
  }

  public boolean isStateful()
  {
    return ((this.mTintStateList != null) && (this.mTintStateList.isStateful())) || (super.isStateful());
  }

  public boolean setState(int[] paramArrayOfInt)
  {
    boolean bool = super.setState(paramArrayOfInt);
    return (updateTint(paramArrayOfInt)) || (bool);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.TintDrawableWrapper
 * JD-Core Version:    0.6.2
 */