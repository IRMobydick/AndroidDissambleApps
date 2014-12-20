package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.ArrayList;

public class fo
  implements Parcelable.Creator
{
  static void a(du paramdu, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramdu.b);
    c.a(paramParcel, 2, paramdu.c, false);
    c.a(paramParcel, 3, paramdu.d, false);
    c.a(paramParcel, 4, paramdu.e, false);
    c.a(paramParcel, 5, paramdu.f);
    c.a(paramParcel, 6, paramdu.g, false);
    c.a(paramParcel, 7, paramdu.h);
    c.a(paramParcel, 8, paramdu.i);
    c.a(paramParcel, 9, paramdu.j);
    c.a(paramParcel, 10, paramdu.k, false);
    c.a(paramParcel, 11, paramdu.l);
    c.a(paramParcel, 12, paramdu.m);
    c.a(paramParcel, 13, paramdu.n, false);
    c.a(paramParcel, 14, paramdu.o);
    c.a(paramParcel, 15, paramdu.p, false);
    c.a(paramParcel, 19, paramdu.r, false);
    c.a(paramParcel, 18, paramdu.q);
    c.a(paramParcel, 21, paramdu.s, false);
    c.a(paramParcel, i);
  }

  public du a(Parcel paramParcel)
  {
    int i = a.b(paramParcel);
    int j = 0;
    String str1 = null;
    String str2 = null;
    ArrayList localArrayList1 = null;
    int k = 0;
    ArrayList localArrayList2 = null;
    long l1 = 0L;
    boolean bool1 = false;
    long l2 = 0L;
    ArrayList localArrayList3 = null;
    long l3 = 0L;
    int m = 0;
    String str3 = null;
    long l4 = 0L;
    String str4 = null;
    boolean bool2 = false;
    String str5 = null;
    String str6 = null;
    while (paramParcel.dataPosition() < i)
    {
      int n = a.a(paramParcel);
      switch (a.a(n))
      {
      case 16:
      case 17:
      case 20:
      default:
        a.b(paramParcel, n);
        break;
      case 1:
        j = a.g(paramParcel, n);
        break;
      case 2:
        str1 = a.o(paramParcel, n);
        break;
      case 3:
        str2 = a.o(paramParcel, n);
        break;
      case 4:
        localArrayList1 = a.B(paramParcel, n);
        break;
      case 5:
        k = a.g(paramParcel, n);
        break;
      case 6:
        localArrayList2 = a.B(paramParcel, n);
        break;
      case 7:
        l1 = a.i(paramParcel, n);
        break;
      case 8:
        bool1 = a.c(paramParcel, n);
        break;
      case 9:
        l2 = a.i(paramParcel, n);
        break;
      case 10:
        localArrayList3 = a.B(paramParcel, n);
        break;
      case 11:
        l3 = a.i(paramParcel, n);
        break;
      case 12:
        m = a.g(paramParcel, n);
        break;
      case 13:
        str3 = a.o(paramParcel, n);
        break;
      case 14:
        l4 = a.i(paramParcel, n);
        break;
      case 15:
        str4 = a.o(paramParcel, n);
        break;
      case 19:
        str5 = a.o(paramParcel, n);
        break;
      case 18:
        bool2 = a.c(paramParcel, n);
        break;
      case 21:
        str6 = a.o(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new du(j, str1, str2, localArrayList1, k, localArrayList2, l1, bool1, l2, localArrayList3, l3, m, str3, l4, str4, bool2, str5, str6);
  }

  public du[] a(int paramInt)
  {
    return new du[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fo
 * JD-Core Version:    0.6.0
 */