package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.drive.DriveId;

public class w
  implements Parcelable.Creator
{
  static void a(AuthorizeAccessRequest paramAuthorizeAccessRequest, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramAuthorizeAccessRequest.a);
    c.a(paramParcel, 2, paramAuthorizeAccessRequest.b);
    c.a(paramParcel, 3, paramAuthorizeAccessRequest.c, paramInt, false);
    c.a(paramParcel, i);
  }

  public AuthorizeAccessRequest a(Parcel paramParcel)
  {
    int i = a.b(paramParcel);
    int j = 0;
    long l = 0L;
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
        l = a.i(paramParcel, k);
        break;
      case 3:
        localDriveId = (DriveId)a.a(paramParcel, k, DriveId.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new AuthorizeAccessRequest(j, l, localDriveId);
  }

  public AuthorizeAccessRequest[] a(int paramInt)
  {
    return new AuthorizeAccessRequest[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.w
 * JD-Core Version:    0.6.0
 */