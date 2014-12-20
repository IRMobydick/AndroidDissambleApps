package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class d
  implements Parcelable.Creator
{
  static void a(FilterHolder paramFilterHolder, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramFilterHolder.b, paramInt, false);
    c.a(paramParcel, 1000, paramFilterHolder.a);
    c.a(paramParcel, 2, paramFilterHolder.c, paramInt, false);
    c.a(paramParcel, 3, paramFilterHolder.d, paramInt, false);
    c.a(paramParcel, 4, paramFilterHolder.e, paramInt, false);
    c.a(paramParcel, 5, paramFilterHolder.f, paramInt, false);
    c.a(paramParcel, 6, paramFilterHolder.g, paramInt, false);
    c.a(paramParcel, 7, paramFilterHolder.h, paramInt, false);
    c.a(paramParcel, i);
  }

  public FilterHolder a(Parcel paramParcel)
  {
    HasFilter localHasFilter = null;
    int i = a.b(paramParcel);
    int j = 0;
    MatchAllFilter localMatchAllFilter = null;
    InFilter localInFilter = null;
    NotFilter localNotFilter = null;
    LogicalFilter localLogicalFilter = null;
    FieldOnlyFilter localFieldOnlyFilter = null;
    ComparisonFilter localComparisonFilter = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.a(paramParcel);
      switch (a.a(k))
      {
      default:
        a.b(paramParcel, k);
        break;
      case 1:
        localComparisonFilter = (ComparisonFilter)a.a(paramParcel, k, ComparisonFilter.a);
        break;
      case 1000:
        j = a.g(paramParcel, k);
        break;
      case 2:
        localFieldOnlyFilter = (FieldOnlyFilter)a.a(paramParcel, k, FieldOnlyFilter.CREATOR);
        break;
      case 3:
        localLogicalFilter = (LogicalFilter)a.a(paramParcel, k, LogicalFilter.CREATOR);
        break;
      case 4:
        localNotFilter = (NotFilter)a.a(paramParcel, k, NotFilter.CREATOR);
        break;
      case 5:
        localInFilter = (InFilter)a.a(paramParcel, k, InFilter.a);
        break;
      case 6:
        localMatchAllFilter = (MatchAllFilter)a.a(paramParcel, k, MatchAllFilter.a);
        break;
      case 7:
        localHasFilter = (HasFilter)a.a(paramParcel, k, HasFilter.a);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new FilterHolder(j, localComparisonFilter, localFieldOnlyFilter, localLogicalFilter, localNotFilter, localInFilter, localMatchAllFilter, localHasFilter);
  }

  public FilterHolder[] a(int paramInt)
  {
    return new FilterHolder[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.d
 * JD-Core Version:    0.6.0
 */