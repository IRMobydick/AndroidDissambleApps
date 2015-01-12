package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class fl
  implements Parcelable.Creator<fk>
{
  static void a(fk paramfk, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.c(paramParcel, 1, paramfk.versionCode);
    b.a(paramParcel, 2, paramfk.rP, false);
    b.a(paramParcel, 3, paramfk.tG, false);
    b.b(paramParcel, 4, paramfk.qf, false);
    b.c(paramParcel, 5, paramfk.errorCode);
    b.b(paramParcel, 6, paramfk.qg, false);
    b.a(paramParcel, 7, paramfk.tH);
    b.a(paramParcel, 8, paramfk.tI);
    b.a(paramParcel, 9, paramfk.tJ);
    b.b(paramParcel, 10, paramfk.tK, false);
    b.a(paramParcel, 11, paramfk.qj);
    b.c(paramParcel, 12, paramfk.orientation);
    b.a(paramParcel, 13, paramfk.tL, false);
    b.a(paramParcel, 14, paramfk.tM);
    b.a(paramParcel, 15, paramfk.tN, false);
    b.a(paramParcel, 19, paramfk.tP, false);
    b.a(paramParcel, 18, paramfk.tO);
    b.a(paramParcel, 21, paramfk.tQ, false);
    b.a(paramParcel, 23, paramfk.tS);
    b.a(paramParcel, 22, paramfk.tR);
    b.a(paramParcel, 25, paramfk.tT);
    b.a(paramParcel, 24, paramfk.tF);
    b.H(paramParcel, i);
  }

  public fk i(Parcel paramParcel)
  {
    int i = a.C(paramParcel);
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
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    while (paramParcel.dataPosition() < i)
    {
      int n = a.B(paramParcel);
      switch (a.aD(n))
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
        localArrayList1 = a.C(paramParcel, n);
        break;
      case 5:
        k = a.g(paramParcel, n);
        break;
      case 6:
        localArrayList2 = a.C(paramParcel, n);
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
        localArrayList3 = a.C(paramParcel, n);
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
        break;
      case 23:
        bool4 = a.c(paramParcel, n);
        break;
      case 22:
        bool3 = a.c(paramParcel, n);
        break;
      case 25:
        bool6 = a.c(paramParcel, n);
        break;
      case 24:
        bool5 = a.c(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    return new fk(j, str1, str2, localArrayList1, k, localArrayList2, l1, bool1, l2, localArrayList3, l3, m, str3, l4, str4, bool2, str5, str6, bool3, bool4, bool5, bool6);
  }

  public fk[] q(int paramInt)
  {
    return new fk[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fl
 * JD-Core Version:    0.6.2
 */