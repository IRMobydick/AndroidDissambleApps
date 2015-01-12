package com.google.android.gms.gcm;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class Task
  implements Parcelable
{
  private final String adB = null;
  private final boolean adC = false;
  private final boolean adD = false;
  private final String mTag = null;

  public int describeContents()
  {
    return 0;
  }

  public String getServiceName()
  {
    return this.adB;
  }

  public String getTag()
  {
    return this.mTag;
  }

  public boolean isPersisted()
  {
    return this.adD;
  }

  public boolean isUpdateCurrent()
  {
    return this.adC;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.adB);
    paramParcel.writeString(this.mTag);
    int j;
    if (this.adC)
    {
      j = i;
      paramParcel.writeInt(j);
      if (!this.adD)
        break label53;
    }
    while (true)
    {
      paramParcel.writeInt(i);
      return;
      j = 0;
      break;
      label53: i = 0;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.gcm.Task
 * JD-Core Version:    0.6.2
 */