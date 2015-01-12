package com.ubercab.client.core.vendor.alipay.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AlipayCredentials
  implements Parcelable
{
  public static Parcelable.Creator<AlipayCredentials> CREATOR = new Parcelable.Creator()
  {
    public AlipayCredentials createFromParcel(Parcel paramAnonymousParcel)
    {
      return new AlipayCredentials(paramAnonymousParcel);
    }

    public AlipayCredentials[] newArray(int paramAnonymousInt)
    {
      return new AlipayCredentials[paramAnonymousInt];
    }
  };
  private String mAccountId;
  private String mMobile;

  public AlipayCredentials(Parcel paramParcel)
  {
    this.mAccountId = paramParcel.readString();
    this.mMobile = paramParcel.readString();
  }

  public AlipayCredentials(String paramString1, String paramString2)
  {
    this.mAccountId = paramString1;
    this.mMobile = paramString2;
  }

  public int describeContents()
  {
    return 0;
  }

  public String getAccountId()
  {
    return this.mAccountId;
  }

  public String getMobile()
  {
    return this.mMobile;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mAccountId);
    paramParcel.writeString(this.mMobile);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.vendor.alipay.model.AlipayCredentials
 * JD-Core Version:    0.6.2
 */