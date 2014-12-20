package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class fd
  implements Parcelable
{

  @Deprecated
  public static final Parcelable.Creator CREATOR = new iv();
  private String a;
  private String b;
  private String c;

  @Deprecated
  public fd()
  {
  }

  @Deprecated
  fd(Parcel paramParcel)
  {
    a(paramParcel);
  }

  @Deprecated
  private void a(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
  }

  @Deprecated
  public int describeContents()
  {
    return 0;
  }

  @Deprecated
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fd
 * JD-Core Version:    0.6.0
 */