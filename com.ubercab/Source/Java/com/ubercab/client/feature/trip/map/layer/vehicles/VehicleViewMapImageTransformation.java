package com.ubercab.client.feature.trip.map.layer.vehicles;

import android.graphics.Bitmap;
import com.squareup.picasso.Transformation;

final class VehicleViewMapImageTransformation
  implements Transformation
{
  public String key()
  {
    return "fixXHDPIDensity()";
  }

  public Bitmap transform(Bitmap paramBitmap)
  {
    if (paramBitmap.getDensity() != 320)
    {
      float f = paramBitmap.getDensity() / 320.0F;
      Bitmap localBitmap = Bitmap.createScaledBitmap(paramBitmap, (int)(f * paramBitmap.getWidth()), (int)(f * paramBitmap.getHeight()), true);
      paramBitmap.recycle();
      return localBitmap;
    }
    return paramBitmap;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.map.layer.vehicles.VehicleViewMapImageTransformation
 * JD-Core Version:    0.6.2
 */