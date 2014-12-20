package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.ArrayList;

public class ll
  implements Parcelable.Creator
{
  static void a(ib.a parama, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, parama.b);
    c.a(paramParcel, 2, parama.c, false);
    c.b(paramParcel, 3, parama.d, false);
    c.a(paramParcel, i);
  }

  public ib.a a(Parcel paramParcel)
  {
    ArrayList localArrayList = null;
    int i = a.b(paramParcel);
    int j = 0;
    String str = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.a(paramParcel);
      switch (a.a(k))
      {
      default:
        a.b(paramParcel, k);
        break;
      case 1:
        j = a.g(paramParcel, k);
        break;
      case 2:
        str = a.o(paramParcel, k);
        break;
      case 3:
        localArrayList = a.c(paramParcel, k, ib.b.a);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new ib.a(j, str, localArrayList);
  }

  public ib.a[] a(int paramInt)
  {
    return new ib.a[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ll
 * JD-Core Version:    0.6.0
 */