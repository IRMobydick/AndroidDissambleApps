package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;

public class d
  implements Parcelable.Creator
{
  static void a(PlayerEntity paramPlayerEntity, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramPlayerEntity.b_(), false);
    c.a(paramParcel, 2, paramPlayerEntity.c(), false);
    c.a(paramParcel, 3, paramPlayerEntity.d(), paramInt, false);
    c.a(paramParcel, 4, paramPlayerEntity.f(), paramInt, false);
    c.a(paramParcel, 5, paramPlayerEntity.h());
    c.a(paramParcel, 6, paramPlayerEntity.j());
    c.a(paramParcel, 7, paramPlayerEntity.i());
    c.a(paramParcel, 8, paramPlayerEntity.e(), false);
    c.a(paramParcel, 9, paramPlayerEntity.g(), false);
    c.a(paramParcel, 14, paramPlayerEntity.l(), false);
    c.a(paramParcel, 15, paramPlayerEntity.n(), paramInt, false);
    c.a(paramParcel, 17, paramPlayerEntity.k());
    c.a(paramParcel, 16, paramPlayerEntity.m(), paramInt, false);
    c.a(paramParcel, 1000, paramPlayerEntity.o());
    c.a(paramParcel, i);
  }

  public PlayerEntity a(Parcel paramParcel)
  {
    int i = a.b(paramParcel);
    int j = 0;
    String str1 = null;
    String str2 = null;
    Uri localUri1 = null;
    Uri localUri2 = null;
    long l1 = 0L;
    int k = 0;
    long l2 = 0L;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    MostRecentGameInfoEntity localMostRecentGameInfoEntity = null;
    PlayerLevelInfo localPlayerLevelInfo = null;
    boolean bool = false;
    while (paramParcel.dataPosition() < i)
    {
      int m = a.a(paramParcel);
      switch (a.a(m))
      {
      default:
        a.b(paramParcel, m);
        break;
      case 1:
        str1 = a.o(paramParcel, m);
        break;
      case 2:
        str2 = a.o(paramParcel, m);
        break;
      case 3:
        localUri1 = (Uri)a.a(paramParcel, m, Uri.CREATOR);
        break;
      case 4:
        localUri2 = (Uri)a.a(paramParcel, m, Uri.CREATOR);
        break;
      case 5:
        l1 = a.i(paramParcel, m);
        break;
      case 6:
        k = a.g(paramParcel, m);
        break;
      case 7:
        l2 = a.i(paramParcel, m);
        break;
      case 8:
        str3 = a.o(paramParcel, m);
        break;
      case 9:
        str4 = a.o(paramParcel, m);
        break;
      case 14:
        str5 = a.o(paramParcel, m);
        break;
      case 15:
        localMostRecentGameInfoEntity = (MostRecentGameInfoEntity)a.a(paramParcel, m, MostRecentGameInfoEntity.a);
        break;
      case 17:
        bool = a.c(paramParcel, m);
        break;
      case 16:
        localPlayerLevelInfo = (PlayerLevelInfo)a.a(paramParcel, m, PlayerLevelInfo.a);
        break;
      case 1000:
        j = a.g(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new PlayerEntity(j, str1, str2, localUri1, localUri2, l1, k, l2, str3, str4, str5, localMostRecentGameInfoEntity, localPlayerLevelInfo, bool);
  }

  public PlayerEntity[] a(int paramInt)
  {
    return new PlayerEntity[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.d
 * JD-Core Version:    0.6.0
 */