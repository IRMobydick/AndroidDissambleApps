package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.HashSet;
import java.util.Set;

public class nk
  implements Parcelable.Creator
{
  static void a(ks.h paramh, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    Set localSet = paramh.e();
    if (localSet.contains(Integer.valueOf(1)))
      c.a(paramParcel, 1, paramh.f());
    if (localSet.contains(Integer.valueOf(3)))
      c.a(paramParcel, 3, paramh.h());
    if (localSet.contains(Integer.valueOf(4)))
      c.a(paramParcel, 4, paramh.j(), true);
    if (localSet.contains(Integer.valueOf(5)))
      c.a(paramParcel, 5, paramh.g(), true);
    if (localSet.contains(Integer.valueOf(6)))
      c.a(paramParcel, 6, paramh.i());
    c.a(paramParcel, i);
  }

  public ks.h a(Parcel paramParcel)
  {
    String str1 = null;
    int i = 0;
    int j = a.b(paramParcel);
    HashSet localHashSet = new HashSet();
    int k = 0;
    String str2 = null;
    int m = 0;
    while (paramParcel.dataPosition() < j)
    {
      int n = a.a(paramParcel);
      switch (a.a(n))
      {
      case 2:
      default:
        a.b(paramParcel, n);
        break;
      case 1:
        m = a.g(paramParcel, n);
        localHashSet.add(Integer.valueOf(1));
        break;
      case 3:
        i = a.g(paramParcel, n);
        localHashSet.add(Integer.valueOf(3));
        break;
      case 4:
        str1 = a.o(paramParcel, n);
        localHashSet.add(Integer.valueOf(4));
        break;
      case 5:
        str2 = a.o(paramParcel, n);
        localHashSet.add(Integer.valueOf(5));
        break;
      case 6:
        k = a.g(paramParcel, n);
        localHashSet.add(Integer.valueOf(6));
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new b("Overread allowed size end=" + j, paramParcel);
    return new ks.h(localHashSet, m, str2, k, str1, i);
  }

  public ks.h[] a(int paramInt)
  {
    return new ks.h[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.nk
 * JD-Core Version:    0.6.0
 */