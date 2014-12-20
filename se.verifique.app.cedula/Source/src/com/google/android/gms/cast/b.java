package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.ArrayList;

public class b
  implements Parcelable.Creator
{
  static void a(CastDevice paramCastDevice, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramCastDevice.a());
    c.a(paramParcel, 2, paramCastDevice.b(), false);
    c.a(paramParcel, 3, paramCastDevice.a, false);
    c.a(paramParcel, 4, paramCastDevice.c(), false);
    c.a(paramParcel, 5, paramCastDevice.d(), false);
    c.a(paramParcel, 6, paramCastDevice.e(), false);
    c.a(paramParcel, 7, paramCastDevice.f());
    c.b(paramParcel, 8, paramCastDevice.g(), false);
    c.a(paramParcel, 9, paramCastDevice.h());
    c.a(paramParcel, i);
  }

  public CastDevice a(Parcel paramParcel)
  {
    int i = 0;
    ArrayList localArrayList = null;
    int j = a.b(paramParcel);
    int k = 0;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
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
        str5 = a.o(paramParcel, n);
        break;
      case 3:
        str4 = a.o(paramParcel, n);
        break;
      case 4:
        str3 = a.o(paramParcel, n);
        break;
      case 5:
        str2 = a.o(paramParcel, n);
        break;
      case 6:
        str1 = a.o(paramParcel, n);
        break;
      case 7:
        k = a.g(paramParcel, n);
        break;
      case 8:
        localArrayList = a.c(paramParcel, n, WebImage.CREATOR);
        break;
      case 9:
        i = a.g(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + j, paramParcel);
    return new CastDevice(m, str5, str4, str3, str2, str1, k, localArrayList, i);
  }

  public CastDevice[] a(int paramInt)
  {
    return new CastDevice[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.cast.b
 * JD-Core Version:    0.6.0
 */