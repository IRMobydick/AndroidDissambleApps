package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class ab
  implements Parcelable.Creator
{
  static void a(CreateFileIntentSenderRequest paramCreateFileIntentSenderRequest, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramCreateFileIntentSenderRequest.a);
    c.a(paramParcel, 2, paramCreateFileIntentSenderRequest.b, paramInt, false);
    c.a(paramParcel, 3, paramCreateFileIntentSenderRequest.c);
    c.a(paramParcel, 4, paramCreateFileIntentSenderRequest.d, false);
    c.a(paramParcel, 5, paramCreateFileIntentSenderRequest.e, paramInt, false);
    c.a(paramParcel, 6, paramCreateFileIntentSenderRequest.f, false);
    c.a(paramParcel, i);
  }

  public CreateFileIntentSenderRequest a(Parcel paramParcel)
  {
    int i = 0;
    Integer localInteger = null;
    int j = a.b(paramParcel);
    DriveId localDriveId = null;
    String str = null;
    MetadataBundle localMetadataBundle = null;
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
        k = a.g(paramParcel, m);
        break;
      case 2:
        localMetadataBundle = (MetadataBundle)a.a(paramParcel, m, MetadataBundle.CREATOR);
        break;
      case 3:
        i = a.g(paramParcel, m);
        break;
      case 4:
        str = a.o(paramParcel, m);
        break;
      case 5:
        localDriveId = (DriveId)a.a(paramParcel, m, DriveId.CREATOR);
        break;
      case 6:
        localInteger = a.h(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new b("Overread allowed size end=" + j, paramParcel);
    return new CreateFileIntentSenderRequest(k, localMetadataBundle, i, str, localDriveId, localInteger);
  }

  public CreateFileIntentSenderRequest[] a(int paramInt)
  {
    return new CreateFileIntentSenderRequest[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.ab
 * JD-Core Version:    0.6.0
 */