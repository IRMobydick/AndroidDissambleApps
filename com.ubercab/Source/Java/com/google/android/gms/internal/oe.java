package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.HashSet;
import java.util.Set;

public class oe
  implements Parcelable.Creator<nz.b.b>
{
  static void a(nz.b.b paramb, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    Set localSet = paramb.amc;
    if (localSet.contains(Integer.valueOf(1)))
      b.c(paramParcel, 1, paramb.BR);
    if (localSet.contains(Integer.valueOf(2)))
      b.c(paramParcel, 2, paramb.lg);
    if (localSet.contains(Integer.valueOf(3)))
      b.a(paramParcel, 3, paramb.uR, true);
    if (localSet.contains(Integer.valueOf(4)))
      b.c(paramParcel, 4, paramb.lf);
    b.H(paramParcel, i);
  }

  public nz.b.b dh(Parcel paramParcel)
  {
    int i = 0;
    int j = a.C(paramParcel);
    HashSet localHashSet = new HashSet();
    String str = null;
    int k = 0;
    int m = 0;
    while (paramParcel.dataPosition() < j)
    {
      int n = a.B(paramParcel);
      switch (a.aD(n))
      {
      default:
        a.b(paramParcel, n);
        break;
      case 1:
        m = a.g(paramParcel, n);
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2:
        k = a.g(paramParcel, n);
        localHashSet.add(Integer.valueOf(2));
        break;
      case 3:
        str = a.o(paramParcel, n);
        localHashSet.add(Integer.valueOf(3));
        break;
      case 4:
        i = a.g(paramParcel, n);
        localHashSet.add(Integer.valueOf(4));
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    return new nz.b.b(localHashSet, m, k, str, i);
  }

  public nz.b.b[] eZ(int paramInt)
  {
    return new nz.b.b[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.oe
 * JD-Core Version:    0.6.2
 */