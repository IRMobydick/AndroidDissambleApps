package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ParcelableEventList
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new b();
  final int a;
  final ParcelableEvent[] b;
  final DataHolder c;
  final boolean d;
  final ParcelableObjectChangedEvent[] e;

  ParcelableEventList(int paramInt, ParcelableEvent[] paramArrayOfParcelableEvent, DataHolder paramDataHolder, boolean paramBoolean, ParcelableObjectChangedEvent[] paramArrayOfParcelableObjectChangedEvent)
  {
    this.a = paramInt;
    this.b = paramArrayOfParcelableEvent;
    this.c = paramDataHolder;
    this.d = paramBoolean;
    this.e = paramArrayOfParcelableObjectChangedEvent;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.event.ParcelableEventList
 * JD-Core Version:    0.6.0
 */