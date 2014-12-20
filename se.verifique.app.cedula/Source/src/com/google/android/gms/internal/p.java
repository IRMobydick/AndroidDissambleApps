package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.ArrayList;

public class p
  implements Parcelable.Creator
{
  static void a(ai paramai, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramai.b);
    c.a(paramParcel, 2, paramai.c);
    c.a(paramParcel, 3, paramai.d, false);
    c.a(paramParcel, 4, paramai.e);
    c.a(paramParcel, 5, paramai.f, false);
    c.a(paramParcel, 6, paramai.g);
    c.a(paramParcel, 7, paramai.h);
    c.a(paramParcel, 8, paramai.i);
    c.a(paramParcel, 9, paramai.j, false);
    c.a(paramParcel, 10, paramai.k, paramInt, false);
    c.a(paramParcel, 11, paramai.l, paramInt, false);
    c.a(paramParcel, 12, paramai.m, false);
    c.a(paramParcel, 13, paramai.n, false);
    c.a(paramParcel, i);
  }

  public ai a(Parcel paramParcel)
  {
    int i = a.b(paramParcel);
    int j = 0;
    long l = 0L;
    Bundle localBundle1 = null;
    int k = 0;
    ArrayList localArrayList = null;
    boolean bool1 = false;
    int m = 0;
    boolean bool2 = false;
    String str1 = null;
    aw localaw = null;
    Location localLocation = null;
    String str2 = null;
    Bundle localBundle2 = null;
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
        l = a.i(paramParcel, n);
        break;
      case 3:
        localBundle1 = a.q(paramParcel, n);
        break;
      case 4:
        k = a.g(paramParcel, n);
        break;
      case 5:
        localArrayList = a.B(paramParcel, n);
        break;
      case 6:
        bool1 = a.c(paramParcel, n);
        break;
      case 7:
        m = a.g(paramParcel, n);
        break;
      case 8:
        bool2 = a.c(paramParcel, n);
        break;
      case 9:
        str1 = a.o(paramParcel, n);
        break;
      case 10:
        localaw = (aw)a.a(paramParcel, n, aw.a);
        break;
      case 11:
        localLocation = (Location)a.a(paramParcel, n, Location.CREATOR);
        break;
      case 12:
        str2 = a.o(paramParcel, n);
        break;
      case 13:
        localBundle2 = a.q(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new ai(j, l, localBundle1, k, localArrayList, bool1, m, bool2, str1, localaw, localLocation, str2, localBundle2);
  }

  public ai[] a(int paramInt)
  {
    return new ai[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.p
 * JD-Core Version:    0.6.0
 */