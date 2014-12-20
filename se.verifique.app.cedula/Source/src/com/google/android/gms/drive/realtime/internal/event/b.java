package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;

public class b
  implements Parcelable.Creator
{
  static void a(ParcelableEventList paramParcelableEventList, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramParcelableEventList.a);
    c.a(paramParcel, 2, paramParcelableEventList.b, paramInt, false);
    c.a(paramParcel, 3, paramParcelableEventList.c, paramInt, false);
    c.a(paramParcel, 4, paramParcelableEventList.d);
    c.a(paramParcel, 5, paramParcelableEventList.e, paramInt, false);
    c.a(paramParcel, i);
  }

  public ParcelableEventList a(Parcel paramParcel)
  {
    boolean bool = false;
    ParcelableObjectChangedEvent[] arrayOfParcelableObjectChangedEvent = null;
    int i = a.b(paramParcel);
    DataHolder localDataHolder = null;
    ParcelableEvent[] arrayOfParcelableEvent = null;
    int j = 0;
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
        arrayOfParcelableEvent = (ParcelableEvent[])a.b(paramParcel, k, ParcelableEvent.CREATOR);
        break;
      case 3:
        localDataHolder = (DataHolder)a.a(paramParcel, k, DataHolder.a);
        break;
      case 4:
        bool = a.c(paramParcel, k);
        break;
      case 5:
        arrayOfParcelableObjectChangedEvent = (ParcelableObjectChangedEvent[])a.b(paramParcel, k, ParcelableObjectChangedEvent.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + i, paramParcel);
    return new ParcelableEventList(j, arrayOfParcelableEvent, localDataHolder, bool, arrayOfParcelableObjectChangedEvent);
  }

  public ParcelableEventList[] a(int paramInt)
  {
    return new ParcelableEventList[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.event.b
 * JD-Core Version:    0.6.0
 */