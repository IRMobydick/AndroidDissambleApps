package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.HashSet;
import java.util.Set;

public class oc
  implements Parcelable.Creator<nz.b>
{
  static void a(nz.b paramb, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    Set localSet = paramb.amc;
    if (localSet.contains(Integer.valueOf(1)))
      b.c(paramParcel, 1, paramb.BR);
    if (localSet.contains(Integer.valueOf(2)))
      b.a(paramParcel, 2, paramb.anv, paramInt, true);
    if (localSet.contains(Integer.valueOf(3)))
      b.a(paramParcel, 3, paramb.anw, paramInt, true);
    if (localSet.contains(Integer.valueOf(4)))
      b.c(paramParcel, 4, paramb.anx);
    b.H(paramParcel, i);
  }

  public nz.b df(Parcel paramParcel)
  {
    Object localObject1 = null;
    int i = 0;
    int j = a.C(paramParcel);
    HashSet localHashSet = new HashSet();
    Object localObject2 = null;
    int k = 0;
    while (paramParcel.dataPosition() < j)
    {
      int m = a.B(paramParcel);
      switch (a.aD(m))
      {
      default:
        a.b(paramParcel, m);
        break;
      case 1:
        k = a.g(paramParcel, m);
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2:
        nz.b.a locala = (nz.b.a)a.a(paramParcel, m, nz.b.a.CREATOR);
        localHashSet.add(Integer.valueOf(2));
        localObject2 = locala;
        break;
      case 3:
        nz.b.b localb = (nz.b.b)a.a(paramParcel, m, nz.b.b.CREATOR);
        localHashSet.add(Integer.valueOf(3));
        localObject1 = localb;
        break;
      case 4:
        i = a.g(paramParcel, m);
        localHashSet.add(Integer.valueOf(4));
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    return new nz.b(localHashSet, k, localObject2, localObject1, i);
  }

  public nz.b[] eX(int paramInt)
  {
    return new nz.b[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.oc
 * JD-Core Version:    0.6.2
 */