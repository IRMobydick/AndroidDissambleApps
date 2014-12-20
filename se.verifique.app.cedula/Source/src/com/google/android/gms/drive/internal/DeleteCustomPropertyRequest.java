package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

public class DeleteCustomPropertyRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new ae();
  final int a;
  final DriveId b;
  final CustomPropertyKey c;

  DeleteCustomPropertyRequest(int paramInt, DriveId paramDriveId, CustomPropertyKey paramCustomPropertyKey)
  {
    this.a = paramInt;
    this.b = paramDriveId;
    this.c = paramCustomPropertyKey;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ae.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.DeleteCustomPropertyRequest
 * JD-Core Version:    0.6.0
 */