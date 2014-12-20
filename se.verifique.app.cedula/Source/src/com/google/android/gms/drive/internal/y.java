package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class y
  implements Parcelable.Creator
{
  static void a(CloseContentsAndUpdateMetadataRequest paramCloseContentsAndUpdateMetadataRequest, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramCloseContentsAndUpdateMetadataRequest.a);
    c.a(paramParcel, 2, paramCloseContentsAndUpdateMetadataRequest.b, paramInt, false);
    c.a(paramParcel, 3, paramCloseContentsAndUpdateMetadataRequest.c, paramInt, false);
    c.a(paramParcel, 4, paramCloseContentsAndUpdateMetadataRequest.d, paramInt, false);
    c.a(paramParcel, 5, paramCloseContentsAndUpdateMetadataRequest.e);
    c.a(paramParcel, 6, paramCloseContentsAndUpdateMetadataRequest.f, false);
    c.a(paramParcel, i);
  }

  public CloseContentsAndUpdateMetadataRequest a(Parcel paramParcel)
  {
    boolean bool = false;
    String str = null;
    int i = a.b(paramParcel);
    Contents localContents = null;
    MetadataBundle localMetadataBundle = null;
    DriveId localDriveId = null;
    int j = 0;
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
        localDriveId = (DriveId)a.a(paramParcel, k, DriveId.CREATOR);
        break;
      case 3:
        localMetadataBundle = (MetadataBundle)a.a(paramParcel, k, MetadataBundle.CREATOR);
        break;
      case 4:
        localContents = (Contents)a.a(paramParcel, k, Contents.CREATOR);
        break;
      case 5:
        bool = a.c(paramParcel, k);
        break;
      case 6:
        str = a.o(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new CloseContentsAndUpdateMetadataRequest(j, localDriveId, localMetadataBundle, localContents, bool, str);
  }

  public CloseContentsAndUpdateMetadataRequest[] a(int paramInt)
  {
    return new CloseContentsAndUpdateMetadataRequest[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.y
 * JD-Core Version:    0.6.0
 */