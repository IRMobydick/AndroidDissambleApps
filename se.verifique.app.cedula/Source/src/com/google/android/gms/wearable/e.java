package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class e
  implements Parcelable.Creator
{
  static void a(c paramc, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.c.a(paramParcel);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 1, paramc.a);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 2, paramc.a(), false);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 3, paramc.b(), false);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 4, paramc.c());
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 5, paramc.d());
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 6, paramc.e());
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, i);
  }

  public c a(Parcel paramParcel)
  {
    String str1 = null;
    boolean bool = false;
    int i = a.b(paramParcel);
    int j = 0;
    int k = 0;
    String str2 = null;
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
        j = a.g(paramParcel, n);
        break;
      case 6:
        bool = a.c(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new c(m, str2, str1, k, j, bool);
  }

  public c[] a(int paramInt)
  {
    return new c[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.e
 * JD-Core Version:    0.6.0
 */