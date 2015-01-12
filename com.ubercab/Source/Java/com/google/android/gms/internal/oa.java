package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class oa
  implements Parcelable.Creator<nz>
{
  static void a(nz paramnz, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    Set localSet = paramnz.amc;
    if (localSet.contains(Integer.valueOf(1)))
      b.c(paramParcel, 1, paramnz.BR);
    if (localSet.contains(Integer.valueOf(2)))
      b.a(paramParcel, 2, paramnz.ana, true);
    if (localSet.contains(Integer.valueOf(3)))
      b.a(paramParcel, 3, paramnz.anb, paramInt, true);
    if (localSet.contains(Integer.valueOf(4)))
      b.a(paramParcel, 4, paramnz.anc, true);
    if (localSet.contains(Integer.valueOf(5)))
      b.a(paramParcel, 5, paramnz.and, true);
    if (localSet.contains(Integer.valueOf(6)))
      b.c(paramParcel, 6, paramnz.ane);
    if (localSet.contains(Integer.valueOf(7)))
      b.a(paramParcel, 7, paramnz.anf, paramInt, true);
    if (localSet.contains(Integer.valueOf(8)))
      b.a(paramParcel, 8, paramnz.ang, true);
    if (localSet.contains(Integer.valueOf(9)))
      b.a(paramParcel, 9, paramnz.NH, true);
    if (localSet.contains(Integer.valueOf(12)))
      b.c(paramParcel, 12, paramnz.om);
    if (localSet.contains(Integer.valueOf(14)))
      b.a(paramParcel, 14, paramnz.BL, true);
    if (localSet.contains(Integer.valueOf(15)))
      b.a(paramParcel, 15, paramnz.anh, paramInt, true);
    if (localSet.contains(Integer.valueOf(16)))
      b.a(paramParcel, 16, paramnz.ani);
    if (localSet.contains(Integer.valueOf(19)))
      b.a(paramParcel, 19, paramnz.anj, paramInt, true);
    if (localSet.contains(Integer.valueOf(18)))
      b.a(paramParcel, 18, paramnz.Fc, true);
    if (localSet.contains(Integer.valueOf(21)))
      b.c(paramParcel, 21, paramnz.anl);
    if (localSet.contains(Integer.valueOf(20)))
      b.a(paramParcel, 20, paramnz.ank, true);
    if (localSet.contains(Integer.valueOf(23)))
      b.c(paramParcel, 23, paramnz.ann, true);
    if (localSet.contains(Integer.valueOf(22)))
      b.c(paramParcel, 22, paramnz.anm, true);
    if (localSet.contains(Integer.valueOf(25)))
      b.c(paramParcel, 25, paramnz.anp);
    if (localSet.contains(Integer.valueOf(24)))
      b.c(paramParcel, 24, paramnz.ano);
    if (localSet.contains(Integer.valueOf(27)))
      b.a(paramParcel, 27, paramnz.uR, true);
    if (localSet.contains(Integer.valueOf(26)))
      b.a(paramParcel, 26, paramnz.anq, true);
    if (localSet.contains(Integer.valueOf(29)))
      b.a(paramParcel, 29, paramnz.ans);
    if (localSet.contains(Integer.valueOf(28)))
      b.c(paramParcel, 28, paramnz.anr, true);
    b.H(paramParcel, i);
  }

  public nz dd(Parcel paramParcel)
  {
    int i = a.C(paramParcel);
    HashSet localHashSet = new HashSet();
    int j = 0;
    String str1 = null;
    Object localObject1 = null;
    String str2 = null;
    String str3 = null;
    int k = 0;
    Object localObject2 = null;
    String str4 = null;
    String str5 = null;
    int m = 0;
    String str6 = null;
    Object localObject3 = null;
    boolean bool1 = false;
    String str7 = null;
    Object localObject4 = null;
    String str8 = null;
    int n = 0;
    ArrayList localArrayList1 = null;
    ArrayList localArrayList2 = null;
    int i1 = 0;
    int i2 = 0;
    String str9 = null;
    String str10 = null;
    ArrayList localArrayList3 = null;
    boolean bool2 = false;
    while (paramParcel.dataPosition() < i)
    {
      int i3 = a.B(paramParcel);
      switch (a.aD(i3))
      {
      case 10:
      case 11:
      case 13:
      case 17:
      default:
        a.b(paramParcel, i3);
        break;
      case 1:
        j = a.g(paramParcel, i3);
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2:
        str1 = a.o(paramParcel, i3);
        localHashSet.add(Integer.valueOf(2));
        break;
      case 3:
        nz.a locala = (nz.a)a.a(paramParcel, i3, nz.a.CREATOR);
        localHashSet.add(Integer.valueOf(3));
        localObject1 = locala;
        break;
      case 4:
        str2 = a.o(paramParcel, i3);
        localHashSet.add(Integer.valueOf(4));
        break;
      case 5:
        str3 = a.o(paramParcel, i3);
        localHashSet.add(Integer.valueOf(5));
        break;
      case 6:
        k = a.g(paramParcel, i3);
        localHashSet.add(Integer.valueOf(6));
        break;
      case 7:
        nz.b localb = (nz.b)a.a(paramParcel, i3, nz.b.CREATOR);
        localHashSet.add(Integer.valueOf(7));
        localObject2 = localb;
        break;
      case 8:
        str4 = a.o(paramParcel, i3);
        localHashSet.add(Integer.valueOf(8));
        break;
      case 9:
        str5 = a.o(paramParcel, i3);
        localHashSet.add(Integer.valueOf(9));
        break;
      case 12:
        m = a.g(paramParcel, i3);
        localHashSet.add(Integer.valueOf(12));
        break;
      case 14:
        str6 = a.o(paramParcel, i3);
        localHashSet.add(Integer.valueOf(14));
        break;
      case 15:
        nz.c localc = (nz.c)a.a(paramParcel, i3, nz.c.CREATOR);
        localHashSet.add(Integer.valueOf(15));
        localObject3 = localc;
        break;
      case 16:
        bool1 = a.c(paramParcel, i3);
        localHashSet.add(Integer.valueOf(16));
        break;
      case 19:
        nz.d locald = (nz.d)a.a(paramParcel, i3, nz.d.CREATOR);
        localHashSet.add(Integer.valueOf(19));
        localObject4 = locald;
        break;
      case 18:
        str7 = a.o(paramParcel, i3);
        localHashSet.add(Integer.valueOf(18));
        break;
      case 21:
        n = a.g(paramParcel, i3);
        localHashSet.add(Integer.valueOf(21));
        break;
      case 20:
        str8 = a.o(paramParcel, i3);
        localHashSet.add(Integer.valueOf(20));
        break;
      case 23:
        localArrayList2 = a.c(paramParcel, i3, nz.g.CREATOR);
        localHashSet.add(Integer.valueOf(23));
        break;
      case 22:
        localArrayList1 = a.c(paramParcel, i3, nz.f.CREATOR);
        localHashSet.add(Integer.valueOf(22));
        break;
      case 25:
        i2 = a.g(paramParcel, i3);
        localHashSet.add(Integer.valueOf(25));
        break;
      case 24:
        i1 = a.g(paramParcel, i3);
        localHashSet.add(Integer.valueOf(24));
        break;
      case 27:
        str10 = a.o(paramParcel, i3);
        localHashSet.add(Integer.valueOf(27));
        break;
      case 26:
        str9 = a.o(paramParcel, i3);
        localHashSet.add(Integer.valueOf(26));
        break;
      case 29:
        bool2 = a.c(paramParcel, i3);
        localHashSet.add(Integer.valueOf(29));
        break;
      case 28:
        localArrayList3 = a.c(paramParcel, i3, nz.h.CREATOR);
        localHashSet.add(Integer.valueOf(28));
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    return new nz(localHashSet, j, str1, localObject1, str2, str3, k, localObject2, str4, str5, m, str6, localObject3, bool1, str7, localObject4, str8, n, localArrayList1, localArrayList2, i1, i2, str9, str10, localArrayList3, bool2);
  }

  public nz[] eV(int paramInt)
  {
    return new nz[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.oa
 * JD-Core Version:    0.6.2
 */