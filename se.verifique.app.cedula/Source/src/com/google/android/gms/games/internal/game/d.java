package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class d
  implements Parcelable.Creator
{
  static void a(GameBadgeEntity paramGameBadgeEntity, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramGameBadgeEntity.e_());
    c.a(paramParcel, 1000, paramGameBadgeEntity.f());
    c.a(paramParcel, 2, paramGameBadgeEntity.c(), false);
    c.a(paramParcel, 3, paramGameBadgeEntity.d(), false);
    c.a(paramParcel, 4, paramGameBadgeEntity.e(), paramInt, false);
    c.a(paramParcel, i);
  }

  public GameBadgeEntity a(Parcel paramParcel)
  {
    int i = 0;
    Uri localUri = null;
    int j = a.b(paramParcel);
    String str1 = null;
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
        i = a.g(paramParcel, m);
        break;
      case 1000:
        k = a.g(paramParcel, m);
        break;
      case 2:
        str2 = a.o(paramParcel, m);
        break;
      case 3:
        str1 = a.o(paramParcel, m);
        break;
      case 4:
        localUri = (Uri)a.a(paramParcel, m, Uri.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new b("Overread allowed size end=" + j, paramParcel);
    return new GameBadgeEntity(k, i, str2, str1, localUri);
  }

  public GameBadgeEntity[] a(int paramInt)
  {
    return new GameBadgeEntity[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.game.d
 * JD-Core Version:    0.6.0
 */