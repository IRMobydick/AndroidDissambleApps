package com.ubercab.library.content;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.Target;

public abstract class TargetAdapter
  implements Target
{
  public void onBitmapFailed(Drawable paramDrawable)
  {
  }

  public void onBitmapLoaded(Bitmap paramBitmap, Picasso.LoadedFrom paramLoadedFrom)
  {
  }

  public void onPrepareLoad(Drawable paramDrawable)
  {
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.content.TargetAdapter
 * JD-Core Version:    0.6.2
 */