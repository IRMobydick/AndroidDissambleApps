package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.drive.Contents;

public class a
  implements Parcelable.Creator
{
  static void a(SnapshotEntity paramSnapshotEntity, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramSnapshotEntity.b(), paramInt, false);
    c.a(paramParcel, 1000, paramSnapshotEntity.d());
    c.a(paramParcel, 2, paramSnapshotEntity.c(), paramInt, false);
    c.a(paramParcel, i);
  }

  public SnapshotEntity a(Parcel paramParcel)
  {
    Object localObject1 = null;
    int i = com.google.android.gms.common.internal.safeparcel.a.b(paramParcel);
    int j = 0;
    Object localObject2 = null;
    if (paramParcel.dataPosition() < i)
    {
      int k = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel);
      Object localObject3;
      Object localObject4;
      int m;
      switch (com.google.android.gms.common.internal.safeparcel.a.a(k))
      {
      default:
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
        localObject3 = localObject1;
        localObject4 = localObject2;
        m = j;
      case 1:
      case 1000:
      case 2:
      }
      while (true)
      {
        j = m;
        localObject2 = localObject4;
        localObject1 = localObject3;
        break;
        SnapshotMetadataEntity localSnapshotMetadataEntity = (SnapshotMetadataEntity)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, SnapshotMetadataEntity.a);
        m = j;
        localObject3 = localObject1;
        localObject4 = localSnapshotMetadataEntity;
        continue;
        int n = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
        Object localObject5 = localObject1;
        localObject4 = localObject2;
        m = n;
        localObject3 = localObject5;
        continue;
        localObject3 = (Contents)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, Contents.CREATOR);
        localObject4 = localObject2;
        m = j;
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return (SnapshotEntity)new SnapshotEntity(j, localObject2, localObject1);
  }

  public SnapshotEntity[] a(int paramInt)
  {
    return new SnapshotEntity[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.snapshot.a
 * JD-Core Version:    0.6.0
 */