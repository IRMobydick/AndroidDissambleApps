package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class nk
  implements Parcelable.Creator<ni>
{
  static void a(ni paramni, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.c(paramParcel, 1, paramni.versionCode);
    b.a(paramParcel, 2, paramni.akH);
    b.a(paramParcel, 3, paramni.tag, false);
    b.a(paramParcel, 4, paramni.akI, false);
    b.a(paramParcel, 5, paramni.akJ, false);
    b.H(paramParcel, i);
  }

  public ni cX(Parcel paramParcel)
  {
    Bundle localBundle = null;
    int i = a.C(paramParcel);
    int j = 0;
    long l = 0L;
    byte[] arrayOfByte = null;
    String str = null;
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
        l = a.i(paramParcel, k);
        break;
      case 3:
        str = a.o(paramParcel, k);
        break;
      case 4:
        arrayOfByte = a.r(paramParcel, k);
        break;
      case 5:
        localBundle = a.q(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    return new ni(j, l, str, arrayOfByte, localBundle);
  }

  public ni[] eO(int paramInt)
  {
    return new ni[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.nk
 * JD-Core Version:    0.6.2
 */