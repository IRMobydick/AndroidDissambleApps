package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class ac
  implements Parcelable.Creator
{
  static void a(CreateFileRequest paramCreateFileRequest, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramCreateFileRequest.a);
    c.a(paramParcel, 2, paramCreateFileRequest.b, paramInt, false);
    c.a(paramParcel, 3, paramCreateFileRequest.c, paramInt, false);
    c.a(paramParcel, 4, paramCreateFileRequest.d, paramInt, false);
    c.a(paramParcel, 5, paramCreateFileRequest.e, false);
    c.a(paramParcel, 6, paramCreateFileRequest.f);
    c.a(paramParcel, 7, paramCreateFileRequest.g, false);
    c.a(paramParcel, i);
  }

  public CreateFileRequest a(Parcel paramParcel)
  {
    boolean bool = false;
    String str = null;
    int i = a.b(paramParcel);
    Integer localInteger = null;
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
        localInteger = a.h(paramParcel, k);
        break;
      case 6:
        bool = a.c(paramParcel, k);
        break;
      case 7:
        str = a.o(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new CreateFileRequest(j, localDriveId, localMetadataBundle, localContents, localInteger, bool, str);
  }

  public CreateFileRequest[] a(int paramInt)
  {
    return new CreateFileRequest[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.ac
 * JD-Core Version:    0.6.0
 */