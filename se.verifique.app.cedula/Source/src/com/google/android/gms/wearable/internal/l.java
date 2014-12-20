package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.ArrayList;

public class l
  implements Parcelable.Creator
{
  static void a(as paramas, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramas.a);
    c.a(paramParcel, 2, paramas.b);
    c.a(paramParcel, 3, paramas.c);
    c.b(paramParcel, 4, paramas.d, false);
    c.a(paramParcel, i);
  }

  public as a(Parcel paramParcel)
  {
    int i = 0;
    int j = a.b(paramParcel);
    long l = 0L;
    ArrayList localArrayList = null;
    int k = 0;
    while (paramParcel.dataPosition() < j)
    {
      int m = a.a(paramParcel);
      switch (a.a(m))
      {
      default:
        a.b(paramParcel, m);
        break;
      case 1:
        k = a.g(paramParcel, m);
        break;
      case 2:
        i = a.g(paramParcel, m);
        break;
      case 3:
        l = a.i(paramParcel, m);
        break;
      case 4:
        localArrayList = a.c(paramParcel, m, ak.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new b("Overread allowed size end=" + j, paramParcel);
    return new as(k, i, l, localArrayList);
  }

  public as[] a(int paramInt)
  {
    return new as[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.l
 * JD-Core Version:    0.6.0
 */