package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class d
  implements Parcelable.Creator
{
  static void a(LocationRequest paramLocationRequest, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramLocationRequest.a);
    c.a(paramParcel, 1000, paramLocationRequest.a());
    c.a(paramParcel, 2, paramLocationRequest.b);
    c.a(paramParcel, 3, paramLocationRequest.c);
    c.a(paramParcel, 4, paramLocationRequest.d);
    c.a(paramParcel, 5, paramLocationRequest.e);
    c.a(paramParcel, 6, paramLocationRequest.f);
    c.a(paramParcel, 7, paramLocationRequest.g);
    c.a(paramParcel, i);
  }

  public LocationRequest a(Parcel paramParcel)
  {
    boolean bool = false;
    int i = a.b(paramParcel);
    int j = 102;
    long l1 = 3600000L;
    long l2 = 600000L;
    long l3 = 9223372036854775807L;
    int k = 2147483647;
    float f = 0.0F;
    int m = 0;
    while (paramParcel.dataPosition() < i)
    {
      int n = a.a(paramParcel);
      switch (a.a(n))
      {
      default:
        a.b(paramParcel, n);
        break;
      case 1:
        j = a.g(paramParcel, n);
        break;
      case 1000:
        m = a.g(paramParcel, n);
        break;
      case 2:
        l1 = a.i(paramParcel, n);
        break;
      case 3:
        l2 = a.i(paramParcel, n);
        break;
      case 4:
        bool = a.c(paramParcel, n);
        break;
      case 5:
        l3 = a.i(paramParcel, n);
        break;
      case 6:
        k = a.g(paramParcel, n);
        break;
      case 7:
        f = a.l(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new LocationRequest(m, j, l1, l2, bool, l3, k, f);
  }

  public LocationRequest[] a(int paramInt)
  {
    return new LocationRequest[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.d
 * JD-Core Version:    0.6.0
 */