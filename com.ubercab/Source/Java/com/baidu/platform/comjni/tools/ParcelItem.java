package com.baidu.platform.comjni.tools;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ParcelItem
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelItem> a = new b();
  private Bundle b;

  public int describeContents()
  {
    return 0;
  }

  public Bundle getBundle()
  {
    return this.b;
  }

  public void setBundle(Bundle paramBundle)
  {
    this.b = paramBundle;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeBundle(this.b);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.platform.comjni.tools.ParcelItem
 * JD-Core Version:    0.6.2
 */