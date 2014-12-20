package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class f
  implements Parcelable.Creator
{
  static void a(af paramaf, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramaf.a);
    c.a(paramParcel, 2, paramaf.a());
    c.a(paramParcel, 3, paramaf.b(), false);
    c.a(paramParcel, 4, paramaf.c(), false);
    c.a(paramParcel, 5, paramaf.d(), false);
    c.a(paramParcel, i);
  }

  public af a(Parcel paramParcel)
  {
    int i = 0;
    String str1 = null;
    int j = a.b(paramParcel);
    byte[] arrayOfByte = null;
    String str2 = null;
    int k = 0;
    while (paramParcel.dataPosition() < j)
    {
      int m = a.a(paramParcel);
      switch (a.a(m))
      {
      default:
        a.b(paramParcel, m);
        break;
      case 1:
        k = a.g(paramParcel, m);
        break;
      case 2:
        i = a.g(paramParcel, m);
        break;
      case 3:
        str2 = a.o(paramParcel, m);
        break;
      case 4:
        arrayOfByte = a.r(paramParcel, m);
        break;
      case 5:
        str1 = a.o(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new b("Overread allowed size end=" + j, paramParcel);
    return new af(k, i, str2, arrayOfByte, str1);
  }

  public af[] a(int paramInt)
  {
    return new af[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.f
 * JD-Core Version:    0.6.0
 */