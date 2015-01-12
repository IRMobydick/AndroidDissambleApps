package com.ubercab.client.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.ubercab.library.location.model.UberLatLng;
import java.util.List;

public class CnLocation
  implements Parcelable
{
  public static Parcelable.Creator<CnLocation> CREATOR = new Parcelable.Creator()
  {
    public CnLocation createFromParcel(Parcel paramAnonymousParcel)
    {
      return new CnLocation(paramAnonymousParcel, null);
    }

    public CnLocation[] newArray(int paramAnonymousInt)
    {
      return new CnLocation[paramAnonymousInt];
    }
  };
  private String address;
  private List<AddressComponent> address_components;
  private Long distance;
  private String formatted_address;
  private String id;
  private String language;
  Double latitude;
  Double longitude;
  private String nickname;
  private String reference;
  private String referenceType;
  private String relevance;
  private String type;

  public CnLocation()
  {
  }

  private CnLocation(Parcel paramParcel)
  {
    this.distance = ((Long)paramParcel.readValue(Long.class.getClassLoader()));
    this.latitude = ((Double)paramParcel.readValue(Double.class.getClassLoader()));
    this.longitude = ((Double)paramParcel.readValue(Double.class.getClassLoader()));
    this.id = paramParcel.readString();
    this.type = paramParcel.readString();
    this.nickname = paramParcel.readString();
    this.address = paramParcel.readString();
    this.reference = paramParcel.readString();
    this.relevance = paramParcel.readString();
    this.referenceType = paramParcel.readString();
    this.formatted_address = paramParcel.readString();
    this.language = paramParcel.readString();
    this.address_components = paramParcel.readArrayList(AddressComponent.class.getClassLoader());
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    CnLocation localCnLocation;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localCnLocation = (CnLocation)paramObject;
      if (this.distance != null)
      {
        if (this.distance.equals(localCnLocation.distance));
      }
      else
        while (localCnLocation.distance != null)
          return false;
      if (this.latitude != null)
      {
        if (this.latitude.equals(localCnLocation.latitude));
      }
      else
        while (localCnLocation.latitude != null)
          return false;
      if (this.longitude != null)
      {
        if (this.longitude.equals(localCnLocation.longitude));
      }
      else
        while (localCnLocation.longitude != null)
          return false;
      if (this.address != null)
      {
        if (this.address.equals(localCnLocation.address));
      }
      else
        while (localCnLocation.address != null)
          return false;
      if (this.address_components != null)
      {
        if (this.address_components.equals(localCnLocation.address_components));
      }
      else
        while (localCnLocation.address_components != null)
          return false;
      if (this.formatted_address != null)
      {
        if (this.formatted_address.equals(localCnLocation.formatted_address));
      }
      else
        while (localCnLocation.formatted_address != null)
          return false;
      if (this.id != null)
      {
        if (this.id.equals(localCnLocation.id));
      }
      else
        while (localCnLocation.id != null)
          return false;
      if (this.language != null)
      {
        if (this.language.equals(localCnLocation.language));
      }
      else
        while (localCnLocation.language != null)
          return false;
      if (this.nickname != null)
      {
        if (this.nickname.equals(localCnLocation.nickname));
      }
      else
        while (localCnLocation.nickname != null)
          return false;
      if (this.reference != null)
      {
        if (this.reference.equals(localCnLocation.reference));
      }
      else
        while (localCnLocation.reference != null)
          return false;
      if (this.referenceType != null)
      {
        if (this.referenceType.equals(localCnLocation.referenceType));
      }
      else
        while (localCnLocation.referenceType != null)
          return false;
      if (this.relevance != null)
      {
        if (this.relevance.equals(localCnLocation.relevance));
      }
      else
        while (localCnLocation.relevance != null)
          return false;
      if (this.type == null)
        break;
    }
    while (this.type.equals(localCnLocation.type));
    while (true)
    {
      return false;
      if (localCnLocation.type == null)
        break;
    }
  }

  public String getAddress()
  {
    return this.address;
  }

  public List<AddressComponent> getAddressComponents()
  {
    return this.address_components;
  }

  public long getDistance()
  {
    if (this.distance != null)
      return this.distance.longValue();
    return 0L;
  }

  public String getFormattedAddress()
  {
    return this.formatted_address;
  }

  public String getId()
  {
    return this.id;
  }

  public String getLanguage()
  {
    return this.language;
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

  public String getNickname()
  {
    return this.nickname;
  }

  public String getReference()
  {
    return this.reference;
  }

  public String getReferenceType()
  {
    return this.referenceType;
  }

  public String getType()
  {
    return this.type;
  }

  public UberLatLng getUberLatLng()
  {
    return new UberLatLng(getLatitude(), getLongitude());
  }

  public int hashCode()
  {
    int i;
    long l1;
    label45: long l2;
    label78: int m;
    label114: int i1;
    label140: int i3;
    label166: int i5;
    label192: int i7;
    label218: int i9;
    label244: int i11;
    label270: int i13;
    label296: int i14;
    if (this.distance != null)
    {
      i = (int)(this.distance.longValue() ^ this.distance.longValue() >>> 32);
      if (this.latitude == null)
        break label368;
      l1 = Double.doubleToLongBits(this.latitude.doubleValue());
      int j = i * 31 + (int)(l1 ^ l1 >>> 32);
      if (this.longitude == null)
        break label373;
      l2 = Double.doubleToLongBits(this.longitude.doubleValue());
      int k = 31 * (j * 31 + (int)(l2 ^ l2 >>> 32));
      if (this.id == null)
        break label379;
      m = this.id.hashCode();
      int n = 31 * (k + m);
      if (this.type == null)
        break label385;
      i1 = this.type.hashCode();
      int i2 = 31 * (n + i1);
      if (this.nickname == null)
        break label391;
      i3 = this.nickname.hashCode();
      int i4 = 31 * (i2 + i3);
      if (this.address == null)
        break label397;
      i5 = this.address.hashCode();
      int i6 = 31 * (i4 + i5);
      if (this.reference == null)
        break label403;
      i7 = this.reference.hashCode();
      int i8 = 31 * (i6 + i7);
      if (this.relevance == null)
        break label409;
      i9 = this.relevance.hashCode();
      int i10 = 31 * (i8 + i9);
      if (this.referenceType == null)
        break label415;
      i11 = this.referenceType.hashCode();
      int i12 = 31 * (i10 + i11);
      if (this.formatted_address == null)
        break label421;
      i13 = this.formatted_address.hashCode();
      i14 = 31 * (i12 + i13);
      if (this.address_components == null)
        break label427;
    }
    label385: label391: label397: label403: label409: label415: label421: label427: for (int i15 = this.address_components.hashCode(); ; i15 = 0)
    {
      int i16 = 31 * (i14 + i15);
      String str = this.language;
      int i17 = 0;
      if (str != null)
        i17 = this.language.hashCode();
      return i16 + i17;
      i = 0;
      break;
      label368: l1 = 0L;
      break label45;
      label373: l2 = 0L;
      break label78;
      label379: m = 0;
      break label114;
      i1 = 0;
      break label140;
      i3 = 0;
      break label166;
      i5 = 0;
      break label192;
      i7 = 0;
      break label218;
      i9 = 0;
      break label244;
      i11 = 0;
      break label270;
      i13 = 0;
      break label296;
    }
  }

  public void setAddress(String paramString)
  {
    this.address = paramString;
  }

  public void setAddressComponents(List<AddressComponent> paramList)
  {
    this.address_components = paramList;
  }

  public void setDistance(long paramLong)
  {
    this.distance = Long.valueOf(paramLong);
  }

  public void setFormattedAddress(String paramString)
  {
    this.formatted_address = paramString;
  }

  public void setId(String paramString)
  {
    this.id = paramString;
  }

  public void setLanguage(String paramString)
  {
    this.language = paramString;
  }

  public void setLatitude(double paramDouble)
  {
    this.latitude = Double.valueOf(paramDouble);
  }

  public void setLongitude(double paramDouble)
  {
    this.longitude = Double.valueOf(paramDouble);
  }

  public void setNickname(String paramString)
  {
    this.nickname = paramString;
  }

  public void setReference(String paramString)
  {
    this.reference = paramString;
  }

  public void setReferenceType(String paramString)
  {
    this.referenceType = paramString;
  }

  public void setRelevance(String paramString)
  {
    this.relevance = paramString;
  }

  public void setType(String paramString)
  {
    this.type = paramString;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeValue(this.distance);
    paramParcel.writeValue(this.latitude);
    paramParcel.writeValue(this.longitude);
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.type);
    paramParcel.writeString(this.nickname);
    paramParcel.writeString(this.address);
    paramParcel.writeString(this.reference);
    paramParcel.writeString(this.relevance);
    paramParcel.writeString(this.referenceType);
    paramParcel.writeString(this.formatted_address);
    paramParcel.writeString(this.language);
    if (this.address_components != null);
    for (Object[] arrayOfObject = this.address_components.toArray(); ; arrayOfObject = null)
    {
      paramParcel.writeArray(arrayOfObject);
      return;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.CnLocation
 * JD-Core Version:    0.6.2
 */