package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import java.util.ArrayList;

public class b
  implements Parcelable.Creator
{
  static void a(ExtendedGameEntity paramExtendedGameEntity, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramExtendedGameEntity.n(), paramInt, false);
    c.a(paramParcel, 1000, paramExtendedGameEntity.m());
    c.a(paramParcel, 2, paramExtendedGameEntity.d());
    c.a(paramParcel, 3, paramExtendedGameEntity.e());
    c.a(paramParcel, 4, paramExtendedGameEntity.f());
    c.a(paramParcel, 5, paramExtendedGameEntity.g());
    c.a(paramParcel, 6, paramExtendedGameEntity.h());
    c.a(paramParcel, 7, paramExtendedGameEntity.i(), false);
    c.a(paramParcel, 8, paramExtendedGameEntity.j());
    c.a(paramParcel, 9, paramExtendedGameEntity.k(), false);
    c.b(paramParcel, 10, paramExtendedGameEntity.c(), false);
    c.a(paramParcel, 11, paramExtendedGameEntity.l(), paramInt, false);
    c.a(paramParcel, i);
  }

  public ExtendedGameEntity a(Parcel paramParcel)
  {
    int i = a.b(paramParcel);
    int j = 0;
    GameEntity localGameEntity = null;
    int k = 0;
    boolean bool = false;
    int m = 0;
    long l1 = 0L;
    long l2 = 0L;
    String str1 = null;
    long l3 = 0L;
    String str2 = null;
    ArrayList localArrayList = null;
    SnapshotMetadataEntity localSnapshotMetadataEntity = null;
    while (paramParcel.dataPosition() < i)
    {
      int n = a.a(paramParcel);
      switch (a.a(n))
      {
      default:
        a.b(paramParcel, n);
        break;
      case 1:
        localGameEntity = (GameEntity)a.a(paramParcel, n, GameEntity.CREATOR);
        break;
      case 1000:
        j = a.g(paramParcel, n);
        break;
      case 2:
        k = a.g(paramParcel, n);
        break;
      case 3:
        bool = a.c(paramParcel, n);
        break;
      case 4:
        m = a.g(paramParcel, n);
        break;
      case 5:
        l1 = a.i(paramParcel, n);
        break;
      case 6:
        l2 = a.i(paramParcel, n);
        break;
      case 7:
        str1 = a.o(paramParcel, n);
        break;
      case 8:
        l3 = a.i(paramParcel, n);
        break;
      case 9:
        str2 = a.o(paramParcel, n);
        break;
      case 10:
        localArrayList = a.c(paramParcel, n, GameBadgeEntity.a);
        break;
      case 11:
        localSnapshotMetadataEntity = (SnapshotMetadataEntity)a.a(paramParcel, n, SnapshotMetadataEntity.a);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + i, paramParcel);
    return new ExtendedGameEntity(j, localGameEntity, k, bool, m, l1, l2, str1, l3, str2, localArrayList, localSnapshotMetadataEntity);
  }

  public ExtendedGameEntity[] a(int paramInt)
  {
    return new ExtendedGameEntity[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.game.b
 * JD-Core Version:    0.6.0
 */