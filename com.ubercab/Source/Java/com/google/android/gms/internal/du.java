package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class du
  implements Parcelable.Creator<dv>
{
  static void a(dv paramdv, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.c(paramParcel, 1, paramdv.versionCode);
    b.a(paramParcel, 2, paramdv.ck(), false);
    b.a(paramParcel, 3, paramdv.cl(), false);
    b.a(paramParcel, 4, paramdv.cm(), false);
    b.a(paramParcel, 5, paramdv.cn(), false);
    b.H(paramParcel, i);
  }

  public dv g(Parcel paramParcel)
  {
    IBinder localIBinder1 = null;
    int i = a.C(paramParcel);
    int j = 0;
    IBinder localIBinder2 = null;
    IBinder localIBinder3 = null;
    IBinder localIBinder4 = null;
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
        localIBinder4 = a.p(paramParcel, k);
        break;
      case 3:
        localIBinder3 = a.p(paramParcel, k);
        break;
      case 4:
        localIBinder2 = a.p(paramParcel, k);
        break;
      case 5:
        localIBinder1 = a.p(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    return new dv(j, localIBinder4, localIBinder3, localIBinder2, localIBinder1);
  }

  public dv[] n(int paramInt)
  {
    return new dv[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.du
 * JD-Core Version:    0.6.2
 */