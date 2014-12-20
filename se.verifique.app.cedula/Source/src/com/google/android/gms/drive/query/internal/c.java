package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c
  implements Parcelable.Creator
{
  static void a(FieldWithSortOrder paramFieldWithSortOrder, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.c.a(paramParcel);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 1000, paramFieldWithSortOrder.d);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 1, paramFieldWithSortOrder.b, false);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 2, paramFieldWithSortOrder.c);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, i);
  }

  public FieldWithSortOrder a(Parcel paramParcel)
  {
    boolean bool = false;
    int i = a.b(paramParcel);
    String str = null;
    int j = 0;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.a(paramParcel);
      switch (a.a(k))
      {
      default:
        a.b(paramParcel, k);
        break;
      case 1000:
        j = a.g(paramParcel, k);
        break;
      case 1:
        str = a.o(paramParcel, k);
        break;
      case 2:
        bool = a.c(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new FieldWithSortOrder(j, str, bool);
  }

  public FieldWithSortOrder[] a(int paramInt)
  {
    return new FieldWithSortOrder[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.c
 * JD-Core Version:    0.6.0
 */