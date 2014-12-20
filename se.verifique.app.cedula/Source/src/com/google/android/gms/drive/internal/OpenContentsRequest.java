package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class OpenContentsRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new p();
  final int a;
  final DriveId b;
  final int c;

  OpenContentsRequest(int paramInt1, DriveId paramDriveId, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramDriveId;
    this.c = paramInt2;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    p.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.OpenContentsRequest
 * JD-Core Version:    0.6.0
 */