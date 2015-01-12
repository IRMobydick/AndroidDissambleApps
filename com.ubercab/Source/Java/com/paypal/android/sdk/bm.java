package com.paypal.android.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class bm extends bo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new bn();
  private boolean c;

  public bm(Parcel paramParcel)
  {
    super(paramParcel);
    if (paramParcel.readByte() != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.c = bool;
      return;
    }
  }

  public bm(String paramString, long paramLong, boolean paramBoolean)
  {
    this.a = paramString;
    this.b = paramLong;
    this.c = paramBoolean;
  }

  public final boolean a()
  {
    return this.c;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final String toString()
  {
    return bm.class.getSimpleName() + "(mToken:" + this.a + ", mGoodUntil:" + this.b + ", isCreatedInternally:" + this.c + ")";
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeLong(this.b);
    if (this.c);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeByte((byte)i);
      return;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.bm
 * JD-Core Version:    0.6.2
 */