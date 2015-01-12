package com.ubercab.client.core.vendor.google;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class GmmProductSurge
  implements Parcelable
{
  public static Parcelable.Creator<GmmProductSurge> CREATOR = new Parcelable.Creator()
  {
    public GmmProductSurge createFromParcel(Parcel paramAnonymousParcel)
    {
      return new GmmProductSurge(paramAnonymousParcel, null);
    }

    public GmmProductSurge[] newArray(int paramAnonymousInt)
    {
      return new GmmProductSurge[paramAnonymousInt];
    }
  };
  private Float mSurge;
  private String mUuid;

  private GmmProductSurge(Parcel paramParcel)
  {
    this.mUuid = paramParcel.readString();
    this.mSurge = ((Float)paramParcel.readValue(Float.class.getClassLoader()));
  }

  public GmmProductSurge(String paramString, Float paramFloat)
  {
    if (paramString == null)
      paramString = "";
    this.mUuid = paramString;
    this.mSurge = paramFloat;
  }

  public int describeContents()
  {
    return 0;
  }

  public Float getSurge()
  {
    return this.mSurge;
  }

  public String getUuid()
  {
    return this.mUuid;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mUuid);
    paramParcel.writeValue(this.mSurge);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.vendor.google.GmmProductSurge
 * JD-Core Version:    0.6.2
 */