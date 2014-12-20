package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class jg
  implements Parcelable.Creator
{
  static void a(gj paramgj, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramgj.a());
    c.a(paramParcel, 2, paramgj.b());
    c.a(paramParcel, 3, paramgj.c());
    c.a(paramParcel, 4, paramgj.d());
    c.a(paramParcel, i);
  }

  public gj a(Parcel paramParcel)
  {
    int i = 0;
    int j = a.b(paramParcel);
    double d = 0.0D;
    boolean bool = false;
    int k = 0;
    while (paramParcel.dataPosition() < j)
    {
      int m = a.a(paramParcel);
      switch (a.a(m))
      {
      default:
        a.b(paramParcel, m);
        break;
      case 1:
        k = a.g(paramParcel, m);
        break;
      case 2:
        d = a.m(paramParcel, m);
        break;
      case 3:
        bool = a.c(paramParcel, m);
        break;
      case 4:
        i = a.g(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new b("Overread allowed size end=" + j, paramParcel);
    return new gj(k, d, bool, i);
  }

  public gj[] a(int paramInt)
  {
    return new gj[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jg
 * JD-Core Version:    0.6.0
 */