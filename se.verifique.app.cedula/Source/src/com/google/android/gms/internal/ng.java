package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.HashSet;
import java.util.Set;

public class ng
  implements Parcelable.Creator
{
  static void a(ks.d paramd, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    Set localSet = paramd.e();
    if (localSet.contains(Integer.valueOf(1)))
      c.a(paramParcel, 1, paramd.f());
    if (localSet.contains(Integer.valueOf(2)))
      c.a(paramParcel, 2, paramd.g(), true);
    if (localSet.contains(Integer.valueOf(3)))
      c.a(paramParcel, 3, paramd.h(), true);
    if (localSet.contains(Integer.valueOf(4)))
      c.a(paramParcel, 4, paramd.i(), true);
    if (localSet.contains(Integer.valueOf(5)))
      c.a(paramParcel, 5, paramd.j(), true);
    if (localSet.contains(Integer.valueOf(6)))
      c.a(paramParcel, 6, paramd.k(), true);
    if (localSet.contains(Integer.valueOf(7)))
      c.a(paramParcel, 7, paramd.l(), true);
    c.a(paramParcel, i);
  }

  public ks.d a(Parcel paramParcel)
  {
    String str1 = null;
    int i = a.b(paramParcel);
    HashSet localHashSet = new HashSet();
    int j = 0;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    String str6 = null;
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
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2:
        str6 = a.o(paramParcel, k);
        localHashSet.add(Integer.valueOf(2));
        break;
      case 3:
        str5 = a.o(paramParcel, k);
        localHashSet.add(Integer.valueOf(3));
        break;
      case 4:
        str4 = a.o(paramParcel, k);
        localHashSet.add(Integer.valueOf(4));
        break;
      case 5:
        str3 = a.o(paramParcel, k);
        localHashSet.add(Integer.valueOf(5));
        break;
      case 6:
        str2 = a.o(paramParcel, k);
        localHashSet.add(Integer.valueOf(6));
        break;
      case 7:
        str1 = a.o(paramParcel, k);
        localHashSet.add(Integer.valueOf(7));
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new ks.d(localHashSet, j, str6, str5, str4, str3, str2, str1);
  }

  public ks.d[] a(int paramInt)
  {
    return new ks.d[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ng
 * JD-Core Version:    0.6.0
 */