package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ht
  implements SafeParcelable
{
  public static final la a = new la();
  private final int b;
  private final hv c;

  ht(int paramInt, hv paramhv)
  {
    this.b = paramInt;
    this.c = paramhv;
  }

  private ht(hv paramhv)
  {
    this.b = 1;
    this.c = paramhv;
  }

  public static ht a(ld paramld)
  {
    if ((paramld instanceof hv))
      return new ht((hv)paramld);
    throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
  }

  int a()
  {
    return this.b;
  }

  hv b()
  {
    return this.c;
  }

  public ld c()
  {
    if (this.c != null)
      return this.c;
    throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    la.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ht
 * JD-Core Version:    0.6.0
 */