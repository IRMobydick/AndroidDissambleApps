package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class h
  implements Parcelable.Creator<InstrumentInfo>
{
  static void a(InstrumentInfo paramInstrumentInfo, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.c(paramParcel, 1, paramInstrumentInfo.getVersionCode());
    b.a(paramParcel, 2, paramInstrumentInfo.getInstrumentType(), false);
    b.a(paramParcel, 3, paramInstrumentInfo.getInstrumentDetails(), false);
    b.H(paramParcel, i);
  }

  public InstrumentInfo dt(Parcel paramParcel)
  {
    String str1 = null;
    int i = a.C(paramParcel);
    int j = 0;
    String str2 = null;
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
        break;
      case 2:
        str2 = a.o(paramParcel, k);
        break;
      case 3:
        str1 = a.o(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    return new InstrumentInfo(j, str2, str1);
  }

  public InstrumentInfo[] fu(int paramInt)
  {
    return new InstrumentInfo[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.h
 * JD-Core Version:    0.6.2
 */