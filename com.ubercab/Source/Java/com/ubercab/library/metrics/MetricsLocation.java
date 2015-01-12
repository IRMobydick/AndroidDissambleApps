package com.ubercab.library.metrics;

import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.location.model.UberLocation;

public final class MetricsLocation
{
  private final Double altitude;
  private final Float course;
  private final Long gps_time_ms;
  private final Float horizontal_accuracy;
  private final Double lat;
  private final Double lng;
  private final Float speed;
  private final Float vertical_accuracy;

  private MetricsLocation(Double paramDouble1, Double paramDouble2, Float paramFloat1, Float paramFloat2, Double paramDouble3, Float paramFloat3, Float paramFloat4, Long paramLong)
  {
    this.lat = paramDouble1;
    this.lng = paramDouble2;
    this.course = paramFloat1;
    this.speed = paramFloat2;
    this.altitude = paramDouble3;
    this.horizontal_accuracy = paramFloat3;
    this.vertical_accuracy = paramFloat4;
    this.gps_time_ms = paramLong;
  }

  public static MetricsLocation createLocation(UberLocation paramUberLocation)
  {
    if (paramUberLocation == null)
      return null;
    UberLatLng localUberLatLng = paramUberLocation.getUberLatLng();
    return new MetricsLocation(Double.valueOf(localUberLatLng.getLatitude()), Double.valueOf(localUberLatLng.getLongitude()), Float.valueOf(paramUberLocation.getBearing()), Float.valueOf(paramUberLocation.getSpeed()), Double.valueOf(paramUberLocation.getAltitude()), Float.valueOf(paramUberLocation.getAccuracy()), Float.valueOf(paramUberLocation.getAccuracy()), Long.valueOf(paramUberLocation.getTime()));
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    MetricsLocation localMetricsLocation;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localMetricsLocation = (MetricsLocation)paramObject;
      if (this.altitude != null)
      {
        if (this.altitude.equals(localMetricsLocation.altitude));
      }
      else
        while (localMetricsLocation.altitude != null)
          return false;
      if (this.course != null)
      {
        if (this.course.equals(localMetricsLocation.course));
      }
      else
        while (localMetricsLocation.course != null)
          return false;
      if (this.gps_time_ms != null)
      {
        if (this.gps_time_ms.equals(localMetricsLocation.gps_time_ms));
      }
      else
        while (localMetricsLocation.gps_time_ms != null)
          return false;
      if (this.horizontal_accuracy != null)
      {
        if (this.horizontal_accuracy.equals(localMetricsLocation.horizontal_accuracy));
      }
      else
        while (localMetricsLocation.horizontal_accuracy != null)
          return false;
      if (this.lat != null)
      {
        if (this.lat.equals(localMetricsLocation.lat));
      }
      else
        while (localMetricsLocation.lat != null)
          return false;
      if (this.lng != null)
      {
        if (this.lng.equals(localMetricsLocation.lng));
      }
      else
        while (localMetricsLocation.lng != null)
          return false;
      if (this.speed != null)
      {
        if (this.speed.equals(localMetricsLocation.speed));
      }
      else
        while (localMetricsLocation.speed != null)
          return false;
      if (this.vertical_accuracy == null)
        break;
    }
    while (this.vertical_accuracy.equals(localMetricsLocation.vertical_accuracy));
    while (true)
    {
      return false;
      if (localMetricsLocation.vertical_accuracy == null)
        break;
    }
  }

  public Double getAltitude()
  {
    return this.altitude;
  }

  public Float getCourse()
  {
    return this.course;
  }

  public Long getGpsTimeMs()
  {
    return this.gps_time_ms;
  }

  public Float getHorizontalAccuracy()
  {
    return this.horizontal_accuracy;
  }

  public Double getLat()
  {
    return this.lat;
  }

  public Double getLng()
  {
    return this.lng;
  }

  public Float getSpeed()
  {
    return this.speed;
  }

  public Float getVerticalAccuracy()
  {
    return this.vertical_accuracy;
  }

  public int hashCode()
  {
    int i;
    int k;
    label35: int n;
    label59: int i2;
    label85: int i4;
    label111: int i6;
    label137: int i7;
    if (this.lat != null)
    {
      i = this.lat.hashCode();
      int j = i * 31;
      if (this.lng == null)
        break label207;
      k = this.lng.hashCode();
      int m = 31 * (j + k);
      if (this.course == null)
        break label212;
      n = this.course.hashCode();
      int i1 = 31 * (m + n);
      if (this.speed == null)
        break label218;
      i2 = this.speed.hashCode();
      int i3 = 31 * (i1 + i2);
      if (this.altitude == null)
        break label224;
      i4 = this.altitude.hashCode();
      int i5 = 31 * (i3 + i4);
      if (this.horizontal_accuracy == null)
        break label230;
      i6 = this.horizontal_accuracy.hashCode();
      i7 = 31 * (i5 + i6);
      if (this.vertical_accuracy == null)
        break label236;
    }
    label207: label212: label218: label224: label230: label236: for (int i8 = this.vertical_accuracy.hashCode(); ; i8 = 0)
    {
      int i9 = 31 * (i7 + i8);
      Long localLong = this.gps_time_ms;
      int i10 = 0;
      if (localLong != null)
        i10 = this.gps_time_ms.hashCode();
      return i9 + i10;
      i = 0;
      break;
      k = 0;
      break label35;
      n = 0;
      break label59;
      i2 = 0;
      break label85;
      i4 = 0;
      break label111;
      i6 = 0;
      break label137;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.metrics.MetricsLocation
 * JD-Core Version:    0.6.2
 */