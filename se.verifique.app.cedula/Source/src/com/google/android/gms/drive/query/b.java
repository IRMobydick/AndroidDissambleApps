package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.drive.query.internal.LogicalFilter;

public class b
  implements Parcelable.Creator
{
  static void a(Query paramQuery, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1000, paramQuery.d);
    c.a(paramParcel, 1, paramQuery.a, paramInt, false);
    c.a(paramParcel, 3, paramQuery.b, false);
    c.a(paramParcel, 4, paramQuery.c, paramInt, false);
    c.a(paramParcel, i);
  }

  public Query a(Parcel paramParcel)
  {
    Object localObject1 = null;
    int i = a.b(paramParcel);
    int j = 0;
    Object localObject2 = null;
    Object localObject3 = null;
    if (paramParcel.dataPosition() < i)
    {
      int k = a.a(paramParcel);
      Object localObject4;
      Object localObject5;
      Object localObject6;
      int m;
      switch (a.a(k))
      {
      default:
        a.b(paramParcel, k);
        localObject4 = localObject1;
        localObject5 = localObject2;
        localObject6 = localObject3;
        m = j;
      case 1000:
      case 1:
      case 3:
      case 4:
      }
      while (true)
      {
        j = m;
        localObject3 = localObject6;
        localObject2 = localObject5;
        localObject1 = localObject4;
        break;
        int n = a.g(paramParcel, k);
        Object localObject9 = localObject1;
        localObject5 = localObject2;
        localObject6 = localObject3;
        m = n;
        localObject4 = localObject9;
        continue;
        LogicalFilter localLogicalFilter = (LogicalFilter)a.a(paramParcel, k, LogicalFilter.CREATOR);
        m = j;
        Object localObject8 = localObject2;
        localObject6 = localLogicalFilter;
        localObject4 = localObject1;
        localObject5 = localObject8;
        continue;
        String str = a.o(paramParcel, k);
        localObject6 = localObject3;
        m = j;
        Object localObject7 = localObject1;
        localObject5 = str;
        localObject4 = localObject7;
        continue;
        localObject4 = (SortOrder)a.a(paramParcel, k, SortOrder.CREATOR);
        localObject5 = localObject2;
        localObject6 = localObject3;
        m = j;
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + i, paramParcel);
    return (Query)new Query(j, localObject3, localObject2, localObject1);
  }

  public Query[] a(int paramInt)
  {
    return new Query[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.b
 * JD-Core Version:    0.6.0
 */