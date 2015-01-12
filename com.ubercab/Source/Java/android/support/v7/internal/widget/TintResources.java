package android.support.v7.internal.widget;

import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;

class TintResources extends Resources
{
  private final TintManager mTintManager;

  public TintResources(Resources paramResources, TintManager paramTintManager)
  {
    super(paramResources.getAssets(), paramResources.getDisplayMetrics(), paramResources.getConfiguration());
    this.mTintManager = paramTintManager;
  }

  public Drawable getDrawable(int paramInt)
    throws Resources.NotFoundException
  {
    Drawable localDrawable = super.getDrawable(paramInt);
    if (localDrawable != null)
      this.mTintManager.tintDrawable(paramInt, localDrawable);
    return localDrawable;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.TintResources
 * JD-Core Version:    0.6.2
 */