package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.List;

public class SetResourceParentsRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new t();
  final int a;
  final DriveId b;
  final List c;

  SetResourceParentsRequest(int paramInt, DriveId paramDriveId, List paramList)
  {
    this.a = paramInt;
    this.b = paramDriveId;
    this.c = paramList;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    t.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.SetResourceParentsRequest
 * JD-Core Version:    0.6.0
 */