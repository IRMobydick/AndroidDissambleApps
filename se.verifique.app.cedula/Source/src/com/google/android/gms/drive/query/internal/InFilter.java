package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.a;

public class InFilter
  implements SafeParcelable, a
{
  public static final g a = new g();
  final MetadataBundle b;
  final int c;
  private final com.google.android.gms.drive.metadata.g d;

  InFilter(int paramInt, MetadataBundle paramMetadataBundle)
  {
    this.c = paramInt;
    this.b = paramMetadataBundle;
    this.d = ((com.google.android.gms.drive.metadata.g)e.a(paramMetadataBundle));
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    g.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.InFilter
 * JD-Core Version:    0.6.0
 */