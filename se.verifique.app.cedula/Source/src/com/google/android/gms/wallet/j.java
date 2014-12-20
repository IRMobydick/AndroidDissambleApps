package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.internal.ln;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.wobs.d;
import com.google.android.gms.wallet.wobs.f;
import com.google.android.gms.wallet.wobs.l;
import com.google.android.gms.wallet.wobs.n;
import com.google.android.gms.wallet.wobs.p;
import java.util.ArrayList;

public class j
  implements Parcelable.Creator
{
  static void a(LoyaltyWalletObject paramLoyaltyWalletObject, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramLoyaltyWalletObject.a());
    c.a(paramParcel, 2, paramLoyaltyWalletObject.a, false);
    c.a(paramParcel, 3, paramLoyaltyWalletObject.b, false);
    c.a(paramParcel, 4, paramLoyaltyWalletObject.c, false);
    c.a(paramParcel, 5, paramLoyaltyWalletObject.d, false);
    c.a(paramParcel, 6, paramLoyaltyWalletObject.e, false);
    c.a(paramParcel, 7, paramLoyaltyWalletObject.f, false);
    c.a(paramParcel, 8, paramLoyaltyWalletObject.g, false);
    c.a(paramParcel, 9, paramLoyaltyWalletObject.h, false);
    c.a(paramParcel, 10, paramLoyaltyWalletObject.i, false);
    c.a(paramParcel, 11, paramLoyaltyWalletObject.j, false);
    c.a(paramParcel, 12, paramLoyaltyWalletObject.k);
    c.b(paramParcel, 13, paramLoyaltyWalletObject.l, false);
    c.a(paramParcel, 14, paramLoyaltyWalletObject.m, paramInt, false);
    c.b(paramParcel, 15, paramLoyaltyWalletObject.n, false);
    c.a(paramParcel, 17, paramLoyaltyWalletObject.p, false);
    c.a(paramParcel, 16, paramLoyaltyWalletObject.o, false);
    c.a(paramParcel, 19, paramLoyaltyWalletObject.r);
    c.b(paramParcel, 18, paramLoyaltyWalletObject.q, false);
    c.b(paramParcel, 21, paramLoyaltyWalletObject.t, false);
    c.b(paramParcel, 20, paramLoyaltyWalletObject.s, false);
    c.a(paramParcel, 23, paramLoyaltyWalletObject.v, paramInt, false);
    c.b(paramParcel, 22, paramLoyaltyWalletObject.u, false);
    c.a(paramParcel, i);
  }

  public LoyaltyWalletObject a(Parcel paramParcel)
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
    String str9 = null;
    String str10 = null;
    int k = 0;
    ArrayList localArrayList1 = ln.a();
    l locall = null;
    ArrayList localArrayList2 = ln.a();
    String str11 = null;
    String str12 = null;
    ArrayList localArrayList3 = ln.a();
    boolean bool = false;
    ArrayList localArrayList4 = ln.a();
    ArrayList localArrayList5 = ln.a();
    ArrayList localArrayList6 = ln.a();
    f localf = null;
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
        str9 = a.o(paramParcel, m);
        break;
      case 11:
        str10 = a.o(paramParcel, m);
        break;
      case 12:
        k = a.g(paramParcel, m);
        break;
      case 13:
        localArrayList1 = a.c(paramParcel, m, p.CREATOR);
        break;
      case 14:
        locall = (l)a.a(paramParcel, m, l.CREATOR);
        break;
      case 15:
        localArrayList2 = a.c(paramParcel, m, LatLng.a);
        break;
      case 17:
        str12 = a.o(paramParcel, m);
        break;
      case 16:
        str11 = a.o(paramParcel, m);
        break;
      case 19:
        bool = a.c(paramParcel, m);
        break;
      case 18:
        localArrayList3 = a.c(paramParcel, m, d.CREATOR);
        break;
      case 21:
        localArrayList5 = a.c(paramParcel, m, com.google.android.gms.wallet.wobs.j.CREATOR);
        break;
      case 20:
        localArrayList4 = a.c(paramParcel, m, n.CREATOR);
        break;
      case 23:
        localf = (f)a.a(paramParcel, m, f.CREATOR);
        break;
      case 22:
        localArrayList6 = a.c(paramParcel, m, n.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new LoyaltyWalletObject(j, str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, k, localArrayList1, locall, localArrayList2, str11, str12, localArrayList3, bool, localArrayList4, localArrayList5, localArrayList6, localf);
  }

  public LoyaltyWalletObject[] a(int paramInt)
  {
    return new LoyaltyWalletObject[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.j
 * JD-Core Version:    0.6.0
 */