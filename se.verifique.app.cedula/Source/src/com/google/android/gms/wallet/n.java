package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

public class n
  implements Parcelable.Creator
{
  static void a(OfferWalletObject paramOfferWalletObject, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramOfferWalletObject.a());
    c.a(paramParcel, 2, paramOfferWalletObject.a, false);
    c.a(paramParcel, 3, paramOfferWalletObject.b, false);
    c.a(paramParcel, 4, paramOfferWalletObject.c, paramInt, false);
    c.a(paramParcel, i);
  }

  public OfferWalletObject a(Parcel paramParcel)
  {
    CommonWalletObject localCommonWalletObject = null;
    int i = a.b(paramParcel);
    int j = 0;
    String str1 = null;
    String str2 = null;
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
        str2 = a.o(paramParcel, k);
        break;
      case 3:
        str1 = a.o(paramParcel, k);
        break;
      case 4:
        localCommonWalletObject = (CommonWalletObject)a.a(paramParcel, k, CommonWalletObject.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new OfferWalletObject(j, str2, str1, localCommonWalletObject);
  }

  public OfferWalletObject[] a(int paramInt)
  {
    return new OfferWalletObject[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.n
 * JD-Core Version:    0.6.0
 */