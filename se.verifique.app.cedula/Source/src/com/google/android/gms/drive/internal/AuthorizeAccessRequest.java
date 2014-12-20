package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class AuthorizeAccessRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new w();
  final int a;
  final long b;
  final DriveId c;

  AuthorizeAccessRequest(int paramInt, long paramLong, DriveId paramDriveId)
  {
    this.a = paramInt;
    this.b = paramLong;
    this.c = paramDriveId;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    w.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.AuthorizeAccessRequest
 * JD-Core Version:    0.6.0
 */