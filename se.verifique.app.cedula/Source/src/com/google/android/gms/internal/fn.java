package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class fn
  implements Parcelable.Creator
{
  static void a(ds paramds, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramds.b);
    c.a(paramParcel, 2, paramds.c, false);
    c.a(paramParcel, 3, paramds.d, paramInt, false);
    c.a(paramParcel, 4, paramds.e, paramInt, false);
    c.a(paramParcel, 5, paramds.f, false);
    c.a(paramParcel, 6, paramds.g, paramInt, false);
    c.a(paramParcel, 7, paramds.h, paramInt, false);
    c.a(paramParcel, 8, paramds.i, false);
    c.a(paramParcel, 9, paramds.j, false);
    c.a(paramParcel, 10, paramds.k, false);
    c.a(paramParcel, 11, paramds.l, paramInt, false);
    c.a(paramParcel, 12, paramds.m, false);
    c.a(paramParcel, 13, paramds.n, false);
    c.a(paramParcel, i);
  }

  public ds a(Parcel paramParcel)
  {
    int i = a.b(paramParcel);
    int j = 0;
    Bundle localBundle1 = null;
    ai localai = null;
    al localal = null;
    String str1 = null;
    ApplicationInfo localApplicationInfo = null;
    PackageInfo localPackageInfo = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    ev localev = null;
    Bundle localBundle2 = null;
    String str5 = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.a(paramParcel);
      switch (a.a(k))
      {
      default:
        a.b(paramParcel, k);
        break;
      case 1:
        j = a.g(paramParcel, k);
        break;
      case 2:
        localBundle1 = a.q(paramParcel, k);
        break;
      case 3:
        localai = (ai)a.a(paramParcel, k, ai.a);
        break;
      case 4:
        localal = (al)a.a(paramParcel, k, al.a);
        break;
      case 5:
        str1 = a.o(paramParcel, k);
        break;
      case 6:
        localApplicationInfo = (ApplicationInfo)a.a(paramParcel, k, ApplicationInfo.CREATOR);
        break;
      case 7:
        localPackageInfo = (PackageInfo)a.a(paramParcel, k, PackageInfo.CREATOR);
        break;
      case 8:
        str2 = a.o(paramParcel, k);
        break;
      case 9:
        str3 = a.o(paramParcel, k);
        break;
      case 10:
        str4 = a.o(paramParcel, k);
        break;
      case 11:
        localev = (ev)a.a(paramParcel, k, ev.a);
        break;
      case 12:
        localBundle2 = a.q(paramParcel, k);
        break;
      case 13:
        str5 = a.o(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new ds(j, localBundle1, localai, localal, str1, localApplicationInfo, localPackageInfo, str2, str3, str4, localev, localBundle2, str5);
  }

  public ds[] a(int paramInt)
  {
    return new ds[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fn
 * JD-Core Version:    0.6.0
 */