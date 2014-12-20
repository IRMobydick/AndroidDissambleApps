package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class hv$a
  implements SafeParcelable
{
  public static final lc a = new lc();
  final int b;
  final String c;
  final int d;

  hv$a(int paramInt1, String paramString, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramString;
    this.d = paramInt2;
  }

  hv$a(String paramString, int paramInt)
  {
    this.b = 1;
    this.c = paramString;
    this.d = paramInt;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    lc.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hv.a
 * JD-Core Version:    0.6.0
 */