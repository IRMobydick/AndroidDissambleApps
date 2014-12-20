package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class gj
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new jg();
  private final int a;
  private double b;
  private boolean c;
  private int d;

  public gj()
  {
    this(1, (0.0D / 0.0D), false, -1);
  }

  gj(int paramInt1, double paramDouble, boolean paramBoolean, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramDouble;
    this.c = paramBoolean;
    this.d = paramInt2;
  }

  public int a()
  {
    return this.a;
  }

  public double b()
  {
    return this.b;
  }

  public boolean c()
  {
    return this.c;
  }

  public int d()
  {
    return this.d;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    int i = 1;
    if (paramObject == this);
    while (true)
    {
      return i;
      if (!(paramObject instanceof gj))
      {
        i = 0;
        continue;
      }
      gj localgj = (gj)paramObject;
      if ((this.b == localgj.b) && (this.c == localgj.c) && (this.d == localgj.d))
        continue;
      i = 0;
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Double.valueOf(this.b);
    arrayOfObject[1] = Boolean.valueOf(this.c);
    arrayOfObject[2] = Integer.valueOf(this.d);
    return kt.a(arrayOfObject);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    jg.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gj
 * JD-Core Version:    0.6.0
 */