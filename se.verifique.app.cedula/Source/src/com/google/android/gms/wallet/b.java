package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.ArrayList;

public class b
  implements Parcelable.Creator
{
  static void a(Cart paramCart, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramCart.a());
    c.a(paramParcel, 2, paramCart.a, false);
    c.a(paramParcel, 3, paramCart.b, false);
    c.b(paramParcel, 4, paramCart.c, false);
    c.a(paramParcel, i);
  }

  public Cart a(Parcel paramParcel)
  {
    String str1 = null;
    int i = a.b(paramParcel);
    int j = 0;
    ArrayList localArrayList = new ArrayList();
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
        localArrayList = a.c(paramParcel, k, LineItem.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + i, paramParcel);
    return new Cart(j, str2, str1, localArrayList);
  }

  public Cart[] a(int paramInt)
  {
    return new Cart[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.b
 * JD-Core Version:    0.6.0
 */