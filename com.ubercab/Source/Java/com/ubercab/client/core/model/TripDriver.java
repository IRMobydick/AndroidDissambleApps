package com.ubercab.client.core.model;

public class TripDriver
{
  public static final String STATUS_ACCEPTED = "Accepted";
  public static final String STATUS_ARRIVING = "Arrived";
  public static final String STATUS_DRIVING_CLIENT = "DrivingClient";
  Capabilities capabilities;
  boolean displayCompany = false;
  TripDriverLocation location;
  String mobile = "";
  String name = "";
  String partnerCompany = "";
  String pictureUrl = "";
  float rating = 0.0F;
  String status = "";
  String uuid = "";

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    TripDriver localTripDriver;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localTripDriver = (TripDriver)paramObject;
      if (this.capabilities != null)
      {
        if (this.capabilities.equals(localTripDriver.capabilities));
      }
      else
        while (localTripDriver.capabilities != null)
          return false;
      if (this.displayCompany != localTripDriver.displayCompany)
        return false;
      if (Float.compare(localTripDriver.rating, this.rating) != 0)
        return false;
      if (this.uuid != null)
      {
        if (this.uuid.equals(this.uuid));
      }
      else
        while (this.uuid != null)
          return false;
      if (this.location != null)
      {
        if (this.location.equals(localTripDriver.location));
      }
      else
        while (localTripDriver.location != null)
          return false;
      if (this.mobile != null)
      {
        if (this.mobile.equals(localTripDriver.mobile));
      }
      else
        while (localTripDriver.mobile != null)
          return false;
      if (this.name != null)
      {
        if (this.name.equals(localTripDriver.name));
      }
      else
        while (localTripDriver.name != null)
          return false;
      if (this.partnerCompany != null)
      {
        if (this.partnerCompany.equals(localTripDriver.partnerCompany));
      }
      else
        while (localTripDriver.partnerCompany != null)
          return false;
      if (this.pictureUrl != null)
      {
        if (this.pictureUrl.equals(localTripDriver.pictureUrl));
      }
      else
        while (localTripDriver.pictureUrl != null)
          return false;
      if (this.status == null)
        break;
    }
    while (this.status.equals(localTripDriver.status));
    while (true)
    {
      return false;
      if (localTripDriver.status == null)
        break;
    }
  }

  public Capabilities getCapabilities()
  {
    return this.capabilities;
  }

  public TripDriverLocation getLocation()
  {
    return this.location;
  }

  public String getMobile()
  {
    return this.mobile;
  }

  public String getName()
  {
    return this.name;
  }

  public String getPartnerCompany()
  {
    return this.partnerCompany;
  }

  public String getPictureUrl()
  {
    return this.pictureUrl;
  }

  public float getRating()
  {
    return this.rating;
  }

  public String getStatus()
  {
    return this.status;
  }

  public String getUuid()
  {
    return this.uuid;
  }

  public int hashCode()
  {
    int i;
    int k;
    label37: int n;
    label55: int i2;
    label81: int i4;
    label107: int i6;
    label133: int i8;
    label159: int i10;
    label185: int i11;
    if (this.capabilities != null)
    {
      i = this.capabilities.hashCode();
      int j = i * 31;
      if (this.rating == 0.0F)
        break label255;
      k = Float.floatToIntBits(this.rating);
      int m = 31 * (j + k);
      if (!this.displayCompany)
        break label260;
      n = 1;
      int i1 = 31 * (m + n);
      if (this.uuid == null)
        break label266;
      i2 = this.uuid.hashCode();
      int i3 = 31 * (i1 + i2);
      if (this.mobile == null)
        break label272;
      i4 = this.mobile.hashCode();
      int i5 = 31 * (i3 + i4);
      if (this.name == null)
        break label278;
      i6 = this.name.hashCode();
      int i7 = 31 * (i5 + i6);
      if (this.partnerCompany == null)
        break label284;
      i8 = this.partnerCompany.hashCode();
      int i9 = 31 * (i7 + i8);
      if (this.pictureUrl == null)
        break label290;
      i10 = this.pictureUrl.hashCode();
      i11 = 31 * (i9 + i10);
      if (this.status == null)
        break label296;
    }
    label260: label266: label272: label278: label284: label290: label296: for (int i12 = this.status.hashCode(); ; i12 = 0)
    {
      int i13 = 31 * (i11 + i12);
      TripDriverLocation localTripDriverLocation = this.location;
      int i14 = 0;
      if (localTripDriverLocation != null)
        i14 = this.location.hashCode();
      return i13 + i14;
      i = 0;
      break;
      label255: k = 0;
      break label37;
      n = 0;
      break label55;
      i2 = 0;
      break label81;
      i4 = 0;
      break label107;
      i6 = 0;
      break label133;
      i8 = 0;
      break label159;
      i10 = 0;
      break label185;
    }
  }

  public boolean isDisplayCompany()
  {
    return this.displayCompany;
  }

  public void setStatus(String paramString)
  {
    this.status = paramString;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.TripDriver
 * JD-Core Version:    0.6.2
 */