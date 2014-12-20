package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.ArrayList;

public class mq
  implements Parcelable.Creator
{
  static void a(jm paramjm, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.b(paramParcel, 1, paramjm.c, false);
    c.a(paramParcel, 1000, paramjm.b);
    c.a(paramParcel, 2, paramjm.a(), false);
    c.a(paramParcel, 3, paramjm.b());
    c.b(paramParcel, 4, paramjm.d, false);
    c.a(paramParcel, 5, paramjm.c(), false);
    c.a(paramParcel, 6, paramjm.e, false);
    c.a(paramParcel, i);
  }

  public jm a(Parcel paramParcel)
  {
    boolean bool = false;
    ArrayList localArrayList1 = null;
    int i = a.b(paramParcel);
    String str1 = null;
    ArrayList localArrayList2 = null;
    String str2 = null;
    ArrayList localArrayList3 = null;
    int j = 0;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.a(paramParcel);
      switch (a.a(k))
      {
      default:
        a.b(paramParcel, k);
        break;
      case 1:
        localArrayList3 = a.c(paramParcel, k, js.bw);
        break;
      case 1000:
        j = a.g(paramParcel, k);
        break;
      case 2:
        str2 = a.o(paramParcel, k);
        break;
      case 3:
        bool = a.c(paramParcel, k);
        break;
      case 4:
        localArrayList2 = a.c(paramParcel, k, jw.d);
        break;
      case 5:
        str1 = a.o(paramParcel, k);
        break;
      case 6:
        localArrayList1 = a.B(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new jm(j, localArrayList3, str2, bool, localArrayList2, str1, localArrayList1);
  }

  public jm[] a(int paramInt)
  {
    return new jm[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.mq
 * JD-Core Version:    0.6.0
 */