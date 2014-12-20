package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Operator
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new k();
  public static final Operator a = new Operator("=");
  public static final Operator b = new Operator("<");
  public static final Operator c = new Operator("<=");
  public static final Operator d = new Operator(">");
  public static final Operator e = new Operator(">=");
  public static final Operator f = new Operator("and");
  public static final Operator g = new Operator("or");
  public static final Operator h = new Operator("not");
  public static final Operator i = new Operator("contains");
  final String j;
  final int k;

  Operator(int paramInt, String paramString)
  {
    this.k = paramInt;
    this.j = paramString;
  }

  private Operator(String paramString)
  {
    this(1, paramString);
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    int m = 1;
    if (this == paramObject);
    while (true)
    {
      return m;
      if (paramObject == null)
      {
        m = 0;
        continue;
      }
      if (getClass() != paramObject.getClass())
      {
        m = 0;
        continue;
      }
      Operator localOperator = (Operator)paramObject;
      if (this.j == null)
      {
        if (localOperator.j == null)
          continue;
        m = 0;
        continue;
      }
      if (this.j.equals(localOperator.j))
        continue;
      m = 0;
    }
  }

  public int hashCode()
  {
    if (this.j == null);
    for (int m = 0; ; m = this.j.hashCode())
      return m + 31;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    k.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.Operator
 * JD-Core Version:    0.6.0
 */