package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.ArrayList;

public class x
  implements Parcelable.Creator
{
  static void a(CheckResourceIdsExistRequest paramCheckResourceIdsExistRequest, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramCheckResourceIdsExistRequest.a());
    c.a(paramParcel, 2, paramCheckResourceIdsExistRequest.b(), false);
    c.a(paramParcel, i);
  }

  public CheckResourceIdsExistRequest a(Parcel paramParcel)
  {
    int i = a.b(paramParcel);
    int j = 0;
    ArrayList localArrayList = null;
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
        localArrayList = a.B(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new CheckResourceIdsExistRequest(j, localArrayList);
  }

  public CheckResourceIdsExistRequest[] a(int paramInt)
  {
    return new CheckResourceIdsExistRequest[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.x
 * JD-Core Version:    0.6.0
 */