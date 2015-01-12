package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import java.nio.ByteBuffer;

public final class BitmapDescriptor
{
  Bitmap a;

  BitmapDescriptor(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
      this.a = a(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight());
  }

  private Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setFilterBitmap(true);
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
    return localBitmap;
  }

  byte[] a()
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4 * (this.a.getWidth() * this.a.getHeight()));
    this.a.copyPixelsToBuffer(localByteBuffer);
    return localByteBuffer.array();
  }

  Bundle b()
  {
    if (this.a == null)
      throw new IllegalStateException("the bitmap has been recycled! you can not use it again");
    Bundle localBundle = new Bundle();
    localBundle.putString("image_hashcode", System.currentTimeMillis() + "_" + hashCode());
    localBundle.putInt("image_width", this.a.getWidth());
    localBundle.putInt("image_height", this.a.getHeight());
    localBundle.putByteArray("image_data", a());
    return localBundle;
  }

  public void recycle()
  {
    if ((this.a != null) && (!this.a.isRecycled()))
    {
      this.a.recycle();
      this.a = null;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.map.BitmapDescriptor
 * JD-Core Version:    0.6.2
 */