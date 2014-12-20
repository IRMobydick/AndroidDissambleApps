package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;
import java.util.ArrayList;

public class a
  implements Parcelable.Creator
{
  static void a(GameRequestEntity paramGameRequestEntity, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramGameRequestEntity.e(), paramInt, false);
    c.a(paramParcel, 1000, paramGameRequestEntity.b());
    c.a(paramParcel, 2, paramGameRequestEntity.f(), paramInt, false);
    c.a(paramParcel, 3, paramGameRequestEntity.h(), false);
    c.a(paramParcel, 4, paramGameRequestEntity.d(), false);
    c.b(paramParcel, 5, paramGameRequestEntity.n(), false);
    c.a(paramParcel, 7, paramGameRequestEntity.i());
    c.a(paramParcel, 9, paramGameRequestEntity.j());
    c.a(paramParcel, 10, paramGameRequestEntity.k());
    c.a(paramParcel, 11, paramGameRequestEntity.c(), false);
    c.a(paramParcel, 12, paramGameRequestEntity.l());
    c.a(paramParcel, i);
  }

  public GameRequestEntity a(Parcel paramParcel)
  {
    int i = com.google.android.gms.common.internal.safeparcel.a.b(paramParcel);
    int j = 0;
    GameEntity localGameEntity = null;
    PlayerEntity localPlayerEntity = null;
    byte[] arrayOfByte = null;
    String str = null;
    ArrayList localArrayList = null;
    int k = 0;
    long l1 = 0L;
    long l2 = 0L;
    Bundle localBundle = null;
    int m = 0;
    while (paramParcel.dataPosition() < i)
    {
      int n = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.a.a(n))
      {
      default:
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, n);
        break;
      case 1:
        localGameEntity = (GameEntity)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, n, GameEntity.CREATOR);
        break;
      case 1000:
        j = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, n);
        break;
      case 2:
        localPlayerEntity = (PlayerEntity)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, n, PlayerEntity.CREATOR);
        break;
      case 3:
        arrayOfByte = com.google.android.gms.common.internal.safeparcel.a.r(paramParcel, n);
        break;
      case 4:
        str = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, n);
        break;
      case 5:
        localArrayList = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, n, PlayerEntity.CREATOR);
        break;
      case 7:
        k = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, n);
        break;
      case 9:
        l1 = com.google.android.gms.common.internal.safeparcel.a.i(paramParcel, n);
        break;
      case 10:
        l2 = com.google.android.gms.common.internal.safeparcel.a.i(paramParcel, n);
        break;
      case 11:
        localBundle = com.google.android.gms.common.internal.safeparcel.a.q(paramParcel, n);
        break;
      case 12:
        m = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new GameRequestEntity(j, localGameEntity, localPlayerEntity, arrayOfByte, str, localArrayList, k, l1, l2, localBundle, m);
  }

  public GameRequestEntity[] a(int paramInt)
  {
    return new GameRequestEntity[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.request.a
 * JD-Core Version:    0.6.0
 */