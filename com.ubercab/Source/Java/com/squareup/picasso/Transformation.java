package com.squareup.picasso;

import android.graphics.Bitmap;

public abstract interface Transformation
{
  public abstract String key();

  public abstract Bitmap transform(Bitmap paramBitmap);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.Transformation
 * JD-Core Version:    0.6.2
 */