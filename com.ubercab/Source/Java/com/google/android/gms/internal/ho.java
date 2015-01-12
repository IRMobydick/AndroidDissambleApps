package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ho
  implements Parcelable.Creator<hm.b>
{
  static void a(hm.b paramb, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.c(paramParcel, 1000, paramb.BR);
    b.a(paramParcel, 1, paramb.Ck, paramInt, false);
    b.c(paramParcel, 2, paramb.Cl, false);
    b.H(paramParcel, i);
  }

  public hm.b[] N(int paramInt)
  {
    return new hm.b[paramInt];
  }

  public hm.b q(Parcel paramParcel)
  {
    Object localObject1 = null;
    int i = a.C(paramParcel);
    int j = 0;
    Object localObject2 = null;
    if (paramParcel.dataPosition() < i)
    {
      int k = a.B(paramParcel);
      Object localObject3;
      Object localObject4;
      int m;
      switch (a.aD(k))
      {
      default:
        a.b(paramParcel, k);
        localObject3 = localObject1;
        localObject4 = localObject2;
        m = j;
      case 1000:
      case 1:
      case 2:
      }
      while (true)
      {
        j = m;
        localObject2 = localObject4;
        localObject1 = localObject3;
        break;
        int n = a.g(paramParcel, k);
        Object localObject5 = localObject1;
        localObject4 = localObject2;
        m = n;
        localObject3 = localObject5;
        continue;
        Status localStatus = (Status)a.a(paramParcel, k, Status.CREATOR);
        m = j;
        localObject3 = localObject1;
        localObject4 = localStatus;
        continue;
        localObject3 = a.c(paramParcel, k, hs.CREATOR);
        localObject4 = localObject2;
        m = j;
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    return new hm.b(j, localObject2, localObject1);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ho
 * JD-Core Version:    0.6.2
 */