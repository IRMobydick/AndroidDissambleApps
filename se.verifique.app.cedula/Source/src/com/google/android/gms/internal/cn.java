package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class cn
  implements Parcelable.Creator
{
  static void a(ce paramce, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramce.b);
    c.a(paramParcel, 2, paramce.c, false);
    c.a(paramParcel, 3, paramce.d, false);
    c.a(paramParcel, 4, paramce.e, false);
    c.a(paramParcel, 5, paramce.f, false);
    c.a(paramParcel, 6, paramce.g, false);
    c.a(paramParcel, 7, paramce.h, false);
    c.a(paramParcel, 8, paramce.i, false);
    c.a(paramParcel, i);
  }

  public ce a(Parcel paramParcel)
  {
    String str1 = null;
    int i = a.b(paramParcel);
    int j = 0;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    String str6 = null;
    String str7 = null;
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
        str7 = a.o(paramParcel, k);
        break;
      case 3:
        str6 = a.o(paramParcel, k);
        break;
      case 4:
        str5 = a.o(paramParcel, k);
        break;
      case 5:
        str4 = a.o(paramParcel, k);
        break;
      case 6:
        str3 = a.o(paramParcel, k);
        break;
      case 7:
        str2 = a.o(paramParcel, k);
        break;
      case 8:
        str1 = a.o(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new ce(j, str7, str6, str5, str4, str3, str2, str1);
  }

  public ce[] a(int paramInt)
  {
    return new ce[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.cn
 * JD-Core Version:    0.6.0
 */