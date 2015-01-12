package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

public class ms
  implements Parcelable.Creator<mr>
{
  static void a(mr parammr, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.a(paramParcel, 1, parammr.getName(), false);
    b.c(paramParcel, 1000, parammr.BR);
    b.a(paramParcel, 2, parammr.ml(), paramInt, false);
    b.a(paramParcel, 3, parammr.getAddress(), false);
    b.c(paramParcel, 4, parammr.mm(), false);
    b.a(paramParcel, 5, parammr.getPhoneNumber(), false);
    b.a(paramParcel, 6, parammr.mn(), false);
    b.H(paramParcel, i);
  }

  public mr cD(Parcel paramParcel)
  {
    String str1 = null;
    int i = a.C(paramParcel);
    int j = 0;
    String str2 = null;
    ArrayList localArrayList = null;
    String str3 = null;
    LatLng localLatLng = null;
    String str4 = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.B(paramParcel);
      switch (a.aD(k))
      {
      default:
        a.b(paramParcel, k);
        break;
      case 1:
        str4 = a.o(paramParcel, k);
        break;
      case 1000:
        j = a.g(paramParcel, k);
        break;
      case 2:
        localLatLng = (LatLng)a.a(paramParcel, k, LatLng.CREATOR);
        break;
      case 3:
        str3 = a.o(paramParcel, k);
        break;
      case 4:
        localArrayList = a.c(paramParcel, k, mp.CREATOR);
        break;
      case 5:
        str2 = a.o(paramParcel, k);
        break;
      case 6:
        str1 = a.o(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    return new mr(j, str4, localLatLng, str3, localArrayList, str2, str1);
  }

  public mr[] et(int paramInt)
  {
    return new mr[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ms
 * JD-Core Version:    0.6.2
 */