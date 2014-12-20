package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.kx;

public class CreateFolderRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new ad();
  final int a;
  final DriveId b;
  final MetadataBundle c;

  CreateFolderRequest(int paramInt, DriveId paramDriveId, MetadataBundle paramMetadataBundle)
  {
    this.a = paramInt;
    this.b = ((DriveId)kx.a(paramDriveId));
    this.c = ((MetadataBundle)kx.a(paramMetadataBundle));
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ad.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.CreateFolderRequest
 * JD-Core Version:    0.6.0
 */