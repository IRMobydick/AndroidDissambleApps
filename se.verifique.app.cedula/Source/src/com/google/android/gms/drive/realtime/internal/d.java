package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class d
  implements Parcelable.Creator
{
  static void a(ParcelableIndexReference paramParcelableIndexReference, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramParcelableIndexReference.a);
    c.a(paramParcel, 2, paramParcelableIndexReference.b, false);
    c.a(paramParcel, 3, paramParcelableIndexReference.c);
    c.a(paramParcel, 4, paramParcelableIndexReference.d);
    c.a(paramParcel, i);
  }

  public ParcelableIndexReference a(Parcel paramParcel)
  {
    boolean bool = false;
    int i = a.b(paramParcel);
    String str = null;
    int j = 0;
    int k = 0;
    while (paramParcel.dataPosition() < i)
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
        str = a.o(paramParcel, m);
        break;
      case 3:
        j = a.g(paramParcel, m);
        break;
      case 4:
        bool = a.c(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new ParcelableIndexReference(k, str, j, bool);
  }

  public ParcelableIndexReference[] a(int paramInt)
  {
    return new ParcelableIndexReference[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.d
 * JD-Core Version:    0.6.0
 */