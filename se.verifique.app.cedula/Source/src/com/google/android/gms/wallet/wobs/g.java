package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class g
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new k();
  int a;
  String b;
  double c;
  String d;
  long e;
  int f;
  private final int g;

  g()
  {
    this.g = 1;
    this.f = -1;
    this.a = -1;
    this.c = -1.0D;
  }

  g(int paramInt1, int paramInt2, String paramString1, double paramDouble, String paramString2, long paramLong, int paramInt3)
  {
    this.g = paramInt1;
    this.a = paramInt2;
    this.b = paramString1;
    this.c = paramDouble;
    this.d = paramString2;
    this.e = paramLong;
    this.f = paramInt3;
  }

  public int a()
  {
    return this.g;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    k.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.wobs.g
 * JD-Core Version:    0.6.0
 */