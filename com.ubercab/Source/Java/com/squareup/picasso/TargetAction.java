package com.squareup.picasso;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

final class TargetAction extends Action<Target>
{
  TargetAction(Picasso paramPicasso, Target paramTarget, Request paramRequest, boolean paramBoolean, int paramInt, Drawable paramDrawable, String paramString)
  {
    super(paramPicasso, paramTarget, paramRequest, paramBoolean, false, paramInt, paramDrawable, paramString);
  }

  void complete(Bitmap paramBitmap, Picasso.LoadedFrom paramLoadedFrom)
  {
    if (paramBitmap == null)
      throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[] { this }));
    Target localTarget = (Target)getTarget();
    if (localTarget != null)
    {
      localTarget.onBitmapLoaded(paramBitmap, paramLoadedFrom);
      if (paramBitmap.isRecycled())
        throw new IllegalStateException("Target callback must not recycle bitmap!");
    }
  }

  void error()
  {
    Target localTarget = (Target)getTarget();
    if (localTarget != null)
    {
      if (this.errorResId != 0)
        localTarget.onBitmapFailed(this.picasso.context.getResources().getDrawable(this.errorResId));
    }
    else
      return;
    localTarget.onBitmapFailed(this.errorDrawable);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.TargetAction
 * JD-Core Version:    0.6.2
 */