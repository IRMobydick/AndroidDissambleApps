package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

public class mb
  implements Parcelable.Creator<ma>
{
  static void a(ma paramma, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.a(paramParcel, 1, paramma.UI, paramInt, false);
    b.c(paramParcel, 1000, paramma.getVersionCode());
    b.a(paramParcel, 2, paramma.afi);
    b.a(paramParcel, 3, paramma.afj);
    b.a(paramParcel, 4, paramma.afk);
    b.c(paramParcel, 5, paramma.afl, false);
    b.a(paramParcel, 6, paramma.mTag, false);
    b.H(paramParcel, i);
  }

  public ma cv(Parcel paramParcel)
  {
    String str = null;
    boolean bool1 = true;
    boolean bool2 = false;
    int i = a.C(paramParcel);
    Object localObject = ma.afh;
    boolean bool3 = bool1;
    LocationRequest localLocationRequest = null;
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
        localLocationRequest = (LocationRequest)a.a(paramParcel, k, LocationRequest.CREATOR);
        break;
      case 1000:
        j = a.g(paramParcel, k);
        break;
      case 2:
        bool2 = a.c(paramParcel, k);
        break;
      case 3:
        bool3 = a.c(paramParcel, k);
        break;
      case 4:
        bool1 = a.c(paramParcel, k);
        break;
      case 5:
        localObject = a.c(paramParcel, k, ls.CREATOR);
        break;
      case 6:
        str = a.o(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    return new ma(j, localLocationRequest, bool2, bool3, bool1, (List)localObject, str);
  }

  public ma[] ej(int paramInt)
  {
    return new ma[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.mb
 * JD-Core Version:    0.6.2
 */