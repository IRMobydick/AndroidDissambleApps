package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public final class ChangeEvent
  implements SafeParcelable, ResourceEvent
{
  public static final Parcelable.Creator CREATOR = new a();
  final int a;
  final DriveId b;
  final int c;

  ChangeEvent(int paramInt1, DriveId paramDriveId, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramDriveId;
    this.c = paramInt2;
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.b;
    arrayOfObject[1] = Integer.valueOf(this.c);
    return String.format("ChangeEvent [id=%s,changeFlags=%x]", arrayOfObject);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.events.ChangeEvent
 * JD-Core Version:    0.6.0
 */