package com.ubercab.client.core.model;

import android.text.TextUtils;
import java.util.List;
import java.util.Locale;

public class TripVehicle
{
  String exteriorColor;
  String interiorColor;
  String licensePlate;
  Integer licensePlateCountryId;
  String licensePlateState;
  List<TripVehiclePictureImage> pictureImages;
  String uuid;
  List<VehiclePathPoint> vehiclePath;
  TripVehicleType vehicleType;
  String vehicleViewId;
  Integer year;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    TripVehicle localTripVehicle;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localTripVehicle = (TripVehicle)paramObject;
      if (this.exteriorColor != null)
      {
        if (this.exteriorColor.equals(localTripVehicle.exteriorColor));
      }
      else
        while (localTripVehicle.exteriorColor != null)
          return false;
      if (this.interiorColor != null)
      {
        if (this.interiorColor.equals(localTripVehicle.interiorColor));
      }
      else
        while (localTripVehicle.interiorColor != null)
          return false;
      if (this.licensePlate != null)
      {
        if (this.licensePlate.equals(localTripVehicle.licensePlate));
      }
      else
        while (localTripVehicle.licensePlate != null)
          return false;
      if (this.licensePlateCountryId != null)
      {
        if (this.licensePlateCountryId.equals(localTripVehicle.licensePlateCountryId));
      }
      else
        while (localTripVehicle.licensePlateCountryId != null)
          return false;
      if (this.licensePlateState != null)
      {
        if (this.licensePlateState.equals(localTripVehicle.licensePlateState));
      }
      else
        while (localTripVehicle.licensePlateState != null)
          return false;
      if (this.pictureImages != null)
      {
        if (this.pictureImages.equals(localTripVehicle.pictureImages));
      }
      else
        while (localTripVehicle.pictureImages != null)
          return false;
      if (this.uuid != null)
      {
        if (this.uuid.equals(localTripVehicle.uuid));
      }
      else
        while (localTripVehicle.uuid != null)
          return false;
      if (this.vehiclePath != null)
      {
        if (this.vehiclePath.equals(localTripVehicle.vehiclePath));
      }
      else
        while (localTripVehicle.vehiclePath != null)
          return false;
      if (this.vehicleType != null)
      {
        if (this.vehicleType.equals(localTripVehicle.vehicleType));
      }
      else
        while (localTripVehicle.vehicleType != null)
          return false;
      if (this.vehicleViewId != null)
      {
        if (this.vehicleViewId.equals(localTripVehicle.vehicleViewId));
      }
      else
        while (localTripVehicle.vehicleViewId != null)
          return false;
      if (this.year == null)
        break;
    }
    while (this.year.equals(localTripVehicle.year));
    while (true)
    {
      return false;
      if (localTripVehicle.year == null)
        break;
    }
  }

  public String getExteriorColor()
  {
    return this.exteriorColor;
  }

  public String getFormattedLicensePlate()
  {
    if (TextUtils.isEmpty(this.licensePlate))
      return "";
    return this.licensePlate.toUpperCase(Locale.getDefault());
  }

  public String getFormattedMake()
  {
    if (this.vehicleType == null)
      return "";
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(this.vehicleType.getMake()))
    {
      localStringBuilder.append(this.vehicleType.getMake());
      localStringBuilder.append(" ");
    }
    if ((!TextUtils.isEmpty(this.vehicleType.getMake())) && (!TextUtils.isEmpty(this.vehicleType.getModel())) && (!this.vehicleType.getModel().equals(this.vehicleType.getMake())))
      localStringBuilder.append(this.vehicleType.getModel());
    return localStringBuilder.toString();
  }

  public String getInteriorColor()
  {
    return this.interiorColor;
  }

  public String getLicensePlate()
  {
    return this.licensePlate;
  }

  public int getLicensePlateCountryId()
  {
    if (this.licensePlateCountryId == null)
      return 0;
    return this.licensePlateCountryId.intValue();
  }

  public String getLicensePlateState()
  {
    return this.licensePlateState;
  }

  public List<TripVehiclePictureImage> getPictureImages()
  {
    return this.pictureImages;
  }

  public String getUuid()
  {
    return this.uuid;
  }

  public List<VehiclePathPoint> getVehiclePath()
  {
    return this.vehiclePath;
  }

  public TripVehicleType getVehicleType()
  {
    return this.vehicleType;
  }

  public String getVehicleViewId()
  {
    return this.vehicleViewId;
  }

  public int getYear()
  {
    if (this.year == null)
      return 0;
    return this.year.intValue();
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
    label189: int i12;
    label217: int i13;
    if (this.year != null)
    {
      i = this.year.hashCode();
      int j = i * 31;
      if (this.licensePlateCountryId == null)
        break label289;
      k = this.licensePlateCountryId.hashCode();
      int m = 31 * (j + k);
      if (this.uuid == null)
        break label294;
      n = this.uuid.hashCode();
      int i1 = 31 * (m + n);
      if (this.licensePlate == null)
        break label300;
      i2 = this.licensePlate.hashCode();
      int i3 = 31 * (i1 + i2);
      if (this.vehicleViewId == null)
        break label306;
      i4 = this.vehicleViewId.hashCode();
      int i5 = 31 * (i3 + i4);
      if (this.exteriorColor == null)
        break label312;
      i6 = this.exteriorColor.hashCode();
      int i7 = 31 * (i5 + i6);
      if (this.interiorColor == null)
        break label318;
      i8 = this.interiorColor.hashCode();
      int i9 = 31 * (i7 + i8);
      if (this.licensePlateState == null)
        break label324;
      i10 = this.licensePlateState.hashCode();
      int i11 = 31 * (i9 + i10);
      if (this.pictureImages == null)
        break label330;
      i12 = this.pictureImages.hashCode();
      i13 = 31 * (i11 + i12);
      if (this.vehiclePath == null)
        break label336;
    }
    label289: label294: label300: label306: label312: label318: label324: label330: label336: for (int i14 = this.vehiclePath.hashCode(); ; i14 = 0)
    {
      int i15 = 31 * (i13 + i14);
      TripVehicleType localTripVehicleType = this.vehicleType;
      int i16 = 0;
      if (localTripVehicleType != null)
        i16 = this.vehicleType.hashCode();
      return i15 + i16;
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
      i12 = 0;
      break label217;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.TripVehicle
 * JD-Core Version:    0.6.2
 */