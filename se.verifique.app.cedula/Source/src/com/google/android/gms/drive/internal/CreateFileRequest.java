package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.kx;

public class CreateFileRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new ac();
  final int a;
  final DriveId b;
  final MetadataBundle c;
  final Contents d;
  final Integer e;
  final boolean f;
  final String g;

  CreateFileRequest(int paramInt, DriveId paramDriveId, MetadataBundle paramMetadataBundle, Contents paramContents, Integer paramInteger, boolean paramBoolean, String paramString)
  {
    this.a = paramInt;
    this.b = ((DriveId)kx.a(paramDriveId));
    this.c = ((MetadataBundle)kx.a(paramMetadataBundle));
    if ((paramInteger == null) || (paramInteger.intValue() == 0));
    for (this.d = ((Contents)kx.a(paramContents)); ; this.d = null)
    {
      this.e = paramInteger;
      this.f = paramBoolean;
      this.g = paramString;
      return;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ac.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.CreateFileRequest
 * JD-Core Version:    0.6.0
 */