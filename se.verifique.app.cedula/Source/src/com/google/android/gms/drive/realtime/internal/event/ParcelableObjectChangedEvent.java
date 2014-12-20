package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ParcelableObjectChangedEvent
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new c();
  final int a;
  final String b;
  final String c;
  final boolean d;
  final String e;
  final String f;
  final int g;
  final int h;

  ParcelableObjectChangedEvent(int paramInt1, String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, int paramInt2, int paramInt3)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramBoolean;
    this.e = paramString3;
    this.f = paramString4;
    this.a = paramInt1;
    this.g = paramInt2;
    this.h = paramInt3;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.event.ParcelableObjectChangedEvent
 * JD-Core Version:    0.6.0
 */