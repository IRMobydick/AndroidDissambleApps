package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class r
  implements Parcelable.Creator
{
  static void a(n paramn, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramn.a());
    c.a(paramParcel, 2, paramn.a, false);
    c.a(paramParcel, 3, paramn.b, false);
    c.a(paramParcel, i);
  }

  public n a(Parcel paramParcel)
  {
    String str1 = null;
    int i = a.b(paramParcel);
    int j = 0;
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
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new n(j, str2, str1);
  }

  public n[] a(int paramInt)
  {
    return new n[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.wobs.r
 * JD-Core Version:    0.6.0
 */