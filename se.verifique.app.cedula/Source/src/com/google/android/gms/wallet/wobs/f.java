package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class f
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new m();
  String a;
  g b;
  String c;
  l d;
  private final int e;

  f()
  {
    this.e = 1;
  }

  f(int paramInt, String paramString1, g paramg, String paramString2, l paraml)
  {
    this.e = paramInt;
    this.a = paramString1;
    this.b = paramg;
    this.c = paramString2;
    this.d = paraml;
  }

  public int a()
  {
    return this.e;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    m.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.wobs.f
 * JD-Core Version:    0.6.0
 */