package com.ubercab.client.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public final class AddressComponent
  implements Parcelable
{
  public static Parcelable.Creator<AddressComponent> CREATOR = new Parcelable.Creator()
  {
    public AddressComponent createFromParcel(Parcel paramAnonymousParcel)
    {
      return new AddressComponent(paramAnonymousParcel, null);
    }

    public AddressComponent[] newArray(int paramAnonymousInt)
    {
      return new AddressComponent[paramAnonymousInt];
    }
  };
  public static final String TYPE_ADMIN_AREA_LEVEL_1 = "administrative_area_level_1";
  public static final String TYPE_ADMIN_AREA_LEVEL_2 = "administrative_area_level_2";
  public static final String TYPE_COUNTRY = "country";
  public static final String TYPE_ESTABLISHMENT = "establishment";
  public static final String TYPE_LOCALITY = "locality";
  public static final String TYPE_NEIGHBORHOOD = "neighborhood";
  public static final String TYPE_POSTAL_CODE = "postal_code";
  public static final String TYPE_ROUTE = "route";
  public static final String TYPE_STREET_NUMBER = "street_number";
  public static final String TYPE_TRANSIT_STATION = "transit_station";
  private String long_name;
  private String short_name;
  private List<String> types;

  public AddressComponent()
  {
  }

  private AddressComponent(Parcel paramParcel)
  {
    this.long_name = paramParcel.readString();
    this.short_name = paramParcel.readString();
    this.types = paramParcel.readArrayList(String.class.getClassLoader());
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    AddressComponent localAddressComponent;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localAddressComponent = (AddressComponent)paramObject;
      if (this.long_name != null)
      {
        if (this.long_name.equals(localAddressComponent.long_name));
      }
      else
        while (localAddressComponent.long_name != null)
          return false;
      if (this.short_name != null)
      {
        if (this.short_name.equals(localAddressComponent.short_name));
      }
      else
        while (localAddressComponent.short_name != null)
          return false;
      if (this.types == null)
        break;
    }
    while (this.types.equals(localAddressComponent.types));
    while (true)
    {
      return false;
      if (localAddressComponent.types == null)
        break;
    }
  }

  public String getLongName()
  {
    return this.long_name;
  }

  public String getShortName()
  {
    return this.short_name;
  }

  public List<String> getTypes()
  {
    return this.types;
  }

  public int hashCode()
  {
    int i;
    int j;
    if (this.long_name != null)
    {
      i = this.long_name.hashCode();
      j = i * 31;
      if (this.short_name == null)
        break label79;
    }
    label79: for (int k = this.short_name.hashCode(); ; k = 0)
    {
      int m = 31 * (j + k);
      List localList = this.types;
      int n = 0;
      if (localList != null)
        n = this.types.hashCode();
      return m + n;
      i = 0;
      break;
    }
  }

  public void setLongName(String paramString)
  {
    this.long_name = paramString;
  }

  public void setShortName(String paramString)
  {
    this.short_name = paramString;
  }

  public void setTypes(List<String> paramList)
  {
    this.types = paramList;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.long_name);
    paramParcel.writeString(this.short_name);
    if (this.types == null);
    for (Object[] arrayOfObject = null; ; arrayOfObject = this.types.toArray())
    {
      paramParcel.writeArray(arrayOfObject);
      return;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.AddressComponent
 * JD-Core Version:    0.6.2
 */