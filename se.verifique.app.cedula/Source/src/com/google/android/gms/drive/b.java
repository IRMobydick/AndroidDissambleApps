package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;

public class b
  implements Parcelable.Creator
{
  static void a(DriveId paramDriveId, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramDriveId.a);
    c.a(paramParcel, 2, paramDriveId.b, false);
    c.a(paramParcel, 3, paramDriveId.c);
    c.a(paramParcel, 4, paramDriveId.d);
    c.a(paramParcel, i);
  }

  public DriveId a(Parcel paramParcel)
  {
    long l1 = 0L;
    int i = a.b(paramParcel);
    int j = 0;
    String str = null;
    long l2 = l1;
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
        l2 = a.i(paramParcel, k);
        break;
      case 4:
        l1 = a.i(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + i, paramParcel);
    return new DriveId(j, str, l2, l1);
  }

  public DriveId[] a(int paramInt)
  {
    return new DriveId[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.b
 * JD-Core Version:    0.6.0
 */