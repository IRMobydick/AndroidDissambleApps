package com.ubercab.client.core.model;

public class Fare
{
  public static final String TYPE_TIME_AND_DISTANCE = "TimeAndDistance";
  public static final String TYPE_TIME_OR_DISTANCE = "TimeOrDistance";
  String base;
  String cancellation;
  String distanceUnit;
  Integer id;
  String minimum;
  String perDistanceUnit;
  String perMinute;
  String safeRidesFee;
  Float speedThresholdMps;
  String type;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    Fare localFare;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localFare = (Fare)paramObject;
      if (this.base != null)
      {
        if (this.base.equals(localFare.base));
      }
      else
        while (localFare.base != null)
          return false;
      if (this.cancellation != null)
      {
        if (this.cancellation.equals(localFare.cancellation));
      }
      else
        while (localFare.cancellation != null)
          return false;
      if (this.distanceUnit != null)
      {
        if (this.distanceUnit.equals(localFare.distanceUnit));
      }
      else
        while (localFare.distanceUnit != null)
          return false;
      if (this.id != null)
      {
        if (this.id.equals(localFare.id));
      }
      else
        while (localFare.id != null)
          return false;
      if (this.minimum != null)
      {
        if (this.minimum.equals(localFare.minimum));
      }
      else
        while (localFare.minimum != null)
          return false;
      if (this.perDistanceUnit != null)
      {
        if (this.perDistanceUnit.equals(localFare.perDistanceUnit));
      }
      else
        while (localFare.perDistanceUnit != null)
          return false;
      if (this.perMinute != null)
      {
        if (this.perMinute.equals(localFare.perMinute));
      }
      else
        while (localFare.perMinute != null)
          return false;
      if (this.safeRidesFee != null)
      {
        if (this.safeRidesFee.equals(localFare.safeRidesFee));
      }
      else
        while (localFare.safeRidesFee != null)
          return false;
      if (this.speedThresholdMps != null)
      {
        if (this.speedThresholdMps.equals(localFare.speedThresholdMps));
      }
      else
        while (localFare.speedThresholdMps != null)
          return false;
      if (this.type == null)
        break;
    }
    while (this.type.equals(localFare.type));
    while (true)
    {
      return false;
      if (localFare.type == null)
        break;
    }
  }

  public String getBase()
  {
    return this.base;
  }

  public String getCancellation()
  {
    return this.cancellation;
  }

  public String getDistanceUnit()
  {
    return this.distanceUnit;
  }

  public int getId()
  {
    if (this.id == null)
      return 0;
    return this.id.intValue();
  }

  public String getMinimum()
  {
    return this.minimum;
  }

  public String getPerDistanceUnit()
  {
    return this.perDistanceUnit;
  }

  public String getPerMinute()
  {
    return this.perMinute;
  }

  public String getSafeRidesFee()
  {
    return this.safeRidesFee;
  }

  public float getSpeedThresholdMps()
  {
    if (this.speedThresholdMps == null)
      return 0.0F;
    return this.speedThresholdMps.floatValue();
  }

  public String getType()
  {
    return this.type;
  }

  public int hashCode()
  {
    int i;
    int k;
    label35: int n;
    label59: int i2;
    label85: int i4;
    label111: int i6;
    label137: int i8;
    label163: int i10;
    label189: int i11;
    if (this.id != null)
    {
      i = this.id.hashCode();
      int j = i * 31;
      if (this.speedThresholdMps == null)
        break label259;
      k = this.speedThresholdMps.hashCode();
      int m = 31 * (j + k);
      if (this.base == null)
        break label264;
      n = this.base.hashCode();
      int i1 = 31 * (m + n);
      if (this.cancellation == null)
        break label270;
      i2 = this.cancellation.hashCode();
      int i3 = 31 * (i1 + i2);
      if (this.distanceUnit == null)
        break label276;
      i4 = this.distanceUnit.hashCode();
      int i5 = 31 * (i3 + i4);
      if (this.minimum == null)
        break label282;
      i6 = this.minimum.hashCode();
      int i7 = 31 * (i5 + i6);
      if (this.perDistanceUnit == null)
        break label288;
      i8 = this.perDistanceUnit.hashCode();
      int i9 = 31 * (i7 + i8);
      if (this.perMinute == null)
        break label294;
      i10 = this.perMinute.hashCode();
      i11 = 31 * (i9 + i10);
      if (this.safeRidesFee == null)
        break label300;
    }
    label259: label264: label270: label276: label282: label288: label294: label300: for (int i12 = this.safeRidesFee.hashCode(); ; i12 = 0)
    {
      int i13 = 31 * (i11 + i12);
      String str = this.type;
      int i14 = 0;
      if (str != null)
        i14 = this.type.hashCode();
      return i13 + i14;
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
      i8 = 0;
      break label163;
      i10 = 0;
      break label189;
    }
  }

  public void setBase(String paramString)
  {
    this.base = paramString;
  }

  public void setDistanceUnit(String paramString)
  {
    this.distanceUnit = paramString;
  }

  public void setMinimum(String paramString)
  {
    this.minimum = paramString;
  }

  public void setPerDistanceUnit(String paramString)
  {
    this.perDistanceUnit = paramString;
  }

  public void setPerMinute(String paramString)
  {
    this.perMinute = paramString;
  }

  public void setSpeedThresholdMps(float paramFloat)
  {
    this.speedThresholdMps = Float.valueOf(paramFloat);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.Fare
 * JD-Core Version:    0.6.2
 */