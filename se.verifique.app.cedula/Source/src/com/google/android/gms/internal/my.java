package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class my
  implements Parcelable.Creator
{
  static void a(kn paramkn, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    Set localSet = paramkn.e();
    if (localSet.contains(Integer.valueOf(1)))
      c.a(paramParcel, 1, paramkn.f());
    if (localSet.contains(Integer.valueOf(2)))
      c.a(paramParcel, 2, paramkn.g(), paramInt, true);
    if (localSet.contains(Integer.valueOf(3)))
      c.a(paramParcel, 3, paramkn.h(), true);
    if (localSet.contains(Integer.valueOf(4)))
      c.a(paramParcel, 4, paramkn.i(), paramInt, true);
    if (localSet.contains(Integer.valueOf(5)))
      c.a(paramParcel, 5, paramkn.j(), true);
    if (localSet.contains(Integer.valueOf(6)))
      c.a(paramParcel, 6, paramkn.k(), true);
    if (localSet.contains(Integer.valueOf(7)))
      c.a(paramParcel, 7, paramkn.l(), true);
    if (localSet.contains(Integer.valueOf(8)))
      c.b(paramParcel, 8, paramkn.m(), true);
    if (localSet.contains(Integer.valueOf(9)))
      c.a(paramParcel, 9, paramkn.n());
    if (localSet.contains(Integer.valueOf(10)))
      c.b(paramParcel, 10, paramkn.o(), true);
    if (localSet.contains(Integer.valueOf(11)))
      c.a(paramParcel, 11, paramkn.p(), paramInt, true);
    if (localSet.contains(Integer.valueOf(12)))
      c.b(paramParcel, 12, paramkn.q(), true);
    if (localSet.contains(Integer.valueOf(13)))
      c.a(paramParcel, 13, paramkn.r(), true);
    if (localSet.contains(Integer.valueOf(14)))
      c.a(paramParcel, 14, paramkn.s(), true);
    if (localSet.contains(Integer.valueOf(15)))
      c.a(paramParcel, 15, paramkn.t(), paramInt, true);
    if (localSet.contains(Integer.valueOf(17)))
      c.a(paramParcel, 17, paramkn.v(), true);
    if (localSet.contains(Integer.valueOf(16)))
      c.a(paramParcel, 16, paramkn.u(), true);
    if (localSet.contains(Integer.valueOf(19)))
      c.b(paramParcel, 19, paramkn.x(), true);
    if (localSet.contains(Integer.valueOf(18)))
      c.a(paramParcel, 18, paramkn.w(), true);
    if (localSet.contains(Integer.valueOf(21)))
      c.a(paramParcel, 21, paramkn.z(), true);
    if (localSet.contains(Integer.valueOf(20)))
      c.a(paramParcel, 20, paramkn.y(), true);
    if (localSet.contains(Integer.valueOf(23)))
      c.a(paramParcel, 23, paramkn.B(), true);
    if (localSet.contains(Integer.valueOf(22)))
      c.a(paramParcel, 22, paramkn.A(), true);
    if (localSet.contains(Integer.valueOf(25)))
      c.a(paramParcel, 25, paramkn.D(), true);
    if (localSet.contains(Integer.valueOf(24)))
      c.a(paramParcel, 24, paramkn.C(), true);
    if (localSet.contains(Integer.valueOf(27)))
      c.a(paramParcel, 27, paramkn.F(), true);
    if (localSet.contains(Integer.valueOf(26)))
      c.a(paramParcel, 26, paramkn.E(), true);
    if (localSet.contains(Integer.valueOf(29)))
      c.a(paramParcel, 29, paramkn.H(), paramInt, true);
    if (localSet.contains(Integer.valueOf(28)))
      c.a(paramParcel, 28, paramkn.G(), true);
    if (localSet.contains(Integer.valueOf(31)))
      c.a(paramParcel, 31, paramkn.J(), true);
    if (localSet.contains(Integer.valueOf(30)))
      c.a(paramParcel, 30, paramkn.I(), true);
    if (localSet.contains(Integer.valueOf(34)))
      c.a(paramParcel, 34, paramkn.M(), paramInt, true);
    if (localSet.contains(Integer.valueOf(32)))
      c.a(paramParcel, 32, paramkn.K(), true);
    if (localSet.contains(Integer.valueOf(33)))
      c.a(paramParcel, 33, paramkn.L(), true);
    if (localSet.contains(Integer.valueOf(38)))
      c.a(paramParcel, 38, paramkn.P());
    if (localSet.contains(Integer.valueOf(39)))
      c.a(paramParcel, 39, paramkn.Q(), true);
    if (localSet.contains(Integer.valueOf(36)))
      c.a(paramParcel, 36, paramkn.N());
    if (localSet.contains(Integer.valueOf(37)))
      c.a(paramParcel, 37, paramkn.O(), paramInt, true);
    if (localSet.contains(Integer.valueOf(42)))
      c.a(paramParcel, 42, paramkn.T(), true);
    if (localSet.contains(Integer.valueOf(43)))
      c.a(paramParcel, 43, paramkn.U(), true);
    if (localSet.contains(Integer.valueOf(40)))
      c.a(paramParcel, 40, paramkn.R(), paramInt, true);
    if (localSet.contains(Integer.valueOf(41)))
      c.b(paramParcel, 41, paramkn.S(), true);
    if (localSet.contains(Integer.valueOf(46)))
      c.a(paramParcel, 46, paramkn.X(), paramInt, true);
    if (localSet.contains(Integer.valueOf(47)))
      c.a(paramParcel, 47, paramkn.Y(), true);
    if (localSet.contains(Integer.valueOf(44)))
      c.a(paramParcel, 44, paramkn.V(), true);
    if (localSet.contains(Integer.valueOf(45)))
      c.a(paramParcel, 45, paramkn.W(), true);
    if (localSet.contains(Integer.valueOf(51)))
      c.a(paramParcel, 51, paramkn.ac(), true);
    if (localSet.contains(Integer.valueOf(50)))
      c.a(paramParcel, 50, paramkn.ab(), paramInt, true);
    if (localSet.contains(Integer.valueOf(49)))
      c.a(paramParcel, 49, paramkn.aa(), true);
    if (localSet.contains(Integer.valueOf(48)))
      c.a(paramParcel, 48, paramkn.Z(), true);
    if (localSet.contains(Integer.valueOf(55)))
      c.a(paramParcel, 55, paramkn.ag(), true);
    if (localSet.contains(Integer.valueOf(54)))
      c.a(paramParcel, 54, paramkn.af(), true);
    if (localSet.contains(Integer.valueOf(53)))
      c.a(paramParcel, 53, paramkn.ae(), true);
    if (localSet.contains(Integer.valueOf(52)))
      c.a(paramParcel, 52, paramkn.ad(), true);
    if (localSet.contains(Integer.valueOf(56)))
      c.a(paramParcel, 56, paramkn.ah(), true);
    c.a(paramParcel, i);
  }

  public kn a(Parcel paramParcel)
  {
    int i = a.b(paramParcel);
    HashSet localHashSet = new HashSet();
    int j = 0;
    Object localObject1 = null;
    ArrayList localArrayList1 = null;
    Object localObject2 = null;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    ArrayList localArrayList2 = null;
    int k = 0;
    ArrayList localArrayList3 = null;
    Object localObject3 = null;
    ArrayList localArrayList4 = null;
    String str4 = null;
    String str5 = null;
    Object localObject4 = null;
    String str6 = null;
    String str7 = null;
    String str8 = null;
    ArrayList localArrayList5 = null;
    String str9 = null;
    String str10 = null;
    String str11 = null;
    String str12 = null;
    String str13 = null;
    String str14 = null;
    String str15 = null;
    String str16 = null;
    String str17 = null;
    Object localObject5 = null;
    String str18 = null;
    String str19 = null;
    String str20 = null;
    String str21 = null;
    Object localObject6 = null;
    double d1 = 0.0D;
    Object localObject7 = null;
    double d2 = 0.0D;
    String str22 = null;
    Object localObject8 = null;
    ArrayList localArrayList6 = null;
    String str23 = null;
    String str24 = null;
    String str25 = null;
    String str26 = null;
    Object localObject9 = null;
    String str27 = null;
    String str28 = null;
    String str29 = null;
    Object localObject10 = null;
    String str30 = null;
    String str31 = null;
    String str32 = null;
    String str33 = null;
    String str34 = null;
    String str35 = null;
    while (paramParcel.dataPosition() < i)
    {
      int m = a.a(paramParcel);
      switch (a.a(m))
      {
      case 35:
      default:
        a.b(paramParcel, m);
        break;
      case 1:
        j = a.g(paramParcel, m);
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2:
        kn localkn10 = (kn)a.a(paramParcel, m, kn.a);
        localHashSet.add(Integer.valueOf(2));
        localObject1 = localkn10;
        break;
      case 3:
        localArrayList1 = a.B(paramParcel, m);
        localHashSet.add(Integer.valueOf(3));
        break;
      case 4:
        kn localkn9 = (kn)a.a(paramParcel, m, kn.a);
        localHashSet.add(Integer.valueOf(4));
        localObject2 = localkn9;
        break;
      case 5:
        str1 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(5));
        break;
      case 6:
        str2 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(6));
        break;
      case 7:
        str3 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(7));
        break;
      case 8:
        localArrayList2 = a.c(paramParcel, m, kn.a);
        localHashSet.add(Integer.valueOf(8));
        break;
      case 9:
        k = a.g(paramParcel, m);
        localHashSet.add(Integer.valueOf(9));
        break;
      case 10:
        localArrayList3 = a.c(paramParcel, m, kn.a);
        localHashSet.add(Integer.valueOf(10));
        break;
      case 11:
        kn localkn8 = (kn)a.a(paramParcel, m, kn.a);
        localHashSet.add(Integer.valueOf(11));
        localObject3 = localkn8;
        break;
      case 12:
        localArrayList4 = a.c(paramParcel, m, kn.a);
        localHashSet.add(Integer.valueOf(12));
        break;
      case 13:
        str4 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(13));
        break;
      case 14:
        str5 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(14));
        break;
      case 15:
        kn localkn7 = (kn)a.a(paramParcel, m, kn.a);
        localHashSet.add(Integer.valueOf(15));
        localObject4 = localkn7;
        break;
      case 17:
        str7 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(17));
        break;
      case 16:
        str6 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(16));
        break;
      case 19:
        localArrayList5 = a.c(paramParcel, m, kn.a);
        localHashSet.add(Integer.valueOf(19));
        break;
      case 18:
        str8 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(18));
        break;
      case 21:
        str10 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(21));
        break;
      case 20:
        str9 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(20));
        break;
      case 23:
        str12 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(23));
        break;
      case 22:
        str11 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(22));
        break;
      case 25:
        str14 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(25));
        break;
      case 24:
        str13 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(24));
        break;
      case 27:
        str16 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(27));
        break;
      case 26:
        str15 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(26));
        break;
      case 29:
        kn localkn6 = (kn)a.a(paramParcel, m, kn.a);
        localHashSet.add(Integer.valueOf(29));
        localObject5 = localkn6;
        break;
      case 28:
        str17 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(28));
        break;
      case 31:
        str19 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(31));
        break;
      case 30:
        str18 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(30));
        break;
      case 34:
        kn localkn5 = (kn)a.a(paramParcel, m, kn.a);
        localHashSet.add(Integer.valueOf(34));
        localObject6 = localkn5;
        break;
      case 32:
        str20 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(32));
        break;
      case 33:
        str21 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(33));
        break;
      case 38:
        d2 = a.m(paramParcel, m);
        localHashSet.add(Integer.valueOf(38));
        break;
      case 39:
        str22 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(39));
        break;
      case 36:
        d1 = a.m(paramParcel, m);
        localHashSet.add(Integer.valueOf(36));
        break;
      case 37:
        kn localkn4 = (kn)a.a(paramParcel, m, kn.a);
        localHashSet.add(Integer.valueOf(37));
        localObject7 = localkn4;
        break;
      case 42:
        str23 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(42));
        break;
      case 43:
        str24 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(43));
        break;
      case 40:
        kn localkn3 = (kn)a.a(paramParcel, m, kn.a);
        localHashSet.add(Integer.valueOf(40));
        localObject8 = localkn3;
        break;
      case 41:
        localArrayList6 = a.c(paramParcel, m, kn.a);
        localHashSet.add(Integer.valueOf(41));
        break;
      case 46:
        kn localkn2 = (kn)a.a(paramParcel, m, kn.a);
        localHashSet.add(Integer.valueOf(46));
        localObject9 = localkn2;
        break;
      case 47:
        str27 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(47));
        break;
      case 44:
        str25 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(44));
        break;
      case 45:
        str26 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(45));
        break;
      case 51:
        str30 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(51));
        break;
      case 50:
        kn localkn1 = (kn)a.a(paramParcel, m, kn.a);
        localHashSet.add(Integer.valueOf(50));
        localObject10 = localkn1;
        break;
      case 49:
        str29 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(49));
        break;
      case 48:
        str28 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(48));
        break;
      case 55:
        str34 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(55));
        break;
      case 54:
        str33 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(54));
        break;
      case 53:
        str32 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(53));
        break;
      case 52:
        str31 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(52));
        break;
      case 56:
        str35 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(56));
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new kn(localHashSet, j, localObject1, localArrayList1, localObject2, str1, str2, str3, localArrayList2, k, localArrayList3, localObject3, localArrayList4, str4, str5, localObject4, str6, str7, str8, localArrayList5, str9, str10, str11, str12, str13, str14, str15, str16, str17, localObject5, str18, str19, str20, str21, localObject6, d1, localObject7, d2, str22, localObject8, localArrayList6, str23, str24, str25, str26, localObject9, str27, str28, str29, localObject10, str30, str31, str32, str33, str34, str35);
  }

  public kn[] a(int paramInt)
  {
    return new kn[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.my
 * JD-Core Version:    0.6.0
 */