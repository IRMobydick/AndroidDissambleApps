package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class StatusCreator
  implements Parcelable.Creator<Status>
{
  public static final int CONTENT_DESCRIPTION;

  static void a(Status paramStatus, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.c(paramParcel, 1, paramStatus.getStatusCode());
    b.c(paramParcel, 1000, paramStatus.getVersionCode());
    b.a(paramParcel, 2, paramStatus.getStatusMessage(), false);
    b.a(paramParcel, 3, paramStatus.getPendingIntent(), paramInt, false);
    b.H(paramParcel, i);
  }

  public Status createFromParcel(Parcel paramParcel)
  {
    PendingIntent localPendingIntent = null;
    int i = 0;
    int j = a.C(paramParcel);
    String str = null;
    int k = 0;
    while (paramParcel.dataPosition() < j)
    {
      int m = a.B(paramParcel);
      switch (a.aD(m))
      {
      default:
        a.b(paramParcel, m);
        break;
      case 1:
        i = a.g(paramParcel, m);
        break;
      case 1000:
        k = a.g(paramParcel, m);
        break;
      case 2:
        str = a.o(paramParcel, m);
        break;
      case 3:
        localPendingIntent = (PendingIntent)a.a(paramParcel, m, PendingIntent.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    return new Status(k, i, str, localPendingIntent);
  }

  public Status[] newArray(int paramInt)
  {
    return new Status[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.StatusCreator
 * JD-Core Version:    0.6.2
 */