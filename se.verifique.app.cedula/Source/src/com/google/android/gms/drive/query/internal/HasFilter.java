package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class HasFilter
  implements SafeParcelable, com.google.android.gms.drive.query.a
{
  public static final f a = new f();
  final MetadataBundle b;
  final int c;
  final com.google.android.gms.drive.metadata.a d;

  HasFilter(int paramInt, MetadataBundle paramMetadataBundle)
  {
    this.c = paramInt;
    this.b = paramMetadataBundle;
    this.d = e.a(paramMetadataBundle);
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    f.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.HasFilter
 * JD-Core Version:    0.6.0
 */