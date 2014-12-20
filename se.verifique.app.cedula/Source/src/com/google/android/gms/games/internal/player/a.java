package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class a
  implements Parcelable.Creator
{
  static void a(MostRecentGameInfoEntity paramMostRecentGameInfoEntity, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramMostRecentGameInfoEntity.f_(), false);
    c.a(paramParcel, 1000, paramMostRecentGameInfoEntity.h());
    c.a(paramParcel, 2, paramMostRecentGameInfoEntity.c(), false);
    c.a(paramParcel, 3, paramMostRecentGameInfoEntity.d());
    c.a(paramParcel, 4, paramMostRecentGameInfoEntity.e(), paramInt, false);
    c.a(paramParcel, 5, paramMostRecentGameInfoEntity.f(), paramInt, false);
    c.a(paramParcel, 6, paramMostRecentGameInfoEntity.g(), paramInt, false);
    c.a(paramParcel, i);
  }

  public MostRecentGameInfoEntity a(Parcel paramParcel)
  {
    Uri localUri1 = null;
    int i = com.google.android.gms.common.internal.safeparcel.a.b(paramParcel);
    int j = 0;
    long l = 0L;
    Uri localUri2 = null;
    Uri localUri3 = null;
    String str1 = null;
    String str2 = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.a.a(k))
      {
      default:
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
        break;
      case 1:
        str2 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
        break;
      case 1000:
        j = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
        break;
      case 2:
        str1 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
        break;
      case 3:
        l = com.google.android.gms.common.internal.safeparcel.a.i(paramParcel, k);
        break;
      case 4:
        localUri3 = (Uri)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, Uri.CREATOR);
        break;
      case 5:
        localUri2 = (Uri)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, Uri.CREATOR);
        break;
      case 6:
        localUri1 = (Uri)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, Uri.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new MostRecentGameInfoEntity(j, str2, str1, l, localUri3, localUri2, localUri1);
  }

  public MostRecentGameInfoEntity[] a(int paramInt)
  {
    return new MostRecentGameInfoEntity[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.player.a
 * JD-Core Version:    0.6.0
 */