package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.drive.DriveId;

public class q
  implements Parcelable.Creator
{
  static void a(OpenFileIntentSenderRequest paramOpenFileIntentSenderRequest, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramOpenFileIntentSenderRequest.a);
    c.a(paramParcel, 2, paramOpenFileIntentSenderRequest.b, false);
    c.a(paramParcel, 3, paramOpenFileIntentSenderRequest.c, false);
    c.a(paramParcel, 4, paramOpenFileIntentSenderRequest.d, paramInt, false);
    c.a(paramParcel, i);
  }

  public OpenFileIntentSenderRequest a(Parcel paramParcel)
  {
    DriveId localDriveId = null;
    int i = a.b(paramParcel);
    int j = 0;
    String[] arrayOfString = null;
    String str = null;
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
        str = a.o(paramParcel, k);
        break;
      case 3:
        arrayOfString = a.A(paramParcel, k);
        break;
      case 4:
        localDriveId = (DriveId)a.a(paramParcel, k, DriveId.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new OpenFileIntentSenderRequest(j, str, arrayOfString, localDriveId);
  }

  public OpenFileIntentSenderRequest[] a(int paramInt)
  {
    return new OpenFileIntentSenderRequest[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.q
 * JD-Core Version:    0.6.0
 */