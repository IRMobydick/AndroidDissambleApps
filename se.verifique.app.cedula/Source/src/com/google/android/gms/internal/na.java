package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class na
  implements Parcelable.Creator
{
  static void a(ks paramks, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    Set localSet = paramks.e();
    if (localSet.contains(Integer.valueOf(1)))
      c.a(paramParcel, 1, paramks.f());
    if (localSet.contains(Integer.valueOf(2)))
      c.a(paramParcel, 2, paramks.g(), true);
    if (localSet.contains(Integer.valueOf(3)))
      c.a(paramParcel, 3, paramks.h(), paramInt, true);
    if (localSet.contains(Integer.valueOf(4)))
      c.a(paramParcel, 4, paramks.i(), true);
    if (localSet.contains(Integer.valueOf(5)))
      c.a(paramParcel, 5, paramks.j(), true);
    if (localSet.contains(Integer.valueOf(6)))
      c.a(paramParcel, 6, paramks.k());
    if (localSet.contains(Integer.valueOf(7)))
      c.a(paramParcel, 7, paramks.l(), paramInt, true);
    if (localSet.contains(Integer.valueOf(8)))
      c.a(paramParcel, 8, paramks.m(), true);
    if (localSet.contains(Integer.valueOf(9)))
      c.a(paramParcel, 9, paramks.n(), true);
    if (localSet.contains(Integer.valueOf(12)))
      c.a(paramParcel, 12, paramks.o());
    if (localSet.contains(Integer.valueOf(14)))
      c.a(paramParcel, 14, paramks.p(), true);
    if (localSet.contains(Integer.valueOf(15)))
      c.a(paramParcel, 15, paramks.q(), paramInt, true);
    if (localSet.contains(Integer.valueOf(16)))
      c.a(paramParcel, 16, paramks.r());
    if (localSet.contains(Integer.valueOf(19)))
      c.a(paramParcel, 19, paramks.t(), paramInt, true);
    if (localSet.contains(Integer.valueOf(18)))
      c.a(paramParcel, 18, paramks.s(), true);
    if (localSet.contains(Integer.valueOf(21)))
      c.a(paramParcel, 21, paramks.v());
    if (localSet.contains(Integer.valueOf(20)))
      c.a(paramParcel, 20, paramks.u(), true);
    if (localSet.contains(Integer.valueOf(23)))
      c.b(paramParcel, 23, paramks.x(), true);
    if (localSet.contains(Integer.valueOf(22)))
      c.b(paramParcel, 22, paramks.w(), true);
    if (localSet.contains(Integer.valueOf(25)))
      c.a(paramParcel, 25, paramks.z());
    if (localSet.contains(Integer.valueOf(24)))
      c.a(paramParcel, 24, paramks.y());
    if (localSet.contains(Integer.valueOf(27)))
      c.a(paramParcel, 27, paramks.B(), true);
    if (localSet.contains(Integer.valueOf(26)))
      c.a(paramParcel, 26, paramks.A(), true);
    if (localSet.contains(Integer.valueOf(29)))
      c.a(paramParcel, 29, paramks.D());
    if (localSet.contains(Integer.valueOf(28)))
      c.b(paramParcel, 28, paramks.C(), true);
    c.a(paramParcel, i);
  }

  public ks a(Parcel paramParcel)
  {
    int i = a.b(paramParcel);
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
      int i3 = a.a(paramParcel);
      switch (a.a(i3))
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
        ks.a locala = (ks.a)a.a(paramParcel, i3, ks.a.a);
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
        ks.b localb = (ks.b)a.a(paramParcel, i3, ks.b.a);
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
        ks.c localc = (ks.c)a.a(paramParcel, i3, ks.c.a);
        localHashSet.add(Integer.valueOf(15));
        localObject3 = localc;
        break;
      case 16:
        bool1 = a.c(paramParcel, i3);
        localHashSet.add(Integer.valueOf(16));
        break;
      case 19:
        ks.d locald = (ks.d)a.a(paramParcel, i3, ks.d.a);
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
        localArrayList2 = a.c(paramParcel, i3, ks.g.a);
        localHashSet.add(Integer.valueOf(23));
        break;
      case 22:
        localArrayList1 = a.c(paramParcel, i3, ks.f.a);
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
        localArrayList3 = a.c(paramParcel, i3, ks.h.a);
        localHashSet.add(Integer.valueOf(28));
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new ks(localHashSet, j, str1, localObject1, str2, str3, k, localObject2, str4, str5, m, str6, localObject3, bool1, str7, localObject4, str8, n, localArrayList1, localArrayList2, i1, i2, str9, str10, localArrayList3, bool2);
  }

  public ks[] a(int paramInt)
  {
    return new ks[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.na
 * JD-Core Version:    0.6.0
 */