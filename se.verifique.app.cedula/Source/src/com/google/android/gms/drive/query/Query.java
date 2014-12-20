package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.internal.LogicalFilter;

public class Query
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new b();
  final LogicalFilter a;
  final String b;
  final SortOrder c;
  final int d;

  Query(int paramInt, LogicalFilter paramLogicalFilter, String paramString, SortOrder paramSortOrder)
  {
    this.d = paramInt;
    this.a = paramLogicalFilter;
    this.b = paramString;
    this.c = paramSortOrder;
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
 * Qualified Name:     com.google.android.gms.drive.query.Query
 * JD-Core Version:    0.6.0
 */