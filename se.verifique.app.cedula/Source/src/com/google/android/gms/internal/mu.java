package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

public class mu
  implements Parcelable.Creator
{
  static void a(ju paramju, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramju.a(), false);
    c.a(paramParcel, 1000, paramju.a);
    c.a(paramParcel, 2, paramju.b(), paramInt, false);
    c.a(paramParcel, 3, paramju.c(), false);
    c.b(paramParcel, 4, paramju.d(), false);
    c.a(paramParcel, 5, paramju.e(), false);
    c.a(paramParcel, 6, paramju.f(), false);
    c.a(paramParcel, i);
  }

  public ju a(Parcel paramParcel)
  {
    String str1 = null;
    int i = a.b(paramParcel);
    int j = 0;
    String str2 = null;
    ArrayList localArrayList = null;
    String str3 = null;
    LatLng localLatLng = null;
    String str4 = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.a(paramParcel);
      switch (a.a(k))
      {
      default:
        a.b(paramParcel, k);
        break;
      case 1:
        str4 = a.o(paramParcel, k);
        break;
      case 1000:
        j = a.g(paramParcel, k);
        break;
      case 2:
        localLatLng = (LatLng)a.a(paramParcel, k, LatLng.a);
        break;
      case 3:
        str3 = a.o(paramParcel, k);
        break;
      case 4:
        localArrayList = a.c(paramParcel, k, js.bw);
        break;
      case 5:
        str2 = a.o(paramParcel, k);
        break;
      case 6:
        str1 = a.o(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new ju(j, str4, localLatLng, str3, localArrayList, str2, str1);
  }

  public ju[] a(int paramInt)
  {
    return new ju[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.mu
 * JD-Core Version:    0.6.0
 */