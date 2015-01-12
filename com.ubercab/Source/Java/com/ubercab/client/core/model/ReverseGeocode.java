package com.ubercab.client.core.model;

import com.google.gson.annotations.SerializedName;

public final class ReverseGeocode
{
  private String id = "";
  private double latitude = 0.0D;

  @SerializedName("long")
  private String longName = "";
  private double longitude = 0.0D;
  private String nickname = "";

  @SerializedName("short")
  private String shortName = "";

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    ReverseGeocode localReverseGeocode;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localReverseGeocode = (ReverseGeocode)paramObject;
      if (Double.compare(localReverseGeocode.latitude, this.latitude) != 0)
        return false;
      if (Double.compare(localReverseGeocode.longitude, this.longitude) != 0)
        return false;
      if (this.id != null)
      {
        if (this.id.equals(localReverseGeocode.id));
      }
      else
        while (localReverseGeocode.id != null)
          return false;
      if (this.longName != null)
      {
        if (this.longName.equals(localReverseGeocode.longName));
      }
      else
        while (localReverseGeocode.longName != null)
          return false;
      if (this.nickname != null)
      {
        if (this.nickname.equals(localReverseGeocode.nickname));
      }
      else
        while (localReverseGeocode.nickname != null)
          return false;
      if (this.shortName == null)
        break;
    }
    while (this.shortName.equals(localReverseGeocode.shortName));
    while (true)
    {
      return false;
      if (localReverseGeocode.shortName == null)
        break;
    }
  }

  public String getId()
  {
    return this.id;
  }

  public double getLatitude()
  {
    return this.latitude;
  }

  public String getLongName()
  {
    return this.longName;
  }

  public double getLongitude()
  {
    return this.longitude;
  }

  public String getNickname()
  {
    return this.nickname;
  }

  public String getShortName()
  {
    return this.shortName;
  }

  public int hashCode()
  {
    int i;
    int m;
    label82: int n;
    if (this.id != null)
    {
      i = this.id.hashCode();
      long l1 = Double.doubleToLongBits(this.longitude);
      int j = i * 31 + (int)(l1 ^ l1 >>> 32);
      long l2 = Double.doubleToLongBits(this.latitude);
      int k = 31 * (j * 31 + (int)(l2 ^ l2 >>> 32));
      if (this.nickname == null)
        break label152;
      m = this.nickname.hashCode();
      n = 31 * (k + m);
      if (this.shortName == null)
        break label158;
    }
    label152: label158: for (int i1 = this.shortName.hashCode(); ; i1 = 0)
    {
      int i2 = 31 * (n + i1);
      String str = this.longName;
      int i3 = 0;
      if (str != null)
        i3 = this.longName.hashCode();
      return i2 + i3;
      i = 0;
      break;
      m = 0;
      break label82;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.ReverseGeocode
 * JD-Core Version:    0.6.2
 */