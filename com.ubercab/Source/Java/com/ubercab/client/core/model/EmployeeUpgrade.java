package com.ubercab.client.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class EmployeeUpgrade
  implements Parcelable
{
  public static Parcelable.Creator<EmployeeUpgrade> CREATOR = new Parcelable.Creator()
  {
    public EmployeeUpgrade createFromParcel(Parcel paramAnonymousParcel)
    {
      return new EmployeeUpgrade(paramAnonymousParcel, null);
    }

    public EmployeeUpgrade[] newArray(int paramAnonymousInt)
    {
      return new EmployeeUpgrade[paramAnonymousInt];
    }
  };
  private String mDownloadUrl;
  private String mReleaseNotes;
  private String mVersion;

  public EmployeeUpgrade()
  {
  }

  private EmployeeUpgrade(Parcel paramParcel)
  {
    this.mDownloadUrl = paramParcel.readString();
    this.mVersion = paramParcel.readString();
    this.mReleaseNotes = paramParcel.readString();
  }

  public EmployeeUpgrade(String paramString1, String paramString2, String paramString3)
  {
    this.mDownloadUrl = paramString1;
    this.mVersion = paramString2;
    this.mReleaseNotes = paramString3;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    EmployeeUpgrade localEmployeeUpgrade;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localEmployeeUpgrade = (EmployeeUpgrade)paramObject;
      if (this.mDownloadUrl != null)
      {
        if (this.mDownloadUrl.equals(localEmployeeUpgrade.mDownloadUrl));
      }
      else
        while (localEmployeeUpgrade.mDownloadUrl != null)
          return false;
      if (this.mReleaseNotes != null)
      {
        if (this.mReleaseNotes.equals(localEmployeeUpgrade.mReleaseNotes));
      }
      else
        while (localEmployeeUpgrade.mReleaseNotes != null)
          return false;
      if (this.mVersion == null)
        break;
    }
    while (this.mVersion.equals(localEmployeeUpgrade.mVersion));
    while (true)
    {
      return false;
      if (localEmployeeUpgrade.mVersion == null)
        break;
    }
  }

  public String getDownloadUrl()
  {
    return this.mDownloadUrl;
  }

  public String getReleaseNotes()
  {
    return this.mReleaseNotes;
  }

  public String getVersion()
  {
    return this.mVersion;
  }

  public int hashCode()
  {
    int i;
    int j;
    if (this.mDownloadUrl != null)
    {
      i = this.mDownloadUrl.hashCode();
      j = i * 31;
      if (this.mVersion == null)
        break label77;
    }
    label77: for (int k = this.mVersion.hashCode(); ; k = 0)
    {
      int m = 31 * (j + k);
      String str = this.mReleaseNotes;
      int n = 0;
      if (str != null)
        n = this.mReleaseNotes.hashCode();
      return m + n;
      i = 0;
      break;
    }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mDownloadUrl);
    paramParcel.writeString(this.mVersion);
    paramParcel.writeString(this.mReleaseNotes);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.EmployeeUpgrade
 * JD-Core Version:    0.6.2
 */