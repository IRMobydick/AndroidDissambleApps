package com.ubercab.client.feature.trip.driver;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.squareup.picasso.Transformation;
import com.ubercab.library.util.DisplayUtils;

class VehicleImageTransformation
  implements Transformation
{
  private static final float CROP_FACTOR_LEFT = 0.2F;
  private static final int PADDING_RIGHT_PX = DisplayUtils.convertDpToPixel(3);

  public String key()
  {
    return "vehicleTransform()";
  }

  public Bitmap transform(Bitmap paramBitmap)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    int k = (int)(0.2F * i);
    Rect localRect1 = new Rect(k, 0, i, j);
    Rect localRect2 = new Rect(0, 0, i - k, j);
    Bitmap localBitmap = Bitmap.createBitmap(i - k + PADDING_RIGHT_PX, j, Bitmap.Config.ARGB_8888);
    new Canvas(localBitmap).drawBitmap(paramBitmap, localRect1, localRect2, null);
    paramBitmap.recycle();
    return localBitmap;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.driver.VehicleImageTransformation
 * JD-Core Version:    0.6.2
 */