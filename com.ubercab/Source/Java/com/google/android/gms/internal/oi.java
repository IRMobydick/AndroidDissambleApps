package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.HashSet;
import java.util.Set;

public class oi
  implements Parcelable.Creator<nz.g>
{
  static void a(nz.g paramg, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    Set localSet = paramg.amc;
    if (localSet.contains(Integer.valueOf(1)))
      b.c(paramParcel, 1, paramg.BR);
    if (localSet.contains(Integer.valueOf(2)))
      b.a(paramParcel, 2, paramg.anG);
    if (localSet.contains(Integer.valueOf(3)))
      b.a(paramParcel, 3, paramg.mValue, true);
    b.H(paramParcel, i);
  }

  public nz.g dl(Parcel paramParcel)
  {
    boolean bool = false;
    int i = a.C(paramParcel);
    HashSet localHashSet = new HashSet();
    String str = null;
    int j = 0;
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
        bool = a.c(paramParcel, k);
        localHashSet.add(Integer.valueOf(2));
        break;
      case 3:
        str = a.o(paramParcel, k);
        localHashSet.add(Integer.valueOf(3));
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    return new nz.g(localHashSet, j, bool, str);
  }

  public nz.g[] fd(int paramInt)
  {
    return new nz.g[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.oi
 * JD-Core Version:    0.6.2
 */