package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class l
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new q();
  long a;
  long b;
  private final int c;

  l()
  {
    this.c = 1;
  }

  l(int paramInt, long paramLong1, long paramLong2)
  {
    this.c = paramInt;
    this.a = paramLong1;
    this.b = paramLong2;
  }

  public int a()
  {
    return this.c;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    q.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.wobs.l
 * JD-Core Version:    0.6.0
 */