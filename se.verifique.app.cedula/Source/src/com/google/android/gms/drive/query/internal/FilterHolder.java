package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.a;

public class FilterHolder
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new d();
  final int a;
  final ComparisonFilter b;
  final FieldOnlyFilter c;
  final LogicalFilter d;
  final NotFilter e;
  final InFilter f;
  final MatchAllFilter g;
  final HasFilter h;
  private final a i;

  FilterHolder(int paramInt, ComparisonFilter paramComparisonFilter, FieldOnlyFilter paramFieldOnlyFilter, LogicalFilter paramLogicalFilter, NotFilter paramNotFilter, InFilter paramInFilter, MatchAllFilter paramMatchAllFilter, HasFilter paramHasFilter)
  {
    this.a = paramInt;
    this.b = paramComparisonFilter;
    this.c = paramFieldOnlyFilter;
    this.d = paramLogicalFilter;
    this.e = paramNotFilter;
    this.f = paramInFilter;
    this.g = paramMatchAllFilter;
    this.h = paramHasFilter;
    if (this.b != null)
      this.i = this.b;
    while (true)
    {
      return;
      if (this.c != null)
      {
        this.i = this.c;
        continue;
      }
      if (this.d != null)
      {
        this.i = this.d;
        continue;
      }
      if (this.e != null)
      {
        this.i = this.e;
        continue;
      }
      if (this.f != null)
      {
        this.i = this.f;
        continue;
      }
      if (this.g != null)
      {
        this.i = this.g;
        continue;
      }
      if (this.h == null)
        break;
      this.i = this.h;
    }
    throw new IllegalArgumentException("At least one filter must be set.");
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    d.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.FilterHolder
 * JD-Core Version:    0.6.0
 */