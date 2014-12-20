package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class i
  implements Parcelable.Creator
{
  static void a(OnListEntriesResponse paramOnListEntriesResponse, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramOnListEntriesResponse.a);
    c.a(paramParcel, 2, paramOnListEntriesResponse.b, paramInt, false);
    c.a(paramParcel, 3, paramOnListEntriesResponse.c);
    c.a(paramParcel, i);
  }

  public OnListEntriesResponse a(Parcel paramParcel)
  {
    boolean bool1 = false;
    int i = a.b(paramParcel);
    Object localObject1 = null;
    int j = 0;
    if (paramParcel.dataPosition() < i)
    {
      int k = a.a(paramParcel);
      boolean bool2;
      Object localObject2;
      int m;
      switch (a.a(k))
      {
      default:
        a.b(paramParcel, k);
        bool2 = bool1;
        localObject2 = localObject1;
        m = j;
      case 1:
      case 2:
      case 3:
      }
      while (true)
      {
        j = m;
        localObject1 = localObject2;
        bool1 = bool2;
        break;
        int n = a.g(paramParcel, k);
        boolean bool3 = bool1;
        localObject2 = localObject1;
        m = n;
        bool2 = bool3;
        continue;
        DataHolder localDataHolder = (DataHolder)a.a(paramParcel, k, DataHolder.a);
        m = j;
        bool2 = bool1;
        localObject2 = localDataHolder;
        continue;
        bool2 = a.c(paramParcel, k);
        localObject2 = localObject1;
        m = j;
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new OnListEntriesResponse(j, localObject1, bool1);
  }

  public OnListEntriesResponse[] a(int paramInt)
  {
    return new OnListEntriesResponse[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.i
 * JD-Core Version:    0.6.0
 */