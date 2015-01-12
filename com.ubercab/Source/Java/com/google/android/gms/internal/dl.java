package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class dl
  implements Parcelable.Creator<dm>
{
  static void a(dm paramdm, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.c(paramParcel, 1, paramdm.versionCode);
    b.a(paramParcel, 2, paramdm.rK, paramInt, false);
    b.a(paramParcel, 3, paramdm.cb(), false);
    b.a(paramParcel, 4, paramdm.cc(), false);
    b.a(paramParcel, 5, paramdm.cd(), false);
    b.a(paramParcel, 6, paramdm.ce(), false);
    b.a(paramParcel, 7, paramdm.rP, false);
    b.a(paramParcel, 8, paramdm.rQ);
    b.a(paramParcel, 9, paramdm.rR, false);
    b.a(paramParcel, 10, paramdm.cg(), false);
    b.c(paramParcel, 11, paramdm.orientation);
    b.c(paramParcel, 12, paramdm.rT);
    b.a(paramParcel, 13, paramdm.rq, false);
    b.a(paramParcel, 14, paramdm.lD, paramInt, false);
    b.a(paramParcel, 15, paramdm.cf(), false);
    b.a(paramParcel, 17, paramdm.rW, paramInt, false);
    b.a(paramParcel, 16, paramdm.rV, false);
    b.H(paramParcel, i);
  }

  public dm f(Parcel paramParcel)
  {
    int i = a.C(paramParcel);
    int j = 0;
    dj localdj = null;
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
    gt localgt = null;
    IBinder localIBinder6 = null;
    String str4 = null;
    x localx = null;
    while (paramParcel.dataPosition() < i)
    {
      int n = a.B(paramParcel);
      switch (a.aD(n))
      {
      default:
        a.b(paramParcel, n);
        break;
      case 1:
        j = a.g(paramParcel, n);
        break;
      case 2:
        localdj = (dj)a.a(paramParcel, n, dj.CREATOR);
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
        localgt = (gt)a.a(paramParcel, n, gt.CREATOR);
        break;
      case 15:
        localIBinder6 = a.p(paramParcel, n);
        break;
      case 17:
        localx = (x)a.a(paramParcel, n, x.CREATOR);
        break;
      case 16:
        str4 = a.o(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    return new dm(j, localdj, localIBinder1, localIBinder2, localIBinder3, localIBinder4, str1, bool, str2, localIBinder5, k, m, str3, localgt, localIBinder6, str4, localx);
  }

  public dm[] m(int paramInt)
  {
    return new dm[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.dl
 * JD-Core Version:    0.6.2
 */