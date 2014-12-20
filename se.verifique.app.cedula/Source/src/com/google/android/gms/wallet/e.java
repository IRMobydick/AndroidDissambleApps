package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class e
  implements Parcelable.Creator
{
  static void a(d paramd, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramd.a());
    c.a(paramParcel, 2, paramd.a, paramInt, false);
    c.a(paramParcel, 3, paramd.b, paramInt, false);
    c.a(paramParcel, i);
  }

  public d a(Parcel paramParcel)
  {
    Object localObject1 = null;
    int i = a.b(paramParcel);
    int j = 0;
    Object localObject2 = null;
    if (paramParcel.dataPosition() < i)
    {
      int k = a.a(paramParcel);
      Object localObject3;
      Object localObject4;
      int m;
      switch (a.a(k))
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
      throw new b("Overread allowed size end=" + i, paramParcel);
    return (d)new d(j, localObject2, localObject1);
  }

  public d[] a(int paramInt)
  {
    return new d[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.e
 * JD-Core Version:    0.6.0
 */