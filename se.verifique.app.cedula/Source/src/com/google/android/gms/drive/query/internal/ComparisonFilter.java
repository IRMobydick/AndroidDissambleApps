package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class ComparisonFilter
  implements SafeParcelable, com.google.android.gms.drive.query.a
{
  public static final a a = new a();
  final Operator b;
  final MetadataBundle c;
  final int d;
  final com.google.android.gms.drive.metadata.a e;

  ComparisonFilter(int paramInt, Operator paramOperator, MetadataBundle paramMetadataBundle)
  {
    this.d = paramInt;
    this.b = paramOperator;
    this.c = paramMetadataBundle;
    this.e = e.a(paramMetadataBundle);
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.ComparisonFilter
 * JD-Core Version:    0.6.0
 */