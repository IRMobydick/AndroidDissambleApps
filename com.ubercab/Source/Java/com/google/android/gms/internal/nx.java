package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.HashSet;
import java.util.Set;

public class nx
  implements Parcelable.Creator<nw>
{
  static void a(nw paramnw, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    Set localSet = paramnw.amc;
    if (localSet.contains(Integer.valueOf(1)))
      b.c(paramParcel, 1, paramnw.BR);
    if (localSet.contains(Integer.valueOf(2)))
      b.a(paramParcel, 2, paramnw.BL, true);
    if (localSet.contains(Integer.valueOf(4)))
      b.a(paramParcel, 4, paramnw.amX, paramInt, true);
    if (localSet.contains(Integer.valueOf(5)))
      b.a(paramParcel, 5, paramnw.amP, true);
    if (localSet.contains(Integer.valueOf(6)))
      b.a(paramParcel, 6, paramnw.amY, paramInt, true);
    if (localSet.contains(Integer.valueOf(7)))
      b.a(paramParcel, 7, paramnw.uO, true);
    b.H(paramParcel, i);
  }

  public nw dc(Parcel paramParcel)
  {
    String str1 = null;
    int i = a.C(paramParcel);
    HashSet localHashSet = new HashSet();
    int j = 0;
    Object localObject1 = null;
    String str2 = null;
    Object localObject2 = null;
    String str3 = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.B(paramParcel);
      switch (a.aD(k))
      {
      case 3:
      default:
        a.b(paramParcel, k);
        break;
      case 1:
        j = a.g(paramParcel, k);
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2:
        str3 = a.o(paramParcel, k);
        localHashSet.add(Integer.valueOf(2));
        break;
      case 4:
        nu localnu2 = (nu)a.a(paramParcel, k, nu.CREATOR);
        localHashSet.add(Integer.valueOf(4));
        localObject2 = localnu2;
        break;
      case 5:
        str2 = a.o(paramParcel, k);
        localHashSet.add(Integer.valueOf(5));
        break;
      case 6:
        nu localnu1 = (nu)a.a(paramParcel, k, nu.CREATOR);
        localHashSet.add(Integer.valueOf(6));
        localObject1 = localnu1;
        break;
      case 7:
        str1 = a.o(paramParcel, k);
        localHashSet.add(Integer.valueOf(7));
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    return new nw(localHashSet, j, str3, localObject2, str2, localObject1, str1);
  }

  public nw[] eU(int paramInt)
  {
    return new nw[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.nx
 * JD-Core Version:    0.6.2
 */