package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class j
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new o();
  String a;
  String b;
  private final int c;

  j()
  {
    this.c = 1;
  }

  j(int paramInt, String paramString1, String paramString2)
  {
    this.c = paramInt;
    this.a = paramString1;
    this.b = paramString2;
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
    o.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.wobs.j
 * JD-Core Version:    0.6.0
 */