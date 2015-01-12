package com.paypal.android.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Random;

public final class bB extends bo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new bC();

  public bB()
  {
    long l = System.currentTimeMillis();
    if (this.a == null)
      this.b = l;
    if (1800000L + this.b > l)
    {
      this.b = l;
      Random localRandom = new Random(this.b);
      StringBuilder localStringBuilder = new StringBuilder();
      for (int i = 0; i < 8; i++)
        localStringBuilder.append((char)(48 + Math.abs(localRandom.nextInt()) % 10));
      this.a = localStringBuilder.toString();
    }
  }

  public bB(Parcel paramParcel)
  {
    super(paramParcel);
  }

  public final int describeContents()
  {
    return 0;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeLong(this.b);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.bB
 * JD-Core Version:    0.6.2
 */