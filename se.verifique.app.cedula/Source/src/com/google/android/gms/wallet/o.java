package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class o
  implements Parcelable.Creator
{
  static void a(ProxyCard paramProxyCard, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramProxyCard.a());
    c.a(paramParcel, 2, paramProxyCard.a, false);
    c.a(paramParcel, 3, paramProxyCard.b, false);
    c.a(paramParcel, 4, paramProxyCard.c);
    c.a(paramParcel, 5, paramProxyCard.d);
    c.a(paramParcel, i);
  }

  public ProxyCard a(Parcel paramParcel)
  {
    String str1 = null;
    int i = 0;
    int j = a.b(paramParcel);
    int k = 0;
    String str2 = null;
    int m = 0;
    while (paramParcel.dataPosition() < j)
    {
      int n = a.a(paramParcel);
      switch (a.a(n))
      {
      default:
        a.b(paramParcel, n);
        break;
      case 1:
        m = a.g(paramParcel, n);
        break;
      case 2:
        str2 = a.o(paramParcel, n);
        break;
      case 3:
        str1 = a.o(paramParcel, n);
        break;
      case 4:
        k = a.g(paramParcel, n);
        break;
      case 5:
        i = a.g(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new b("Overread allowed size end=" + j, paramParcel);
    return new ProxyCard(m, str2, str1, k, i);
  }

  public ProxyCard[] a(int paramInt)
  {
    return new ProxyCard[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.o
 * JD-Core Version:    0.6.0
 */