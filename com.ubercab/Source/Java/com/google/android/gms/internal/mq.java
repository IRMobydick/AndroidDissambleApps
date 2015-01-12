package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class mq
  implements Parcelable.Creator<mp>
{
  static void a(mp parammp, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.a(paramParcel, 1, parammp.uO, false);
    b.c(paramParcel, 1000, parammp.BR);
    b.H(paramParcel, i);
  }

  public mp cC(Parcel paramParcel)
  {
    int i = a.C(paramParcel);
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
        str = a.o(paramParcel, k);
        break;
      case 1000:
        j = a.g(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    return new mp(j, str);
  }

  public mp[] es(int paramInt)
  {
    return new mp[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.mq
 * JD-Core Version:    0.6.2
 */