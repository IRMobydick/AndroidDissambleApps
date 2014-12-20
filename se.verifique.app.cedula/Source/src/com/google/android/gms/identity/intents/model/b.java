package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;

public class b
  implements Parcelable.Creator
{
  static void a(UserAddress paramUserAddress, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramUserAddress.a());
    c.a(paramParcel, 2, paramUserAddress.a, false);
    c.a(paramParcel, 3, paramUserAddress.b, false);
    c.a(paramParcel, 4, paramUserAddress.c, false);
    c.a(paramParcel, 5, paramUserAddress.d, false);
    c.a(paramParcel, 6, paramUserAddress.e, false);
    c.a(paramParcel, 7, paramUserAddress.f, false);
    c.a(paramParcel, 8, paramUserAddress.g, false);
    c.a(paramParcel, 9, paramUserAddress.h, false);
    c.a(paramParcel, 10, paramUserAddress.i, false);
    c.a(paramParcel, 11, paramUserAddress.j, false);
    c.a(paramParcel, 12, paramUserAddress.k, false);
    c.a(paramParcel, 13, paramUserAddress.l, false);
    c.a(paramParcel, 14, paramUserAddress.m);
    c.a(paramParcel, 15, paramUserAddress.n, false);
    c.a(paramParcel, 16, paramUserAddress.o, false);
    c.a(paramParcel, i);
  }

  public UserAddress a(Parcel paramParcel)
  {
    int i = a.b(paramParcel);
    int j = 0;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    String str6 = null;
    String str7 = null;
    String str8 = null;
    String str9 = null;
    String str10 = null;
    String str11 = null;
    String str12 = null;
    boolean bool = false;
    String str13 = null;
    String str14 = null;
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
        str1 = a.o(paramParcel, k);
        break;
      case 3:
        str2 = a.o(paramParcel, k);
        break;
      case 4:
        str3 = a.o(paramParcel, k);
        break;
      case 5:
        str4 = a.o(paramParcel, k);
        break;
      case 6:
        str5 = a.o(paramParcel, k);
        break;
      case 7:
        str6 = a.o(paramParcel, k);
        break;
      case 8:
        str7 = a.o(paramParcel, k);
        break;
      case 9:
        str8 = a.o(paramParcel, k);
        break;
      case 10:
        str9 = a.o(paramParcel, k);
        break;
      case 11:
        str10 = a.o(paramParcel, k);
        break;
      case 12:
        str11 = a.o(paramParcel, k);
        break;
      case 13:
        str12 = a.o(paramParcel, k);
        break;
      case 14:
        bool = a.c(paramParcel, k);
        break;
      case 15:
        str13 = a.o(paramParcel, k);
        break;
      case 16:
        str14 = a.o(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + i, paramParcel);
    return new UserAddress(j, str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, bool, str13, str14);
  }

  public UserAddress[] a(int paramInt)
  {
    return new UserAddress[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.identity.intents.model.b
 * JD-Core Version:    0.6.0
 */