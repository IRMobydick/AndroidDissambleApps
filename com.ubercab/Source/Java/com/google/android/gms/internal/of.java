package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.HashSet;
import java.util.Set;

public class of
  implements Parcelable.Creator<nz.c>
{
  static void a(nz.c paramc, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    Set localSet = paramc.amc;
    if (localSet.contains(Integer.valueOf(1)))
      b.c(paramParcel, 1, paramc.BR);
    if (localSet.contains(Integer.valueOf(2)))
      b.a(paramParcel, 2, paramc.uR, true);
    b.H(paramParcel, i);
  }

  public nz.c di(Parcel paramParcel)
  {
    int i = a.C(paramParcel);
    HashSet localHashSet = new HashSet();
    int j = 0;
    String str = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.B(paramParcel);
      switch (a.aD(k))
      {
      default:
        a.b(paramParcel, k);
        break;
      case 1:
        j = a.g(paramParcel, k);
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2:
        str = a.o(paramParcel, k);
        localHashSet.add(Integer.valueOf(2));
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    return new nz.c(localHashSet, j, str);
  }

  public nz.c[] fa(int paramInt)
  {
    return new nz.c[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.of
 * JD-Core Version:    0.6.2
 */