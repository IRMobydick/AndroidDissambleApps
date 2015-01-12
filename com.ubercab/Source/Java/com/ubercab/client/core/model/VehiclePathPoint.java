package com.ubercab.client.core.model;

import com.ubercab.library.location.model.UberLatLng;

public final class VehiclePathPoint
{
  private Float course;
  private Long epoch;
  private Double latitude;
  private Double longitude;

  public VehiclePathPoint()
  {
  }

  public VehiclePathPoint(long paramLong, UberLatLng paramUberLatLng, float paramFloat)
  {
    this.epoch = Long.valueOf(paramLong);
    this.latitude = Double.valueOf(paramUberLatLng.getLatitude());
    this.longitude = Double.valueOf(paramUberLatLng.getLongitude());
    this.course = Float.valueOf(paramFloat);
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    VehiclePathPoint localVehiclePathPoint;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localVehiclePathPoint = (VehiclePathPoint)paramObject;
      if (this.course != null)
      {
        if (this.course.equals(localVehiclePathPoint.course));
      }
      else
        while (localVehiclePathPoint.course != null)
          return false;
      if (this.epoch != null)
      {
        if (this.epoch.equals(localVehiclePathPoint.epoch));
      }
      else
        while (localVehiclePathPoint.epoch != null)
          return false;
      if (this.latitude != null)
      {
        if (this.latitude.equals(localVehiclePathPoint.latitude));
      }
      else
        while (localVehiclePathPoint.latitude != null)
          return false;
      if (this.longitude == null)
        break;
    }
    while (this.longitude.equals(localVehiclePathPoint.longitude));
    while (true)
    {
      return false;
      if (localVehiclePathPoint.longitude == null)
        break;
    }
  }

  public float getCourse()
  {
    if (this.course != null)
      return this.course.floatValue();
    return 0.0F;
  }

  public long getEpoch()
  {
    if (this.epoch != null)
      return this.epoch.longValue();
    return 0L;
  }

  public double getLatitude()
  {
    if (this.latitude != null)
      return this.latitude.doubleValue();
    return 0.0D;
  }

  public double getLongitude()
  {
    if (this.longitude != null)
      return this.longitude.doubleValue();
    return 0.0D;
  }

  public UberLatLng getUberLatLng()
  {
    return new UberLatLng(getLatitude(), getLongitude());
  }

  public int hashCode()
  {
    int i;
    long l1;
    label81: int n;
    if (this.course != null)
    {
      i = Float.floatToIntBits(this.course.floatValue());
      int j = i * 31;
      Long localLong = this.epoch;
      int k = 0;
      if (localLong != null)
        k = (int)(this.epoch.longValue() ^ this.epoch.longValue() >>> 32);
      int m = j + k;
      if (this.latitude == null)
        break label138;
      l1 = Double.doubleToLongBits(this.latitude.doubleValue());
      n = m * 31 + (int)(l1 ^ l1 >>> 32);
      if (this.longitude == null)
        break label144;
    }
    label138: label144: for (long l2 = Double.doubleToLongBits(this.longitude.doubleValue()); ; l2 = 0L)
    {
      return n * 31 + (int)(l2 ^ l2 >>> 32);
      i = 0;
      break;
      l1 = 0L;
      break label81;
    }
  }

  public void setEpoch(long paramLong)
  {
    this.epoch = Long.valueOf(paramLong);
  }

  public void setLatitude(double paramDouble)
  {
    this.latitude = Double.valueOf(paramDouble);
  }

  public void setLongitude(double paramDouble)
  {
    this.longitude = Double.valueOf(paramDouble);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.VehiclePathPoint
 * JD-Core Version:    0.6.2
 */