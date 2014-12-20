package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.ArrayList;

public final class FileConflictEvent
  implements SafeParcelable, DriveEvent
{
  public static final Parcelable.Creator CREATOR = new b();
  final int a;
  final DriveId b;
  final String c;
  final ParcelFileDescriptor d;
  final ParcelFileDescriptor e;
  final MetadataBundle f;
  final ArrayList g;
  private boolean h = false;
  private boolean i = false;
  private boolean j = false;

  FileConflictEvent(int paramInt, DriveId paramDriveId, String paramString, ParcelFileDescriptor paramParcelFileDescriptor1, ParcelFileDescriptor paramParcelFileDescriptor2, MetadataBundle paramMetadataBundle, ArrayList paramArrayList)
  {
    this.a = paramInt;
    this.b = paramDriveId;
    this.c = paramString;
    this.d = paramParcelFileDescriptor1;
    this.e = paramParcelFileDescriptor2;
    this.f = paramMetadataBundle;
    this.g = paramArrayList;
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.b;
    return String.format("FileConflictEvent [id=%s]", arrayOfObject);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.events.FileConflictEvent
 * JD-Core Version:    0.6.0
 */