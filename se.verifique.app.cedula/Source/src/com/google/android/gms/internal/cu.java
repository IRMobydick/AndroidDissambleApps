package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class cu
  implements Parcelable.Creator
{
  static void a(ch paramch, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramch.b);
    c.a(paramParcel, 2, paramch.c, paramInt, false);
    c.a(paramParcel, 3, paramch.a(), false);
    c.a(paramParcel, 4, paramch.b(), false);
    c.a(paramParcel, 5, paramch.c(), false);
    c.a(paramParcel, 6, paramch.d(), false);
    c.a(paramParcel, 7, paramch.h, false);
    c.a(paramParcel, 8, paramch.i);
    c.a(paramParcel, 9, paramch.j, false);
    c.a(paramParcel, 10, paramch.f(), false);
    c.a(paramParcel, 11, paramch.l);
    c.a(paramParcel, 12, paramch.m);
    c.a(paramParcel, 13, paramch.n, false);
    c.a(paramParcel, 14, paramch.o, paramInt, false);
    c.a(paramParcel, 15, paramch.e(), false);
    c.a(paramParcel, 17, paramch.r, paramInt, false);
    c.a(paramParcel, 16, paramch.q, false);
    c.a(paramParcel, i);
  }

  public ch a(Parcel paramParcel)
  {
    int i = a.b(paramParcel);
    int j = 0;
    ce localce = null;
    IBinder localIBinder1 = null;
    IBinder localIBinder2 = null;
    IBinder localIBinder3 = null;
    IBinder localIBinder4 = null;
    String str1 = null;
    boolean bool = false;
    String str2 = null;
    IBinder localIBinder5 = null;
    int k = 0;
    int m = 0;
    String str3 = null;
    ev localev = null;
    IBinder localIBinder6 = null;
    String str4 = null;
    v localv = null;
    while (paramParcel.dataPosition() < i)
    {
      int n = a.a(paramParcel);
      switch (a.a(n))
      {
      default:
        a.b(paramParcel, n);
        break;
      case 1:
        j = a.g(paramParcel, n);
        break;
      case 2:
        localce = (ce)a.a(paramParcel, n, ce.a);
        break;
      case 3:
        localIBinder1 = a.p(paramParcel, n);
        break;
      case 4:
        localIBinder2 = a.p(paramParcel, n);
        break;
      case 5:
        localIBinder3 = a.p(paramParcel, n);
        break;
      case 6:
        localIBinder4 = a.p(paramParcel, n);
        break;
      case 7:
        str1 = a.o(paramParcel, n);
        break;
      case 8:
        bool = a.c(paramParcel, n);
        break;
      case 9:
        str2 = a.o(paramParcel, n);
        break;
      case 10:
        localIBinder5 = a.p(paramParcel, n);
        break;
      case 11:
        k = a.g(paramParcel, n);
        break;
      case 12:
        m = a.g(paramParcel, n);
        break;
      case 13:
        str3 = a.o(paramParcel, n);
        break;
      case 14:
        localev = (ev)a.a(paramParcel, n, ev.a);
        break;
      case 15:
        localIBinder6 = a.p(paramParcel, n);
        break;
      case 17:
        localv = (v)a.a(paramParcel, n, v.a);
        break;
      case 16:
        str4 = a.o(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new ch(j, localce, localIBinder1, localIBinder2, localIBinder3, localIBinder4, str1, bool, str2, localIBinder5, k, m, str3, localev, localIBinder6, str4, localv);
  }

  public ch[] a(int paramInt)
  {
    return new ch[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.cu
 * JD-Core Version:    0.6.0
 */