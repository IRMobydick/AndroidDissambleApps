package com.ubercab.library.location.model;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class UberLatLng
  implements Parcelable
{
  public static final Parcelable.Creator<UberLatLng> CREATOR = new Parcelable.Creator()
  {
    public UberLatLng createFromParcel(Parcel paramAnonymousParcel)
    {
      return new UberLatLng(paramAnonymousParcel);
    }

    public UberLatLng[] newArray(int paramAnonymousInt)
    {
      return new UberLatLng[paramAnonymousInt];
    }
  };
  private static final double EARTH_A = 6378245.0D;
  private static final double EARTH_EE = 0.006693421622965943D;
  public static final int PROJECTION_BD09 = 2;
  public static final int PROJECTION_GCJ02 = 1;
  public static final int PROJECTION_WGS84 = 0;
  private static final double X_PI = 52.359877559829883D;
  private final double mLatitude;
  private final double mLongitude;
  private final int mProjection;

  public UberLatLng(double paramDouble1, double paramDouble2)
  {
    this(paramDouble1, paramDouble2, 0);
  }

  public UberLatLng(double paramDouble1, double paramDouble2, int paramInt)
  {
    this.mLatitude = paramDouble1;
    this.mLongitude = paramDouble2;
    this.mProjection = paramInt;
  }

  public UberLatLng(Parcel paramParcel)
  {
    this.mLatitude = paramParcel.readDouble();
    this.mLongitude = paramParcel.readDouble();
    this.mProjection = paramParcel.readInt();
  }

  private static UberLatLng convertBD09ToGCJ02(UberLatLng paramUberLatLng)
  {
    double d1 = paramUberLatLng.getLongitude() - 0.00665D;
    double d2 = paramUberLatLng.getLatitude() - 0.006D;
    double d3 = Math.sqrt(d1 * d1 + d2 * d2) - 2.E-005D * Math.sin(52.359877559829883D * d2);
    double d4 = Math.atan2(d2, d1) - 3.E-006D * Math.cos(52.359877559829883D * d1);
    double d5 = d3 * Math.cos(d4);
    return new UberLatLng(d3 * Math.sin(d4), d5, 1);
  }

  private static UberLatLng convertGCJ02ToBD09(UberLatLng paramUberLatLng)
  {
    double d1 = paramUberLatLng.getLongitude();
    double d2 = paramUberLatLng.getLatitude();
    double d3 = Math.sqrt(d1 * d1 + d2 * d2) + 2.E-005D * Math.sin(52.359877559829883D * d2);
    double d4 = Math.atan2(d2, d1) + 3.E-006D * Math.cos(52.359877559829883D * d1);
    double d5 = 0.0065D + d3 * Math.cos(d4);
    return new UberLatLng(0.006D + d3 * Math.sin(d4), d5, 2);
  }

  private static UberLatLng convertGCJ02ToWGS84(UberLatLng paramUberLatLng)
  {
    UberLatLng localUberLatLng = convertWGS84ToGCJ02(paramUberLatLng);
    double d1 = localUberLatLng.getLatitude() - paramUberLatLng.getLatitude();
    double d2 = localUberLatLng.getLongitude() - paramUberLatLng.getLongitude();
    return new UberLatLng(paramUberLatLng.getLatitude() - d1, paramUberLatLng.getLongitude() - d2, 0);
  }

  private static UberLatLng convertWGS84ToGCJ02(UberLatLng paramUberLatLng)
  {
    double d1 = Math.toRadians(paramUberLatLng.getLatitude());
    double d2 = 1.0D - 0.006693421622965943D * Math.sin(d1) * Math.sin(d1);
    double d3 = Math.sqrt(d2);
    double d4 = 180.0D * latitudeOffset(paramUberLatLng.getLongitude() - 105.0D, paramUberLatLng.getLatitude() - 35.0D) / (3.141592653589793D * (6335552.7170004258D / (d2 * d3)));
    double d5 = 180.0D * longitudeOffset(paramUberLatLng.getLongitude() - 105.0D, paramUberLatLng.getLatitude() - 35.0D) / (3.141592653589793D * (6378245.0D / d3 * Math.cos(d1)));
    return new UberLatLng(d4 + paramUberLatLng.getLatitude(), d5 + paramUberLatLng.getLongitude(), 1);
  }

  public static double distanceInMeters(UberLatLng paramUberLatLng1, UberLatLng paramUberLatLng2)
  {
    UberLatLng localUberLatLng1 = paramUberLatLng1.convertToWGS84();
    UberLatLng localUberLatLng2 = paramUberLatLng2.convertToWGS84();
    float[] arrayOfFloat = new float[1];
    Location.distanceBetween(localUberLatLng1.getLatitude(), localUberLatLng1.getLongitude(), localUberLatLng2.getLatitude(), localUberLatLng2.getLongitude(), arrayOfFloat);
    return arrayOfFloat[0];
  }

  private static double latitudeOffset(double paramDouble1, double paramDouble2)
  {
    return -100.0D + 2.0D * paramDouble1 + 3.0D * paramDouble2 + paramDouble2 * (0.2D * paramDouble2) + paramDouble2 * (0.1D * paramDouble1) + 0.2D * Math.sqrt(Math.abs(paramDouble1)) + 2.0D * (20.0D * Math.sin(3.141592653589793D * (6.0D * paramDouble1)) + 20.0D * Math.sin(3.141592653589793D * (2.0D * paramDouble1))) / 3.0D + 2.0D * (20.0D * Math.sin(3.141592653589793D * paramDouble2) + 40.0D * Math.sin(3.141592653589793D * (paramDouble2 / 3.0D))) / 3.0D + 2.0D * (160.0D * Math.sin(3.141592653589793D * (paramDouble2 / 12.0D)) + 320.0D * Math.sin(3.141592653589793D * paramDouble2 / 30.0D)) / 3.0D;
  }

  private static double longitudeOffset(double paramDouble1, double paramDouble2)
  {
    return 300.0D + paramDouble1 + 2.0D * paramDouble2 + paramDouble1 * (0.1D * paramDouble1) + paramDouble2 * (0.1D * paramDouble1) + 0.1D * Math.sqrt(Math.abs(paramDouble1)) + 2.0D * (20.0D * Math.sin(3.141592653589793D * (6.0D * paramDouble1)) + 20.0D * Math.sin(3.141592653589793D * (2.0D * paramDouble1))) / 3.0D + 2.0D * (20.0D * Math.sin(3.141592653589793D * paramDouble1) + 40.0D * Math.sin(3.141592653589793D * (paramDouble1 / 3.0D))) / 3.0D + 2.0D * (150.0D * Math.sin(3.141592653589793D * (paramDouble1 / 12.0D)) + 300.0D * Math.sin(3.141592653589793D * (paramDouble1 / 30.0D))) / 3.0D;
  }

  public UberLatLng convertToBD09()
  {
    switch (this.mProjection)
    {
    default:
      throw new RuntimeException("Conversion doesn't exist for projections.");
    case 2:
      return new UberLatLng(this.mLatitude, this.mLongitude, this.mProjection);
    case 0:
      return convertGCJ02ToBD09(convertWGS84ToGCJ02(this));
    case 1:
    }
    return convertGCJ02ToBD09(this);
  }

  public UberLatLng convertToGCJ02()
  {
    switch (this.mProjection)
    {
    default:
      throw new RuntimeException("Conversion doesn't exist for projections.");
    case 1:
      return new UberLatLng(this.mLatitude, this.mLongitude, this.mProjection);
    case 0:
      return convertWGS84ToGCJ02(this);
    case 2:
    }
    return convertBD09ToGCJ02(this);
  }

  public UberLatLng convertToWGS84()
  {
    switch (this.mProjection)
    {
    default:
      throw new RuntimeException("Conversion doesn't exist for projections.");
    case 0:
      return new UberLatLng(this.mLatitude, this.mLongitude, this.mProjection);
    case 1:
      return convertGCJ02ToWGS84(this);
    case 2:
    }
    return convertGCJ02ToWGS84(convertBD09ToGCJ02(this));
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    UberLatLng localUberLatLng;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localUberLatLng = (UberLatLng)paramObject;
      if (Double.compare(localUberLatLng.getLatitude(), this.mLatitude) != 0)
        return false;
      if (Double.compare(localUberLatLng.getLongitude(), this.mLongitude) != 0)
        return false;
    }
    while (this.mProjection == localUberLatLng.getProjection());
    return false;
  }

  public double getLatitude()
  {
    return this.mLatitude;
  }

  public double getLongitude()
  {
    return this.mLongitude;
  }

  public int getProjection()
  {
    return this.mProjection;
  }

  public int hashCode()
  {
    long l1 = Double.doubleToLongBits(this.mLatitude);
    int i = (int)(l1 ^ l1 >>> 32);
    long l2 = Double.doubleToLongBits(this.mLongitude);
    return 31 * (i * 31 + (int)(l2 ^ l2 >>> 32)) + this.mProjection;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeDouble(this.mLatitude);
    paramParcel.writeDouble(this.mLongitude);
    paramParcel.writeInt(this.mProjection);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.location.model.UberLatLng
 * JD-Core Version:    0.6.2
 */