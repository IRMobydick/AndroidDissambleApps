package com.ubercab.library.location.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class UberLocation
  implements Parcelable
{
  public static final Parcelable.Creator<UberLocation> CREATOR = new Parcelable.Creator()
  {
    public UberLocation createFromParcel(Parcel paramAnonymousParcel)
    {
      return new UberLocation(paramAnonymousParcel);
    }

    public UberLocation[] newArray(int paramAnonymousInt)
    {
      return new UberLocation[paramAnonymousInt];
    }
  };
  private final float mAccuracy;
  private final double mAltitude;
  private final float mBearing;
  private final float mSpeed;
  private final long mTime;
  private final UberLatLng mUberLatLng;

  public UberLocation(float paramFloat1, double paramDouble, float paramFloat2, float paramFloat3, long paramLong, UberLatLng paramUberLatLng)
  {
    this.mAccuracy = paramFloat1;
    this.mAltitude = paramDouble;
    this.mBearing = paramFloat2;
    this.mSpeed = paramFloat3;
    this.mTime = paramLong;
    this.mUberLatLng = paramUberLatLng;
  }

  protected UberLocation(Parcel paramParcel)
  {
    this.mAccuracy = paramParcel.readFloat();
    this.mAltitude = paramParcel.readDouble();
    this.mBearing = paramParcel.readFloat();
    this.mSpeed = paramParcel.readFloat();
    this.mTime = paramParcel.readLong();
    this.mUberLatLng = new UberLatLng(paramParcel);
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    UberLocation localUberLocation;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localUberLocation = (UberLocation)paramObject;
      if (Float.compare(localUberLocation.mAccuracy, this.mAccuracy) != 0)
        return false;
      if (Double.compare(localUberLocation.mAltitude, this.mAltitude) != 0)
        return false;
      if (Float.compare(localUberLocation.mBearing, this.mBearing) != 0)
        return false;
      if (Float.compare(localUberLocation.mSpeed, this.mSpeed) != 0)
        return false;
      if (this.mTime != localUberLocation.mTime)
        return false;
      if (this.mUberLatLng == null)
        break;
    }
    while (this.mUberLatLng.equals(localUberLocation.mUberLatLng));
    while (true)
    {
      return false;
      if (localUberLocation.mUberLatLng == null)
        break;
    }
  }

  public float getAccuracy()
  {
    return this.mAccuracy;
  }

  public double getAltitude()
  {
    return this.mAltitude;
  }

  public float getBearing()
  {
    return this.mBearing;
  }

  public float getSpeed()
  {
    return this.mSpeed;
  }

  public long getTime()
  {
    return this.mTime;
  }

  public UberLatLng getUberLatLng()
  {
    return this.mUberLatLng;
  }

  public int hashCode()
  {
    int i;
    int k;
    label60: int m;
    if (this.mAccuracy != 0.0F)
    {
      i = Float.floatToIntBits(this.mAccuracy);
      long l = Double.doubleToLongBits(this.mAltitude);
      int j = 31 * (i * 31 + (int)(l ^ l >>> 32));
      if (this.mBearing == 0.0F)
        break label149;
      k = Float.floatToIntBits(this.mBearing);
      m = 31 * (j + k);
      if (this.mSpeed == 0.0F)
        break label155;
    }
    label149: label155: for (int n = Float.floatToIntBits(this.mSpeed); ; n = 0)
    {
      int i1 = 31 * (31 * (m + n) + (int)(this.mTime ^ this.mTime >>> 32));
      UberLatLng localUberLatLng = this.mUberLatLng;
      int i2 = 0;
      if (localUberLatLng != null)
        i2 = this.mUberLatLng.hashCode();
      return i1 + i2;
      i = 0;
      break;
      k = 0;
      break label60;
    }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeFloat(this.mAccuracy);
    paramParcel.writeDouble(this.mAltitude);
    paramParcel.writeFloat(this.mBearing);
    paramParcel.writeFloat(this.mSpeed);
    paramParcel.writeLong(this.mTime);
    this.mUberLatLng.writeToParcel(paramParcel, paramInt);
  }

  public static class Builder
  {
    private float accuracy;
    private double altitude;
    private float bearing;
    private float speed;
    private long time;
    private final UberLatLng uberLatLng;

    public Builder(UberLatLng paramUberLatLng)
    {
      this.uberLatLng = paramUberLatLng;
    }

    public Builder accuracy(float paramFloat)
    {
      this.accuracy = paramFloat;
      return this;
    }

    public Builder altitude(double paramDouble)
    {
      this.altitude = paramDouble;
      return this;
    }

    public Builder bearing(float paramFloat)
    {
      this.bearing = paramFloat;
      return this;
    }

    public UberLocation build()
    {
      return new UberLocation(this.accuracy, this.altitude, this.bearing, this.speed, this.time, this.uberLatLng);
    }

    public Builder speed(float paramFloat)
    {
      this.speed = paramFloat;
      return this;
    }

    public Builder time(long paramLong)
    {
      this.time = paramLong;
      return this;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.location.model.UberLocation
 * JD-Core Version:    0.6.2
 */