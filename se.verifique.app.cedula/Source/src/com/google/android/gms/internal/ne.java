package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.HashSet;
import java.util.Set;

public class ne
  implements Parcelable.Creator
{
  static void a(ks.b.b paramb, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    Set localSet = paramb.e();
    if (localSet.contains(Integer.valueOf(1)))
      c.a(paramParcel, 1, paramb.f());
    if (localSet.contains(Integer.valueOf(2)))
      c.a(paramParcel, 2, paramb.g());
    if (localSet.contains(Integer.valueOf(3)))
      c.a(paramParcel, 3, paramb.h(), true);
    if (localSet.contains(Integer.valueOf(4)))
      c.a(paramParcel, 4, paramb.i());
    c.a(paramParcel, i);
  }

  public ks.b.b a(Parcel paramParcel)
  {
    int i = 0;
    int j = a.b(paramParcel);
    HashSet localHashSet = new HashSet();
    String str = null;
    int k = 0;
    int m = 0;
    while (paramParcel.dataPosition() < j)
    {
      int n = a.a(paramParcel);
      switch (a.a(n))
      {
      default:
        a.b(paramParcel, n);
        break;
      case 1:
        m = a.g(paramParcel, n);
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2:
        k = a.g(paramParcel, n);
        localHashSet.add(Integer.valueOf(2));
        break;
      case 3:
        str = a.o(paramParcel, n);
        localHashSet.add(Integer.valueOf(3));
        break;
      case 4:
        i = a.g(paramParcel, n);
        localHashSet.add(Integer.valueOf(4));
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new b("Overread allowed size end=" + j, paramParcel);
    return new ks.b.b(localHashSet, m, k, str, i);
  }

  public ks.b.b[] a(int paramInt)
  {
    return new ks.b.b[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ne
 * JD-Core Version:    0.6.0
 */