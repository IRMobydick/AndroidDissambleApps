package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c
  implements Parcelable.Creator
{
  static void a(StorageStats paramStorageStats, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.c.a(paramParcel);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 1, paramStorageStats.a);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 2, paramStorageStats.b);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 3, paramStorageStats.c);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 4, paramStorageStats.d);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 5, paramStorageStats.e);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 6, paramStorageStats.f);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, i);
  }

  public StorageStats a(Parcel paramParcel)
  {
    int i = 0;
    long l1 = 0L;
    int j = a.b(paramParcel);
    long l2 = l1;
    long l3 = l1;
    long l4 = l1;
    int k = 0;
    while (paramParcel.dataPosition() < j)
    {
      int m = a.a(paramParcel);
      switch (a.a(m))
      {
      default:
        a.b(paramParcel, m);
        break;
      case 1:
        k = a.g(paramParcel, m);
        break;
      case 2:
        l4 = a.i(paramParcel, m);
        break;
      case 3:
        l3 = a.i(paramParcel, m);
        break;
      case 4:
        l2 = a.i(paramParcel, m);
        break;
      case 5:
        l1 = a.i(paramParcel, m);
        break;
      case 6:
        i = a.g(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new b("Overread allowed size end=" + j, paramParcel);
    return new StorageStats(k, l4, l3, l2, l1, i);
  }

  public StorageStats[] a(int paramInt)
  {
    return new StorageStats[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.c
 * JD-Core Version:    0.6.0
 */