package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class e
  implements Parcelable.Creator<d>
{
  static void a(d paramd, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.c(paramParcel, 1, paramd.getVersionCode());
    b.a(paramParcel, 2, paramd.asz, paramInt, false);
    b.a(paramParcel, 3, paramd.asA, paramInt, false);
    b.H(paramParcel, i);
  }

  public d dq(Parcel paramParcel)
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
      case 1:
      case 2:
      case 3:
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
        LoyaltyWalletObject localLoyaltyWalletObject = (LoyaltyWalletObject)a.a(paramParcel, k, LoyaltyWalletObject.CREATOR);
        m = j;
        localObject3 = localObject1;
        localObject4 = localLoyaltyWalletObject;
        continue;
        localObject3 = (OfferWalletObject)a.a(paramParcel, k, OfferWalletObject.CREATOR);
        localObject4 = localObject2;
        m = j;
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    return new d(j, localObject2, localObject1);
  }

  public d[] fr(int paramInt)
  {
    return new d[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.e
 * JD-Core Version:    0.6.2
 */