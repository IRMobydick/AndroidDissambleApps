package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.drive.DriveId;

public class s
  implements Parcelable.Creator
{
  static void a(RemoveEventListenerRequest paramRemoveEventListenerRequest, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramRemoveEventListenerRequest.a);
    c.a(paramParcel, 2, paramRemoveEventListenerRequest.b, paramInt, false);
    c.a(paramParcel, 3, paramRemoveEventListenerRequest.c);
    c.a(paramParcel, i);
  }

  public RemoveEventListenerRequest a(Parcel paramParcel)
  {
    int i = 0;
    int j = a.b(paramParcel);
    Object localObject1 = null;
    int k = 0;
    if (paramParcel.dataPosition() < j)
    {
      int m = a.a(paramParcel);
      int n;
      Object localObject2;
      int i1;
      switch (a.a(m))
      {
      default:
        a.b(paramParcel, m);
        n = i;
        localObject2 = localObject1;
        i1 = k;
      case 1:
      case 2:
      case 3:
      }
      while (true)
      {
        k = i1;
        localObject1 = localObject2;
        i = n;
        break;
        int i2 = a.g(paramParcel, m);
        int i3 = i;
        localObject2 = localObject1;
        i1 = i2;
        n = i3;
        continue;
        DriveId localDriveId = (DriveId)a.a(paramParcel, m, DriveId.CREATOR);
        i1 = k;
        n = i;
        localObject2 = localDriveId;
        continue;
        n = a.g(paramParcel, m);
        localObject2 = localObject1;
        i1 = k;
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new b("Overread allowed size end=" + j, paramParcel);
    return new RemoveEventListenerRequest(k, localObject1, i);
  }

  public RemoveEventListenerRequest[] a(int paramInt)
  {
    return new RemoveEventListenerRequest[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.s
 * JD-Core Version:    0.6.0
 */