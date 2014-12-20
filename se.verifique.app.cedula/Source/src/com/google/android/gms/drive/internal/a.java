package com.google.android.gms.drive.internal;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.drive.DriveId;

public class a
  implements Parcelable.Creator
{
  static void a(AddEventListenerRequest paramAddEventListenerRequest, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramAddEventListenerRequest.a);
    c.a(paramParcel, 2, paramAddEventListenerRequest.b, paramInt, false);
    c.a(paramParcel, 3, paramAddEventListenerRequest.c);
    c.a(paramParcel, 4, paramAddEventListenerRequest.d, paramInt, false);
    c.a(paramParcel, i);
  }

  public AddEventListenerRequest a(Parcel paramParcel)
  {
    Object localObject1 = null;
    int i = 0;
    int j = com.google.android.gms.common.internal.safeparcel.a.b(paramParcel);
    Object localObject2 = null;
    int k = 0;
    if (paramParcel.dataPosition() < j)
    {
      int m = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel);
      Object localObject3;
      int n;
      Object localObject4;
      int i1;
      switch (com.google.android.gms.common.internal.safeparcel.a.a(m))
      {
      default:
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, m);
        localObject3 = localObject1;
        n = i;
        localObject4 = localObject2;
        i1 = k;
      case 1:
      case 2:
      case 3:
      case 4:
      }
      while (true)
      {
        k = i1;
        localObject2 = localObject4;
        i = n;
        localObject1 = localObject3;
        break;
        int i4 = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, m);
        Object localObject6 = localObject1;
        n = i;
        localObject4 = localObject2;
        i1 = i4;
        localObject3 = localObject6;
        continue;
        DriveId localDriveId = (DriveId)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, m, DriveId.CREATOR);
        i1 = k;
        int i3 = i;
        localObject4 = localDriveId;
        localObject3 = localObject1;
        n = i3;
        continue;
        int i2 = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, m);
        localObject4 = localObject2;
        i1 = k;
        Object localObject5 = localObject1;
        n = i2;
        localObject3 = localObject5;
        continue;
        localObject3 = (PendingIntent)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, m, PendingIntent.CREATOR);
        n = i;
        localObject4 = localObject2;
        i1 = k;
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new b("Overread allowed size end=" + j, paramParcel);
    return (AddEventListenerRequest)new AddEventListenerRequest(k, localObject2, i, localObject1);
  }

  public AddEventListenerRequest[] a(int paramInt)
  {
    return new AddEventListenerRequest[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.a
 * JD-Core Version:    0.6.0
 */