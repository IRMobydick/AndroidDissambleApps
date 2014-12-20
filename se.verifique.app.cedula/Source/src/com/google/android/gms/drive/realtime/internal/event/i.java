package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class i
  implements Parcelable.Creator
{
  static void a(ValuesRemovedDetails paramValuesRemovedDetails, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramValuesRemovedDetails.a);
    c.a(paramParcel, 2, paramValuesRemovedDetails.b);
    c.a(paramParcel, 3, paramValuesRemovedDetails.c);
    c.a(paramParcel, 4, paramValuesRemovedDetails.d);
    c.a(paramParcel, 5, paramValuesRemovedDetails.e, false);
    c.a(paramParcel, 6, paramValuesRemovedDetails.f);
    c.a(paramParcel, i);
  }

  public ValuesRemovedDetails a(Parcel paramParcel)
  {
    int i = 0;
    int j = a.b(paramParcel);
    String str = null;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    while (paramParcel.dataPosition() < j)
    {
      int i2 = a.a(paramParcel);
      switch (a.a(i2))
      {
      default:
        a.b(paramParcel, i2);
        break;
      case 1:
        i1 = a.g(paramParcel, i2);
        break;
      case 2:
        n = a.g(paramParcel, i2);
        break;
      case 3:
        m = a.g(paramParcel, i2);
        break;
      case 4:
        k = a.g(paramParcel, i2);
        break;
      case 5:
        str = a.o(paramParcel, i2);
        break;
      case 6:
        i = a.g(paramParcel, i2);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new b("Overread allowed size end=" + j, paramParcel);
    return new ValuesRemovedDetails(i1, n, m, k, str, i);
  }

  public ValuesRemovedDetails[] a(int paramInt)
  {
    return new ValuesRemovedDetails[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.event.i
 * JD-Core Version:    0.6.0
 */