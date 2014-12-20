package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.drive.DriveId;

public class b
  implements Parcelable.Creator
{
  static void a(ListParentsRequest paramListParentsRequest, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramListParentsRequest.a);
    c.a(paramParcel, 2, paramListParentsRequest.b, paramInt, false);
    c.a(paramParcel, i);
  }

  public ListParentsRequest a(Parcel paramParcel)
  {
    int i = a.b(paramParcel);
    int j = 0;
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
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + i, paramParcel);
    return new ListParentsRequest(j, localDriveId);
  }

  public ListParentsRequest[] a(int paramInt)
  {
    return new ListParentsRequest[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.b
 * JD-Core Version:    0.6.0
 */