package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class j
  implements Parcelable.Creator
{
  static void a(ValuesSetDetails paramValuesSetDetails, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramValuesSetDetails.a);
    c.a(paramParcel, 2, paramValuesSetDetails.b);
    c.a(paramParcel, 3, paramValuesSetDetails.c);
    c.a(paramParcel, 4, paramValuesSetDetails.d);
    c.a(paramParcel, i);
  }

  public ValuesSetDetails a(Parcel paramParcel)
  {
    int i = 0;
    int j = a.b(paramParcel);
    int k = 0;
    int m = 0;
    int n = 0;
    while (paramParcel.dataPosition() < j)
    {
      int i1 = a.a(paramParcel);
      switch (a.a(i1))
      {
      default:
        a.b(paramParcel, i1);
        break;
      case 1:
        n = a.g(paramParcel, i1);
        break;
      case 2:
        m = a.g(paramParcel, i1);
        break;
      case 3:
        k = a.g(paramParcel, i1);
        break;
      case 4:
        i = a.g(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new b("Overread allowed size end=" + j, paramParcel);
    return new ValuesSetDetails(n, m, k, i);
  }

  public ValuesSetDetails[] a(int paramInt)
  {
    return new ValuesSetDetails[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.event.j
 * JD-Core Version:    0.6.0
 */