package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class p
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new s();
  String a;
  String b;
  l c;
  n d;
  n e;
  private final int f;

  p()
  {
    this.f = 1;
  }

  p(int paramInt, String paramString1, String paramString2, l paraml, n paramn1, n paramn2)
  {
    this.f = paramInt;
    this.a = paramString1;
    this.b = paramString2;
    this.c = paraml;
    this.d = paramn1;
    this.e = paramn2;
  }

  public int a()
  {
    return this.f;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    s.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.wobs.p
 * JD-Core Version:    0.6.0
 */