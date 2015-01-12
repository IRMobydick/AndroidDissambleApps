package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class fj
  implements Parcelable.Creator<fi>
{
  static void a(fi paramfi, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.c(paramParcel, 1, paramfi.versionCode);
    b.a(paramParcel, 2, paramfi.tw, false);
    b.a(paramParcel, 3, paramfi.tx, paramInt, false);
    b.a(paramParcel, 4, paramfi.lH, paramInt, false);
    b.a(paramParcel, 5, paramfi.lA, false);
    b.a(paramParcel, 6, paramfi.applicationInfo, paramInt, false);
    b.a(paramParcel, 7, paramfi.ty, paramInt, false);
    b.a(paramParcel, 8, paramfi.tz, false);
    b.a(paramParcel, 9, paramfi.tA, false);
    b.a(paramParcel, 10, paramfi.tB, false);
    b.a(paramParcel, 11, paramfi.lD, paramInt, false);
    b.a(paramParcel, 12, paramfi.tC, false);
    b.c(paramParcel, 13, paramfi.tD);
    b.b(paramParcel, 14, paramfi.lS, false);
    b.a(paramParcel, 15, paramfi.tE, false);
    b.a(paramParcel, 16, paramfi.tF);
    b.H(paramParcel, i);
  }

  public fi h(Parcel paramParcel)
  {
    int i = a.C(paramParcel);
    int j = 0;
    Bundle localBundle1 = null;
    av localav = null;
    ay localay = null;
    String str1 = null;
    ApplicationInfo localApplicationInfo = null;
    PackageInfo localPackageInfo = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    gt localgt = null;
    Bundle localBundle2 = null;
    int k = 0;
    ArrayList localArrayList = null;
    Bundle localBundle3 = null;
    boolean bool = false;
    while (paramParcel.dataPosition() < i)
    {
      int m = a.B(paramParcel);
      switch (a.aD(m))
      {
      default:
        a.b(paramParcel, m);
        break;
      case 1:
        j = a.g(paramParcel, m);
        break;
      case 2:
        localBundle1 = a.q(paramParcel, m);
        break;
      case 3:
        localav = (av)a.a(paramParcel, m, av.CREATOR);
        break;
      case 4:
        localay = (ay)a.a(paramParcel, m, ay.CREATOR);
        break;
      case 5:
        str1 = a.o(paramParcel, m);
        break;
      case 6:
        localApplicationInfo = (ApplicationInfo)a.a(paramParcel, m, ApplicationInfo.CREATOR);
        break;
      case 7:
        localPackageInfo = (PackageInfo)a.a(paramParcel, m, PackageInfo.CREATOR);
        break;
      case 8:
        str2 = a.o(paramParcel, m);
        break;
      case 9:
        str3 = a.o(paramParcel, m);
        break;
      case 10:
        str4 = a.o(paramParcel, m);
        break;
      case 11:
        localgt = (gt)a.a(paramParcel, m, gt.CREATOR);
        break;
      case 12:
        localBundle2 = a.q(paramParcel, m);
        break;
      case 13:
        k = a.g(paramParcel, m);
        break;
      case 14:
        localArrayList = a.C(paramParcel, m);
        break;
      case 15:
        localBundle3 = a.q(paramParcel, m);
        break;
      case 16:
        bool = a.c(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    return new fi(j, localBundle1, localav, localay, str1, localApplicationInfo, localPackageInfo, str2, str3, str4, localgt, localBundle2, k, localArrayList, localBundle3, bool);
  }

  public fi[] p(int paramInt)
  {
    return new fi[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fj
 * JD-Core Version:    0.6.2
 */