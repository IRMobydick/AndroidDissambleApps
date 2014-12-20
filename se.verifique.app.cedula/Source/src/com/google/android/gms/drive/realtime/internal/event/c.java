package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c
  implements Parcelable.Creator
{
  static void a(ParcelableObjectChangedEvent paramParcelableObjectChangedEvent, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.c.a(paramParcel);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 1, paramParcelableObjectChangedEvent.a);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 2, paramParcelableObjectChangedEvent.b, false);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 3, paramParcelableObjectChangedEvent.c, false);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 4, paramParcelableObjectChangedEvent.d);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 5, paramParcelableObjectChangedEvent.e, false);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 6, paramParcelableObjectChangedEvent.f, false);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 7, paramParcelableObjectChangedEvent.g);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 8, paramParcelableObjectChangedEvent.h);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, i);
  }

  public ParcelableObjectChangedEvent a(Parcel paramParcel)
  {
    String str1 = null;
    int i = 0;
    int j = a.b(paramParcel);
    int k = 0;
    String str2 = null;
    boolean bool = false;
    String str3 = null;
    String str4 = null;
    int m = 0;
    while (paramParcel.dataPosition() < j)
    {
      int n = a.a(paramParcel);
      switch (a.a(n))
      {
      default:
        a.b(paramParcel, n);
        break;
      case 1:
        m = a.g(paramParcel, n);
        break;
      case 2:
        str4 = a.o(paramParcel, n);
        break;
      case 3:
        str3 = a.o(paramParcel, n);
        break;
      case 4:
        bool = a.c(paramParcel, n);
        break;
      case 5:
        str2 = a.o(paramParcel, n);
        break;
      case 6:
        str1 = a.o(paramParcel, n);
        break;
      case 7:
        k = a.g(paramParcel, n);
        break;
      case 8:
        i = a.g(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new b("Overread allowed size end=" + j, paramParcel);
    return new ParcelableObjectChangedEvent(m, str4, str3, bool, str2, str1, k, i);
  }

  public ParcelableObjectChangedEvent[] a(int paramInt)
  {
    return new ParcelableObjectChangedEvent[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.event.c
 * JD-Core Version:    0.6.0
 */