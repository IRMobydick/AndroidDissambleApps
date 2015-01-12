package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class mk
  implements Parcelable.Creator<mj>
{
  static void a(mj parammj, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.c(paramParcel, 1, parammj.afr, false);
    b.c(paramParcel, 1000, parammj.BR);
    b.a(paramParcel, 2, parammj.mi(), false);
    b.a(paramParcel, 3, parammj.mj());
    b.c(paramParcel, 4, parammj.afu, false);
    b.b(paramParcel, 6, parammj.afv, false);
    b.H(paramParcel, i);
  }

  public mj cz(Parcel paramParcel)
  {
    boolean bool = false;
    ArrayList localArrayList1 = null;
    int i = a.C(paramParcel);
    ArrayList localArrayList2 = null;
    String str = null;
    ArrayList localArrayList3 = null;
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
        localArrayList3 = a.c(paramParcel, k, mp.CREATOR);
        break;
      case 1000:
        j = a.g(paramParcel, k);
        break;
      case 2:
        str = a.o(paramParcel, k);
        break;
      case 3:
        bool = a.c(paramParcel, k);
        break;
      case 4:
        localArrayList2 = a.c(paramParcel, k, mt.CREATOR);
        break;
      case 6:
        localArrayList1 = a.C(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    return new mj(j, localArrayList3, str, bool, localArrayList2, localArrayList1);
  }

  public mj[] ep(int paramInt)
  {
    return new mj[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.mk
 * JD-Core Version:    0.6.2
 */