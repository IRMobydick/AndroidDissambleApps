package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class FieldOnlyFilter
  implements SafeParcelable, com.google.android.gms.drive.query.a
{
  public static final Parcelable.Creator CREATOR = new b();
  final MetadataBundle a;
  final int b;
  private final com.google.android.gms.drive.metadata.a c;

  FieldOnlyFilter(int paramInt, MetadataBundle paramMetadataBundle)
  {
    this.b = paramInt;
    this.a = paramMetadataBundle;
    this.c = e.a(paramMetadataBundle);
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.FieldOnlyFilter
 * JD-Core Version:    0.6.0
 */