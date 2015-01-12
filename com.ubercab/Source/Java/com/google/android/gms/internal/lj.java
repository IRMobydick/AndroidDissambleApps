package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.DataSource;

public class lj
  implements Parcelable.Creator<li>
{
  static void a(li paramli, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.a(paramParcel, 1, paramli.getDataSource(), paramInt, false);
    b.c(paramParcel, 1000, paramli.getVersionCode());
    b.H(paramParcel, i);
  }

  public li bz(Parcel paramParcel)
  {
    int i = a.C(paramParcel);
    int j = 0;
    DataSource localDataSource = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.B(paramParcel);
      switch (a.aD(k))
      {
      default:
        a.b(paramParcel, k);
        break;
      case 1:
        localDataSource = (DataSource)a.a(paramParcel, k, DataSource.CREATOR);
        break;
      case 1000:
        j = a.g(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    return new li(j, localDataSource);
  }

  public li[] cQ(int paramInt)
  {
    return new li[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.lj
 * JD-Core Version:    0.6.2
 */