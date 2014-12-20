package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class f
  implements Parcelable.Creator
{
  static void a(PlayerLevelInfo paramPlayerLevelInfo, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramPlayerLevelInfo.b());
    c.a(paramParcel, 1000, paramPlayerLevelInfo.a());
    c.a(paramParcel, 2, paramPlayerLevelInfo.c());
    c.a(paramParcel, 3, paramPlayerLevelInfo.d(), paramInt, false);
    c.a(paramParcel, 4, paramPlayerLevelInfo.e(), paramInt, false);
    c.a(paramParcel, i);
  }

  public PlayerLevelInfo a(Parcel paramParcel)
  {
    long l1 = 0L;
    PlayerLevel localPlayerLevel1 = null;
    int i = a.b(paramParcel);
    int j = 0;
    PlayerLevel localPlayerLevel2 = null;
    long l2 = l1;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.a(paramParcel);
      switch (a.a(k))
      {
      default:
        a.b(paramParcel, k);
        break;
      case 1:
        l2 = a.i(paramParcel, k);
        break;
      case 1000:
        j = a.g(paramParcel, k);
        break;
      case 2:
        l1 = a.i(paramParcel, k);
        break;
      case 3:
        localPlayerLevel2 = (PlayerLevel)a.a(paramParcel, k, PlayerLevel.a);
        break;
      case 4:
        localPlayerLevel1 = (PlayerLevel)a.a(paramParcel, k, PlayerLevel.a);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new PlayerLevelInfo(j, l2, l1, localPlayerLevel2, localPlayerLevel1);
  }

  public PlayerLevelInfo[] a(int paramInt)
  {
    return new PlayerLevelInfo[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.f
 * JD-Core Version:    0.6.0
 */