package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.ArrayList;

public class b
  implements Parcelable.Creator
{
  static void a(FileConflictEvent paramFileConflictEvent, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramFileConflictEvent.a);
    c.a(paramParcel, 2, paramFileConflictEvent.b, paramInt, false);
    c.a(paramParcel, 3, paramFileConflictEvent.c, false);
    c.a(paramParcel, 4, paramFileConflictEvent.d, paramInt, false);
    c.a(paramParcel, 5, paramFileConflictEvent.e, paramInt, false);
    c.a(paramParcel, 6, paramFileConflictEvent.f, paramInt, false);
    c.a(paramParcel, 7, paramFileConflictEvent.g, false);
    c.a(paramParcel, i);
  }

  public FileConflictEvent a(Parcel paramParcel)
  {
    ArrayList localArrayList = null;
    int i = a.b(paramParcel);
    int j = 0;
    MetadataBundle localMetadataBundle = null;
    ParcelFileDescriptor localParcelFileDescriptor1 = null;
    ParcelFileDescriptor localParcelFileDescriptor2 = null;
    String str = null;
    DriveId localDriveId = null;
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
        str = a.o(paramParcel, k);
        break;
      case 4:
        localParcelFileDescriptor2 = (ParcelFileDescriptor)a.a(paramParcel, k, ParcelFileDescriptor.CREATOR);
        break;
      case 5:
        localParcelFileDescriptor1 = (ParcelFileDescriptor)a.a(paramParcel, k, ParcelFileDescriptor.CREATOR);
        break;
      case 6:
        localMetadataBundle = (MetadataBundle)a.a(paramParcel, k, MetadataBundle.CREATOR);
        break;
      case 7:
        localArrayList = a.B(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + i, paramParcel);
    return new FileConflictEvent(j, localDriveId, str, localParcelFileDescriptor2, localParcelFileDescriptor1, localMetadataBundle, localArrayList);
  }

  public FileConflictEvent[] a(int paramInt)
  {
    return new FileConflictEvent[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.events.b
 * JD-Core Version:    0.6.0
 */