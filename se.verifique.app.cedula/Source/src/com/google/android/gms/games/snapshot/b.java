package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public class b
  implements Parcelable.Creator
{
  static void a(SnapshotMetadataChange paramSnapshotMetadataChange, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramSnapshotMetadataChange.b(), false);
    c.a(paramParcel, 1000, paramSnapshotMetadataChange.a());
    c.a(paramParcel, 2, paramSnapshotMetadataChange.c(), false);
    c.a(paramParcel, 4, paramSnapshotMetadataChange.e(), paramInt, false);
    c.a(paramParcel, 5, paramSnapshotMetadataChange.d(), paramInt, false);
    c.a(paramParcel, i);
  }

  public SnapshotMetadataChange a(Parcel paramParcel)
  {
    Uri localUri = null;
    int i = com.google.android.gms.common.internal.safeparcel.a.b(paramParcel);
    int j = 0;
    com.google.android.gms.common.data.a locala = null;
    Long localLong = null;
    String str = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.a.a(k))
      {
      default:
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
        break;
      case 1:
        str = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
        break;
      case 1000:
        j = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
        break;
      case 2:
        localLong = com.google.android.gms.common.internal.safeparcel.a.j(paramParcel, k);
        break;
      case 4:
        localUri = (Uri)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, Uri.CREATOR);
        break;
      case 5:
        locala = (com.google.android.gms.common.data.a)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, com.google.android.gms.common.data.a.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + i, paramParcel);
    return new SnapshotMetadataChange(j, str, localLong, locala, localUri);
  }

  public SnapshotMetadataChange[] a(int paramInt)
  {
    return new SnapshotMetadataChange[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.snapshot.b
 * JD-Core Version:    0.6.0
 */