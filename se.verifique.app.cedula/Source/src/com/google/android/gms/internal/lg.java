package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class lg
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new nl();
  int[] a;
  private final int b;

  lg()
  {
    this(1, null);
  }

  lg(int paramInt, int[] paramArrayOfInt)
  {
    this.b = paramInt;
    this.a = paramArrayOfInt;
  }

  public int a()
  {
    return this.b;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    nl.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.lg
 * JD-Core Version:    0.6.0
 */