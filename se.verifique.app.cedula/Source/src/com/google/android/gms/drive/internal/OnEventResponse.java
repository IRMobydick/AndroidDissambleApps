package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.FileConflictEvent;

public class OnEventResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new h();
  final int a;
  final int b;
  final ChangeEvent c;
  final FileConflictEvent d;

  OnEventResponse(int paramInt1, int paramInt2, ChangeEvent paramChangeEvent, FileConflictEvent paramFileConflictEvent)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramChangeEvent;
    this.d = paramFileConflictEvent;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    h.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.OnEventResponse
 * JD-Core Version:    0.6.0
 */