package com.ubercab.client.feature.signup;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class ThirdPartyToken
  implements Parcelable
{
  public static Parcelable.Creator<ThirdPartyToken> CREATOR = new Parcelable.Creator()
  {
    public ThirdPartyToken createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ThirdPartyToken(paramAnonymousParcel, null);
    }

    public ThirdPartyToken[] newArray(int paramAnonymousInt)
    {
      return new ThirdPartyToken[paramAnonymousInt];
    }
  };
  private long mExpiresInMs;
  private String mToken;
  private String mType;

  public ThirdPartyToken()
  {
  }

  private ThirdPartyToken(Parcel paramParcel)
  {
    this.mType = paramParcel.readString();
    this.mToken = paramParcel.readString();
    this.mExpiresInMs = paramParcel.readLong();
  }

  public ThirdPartyToken(String paramString1, String paramString2, long paramLong)
  {
    this.mType = paramString1;
    this.mToken = paramString2;
    this.mExpiresInMs = paramLong;
  }

  public int describeContents()
  {
    return 0;
  }

  public long getExpiresInMs()
  {
    return this.mExpiresInMs;
  }

  public String getToken()
  {
    return this.mToken;
  }

  public String getType()
  {
    return this.mType;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mType);
    paramParcel.writeString(this.mToken);
    paramParcel.writeLong(this.mExpiresInMs);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.signup.ThirdPartyToken
 * JD-Core Version:    0.6.2
 */