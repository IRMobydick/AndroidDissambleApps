package com.paypal.android.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class bv
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new bw();
  private t a;
  private String b;
  private bx c;

  public bv()
  {
  }

  public bv(Parcel paramParcel)
  {
    this.a = ((t)paramParcel.readParcelable(t.class.getClassLoader()));
    this.b = paramParcel.readString();
    this.c = ((bx)paramParcel.readSerializable());
  }

  public bv(String paramString, t paramt, bx parambx)
  {
    this.b = paramString;
    this.a = paramt;
    this.c = parambx;
  }

  public final t a()
  {
    return this.a;
  }

  public final void a(bx parambx)
  {
    this.c = parambx;
  }

  public final void a(t paramt)
  {
    this.a = paramt;
  }

  public final void a(String paramString)
  {
    this.b = paramString;
  }

  public final String b()
  {
    return this.b;
  }

  public final bx c()
  {
    return this.c;
  }

  public final boolean d()
  {
    if ((this.c == null) || ((this.a == null) && (this.c.equals(bx.b))) || ((R.a(this.b)) && (this.c.equals(bx.a))));
    for (int i = 1; i == 0; i = 0)
      return true;
    return false;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final String e()
  {
    if (d())
    {
      if (this.c.equals(bx.a))
        return this.b;
      return this.a.a(br.d());
    }
    return null;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.a, 0);
    paramParcel.writeString(this.b);
    paramParcel.writeSerializable(this.c);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.bv
 * JD-Core Version:    0.6.2
 */