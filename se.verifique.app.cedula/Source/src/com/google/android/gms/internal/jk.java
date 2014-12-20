package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class jk
  implements SafeParcelable
{
  public static final mp a = new mp();
  private final int b;
  private final int c;
  private final int d;
  private final jm e;

  jk(int paramInt1, int paramInt2, int paramInt3, jm paramjm)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramjm;
  }

  public int a()
  {
    return this.b;
  }

  public int b()
  {
    return this.c;
  }

  public int c()
  {
    return this.d;
  }

  public jm d()
  {
    return this.e;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    int i = 1;
    if (this == paramObject);
    while (true)
    {
      return i;
      if (!(paramObject instanceof jk))
      {
        i = 0;
        continue;
      }
      jk localjk = (jk)paramObject;
      if ((this.c == localjk.c) && (this.d == localjk.d) && (this.e.equals(localjk.e)))
        continue;
      i = 0;
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(this.c);
    arrayOfObject[1] = Integer.valueOf(this.d);
    return kt.a(arrayOfObject);
  }

  public String toString()
  {
    return kt.a(this).a("transitionTypes", Integer.valueOf(this.c)).a("loiteringTimeMillis", Integer.valueOf(this.d)).a("placeFilter", this.e).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    mp.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jk
 * JD-Core Version:    0.6.0
 */