package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class a
  implements Parcelable.Creator
{
  static void a(Contents paramContents, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramContents.a);
    c.a(paramParcel, 2, paramContents.b, paramInt, false);
    c.a(paramParcel, 3, paramContents.c);
    c.a(paramParcel, 4, paramContents.d);
    c.a(paramParcel, 5, paramContents.e, paramInt, false);
    c.a(paramParcel, 6, paramContents.f, false);
    c.a(paramParcel, 7, paramContents.g);
    c.a(paramParcel, i);
  }

  public Contents a(Parcel paramParcel)
  {
    String str = null;
    boolean bool = false;
    int i = com.google.android.gms.common.internal.safeparcel.a.b(paramParcel);
    DriveId localDriveId = null;
    int j = 0;
    int k = 0;
    ParcelFileDescriptor localParcelFileDescriptor = null;
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
        m = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, n);
        break;
      case 2:
        localParcelFileDescriptor = (ParcelFileDescriptor)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, n, ParcelFileDescriptor.CREATOR);
        break;
      case 3:
        k = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, n);
        break;
      case 4:
        j = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, n);
        break;
      case 5:
        localDriveId = (DriveId)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, n, DriveId.CREATOR);
        break;
      case 6:
        str = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, n);
        break;
      case 7:
        bool = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new Contents(m, localParcelFileDescriptor, k, j, localDriveId, str, bool);
  }

  public Contents[] a(int paramInt)
  {
    return new Contents[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.a
 * JD-Core Version:    0.6.0
 */