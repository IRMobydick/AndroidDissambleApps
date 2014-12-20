package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class o
  implements Parcelable.Creator
{
  static void a(Tile paramTile, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramTile.a());
    c.a(paramParcel, 2, paramTile.b);
    c.a(paramParcel, 3, paramTile.c);
    c.a(paramParcel, 4, paramTile.d, false);
    c.a(paramParcel, i);
  }

  public Tile a(Parcel paramParcel)
  {
    int i = 0;
    int j = a.b(paramParcel);
    byte[] arrayOfByte = null;
    int k = 0;
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
        k = a.g(paramParcel, n);
        break;
      case 3:
        i = a.g(paramParcel, n);
        break;
      case 4:
        arrayOfByte = a.r(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new b("Overread allowed size end=" + j, paramParcel);
    return new Tile(m, k, i, arrayOfByte);
  }

  public Tile[] a(int paramInt)
  {
    return new Tile[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.o
 * JD-Core Version:    0.6.0
 */