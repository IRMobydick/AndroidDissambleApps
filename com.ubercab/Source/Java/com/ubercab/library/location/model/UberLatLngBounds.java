package com.ubercab.library.location.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class UberLatLngBounds
  implements Parcelable
{
  public static final Parcelable.Creator<UberLatLngBounds> CREATOR = new Parcelable.Creator()
  {
    public UberLatLngBounds createFromParcel(Parcel paramAnonymousParcel)
    {
      return new UberLatLngBounds(paramAnonymousParcel);
    }

    public UberLatLngBounds[] newArray(int paramAnonymousInt)
    {
      return new UberLatLngBounds[paramAnonymousInt];
    }
  };
  private final UberLatLng mNortheast;
  private final UberLatLng mSouthwest;

  protected UberLatLngBounds(Parcel paramParcel)
  {
    this.mSouthwest = new UberLatLng(paramParcel);
    this.mNortheast = new UberLatLng(paramParcel);
  }

  public UberLatLngBounds(UberLatLng paramUberLatLng1, UberLatLng paramUberLatLng2)
  {
    this.mSouthwest = paramUberLatLng1;
    this.mNortheast = paramUberLatLng2;
  }

  public static Builder builder()
  {
    return new Builder();
  }

  private static double distanceFromNortheastLatitude(double paramDouble1, double paramDouble2)
  {
    return (360.0D + (paramDouble2 - paramDouble1)) % 360.0D;
  }

  private static double distanceFromSouthwestLatitude(double paramDouble1, double paramDouble2)
  {
    return (360.0D + (paramDouble1 - paramDouble2)) % 360.0D;
  }

  private boolean isInBetweenLatitudes(double paramDouble)
  {
    return (this.mSouthwest.getLatitude() <= paramDouble) && (paramDouble <= this.mNortheast.getLatitude());
  }

  private boolean isInBetweenLongitudes(double paramDouble)
  {
    if (this.mSouthwest.getLongitude() <= this.mNortheast.getLongitude())
      return (this.mSouthwest.getLongitude() <= paramDouble) && (paramDouble <= this.mNortheast.getLongitude());
    boolean bool1;
    if (this.mSouthwest.getLongitude() > paramDouble)
    {
      boolean bool2 = paramDouble < this.mNortheast.getLongitude();
      bool1 = false;
      if (bool2);
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }

  public boolean contains(UberLatLng paramUberLatLng)
  {
    return (isInBetweenLatitudes(paramUberLatLng.getLatitude())) && (isInBetweenLongitudes(paramUberLatLng.getLongitude()));
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    UberLatLngBounds localUberLatLngBounds;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localUberLatLngBounds = (UberLatLngBounds)paramObject;
      if (this.mNortheast != null)
      {
        if (this.mNortheast.equals(localUberLatLngBounds.getNortheast()));
      }
      else
        while (localUberLatLngBounds.getNortheast() != null)
          return false;
      if (this.mSouthwest == null)
        break;
    }
    while (this.mSouthwest.equals(localUberLatLngBounds.getSouthwest()));
    while (true)
    {
      return false;
      if (localUberLatLngBounds.getSouthwest() == null)
        break;
    }
  }

  public UberLatLng getCenter()
  {
    double d1 = (this.mSouthwest.getLatitude() + this.mNortheast.getLatitude()) / 2.0D;
    double d2 = this.mNortheast.getLongitude();
    double d3 = this.mSouthwest.getLongitude();
    if (d3 <= d2);
    for (double d4 = (d2 + d3) / 2.0D; ; d4 = (d3 + (360.0D + d2)) / 2.0D)
      return new UberLatLng(d1, d4);
  }

  public UberLatLng getNortheast()
  {
    return this.mNortheast;
  }

  public UberLatLng getSouthwest()
  {
    return this.mSouthwest;
  }

  public int hashCode()
  {
    if (this.mSouthwest != null);
    for (int i = this.mSouthwest.hashCode(); ; i = 0)
    {
      int j = i * 31;
      UberLatLng localUberLatLng = this.mNortheast;
      int k = 0;
      if (localUberLatLng != null)
        k = this.mNortheast.hashCode();
      return j + k;
    }
  }

  public UberLatLngBounds including(UberLatLng paramUberLatLng)
  {
    double d1 = Math.min(this.mSouthwest.getLatitude(), paramUberLatLng.getLatitude());
    double d2 = Math.max(this.mNortheast.getLatitude(), paramUberLatLng.getLatitude());
    double d3 = this.mNortheast.getLongitude();
    double d4 = this.mSouthwest.getLongitude();
    double d5 = paramUberLatLng.getLongitude();
    if (!isInBetweenLongitudes(d5))
    {
      if (distanceFromSouthwestLatitude(d4, d5) >= distanceFromNortheastLatitude(d3, d5))
        break label115;
      d4 = d5;
    }
    while (true)
    {
      return new UberLatLngBounds(new UberLatLng(d1, d4), new UberLatLng(d2, d3));
      label115: d3 = d5;
    }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    this.mSouthwest.writeToParcel(paramParcel, paramInt);
    this.mNortheast.writeToParcel(paramParcel, paramInt);
  }

  public static final class Builder
  {
    private double mNortheastLatitude = (-1.0D / 0.0D);
    private double mNortheastLongitude = (0.0D / 0.0D);
    private double mSouthwestLatitude = (1.0D / 0.0D);
    private double mSouthwestLongitude = (0.0D / 0.0D);

    private boolean isInBetweenLongitudes(double paramDouble)
    {
      if (this.mSouthwestLongitude <= this.mNortheastLongitude)
        return (this.mSouthwestLongitude <= paramDouble) && (paramDouble <= this.mNortheastLongitude);
      boolean bool1;
      if (this.mSouthwestLongitude > paramDouble)
      {
        boolean bool2 = paramDouble < this.mNortheastLongitude;
        bool1 = false;
        if (bool2);
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }

    public UberLatLngBounds build()
    {
      return new UberLatLngBounds(new UberLatLng(this.mSouthwestLatitude, this.mSouthwestLongitude), new UberLatLng(this.mNortheastLatitude, this.mNortheastLongitude));
    }

    public Builder include(UberLatLng paramUberLatLng)
    {
      this.mSouthwestLatitude = Math.min(this.mSouthwestLatitude, paramUberLatLng.getLatitude());
      this.mNortheastLatitude = Math.max(this.mNortheastLatitude, paramUberLatLng.getLatitude());
      double d = paramUberLatLng.getLongitude();
      if (Double.isNaN(this.mSouthwestLongitude))
      {
        this.mSouthwestLongitude = d;
        this.mNortheastLongitude = d;
      }
      while (isInBetweenLongitudes(d))
        return this;
      if (UberLatLngBounds.distanceFromSouthwestLatitude(this.mSouthwestLongitude, d) < UberLatLngBounds.distanceFromNortheastLatitude(this.mNortheastLongitude, d))
      {
        this.mSouthwestLongitude = d;
        return this;
      }
      this.mNortheastLongitude = d;
      return this;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.location.model.UberLatLngBounds
 * JD-Core Version:    0.6.2
 */