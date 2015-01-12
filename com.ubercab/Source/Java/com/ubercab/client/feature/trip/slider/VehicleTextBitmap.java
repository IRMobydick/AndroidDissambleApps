package com.ubercab.client.feature.trip.slider;

import android.graphics.Bitmap;

public class VehicleTextBitmap
{
  private final Bitmap mBitmap;
  private final String mVehicleId;
  private final String mVehicleName;
  private final int mX;
  private final int mY;

  public VehicleTextBitmap(Bitmap paramBitmap, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.mBitmap = paramBitmap;
    this.mVehicleName = paramString1;
    this.mVehicleId = paramString2;
    this.mX = paramInt1;
    this.mY = paramInt2;
  }

  public Bitmap getBitmap()
  {
    return this.mBitmap;
  }

  public String getVehicleId()
  {
    return this.mVehicleId;
  }

  public String getVehicleName()
  {
    return this.mVehicleName;
  }

  public int getX()
  {
    return this.mX;
  }

  public int getY()
  {
    return this.mY;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.slider.VehicleTextBitmap
 * JD-Core Version:    0.6.2
 */