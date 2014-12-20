package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;

public class c
  implements Parcelable.Creator
{
  static void a(SnapshotMetadataEntity paramSnapshotMetadataEntity, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.c.a(paramParcel);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 1, paramSnapshotMetadataEntity.l_(), paramInt, false);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 1000, paramSnapshotMetadataEntity.m());
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 2, paramSnapshotMetadataEntity.c(), paramInt, false);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 3, paramSnapshotMetadataEntity.d(), false);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 5, paramSnapshotMetadataEntity.e(), paramInt, false);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 6, paramSnapshotMetadataEntity.f(), false);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 7, paramSnapshotMetadataEntity.i(), false);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 8, paramSnapshotMetadataEntity.j(), false);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 9, paramSnapshotMetadataEntity.k());
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 10, paramSnapshotMetadataEntity.l());
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 11, paramSnapshotMetadataEntity.g());
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 12, paramSnapshotMetadataEntity.h(), false);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, i);
  }

  public SnapshotMetadataEntity a(Parcel paramParcel)
  {
    int i = a.b(paramParcel);
    int j = 0;
    GameEntity localGameEntity = null;
    PlayerEntity localPlayerEntity = null;
    String str1 = null;
    Uri localUri = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    long l1 = 0L;
    long l2 = 0L;
    float f = 0.0F;
    String str5 = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.a(paramParcel);
      switch (a.a(k))
      {
      default:
        a.b(paramParcel, k);
        break;
      case 1:
        localGameEntity = (GameEntity)a.a(paramParcel, k, GameEntity.CREATOR);
        break;
      case 1000:
        j = a.g(paramParcel, k);
        break;
      case 2:
        localPlayerEntity = (PlayerEntity)a.a(paramParcel, k, PlayerEntity.CREATOR);
        break;
      case 3:
        str1 = a.o(paramParcel, k);
        break;
      case 5:
        localUri = (Uri)a.a(paramParcel, k, Uri.CREATOR);
        break;
      case 6:
        str2 = a.o(paramParcel, k);
        break;
      case 7:
        str3 = a.o(paramParcel, k);
        break;
      case 8:
        str4 = a.o(paramParcel, k);
        break;
      case 9:
        l1 = a.i(paramParcel, k);
        break;
      case 10:
        l2 = a.i(paramParcel, k);
        break;
      case 11:
        f = a.l(paramParcel, k);
        break;
      case 12:
        str5 = a.o(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new SnapshotMetadataEntity(j, localGameEntity, localPlayerEntity, str1, localUri, str2, str3, str4, l1, l2, f, str5);
  }

  public SnapshotMetadataEntity[] a(int paramInt)
  {
    return new SnapshotMetadataEntity[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.snapshot.c
 * JD-Core Version:    0.6.0
 */