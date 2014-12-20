package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import com.google.android.gms.internal.ky;

final class b extends ky
{
  protected int a(f paramf, Bitmap paramBitmap)
  {
    return paramBitmap.getHeight() * paramBitmap.getRowBytes();
  }

  protected void a(boolean paramBoolean, f paramf, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    super.a(paramBoolean, paramf, paramBitmap1, paramBitmap2);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.images.b
 * JD-Core Version:    0.6.0
 */