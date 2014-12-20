package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ib$b
  implements SafeParcelable
{
  public static final lj a = new lj();
  final int b;
  final String c;
  final hy.a d;

  ib$b(int paramInt, String paramString, hy.a parama)
  {
    this.b = paramInt;
    this.c = paramString;
    this.d = parama;
  }

  ib$b(String paramString, hy.a parama)
  {
    this.b = 1;
    this.c = paramString;
    this.d = parama;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    lj.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ib.b
 * JD-Core Version:    0.6.0
 */