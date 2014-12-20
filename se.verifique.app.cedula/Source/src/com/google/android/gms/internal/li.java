package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class li
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new nm();
  String[] a;
  byte[][] b;
  private final int c;

  li()
  {
    this(1, new String[0], new byte[0][]);
  }

  li(int paramInt, String[] paramArrayOfString, byte[][] paramArrayOfByte)
  {
    this.c = paramInt;
    this.a = paramArrayOfString;
    this.b = paramArrayOfByte;
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
    nm.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.li
 * JD-Core Version:    0.6.0
 */