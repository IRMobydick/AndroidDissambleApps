package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class oq
  implements Parcelable.Creator<op>
{
  static void a(op paramop, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.c(paramParcel, 1, paramop.getVersionCode());
    b.a(paramParcel, 2, paramop.atO, false);
    b.a(paramParcel, 3, paramop.atP, false);
    b.H(paramParcel, i);
  }

  public op dC(Parcel paramParcel)
  {
    String[] arrayOfString = null;
    int i = a.C(paramParcel);
    int j = 0;
    byte[][] arrayOfByte = (byte[][])null;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.B(paramParcel);
      switch (a.aD(k))
      {
      default:
        a.b(paramParcel, k);
        break;
      case 1:
        j = a.g(paramParcel, k);
        break;
      case 2:
        arrayOfString = a.A(paramParcel, k);
        break;
      case 3:
        arrayOfByte = a.s(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    return new op(j, arrayOfString, arrayOfByte);
  }

  public op[] fD(int paramInt)
  {
    return new op[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.oq
 * JD-Core Version:    0.6.2
 */