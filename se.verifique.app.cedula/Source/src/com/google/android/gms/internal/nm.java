package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class nm
  implements Parcelable.Creator
{
  static void a(li paramli, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramli.a());
    c.a(paramParcel, 2, paramli.a, false);
    c.a(paramParcel, 3, paramli.b, false);
    c.a(paramParcel, i);
  }

  public li a(Parcel paramParcel)
  {
    String[] arrayOfString = null;
    int i = a.b(paramParcel);
    int j = 0;
    byte[][] arrayOfByte = (byte[][])null;
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
        arrayOfString = a.A(paramParcel, k);
        break;
      case 3:
        arrayOfByte = a.s(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new li(j, arrayOfString, arrayOfByte);
  }

  public li[] a(int paramInt)
  {
    return new li[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.nm
 * JD-Core Version:    0.6.0
 */