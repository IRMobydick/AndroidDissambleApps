package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class a
  implements Parcelable.Creator
{
  static void a(ParcelableEvent paramParcelableEvent, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramParcelableEvent.a);
    c.a(paramParcel, 2, paramParcelableEvent.b, false);
    c.a(paramParcel, 3, paramParcelableEvent.c, false);
    c.a(paramParcel, 4, paramParcelableEvent.d);
    c.a(paramParcel, 5, paramParcelableEvent.e, false);
    c.a(paramParcel, 6, paramParcelableEvent.f, false);
    c.a(paramParcel, 7, paramParcelableEvent.g, paramInt, false);
    c.a(paramParcel, 8, paramParcelableEvent.h, paramInt, false);
    c.a(paramParcel, 9, paramParcelableEvent.i, paramInt, false);
    c.a(paramParcel, 10, paramParcelableEvent.j, paramInt, false);
    c.a(paramParcel, 11, paramParcelableEvent.k, paramInt, false);
    c.a(paramParcel, 12, paramParcelableEvent.l, paramInt, false);
    c.a(paramParcel, 13, paramParcelableEvent.m, paramInt, false);
    c.a(paramParcel, i);
  }

  public ParcelableEvent a(Parcel paramParcel)
  {
    int i = com.google.android.gms.common.internal.safeparcel.a.b(paramParcel);
    int j = 0;
    String str1 = null;
    String str2 = null;
    boolean bool = false;
    String str3 = null;
    String str4 = null;
    TextInsertedDetails localTextInsertedDetails = null;
    TextDeletedDetails localTextDeletedDetails = null;
    ValuesAddedDetails localValuesAddedDetails = null;
    ValuesRemovedDetails localValuesRemovedDetails = null;
    ValuesSetDetails localValuesSetDetails = null;
    ValueChangedDetails localValueChangedDetails = null;
    ReferenceShiftedDetails localReferenceShiftedDetails = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.a.a(k))
      {
      default:
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
        break;
      case 1:
        j = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
        break;
      case 2:
        str1 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
        break;
      case 3:
        str2 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
        break;
      case 4:
        bool = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, k);
        break;
      case 5:
        str3 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
        break;
      case 6:
        str4 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
        break;
      case 7:
        localTextInsertedDetails = (TextInsertedDetails)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, TextInsertedDetails.CREATOR);
        break;
      case 8:
        localTextDeletedDetails = (TextDeletedDetails)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, TextDeletedDetails.CREATOR);
        break;
      case 9:
        localValuesAddedDetails = (ValuesAddedDetails)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, ValuesAddedDetails.CREATOR);
        break;
      case 10:
        localValuesRemovedDetails = (ValuesRemovedDetails)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, ValuesRemovedDetails.CREATOR);
        break;
      case 11:
        localValuesSetDetails = (ValuesSetDetails)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, ValuesSetDetails.CREATOR);
        break;
      case 12:
        localValueChangedDetails = (ValueChangedDetails)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, ValueChangedDetails.CREATOR);
        break;
      case 13:
        localReferenceShiftedDetails = (ReferenceShiftedDetails)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, ReferenceShiftedDetails.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new ParcelableEvent(j, str1, str2, bool, str3, str4, localTextInsertedDetails, localTextDeletedDetails, localValuesAddedDetails, localValuesRemovedDetails, localValuesSetDetails, localValueChangedDetails, localReferenceShiftedDetails);
  }

  public ParcelableEvent[] a(int paramInt)
  {
    return new ParcelableEvent[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.event.a
 * JD-Core Version:    0.6.0
 */