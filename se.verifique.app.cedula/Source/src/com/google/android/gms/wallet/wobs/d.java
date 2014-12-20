package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ln;
import java.util.ArrayList;

public final class d
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new i();
  String a;
  String b;
  ArrayList c;
  private final int d;

  d()
  {
    this.d = 1;
    this.c = ln.a();
  }

  d(int paramInt, String paramString1, String paramString2, ArrayList paramArrayList)
  {
    this.d = paramInt;
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramArrayList;
  }

  public int a()
  {
    return this.d;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    i.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.wobs.d
 * JD-Core Version:    0.6.0
 */