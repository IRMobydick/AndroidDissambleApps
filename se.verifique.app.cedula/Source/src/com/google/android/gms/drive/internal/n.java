package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.drive.StorageStats;

public class n
  implements Parcelable.Creator
{
  static void a(OnStorageStatsResponse paramOnStorageStatsResponse, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramOnStorageStatsResponse.a);
    c.a(paramParcel, 2, paramOnStorageStatsResponse.b, paramInt, false);
    c.a(paramParcel, i);
  }

  public OnStorageStatsResponse a(Parcel paramParcel)
  {
    int i = a.b(paramParcel);
    int j = 0;
    StorageStats localStorageStats = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.a(paramParcel);
      switch (a.a(k))
      {
      default:
        a.b(paramParcel, k);
        break;
      case 1:
        j = a.g(paramParcel, k);
        break;
      case 2:
        localStorageStats = (StorageStats)a.a(paramParcel, k, StorageStats.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new OnStorageStatsResponse(j, localStorageStats);
  }

  public OnStorageStatsResponse[] a(int paramInt)
  {
    return new OnStorageStatsResponse[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.n
 * JD-Core Version:    0.6.0
 */