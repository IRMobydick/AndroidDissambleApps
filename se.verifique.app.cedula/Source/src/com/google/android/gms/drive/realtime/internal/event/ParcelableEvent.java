package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ParcelableEvent
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new a();
  final int a;
  final String b;
  final String c;
  final boolean d;
  final String e;
  final String f;
  final TextInsertedDetails g;
  final TextDeletedDetails h;
  final ValuesAddedDetails i;
  final ValuesRemovedDetails j;
  final ValuesSetDetails k;
  final ValueChangedDetails l;
  final ReferenceShiftedDetails m;

  ParcelableEvent(int paramInt, String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, TextInsertedDetails paramTextInsertedDetails, TextDeletedDetails paramTextDeletedDetails, ValuesAddedDetails paramValuesAddedDetails, ValuesRemovedDetails paramValuesRemovedDetails, ValuesSetDetails paramValuesSetDetails, ValueChangedDetails paramValueChangedDetails, ReferenceShiftedDetails paramReferenceShiftedDetails)
  {
    this.a = paramInt;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramBoolean;
    this.e = paramString3;
    this.f = paramString4;
    this.g = paramTextInsertedDetails;
    this.h = paramTextDeletedDetails;
    this.i = paramValuesAddedDetails;
    this.j = paramValuesRemovedDetails;
    this.k = paramValuesSetDetails;
    this.l = paramValueChangedDetails;
    this.m = paramReferenceShiftedDetails;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.event.ParcelableEvent
 * JD-Core Version:    0.6.0
 */