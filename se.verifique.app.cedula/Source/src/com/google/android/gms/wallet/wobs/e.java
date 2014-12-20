package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.internal.ln;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

public class e
  implements Parcelable.Creator
{
  static void a(CommonWalletObject paramCommonWalletObject, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramCommonWalletObject.b());
    c.a(paramParcel, 2, paramCommonWalletObject.a, false);
    c.a(paramParcel, 3, paramCommonWalletObject.b, false);
    c.a(paramParcel, 4, paramCommonWalletObject.c, false);
    c.a(paramParcel, 5, paramCommonWalletObject.d, false);
    c.a(paramParcel, 6, paramCommonWalletObject.e, false);
    c.a(paramParcel, 7, paramCommonWalletObject.f, false);
    c.a(paramParcel, 8, paramCommonWalletObject.g, false);
    c.a(paramParcel, 9, paramCommonWalletObject.h, false);
    c.a(paramParcel, 10, paramCommonWalletObject.i);
    c.b(paramParcel, 11, paramCommonWalletObject.j, false);
    c.a(paramParcel, 12, paramCommonWalletObject.k, paramInt, false);
    c.b(paramParcel, 13, paramCommonWalletObject.l, false);
    c.a(paramParcel, 14, paramCommonWalletObject.m, false);
    c.a(paramParcel, 15, paramCommonWalletObject.n, false);
    c.a(paramParcel, 17, paramCommonWalletObject.p);
    c.b(paramParcel, 16, paramCommonWalletObject.o, false);
    c.b(paramParcel, 19, paramCommonWalletObject.r, false);
    c.b(paramParcel, 18, paramCommonWalletObject.q, false);
    c.b(paramParcel, 20, paramCommonWalletObject.s, false);
    c.a(paramParcel, i);
  }

  public CommonWalletObject a(Parcel paramParcel)
  {
    int i = a.b(paramParcel);
    int j = 0;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    String str6 = null;
    String str7 = null;
    String str8 = null;
    int k = 0;
    ArrayList localArrayList1 = ln.a();
    l locall = null;
    ArrayList localArrayList2 = ln.a();
    String str9 = null;
    String str10 = null;
    ArrayList localArrayList3 = ln.a();
    boolean bool = false;
    ArrayList localArrayList4 = ln.a();
    ArrayList localArrayList5 = ln.a();
    ArrayList localArrayList6 = ln.a();
    while (paramParcel.dataPosition() < i)
    {
      int m = a.a(paramParcel);
      switch (a.a(m))
      {
      default:
        a.b(paramParcel, m);
        break;
      case 1:
        j = a.g(paramParcel, m);
        break;
      case 2:
        str1 = a.o(paramParcel, m);
        break;
      case 3:
        str2 = a.o(paramParcel, m);
        break;
      case 4:
        str3 = a.o(paramParcel, m);
        break;
      case 5:
        str4 = a.o(paramParcel, m);
        break;
      case 6:
        str5 = a.o(paramParcel, m);
        break;
      case 7:
        str6 = a.o(paramParcel, m);
        break;
      case 8:
        str7 = a.o(paramParcel, m);
        break;
      case 9:
        str8 = a.o(paramParcel, m);
        break;
      case 10:
        k = a.g(paramParcel, m);
        break;
      case 11:
        localArrayList1 = a.c(paramParcel, m, p.CREATOR);
        break;
      case 12:
        locall = (l)a.a(paramParcel, m, l.CREATOR);
        break;
      case 13:
        localArrayList2 = a.c(paramParcel, m, LatLng.a);
        break;
      case 14:
        str9 = a.o(paramParcel, m);
        break;
      case 15:
        str10 = a.o(paramParcel, m);
        break;
      case 17:
        bool = a.c(paramParcel, m);
        break;
      case 16:
        localArrayList3 = a.c(paramParcel, m, d.CREATOR);
        break;
      case 19:
        localArrayList5 = a.c(paramParcel, m, j.CREATOR);
        break;
      case 18:
        localArrayList4 = a.c(paramParcel, m, n.CREATOR);
        break;
      case 20:
        localArrayList6 = a.c(paramParcel, m, n.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new CommonWalletObject(j, str1, str2, str3, str4, str5, str6, str7, str8, k, localArrayList1, locall, localArrayList2, str9, str10, localArrayList3, bool, localArrayList4, localArrayList5, localArrayList6);
  }

  public CommonWalletObject[] a(int paramInt)
  {
    return new CommonWalletObject[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.wobs.e
 * JD-Core Version:    0.6.0
 */