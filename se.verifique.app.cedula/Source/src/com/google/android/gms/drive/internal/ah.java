package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class ah
  implements Parcelable.Creator
{
  static void a(GetDriveIdFromUniqueIdentifierRequest paramGetDriveIdFromUniqueIdentifierRequest, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramGetDriveIdFromUniqueIdentifierRequest.a);
    c.a(paramParcel, 2, paramGetDriveIdFromUniqueIdentifierRequest.b, false);
    c.a(paramParcel, 3, paramGetDriveIdFromUniqueIdentifierRequest.c);
    c.a(paramParcel, i);
  }

  public GetDriveIdFromUniqueIdentifierRequest a(Parcel paramParcel)
  {
    boolean bool = false;
    int i = a.b(paramParcel);
    String str = null;
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
        str = a.o(paramParcel, k);
        break;
      case 3:
        bool = a.c(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new GetDriveIdFromUniqueIdentifierRequest(j, str, bool);
  }

  public GetDriveIdFromUniqueIdentifierRequest[] a(int paramInt)
  {
    return new GetDriveIdFromUniqueIdentifierRequest[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.ah
 * JD-Core Version:    0.6.0
 */