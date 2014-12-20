package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.HashSet;
import java.util.Set;

public class ni
  implements Parcelable.Creator
{
  static void a(ks.f paramf, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    Set localSet = paramf.e();
    if (localSet.contains(Integer.valueOf(1)))
      c.a(paramParcel, 1, paramf.f());
    if (localSet.contains(Integer.valueOf(2)))
      c.a(paramParcel, 2, paramf.g(), true);
    if (localSet.contains(Integer.valueOf(3)))
      c.a(paramParcel, 3, paramf.h(), true);
    if (localSet.contains(Integer.valueOf(4)))
      c.a(paramParcel, 4, paramf.i(), true);
    if (localSet.contains(Integer.valueOf(5)))
      c.a(paramParcel, 5, paramf.j(), true);
    if (localSet.contains(Integer.valueOf(6)))
      c.a(paramParcel, 6, paramf.k(), true);
    if (localSet.contains(Integer.valueOf(7)))
      c.a(paramParcel, 7, paramf.l());
    if (localSet.contains(Integer.valueOf(8)))
      c.a(paramParcel, 8, paramf.m(), true);
    if (localSet.contains(Integer.valueOf(9)))
      c.a(paramParcel, 9, paramf.n(), true);
    if (localSet.contains(Integer.valueOf(10)))
      c.a(paramParcel, 10, paramf.o());
    c.a(paramParcel, i);
  }

  public ks.f a(Parcel paramParcel)
  {
    int i = 0;
    String str1 = null;
    int j = a.b(paramParcel);
    HashSet localHashSet = new HashSet();
    String str2 = null;
    boolean bool = false;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    String str6 = null;
    String str7 = null;
    int k = 0;
    while (paramParcel.dataPosition() < j)
    {
      int m = a.a(paramParcel);
      switch (a.a(m))
      {
      default:
        a.b(paramParcel, m);
        break;
      case 1:
        k = a.g(paramParcel, m);
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2:
        str7 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(2));
        break;
      case 3:
        str6 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(3));
        break;
      case 4:
        str5 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(4));
        break;
      case 5:
        str4 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(5));
        break;
      case 6:
        str3 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(6));
        break;
      case 7:
        bool = a.c(paramParcel, m);
        localHashSet.add(Integer.valueOf(7));
        break;
      case 8:
        str2 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(8));
        break;
      case 9:
        str1 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(9));
        break;
      case 10:
        i = a.g(paramParcel, m);
        localHashSet.add(Integer.valueOf(10));
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new b("Overread allowed size end=" + j, paramParcel);
    return new ks.f(localHashSet, k, str7, str6, str5, str4, str3, bool, str2, str1, i);
  }

  public ks.f[] a(int paramInt)
  {
    return new ks.f[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ni
 * JD-Core Version:    0.6.0
 */