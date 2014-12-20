package com.google.android.gms.internal;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public final class ji
{
  public static Bitmap a(Bitmap paramBitmap)
  {
    int i = 0;
    Object localObject;
    if (paramBitmap == null)
    {
      localObject = null;
      return localObject;
    }
    int j = paramBitmap.getWidth();
    int k = paramBitmap.getHeight();
    int m;
    if (j >= k)
    {
      i = j / 2 - k / 2;
      m = 0;
    }
    while (true)
    {
      Bitmap localBitmap = Bitmap.createBitmap(k, k, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint(1);
      localPaint.setColor(-16777216);
      localCanvas.drawCircle(k / 2, k / 2, k / 2, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawBitmap(paramBitmap, i, m, localPaint);
      localObject = localBitmap;
      break;
      int n = k / 2 - j / 2;
      k = j;
    }
  }

  private static Bitmap a(Drawable paramDrawable)
  {
    Bitmap localBitmap;
    if (paramDrawable == null)
      localBitmap = null;
    while (true)
    {
      return localBitmap;
      if ((paramDrawable instanceof BitmapDrawable))
      {
        localBitmap = ((BitmapDrawable)paramDrawable).getBitmap();
        continue;
      }
      localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      paramDrawable.draw(localCanvas);
    }
  }

  public static Drawable a(Resources paramResources, Drawable paramDrawable)
  {
    return new BitmapDrawable(paramResources, a(a(paramDrawable)));
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ji
 * JD-Core Version:    0.6.0
 */